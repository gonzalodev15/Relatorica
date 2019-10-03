package com.example.relatorica.logic.network

import android.content.Context
import android.net.ConnectivityManager
import android.telecom.ConnectionService
import android.widget.Toast

object Connection {

    fun isOnline(context: Context): Boolean {
        val conMgr = context.getSystemService(ConnectionService.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo

        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable) {
            Toast.makeText(context, "No Internet connection!", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}