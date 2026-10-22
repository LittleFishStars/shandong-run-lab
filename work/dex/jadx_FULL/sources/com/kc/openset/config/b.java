package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdapterType;
import com.kc.openset.bean.InitConfigBean;
import com.kc.openset.bean.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<InitConfigBean> f39749a;
    private static final List<com.kc.openset.bean.d> b;
    private static final List<j> c;

    static {
        OSETSDKProtected.interface11(4397);
        f39749a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
    }

    public static native InitConfigBean a(String str);

    public static native com.kc.openset.bean.d a(String str, AdapterType adapterType, int i);

    public static native j a(String str, AdapterType adapterType);

    public static native List<InitConfigBean> a();

    private static native void b();

    private static native void c();

    private static native void d();
}
