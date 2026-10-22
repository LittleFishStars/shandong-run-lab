package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.kc.dw.core.utils.SsdAdPatternType;
import com.zj.adlib.a7b;
import com.zj.adlib.qwb;
import com.zj.adlib.tu3;
import com.zj.adlib.twa;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ek extends View {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IPoint f822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f824a;
    public Paint b;
    public String f;

    public ek(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f = "";
        this.K = 0;
        this.f25930a = 0.0f;
        this.f824a = new int[]{10000000, tu3.d, 2000000, 1000000, 500000, SsdAdPatternType.MIX_RENDER, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f823a = iAMapDelegate;
        this.f820a = new Paint();
        this.f821a = new Rect();
        this.f820a.setAntiAlias(true);
        this.f820a.setColor(-16777216);
        this.f820a.setStrokeWidth(qwb.f44317a * 2.0f);
        this.f820a.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(-16777216);
        this.b.setTextSize(qwb.f44317a * 20.0f);
        this.f25930a = twa.a(context, 1.0f);
        this.f822a = new IPoint();
    }

    public final void a() {
        this.f820a = null;
        this.b = null;
        this.f821a = null;
        this.f = null;
        this.f822a = null;
    }

    public final void b(int i) {
        this.K = i;
    }

    public final void c(String str) {
        this.f = str;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f;
        if (str == null || "".equals(str) || this.K == 0 || (waterMarkerPositon = this.f823a.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.b;
        String str2 = this.f;
        paint.getTextBounds(str2, 0, str2.length(), this.f821a);
        int i = waterMarkerPositon.x;
        int iHeight = (waterMarkerPositon.y - this.f821a.height()) + 5;
        canvas.drawText(this.f, ((this.K - this.f821a.width()) / 2) + i, iHeight, this.b);
        float f = i;
        float fHeight = iHeight + (this.f821a.height() - 5);
        canvas.drawLine(f, fHeight - (this.f25930a * 2.0f), f, fHeight + qwb.f44317a, this.f820a);
        canvas.drawLine(f, fHeight, this.K + i, fHeight, this.f820a);
        int i2 = this.K;
        canvas.drawLine(i + i2, fHeight - (this.f25930a * 2.0f), i + i2, fHeight + qwb.f44317a, this.f820a);
    }

    public final void b() {
        IAMapDelegate iAMapDelegate = this.f823a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f823a.getPreciseLevel(engineIDWithType);
            this.f823a.getGeoCenter(engineIDWithType, this.f822a);
            IPoint iPoint = this.f822a;
            if (iPoint == null) {
                return;
            }
            DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
            float mapZoomScale = this.f823a.getMapZoomScale();
            double dCos = (float) ((((Math.cos((dPointPixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int i = this.f824a[(int) preciseLevel];
            int i2 = (int) (((double) i) / (dCos * ((double) mapZoomScale)));
            String strU = zwa.u(i);
            b(i2);
            c(strU);
            dPointPixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
        } else {
            c("");
            b(0);
            setVisibility(8);
        }
    }
}
