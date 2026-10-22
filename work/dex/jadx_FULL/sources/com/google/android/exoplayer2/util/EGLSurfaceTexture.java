package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.wg6;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(17)
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 1;
    public static final int O = 1;
    public static final int P = 12992;
    public static final int[] b = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public SurfaceTexture f31153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public EGLContext f5231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public EGLDisplay f5232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public EGLSurface f5233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TextureImageListener f5235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f5236a;

    public static final class GlException extends RuntimeException {
        private GlException(String str) {
            super(str);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    public interface TextureImageListener {
        void onFrameAvailable();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    public static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig eGLConfig;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, b, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!zEglChooseConfig || iArr[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            throw new GlException(gj9.H("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        }
        return eGLConfig;
    }

    public static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{wg6.O, 2, 12344} : new int[]{wg6.O, 2, P, 1, 12344}, 0);
        if (eGLContextEglCreateContext != null) {
            return eGLContextEglCreateContext;
        }
        throw new GlException("eglCreateContext failed");
    }

    public static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, P, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new GlException("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new GlException("eglMakeCurrent failed");
    }

    public static void e(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.g();
    }

    public static EGLDisplay f() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new GlException("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new GlException("eglInitialize failed");
    }

    public final void d() {
        TextureImageListener textureImageListener = this.f5235a;
        if (textureImageListener != null) {
            textureImageListener.onFrameAvailable();
        }
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) sb0.g(this.f31153a);
    }

    public void h(int i) {
        EGLDisplay eGLDisplayF = f();
        this.f5232a = eGLDisplayF;
        EGLConfig eGLConfigA = a(eGLDisplayF);
        EGLContext eGLContextB = b(this.f5232a, eGLConfigA, i);
        this.f5231a = eGLContextB;
        this.f5233a = c(this.f5232a, eGLConfigA, eGLContextB, i);
        e(this.f5236a);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f5236a[0]);
        this.f31153a = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        this.f5234a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f31153a;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f5236a, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f5232a;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f5232a;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f5233a;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f5232a, this.f5233a);
            }
            EGLContext eGLContext = this.f5231a;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f5232a, eGLContext);
            }
            if (gj9.f41922a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f5232a;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f5232a);
            }
            this.f5232a = null;
            this.f5231a = null;
            this.f5233a = null;
            this.f31153a = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f5234a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f31153a;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, @Nullable TextureImageListener textureImageListener) {
        this.f5234a = handler;
        this.f5235a = textureImageListener;
        this.f5236a = new int[1];
    }
}
