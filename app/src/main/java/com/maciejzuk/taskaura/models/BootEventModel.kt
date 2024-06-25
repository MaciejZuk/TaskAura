package com.maciejzuk.taskaura.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_boot_events")
data class BootEventModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val timestamp: Long
)