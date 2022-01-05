package com.example.admobdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {
    private var mAdView: AdView? = null
    private var btnBanner: Button? = null
    private var btnInterstitial: Button? = null
    private val TAG = "MainActivity"
    private lateinit var bannerAd: BannerAd
    private lateinit var interstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {
            Log.d(TAG, "initialize :" + it.toString())
        }
        initId()
        clickEvent()
    }

    private fun initId() {
        mAdView = findViewById(R.id.adView)
        btnBanner = findViewById(R.id.btnBanner)
        btnInterstitial = findViewById(R.id.btnInterstitial)
    }

    private fun deviceId() {
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("D8AF26B5FF561C5354230FE528DC774E"))
                .build()
        )
    }

    private fun clickEvent() {
        btnBanner?.setOnClickListener {
            bannerAd = BannerAd()
            bannerAd.showBanner(mAdView = mAdView)

        }
        btnInterstitial?.setOnClickListener {
            interstitialAd = InterstitialAd()
            interstitialAd.ShowInterstitialAd(this)
        }
    }
}