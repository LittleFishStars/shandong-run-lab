package com.kc.openset.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final class LocationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static double f39943a;
    public static double b;
    private LocationManager c;
    private LocationListener d;

    @Keep
    public class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f39944a;
        final LocationUtils b;

        static {
            OSETSDKProtected.interface11(4936);
        }

        public a(LocationUtils locationUtils, Context context) {
            this.b = locationUtils;
            this.f39944a = context;
        }

        @Override // android.location.LocationListener
        public native void onLocationChanged(Location location);

        @Override // android.location.LocationListener
        public native void onProviderDisabled(String str);

        @Override // android.location.LocationListener
        public native void onProviderEnabled(String str);

        @Override // android.location.LocationListener
        public native void onStatusChanged(String str, int i, Bundle bundle);
    }

    public static void a(Context context) {
        if (!com.kc.openset.config.c.b()) {
            LogUtils.writeD("LocationUtils", "隐私合规不允许获取位置信息");
        } else if (f39943a == AudioStats.AUDIO_AMPLITUDE_NONE || b == AudioStats.AUDIO_AMPLITUDE_NONE) {
            new LocationUtils().b(context);
        } else {
            LogUtils.writeD("LocationUtils", "init: 已有位置");
        }
    }

    private void b(Context context) {
        this.c = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        this.d = new a(this, context);
        f(context);
    }

    public static boolean c(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isProviderEnabled("gps");
    }

    public static boolean d(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    private void f(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            LogUtils.writeW("LocationUtils", "requestLocationUpdates: 没有位置权限");
            return;
        }
        if (!d(context)) {
            LogUtils.writeE("LocationUtils", "你必须打开 GPS 或互联网");
            return;
        }
        if (d(context)) {
            try {
                this.c.requestLocationUpdates("network", 60000L, 8.0f, this.d);
                Location lastKnownLocation = this.c.getLastKnownLocation("network");
                if (lastKnownLocation != null) {
                    f39943a = lastKnownLocation.getLatitude();
                    b = lastKnownLocation.getLongitude();
                    LogUtils.writeD("LocationUtils", "init 经纬度 network: " + f39943a + ", " + b);
                    e(context);
                }
            } catch (Exception e) {
                LogUtils.e("LocationUtils", "requestLocationUpdates: " + e.getMessage());
            }
        }
        if (c(context)) {
            try {
                Location lastKnownLocation2 = this.c.getLastKnownLocation("gps");
                if (lastKnownLocation2 != null) {
                    f39943a = lastKnownLocation2.getLatitude();
                    b = lastKnownLocation2.getLongitude();
                    LogUtils.writeD("LocationUtils", "init 经纬度 gps: " + f39943a + ", " + b);
                    e(context);
                }
            } catch (Exception e2) {
                LogUtils.e("LocationUtils", "requestLocationUpdates: " + e2.getMessage());
            }
        }
    }

    public void e(Context context) {
        LocationListener locationListener;
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            LogUtils.writeW("LocationUtils", "removeLocationUpdatesListener: 没有位置权限");
            return;
        }
        LocationManager locationManager = this.c;
        if (locationManager == null || (locationListener = this.d) == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
            LogUtils.writeD("LocationUtils", "removeLocationUpdatesListener: 移除定位监听！");
        } catch (Exception unused) {
        }
    }
}
