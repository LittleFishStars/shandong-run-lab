package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IProjection {
    float calculateMapZoomer(LatLng latLng, int i);

    TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) throws RemoteException;

    LatLng fromScreenLocation(Point point) throws RemoteException;

    AMapCameraInfo getCameraInfo();

    LatLngBounds getMapBounds(LatLng latLng, float f) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    float toMapLenWithWin(int i) throws RemoteException;

    PointF toMapLocation(LatLng latLng) throws RemoteException;

    Point toScreenLocation(LatLng latLng) throws RemoteException;
}
