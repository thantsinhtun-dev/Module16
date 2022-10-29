package com.stone.module16.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.R
import com.stone.module16.data.TaskVO
import com.stone.module16.viewholders.TaskViewHolder

class TaskAdapter: RecyclerView.Adapter<TaskViewHolder>() {
    private var taskList : List<TaskVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_task_list,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
       return taskList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(taskData: List<TaskVO>) {
        taskList = taskData
        notifyDataSetChanged()
    }
}