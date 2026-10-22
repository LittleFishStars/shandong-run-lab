package com.kc.dw.core.ad.splash;

import android.view.ViewGroup;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class SplashAd extends a implements ISplashAd {
    public ViewGroup adContainer;
    private b adWrapper;
    public ISplashDownloadDialogListener downloadDialogListener;
    private ISplashFinishingTouchListener finishingTouchListener;
    public Integer height;
    private boolean isFinishingTouch;
    public Integer width;

    public SplashAd(b bVar, String str) {
        super(bVar, str);
        this.adWrapper = bVar;
    }

    public Integer getHeight() {
        return this.height;
    }

    public boolean getIsFinishingTouch() {
        return this.isFinishingTouch;
    }

    public ISplashFinishingTouchListener getSplashFinishingTouchListener() {
        return this.finishingTouchListener;
    }

    public Integer getWidth() {
        return this.width;
    }

    @Override // com.kc.dw.core.ad.splash.ISplashAd
    public void render() {
        com.kc.dw.core.service.logrecord.a.a(5, "e5", this.adWrapper, new TypeMsg().setData(2));
    }

    public void setAdContainer(ViewGroup viewGroup) {
        this.adContainer = viewGroup;
    }

    @Override // com.kc.dw.core.ad.splash.ISplashAd
    public void setDownloadDialogListener(ISplashDownloadDialogListener iSplashDownloadDialogListener) {
        this.downloadDialogListener = iSplashDownloadDialogListener;
    }

    public void setHeight(Integer num) {
        this.height = num;
    }

    public void setIsFinishingTouch(boolean z) {
        this.isFinishingTouch = z;
    }

    @Override // com.kc.dw.core.ad.splash.ISplashAd
    public void setSplashFinishingTouchListener(ISplashFinishingTouchListener iSplashFinishingTouchListener) {
        this.finishingTouchListener = iSplashFinishingTouchListener;
    }

    public void setWidth(Integer num) {
        this.width = num;
    }

    public void showAd(ViewGroup viewGroup) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.kc.dw.core.ad.splash.ISplashAd
    public void splashAnimationFinish() {
    }
}
