package com.byazt.u;

import android.annotation.SuppressLint;
import android.os.Process;
import com.byazt.hs.i;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.byazt.zz.da;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 67, 13})
public class tt implements Runnable {
    public static final String c = "tt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadInfo f29081a;
    public volatile boolean da;
    public da i;
    public final DownloadTask n;
    public volatile boolean sl;
    public final a sp;
    public boolean t;
    public com.byazt.t.tt tt;
    public com.byazt.zz.n uj;
    public com.byazt.t.tt ve;
    public i x;

    public tt(com.byazt.t.tt ttVar, DownloadTask downloadTask, a aVar) {
        this.t = false;
        this.ve = ttVar;
        this.n = downloadTask;
        if (downloadTask != null) {
            this.f29081a = downloadTask.getDownloadInfo();
        }
        this.sp = aVar;
        this.i = com.byazt.zz.ve.zm();
        this.ve.c(this);
    }

    private boolean n() {
        return this.da || this.sl;
    }

    private void uj() {
        i iVar = this.x;
        if (iVar != null) {
            iVar.uj();
            this.x = null;
        }
    }

    private String ve() {
        return this.f29081a.getConnectionUrl();
    }

    public void c(long j, long j2) {
        com.byazt.zz.n nVar = this.uj;
        if (nVar == null) {
            return;
        }
        nVar.c(j, j2);
    }

    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    public void run() {
        Process.setThreadPriority(10);
        this.tt = this.ve;
        while (true) {
            try {
                this.tt.c(this);
                if (!c(this.tt)) {
                    this.tt.c(false);
                    break;
                }
                this.tt.c(false);
                if (n()) {
                    break;
                }
                this.tt = this.sp.c(this.tt.my());
                if (n() || this.tt == null) {
                    break;
                }
                try {
                    Thread.sleep(50L);
                } catch (Throwable th) {
                    m.c(th);
                }
            } catch (Throwable th2) {
                com.byazt.t.tt ttVar = this.tt;
                if (ttVar != null) {
                    ttVar.c(false);
                }
                uj();
                this.sp.c(this);
                throw th2;
            }
        }
        com.byazt.t.tt ttVar2 = this.tt;
        if (ttVar2 != null) {
            ttVar2.c(false);
        }
        uj();
        this.sp.c(this);
    }

    public void tt() {
        this.sl = true;
        com.byazt.zz.n nVar = this.uj;
        if (nVar != null) {
            nVar.ve();
        }
    }

    /* JADX WARN: Code duplicated, block: B:122:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:202:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f9 A[Catch: all -> 0x01ae, BaseException -> 0x01ca, TRY_ENTER, TryCatch #15 {BaseException -> 0x01ca, all -> 0x01ae, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:45:0x00cb, B:60:0x00ef, B:64:0x00f9, B:66:0x00fd, B:77:0x012b, B:74:0x0123, B:76:0x012a, B:49:0x00d5, B:51:0x00d9, B:68:0x0101, B:71:0x010c, B:72:0x0121, B:32:0x006c, B:34:0x0070), top: B:210:0x004e, inners: #16, #14 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fd A[Catch: all -> 0x01ae, BaseException -> 0x01ca, TRY_LEAVE, TryCatch #15 {BaseException -> 0x01ca, all -> 0x01ae, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:45:0x00cb, B:60:0x00ef, B:64:0x00f9, B:66:0x00fd, B:77:0x012b, B:74:0x0123, B:76:0x012a, B:49:0x00d5, B:51:0x00d9, B:68:0x0101, B:71:0x010c, B:72:0x0121, B:32:0x006c, B:34:0x0070), top: B:210:0x004e, inners: #16, #14 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x010b  */
    /* JADX WARN: Code duplicated, block: B:71:0x010c A[Catch: all -> 0x0122, BaseException -> 0x0129, TryCatch #16 {BaseException -> 0x0129, all -> 0x0122, blocks: (B:68:0x0101, B:71:0x010c, B:72:0x0121), top: B:208:0x0101, outer: #15 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0141 A[Catch: all -> 0x01a9, BaseException -> 0x01ab, TryCatch #3 {all -> 0x01a9, blocks: (B:79:0x013a, B:81:0x0141, B:85:0x014d, B:86:0x0153, B:87:0x0164, B:93:0x0173, B:94:0x0181, B:102:0x018c, B:104:0x0190, B:112:0x01a5, B:113:0x01a8), top: B:195:0x006c }] */
    private boolean c(com.byazt.t.tt ttVar) {
        com.byazt.t.tt ttVarN;
        boolean z;
        long j;
        long jC;
        com.byazt.m.x xVarC;
        Throwable th;
        i iVar;
        i iVar2;
        int iTt;
        long jVe;
        while (true) {
            if (!ttVar.uj() || !ttVar.a() || (ttVarN = ttVar.n()) == null || ttVarN.my() != ttVar.my()) {
                ttVarN = null;
            }
            com.byazt.t.tt ttVar2 = ttVarN;
            if (ttVar2 != null && ttVar2.i()) {
                return true;
            }
            long jYp = ttVar.yp();
            long jM = ttVar.m();
            long jYp2 = ttVar.yp();
            if (ttVar2 != null) {
                jYp2 = ttVar2.yp();
                jYp = ttVar2.yp();
                jM = ttVar2.m();
            }
            long j2 = jYp;
            long j3 = jM;
            long jC2 = 0;
            boolean z2 = false;
            try {
                if (n()) {
                    uj();
                    return false;
                }
                String strVe = ve();
                boolean z3 = this.x != null;
                this.t = z3;
                ttVar.tt(z3);
                try {
                    try {
                        try {
                            if (!this.t) {
                                List<com.byazt.t.ve> listC = com.byazt.w.a.c(this.f29081a.getExtraHeaders(), this.f29081a.geteTag(), j2, j3);
                                listC.add(new com.byazt.t.ve("Chunk-Index", String.valueOf(ttVar.my())));
                                com.byazt.w.a.c(listC, this.f29081a);
                                com.byazt.w.a.tt(listC, this.f29081a);
                                this.x = com.byazt.zz.ve.c(this.f29081a.isNeedDefaultHttpServiceBackUp(), this.f29081a.getMaxBytes(), strVe, listC);
                            }
                            i iVar3 = this.x;
                            if (iVar3 != null && this.sp != null) {
                                try {
                                    int iTt2 = iVar3.tt();
                                    if (iTt2 < 200 || iTt2 >= 300) {
                                        this.sp.c(this.x);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    m.c(th);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (n()) {
                                uj();
                                return true;
                            }
                            try {
                                com.byazt.w.a.c(th, "downloadChunkInner");
                            } catch (BaseException e) {
                                this.sp.tt(e);
                            }
                            uj();
                            return z;
                        }
                    } catch (BaseException e2) {
                        try {
                            throw e2;
                        } catch (Throwable th4) {
                            th = th4;
                            th = th;
                            iVar = this.x;
                            if (iVar == null) {
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        try {
                            com.byazt.w.a.c(th5, "ChunkRunnableConnection");
                            i iVar4 = this.x;
                            if (iVar4 != null && this.sp != null) {
                                try {
                                    int iTt3 = iVar4.tt();
                                    if (iTt3 < 200 || iTt3 >= 300) {
                                        this.sp.c(this.x);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    m.c(th);
                                }
                            }
                            if (n()) {
                                uj();
                                return false;
                            }
                            iVar2 = this.x;
                            if (iVar2 != null) {
                                if (!this.t) {
                                    try {
                                        iTt = iVar2.tt();
                                        if (com.byazt.w.a.uj(iTt)) {
                                            throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iTt)));
                                        }
                                    } catch (BaseException e3) {
                                        throw e3;
                                    } catch (Throwable th7) {
                                        com.byazt.w.a.c(th7, "ChunkRunnableGetResponseCode");
                                    }
                                    e = e;
                                    z = false;
                                    j = jYp2;
                                }
                                z = false;
                                j = jYp2;
                                this.uj = new com.byazt.zz.n(this.f29081a, strVe, this.x, ttVar, this.sp);
                                if (ttVar2 != null) {
                                    jVe = ttVar2.ve(false);
                                    if (j3 != 0) {
                                        jVe = (j3 - j2) + 1;
                                    }
                                    this.uj.c(ttVar2.yp(), ttVar2.m(), jVe);
                                }
                                try {
                                    this.uj.uj();
                                    uj();
                                    return true;
                                } catch (BaseException e4) {
                                    e = e4;
                                    z2 = true;
                                }
                            } else {
                                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            th = th;
                            iVar = this.x;
                            if (iVar == null && this.sp != null) {
                                try {
                                    int iTt4 = iVar.tt();
                                    if (iTt4 < 200 || iTt4 >= 300) {
                                        this.sp.c(this.x);
                                        throw th;
                                    }
                                    throw th;
                                } catch (Throwable th9) {
                                    m.c(th9);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    if (n()) {
                        uj();
                        return false;
                    }
                    iVar2 = this.x;
                    if (iVar2 != null) {
                        if (!this.t) {
                            iTt = iVar2.tt();
                            if (com.byazt.w.a.uj(iTt)) {
                                throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iTt)));
                            }
                            e = e;
                            z = false;
                            j = jYp2;
                        }
                        z = false;
                        j = jYp2;
                        this.uj = new com.byazt.zz.n(this.f29081a, strVe, this.x, ttVar, this.sp);
                        if (ttVar2 != null) {
                            jVe = ttVar2.ve(false);
                            if (j3 != 0 && j3 >= j2) {
                                jVe = (j3 - j2) + 1;
                            }
                            this.uj.c(ttVar2.yp(), ttVar2.m(), jVe);
                        }
                        this.uj.uj();
                        uj();
                        return true;
                    }
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                } catch (BaseException e5) {
                    e = e5;
                    z2 = z;
                }
            } catch (BaseException e6) {
                e = e6;
                z = false;
                j = jYp2;
            } catch (Throwable th10) {
                th = th10;
                z = false;
                if (n()) {
                    uj();
                    return true;
                }
                com.byazt.w.a.c(th, "downloadChunkInner");
                uj();
                return z;
            }
            try {
                if (n()) {
                    uj();
                    return true;
                }
                if (com.byazt.w.a.tt(e)) {
                    this.sp.c(e, z);
                    uj();
                    return z;
                }
                if (this.sp.c(e)) {
                    if (com.byazt.w.a.c(e)) {
                        this.sp.c(e, true);
                        uj();
                        return z;
                    }
                    if (!z2) {
                        jC = jC2;
                    } else if (this.uj != null) {
                        if (com.byazt.w.c.c(32)) {
                            jC = this.uj.c() - this.uj.n();
                            if (jC > 0) {
                                c(ttVar, this.uj.n());
                            } else if (jC < 0) {
                            }
                        } else {
                            jC2 = this.uj.c() - j;
                            c(ttVar, j);
                        }
                        jC = jC2;
                    } else {
                        this.sp.tt(e);
                        uj();
                        return z;
                    }
                    if (com.byazt.w.c.c(16)) {
                        xVarC = this.sp.c(ttVar, e, jC);
                    } else {
                        xVarC = this.sp.c(e, jC);
                    }
                    if (xVarC == com.byazt.m.x.RETURN) {
                        uj();
                        return z;
                    }
                    ttVar.tt(z);
                    uj();
                    uj();
                } else {
                    if (this.f29081a.isNeedChunkDowngradeRetry() && !this.f29081a.isChunkDowngradeRetryUsed() && this.f29081a.getChunkCount() > 1 && com.byazt.w.a.c(e, this.f29081a)) {
                        this.sp.ve(e);
                        uj();
                        return z;
                    }
                    this.sp.tt(e);
                    uj();
                    return z;
                }
            } catch (Throwable th11) {
                uj();
                throw th11;
            }
        }
    }

    public tt(com.byazt.t.tt ttVar, DownloadTask downloadTask, i iVar, a aVar) {
        this(ttVar, downloadTask, aVar);
        this.x = iVar;
    }

    private void c(com.byazt.t.tt ttVar, long j) {
        com.byazt.t.tt ttVarN = ttVar.uj() ? ttVar.n() : ttVar;
        if (ttVarN != null) {
            if (ttVarN.x()) {
                this.i.c(ttVarN.sl(), ttVarN.tt(), j);
            }
            ttVarN.tt(j);
            this.i.c(ttVarN.sl(), ttVarN.my(), ttVarN.tt(), j);
            return;
        }
        if (ttVar.uj()) {
            this.i.c(ttVar.sl(), ttVar.my(), j);
        }
    }

    public void c() {
        this.da = true;
        com.byazt.zz.n nVar = this.uj;
        if (nVar != null) {
            nVar.tt();
        }
    }
}
