package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private final int aAO;
    private final long aAW;
    long aAX;
    private final long aAY;
    private final f aBL;
    private final int aBN;
    private final com.kwad.framework.filedownloader.b.a aBd;
    private final boolean aBl;
    private final c aCd;
    private final com.kwad.framework.filedownloader.a.b aCe;
    private com.kwad.framework.filedownloader.e.a aCf;
    private volatile long aCg;
    private volatile long aCh;
    private final String apn;
    private final long contentLength;
    private volatile boolean nJ;

    public static class a {
        Integer aAU;
        com.kwad.framework.filedownloader.download.a aAV;
        Boolean aBI;
        f aBL;
        Integer aBP;
        com.kwad.framework.filedownloader.a.b aCe;
        c aCi;
        String apn;

        public final e CE() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.aBI == null || (bVar = this.aCe) == null || (aVar = this.aAV) == null || this.aBL == null || this.apn == null || (num = this.aAU) == null || this.aBP == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.aCi, num.intValue(), this.aBP.intValue(), this.aBI.booleanValue(), this.aBL, this.apn, (byte) 0);
        }

        public final a a(c cVar) {
            this.aCi = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.aBL = fVar;
            return this;
        }

        public final a bx(boolean z) {
            this.aBI = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.aAV = aVar;
            return this;
        }

        public final a cN(int i) {
            this.aBP = Integer.valueOf(i);
            return this;
        }

        public final a cO(int i) {
            this.aAU = Integer.valueOf(i);
            return this;
        }

        public final a ce(String str) {
            this.apn = str;
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.aCe = bVar;
            return this;
        }
    }

    public /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void CD() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.aAX - this.aCg, jElapsedRealtime - this.aCh)) {
            sync();
            this.aCg = this.aAX;
            this.aCh = jElapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aCf.Du();
            z = true;
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.aCd != null) {
                this.aBd.a(this.aAO, this.aBN, this.aAX);
            } else {
                this.aBL.Cm();
            }
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.aAO), Integer.valueOf(this.aBN), Long.valueOf(this.aAX), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public final void pause() {
        this.nJ = true;
    }

    public final void run() throws Throwable {
        com.kwad.framework.filedownloader.e.a aVarCs;
        if (this.nJ) {
            return;
        }
        long jB = com.kwad.framework.filedownloader.f.f.b(this.aBN, this.aCe);
        if (jB == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.aAO), Integer.valueOf(this.aBN)));
        }
        long j = this.contentLength;
        if (j > 0 && jB != j) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.aAY == 0 ? com.kwad.framework.filedownloader.f.f.c("range[%d-)", Long.valueOf(this.aAX)) : com.kwad.framework.filedownloader.f.f.c("range[%d-%d)", Long.valueOf(this.aAX), Long.valueOf(this.aAY)), Long.valueOf(this.contentLength), Long.valueOf(jB), Integer.valueOf(this.aAO), Integer.valueOf(this.aBN)));
        }
        long j2 = this.aAX;
        try {
            boolean zCe = b.Ca().Ce();
            if (this.aCd != null && !zCe) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVarCs = com.kwad.framework.filedownloader.f.f.cs(this.apn);
            try {
                this.aCf = aVarCs;
                if (zCe) {
                    aVarCs.seek(this.aAX);
                }
                if (com.kwad.framework.filedownloader.f.d.aDr) {
                    com.kwad.framework.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.aBN), Long.valueOf(this.aAW), Long.valueOf(this.aAY), Long.valueOf(this.aAX));
                }
                InputStream inputStream = this.aCe.getInputStream();
                byte[] bArr = new byte[4096];
                if (this.nJ) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVarCs);
                    return;
                }
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    aVarCs.write(bArr, 0, i);
                    long j3 = i;
                    this.aAX += j3;
                    this.aBL.onProgress(j3);
                    CD();
                    if (this.nJ) {
                        break;
                    } else if (this.aBl && com.kwad.framework.filedownloader.f.f.DE()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                }
                if (aVarCs != null) {
                    sync();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVarCs);
                long j4 = this.aAX - j2;
                if (jB != -1 && jB != j4) {
                    throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j4), Long.valueOf(jB), Long.valueOf(this.aAW), Long.valueOf(this.aAY), Long.valueOf(this.aAX), Long.valueOf(j2)));
                }
                this.aBL.a(this.aCd, this.aAW, this.aAY);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVarCs);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            aVarCs = null;
        }
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.aCg = 0L;
        this.aCh = 0L;
        this.aBL = fVar;
        this.apn = str;
        this.aCe = bVar;
        this.aBl = z;
        this.aCd = cVar;
        this.aBN = i2;
        this.aAO = i;
        this.aBd = b.Ca().Cc();
        this.aAW = aVar.aAW;
        this.aAY = aVar.aAY;
        this.aAX = aVar.aAX;
        this.contentLength = aVar.contentLength;
    }
}
