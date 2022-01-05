package com.example.admobdemo

import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

class BannerAd {
    val TAG = "BannerAd"
    fun showBanner(mAdView: AdView?) {
        val adRequest = AdRequest.Builder().build()
        mAdView?.loadAd(adRequest)

        mAdView?.adListener = object : AdListener() {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d(TAG, "onAdFailedToLoad :" + p0.toString())
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d(TAG, "onAdLoaded :")
            }
        }
    }
}