package com.kc.dw.ad.nativ;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39135a;

    public k(NormalMediaView normalMediaView) {
        this.f39135a = normalMediaView;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        a aVar;
        NormalMediaView normalMediaView = this.f39135a;
        if (normalMediaView.C || (aVar = normalMediaView.B) == null) {
            return;
        }
        aVar.onADExposure();
    }
}
