package com.zj.adlib;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class jsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f42662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f17484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f17485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Circle f17486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LatLng f17487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Marker f17488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f17490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sia f17492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MyLocationStyle f17489a = new MyLocationStyle();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17481a = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17493a = false;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f17491a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Animator.AnimatorListener f17482a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator.AnimatorUpdateListener f17483a = new b();

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            jsa.this.w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (jsa.this.f17486a != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    jsa.this.f17486a.setCenter(latLng);
                    jsa.this.f17488a.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static class c implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.latitude;
            double d2 = f;
            double d3 = d + ((latLng2.latitude - d) * d2);
            double d4 = latLng.longitude;
            return new LatLng(d3, d4 + (d2 * (latLng2.longitude - d4)));
        }
    }

    public jsa(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f17485a = applicationContext;
        this.f17490a = iAMapDelegate;
        this.f17492a = new sia(applicationContext, iAMapDelegate);
        d(4, true);
    }

    public final MyLocationStyle a() {
        return this.f17489a;
    }

    public final void b(float f) {
        Marker marker = this.f17488a;
        if (marker != null) {
            marker.setRotateAngle(f);
        }
    }

    public final void c(int i) {
        d(i, false);
    }

    public final void d(int i, boolean z) {
        this.f17481a = i;
        this.f17493a = false;
        this.c = false;
        this.b = false;
        this.e = false;
        this.f = false;
        if (i == 1) {
            this.b = true;
            this.c = true;
            this.d = true;
        } else if (i != 2) {
            if (i == 3) {
                this.b = true;
            } else if (i == 4) {
                this.b = true;
                this.e = true;
                this.d = false;
            } else if (i == 5) {
                this.e = true;
                this.d = false;
            } else if (i == 7) {
            }
            this.f = true;
        } else {
            this.b = true;
            this.d = true;
        }
        if (!this.e && !this.f) {
            Marker marker = this.f17488a;
            if (marker != null) {
                marker.setFlat(false);
            }
            u();
            t();
            s();
            return;
        }
        if (this.f) {
            this.f17492a.f(true);
            if (!z) {
                try {
                    this.f17490a.moveCamera(kja.b(17.0f));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            l(45.0f);
        } else {
            this.f17492a.f(false);
        }
        this.f17492a.d();
        Marker marker2 = this.f17488a;
        if (marker2 != null) {
            marker2.setFlat(true);
        }
    }

    public final void e(Location location) {
        if (location == null) {
            return;
        }
        i(this.f17489a.isMyLocationShowing());
        if (this.f17489a.isMyLocationShowing()) {
            this.f17487a = new LatLng(location.getLatitude(), location.getLongitude());
            this.f42662a = location.getAccuracy();
            if (this.f17488a == null && this.f17486a == null) {
                x();
            }
            Circle circle = this.f17486a;
            if (circle != null) {
                try {
                    double d = this.f42662a;
                    if (d != -1.0d) {
                        circle.setRadius(d);
                    }
                } catch (Throwable th) {
                    a7b.m(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            o(location.getBearing());
            if (this.f17487a.equals(this.f17488a.getPosition())) {
                w();
            } else {
                f(this.f17487a);
            }
        }
    }

    public final void f(LatLng latLng) {
        LatLng position = this.f17488a.getPosition();
        if (position == null) {
            position = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (this.f17491a == null) {
            this.f17491a = new c();
        }
        ValueAnimator valueAnimator = this.f17484a;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new c(), position, latLng);
            this.f17484a = valueAnimatorOfObject;
            valueAnimatorOfObject.addListener(this.f17482a);
            this.f17484a.addUpdateListener(this.f17483a);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.f17484a.setEvaluator(this.f17491a);
        }
        if (position.latitude == AudioStats.AUDIO_AMPLITUDE_NONE && position.longitude == AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.f17484a.setDuration(1L);
        } else {
            this.f17484a.setDuration(1000L);
        }
        this.f17484a.start();
    }

    public final void g(MyLocationStyle myLocationStyle) {
        try {
            this.f17489a = myLocationStyle;
            i(myLocationStyle.isMyLocationShowing());
            if (!this.f17489a.isMyLocationShowing()) {
                this.f17492a.f(false);
                this.f17481a = this.f17489a.getMyLocationType();
                return;
            }
            x();
            Marker marker = this.f17488a;
            if (marker == null && this.f17486a == null) {
                return;
            }
            this.f17492a.e(marker);
            c(this.f17489a.getMyLocationType());
        } catch (Throwable th) {
            a7b.m(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void i(boolean z) {
        Circle circle = this.f17486a;
        if (circle != null && circle.isVisible() != z) {
            this.f17486a.setVisible(z);
        }
        Marker marker = this.f17488a;
        if (marker == null || marker.isVisible() == z) {
            return;
        }
        this.f17488a.setVisible(z);
    }

    public final void k() {
        sia siaVar;
        if (this.f17481a != 3 || (siaVar = this.f17492a) == null) {
            return;
        }
        siaVar.d();
    }

    public final void l(float f) {
        IAMapDelegate iAMapDelegate = this.f17490a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(kja.p(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void n() throws RemoteException {
        y();
        if (this.f17492a != null) {
            s();
            this.f17492a = null;
        }
    }

    public final void o(float f) {
        if (this.d) {
            float f2 = f % 360.0f;
            if (f2 > 180.0f) {
                f2 -= 360.0f;
            } else if (f2 < -180.0f) {
                f2 += 360.0f;
            }
            Marker marker = this.f17488a;
            if (marker != null) {
                marker.setRotateAngle(-f2);
            }
        }
    }

    public final String p() {
        Marker marker = this.f17488a;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String q() throws RemoteException {
        Circle circle = this.f17486a;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void r() {
        this.f17486a = null;
        this.f17488a = null;
    }

    public final void s() {
        this.f17492a.h();
    }

    public final void t() {
        l(0.0f);
    }

    public final void u() {
        v();
    }

    public final void v() {
        IAMapDelegate iAMapDelegate = this.f17490a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(kja.q(0.0f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void w() {
        if (this.f17487a != null && this.b) {
            if (this.c && this.f17493a) {
                return;
            }
            this.f17493a = true;
            try {
                IPoint iPointObtain = IPoint.obtain();
                LatLng latLng = this.f17487a;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, iPointObtain);
                this.f17490a.animateCamera(kja.e(iPointObtain));
            } catch (Throwable th) {
                a7b.m(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    public final void x() {
        MyLocationStyle myLocationStyle = this.f17489a;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f17489a = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.f17489a.getMyLocationIcon().getBitmap() == null) {
            this.f17489a.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        z();
    }

    public final void y() {
        Circle circle = this.f17486a;
        if (circle != null) {
            try {
                this.f17490a.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                a7b.m(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f17486a = null;
        }
        Marker marker = this.f17488a;
        if (marker != null) {
            marker.remove();
            this.f17488a = null;
            this.f17492a.e(null);
        }
    }

    public final void z() {
        try {
            if (this.f17486a == null) {
                this.f17486a = this.f17490a.addCircle(new CircleOptions().zIndex(1.0f));
            }
            Circle circle = this.f17486a;
            if (circle != null) {
                if (circle.getStrokeWidth() != this.f17489a.getStrokeWidth()) {
                    this.f17486a.setStrokeWidth(this.f17489a.getStrokeWidth());
                }
                if (this.f17486a.getFillColor() != this.f17489a.getRadiusFillColor()) {
                    this.f17486a.setFillColor(this.f17489a.getRadiusFillColor());
                }
                if (this.f17486a.getStrokeColor() != this.f17489a.getStrokeColor()) {
                    this.f17486a.setStrokeColor(this.f17489a.getStrokeColor());
                }
                LatLng latLng = this.f17487a;
                if (latLng != null) {
                    this.f17486a.setCenter(latLng);
                }
                this.f17486a.setRadius(this.f42662a);
                this.f17486a.setVisible(true);
            }
            if (this.f17488a == null) {
                this.f17488a = this.f17490a.addMarker(new MarkerOptions().visible(false));
            }
            Marker marker = this.f17488a;
            if (marker != null) {
                if (marker.getAnchorU() != this.f17489a.getAnchorU() || this.f17488a.getAnchorV() != this.f17489a.getAnchorV()) {
                    this.f17488a.setAnchor(this.f17489a.getAnchorU(), this.f17489a.getAnchorV());
                }
                if (this.f17488a.getIcons() == null || this.f17488a.getIcons().size() == 0) {
                    this.f17488a.setIcon(this.f17489a.getMyLocationIcon());
                } else if (this.f17489a.getMyLocationIcon() != null && !this.f17488a.getIcons().get(0).equals(this.f17489a.getMyLocationIcon())) {
                    this.f17488a.setIcon(this.f17489a.getMyLocationIcon());
                }
                LatLng latLng2 = this.f17487a;
                if (latLng2 != null) {
                    this.f17488a.setPosition(latLng2);
                    this.f17488a.setVisible(true);
                }
            }
            w();
            this.f17492a.e(this.f17488a);
        } catch (Throwable th) {
            a7b.m(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }
}
