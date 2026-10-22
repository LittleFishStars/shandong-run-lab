package com.fl.saas.adx.base.inner;

import android.view.View;
import android.view.ViewGroup;
import com.fl.saas.adx.api.mixNative.NativeAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerNativeView {
    View getCATView();

    View[] getClicks();

    NativeAdView getNativeAdView();

    ViewGroup getSelfView();

    void onClicked();
}
