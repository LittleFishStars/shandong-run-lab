package com.efs.sdk.base.core.cache;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends Handler implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f29581a;
    boolean b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f29582a = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.f29582a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            WorkThreadUtil.submit(this);
            return;
        }
        Log.w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CacheManager.getInstance();
        File fileH = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileH.exists()) {
            for (File file : FileUtil.listFiles(fileH)) {
                if (CacheManager.a(file.getName())) {
                    CacheManager.a(file);
                }
            }
        }
        CacheManager.getInstance();
        File fileI = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileI.exists()) {
            for (File file2 : FileUtil.listFiles(fileI)) {
                if (CacheManager.a(file2.getName())) {
                    CacheManager.a(file2);
                }
            }
        }
        long j = Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("disk_bytes", "4194304"));
        long folderSize = FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z = folderSize < j;
        this.f29581a = z;
        if (!z) {
            Log.w("efs.cache", "Cache Limited! curr " + folderSize + "byte, max " + j + " byte.");
        }
        long j2 = Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("apm_codelog_store_max", "5")) * 1024 * 1024;
        long folderSize2 = FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z2 = folderSize2 < j2;
        this.b = z2;
        if (!z2) {
            Log.w("efs.cache", "code log. Cache Limited! curr " + folderSize2 + "byte, max " + j2 + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }

    private b() {
        super(com.efs.sdk.base.core.util.concurrent.a.f29618a.getLooper());
        this.f29581a = true;
        this.b = true;
        sendEmptyMessageDelayed(2, 60000L);
    }
}
