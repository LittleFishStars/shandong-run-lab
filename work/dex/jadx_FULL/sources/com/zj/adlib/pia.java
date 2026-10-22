package com.zj.adlib;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class pia implements IProjectionDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAMapDelegate f43990a;

    public pia(IAMapDelegate iAMapDelegate) {
        this.f43990a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float calculateMapZoomer(LatLng latLng, int i) {
        IAMapDelegate iAMapDelegate = this.f43990a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        MapConfig mapConfig = this.f43990a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        return zwa.e(mapProjection, (int) mapConfig.getSX(), (int) mapConfig.getSY(), latLng.latitude, latLng.longitude, i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) throws RemoteException {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        IPoint iPointObtain = IPoint.obtain();
        IPoint iPointObtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.f43990a;
        LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, iPointObtain);
        IAMapDelegate iAMapDelegate2 = this.f43990a;
        LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, iPointObtain2);
        int i3 = ((Point) iPointObtain).x;
        int i4 = 20 - i;
        int i5 = (i3 >> i4) / i2;
        int i6 = (((Point) iPointObtain).y >> i4) / i2;
        int i7 = (((Point) iPointObtain2).x >> i4) / i2;
        int i8 = ((Point) iPointObtain2).y;
        int i9 = (i8 >> i4) / i2;
        iPointObtain.recycle();
        iPointObtain2.recycle();
        return new TileProjection((i3 - ((i5 << i4) * i2)) >> i4, (i8 - ((i9 << i4) * i2)) >> i4, i5, i7, i9, i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint dPointObtain = DPoint.obtain();
        this.f43990a.getPixel2LatLng(point.x, point.y, dPointObtain);
        LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
        dPointObtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final AMapCameraInfo getCameraInfo() {
        return this.f43990a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLngBounds getMapBounds(LatLng latLng, float f) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.f43990a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.f43990a.getMapWidth();
        int mapHeight = this.f43990a.getMapHeight();
        LatLng latLngFromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng latLngFromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng latLngFromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng latLngFromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(latLngFromScreenLocation3, latLngFromScreenLocation4, latLngFromScreenLocation, latLngFromScreenLocation2, LatLngBounds.builder().include(latLngFromScreenLocation3).include(latLngFromScreenLocation4).include(latLngFromScreenLocation).include(latLngFromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float toMapLenWithWin(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.f43990a.toMapLenWithWin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint fPointObtain = FPoint.obtain();
        this.f43990a.getLatLng2Map(latLng.latitude, latLng.longitude, fPointObtain);
        PointF pointF = new PointF(((PointF) fPointObtain).x, ((PointF) fPointObtain).y);
        fPointObtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint iPointObtain = IPoint.obtain();
        this.f43990a.getLatLng2Pixel(latLng.latitude, latLng.longitude, iPointObtain);
        Point point = new Point(((Point) iPointObtain).x, ((Point) iPointObtain).y);
        iPointObtain.recycle();
        return point;
    }
}
