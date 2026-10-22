package com.kc.openset.sdk.apiad.tools;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f39923a;

    static {
        OSETSDKProtected.interface11(4893);
    }

    private h() {
    }

    public static native h a();

    public native void a(Context context, String str, String str2, DeeplinkCallback deeplinkCallback);
}
