package com.byazt.mk;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.o.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 20})
public class c extends gt {
    public static c c;
    public static final long tt;
    public static final long uj;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f28792a;
    public boolean n;
    public long sp;

    /* JADX INFO: renamed from: com.byazt.mk.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 44})
    public static final class C0466c extends com.byazt.jtc.ve {
        public C0466c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.m_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                try {
                    synchronized (c.class) {
                        try {
                            c cVarUj = c.uj();
                            if (cVarUj != null) {
                                if (cVarUj == c.c) {
                                    c.c = null;
                                    return;
                                }
                                continue;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (InterruptedException unused) {
                    continue;
                } catch (Throwable unused2) {
                    return;
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        tt = millis;
        uj = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static c uj() throws InterruptedException {
        c cVar = c.f28792a;
        if (cVar == null) {
            long jNanoTime = System.nanoTime();
            c.class.wait(tt);
            if (c.f28792a != null || System.nanoTime() - jNanoTime < uj) {
                return null;
            }
            return c;
        }
        long jTt = cVar.tt(System.nanoTime());
        if (jTt > 0) {
            long j = jTt / 1000000;
            c.class.wait(j, (int) (jTt - (1000000 * j)));
            return null;
        }
        c.f28792a = cVar.f28792a;
        cVar.f28792a = null;
        return cVar;
    }

    public final void c() {
        if (this.n) {
            return;
        }
        long jN_ = n_();
        boolean zVe = ve();
        if (jN_ != 0 || zVe) {
            this.n = true;
            c(this, jN_, zVe);
        }
    }

    public void m_() {
    }

    public final boolean tt() {
        if (!this.n) {
            return false;
        }
        this.n = false;
        return c(this);
    }

    private long tt(long j) {
        return this.sp - j;
    }

    public IOException tt(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(b.r0);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void c(c cVar, long j, boolean z) {
        if (c == null) {
            c = new c();
            C0466c c0466c = new C0466c();
            c0466c.setName("csj_watch_dog");
            try {
                c0466c.start();
            } catch (Throwable unused) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            cVar.sp = Math.min(j, cVar.o_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            cVar.sp = j + jNanoTime;
        } else if (z) {
            cVar.sp = cVar.o_();
        } else {
            throw new AssertionError();
        }
        long jTt = cVar.tt(jNanoTime);
        c cVar2 = c;
        while (true) {
            c cVar3 = cVar2.f28792a;
            if (cVar3 == null || jTt < cVar3.tt(jNanoTime)) {
                break;
                break;
            }
            cVar2 = cVar2.f28792a;
        }
        cVar.f28792a = cVar2.f28792a;
        cVar2.f28792a = cVar;
        if (cVar2 == c) {
            c.class.notify();
        }
    }

    private static synchronized boolean c(c cVar) {
        c cVar2 = c;
        while (cVar2 != null) {
            c cVar3 = cVar2.f28792a;
            if (cVar3 == cVar) {
                cVar2.f28792a = cVar.f28792a;
                cVar.f28792a = null;
                return false;
            }
            cVar2 = cVar3;
        }
        return true;
    }

    public final rh c(final rh rhVar) {
        return new rh() { // from class: com.byazt.mk.c.1
            @Override // com.byazt.mk.rh
            public void a_(ve veVar, long j) throws IOException {
                try {
                    rl.c(veVar.tt, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j <= 0) {
                            return;
                        }
                        z zVar = veVar.c;
                        while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            j2 += (long) (zVar.ve - zVar.tt);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            zVar = zVar.f28794a;
                        }
                        c.this.c();
                        try {
                            try {
                                rhVar.a_(veVar, j2);
                                j -= j2;
                                c.this.c(true);
                            } catch (IOException e) {
                                throw c.this.c(e);
                            }
                        } catch (Throwable th) {
                            c.this.c(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.byazt.mk.rh
            public gt c() {
                return c.this;
            }

            @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                c.this.c();
                try {
                    try {
                        rhVar.close();
                        c.this.c(true);
                    } catch (IOException e) {
                        throw c.this.c(e);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            @Override // com.byazt.mk.rh, java.io.Flushable
            public void flush() throws IOException {
                c.this.c();
                try {
                    try {
                        rhVar.flush();
                        c.this.c(true);
                    } catch (IOException e) {
                        throw c.this.c(e);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rhVar + ")";
            }
        };
    }

    public final my c(final my myVar) {
        return new my() { // from class: com.byazt.mk.c.2
            @Override // com.byazt.mk.my
            public long c(ve veVar, long j) throws IOException {
                c.this.c();
                try {
                    try {
                        long jC = myVar.c(veVar, j);
                        c.this.c(true);
                        return jC;
                    } catch (IOException e) {
                        throw c.this.c(e);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                c.this.c();
                try {
                    try {
                        myVar.close();
                        c.this.c(true);
                    } catch (IOException e) {
                        throw c.this.c(e);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + myVar + ")";
            }

            @Override // com.byazt.mk.my
            public gt c() {
                return c.this;
            }
        };
    }

    public final void c(boolean z) throws IOException {
        if (tt() && z) {
            throw tt((IOException) null);
        }
    }

    public final IOException c(IOException iOException) throws IOException {
        return !tt() ? iOException : tt(iOException);
    }
}
