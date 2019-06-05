package com.faraji.coinanimation

import android.animation.Animator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivCircle.setOnClickListener {
            val number = (Math.random() * 50).toInt()
            animation(number)
        }
    }

    private fun animation(number: Int) {
        TargetAnimationHelper(ivCoin, vTarget).apply { repeat = number }.start()
        animateNumber(number)
    }

    private fun animateNumber(number: Int) {
        tvNumber.text = number.toString()
        tvNumber.visibility = View.VISIBLE
        tvNumber.animate()
            .scaleX(3f)
            .scaleY(3f)
            .alpha(0f)
            .apply { duration = 4000 }
            .setListener(object : AnimatorAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    tvNumber.scaleX = 1f
                    tvNumber.scaleY = 1f
                    tvNumber.alpha = 1f
                    tvNumber.visibility = View.GONE
                }

            })
            .start()
    }

}
