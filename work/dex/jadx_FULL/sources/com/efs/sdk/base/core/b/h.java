package com.efs.sdk.base.core.b;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h {
    static FileLock b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile int f29570a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f29572a = new h(0);
    }

    public /* synthetic */ h(byte b2) {
        this();
    }

    public final boolean a() {
        if (this.f29570a == 2) {
            return true;
        }
        if (this.f29570a != 0) {
            return false;
        }
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }

    private h() {
        this.f29570a = 0;
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    private synchronized void a(final Context context) {
        Log.w("efs.send_log", "tryFileLock start! ");
        this.f29570a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.core.b.h.1
            @Override // java.lang.Runnable
            public final void run() {
                FileLock fileLockLock;
                try {
                    File fileA = com.efs.sdk.base.core.util.a.a(context);
                    if (!fileA.exists()) {
                        fileA.mkdirs();
                    }
                    File file = new File(fileA.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        fileLockLock = new FileOutputStream(file).getChannel().lock();
                        h.b = fileLockLock;
                    } while (!fileLockLock.isValid());
                    Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + ProcessUtil.getCurrentProcessName());
                    h.this.f29570a = 2;
                } catch (Exception e) {
                    Log.w("efs.send_log", "tryFileLock fail! " + e.getMessage());
                    h.this.f29570a = 0;
                }
            }
        }).start();
    }
}
