package com.stone.module16.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.data.ProfileVO
import kotlinx.android.synthetic.main.view_holder_profile.view.*

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(profileVO: ProfileVO){
        itemView.imgProfile.setImageResource(profileVO.profileImage)
    }
}