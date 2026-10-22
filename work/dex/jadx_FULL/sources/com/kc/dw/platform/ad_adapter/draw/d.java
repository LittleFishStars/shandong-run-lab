package com.kc.dw.platform.ad_adapter.draw;

import android.view.View;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.safe.m;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.nativ.d f39460a;
    public final f.a b;

    public d(f.a aVar, com.kc.dw.ad.nativ.d dVar) {
        this.b = aVar;
        this.f39460a = dVar;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        if (this.b.f39463a.f39462a.f) {
            this.f39460a.a().setClkActType(2);
            T t = this.b.f39463a.f39462a.f39477a;
            if (t != 0 && ((i) t).getCbc() == 0 && this.b.f39463a.f39462a.h.getInteractionListener() != null) {
                this.b.f39463a.f39462a.h.getInteractionListener().onAdClicked();
            }
            this.f39460a.setInteractionListener(this.b.f39463a.f39462a.h.getInteractionListener());
            com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.f39460a, true);
        }
    }
}
