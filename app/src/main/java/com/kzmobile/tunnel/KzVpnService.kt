package com.kzmobile.tunnel

import android.net.VpnService
import android.content.Intent
import android.os.ParcelFileDescriptor

class KzVpnService : VpnService() {

    private var vpnInterface: ParcelFileDescriptor? = null

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {
        stopVpn()
        return START_NOT_STICKY
    }

    private fun stopVpn() {
        try {
            vpnInterface?.close()
        } catch (_: Exception) {
        }
        vpnInterface = null
        stopSelf()
    }

    override fun onDestroy() {
        stopVpn()
        super.onDestroy()
    }
}
