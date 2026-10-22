package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mapsdkplatform.comapi.util.b;
import com.baidu.mapsdkplatform.comjni.tools.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoordUtil {
    public static LatLng Coordinate_encryptEx(float f, float f2, String str) {
        return b.a(f, f2, str);
    }

    public static LatLng decodeLocation(String str) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(b.a(str)) : b.a(str);
    }

    public static List<LatLng> decodeLocationList(String str) {
        return b.b(str);
    }

    public static List<List<LatLng>> decodeLocationList2D(String str) {
        return b.c(str);
    }

    public static LatLng decodeNodeLocation(String str) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(b.d(str)) : b.d(str);
    }

    public static double getDistance(Point point, Point point2) {
        return a.a(point, point2);
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? b.a(CoordTrans.gcjToBaidu(latLng), i) : b.a(latLng, i);
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? b.a(CoordTrans.gcjToBaidu(latLng)) : b.a(latLng);
    }

    public static GeoPoint ll2mcDirect(LatLng latLng) {
        return b.a(latLng);
    }

    public static Point ll2point(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? b.b(CoordTrans.gcjToBaidu(latLng)) : b.b(latLng);
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(b.a(geoPoint)) : b.a(geoPoint);
    }

    public static LatLng mc2llDirect(GeoPoint geoPoint) {
        return b.a(geoPoint);
    }
}
