package com.byazt.n;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.byazt.zz.da;
import com.byazt.zz.ve;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 46, 13})
public class tt {
    public static final Object n = new Object();
    public static volatile tt ve;
    public final long c = 1000;
    public final Map<Integer, Long> tt = new HashMap();
    public final Set<String> uj = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<c> f28804a = new SparseArray<>();

    private tt() {
    }

    public static tt c() {
        if (ve == null) {
            synchronized (tt.class) {
                if (ve == null) {
                    ve = new tt();
                }
            }
        }
        return ve;
    }

    public static boolean tt(int i) {
        return i == 1 || i == 3;
    }

    public static boolean ve(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && tt(downloadInfo.getNotificationVisibility());
    }

    public void a(int i) {
        uj(i);
        if (i != 0) {
            c().ve(i);
        }
    }

    public c n(int i) {
        c cVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f28804a) {
            cVar = this.f28804a.get(i);
        }
        return cVar;
    }

    public void tt(DownloadInfo downloadInfo) {
        if (ve(downloadInfo)) {
            a(downloadInfo.getId());
        }
    }

    public c uj(int i) {
        c cVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f28804a) {
            cVar = this.f28804a.get(i);
            if (cVar != null) {
                this.f28804a.remove(i);
                com.byazt.x.c.c("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return cVar;
    }

    public void ve(int i) {
        Context contextIc = ve.ic();
        if (contextIc == null || i == 0) {
            return;
        }
        Intent intent = new Intent(contextIc, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.byazt.k.c.ve().tt("enable_target_34") > 0) {
                com.byazt.l.c.c().c(intent);
            } else {
                contextIc.startService(intent);
            }
        } catch (Throwable th) {
            m.c(th);
            if (com.byazt.k.c.ve().tt("enable_target_34") > 0) {
                com.byazt.l.c.c().c(intent);
            }
        }
    }

    public SparseArray<c> tt() {
        SparseArray<c> sparseArray;
        synchronized (this.f28804a) {
            sparseArray = this.f28804a;
        }
        return sparseArray;
    }

    public void c(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(ve.ic()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        c(downloadInfo);
        tt(downloadInfo);
    }

    public void c(DownloadInfo downloadInfo) {
        da daVarZm = ve.zm();
        if (daVarZm != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                daVarZm.c(downloadInfo);
            } catch (SQLiteException e) {
                m.c(e);
            }
        }
    }

    public void c(int i, int i2, Notification notification) {
        Context contextIc = ve.ic();
        if (contextIc == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.tt) {
                Long l = this.tt.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.tt.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(contextIc, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.byazt.k.c.ve().tt("enable_target_34") > 0) {
                com.byazt.l.c.c().c(intent);
            } else {
                contextIc.startService(intent);
            }
        } catch (Throwable th) {
            m.c(th);
            if (com.byazt.k.c.ve().tt("enable_target_34") > 0) {
                com.byazt.l.c.c().c(intent);
            }
        }
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (this.f28804a) {
            this.f28804a.put(cVar.c(), cVar);
        }
    }
}
