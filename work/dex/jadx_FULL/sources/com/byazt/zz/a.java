package com.byazt.zz;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.byazt.c.IDownloadListener;
import com.byazt.c.cu;
import com.byazt.c.gr;
import com.byazt.ev.DownloadStatus;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 34})
public class a {
    public static final String c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadTask f29267a;
    public SparseArray<IDownloadListener> i;
    public com.byazt.c.yp m;
    public final Handler n;
    public gr nu;
    public SparseArray<IDownloadListener> sp;
    public final boolean tt;
    public final da uj;
    public DownloadInfo ve;
    public SparseArray<IDownloadListener> x;
    public int yp;
    public long z;
    public boolean da = false;
    public volatile long sl = 0;
    public final AtomicLong t = new AtomicLong();
    public boolean u = false;

    public a(DownloadTask downloadTask, Handler handler) {
        this.f29267a = downloadTask;
        da();
        this.n = handler;
        this.uj = ve.zm();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.tt = com.byazt.k.c.c(downloadInfo.getId()).c("fix_start_with_file_exist_update_error");
        } else {
            this.tt = false;
        }
    }

    private void da() {
        DownloadTask downloadTask = this.f29267a;
        if (downloadTask != null) {
            this.ve = downloadTask.getDownloadInfo();
            this.sp = this.f29267a.getDownloadListeners(com.byazt.ev.a.MAIN);
            this.i = this.f29267a.getDownloadListeners(com.byazt.ev.a.NOTIFICATION);
            this.x = this.f29267a.getDownloadListeners(com.byazt.ev.a.SUB);
            this.m = this.f29267a.getDepend();
            this.nu = this.f29267a.getMonitorDepend();
        }
    }

    private void sl() {
        ExecutorService executorServiceT = ve.t();
        if (executorServiceT != null) {
            executorServiceT.execute(new Runnable() { // from class: com.byazt.zz.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.uj.i(a.this.ve.getId());
                    a.this.c(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            com.byazt.x.c.tt(c, "saveFileAsTargetName onSuccess");
            try {
                u();
                this.ve.setFirstSuccess(false);
                this.ve.setSuccessByCache(false);
                c(-3, (BaseException) null);
                this.uj.ve(this.ve.getId(), this.ve.getTotalBytes());
                this.uj.uj(this.ve.getId());
                this.uj.u(this.ve.getId());
            } catch (BaseException e) {
                c(e);
            }
        } catch (Throwable th) {
            c(new BaseException(1008, com.byazt.w.a.tt(th, "onCompleted")));
        }
    }

    private void u() throws BaseException {
        List<com.byazt.c.u> downloadCompleteHandlers = this.f29267a.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.ve;
        c(11, (BaseException) null);
        this.uj.c(downloadInfo);
        for (com.byazt.c.u uVar : downloadCompleteHandlers) {
            try {
                if (uVar.tt(downloadInfo)) {
                    uVar.c(downloadInfo);
                    this.uj.c(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void a() {
        this.ve.setFirstDownload(false);
        if (!this.ve.isIgnoreDataVerify() && this.ve.getCurBytes() != this.ve.getTotalBytes()) {
            com.byazt.x.c.tt(c, this.ve.getErrorBytesLog());
            c(new com.byazt.m.a(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.ve.getByteInvalidRetryStatus()));
            return;
        }
        if (this.ve.getCurBytes() <= 0) {
            com.byazt.x.c.tt(c, this.ve.getErrorBytesLog());
            c(new com.byazt.m.a(1026, "curBytes is 0, bytes changed with process : " + this.ve.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.ve.isIgnoreDataVerify() && this.ve.getTotalBytes() <= 0) {
            com.byazt.x.c.tt(c, this.ve.getErrorBytesLog());
            c(new com.byazt.m.a(1044, "TotalBytes is 0, bytes changed with process : " + this.ve.getByteInvalidRetryStatus()));
            return;
        }
        com.byazt.x.c.tt(c, this.ve.getName() + " onCompleted start save file as target name");
        gr monitorDepend = this.nu;
        DownloadTask downloadTask = this.f29267a;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.byazt.w.a.c(this.ve, monitorDepend, new cu() { // from class: com.byazt.zz.a.2
            @Override // com.byazt.c.cu
            public void c() {
                a.this.t();
            }

            @Override // com.byazt.c.cu
            public void c(BaseException baseException) {
                String str = a.c;
                StringBuilder sb = new StringBuilder("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                com.byazt.x.c.tt(str, sb.toString());
                a.this.c(baseException);
            }
        });
    }

    public void n() {
        this.ve.setStatus(-7);
        try {
            this.uj.da(this.ve.getId());
        } catch (SQLiteException e) {
            com.byazt.nr.m.c(e);
        }
        c(-7, (BaseException) null);
    }

    public void sp() throws BaseException {
        if (!this.tt) {
            u();
            com.byazt.x.c.tt(c, "onCompleteForFileExist");
            this.ve.setSuccessByCache(true);
            c(-3, (BaseException) null);
            this.uj.ve(this.ve.getId(), this.ve.getTotalBytes());
            this.uj.uj(this.ve.getId());
            this.uj.u(this.ve.getId());
            return;
        }
        u();
        com.byazt.x.c.tt(c, "onCompleteForFileExist");
        this.ve.setSuccessByCache(true);
        c(-3, (BaseException) null);
        this.uj.ve(this.ve.getId(), this.ve.getTotalBytes());
        this.uj.uj(this.ve.getId());
        this.uj.c(this.ve);
        this.uj.u(this.ve.getId());
    }

    public void uj() {
        this.ve.setStatus(-2);
        try {
            this.uj.uj(this.ve.getId(), this.ve.getCurBytes());
        } catch (SQLiteException e) {
            com.byazt.nr.m.c(e);
        }
        c(-2, (BaseException) null);
    }

    public void x() {
        this.ve.setStatus(8);
        this.ve.setAsyncHandleStatus(com.byazt.ev.c.ASYNC_HANDLE_WAITING);
        com.byazt.b.c cVarD = ve.d();
        if (cVarD != null) {
            cVarD.c(this.ve.getId(), this.f29267a.getHashCodeForSameTask(), 8);
        }
    }

    public void tt() {
        if (this.ve.canSkipStatusHandler()) {
            this.ve.changeSkipStatus();
            return;
        }
        this.uj.sp(this.ve.getId());
        if (this.ve.isFirstDownload()) {
            c(6, (BaseException) null);
        }
        c(2, (BaseException) null);
    }

    public void ve() {
        c(-4, (BaseException) null);
    }

    private BaseException ve(BaseException baseException) {
        Context contextIc;
        if (com.byazt.k.c.c(this.ve.getId()).c("download_failed_check_net", 1) != 1 || !com.byazt.w.a.i(baseException) || (contextIc = ve.ic()) == null || com.byazt.w.a.ve(contextIc)) {
            return baseException;
        }
        return new BaseException(this.ve.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void c() {
        if (this.ve.canSkipStatusHandler()) {
            return;
        }
        this.ve.setStatus(1);
        sl();
    }

    public void c(long j, String str, String str2) {
        this.ve.setTotalBytes(j);
        this.ve.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.ve.getName())) {
            this.ve.setName(str2);
        }
        try {
            this.uj.c(this.ve.getId(), j, str, str2);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        c(3, (BaseException) null);
        this.z = this.ve.getMinByteIntervalForPostToMainThread(j);
        this.yp = this.ve.getMinProgressTimeMsInterval();
        this.da = true;
        com.byazt.b.rh.c().n();
    }

    private void tt(BaseException baseException) {
        Log.getStackTraceString(new Throwable());
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.uj.a(this.ve.getId());
            } catch (SQLiteException e) {
                com.byazt.nr.m.c(e);
            }
        } else {
            try {
                try {
                    this.uj.tt(this.ve.getId(), this.ve.getCurBytes());
                } catch (SQLiteException e2) {
                    com.byazt.nr.m.c(e2);
                }
            } catch (SQLiteException unused) {
                this.uj.a(this.ve.getId());
            }
        }
        BaseException baseExceptionVe = ve(baseException);
        this.ve.setFailedException(baseExceptionVe);
        c(baseExceptionVe instanceof com.byazt.m.n ? -2 : -1, baseExceptionVe);
        if (com.byazt.k.c.c(this.ve.getId()).c("retry_schedule", 0) > 0) {
            com.byazt.b.rh.c().c(this.ve);
        }
    }

    public boolean c(long j) {
        this.t.addAndGet(j);
        this.ve.increaseCurBytes(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return c(jUptimeMillis, tt(jUptimeMillis));
    }

    private boolean tt(long j) {
        boolean z = true;
        if (!this.u) {
            this.u = true;
            return true;
        }
        long j2 = j - this.sl;
        if (this.t.get() < this.z && j2 < this.yp) {
            z = false;
        }
        if (z) {
            this.sl = j;
            this.t.set(0L);
        }
        return z;
    }

    public void c(BaseException baseException, boolean z) {
        this.ve.setFirstDownload(false);
        this.t.set(0L);
        tt(baseException, z);
    }

    public void c(com.byazt.t.tt ttVar, BaseException baseException, boolean z) {
        this.ve.setFirstDownload(false);
        this.t.set(0L);
        this.uj.x(this.ve.getId());
        c(z ? 10 : 9, baseException, true);
    }

    private void tt(BaseException baseException, boolean z) {
        this.uj.x(this.ve.getId());
        c(z ? 7 : 5, baseException);
    }

    public void c(BaseException baseException) {
        this.ve.setFirstDownload(false);
        tt(baseException);
    }

    public void c(String str) throws BaseException {
        com.byazt.x.c.tt(c, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.ve.getName());
        if (this.tt) {
            com.byazt.w.a.c(this.ve, str);
            u();
            this.ve.setSuccessByCache(true);
            c(-3, (BaseException) null);
            this.uj.c(this.ve);
            return;
        }
        this.uj.c(this.ve);
        com.byazt.w.a.c(this.ve, str);
        this.ve.setSuccessByCache(true);
        u();
        c(-3, (BaseException) null);
    }

    private boolean c(long j, boolean z) {
        boolean z2 = false;
        if (this.ve.getCurBytes() == this.ve.getTotalBytes()) {
            try {
                this.uj.c(this.ve.getId(), this.ve.getCurBytes());
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
            return false;
        }
        if (this.da) {
            this.da = false;
            this.ve.setStatus(4);
        }
        if (this.ve.isNeedPostProgress() && z) {
            z2 = true;
        }
        c(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, BaseException baseException) {
        c(i, baseException, true);
    }

    private void c(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.ve.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        da();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.ve.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.ve.updateDownloadTime();
            }
        }
        if (!this.ve.isAddListenerToSameTask()) {
            com.byazt.zl.c.c(this.f29267a, baseException, i);
        }
        if (i == 6) {
            this.ve.setStatus(2);
        } else if (i == -6) {
            this.ve.setStatus(-3);
        } else {
            this.ve.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.ve.getRetryDelayStatus() == com.byazt.ev.sp.DELAY_RETRY_DOWNLOADING) {
                this.ve.setRetryDelayStatus(com.byazt.ev.sp.DELAY_RETRY_DOWNLOADED);
            }
            if (this.ve.getAsyncHandleStatus() == com.byazt.ev.c.ASYNC_HANDLE_DOWNLOADING) {
                this.ve.setAsyncHandleStatus(com.byazt.ev.c.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.ve.getByteInvalidRetryStatus() == com.byazt.ev.tt.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.ve.setByteInvalidRetryStatus(com.byazt.ev.tt.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.byazt.w.ve.c(i, this.x, true, this.ve, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.n != null && (((sparseArray = this.sp) != null && sparseArray.size() > 0) || ((sparseArray2 = this.i) != null && sparseArray2.size() > 0 && (this.ve.canShowNotification() || this.ve.isAutoInstallWithoutNotification())))) {
            this.n.obtainMessage(i, this.ve.getId(), this.f29267a.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.byazt.b.c cVarD = ve.d();
        if (cVarD != null) {
            cVarD.c(this.ve.getId(), this.f29267a.getHashCodeForSameTask(), i);
        }
    }
}
