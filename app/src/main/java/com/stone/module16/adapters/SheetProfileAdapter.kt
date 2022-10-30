package com.stone.module16.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.R
import com.stone.module16.data.TaskVO
import com.stone.module16.viewholders.SheetProfileViewHolder

class SheetProfileAdapter: RecyclerView.Adapter<SheetProfileViewHolder>() {
    var taskList : List<TaskVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SheetProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_task,parent,false)
        return SheetProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: SheetProfileViewHolder, position: Int) {
        if (taskList.isNotEmpty()) {
            holder.bind(taskList[position])
            Log.i("task",taskList[position].title)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(taskList:List<TaskVO>){
        this.taskList = taskList
        notifyDataSetChanged()
    }
}