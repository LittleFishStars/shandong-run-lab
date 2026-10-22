package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.p;
import com.baidu.location.b.v;
import com.baidu.location.b.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static long D = 0;
    private static String R = null;
    private static double T = 100.0d;
    private static float W = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26424a = 0;
    private static final Lock al = new ReentrantLock();
    public static String b = "";
    public static String c = "";
    private static d f = null;
    private static Location j = null;
    private static int k = -1;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;
    private BDLocation ar;
    private String av;
    private Context g;
    private Location i;
    private GpsStatus n;
    private c o;
    private boolean p;
    private boolean r;
    private LocationManager h = null;
    private f l = null;
    private h m = null;
    private C0263d q = null;
    private GpsStatus.NmeaListener s = null;
    private OnNmeaMessageListener t = null;
    private long E = 0;
    private boolean F = false;
    private boolean G = false;
    private String H = null;
    private boolean I = false;
    private long J = 0;
    private long K = 0;
    private double L = -1.0d;
    private double M = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double N = AudioStats.AUDIO_AMPLITUDE_NONE;
    private long O = 0;
    private long P = 0;
    private long Q = 0;
    private e S = null;
    private long U = 0;
    private long V = 0;
    private a X = null;
    private b Y = null;
    public ArrayList<ArrayList<Float>> d = new ArrayList<>();
    private ArrayList<ArrayList<Float>> Z = new ArrayList<>();
    private ArrayList<ArrayList<Float>> aa = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ab = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ac = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ad = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ae = new ArrayList<>();
    private ArrayList<ArrayList<Float>> af = new ArrayList<>();
    private String ag = null;
    private long ah = 0;
    private ArrayList<Integer> ai = new ArrayList<>();
    private final LinkedHashMap<String, Float> aj = new LinkedHashMap<>();
    private long ak = 0;
    private String am = null;
    private String an = null;
    private long ao = 0;
    private long ap = -1;
    private long aq = -1;
    private boolean as = false;
    private boolean at = false;
    private long au = 0;
    private long aw = 0;
    private boolean ax = false;
    private boolean ay = false;
    private boolean az = false;
    private StringBuilder aA = new StringBuilder();
    private String aB = "";
    private long aC = -1;
    private long aD = 0;
    private long aE = 0;
    private boolean aF = false;
    private long aG = 0;
    private long aH = 0;
    private long aI = 0;
    private long aJ = 0;
    public long e = 0;

    @TargetApi(24)
    public class a extends GnssMeasurementsEvent.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26426a;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            this.f26426a = i;
        }
    }

    @TargetApi(24)
    public class b extends GnssNavigationMessage.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26427a;

        private b() {
            this.f26427a = 0;
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            aa aaVarA;
            long jCurrentTimeMillis;
            if (d.this.Q != 0) {
                aaVarA = aa.a();
                jCurrentTimeMillis = d.this.Q;
            } else {
                aaVarA = aa.a();
                jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            }
            aaVarA.a(gnssNavigationMessage, jCurrentTimeMillis);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            this.f26427a = i;
        }
    }

    @TargetApi(24)
    public class c extends GnssStatus.Callback {
        private c() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            ArrayList arrayList;
            if (d.this.h == null || gnssStatus == null) {
                return;
            }
            d.this.V = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            d.this.ac.clear();
            d.this.ad.clear();
            d.this.ae.clear();
            d.this.af.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                i++;
                ArrayList arrayList2 = new ArrayList();
                int constellationType = gnssStatus.getConstellationType(i4);
                arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                if (gnssStatus.usedInFix(i4)) {
                    i2++;
                    arrayList2.add(Float.valueOf(1.0f));
                    if (constellationType == 1) {
                        i3++;
                    }
                } else {
                    arrayList2.add(Float.valueOf(0.0f));
                }
                arrayList2.add(Float.valueOf(gnssStatus.getSvid(i4)));
                if (constellationType == 1) {
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList = d.this.ac;
                } else {
                    if (constellationType == 5) {
                        arrayList2.add(Float.valueOf(2.0f));
                        d.this.ad.add(arrayList2);
                        d.this.aD = System.currentTimeMillis();
                    } else if (constellationType == 3) {
                        arrayList2.add(Float.valueOf(3.0f));
                        arrayList = d.this.ae;
                    } else if (constellationType == 6) {
                        arrayList2.add(Float.valueOf(4.0f));
                        arrayList = d.this.af;
                    }
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(d.this.ac);
            arrayList3.addAll(d.this.ad);
            arrayList3.addAll(d.this.ae);
            arrayList3.addAll(d.this.af);
            d.this.b((ArrayList<ArrayList<Float>>) arrayList3);
            d dVar = d.this;
            dVar.Z = dVar.a(true, false, false, false, true, -1.0f);
            d dVar2 = d.this;
            d.b = dVar2.a((ArrayList<ArrayList<Float>>) dVar2.Z);
            d dVar3 = d.this;
            dVar3.aa = dVar3.a(true, true, true, true, true, -1.0f);
            d dVar4 = d.this;
            dVar4.ab = dVar4.a(true, true, true, true, false, -1.0f);
            d dVar5 = d.this;
            d.c = dVar5.a((ArrayList<ArrayList<Float>>) dVar5.ab);
            if (com.baidu.location.b.c.b().bZ == 1) {
                com.baidu.location.b.h.a().a(d.this.ab);
            }
            d.f26424a = i2;
            int unused = d.u = i3;
            int unused2 = d.C = i;
            long unused3 = d.D = System.currentTimeMillis();
            d dVar6 = d.this;
            int unused4 = d.v = dVar6.a((ArrayList<ArrayList<Float>>) dVar6.ae, true, -1.0f).size();
            d dVar7 = d.this;
            int unused5 = d.w = dVar7.a((ArrayList<ArrayList<Float>>) dVar7.af, true, -1.0f).size();
            d dVar8 = d.this;
            int unused6 = d.x = dVar8.a((ArrayList<ArrayList<Float>>) dVar8.ad, true, -1.0f).size();
            d dVar9 = d.this;
            int unused7 = d.y = dVar9.a((ArrayList<ArrayList<Float>>) dVar9.ac, false, -1.0f).size();
            d dVar10 = d.this;
            int unused8 = d.z = dVar10.a((ArrayList<ArrayList<Float>>) dVar10.ae, false, -1.0f).size();
            d dVar11 = d.this;
            int unused9 = d.A = dVar11.a((ArrayList<ArrayList<Float>>) dVar11.af, false, -1.0f).size();
            d dVar12 = d.this;
            int unused10 = d.B = dVar12.a((ArrayList<ArrayList<Float>>) dVar12.ad, false, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            d.this.e((Location) null);
            d.this.b(false);
            d.f26424a = 0;
            int unused = d.u = 0;
            int unused2 = d.v = 0;
            int unused3 = d.w = 0;
            int unused4 = d.x = 0;
            int unused5 = d.y = 0;
            int unused6 = d.z = 0;
            int unused7 = d.A = 0;
            int unused8 = d.B = 0;
            int unused9 = d.C = 0;
            int unused10 = d.k = -1;
            Location unused11 = d.j = null;
        }
    }

    /* JADX INFO: renamed from: com.baidu.location.c.d$d, reason: collision with other inner class name */
    public class C0263d implements GpsStatus.Listener {
        private long b;

        private C0263d() {
            this.b = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            ArrayList arrayList;
            if (d.this.h == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                d.this.e((Location) null);
                d.this.b(false);
                d.f26424a = 0;
                int unused = d.u = 0;
                int unused2 = d.v = 0;
                int unused3 = d.w = 0;
                int unused4 = d.x = 0;
                return;
            }
            if (i == 4 && d.this.G) {
                try {
                    if (d.this.n == null) {
                        d dVar = d.this;
                        dVar.n = dVar.h.getGpsStatus(null);
                    } else {
                        d.this.h.getGpsStatus(d.this.n);
                    }
                    d.this.V = System.currentTimeMillis();
                    d.this.ac.clear();
                    d.this.ad.clear();
                    d.this.ae.clear();
                    d.this.af.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : d.this.n.getSatellites()) {
                        ArrayList arrayList2 = new ArrayList();
                        int prn = gpsSatellite.getPrn();
                        arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            i2++;
                            arrayList2.add(Float.valueOf(1.0f));
                            if (prn >= 1 && prn <= 32) {
                                i3++;
                            }
                        } else {
                            arrayList2.add(Float.valueOf(0.0f));
                        }
                        arrayList2.add(Float.valueOf(prn));
                        if (prn >= 1 && prn <= 32) {
                            arrayList2.add(Float.valueOf(1.0f));
                            arrayList = d.this.ac;
                        } else if (prn >= 201 && prn <= 261) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = d.this.ad;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = d.this.ae;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = d.this.af;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(d.this.ac);
                    arrayList3.addAll(d.this.ad);
                    arrayList3.addAll(d.this.ae);
                    arrayList3.addAll(d.this.af);
                    d.this.b((ArrayList<ArrayList<Float>>) arrayList3);
                    d dVar2 = d.this;
                    dVar2.Z = dVar2.a(true, false, false, false, true, -1.0f);
                    d dVar3 = d.this;
                    d.b = dVar3.a((ArrayList<ArrayList<Float>>) dVar3.Z);
                    d dVar4 = d.this;
                    dVar4.aa = dVar4.a(true, true, true, true, true, -1.0f);
                    d dVar5 = d.this;
                    dVar5.ab = dVar5.a(true, true, true, true, false, -1.0f);
                    d dVar6 = d.this;
                    d.c = dVar6.a((ArrayList<ArrayList<Float>>) dVar6.ab);
                    if (com.baidu.location.b.c.b().bZ == 1) {
                        com.baidu.location.b.h.a().a(d.this.ab);
                    }
                    if (i3 > 0) {
                        int unused5 = d.u = i3;
                    }
                    if (i2 > 0 || System.currentTimeMillis() - this.b > 100) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        this.b = jCurrentTimeMillis;
                        d.f26424a = i2;
                    }
                    long unused6 = d.D = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<d> f26430a;
        d b;

        public e(d dVar) {
            this.f26430a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Location location;
            String str;
            if (com.baidu.location.f.isServing) {
                d dVar = this.f26430a.get();
                this.b = dVar;
                if (dVar == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    Location location2 = (Location) message.obj;
                    this.b.a(location2, com.baidu.location.b.c.b().bZ == 1 ? com.baidu.location.b.h.a().a(location2) : -1);
                    return;
                }
                if (i == 3) {
                    location = (Location) message.obj;
                    str = "&og=1";
                } else {
                    if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                        dVar.a((String) message.obj);
                        return;
                    }
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                dVar.a(str, location);
            }
        }
    }

    public class f implements LocationListener {
        private f() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null && com.baidu.location.e.h.f == 4) {
                return;
            }
            if (com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext())) {
                com.baidu.location.c.c.a().a(location);
                return;
            }
            if (!com.baidu.location.e.h.a(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                d.this.Q = location.getTime() / 1000;
                d.this.ap = System.currentTimeMillis();
                if (d.this.P != 0) {
                    d.this.O = System.currentTimeMillis() - d.this.P;
                }
                d.this.P = System.currentTimeMillis();
                int i = d.f26424a;
                if (i == 0) {
                    try {
                        i = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i == 0 || p.c().j()) {
                    System.currentTimeMillis();
                    long unused2 = d.this.V;
                }
                d.this.b(true);
                d.this.e(location);
                d.this.F = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            d.this.e((Location) null);
            d.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                d.this.e((Location) null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                d.this.F = false;
                return;
            } else {
                d.this.E = System.currentTimeMillis();
                d.this.F = true;
            }
            d.this.b(false);
        }
    }

    public class g implements GpsStatus.NmeaListener {
        private g() {
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (d.this.S != null) {
                d.this.S.sendMessage(d.this.S.obtainMessage(5, str));
            }
        }
    }

    public class h implements LocationListener {
        private long b;

        private h() {
            this.b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(d.this.G && com.baidu.location.e.h.f == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.b >= 10000 && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && z.a(location, false)) {
                this.b = System.currentTimeMillis();
                if (d.this.S != null) {
                    d.this.e = System.currentTimeMillis();
                    d.this.S.sendMessage(d.this.S.obtainMessage(4, location));
                }
            }
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
    }

    private d() {
        this.p = false;
        this.r = false;
        this.av = null;
        try {
            Class.forName("android.location.GnssStatus");
            this.p = true;
        } catch (ClassNotFoundException unused) {
            this.p = false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.av = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.r = false;
    }

    public static synchronized d a() {
        if (f == null) {
            f = new d();
        }
        return f;
    }

    public static String a(Location location) {
        StringBuilder sb;
        if (location == null) {
            return null;
        }
        float speed = (float) (((double) location.getSpeed()) * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
        String str = W < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(f26424a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f26424a), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Integer.valueOf(x), Integer.valueOf(C), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(A), Integer.valueOf(B), Double.valueOf(T)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(f26424a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f26424a), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Integer.valueOf(x), Integer.valueOf(C), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(A), Integer.valueOf(B), Double.valueOf(T), Float.valueOf(W));
        try {
            if (k != 2 || j == null) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("&ll_fake=");
                sb.append(k);
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(k), Double.valueOf(j.getLongitude()), Double.valueOf(j.getLatitude()), Long.valueOf(j.getTime() / 1000)));
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<ArrayList<Float>> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        boolean z2 = true;
        for (ArrayList<Float> arrayList2 : arrayList) {
            if (arrayList2.size() == 6) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append("|");
                }
                sb.append(String.format("%.1f;", arrayList2.get(0)));
                sb.append(String.format("%.1f;", arrayList2.get(1)));
                sb.append(String.format("%.1f;", arrayList2.get(2)));
                sb.append(String.format("%.0f;", arrayList2.get(3)));
                sb.append(String.format("%.0f;", arrayList2.get(4)));
                sb.append(String.format("%.0f", arrayList2.get(5)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> arrayList, boolean z2, float f2) {
        ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
        if (arrayList.size() <= 40 && arrayList.size() != 0) {
            for (ArrayList<Float> arrayList3 : arrayList) {
                if (arrayList3.size() == 6) {
                    float fFloatValue = arrayList3.get(3).floatValue();
                    float fFloatValue2 = arrayList3.get(2).floatValue();
                    if (!z2 || fFloatValue >= 1.0f) {
                        if (f2 <= 0.0f || fFloatValue2 >= f2) {
                            arrayList2.add(arrayList3);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, float f2) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        if (z2) {
            arrayList.addAll(a(this.ac, z6, f2));
        }
        if (z3) {
            arrayList.addAll(a(this.ad, z6, f2));
        }
        if (z4) {
            arrayList.addAll(a(this.ae, z6, f2));
        }
        if (z5) {
            arrayList.addAll(a(this.af, z6, f2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location, int i) {
        if (location == null) {
            this.i = null;
            return;
        }
        if (f26424a == 0) {
            try {
                location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (this.r && com.baidu.location.e.h.a(location.getSpeed(), 0.0f) && !com.baidu.location.e.h.a(this.M, AudioStats.AUDIO_AMPLITUDE_NONE) && System.currentTimeMillis() - this.N < 2000.0d) {
            location.setSpeed((float) this.M);
        }
        Location location2 = new Location(location);
        this.J = System.currentTimeMillis();
        this.i = location;
        int i2 = f26424a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.i.setTime(jCurrentTimeMillis);
        float speed = (float) (((double) this.i.getSpeed()) * 3.6d);
        if (!this.i.hasSpeed()) {
            speed = -1.0f;
        }
        if (i2 == 0) {
            try {
                i2 = this.i.getExtras().getInt("satellites");
            } catch (Exception unused2) {
            }
        }
        this.H = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.i.getLongitude()), Double.valueOf(this.i.getLatitude()), Float.valueOf(speed), Float.valueOf(this.i.getBearing()), Integer.valueOf(i2), Long.valueOf(jCurrentTimeMillis));
        if (this.i != null) {
            BDLocation bDLocation = new BDLocation(f());
            com.baidu.location.b.e.a().a(bDLocation, "gcj02", this.i);
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putInt("sat_num", i2);
            if (Math.abs(System.currentTimeMillis() - this.aD) >= 3000) {
                extras.putBoolean("is_support_beidou", false);
            } else {
                extras.putBoolean("is_support_beidou", true);
            }
            bDLocation.setExtrainfo(extras);
            Location location3 = this.i;
            if (location3 != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(location3.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            a(bDLocation);
            if (f26424a > 2 && z.a(this.i, true) && "gps".equals(this.i.getProvider())) {
                boolean zJ = com.baidu.location.c.f.a().j();
                com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
                if (aVarF != null) {
                    v.a(new com.baidu.location.c.a(aVarF));
                }
                v.a(System.currentTimeMillis());
                v.a(new Location(this.i));
                v.a(com.baidu.location.b.b.a().c());
                v.b(com.baidu.location.b.e.a().c());
                if (!zJ) {
                    aa.a().b();
                }
            }
        }
        if ("gps".equals(location2.getProvider())) {
            aa.a().a(location2, f26424a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            a(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            a(str, 3, 5, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f9  */
    private void a(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (str.startsWith("$GPGGA,")) {
            if (strArrSplit.length < 7) {
                return;
            }
        } else if (str.startsWith("$GPRMC,") && strArrSplit.length < 6) {
            return;
        }
        if (TextUtils.isEmpty(strArrSplit[i].trim()) || strArrSplit[i].trim().length() <= 2) {
            this.ar = null;
        } else {
            try {
                double dDoubleValue = Double.valueOf(strArrSplit[i].substring(0, 2)).doubleValue() + (Double.valueOf(strArrSplit[i].substring(2)).doubleValue() / 60.0d);
                if (this.ar == null) {
                    this.ar = new BDLocation();
                }
                this.ar.setLatitude(dDoubleValue);
            } catch (NumberFormatException unused) {
                this.at = true;
            }
        }
        if (this.ar == null || TextUtils.isEmpty(strArrSplit[i2].trim()) || strArrSplit[i2].trim().length() <= 3) {
            this.ar = null;
        } else {
            try {
                this.ar.setLongitude(Double.valueOf(strArrSplit[i2].substring(0, 3)).doubleValue() + (Double.valueOf(strArrSplit[i2].substring(3)).doubleValue() / 60.0d));
            } catch (NumberFormatException unused2) {
                this.at = true;
            }
        }
        if (!TextUtils.isEmpty(strArrSplit[i3].trim())) {
            if (i3 == 2) {
                if (TextUtils.equals(strArrSplit[i3], "V")) {
                    this.as = false;
                } else if (TextUtils.equals(strArrSplit[i3], "A")) {
                    this.as = true;
                }
            } else if (i3 == 6) {
                if (TextUtils.equals(strArrSplit[i3], "0")) {
                    this.as = false;
                } else {
                    this.as = true;
                }
            }
        }
        if (this.ar != null) {
            this.at = false;
        }
        this.aq = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.b.a().c();
        boolean zJ = com.baidu.location.c.f.a().j();
        com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
        if (aVarF != null) {
            v.a(new com.baidu.location.c.a(aVarF));
        }
        v.a(System.currentTimeMillis());
        v.a(new Location(location));
        v.a(str2);
        v.b(com.baidu.location.b.e.a().c());
        if (zJ) {
            return;
        }
        z.a(v.c(), (k) null, v.d(), str2, v.e());
    }

    public static boolean a(Location location, Location location2, boolean z2) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z2 && ((com.baidu.location.e.h.u == 3 || !com.baidu.location.e.e.a().a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float fDistanceTo = location2.distanceTo(location);
        if (speed > com.baidu.location.e.h.K) {
            return fDistanceTo > com.baidu.location.e.h.M;
        }
        if (speed > com.baidu.location.e.h.J) {
            return fDistanceTo > com.baidu.location.e.h.L;
        }
        return fDistanceTo > 5.0f;
    }

    public static String b(Location location) {
        String strA = a(location);
        if (strA == null) {
            return strA;
        }
        return strA + "&g_tp=0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<ArrayList<Float>> arrayList) {
        String string;
        if (arrayList == null || arrayList.size() <= 0) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ac);
            sb.append(com.baidu.location.e.c.g(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.f(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.a(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.h(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.b(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.c(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.e(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.c.d(arrayList2));
            string = sb.toString();
        }
        this.ag = string;
        this.ah = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        this.I = z2;
        W = -1.0f;
    }

    private boolean b(String str) {
        int i;
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i2 = bytes[1];
            for (int i3 = 2; i3 < bytes.length; i3++) {
                i2 ^= bytes[i3];
            }
            String str2 = String.format("%02x", Integer.valueOf(i2));
            int iIndexOf = str.indexOf("*");
            if (iIndexOf != -1 && str.length() >= (i = iIndexOf + 3) && str2.equalsIgnoreCase(str.substring(iIndexOf + 1, i))) {
                return true;
            }
        }
        return false;
    }

    public static String c(Location location) {
        String strA = a(location);
        if (strA == null) {
            return strA;
        }
        return strA + R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        if (this.S == null || System.currentTimeMillis() - this.aw <= 3000) {
            return;
        }
        this.S.sendMessage(this.S.obtainMessage(1, location));
    }

    private int f(Location location) {
        if (location == null) {
            return 0;
        }
        try {
            if (location.isFromMockProvider()) {
                return 100;
            }
            if (Math.abs(this.ap - this.aq) >= 3000) {
                this.aq = -1L;
                this.at = false;
                this.as = false;
                this.ar = null;
            } else if (this.ar == null) {
                if (!this.as) {
                    return 200;
                }
                if (this.at) {
                    return 300;
                }
            } else if (!this.at && this.as) {
                return 400;
            }
            if (this.ap > 0 && this.aq == -1) {
                return 500;
            }
        } catch (Error | Exception unused) {
        }
        return 0;
    }

    public static String l() {
        long jCurrentTimeMillis = System.currentTimeMillis() - D;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(C), Integer.valueOf(f26424a));
    }

    public void a(int i) {
        a aVar;
        LocationManager locationManager;
        if (i != 0) {
            if (i == 2) {
                this.az = false;
            } else if (i == 1) {
            }
            if (!this.ay || this.az || !this.p || (aVar = this.X) == null || (locationManager = this.h) == null) {
                return;
            }
            try {
                locationManager.unregisterGnssMeasurementsCallback(aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.X = null;
            this.ax = false;
            return;
        }
        this.az = false;
        this.ay = false;
        if (this.ay) {
        }
    }

    public void a(BDLocation bDLocation) {
        if (com.baidu.location.e.h.l || f(this.i) <= 0) {
            com.baidu.location.b.b.a().d(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    public void a(boolean z2) {
        if (z2) {
            c();
        } else {
            d();
        }
    }

    public synchronized void b() {
        if (com.baidu.location.f.isServing) {
            Context serviceContext = com.baidu.location.f.getServiceContext();
            this.g = serviceContext;
            try {
                this.h = (LocationManager) serviceContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            } catch (Exception unused) {
            }
            this.S = new e(this);
        }
    }

    public void c() {
        if (this.G) {
            return;
        }
        try {
            if (!this.p) {
                C0263d c0263d = new C0263d();
                this.q = c0263d;
                this.h.addGpsStatusListener(c0263d);
            } else if (com.baidu.location.e.h.a(this.g, "android.permission.ACCESS_FINE_LOCATION") == 1) {
                c cVar = new c();
                this.o = cVar;
                this.h.registerGnssStatusCallback(cVar);
            }
            h hVar = new h();
            this.m = hVar;
            this.h.requestLocationUpdates("passive", 9000L, 0.0f, hVar);
        } catch (Exception unused) {
        }
        try {
            this.l = new f();
            try {
                if (com.baidu.location.e.h.a(this.g, "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS") == 1) {
                    this.h.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
                }
            } catch (Exception unused2) {
            }
            if (com.baidu.location.e.h.a(this.g, "android.permission.ACCESS_FINE_LOCATION") == 1) {
                this.h.requestLocationUpdates("gps", 1000L, 0.0f, this.l);
                this.aF = true;
            }
            if (this.p && this.Y == null && com.baidu.location.e.h.aC == 1 && new Random().nextDouble() < com.baidu.location.e.h.aB) {
                this.Y = new b();
            }
            b bVar = this.Y;
            if (bVar != null) {
                this.h.registerGnssNavigationMessageCallback(bVar);
            }
            this.U = System.currentTimeMillis();
            if (!com.baidu.location.e.h.l && com.baidu.location.e.h.aX == 1) {
                OnNmeaMessageListener onNmeaMessageListener = new OnNmeaMessageListener() { // from class: com.baidu.location.c.d.1
                    @Override // android.location.OnNmeaMessageListener
                    public void onNmeaMessage(String str, long j2) {
                        if (d.this.S != null) {
                            d.this.S.sendMessage(d.this.S.obtainMessage(5, str));
                        }
                    }
                };
                this.t = onNmeaMessageListener;
                this.h.addNmeaListener(onNmeaMessageListener);
            }
            this.G = true;
        } catch (Exception unused3) {
        }
    }

    public void d() {
        c cVar;
        if (this.G) {
            LocationManager locationManager = this.h;
            if (locationManager != null) {
                try {
                    C0263d c0263d = this.q;
                    if (c0263d != null) {
                        locationManager.removeGpsStatusListener(c0263d);
                        this.q = null;
                    }
                    if (this.p && (cVar = this.o) != null) {
                        this.h.unregisterGnssStatusCallback(cVar);
                        this.o = null;
                    }
                    h hVar = this.m;
                    if (hVar != null) {
                        this.h.removeUpdates(hVar);
                        this.m = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    f fVar = this.l;
                    if (fVar != null) {
                        this.h.removeUpdates(fVar);
                        this.aF = false;
                    }
                    OnNmeaMessageListener onNmeaMessageListener = this.t;
                    if (onNmeaMessageListener != null) {
                        this.h.removeNmeaListener(onNmeaMessageListener);
                    }
                    if (this.s != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.h, this.s);
                    }
                    b bVar = this.Y;
                    if (bVar != null) {
                        this.h.unregisterGnssNavigationMessageCallback(bVar);
                    }
                    a(0);
                } catch (Exception unused2) {
                }
            }
            com.baidu.location.e.h.d = 0;
            com.baidu.location.e.h.u = 0;
            this.l = null;
            this.G = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.h == null) {
            return;
        }
        try {
            e eVar = this.S;
            if (eVar != null) {
                eVar.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.h = null;
        if (com.baidu.location.b.c.b().bZ == 1 && com.baidu.location.b.h.a().b()) {
            com.baidu.location.b.h.a().c();
        }
    }

    public String f() {
        boolean z2;
        StringBuilder sb;
        String str;
        if (this.i == null) {
            return null;
        }
        String str2 = "{\"result\":{\"time\":\"" + com.baidu.location.e.h.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.i.hasAccuracy() ? this.i.getAccuracy() : 10.0f);
        float speed = (float) (((double) this.i.getSpeed()) * 3.6d);
        if (!this.i.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArrCoorEncrypt = new double[2];
        if (com.baidu.location.e.e.a().a(this.i.getLongitude(), this.i.getLatitude())) {
            dArrCoorEncrypt = Jni.coorEncrypt(this.i.getLongitude(), this.i.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArrCoorEncrypt[0] <= AudioStats.AUDIO_AMPLITUDE_NONE && dArrCoorEncrypt[1] <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                dArrCoorEncrypt[0] = this.i.getLongitude();
                dArrCoorEncrypt[1] = this.i.getLatitude();
            }
            z2 = true;
        } else {
            dArrCoorEncrypt[0] = this.i.getLongitude();
            double latitude = this.i.getLatitude();
            dArrCoorEncrypt[1] = latitude;
            if (dArrCoorEncrypt[0] <= AudioStats.AUDIO_AMPLITUDE_NONE && latitude <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                dArrCoorEncrypt[0] = this.i.getLongitude();
                dArrCoorEncrypt[1] = this.i.getLatitude();
            }
            z2 = false;
        }
        String str3 = String.format(Locale.CHINA, str2, Double.valueOf(dArrCoorEncrypt[0]), Double.valueOf(dArrCoorEncrypt[1]), Integer.valueOf(accuracy), Float.valueOf(this.i.getBearing()), Float.valueOf(speed), Integer.valueOf(f26424a));
        if (!z2) {
            str3 = str3 + ",\"in_cn\":\"0\"";
        }
        if (!com.baidu.location.e.h.l) {
            str3 = str3 + String.format(Locale.CHINA, ",\"is_mock\":%d", Integer.valueOf(f(this.i)));
        }
        if (this.i.hasAltitude()) {
            sb = new StringBuilder();
            sb.append(str3);
            str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.i.getAltitude()));
        } else {
            sb = new StringBuilder();
            sb.append(str3);
            str = "}}";
        }
        sb.append(str);
        return sb.toString();
    }

    public Location g() {
        if (this.i != null && Math.abs(System.currentTimeMillis() - this.i.getTime()) <= 60000) {
            return this.i;
        }
        return null;
    }

    public BDLocation h() {
        if (this.ar != null && Math.abs(System.currentTimeMillis() - this.aq) <= 3000) {
            return this.ar;
        }
        return null;
    }

    public boolean i() {
        try {
            System.currentTimeMillis();
            if (f26424a == 0) {
                try {
                    this.i.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            Location location = this.i;
            return (location == null || location.getLatitude() == AudioStats.AUDIO_AMPLITUDE_NONE || this.i.getLongitude() == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
        } catch (Exception unused2) {
            Location location2 = this.i;
            return (location2 == null || location2.getLatitude() == AudioStats.AUDIO_AMPLITUDE_NONE || this.i.getLongitude() == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
        }
    }

    public boolean j() {
        if (!i() || com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext()) || System.currentTimeMillis() - this.J > 10000) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.F || jCurrentTimeMillis - this.E >= 3000) {
            return this.I;
        }
        return true;
    }

    public boolean k() {
        return this.aF;
    }

    public synchronized String m() {
        String str;
        str = "-2";
        try {
            if (Math.abs(System.currentTimeMillis() - this.ah) < 3000) {
                String str2 = this.ag;
                str = str2 == null ? "0" : str2;
            } else {
                str = "-1";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "&gnsf=" + str;
    }
}
