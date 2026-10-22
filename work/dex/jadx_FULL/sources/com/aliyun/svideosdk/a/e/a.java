package com.aliyun.svideosdk.a.e;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.aliyun.common.c.b.e;
import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile SurfaceTexture f25608a;
    private int c;
    private OnTextureIdCallback e;
    private d f;
    private float m;
    private int n;
    private int o;
    private NativeRecorder p;
    private c q;
    private AliyunRecordVideoSource r;
    private float[] b = new float[16];
    private short d = 1;
    private int g = 0;
    private com.aliyun.svideosdk.a.d.a h = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a i = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a j = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a k = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a l = new com.aliyun.svideosdk.a.d.b();

    /* JADX INFO: renamed from: com.aliyun.svideosdk.a.e.a$a, reason: collision with other inner class name */
    public class C0217a implements NativeRecorder.TextureCallback {
        public C0217a() {
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback
        public int onDestroyTexture() {
            if (a.this.e == null) {
                return 0;
            }
            a.this.e.onTextureDestroyed();
            return 0;
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback
        public int onPostTexture(int i, int i2, int i3) {
            int iOnScaledIdBack;
            if (a.this.e != null) {
                a.this.k.c();
                iOnScaledIdBack = a.this.e.onScaledIdBack(i, i2, i3, null);
                a.this.k.b();
            } else {
                iOnScaledIdBack = i;
            }
            return iOnScaledIdBack == 0 ? i : iOnScaledIdBack;
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback
        public int onPreTexture(int i, int i2, int i3) {
            int iOnTextureIdBack;
            a.this.s();
            if (a.this.e != null) {
                a.this.k.c();
                iOnTextureIdBack = a.this.e.onTextureIdBack(i, i2, i3, a.this.b);
                a.this.k.b();
            } else {
                iOnTextureIdBack = i;
            }
            return iOnTextureIdBack == 0 ? i : iOnTextureIdBack;
        }
    }

    public class b implements NativeRecorder.ScreenshotCallback {
        public b() {
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.ScreenshotCallback
        public void onScreenshot(int i, int i2, byte[] bArr, int i3) {
            if (a.this.f != null) {
                a.this.f.a(i, i2, ByteBuffer.wrap(bArr));
            }
        }
    }

    public interface c {
        void b(int i);
    }

    public interface d {
        void a(int i, int i2, ByteBuffer byteBuffer);
    }

    public a(e eVar, NativeRecorder nativeRecorder) {
        this.p = nativeRecorder;
    }

    private int a() {
        this.c = this.p.createTexture();
        this.f25608a = new SurfaceTexture(this.c);
        return 0;
    }

    public int a(int i, int i2) {
        synchronized (this) {
            try {
                if (i > 0 && i2 > 0) {
                    this.r.getStickerManager().setDisplaySize(this.r.getNativeHandle(), i, i2);
                    this.p.updateSource(this.r);
                    return 0;
                }
                Log.e("AliYunLog", "Invalid fbo width[" + i + "] or height[" + i2 + "]");
                return -20003002;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(int i, int i2, int i3) {
        synchronized (this) {
            try {
                if (i > 0 && i2 > 0) {
                    this.r.setCaptureSurface(this.f25608a, i, i2, i3);
                    this.p.updateSource(this.r);
                    return 0;
                }
                Log.e("AliYunLog", "Invalid capture width[" + i + "] or height[" + i2 + "]");
                return -20003002;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(int i, Bitmap bitmap, float f, float f2, float f3, float f4, float f5) {
        this.r.getStickerManager().addBitmapSticker(i, bitmap, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), f, f2, f3, f4, f5);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(int i, String str, float f, float f2, float f3, float f4, float f5) {
        this.r.getStickerManager().addSticker(i, str, f, f2, f3, f4, f5);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(Surface surface) {
        this.r.setDisplay(surface);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(AliyunRecordVideoSource aliyunRecordVideoSource) {
        if (this.d != 1) {
            Log.e("AliYunLog", "CameraRender has been already initialized!");
            return -4;
        }
        synchronized (this) {
            this.r = aliyunRecordVideoSource;
            this.p.setTextureCallback(aliyunRecordVideoSource, new C0217a());
            this.p.setScreenshotCallback(new b());
        }
        a();
        this.d = (short) 2;
        this.p.startPreview();
        return 0;
    }

    public int a(String str) {
        this.r.setFilterInfo(str);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(String str, int i, float f, float f2, float f3, float f4, float f5, boolean z, long j, int i2) {
        this.r.getStickerManager().addGifSticker(i, str, f, f2, f3, f4, f5, z, 0L, j, i2 == 1);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(String str, String str2) {
        if (AliyunRecorderProperty.SURFACE_ROTATION_MODE != str) {
            return -20003002;
        }
        Boolean.parseBoolean(str2);
        return 0;
    }

    public void a(float f, int i, int i2) {
        a(true, f, i, i2);
    }

    public void a(int i) {
        this.r.getStickerManager().removeSticker(i);
        this.p.updateSource(this.r);
    }

    public void a(int i, float[] fArr) {
        this.r.getStickerManager().setFacePoint(i, fArr, fArr.length);
        this.p.updateSource(this.r);
    }

    public void a(c cVar) {
        this.q = cVar;
    }

    public void a(d dVar) {
        synchronized (this) {
            this.f = dVar;
            this.p.takePhoto(this.r);
        }
    }

    public void a(OnTextureIdCallback onTextureIdCallback) {
        this.e = onTextureIdCallback;
    }

    public void a(boolean z, float f, int i, int i2) {
        if (i > 0) {
            if ((f > 0.0f) && (i2 > 0)) {
                this.m = f;
                this.n = i;
                this.o = i2;
                this.h.c();
                int i3 = this.c;
                synchronized (this) {
                    System.currentTimeMillis();
                    this.i.c();
                    c cVar = this.q;
                    if (cVar == null) {
                        this.p.addVideoBuffer(this.r, i3);
                    } else {
                        cVar.b(i3);
                    }
                    this.i.b();
                }
                this.h.b();
            }
        }
    }

    public void a(float[] fArr) {
        this.r.getStickerManager().mapScreenToOriginalPreview(fArr);
    }

    public int b() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        a(false, this.m, this.n, this.o);
        countDownLatch.countDown();
        return 0;
    }

    public int b(int i) {
        this.g = i;
        this.r.setBeautyLevel(i);
        this.p.updateSource(this.r);
        return 0;
    }

    public int b(Surface surface) {
        this.r.setDisplay(null);
        this.p.updateSource(this.r);
        return 0;
    }

    public int b(String str, String str2) {
        this.r.setAnimationFilterInfo(str, str2);
        this.p.updateSource(this.r);
        return 0;
    }

    public int c() {
        return this.g;
    }

    public AliyunRecordVideoSource d() {
        return this.r;
    }

    public com.aliyun.svideosdk.a.d.a e() {
        return this.l;
    }

    public com.aliyun.svideosdk.a.d.a f() {
        return this.i;
    }

    public com.aliyun.svideosdk.a.d.a g() {
        return this.j;
    }

    public OnTextureIdCallback h() {
        return this.e;
    }

    public com.aliyun.svideosdk.a.d.a i() {
        return this.h;
    }

    public SurfaceTexture j() {
        return this.f25608a;
    }

    public com.aliyun.svideosdk.a.d.a k() {
        return this.k;
    }

    public void l() {
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
    }

    public void m() {
        this.h.f();
        this.i.f();
        this.j.f();
        this.k.f();
    }

    public int n() {
        if (this.d == 2) {
            this.r.setDisplay(null);
            this.r.setCaptureSurface(null, 0, 0, 0);
            this.f25608a.release();
        }
        this.d = (short) 1;
        this.f25608a = null;
        return 0;
    }

    public void o() {
    }

    public int p() {
        return b(null, null);
    }

    public void q() {
        a((String) null);
    }

    public void r() {
        try {
            this.f25608a.updateTexImage();
            this.f25608a.getTransformMatrix(this.b);
        } catch (Throwable th) {
            Log.e("AliYunLog", "SurfaceTexture updateTexImage Error!", th);
        }
    }

    public void s() {
        try {
            this.f25608a.getTransformMatrix(this.b);
        } catch (Throwable th) {
            Log.e("AliYunLog", "SurfaceTexture updateTransformMatrix Error!", th);
        }
    }
}
