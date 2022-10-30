package com.stone.module16.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.data.ProfileVO
import com.stone.module16.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.view_holder_profile.view.*
import kotlinx.android.synthetic.main.view_holder_profile.view.imgProfile
import kotlinx.android.synthetic.main.view_holder_task.view.*

class ProfileViewHolder(itemView: View, profileDelegate: ProfileDelegate) :
    RecyclerView.ViewHolder(itemView) {
    var mProfile: ProfileVO? = null
    fun bind(profileVO: ProfileVO) {
        mProfile = profileVO
        itemView.imgProfile.setImageResource(profileVO.profileImage)

    }

    init {
        itemView.imgProfile.setOnClickListener {
            mProfile?.let {
                if (it.name == "plus") {
                    profileDelegate.onTapProfilePlus()
                } else profileDelegate.onTapProfile(it.id)
            }

        }

    }
}