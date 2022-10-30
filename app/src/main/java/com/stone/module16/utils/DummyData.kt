package com.stone.module16.utils

import com.stone.module16.R
import com.stone.module16.data.ProfileVO
import com.stone.module16.data.TaskVO


const val inProgress = "In Progress"
const val done = "Done"
const val review = "Review"

const val design = "#Design"
const val frontEnd = "#Frontend"
const val backEnd = "#Backend"
const val mobile = "#Mobile"

enum class TaskLine(val background:Int){
    DOTTED(R.drawable.background_dotted),
    WHITE(R.drawable.background_white_dash),
    GRAY(R.drawable.background_black_dash)
}





val profileList = listOf(
    ProfileVO(id = 0, profileImage = R.drawable.avator1, name = "Gamer", position = ""),
    ProfileVO(id = 1, profileImage = R.drawable.avator2, name = "Developer", position = ""),
    ProfileVO(id = 2, profileImage = R.drawable.avator3, name = "Hllo", position = ""),
    ProfileVO(id = 3, profileImage = R.drawable.plus, name = "plus", position = ""),
)


val taskData = listOf(
    TaskVO(currentProgress = inProgress, "Contact Page", 5, 4, 150, design, "24.5", R.drawable.avator1),
    TaskVO(currentProgress = done, "Calculator Pade", 3, 2, 156, design, "24.5",R.drawable.avator2),
    TaskVO(currentProgress = review, "Technical Talk", 6, 9, 160, frontEnd, "24.5",R.drawable.avator3),
    TaskVO(currentProgress = inProgress, "Create Mobile Version", 7, 4, 200, mobile, "24.5",R.drawable.avator4),
    TaskVO(currentProgress = review, "Create IOS Page", 8, 2, 205, mobile, "24.5",R.drawable.avator1),
    TaskVO(currentProgress = done, "Web Page", 3, 7, 300, backEnd, "24.5",R.drawable.avator3),
    TaskVO(currentProgress = inProgress, "Contact Page", 5, 10, 200, mobile, "24.5",R.drawable.avator4),
)