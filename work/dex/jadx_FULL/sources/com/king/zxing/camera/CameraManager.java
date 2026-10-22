package com.king.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import com.zj.adlib.aa6;
import com.zj.adlib.es6;
import com.zj.adlib.gi0;
import com.zj.adlib.tb1;
import com.zj.adlib.u15;
import com.zj.adlib.wx6;
import com.zj.adlib.z96;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class CameraManager {
    public static final int f = 240;
    public static final int g = 240;
    public static final int h = 1200;
    public static final int i = 675;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15049a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f15050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f15051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnSensorListener f15052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTorchListener f15053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gi0 f15054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tb1 f15055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wx6 f15056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z96 f15057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15058a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Rect f15059b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15060b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15061c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f15062d;
    public int e;

    public interface OnSensorListener {
        void a(boolean z, boolean z2, float f);
    }

    public interface OnTorchListener {
        void a(boolean z);
    }

    public CameraManager(Context context) {
        this.f15050a = context.getApplicationContext();
        tb1 tb1Var = new tb1(context);
        this.f15055a = tb1Var;
        this.f15056a = new wx6(tb1Var);
    }

    public es6 a(byte[] bArr, int i2, int i3) {
        if (e() == null) {
            return null;
        }
        if (this.f15061c) {
            return new es6(bArr, i2, i3, 0, 0, i2, i3, false);
        }
        int iMin = (int) (Math.min(i2, i3) * this.f40021a);
        return new es6(bArr, i2, i3, ((i2 - iMin) / 2) + this.e, ((i3 - iMin) / 2) + this.d, iMin, iMin, false);
    }

    public void b() {
        z96 z96Var = this.f15057a;
        if (z96Var != null) {
            z96Var.a().release();
            this.f15057a = null;
            this.f15051a = null;
            this.f15059b = null;
        }
        this.f15062d = false;
        OnTorchListener onTorchListener = this.f15053a;
        if (onTorchListener != null) {
            onTorchListener.a(false);
        }
    }

    public Point c() {
        return this.f15055a.d();
    }

    public synchronized Rect d() {
        if (this.f15051a == null) {
            if (this.f15057a == null) {
                return null;
            }
            Point pointD = this.f15055a.d();
            if (pointD == null) {
                return null;
            }
            int i2 = pointD.x;
            int i3 = pointD.y;
            if (this.f15061c) {
                this.f15051a = new Rect(0, 0, i2, i3);
            } else {
                int iMin = (int) (Math.min(i2, i3) * this.f40021a);
                int i4 = ((i2 - iMin) / 2) + this.e;
                int i5 = ((i3 - iMin) / 2) + this.d;
                this.f15051a = new Rect(i4, i5, i4 + iMin, iMin + i5);
            }
        }
        return this.f15051a;
    }

    public synchronized Rect e() {
        if (this.f15059b == null) {
            Rect rectD = d();
            if (rectD == null) {
                return null;
            }
            Rect rect = new Rect(rectD);
            Point pointD = this.f15055a.d();
            Point pointF = this.f15055a.f();
            if (pointD != null && pointF != null) {
                int i2 = rect.left;
                int i3 = pointD.y;
                int i4 = pointF.x;
                rect.left = (i2 * i3) / i4;
                rect.right = (rect.right * i3) / i4;
                int i5 = rect.top;
                int i6 = pointD.x;
                int i7 = pointF.y;
                rect.top = (i5 * i6) / i7;
                rect.bottom = (rect.bottom * i6) / i7;
                this.f15059b = rect;
            }
            return null;
        }
        return this.f15059b;
    }

    public z96 f() {
        return this.f15057a;
    }

    public Point g() {
        return this.f15055a.f();
    }

    public synchronized boolean h() {
        return this.f15057a != null;
    }

    public void i(SurfaceHolder surfaceHolder) throws IOException {
        int i2;
        z96 z96VarA = this.f15057a;
        if (z96VarA == null) {
            z96VarA = aa6.a(this.f15049a);
            if (z96VarA == null) {
                throw new IOException("Camera.open() failed to return object from driver");
            }
            this.f15057a = z96VarA;
        }
        if (!this.f15058a) {
            this.f15058a = true;
            this.f15055a.h(z96VarA);
            int i3 = this.b;
            if (i3 > 0 && (i2 = this.c) > 0) {
                q(i3, i2);
                this.b = 0;
                this.c = 0;
            }
        }
        Camera cameraA = z96VarA.a();
        Camera.Parameters parameters = cameraA.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.f15055a.j(z96VarA, false);
        } catch (RuntimeException unused) {
            u15.z("Camera rejected parameters. Setting only minimal safe-mode parameters");
            u15.l("Resetting to saved camera params: " + strFlatten);
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraA.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraA.setParameters(parameters2);
                    this.f15055a.j(z96VarA, true);
                } catch (RuntimeException unused2) {
                    u15.z("Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
        cameraA.setPreviewDisplay(surfaceHolder);
    }

    public synchronized void j(Handler handler, int i2) {
        z96 z96Var = this.f15057a;
        if (z96Var != null && this.f15060b) {
            this.f15056a.a(handler, i2);
            z96Var.a().setOneShotPreviewCallback(this.f15056a);
        }
    }

    public void k(boolean z, float f2) {
        OnSensorListener onSensorListener = this.f15052a;
        if (onSensorListener != null) {
            onSensorListener.a(this.f15062d, z, f2);
        }
    }

    public void l(int i2) {
        this.e = i2;
    }

    public void m(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f2) {
        this.f40021a = f2;
    }

    public void n(int i2) {
        this.d = i2;
    }

    public void o(boolean z) {
        this.f15061c = z;
    }

    public synchronized void p(int i2) {
        this.f15049a = i2;
    }

    public synchronized void q(int i2, int i3) {
        if (this.f15058a) {
            Point pointF = this.f15055a.f();
            int i4 = pointF.x;
            if (i2 > i4) {
                i2 = i4;
            }
            int i5 = pointF.y;
            if (i3 > i5) {
                i3 = i5;
            }
            int i6 = (i4 - i2) / 2;
            int i7 = (i5 - i3) / 2;
            this.f15051a = new Rect(i6, i7, i2 + i6, i3 + i7);
            u15.a("Calculated manual framing rect: " + this.f15051a);
            this.f15059b = null;
        } else {
            this.b = i2;
            this.c = i3;
        }
    }

    public synchronized void r(boolean z) {
        z96 z96Var = this.f15057a;
        if (z96Var != null && z != this.f15055a.g(z96Var.a())) {
            gi0 gi0Var = this.f15054a;
            boolean z2 = gi0Var != null;
            if (z2) {
                gi0Var.d();
                this.f15054a = null;
            }
            this.f15062d = z;
            this.f15055a.k(z96Var.a(), z);
            if (z2) {
                gi0 gi0Var2 = new gi0(this.f15050a, z96Var.a());
                this.f15054a = gi0Var2;
                gi0Var2.c();
            }
            OnTorchListener onTorchListener = this.f15053a;
            if (onTorchListener != null) {
                onTorchListener.a(z);
            }
        }
    }

    public void s() {
        z96 z96Var = this.f15057a;
        if (z96Var == null || this.f15060b) {
            return;
        }
        z96Var.a().startPreview();
        this.f15060b = true;
        this.f15054a = new gi0(this.f15050a, z96Var.a());
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        this.f15052a = onSensorListener;
    }

    public void setOnTorchListener(OnTorchListener onTorchListener) {
        this.f15053a = onTorchListener;
    }

    public void t() {
        gi0 gi0Var = this.f15054a;
        if (gi0Var != null) {
            gi0Var.d();
            this.f15054a = null;
        }
        z96 z96Var = this.f15057a;
        if (z96Var == null || !this.f15060b) {
            return;
        }
        z96Var.a().stopPreview();
        this.f15056a.a(null, 0);
        this.f15060b = false;
    }
}
