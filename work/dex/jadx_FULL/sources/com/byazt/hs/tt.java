package com.byazt.hs;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_SERVER_ERROR, 13})
public class tt {
    public static volatile boolean c = false;
    public static long sp = -1;
    public static final String tt = "tt";
    public static volatile tt x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28629a;
    public final sl ve = sl.c();
    public final AtomicInteger uj = new AtomicInteger();
    public final c n = new c(com.byazt.u.n.c());

    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_SERVER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void c() {
            sendEmptyMessage(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            tt.this.a();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void tt() {
            removeMessages(1);
        }
    }

    private tt() {
    }

    public static tt c() {
        if (x == null) {
            synchronized (tt.class) {
                if (x == null) {
                    x = new tt();
                }
            }
        }
        return x;
    }

    public static void n() {
        c = com.byazt.w.a.tt(com.byazt.zz.ve.ic());
    }

    public static long uj() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public void a() {
        try {
            n();
            long jUj = c ? uj() : TrafficStats.getMobileRxBytes();
            long j = sp;
            long j2 = jUj - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.ve.c(j2, jUptimeMillis - this.f28629a);
                    this.f28629a = jUptimeMillis;
                }
            }
            sp = jUj;
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void sp() {
        a();
        sp = -1L;
    }

    public void tt() {
        try {
            com.byazt.x.c.ve(tt, "startSampling: mSamplingCounter = " + this.uj);
            if (this.uj.getAndIncrement() == 0) {
                this.n.c();
                this.f28629a = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void ve() {
        try {
            com.byazt.x.c.ve(tt, "stopSampling: mSamplingCounter = " + this.uj);
            if (this.uj.decrementAndGet() == 0) {
                this.n.tt();
                sp();
            }
        } catch (Throwable unused) {
        }
    }
}
