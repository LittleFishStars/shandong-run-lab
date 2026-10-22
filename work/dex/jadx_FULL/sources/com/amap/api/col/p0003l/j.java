package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.zj.adlib.a7b;
import com.zj.adlib.kja;
import com.zj.adlib.qwb;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class j extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f25979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f933a;
    public Bitmap b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f934b;
    public Bitmap c;
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;
    public Bitmap g;
    public Bitmap h;
    public Bitmap i;
    public Bitmap j;
    public Bitmap k;
    public Bitmap l;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (j.this.f933a.getZoomLevel() < j.this.f933a.getMaxZoomLevel() && j.this.f933a.isMaploaded()) {
                    if (motionEvent.getAction() == 0) {
                        j.this.f932a.setImageBitmap(j.this.e);
                    } else if (motionEvent.getAction() == 1) {
                        j.this.f932a.setImageBitmap(j.this.f25979a);
                        try {
                            j.this.f933a.animateCamera(kja.a());
                        } catch (RemoteException e) {
                            a7b.m(e, "ZoomControllerView", "zoomin ontouch");
                            e.printStackTrace();
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (j.this.f933a.getZoomLevel() > j.this.f933a.getMinZoomLevel() && j.this.f933a.isMaploaded()) {
                    if (motionEvent.getAction() == 0) {
                        j.this.f934b.setImageBitmap(j.this.f);
                    } else if (motionEvent.getAction() == 1) {
                        j.this.f934b.setImageBitmap(j.this.c);
                        j.this.f933a.animateCamera(kja.l());
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                a7b.m(th, "ZoomControllerView", "zoomout ontouch");
                th.printStackTrace();
            }
        }
    }

    public j(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f933a = iAMapDelegate;
        try {
            Bitmap bitmapL = zwa.l(context, "zoomin_selected.png");
            this.g = bitmapL;
            this.f25979a = zwa.m(bitmapL, qwb.f44317a);
            Bitmap bitmapL2 = zwa.l(context, "zoomin_unselected.png");
            this.h = bitmapL2;
            this.b = zwa.m(bitmapL2, qwb.f44317a);
            Bitmap bitmapL3 = zwa.l(context, "zoomout_selected.png");
            this.i = bitmapL3;
            this.c = zwa.m(bitmapL3, qwb.f44317a);
            Bitmap bitmapL4 = zwa.l(context, "zoomout_unselected.png");
            this.j = bitmapL4;
            this.d = zwa.m(bitmapL4, qwb.f44317a);
            Bitmap bitmapL5 = zwa.l(context, "zoomin_pressed.png");
            this.k = bitmapL5;
            this.e = zwa.m(bitmapL5, qwb.f44317a);
            Bitmap bitmapL6 = zwa.l(context, "zoomout_pressed.png");
            this.l = bitmapL6;
            this.f = zwa.m(bitmapL6, qwb.f44317a);
            ImageView imageView = new ImageView(context);
            this.f932a = imageView;
            imageView.setImageBitmap(this.f25979a);
            this.f932a.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f934b = imageView2;
            imageView2.setImageBitmap(this.c);
            this.f934b.setClickable(true);
            this.f932a.setOnTouchListener(new a());
            this.f934b.setOnTouchListener(new b());
            this.f932a.setPadding(0, 0, 20, -2);
            this.f934b.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f932a);
            addView(this.f934b);
        } catch (Throwable th) {
            a7b.m(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            removeAllViews();
            zwa.B(this.f25979a);
            zwa.B(this.b);
            zwa.B(this.c);
            zwa.B(this.d);
            zwa.B(this.e);
            zwa.B(this.f);
            this.f25979a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            Bitmap bitmap = this.g;
            if (bitmap != null) {
                zwa.B(bitmap);
                this.g = null;
            }
            Bitmap bitmap2 = this.h;
            if (bitmap2 != null) {
                zwa.B(bitmap2);
                this.h = null;
            }
            Bitmap bitmap3 = this.i;
            if (bitmap3 != null) {
                zwa.B(bitmap3);
                this.i = null;
            }
            Bitmap bitmap4 = this.j;
            if (bitmap4 != null) {
                zwa.B(bitmap4);
                this.g = null;
            }
            Bitmap bitmap5 = this.k;
            if (bitmap5 != null) {
                zwa.B(bitmap5);
                this.k = null;
            }
            Bitmap bitmap6 = this.l;
            if (bitmap6 != null) {
                zwa.B(bitmap6);
                this.l = null;
            }
            this.f932a = null;
            this.f934b = null;
        } catch (Throwable th) {
            a7b.m(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void c(float f) {
        try {
            if (f < this.f933a.getMaxZoomLevel() && f > this.f933a.getMinZoomLevel()) {
                this.f932a.setImageBitmap(this.f25979a);
                this.f934b.setImageBitmap(this.c);
            } else if (f == this.f933a.getMinZoomLevel()) {
                this.f934b.setImageBitmap(this.d);
                this.f932a.setImageBitmap(this.f25979a);
            } else if (f == this.f933a.getMaxZoomLevel()) {
                this.f932a.setImageBitmap(this.b);
                this.f934b.setImageBitmap(this.c);
            }
        } catch (Throwable th) {
            a7b.m(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void d(int i) {
        try {
            eh.c cVar = (eh.c) getLayoutParams();
            if (i == 1) {
                cVar.c = 16;
            } else if (i == 2) {
                cVar.c = 80;
            }
            setLayoutParams(cVar);
        } catch (Throwable th) {
            a7b.m(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void e(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
