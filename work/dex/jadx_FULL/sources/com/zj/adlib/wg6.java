package com.zj.adlib;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(16)
public class wg6 implements SurfaceTexture.OnFrameAvailableListener {
    public static final int N = 4;
    public static final int O = 12440;
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceTexture f45591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Surface f20430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s49 f20431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f20432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f20433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGL10 f20434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGLContext f20435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGLDisplay f20436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGLSurface f20437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20438a;

    public wg6(int i, int i2, int i3) {
        this.f20436a = null;
        this.f20435a = null;
        this.f20437a = null;
        this.f20432a = new Object();
        this.M = 0;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.K = i;
        this.L = i2;
        this.M = i3;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        this.f20433a = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        e(i, i2);
        h();
        j();
    }

    public void a() {
        synchronized (this.f20432a) {
            while (!this.f20438a) {
                try {
                    this.f20432a.wait(5000L);
                    if (!this.f20438a) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.f20438a = false;
        }
        this.f20431a.b("before updateTexImage");
        this.f45591a.updateTexImage();
    }

    public void b(String str) {
        this.f20431a.a(str);
    }

    public final void c(String str) {
        if (this.f20434a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public void d(boolean z) {
        this.f20431a.d(this.f45591a, z);
    }

    public final void e(int i, int i2) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f20434a = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f20436a = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.f20434a.eglInitialize(eGLDisplayEglGetDisplay, null)) {
            this.f20436a = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f20434a.eglChooseConfig(this.f20436a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        this.f20435a = this.f20434a.eglCreateContext(this.f20436a, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{O, 2, 12344});
        c("eglCreateContext");
        if (this.f20435a == null) {
            throw new RuntimeException("null context");
        }
        this.f20437a = this.f20434a.eglCreatePbufferSurface(this.f20436a, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344});
        c("eglCreatePbufferSurface");
        if (this.f20437a == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public ByteBuffer f() {
        this.f20433a.rewind();
        GLES20.glReadPixels(0, 0, this.K, this.L, 6408, 5121, this.f20433a);
        return this.f20433a;
    }

    public Surface g() {
        return this.f20430a;
    }

    public void h() {
        if (this.f20434a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        c("before makeCurrent");
        EGL10 egl10 = this.f20434a;
        EGLDisplay eGLDisplay = this.f20436a;
        EGLSurface eGLSurface = this.f20437a;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f20435a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void i() {
        EGL10 egl10 = this.f20434a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f20435a)) {
                EGL10 egl11 = this.f20434a;
                EGLDisplay eGLDisplay = this.f20436a;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl11.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f20434a.eglDestroySurface(this.f20436a, this.f20437a);
            this.f20434a.eglDestroyContext(this.f20436a, this.f20435a);
        }
        this.f20430a.release();
        this.f20436a = null;
        this.f20435a = null;
        this.f20437a = null;
        this.f20434a = null;
        this.f20431a = null;
        this.f20430a = null;
        this.f45591a = null;
    }

    public final void j() {
        s49 s49Var = new s49(this.M);
        this.f20431a = s49Var;
        s49Var.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f20431a.e());
        this.f45591a = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f20430a = new Surface(this.f45591a);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f20432a) {
            if (this.f20438a) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.f20438a = true;
            this.f20432a.notifyAll();
        }
    }

    public wg6() {
        this.f20436a = null;
        this.f20435a = null;
        this.f20437a = null;
        this.f20432a = new Object();
        this.M = 0;
        j();
    }
}
