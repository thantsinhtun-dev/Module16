package com.stone.module16.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.data.TaskVO
import kotlinx.android.synthetic.main.view_holder_task.view.*
import kotlinx.android.synthetic.main.view_holder_task_list.view.*

class SheetProfileViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    fun bind(taskVO: TaskVO) {
        itemView.lblProgressStatus.text = taskVO.currentProgress
        itemView.lblProgressTitle.text = taskVO.title
        itemView.lblCommentCount.text = taskVO.commentCount.toString()
        itemView.lblClipCount.text = taskVO.clipCount.toString()
        itemView.lblNo.text = "No ${taskVO.taskCount}"
        itemView.imgProfile.setImageResource(taskVO.profile)
    }

}