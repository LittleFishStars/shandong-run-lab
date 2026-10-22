package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor aBt = com.kwad.framework.filedownloader.f.b.cj("ConnectionBlock");
    private String aBA;
    private long aBB;
    private long aBC;
    private long aBD;
    private long aBE;
    private final com.kwad.framework.filedownloader.b.a aBd;
    private final d aBg;
    private final int aBh;
    private final com.kwad.framework.filedownloader.d.c aBi;
    private final com.kwad.framework.filedownloader.d.b aBj;
    private final boolean aBk;
    private final boolean aBl;
    private final y aBm;
    private boolean aBn;
    int aBo;
    private final boolean aBp;
    private final ArrayList<c> aBq;
    private e aBr;
    private boolean aBs;
    private boolean aBu;
    private boolean aBv;
    private boolean aBw;
    private final AtomicBoolean aBx;
    private volatile boolean aBy;
    private volatile Exception aBz;
    private volatile boolean nJ;

    public class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        public DiscardSafely() {
        }
    }

    public class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        public RetryDirectly() {
        }
    }

    public static class a {
        private com.kwad.framework.filedownloader.d.b aAP;
        private Integer aBF;
        private Integer aBG;
        private Boolean aBH;
        private Boolean aBI;
        private Integer aBJ;
        private com.kwad.framework.filedownloader.d.c aBi;
        private y aBm;

        public final DownloadLaunchRunnable Cq() {
            if (this.aBi == null || this.aBm == null || this.aBF == null || this.aBG == null || this.aBH == null || this.aBI == null || this.aBJ == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.aBi, this.aAP, this.aBm, this.aBF.intValue(), this.aBG.intValue(), this.aBH.booleanValue(), this.aBI.booleanValue(), this.aBJ.intValue(), (byte) 0);
        }

        public final a a(y yVar) {
            this.aBm = yVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.aAP = bVar;
            return this;
        }

        public final a c(Boolean bool) {
            this.aBI = bool;
            return this;
        }

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.aBi = cVar;
            return this;
        }

        public final a f(Integer num) {
            this.aBF = num;
            return this;
        }

        public final a g(Integer num) {
            this.aBG = num;
            return this;
        }

        public final a h(Integer num) {
            this.aBJ = num;
            return this;
        }

        public final a b(Boolean bool) {
            this.aBH = bool;
            return this;
        }
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    private boolean Cl() {
        return (!this.aBu || this.aBi.Da() > 1) && this.aBv && this.aBp && !this.aBw;
    }

    private void Cn() {
        if (this.aBl && !com.kwad.framework.filedownloader.f.f.cq("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.aBi.getId()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.aBl && com.kwad.framework.filedownloader.f.f.DE()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void Co() throws RetryDirectly, DiscardSafely {
        int id = this.aBi.getId();
        if (this.aBi.AB()) {
            String targetFilePath = this.aBi.getTargetFilePath();
            int iD = com.kwad.framework.filedownloader.f.f.D(this.aBi.getUrl(), targetFilePath);
            if (com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.aBk, false)) {
                this.aBd.cF(id);
                this.aBd.cE(id);
                throw new DiscardSafely();
            }
            com.kwad.framework.filedownloader.d.c cVarCC = this.aBd.cC(iD);
            if (cVarCC != null) {
                if (com.kwad.framework.filedownloader.f.c.a(id, cVarCC, this.aBm, false)) {
                    this.aBd.cF(id);
                    this.aBd.cE(id);
                    throw new DiscardSafely();
                }
                List<com.kwad.framework.filedownloader.d.a> listCD = this.aBd.cD(iD);
                this.aBd.cF(iD);
                this.aBd.cE(iD);
                com.kwad.framework.filedownloader.f.f.cu(this.aBi.getTargetFilePath());
                if (com.kwad.framework.filedownloader.f.f.b(iD, cVarCC)) {
                    this.aBi.af(cVarCC.CX());
                    this.aBi.ah(cVarCC.getTotal());
                    this.aBi.cg(cVarCC.CY());
                    this.aBi.cV(cVarCC.Da());
                    this.aBd.b(this.aBi);
                    if (listCD != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : listCD) {
                            aVar.setId(id);
                            this.aBd.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwad.framework.filedownloader.f.c.a(id, this.aBi.CX(), this.aBi.Cp(), targetFilePath, this.aBm)) {
                this.aBd.cF(id);
                this.aBd.cE(id);
                throw new DiscardSafely();
            }
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) throws FileDownloadHttpException, RetryDirectly {
        int id = this.aBi.getId();
        int responseCode = bVar.getResponseCode();
        this.aBv = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String strCY = this.aBi.CY();
        String strA = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (!(responseCode == 412 || !(strCY == null || strCY.equals(strA) || (!z && !this.aBv)) || ((responseCode == 201 && connectTask.BW()) || (responseCode == 416 && this.aBi.CX() > 0)))) {
            this.aBA = connectTask.BX();
            if (!this.aBv && !z) {
                throw new FileDownloadHttpException(responseCode, map, bVar.BP());
            }
            long jB = com.kwad.framework.filedownloader.f.f.b(id, bVar);
            String strA2 = this.aBi.AB() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.aBi.getUrl()) : null;
            boolean z2 = jB == -1;
            this.aBw = z2;
            this.aBg.a(this.aBu && this.aBv, !z2 ? this.aBi.CX() + jB : jB, strA, strA2);
            return;
        }
        if (this.aBu) {
            com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), strCY, strA, Integer.valueOf(responseCode));
        }
        this.aBd.cE(this.aBi.getId());
        com.kwad.framework.filedownloader.f.f.E(this.aBi.getTargetFilePath(), this.aBi.Cp());
        this.aBu = false;
        if (strCY != null && strCY.equals(strA)) {
            com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", strCY, strA, Integer.valueOf(responseCode), Integer.valueOf(id));
            strA = null;
        }
        this.aBi.af(0L);
        this.aBi.ah(0L);
        this.aBi.cg(strA);
        this.aBi.Db();
        this.aBd.a(id, this.aBi.CY(), this.aBi.CX(), this.aBi.getTotal(), this.aBi.Da());
        throw new RetryDirectly();
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j) throws InterruptedException {
        int id = this.aBi.getId();
        String strCY = this.aBi.CY();
        String url = this.aBA;
        if (url == null) {
            url = this.aBi.getUrl();
        }
        String strCp = this.aBi.Cp();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.aBu;
        long j2 = 0;
        long jCT = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            long jCT2 = aVar.CU() == j2 ? j - aVar.CT() : (aVar.CU() - aVar.CT()) + 1;
            jCT += aVar.CT() - aVar.getStartOffset();
            if (jCT2 != j2) {
                c cVarCr = new c.a().cL(id).i(Integer.valueOf(aVar.getIndex())).a(this).cb(url).cc(z ? strCY : null).c(this.aBj).bv(this.aBl).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.CT(), aVar.CU(), jCT2)).cd(strCp).Cr();
                if (com.kwad.framework.filedownloader.f.d.aDr) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.aBq.add(cVarCr);
            } else if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
            }
            j2 = 0;
        }
        if (jCT != this.aBi.CX()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.aBi.CX()), Long.valueOf(jCT));
            this.aBi.af(jCT);
        }
        ArrayList arrayList = new ArrayList(this.aBq.size());
        for (c cVar : this.aBq) {
            if (this.nJ) {
                cVar.pause();
            } else {
                arrayList.add(Executors.callable(cVar));
            }
        }
        if (this.nJ) {
            this.aBi.d((byte) -2);
            return;
        }
        List<Future> listInvokeAll = aBt.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            for (Future future : listInvokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void d(long j, int i) throws InterruptedException {
        long j2 = j / ((long) i);
        int id = this.aBi.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i2);
            aVar.setStartOffset(j3);
            aVar.ad(j3);
            aVar.ae(j4);
            arrayList.add(aVar);
            this.aBd.a(aVar);
            j3 += j2;
            i2++;
        }
        this.aBi.cV(i);
        this.aBd.w(id, i);
        b(arrayList, j);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    private com.kwad.framework.filedownloader.download.a x(List<com.kwad.framework.filedownloader.d.a> list) {
        long jCX;
        long j;
        int iDa = this.aBi.Da();
        String strCp = this.aBi.Cp();
        String targetFilePath = this.aBi.getTargetFilePath();
        boolean z = iDa > 1;
        if ((!z || this.aBp) && com.kwad.framework.filedownloader.f.f.b(this.aBi.getId(), this.aBi)) {
            if (!this.aBp) {
                jCX = new File(strCp).length();
            } else if (!z) {
                jCX = this.aBi.CX();
            } else if (iDa == list.size()) {
                jCX = com.kwad.framework.filedownloader.d.a.y(list);
            } else {
                j = 0;
            }
            j = jCX;
        } else {
            j = 0;
        }
        this.aBi.af(j);
        boolean z2 = j > 0;
        this.aBu = z2;
        if (!z2) {
            this.aBd.cE(this.aBi.getId());
            com.kwad.framework.filedownloader.f.f.E(targetFilePath, strCp);
        }
        return new com.kwad.framework.filedownloader.download.a(0L, j, 0L, this.aBi.getTotal() - j);
    }

    public final void Ck() {
        if (this.aBi.Da() > 1) {
            List<com.kwad.framework.filedownloader.d.a> listCD = this.aBd.cD(this.aBi.getId());
            if (this.aBi.Da() == listCD.size()) {
                this.aBi.af(com.kwad.framework.filedownloader.d.a.y(listCD));
            } else {
                this.aBi.af(0L);
                this.aBd.cE(this.aBi.getId());
            }
        }
        this.aBg.Ct();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void Cm() {
        this.aBd.b(this.aBi.getId(), this.aBi.CX());
    }

    public final String Cp() {
        return this.aBi.Cp();
    }

    public final int getId() {
        return this.aBi.getId();
    }

    public final boolean isAlive() {
        return this.aBx.get() || this.aBg.isAlive();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j) {
        if (this.nJ) {
            return;
        }
        this.aBg.onProgress(j);
    }

    public final void pause() {
        this.nJ = true;
        e eVar = this.aBr;
        if (eVar != null) {
            eVar.pause();
        }
        for (c cVar : (ArrayList) this.aBq.clone()) {
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x006b  */
    /* JADX WARN: Code duplicated, block: B:156:0x025c A[Catch: all -> 0x0217, TryCatch #25 {all -> 0x0217, blocks: (B:46:0x00cf, B:95:0x01d4, B:97:0x01dd, B:98:0x01e1, B:154:0x0256, B:156:0x025c, B:159:0x0264, B:125:0x021a), top: B:205:0x0256 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0269 A[Catch: all -> 0x028f, TRY_ENTER, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x026f A[Catch: all -> 0x028f, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x027e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0075  */
    /* JADX WARN: Code duplicated, block: B:202:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:? A[Catch: all -> 0x028f, SYNTHETIC, TRY_LEAVE, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    @Override // java.lang.Runnable
    public final void run() {
        IOException iOException;
        Exception exc;
        Throwable th;
        long j;
        int iA;
        try {
            Process.setThreadPriority(10);
            if (this.aBi.AH() != 1) {
                if (this.aBi.AH() != -2) {
                    b(new RuntimeException(com.kwad.framework.filedownloader.f.f.c("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.aBi.getId()), Byte.valueOf(this.aBi.AH()), (byte) 1)));
                } else if (com.kwad.framework.filedownloader.f.d.aDr) {
                    com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.aBi.getId()));
                }
                this.aBg.Cs();
                if (this.nJ) {
                    this.aBg.Cw();
                } else if (this.aBy) {
                    this.aBg.c(this.aBz);
                } else {
                    try {
                        this.aBg.Cx();
                    } catch (IOException e) {
                        iOException = e;
                        this.aBg.c(iOException);
                    }
                }
            } else {
                if (!this.nJ) {
                    this.aBg.Cu();
                }
                while (true) {
                    if (this.nJ) {
                        if (com.kwad.framework.filedownloader.f.d.aDr) {
                            com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.aBi.getId()));
                        }
                        this.aBg.Cs();
                        if (this.nJ) {
                            this.aBg.Cw();
                        } else if (this.aBy) {
                            this.aBg.c(this.aBz);
                        } else {
                            try {
                                this.aBg.Cx();
                            } catch (IOException e2) {
                                iOException = e2;
                                this.aBg.c(iOException);
                            }
                        }
                    } else {
                        if (this.aBd != null) {
                            com.kwad.framework.filedownloader.a.b bVar = null;
                            try {
                                Cn();
                                List<com.kwad.framework.filedownloader.d.a> listCD = this.aBd.cD(this.aBi.getId());
                                ConnectTask connectTaskBZ = new ConnectTask.a().cK(this.aBi.getId()).bY(this.aBi.getUrl()).bZ(this.aBi.CY()).a(this.aBj).a(x(listCD)).BZ();
                                com.kwad.framework.filedownloader.a.b bVarBV = connectTaskBZ.BV();
                                try {
                                    a(connectTaskBZ.getRequestHeader(), connectTaskBZ, bVarBV);
                                    if (this.nJ) {
                                        this.aBi.d((byte) -2);
                                        if (bVarBV != null) {
                                            bVarBV.BQ();
                                        }
                                        this.aBg.Cs();
                                        if (this.nJ) {
                                            this.aBg.Cw();
                                        } else if (this.aBy) {
                                            this.aBg.c(this.aBz);
                                        } else {
                                            try {
                                                this.aBg.Cx();
                                            } catch (IOException e3) {
                                                iOException = e3;
                                                this.aBg.c(iOException);
                                            }
                                        }
                                    } else {
                                        Co();
                                        long total = this.aBi.getTotal();
                                        a(total, this.aBi.Cp());
                                        if (!Cl()) {
                                            j = total;
                                            iA = 1;
                                        } else if (this.aBu) {
                                            iA = this.aBi.Da();
                                            j = total;
                                        } else {
                                            j = total;
                                            iA = b.Ca().a(this.aBi.getId(), this.aBi.getUrl(), this.aBi.getPath(), j);
                                        }
                                        if (iA <= 0) {
                                            throw new IllegalAccessException(com.kwad.framework.filedownloader.f.f.c("invalid connection count %d, the connection count must be larger than 0", bVarBV));
                                        }
                                        if (this.nJ) {
                                            this.aBi.d((byte) -2);
                                            if (bVarBV != null) {
                                                bVarBV.BQ();
                                            }
                                            this.aBg.Cs();
                                            if (this.nJ) {
                                                this.aBg.Cw();
                                            } else if (this.aBy) {
                                                this.aBg.c(this.aBz);
                                            } else {
                                                try {
                                                    this.aBg.Cx();
                                                } catch (IOException e4) {
                                                    iOException = e4;
                                                    this.aBg.c(iOException);
                                                }
                                            }
                                        } else {
                                            boolean z = iA == 1;
                                            this.aBs = z;
                                            if (z) {
                                                a(connectTaskBZ.BY(), bVarBV);
                                            } else {
                                                if (bVarBV != null) {
                                                    bVarBV.BQ();
                                                } else {
                                                    bVar = bVarBV;
                                                }
                                                this.aBg.Cv();
                                                if (this.aBu) {
                                                    a(iA, listCD);
                                                } else {
                                                    d(j, iA);
                                                }
                                                bVarBV = bVar;
                                            }
                                            if (bVarBV != null) {
                                                bVarBV.BQ();
                                            }
                                        }
                                    }
                                } catch (DiscardSafely unused) {
                                    bVar = bVarBV;
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (!this.nJ) {
                                        if (this.aBy) {
                                            this.aBg.c(this.aBz);
                                        } else {
                                            try {
                                                this.aBg.Cx();
                                            } catch (IOException e5) {
                                                iOException = e5;
                                                this.aBg.c(iOException);
                                            }
                                        }
                                    }
                                    this.aBx.set(false);
                                } catch (RetryDirectly unused2) {
                                    bVar = bVarBV;
                                    this.aBi.d((byte) 5);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                } catch (FileDownloadGiveUpRetryException e6) {
                                    e = e6;
                                    exc = e;
                                    bVar = bVarBV;
                                    try {
                                        if (!a(exc)) {
                                            a(exc, 0L);
                                            if (bVar != null) {
                                                bVar.BQ();
                                            }
                                        } else {
                                            b(exc);
                                            if (bVar != null) {
                                                bVar.BQ();
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (bVar != null) {
                                            throw th;
                                        }
                                        bVar.BQ();
                                        throw th;
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    exc = e;
                                    bVar = bVarBV;
                                    if (!a(exc)) {
                                        a(exc, 0L);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    } else {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    }
                                } catch (ArrayIndexOutOfBoundsException e8) {
                                    e = e8;
                                    exc = e;
                                    bVar = bVarBV;
                                    if (!a(exc)) {
                                        a(exc, 0L);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    } else {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    }
                                } catch (IllegalAccessException e9) {
                                    e = e9;
                                    exc = e;
                                    bVar = bVarBV;
                                    if (!a(exc)) {
                                        a(exc, 0L);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    } else {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    }
                                } catch (IllegalArgumentException e10) {
                                    e = e10;
                                    exc = e;
                                    bVar = bVarBV;
                                    if (!a(exc)) {
                                        a(exc, 0L);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    } else {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    }
                                } catch (InterruptedException e11) {
                                    e = e11;
                                    exc = e;
                                    bVar = bVarBV;
                                    if (!a(exc)) {
                                        a(exc, 0L);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    } else {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    }
                                } catch (NullPointerException e12) {
                                    e = e12;
                                    exc = e;
                                    bVar = bVarBV;
                                    if (!a(exc)) {
                                        a(exc, 0L);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    } else {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.BQ();
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bVar = bVarBV;
                                    if (bVar != null) {
                                        throw th;
                                    }
                                    bVar.BQ();
                                    throw th;
                                }
                            } catch (DiscardSafely unused3) {
                            } catch (RetryDirectly unused4) {
                            } catch (FileDownloadGiveUpRetryException e13) {
                                e = e13;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        try {
                                            this.aBg.Cx();
                                        } catch (IOException e14) {
                                            iOException = e14;
                                            this.aBg.c(iOException);
                                        }
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            } catch (IOException e15) {
                                e = e15;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        this.aBg.Cx();
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            } catch (ArrayIndexOutOfBoundsException e16) {
                                e = e16;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        this.aBg.Cx();
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            } catch (IllegalAccessException e17) {
                                e = e17;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        this.aBg.Cx();
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            } catch (IllegalArgumentException e18) {
                                e = e18;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        this.aBg.Cx();
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            } catch (InterruptedException e19) {
                                e = e19;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        this.aBg.Cx();
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            } catch (NullPointerException e20) {
                                e = e20;
                                exc = e;
                                if (!a(exc)) {
                                    b(exc);
                                    if (bVar != null) {
                                        bVar.BQ();
                                    }
                                    this.aBg.Cs();
                                    if (this.nJ) {
                                        this.aBg.Cw();
                                    } else if (this.aBy) {
                                        this.aBg.c(this.aBz);
                                    } else {
                                        this.aBg.Cx();
                                    }
                                    this.aBx.set(false);
                                }
                                a(exc, 0L);
                                if (bVar != null) {
                                    bVar.BQ();
                                }
                            }
                        }
                        this.aBg.Cs();
                        if (this.nJ) {
                            this.aBg.Cw();
                        } else if (this.aBy) {
                            this.aBg.c(this.aBz);
                        } else {
                            this.aBg.Cx();
                        }
                    }
                }
            }
            this.aBx.set(false);
        } catch (Throwable th4) {
            this.aBg.Cs();
            if (this.nJ) {
                this.aBg.Cw();
            } else if (this.aBy) {
                this.aBg.c(this.aBz);
            } else {
                try {
                    this.aBg.Cx();
                } catch (IOException e21) {
                    this.aBg.c(e21);
                }
            }
            this.aBx.set(false);
            throw th4;
        }
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.aBh = 5;
        this.aBq = new ArrayList<>(5);
        this.aBB = 0L;
        this.aBC = 0L;
        this.aBD = 0L;
        this.aBE = 0L;
        this.aBx = new AtomicBoolean(true);
        this.nJ = false;
        this.aBn = false;
        this.aBi = cVar;
        this.aBj = bVar;
        this.aBk = z;
        this.aBl = z2;
        this.aBd = b.Ca().Cc();
        this.aBp = b.Ca().Ce();
        this.aBm = yVar;
        this.aBo = i3;
        this.aBg = new d(cVar, i3, i, i2);
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) throws Throwable {
        if (!this.aBv) {
            this.aBi.af(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.aAY, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).cO(this.aBi.getId()).cN(-1).bx(this.aBl).d(bVar).c(aVar).ce(this.aBi.Cp());
        this.aBi.cV(1);
        this.aBd.w(this.aBi.getId(), 1);
        this.aBr = aVar2.CE();
        if (this.nJ) {
            this.aBi.d((byte) -2);
            this.aBr.pause();
        } else {
            this.aBr.run();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.aBy = true;
        this.aBz = exc;
        if (this.nJ) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.aBi.getId()));
            }
        } else {
            for (c cVar : (ArrayList) this.aBq.clone()) {
                if (cVar != null) {
                    cVar.Bw();
                }
            }
        }
    }

    private void a(int i, List<com.kwad.framework.filedownloader.d.a> list) throws InterruptedException {
        if (i > 1 && list.size() == i) {
            b(list, this.aBi.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j, String str) {
        com.kwad.framework.filedownloader.e.a aVarCs = null;
        if (j != -1) {
            try {
                aVarCs = com.kwad.framework.filedownloader.f.f.cs(this.aBi.Cp());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes >= j2) {
                    if (!com.kwad.framework.filedownloader.f.e.Dz().aDx) {
                        aVarCs.setLength(j);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    aVarCs.close();
                }
                throw th;
            }
        }
        if (aVarCs != null) {
            aVarCs.close();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        if (this.nJ) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.aBi.getId()));
                return;
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.aBN;
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.aBi.getTotal()));
        }
        if (!this.aBs) {
            synchronized (this.aBq) {
                this.aBq.remove(cVar);
            }
        } else {
            if (j == 0 || j2 == this.aBi.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.aBi.getTotal()), Integer.valueOf(this.aBi.getId()));
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.aBs && code == 416 && !this.aBn) {
                com.kwad.framework.filedownloader.f.f.E(this.aBi.getTargetFilePath(), this.aBi.Cp());
                this.aBn = true;
                return true;
            }
        }
        return this.aBo > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j) {
        if (this.nJ) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.aBi.getId()));
            }
        } else {
            int i = this.aBo;
            int i2 = i - 1;
            this.aBo = i2;
            if (i < 0) {
                com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.aBi.getId()));
            }
            this.aBg.a(exc, this.aBo, j);
        }
    }
}
