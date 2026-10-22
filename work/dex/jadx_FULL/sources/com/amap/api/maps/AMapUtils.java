package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.camera.video.AudioStats;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.fh;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import com.zj.adlib.j4b;
import com.zj.adlib.qwb;
import com.zj.adlib.r4b;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;
    private static final double R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    public static class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26105a;
        Context b;

        public a(String str, Context context) {
            this.f26105a = str;
            if (context != null) {
                this.b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (this.b != null) {
                try {
                    fh.c(this.b, new r4b.a(this.f26105a, "9.5.0", qwb.b).b(new String[]{"com.amap.api.maps"}).c(), "", null);
                    interrupt();
                } catch (ff e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(RoutePara routePara, Context context, int i) throws AMapException {
        if (!a(routePara)) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(b(routePara, context, i)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
        } catch (Throwable unused) {
            throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
        }
    }

    private static String b(RoutePara routePara, Context context, int i) {
        String str = String.format(Locale.US, AMAPROUTEURL, j4b.e(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i));
        if (i == 1) {
            return str + "&m=" + routePara.getTransitRouteStyle();
        }
        if (i != 2) {
            return str;
        }
        return str + "&m=" + routePara.getDrivingRouteStyle();
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double dSin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
            double d = (latLng2.longitude - latLng.longitude) / 360.0d;
            if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
                d += 1.0d;
            }
            return (float) (dSin * 2.5560394669790553E14d * d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double d = latLng.longitude;
            double d2 = latLng.latitude;
            double d3 = latLng2.longitude;
            double d4 = latLng2.latitude;
            double d5 = d * NF_PI;
            double d6 = d2 * NF_PI;
            double d7 = d3 * NF_PI;
            double d8 = d4 * NF_PI;
            double dSin = Math.sin(d5);
            double dSin2 = Math.sin(d6);
            double dCos = Math.cos(d5);
            double dCos2 = Math.cos(d6);
            double dSin3 = Math.sin(d7);
            double dSin4 = Math.sin(d8);
            double dCos3 = Math.cos(d7);
            double dCos4 = Math.cos(d8);
            double[] dArr = {dCos * dCos2, dCos2 * dSin, dSin2};
            double d9 = dCos3 * dCos4;
            double d10 = dCos4 * dSin3;
            double d11 = dArr[0];
            double d12 = (d11 - d9) * (d11 - d9);
            double d13 = dArr[1];
            double d14 = d12 + ((d13 - d10) * (d13 - d10));
            double d15 = dArr[2];
            return (float) (Math.asin(Math.sqrt(d14 + ((d15 - dSin4) * (d15 - dSin4))) / 2.0d) * 1.27420015798544E7d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 2);
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (naviPara.getTargetPoint() == null) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(a(naviPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
        } catch (Throwable unused) {
            throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
        }
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (poiPara.getKeywords() == null || poiPara.getKeywords().trim().length() <= 0) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(a(poiPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
        } catch (Throwable unused) {
            throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
        }
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 4);
    }

    public static float calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0f;
        }
        int size = list.size();
        double dCos = AudioStats.AUDIO_AMPLITUDE_NONE;
        int i = 0;
        while (i < size) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i % size);
            double dCos2 = latLng.longitude * 111319.49079327357d * Math.cos(latLng.latitude * 0.017453292519943295d);
            double d = latLng.latitude * 111319.49079327357d;
            dCos += (dCos2 * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * 0.017453292519943295d)) * d);
        }
        return Math.abs((float) (dCos / 2.0d));
    }

    private static boolean a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    private static String a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, AMAPNAVIURL, j4b.e(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    private static String a(PoiPara poiPara, Context context) {
        String str = String.format(Locale.US, AMAPPOISEARCHURL, j4b.e(context), poiPara.getKeywords());
        if (poiPara.getCenter() == null) {
            return str;
        }
        return str + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude;
    }
}
