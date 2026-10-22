package com.baidu.location.b;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p extends m {
    public static String h = "0";
    public static boolean j = false;
    private static p k;
    private long B;
    private double F;
    private double G;
    public m.c g;
    private boolean l = true;
    private String m = null;
    private BDLocation n = null;
    private BDLocation o = null;
    private Location p = null;
    private com.baidu.location.c.k q = null;
    private com.baidu.location.c.a r = null;
    private HashSet<String> s = null;
    private com.baidu.location.c.k t = null;
    private com.baidu.location.c.a u = null;
    private boolean v = true;
    private volatile boolean w = false;
    private boolean x = false;
    private long y = 0;
    private long z = 0;
    private Address A = null;
    private String C = null;
    private List<Poi> D = null;
    private PoiRegion E = null;
    private boolean H = false;
    private long I = 0;
    private long J = 0;
    private a K = null;
    private boolean L = false;
    private boolean M = false;
    private boolean N = true;
    public final Handler i = new m.b();
    private boolean O = false;
    private boolean P = false;
    private b Q = null;
    private boolean R = false;
    private int S = 0;
    private long T = 0;
    private boolean U = false;
    private String V = null;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private long Z = 0;
    private Address aa = null;
    private boolean ab = true;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f26383a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f26383a.L) {
                this.f26383a.L = false;
                boolean unused = this.f26383a.M;
            }
        }
    }

    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.R) {
                p.this.R = false;
            }
            if (p.this.x) {
                p.this.x = false;
                p.this.h(null);
            }
        }
    }

    private p() {
        this.g = null;
        this.g = new m.c();
        this.e = new m.a();
    }

    private boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        if (aVar2 == aVar) {
            return false;
        }
        if (aVar2 == null || aVar == null) {
            return true;
        }
        return !aVar.a(aVar2);
    }

    private boolean a(com.baidu.location.c.a aVar, HashSet<String> hashSet) {
        com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
        this.b = aVarF;
        boolean zA = a(aVar, aVarF);
        if (com.baidu.location.e.h.aG == 0) {
            return zA;
        }
        boolean z = zA || com.baidu.location.c.f.a().a(aVar, this.b);
        HashSet<String> hashSetC = com.baidu.location.c.f.a().c(this.b);
        this.c = hashSetC;
        return z || a(hashSet, hashSetC);
    }

    private boolean a(com.baidu.location.c.k kVar) {
        com.baidu.location.c.k kVarR = com.baidu.location.c.f.a().r();
        this.f26369a = kVarR;
        if (kVar == kVarR) {
            return false;
        }
        if (kVarR == null || kVar == null) {
            return true;
        }
        return !com.baidu.location.c.f.a().a(this.f26369a, kVar, com.baidu.location.e.h.aA);
    }

    private boolean a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        if ((hashSet == null || hashSet.isEmpty()) && (hashSet2 == null || hashSet2.isEmpty())) {
            return false;
        }
        if (hashSet == null || hashSet.isEmpty() || hashSet2 == null || hashSet2.isEmpty()) {
            return true;
        }
        int size = hashSet.size();
        Iterator<String> it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (hashSet2.contains(it.next())) {
                i++;
            }
        }
        return ((float) i) < ((float) size) * com.baidu.location.e.h.aH;
    }

    private void b(String str) {
        this.X = str != null && "subway".equals(str.toLowerCase());
    }

    public static synchronized p c() {
        if (k == null) {
            k = new p();
        }
        return k;
    }

    private void c(Message message) {
        if (!com.baidu.location.e.h.c(com.baidu.location.f.getServiceContext())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.b.b.a().a(bDLocation);
            return;
        }
        if (com.baidu.location.e.h.b()) {
            Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
        }
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            j = true;
        }
        com.baidu.location.c.c.a().a(com.baidu.location.f.getServiceContext());
        int iD = com.baidu.location.b.b.a().d(message);
        if (iD == 1) {
            d(message);
            return;
        }
        if (iD == 2) {
            if (com.baidu.location.c.d.a().j()) {
                e(message);
            }
        } else {
            if (iD != 3 && iD != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(iD)));
            }
            g(message);
        }
    }

    private void d(Message message) {
        if (com.baidu.location.c.d.a().j()) {
            e(message);
            u.a().c();
        } else {
            g(message);
            u.a().b();
        }
    }

    private void d(BDLocation bDLocation) {
        if (com.baidu.location.e.h.l || bDLocation.getMockGpsStrategy() <= 0) {
            com.baidu.location.b.b.a().a(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.c.d.a().f());
        Location locationG = com.baidu.location.c.d.a().g();
        if (locationG != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(locationG.getProvider())) {
            bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
        }
        if (locationG != null) {
            bDLocation.setExtrainfo(locationG.getExtras());
        }
        if (com.baidu.location.e.h.e.equals("all") || com.baidu.location.e.h.g || com.baidu.location.e.h.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.G, this.F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.A;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.C;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.D;
                if (list != null) {
                    bDLocation.setPoiList(list);
                }
                PoiRegion poiRegion = this.E;
                if (poiRegion != null) {
                    bDLocation.setPoiRegion(poiRegion);
                }
            } else {
                this.H = true;
                g(null);
            }
        }
        this.n = bDLocation;
        this.o = null;
        d(bDLocation);
    }

    private void e(BDLocation bDLocation) {
        this.Y = bDLocation != null && bDLocation.isInIndoorPark();
    }

    private void f(Message message) {
        b bVar;
        if (!com.baidu.location.c.f.a().k()) {
            h(message);
            return;
        }
        this.x = true;
        if (this.Q == null) {
            this.Q = new b();
        }
        if (this.R && (bVar = this.Q) != null) {
            this.i.removeCallbacks(bVar);
        }
        this.i.postDelayed(this.Q, 3500L);
        this.R = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.S = 0;
        if (!this.v) {
            f(message);
            this.J = SystemClock.uptimeMillis();
            return;
        }
        this.S = 1;
        this.J = SystemClock.uptimeMillis();
        if (com.baidu.location.c.f.a().b(com.baidu.location.e.h.af)) {
            f(message);
        } else {
            h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x00d2  */
    public void h(Message message) {
        Location locationC;
        boolean zA;
        String str;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.y;
        if (!this.w || jCurrentTimeMillis2 > 12000) {
            if (System.currentTimeMillis() - this.y > 0 && System.currentTimeMillis() - this.y < 1000) {
                if (this.n != null) {
                    com.baidu.location.b.b.a().a(this.n);
                }
                n();
                return;
            }
            this.w = true;
            this.l = a(this.r, this.s);
            boolean zA2 = a(this.q);
            boolean zH = com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext());
            if (zH) {
                locationC = com.baidu.location.c.c.a().c();
                zA = com.baidu.location.c.c.a().a(this.p, locationC);
            } else {
                locationC = null;
                zA = false;
            }
            if (!zA2 && !this.l && this.n != null && !this.H && !com.baidu.location.c.f.a().m() && !zA) {
                if (this.o != null && System.currentTimeMillis() - this.z > 30000) {
                    this.n = this.o;
                    this.o = null;
                }
                if (u.a().d()) {
                    this.n.setDirection(u.a().e());
                }
                if (this.n.getLocType() == 62) {
                    jCurrentTimeMillis = System.currentTimeMillis() - this.T;
                    if (jCurrentTimeMillis <= 0) {
                        jCurrentTimeMillis = 0;
                    }
                } else {
                    jCurrentTimeMillis = 0;
                }
                if (this.n.getLocType() == 61 || this.n.getLocType() == 161 || this.n.getLocType() == 160 || (this.n.getLocType() == 62 && jCurrentTimeMillis < 15000)) {
                    com.baidu.location.b.b.a().a(this.n);
                    n();
                    return;
                }
            }
            this.y = System.currentTimeMillis();
            String strA = a((String) null);
            this.P = false;
            if (strA == null) {
                this.P = true;
                this.T = System.currentTimeMillis();
                String[] strArrM = new String[2];
                try {
                    strArrM = m();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (jCurrentTimeMillis3 - this.I > 60000) {
                    this.I = jCurrentTimeMillis3;
                }
                String strO = com.baidu.location.c.f.a().o();
                if (strO != null) {
                    str = strO + b() + strArrM[0];
                } else {
                    str = "" + b() + strArrM[0];
                }
                if (this.b != null && com.baidu.location.c.f.a().b(this.b) != null) {
                    str = com.baidu.location.c.f.a().b(this.b) + str;
                }
                String strA2 = com.baidu.location.e.b.a().a(true);
                if (strA2 != null) {
                    str = str + strA2;
                }
            } else {
                str = strA + com.baidu.location.e.h.d(com.baidu.location.f.getServiceContext());
            }
            String strB = com.baidu.location.a.a.a().b();
            if (strB != null) {
                str = str + "&ak=" + strB + "&aks=lbs_locsdk";
            }
            if (zH) {
                String strB2 = com.baidu.location.c.c.a().b(locationC);
                if (strB2 != null) {
                    str = str + strB2 + "&per_c=1";
                }
                this.p = locationC;
            }
            if (this.m != null) {
                str = str + this.m;
                this.m = null;
            }
            String str2 = (str + e.a().c()) + "&cnloc=" + l.a().b();
            long jB = this.f26369a != null ? com.baidu.location.c.f.a().b(this.f26369a) : 0L;
            if (str2.length() > com.baidu.location.e.h.aN) {
                String[] strArrSplit = str2.split("&cl_list=");
                if (strArrSplit.length == 2) {
                    String[] strArrSplit2 = strArrSplit[1].split("&", 2);
                    if (strArrSplit2.length == 2) {
                        str2 = strArrSplit[0] + "&cl_list=null&" + strArrSplit2[1];
                    } else {
                        str2 = strArrSplit[0] + "&cl_list=null";
                    }
                }
            }
            this.g.a(str2, jB);
            this.r = this.b;
            this.s = this.c;
            this.q = this.f26369a;
            if (this.v) {
                this.v = false;
                if (com.baidu.location.c.f.a().l() && message != null) {
                    com.baidu.location.b.b.a().e(message);
                }
            }
            int i = this.S;
            if (i > 0) {
                if (i == 2) {
                    com.baidu.location.c.f.a().k();
                }
                this.S = 0;
            }
        }
    }

    private void l() {
        try {
            String str = null;
            String strA = s.a().a("FirstLocAddr", (String) null);
            if (strA != null) {
                String[] strArrSplit = new String(Base64.decode(strA.getBytes(), 0)).split(LoginConstants.UNDER_LINE);
                if (strArrSplit.length == 2) {
                    this.Z = Long.parseLong(strArrSplit[0]);
                    str = strArrSplit[1];
                }
                if (str != null) {
                    String[] strArrSplit2 = str.split(com.alipay.sdk.m.y.l.b);
                    if (strArrSplit2.length == 11) {
                        this.aa = new Address.Builder().country(strArrSplit2[0]).countryCode(strArrSplit2[1]).province(strArrSplit2[2]).city(strArrSplit2[3]).cityCode(strArrSplit2[4]).district(strArrSplit2[5]).street(strArrSplit2[6]).streetNumber(strArrSplit2[7]).adcode(strArrSplit2[8]).town(strArrSplit2[9]).townCode(strArrSplit2[10]).build();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String[] m() {
        boolean z;
        f fVarA;
        int i;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int iA = com.baidu.location.e.h.a(com.baidu.location.f.getServiceContext());
        String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        if (iA == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(iA);
        String strD = com.baidu.location.e.h.d(com.baidu.location.f.getServiceContext());
        if (strD.contains("per=0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(strD);
        stringBuffer.append("&loc=");
        int iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB == 0) {
            strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
            z = true;
        } else {
            z = false;
        }
        stringBuffer.append(iB);
        stringBuffer.append("&lmd=");
        int iB2 = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB2 >= 0) {
            stringBuffer.append(iB2);
        }
        String strH = com.baidu.location.c.f.a().h();
        String strN = com.baidu.location.c.f.a().n();
        stringBuffer.append(strN);
        stringBuffer.append(strH);
        stringBuffer.append(com.baidu.location.e.h.e(com.baidu.location.f.getServiceContext()));
        if (iA != 1) {
            if (strD.contains("per=0|0|")) {
                f.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
            } else if (z) {
                f.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
            } else if (strH != null && strN != null && strH.equals("&sim=1") && !strN.equals("&wifio=1")) {
                fVarA = f.a();
                i = 6;
                str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
            } else if (!com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext())) {
                f.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
            }
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        fVarA = f.a();
        i = 7;
        fVarA.a(62, i, str);
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void n() {
        this.w = false;
        this.M = false;
        this.N = false;
        this.H = false;
        o();
        if (this.ab) {
            this.ab = false;
        }
    }

    private void o() {
        if (this.n == null || !com.baidu.location.c.f.a().l()) {
            return;
        }
        aa.a().d();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00a6  */
    public Address a(BDLocation bDLocation) {
        Address addressBuild;
        if (com.baidu.location.e.h.e.equals("all") || com.baidu.location.e.h.g || com.baidu.location.e.h.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.G, this.F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            float f = fArr[0];
            if (f >= 100.0d) {
                if (this.A == null) {
                    if (System.currentTimeMillis() - this.Z < 3000) {
                        addressBuild = this.aa;
                    } else {
                        addressBuild = null;
                    }
                } else if (f < 1000.0d) {
                    addressBuild = new Address.Builder().country(this.A.country).countryCode(this.A.countryCode).province(this.A.province).city(this.A.city).cityCode(this.A.cityCode).district(this.A.district).adcode(this.A.adcode).town(this.A.town).townCode(this.A.townCode).build();
                } else {
                    addressBuild = null;
                }
                this.C = null;
                this.D = null;
                this.E = null;
                this.H = true;
                this.i.post(new Runnable() { // from class: com.baidu.location.b.p.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.g(null);
                    }
                });
                return addressBuild;
            }
            Address address = this.A;
            if (address != null) {
                return address;
            }
        }
        return null;
    }

    @Override // com.baidu.location.b.m
    public void a() {
        a aVar = this.K;
        if (aVar != null && this.L) {
            this.L = false;
            this.i.removeCallbacks(aVar);
        }
        if (com.baidu.location.c.d.a().j()) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.c.d.a().f());
            Location locationG = com.baidu.location.c.d.a().g();
            if (locationG != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(locationG.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (locationG != null) {
                bDLocation.setExtrainfo(locationG.getExtras());
            }
            if (com.baidu.location.e.h.e.equals("all") || com.baidu.location.e.h.g || com.baidu.location.e.h.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.G, this.F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.A;
                    if (address != null) {
                        bDLocation.setAddr(address);
                    }
                    String str = this.C;
                    if (str != null) {
                        bDLocation.setLocationDescribe(str);
                    }
                    List<Poi> list = this.D;
                    if (list != null) {
                        bDLocation.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.E;
                    if (poiRegion != null) {
                        bDLocation.setPoiRegion(poiRegion);
                    }
                }
            }
            com.baidu.location.b.b.a().a(bDLocation);
        } else {
            if (this.M) {
                n();
                return;
            }
            if (this.l || this.n == null) {
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.setLocType(63);
                this.n = null;
                com.baidu.location.b.b.a().a(bDLocation2);
            } else {
                com.baidu.location.b.b.a().a(this.n);
            }
            this.o = null;
        }
        n();
    }

    @Override // com.baidu.location.b.m
    public void a(Message message) {
        a aVar = this.K;
        if (aVar != null && this.L) {
            this.L = false;
            this.i.removeCallbacks(aVar);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        int i = message.arg1;
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            b(bDLocation.getTraffic());
            e(bDLocation);
            if (i == 1) {
                e.a().a(bDLocation, "gcj02", null);
            }
        }
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.P) {
            bDLocation.setLocType(62);
        }
        if (!this.U && bDLocation != null && bDLocation.getLocType() == 161) {
            String cityCode = bDLocation.getCityCode();
            if (!TextUtils.isEmpty(cityCode)) {
                s.a().b("mapcity", cityCode);
                c.b().a(cityCode);
                this.U = true;
            }
        }
        if (bDLocation != null) {
            l.a().a(bDLocation);
        }
        b(bDLocation);
    }

    public void b(Message message) {
        if (this.O) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        f fVarA;
        int i;
        String str;
        String strN;
        BDLocation bDLocation2;
        String str2;
        new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            Address address = bDLocation.getAddress();
            this.A = address;
            if (address != null && (str2 = address.cityCode) != null) {
                h = str2;
                this.B = System.currentTimeMillis();
            }
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.C = bDLocation.getLocationDescribe();
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.D = bDLocation.getPoiList();
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiRegion() != null) {
            this.E = bDLocation.getPoiRegion();
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        boolean z = false;
        if (com.baidu.location.c.d.a().j()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.c.d.a().f());
            Location locationG = com.baidu.location.c.d.a().g();
            if (locationG != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(locationG.getProvider())) {
                bDLocation3.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (locationG != null) {
                bDLocation3.setExtrainfo(locationG.getExtras());
            }
            if (com.baidu.location.e.h.e.equals("all") || com.baidu.location.e.h.g || com.baidu.location.e.h.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.G, this.F, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address2 = this.A;
                    if (address2 != null) {
                        bDLocation3.setAddr(address2);
                    }
                    String str3 = this.C;
                    if (str3 != null) {
                        bDLocation3.setLocationDescribe(str3);
                    }
                    List<Poi> list = this.D;
                    if (list != null) {
                        bDLocation3.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.E;
                    if (poiRegion != null) {
                        bDLocation3.setPoiRegion(poiRegion);
                    }
                }
            }
            d(bDLocation3);
            n();
            return;
        }
        if (this.M) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation4 = this.n;
            if (bDLocation4 != null) {
                Location.distanceBetween(bDLocation4.getLatitude(), this.n.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.n = bDLocation;
                if (!this.N) {
                    this.N = false;
                    com.baidu.location.b.b.a().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.n = bDLocation;
                com.baidu.location.b.b.a().a(bDLocation);
            }
            n();
            return;
        }
        if (bDLocation.getLocType() == 167) {
            f.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
        } else if (bDLocation.getLocType() == 161) {
            int iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
            if (iB == 0 || iB == 2) {
                f.a().a(161, 1, "NetWork location successful, open gps will be better!");
            } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (strN = com.baidu.location.c.f.a().n()) != null && !strN.equals("&wifio=1")) {
                f.a().a(161, 2, "NetWork location successful, open wifi will be better!");
            }
        } else {
            int i2 = 160;
            if (bDLocation.getLocType() == 160) {
                fVarA = f.a();
                i = 10;
                str = "Coarse location successful, open Accurately locate permission will be better!";
            } else if (com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext())) {
                i2 = 62;
                if (bDLocation.getLocType() == 62) {
                    fVarA = f.a();
                    i = 11;
                    str = "Coarse location failed because we can not get any loc result";
                }
            }
            fVarA.a(i2, i, str);
        }
        this.o = null;
        if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.n) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.n.getNetworkLocationType()) && System.currentTimeMillis() - this.z < 30000) {
            this.o = bDLocation;
            z = true;
        }
        com.baidu.location.b.b bVarA = com.baidu.location.b.b.a();
        if (z) {
            bVarA.a(this.n);
        } else {
            bVarA.a(bDLocation);
            this.z = System.currentTimeMillis();
        }
        if (!com.baidu.location.e.h.a(bDLocation)) {
            this.n = null;
        } else if (!z) {
            this.n = bDLocation;
        }
        int iA = com.baidu.location.e.h.a(m.d, "ssid\":\"", "\"");
        if (iA == Integer.MIN_VALUE || this.q == null) {
            this.m = null;
        } else {
            this.m = com.baidu.location.c.f.a().a(iA, this.q);
        }
        com.baidu.location.c.f.a().l();
        n();
    }

    public void c(BDLocation bDLocation) {
        this.n = new BDLocation(bDLocation);
    }

    public void d() {
        this.v = true;
        this.w = false;
        this.O = true;
        l();
    }

    public void e() {
        this.w = false;
        this.x = false;
        this.M = false;
        this.N = true;
        k();
        this.O = false;
    }

    public String f() {
        return this.C;
    }

    public List<Poi> g() {
        return this.D;
    }

    public PoiRegion h() {
        return this.E;
    }

    public void i() {
        if (this.x) {
            h(null);
            this.x = false;
        }
    }

    public boolean j() {
        return this.Y;
    }

    public void k() {
        this.n = null;
    }
}
