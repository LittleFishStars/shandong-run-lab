package com.kwad.components.core.t;

import android.content.Context;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o {
    public static boolean aP(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            return locationManager != null && locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
        }
    }

    private static boolean aQ(Context context) {
        try {
            return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
