package cj.mobile.wm.common;

import cj.mobile.wm.common.Iinterface.INativeExpressInterface;
import cj.mobile.wm.common.Iinterface.INativePotInterface;
import cj.mobile.wm.common.Iinterface.IRewordInterface;
import cj.mobile.wm.common.Iinterface.ISplashInterface;
import cj.mobile.wm.common.Iinterface.InterstitialInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IAdLoader {
    void fetchInterstialAd(InterstitialInterface interstitialInterface);

    void fetchNativeExpressAd(INativeExpressInterface iNativeExpressInterface);

    void fetchNativePotAd(INativePotInterface iNativePotInterface);

    void fetchRewordVideoAd(IRewordInterface iRewordInterface);

    void fetchSplashAd(ISplashInterface iSplashInterface);
}
