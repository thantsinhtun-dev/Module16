package com.stone.module16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stone.module16.adapters.ProfileAdapter
import com.stone.module16.adapters.TaskAdapter
import com.stone.module16.utils.profileList
import com.stone.module16.utils.taskData
import com.stone.module16.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }
    private fun setupRecyclerView() {

        val profileAdapter = ProfileAdapter()
        rvProfile.adapter = profileAdapter
        rvProfile.addItemDecoration(OverlapDecoration())
        profileAdapter.setNewData(profileList)

        val taskAdapter = TaskAdapter()
        rvTaskList.adapter = taskAdapter
        taskAdapter.setNewData(taskData)

    }
}