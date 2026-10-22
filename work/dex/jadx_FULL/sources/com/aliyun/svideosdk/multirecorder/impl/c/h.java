package com.aliyun.svideosdk.multirecorder.impl.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.aliyun.svideosdk.multirecorder.AliyunIViewCapture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends com.aliyun.svideosdk.multirecorder.impl.c.f implements AliyunIViewCapture {
    private View m;
    private com.aliyun.svideosdk.multirecorder.impl.c.i.a.c<Bitmap> s;
    private volatile boolean n = false;
    private Object p = new Object();
    private com.aliyun.common.d.a q = null;
    private f r = f.AUTO;
    private Handler o = new Handler(Looper.getMainLooper());

    public class a implements com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.e.b f25804a;

        public a(h hVar, com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
            this.f25804a = bVar;
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a
        public void a(Bitmap bitmap) {
            this.f25804a.a(bitmap);
        }
    }

    public class b implements com.aliyun.svideosdk.multirecorder.impl.c.e.b<Bitmap> {
        public b() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.b
        public void a(Bitmap bitmap) {
            synchronized (h.this.p) {
                h hVar = h.this;
                hVar.a(hVar.q);
                h.this.q = bitmap == null ? null : new com.aliyun.common.d.a(bitmap);
                h.this.l();
            }
            h.this.n = false;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.e.b f25806a;

        public c(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
            this.f25806a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.b((com.aliyun.svideosdk.multirecorder.impl.c.e.b<Bitmap>) this.f25806a);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.o();
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25808a;

        static {
            int[] iArr = new int[f.values().length];
            f25808a = iArr;
            try {
                iArr[f.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25808a[f.THREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum f {
        AUTO,
        ONE,
        TWO,
        THREE
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.aliyun.common.d.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.c();
    }

    private boolean a(View view, int i) {
        if (view != null && view.getVisibility() == 0) {
            if (view instanceof SurfaceView) {
                return i != 0;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (a(viewGroup.getChildAt(i2), i + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.aliyun.svideosdk.multirecorder.impl.c.e.b<Bitmap> bVar) {
        if (this.s == null) {
            this.s = r();
            com.aliyun.common.c.a.a.a("AliYunLog", "bestViewCapturePolicy " + this.s.a());
        }
        this.s.a(this.m, new a(this, bVar));
    }

    private boolean q() {
        return AlivcSdkCore.AlivcLogLevel.AlivcLogClose != AlivcSdkCore.getLogLevel() && AlivcSdkCore.AlivcLogLevel.AlivcLogDebug.getValue() >= AlivcSdkCore.getLogLevel().getValue();
    }

    private com.aliyun.svideosdk.multirecorder.impl.c.i.a.c r() {
        View view = this.m;
        if (view instanceof TextureView) {
            if (this.r == f.TWO && view.isAttachedToWindow()) {
                View view2 = this.m;
                if ((view2 instanceof SurfaceView) || (view2.getContext() instanceof Activity)) {
                    return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d();
                }
            }
            return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.e();
        }
        if (view.isAttachedToWindow()) {
            View view3 = this.m;
            if ((view3 instanceof SurfaceView) || (view3.getContext() instanceof Activity)) {
                if (this.m instanceof SurfaceView) {
                    return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d();
                }
                int i = e.f25808a[this.r.ordinal()];
                if (i != 1) {
                    return i != 2 ? new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d() : new com.aliyun.svideosdk.multirecorder.impl.c.i.a.b();
                }
                return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.a();
            }
        }
        return this.r == f.THREE ? new com.aliyun.svideosdk.multirecorder.impl.c.i.a.b() : new com.aliyun.svideosdk.multirecorder.impl.c.i.a.a();
    }

    private boolean s() {
        return AlivcSdkCore.AlivcLogLevel.AlivcLogClose != AlivcSdkCore.getLogLevel() && AlivcSdkCore.AlivcLogLevel.AlivcLogError.getValue() >= AlivcSdkCore.getLogLevel().getValue();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        if (i > 60) {
            i = 60;
        }
        super.a(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
        com.aliyun.common.d.a aVar;
        synchronized (this.p) {
            aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
        }
        bVar.a(aVar);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(boolean z) {
        p();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.f, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        super.destroy();
        this.n = false;
        synchronized (this.p) {
            a(this.q);
            this.q = null;
        }
        this.o.removeCallbacksAndMessages(null);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public com.aliyun.svideosdk.multirecorder.impl.c.e.a e() {
        return com.aliyun.svideosdk.multirecorder.impl.c.e.a.BITMAP;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.f
    public void o() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o.post(new c(new b()));
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIViewCapture
    public void setCaptureView(View view) {
        if (view == null) {
            throw new RuntimeException("captureView should be not null");
        }
        if (this.m != null) {
            throw new RuntimeException("Already set capture view");
        }
        if (s() && a(view, 0)) {
            if (q()) {
                throw new RuntimeException("The captureView should not contains SurfaceView");
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "The captureView should not contains SurfaceView");
        }
        this.m = view;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public int setProperty(String str, String str2) {
        f fVar;
        if (!"view_capture_policy".equals(str)) {
            return super.setProperty(str, str2);
        }
        str2.hashCode();
        switch (str2) {
            case "1":
                fVar = f.ONE;
                break;
            case "2":
                fVar = f.TWO;
                break;
            case "3":
                fVar = f.THREE;
                break;
            default:
                fVar = f.AUTO;
                break;
        }
        this.r = fVar;
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        if (!a()) {
            this.o.postDelayed(new d(), 100L);
        }
        return super.startPreview();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        c(true);
        return super.startRecording();
    }
}
