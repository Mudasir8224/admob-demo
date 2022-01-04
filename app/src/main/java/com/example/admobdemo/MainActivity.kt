package com.example.admobdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mAdView: AdView? = null
    private var mButton: Button? = null
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdView = findViewById(R.id.adView)
        mButton = findViewById(R.id.button)

        MobileAds.initialize(this) {
            Log.d(TAG, "initialize :" + it.toString())
        }

        clickEvent()

//      mAdView!!.adSize = AdSize.BANNER
//       // mAdView!!.adUnitId = "ca-app-pub-1579765449468517/2317506186"
//       // mAdView!!.adUnitId = "ca-app-pub-3940256099942544/6300978111"
//        val adRequest = AdRequest.Builder().build()
//        mAdView?.loadAd(adRequest)

    }

    private fun clickEvent() {
        mButton?.setOnClickListener {
            showAdd()
        }
    }

    private fun showAdd() {
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("D8AF26B5FF561C5354230FE528DC774E"))
                .build()
        )
        val adRequest = AdRequest.Builder().build()
        mAdView?.loadAd(adRequest)

        mAdView?.adListener = object : AdListener() {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d(TAG,"onAdFailedToLoad :" +p0.toString())
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d(TAG, "onAdLoaded :")
            }
        }
    }
//
//    public override fun onResume() {
//        super.onResume()
//        mAdView?.resume()
//    }
//
//    public override fun onDestroy() {
//        mAdView?.destroy()
//        super.onDestroy()
//
//    }
}