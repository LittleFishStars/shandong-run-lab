package com.amap.api.col.p0003l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.zj.adlib.axa;
import com.zj.adlib.bxa;
import com.zj.adlib.ewa;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n extends GLSurfaceView implements IGLSurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GLMapRender f26038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f1070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected boolean f1071a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (n.this.f26038a != null) {
                try {
                    n.this.f26038a.onSurfaceDestory();
                } catch (Throwable th) {
                    th.printStackTrace();
                    zwa.D(th);
                }
            }
        }
    }

    public n(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        bxa.e(axa.f40634a, "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f26038a;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        bxa.e(axa.f40634a, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            GLMapRender gLMapRender = this.f26038a;
            if (gLMapRender != null) {
                gLMapRender.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
        bxa.e(axa.f40634a, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f26038a;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                zwa.D(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        bxa.e(axa.f40634a, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f26038a.mSurfacedestoryed);
        if (!this.f26038a.mSurfacedestoryed) {
            queueEvent(new a());
            int i = 0;
            while (!this.f26038a.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i = i2;
            }
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        bxa.e(axa.f40634a, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f1070a.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        bxa.e(axa.f40634a, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i == 8 || i == 4) {
                GLMapRender gLMapRender = this.f26038a;
                if (gLMapRender != null) {
                    gLMapRender.renderPause();
                    this.f1071a = false;
                }
            } else {
                if (i != 0) {
                    return;
                }
                GLMapRender gLMapRender2 = this.f26038a;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(g gVar) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) gVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(h hVar) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) hVar);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f26038a = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    public n(Context context, boolean z, byte b) {
        super(context, null);
        this.f1070a = null;
        this.f26038a = null;
        this.f1071a = false;
        ewa.a(this);
        this.f1070a = new l(this, context, z);
    }

    public final IAMapDelegate a() {
        return this.f1070a;
    }
}
