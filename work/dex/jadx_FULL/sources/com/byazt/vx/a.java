package com.byazt.vx;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 34})
public class a {
    public static long c = 1800000;
    public static Handler tt = new Handler(Looper.getMainLooper());

    @com.byazt.zqa.c(c = {0, 1, 962, 464})
    public static class c implements Callable<Location> {
        public LocationManager c;
        public String tt;

        public c(LocationManager locationManager, String str) {
            this.c = locationManager;
            this.tt = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.c.getLastKnownLocation(this.tt);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    private static boolean tt(Context context) {
        long j = com.byazt.vif.uj.c(null, "gm_tt_ad_mediation_sdk_sp").getLong("lbstime", -1L);
        return j == -1 || System.currentTimeMillis() - j > c;
    }

    private static n uj(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        n nVar = null;
        if (locationManager != null) {
            try {
                Location locationC = c(locationManager);
                if (locationC != null && tt(locationC)) {
                    tt(context, locationC);
                    nVar = new n((float) locationC.getLatitude(), (float) locationC.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.vx.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.tt(context, locationManager);
                        }
                    });
                } else {
                    tt(context, locationManager);
                }
            } catch (Throwable th) {
                if (com.byazt.eu.tt.tt()) {
                    com.byazt.nr.m.c(th);
                }
            }
        }
        return nVar;
    }

    @Nullable
    private static n ve(Context context) {
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(null, "gm_tt_ad_mediation_sdk_sp");
        float f = veVarC.getFloat("latitude", -1.0f);
        float f2 = veVarC.getFloat("longitude", -1.0f);
        if (f == -1.0f || f2 == -1.0f) {
            return null;
        }
        return new n(f, f2);
    }

    private static String tt(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    @Nullable
    public static n c(Context context) {
        if (!com.byazt.bp.c.t().qy().c()) {
            return null;
        }
        Context context2 = context == null ? com.byazt.bp.tt.getContext() : context.getApplicationContext();
        if (context2 == null) {
            return null;
        }
        n nVarVe = ve(context2);
        if (!tt(context2)) {
            return nVarVe;
        }
        int iC = com.byazt.ka.tt.c(context2, "android.permission.ACCESS_FINE_LOCATION");
        int iC2 = com.byazt.ka.tt.c(context2, "android.permission.ACCESS_COARSE_LOCATION");
        if (iC == 0 || iC2 == 0) {
            return uj(context2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.byazt.vx.a.2
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null && a.tt(location)) {
                    a.tt(context, location);
                }
                a.tt(locationManager, this);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        try {
            String strTt = tt(locationManager);
            if (TextUtils.isEmpty(strTt)) {
                return;
            }
            locationManager.requestSingleUpdate(strTt, locationListener, Looper.getMainLooper());
            tt.postDelayed(new Runnable() { // from class: com.byazt.vx.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.tt(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            if (com.byazt.eu.tt.tt()) {
                com.byazt.nr.m.c(th);
            }
            tt(locationManager, locationListener);
        }
    }

    private static Location c(LocationManager locationManager) {
        Location locationC = c(locationManager, "gps");
        if (locationC == null) {
            locationC = c(locationManager, "network");
        }
        return locationC == null ? c(locationManager, "passive") : locationC;
    }

    private static Location c(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new c(locationManager, str));
            com.byazt.eu.n.uj(futureTask);
            return (Location) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.byazt.eu.tt.tt()) {
                com.byazt.nr.m.c(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Context context, Location location) {
        if (tt(location)) {
            com.byazt.it.ve veVarC = com.byazt.vif.uj.c(null, "gm_tt_ad_mediation_sdk_sp");
            veVarC.put("latitude", (float) location.getLatitude());
            veVarC.put("longitude", (float) location.getLongitude());
            veVarC.put("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(Location location) {
        return (location.getLatitude() == AudioStats.AUDIO_AMPLITUDE_NONE || location.getLongitude() == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
    }
}
