package com.kc.dw.ad.reward;

import android.view.View;
import com.kc.dw.core.safe.m;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FullScreenMediaView f39155a;

    public c(FullScreenMediaView fullScreenMediaView) {
        this.f39155a = fullScreenMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        if (this.f39155a.f39151a.b()) {
            FullScreenMediaView fullScreenMediaView = this.f39155a;
            fullScreenMediaView.f39151a.c();
            fullScreenMediaView.d();
            com.kc.dw.ad.nativ.h hVar = fullScreenMediaView.h;
            if (hVar != null) {
                ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).d();
            }
        }
    }
}
