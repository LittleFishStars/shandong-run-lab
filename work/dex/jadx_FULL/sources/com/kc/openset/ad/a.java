package com.kc.openset.ad;

import android.app.Activity;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseAdLoad;
import com.kc.openset.ad.config.AdapterType;
import com.kc.openset.ad.listener.AdLoadCacheListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<BaseAdLoad> f39616a = new ArrayList();
    long b;
    private AdapterType c;

    /* JADX INFO: renamed from: com.kc.openset.ad.a$a, reason: collision with other inner class name */
    @Keep
    public static /* synthetic */ class C1103a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39617a;

        static {
            OSETSDKProtected.interface11(3728);
            int[] iArr = new int[AdapterType.values().length];
            f39617a = iArr;
            try {
                iArr[AdapterType.ADAPTER_TYPE_SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_FULL_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_REWARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_NATIVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_NATIVE_VIEW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_DRAW_NATIVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f39617a[AdapterType.ADAPTER_TYPE_INTERSTITIAL_HORIZONTAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static native /* synthetic */ void $r8$lambda$rbPc2ibrfbDabUi_sQ78S_MQiMQ(a aVar, AdLoadCacheListener adLoadCacheListener, e eVar, String str);

    static {
        OSETSDKProtected.interface11(3729);
    }

    private native void a(e eVar, String str, AdLoadCacheListener adLoadCacheListener);

    private native /* synthetic */ void a(AdLoadCacheListener adLoadCacheListener, e eVar, String str);

    private native String b();

    public final native String a(Activity activity, Context context, AdapterType adapterType, e eVar, AdLoadCacheListener adLoadCacheListener, boolean z, boolean z2);

    public final native void a();

    public final native void c();
}
