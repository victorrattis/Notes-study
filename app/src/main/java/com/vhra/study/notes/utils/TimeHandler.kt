package com.vhra.study.notes.utils

import android.os.Handler


class TimeHandler {
    fun callMe(time: Long, callback: () -> Unit) {
        Handler().postDelayed({
            callback()
        }, time)
    }
}
