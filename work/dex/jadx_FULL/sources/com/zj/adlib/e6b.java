package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.c;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e6b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AMapLocation f41358a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f16206a = "CoarseLocation";
    public static long c = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f16207c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f16210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationManager f16212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f16213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f16215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.autonavi.aps.amapapi.filters.a f16216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16209a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16218a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16208a = 0;
    public int b = 240;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f16221c = 80;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f16222d = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16219b = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f16223e = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f16217a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f16220b = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption.GeoLanguage f16214a = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationListener f16211a = null;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e6b f41359a;

        public a(e6b e6bVar) {
            this.f41359a = e6bVar;
        }

        public final void a() {
            this.f41359a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                e6b e6bVar = this.f41359a;
                if (e6bVar != null) {
                    e6bVar.e(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                e6b e6bVar = this.f41359a;
                if (e6bVar != null) {
                    e6bVar.A();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            "gps".equalsIgnoreCase(str);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                e6b e6bVar = this.f41359a;
                if (e6bVar != null) {
                    e6bVar.c(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public e6b(Context context, Handler handler) {
        this.f16216a = null;
        this.f16210a = context;
        this.f16213a = handler;
        try {
            this.f16212a = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        } catch (Throwable th) {
            b.a(th, f16206a, "<init>");
        }
        this.f16216a = new com.autonavi.aps.amapapi.filters.a();
    }

    public static void B(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.r()) {
            long time = aMapLocation.getTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jA = c.a(time, jCurrentTimeMillis, com.autonavi.aps.amapapi.utils.a.s());
            if (jA != time) {
                aMapLocation.setTime(jA);
                g.a(time, jCurrentTimeMillis);
            }
        }
    }

    public static com.autonavi.aps.amapapi.model.a a(int i, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i);
        aVar.setLocationDetail(str);
        return aVar;
    }

    public static boolean m(LocationManager locationManager) {
        try {
            if (f16207c) {
                return d;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                d = false;
            } else {
                d = allProviders.contains("gps");
            }
            f16207c = true;
            return d;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            return d;
        }
    }

    public static int o(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras.getInt("satellites");
        }
        return 0;
    }

    public static boolean r(LocationManager locationManager) {
        try {
            if (e) {
                return f;
            }
            boolean zIsProviderEnabled = locationManager.isProviderEnabled("network");
            f = zIsProviderEnabled;
            e = true;
            return zIsProviderEnabled;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            return f;
        }
    }

    public final void A() {
        try {
            this.f16222d = 0;
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        LocationManager locationManager = this.f16212a;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f16211a;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f16211a).a();
                this.f16211a = null;
            }
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
        }
        try {
            Handler handler = this.f16213a;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.f16222d = 0;
        this.f16209a = 0L;
        this.f16219b = 0L;
        this.f16208a = 0;
        this.f16223e = 0;
        this.f16216a.a();
    }

    public final void c(int i) {
        if (i == 0) {
            try {
                this.f16222d = 0;
            } catch (Throwable unused) {
            }
        }
    }

    public final void d(int i, String str, long j) {
        try {
            if (this.f16213a != null) {
                Message messageObtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                messageObtain.obj = aMapLocation;
                messageObtain.what = i;
                this.f16213a.sendMessageDelayed(messageObtain, j);
            }
        } catch (Throwable unused) {
        }
    }

    public final void e(Location location) {
        Boolean bool;
        Handler handler = this.f16213a;
        if (handler != null) {
            handler.removeMessages(100);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (i.a(aMapLocation)) {
                if ("gps".equals(location.getProvider())) {
                    aMapLocation.setProvider("gps_coarse");
                } else {
                    aMapLocation.setProvider("network_coarse");
                }
                aMapLocation.setLocationType(11);
                if (!this.f16218a && i.a(aMapLocation)) {
                    g.b(this.f16210a, i.b() - this.f16209a, b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f16218a = true;
                }
                Boolean bool2 = Boolean.FALSE;
                try {
                    bool = (Boolean) e.a(location, "isFromMockProvider", new Object[0]);
                    try {
                        "CoarseLocation | isFromMock=".concat(String.valueOf(bool));
                    } catch (Throwable unused) {
                        bool2 = bool;
                        bool = bool2;
                    }
                } catch (Throwable unused2) {
                }
                if (bool.booleanValue()) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f16215a.isMockEnable()) {
                        int i = this.f16223e;
                        if (i <= 3) {
                            this.f16223e = i + 1;
                            return;
                        }
                        g.a((String) null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("CoarseLocation has been mocked!#2007");
                        aMapLocation.setLatitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                        aMapLocation.setLongitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                        aMapLocation.setAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        s(aMapLocation);
                        return;
                    }
                } else {
                    this.f16223e = 0;
                }
                int iO = o(location);
                this.f16222d = iO;
                aMapLocation.setSatellites(iO);
                x(aMapLocation);
                B(aMapLocation);
                AMapLocation aMapLocationY = y(aMapLocation);
                g(aMapLocationY);
                p(aMapLocationY);
                synchronized (this.f16217a) {
                    h(aMapLocationY, f41358a);
                }
                s(aMapLocationY);
            }
        } catch (Throwable th) {
            b.a(th, "CoarseLocation", "onLocationChanged");
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(AMapLocation.class.getClassLoader());
            this.b = bundle.getInt("I_MAX_GEO_DIS");
            this.f16221c = bundle.getInt("I_MIN_GEO_DIS");
            AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
            if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                return;
            }
            synchronized (this.f16217a) {
                try {
                    f41358a = aMapLocation;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void g(AMapLocation aMapLocation) {
        if (i.a(aMapLocation)) {
            this.f16208a++;
        }
    }

    public final void h(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f16215a.isNeedAddress() || i.a(aMapLocation, aMapLocation2) >= this.b) {
            return;
        }
        b.a(aMapLocation, aMapLocation2);
    }

    public final void i(AMapLocationClientOption aMapLocationClientOption) {
        this.f16215a = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f16215a = new AMapLocationClientOption();
        }
        new StringBuilder("option: ").append(this.f16215a.toString());
        if (!this.f16215a.isOnceLocation()) {
            w();
        } else if (!t()) {
            u();
        } else {
            try {
                c = h.a(this.f16210a, "pref", "lagt", c);
            } catch (Throwable unused) {
            }
            z();
        }
    }

    @SuppressLint({"NewApi"})
    public final int n() {
        LocationManager locationManager = this.f16212a;
        if (locationManager == null || !m(locationManager)) {
            return 1;
        }
        int i = Settings.Secure.getInt(this.f16210a.getContentResolver(), "location_mode", 0);
        if (i == 0) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        return !this.f16220b ? 4 : 0;
    }

    public final void p(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && this.f16213a != null) {
            long jB = i.b();
            if (this.f16215a.getInterval() <= 8000 || jB - this.f16219b > this.f16215a.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message messageObtain = Message.obtain();
                messageObtain.setData(bundle);
                messageObtain.what = 102;
                synchronized (this.f16217a) {
                    if (f41358a == null || i.a(aMapLocation, f41358a) > this.f16221c) {
                        this.f16213a.sendMessage(messageObtain);
                    }
                }
            }
        }
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f16215a = aMapLocationClientOption;
        new StringBuilder("option: ").append(this.f16215a.toString());
        this.f16213a.removeMessages(100);
        if (this.f16214a != this.f16215a.getGeoLanguage()) {
            synchronized (this.f16217a) {
                f41358a = null;
            }
        }
        this.f16214a = this.f16215a.getGeoLanguage();
    }

    public final void s(AMapLocation aMapLocation) {
        if (this.f16215a.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f16215a.getDeviceModeDistanceFilter() > 0.0f) {
            v(aMapLocation);
        } else if (i.b() - this.f16219b >= this.f16215a.getInterval() - 200) {
            this.f16219b = i.b();
            v(aMapLocation);
        }
    }

    public final boolean t() {
        boolean zBooleanValue = true;
        try {
            if (i.c() >= 28) {
                if (this.f16212a == null) {
                    this.f16212a = (LocationManager) this.f16210a.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                }
                zBooleanValue = ((Boolean) e.a(this.f16212a, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (i.c() >= 24 && i.c() < 28 && Settings.Secure.getInt(this.f16210a.getContentResolver(), "location_mode", 0) == 0) {
                return false;
            }
        } catch (Throwable unused) {
        }
        return zBooleanValue;
    }

    public final void u() {
        s(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    public final void v(AMapLocation aMapLocation) {
        if (this.f16213a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = aMapLocation;
            messageObtain.what = 101;
            this.f16213a.sendMessage(messageObtain);
        }
    }

    public final void w() {
        s(a(20, "模糊权限下不支持连续定位#2006"));
    }

    public final void x(AMapLocation aMapLocation) {
        try {
            if (!b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.f16215a.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint dPointA = d.a(this.f16210a, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(dPointA.getLatitude());
            aMapLocation.setLongitude(dPointA.getLongitude());
            aMapLocation.setOffset(this.f16215a.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
            new StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
        }
    }

    public final AMapLocation y(AMapLocation aMapLocation) {
        if (!i.a(aMapLocation) || this.f16208a < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f16216a.a(aMapLocation);
    }

    public final void z() {
        if (this.f16212a == null) {
            return;
        }
        try {
            this.f16220b = true;
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = this.f16210a.getMainLooper();
            }
            this.f16209a = i.b();
            if (r(this.f16212a)) {
                if (this.f16211a == null) {
                    this.f16211a = new a(this);
                }
                this.f16212a.requestLocationUpdates("network", this.f16215a.getInterval(), this.f16215a.getDeviceModeDistanceFilter(), this.f16211a, looperMyLooper);
            }
            if (m(this.f16212a)) {
                try {
                    if (i.a() - c >= 259200000) {
                        if (i.c(this.f16210a, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f16212a.sendExtraCommand("gps", "force_xtra_injection", null);
                            c = i.a();
                            SharedPreferences.Editor editorA = h.a(this.f16210a, "pref");
                            h.a(editorA, "lagt", c);
                            h.a(editorA);
                        } else {
                            b.a(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("CoarseLocation | sendExtraCommand error: ").append(th.getMessage());
                }
                if (this.f16211a == null) {
                    this.f16211a = new a(this);
                }
                this.f16212a.requestLocationUpdates("gps", this.f16215a.getInterval(), this.f16215a.getDeviceModeDistanceFilter(), this.f16211a, looperMyLooper);
            }
            if (d || f) {
                d(100, "系统返回定位结果超时#2002", this.f16215a.getHttpTimeOut());
            }
            if (d || f) {
                return;
            }
            d(100, "系统定位当前不可用#2003", 0L);
        } catch (SecurityException e2) {
            this.f16220b = false;
            g.a((String) null, 2121);
            d(101, e2.getMessage() + "#2004", 0L);
        } catch (Throwable th2) {
            new StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th2.getMessage());
            b.a(th2, "CoarseLocation", "requestLocationUpdates part2");
        }
    }
}
