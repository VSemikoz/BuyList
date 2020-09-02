package ru.vssemikoz.buylist.utils.animations

import android.view.View
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

object AnimationImpl: Animation {

    override fun accentEmptyField(view: View) {
        YoYo.with(Techniques.Flash)
            .duration(500)
            .playOn(view);
    }
}
