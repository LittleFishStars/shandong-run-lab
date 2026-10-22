package com.ipd.dsp.internal.c0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.f.f;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38211a = "AppVersionSignature";
    public static final ConcurrentMap<String, f> b = new ConcurrentHashMap();

    @VisibleForTesting
    public static void a() {
        b.clear();
    }

    @NonNull
    public static f b(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, f> concurrentMap = b;
        f fVar = concurrentMap.get(packageName);
        if (fVar != null) {
            return fVar;
        }
        f fVarC = c(context);
        f fVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, fVarC);
        return fVarPutIfAbsent == null ? fVarC : fVarPutIfAbsent;
    }

    @NonNull
    public static f c(@NonNull Context context) {
        return new e(a(a(context)));
    }

    @NonNull
    public static String a(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @Nullable
    public static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            k.b(f38211a, "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }
}
