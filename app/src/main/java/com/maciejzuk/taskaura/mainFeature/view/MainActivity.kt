package com.maciejzuk.taskaura.mainFeature.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maciejzuk.taskaura.R
import com.maciejzuk.taskaura.mainFeature.viewModel.MainViewModel
import com.maciejzuk.taskaura.providers.NotificationProvider.Companion.NOTIFICATION_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val data = intent.getLongExtra("boot", 0)
        Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
        showNotification()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun showNotification() {
        val notificationBuilder = mainViewModel.getNotification()
        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this@MainActivity, "No permission", Toast.LENGTH_LONG).show()
                return@with
            }
            notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }
}