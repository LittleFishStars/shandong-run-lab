package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(17)
public final class PlaceholderSurface extends Surface {
    private static final String TAG = "PlaceholderSurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final b thread;
    private boolean threadReleased;

    public static class b extends HandlerThread implements Handler.Callback {
        public static final int K = 1;
        public static final int L = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f31175a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EGLSurfaceTexture f5319a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public PlaceholderSurface f5320a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Error f5321a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public RuntimeException f5322a;

        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        public PlaceholderSurface a(int i) {
            boolean z;
            start();
            this.f31175a = new Handler(getLooper(), this);
            this.f5319a = new EGLSurfaceTexture(this.f31175a);
            synchronized (this) {
                z = false;
                this.f31175a.obtainMessage(1, i, 0).sendToTarget();
                while (this.f5320a == null && this.f5322a == null && this.f5321a == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f5322a;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f5321a;
            if (error == null) {
                return (PlaceholderSurface) sb0.g(this.f5320a);
            }
            throw error;
        }

        public final void b(int i) {
            sb0.g(this.f5319a);
            this.f5319a.h(i);
            this.f5320a = new PlaceholderSurface(this, this.f5319a.g(), i != 0);
        }

        public void c() {
            sb0.g(this.f31175a);
            this.f31175a.sendEmptyMessage(2);
        }

        public final void d() {
            sb0.g(this.f5319a);
            this.f5319a.i();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        d();
                    } catch (Throwable th) {
                        try {
                            Log.e(PlaceholderSurface.TAG, "Failed to release placeholder surface", th);
                        } finally {
                            quit();
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e);
                    this.f5321a = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e2);
                    this.f5322a = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }
    }

    private static int getSecureMode(Context context) {
        if (GlUtil.D(context)) {
            return GlUtil.E() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        if (!secureModeInitialized) {
            secureMode = getSecureMode(context);
            secureModeInitialized = true;
        }
        return secureMode != 0;
    }

    public static PlaceholderSurface newInstanceV17(Context context, boolean z) {
        sb0.i(!z || isSecureSupported(context));
        return new b().a(z ? secureMode : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.c();
                this.threadReleased = true;
            }
        }
    }

    private PlaceholderSurface(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.thread = bVar;
        this.secure = z;
    }
}
