package com.example.notificationhomework


import android.app.Application
import android.util.Log.d
import com.onesignal.OSNotificationOpenResult
import com.onesignal.OneSignal
import com.onesignal.OneSignal.NotificationOpenedHandler


class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .setNotificationOpenedHandler(NotificationOpenedHandler(this))
            .init()
    }

}
