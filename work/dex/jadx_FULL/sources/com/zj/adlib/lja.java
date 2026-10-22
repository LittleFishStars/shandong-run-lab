package com.zj.adlib;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class lja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static double f43084a = 3.141592653589793d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f17979a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final double[] f17980a = {25.575374d, 120.391111d};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final double[] f17981b = {21.405235d, 121.649046d};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final List<LatLng> f17978a = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));
    public static double b = 6378245.0d;
    public static double c = 0.006693421622965943d;

    public static double a(double d) {
        return Math.sin(d * 3000.0d * (f43084a / 180.0d)) * 2.0E-5d;
    }

    public static double b(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static LatLng c(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!swa.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        DPoint dPointF = f(DPoint.obtain(latLng.longitude, latLng.latitude), f17979a);
        LatLng latLng2 = new LatLng(dPointF.y, dPointF.x, false);
        dPointF.recycle();
        return latLng2;
    }

    public static LatLng d(LatLng latLng) {
        if (latLng != null) {
            try {
                if (swa.a(latLng.latitude, latLng.longitude)) {
                    DPoint dPointM = m(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(dPointM.y, dPointM.x, false);
                    dPointM.recycle();
                    return latLng2;
                }
                if (!n(latLng.latitude, latLng.longitude)) {
                    return latLng;
                }
                DPoint dPointM2 = m(latLng.longitude, latLng.latitude);
                return o(dPointM2.y, dPointM2.x);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    public static DPoint e(double d, double d2, double d3, double d4) {
        DPoint dPointObtain = DPoint.obtain();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint dPointL = l(d5, d6);
        dPointObtain.x = j((d + d5) - dPointL.x);
        dPointObtain.y = j((d2 + d6) - dPointL.y);
        return dPointObtain;
    }

    public static DPoint f(DPoint dPoint, boolean z) {
        try {
            if (!swa.a(dPoint.y, dPoint.x)) {
                return dPoint;
            }
            double[] dArrA = new double[2];
            if (!z) {
                dArrA = a.a(dPoint.x, dPoint.y);
            }
            dPoint.recycle();
            return DPoint.obtain(dArrA[0], dArrA[1]);
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    public static double g(double d) {
        return Math.cos(d * 3000.0d * (f43084a / 180.0d)) * 3.0E-6d;
    }

    public static double h(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static LatLng i(Context context, LatLng latLng) {
        try {
            if (!swa.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            DPoint dPointK = k(latLng.longitude, latLng.latitude);
            LatLng latLngC = c(context, new LatLng(dPointK.y, dPointK.x, false));
            dPointK.recycle();
            return latLngC;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    public static double j(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    public static DPoint k(double d, double d2) {
        double d3 = ((long) (d * 100000.0d)) % 36000000;
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        double d5 = (int) ((-b(d3, d4)) + d3);
        double d6 = (int) ((-h(d3, d4)) + d4);
        double d7 = (int) ((-b(d5, d6)) + d3 + ((double) (d3 > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : -1)));
        return DPoint.obtain(d7 / 100000.0d, ((double) ((int) (((-h(d7, d6)) + d4) + ((double) (d4 <= AudioStats.AUDIO_AMPLITUDE_NONE ? -1 : 1))))) / 100000.0d);
    }

    public static DPoint l(double d, double d2) {
        DPoint dPointObtain = DPoint.obtain();
        double d3 = (d * d) + (d2 * d2);
        double dCos = (Math.cos(g(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.0065d;
        double dSin = (Math.sin(g(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.006d;
        dPointObtain.x = j(dCos);
        dPointObtain.y = j(dSin);
        return dPointObtain;
    }

    public static DPoint m(double d, double d2) {
        DPoint dPointE = null;
        double d3 = 0.006401062d;
        double d4 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPointE = e(d, d2, d3, d4);
            d3 = d - dPointE.x;
            d4 = d2 - dPointE.y;
        }
        return dPointE;
    }

    public static boolean n(double d, double d2) {
        return zwa.M(new LatLng(d, d2), f17978a);
    }

    public static LatLng o(double d, double d2) {
        LatLng latLngP = p(d, d2);
        return new LatLng((d * 2.0d) - latLngP.latitude, (d2 * 2.0d) - latLngP.longitude);
    }

    public static LatLng p(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double dQ = q(d3, d4);
        double dR = r(d3, d4);
        double d5 = (d / 180.0d) * f43084a;
        double dSin = Math.sin(d5);
        double d6 = 1.0d - ((c * dSin) * dSin);
        double dSqrt = Math.sqrt(d6);
        double d7 = b;
        return new LatLng(d + ((dQ * 180.0d) / ((((1.0d - c) * d7) / (d6 * dSqrt)) * f43084a)), d2 + ((dR * 180.0d) / (((d7 / dSqrt) * Math.cos(d5)) * f43084a)));
    }

    public static double q(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * f43084a) * 20.0d) + (Math.sin(d3 * f43084a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f43084a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f43084a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f43084a) * 160.0d) + (Math.sin((d2 * f43084a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public static double r(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * f43084a) * 20.0d) + (Math.sin((d * 2.0d) * f43084a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f43084a * d) * 20.0d) + (Math.sin((d / 3.0d) * f43084a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f43084a) * 150.0d) + (Math.sin((d / 30.0d) * f43084a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
