package com.maciejzuk.taskaura.mainFeature.viewModel

import android.content.Context
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import com.maciejzuk.taskaura.repositories.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val notificationRepository: NotificationRepository
) : ViewModel() {

    fun getNotification() = notificationRepository.getNotification()

}