package com.baidu.platform.comapi.location;

import android.os.Bundle;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoordinateUtil {
    public static native Point bd09llTobd09mc(double d, double d2);

    public static native Point bd09llTogcj02ll(double d, double d2);

    public static native Point bd09mcTobd09ll(double d, double d2);

    public static Point bd09mcTogcj02ll(double d, double d2) {
        Point pointBd09mcTobd09ll = bd09mcTobd09ll(d, d2);
        if (pointBd09mcTobd09ll != null) {
            return bd09llTogcj02ll(pointBd09mcTobd09ll.getDoubleX(), pointBd09mcTobd09ll.getDoubleY());
        }
        return null;
    }

    public static Point complexPtToPoint(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return nativeComplexPtToPoint(str);
    }

    public static native Point gcj02Tobd09ll(double d, double d2);

    public static Point gcj02Tobd09mc(double d, double d2) {
        Point pointGcj02Tobd09ll = gcj02Tobd09ll(d, d2);
        if (pointGcj02Tobd09ll != null) {
            return bd09llTobd09mc(pointGcj02Tobd09ll.getDoubleX(), pointGcj02Tobd09ll.getDoubleY());
        }
        return null;
    }

    public static ComplexPt geoStringToComplexPt(String str) {
        if (str != null && !str.equals("")) {
            Bundle bundle = new Bundle();
            if (nativeGeoStringToComplexPt(str, bundle)) {
                ComplexPt complexPt = new ComplexPt();
                Bundle bundle2 = bundle.getBundle("map_bound");
                if (bundle2 != null) {
                    Bundle bundle3 = bundle2.getBundle(AliyunLogKey.KEY_LOG_LEVEL);
                    if (bundle3 != null) {
                        complexPt.mLL = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
                    }
                    Bundle bundle4 = bundle2.getBundle("ru");
                    if (bundle4 != null) {
                        complexPt.mRu = new Point((int) bundle4.getDouble("ptx"), (int) bundle4.getDouble("pty"));
                    }
                }
                for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
                    if (complexPt.mGeoPt == null) {
                        complexPt.mGeoPt = new ArrayList<>();
                    }
                    Bundle bundle5 = parcelItem.getBundle();
                    if (bundle5 != null) {
                        ParcelItem[] parcelItemArr = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                        ArrayList<Point> arrayList = new ArrayList<>();
                        for (ParcelItem parcelItem2 : parcelItemArr) {
                            Bundle bundle6 = parcelItem2.getBundle();
                            if (bundle6 != null) {
                                arrayList.add(new Point((int) bundle6.getDouble("ptx"), (int) bundle6.getDouble("pty")));
                            }
                        }
                        arrayList.trimToSize();
                        complexPt.mGeoPt.add(arrayList);
                    }
                }
                complexPt.mGeoPt.trimToSize();
                complexPt.eType = (int) bundle.getDouble("type");
                return complexPt;
            }
        }
        return null;
    }

    public static ComplexPt geoStringToComplexPtBound(String str) {
        if (str != null && !str.equals("")) {
            Bundle bundle = new Bundle();
            if (nativeGeoStringToComplexPtBound(str, bundle)) {
                ComplexPt complexPt = new ComplexPt();
                Bundle bundle2 = bundle.getBundle("map_bound");
                if (bundle2 != null) {
                    Bundle bundle3 = bundle2.getBundle(AliyunLogKey.KEY_LOG_LEVEL);
                    if (bundle3 != null) {
                        complexPt.mLL = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
                    }
                    Bundle bundle4 = bundle2.getBundle("ru");
                    if (bundle4 != null) {
                        complexPt.mRu = new Point((int) bundle4.getDouble("ptx"), (int) bundle4.getDouble("pty"));
                    }
                }
                complexPt.eType = (int) bundle.getDouble("type");
                return complexPt;
            }
        }
        return null;
    }

    public static Point geoStringToPoint(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return nativeGeoStringToPoint(str);
    }

    public static native double getDistanceByMc(double d, double d2, double d3, double d4);

    public static native Point getIntermediatePointByMC(double d, double d2, double d3, double d4, double d5);

    private static native Point nativeComplexPtToPoint(String str);

    private static native boolean nativeGeoStringToComplexPt(String str, Bundle bundle);

    private static native boolean nativeGeoStringToComplexPtBound(String str, Bundle bundle);

    private static native Point nativeGeoStringToPoint(String str);

    private static native String nativePointToGeoString(double d, double d2);

    public static String pointToGeoString(Point point) {
        return point == null ? "" : nativePointToGeoString(point.getDoubleX(), point.getDoubleY());
    }

    public static Point wgs84Tobd09ll(double d, double d2) {
        Point pointWgs84Togcj02 = wgs84Togcj02(d, d2);
        if (pointWgs84Togcj02 != null) {
            return gcj02Tobd09ll(pointWgs84Togcj02.getDoubleX(), pointWgs84Togcj02.getDoubleY());
        }
        return null;
    }

    public static Point wgs84Tobd09mc(double d, double d2) {
        Point pointGcj02Tobd09ll;
        Point pointWgs84Togcj02 = wgs84Togcj02(d, d2);
        if (pointWgs84Togcj02 == null || (pointGcj02Tobd09ll = gcj02Tobd09ll(pointWgs84Togcj02.getDoubleX(), pointWgs84Togcj02.getDoubleY())) == null) {
            return null;
        }
        return bd09llTobd09mc(pointGcj02Tobd09ll.getDoubleX(), pointGcj02Tobd09ll.getDoubleY());
    }

    public static native Point wgs84Togcj02(double d, double d2);
}
