package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.zj.adlib.axa;
import com.zj.adlib.bxa;
import com.zj.adlib.ewa;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class o extends y implements IGLSurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GLMapRender f26040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f1072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected boolean f1073a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (o.this.f26040a != null) {
                    o.this.f26040a.onSurfaceDestory();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                zwa.D(th);
            }
        }
    }

    public o(Context context, boolean z) {
        super(context);
        this.f1072a = null;
        this.f26040a = null;
        this.f1073a = false;
        ewa.a(this);
        this.f1072a = new l(this, context, z);
    }

    @Override // com.amap.api.col.p0003l.y
    public final void b() {
        bxa.e(axa.f40634a, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f26040a.mSurfacedestoryed);
        if (!this.f26040a.mSurfacedestoryed) {
            queueEvent(new a());
            int i = 0;
            while (!this.f26040a.mSurfacedestoryed) {
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
        super.b();
    }

    @Override // com.amap.api.col.p0003l.y
    public final void c() {
        super.c();
        bxa.e(axa.f40634a, "AMapGLTextureView onResume");
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        bxa.e(axa.f40634a, "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f26040a;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    @Override // com.amap.api.col.p0003l.y, android.view.View
    public final void onDetachedFromWindow() {
        bxa.e(axa.f40634a, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        b();
        try {
            GLMapRender gLMapRender = this.f26040a;
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
        bxa.e(axa.f40634a, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                GLMapRender gLMapRender = this.f26040a;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        bxa.e(axa.f40634a, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f1072a.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i);
        bxa.e(axa.f40634a, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i != 8 && i != 4) {
                if (i != 0 || (gLMapRender = this.f26040a) == null) {
                    return;
                }
                gLMapRender.renderResume();
                return;
            }
            GLMapRender gLMapRender2 = this.f26040a;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.f1073a = false;
            }
            requestRender();
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(g gVar) {
        super.a(gVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(h hVar) {
        super.a(hVar);
    }

    @Override // com.amap.api.col.p0003l.y, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f26040a = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z) {
    }

    public final IAMapDelegate a() {
        return this.f1072a;
    }
}
