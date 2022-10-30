package com.stone.module16.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.module16.data.ProfileVO
import com.stone.module16.mvp.view.MainView
import com.stone.module16.utils.profileList
import com.stone.module16.utils.taskData

class MainPresenterImpl :MainPresenter,ViewModel(){
    var mView : MainView? = null
    override fun initializeView(view: MainView) {
        mView = view
    }

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        mView?.showTaskList(taskData)
        mView?.showProfileData(profileList)
    }

    override fun onTapProfile(profileId: Int) {
        mView?.showProfile(profileId)

    }

    override fun onTapProfilePlus() {
        mView?.navigateToCreateTaskScreen()
    }
}