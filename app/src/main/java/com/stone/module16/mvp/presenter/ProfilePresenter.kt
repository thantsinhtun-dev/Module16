package com.stone.module16.mvp.presenter

import com.stone.module16.mvp.view.ProfileView

interface ProfilePresenter :IBasePresenter{
    fun initializeView(view: ProfileView)
    fun onTapClose()
}