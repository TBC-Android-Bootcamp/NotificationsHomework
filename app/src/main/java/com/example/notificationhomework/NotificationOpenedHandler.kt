package com.example.notificationhomework

import android.app.Application
import android.content.Intent
import android.util.Log
import com.onesignal.OSNotificationAction.ActionType
import com.onesignal.OSNotificationOpenResult
import com.onesignal.OneSignal.NotificationOpenedHandler


class NotificationOpenedHandler(private val application: Application) :
    NotificationOpenedHandler {
    override fun notificationOpened(result: OSNotificationOpenResult) {

        val data = result.notification.payload.additionalData
        if (data != null) {
            val myCustomData = data.optString("key", null)
        }

        // React to button pressed
        val actionType = result.action.type
        if (actionType == ActionType.ActionTaken) Log.i(
            "OneSignalExample",
            "Button pressed with id: " + result.action.actionID
        )

        startSecondActivity()
    }

    private fun startSecondActivity() {
        val intent = Intent(application, SecondActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK)
        application.startActivity(intent)
    }

}

/*class NotificationOpenedHandler : OneSignal.NotificationOpenedHandler {
    override fun notificationOpened(openedResult: OSNotificationOpenResult) {
        Log.d("OneSignalExample", "notificationOpened!!!!!!")
        print(openedResult.action)
        print(openedResult.notification)
    }
}*/