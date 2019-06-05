package com.faraji.coinanimation

import android.animation.Animator
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.View

/**
 * Created by Omid Faraji on 05/06/2019.
 */

class TargetAnimationHelper(val view: View, val target: View) {
    var repeat: Int = 1
    var count = 0
    private val listener by lazy { Listener() }
    fun start() {
        val x = target.x - view.x - 50
        val y = target.y - view.y - 50
        animate(x, y)
    }

    private fun animate(x: Float, y: Float) {
        view.animate()
            .translationX(x)
            .translationY(y)
            .alpha(.01f)
            .apply { duration = 200 }
            .apply { interpolator = FastOutSlowInInterpolator() }
            .setListener(listener)
            .start()
    }

    inner class Listener : AnimatorAdapter() {
        override fun onAnimationStart(animation: Animator?) {
            view.visibility = View.VISIBLE
        }
        override fun onAnimationEnd(animation: Animator?) {
            if (count >= repeat)
                return
            view.translationX = 0f
            view.translationY = 0f
            view.alpha = 1f
            view.visibility = View.GONE
            count++
            start()
        }
    }
}