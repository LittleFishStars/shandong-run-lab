package com.kc.dw.core.router.service;

import android.app.Activity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends d {

    /* JADX INFO: renamed from: com.kc.dw.core.router.service.a$a, reason: collision with other inner class name */
    @Keep
    public interface InterfaceC1044a {
        void onActivityPause(Activity activity);

        void onActivityResume(Activity activity);

        void onAppStateUpdate(boolean z);
    }

    void a(InterfaceC1044a interfaceC1044a);

    void b(InterfaceC1044a interfaceC1044a);
}
