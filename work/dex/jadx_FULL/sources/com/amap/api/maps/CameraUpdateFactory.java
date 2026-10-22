package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.zj.adlib.kja;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(kja.q(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        if (iPoint != null) {
            return new CameraUpdate(kja.n(f % 360.0f, new Point(((Point) iPoint).x, ((Point) iPoint).y)));
        }
        Log.w(CLASSNAME, "geoPoint is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(kja.e(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(kja.p(f));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            return new CameraUpdate(kja.f(cameraPosition));
        }
        Log.w(CLASSNAME, "cameraPosition is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(kja.g(latLng));
        }
        Log.w(CLASSNAME, "latLng is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        if (latLngBounds != null) {
            return new CameraUpdate(kja.i(latLngBounds, i));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds != null) {
            return new CameraUpdate(kja.k(latLngBounds, i, i2, i3, i4));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng != null) {
            return new CameraUpdate(kja.h(latLng, f));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(kja.o());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(kja.c(f, f2));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(kja.m(f));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(kja.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(kja.l());
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(kja.b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(kja.d(f, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(kja.o());
        }
        return new CameraUpdate(kja.j(latLngBounds, i, i2, i3));
    }
}
