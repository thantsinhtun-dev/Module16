package com.stone.module16.mvp.presenter

import androidx.lifecycle.LifecycleOwner

interface IBasePresenter {
    fun onUIReady(lifecycleOwner: LifecycleOwner)
}