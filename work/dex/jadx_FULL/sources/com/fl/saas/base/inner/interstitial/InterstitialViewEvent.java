package com.fl.saas.base.inner.interstitial;

import com.fl.saas.base.inner.InnerViewLoaderEvent;
import com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InterstitialViewEvent extends InnerViewLoaderEvent<NativeInterstitialView> {
    void onDismiss();
}
