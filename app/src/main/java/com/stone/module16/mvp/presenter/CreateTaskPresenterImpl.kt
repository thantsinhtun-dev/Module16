package com.stone.module16.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.module16.mvp.view.CreateTaskView

class CreateTaskPresenterImpl:CreateTaskPresenter,ViewModel() {
    var createTaskView : CreateTaskView? = null
    override fun initializeView(view: CreateTaskView) {
        createTaskView = view
    }

    override fun onTapClose() {
        createTaskView?.navigateBack()
    }

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onTapProfile(profileId: Int) {
        createTaskView?.showProfile(profileId)
    }

    override fun onTapProfilePlus() {
        createTaskView?.navigateToCreateTaskScreen()
    }
}