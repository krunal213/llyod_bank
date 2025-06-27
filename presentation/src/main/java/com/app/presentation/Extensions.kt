package com.app.presentation

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.app.common.exception.NoConnectivityException

fun Application.isNetworkAvailable(): Boolean {
    val cm =
        applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val isNetworkAvailable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = cm.activeNetwork ?: return false
        val capabilities = cm.getNetworkCapabilities(network) ?: return false
        capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    } else {
        cm.activeNetworkInfo?.isConnectedOrConnecting == true
    }
    if (isNetworkAvailable) return true else throw NoConnectivityException()
}