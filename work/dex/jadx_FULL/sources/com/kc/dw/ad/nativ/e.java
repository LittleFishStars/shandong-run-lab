package com.kc.dw.ad.nativ;

import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends com.kc.dw.core.safe.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f39129a;
    public final com.kc.dw.platform.ad_adapter.recycler.f b;
    public final g c;

    public e(g gVar, ViewGroup viewGroup, com.kc.dw.platform.ad_adapter.recycler.f fVar) {
        this.c = gVar;
        this.f39129a = viewGroup;
        this.b = fVar;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        i iVar = this.c.h;
        if (iVar == null || !iVar.B) {
            LogUtil.dev("NativeAdDataImpl", "is`not FeedAdExposure");
            return;
        }
        if (this.f39129a != null) {
            for (int i = 0; i < this.c.h.getClickUrl().length; i++) {
                try {
                    int width = this.f39129a.getWidth();
                    int height = this.f39129a.getHeight();
                    if (width > 0 && height > 0) {
                        this.c.h.getClickUrl()[i] = g0.a(this.c.h.getClickUrl()[i], width, height);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.b.a();
    }
}
