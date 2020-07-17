package com.example.epamcoronavirusmap.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.main.MainActivity
import com.example.epamcoronavirusmap.utils.CustomRotateAnimationListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash_screen.view.*


class SplashScreen : Fragment() {

    lateinit var binding: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflate(R.layout.fragment_splash_screen, container, false)

        startImageAnimation()

        return binding
    }

    private fun startImageAnimation() {
        val rotateAnimator = RotateAnimation(
            0f,
            720f, 1, 0.5f, 1, 0.5f
        )

        rotateAnimator.duration = 1000
        rotateAnimator.fillAfter = true
        rotateAnimator.interpolator = DecelerateInterpolator()
        rotateAnimator.setAnimationListener(object : CustomRotateAnimationListener() {
            override fun onAnimationEnd(animation: Animation?) {
                this@SplashScreen.findNavController().navigate(R.id.newsFragment)
                (activity as MainActivity).bottom_nav.visibility = View.VISIBLE
            }
        })
        binding.imageView.animation = rotateAnimator
        binding.imageView.startAnimation(rotateAnimator)
    }

}
