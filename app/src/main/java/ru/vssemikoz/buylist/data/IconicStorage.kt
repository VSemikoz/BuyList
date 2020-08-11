package ru.vssemikoz.buylist.data

import android.content.Context
import android.graphics.drawable.Drawable

interface IconicStorage {

    fun getIsFollowedDrawable(context: Context?): Drawable?

    fun getIsUnfollowedDrawable(context: Context?): Drawable?

    fun getIsAddDrawwble(context: Context?): Drawable?

    fun getIsNotAddDrawwble(context: Context?): Drawable?
}
