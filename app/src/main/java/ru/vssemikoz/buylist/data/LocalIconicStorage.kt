package ru.vssemikoz.buylist.data

import android.content.Context
import android.graphics.drawable.Drawable
import ru.vssemikoz.buylist.R

class LocalIconicStorage: IconicStorage {
    private var STAR_IS_FOLLOWED: Drawable? = null
    private var STAR_IS_UNFOLLOWED: Drawable? = null
    private var STAR_IS_ADD: Drawable? = null
    private var STAR_IS_NOT_ADD: Drawable? = null


    override fun getIsFollowedDrawable(context: Context?): Drawable? {
        if (STAR_IS_FOLLOWED == null) {
            STAR_IS_FOLLOWED = context?.resources?.getDrawable(R.drawable.ic_star_check_24dp, null)
        }
        return STAR_IS_FOLLOWED
    }

    override fun getIsUnfollowedDrawable(context: Context?): Drawable? {
        if (STAR_IS_UNFOLLOWED == null) {
            STAR_IS_UNFOLLOWED = context?.resources?.getDrawable(R.drawable.ic_star_uncheck_24dp, null)
        }
        return STAR_IS_UNFOLLOWED
    }

    override fun getIsAddDrawwble(context: Context?): Drawable? {
        if (STAR_IS_ADD == null) {
            STAR_IS_ADD = context?.resources?.getDrawable(R.drawable.ic_check_choosen_24dp, null)
        }
        return STAR_IS_ADD
    }

    override fun getIsNotAddDrawwble(context: Context?): Drawable? {
        if (STAR_IS_NOT_ADD == null) {
            STAR_IS_NOT_ADD = context?.resources?.getDrawable(R.drawable.ic_check_unchoosen_24dp, null)
        }
        return STAR_IS_NOT_ADD
    }
}
