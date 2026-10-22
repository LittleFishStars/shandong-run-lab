package com.baidu.location.b;

import android.content.Intent;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.camera.video.AudioStats;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {
    public static long c = 0;
    public static int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26336a;
    boolean b;
    int e;
    private ArrayList<a> f;
    private boolean g;
    private boolean h;
    private BDLocation i;
    private BDLocation j;
    private Object k;
    private long l;
    private LruCache<String, JSONObject> m;
    private String n;
    private String o;
    private String p;
    private final String[] q;
    private BDLocation r;
    private boolean s;
    private boolean t;
    private c u;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26337a;
        public Messenger b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;
        public int e;

        public a(Message message) {
            this.f26337a = null;
            this.b = null;
            this.e = 1;
            this.b = message.replyTo;
            this.e = message.arg1;
            this.f26337a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.c.prodName, this.f26337a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.h.l = com.baidu.location.e.h.l || this.c.enableSimulateGps;
            if (!com.baidu.location.e.h.e.equals("all")) {
                com.baidu.location.e.h.e = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.h.h = com.baidu.location.e.h.h || this.c.isNeedNewVersionRgc;
            com.baidu.location.e.h.g = com.baidu.location.e.h.g || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.h.i = com.baidu.location.e.h.i || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.h.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wfnum", com.baidu.location.e.h.ay);
            float f = message.getData().getFloat("wfsm", com.baidu.location.e.h.aA);
            int i2 = message.getData().getInt("gnmcon", com.baidu.location.e.h.aC);
            double d = message.getData().getDouble("gnmcrm", com.baidu.location.e.h.aB);
            int i3 = message.getData().getInt("iupl", 1);
            com.baidu.location.e.h.aR = message.getData().getInt("ct", 10);
            com.baidu.location.e.h.aS = message.getData().getInt("suci", 3);
            com.baidu.location.e.h.aU = message.getData().getDoubleArray("cgs");
            com.baidu.location.e.h.aV = message.getData().getInt("ums", 1);
            com.baidu.location.e.h.aT = message.getData().getInt("smn", 40);
            if (i3 <= 0) {
                com.baidu.location.e.h.aQ = 0;
            } else if (com.baidu.location.e.h.aQ == -1) {
                com.baidu.location.e.h.aQ = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                com.baidu.location.e.h.aW = 0;
            }
            if (message.getData().getInt("lpcs", com.baidu.location.e.h.aX) == 0) {
                com.baidu.location.e.h.aX = 0;
            }
            if (i2 == 1) {
                com.baidu.location.e.h.aC = 1;
            }
            if (d > com.baidu.location.e.h.aB) {
                com.baidu.location.e.h.aB = d;
            }
            com.baidu.location.e.h.ax = com.baidu.location.e.h.ax || message.getData().getBoolean("ischeckper", false);
            boolean z = message.getData().getBoolean("isEnableBeidouMode", false);
            if (Build.VERSION.SDK_INT >= 28) {
                com.baidu.location.e.h.aY = com.baidu.location.e.h.aY || z;
            }
            if (i > com.baidu.location.e.h.ay) {
                com.baidu.location.e.h.ay = i;
            }
            if (f > com.baidu.location.e.h.aA) {
                com.baidu.location.e.h.aA = f;
            }
            int i4 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i4 < com.baidu.location.e.h.af) {
                com.baidu.location.e.h.af = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i5 >= com.baidu.location.e.h.W) {
                com.baidu.location.e.h.W = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i6 >= com.baidu.location.e.h.Y) {
                com.baidu.location.e.h.Y = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i7 >= com.baidu.location.e.h.X) {
                com.baidu.location.e.h.X = i7;
            }
            LocationClientOption locationClientOption = this.c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                u.a().a(this.c.mIsNeedDeviceDirect);
                u.a().b();
            }
            b.this.b = b.this.b || this.c.isNeedAltitude;
            if (message.getData().getInt("hpdts", com.baidu.location.e.h.aD) == 1) {
                com.baidu.location.e.h.aD = 1;
            } else {
                com.baidu.location.e.h.aD = 0;
            }
            if (message.getData().getInt("oldts", com.baidu.location.e.h.aE) == 1) {
                com.baidu.location.e.h.aE = 1;
            } else {
                com.baidu.location.e.h.aE = 0;
            }
            int i8 = message.getData().getInt("onic", com.baidu.location.e.h.aF);
            if (i8 == 0) {
                com.baidu.location.e.h.aF = i8;
            }
            int i9 = message.getData().getInt("nlcs", com.baidu.location.e.h.aG);
            if (i9 == 1) {
                com.baidu.location.e.h.aG = i9;
            }
            com.baidu.location.e.h.aH = message.getData().getFloat("ncsr", com.baidu.location.e.h.aH);
            com.baidu.location.e.h.aI = message.getData().getFloat("cscr", com.baidu.location.e.h.aI);
            com.baidu.location.e.h.aJ = message.getData().getInt("cls", com.baidu.location.e.h.aJ);
            int[] intArray = message.getData().getIntArray("ocs");
            com.baidu.location.e.h.aK = intArray;
            com.baidu.location.e.h.aL = com.baidu.location.e.h.a(intArray);
            com.baidu.location.e.h.aM = message.getData().getInt("topCellNumber");
            com.baidu.location.e.h.aN = message.getData().getInt("locStrLength");
            com.baidu.location.e.h.aO = message.getData().getInt("hils");
            com.baidu.location.c.f.a().a((WifiInfo) null, message.getData().getString("connectBssid", null));
        }

        private double a(boolean z, BDLocation bDLocation, BDLocation bDLocation2) {
            double d;
            double latitude;
            double longitude;
            double latitude2;
            double longitude2;
            double dA;
            double[] dArrCoorEncrypt;
            double[] dArrCoorEncrypt2;
            if (z) {
                if (!TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                    if (TextUtils.equals("wgs84", bDLocation.getCoorType())) {
                        dArrCoorEncrypt = new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                    } else {
                        if (TextUtils.equals("bd09", bDLocation.getCoorType())) {
                            dArrCoorEncrypt2 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                        } else {
                            dArrCoorEncrypt2 = TextUtils.equals("bd09ll", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02) : new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                        }
                        dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
                    }
                    bDLocation.setLatitude(dArrCoorEncrypt[1]);
                    d = dArrCoorEncrypt[0];
                    bDLocation.setLongitude(d);
                    bDLocation.setTime(com.baidu.location.e.h.a());
                    bDLocation.setCoorType("wgs84");
                } else if (TextUtils.equals("bd09", bDLocation2.getCoorType())) {
                    double[] dArrCoorEncrypt3 = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double[] dArrCoorEncrypt4 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    latitude = dArrCoorEncrypt3[1];
                    longitude = dArrCoorEncrypt3[0];
                    latitude2 = dArrCoorEncrypt4[1];
                    longitude2 = dArrCoorEncrypt4[0];
                    dA = com.baidu.location.e.h.a(latitude, longitude, latitude2, longitude2);
                }
                dA = com.baidu.location.e.h.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
            } else if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                latitude = bDLocation2.getLatitude();
                longitude = bDLocation2.getLongitude();
                latitude2 = bDLocation.getLatitude();
                longitude2 = bDLocation.getLongitude();
                dA = com.baidu.location.e.h.a(latitude, longitude, latitude2, longitude2);
            } else {
                double[] dArrCoorEncrypt5 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                bDLocation.setLatitude(dArrCoorEncrypt5[1]);
                d = dArrCoorEncrypt5[0];
                bDLocation.setLongitude(d);
                bDLocation.setTime(com.baidu.location.e.h.a());
                bDLocation.setCoorType("wgs84");
                dA = com.baidu.location.e.h.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
            }
            bDLocation2.setDisToRealLocation(dA);
            if (bDLocation != null) {
                bDLocation2.setReallLocation(bDLocation);
            }
            return dA;
        }

        private int a(double d) {
            if (d >= AudioStats.AUDIO_AMPLITUDE_NONE && d <= 10.0d) {
                return 0;
            }
            if (d <= 10.0d || d > 100.0d) {
                return (d <= 100.0d || d > 200.0d) ? 3 : 2;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message messageObtain = Message.obtain((Handler) null, i);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            Message messageObtain = Message.obtain((Handler) null, i);
            messageObtain.setData(bundle);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message messageObtain = Message.obtain((Handler) null, i);
            messageObtain.setData(bundle);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        private BDLocation b() {
            BDLocation bDLocationH = com.baidu.location.c.d.a().h();
            if (bDLocationH == null) {
                return null;
            }
            double[] dArrCoorEncrypt = Jni.coorEncrypt(bDLocationH.getLongitude(), bDLocationH.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            double[] dArrCoorEncrypt2 = Jni.coorEncrypt(dArrCoorEncrypt[0], dArrCoorEncrypt[1], this.c.coorType);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(dArrCoorEncrypt2[0]);
            bDLocation.setLatitude(dArrCoorEncrypt2[1]);
            bDLocation.setTime(com.baidu.location.e.h.a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType(this.c.coorType);
            return bDLocation;
        }

        private BDLocation c() {
            BDLocation bDLocationH = com.baidu.location.c.d.a().h();
            if (bDLocationH == null) {
                return null;
            }
            double[] dArrCoorEncrypt = Jni.coorEncrypt(bDLocationH.getLongitude(), bDLocationH.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(dArrCoorEncrypt[0]);
            bDLocation.setLatitude(dArrCoorEncrypt[1]);
            bDLocation.setTime(com.baidu.location.e.h.a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType("gcj02");
            return bDLocation;
        }

        public int a(int i, boolean z, BDLocation bDLocation) {
            double dA;
            if (i == 100) {
                if (z) {
                    BDLocation bDLocationB = b();
                    if (bDLocationB == null) {
                        return 3;
                    }
                    a(true, bDLocationB, bDLocation);
                    return 3;
                }
                BDLocation bDLocationC = c();
                if (bDLocationC == null) {
                    return 3;
                }
                a(false, bDLocationC, bDLocation);
                return 3;
            }
            if (i == 200 || i == 300) {
                return 1;
            }
            if (i != 400) {
                return i == 500 ? 1 : 0;
            }
            if (z) {
                BDLocation bDLocationB2 = b();
                if (bDLocationB2 == null) {
                    return -1;
                }
                dA = a(true, bDLocationB2, bDLocation);
            } else {
                BDLocation bDLocationC2 = c();
                if (bDLocationC2 == null) {
                    return -1;
                }
                dA = a(false, bDLocationC2, bDLocation);
            }
            return a(dA);
        }

        public void a() {
            if (this.c.location_change_notify) {
                a(com.baidu.location.e.h.b ? 54 : 55);
            }
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            int iA;
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            String str2 = this.c.coorType;
            if (str2 != null && !str2.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] dArrCoorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(dArrCoorEncrypt[0]);
                        bDLocation2.setLatitude(dArrCoorEncrypt[1]);
                        str = this.c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.c.coorType.equals("bd09ll")) {
                        double[] dArrCoorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(dArrCoorEncrypt2[0]);
                        bDLocation2.setLatitude(dArrCoorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
                if (!com.baidu.location.e.h.l && bDLocation2.getMockGpsStrategy() > 0) {
                    iA = a(bDLocation2.getMockGpsStrategy(), true, bDLocation2);
                    bDLocation2.setMockGpsProbability(iA);
                }
            } else if (!com.baidu.location.e.h.l && bDLocation2.getMockGpsStrategy() > 0) {
                iA = a(bDLocation2.getMockGpsStrategy(), false, bDLocation2);
                bDLocation2.setMockGpsProbability(iA);
            }
            a(i, "locStr", bDLocation2);
        }
    }

    /* JADX INFO: renamed from: com.baidu.location.b.b$b, reason: collision with other inner class name */
    public static class C0260b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f26338a = new b();
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f26339a;
        private int b;
        private boolean c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.b++;
            this.f26339a.t = false;
        }
    }

    private b() {
        this.f = null;
        this.g = false;
        this.h = true;
        this.f26336a = false;
        this.b = false;
        this.i = null;
        this.j = null;
        this.k = new Object();
        this.l = -1L;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = new String[]{"name", "mac", "onLng", "onLat", "onLocType", "onTime", "offLng", "offLat", "offLocType", "offTime"};
        this.e = 0;
        this.r = null;
        this.s = false;
        this.t = false;
        this.u = null;
        this.f = new ArrayList<>();
        this.m = new LruCache<>(3);
        this.o = s.a().a("sp_loc_map_end_str", "");
        this.n = s.a().a("sp_loc_navi_end_str", "");
        this.p = s.a().a("sp_loc_last_navi_end_str", "");
        String strA = s.a().a("sp_bluetooth_info", "");
        if (strA == null || "".equals(strA)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strA);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                this.m.put(jSONObject.getString("mac"), jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private a a(Messenger messenger) {
        if (this.f == null) {
            return null;
        }
        try {
            synchronized (this.k) {
                for (a aVar : this.f) {
                    if (aVar.b.equals(messenger)) {
                        return aVar;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static b a() {
        return C0260b.f26338a;
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.k) {
            if (a(aVar.b) != null) {
                aVar.a(14);
            } else {
                this.f.add(aVar);
                aVar.a(13);
            }
        }
    }

    private void a(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.e.b.e);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() throws Throwable {
        f();
        d();
        g();
    }

    private void f() throws Throwable {
        boolean z = false;
        try {
            try {
                synchronized (this.k) {
                    try {
                        Iterator<a> it = this.f.iterator();
                        z = false;
                        while (it.hasNext()) {
                            LocationClientOption locationClientOption = it.next().c;
                            if (locationClientOption.openGps) {
                                z = true;
                            }
                            if (locationClientOption.location_change_notify) {
                                z = true;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                throw th;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                com.baidu.location.e.h.f26475a = z;
                if (this.g != z || (!com.baidu.location.c.d.a().k() && this.g)) {
                    this.g = z;
                    com.baidu.location.c.d.a().a(this.g);
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void g() {
        try {
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                com.baidu.location.e.h.f = Math.min(com.baidu.location.e.h.f, it.next().c.priority);
            }
            if (com.baidu.location.f.isServing) {
                return;
            }
            com.baidu.location.e.h.f = 4;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Bundle bundle, int i) {
        synchronized (this.k) {
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    a next = it.next();
                    next.a(i, bundle);
                    if (next.d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        c = System.currentTimeMillis();
        this.f26336a = true;
        com.baidu.location.c.f.a().i();
        a(new a(message));
        e();
        if (this.s) {
            a("start");
            this.e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    public void a(boolean z) {
        this.f26336a = z;
        d = z ? 1 : 0;
    }

    public void b() {
        synchronized (this.k) {
            try {
                ArrayList<a> arrayList = this.f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            } catch (Throwable unused) {
            }
        }
        this.i = null;
        e();
    }

    public void b(Message message) {
        synchronized (this.k) {
            a aVarA = a(message.replyTo);
            if (aVarA != null) {
                this.f.remove(aVarA);
            }
        }
        u.a().c();
        e();
        if (this.s) {
            a("stop");
            this.e = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().c()) {
            synchronized (this.k) {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    try {
                        a next = it.next();
                        next.a(bDLocation);
                        if (next.d > 4) {
                            it.remove();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            if (this.j == null) {
                BDLocation bDLocation3 = new BDLocation();
                this.j = bDLocation3;
                bDLocation3.setLocType(505);
            }
            synchronized (this.k) {
                Iterator<a> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    try {
                        a next2 = it2.next();
                        next2.a(this.j);
                        if (next2.d > 4) {
                            it2.remove();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (bDLocation != null && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            com.baidu.location.b.c.b().a(bDLocation.getLatitude(), bDLocation.getLongitude());
            com.baidu.location.b.c.b().a(bDLocation.getCityCode());
        }
        boolean z = p.j;
        if (z) {
            p.j = false;
        }
        if (com.baidu.location.e.h.W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                BDLocation bDLocation4 = this.i;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.getLatitude(), this.i.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] <= com.baidu.location.e.h.Y && !z) {
                        return;
                    }
                    this.i = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.i = bDLocation2;
            }
        }
    }

    public String c() {
        StringBuilder sb;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f.isEmpty()) {
            return "&prod=" + com.baidu.location.e.b.f + u15.f19942b + com.baidu.location.e.b.e;
        }
        String string = stringBuffer.toString();
        try {
            a aVar = this.f.get(0);
            String str = aVar.c.prodName;
            if (str != null) {
                stringBuffer.append(str);
            }
            if (aVar.f26337a != null) {
                stringBuffer.append(u15.f19942b);
                stringBuffer.append(aVar.f26337a);
                stringBuffer.append("|");
            }
            if (string == null || string.equals("")) {
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(com.baidu.location.e.b.f);
                sb.append(u15.f19942b);
                string = com.baidu.location.e.b.e;
            } else {
                sb = new StringBuilder();
                sb.append("&prod=");
            }
            sb.append(string);
            return sb.toString();
        } catch (Exception unused) {
            return "&prod=" + com.baidu.location.e.b.f + u15.f19942b + com.baidu.location.e.b.e;
        }
    }

    public void c(BDLocation bDLocation) {
        Address addressA = p.c().a(bDLocation);
        String strF = p.c().f();
        List<Poi> listG = p.c().g();
        PoiRegion poiRegionH = p.c().h();
        if (addressA != null) {
            bDLocation.setAddr(addressA);
        }
        if (strF != null) {
            bDLocation.setLocationDescribe(strF);
        }
        if (listG != null) {
            bDLocation.setPoiList(listG);
        }
        if (poiRegionH != null) {
            bDLocation.setPoiRegion(poiRegionH);
        }
        a(bDLocation);
        p.c().c(bDLocation);
    }

    public boolean c(Message message) {
        a aVarA = a(message.replyTo);
        boolean z = false;
        if (aVarA == null) {
            return false;
        }
        LocationClientOption locationClientOption = aVarA.c;
        int i = locationClientOption.scanSpan;
        locationClientOption.scanSpan = message.getData().getInt("scanSpan", aVarA.c.scanSpan);
        if (aVarA.c.scanSpan < 1000) {
            u.a().c();
            this.f26336a = false;
        } else {
            this.f26336a = true;
        }
        LocationClientOption locationClientOption2 = aVarA.c;
        if (locationClientOption2.scanSpan > 999 && i < 1000) {
            if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                u.a().a(aVarA.c.mIsNeedDeviceDirect);
                u.a().b();
            }
            this.b = this.b || aVarA.c.isNeedAltitude;
            z = true;
        }
        aVarA.c.openGps = message.getData().getBoolean("openGPS", aVarA.c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption3 = aVarA.c;
        if (string == null || string.equals("")) {
            string = aVarA.c.coorType;
        }
        locationClientOption3.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption4 = aVarA.c;
        if (string2 == null || string2.equals("")) {
            string2 = aVarA.c.addrType;
        }
        locationClientOption4.addrType = string2;
        if (!com.baidu.location.e.h.e.equals(aVarA.c.addrType)) {
            p.c().k();
        }
        aVarA.c.timeOut = message.getData().getInt("timeOut", aVarA.c.timeOut);
        aVarA.c.location_change_notify = message.getData().getBoolean("location_change_notify", aVarA.c.location_change_notify);
        aVarA.c.priority = message.getData().getInt("priority", aVarA.c.priority);
        com.baidu.location.e.h.f = aVarA.c.priority;
        int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i2 < com.baidu.location.e.h.af) {
            com.baidu.location.e.h.af = i2;
        }
        e();
        return z;
    }

    public int d(Message message) {
        Messenger messenger;
        a aVarA;
        if (message == null || (messenger = message.replyTo) == null || (aVarA = a(messenger)) == null || aVarA.c == null) {
            return 1;
        }
        return com.baidu.location.e.h.f;
    }

    public void d() {
        try {
            synchronized (this.k) {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d(BDLocation bDLocation) {
        c(bDLocation);
    }

    public int e(Message message) {
        Messenger messenger;
        a aVarA;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (aVarA = a(messenger)) == null || (locationClientOption = aVarA.c) == null) {
            return 1000;
        }
        return locationClientOption.scanSpan;
    }
}
