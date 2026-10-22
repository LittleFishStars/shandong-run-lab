package com.byazt.zz;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 913})
public class CSJDownloadService extends Service {
    public static final String tt = "CSJDownloadService";
    public z c;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = tt;
        StringBuilder sb = new StringBuilder("onBind downloadServiceHandler != null:");
        sb.append(this.c != null);
        com.byazt.x.c.tt(str, sb.toString());
        z zVar = this.c;
        if (zVar != null) {
            return zVar.c(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ve.c(this);
        z zVarYv = ve.yv();
        this.c = zVarYv;
        zVarYv.c(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.byazt.x.c.c()) {
            com.byazt.x.c.tt(tt, "Service onDestroy");
        }
        z zVar = this.c;
        if (zVar != null) {
            zVar.uj();
            this.c = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.byazt.x.c.c()) {
            com.byazt.x.c.tt(tt, "DownloadService onStartCommand");
        }
        this.c.ve();
        ExecutorService executorServiceT = ve.t();
        if (executorServiceT != null) {
            executorServiceT.execute(new Runnable() { // from class: com.byazt.zz.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    z zVar = CSJDownloadService.this.c;
                    if (zVar != null) {
                        zVar.c(intent, i, i2);
                    }
                }
            });
        }
        return ve.da() ? 2 : 3;
    }
}
