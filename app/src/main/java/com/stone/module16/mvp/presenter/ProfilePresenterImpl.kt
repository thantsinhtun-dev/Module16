package com.stone.module16.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.module16.mvp.view.ProfileView

class ProfilePresenterImpl : ProfilePresenter, ViewModel() {
    var mProfileView: ProfileView? = null
    override fun initializeView(view: ProfileView) {
        mProfileView = view
    }

    override fun onTapClose() {
        mProfileView?.navigateBack()
    }

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {

    }
}