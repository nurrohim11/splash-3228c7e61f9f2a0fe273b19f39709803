package com.fiberstream.splashfiberstream

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.core.content.res.ResourcesCompat
import com.fiberstream.splashfiberstream.utils.Utils

class MainFragment : androidx.leanback.app.ErrorFragment() {
    private lateinit var utils: Utils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Selamat datang"
        utils = Utils()
        val installedPackages: List<String>? = utils.getInstalledAppsPackageNameList(activity)
        if (installedPackages != null) {
            if (installedPackages.contains("com.fiberstream.tv")){
                Handler().postDelayed({
                    val launchIntent = activity.packageManager.getLaunchIntentForPackage("com.fiberstream.tv")
                    activity.startActivity(launchIntent)
                }, 200)
            }else{
                Handler().postDelayed({
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.fiberstream.tv")
                        )
                    )
                },3000)
            }
        }

    }

    internal fun setErrorContent() {
        val bg = ResourcesCompat.getDrawable(resources, R.drawable.splash, null)
        backgroundDrawable = bg
    }

}