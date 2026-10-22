package com.bwt.top.zhike;

import com.bwt.top.custom_ad.AdapterCustomSplashAdLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ZhiKeSplashAdLoader extends AdapterCustomSplashAdLoader {
    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader, com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void onAdExposeListener() {
        super.onAdExposeListener();
        displayReport();
    }
}
