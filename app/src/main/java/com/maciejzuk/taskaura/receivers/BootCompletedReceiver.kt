package com.maciejzuk.taskaura.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.maciejzuk.taskaura.mainFeature.view.MainActivity


class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        //TODO replace ACTION_BOOT_COMPLETED to BOOT_COMPLETED
        // adb shell am broadcast -a android.intent.action.ACTION_BOOT_COMPLETED -p com.maciejzuk.taskaura
        if (intent.action == "android.intent.action.ACTION_BOOT_COMPLETED") {
            val timestamp = System.currentTimeMillis()/1000
            val mainActivityIntent = Intent(context, MainActivity::class.java)
            mainActivityIntent.putExtra("boot", timestamp)
            mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mainActivityIntent)
        }
    }
}