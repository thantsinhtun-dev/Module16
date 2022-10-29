package com.stone.module16.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.R
import com.stone.module16.data.TaskVO
import com.stone.module16.utils.done
import com.stone.module16.utils.inProgress
import com.stone.module16.utils.review
import kotlinx.android.synthetic.main.view_holder_task.view.*
import kotlinx.android.synthetic.main.view_holder_task_list.view.*

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(taskVO: TaskVO) {


        when(taskVO.currentProgress){
            done -> chaneTitleColor(R.color.color_purple)
            inProgress -> chaneTitleColor(R.color.color_accent_orange)
            review -> chaneTitleColor(R.color.color_dark_grey)
        }



        itemView.lblDate.text = taskVO.taskDate
        itemView.llTask.lblProgressStatus.text = taskVO.currentProgress
        itemView.llTask.lblProgressTitle.text = taskVO.title
        itemView.llTask.lblProgressTime.text = taskVO.taskCategory
        itemView.llTask.lblCommentCount.text = taskVO.commentCount.toString()
        itemView.llTask.lblClipCount.text = taskVO.clipCount.toString()
        itemView.llTask.lblNo.text = taskVO.taskCount.toString()
        itemView.llTask.imgProfile.setImageResource(taskVO.profile)
    }
    private fun chaneTitleColor(color:Int){
        itemView.llTask.lblProgressStatus.setTextColor(itemView.context.getColor(color))
        itemView.imgCircleIndicator.setBackgroundColor(itemView.context.getColor(color))
    }
}