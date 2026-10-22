package com.kc.openset.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class AppUtils {
    private static final String TAG = OSETSDKProtected.getString2(3062);

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39939a;
        private String b;
        private Drawable c;
        private String d;
        private String e;
        private int f;
        private int g;
        private int h;
        private boolean i;

        static {
            OSETSDKProtected.interface11(4921);
        }

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, int i2, int i3, boolean z) {
            a(str2);
            a(drawable);
            b(str);
            c(str3);
            d(str4);
            c(i);
            a(i2);
            b(i3);
            a(z);
        }

        public native Drawable a();

        public native void a(int i);

        public native void a(Drawable drawable);

        public native void a(String str);

        public native void a(boolean z);

        public native int b();

        public native void b(int i);

        public native void b(String str);

        public native String c();

        public native void c(int i);

        public native void c(String str);

        public native String d();

        public native void d(String str);

        public native String e();

        public native int f();

        public native int g();

        public native String h();

        public native boolean i();

        public native String toString();
    }

    static {
        OSETSDKProtected.interface11(4922);
    }

    public static native a getAppInfoByPackage(String str);

    public static native List<a> getAppsInfo(Application application);

    public static native a getBean(PackageManager packageManager, PackageInfo packageInfo);

    public static native String getCurAppVersionName(Context context);

    public static native int getVersionNo(Context context);

    public static native boolean isDebuggable(Context context);

    public static native List<a> queryIntentActivities(Application application);
}
