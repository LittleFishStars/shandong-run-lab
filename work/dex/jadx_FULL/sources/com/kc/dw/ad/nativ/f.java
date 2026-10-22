package com.kc.dw.ad.nativ;

import android.view.ViewGroup;
import com.kc.dw.ad.a0;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.core.service.logrecord.util.a f39130a;
    public final a0 b;
    public final h c;
    public final ViewGroup d;
    public final g e;

    public f(g gVar, com.kc.dw.core.service.logrecord.util.a aVar, a0 a0Var, h hVar, ViewGroup viewGroup) {
        this.e = gVar;
        this.f39130a = aVar;
        this.b = a0Var;
        this.c = hVar;
        this.d = viewGroup;
    }

    @Override // com.kc.dw.ad.nativ.c
    public void onPrepareError(int i, String str) {
        NativeAdMediaListener nativeAdMediaListener;
        LogUtil.d("NativeAdDataImpl", "onFail: " + i + ", " + str);
        com.kc.dw.core.service.logrecord.util.a aVar = this.f39130a;
        if (aVar != null) {
            aVar.a(false);
        }
        h hVar = this.c;
        if (hVar == null || (nativeAdMediaListener = ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f39488a) == null) {
            return;
        }
        nativeAdMediaListener.onVideoError();
    }

    @Override // com.kc.dw.ad.nativ.c
    public void onPreparedStartPlay(int i, int i2, boolean z) {
        try {
            com.kc.dw.core.service.logrecord.util.a aVar = this.f39130a;
            if (aVar != null) {
                aVar.a(true);
            }
            a0 a0Var = this.b;
            if (a0Var != null) {
                a0Var.setNativeAdMediaListener(this.c);
            }
            if (this.d != null) {
                ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.d.addView(this.e.g.getVideoView());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.nativ.c
    public void onStartDownload() {
    }
}
