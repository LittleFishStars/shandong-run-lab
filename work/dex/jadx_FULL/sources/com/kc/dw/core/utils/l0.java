package com.kc.dw.core.utils;

import android.app.Activity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l0 implements com.kc.dw.core.router.service.a.InterfaceC1044a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f39382a;

    public l0(boolean z) {
        this.f39382a = z;
    }

    @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
    public void onActivityPause(Activity activity) {
    }

    @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
    public void onActivityResume(Activity activity) {
        m0.a(this.f39382a);
        com.kc.dw.core.router.helper.a.b(this);
    }

    @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
    public void onAppStateUpdate(boolean z) {
    }
}
