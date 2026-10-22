package com.kc.dw.platform.ad_adapter.paster;

import android.view.View;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.nativ.d f39481a;
    public final d.a b;

    public a(d.a aVar, com.kc.dw.ad.nativ.d dVar) {
        this.b = aVar;
        this.f39481a = dVar;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        if (this.b.b.g) {
            this.f39481a.a().setClkActType(1);
            T t = this.b.b.f39477a;
            if (t != 0 && ((i) t).getCbc() == 0 && this.b.b.i.getInteractionListener() != null) {
                this.b.b.i.getInteractionListener().onAdClicked();
            }
            this.f39481a.setInteractionListener(this.b.b.i.getInteractionListener());
            f.a((com.kc.dw.platform.ad_adapter.c) this.f39481a, true);
        }
    }
}
