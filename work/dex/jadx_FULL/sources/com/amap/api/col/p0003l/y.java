package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import com.heytap.mcssdk.constant.MessageConstant;
import com.zj.adlib.wg6;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public class y extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f26065a = new j(0);
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GLSurfaceView.Renderer f1127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f1128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f1129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f1130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f1131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f1132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<y> f1133a;
    public boolean b;
    public boolean c;

    public abstract class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f1134a;

        public a(int[] iArr) {
            this.f1134a = b(iArr);
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public final int[] b(int[] iArr) {
            if (y.this.L != 2 && y.this.L != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (y.this.L == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.amap.api.col.3l.y.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f1134a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f1134a, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig eGLConfigA = a(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigA != null) {
                return eGLConfigA;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    public class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26067a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int[] f1136b;
        public int c;
        public int d;
        public int e;
        public int f;

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
            this.f1136b = new int[1];
            this.f26067a = 8;
            this.b = 8;
            this.c = 8;
            this.d = 0;
            this.e = 16;
            this.f = 0;
        }

        @Override // com.amap.api.col.3l.y.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int iC = c(egl10, eGLDisplay, eGLConfig, 12325);
                int iC2 = c(egl10, eGLDisplay, eGLConfig, 12326);
                if (iC >= this.e && iC2 >= this.f) {
                    int iC3 = c(egl10, eGLDisplay, eGLConfig, 12324);
                    int iC4 = c(egl10, eGLDisplay, eGLConfig, 12323);
                    int iC5 = c(egl10, eGLDisplay, eGLConfig, 12322);
                    int iC6 = c(egl10, eGLDisplay, eGLConfig, 12321);
                    if (iC3 == this.f26067a && iC4 == this.b && iC5 == this.c && iC6 == this.d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f1136b)) {
                return this.f1136b[0];
            }
            return 0;
        }
    }

    public class c implements f {
        public c() {
        }

        @Override // com.amap.api.col.3l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {wg6.O, y.this.L, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (y.this.L == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.col.3l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.c("eglDestroyContex", egl10.eglGetError());
        }

        public /* synthetic */ c(y yVar, byte b) {
            this();
        }
    }

    public static class d implements g {
        public d() {
        }

        @Override // com.amap.api.col.3l.y.g
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        @Override // com.amap.api.col.3l.y.g
        public final EGLSurface b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface g {
        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);

        EGLSurface b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<y> f26069a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EGL10 f1137a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EGLConfig f1138a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EGLContext f1139a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EGLDisplay f1140a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EGLSurface f1141a;

        public h(WeakReference<y> weakReference) {
            this.f26069a = weakReference;
        }

        public static void c(String str, int i) {
            throw new RuntimeException(e(str, i));
        }

        public static void d(String str, String str2, int i) {
            Log.w(str, e(str2, i));
        }

        public static String e(String str, int i) {
            return str + " failed: " + i;
        }

        public final void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f1137a = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f1140a = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f1137a.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            y yVar = this.f26069a.get();
            if (yVar == null) {
                this.f1138a = null;
                this.f1139a = null;
            } else {
                this.f1138a = yVar.f1128a.chooseConfig(this.f1137a, this.f1140a);
                this.f1139a = yVar.f1129a.createContext(this.f1137a, this.f1140a, this.f1138a);
            }
            EGLContext eGLContext = this.f1139a;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f1139a = null;
                b("createContext");
            }
            this.f1141a = null;
        }

        public final void b(String str) {
            c(str, this.f1137a.eglGetError());
        }

        public final boolean f() {
            if (this.f1137a == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f1140a == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f1138a == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            k();
            y yVar = this.f26069a.get();
            if (yVar != null) {
                this.f1141a = yVar.f1130a.b(this.f1137a, this.f1140a, this.f1138a, yVar.getSurfaceTexture());
            } else {
                this.f1141a = null;
            }
            EGLSurface eGLSurface = this.f1141a;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.f1137a.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            if (this.f1137a.eglMakeCurrent(this.f1140a, eGLSurface, eGLSurface, this.f1139a)) {
                return true;
            }
            d("EGLHelper", "eglMakeCurrent", this.f1137a.eglGetError());
            return false;
        }

        public final GL g() {
            GL gl = this.f1139a.getGL();
            y yVar = this.f26069a.get();
            if (yVar == null) {
                return gl;
            }
            if (yVar.f1132a != null) {
                gl = yVar.f1132a.a();
            }
            if ((yVar.K & 3) != 0) {
                return GLDebugHelper.wrap(gl, (yVar.K & 1) == 0 ? 0 : 1, (yVar.K & 2) != 0 ? new l() : null);
            }
            return gl;
        }

        public final int h() {
            return !this.f1137a.eglSwapBuffers(this.f1140a, this.f1141a) ? this.f1137a.eglGetError() : MessageConstant.CommandId.COMMAND_BASE;
        }

        public final void i() {
            k();
        }

        public final void j() {
            if (this.f1139a != null) {
                y yVar = this.f26069a.get();
                if (yVar != null) {
                    yVar.f1129a.destroyContext(this.f1137a, this.f1140a, this.f1139a);
                }
                this.f1139a = null;
            }
            EGLDisplay eGLDisplay = this.f1140a;
            if (eGLDisplay != null) {
                this.f1137a.eglTerminate(eGLDisplay);
                this.f1140a = null;
            }
        }

        public final void k() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f1141a;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f1137a.eglMakeCurrent(this.f1140a, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            y yVar = this.f26069a.get();
            if (yVar != null) {
                yVar.f1130a.a(this.f1137a, this.f1140a, this.f1141a);
            }
            this.f1141a = null;
        }
    }

    public static class i extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f26070a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<y> f1142a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1144a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean m;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<Runnable> f1143a = new ArrayList<>();
        public boolean n = true;
        public int K = 0;
        public int L = 0;
        public boolean l = true;
        public int M = 1;

        public i(WeakReference<y> weakReference) {
            this.f1142a = weakReference;
        }

        public static /* synthetic */ boolean f(i iVar) {
            iVar.b = true;
            return true;
        }

        public final int b() {
            int i;
            synchronized (y.f26065a) {
                i = this.M;
            }
            return i;
        }

        public final void c(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (y.f26065a) {
                this.M = i;
                y.f26065a.notifyAll();
            }
        }

        public final void d(int i, int i2) {
            synchronized (y.f26065a) {
                this.K = i;
                this.L = i2;
                this.n = true;
                this.l = true;
                this.m = false;
                y.f26065a.notifyAll();
                while (!this.b && !this.d && !this.m && s()) {
                    try {
                        y.f26065a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void e(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (y.f26065a) {
                this.f1143a.add(runnable);
                y.f26065a.notifyAll();
            }
        }

        public final void g() {
            synchronized (y.f26065a) {
                this.l = true;
                y.f26065a.notifyAll();
            }
        }

        public final void h() {
            synchronized (y.f26065a) {
                this.e = true;
                this.j = false;
                y.f26065a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        y.f26065a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void i() {
            synchronized (y.f26065a) {
                this.e = false;
                y.f26065a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            y.f26065a.wait();
                        } else {
                            y.f26065a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void j() {
            synchronized (y.f26065a) {
                this.c = true;
                y.f26065a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            y.f26065a.wait();
                        } else {
                            y.f26065a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void k() {
            synchronized (y.f26065a) {
                this.c = false;
                this.l = true;
                this.m = false;
                y.f26065a.notifyAll();
                while (!this.b && this.d && !this.m) {
                    try {
                        y.f26065a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void l() {
            synchronized (y.f26065a) {
                this.f1144a = true;
                y.f26065a.notifyAll();
                while (!this.b) {
                    try {
                        y.f26065a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void m() {
            this.k = true;
            y.f26065a.notifyAll();
        }

        public final int n() {
            int i;
            synchronized (y.f26065a) {
                i = this.K;
            }
            return i;
        }

        public final int o() {
            int i;
            synchronized (y.f26065a) {
                i = this.L;
            }
            return i;
        }

        public final void p() {
            if (this.i) {
                this.i = false;
                this.f26070a.i();
            }
        }

        public final void q() {
            if (this.h) {
                this.f26070a.j();
                this.h = false;
                y.f26065a.g(this);
            }
        }

        /* JADX WARN: Code duplicated, block: B:170:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public final void r() throws InterruptedException {
            boolean z;
            boolean z2;
            this.f26070a = new h(this.f1142a);
            this.h = false;
            this.i = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int i = 0;
            int i2 = 0;
            boolean z10 = false;
            GL10 gl10 = null;
            while (true) {
                Runnable runnableRemove = null;
                while (true) {
                    try {
                        synchronized (y.f26065a) {
                            while (true) {
                                if (this.f1144a) {
                                    synchronized (y.f26065a) {
                                        p();
                                        q();
                                    }
                                    return;
                                }
                                if (!this.f1143a.isEmpty()) {
                                    runnableRemove = this.f1143a.remove(0);
                                    z = false;
                                    break;
                                }
                                boolean z11 = this.d;
                                boolean z12 = this.c;
                                if (z11 != z12) {
                                    this.d = z12;
                                    y.f26065a.notifyAll();
                                } else {
                                    z12 = false;
                                }
                                if (this.k) {
                                    p();
                                    q();
                                    this.k = false;
                                    z5 = true;
                                }
                                if (z3) {
                                    p();
                                    q();
                                    z3 = false;
                                }
                                if (z12 && this.i) {
                                    p();
                                }
                                if (z12 && this.h) {
                                    y yVar = this.f1142a.get();
                                    if (!(yVar == null ? false : yVar.c) || y.f26065a.c()) {
                                        q();
                                    }
                                }
                                if (z12 && y.f26065a.d()) {
                                    this.f26070a.j();
                                }
                                if (!this.e && !this.g) {
                                    if (this.i) {
                                        p();
                                    }
                                    this.g = true;
                                    this.f = false;
                                    y.f26065a.notifyAll();
                                }
                                if (this.e && this.g) {
                                    this.g = false;
                                    y.f26065a.notifyAll();
                                }
                                if (z4) {
                                    this.m = true;
                                    y.f26065a.notifyAll();
                                    z4 = false;
                                    z10 = false;
                                }
                                if (t()) {
                                    if (!this.h) {
                                        if (z5) {
                                            z5 = false;
                                        } else if (y.f26065a.e(this)) {
                                            try {
                                                this.f26070a.a();
                                                this.h = true;
                                                y.f26065a.notifyAll();
                                                z6 = true;
                                            } catch (RuntimeException e) {
                                                y.f26065a.g(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.h && !this.i) {
                                        this.i = true;
                                        z7 = true;
                                        z8 = true;
                                        z9 = true;
                                    }
                                    if (this.i) {
                                        if (this.n) {
                                            int i3 = this.K;
                                            int i4 = this.L;
                                            this.n = false;
                                            i = i3;
                                            i2 = i4;
                                            z = false;
                                            z7 = true;
                                            z9 = true;
                                            z10 = true;
                                        } else {
                                            z = false;
                                        }
                                        this.l = z;
                                        y.f26065a.notifyAll();
                                        break;
                                    }
                                }
                                y.f26065a.wait();
                            }
                        }
                        if (runnableRemove != null) {
                            break;
                        }
                        if (z7) {
                            if (this.f26070a.f()) {
                                synchronized (y.f26065a) {
                                    this.j = true;
                                    y.f26065a.notifyAll();
                                }
                                z7 = z;
                            } else {
                                synchronized (y.f26065a) {
                                    this.j = true;
                                    this.f = true;
                                    y.f26065a.notifyAll();
                                }
                            }
                            synchronized (y.f26065a) {
                                p();
                                q();
                                throw th;
                            }
                        }
                        if (z8) {
                            gl10 = (GL10) this.f26070a.g();
                            y.f26065a.b(gl10);
                            z8 = z;
                        }
                        if (z6) {
                            y yVar2 = this.f1142a.get();
                            if (yVar2 != null) {
                                yVar2.f1127a.onSurfaceCreated(gl10, this.f26070a.f1138a);
                            }
                            z6 = z;
                        }
                        if (z9) {
                            y yVar3 = this.f1142a.get();
                            if (yVar3 != null) {
                                yVar3.f1127a.onSurfaceChanged(gl10, i, i2);
                            }
                            z9 = z;
                        }
                        y yVar4 = this.f1142a.get();
                        if (yVar4 != null) {
                            yVar4.f1127a.onDrawFrame(gl10);
                        }
                        int iH = this.f26070a.h();
                        if (iH == 12288) {
                            z2 = true;
                        } else if (iH != 12302) {
                            h.d("GLThread", "eglSwapBuffers", iH);
                            synchronized (y.f26065a) {
                                z2 = true;
                                this.f = true;
                                y.f26065a.notifyAll();
                            }
                        } else {
                            z2 = true;
                            z3 = true;
                        }
                        if (z10) {
                            z4 = z2;
                        }
                    } catch (Throwable th) {
                        synchronized (y.f26065a) {
                            p();
                            q();
                            throw th;
                        }
                    }
                }
                runnableRemove.run();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                r();
            } catch (InterruptedException unused) {
            } finally {
                y.f26065a.a(this);
            }
        }

        public final boolean s() {
            return this.h && this.i && t();
        }

        public final boolean t() {
            if (this.d || !this.e || this.f || this.K <= 0 || this.L <= 0) {
                return false;
            }
            return this.l || this.M == 1;
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f26071a = "GLThreadManager";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f1145a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i f1146a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1147a;
        public boolean b;
        public boolean c;
        public boolean d;

        public j() {
        }

        public final synchronized void a(i iVar) {
            i.f(iVar);
            if (this.f1146a == iVar) {
                this.f1146a = null;
            }
            notifyAll();
        }

        public final synchronized void b(GL10 gl10) {
            if (!this.b && gl10 != null) {
                f();
                String strGlGetString = gl10.glGetString(7937);
                if (this.f1145a < 131072) {
                    this.c = !strGlGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.d = this.c ? false : true;
                this.b = true;
            }
        }

        public final synchronized boolean c() {
            return this.d;
        }

        public final synchronized boolean d() {
            f();
            return !this.c;
        }

        public final boolean e(i iVar) {
            i iVar2 = this.f1146a;
            if (iVar2 == iVar || iVar2 == null) {
                this.f1146a = iVar;
                notifyAll();
                return true;
            }
            f();
            if (this.c) {
                return true;
            }
            i iVar3 = this.f1146a;
            if (iVar3 == null) {
                return false;
            }
            iVar3.m();
            return false;
        }

        public final void f() {
            if (this.f1147a) {
                return;
            }
            this.f1145a = 131072;
            this.c = true;
            this.f1147a = true;
        }

        public final void g(i iVar) {
            if (this.f1146a == iVar) {
                this.f1146a = null;
            }
            notifyAll();
        }

        public /* synthetic */ j(byte b) {
            this();
        }
    }

    public interface k {
        GL a();
    }

    public static class l extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f26072a = new StringBuilder();

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            g();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            g();
        }

        public final void g() {
            if (this.f26072a.length() > 0) {
                Log.v("GLSurfaceView", this.f26072a.toString());
                StringBuilder sb = this.f26072a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    g();
                } else {
                    this.f26072a.append(c);
                }
            }
        }
    }

    public class m extends b {
        public m() {
            super();
        }
    }

    public y(Context context) {
        super(context, null);
        this.f1133a = new WeakReference<>(this);
        e();
    }

    public static boolean g() {
        return false;
    }

    public void finalize() throws Throwable {
        try {
            i iVar = this.f1131a;
            if (iVar != null) {
                iVar.l();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f1131a.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b && this.f1127a != null) {
            i iVar = this.f1131a;
            int iB = iVar != null ? iVar.b() : 1;
            i iVar2 = new i(this.f1133a);
            this.f1131a = iVar2;
            if (iB != 1) {
                iVar2.c(iB);
            }
            this.f1131a.start();
        }
        this.b = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        i iVar = this.f1131a;
        if (iVar != null) {
            iVar.l();
        }
        this.b = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f1131a.h();
        if (g() || MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        } else {
            if (this.f1131a.n() == i2 && this.f1131a.o() == i3) {
                return;
            }
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f1131a.i();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f1131a.d(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f1131a.e(runnable);
    }

    public void requestRender() {
        this.f1131a.g();
    }

    public void setRenderMode(int i2) {
        this.f1131a.c(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        f();
        if (this.f1128a == null) {
            this.f1128a = new m();
        }
        byte b2 = 0;
        if (this.f1129a == null) {
            this.f1129a = new c(this, b2);
        }
        if (this.f1130a == null) {
            this.f1130a = new d(b2);
        }
        this.f1127a = renderer;
        i iVar = new i(this.f1133a);
        this.f1131a = iVar;
        iVar.start();
    }

    public final void a(f fVar) {
        f();
        this.f1129a = fVar;
    }

    public void b() {
        this.f1131a.j();
    }

    public void c() {
        this.f1131a.k();
    }

    public final void e() {
        setSurfaceTextureListener(this);
    }

    public final void f() {
        if (this.f1131a != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public final void a(e eVar) {
        f();
        this.f1128a = eVar;
    }
}
