package com.example.bankcollection.ui.web

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.text.TextUtils
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

abstract class CustomWebViewClient : WebViewClient() {
    private val TAG = CustomWebViewClient::class.java.simpleName
    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
        handler.proceed()
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (TextUtils.isEmpty(url)) {
            return false
        }
        Log.d(TAG, "shouldOverrideUrlLoading url : $url")
        val uri = Uri.parse(url)
        var scheme = uri.scheme
        if (!TextUtils.isEmpty(scheme)) {
            scheme = scheme!!.toLowerCase()
            //避免android 9.0 WebView出現Cleartext HTTP traffic to **** not permitted，http一律外開
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && scheme == "http") {
                view.context
                    .startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                return true
            }
            else {
                return false
            }
        }
        return true
    }
}