package com.example.admobdemo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAdView
import java.util.*

///
class MainActivity : AppCompatActivity() {
    private var mAdView: AdView? = null
    private var btnBanner: Button? = null
    private var btnInterstitial: Button? = null
    private var btnNative: Button? = null
    private val TAG = "MainActivity"
    private lateinit var bannerAd: BannerAd
    private lateinit var interstitialAd: InterstitialAd
    private lateinit var nativeAd: NativeAd
    private var mAdManagerAdView: NativeAdView? = null

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
        btnNative = findViewById(R.id.btnNative)
        mAdManagerAdView = findViewById(R.id.fluid_view)

        interstitialAd = InterstitialAd()
        interstitialAd.ShowInterstitialAd(this)

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

        btnNative?.setOnClickListener {
            nativeAd = NativeAd()
            nativeAd.showNativeAd(this)
        }

        btnNative?.setOnClickListener {
          startActivity(Intent(this,NativeAds().javaClass))
        }
    }

}