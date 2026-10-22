package com.zj.adlib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w8c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f20388a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static String f20389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("sLock")
    public static boolean f20390a;

    public static int a(Context context) {
        c(context);
        return f45547a;
    }

    @Nullable
    public static String b(Context context) {
        c(context);
        return f20389a;
    }

    public static void c(Context context) {
        synchronized (f20388a) {
            if (f20390a) {
                return;
            }
            f20390a = true;
            try {
                Bundle bundle = w0a.a(context).c(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f20389a = bundle.getString("com.google.app.id");
                f45547a = bundle.getInt("com.google.android.gms.version");
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
