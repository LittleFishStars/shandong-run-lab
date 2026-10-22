package com.zj.adlib;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46185a = "BundleUtil";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static Method f20980a;

    @Nullable
    public static Method b;

    @Nullable
    public static IBinder a(Bundle bundle, @Nullable String str) {
        return gj9.f41922a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    @Nullable
    public static IBinder b(Bundle bundle, @Nullable String str) {
        Method method = f20980a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f20980a = method2;
                method2.setAccessible(true);
                method = f20980a;
            } catch (NoSuchMethodException e) {
                Log.i(f46185a, "Failed to retrieve getIBinder method", e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            Log.i(f46185a, "Failed to invoke getIBinder via reflection", e2);
            return null;
        }
    }

    public static void c(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (gj9.f41922a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    public static void d(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                b = method2;
                method2.setAccessible(true);
                method = b;
            } catch (NoSuchMethodException e) {
                Log.i(f46185a, "Failed to retrieve putIBinder method", e);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            Log.i(f46185a, "Failed to invoke putIBinder via reflection", e2);
        }
    }
}
