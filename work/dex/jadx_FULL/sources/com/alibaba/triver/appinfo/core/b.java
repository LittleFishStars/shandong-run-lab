package com.alibaba.triver.appinfo.core;

import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AppInfoCenterInternal f24641a = new AppInfoCenterInternal();

    @WorkerThread
    public static void a(long j, long j2) {
        f24641a.a(j, j2);
    }

    @WorkerThread
    public static void b() {
        f24641a.a();
    }

    @WorkerThread
    public static void c() {
        f24641a.b();
    }

    @WorkerThread
    public static long a() {
        AcceleratorConfig acceleratorConfigC = com.alibaba.triver.appinfo.storage.b.a().c();
        return acceleratorConfigC != null ? acceleratorConfigC.getMaxAsyncTime() : AppInfoCenterInternal.c;
    }

    @WorkerThread
    public static void b(AppRequestParams appRequestParams, a aVar) {
        f24641a.b(appRequestParams, aVar);
    }

    @WorkerThread
    public static void a(List<AcceleratorConfig.ConfigItem> list) {
        f24641a.a(list);
    }

    public static void a(AppRequestParams appRequestParams, a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            f24641a.a(appRequestParams, aVar);
        } else {
            b(appRequestParams, aVar);
        }
    }

    @WorkerThread
    public static AppInfoStrategy a(String str, String str2) {
        return f24641a.a(str, str2);
    }

    @WorkerThread
    public static AppModel a(String str, String str2, String str3) {
        return f24641a.a(str, str2, str3);
    }

    @WorkerThread
    public static void a(long j) {
        f24641a.a(j);
    }
}
