package com.kc.dw.own.splash;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.ad.splash.b;
import com.kc.dw.ad.splash.c;
import com.kc.dw.core.ad.splash.ISplashFinishingTouchListener;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.ad_adapter.splash.k;
import com.kc.dw.platform.custom.splash.MsCustomSplashAd;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomSplashAd extends MsCustomSplashAd {
    private k qzxSplashAd;

    public OwnCustomSplashAd(MsCustomSplashAdapter msCustomSplashAdapter, String str, k kVar) {
        super(msCustomSplashAdapter, str);
        this.qzxSplashAd = kVar;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        k kVar = this.qzxSplashAd;
        return kVar != null ? kVar.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        k kVar = this.qzxSplashAd;
        if (kVar != null) {
            return kVar.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        k kVar = this.qzxSplashAd;
        if (kVar != null) {
            kVar.sendLossNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        k kVar = this.qzxSplashAd;
        if (kVar != null) {
            kVar.sendWinNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void setSplashFinishingTouchListener(ISplashFinishingTouchListener iSplashFinishingTouchListener) {
        k kVar = this.qzxSplashAd;
        if (kVar != null) {
            kVar.setSplashFinishingTouchListener(iSplashFinishingTouchListener);
        }
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void splashAnimationFinish() {
        k kVar = this.qzxSplashAd;
        if (kVar != null) {
            try {
                b bVar = kVar.b;
                if (bVar == null || !(bVar instanceof c)) {
                    return;
                }
                c cVar = (c) bVar;
                cVar.h = true;
                SsdSplashRootView ssdSplashRootView = cVar.e;
                ImageView imageView = (ImageView) ssdSplashRootView.findViewById(R.id.ms_click_eye_close);
                ssdSplashRootView.findViewById(R.id.ssd_skipView).setVisibility(8);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new k.a(kVar, cVar));
                ssdSplashRootView.setOnClickListener(new k.b(kVar, cVar));
                new Handler(Looper.getMainLooper()).postDelayed(new k.c(kVar, cVar), 5000L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
