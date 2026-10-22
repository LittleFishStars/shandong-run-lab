package com.bwt.top.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LocationUtil {
    private static String TAG = "LocationUtil";
    private static String[] locationInfo;
    private static LocationManager locationManager;

    public class a implements LocationListener {
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            LocationUtil.updateLocationResult(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            LocationUtil.updateLocationResult(null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public static String[] getLocationInfo(Context context) {
        String[] strArr = locationInfo;
        if (strArr != null && strArr.length == 0) {
            return strArr;
        }
        startLocation(context);
        return new String[]{"0.0", "0.0"};
    }

    public static void start(Context context) {
        startLocation(context);
    }

    @SuppressLint({"MissingPermission"})
    private static void startLocation(Context context) {
        locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (!PermissionUtil.check(context, "android.permission.ACCESS_COARSE_LOCATION") && !PermissionUtil.check(context, "android.permission.ACCESS_FINE_LOCATION")) {
            Log.d("LocationUtil", "NO Location Permission");
        } else {
            updateLocationResult(locationManager.getLastKnownLocation(bestProvider));
            locationManager.requestLocationUpdates("gps", 2000L, 0.0f, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLocationResult(Location location) {
        if (location != null) {
            locationInfo = new String[]{location.getLongitude() + "", location.getLatitude() + ""};
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("updateLocationResult: ");
            sb.append(location);
            ALog.d(str, sb.toString());
        }
    }
}
