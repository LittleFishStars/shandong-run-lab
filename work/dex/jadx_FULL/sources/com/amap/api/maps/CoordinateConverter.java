package com.amap.api.maps;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.zj.adlib.a7b;
import com.zj.adlib.lja;
import com.zj.adlib.swa;
import com.zj.adlib.xwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    /* JADX INFO: renamed from: com.amap.api.maps.CoordinateConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26107a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f26107a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26107a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26107a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26107a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26107a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26107a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26107a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return swa.a(d, d2);
    }

    public LatLng convert() {
        CoordType coordType = this.coordType;
        LatLng latLngD = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            String str = "";
            switch (AnonymousClass1.f26107a[coordType.ordinal()]) {
                case 1:
                    latLngD = lja.d(this.sourceLatLng);
                    str = "baidu";
                    break;
                case 2:
                    latLngD = lja.i(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLngD = this.sourceLatLng;
                    break;
                case 4:
                    str = "sosomap";
                    latLngD = this.sourceLatLng;
                    break;
                case 5:
                    str = "aliyun";
                    latLngD = this.sourceLatLng;
                    break;
                case 6:
                    str = "google";
                    latLngD = this.sourceLatLng;
                    break;
                case 7:
                    str = "gps";
                    latLngD = lja.c(this.ctx, this.sourceLatLng);
                    break;
            }
            xwa.h(this.ctx, str);
            return latLngD;
        } catch (Throwable th) {
            th.printStackTrace();
            a7b.m(th, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.coordType = coordType;
        return this;
    }
}
