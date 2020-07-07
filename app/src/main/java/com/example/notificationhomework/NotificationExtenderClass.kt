package com.example.notificationhomework

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import android.util.Log.d
import androidx.core.app.NotificationCompat
import com.onesignal.NotificationExtenderService
import com.onesignal.OSNotificationReceivedResult


class NotificationExtenderClass : NotificationExtenderService() {
    override fun onNotificationProcessing(receivedResult: OSNotificationReceivedResult): Boolean {
        d("onNotificationProcesing", "${receivedResult.payload.additionalData}")
        val json = receivedResult.payload.additionalData

        // ხელით გავუწერე თაითლი და დესქრიფშენი რახან არ ვმუშაობდი api-ზე

        val actionId = 1.toString()
        val myDescription = "My Description"
        val title = "My Notification Title"


        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(actionId, name, importance).apply {
                description = descriptionText
            }

            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(applicationContext, SecondActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(applicationContext,11, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val builder = NotificationCompat.Builder(this, actionId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(myDescription)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(1,builder.build())
        return false
    }
}