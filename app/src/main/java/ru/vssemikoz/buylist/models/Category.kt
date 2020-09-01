package ru.vssemikoz.buylist.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String
) : Serializable
