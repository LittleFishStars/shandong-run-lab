package com.byazt.utw;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 13})
public class tt extends com.byazt.utw.c {
    public final Object t;
    public final Object u;
    public final int yp;
    public final InterfaceC0551tt z;

    /* JADX INFO: renamed from: com.byazt.utw.tt$tt, reason: collision with other inner class name */
    public interface InterfaceC0551tt {
        void c(tt ttVar);
    }

    public tt(c cVar) {
        super(cVar.uj, cVar.n);
        this.yp = cVar.sp;
        this.z = cVar.x;
        this.t = this;
        this.sp = cVar.c;
        this.x = cVar.tt;
        this.f29111a = cVar.f29112a;
        this.i = cVar.ve;
        this.u = cVar.i;
    }

    private void c(x.c cVar) throws Throwable {
        boolean z;
        File fileVe = this.c.ve(this.x);
        long length = fileVe.length();
        int i = this.yp;
        if (i > 0 && length >= i) {
            m.c("TAG_PROXY_DownloadTask", "no necessary to download for " + this.x + ", cache file size: " + length + ", max: " + this.yp);
            return;
        }
        int iN = n();
        com.byazt.emg.c cVarQuery = this.tt.query(this.x, iN);
        if (cVarQuery != null && length >= cVarQuery.ve) {
            if (uj.n) {
                m.c("TAG_PROXY_DownloadTask", "file download complete, key: " + this.x);
                return;
            }
            return;
        }
        uj();
        int i2 = (int) length;
        com.byazt.ydv.c cVarC = c(cVar, i2, this.yp, "GET");
        if (cVarC == null) {
            return;
        }
        n nVar = null;
        try {
            uj();
            String strC = com.byazt.nxx.c.c(cVarC, uj.sp, true);
            if (strC != null) {
                throw new com.byazt.ju.ve(strC + ", rawKey: " + this.sp + ", url: " + cVar);
            }
            int iC = com.byazt.nxx.c.c(cVarC);
            if (cVarQuery != null && cVarQuery.ve != iC) {
                if (uj.n) {
                    m.uj("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + cVarQuery.ve + ", " + iC + ", key: " + this.x);
                }
                throw new com.byazt.ju.tt("Content-Length not match, old length: " + cVarQuery.ve + ", new length: " + iC + ", rawKey: " + this.sp + ", currentUrl: " + cVar + ", previousInfo: " + cVarQuery.n);
            }
            com.byazt.nxx.c.c(cVarC, this.tt, this.x, iN);
            com.byazt.emg.c cVarQuery2 = this.tt.query(this.x, iN);
            int i3 = cVarQuery2 == null ? 0 : cVarQuery2.ve;
            InputStream inputStreamUj = cVarC.uj();
            n nVar2 = new n(fileVe, uj.f29113a ? "rwd" : "rw");
            try {
                nVar2.c(length);
                if (uj.n) {
                    m.c("TAG_PROXY_DownloadTask", "preload start from: ".concat(String.valueOf(length)));
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = inputStreamUj.read(bArr);
                    if (i4 >= 0) {
                        uj();
                        if (i4 > 0) {
                            nVar2.c(bArr, 0, i4);
                            i2 += i4;
                            this.ve.addAndGet(i4);
                            c(i3, i2);
                        }
                        int i5 = this.yp;
                        if (i5 > 0 && i2 >= i5) {
                            boolean z2 = uj.n;
                            if (z2) {
                                m.tt("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + i2 + ", max: " + this.yp);
                            }
                            com.byazt.nxx.c.c(cVarC.uj());
                            nVar2.c();
                            c();
                            if (z2) {
                                m.tt("TAG_PROXY_DownloadTask", "cancel call");
                                return;
                            }
                            return;
                        }
                        uj();
                    } else {
                        try {
                            ve();
                            if (uj.n) {
                                m.c("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
                            }
                            com.byazt.nxx.c.c(cVarC.uj());
                            nVar2.c();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            nVar = nVar2;
                            z = false;
                        }
                    }
                    com.byazt.nxx.c.c(cVarC.uj());
                    if (nVar != null) {
                        nVar.c();
                    }
                    if (z) {
                        c();
                        if (uj.n) {
                            m.tt("TAG_PROXY_DownloadTask", "cancel call");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                nVar = nVar2;
                z = true;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean sp() throws com.byazt.ju.c {
        while (this.i.c()) {
            uj();
            x.c cVarTt = this.i.tt();
            try {
                c(cVarTt);
                return true;
            } catch (com.byazt.ju.ve unused) {
                cVarTt.c();
                a();
            } catch (n.c unused2) {
                a();
                return false;
            } catch (IOException e) {
                if (e instanceof SocketTimeoutException) {
                    cVarTt.tt();
                }
                if (!tt()) {
                    a();
                }
            } catch (Throwable unused3) {
                return false;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.c(this.x);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            sp();
        } catch (Throwable unused) {
        }
        this.uj.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.c.tt(this.x);
        InterfaceC0551tt interfaceC0551tt = this.z;
        if (interfaceC0551tt != null) {
            interfaceC0551tt.c(this);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 450, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<a.tt> f29112a;
        public String c;
        public Object i;
        public com.byazt.emg.ve n;
        public int sp;
        public String tt;
        public com.byazt.byh.c uj;
        public x ve;
        public InterfaceC0551tt x;

        public c c(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.c = str;
            return this;
        }

        public c tt(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.tt = str;
            return this;
        }

        public c c(x xVar) {
            if (xVar != null) {
                this.ve = xVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        public c c(com.byazt.byh.c cVar) {
            if (cVar != null) {
                this.uj = cVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        public c c(com.byazt.emg.ve veVar) {
            if (veVar != null) {
                this.n = veVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        public c c(List<a.tt> list) {
            this.f29112a = list;
            return this;
        }

        public c c(int i) {
            this.sp = i;
            return this;
        }

        public c c(InterfaceC0551tt interfaceC0551tt) {
            this.x = interfaceC0551tt;
            return this;
        }

        public c c(Object obj) {
            this.i = obj;
            return this;
        }

        public tt c() {
            if (this.uj != null && this.n != null && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.tt) && this.ve != null) {
                return new tt(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
