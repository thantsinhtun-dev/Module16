package com.stone.module16.mvp.presenter

import com.stone.module16.delegates.ProfileDelegate
import com.stone.module16.mvp.view.MainView

interface MainPresenter:IBasePresenter,ProfileDelegate {
    fun initializeView(view: MainView){

    }
}