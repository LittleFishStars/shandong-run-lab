package com.kc.openset.sdk.apiad.tools;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f39916a;
    private final LinkedHashMap<String, ADVBaseListener> b = new LinkedHashMap<>();

    static {
        OSETSDKProtected.interface11(4881);
    }

    private a() {
    }

    public static native a a();

    public native void a(String str);

    public native void a(String str, ADVBaseListener aDVBaseListener);

    public native ADVBaseListener b(String str);
}
