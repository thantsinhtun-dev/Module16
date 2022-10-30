package com.stone.module16.mvp.presenter

import com.stone.module16.delegates.ProfileDelegate
import com.stone.module16.mvp.view.CreateTaskView
import com.stone.module16.mvp.view.ProfileView

interface CreateTaskPresenter :IBasePresenter,ProfileDelegate{
    fun initializeView(view: CreateTaskView)
    fun onTapClose()
}