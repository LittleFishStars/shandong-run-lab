package com.fl.saas.adx.base.inner.interstitial;

import android.app.Activity;
import com.fl.saas.adx.base.inner.InnerViewLoaderEvent;
import com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InterstitialViewEvent extends InnerViewLoaderEvent<NativeInterstitialView> {
    void onActivityShow(Activity activity);

    void onDismiss();
}
