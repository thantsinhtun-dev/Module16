package com.stone.module16.delegates

import com.stone.module16.data.ProfileVO

interface ProfileDelegate {
    fun onTapProfile(profileId: Int)
    fun onTapProfilePlus()
}