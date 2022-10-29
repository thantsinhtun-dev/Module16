package com.stone.module16.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stone.module16.R
import com.stone.module16.adapters.ProfileAdapter
import com.stone.module16.utils.profileList
import com.stone.module16.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_create_task.*

class CreateTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        setUpRecyclerView()
        setUpListener()
    }

    private fun setUpListener() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setUpRecyclerView() {
        val profileAdapter = ProfileAdapter()
        rvAssignee.adapter = profileAdapter
        rvAssignee.addItemDecoration(OverlapDecoration())
        profileAdapter.setNewData(profileList)
    }
}