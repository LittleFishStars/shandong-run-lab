package com.byazt.zz;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.t.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 20})
public abstract class c implements z {
    public static final String n = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Service> f29268a;
    public volatile boolean ve;
    public final SparseArray<List<DownloadTask>> c = new SparseArray<>();
    public volatile boolean tt = false;
    public volatile boolean uj = false;
    public Handler sp = new Handler(Looper.getMainLooper());
    public Runnable x = new Runnable() { // from class: com.byazt.zz.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.byazt.x.c.c()) {
                com.byazt.x.c.tt(c.n, "tryDownload: 2 try");
            }
            if (c.this.tt) {
                return;
            }
            if (com.byazt.x.c.c()) {
                com.byazt.x.c.tt(c.n, "tryDownload: 2 error");
            }
            c.this.startService(ve.ic(), null);
        }
    };

    @Override // com.byazt.zz.z
    public void c(Intent intent, int i, int i2) {
    }

    @Override // com.byazt.zz.z
    public void c(yp ypVar) {
    }

    @Override // com.byazt.zz.z
    public void c(WeakReference weakReference) {
        this.f29268a = weakReference;
    }

    public void n() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.c) {
            com.byazt.x.c.tt(n, "resumePendingTask pendingTasks.size:" + this.c.size());
            sparseArrayClone = this.c.clone();
            this.c.clear();
        }
        com.byazt.b.c cVarD = ve.d();
        if (cVarD != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.byazt.x.c.tt(n, "resumePendingTask key:" + downloadTask.getDownloadId());
                        cVarD.c(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.byazt.zz.z
    public void startService() {
        if (this.tt) {
            return;
        }
        if (com.byazt.x.c.c()) {
            com.byazt.x.c.tt(n, "startService");
        }
        startService(ve.ic(), null);
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.byazt.zz.z
    public boolean tt() {
        com.byazt.x.c.ve(n, "isServiceForeground = " + this.ve);
        return this.ve;
    }

    @Override // com.byazt.zz.z
    public void uj() {
        this.tt = false;
    }

    @Override // com.byazt.zz.z
    public void ve() {
    }

    @Override // com.byazt.zz.z
    public void ve(DownloadTask downloadTask) {
    }

    @Override // com.byazt.zz.z
    public boolean c() {
        return this.tt;
    }

    @Override // com.byazt.zz.z
    public IBinder c(Intent intent) {
        com.byazt.x.c.tt(n, "onBind Abs");
        return new Binder();
    }

    @Override // com.byazt.zz.z
    public void tt(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.tt) {
            if (com.byazt.x.c.c()) {
                com.byazt.x.c.tt(n, "tryDownload but service is not alive");
            }
            if (com.byazt.w.c.c(262144)) {
                c(downloadTask);
                if (!this.uj) {
                    if (com.byazt.x.c.c()) {
                        com.byazt.x.c.tt(n, "tryDownload: 1");
                    }
                    startService(ve.ic(), null);
                    this.uj = true;
                    return;
                }
                this.sp.removeCallbacks(this.x);
                this.sp.postDelayed(this.x, 10L);
                return;
            }
            c(downloadTask);
            startService(ve.ic(), null);
            return;
        }
        String str = n;
        com.byazt.x.c.tt(str, "tryDownload when isServiceAlive");
        n();
        com.byazt.b.c cVarD = ve.d();
        if (cVarD != null) {
            com.byazt.x.c.tt(str, "tryDownload current task: " + downloadTask.getDownloadId());
            cVarD.c(downloadTask);
        }
    }

    @Override // com.byazt.zz.z
    public void c(int i, Notification notification) {
        WeakReference<Service> weakReference = this.f29268a;
        if (weakReference != null && weakReference.get() != null) {
            com.byazt.x.c.ve(n, "startForeground  id = " + i + ", service = " + this.f29268a.get() + ",  isServiceAlive = " + this.tt);
            try {
                this.f29268a.get().startForeground(i, notification);
                this.ve = true;
                return;
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                return;
            }
        }
        com.byazt.x.c.uj(n, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.byazt.zz.z
    public void c(boolean z) {
        WeakReference<Service> weakReference = this.f29268a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.byazt.x.c.ve(n, "stopForeground  service = " + this.f29268a.get() + ",  isServiceAlive = " + this.tt);
        try {
            this.ve = false;
            this.f29268a.get().stopForeground(z);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.c) {
            String str = n;
            com.byazt.x.c.tt(str, "pendDownloadTask pendingTasks.size:" + this.c.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.c.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.c.put(downloadId, arrayList);
            }
            com.byazt.x.c.tt(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.byazt.x.c.tt(str, "after pendDownloadTask pendingTasks.size:" + this.c.size());
        }
    }

    @Override // com.byazt.zz.z
    public void c(int i) {
        com.byazt.x.c.c(i);
    }
}
