package com.fiberstream.splashfiberstream

import java.util.Timer
import java.util.TimerTask

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseFragment
import androidx.core.content.ContextCompat
import android.util.DisplayMetrics
import android.util.Log

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget

/**
 * Loads a grid of cards with movies to browse.
 */
class ShadowFragment : BrowseFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
