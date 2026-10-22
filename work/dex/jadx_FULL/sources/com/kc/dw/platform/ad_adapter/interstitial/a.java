package com.kc.dw.platform.ad_adapter.interstitial;

import com.kc.dw.core.ad.interstitial.InterstitialAdListener;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.ad_adapter.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements com.kc.dw.ad.interstitial.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialAdListener f39478a;
    public b b;

    public a(b bVar, InterstitialAdListener interstitialAdListener) {
        this.b = bVar;
        this.f39478a = interstitialAdListener;
    }

    @Override // com.kc.dw.ad.z
    public void onAdRenderFail(String str, int i) {
        if (((com.kc.dw.ad.interstitial.b) this.b.f39477a).getErrorUrl() != null) {
            z.a(((com.kc.dw.ad.interstitial.b) this.b.f39477a).getErrorUrl()[0], Integer.valueOf(i), str);
        }
        InterstitialAdListener interstitialAdListener = this.f39478a;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPlatformError(new f(str, Integer.valueOf(i)));
            this.f39478a.onAdRenderFail(str, i);
        }
    }
}
