package com.bwt.top.channel;

import com.bwt.top.custom_ad.AdapterCustomInterstitialAdLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ChannelInterstitialAdLoader extends AdapterCustomInterstitialAdLoader {
    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void onAdReceiveListener() {
        super.onAdReceiveListener();
        displayReport();
    }
}
