package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements com.kwad.framework.filedownloader.a, com.kwad.framework.filedownloader.a.InterfaceC1252a, d.a {
    private final x ayW;
    private final x.a ayX;
    private int ayY;
    private ArrayList<Object> ayZ;
    private String aza;
    private String azb;
    private boolean azc;
    private com.kwad.framework.filedownloader.d.b azd;
    private i aze;
    private Object azf;
    private final Object azo;
    private final String mUrl;
    private int azg = 0;
    private boolean azh = false;
    private boolean azi = false;
    private int azj = 100;
    private int azk = 10;
    private boolean azl = false;
    volatile int azm = 0;
    private boolean azn = false;
    private final Object azp = new Object();
    private volatile boolean azq = false;

    public static final class a implements com.kwad.framework.filedownloader.a.b {
        private final c azr;

        public /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int AX() {
            int id = this.azr.getId();
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.Bn().c(this.azr);
            return id;
        }

        private a(c cVar) {
            this.azr = cVar;
            c.a(cVar, true);
        }
    }

    public c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.azo = obj;
        d dVar = new d(this, obj);
        this.ayW = dVar;
        this.ayX = dVar;
    }

    private boolean AZ() {
        return this.ayW.AH() != 0;
    }

    private int Ba() {
        if (!AZ()) {
            if (!Ay()) {
                AS();
            }
            this.ayW.Bg();
            return getId();
        }
        if (isRunning()) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
        }
        throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.ayW.toString());
    }

    private void Bb() {
        if (this.azd == null) {
            synchronized (this.azp) {
                if (this.azd == null) {
                    this.azd = new com.kwad.framework.filedownloader.d.b();
                }
            }
        }
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.azn = true;
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int AA() {
        return this.azk;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean AB() {
        return this.azc;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i AC() {
        return this.aze;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int AD() {
        return getSmallFileSoFarBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long AE() {
        return this.ayW.Bh();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int AF() {
        return getSmallFileTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long AG() {
        return this.ayW.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte AH() {
        return this.ayW.AH();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean AI() {
        return this.azl;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable AJ() {
        return this.ayW.AJ();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int AK() {
        return this.azg;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int AL() {
        return this.ayW.AL();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean AM() {
        return this.azh;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean AN() {
        return this.ayW.AN();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean AO() {
        return this.azi;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final com.kwad.framework.filedownloader.a AP() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final x.a AQ() {
        return this.ayX;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final int AR() {
        return this.azm;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final void AS() {
        this.azm = AC() != null ? AC().hashCode() : hashCode();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final boolean AT() {
        return this.azq;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final void AU() {
        this.azq = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final void AV() {
        Ba();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final boolean AW() {
        ArrayList<Object> arrayList = this.ayZ;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a.b Aw() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Ax() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.azm = 0;
        this.azn = false;
        this.azq = false;
        this.ayW.reset();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Ay() {
        return this.azm != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int Az() {
        return this.azj;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b Bc() {
        return this.azd;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.a.InterfaceC1252a Bd() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> Be() {
        return this.ayZ;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bT(String str) {
        return c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bU(String str) {
        if (this.azd == null) {
            synchronized (this.azp) {
                if (this.azd == null) {
                    return this;
                }
            }
        }
        this.azd.cf(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bs(boolean z) {
        this.azl = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bt(boolean z) {
        this.azh = z;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bu(boolean z) {
        this.azi = z;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a c(String str, boolean z) {
        this.aza = str;
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.azc = z;
        if (z) {
            this.azb = null;
        } else {
            this.azb = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a cp(int i) {
        this.azg = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final boolean cq(int i) {
        return getId() == i;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final void free() {
        this.ayW.free();
        if (h.Bn().a(this)) {
            this.azq = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.azb;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i = this.ayY;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.aza) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int iG = com.kwad.framework.filedownloader.f.f.g(this.mUrl, this.aza, this.azc);
        this.ayY = iG;
        return iG;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.aza;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.ayW.Bh() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.ayW.Bh();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.ayW.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.ayW.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.ayW.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.ayW.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.azf;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), AB(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a i(Object obj) {
        this.azf = obj;
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC1252a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.cX(AH());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.BG().BK().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.cY(AH());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean zPause;
        synchronized (this.azo) {
            zPause = this.ayW.pause();
        }
        return zPause;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void setFileName(String str) {
        this.azb = str;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (this.azn) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return Ba();
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a y(String str, String str2) {
        Bb();
        this.azd.A(str, str2);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.aze = iVar;
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }
}
