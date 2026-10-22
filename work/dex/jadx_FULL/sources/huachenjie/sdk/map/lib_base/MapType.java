package huachenjie.sdk.map.lib_base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class MapType {
    public static final int MAP_TYPE_AMAP = 1;
    public static final int MAP_TYPE_BMAP = 2;
    public static final int MAP_TYPE_GMAP = 3;
    private static int mMapType = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapTypeChecker {
    }

    public static int getMapType() {
        return mMapType;
    }

    public static void setMapType(int i) {
        mMapType = i;
    }
}
