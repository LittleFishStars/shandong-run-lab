package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a8b {
    public static AMapLocation b = null;
    public static volatile AMapLocation c = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static Object f15179c = new Object();
    public static long e = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static boolean f15180e = false;
    public static long f = 0;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static boolean f15181f = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f15184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GnssStatus.Callback f15185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationManager f15189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f15190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f15193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.autonavi.aps.amapapi.filters.a f15194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15183a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f15199b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15197a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15182a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f15198b = 240;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f15202c = 80;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocation f15191a = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f15203c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40477a = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f15195a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f15200b = new Object();
    public int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GpsStatus f15187a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GpsStatus.Listener f15186a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption.GeoLanguage f15192a = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15201b = true;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f15205d = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f15207e = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationListener f15188a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15196a = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15204c = false;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f15208f = 0;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f15206d = false;

    public class a extends GnssStatus.Callback {
        public a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
            a8b.N();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            a8b.this.f(gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            a8b.L();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            a8b.this.M();
        }
    }

    public class b implements GpsStatus.Listener {
        public b() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            try {
                a8b a8bVar = a8b.this;
                LocationManager locationManager = a8bVar.f15189a;
                if (locationManager == null) {
                    return;
                }
                a8bVar.f15187a = locationManager.getGpsStatus(a8bVar.f15187a);
                if (i == 1) {
                    a8b.L();
                    return;
                }
                if (i == 2) {
                    a8b.this.M();
                } else if (i == 3) {
                    a8b.N();
                } else {
                    if (i != 4) {
                        return;
                    }
                    a8b.this.O();
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    public static class c implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a8b f40480a;

        public c(a8b a8bVar) {
            this.f40480a = a8bVar;
        }

        public final void a() {
            this.f40480a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                a8b a8bVar = this.f40480a;
                if (a8bVar != null) {
                    a8bVar.g(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                a8b a8bVar = this.f40480a;
                if (a8bVar != null) {
                    a8bVar.q(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                a8b a8bVar = this.f40480a;
                if (a8bVar != null) {
                    a8bVar.d(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a8b(Context context, Handler handler) {
        this.f15194a = null;
        this.f15184a = context;
        this.f15190a = handler;
        try {
            this.f15189a = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "<init>");
        }
        this.f15194a = new com.autonavi.aps.amapapi.filters.a();
    }

    public static void J(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.r()) {
            long time = aMapLocation.getTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jA = com.autonavi.aps.amapapi.utils.c.a(time, jCurrentTimeMillis, com.autonavi.aps.amapapi.utils.a.s());
            if (jA != time) {
                aMapLocation.setTime(jA);
                g.a(time, jCurrentTimeMillis);
            }
        }
    }

    public static void L() {
    }

    public static void N() {
    }

    public static boolean Q() {
        try {
            return ((Boolean) e.a(s4b.v("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), s4b.v("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean r(LocationManager locationManager) {
        try {
            if (f15180e) {
                return f15181f;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                f15181f = false;
            } else {
                f15181f = allProviders.contains("gps");
            }
            f15180e = true;
            return f15181f;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            return f15181f;
        }
    }

    @SuppressLint({"NewApi"})
    public final int A() {
        LocationManager locationManager = this.f15189a;
        if (locationManager == null || !r(locationManager)) {
            return 1;
        }
        int i = Settings.Secure.getInt(this.f15184a.getContentResolver(), "location_mode", 0);
        if (i == 0) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        return !this.f15201b ? 4 : 0;
    }

    public final void B(AMapLocation aMapLocation) {
        if (this.f15190a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = aMapLocation;
            messageObtain.what = 2;
            this.f15190a.sendMessage(messageObtain);
        }
    }

    public final int C() {
        return this.d;
    }

    public final void D(AMapLocation aMapLocation) {
        try {
            if (!com.autonavi.aps.amapapi.utils.b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.f15193a.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint dPointA = d.a(this.f15184a, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(dPointA.getLatitude());
            aMapLocation.setLongitude(dPointA.getLongitude());
            aMapLocation.setOffset(this.f15193a.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    public final void E(AMapLocation aMapLocation) {
        try {
            int i = this.d;
            if (i >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean F() {
        AMapLocationClientOption aMapLocationClientOption = this.f15193a;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || i.b() - this.f15199b <= 300000) ? false : true;
    }

    public final AMapLocation G(AMapLocation aMapLocation) {
        if (!i.a(aMapLocation) || this.f15182a < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f15194a.a(aMapLocation);
    }

    public final void K() {
        if (this.f15189a == null) {
            return;
        }
        try {
            P();
            this.f15201b = true;
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = this.f15184a.getMainLooper();
            }
            Looper looper = looperMyLooper;
            this.f15183a = i.b();
            if (!r(this.f15189a)) {
                e(8, 14, "no gps provider#1402", 0L);
                return;
            }
            try {
                if (i.a() - f >= 259200000) {
                    if (i.c(this.f15184a, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.f15189a.sendExtraCommand("gps", "force_xtra_injection", null);
                        f = i.a();
                        SharedPreferences.Editor editorA = h.a(this.f15184a, "pref");
                        h.a(editorA, "lagt", f);
                        h.a(editorA);
                    } else {
                        com.autonavi.aps.amapapi.utils.b.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
            }
            if (this.f15188a == null) {
                this.f15188a = new c(this);
            }
            this.f15189a.requestLocationUpdates("gps", this.f15193a.getInterval(), this.f15193a.getDeviceModeDistanceFilter(), this.f15188a, looper);
            a aVar = new a();
            this.f15185a = aVar;
            this.f15189a.registerGnssStatusCallback(aVar);
            e(8, 14, "no enough satellites#1401", this.f15193a.getHttpTimeOut());
        } catch (SecurityException e2) {
            this.f15201b = false;
            g.a((String) null, 2121);
            e(2, 12, e2.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
            com.autonavi.aps.amapapi.utils.b.a(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    public final void M() {
        this.d = 0;
    }

    public final void O() {
        Iterable<GpsSatellite> satellites;
        int i = 0;
        try {
            GpsStatus gpsStatus = this.f15187a;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.f15187a.getMaxSatellites();
                while (it.hasNext() && i < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i++;
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.d = i;
    }

    public final void P() {
        if (i.b() - e > 5000 || !i.a(b)) {
            return;
        }
        if (this.f15193a.isMockEnable() || !b.isMock()) {
            this.f15199b = i.b();
            y(b);
        }
    }

    public final AMapLocation R() {
        float f2;
        float f3;
        try {
            if (i.a(this.f15191a) && com.autonavi.aps.amapapi.utils.a.j() && Q()) {
                JSONObject jSONObject = new JSONObject((String) e.a(s4b.v("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), s4b.v("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long jOptLong = jSONObject.optLong("time");
                if (!this.f15206d) {
                    this.f15206d = true;
                    g.a("useNaviLoc", "use NaviLoc");
                }
                if (i.a() - jOptLong <= 5500) {
                    double dOptDouble = jSONObject.optDouble("lat", AudioStats.AUDIO_AMPLITUDE_NONE);
                    double dOptDouble2 = jSONObject.optDouble("lng", AudioStats.AUDIO_AMPLITUDE_NONE);
                    float f4 = 0.0f;
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f2 = 0.0f;
                    }
                    double dOptDouble3 = jSONObject.optDouble("altitude", AudioStats.AUDIO_AMPLITUDE_NONE);
                    try {
                        f3 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f3 = 0.0f;
                    }
                    try {
                        f4 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(dOptDouble);
                    aMapLocation.setLongitude(dOptDouble2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setAltitude(dOptDouble3);
                    aMapLocation.setBearing(f3);
                    aMapLocation.setSpeed(f4);
                    aMapLocation.setTime(jOptLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (i.a(aMapLocation, this.f15191a) <= 300.0f) {
                        synchronized (this.f15200b) {
                            this.f15191a.setLongitude(dOptDouble2);
                            this.f15191a.setLatitude(dOptDouble);
                            this.f15191a.setAccuracy(f2);
                            this.f15191a.setBearing(f3);
                            this.f15191a.setSpeed(f4);
                            this.f15191a.setTime(jOptLong);
                            this.f15191a.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0098  */
    public final AMapLocation b(AMapLocation aMapLocation, String str) {
        long j;
        if (this.f15191a == null) {
            return aMapLocation;
        }
        if ((!this.f15193a.isMockEnable() && this.f15191a.isMock()) || !i.a(this.f15191a)) {
            return aMapLocation;
        }
        AMapLocation aMapLocationR = R();
        if (aMapLocationR != null && i.a(aMapLocationR)) {
            aMapLocationR.setTrustedLevel(2);
            return aMapLocationR;
        }
        float speed = this.f15191a.getSpeed();
        if (speed == 0.0f) {
            long j2 = this.f15203c;
            if (j2 > 0 && j2 < 8) {
                float f2 = this.f40477a;
                if (f2 > 0.0f) {
                    speed = f2 / j2;
                }
            }
        }
        if (aMapLocation == null || !i.a(aMapLocation)) {
            j = 30000;
        } else if (aMapLocation.getAccuracy() < 200.0f) {
            int i = this.f15208f + 1;
            this.f15208f = i;
            if (this.f15196a == null && i >= 2) {
                this.f15204c = true;
            }
            j = speed > 5.0f ? 10000L : 15000L;
        } else {
            if (!TextUtils.isEmpty(this.f15196a)) {
                this.f15204c = false;
                this.f15208f = 0;
            }
            if (speed > 5.0f) {
                j = 20000;
            } else {
                j = 30000;
            }
        }
        long jB = i.b() - this.f15199b;
        if (jB > 30000) {
            return aMapLocation;
        }
        if (jB < j) {
            if (this.f15196a == null && this.f15208f >= 2) {
                this.f15196a = str;
            }
            AMapLocation aMapLocationM149clone = this.f15191a.m149clone();
            aMapLocationM149clone.setTrustedLevel(2);
            return aMapLocationM149clone;
        }
        if (this.f15204c && w(str)) {
            AMapLocation aMapLocationM149clone2 = this.f15191a.m149clone();
            aMapLocationM149clone2.setTrustedLevel(3);
            return aMapLocationM149clone2;
        }
        this.f15196a = null;
        this.f15208f = 0;
        synchronized (this.f15200b) {
            this.f15191a = null;
        }
        this.f15203c = 0L;
        this.f40477a = 0.0f;
        return aMapLocation;
    }

    public final void c() {
        LocationManager locationManager = this.f15189a;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f15188a;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((c) this.f15188a).a();
                this.f15188a = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.f15186a;
            if (listener != null) {
                this.f15189a.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.f15185a;
            if (callback != null) {
                this.f15189a.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.f15190a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.d = 0;
        this.f15183a = 0L;
        this.f15205d = 0L;
        this.f15199b = 0L;
        this.f15182a = 0;
        this.f15207e = 0;
        this.f15194a.a();
        this.f15191a = null;
        this.f15203c = 0L;
        this.f40477a = 0.0f;
        this.f15196a = null;
        this.f15206d = false;
    }

    public final void d(int i) {
        if (i == 0) {
            try {
                this.f15199b = 0L;
                this.d = 0;
            } catch (Throwable unused) {
            }
        }
    }

    public final void e(int i, int i2, String str, long j) {
        try {
            if (this.f15190a == null || this.f15193a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message messageObtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider("gps");
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            messageObtain.obj = aMapLocation;
            messageObtain.what = i;
            this.f15190a.sendMessageDelayed(messageObtain, j);
        } catch (Throwable unused) {
        }
    }

    public final void f(GnssStatus gnssStatus) {
        int i = 0;
        if (gnssStatus != null) {
            try {
                int satelliteCount = gnssStatus.getSatelliteCount();
                int i2 = 0;
                while (i < satelliteCount) {
                    try {
                        if (gnssStatus.usedInFix(i)) {
                            i2++;
                        }
                        i++;
                    } catch (Throwable th) {
                        th = th;
                        i = i2;
                        com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                        this.d = i;
                    }
                }
                i = i2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.d = i;
    }

    public final void g(Location location) {
        Handler handler = this.f15190a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (i.a(aMapLocation)) {
                aMapLocation.setProvider("gps");
                aMapLocation.setLocationType(1);
                if (!this.f15197a && i.a(aMapLocation)) {
                    g.a(this.f15184a, i.b() - this.f15183a, com.autonavi.aps.amapapi.utils.b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f15197a = true;
                }
                if (i.a(aMapLocation, this.d)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f15193a.isMockEnable()) {
                        int i = this.f15207e;
                        if (i <= 3) {
                            this.f15207e = i + 1;
                            return;
                        }
                        g.a((String) null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                        aMapLocation.setLatitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                        aMapLocation.setLongitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                        aMapLocation.setAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        y(aMapLocation);
                        return;
                    }
                } else {
                    this.f15207e = 0;
                }
                aMapLocation.setSatellites(this.d);
                D(aMapLocation);
                E(aMapLocation);
                J(aMapLocation);
                AMapLocation aMapLocationG = G(aMapLocation);
                i(aMapLocationG);
                t(aMapLocationG);
                synchronized (this.f15195a) {
                    j(aMapLocationG, c);
                }
                try {
                    if (i.a(aMapLocationG)) {
                        if (this.f15191a != null) {
                            this.f15203c = location.getTime() - this.f15191a.getTime();
                            this.f40477a = i.a(this.f15191a, aMapLocationG);
                        }
                        synchronized (this.f15200b) {
                            this.f15191a = aMapLocationG.m149clone();
                        }
                        this.f15196a = null;
                        this.f15204c = false;
                        this.f15208f = 0;
                    }
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onLocationChangedLast");
                }
                y(aMapLocationG);
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GpsLocation", "onLocationChanged");
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(AMapLocation.class.getClassLoader());
            this.f15198b = bundle.getInt("I_MAX_GEO_DIS");
            this.f15202c = bundle.getInt("I_MIN_GEO_DIS");
            AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
            if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                return;
            }
            synchronized (this.f15195a) {
                try {
                    c = aMapLocation;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void i(AMapLocation aMapLocation) {
        if (i.a(aMapLocation)) {
            this.f15199b = i.b();
            synchronized (f15179c) {
                e = i.b();
                b = aMapLocation.m149clone();
            }
            this.f15182a++;
        }
    }

    public final void j(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f15193a.isNeedAddress() || i.a(aMapLocation, aMapLocation2) >= this.f15198b) {
            return;
        }
        com.autonavi.aps.amapapi.utils.b.a(aMapLocation, aMapLocation2);
    }

    public final void k(AMapLocationClientOption aMapLocationClientOption) {
        this.f15193a = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f15193a = new AMapLocationClientOption();
        }
        try {
            f = h.a(this.f15184a, "pref", "lagt", f);
        } catch (Throwable unused) {
        }
        K();
    }

    public final void q(String str) {
        try {
            if ("gps".equalsIgnoreCase(str)) {
                this.f15199b = 0L;
                this.d = 0;
            }
        } catch (Throwable unused) {
        }
    }

    public final void t(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && this.f15190a != null) {
            long jB = i.b();
            if (this.f15193a.getInterval() <= 8000 || jB - this.f15205d > this.f15193a.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message messageObtain = Message.obtain();
                messageObtain.setData(bundle);
                messageObtain.what = 5;
                synchronized (this.f15195a) {
                    if (c == null || i.a(aMapLocation, c) > this.f15202c) {
                        this.f15190a.sendMessage(messageObtain);
                    }
                }
            }
        }
    }

    public final void u(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f15193a = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.f15190a) != null) {
            handler.removeMessages(8);
        }
        if (this.f15192a != this.f15193a.getGeoLanguage()) {
            synchronized (this.f15195a) {
                c = null;
            }
        }
        this.f15192a = this.f15193a.getGeoLanguage();
    }

    public final boolean v() {
        return i.b() - this.f15199b <= 2800;
    }

    public final boolean w(String str) {
        try {
            ArrayList<String> arrayListB = i.b(str);
            ArrayList<String> arrayListB2 = i.b(this.f15196a);
            if (arrayListB.size() < 8 || arrayListB2.size() < 8) {
                return false;
            }
            return i.a(this.f15196a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void x() {
        this.f15207e = 0;
    }

    public final void y(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f15193a.getLocationMode())) {
            if (this.f15193a.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f15193a.getDeviceModeDistanceFilter() > 0.0f) {
                B(aMapLocation);
            } else if (i.b() - this.f15205d >= this.f15193a.getInterval() - 200) {
                this.f15205d = i.b();
                B(aMapLocation);
            }
        }
    }
}
