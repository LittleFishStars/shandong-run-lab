package cj.mobile.jt.core.splash;

import cj.mobile.jt.core.interfaces.o;
import cj.mobile.jt.core.modle.AdError;
import cj.mobile.jt.core.modle.IJuTuiBiddingAdData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface JuTuiSplashListener extends o {
    @Override // cj.mobile.jt.core.interfaces.o
    /* synthetic */ void onAdClicked();

    @Override // cj.mobile.jt.core.interfaces.o
    /* synthetic */ void onAdDismissed();

    void onAdLoaded(IJuTuiBiddingAdData iJuTuiBiddingAdData);

    @Override // cj.mobile.jt.core.interfaces.o
    /* synthetic */ void onAdPresent();

    void onNoAd(AdError adError);

    @Override // cj.mobile.jt.core.interfaces.o
    /* synthetic */ void onShowError(AdError adError);
}
