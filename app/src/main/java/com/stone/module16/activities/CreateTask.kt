package com.stone.module16.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stone.module16.R
import com.stone.module16.adapters.ProfileAdapter
import com.stone.module16.mvp.presenter.CreateTaskPresenter
import com.stone.module16.mvp.presenter.CreateTaskPresenterImpl
import com.stone.module16.mvp.presenter.MainPresenter
import com.stone.module16.mvp.presenter.MainPresenterImpl
import com.stone.module16.mvp.view.CreateTaskView
import com.stone.module16.utils.profileList
import com.stone.module16.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_create_task.*

class CreateTask : AppCompatActivity() ,CreateTaskView{
    lateinit var createTaskPresenter: CreateTaskPresenter
    companion object{
        fun getIntent(context: Context):Intent{
            return Intent(context,CreateTask::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)


        setupPresenter()
        setUpRecyclerView()
        setUpListener()
        createTaskPresenter.onUIReady(this)

    }
    private fun setupPresenter() {
        createTaskPresenter = ViewModelProvider(this)[CreateTaskPresenterImpl::class.java]
        createTaskPresenter.initializeView(this)
    }

    private fun setUpListener() {
        btnBack.setOnClickListener {
            createTaskPresenter.onTapClose()
        }
    }

    private fun setUpRecyclerView() {
        val profileAdapter = ProfileAdapter(createTaskPresenter)
        rvAssignee.adapter = profileAdapter
        rvAssignee.addItemDecoration(OverlapDecoration())
        profileAdapter.setNewData(profileList)
    }

    override fun navigateBack() {
        super.onBackPressed()
    }

    override fun showProfile(profileId: Int) {
        TODO("Not yet implemented")
    }

    override fun navigateToCreateTaskScreen() {
        TODO("Not yet implemented")
    }
}