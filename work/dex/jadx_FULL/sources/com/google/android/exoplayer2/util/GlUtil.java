package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zj.adlib.gj9;
import com.zj.adlib.wg6;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class GlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f31155a = 2.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f5255a = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f5256a = "GlUtil";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f5257a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f5259b = "EGL_EXT_protected_content";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f5261c = "EGL_KHR_surfaceless_context";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f5258a = {12344};
    public static final int b = 12445;
    public static final int c = 13120;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f5260b = {b, c, 12344};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f5262c = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    public static final int[] d = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    @RequiresApi(17)
    public static final class a {
        @DoNotInline
        public static EGLContext a(EGLDisplay eGLDisplay, int i, int[] iArr) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, f(eGLDisplay, iArr), EGL14.EGL_NO_CONTEXT, new int[]{wg6.O, i, 12344}, 0);
            if (eGLContextEglCreateContext == null) {
                EGL14.eglTerminate(eGLDisplay);
                GlUtil.G("eglCreateContext() failed to create a valid context. The device may not support EGL version " + i);
            }
            GlUtil.g();
            return eGLContextEglCreateContext;
        }

        @DoNotInline
        public static EGLDisplay b() {
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            GlUtil.f(!eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
            if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0)) {
                GlUtil.G("Error in eglInitialize.");
            }
            GlUtil.g();
            return eGLDisplayEglGetDisplay;
        }

        @DoNotInline
        public static EGLSurface c(EGLDisplay eGLDisplay, int[] iArr, int[] iArr2) {
            EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, f(eGLDisplay, iArr), iArr2, 0);
            GlUtil.e("Error creating surface");
            return eGLSurfaceEglCreatePbufferSurface;
        }

        @DoNotInline
        public static void d(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) {
            if (eGLDisplay == null) {
                return;
            }
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            GlUtil.e("Error releasing context");
            if (eGLContext != null) {
                EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                GlUtil.e("Error destroying context");
            }
            EGL14.eglReleaseThread();
            GlUtil.e("Error releasing thread");
            EGL14.eglTerminate(eGLDisplay);
            GlUtil.e("Error terminating display");
        }

        @DoNotInline
        public static void e(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2, int i3) {
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(36006, iArr, 0);
            if (iArr[0] != i) {
                GLES20.glBindFramebuffer(36160, i);
            }
            GlUtil.g();
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            GlUtil.e("Error making context current");
            GLES20.glViewport(0, 0, i2, i3);
            GlUtil.g();
        }

        @DoNotInline
        private static EGLConfig f(EGLDisplay eGLDisplay, int[] iArr) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                GlUtil.G("eglChooseConfig failed.");
            }
            return eGLConfigArr[0];
        }

        @DoNotInline
        public static EGLSurface g(EGLDisplay eGLDisplay, Object obj, int[] iArr, int[] iArr2) {
            EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, f(eGLDisplay, iArr), obj, iArr2, 0);
            GlUtil.e("Error creating surface");
            return eGLSurfaceEglCreateWindowSurface;
        }
    }

    @RequiresApi(17)
    public static EGLSurface A(EGLDisplay eGLDisplay, Object obj) {
        return a.g(eGLDisplay, obj, d, f5260b);
    }

    public static float[] B() {
        return new float[]{-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static float[] C() {
        return new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static boolean D(Context context) {
        String strEglQueryString;
        int i = gj9.f41922a;
        if (i < 24) {
            return false;
        }
        if (i >= 26 || !("samsung".equals(gj9.b) || "XT1650".equals(gj9.c))) {
            return (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(f5259b);
        }
        return false;
    }

    public static boolean E() {
        String strEglQueryString;
        return gj9.f41922a >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(f5261c);
    }

    public static String F(Context context, String str) throws IOException {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return gj9.I(gj9.B1(inputStreamOpen));
        } finally {
            gj9.p(inputStreamOpen);
        }
    }

    public static void G(String str) {
        if (f5257a) {
            throw new GlException(str);
        }
        Log.d(f5256a, str);
    }

    public static void c(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        int i3 = iArr[0];
        if (i < 0 || i2 < 0) {
            G("width or height is less than 0");
        }
        if (i > i3 || i2 > i3) {
            G("width or height is greater than GL_MAX_TEXTURE_SIZE " + i3);
        }
    }

    public static void d(int i, int i2) {
        GLES20.glBindTexture(i, i2);
        g();
        GLES20.glTexParameteri(i, 10240, 9729);
        g();
        GLES20.glTexParameteri(i, 10241, 9729);
        g();
        GLES20.glTexParameteri(i, 10242, 33071);
        g();
        GLES20.glTexParameteri(i, 10243, 33071);
        g();
    }

    public static void e(String str) {
        int iEglGetError = EGL14.eglGetError();
        f(iEglGetError == 12288, str + ", error code: " + iEglGetError);
    }

    public static void f(boolean z, String str) {
        if (z) {
            return;
        }
        G(str);
    }

    public static void g() {
        int i = 0;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            Log.d(f5256a, "glError: " + GLU.gluErrorString(iGlGetError));
            i = iGlGetError;
        }
        if (i != 0) {
            G("glError: " + GLU.gluErrorString(i));
        }
    }

    public static FloatBuffer h(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer i(float[] fArr) {
        return (FloatBuffer) h(fArr.length).put(fArr).flip();
    }

    @RequiresApi(17)
    public static EGLContext j(EGLDisplay eGLDisplay) {
        return a.a(eGLDisplay, 2, f5262c);
    }

    @RequiresApi(17)
    public static EGLContext k(EGLDisplay eGLDisplay) {
        return a.a(eGLDisplay, 3, d);
    }

    @RequiresApi(17)
    public static EGLDisplay l() {
        return a.b();
    }

    public static int m() {
        int iY = y();
        d(36197, iY);
        return iY;
    }

    public static int n(int i) {
        f(!gj9.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        g();
        GLES20.glBindFramebuffer(36160, iArr[0]);
        g();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        g();
        return iArr[0];
    }

    @RequiresApi(17)
    public static EGLSurface o(EGLDisplay eGLDisplay, int i, int i2) {
        return a.c(eGLDisplay, f5262c, new int[]{12375, i, 12374, i2, 12344});
    }

    @RequiresApi(17)
    public static EGLSurface p(EGLDisplay eGLDisplay) {
        return E() ? EGL14.EGL_NO_SURFACE : o(eGLDisplay, 1, 1);
    }

    public static int q(int i, int i2) {
        c(i, i2);
        int iY = y();
        d(3553, iY);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.allocateDirect(i * i2 * 4));
        g();
        return iY;
    }

    public static float[] r(List<float[]> list) {
        float[] fArr = new float[list.size() * 4];
        for (int i = 0; i < list.size(); i++) {
            System.arraycopy(list.get(i), 0, fArr, i * 4, 4);
        }
        return fArr;
    }

    public static void s(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        g();
    }

    @RequiresApi(17)
    public static void t(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) {
        a.d(eGLDisplay, eGLContext);
    }

    @RequiresApi(17)
    public static void u(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2) {
        a.e(eGLDisplay, eGLContext, eGLSurface, 0, i, i2);
    }

    @RequiresApi(17)
    public static void v(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2, int i3) {
        a.e(eGLDisplay, eGLContext, eGLSurface, i, i2, i3);
    }

    @RequiresApi(17)
    public static void w(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        u(eGLDisplay, eGLContext, o(eGLDisplay, 1, 1), 1, 1);
    }

    @RequiresApi(17)
    public static void x(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        u(eGLDisplay, eGLContext, a.c(eGLDisplay, d, new int[]{12375, 1, 12374, 1, b, c, 12344}), 1, 1);
    }

    public static int y() {
        f(!gj9.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g();
        return iArr[0];
    }

    @RequiresApi(17)
    public static EGLSurface z(EGLDisplay eGLDisplay, Object obj) {
        return a.g(eGLDisplay, obj, f5262c, f5258a);
    }
}
