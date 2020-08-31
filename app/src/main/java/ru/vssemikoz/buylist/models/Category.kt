package ru.vssemikoz.buylist.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String
)
