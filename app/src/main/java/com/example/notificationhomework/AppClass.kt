package com.example.notificationhomework

import android.app.Application
import com.onesignal.OneSignal

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()
    }
}