package com.byazt.l;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ev.n;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.u.sp;
import com.byazt.w.a;
import com.byazt.zz.Downloader;
import com.byazt.zz.ve;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 517, 20})
public class c {
    public static volatile c sp;
    public volatile long c;
    public volatile long tt;
    public volatile sp uj;
    public long ve = 1000;
    public final SparseArray<Notification> n = new SparseArray<>(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f28766a = new AtomicBoolean(false);

    public void tt() {
        if (this.f28766a.compareAndSet(false, true)) {
            this.uj = new sp("DownloaderNotifyThread");
            this.uj.c();
            long jC = com.byazt.k.c.ve().c("notification_time_window", 1000L);
            this.ve = jC;
            if (jC < 0 || jC > 1200) {
                this.ve = 1000L;
            }
        }
    }

    public static c c() {
        if (sp == null) {
            synchronized (c.class) {
                if (sp == null) {
                    sp = new c();
                }
            }
        }
        return sp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        DownloadInfo downloadInfo;
        Context contextIc = ve.ic();
        if (contextIc == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) contextIc.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 != -2 && intExtra2 != -3) {
                    c(notificationManager, intExtra, notification);
                    return;
                } else {
                    c(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (Downloader.getInstance(ve.ic()).isDownloading(intExtra) && (downloadInfo = Downloader.getInstance(ve.ic()).getDownloadInfo(intExtra)) != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - this.tt > this.ve) {
                tt(notificationManager, intExtra, notification);
                downloadInfo.setLastNotifyProgressTime();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                tt(notificationManager, intExtra);
                return;
            }
            return;
        }
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
            try {
                if (a.c(contextIc, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) contextIc.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(n.c)) {
                        arrayList.add(n.c);
                    }
                    arrayList.add("mime_type_plg");
                    Downloader.getInstance(contextIc).restartAllFailedDownloadTasks(arrayList);
                    Downloader.getInstance(contextIc).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                    return;
                }
                return;
            } catch (Exception e) {
                m.c(e);
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                Downloader.getInstance(ve.ic()).pauseAll();
            } catch (Exception e2) {
                m.c(e2);
            }
        }
    }

    public void c(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        tt();
        if (this.uj == null) {
            return;
        }
        this.uj.c(new Runnable() { // from class: com.byazt.l.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.tt(intent);
            }
        });
    }

    private void c(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.n) {
            int iIndexOfKey = this.n.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.n.size()) {
                this.n.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = this.ve - (System.currentTimeMillis() - this.c);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            this.tt = jCurrentTimeMillis2;
            this.c = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                tt(notificationManager, i, notification);
            } else if (this.uj != null) {
                synchronized (this.n) {
                    this.n.put(i, notification);
                }
                this.uj.c(new Runnable() { // from class: com.byazt.l.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.n) {
            notification = this.n.get(i);
            this.n.remove(i);
        }
        if (notification != null) {
            tt(notificationManager, i, notification);
        }
    }

    private void tt(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.c < jCurrentTimeMillis) {
                this.c = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void tt(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }
}
