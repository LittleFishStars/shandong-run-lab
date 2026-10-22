package com.zj.adlib;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(18)
public class ab4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40501a = 12610;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f15240a = false;
    public static final int b = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGLContext f15241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGLDisplay f15242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EGLSurface f15243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Surface f15244a;

    public ab4(Surface surface) {
        surface.getClass();
        this.f15244a = surface;
        b();
    }

    public final void a(String str) {
        boolean z = false;
        while (EGL14.eglGetError() != 12288) {
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public final void b() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f15242a = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.f15242a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f15242a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, f40501a, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f15241a = EGL14.eglCreateContext(this.f15242a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{wg6.O, 2, 12344}, 0);
        a("eglCreateContext");
        if (this.f15241a == null) {
            throw new RuntimeException("null context");
        }
        this.f15243a = EGL14.eglCreateWindowSurface(this.f15242a, eGLConfigArr[0], this.f15244a, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.f15243a == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public Surface c() {
        return this.f15244a;
    }

    public void d() {
        EGLDisplay eGLDisplay = this.f15242a;
        EGLSurface eGLSurface = this.f15243a;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f15241a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void e() {
        if (EGL14.eglGetCurrentContext().equals(this.f15241a)) {
            EGLDisplay eGLDisplay = this.f15242a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f15242a, this.f15243a);
        EGL14.eglDestroyContext(this.f15242a, this.f15241a);
        this.f15244a.release();
        this.f15242a = null;
        this.f15241a = null;
        this.f15243a = null;
        this.f15244a = null;
    }

    public void f(long j) {
        EGLExt.eglPresentationTimeANDROID(this.f15242a, this.f15243a, j);
    }

    public boolean g() {
        return EGL14.eglSwapBuffers(this.f15242a, this.f15243a);
    }
}
