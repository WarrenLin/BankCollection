package com.example.bankcollection.ui.web

import android.app.Activity
import android.util.Log
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import io.reactivex.Observable
import io.reactivex.functions.Consumer


class CustomWebChromeClient(activity: Activity): WebChromeClient() {
    private val TAG = CustomWebChromeClient::class.java.simpleName
    private var mConsumer: Consumer<Int>? = null

    override fun onJsAlert(view: WebView, url: String, message: String, result: JsResult): Boolean {
        Log.i(TAG, "onJsAlert: url:$url message:$message")
        return super.onJsAlert(view, url, message, result)
    }

    fun setProgressChangedConsumer(consumer:Consumer<Int>) {
        mConsumer = consumer
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        mConsumer?.let {
            Observable.just(newProgress)
                    .subscribe {
                        mConsumer!!.accept(it)
                    }
        }
    }
}