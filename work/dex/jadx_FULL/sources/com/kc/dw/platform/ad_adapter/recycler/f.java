package com.kc.dw.platform.ad_adapter.recycler;

import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecylcerAdInteractionListener f39490a;
    public com.kc.dw.ad.nativ.d b;

    public f(com.kc.dw.ad.nativ.d dVar, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        this.b = dVar;
        this.f39490a = recylcerAdInteractionListener;
    }

    public void a() {
        try {
            this.b.a().setClkActType(1);
            if (this.f39490a != null && this.b.a().getCbc() == 0) {
                this.f39490a.onAdClicked();
            }
            com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.b, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
