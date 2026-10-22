package com.kc.bw.common;

import android.app.Activity;
import com.kc.bw.common.Iinterface.INativeExpressInterface;
import com.kc.bw.common.Iinterface.INativePotInterface;
import com.kc.bw.common.Iinterface.IRewordInterface;
import com.kc.bw.common.Iinterface.ISplashInterface;
import com.kc.bw.common.Iinterface.InterstitialInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IAdLoader {
    void dispatchAction(Activity activity);

    void fetchInterstialAd(InterstitialInterface interstitialInterface);

    void fetchNativeExpressAd(INativeExpressInterface iNativeExpressInterface);

    void fetchNativePotAd(INativePotInterface iNativePotInterface);

    void fetchRewordVideoAd(IRewordInterface iRewordInterface);

    void fetchSplashAd(ISplashInterface iSplashInterface);
}
