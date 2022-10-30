package com.stone.module16.mvp.view

import com.stone.module16.data.ProfileVO
import com.stone.module16.data.TaskVO

interface MainView :BaseView{
    fun showProfile(profileId: Int)
    fun navigateToCreateTaskScreen()
    fun showTaskList(tasks:List<TaskVO>)
    fun showProfileData(profiles:List<ProfileVO>)
}