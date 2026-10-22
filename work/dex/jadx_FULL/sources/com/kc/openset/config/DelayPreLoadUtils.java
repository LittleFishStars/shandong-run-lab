package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class DelayPreLoadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile DelayPreLoadUtils f39747a;
    private DelayPreLoadListener b;
    private boolean c = false;

    @Keep
    public interface DelayPreLoadListener {
        void doLoad();
    }

    static {
        OSETSDKProtected.interface11(4394);
    }

    public static native DelayPreLoadUtils a();

    public native void a(DelayPreLoadListener delayPreLoadListener);

    public native void b();
}
