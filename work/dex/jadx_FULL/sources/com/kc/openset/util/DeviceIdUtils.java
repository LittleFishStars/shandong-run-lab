package com.kc.openset.util;

import android.content.Context;
import android.util.Pair;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class DeviceIdUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f39942a = true;
    private static OnDeviceIdResult b;

    @Keep
    public interface OnDeviceIdResult {
        void onResult();
    }

    @Keep
    public class a implements OAIDUtils.OnOAIDLoadCompleteListener {
        static {
            OSETSDKProtected.interface11(4929);
        }

        @Override // com.kc.openset.util.OAIDUtils.OnOAIDLoadCompleteListener
        public native void onAllOAIDLoadComplete(List<OAIDUtils.c> list);

        @Override // com.kc.openset.util.OAIDUtils.OnOAIDLoadCompleteListener
        public native void onSsOAIDLoadComplete(Pair<String, String> pair);
    }

    @Keep
    public class b implements IGetter {
        static {
            OSETSDKProtected.interface11(4930);
        }

        @Override // com.kc.openset.oaid.IGetter
        public native void onOAIDGetComplete(String str);

        @Override // com.kc.openset.oaid.IGetter
        public native void onOAIDGetError(Exception exc);
    }

    static {
        OSETSDKProtected.interface11(4931);
    }

    public static native /* synthetic */ OnDeviceIdResult a();

    public static native /* synthetic */ void a(Context context);

    public static native void a(OnDeviceIdResult onDeviceIdResult);

    public static native /* synthetic */ void a(List list);

    public static native boolean a(String str);

    private static native void b();

    private static native void b(Context context);

    private static native void b(List<OAIDUtils.c> list);

    private static native void c();

    private static native void c(Context context);

    public static native String d();

    private static native void d(Context context);

    private static native void e(Context context);

    public static native boolean e();

    public static native void f();
}
