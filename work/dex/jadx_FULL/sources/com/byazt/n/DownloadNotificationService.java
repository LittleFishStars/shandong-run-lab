package com.byazt.n;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ev.n;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.u.sp;
import com.byazt.w.a;
import com.byazt.zz.Downloader;
import com.byazt.zz.u;
import com.byazt.zz.uj;
import com.byazt.zz.ve;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 46, 948})
public class DownloadNotificationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f28802a = 0;
    public static final String c = "DownloadNotificationService";
    public static long i = 900;
    public static boolean n = false;
    public static volatile long sp = 0;
    public static int tt = -1;
    public static boolean uj = true;
    public static int ve = -1;
    public static boolean x;
    public sp da;
    public final SparseArray<Notification> sl = new SparseArray<>(2);

    private void uj() {
        if (this.da == null) {
            sp spVar = new sp("DownloaderNotifyThread");
            this.da = spVar;
            spVar.c();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        uj();
        ve.c(this);
        com.byazt.k.c cVarVe = com.byazt.k.c.ve();
        int iC = cVarVe.c("download_service_foreground", 0);
        if ((iC == 1 || iC == 3) && tt == -1) {
            tt = 0;
        }
        if ((iC == 2 || iC == 3) && ve == -1) {
            ve = 0;
        }
        n = cVarVe.tt("non_going_notification_foreground", false);
        x = cVarVe.tt("notify_too_fast", false);
        long jC = cVarVe.c("notification_time_window", 900L);
        i = jC;
        if (jC < 0 || jC > 1200) {
            i = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        sp spVar = this.da;
        if (spVar != null) {
            try {
                spVar.tt();
            } catch (Throwable unused) {
            }
            this.da = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        c(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(NotificationManager notificationManager, int i2, Notification notification) {
        if (c(i2, notification)) {
            try {
                boolean z = false;
                boolean z2 = uj.c().c(i2) == 1 && !a.ve();
                if ((!z2 && tt == 0) || (z2 && ve == 0)) {
                    z = true;
                }
                if (z) {
                    u uVarVe = uj.c().ve(i2);
                    if (uVarVe.sp() && !uVarVe.tt()) {
                        com.byazt.x.c.ve(c, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                        if (z2) {
                            ve = i2;
                        } else {
                            tt = i2;
                        }
                        uVarVe.c(i2, notification);
                    } else {
                        com.byazt.x.c.ve(c, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z2)));
                    }
                }
            } catch (Throwable th) {
                m.c(th);
            }
        } else if ((tt == i2 || ve == i2) && n && (notification.flags & 2) == 0) {
            tt(notificationManager, i2);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (f28802a < jCurrentTimeMillis) {
                f28802a = jCurrentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable unused) {
        }
    }

    private void c(final Intent intent) {
        sp spVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (spVar = this.da) == null) {
            return;
        }
        spVar.c(new Runnable() { // from class: com.byazt.n.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.tt(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e) {
                                m.c(e);
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (a.c((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(n.c)) {
                                arrayList.add(n.c);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        m.c(e2);
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.x) {
                            DownloadNotificationService.this.c(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.tt(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.x) {
                        DownloadNotificationService.this.c(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.da != null) {
                            DownloadNotificationService.this.da.c(new Runnable() { // from class: com.byazt.n.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.tt(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(ve.ic()).isDownloading(intExtra)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(ve.ic()).getDownloadInfo(intExtra);
                    if (!DownloadNotificationService.x) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.tt(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.sp <= DownloadNotificationService.i) {
                        return;
                    }
                    DownloadNotificationService.this.tt(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final NotificationManager notificationManager, final int i2, Notification notification) {
        synchronized (this.sl) {
            int iIndexOfKey = this.sl.indexOfKey(i2);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.sl.size()) {
                this.sl.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = i - (System.currentTimeMillis() - f28802a);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            sp = jCurrentTimeMillis2;
            f28802a = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                tt(notificationManager, i2, notification);
            } else if (this.da != null) {
                synchronized (this.sl) {
                    this.sl.put(i2, notification);
                }
                this.da.c(new Runnable() { // from class: com.byazt.n.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.c(notificationManager, i2);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.sl) {
            notification = this.sl.get(i2);
            this.sl.remove(i2);
        }
        if (notification != null) {
            tt(notificationManager, i2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(NotificationManager notificationManager, int i2) {
        boolean z;
        c cVarValueAt;
        int iC;
        int i3 = tt;
        if (i3 != i2 && ve != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i3 == i2) {
            tt = 0;
            z = false;
        } else {
            ve = 0;
            z = true;
        }
        try {
            u uVarVe = uj.c().ve(i2);
            if (!uVarVe.tt()) {
                uj = false;
                com.byazt.x.c.uj(c, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
            }
            com.byazt.x.c.ve(c, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
            uVarVe.c(false, true);
        } catch (Throwable th) {
            m.c(th);
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (uj) {
            try {
                SparseArray<c> sparseArrayTt = tt.c().tt();
                if (sparseArrayTt == null) {
                    cVarValueAt = null;
                    break;
                }
                int size = sparseArrayTt.size() - 1;
                while (true) {
                    if (size < 0) {
                        cVarValueAt = null;
                        break;
                    }
                    cVarValueAt = sparseArrayTt.valueAt(size);
                    if (cVarValueAt != null && (iC = cVarValueAt.c()) != i2 && iC != tt && iC != ve && cVarValueAt.x()) {
                        if ((uj.c().c(cVarValueAt.c()) == 1 && !a.ve()) == z) {
                            break;
                        }
                    }
                    size--;
                }
                if (cVarValueAt != null) {
                    int iC2 = cVarValueAt.c();
                    try {
                        notificationManager.cancel(iC2);
                    } catch (Throwable th2) {
                        m.c(th2);
                    }
                    if (Downloader.getInstance(this).getStatus(iC2) != 1) {
                        z2 = false;
                    }
                    com.byazt.x.c.ve(c, "doCancel, updateNotification id = ".concat(String.valueOf(iC2)));
                    cVarValueAt.c((BaseException) null, z2);
                }
            } catch (Throwable th3) {
                m.c(th3);
            }
        }
    }

    private boolean c(int i2, Notification notification) {
        int i3;
        int i4;
        if (!uj || (i3 = tt) == i2 || (i4 = ve) == i2) {
            return false;
        }
        if (i3 == 0 || i4 == 0) {
            return ((n && (notification.flags & 2) == 0) || TextUtils.isEmpty(notification.getChannelId())) ? false : true;
        }
        return false;
    }
}
