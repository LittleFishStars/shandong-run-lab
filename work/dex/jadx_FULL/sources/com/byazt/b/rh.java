package com.byazt.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 115})
public class rh implements Handler.Callback, com.byazt.g.c.InterfaceC0409c {
    public static volatile rh c;
    public static tt i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28307a;
    public final boolean n;
    public ConnectivityManager x;
    public final Handler ve = new Handler(Looper.getMainLooper(), this);
    public final SparseArray<c> uj = new SparseArray<>();
    public int sp = 0;
    public final Context tt = com.byazt.zz.ve.ic();

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 739})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f28308a;
        public final int c;
        public boolean da;
        public int i;
        public final int n;
        public long sl;
        public final int[] sp;
        public boolean t;
        public final int tt;
        public final int uj;
        public final int ve;
        public int x;

        public c(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.c = i;
            this.tt = i2;
            this.ve = i3;
            this.uj = i4;
            this.n = i5;
            this.f28308a = z;
            this.sp = iArr;
            this.x = i4;
        }

        public int uj() {
            return this.x;
        }

        public void ve() {
            this.x = this.uj;
        }

        public boolean c(long j, int i, int i2, boolean z) {
            if (!this.t) {
                com.byazt.x.c.ve("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.tt < i || this.i >= this.ve) {
                return false;
            }
            if (!this.da || i2 == 2) {
                return z || j - this.sl >= ((long) this.uj);
            }
            return false;
        }

        public synchronized void tt() {
            this.i++;
        }

        public synchronized void c() {
            this.x += this.n;
        }

        public synchronized void c(long j) {
            this.sl = j;
        }
    }

    public interface tt {
        void c(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private rh() {
        a();
        this.n = com.byazt.w.a.ve();
        com.byazt.g.c.c().c(this);
    }

    private void a() {
        if (com.byazt.k.c.ve().c("use_network_callback", 0) != 1) {
            return;
        }
        com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.b.rh.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (rh.this.tt != null) {
                        rh rhVar = rh.this;
                        rhVar.x = (ConnectivityManager) rhVar.tt.getApplicationContext().getSystemService("connectivity");
                        rh.this.x.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.byazt.b.rh.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.byazt.x.c.tt("RetryScheduler", "network onAvailable: ");
                                rh.this.c(1, true);
                            }
                        });
                    }
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sp() {
        try {
            if (this.x == null) {
                this.x = (ConnectivityManager) this.tt.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.x.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            tt(message.arg1, message.arg2 == 1);
        } else {
            com.byazt.x.c.ve("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            c(message.what);
        }
        return true;
    }

    private void tt(final int i2, final boolean z) {
        com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.b.rh.2
            @Override // java.lang.Runnable
            public void run() {
                int iSp;
                try {
                    if (rh.this.sp > 0 && (iSp = rh.this.sp()) != 0) {
                        com.byazt.x.c.ve("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + rh.this.sp);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (rh.this.uj) {
                            for (int i3 = 0; i3 < rh.this.uj.size(); i3++) {
                                c cVar = (c) rh.this.uj.valueAt(i3);
                                if (cVar != null && cVar.c(jCurrentTimeMillis, i2, iSp, z)) {
                                    if (z) {
                                        cVar.ve();
                                    }
                                    arrayList.add(cVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                rh.this.c(((c) it.next()).c, iSp, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private c uj(int i2) {
        int[] iArrC;
        int i3;
        int i4;
        boolean z;
        com.byazt.k.c cVarC = com.byazt.k.c.c(i2);
        boolean z2 = false;
        int iC = cVarC.c("retry_schedule", 0);
        JSONObject jSONObjectUj = cVarC.uj("retry_schedule_config");
        int i5 = 60;
        if (jSONObjectUj != null) {
            int iOptInt = jSONObjectUj.optInt("max_count", 60);
            int iOptInt2 = jSONObjectUj.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectUj.optInt("interval_sec_acceleration", 60);
            if (i != null && jSONObjectUj.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrC = c(jSONObjectUj.optString("allow_error_code"));
            i3 = iOptInt3;
            z = z2;
            i4 = iOptInt;
            i5 = iOptInt2;
        } else {
            iArrC = null;
            i3 = 60;
            i4 = 60;
            z = false;
        }
        return new c(i2, iC, i4, i5 * 1000, i3 * 1000, z, iArrC);
    }

    private void ve(int i2) {
        synchronized (this.uj) {
            this.uj.remove(i2);
        }
    }

    public void n() {
        c(5, false);
    }

    private c tt(int i2) {
        c cVarUj = this.uj.get(i2);
        if (cVarUj == null) {
            synchronized (this.uj) {
                cVarUj = this.uj.get(i2);
                if (cVarUj == null) {
                    cVarUj = uj(i2);
                }
                this.uj.put(i2, cVarUj);
            }
        }
        return cVarUj;
    }

    public static rh c() {
        if (c == null) {
            synchronized (rh.class) {
                if (c == null) {
                    c = new rh();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.g.c.InterfaceC0409c
    public void ve() {
        c(3, false);
    }

    @Override // com.byazt.g.c.InterfaceC0409c
    public void tt() {
        c(4, false);
    }

    public static void c(tt ttVar) {
        i = ttVar;
    }

    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        c(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), sp());
    }

    public void uj() {
        c(2, true);
    }

    private void c(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        c cVarTt = tt(downloadInfo.getId());
        if (cVarTt.i > cVarTt.ve) {
            com.byazt.x.c.uj("RetryScheduler", "tryStartScheduleRetry, id = " + cVarTt.c + ", mRetryCount = " + cVarTt.i + ", maxCount = " + cVarTt.ve);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.byazt.w.a.x(failedException) && !com.byazt.w.a.i(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!c(cVarTt, errorCode)) {
                return;
            }
            com.byazt.x.c.ve("RetryScheduler", "allow error code, id = " + cVarTt.c + ", error code = " + errorCode);
        }
        cVarTt.da = z;
        synchronized (this.uj) {
            if (!cVarTt.t) {
                cVarTt.t = true;
                this.sp++;
            }
        }
        int iUj = cVarTt.uj();
        com.byazt.x.c.ve("RetryScheduler", "tryStartScheduleRetry: id = " + cVarTt.c + ", delayTimeMills = " + iUj + ", mWaitingRetryTasks = " + this.sp);
        if (!cVarTt.f28308a) {
            if (z) {
                return;
            }
            this.ve.removeMessages(downloadInfo.getId());
            this.ve.sendEmptyMessageDelayed(downloadInfo.getId(), iUj);
            return;
        }
        if (i2 == 0) {
            cVarTt.ve();
        }
        tt ttVar = i;
        if (ttVar != null) {
            ttVar.c(downloadInfo, iUj, z, i2);
        }
        if (this.n) {
            cVarTt.c(System.currentTimeMillis());
            cVarTt.tt();
            cVarTt.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2, boolean z) {
        if (this.sp <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.f28307a < 10000) {
                    return;
                }
            }
            this.f28307a = jCurrentTimeMillis;
            com.byazt.x.c.ve("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + "]");
            if (z) {
                this.ve.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i2;
            messageObtain.arg2 = z ? 1 : 0;
            this.ve.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    public void c(final int i2) {
        com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.b.rh.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    rh rhVar = rh.this;
                    rhVar.c(i2, rhVar.sp(), true);
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2, int i3, boolean z) {
        com.byazt.zz.rh reserveWifiStatusListener;
        boolean zC;
        Context context = this.tt;
        if (context == null) {
            return;
        }
        synchronized (this.uj) {
            c cVar = this.uj.get(i2);
            if (cVar == null) {
                return;
            }
            boolean z2 = true;
            if (cVar.t) {
                cVar.t = false;
                int i4 = this.sp - 1;
                this.sp = i4;
                if (i4 < 0) {
                    this.sp = 0;
                }
            }
            com.byazt.x.c.ve("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + cVar.i + ", mWaitingRetryTasksCount = " + this.sp);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                ve(i2);
                return;
            }
            com.byazt.x.c.n("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i2)));
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.byazt.zz.ve.ic()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.c(downloadInfo, 4, 3);
                    }
                    com.byazt.zz.t tVarGr = com.byazt.zz.ve.gr();
                    if (tVarGr != null) {
                        tVarGr.c(Collections.singletonList(downloadInfo), 3);
                    }
                    ve(i2);
                    return;
                }
                if (realStatus != -1) {
                    return;
                }
                if (i3 != 0) {
                    zC = true;
                } else if (!cVar.f28308a) {
                    return;
                } else {
                    zC = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (zC && com.byazt.w.a.x(failedException)) {
                    zC = c(downloadInfo, failedException);
                }
                cVar.tt();
                if (zC) {
                    com.byazt.x.c.ve("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + cVar.c);
                    cVar.c(System.currentTimeMillis());
                    if (z) {
                        cVar.c();
                    }
                    downloadInfo.setRetryScheduleCount(cVar.i);
                    if (downloadInfo.getStatus() == -1) {
                        Downloader.getInstance(context).restart(downloadInfo.getId());
                        return;
                    }
                    return;
                }
                if (z) {
                    cVar.c();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z2 = false;
                }
                c(downloadInfo, z2, i3);
                return;
            }
            ve(i2);
        }
    }

    private boolean c(c cVar, int i2) {
        int[] iArr = cVar.sp;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                iArr[i2] = Integer.parseInt(strArrSplit[i2]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean c(DownloadInfo downloadInfo, BaseException baseException) {
        long jUj;
        long totalBytes;
        try {
            jUj = com.byazt.w.a.uj(downloadInfo.getTempPath());
        } catch (BaseException e) {
            com.byazt.nr.m.c(e);
            jUj = 0;
        }
        if (baseException instanceof com.byazt.m.uj) {
            totalBytes = ((com.byazt.m.uj) baseException).tt();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jUj < totalBytes) {
            com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
            if (cVarC.c("space_fill_part_download", 0) == 1) {
                if (jUj > 0) {
                    int iC = cVarC.c("space_fill_min_keep_mb", 100);
                    if (iC > 0) {
                        long j = jUj - (((long) iC) * 1048576);
                        com.byazt.x.c.ve("RetryScheduler", "retry schedule: available = " + com.byazt.w.a.c(jUj) + "MB, minKeep = " + iC + "MB, canDownload = " + com.byazt.w.a.c(j) + "MB");
                        if (j <= 0) {
                            com.byazt.x.c.uj("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (cVarC.c("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
