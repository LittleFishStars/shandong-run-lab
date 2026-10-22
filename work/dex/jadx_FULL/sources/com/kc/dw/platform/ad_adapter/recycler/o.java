package com.kc.dw.platform.ad_adapter.recycler;

import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o implements RecylcerAdInteractionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f39514a;

    public o(i iVar) {
        this.f39514a = iVar;
    }

    @Override // com.kc.dw.core.loader.InteractionListener
    public void onAdClicked() {
        if (this.f39514a.f39495a.a().getCbc() == 0) {
            this.f39514a.callAdClicked();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
    public void onAdClosed() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
    public void onAdExposure() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener
    public void onAdRenderFailed() {
    }
}
