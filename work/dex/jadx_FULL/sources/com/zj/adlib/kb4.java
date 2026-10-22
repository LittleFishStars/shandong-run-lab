package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class kb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f42780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static Boolean f17631a;

    @KeepForSdk
    public static synchronized boolean a(@NonNull Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f42780a;
        if (context2 != null && (bool = f17631a) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f17631a = null;
        if (is6.n()) {
            f17631a = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f17631a = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f17631a = Boolean.FALSE;
            }
        }
        f42780a = applicationContext;
        return f17631a.booleanValue();
    }
}
