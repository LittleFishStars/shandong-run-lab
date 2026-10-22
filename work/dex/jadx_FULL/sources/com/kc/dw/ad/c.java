package com.kc.dw.ad;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsdSplashRootView f39086a;
    public final LinearLayout b;
    public final com.kc.dw.core.bquery.d c;

    public c(k kVar, SsdSplashRootView ssdSplashRootView, LinearLayout linearLayout, com.kc.dw.core.bquery.d dVar) {
        this.f39086a = ssdSplashRootView;
        this.b = linearLayout;
        this.c = dVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        int measuredHeight = this.f39086a.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.bottomMargin = (int) (((double) measuredHeight) * 0.1d);
        this.b.setLayoutParams(layoutParams);
        this.c.b(R.id.ms_shakeRoot).d(0);
    }
}
