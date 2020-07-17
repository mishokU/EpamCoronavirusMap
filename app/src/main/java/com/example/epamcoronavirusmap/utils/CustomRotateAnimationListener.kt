package com.example.epamcoronavirusmap.utils

import android.view.animation.Animation

abstract class CustomRotateAnimationListener : Animation.AnimationListener {
    override fun onAnimationRepeat(animation: Animation?) {}
    override fun onAnimationEnd(animation: Animation?) {}
    override fun onAnimationStart(animation: Animation?) {}
}