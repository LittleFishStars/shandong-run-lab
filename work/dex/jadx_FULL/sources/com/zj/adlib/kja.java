package com.zj.adlib;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class kja {
    public static AbstractCameraUpdateMessage a() {
        eja ejaVar = new eja();
        ejaVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ejaVar.amount = 1.0f;
        return ejaVar;
    }

    public static AbstractCameraUpdateMessage b(float f) {
        bja bjaVar = new bja();
        bjaVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        bjaVar.zoom = f;
        return bjaVar;
    }

    public static AbstractCameraUpdateMessage c(float f, float f2) {
        cja cjaVar = new cja();
        cjaVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        cjaVar.xPixel = f;
        cjaVar.yPixel = f2;
        return cjaVar;
    }

    public static AbstractCameraUpdateMessage d(float f, Point point) {
        eja ejaVar = new eja();
        ejaVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ejaVar.amount = f;
        ejaVar.focus = point;
        return ejaVar;
    }

    public static AbstractCameraUpdateMessage e(Point point) {
        bja bjaVar = new bja();
        bjaVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        bjaVar.geoPoint = new DPoint(point.x, point.y);
        return bjaVar;
    }

    public static AbstractCameraUpdateMessage f(CameraPosition cameraPosition) {
        LatLng latLng;
        bja bjaVar = new bja();
        bjaVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint dPointLatLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            bjaVar.geoPoint = new DPoint(dPointLatLongToPixelsDouble.x, dPointLatLongToPixelsDouble.y);
            bjaVar.zoom = cameraPosition.zoom;
            bjaVar.bearing = cameraPosition.bearing;
            bjaVar.tilt = cameraPosition.tilt;
            bjaVar.cameraPosition = cameraPosition;
        }
        return bjaVar;
    }

    public static AbstractCameraUpdateMessage g(LatLng latLng) {
        return f(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage h(LatLng latLng, float f) {
        return f(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage i(LatLngBounds latLngBounds, int i) {
        aja ajaVar = new aja();
        ajaVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ajaVar.bounds = latLngBounds;
        ajaVar.paddingLeft = i;
        ajaVar.paddingRight = i;
        ajaVar.paddingTop = i;
        ajaVar.paddingBottom = i;
        return ajaVar;
    }

    public static AbstractCameraUpdateMessage j(LatLngBounds latLngBounds, int i, int i2, int i3) {
        aja ajaVar = new aja();
        ajaVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        ajaVar.bounds = latLngBounds;
        ajaVar.paddingLeft = i3;
        ajaVar.paddingRight = i3;
        ajaVar.paddingTop = i3;
        ajaVar.paddingBottom = i3;
        ajaVar.width = i;
        ajaVar.height = i2;
        return ajaVar;
    }

    public static AbstractCameraUpdateMessage k(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        aja ajaVar = new aja();
        ajaVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ajaVar.bounds = latLngBounds;
        ajaVar.paddingLeft = i;
        ajaVar.paddingRight = i2;
        ajaVar.paddingTop = i3;
        ajaVar.paddingBottom = i4;
        return ajaVar;
    }

    public static AbstractCameraUpdateMessage l() {
        eja ejaVar = new eja();
        ejaVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ejaVar.amount = -1.0f;
        return ejaVar;
    }

    public static AbstractCameraUpdateMessage m(float f) {
        return d(f, null);
    }

    public static AbstractCameraUpdateMessage n(float f, Point point) {
        bja bjaVar = new bja();
        bjaVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        bjaVar.geoPoint = new DPoint(point.x, point.y);
        bjaVar.bearing = f;
        return bjaVar;
    }

    public static AbstractCameraUpdateMessage o() {
        return new bja();
    }

    public static AbstractCameraUpdateMessage p(float f) {
        bja bjaVar = new bja();
        bjaVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        bjaVar.tilt = f;
        return bjaVar;
    }

    public static AbstractCameraUpdateMessage q(float f) {
        bja bjaVar = new bja();
        bjaVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        bjaVar.bearing = f;
        return bjaVar;
    }
}
