package com.byazt.hs;

import androidx.camera.video.AudioStats;
import com.byazt.nr.m;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_SERVER_ERROR, 158})
public class sl {
    public static final String c = "sl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Object> f28627a;
    public AtomicReference<t> n;
    public int sp;
    public final uj tt;
    public final AtomicReference<t> uj;
    public volatile boolean ve;

    /* JADX INFO: renamed from: com.byazt.hs.sl$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_SERVER_ERROR, 696})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[t.values().length];
            c = iArr;
            try {
                iArr[t.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[t.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[t.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[t.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_SERVER_ERROR, 925})
    public static class c {
        public static final sl c = new sl(null);
    }

    public /* synthetic */ sl(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static sl c() {
        return c.c;
    }

    private void uj() {
        try {
            int size = this.f28627a.size();
            for (int i = 0; i < size; i++) {
                this.f28627a.get(i);
                this.uj.get();
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private boolean ve() {
        double d;
        if (this.tt == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.c[this.uj.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            } else if (i == 2) {
                d2 = 550.0d;
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
            }
            double dC = this.tt.c();
            if (dC > d2) {
                if (dC > d2 * 1.25d) {
                    return true;
                }
            } else if (dC < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return false;
    }

    public synchronized t tt() {
        uj ujVar = this.tt;
        if (ujVar == null) {
            return t.UNKNOWN;
        }
        try {
            return c(ujVar.c());
        } catch (Throwable th) {
            m.c(th);
            return t.UNKNOWN;
        }
    }

    private sl() {
        this.tt = new uj(0.05d);
        this.ve = false;
        this.uj = new AtomicReference<>(t.UNKNOWN);
        this.f28627a = new ArrayList<>();
    }

    public synchronized void c(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.tt.c(d);
            t tVarTt = tt();
            if (!this.ve) {
                if (this.uj.get() != tVarTt) {
                    this.ve = true;
                    this.n = new AtomicReference<>(tVarTt);
                }
                return;
            }
            this.sp++;
            if (tVarTt != this.n.get()) {
                this.ve = false;
                this.sp = 1;
            }
            if (this.sp >= 5.0d && ve()) {
                this.ve = false;
                this.sp = 1;
                this.uj.set(this.n.get());
                uj();
            }
        } catch (Throwable unused) {
        }
    }

    private t c(double d) {
        if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
            return t.UNKNOWN;
        }
        if (d < 150.0d) {
            return t.POOR;
        }
        if (d < 550.0d) {
            return t.MODERATE;
        }
        if (d < 2000.0d) {
            return t.GOOD;
        }
        return t.EXCELLENT;
    }
}
