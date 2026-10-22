package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.y99;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Loader implements LoaderErrorThrower {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31116a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f5048a = "ExoPlayer:Loader:";
    public static final int b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final b f5050c;
    public static final int d = 3;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final b f5051d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c<? extends Loadable> f5052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IOException f5053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorService f5054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final b f5047a = g(false, -9223372036854775807L);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final b f5049b = g(true, -9223372036854775807L);

    public interface Callback<T extends Loadable> {
        b A(T t, long j, long j2, IOException iOException, int i);

        void K(T t, long j, long j2);

        void M(T t, long j, long j2, boolean z);
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31117a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f5055a;

        public boolean c() {
            int i = this.f31117a;
            return i == 0 || i == 1;
        }

        public b(int i, long j) {
            this.f31117a = i;
            this.f5055a = j;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class c<T extends Loadable> extends Handler implements Runnable {
        public static final int M = 0;
        public static final int N = 1;
        public static final int O = 2;
        public static final int P = 3;
        public static final String f = "LoadTask";
        public final int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31118a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Callback<T> f5056a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final T f5057a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public IOException f5059a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Thread f5060a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5061a;
        public volatile boolean b;

        public c(Looper looper, T t, Callback<T> callback, int i, long j) {
            super(looper);
            this.f5057a = t;
            this.f5056a = callback;
            this.K = i;
            this.f31118a = j;
        }

        public void a(boolean z) {
            this.b = z;
            this.f5059a = null;
            if (hasMessages(0)) {
                this.f5061a = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f5061a = true;
                    this.f5057a.cancelLoad();
                    Thread thread = this.f5060a;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) sb0.g(this.f5056a)).M(this.f5057a, jElapsedRealtime, jElapsedRealtime - this.f31118a, true);
                this.f5056a = null;
            }
        }

        public final void b() {
            this.f5059a = null;
            Loader.this.f5054a.execute((Runnable) sb0.g(Loader.this.f5052a));
        }

        public final void c() {
            Loader.this.f5052a = null;
        }

        public final long d() {
            return Math.min((this.L - 1) * 1000, 5000);
        }

        public void e(int i) throws IOException {
            IOException iOException = this.f5059a;
            if (iOException != null && this.L > i) {
                throw iOException;
            }
        }

        public void f(long j) {
            sb0.i(Loader.this.f5052a == null);
            Loader.this.f5052a = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.b) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                b();
                return;
            }
            if (i == 3) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.f31118a;
            Callback callback = (Callback) sb0.g(this.f5056a);
            if (this.f5061a) {
                callback.M(this.f5057a, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    callback.K(this.f5057a, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    Log.e(f, "Unexpected exception handling load completed", e);
                    Loader.this.f5053a = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f5059a = iOException;
            int i3 = this.L + 1;
            this.L = i3;
            b bVarA = callback.A(this.f5057a, jElapsedRealtime, j, iOException, i3);
            if (bVarA.f31117a == 3) {
                Loader.this.f5053a = this.f5059a;
            } else if (bVarA.f31117a != 2) {
                if (bVarA.f31117a == 1) {
                    this.L = 1;
                }
                f(bVarA.f5055a != -9223372036854775807L ? bVarA.f5055a : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = !this.f5061a;
                    this.f5060a = Thread.currentThread();
                }
                if (z) {
                    y99.a("load:" + this.f5057a.getClass().getSimpleName());
                    try {
                        this.f5057a.load();
                        y99.c();
                    } catch (Throwable th) {
                        y99.c();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f5060a = null;
                    Thread.interrupted();
                }
                if (this.b) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.b) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (Error e2) {
                if (!this.b) {
                    Log.e(f, "Unexpected error loading stream", e2);
                    obtainMessage(3, e2).sendToTarget();
                }
                throw e2;
            } catch (Exception e3) {
                if (this.b) {
                    return;
                }
                Log.e(f, "Unexpected exception loading stream", e3);
                obtainMessage(2, new UnexpectedLoaderException(e3)).sendToTarget();
            } catch (OutOfMemoryError e4) {
                if (this.b) {
                    return;
                }
                Log.e(f, "OutOfMemory error loading stream", e4);
                obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
            }
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReleaseCallback f31119a;

        public d(ReleaseCallback releaseCallback) {
            this.f31119a = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f31119a.onLoaderReleased();
        }
    }

    static {
        long j = -9223372036854775807L;
        f5050c = new b(2, j);
        f5051d = new b(3, j);
    }

    public Loader(String str) {
        this.f5054a = gj9.a1(f5048a + str);
    }

    public static b g(boolean z, long j) {
        return new b(z ? 1 : 0, j);
    }

    public void e() {
        ((c) sb0.k(this.f5052a)).a(false);
    }

    public void f() {
        this.f5053a = null;
    }

    public boolean h() {
        return this.f5053a != null;
    }

    public boolean i() {
        return this.f5052a != null;
    }

    public void j() {
        k(null);
    }

    public void k(@Nullable ReleaseCallback releaseCallback) {
        c<? extends Loadable> cVar = this.f5052a;
        if (cVar != null) {
            cVar.a(true);
        }
        if (releaseCallback != null) {
            this.f5054a.execute(new d(releaseCallback));
        }
        this.f5054a.shutdown();
    }

    public <T extends Loadable> long l(T t, Callback<T> callback, int i) {
        Looper looper = (Looper) sb0.k(Looper.myLooper());
        this.f5053a = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new c(looper, t, callback, i, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) throws IOException {
        IOException iOException = this.f5053a;
        if (iOException != null) {
            throw iOException;
        }
        c<? extends Loadable> cVar = this.f5052a;
        if (cVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = cVar.K;
            }
            cVar.e(i);
        }
    }
}
