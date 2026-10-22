package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double f26203a = 3.141592653589793d;
    private static final List<DPoint> b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return b(dPoint);
    }

    private static DPoint b(DPoint dPoint) {
        try {
            if (!b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] dArrA = com.autonavi.util.a.a(dPoint.getLongitude(), dPoint.getLatitude());
            return new DPoint(dArrA[1], dArrA[0]);
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static DPoint c(double d, double d2) {
        double d3 = ((long) (d * 100000.0d)) % 36000000;
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        double d5 = (int) ((-a(d3, d4)) + d3);
        double d6 = (int) ((-b(d3, d4)) + d4);
        double d7 = (int) ((-a(d5, d6)) + d3 + ((double) (d3 > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : -1)));
        return new DPoint(((double) ((int) (((-b(d7, d6)) + d4) + ((double) (d4 <= AudioStats.AUDIO_AMPLITUDE_NONE ? -1 : 1))))) / 100000.0d, d7 / 100000.0d);
    }

    private static DPoint d(double d, double d2) {
        DPoint dPoint = new DPoint();
        double d3 = (d * d) + (d2 * d2);
        double dCos = (Math.cos(b(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.0065d;
        double dSin = (Math.sin(b(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.006d;
        dPoint.setLongitude(c(dCos));
        dPoint.setLatitude(c(dSin));
        return dPoint;
    }

    private static boolean e(double d, double d2) {
        return b.a(new DPoint(d, d2), b);
    }

    private static DPoint f(double d, double d2) {
        DPoint dPointG = g(d, d2);
        return new DPoint((d * 2.0d) - dPointG.getLatitude(), (d2 * 2.0d) - dPointG.getLongitude());
    }

    private static DPoint g(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double dH = h(d3, d4);
        double dI = i(d3, d4);
        double d5 = (d / 180.0d) * f26203a;
        double dSin = Math.sin(d5);
        double d6 = 1.0d - ((0.006693421622965943d * dSin) * dSin);
        double dSqrt = Math.sqrt(d6);
        return new DPoint(d + ((dH * 180.0d) / ((6335552.717000426d / (d6 * dSqrt)) * f26203a)), d2 + ((dI * 180.0d) / (((6378245.0d / dSqrt) * Math.cos(d5)) * f26203a)));
    }

    private static double h(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * f26203a) * 20.0d) + (Math.sin(d3 * f26203a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f26203a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f26203a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f26203a) * 160.0d) + (Math.sin((d2 * f26203a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double i(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * f26203a) * 20.0d) + (Math.sin((d * 2.0d) * f26203a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f26203a * d) * 20.0d) + (Math.sin((d / 3.0d) * f26203a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f26203a) * 150.0d) + (Math.sin((d / 30.0d) * f26203a) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return c(dPoint);
                }
                if (!e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return dPoint;
                }
                DPoint dPointC = c(dPoint);
                return f(dPointC.getLatitude(), dPointC.getLongitude());
            } catch (Throwable th) {
                b.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            return !b.a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : a(context, c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static double c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static double a(double d) {
        return Math.sin(d * 3000.0d * (f26203a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static DPoint a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint dPointD = d(d5, d6);
        dPoint.setLongitude(c((d + d5) - dPointD.getLongitude()));
        dPoint.setLatitude(c((d2 + d6) - dPointD.getLatitude()));
        return dPoint;
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * (f26203a / 180.0d)) * 3.0E-6d;
    }

    private static DPoint c(DPoint dPoint) {
        DPoint dPointA = null;
        double longitude = 0.006401062d;
        double latitude = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPointA = a(dPoint.getLongitude(), dPoint.getLatitude(), longitude, latitude);
            longitude = dPoint.getLongitude() - dPointA.getLongitude();
            latitude = dPoint.getLatitude() - dPointA.getLatitude();
        }
        return dPointA;
    }
}
