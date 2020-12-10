/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.presentation.main.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.ActivityInWebViewBinding

class InWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityInWebViewBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_in_web_view)
        initView(binding)
    }

    private fun initView(binding: ActivityInWebViewBinding) {
        binding.webView.apply {
            loadUrl(getWebUrl())
            webViewClient = WebViewClient()
        }
        binding.webView.settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = false
            allowFileAccess = true
            loadWithOverviewMode = true
            useWideViewPort = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = true
            cacheMode = WebSettings.LOAD_DEFAULT
            defaultFixedFontSize = 14
        }
    }

    private fun getWebUrl() = intent.getStringExtra(WEB_URL_KEY)
        ?: throw IllegalArgumentException("url 을 입력해야합니다.")

    companion object {
        const val WEB_URL_KEY = "WebUrlKey"
    }
}