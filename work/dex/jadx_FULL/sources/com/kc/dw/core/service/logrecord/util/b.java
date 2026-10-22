package com.kc.dw.core.service.logrecord.util;

import com.kc.dw.core.view.TouchAdContainer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements TouchAdContainer.OnWindownEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.core.loader.b f39322a;

    public b(com.kc.dw.core.loader.b bVar) {
        this.f39322a = bVar;
    }

    @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
    public void onAttachedToWindow() {
        c.c(this.f39322a);
        c.d(this.f39322a);
    }

    @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
    public void onDetachedFromWindow() {
    }

    @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
    public void onWindowFocusChanged(boolean z) {
    }
}
