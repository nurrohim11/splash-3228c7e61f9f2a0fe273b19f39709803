package com.fiberstream.splashfiberstream

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar

class MainActivity : Activity() {

    private lateinit var mMainFragment: MainFragment
    private lateinit var mSpinnerFragment: SpinnerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testError()
    }

    private fun testError() {
        mMainFragment = MainFragment()
        fragmentManager
                .beginTransaction()
                .add(R.id.main_browse_fragment, mMainFragment)
                .commit()

        mSpinnerFragment = SpinnerFragment()
        fragmentManager
                .beginTransaction()
                .add(R.id.main_browse_fragment, mSpinnerFragment)
                .commit()

        val handler = Handler()
        handler.postDelayed({
            fragmentManager
                    .beginTransaction()
                    .remove(mSpinnerFragment)
                    .commit()
            mMainFragment.setErrorContent()
        }, TIMER_DELAY)
    }

    class SpinnerFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val progressBar = ProgressBar(container?.context)
            if (container is FrameLayout) {
                val layoutParams = FrameLayout.LayoutParams(SPINNER_WIDTH, SPINNER_HEIGHT, Gravity.CENTER)
                progressBar.layoutParams = layoutParams
            }
            return progressBar
        }
    }

    companion object {
        private val TIMER_DELAY = 1000L
        private val SPINNER_WIDTH = 100
        private val SPINNER_HEIGHT = 100
    }
}