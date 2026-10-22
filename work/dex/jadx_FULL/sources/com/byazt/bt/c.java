package com.byazt.bt;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 20})
public class c {
    public static long c = 1800000;
    public static volatile long n = 0;
    public static long tt = 60000;
    public static volatile long uj;
    public static volatile com.byazt.zuu.c ve;

    /* JADX INFO: renamed from: com.byazt.bt.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 274, 44})
    public static class CallableC0355c implements Callable<com.byazt.lz.uj> {
        public com.byazt.dna.c c;

        public CallableC0355c(com.byazt.dna.c cVar) {
            this.c = cVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.byazt.lz.uj call() throws Exception {
            return this.c.getCustomController().getTTLocation();
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 274, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt implements Callable<Location> {
        public LocationManager c;
        public String tt;

        public tt(LocationManager locationManager, String str) {
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

    public static com.byazt.zuu.c tt(Context context, boolean z, com.byazt.dna.c cVar, int i) {
        if ((ve != null && !c()) || !tt()) {
            return ve;
        }
        String strVe = com.byazt.nr.c.ve(x.tt("new_sdk_ad_location", 2147483647L, cVar));
        if (strVe != null) {
            try {
                JSONObject jSONObject = new JSONObject(strVe);
                String strOptString = jSONObject.optString("latitude");
                String strOptString2 = jSONObject.optString("longitude");
                long jOptLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    ve = new com.byazt.zuu.c(Float.valueOf(strOptString).floatValue(), Float.valueOf(strOptString2).floatValue(), jOptLong);
                    n = jOptLong;
                }
            } catch (Throwable th) {
                m.c(th);
            }
            if (z) {
                return ve;
            }
        }
        if (ve != null && !c()) {
            return ve;
        }
        com.byazt.lz.c customController = cVar.getCustomController();
        if (customController.isCanUseLocation()) {
            n = System.currentTimeMillis();
            uj = System.currentTimeMillis();
            c(context, cVar, i);
            return ve;
        }
        com.byazt.lz.uj tTLocation = customController.getTTLocation();
        if (tTLocation != null) {
            n = System.currentTimeMillis();
            ve = new com.byazt.zuu.c((float) tTLocation.getLatitude(), (float) tTLocation.getLongitude(), System.currentTimeMillis());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (ve != null) {
                jSONObject2.put("latitude", Float.toString(ve.c));
                jSONObject2.put("longitude", Float.toString(ve.tt));
                jSONObject2.put("lbstime", ve.ve);
            }
            x.c("new_sdk_ad_location", com.byazt.nr.c.tt(jSONObject2.toString()), cVar, i);
        } catch (Exception e) {
            m.c(e);
        }
        return ve;
    }

    public static com.byazt.fn.c c(Context context, boolean z, com.byazt.dna.c cVar, int i) {
        return tt(context, z, cVar, i);
    }

    private static void c(final Context context, final com.byazt.dna.c cVar, final int i) {
        ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("getLocation c") { // from class: com.byazt.bt.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.zuu.c cVarTt = c.tt(context.getApplicationContext(), cVar);
                long unused = c.uj = 0L;
                if (cVarTt != null) {
                    com.byazt.zuu.c unused2 = c.ve = cVarTt;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(cVarTt.c));
                        jSONObject.put("longitude", Float.toString(cVarTt.tt));
                        jSONObject.put("lbstime", cVarTt.ve);
                        x.c("new_sdk_ad_location", com.byazt.nr.c.tt(jSONObject.toString()), cVar, i);
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            }
        });
    }

    private static boolean c() {
        return System.currentTimeMillis() - n > c;
    }

    private static LocationManager c(Context context) {
        try {
            return (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Location c(LocationManager locationManager) {
        Location locationC = c(locationManager, "gps");
        if (locationC == null) {
            locationC = c(locationManager, "network");
        }
        return locationC == null ? c(locationManager, "passive") : locationC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location c(LocationManager locationManager, String str) {
        try {
            final com.byazt.bwm.a aVar = new com.byazt.bwm.a(new tt(locationManager, str), 1, 2);
            ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("getLastKnownLocation") { // from class: com.byazt.bt.c.3
                @Override // java.lang.Runnable
                public void run() {
                    aVar.run();
                }
            });
            return (Location) aVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.byazt.lz.uj c(com.byazt.dna.c cVar) {
        try {
            final com.byazt.bwm.a aVar = new com.byazt.bwm.a(new CallableC0355c(cVar), 1, 2);
            ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("getLastKnownLocation") { // from class: com.byazt.bt.c.4
                @Override // java.lang.Runnable
                public void run() {
                    aVar.run();
                }
            });
            return (com.byazt.lz.uj) aVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean tt() {
        return System.currentTimeMillis() - uj > tt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.zuu.c tt(final Context context, com.byazt.dna.c cVar) {
        com.byazt.zuu.c cVar2 = null;
        if (!cVar.getCustomController().isCanUseLocation()) {
            try {
                com.byazt.lz.uj ujVarC = c(cVar);
                if (ujVarC != null) {
                    return new com.byazt.zuu.c(Double.valueOf(ujVarC.getLatitude()).floatValue(), Double.valueOf(ujVarC.getLongitude()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManagerC = c(context);
        if (locationManagerC != null) {
            try {
                Location locationC = c(locationManagerC);
                if (locationC != null && tt(locationC)) {
                    cVar2 = new com.byazt.zuu.c((float) locationC.getLatitude(), (float) locationC.getLongitude(), System.currentTimeMillis());
                }
                com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.bt.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.tt(context, locationManagerC);
                    }
                });
            } catch (Throwable th) {
                if (m.ve()) {
                    m.c(th);
                }
            }
        }
        return cVar2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.byazt.bt.c.5
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    c.tt(location);
                }
                c.tt(locationManager, this);
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
            locationManager.requestSingleUpdate(strTt, locationListener, Looper.myLooper());
            com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.bt.c.6
                @Override // java.lang.Runnable
                public void run() {
                    c.tt(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            if (m.ve()) {
                m.c(th);
            }
            tt(locationManager, locationListener);
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
            if (m.ve()) {
                m.c(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(Location location) {
        return (location.getLatitude() == AudioStats.AUDIO_AMPLITUDE_NONE || location.getLongitude() == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
    }
}
