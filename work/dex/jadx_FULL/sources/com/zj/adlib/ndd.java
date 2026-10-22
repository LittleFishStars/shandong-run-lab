package com.zj.adlib;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ndd implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f43505a = new HashMap();
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double f18404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18405a;
    public long b;
    public long c;
    public long d;
    public final String f;

    public ndd(String str) {
        this.c = 2147483647L;
        this.d = -2147483648L;
        this.f = str;
    }

    public static ndd l(String str) {
        ogd.a();
        if (!ogd.b()) {
            return jdd.f42566a;
        }
        Map map = f43505a;
        if (map.get("detectorTaskWithResource#run") == null) {
            map.put("detectorTaskWithResource#run", new ndd("detectorTaskWithResource#run"));
        }
        return (ndd) map.get("detectorTaskWithResource#run");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.f18405a;
        if (j == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        k(j);
    }

    public final void g() {
        this.K = 0;
        this.f18404a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f18405a = 0L;
        this.c = 2147483647L;
        this.d = -2147483648L;
    }

    public ndd h() {
        this.f18405a = SystemClock.elapsedRealtimeNanos() / 1000;
        return this;
    }

    public void j(long j) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j2 = this.b;
        if (j2 != 0 && jElapsedRealtimeNanos - j2 >= 1000000) {
            g();
        }
        this.b = jElapsedRealtimeNanos;
        this.K++;
        this.f18404a += j;
        this.c = Math.min(this.c, j);
        this.d = Math.max(this.d, j);
        if (this.K % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", this.f, Long.valueOf(j), Integer.valueOf(this.K), Long.valueOf(this.c), Long.valueOf(this.d), Integer.valueOf((int) (this.f18404a / ((double) this.K))));
            ogd.a();
        }
        if (this.K % 500 == 0) {
            g();
        }
    }

    public void k(long j) {
        j((SystemClock.elapsedRealtimeNanos() / 1000) - j);
    }
}
