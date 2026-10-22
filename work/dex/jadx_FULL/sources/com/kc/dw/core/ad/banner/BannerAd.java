package com.kc.dw.core.ad.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class BannerAd extends a implements IBannerAd {
    private b adWrapper;

    public BannerAd(b bVar, String str) {
        super(bVar, str);
        this.adWrapper = bVar;
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void render() {
        com.kc.dw.core.service.logrecord.a.a(5, "e5", this.adWrapper, new TypeMsg().setData(2));
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void setCloseButtonVisible(boolean z) {
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void setWidthAndHeight(int i, int i2) {
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
