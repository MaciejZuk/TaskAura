package com.maciejzuk.taskaura.repositories

import androidx.core.app.NotificationCompat
import com.maciejzuk.taskaura.providers.NotificationProvider
import javax.inject.Inject

class NotificationRepository @Inject constructor(
    private val notificationProvider: NotificationProvider
) {

    fun getNotification() : NotificationCompat.Builder {

        return getNotificationBuilder(0, "test")
    }

    private fun getNotificationData() {

    }


    private fun getNotificationBuilder(numberOfEvents: Int, notificationDetailsText: String) =
        notificationProvider.getNotification(numberOfEvents, notificationDetailsText)
}
