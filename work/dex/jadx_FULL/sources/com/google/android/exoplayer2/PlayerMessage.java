package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;
import com.zj.adlib.sb0;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class PlayerMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Looper f2172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Sender f2173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Target f2174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline f2175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f2176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Object f2177a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2179b;
    public boolean c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2171a = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2178a = true;

    public interface Sender {
        void a(PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i, Clock clock, Looper looper) {
        this.f2173a = sender;
        this.f2174a = target;
        this.f2175a = timeline;
        this.f2172a = looper;
        this.f2176a = clock;
        this.b = i;
    }

    public synchronized boolean a() throws InterruptedException {
        sb0.i(this.f2179b);
        sb0.i(this.f2172a.getThread() != Thread.currentThread());
        while (!this.d) {
            wait();
        }
        return this.c;
    }

    public synchronized boolean b(long j) throws InterruptedException, TimeoutException {
        boolean z;
        sb0.i(this.f2179b);
        sb0.i(this.f2172a.getThread() != Thread.currentThread());
        long jElapsedRealtime = this.f2176a.elapsedRealtime() + j;
        while (true) {
            z = this.d;
            if (z || j <= 0) {
                break;
            }
            this.f2176a.onThreadBlocked();
            wait(j);
            j = jElapsedRealtime - this.f2176a.elapsedRealtime();
        }
        if (!z) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.c;
    }

    public synchronized PlayerMessage c() {
        sb0.i(this.f2179b);
        this.e = true;
        l(false);
        return this;
    }

    public boolean d() {
        return this.f2178a;
    }

    public Looper e() {
        return this.f2172a;
    }

    public int f() {
        return this.b;
    }

    @Nullable
    public Object g() {
        return this.f2177a;
    }

    public int getType() {
        return this.f30503a;
    }

    public long h() {
        return this.f2171a;
    }

    public Target i() {
        return this.f2174a;
    }

    public Timeline j() {
        return this.f2175a;
    }

    public synchronized boolean k() {
        return this.e;
    }

    public synchronized void l(boolean z) {
        this.c = z | this.c;
        this.d = true;
        notifyAll();
    }

    public PlayerMessage m() {
        sb0.i(!this.f2179b);
        if (this.f2171a == -9223372036854775807L) {
            sb0.a(this.f2178a);
        }
        this.f2179b = true;
        this.f2173a.a(this);
        return this;
    }

    public PlayerMessage n(boolean z) {
        sb0.i(!this.f2179b);
        this.f2178a = z;
        return this;
    }

    @Deprecated
    public PlayerMessage o(Handler handler) {
        return p(handler.getLooper());
    }

    public PlayerMessage p(Looper looper) {
        sb0.i(!this.f2179b);
        this.f2172a = looper;
        return this;
    }

    public PlayerMessage q(@Nullable Object obj) {
        sb0.i(!this.f2179b);
        this.f2177a = obj;
        return this;
    }

    public PlayerMessage r(int i, long j) {
        sb0.i(!this.f2179b);
        sb0.a(j != -9223372036854775807L);
        if (i < 0 || (!this.f2175a.w() && i >= this.f2175a.v())) {
            throw new IllegalSeekPositionException(this.f2175a, i, j);
        }
        this.b = i;
        this.f2171a = j;
        return this;
    }

    public PlayerMessage s(long j) {
        sb0.i(!this.f2179b);
        this.f2171a = j;
        return this;
    }

    public PlayerMessage t(int i) {
        sb0.i(!this.f2179b);
        this.f30503a = i;
        return this;
    }
}
