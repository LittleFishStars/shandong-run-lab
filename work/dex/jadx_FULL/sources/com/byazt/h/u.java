package com.byazt.h;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 67})
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f28599a;
    public com.byazt.w.n bx;
    public volatile i c;
    public boolean cu;
    public int d;
    public String da;
    public int eo;
    public volatile boolean gr;
    public volatile long gt;
    public Future gu;
    public int h;
    public String i;
    public com.byazt.t.uj m;
    public volatile boolean md;
    public volatile long my;
    public volatile long n;
    public boolean nb;
    public int or;
    public Thread p;
    public boolean pf;
    public BaseException qp;
    public volatile long qy;
    public long rh;
    public final a sl;
    public volatile long sp;
    public final ve t;
    public nu tt;
    public final DownloadInfo u;
    public volatile long uj;
    public final int ve;
    public String x;
    public final com.byazt.k.c yp;
    public volatile boolean yv;
    public com.byazt.hs.i z;
    public long zb;
    public volatile boolean zm;
    public final List<i> nu = new ArrayList();
    public volatile long rl = -1;

    public u(DownloadInfo downloadInfo, sl slVar, ve veVar, nu nuVar, int i) {
        this.u = downloadInfo;
        this.sl = slVar;
        this.t = veVar;
        this.yp = com.byazt.k.c.c(downloadInfo.getId());
        this.tt = nuVar;
        this.ve = i;
    }

    private boolean c(i iVar) throws BaseException {
        sl();
        while (true) {
            try {
                tt(iVar);
                uj(iVar);
                i();
                return true;
            } catch (da e) {
                this.qp = e;
                throw e;
            } catch (Throwable th) {
                try {
                    com.byazt.x.c.n("SegmentReader", "download: e = " + th + ", threadIndex = " + this.ve + ", reconnect = " + this.zm + ", closed = " + this.gr);
                    if (this.gr) {
                        i();
                        return false;
                    }
                    if (this.zm) {
                        this.zm = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            com.byazt.nr.m.c(th2);
                        }
                        if (this.yv) {
                            this.yv = false;
                            throw new da(5, "download");
                        }
                    } else {
                        com.byazt.nr.m.c(th);
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                com.byazt.w.a.c((Throwable) th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !c(iVar, e)) {
                            i();
                            return false;
                        }
                    }
                    i();
                } catch (Throwable th3) {
                    i();
                    throw th3;
                }
            }
        }
    }

    private void da() {
        com.byazt.hs.i iVar = this.z;
        if (iVar != null) {
            try {
                com.byazt.x.c.ve("SegmentReader", "closeConnection: thread = " + this.ve);
                iVar.uj();
                iVar.ve();
            } catch (Throwable unused) {
            }
        }
    }

    private void i() {
        this.zb = this.uj;
        this.uj = -1L;
        this.n = -1L;
        this.f28599a = -1L;
        this.sp = -1L;
        da();
    }

    private void sl() {
        this.cu = false;
        t();
    }

    private void t() {
        this.d = this.tt.uj ? this.u.getRetryCount() : this.u.getBackUpUrlRetryCount();
        this.eo = 0;
    }

    private void tt(i iVar) throws BaseException, com.byazt.m.i {
        ve(iVar);
        this.sl.c(this, iVar, this.tt, this.m);
        this.tt.ve();
    }

    private long u() {
        long j = this.my;
        this.my = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0152 */
    /* JADX WARN: Code duplicated, block: B:129:0x0255  */
    /* JADX WARN: Code duplicated, block: B:165:0x02e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:169:0x02f2 A[PHI: r15
      0x02f2: PHI (r15v7 com.byazt.h.c) = (r15v6 com.byazt.h.c), (r15v9 com.byazt.h.c) binds: [B:164:0x02e2, B:211:0x02f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:171:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:174:0x0302  */
    /* JADX WARN: Code duplicated, block: B:176:0x0310  */
    /* JADX WARN: Code duplicated, block: B:180:0x0319  */
    /* JADX WARN: Code duplicated, block: B:198:0x0346  */
    /* JADX WARN: Code duplicated, block: B:201:0x0353  */
    /* JADX WARN: Code duplicated, block: B:207:0x0369  */
    /* JADX WARN: Code duplicated, block: B:232:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0176 A[Catch: all -> 0x0266, BaseException -> 0x0268, TryCatch #22 {BaseException -> 0x0268, all -> 0x0266, blocks: (B:27:0x006e, B:28:0x0072, B:48:0x00d7, B:86:0x0164, B:88:0x016f, B:89:0x0176, B:91:0x017c, B:93:0x0182, B:96:0x018b, B:97:0x018f, B:130:0x0257), top: B:237:0x005d }] */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0153, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void uj(i iVar) throws BaseException {
        long j;
        n nVarUj;
        InputStream inputStreamC;
        c cVarTt;
        c cVar;
        boolean z;
        c cVar2;
        com.byazt.k.c cVar3;
        DownloadInfo downloadInfo;
        String str;
        String str2;
        String str3;
        boolean z2;
        c cVarTt2;
        int i;
        long j2;
        long j3;
        int i2;
        c cVar4;
        c cVar5;
        int i3;
        ve veVar = this.t;
        this.f28599a = System.currentTimeMillis();
        long jN = iVar.n();
        boolean z3 = false;
        try {
            try {
                inputStreamC = this.z.c();
                try {
                    if (inputStreamC == null) {
                        throw new BaseException(1042, new IOException("inputStream is null"));
                    }
                    long jX = this.m.x();
                    if (jX == 0) {
                        throw new com.byazt.m.a(1004, "the content-length is 0, contentLength = ".concat(String.valueOf(jX)));
                    }
                    cVarTt = c(veVar, inputStreamC);
                    try {
                        if (this.zm || this.gr) {
                            throw new m("probe");
                        }
                        this.sl.tt(this, iVar);
                        nVarUj = this.sl.uj(this, iVar);
                        try {
                            long jA = iVar.a();
                            if (jA <= 0) {
                                jA = jX > 0 ? (jX + jN) - 1 : Long.MAX_VALUE;
                            }
                            int i4 = cVarTt.ve;
                            long j4 = i4;
                            j = jN + j4;
                            try {
                                if (j > jA) {
                                    long j5 = jA + 1;
                                    if (j > j5 && (i3 = (int) (j4 - (j - j5))) > 0 && i3 < i4) {
                                        cVarTt.ve = i3;
                                        j = j5;
                                    }
                                    this.rl = j;
                                    nVarUj.tt(cVarTt);
                                    com.byazt.w.a.c(inputStreamC);
                                    try {
                                        c cVarTt3 = veVar.tt();
                                        try {
                                            cVarTt3.ve = -1;
                                            nVarUj.tt(cVarTt3);
                                            cVar5 = null;
                                        } catch (Throwable unused) {
                                            cVar5 = cVarTt3;
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    if (cVar5 != null) {
                                        veVar.c(cVar5);
                                    }
                                    this.sp = System.currentTimeMillis();
                                    if (j > jN) {
                                        com.byazt.zl.c.c(this.yp, this.u, this.x, this.i, this.da, this.gr || this.zm, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                                    }
                                } else {
                                    this.rl = j;
                                    nVarUj.tt(cVarTt);
                                    long jU = jA;
                                    while (true) {
                                        try {
                                            if (this.md) {
                                                synchronized (this) {
                                                    this.md = z3;
                                                    if (this.zm || this.gr) {
                                                        throw new m("loopAndRead");
                                                    }
                                                }
                                                synchronized (this.sl) {
                                                    if (this.my != 0) {
                                                        com.byazt.x.c.ve("SegmentReader", "loopAndRead:  change readEnd = " + jU + ", segmentNewEndOffset = " + this.my + ", segment = " + iVar);
                                                        jU = u();
                                                        if (j > jU) {
                                                            long j6 = jU + 1;
                                                            long j7 = j - j6;
                                                            if (j7 > 0) {
                                                                com.byazt.x.c.n("SegmentReader", "loopAndRead: redundant = ".concat(String.valueOf(j7)));
                                                            }
                                                            try {
                                                                this.rl = j6;
                                                                j = j6;
                                                                jU = jU;
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                while (true) {
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                        j2 = 0;
                                                        break;
                                                    }
                                                    cVarTt2 = veVar.tt();
                                                    i = inputStreamC.read(cVarTt2.c);
                                                    cVarTt2.ve = i;
                                                    if (i == -1) {
                                                        nVarUj.tt(cVarTt2);
                                                        j2 = 0;
                                                        nVarUj = null;
                                                        break;
                                                    }
                                                    long j8 = i;
                                                    j += j8;
                                                    if (j > jU) {
                                                        j3 = jU + 1;
                                                        if (j > j3 && (i2 = (int) (j8 - (j - j3))) > 0 && i2 < i) {
                                                            cVarTt2.ve = i2;
                                                            j = j3;
                                                        }
                                                        this.rl = j;
                                                        nVarUj.tt(cVarTt2);
                                                        com.byazt.x.c.ve("SegmentReader", "loopAndRead: bytesRead = " + (j - jN) + ", url = " + this.tt.c);
                                                        j2 = 0;
                                                        break;
                                                    }
                                                    this.rl = j;
                                                    nVarUj.tt(cVarTt2);
                                                    z3 = false;
                                                }
                                            } else {
                                                cVarTt2 = veVar.tt();
                                                i = inputStreamC.read(cVarTt2.c);
                                                cVarTt2.ve = i;
                                                if (i == -1) {
                                                    nVarUj.tt(cVarTt2);
                                                    j2 = 0;
                                                    nVarUj = null;
                                                    break;
                                                }
                                                long j9 = i;
                                                j += j9;
                                                if (j > jU) {
                                                    j3 = jU + 1;
                                                    if (j > j3) {
                                                        cVarTt2.ve = i2;
                                                        j = j3;
                                                    }
                                                    this.rl = j;
                                                    nVarUj.tt(cVarTt2);
                                                    com.byazt.x.c.ve("SegmentReader", "loopAndRead: bytesRead = " + (j - jN) + ", url = " + this.tt.c);
                                                    j2 = 0;
                                                    break;
                                                }
                                                this.rl = j;
                                                nVarUj.tt(cVarTt2);
                                                z3 = false;
                                            }
                                        } catch (BaseException e) {
                                            e = e;
                                            this.qp = e;
                                            throw e;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cVarTt = null;
                                            com.byazt.x.c.n("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                            com.byazt.nr.m.c(th);
                                            try {
                                                com.byazt.w.a.c(th, "loopAndRead");
                                                com.byazt.w.a.c(inputStreamC);
                                                if (nVarUj != null) {
                                                    if (cVarTt == null) {
                                                        try {
                                                            cVarTt = veVar.tt();
                                                        } catch (Throwable unused3) {
                                                            cVar2 = cVarTt;
                                                            if (cVar2 != null) {
                                                                veVar.c(cVar2);
                                                            }
                                                            this.sp = System.currentTimeMillis();
                                                            if (j > jN) {
                                                                cVar3 = this.yp;
                                                                downloadInfo = this.u;
                                                                str = this.x;
                                                                str2 = this.i;
                                                                str3 = this.da;
                                                                if (!this.gr || this.zm) {
                                                                    z2 = true;
                                                                } else {
                                                                    z2 = false;
                                                                }
                                                                com.byazt.zl.c.c(cVar3, downloadInfo, str, str2, str3, z2, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                                                            }
                                                            this.sl.ve(this, iVar);
                                                        }
                                                    }
                                                    cVarTt.ve = -1;
                                                    nVarUj.tt(cVarTt);
                                                    cVar2 = null;
                                                } else {
                                                    cVar2 = cVarTt;
                                                }
                                                if (cVar2 != null) {
                                                    veVar.c(cVar2);
                                                }
                                                this.sp = System.currentTimeMillis();
                                                if (j > jN) {
                                                    cVar3 = this.yp;
                                                    downloadInfo = this.u;
                                                    str = this.x;
                                                    str2 = this.i;
                                                    str3 = this.da;
                                                    if (this.gr) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                    com.byazt.zl.c.c(cVar3, downloadInfo, str, str2, str3, z2, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                                                }
                                            } catch (BaseException e2) {
                                                this.qp = e2;
                                                throw e2;
                                            }
                                        }
                                    }
                                    if (jU > j2 && jU != Long.MAX_VALUE && j <= jU) {
                                        throw new BaseException(1051, String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", Long.valueOf(jN), Long.valueOf(jU), Long.valueOf(j), Long.valueOf(jN)));
                                    }
                                    com.byazt.w.a.c(inputStreamC);
                                    if (nVarUj != null) {
                                        try {
                                            c cVarTt4 = veVar.tt();
                                            try {
                                                cVarTt4.ve = -1;
                                                nVarUj.tt(cVarTt4);
                                            } catch (Throwable unused4) {
                                                cVar4 = cVarTt4;
                                            }
                                        } catch (Throwable unused5) {
                                        }
                                        cVar4 = null;
                                    } else {
                                        cVar4 = null;
                                    }
                                    if (cVar4 != null) {
                                        veVar.c(cVar4);
                                    }
                                    this.sp = System.currentTimeMillis();
                                    if (j > jN) {
                                        cVar3 = this.yp;
                                        downloadInfo = this.u;
                                        str = this.x;
                                        str2 = this.i;
                                        str3 = this.da;
                                        z2 = this.gr || this.zm;
                                        com.byazt.zl.c.c(cVar3, downloadInfo, str, str2, str3, z2, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                                    }
                                }
                            } catch (BaseException e3) {
                                e = e3;
                                this.qp = e;
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                com.byazt.x.c.n("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                com.byazt.nr.m.c(th);
                                com.byazt.w.a.c(th, "loopAndRead");
                                com.byazt.w.a.c(inputStreamC);
                                if (nVarUj != null) {
                                    if (cVarTt == null) {
                                        cVarTt = veVar.tt();
                                    }
                                    cVarTt.ve = -1;
                                    nVarUj.tt(cVarTt);
                                    cVar2 = null;
                                } else {
                                    cVar2 = cVarTt;
                                }
                                if (cVar2 != null) {
                                    veVar.c(cVar2);
                                }
                                this.sp = System.currentTimeMillis();
                                if (j > jN) {
                                    cVar3 = this.yp;
                                    downloadInfo = this.u;
                                    str = this.x;
                                    str2 = this.i;
                                    str3 = this.da;
                                    if (this.gr) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    com.byazt.zl.c.c(cVar3, downloadInfo, str, str2, str3, z2, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                                }
                            }
                        } catch (BaseException e4) {
                            e = e4;
                        } catch (Throwable th4) {
                            th = th4;
                            j = jN;
                        }
                        this.sl.ve(this, iVar);
                    } catch (BaseException e5) {
                        e = e5;
                    } catch (Throwable th5) {
                        th = th5;
                        j = jN;
                        nVarUj = null;
                    }
                } catch (BaseException e6) {
                    e = e6;
                } catch (Throwable th6) {
                    th = th6;
                    j = jN;
                    nVarUj = null;
                }
            } catch (Throwable th7) {
                com.byazt.w.a.c(inputStreamC);
                if (nVarUj != null) {
                    if (cVarTt == null) {
                        try {
                            cVarTt = veVar.tt();
                        } catch (Throwable unused6) {
                            cVar = cVarTt;
                            if (cVar != null) {
                                veVar.c(cVar);
                            }
                            this.sp = System.currentTimeMillis();
                            if (j > jN) {
                                com.byazt.k.c cVar6 = this.yp;
                                DownloadInfo downloadInfo2 = this.u;
                                String str4 = this.x;
                                String str5 = this.i;
                                String str6 = this.da;
                                if (!this.gr || this.zm) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                com.byazt.zl.c.c(cVar6, downloadInfo2, str4, str5, str6, z, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                            }
                            this.sl.ve(this, iVar);
                            throw th7;
                        }
                    }
                    cVarTt.ve = -1;
                    nVarUj.tt(cVarTt);
                    cVar = null;
                } else {
                    cVar = cVarTt;
                }
                if (cVar != null) {
                    veVar.c(cVar);
                }
                this.sp = System.currentTimeMillis();
                if (j > jN) {
                    com.byazt.k.c cVar7 = this.yp;
                    DownloadInfo downloadInfo3 = this.u;
                    String str7 = this.x;
                    String str8 = this.i;
                    String str9 = this.da;
                    if (this.gr) {
                        z = true;
                    } else {
                        z = true;
                    }
                    com.byazt.zl.c.c(cVar7, downloadInfo3, str7, str8, str9, z, this.z, this.qp, j - jN, TimeUnit.MILLISECONDS.toNanos(this.sp - this.f28599a));
                }
                this.sl.ve(this, iVar);
                throw th7;
            }
        } catch (BaseException e7) {
            e = e7;
        } catch (Throwable th8) {
            th = th8;
            j = jN;
            nVarUj = null;
            inputStreamC = null;
        }
    }

    private void ve(i iVar) throws BaseException {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.n = 0L;
                this.uj = jCurrentTimeMillis;
                this.rh = iVar.n();
                this.gt = iVar.a();
                if (this.gt > 0 && this.rh > this.gt) {
                    throw new da(6, "createConn, ".concat(String.valueOf(iVar)));
                }
                this.bx = new com.byazt.w.n();
                List<com.byazt.t.ve> listC = com.byazt.w.a.c(this.u.getExtraHeaders(), this.u.geteTag(), this.rh, this.gt);
                listC.add(new com.byazt.t.ve("Segment-Index", String.valueOf(iVar.sp())));
                listC.add(new com.byazt.t.ve("Thread-Index", String.valueOf(this.ve)));
                com.byazt.w.a.c(listC, this.u);
                com.byazt.w.a.tt(listC, this.u);
                String strReplaceFirst = this.tt.c;
                if (this.cu && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith("https")) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("https", "http");
                }
                String str = this.tt.tt;
                com.byazt.x.c.ve("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + iVar + ", threadIndex = " + this.ve);
                this.x = strReplaceFirst;
                this.i = str;
                com.byazt.hs.i iVarC = com.byazt.zz.ve.c(this.u.isNeedDefaultHttpServiceBackUp(), this.u.getMaxBytes(), strReplaceFirst, str, listC, 0, jCurrentTimeMillis - this.zb > 3000 && this.yp.tt("monitor_download_connect") > 0, this.u);
                if (iVarC == null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                this.z = iVarC;
                this.m = new com.byazt.t.uj(strReplaceFirst, iVarC);
                if (this.gr) {
                    throw new m("createConn");
                }
                if (iVarC instanceof com.byazt.hs.c) {
                    this.da = ((com.byazt.hs.c) iVarC).n();
                }
                com.byazt.nr.m.c("SegmentReader", "createConnectionSuccess: url = " + strReplaceFirst + ", ip = " + str + ", hostRealIp = " + this.da + ", threadIndex = " + this.ve);
                this.n = System.currentTimeMillis();
            } catch (Throwable th) {
                this.n = System.currentTimeMillis();
                throw th;
            }
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th2) {
            com.byazt.w.a.c(th2, "createConn");
        }
    }

    public void a() {
        c(false);
    }

    public void n() {
        com.byazt.x.c.ve("SegmentReader", "close: threadIndex = " + this.ve);
        synchronized (this) {
            this.gr = true;
            this.md = true;
        }
        da();
        Future future = this.gu;
        if (future != null) {
            this.gu = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        a aVar2;
        Process.setThreadPriority(10);
        try {
            this.p = Thread.currentThread();
            this.sl.c(this);
            this.tt.c(this);
            while (true) {
                i iVarC = this.sl.c(this, this.tt);
                if (iVarC == null) {
                    com.byazt.x.c.ve("SegmentReader", "no more segment, thread_index = " + this.ve);
                } else {
                    this.c = iVarC;
                    try {
                        try {
                            if (c(iVarC)) {
                                this.nu.add(iVarC);
                                this.c = null;
                                aVar2 = this.sl;
                            } else {
                                if (!this.gr) {
                                    com.byazt.x.c.n("SegmentReader", "download segment failed, segment = " + iVarC + ", thread_index = " + this.ve + ", failedException = " + this.qp);
                                }
                                this.c = null;
                                aVar = this.sl;
                                aVar.c(this, iVarC);
                            }
                        } catch (da e) {
                            com.byazt.x.c.n("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e)));
                            int i = this.h;
                            if (i >= 50) {
                                com.byazt.x.c.n("SegmentReader", "segment apply failed " + this.h + "times, thread_index = " + this.ve);
                                this.c = null;
                                aVar = this.sl;
                                aVar.c(this, iVarC);
                            } else {
                                this.h = i + 1;
                                this.c = null;
                                aVar2 = this.sl;
                            }
                        }
                        aVar2.c(this, iVarC);
                    } catch (Throwable th) {
                        this.c = null;
                        this.sl.c(this, iVarC);
                        throw th;
                    }
                }
                try {
                    this.tt.tt(this);
                    this.sl.tt(this);
                } catch (Throwable unused) {
                }
                this.p = null;
                return;
            }
        } catch (Throwable th2) {
            try {
                com.byazt.nr.m.c(th2);
            } finally {
                try {
                    this.tt.tt(this);
                    this.sl.tt(this);
                } catch (Throwable unused2) {
                }
                this.p = null;
            }
        }
    }

    public boolean sp() {
        return this.nb;
    }

    public long x() {
        return this.rh;
    }

    public long tt() {
        long jVe;
        synchronized (this.sl) {
            jVe = this.qy + ve();
        }
        return jVe;
    }

    public void tt(boolean z) {
        this.nb = z;
    }

    public void tt(long j) {
        long j2 = this.rl;
        com.byazt.w.n nVar = this.bx;
        if (j2 < 0 || nVar == null) {
            return;
        }
        com.byazt.nr.m.c("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.ve);
        nVar.c(j2, j);
    }

    public boolean c(nu nuVar) {
        int i = this.or;
        if (i >= 30) {
            return false;
        }
        this.or = i + 1;
        nu nuVar2 = this.tt;
        if (nuVar2 != null) {
            nuVar2.tt(this);
        }
        nuVar.c(this);
        this.tt = nuVar;
        t();
        return true;
    }

    private boolean c(i iVar, BaseException baseException) {
        com.byazt.x.c.n("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.eo + ", retryCount = " + this.d);
        this.qp = baseException;
        this.tt.tt();
        this.sl.c(this, this.tt, iVar, baseException, this.eo, this.d);
        int i = this.eo;
        if (i < this.d) {
            this.eo = i + 1;
            return true;
        }
        if (c(baseException)) {
            return true;
        }
        this.sl.c(this, this.tt, iVar, baseException);
        return false;
    }

    public long ve() {
        synchronized (this.sl) {
            long j = this.rl;
            long j2 = this.rh;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    private boolean c(BaseException baseException) {
        if (!com.byazt.w.a.ve(baseException)) {
            return false;
        }
        String str = this.tt.c;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.u.isNeedHttpsToHttpRetry() || this.cu) {
            return false;
        }
        this.cu = true;
        t();
        return true;
    }

    public void ve(boolean z) {
        this.pf = z;
    }

    private c c(ve veVar, InputStream inputStream) throws Throwable {
        int i;
        c cVarTt = veVar.tt();
        try {
            i = inputStream.read(cVarTt.c);
            try {
                if (i != -1) {
                    cVarTt.ve = i;
                    if (i == -1) {
                        veVar.c(cVarTt);
                    }
                    return cVarTt;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    veVar.c(cVarTt);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    public boolean c(long j) {
        long j2 = this.gt;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.my = j;
        this.md = true;
        return true;
    }

    public void c() {
        nu nuVar = this.tt;
        try {
            synchronized (this.sl) {
                long jVe = ve();
                if (jVe > 0) {
                    this.qy += jVe;
                    nuVar.c(jVe);
                }
                this.rl = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void c(boolean z) {
        com.byazt.x.c.ve("SegmentReader", "reconnect: threadIndex = " + this.ve);
        synchronized (this) {
            this.yv = z;
            this.zm = true;
            this.md = true;
        }
        da();
        Thread thread = this.p;
        if (thread != null) {
            try {
                com.byazt.nr.m.c("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.ve);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void c(Future future) {
        this.gu = future;
    }

    public long c(long j, long j2) {
        com.byazt.w.n nVar = this.bx;
        if (nVar == null) {
            return -1L;
        }
        return nVar.tt(j, j2);
    }

    public long uj() {
        return this.rl;
    }
}
