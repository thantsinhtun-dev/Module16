package com.stone.module16.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stone.module16.R
import com.stone.module16.adapters.ProfileAdapter
import com.stone.module16.adapters.TaskAdapter
import com.stone.module16.data.ProfileVO
import com.stone.module16.data.TaskVO
import com.stone.module16.fragments.ProfileFragment
import com.stone.module16.mvp.presenter.MainPresenter
import com.stone.module16.mvp.presenter.MainPresenterImpl
import com.stone.module16.mvp.view.MainView
import com.stone.module16.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {
    lateinit var mainPresenter: MainPresenter
    private lateinit var taskAdapter : TaskAdapter
    private lateinit var profileAdapter : ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
        setupRecyclerView()


        mainPresenter.onUIReady(this)

    }
    private fun setupPresenter() {
        mainPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mainPresenter.initializeView(this)
    }
    private fun setupRecyclerView() {

        profileAdapter = ProfileAdapter(mainPresenter)
        rvProfile.adapter = profileAdapter
        rvProfile.addItemDecoration(OverlapDecoration())


        taskAdapter = TaskAdapter()
        rvTaskList.adapter = taskAdapter

    }

    override fun showProfile(profileId: Int) {
        val modalBottomSheet = ProfileFragment(profileId)
        modalBottomSheet.show(supportFragmentManager, "ModalBottomSheet.TAG")
    }

    override fun navigateToCreateTaskScreen() {
        startActivity(CreateTask.getIntent(this))
    }

    override fun showTaskList(tasks: List<TaskVO>) {
        taskAdapter.setNewData(tasks)
    }

    override fun showProfileData(profiles: List<ProfileVO>) {
        profileAdapter.setNewData(profiles)
    }

    override fun showError(errorString: String) {
        Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show()
    }
}