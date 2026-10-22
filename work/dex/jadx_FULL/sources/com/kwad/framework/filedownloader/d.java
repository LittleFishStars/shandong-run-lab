package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d implements com.kwad.framework.filedownloader.a.c, x, x.a, x.b {
    private long azA;
    private int azB;
    private boolean azC;
    private boolean azD;
    private String azE;
    private final Object azo;
    private t azs;
    private final a azt;
    private volatile long azv;
    private final s.b azx;
    private final s.a azy;
    private long azz;
    private volatile byte azu = 0;
    private Throwable azw = null;
    private boolean azF = false;

    public interface a {
        com.kwad.framework.filedownloader.d.b Bc();

        com.kwad.framework.filedownloader.a.InterfaceC1252a Bd();

        ArrayList<Object> Be();

        void setFileName(String str);
    }

    public d(a aVar, Object obj) {
        this.azo = obj;
        this.azt = aVar;
        b bVar = new b();
        this.azx = bVar;
        this.azy = bVar;
        this.azs = new k(aVar.Bd(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        com.kwad.framework.filedownloader.a aVarAP = this.azt.Bd().AP();
        byte bAH = messageSnapshot.AH();
        b(bAH);
        this.azC = messageSnapshot.AN();
        if (bAH == -4) {
            this.azx.reset();
            int iCr = h.Bn().cr(aVarAP.getId());
            if (iCr + ((iCr > 1 || !aVarAP.AB()) ? 0 : h.Bn().cr(com.kwad.framework.filedownloader.f.f.D(aVarAP.getUrl(), aVarAP.getTargetFilePath()))) <= 1) {
                byte bCw = n.By().cw(aVarAP.getId());
                com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(aVarAP.getId()), Integer.valueOf(bCw));
                if (com.kwad.framework.filedownloader.d.d.cY(bCw)) {
                    b((byte) 1);
                    this.azA = messageSnapshot.CM();
                    long jCO = messageSnapshot.CO();
                    this.azz = jCO;
                    this.azx.start(jCO);
                    this.azs.f(((MessageSnapshot.a) messageSnapshot).CQ());
                    return;
                }
            }
            h.Bn().a(this.azt.Bd(), messageSnapshot);
            return;
        }
        if (bAH == -3) {
            this.azF = messageSnapshot.CN();
            this.azz = messageSnapshot.CM();
            this.azA = messageSnapshot.CM();
            h.Bn().a(this.azt.Bd(), messageSnapshot);
            return;
        }
        if (bAH == -1) {
            this.azw = messageSnapshot.CP();
            this.azz = messageSnapshot.CO();
            h.Bn().a(this.azt.Bd(), messageSnapshot);
            return;
        }
        if (bAH == 1) {
            this.azz = messageSnapshot.CO();
            this.azA = messageSnapshot.CM();
            this.azs.f(messageSnapshot);
            return;
        }
        if (bAH == 2) {
            this.azA = messageSnapshot.CM();
            this.azD = messageSnapshot.CC();
            this.azE = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (aVarAP.getFilename() != null) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", aVarAP.getFilename(), fileName);
                }
                this.azt.setFileName(fileName);
            }
            this.azx.start(this.azz);
            this.azs.h(messageSnapshot);
            return;
        }
        if (bAH == 3) {
            this.azz = messageSnapshot.CO();
            this.azx.aa(messageSnapshot.CO());
            this.azs.i(messageSnapshot);
        } else if (bAH != 5) {
            if (bAH != 6) {
                return;
            }
            this.azs.g(messageSnapshot);
        } else {
            this.azz = messageSnapshot.CO();
            this.azw = messageSnapshot.CP();
            this.azB = messageSnapshot.AL();
            this.azx.reset();
            this.azs.k(messageSnapshot);
        }
    }

    private int getId() {
        return this.azt.Bd().AP().getId();
    }

    private void prepare() throws IOException {
        File file;
        com.kwad.framework.filedownloader.a aVarAP = this.azt.Bd().AP();
        if (aVarAP.getPath() == null) {
            aVarAP.bT(com.kwad.framework.filedownloader.f.f.ck(aVarAP.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", aVarAP.getPath());
            }
        }
        if (aVarAP.AB()) {
            file = new File(aVarAP.getPath());
        } else {
            String strCo = com.kwad.framework.filedownloader.f.f.co(aVarAP.getPath());
            if (strCo == null) {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.c("the provided mPath[%s] is invalid, can't find its directory", aVarAP.getPath()));
            }
            file = new File(strCo);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.c("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte AH() {
        return this.azu;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable AJ() {
        return this.azw;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int AL() {
        return this.azB;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean AN() {
        return this.azC;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void AY() {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(AH()));
        }
        this.azx.end(this.azz);
        if (this.azt.Be() != null) {
            ArrayList arrayList = (ArrayList) this.azt.Be().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        r.BG().BK().e(this.azt.Bd());
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t Bf() {
        return this.azs;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void Bg() {
        boolean z;
        synchronized (this.azo) {
            if (this.azu != 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.azu));
                return;
            }
            b((byte) 10);
            com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252aBd = this.azt.Bd();
            com.kwad.framework.filedownloader.a aVarAP = interfaceC1252aBd.AP();
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", aVarAP.getUrl(), aVarAP.getPath(), aVarAP.AC(), aVarAP.getTag());
            }
            try {
                prepare();
                z = true;
            } catch (Throwable th) {
                h.Bn().b(interfaceC1252aBd);
                h.Bn().a(interfaceC1252aBd, n(th));
                z = false;
            }
            if (z) {
                q.BE().a(this);
            }
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long Bh() {
        return this.azz;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.d.d.x(AH(), messageSnapshot.AH())) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.azu), Byte.valueOf(AH()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte bAH = AH();
        byte bAH2 = messageSnapshot.AH();
        if (-2 == bAH && com.kwad.framework.filedownloader.d.d.cY(bAH2)) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (com.kwad.framework.filedownloader.d.d.y(bAH, bAH2)) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.azu), Byte.valueOf(AH()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.azt.Bd().AP())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.azt.Bd().AP().AB() || messageSnapshot.AH() != -4 || AH() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.azu));
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.azy.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.azv;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.azA;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot n(Throwable th) {
        b((byte) -1);
        this.azw = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), Bh(), th);
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(AH()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.cX(AH())) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(AH()), Integer.valueOf(this.azt.Bd().AP().getId()));
            }
            return false;
        }
        b((byte) -2);
        com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252aBd = this.azt.Bd();
        com.kwad.framework.filedownloader.a aVarAP = interfaceC1252aBd.AP();
        q.BE().b(this);
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.BG();
        if (r.BI()) {
            n.By().cv(aVarAP.getId());
        } else if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(aVarAP.getId()));
        }
        h.Bn().b(interfaceC1252aBd);
        h.Bn().a(interfaceC1252aBd, com.kwad.framework.filedownloader.message.f.e(aVarAP));
        r.BG().BK().e(interfaceC1252aBd);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.azw = null;
        this.azE = null;
        this.azD = false;
        this.azB = 0;
        this.azF = false;
        this.azC = false;
        this.azz = 0L;
        this.azA = 0L;
        this.azx.reset();
        if (com.kwad.framework.filedownloader.d.d.cX(this.azu)) {
            this.azs.Bw();
            this.azs = new k(this.azt.Bd(), this);
        } else {
            this.azs.b(this.azt.Bd(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.azu != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.azu));
            return;
        }
        com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252aBd = this.azt.Bd();
        com.kwad.framework.filedownloader.a aVarAP = interfaceC1252aBd.AP();
        v vVarBK = r.BG().BK();
        try {
            if (vVarBK.f(interfaceC1252aBd)) {
                return;
            }
            synchronized (this.azo) {
                if (this.azu != 10) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.azu));
                    return;
                }
                b((byte) 11);
                h.Bn().b(interfaceC1252aBd);
                if (com.kwad.framework.filedownloader.f.c.a(aVarAP.getId(), aVarAP.getTargetFilePath(), aVarAP.AI(), true)) {
                    return;
                }
                boolean zA = n.By().a(aVarAP.getUrl(), aVarAP.getPath(), aVarAP.AB(), aVarAP.Az(), aVarAP.AA(), aVarAP.AK(), aVarAP.AI(), this.azt.Bc(), aVarAP.AO());
                if (this.azu == -2) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (zA) {
                        n.By().cv(getId());
                        return;
                    }
                    return;
                }
                if (zA) {
                    vVarBK.e(interfaceC1252aBd);
                    return;
                }
                if (vVarBK.f(interfaceC1252aBd)) {
                    return;
                }
                MessageSnapshot messageSnapshotN = n(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                if (h.Bn().a(interfaceC1252aBd)) {
                    vVarBK.e(interfaceC1252aBd);
                    h.Bn().b(interfaceC1252aBd);
                }
                h.Bn().a(interfaceC1252aBd, messageSnapshotN);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.Bn().a(interfaceC1252aBd, n(th));
        }
    }

    private void b(byte b) {
        this.azu = b;
        this.azv = System.currentTimeMillis();
    }
}
