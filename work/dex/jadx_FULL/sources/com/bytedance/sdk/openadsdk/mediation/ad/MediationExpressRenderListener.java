package com.bytedance.sdk.openadsdk.mediation.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediationExpressRenderListener extends TTNativeAd.ExpressRenderListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(View view, String str, int i);
}
