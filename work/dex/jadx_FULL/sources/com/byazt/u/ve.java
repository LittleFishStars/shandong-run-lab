package com.byazt.u;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.c.IDownloadInterceptor;
import com.byazt.c.gr;
import com.byazt.c.gu;
import com.byazt.c.nu;
import com.byazt.c.rh;
import com.byazt.h.sl;
import com.byazt.h.yp;
import com.byazt.hs.i;
import com.byazt.hs.t;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.byazt.zz.da;
import com.byazt.zz.my;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 67, 54})
public class ve implements a, Runnable {
    public static final String c = "ve";
    public long cu;
    public boolean da;
    public String eo;
    public i gr;
    public final com.byazt.zz.sp gt;
    public volatile BaseException gu;
    public boolean i;
    public DownloadInfo m;
    public com.byazt.zz.sp my;
    public AtomicInteger n;
    public com.byazt.zz.x nu;
    public long or;
    public rh p;
    public final com.byazt.k.c qp;
    public final com.byazt.zz.a qy;
    public final com.byazt.zz.x rh;
    public my rl;
    public boolean sl;
    public volatile com.byazt.zz.n sp;
    public boolean t;
    public Future tt;
    public final AtomicBoolean u;
    public final DownloadTask ve;
    public boolean x;
    public gu yv;
    public final da z;
    public com.byazt.hs.sp zm;
    public volatile boolean uj = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<tt> f29082a = new ArrayList<>();
    public volatile com.byazt.ev.x yp = com.byazt.ev.x.RUN_STATUS_NONE;
    public volatile int md = 5;
    public boolean h = false;
    public boolean d = false;
    public boolean zb = false;
    public int nb = 0;
    public volatile sl pf = null;

    public ve(DownloadTask downloadTask, Handler handler) {
        this.ve = downloadTask;
        if (downloadTask != null) {
            this.m = downloadTask.getDownloadInfo();
            this.nu = downloadTask.getChunkStrategy();
            this.my = downloadTask.getChunkAdjustCalculator();
            this.yv = downloadTask.getForbiddenHandler();
            this.p = downloadTask.getDiskSpaceHandler();
            this.rl = c(downloadTask);
            this.qp = com.byazt.k.c.c(this.m.getId());
        } else {
            this.qp = com.byazt.k.c.ve();
        }
        x();
        this.z = com.byazt.zz.ve.zm();
        this.rh = com.byazt.zz.ve.nb();
        this.gt = com.byazt.zz.ve.bx();
        this.qy = new com.byazt.zz.a(downloadTask, handler);
        this.u = new AtomicBoolean(true);
    }

    private void cu() {
        com.byazt.x.c.uj(c, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.z.uj(this.m.getId());
            this.z.u(this.m.getId());
            com.byazt.w.a.c(this.m);
            this.i = false;
            this.m.resetDataForEtagEndure("");
            this.z.c(this.m);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void d() throws BaseException {
        long jUj;
        int iC;
        try {
            jUj = com.byazt.w.a.uj(this.m.getTempPath());
        } catch (BaseException unused) {
            jUj = 0;
        }
        String str = c;
        com.byazt.x.c.ve(str, "checkSpaceOverflowInProgress: available = " + com.byazt.w.a.c(jUj) + "MB");
        if (jUj > 0) {
            long totalBytes = this.m.getTotalBytes() - this.m.getCurBytes();
            if (jUj < totalBytes && (iC = com.byazt.k.c.c(this.m.getId()).c("space_fill_min_keep_mb", 100)) > 0) {
                long j = jUj - (((long) iC) * 1048576);
                com.byazt.x.c.ve(str, "checkSpaceOverflowInProgress: minKeep  = " + iC + "MB, canDownload = " + com.byazt.w.a.c(j) + "MB");
                if (j > 0) {
                    this.or = this.m.getCurBytes() + j + 1048576;
                    return;
                } else {
                    this.or = 0L;
                    throw new com.byazt.m.uj(jUj, totalBytes);
                }
            }
        }
        this.or = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f8 A[Catch: SQLiteException -> 0x0100, TRY_LEAVE, TryCatch #7 {SQLiteException -> 0x0100, blocks: (B:80:0x00f0, B:82:0x00f8), top: B:91:0x00f0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00ee: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:82:0x00f8, block:B:79:0x00ee */
    private void da() throws com.byazt.m.c {
        boolean z;
        boolean z2;
        DownloadTask downloadTask;
        boolean z3 = false;
        try {
            try {
                int id = this.m.getId();
                if (this.z != null) {
                    if (com.byazt.w.c.c(2048)) {
                        this.z.n();
                    }
                    DownloadInfo downloadInfoTt = this.z.tt(id);
                    z = true;
                    if (downloadInfoTt != null && !downloadInfoTt.isNewTask()) {
                        String savePath = this.m.getSavePath();
                        String md5 = this.m.getMd5();
                        this.m.copyFromCacheData(downloadInfoTt, true);
                        boolean z4 = com.byazt.w.c.c(4096) && downloadInfoTt != this.m;
                        try {
                            if (savePath.equals(downloadInfoTt.getSavePath()) && com.byazt.w.a.c(downloadInfoTt, false, md5)) {
                                try {
                                    throw new com.byazt.m.c(downloadInfoTt.getName());
                                } catch (com.byazt.m.c e) {
                                    e = e;
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = z4;
                                    downloadTask = this.ve;
                                    if (downloadTask != null && this.m != null) {
                                        com.byazt.zl.c.c(downloadTask.getMonitorDepend(), this.m, new BaseException(1003, com.byazt.w.a.tt(th, "checkTaskCache")), this.m.getStatus());
                                    }
                                    if (z3) {
                                        if (z) {
                                            try {
                                                if (!this.qp.c("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                m.c(e2);
                                                return;
                                            }
                                        }
                                        this.z.c(this.m);
                                    }
                                }
                            } else if (com.byazt.zz.ve.c(downloadInfoTt) != id) {
                                try {
                                    this.z.a(id);
                                } catch (SQLiteException e3) {
                                    m.c(e3);
                                }
                            } else {
                                z = z4;
                            }
                        } catch (com.byazt.m.c e4) {
                            e = e4;
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                        throw e;
                    }
                    this.m.reset();
                } else {
                    z = false;
                }
                try {
                    x();
                    if (z) {
                        try {
                            this.z.c(this.m);
                        } catch (SQLiteException e5) {
                            m.c(e5);
                        }
                    }
                } catch (com.byazt.m.c e6) {
                    throw e6;
                } catch (Throwable th3) {
                    th = th3;
                    boolean z5 = z;
                    z = false;
                    z3 = z5;
                    downloadTask = this.ve;
                    if (downloadTask != null) {
                        com.byazt.zl.c.c(downloadTask.getMonitorDepend(), this.m, new BaseException(1003, com.byazt.w.a.tt(th, "checkTaskCache")), this.m.getStatus());
                    }
                    if (z3) {
                        if (z) {
                            if (!this.qp.c("fix_file_exist_update_download_info")) {
                                return;
                            }
                        }
                        this.z.c(this.m);
                    }
                }
            } catch (Throwable th4) {
                if (0 != 0) {
                    if (z2) {
                        try {
                            if (this.qp.c("fix_file_exist_update_download_info")) {
                                this.z.c(this.m);
                            }
                        } catch (SQLiteException e7) {
                            m.c(e7);
                        }
                    } else {
                        this.z.c(this.m);
                    }
                }
                throw th4;
            }
        } catch (com.byazt.m.c e8) {
            throw e8;
        } catch (Throwable th5) {
            th = th5;
            z = false;
        }
    }

    private void eo() throws com.byazt.m.a {
        if (this.m.isOnlyWifi() && !com.byazt.w.a.c(com.byazt.zz.ve.ic(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.byazt.m.a(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.m.isDownloadWithWifiValid()) {
            throw new com.byazt.m.ve();
        }
        if (!this.m.isPauseReserveWithWifiValid()) {
            throw new com.byazt.m.n();
        }
    }

    private boolean gr() {
        if (this.m.getChunkCount() <= 1) {
            return this.m.getCurBytes() > 0 && this.m.getCurBytes() == this.m.getTotalBytes();
        }
        List<com.byazt.t.tt> listVe = this.z.ve(this.m.getId());
        if (listVe == null || listVe.size() <= 1) {
            return false;
        }
        for (com.byazt.t.tt ttVar : listVe) {
            if (ttVar == null || !ttVar.i()) {
                return false;
            }
        }
        return true;
    }

    private void gt() throws BaseException {
        if (this.sp != null) {
            if (this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED) {
                this.m.setStatus(-4);
                this.sp.ve();
            } else if (this.yp != com.byazt.ev.x.RUN_STATUS_PAUSE) {
                this.sp.uj();
            } else {
                this.m.setStatus(-2);
                this.sp.tt();
            }
        }
    }

    private boolean gu() {
        if (this.yp == com.byazt.ev.x.RUN_STATUS_ERROR) {
            this.qy.c(this.gu);
        } else if (this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED) {
            this.qy.ve();
        } else if (this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE) {
            this.qy.uj();
        } else if (this.yp == com.byazt.ev.x.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.qy.sp();
            } catch (BaseException e) {
                this.qy.c(e);
            }
        } else if (this.yp == com.byazt.ev.x.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.qy.c(this.eo);
            } catch (BaseException e2) {
                this.qy.c(e2);
            }
        } else {
            if (this.yp == com.byazt.ev.x.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.qy.c(this.gu, false);
                return false;
            }
            if (this.yp == com.byazt.ev.x.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.byazt.ev.x xVar = this.yp;
            com.byazt.ev.x xVar2 = com.byazt.ev.x.RUN_STATUS_RETRY_DELAY;
            if (xVar == xVar2 && !gr()) {
                com.byazt.x.c.tt(c, "doTaskStatusHandle retryDelay");
                yv();
                return this.yp == xVar2;
            }
            try {
                if (!zm()) {
                    return false;
                }
                this.qy.a();
                com.byazt.b.rh.c().uj();
            } catch (Throwable th) {
                tt(new BaseException(1008, com.byazt.w.a.tt(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean h() {
        DownloadInfo downloadInfo = this.m;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.i && this.m.getChunkCount() <= 1) || this.m.isChunkDowngradeRetryUsed() || !this.da || this.t) ? false : true;
    }

    private boolean i() {
        int status = this.m.getStatus();
        if (status == 1 || this.m.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        tt(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    private void m() {
        boolean zGu;
        boolean z;
        com.byazt.x.c.tt(c, "endDownloadRunnable::runStatus=" + this.yp);
        boolean z2 = (this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE || this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED) ? false : true;
        try {
            zGu = gu();
            z = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.qy.c((BaseException) e);
            } else {
                this.qy.c(new BaseException(1046, e));
            }
            zGu = true;
            z = true;
        }
        if (!zGu && !z) {
            this.h = true;
            com.byazt.x.c.tt(c, "jump to restart");
            return;
        }
        this.u.set(false);
        if (z2) {
            try {
                com.byazt.b.c cVarD = com.byazt.zz.ve.d();
                if (cVarD != null) {
                    cVarD.c(this);
                }
            } catch (Throwable th) {
                m.c(th);
                gr monitorDepend = this.ve.getMonitorDepend();
                DownloadInfo downloadInfo = this.m;
                BaseException baseException = new BaseException(1014, com.byazt.w.a.tt(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.m;
                com.byazt.zl.c.c(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void md() throws BaseException, com.byazt.m.i {
        com.byazt.b.c cVarD;
        int id = this.m.getId();
        int iC = com.byazt.zz.ve.c(this.m);
        if (this.m.isDownloaded() && !this.m.isExpiredRedownload() && !this.zb) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo downloadInfoTt = this.z.tt(iC);
        if (downloadInfoTt == null || (cVarD = com.byazt.zz.ve.d()) == null || downloadInfoTt.getId() == id || !downloadInfoTt.equalsTask(this.m)) {
            return;
        }
        if (cVarD.c(downloadInfoTt.getId())) {
            this.z.a(id);
            throw new BaseException(1025, "another same task is downloading");
        }
        List<com.byazt.t.tt> listVe = this.z.ve(iC);
        com.byazt.w.a.c(this.m);
        this.z.a(iC);
        if (downloadInfoTt.isBreakpointAvailable()) {
            this.m.copyFromCacheData(downloadInfoTt, false);
            this.z.c(this.m);
            if (listVe != null) {
                for (com.byazt.t.tt ttVar : listVe) {
                    ttVar.tt(id);
                    this.z.c(ttVar);
                }
            }
            throw new com.byazt.m.i("retry task because id generator changed");
        }
    }

    private void my() {
        nu();
        rh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb() {
        com.byazt.b.c cVarD;
        if (qy() || (cVarD = com.byazt.zz.ve.d()) == null) {
            return;
        }
        cVarD.t(this.m.getId());
    }

    private void nu() {
        com.byazt.hs.sp spVar = this.zm;
        if (spVar != null) {
            spVar.ve();
            this.zm = null;
        }
    }

    private void or() {
        long jA = com.byazt.w.a.a(this.m);
        long curBytes = this.m.getCurBytes();
        if (jA != curBytes) {
            com.byazt.x.c.uj(c, "checkTaskCanResume: offset = " + jA + ", curBytes = " + curBytes);
        }
        this.m.setCurBytes(jA);
        boolean z = jA > 0;
        this.i = z;
        if (z || this.zb) {
            return;
        }
        com.byazt.x.c.ve(c, "checkTaskCanResume: deleteAllDownloadFiles");
        this.z.uj(this.m.getId());
        this.z.u(this.m.getId());
        com.byazt.w.a.c(this.m);
    }

    private long p() {
        return this.rl.c(this.m.getCurRetryTimeInTotal(), this.m.getTotalRetryCount());
    }

    private boolean pf() {
        return false;
    }

    private void qp() {
        try {
            for (tt ttVar : (ArrayList) this.f29082a.clone()) {
                if (ttVar != null) {
                    ttVar.tt();
                }
            }
        } catch (Throwable th) {
            com.byazt.x.c.ve(c, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private boolean qy() {
        if (!rl() && this.m.getStatus() != -2) {
            return false;
        }
        if (rl()) {
            return true;
        }
        if (this.m.getStatus() == -2) {
            this.yp = com.byazt.ev.x.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.m.getStatus() != -4) {
            return true;
        }
        this.yp = com.byazt.ev.x.RUN_STATUS_CANCELED;
        return true;
    }

    private void rh() {
        i iVar = this.gr;
        if (iVar != null) {
            iVar.uj();
            this.gr = null;
        }
    }

    private boolean rl() {
        return this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED || this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE;
    }

    private void sl() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.m;
            if (downloadInfo != null && this.cu > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.cu);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.ve.getInterceptor();
            if (interceptor != null && interceptor.intercepte()) {
                this.qy.n();
                return;
            }
        } catch (Throwable th) {
            m.c(th);
        }
        if (!i()) {
            gr monitorDepend = this.ve.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.m;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.m;
            com.byazt.zl.c.c(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            t();
            if (!this.h) {
                return;
            }
            if (this.md > 0) {
                this.md--;
            } else {
                if (this.m.getCurBytes() != this.m.getTotalBytes()) {
                    com.byazt.x.c.tt(c, this.m.getErrorBytesLog());
                    this.qy.c(new com.byazt.m.a(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.m.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.m.getCurBytes() <= 0) {
                    com.byazt.x.c.tt(c, this.m.getErrorBytesLog());
                    this.qy.c(new com.byazt.m.a(1026, "curBytes is 0, bytes invalid retry status is : " + this.m.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.m.getTotalBytes() <= 0) {
                    com.byazt.x.c.tt(c, this.m.getErrorBytesLog());
                    this.qy.c(new com.byazt.m.a(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.m.getByteInvalidRetryStatus()));
                    return;
                }
            }
        }
    }

    private void t() {
        boolean z;
        try {
            this.yp = com.byazt.ev.x.RUN_STATUS_NONE;
            this.m.updateStartDownloadTime();
            this.m.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.m.setFirstSpeedTime(-1L);
            try {
                da();
                z = false;
            } catch (com.byazt.m.c e) {
                com.byazt.x.c.tt(c, "file exist " + e.c());
                this.eo = e.c();
                z = true;
            }
            if (!this.h) {
                this.qy.tt();
            }
            this.h = false;
            if (qy()) {
                m();
                return;
            }
            if (!TextUtils.isEmpty(this.eo) && z) {
                if (this.m.isExpiredRedownload()) {
                    this.zb = com.byazt.w.a.uj(this.m);
                }
                if (!this.zb) {
                    u();
                    m();
                    return;
                }
            }
            while (true) {
                if (qy()) {
                    m();
                    return;
                }
                try {
                    try {
                        try {
                            try {
                                zb();
                                md();
                                eo();
                                List<com.byazt.t.tt> listVe = this.z.ve(this.m.getId());
                                or();
                                if (yp()) {
                                    com.byazt.x.c.ve(c, "downloadSegments return");
                                    my();
                                    m();
                                    return;
                                }
                                String connectionUrl = this.m.getConnectionUrl();
                                if (qy()) {
                                    my();
                                    m();
                                    return;
                                }
                                long jN = this.i ? com.byazt.w.a.n(this.m) : 0L;
                                com.byazt.t.tt ttVarC = c(this.m, jN);
                                List<com.byazt.t.ve> listC = c(ttVarC);
                                com.byazt.w.a.c(listC, this.m);
                                com.byazt.w.a.tt(listC, this.m);
                                this.m.setPreconnectLevel(0);
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                try {
                                    c(connectionUrl, listC, jN);
                                    this.m.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                    if (qy()) {
                                        my();
                                        m();
                                        return;
                                    }
                                    long totalBytes = this.m.getTotalBytes();
                                    c(totalBytes);
                                    int iC = c(totalBytes, listVe);
                                    if (qy()) {
                                        my();
                                        m();
                                        return;
                                    }
                                    if (iC <= 0) {
                                        throw new BaseException(1032, "chunkCount is 0");
                                    }
                                    boolean z2 = iC == 1;
                                    this.x = z2;
                                    if (!z2) {
                                        if (!this.m.isNeedReuseFirstConnection()) {
                                            rh();
                                        }
                                        if (!qy()) {
                                            z();
                                            this.m.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                            if (!this.i) {
                                                c(totalBytes, iC);
                                                break;
                                            } else {
                                                c(iC, listVe);
                                                break;
                                            }
                                        }
                                        my();
                                        m();
                                        return;
                                    }
                                    if (this.gr == null) {
                                        try {
                                            jCurrentTimeMillis2 = System.currentTimeMillis();
                                            c(connectionUrl, listC);
                                            this.m.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                        } catch (Throwable th) {
                                            this.m.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                            throw th;
                                        }
                                    }
                                    if (!qy()) {
                                        this.m.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                        z();
                                        c(ttVarC, connectionUrl, this.gr);
                                        break;
                                    } else {
                                        my();
                                        m();
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    this.m.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                    throw th2;
                                }
                            } catch (com.byazt.m.c unused) {
                                u();
                            }
                        } catch (BaseException e2) {
                            com.byazt.x.c.uj(c, "downloadInner: baseException = " + e2);
                            if (this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE) {
                                break;
                            }
                            if (e2.getErrorCode() != 1025 && e2.getErrorCode() != 1009) {
                                if (!c(e2)) {
                                    tt(e2);
                                    break;
                                }
                                if (com.byazt.w.a.c(e2)) {
                                    cu();
                                }
                                if (c(e2, 0L) == com.byazt.m.x.RETURN) {
                                    my();
                                    m();
                                    return;
                                }
                                my();
                            }
                            this.yp = com.byazt.ev.x.RUN_STATUS_END_RIGHT_NOW;
                            my();
                            m();
                            return;
                        }
                    } catch (Throwable th3) {
                        com.byazt.x.c.uj(c, "downloadInner: throwable =  " + th3);
                        if (this.yp != com.byazt.ev.x.RUN_STATUS_PAUSE) {
                            tt(new BaseException(1045, th3));
                        }
                    }
                } catch (com.byazt.m.i e3) {
                    try {
                        com.byazt.x.c.uj(c, "downloadInner: retry throwable for " + e3.c());
                        if (this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE) {
                            break;
                        }
                        AtomicInteger atomicInteger = this.n;
                        if (atomicInteger != null && atomicInteger.get() > 0) {
                            this.m.updateCurRetryTime(this.n.decrementAndGet());
                            this.m.setStatus(5);
                        } else if (this.n == null) {
                            tt(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.c()));
                            break;
                        } else if (!this.m.trySwitchToNextBackupUrl()) {
                            tt(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.m.getRetryCount()), e3.c())));
                            break;
                        } else {
                            this.m.setStatus(5);
                            this.n.set(this.m.getRetryCount());
                            this.m.updateCurRetryTime(this.n.get());
                        }
                        my();
                    } catch (Throwable th4) {
                        my();
                        throw th4;
                    }
                }
                my();
            }
            my();
            m();
        } catch (Throwable th5) {
            m();
            throw th5;
        }
    }

    private void u() {
        com.byazt.x.c.tt(c, "finishWithFileExist");
        if (com.byazt.k.c.ve().tt("fix_end_for_file_exist_error", true)) {
            if (this.eo.equals(this.m.getName())) {
                this.yp = com.byazt.ev.x.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.yp = com.byazt.ev.x.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.eo.equals(this.m.getTargetFilePath())) {
            this.yp = com.byazt.ev.x.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.yp = com.byazt.ev.x.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private void x() {
        DownloadInfo downloadInfo = this.m;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.m.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.n;
        if (atomicInteger == null) {
            this.n = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean yp() throws BaseException, InterruptedException {
        if (this.m.isExpiredRedownload() || this.m.getChunkCount() != 1 || this.m.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectUj = com.byazt.k.c.c(this.m.getId()).uj("segment_config");
        List<com.byazt.h.i> listYp = this.z.yp(this.m.getId());
        if (this.m.getCurBytes() > 0) {
            if (listYp == null || listYp.isEmpty()) {
                return false;
            }
            if (jSONObjectUj == null) {
                jSONObjectUj = new JSONObject();
            }
        }
        if (jSONObjectUj == null) {
            return false;
        }
        this.pf = new sl(this.m, yp.c(jSONObjectUj), this);
        if (!qy()) {
            return this.pf.c(listYp);
        }
        com.byazt.x.c.ve(c, "downloadSegments: is stopped by user");
        if (this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED) {
            this.pf.c();
        } else {
            this.pf.tt();
        }
        return true;
    }

    private void yv() {
        this.yp = com.byazt.ev.x.RUN_STATUS_NONE;
    }

    private void z() {
        if (com.byazt.k.c.c(this.m.getId()).c("reset_retain_retry_times", 0) != 1 || this.nb >= 3) {
            return;
        }
        this.n.set(this.m.isBackUpUrlUsed() ? this.m.getBackUpUrlRetryCount() : this.m.getRetryCount());
        this.nb++;
    }

    private void zb() throws BaseException {
        if (TextUtils.isEmpty(this.m.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.m.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.m.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.byazt.w.uj.tt(this.m)) {
                throw new BaseException(1031, "download savePath is not a directory:" + this.m.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new BaseException(1031, "download savePath is not directory:path=" + this.m.getSavePath());
        }
        boolean zMkdirs = file.mkdirs();
        if (zMkdirs || file.exists()) {
            return;
        }
        int i = 0;
        if (com.byazt.k.c.c(this.m.getId()).c("opt_mkdir_failed", 0) != 1) {
            throw new BaseException(1030, "download savePath directory can not created:" + this.m.getSavePath());
        }
        while (!zMkdirs) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                zMkdirs = file.mkdirs();
                i = i2;
            } catch (InterruptedException unused) {
            }
        }
        if (zMkdirs || file.exists()) {
            return;
        }
        if (com.byazt.w.a.uj(this.m.getSavePath()) < PlaybackStateCompat.ACTION_PREPARE) {
            throw new BaseException(1006, "download savePath directory can not created:" + this.m.getSavePath());
        }
        throw new BaseException(1030, "download savePath directory can not created:" + this.m.getSavePath());
    }

    private boolean zm() {
        if (this.m.isChunked()) {
            DownloadInfo downloadInfo = this.m;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.byazt.x.c.ve(c, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.m.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.m.getTotalBytes());
        if (this.m.getCurBytes() > 0) {
            if (this.m.isIgnoreDataVerify()) {
                return true;
            }
            if (this.m.getTotalBytes() > 0 && this.m.getCurBytes() == this.m.getTotalBytes()) {
                return true;
            }
        }
        this.m.setByteInvalidRetryStatus(com.byazt.ev.tt.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.m.reset();
        this.z.c(this.m);
        this.z.uj(this.m.getId());
        this.z.u(this.m.getId());
        com.byazt.w.a.c(this.m);
        return false;
    }

    public void a() {
        this.cu = System.currentTimeMillis();
        this.qy.c();
    }

    public int n() {
        DownloadInfo downloadInfo = this.m;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.zz.ve.c(this.ve, 3);
        try {
            com.byazt.hs.tt.c().tt();
            sl();
            com.byazt.hs.tt.c().ve();
            com.byazt.zz.ve.tt(this.ve, 3);
        } catch (Throwable th) {
            com.byazt.hs.tt.c().ve();
            throw th;
        }
    }

    public Future sp() {
        return this.tt;
    }

    public void tt() {
        com.byazt.ev.x xVar = com.byazt.ev.x.RUN_STATUS_CANCELED;
        this.yp = xVar;
        if (this.pf != null) {
            this.pf.c();
        }
        if (this.sp != null) {
            this.sp.ve();
        }
        if (this.pf == null && this.sp == null) {
            my();
            this.yp = xVar;
            m();
        }
        qp();
    }

    public boolean uj() {
        return this.u.get();
    }

    public DownloadTask ve() {
        return this.ve;
    }

    private boolean uj(BaseException baseException) {
        AtomicInteger atomicInteger = this.n;
        boolean z = true;
        if (atomicInteger == null) {
            tt(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.m.trySwitchToNextBackupUrl()) {
                this.n.set(this.m.getBackUpUrlRetryCount());
                this.m.updateCurRetryTime(this.n.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.m.canReplaceHttpForRetry())) {
                    tt(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.n), String.valueOf(this.m.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                this.n.set(this.m.getRetryCount());
                this.m.updateCurRetryTime(this.n.get());
                this.m.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.yp != com.byazt.ev.x.RUN_STATUS_RETRY_DELAY && z) {
            this.m.updateCurRetryTime(this.n.decrementAndGet());
        }
        return false;
    }

    @Override // com.byazt.u.a
    public void ve(BaseException baseException) {
        DownloadInfo downloadInfo = this.m;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        c(baseException, false);
    }

    public void c() {
        com.byazt.ev.x xVar = com.byazt.ev.x.RUN_STATUS_PAUSE;
        this.yp = xVar;
        if (this.pf != null) {
            this.pf.tt();
        }
        if (this.sp != null) {
            this.sp.tt();
        }
        if (this.pf == null && this.sp == null) {
            my();
            this.yp = xVar;
            m();
        }
        try {
            for (tt ttVar : (ArrayList) this.f29082a.clone()) {
                if (ttVar != null) {
                    ttVar.c();
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void tt(String str, List<com.byazt.t.ve> list, long j) throws BaseException, com.byazt.m.i {
        com.byazt.no.ve veVarC;
        boolean z = true;
        if (this.m.getChunkCount() == 1 && (veVarC = com.byazt.no.c.c().c(str, list)) != null) {
            this.zm = veVarC;
            this.m.setPreconnectLevel(1);
        }
        if (this.zm == null && !this.d && this.m.isHeadConnectionAvailable()) {
            try {
                int iTt = this.qp.tt("net_lib_strategy");
                if (this.qp.c("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.zm = com.byazt.zz.ve.c(str, list, iTt, z, this.m);
            } catch (Throwable th) {
                this.m.setHeadConnectionException(com.byazt.w.a.da(th));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    private int c(long j, List<com.byazt.t.tt> list) {
        int iC;
        int iC2;
        if (h()) {
            if (!this.i) {
                com.byazt.zz.x xVar = this.nu;
                if (xVar != null) {
                    iC2 = xVar.c(j);
                } else {
                    iC2 = this.rh.c(j);
                }
                t tVarTt = com.byazt.hs.sl.c().tt();
                com.byazt.x.c.tt(c, String.format("NetworkQuality is : %s", tVarTt.name()));
                this.m.setNetworkQuality(tVarTt.name());
                com.byazt.zz.sp spVar = this.my;
                if (spVar != null) {
                    iC = spVar.c(iC2, tVarTt);
                } else {
                    iC = this.gt.c(iC2, tVarTt);
                }
            } else if (list != null) {
                iC = list.size();
            } else {
                iC = this.m.getChunkCount();
            }
            if (iC <= 0) {
                iC = 1;
            }
        } else {
            iC = 1;
        }
        if (com.byazt.x.c.c()) {
            com.byazt.x.c.tt(c, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(iC), this.m.getName(), String.valueOf(j)));
        }
        return iC;
    }

    @Override // com.byazt.u.a
    public boolean tt(long j) throws BaseException {
        if (this.or > 0 && this.m.getCurBytes() > this.or) {
            d();
        }
        return this.qy.c(j);
    }

    @Override // com.byazt.u.a
    public void tt(BaseException baseException) {
        com.byazt.x.c.tt(c, "onError:" + baseException.getMessage());
        this.yp = com.byazt.ev.x.RUN_STATUS_ERROR;
        this.gu = baseException;
        qp();
    }

    private void c(String str, List<com.byazt.t.ve> list, long j) throws BaseException, com.byazt.m.i {
        tt(str, list, j);
        com.byazt.hs.sp spVar = this.zm;
        if (spVar != null) {
            try {
                c(str, spVar, j);
            } catch (Throwable unused) {
                this.d = true;
            }
        }
        if (this.zm == null || this.d) {
            c(str, list);
            c(str, this.gr, j);
        }
    }

    private void c(String str, List<com.byazt.t.ve> list) throws BaseException, com.byazt.m.i {
        i iVarC;
        if (this.gr != null) {
            return;
        }
        com.byazt.no.uj ujVarTt = this.m.getChunkCount() == 1 ? com.byazt.no.c.c().tt(str, list) : null;
        try {
            if (ujVarTt != null) {
                c(this.gr);
                this.m.setPreconnectLevel(2);
                this.gr = ujVarTt;
            } else {
                try {
                    iVarC = com.byazt.zz.ve.c(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), str, null, list, this.qp.tt("net_lib_strategy"), this.qp.c("monitor_download_connect", 0) > 0, this.m);
                    this.gr = iVarC;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.m.isExpiredRedownload() && com.byazt.w.a.sp(th) && com.byazt.w.a.ve(list)) {
                        com.byazt.x.c.tt(c, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.m.getCacheControl());
                        long jI = com.byazt.w.a.i(this.m.getCacheControl());
                        if (jI <= 0) {
                            jI = com.byazt.k.c.c(this.m.getId()).c("default_304_max_age", 300);
                        }
                        this.m.setCacheExpiredTime(System.currentTimeMillis() + (jI * 1000));
                        throw new com.byazt.m.c(this.eo);
                    }
                    if (com.byazt.w.a.a(th)) {
                        c("", "http code 416");
                    } else if (com.byazt.w.a.n(th)) {
                        c("", "http code 412");
                    } else {
                        com.byazt.w.a.c(th, "CreateFirstConnection");
                    }
                    iVarC = this.gr;
                }
                c(iVarC);
            }
            if (this.gr == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            c(this.gr);
            throw th2;
        }
    }

    public static com.byazt.t.tt c(DownloadInfo downloadInfo, long j) {
        return new com.byazt.t.tt.c(downloadInfo.getId()).c(-1).c(0L).n(j).tt(j).ve(0L).uj(downloadInfo.getTotalBytes() - j).c();
    }

    private List<com.byazt.t.ve> c(com.byazt.t.tt ttVar) {
        List<com.byazt.t.ve> listC = com.byazt.w.a.c(this.m.getExtraHeaders(), this.m.geteTag(), ttVar);
        if (this.m.isExpiredRedownload() && this.zb && this.m.getLastModified() != null) {
            listC.add(new com.byazt.t.ve("if-modified-since", this.m.getLastModified()));
            listC.add(new com.byazt.t.ve("download-tc21-1-15", "download-tc21-1-15"));
            com.byazt.x.c.tt(c, "dcache::add head IF_MODIFIED_SINCE=" + this.m.getLastModified());
        }
        return listC;
    }

    private void c(int i, List<com.byazt.t.tt> list) throws BaseException {
        if (list.size() == i) {
            c(list, this.m.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void c(long j, int i) throws BaseException {
        long j2 = j / ((long) i);
        int id = this.m.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.byazt.t.tt ttVarC = new com.byazt.t.tt.c(id).c(i2).c(j3).n(j3).tt(j3).ve(i2 == i + (-1) ? 0L : (j3 + j2) - 1).c();
            arrayList.add(ttVarC);
            this.z.c(ttVarC);
            j3 += j2;
            i2++;
        }
        this.m.setChunkCount(i);
        this.z.c(id, i);
        c(arrayList, j);
    }

    private void c(List<com.byazt.t.tt> list, long j) throws BaseException {
        long jM;
        for (com.byazt.t.tt ttVar : list) {
            if (ttVar != null) {
                if (ttVar.m() == 0) {
                    jM = j - ttVar.yp();
                } else {
                    jM = (ttVar.m() - ttVar.yp()) + 1;
                }
                if (jM > 0) {
                    ttVar.c(jM);
                    if (this.m.isNeedReuseFirstConnection() && this.gr != null && (!this.m.isHeadConnectionAvailable() || this.d)) {
                        if (ttVar.my() == 0) {
                            this.f29082a.add(new tt(ttVar, this.ve, this.gr, this));
                        } else if (ttVar.my() > 0) {
                            this.f29082a.add(new tt(ttVar, this.ve, this));
                        }
                    } else {
                        this.f29082a.add(new tt(ttVar, this.ve, this));
                    }
                }
            }
        }
        if (com.byazt.w.c.c(64)) {
            ArrayList arrayList = new ArrayList(this.f29082a.size());
            for (tt ttVar2 : this.f29082a) {
                if (this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED) {
                    ttVar2.tt();
                } else if (this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE) {
                    ttVar2.c();
                } else {
                    arrayList.add(ttVar2);
                }
            }
            try {
                List<Future> listUj = com.byazt.b.n.uj(arrayList);
                for (Runnable runnableN = (Runnable) arrayList.remove(0); runnableN != null; runnableN = com.byazt.b.n.n(listUj)) {
                    if (qy()) {
                        return;
                    }
                    try {
                        runnableN.run();
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
                if (listUj == null || listUj.isEmpty()) {
                    return;
                }
                for (Future future : listUj) {
                    if (future != null && !future.isDone()) {
                        future.get();
                    }
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f29082a.size());
        for (tt ttVar3 : this.f29082a) {
            if (this.yp == com.byazt.ev.x.RUN_STATUS_CANCELED) {
                ttVar3.tt();
            } else if (this.yp == com.byazt.ev.x.RUN_STATUS_PAUSE) {
                ttVar3.c();
            } else {
                arrayList2.add(Executors.callable(ttVar3));
            }
        }
        if (qy()) {
            return;
        }
        try {
            com.byazt.b.n.ve(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(1020, e);
        }
    }

    private void c(com.byazt.t.tt ttVar, String str, i iVar) throws BaseException {
        ttVar.c(this.m.getTotalBytes() - ttVar.yp());
        this.m.setChunkCount(1);
        this.z.c(this.m.getId(), 1);
        this.sp = new com.byazt.zz.n(this.m, str, iVar, ttVar, this);
        gt();
    }

    @Override // com.byazt.u.a
    public void c(long j) throws BaseException {
        long j2;
        boolean z;
        long j3;
        String tempPath = this.m.getTempPath();
        String tempName = this.m.getTempName();
        if (com.byazt.w.a.tt(j)) {
            return;
        }
        com.byazt.t.n nVarC = com.byazt.w.a.c(this.m, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long totalBytes = j - length;
            long jUj = com.byazt.w.a.uj(tempPath);
            com.byazt.k.c cVarC = com.byazt.k.c.c(this.m.getId());
            try {
                if (cVarC.c("space_fill_part_download", 0) == 1) {
                    this.or = 0L;
                    if (totalBytes <= 0) {
                        totalBytes = this.m.getTotalBytes() - this.m.getCurBytes();
                    }
                    if (jUj < totalBytes) {
                        String str = c;
                        com.byazt.x.c.uj(str, "checkSpaceOverflow: contentLength = " + com.byazt.w.a.c(j) + "MB, downloaded = " + com.byazt.w.a.c(length) + "MB, required = " + com.byazt.w.a.c(totalBytes) + "MB, available = " + com.byazt.w.a.c(jUj) + "MB");
                        if (jUj > 0) {
                            int iC = cVarC.c("space_fill_min_keep_mb", 100);
                            if (iC > 0) {
                                long j4 = jUj - (((long) iC) * 1048576);
                                com.byazt.x.c.uj(str, "checkSpaceOverflow: minKeep = " + iC + "MB, canDownload = " + com.byazt.w.a.c(j4) + "MB");
                                if (j4 > 0) {
                                    this.or = this.m.getCurBytes() + j4;
                                    j3 = j4;
                                } else {
                                    throw new com.byazt.m.uj(jUj, totalBytes);
                                }
                            } else {
                                j3 = jUj;
                            }
                            if (length < j) {
                                j2 = j3 + length;
                                if (j2 > j) {
                                }
                            }
                            z = true;
                        } else {
                            if (cVarC.c("download_when_space_negative", 0) != 1) {
                                StringBuilder sb = new StringBuilder("availableSpace ");
                                sb.append(jUj == 0 ? "=" : "<");
                                sb.append(" 0");
                                throw new BaseException(1052, sb.toString());
                            }
                            j2 = j;
                            z = false;
                        }
                    }
                    nVarC.tt(j);
                    com.byazt.w.a.c(nVarC);
                }
                if (jUj <= 0) {
                    StringBuilder sb2 = new StringBuilder("availableSpace ");
                    sb2.append(jUj == 0 ? "=" : "<");
                    sb2.append(" 0");
                    throw new BaseException(1052, sb2.toString());
                }
                if (jUj < totalBytes) {
                    throw new com.byazt.m.uj(jUj, totalBytes);
                }
                nVarC.tt(j);
            } catch (Throwable th) {
                com.byazt.x.c.n(c, "checkSpaceOverflow: setLength1 e = " + th + ", mustSetLength = " + z);
                if (j2 < j && j2 > 0 && j2 > length) {
                    try {
                        nVarC.tt(j2);
                    } catch (Throwable th2) {
                        com.byazt.x.c.n(c, "checkSpaceOverflow: setLength2 ex = " + th2 + ", mustSetLength = " + z);
                        if (z) {
                            throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th2);
                        }
                    }
                } else if (z) {
                    throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th);
                }
            }
            j2 = j;
            z = true;
            com.byazt.w.a.c(nVarC);
        } catch (Throwable th3) {
            com.byazt.w.a.c(nVarC);
            throw th3;
        }
    }

    private boolean c(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.sl || this.da)) {
            return (i == 201 || i == 416) && this.m.getCurBytes() > 0;
        }
        return true;
    }

    private void c(String str, String str2) throws com.byazt.m.i {
        this.z.uj(this.m.getId());
        this.z.u(this.m.getId());
        com.byazt.w.a.c(this.m);
        this.i = false;
        this.m.resetDataForEtagEndure(str);
        this.z.c(this.m);
        throw new com.byazt.m.i(str2);
    }

    @Override // com.byazt.u.a
    public void c(String str, com.byazt.hs.sp spVar, long j) throws BaseException, com.byazt.m.i {
        com.byazt.hs.sp spVar2;
        long jTt;
        boolean z;
        if (spVar == null) {
            return;
        }
        try {
            com.byazt.t.uj ujVar = new com.byazt.t.uj(str, spVar);
            int i = ujVar.ve;
            String strUj = ujVar.uj();
            if (TextUtils.isEmpty(this.m.getMimeType()) && !TextUtils.isEmpty(strUj)) {
                this.m.setMimeType(strUj);
            }
            boolean zTt = ujVar.tt();
            this.da = zTt;
            this.m.setSupportPartial(zTt);
            this.sl = ujVar.c();
            String str2 = this.m.geteTag();
            String strVe = ujVar.ve();
            String strA = ujVar.a();
            String strSp = ujVar.sp();
            String str3 = c;
            com.byazt.x.c.tt(str3, "dcache=responseCode=" + i + " last_modified=" + strA + " CACHE_CONTROL=" + strSp + " max-age=" + ujVar.sl() + " isDeleteCacheIfCheckFailed=" + this.m.isDeleteCacheIfCheckFailed());
            StringBuilder sb = new StringBuilder("dcache=firstOffset=");
            sb.append(j);
            sb.append(" cur=");
            sb.append(strA);
            sb.append(" before=");
            sb.append(this.m.getLastModified());
            sb.append(" cur=");
            String str4 = strVe;
            sb.append(ujVar.da());
            sb.append(" before=");
            sb.append(this.m.getTotalBytes());
            com.byazt.x.c.tt(str3, sb.toString());
            if (!TextUtils.isEmpty(strSp)) {
                this.m.setCacheControl(strSp);
                if (ujVar.sl() > 0) {
                    this.m.setCacheExpiredTime(System.currentTimeMillis() + (ujVar.sl() * 1000));
                }
            }
            if (this.m.isExpiredRedownload() && this.zb && !TextUtils.isEmpty(this.eo)) {
                if (i == 304) {
                    z = true;
                } else {
                    z = false;
                    if ((!TextUtils.isEmpty(this.m.getLastModified()) || !this.m.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strA, this.m.getLastModified())) {
                        z = true;
                    }
                }
                if (!z) {
                    com.byazt.w.a.c(this.m);
                } else {
                    com.byazt.x.c.tt(str3, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + strA);
                    throw new com.byazt.m.c(this.eo);
                }
            }
            if (j > 0 && this.m.isExpiredRedownload() && !TextUtils.equals(strA, this.m.getLastModified())) {
                com.byazt.x.c.tt(str3, "dcache cdn file change, so retry");
                c("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strA)) {
                this.m.setLastModified(strA);
            }
            if (c(i, str2, str4)) {
                spVar2 = spVar;
                if (spVar2 instanceof i) {
                    if (!TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        str4 = "";
                    }
                    c(str4, "eTag of server file changed");
                } else {
                    throw new com.byazt.m.tt(1002, i, "");
                }
            } else {
                spVar2 = spVar;
            }
            if (!this.da && !this.sl) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.byazt.m.tt(1004, i, "response code error : " + i);
            }
            if (this.sl && j > 0) {
                if (spVar2 instanceof i) {
                    c("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            String str5 = str4;
            long jX = ujVar.x();
            if (!(spVar2 instanceof i) && jX < 0 && com.byazt.w.uj.c(this.m)) {
                throw new BaseException(1004, "");
            }
            String strC = TextUtils.isEmpty(this.m.getName()) ? com.byazt.w.a.c(spVar2, this.m.getUrl()) : "";
            boolean zI = ujVar.i();
            this.t = zI;
            if (!zI && jX == 0 && !(spVar2 instanceof i)) {
                throw new BaseException(1004, "");
            }
            if (zI) {
                jTt = -1;
            } else {
                String strTt = com.byazt.w.a.tt(spVar2, "Content-Range");
                com.byazt.x.c.ve(str3, "firstConnection: contentRange = " + strTt);
                if (!TextUtils.isEmpty(strTt) && this.qp.tt("fix_get_total_bytes", true)) {
                    jTt = com.byazt.w.a.tt(strTt);
                    com.byazt.x.c.ve(str3, "firstConnection: 1 totalLength = " + jTt);
                } else {
                    long j2 = j + jX;
                    com.byazt.x.c.n(str3, "firstConnection: 2 totalLength = " + j2 + ", contentLength = " + jX);
                    jTt = j2;
                }
            }
            if (!TextUtils.isEmpty(this.m.getTaskKey()) && this.m.getTotalBytes() > 0 && jTt != this.m.getTotalBytes()) {
                if (spVar2 instanceof i) {
                    c("", "file totalLength changed");
                } else {
                    throw new com.byazt.m.tt(1002, i, "");
                }
            }
            if (qy()) {
                return;
            }
            if (this.m.getExpectFileLength() > 0 && com.byazt.k.c.c(this.m.getId()).tt("force_check_file_length") == 1 && this.m.getExpectFileLength() != jTt) {
                throw new BaseException(1070, "expectFileLength = " + this.m.getExpectFileLength() + " , totalLength = " + jTt);
            }
            this.qy.c(jTt, str5, strC);
        } catch (BaseException e) {
            throw e;
        } catch (com.byazt.m.i e2) {
            throw e2;
        } catch (Throwable th) {
            com.byazt.w.a.c(th, "HandleFirstConnection");
        }
    }

    @Override // com.byazt.u.a
    public void c(tt ttVar) {
        if (this.x) {
            return;
        }
        synchronized (this) {
            this.f29082a.remove(ttVar);
        }
    }

    @Override // com.byazt.u.a
    public boolean c(BaseException baseException) {
        if (this.pf != null && com.byazt.w.a.i(baseException) && this.n.get() < this.m.getRetryCount()) {
            return false;
        }
        if (com.byazt.w.a.tt(baseException)) {
            if (this.x && !this.uj) {
                com.byazt.w.a.c(this.m);
                this.uj = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.n;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.m.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.m.canReplaceHttpForRetry()))) && !(baseException instanceof com.byazt.m.a);
    }

    @Override // com.byazt.u.a
    public void c(BaseException baseException, boolean z) {
        com.byazt.x.c.tt(c, "onAllChunkRetryWithReset");
        this.yp = com.byazt.ev.x.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.gu = baseException;
        qp();
        if (z ? uj(baseException) : false) {
            return;
        }
        cu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.m.setForbiddenBackupUrls(list, this.yp == com.byazt.ev.x.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.byazt.b.c cVarD = com.byazt.zz.ve.d();
        if (cVarD != null) {
            cVarD.t(this.m.getId());
        }
    }

    @Override // com.byazt.u.a
    public com.byazt.m.x c(com.byazt.t.tt ttVar, BaseException baseException, long j) {
        if (rl()) {
            return com.byazt.m.x.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.byazt.w.a.x(baseException))) {
            return c(baseException, j);
        }
        this.gu = baseException;
        this.m.increaseCurBytes(-j);
        this.z.c(this.m);
        if (uj(baseException)) {
            return com.byazt.m.x.RETURN;
        }
        com.byazt.zz.a aVar = this.qy;
        com.byazt.ev.x xVar = this.yp;
        com.byazt.ev.x xVar2 = com.byazt.ev.x.RUN_STATUS_RETRY_DELAY;
        aVar.c(ttVar, baseException, xVar == xVar2);
        if (this.yp != xVar2 && this.m.isNeedRetryDelay()) {
            long jP = p();
            if (jP > 0) {
                com.byazt.x.c.ve(c, "onSingleChunkRetry with delay time " + jP);
                try {
                    Thread.sleep(jP);
                } catch (Throwable th) {
                    com.byazt.x.c.uj(c, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.byazt.m.x.CONTINUE;
    }

    @Override // com.byazt.u.a
    public com.byazt.m.x c(BaseException baseException, long j) {
        long jC;
        long totalBytes;
        boolean z;
        this.gu = baseException;
        this.m.increaseCurBytes(-j);
        this.z.c(this.m);
        if (rl()) {
            return com.byazt.m.x.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.yv != null && !this.m.isForbiddenRetryed()) {
                com.byazt.c.tt ttVar = new com.byazt.c.tt() { // from class: com.byazt.u.ve.1
                    @Override // com.byazt.c.tt, com.byazt.c.qy
                    public void c(List<String> list) {
                        super.c(list);
                        ve.this.c(list);
                    }
                };
                boolean zC = this.yv.c(ttVar);
                this.m.setForbiddenRetryed();
                if (zC) {
                    if (!ttVar.c()) {
                        qp();
                        this.qy.x();
                        this.yp = com.byazt.ev.x.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.byazt.m.x.RETURN;
                    }
                    z = true;
                }
            } else if (uj(baseException)) {
                return com.byazt.m.x.RETURN;
            }
            z = false;
        } else if (com.byazt.w.a.x(baseException)) {
            if (this.p == null) {
                tt(baseException);
                return com.byazt.m.x.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            nu nuVar = new nu() { // from class: com.byazt.u.ve.2
                @Override // com.byazt.c.nu
                public void c() {
                    synchronized (ve.this) {
                        atomicBoolean.set(true);
                        ve.this.nb();
                    }
                }
            };
            if (baseException instanceof com.byazt.m.uj) {
                com.byazt.m.uj ujVar = (com.byazt.m.uj) baseException;
                jC = ujVar.c();
                totalBytes = ujVar.tt();
            } else {
                jC = -1;
                totalBytes = this.m.getTotalBytes();
            }
            synchronized (this) {
                if (this.p.c(jC, totalBytes, nuVar)) {
                    if (!com.byazt.k.c.c(this.m.getId()).tt("not_delete_when_clean_space", false)) {
                        zm();
                    }
                    if (!atomicBoolean.get()) {
                        com.byazt.ev.x xVar = this.yp;
                        com.byazt.ev.x xVar2 = com.byazt.ev.x.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (xVar != xVar2) {
                            this.yp = xVar2;
                            qp();
                            this.qy.x();
                        }
                        return com.byazt.m.x.RETURN;
                    }
                    if (uj(baseException)) {
                        return com.byazt.m.x.RETURN;
                    }
                    z = true;
                } else {
                    if (this.yp == com.byazt.ev.x.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.byazt.m.x.RETURN;
                    }
                    tt(baseException);
                    return com.byazt.m.x.RETURN;
                }
            }
        } else {
            if (uj(baseException)) {
                return com.byazt.m.x.RETURN;
            }
            z = false;
        }
        if (!z && pf()) {
            qp();
        }
        com.byazt.zz.a aVar = this.qy;
        com.byazt.ev.x xVar3 = this.yp;
        com.byazt.ev.x xVar4 = com.byazt.ev.x.RUN_STATUS_RETRY_DELAY;
        aVar.c(baseException, xVar3 == xVar4);
        return this.yp == xVar4 ? com.byazt.m.x.RETURN : com.byazt.m.x.CONTINUE;
    }

    @Override // com.byazt.u.a
    public synchronized com.byazt.t.tt c(int i) {
        com.byazt.t.tt ttVarC;
        if (this.m.getChunkCount() < 2) {
            return null;
        }
        List<com.byazt.t.tt> listVe = this.z.ve(this.m.getId());
        if (listVe != null && !listVe.isEmpty()) {
            for (int i2 = 0; i2 < listVe.size(); i2++) {
                com.byazt.t.tt ttVar = listVe.get(i2);
                if (ttVar != null && (ttVarC = c(ttVar, i)) != null) {
                    return ttVarC;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.byazt.u.a
    public void c(com.byazt.hs.sp spVar) {
        boolean z;
        if (spVar != null) {
            try {
                int iTt = spVar.tt();
                this.m.setHttpStatusCode(iTt);
                this.m.setHttpStatusMessage(com.byazt.w.tt.c(iTt));
                z = true;
            } catch (Throwable th) {
                m.c(th);
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.m.setHttpStatusCode(-1);
        this.m.setHttpStatusMessage("");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00db A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x008c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x00e0, please report this as an issue */
    private com.byazt.t.tt c(com.byazt.t.tt ttVar, int i) {
        boolean z;
        int i2;
        com.byazt.t.tt ttVar2;
        com.byazt.t.tt ttVar3 = null;
        if (!ttVar.uj()) {
            return null;
        }
        long jVe = ttVar.ve(true);
        com.byazt.x.c.tt(c, "reuseChunk retainLen:" + jVe + " chunkIndex:" + i);
        if (!ttVar.a() && jVe > com.byazt.ev.n.f28532a && this.m.isNeedReuseChunkRunnable()) {
            List<com.byazt.t.tt> listC = ttVar.c(this.m.getChunkCount(), this.m.getTotalBytes());
            if (listC != null) {
                Iterator<com.byazt.t.tt> it = listC.iterator();
                while (it.hasNext()) {
                    this.z.tt(it.next());
                }
            }
        } else {
            if (!ttVar.a()) {
                z = false;
            }
            if (z && ttVar.a()) {
                for (i2 = 1; i2 < ttVar.sp().size(); i2++) {
                    ttVar2 = ttVar.sp().get(i2);
                    if (ttVar2 != null) {
                        com.byazt.x.c.tt(c, "check can checkUnCompletedChunk -- chunkIndex:" + ttVar2.my() + " currentOffset:" + ttVar2.yp() + "  startOffset:" + ttVar2.t() + " contentLen:" + ttVar2.nu());
                        if (ttVar2.my() >= 0 || (!ttVar2.i() && !ttVar2.ve())) {
                            ttVar3 = ttVar2;
                            break;
                        }
                    }
                }
                if (ttVar3 != null) {
                    long jYp = ttVar.yp();
                    com.byazt.x.c.tt(c, "unComplete chunk " + ttVar.my() + " curOffset:" + jYp + " reuseChunk chunkIndex:" + i + " for subChunk:" + ttVar3.my());
                    this.z.c(ttVar3.sl(), ttVar3.my(), ttVar3.tt(), i);
                    ttVar3.ve(i);
                    ttVar3.c(true);
                }
            }
            return ttVar3;
        }
        z = true;
        if (z) {
            while (i2 < ttVar.sp().size()) {
                ttVar2 = ttVar.sp().get(i2);
                if (ttVar2 != null) {
                    com.byazt.x.c.tt(c, "check can checkUnCompletedChunk -- chunkIndex:" + ttVar2.my() + " currentOffset:" + ttVar2.yp() + "  startOffset:" + ttVar2.t() + " contentLen:" + ttVar2.nu());
                    if (ttVar2.my() >= 0) {
                    }
                    ttVar3 = ttVar2;
                    break;
                }
            }
            if (ttVar3 != null) {
                long jYp2 = ttVar.yp();
                com.byazt.x.c.tt(c, "unComplete chunk " + ttVar.my() + " curOffset:" + jYp2 + " reuseChunk chunkIndex:" + i + " for subChunk:" + ttVar3.my());
                this.z.c(ttVar3.sl(), ttVar3.my(), ttVar3.tt(), i);
                ttVar3.ve(i);
                ttVar3.c(true);
            }
        }
        return ttVar3;
    }

    private my c(DownloadTask downloadTask) {
        my retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.byazt.b.nu(retryDelayTimeArray);
            }
        }
        return com.byazt.zz.ve.sv();
    }

    public void c(Future future) {
        this.tt = future;
    }
}
