package com.stone.module16.data

data class TaskVO(
    val currentProgress: String,
    val title: String,
    val commentCount: Int,
    val clipCount: Int,
    val taskCount: Int,
    val taskCategory: String,
    val taskDate : String,
    val profile : Int
)