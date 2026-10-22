package com.kc.openset.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f39981a;
    private static Method b;
    private static Field c;
    private static int d;

    static {
        OSETSDKProtected.interface11(5037);
        String string2 = OSETSDKProtected.getString2(3452);
        try {
            f39981a = Activity.class.getMethod(string2, Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            b = Activity.class.getMethod(string2, Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            c = WindowManager.LayoutParams.class.getField(OSETSDKProtected.getString2("3453"));
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            d = View.class.getField(OSETSDKProtected.getString2("3454")).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    public static native void a(Activity activity, boolean z);

    private static native void a(Activity activity, boolean z, boolean z2);

    private static native void a(View view, boolean z);

    private static native void a(Window window, int i);

    public static native void a(Window window, boolean z);

    private static native boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z);
}
