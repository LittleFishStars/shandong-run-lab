package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.zj.adlib.a7b;
import com.zj.adlib.kja;
import com.zj.adlib.qwb;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eg extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bitmap f25921a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    IAMapDelegate h;
    boolean i;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (!eg.this.i) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                eg egVar = eg.this;
                egVar.g.setImageBitmap(egVar.b);
            } else if (motionEvent.getAction() == 1) {
                try {
                    eg egVar2 = eg.this;
                    egVar2.g.setImageBitmap(egVar2.f25921a);
                    eg.this.h.setMyLocationEnabled(true);
                    Location myLocation = eg.this.h.getMyLocation();
                    if (myLocation == null) {
                        return false;
                    }
                    LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                    eg.this.h.showMyLocationOverlay(myLocation);
                    IAMapDelegate iAMapDelegate = eg.this.h;
                    iAMapDelegate.moveCamera(kja.h(latLng, iAMapDelegate.getZoomLevel()));
                } catch (Throwable th) {
                    a7b.m(th, "LocationView", "onTouch");
                    th.printStackTrace();
                }
            }
            return false;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public eg(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.i = false;
        this.h = iAMapDelegate;
        try {
            Bitmap bitmapL = zwa.l(context, "location_selected.png");
            this.d = bitmapL;
            this.f25921a = zwa.m(bitmapL, qwb.f44317a);
            Bitmap bitmapL2 = zwa.l(context, "location_pressed.png");
            this.e = bitmapL2;
            this.b = zwa.m(bitmapL2, qwb.f44317a);
            Bitmap bitmapL3 = zwa.l(context, "location_unselected.png");
            this.f = bitmapL3;
            this.c = zwa.m(bitmapL3, qwb.f44317a);
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.f25921a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new a());
            addView(this.g);
        } catch (Throwable th) {
            a7b.m(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f25921a;
            if (bitmap != null) {
                zwa.B(bitmap);
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                zwa.B(bitmap2);
            }
            if (this.b != null) {
                zwa.B(this.c);
            }
            this.f25921a = null;
            this.b = null;
            this.c = null;
            Bitmap bitmap3 = this.d;
            if (bitmap3 != null) {
                zwa.B(bitmap3);
                this.d = null;
            }
            Bitmap bitmap4 = this.e;
            if (bitmap4 != null) {
                zwa.B(bitmap4);
                this.e = null;
            }
            Bitmap bitmap5 = this.f;
            if (bitmap5 != null) {
                zwa.B(bitmap5);
                this.f = null;
            }
        } catch (Throwable th) {
            a7b.m(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        this.i = z;
        try {
            if (z) {
                this.g.setImageBitmap(this.f25921a);
            } else {
                this.g.setImageBitmap(this.c);
            }
            this.g.invalidate();
        } catch (Throwable th) {
            a7b.m(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
