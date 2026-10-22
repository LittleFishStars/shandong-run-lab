package com.kc.openset.bridge;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class CocosBridgeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile CocosBridgeUtils f39735a;
    private WeakReference<Activity> b;

    static {
        OSETSDKProtected.interface11(4348);
    }

    private CocosBridgeUtils() {
    }

    public static native CocosBridgeUtils getInstance();

    public native Activity getActivity();

    public native void init(Activity activity);
}
