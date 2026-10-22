package com.kc.dw.core.ad.fullscreenvideo;

import android.app.Activity;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class FullScreenVideoAd extends a implements IFullScreenVideoAd {
    private b adWrapper;

    public FullScreenVideoAd(b bVar, String str) {
        super(bVar, str);
        this.adWrapper = bVar;
    }

    @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void render() {
    }

    @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
