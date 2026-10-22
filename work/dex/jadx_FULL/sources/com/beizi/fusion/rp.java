package com.beizi.fusion;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.amap.api.location.AMapLocation;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rp {
    private static rp q;
    public String e;
    public String f;
    public long h;
    private EnvInfo i;
    private Context j;
    private boolean k;
    private boolean l;
    private boolean m;
    private long n;
    private long o;
    private int p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l7 f27734a = l7.NET_OTHER;
    private k7 b = k7.ISP_OTHER;
    public boolean c = true;
    private int d = -1;
    public String g = AMapLocation.COORD_TYPE_WGS84;

    private rp() {
        RequestInfo requestInfo;
        this.n = 86400000L;
        Context contextM = q1.h().m();
        this.j = contextM;
        if (contextM == null || (requestInfo = RequestInfo.getInstance(contextM)) == null) {
            return;
        }
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        this.l = q1.h().y();
        this.m = q1.h().w();
        if (this.l) {
            long locationFrequency = ResponseInfo.getInstance(this.j).getLocationFrequency();
            if (locationFrequency > 0) {
                this.n = locationFrequency;
            }
        }
        EnvInfo envInfo = requestInfo.getEnvInfo();
        this.i = envInfo;
        if (envInfo == null || !"true".equals(envInfo.isIsVpn())) {
            return;
        }
        this.p = 1;
    }

    public static synchronized rp a() {
        if (q == null) {
            synchronized (rp.class) {
                if (q == null) {
                    q = new rp();
                }
            }
        }
        return q;
    }

    private synchronized void d() {
        try {
            if (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.f) && !this.k) {
                this.k = true;
                if (s3.a() == null || s3.a().c()) {
                    Context contextG = a4.j().g();
                    if (contextG.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || contextG.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        if (this.o == 0) {
                            this.o = ((Long) co.a(this.j, "LOCATION_TIME", (Object) 0L)).longValue();
                        }
                        if (this.o > 0 && System.currentTimeMillis() - this.o < this.n) {
                            this.e = (String) co.a(this.j, "LOCATION_LONGITUDE", (Object) "");
                            this.f = (String) co.a(this.j, "LOCATION_LATITUDE", (Object) "");
                            this.h = ((Long) co.a(this.j, "LOCATION_TIMESTAMP", (Object) 0L)).longValue();
                            this.k = false;
                            return;
                        }
                        LocationManager locationManager = (LocationManager) contextG.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                        if (locationManager == null) {
                            f();
                            this.k = false;
                            return;
                        }
                        String bestProvider = locationManager.getBestProvider(new Criteria(), true);
                        if (TextUtils.isEmpty(bestProvider)) {
                            f();
                            this.k = false;
                            return;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        this.o = jCurrentTimeMillis;
                        co.b(this.j, "LOCATION_TIME", Long.valueOf(jCurrentTimeMillis));
                        Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                        if (lastKnownLocation != null) {
                            this.e = String.valueOf(lastKnownLocation.getLongitude());
                            this.f = String.valueOf(lastKnownLocation.getLatitude());
                            this.h = lastKnownLocation.getTime();
                            co.b(this.j, "LOCATION_LONGITUDE", this.e);
                            co.b(this.j, "LOCATION_LATITUDE", this.f);
                            co.b(this.j, "LOCATION_TIMESTAMP", Long.valueOf(this.h));
                        } else {
                            f();
                        }
                    } else {
                        f();
                    }
                } else {
                    f();
                }
                this.k = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void f() {
        BeiZiLocation beiZiLocationB;
        if (s3.a() == null || (beiZiLocationB = s3.a().b()) == null) {
            return;
        }
        this.e = beiZiLocationB.getLongitude();
        this.f = beiZiLocationB.getLatitude();
        this.g = beiZiLocationB.getType();
        this.h = beiZiLocationB.getTime();
    }

    public int b() {
        return this.p;
    }

    public k7 c() {
        k7 k7Var = this.b;
        k7 k7Var2 = k7.ISP_OTHER;
        if (k7Var == k7Var2) {
            EnvInfo envInfo = this.i;
            if (envInfo != null) {
                String isp = envInfo.getIsp();
                if ("0".equals(isp)) {
                    this.b = k7.ISP_UNKNOWN;
                } else if ("1".equals(isp)) {
                    this.b = k7.ISP_CN_MOBILE;
                } else if ("2".equals(isp)) {
                    this.b = k7.ISP_CN_UNICOM;
                } else if ("3".equals(isp)) {
                    this.b = k7.ISP_CN_TEL;
                }
            } else if (k7Var == k7Var2) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) a4.j().u.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                    if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                        String simOperator = telephonyManager.getSimOperator();
                        if (simOperator == null) {
                            this.b = k7.ISP_UNKNOWN;
                        } else if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                            this.b = k7.ISP_CN_MOBILE;
                        } else if (simOperator.equals("46001")) {
                            this.b = k7.ISP_CN_UNICOM;
                        } else if (simOperator.equals("46003")) {
                            this.b = k7.ISP_CN_TEL;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.b;
    }

    public l7 e() {
        l7 l7Var = this.f27734a;
        l7 l7Var2 = l7.NET_OTHER;
        if (l7Var == l7Var2) {
            EnvInfo envInfo = this.i;
            if (envInfo != null) {
                String net = envInfo.getNet();
                if ("1".equals(net)) {
                    this.f27734a = l7.NET_3G;
                } else if ("2".equals(net)) {
                    this.f27734a = l7.NET_4G;
                } else if ("3".equals(net)) {
                    this.f27734a = l7.NET_5G;
                } else if ("4".equals(net)) {
                    this.f27734a = l7.NET_WIFI;
                } else if ("5".equals(net)) {
                    this.f27734a = l7Var2;
                } else if ("6".equals(net)) {
                    this.f27734a = l7.NET_2G;
                }
            } else {
                this.f27734a = sp.a(a4.j().u);
            }
        }
        return this.f27734a;
    }

    public void g() {
        Location lastKnownLocation;
        try {
            if (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.f) && !this.k) {
                if (this.l) {
                    d();
                    return;
                }
                this.k = true;
                if (s3.a() != null && !s3.a().c()) {
                    f();
                    return;
                }
                Context contextG = a4.j().g();
                boolean z = contextG.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
                boolean z2 = contextG.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
                if (!z && !z2) {
                    f();
                    return;
                }
                LocationManager locationManager = (LocationManager) contextG.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager == null) {
                    this.k = false;
                    f();
                    return;
                }
                Location location = null;
                if (this.m) {
                    String bestProvider = locationManager.getBestProvider(new Criteria(), true);
                    if (!TextUtils.isEmpty(bestProvider)) {
                        lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                    } else if (z) {
                        lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    } else if (z2) {
                        lastKnownLocation = locationManager.getLastKnownLocation("network");
                    }
                    location = lastKnownLocation;
                } else {
                    Iterator<String> it = locationManager.getProviders(true).iterator();
                    while (it.hasNext()) {
                        Location lastKnownLocation2 = locationManager.getLastKnownLocation(it.next());
                        if (lastKnownLocation2 != null && (location == null || (lastKnownLocation2.getTime() > 0 && location.getTime() > 0 && lastKnownLocation2.getTime() > location.getTime()))) {
                            location = lastKnownLocation2;
                        }
                    }
                    this.k = false;
                }
                if (location == null) {
                    f();
                    return;
                }
                this.e = String.valueOf(location.getLongitude());
                this.f = String.valueOf(location.getLatitude());
                this.h = location.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
