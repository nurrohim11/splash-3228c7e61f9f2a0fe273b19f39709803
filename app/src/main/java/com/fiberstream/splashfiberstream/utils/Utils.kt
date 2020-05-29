package com.fiberstream.splashfiberstream.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import java.util.*

class Utils{
    fun checkFiberstrem(uri:String?, context:Context): Boolean{
        val pm = context.packageManager
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            return true
        }catch (e: PackageManager.NameNotFoundException){
        }
        return  false
    }

    fun getInstalledAppsPackageNameList(context: Context): List<String>? {
        // Initialize a new intent
        val intent = Intent(Intent.ACTION_MAIN, null)

        // Set intent category
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        // Set intent flags
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED

        // Initialize a new list of resolve info
        val resolveInfoList =
            context.packageManager.queryIntentActivities(intent, 0)

        // Initialize a new list of package name
        val packageNameList: MutableList<String> =
            ArrayList()
        for (resolveInfo in resolveInfoList) {

            // Get the activity info from resolve info
            val activityInfo = resolveInfo.activityInfo

            // Get the package name from activity info's application info
            // Add the package name to the list
            packageNameList.add(activityInfo.applicationInfo.packageName)
        }

        // Return the package name list
        return packageNameList
    }
}