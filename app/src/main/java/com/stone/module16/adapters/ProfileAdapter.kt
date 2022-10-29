package com.stone.module16.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.module16.R
import com.stone.module16.data.ProfileVO
import com.stone.module16.viewholders.ProfileViewHolder

class ProfileAdapter : RecyclerView.Adapter<ProfileViewHolder>() {
    var profileList : List<ProfileVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_profile,parent,false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(profileList[position])
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(profiles : List<ProfileVO>){
        profileList = profiles
        notifyDataSetChanged()
    }

}