package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.zj.adlib.a7b;
import com.zj.adlib.kja;
import com.zj.adlib.qwb;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ee extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bitmap f25913a;
    Bitmap b;
    Bitmap c;
    ImageView d;
    IAMapDelegate e;
    Matrix f;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (!ee.this.e.isMaploaded()) {
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    ee eeVar = ee.this;
                    eeVar.d.setImageBitmap(eeVar.b);
                } else if (motionEvent.getAction() == 1) {
                    ee eeVar2 = ee.this;
                    eeVar2.d.setImageBitmap(eeVar2.f25913a);
                    CameraPosition cameraPosition = ee.this.e.getCameraPosition();
                    ee.this.e.animateCamera(kja.f(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                }
            } catch (Throwable th) {
                a7b.m(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            return false;
        }
    }

    public ee(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f = new Matrix();
        this.e = iAMapDelegate;
        try {
            Bitmap bitmapL = zwa.l(context, "maps_dav_compass_needle_large.png");
            this.c = bitmapL;
            this.b = zwa.m(bitmapL, qwb.f44317a * 0.8f);
            Bitmap bitmapM = zwa.m(this.c, qwb.f44317a * 0.7f);
            this.c = bitmapM;
            Bitmap bitmap = this.b;
            if (bitmap != null && bitmapM != null) {
                this.f25913a = Bitmap.createBitmap(bitmap.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f25913a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.c, (this.b.getWidth() - this.c.getWidth()) / 2.0f, (this.b.getHeight() - this.c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.d.setImageBitmap(this.f25913a);
                this.d.setClickable(true);
                b();
                this.d.setOnTouchListener(new a());
                addView(this.d);
            }
        } catch (Throwable th) {
            a7b.m(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f25913a;
            if (bitmap != null) {
                zwa.B(bitmap);
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                zwa.B(bitmap2);
            }
            Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                zwa.B(bitmap3);
            }
            Matrix matrix = this.f;
            if (matrix != null) {
                matrix.reset();
                this.f = null;
            }
            this.c = null;
            this.f25913a = null;
            this.b = null;
        } catch (Throwable th) {
            a7b.m(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            IAMapDelegate iAMapDelegate = this.e;
            if (iAMapDelegate == null || this.d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float cameraDegree = this.e.getCameraDegree(engineIDWithType);
            float mapAngle = this.e.getMapAngle(engineIDWithType);
            if (this.f == null) {
                this.f = new Matrix();
            }
            this.f.reset();
            this.f.postRotate(-mapAngle, this.d.getDrawable().getBounds().width() / 2.0f, this.d.getDrawable().getBounds().height() / 2.0f);
            this.f.postScale(1.0f, (float) Math.cos((((double) cameraDegree) * 3.141592653589793d) / 180.0d), this.d.getDrawable().getBounds().width() / 2.0f, this.d.getDrawable().getBounds().height() / 2.0f);
            this.d.setImageMatrix(this.f);
        } catch (Throwable th) {
            a7b.m(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
        } else {
            setVisibility(8);
        }
    }
}
