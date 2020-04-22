package com.example.bankcollection.ui.web

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.bankcollection.R
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    private val TAG = WebViewActivity::class.java.simpleName

    companion object {
        fun start(context: Context, url: String, title: String?) {
            val starter = Intent(context, WebViewActivity::class.java)
            starter.putExtra("url", url)
            starter.putExtra("title", title)
            context.startActivity(starter)
        }
    }

    private lateinit var mProgressBar: ProgressBar
    private lateinit var mWebView: WebView

    private var urlString: String = ""
    private var titleString: String = ""
    private val mCustomWebChromeClient = CustomWebChromeClient(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        title = ""
        setSupportActionBar(actionbar)
        mProgressBar = findViewById(R.id.pb_hori_loading)
        mProgressBar.progressDrawable.setColorFilter(Color.rgb(50, 150, 251), PorterDuff.Mode.SRC_IN)
        mWebView = findViewById(R.id.wv_fragment)

        fl_jump.run {
            setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse(urlString)
                startActivity(intent)
            }
        }

        fl_refresh.run {
            setOnClickListener {
                mWebView.reload()
            }
        }

        fl_close.run {
            setOnClickListener{
                finish()
            }
        }
        urlString = intent.getStringExtra("url")
        titleString = intent.getStringExtra("title")
        initWebView()
        actionbar_title_no_arrow.text = titleString
        mWebView.loadUrl(urlString)
    }

    @SuppressLint("SetJavaScriptEnabled", "AddJavascriptInterface")
    fun initWebView() {
        val websettings: WebSettings = mWebView.settings
        websettings.run {
            builtInZoomControls = true
            displayZoomControls = false

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
            javaScriptEnabled = true
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
        }
        disableWebViewAcceleration(mWebView)

        mWebView.webViewClient = object: CustomWebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d(TAG, "onPageStarted")
                mProgressBar.visibility = ProgressBar.VISIBLE
            }

            override fun onPageFinished(webView: WebView?, url: String) {
                super.onPageFinished(webView, url)
                Log.d(TAG, "onPageFinished:$url")
                //如果title為空，帶入title
                if (titleString.isEmpty()) {
                    val sTitle = webView!!.title
                    if (!TextUtils.isEmpty(sTitle)) {
                        actionbar_title_no_arrow.text = sTitle
                    }
                }
                checkNavigationBtnState()
            }
        }

        mWebView.webChromeClient = mCustomWebChromeClient

        mCustomWebChromeClient.setProgressChangedConsumer(Consumer<Int> {
            if (it == 100) {
                mProgressBar.visibility = ProgressBar.GONE
                return@Consumer
            }
            mProgressBar.progress = it
        })

    }

    fun checkNavigationBtnState() {
        Log.d(TAG, "checkNavigationButtonState canGoBack : " + mWebView.canGoBack())
        Log.d(TAG, "checkNavigationButtonState canGoForward : " + mWebView.canGoForward())

        iv_back.setImageResource(if (mWebView.canGoBack()) R.drawable.web_back else R.drawable.web_back_disable)
        iv_web_forward.setImageResource(if (mWebView.canGoForward()) R.drawable.web_forward else R.drawable.web_forward_disable)
    }

    private fun disableWebViewAcceleration(webview: WebView) {
        val product = Build.PRODUCT
        val s9ProductsThatNeedWorkaround =
            arrayOf("starqltesq", "star2qltesq", "starqlteue", "star2qlteue")

        if (s9ProductsThatNeedWorkaround.contains(product)) {
            webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
    }

    fun onBackOrForwardClick(view: View) {
        when (view.id) {
            R.id.fl_forward -> if (mWebView.canGoForward()) {
                mWebView.goForward()
            }
            R.id.fl_back -> onBackPressed()
        }
    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed")
        if (mWebView.canGoBack()) {
            mWebView.goBack()
        } else {
            Log.d(TAG, "webView finish")
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mWebView.stopLoading()
        mWebView.destroyWebView()
    }
}
