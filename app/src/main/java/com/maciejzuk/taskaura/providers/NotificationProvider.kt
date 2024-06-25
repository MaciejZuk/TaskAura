package com.maciejzuk.taskaura.providers

import android.content.Context
import androidx.core.app.NotificationCompat
import com.maciejzuk.taskaura.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class NotificationProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "0"
        const val NOTIFICATION_ID = 1
    }

    fun getNotification(numberOfEvents: Int, notificationDetailsText: String) =
        NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText(getContent(numberOfEvents, notificationDetailsText))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    private fun getContent(numberOfEvents: Int, text: String) =
        when (numberOfEvents) {
            0 -> context.getString(R.string.no_boots)
            1 -> "${context.getString(R.string.single_boot)} = $text"
            else -> "${context.getString(R.string.multiple_boot)} = $text"
        }
}