package com.autonavi.aps.amapapi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.fh;
import com.amap.api.col.p0003l.fj;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.i;
import com.autonavi.aps.amapapi.trans.f;
import com.hjq.permissions.Permission;
import com.huachenjie.common.constants.ErrorCode;
import com.zj.adlib.a7b;
import com.zj.adlib.i9b;
import com.zj.adlib.mhb;
import com.zj.adlib.s4b;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public final class b {
    static int C = -1;
    private static boolean M = false;
    boolean H;
    private Handler P;
    private g Q;
    private String R;
    private c T;
    public static String[] F = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static String G = Permission.ACCESS_BACKGROUND_LOCATION;
    private static volatile boolean S = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f26167a = null;
    ConnectivityManager b = null;
    i c = null;
    e d = null;
    com.autonavi.aps.amapapi.storage.a e = null;
    com.autonavi.aps.amapapi.trans.e f = null;
    ArrayList<mhb> g = new ArrayList<>();
    a h = null;
    AMapLocationClientOption i = new AMapLocationClientOption();
    com.autonavi.aps.amapapi.model.a j = null;
    long k = 0;
    private int K = 0;
    f l = null;
    boolean m = false;
    private String L = null;
    com.autonavi.aps.amapapi.trans.c n = null;
    StringBuilder o = new StringBuilder();
    boolean p = true;
    boolean q = true;
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    boolean t = false;
    WifiInfo u = null;
    boolean v = true;
    private String N = null;
    StringBuilder w = null;
    boolean x = false;
    public boolean y = false;
    int z = 12;
    private boolean O = true;
    com.autonavi.aps.amapapi.restruct.b A = null;
    boolean B = false;
    com.autonavi.aps.amapapi.filters.a D = null;
    String E = null;
    IntentFilter I = null;
    LocationManager J = null;

    /* JADX INFO: renamed from: com.autonavi.aps.amapapi.b$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26168a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f26168a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26168a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26168a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            i iVar;
            i iVar2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (!action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || (iVar = b.this.c) == null) {
                        return;
                    }
                    iVar.j();
                    return;
                }
                i iVar3 = b.this.c;
                if (iVar3 != null) {
                    iVar3.i();
                }
                try {
                    if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (iVar2 = b.this.c) == null) {
                        return;
                    }
                    iVar2.h();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "onReceive");
            }
        }
    }

    public b(boolean z) {
        this.H = z;
    }

    private void i() {
        if (this.n != null) {
            try {
                if (this.i == null) {
                    this.i = new AMapLocationClientOption();
                }
                this.n.a(this.i.getHttpTimeOut(), this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), j());
            } catch (Throwable unused) {
            }
        }
    }

    private int j() {
        int i;
        if (this.i.getGeoLanguage() == null || (i = AnonymousClass1.f26168a[this.i.getGeoLanguage().ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private void k() {
        boolean zIsNeedAddress;
        boolean z;
        boolean zIsOffset;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean zIsLocationCacheEnable = true;
        try {
            geoLanguage = this.i.getGeoLanguage();
            zIsNeedAddress = this.i.isNeedAddress();
            try {
                zIsOffset = this.i.isOffset();
                try {
                    zIsLocationCacheEnable = this.i.isLocationCacheEnable();
                    this.t = this.i.isOnceLocationLatest();
                    this.B = this.i.isSensorEnable();
                    if (zIsOffset != this.q || zIsNeedAddress != this.p || zIsLocationCacheEnable != this.s || geoLanguage != this.r) {
                        r();
                    }
                } catch (Throwable unused) {
                    z = zIsLocationCacheEnable;
                    zIsLocationCacheEnable = zIsOffset;
                    boolean z2 = z;
                    zIsOffset = zIsLocationCacheEnable;
                    zIsLocationCacheEnable = z2;
                }
            } catch (Throwable unused2) {
                z = true;
            }
        } catch (Throwable unused3) {
            zIsNeedAddress = true;
            z = true;
        }
        this.q = zIsOffset;
        this.p = zIsNeedAddress;
        this.s = zIsLocationCacheEnable;
        this.r = geoLanguage;
    }

    private void l() {
        try {
            if (this.h == null) {
                this.h = new a();
            }
            if (this.I == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.I = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.I.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f26167a.registerReceiver(this.h, this.I);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] m() throws Throwable {
        if (this.l == null) {
            this.l = new f();
        }
        if (this.i == null) {
            this.i = new AMapLocationClientOption();
        }
        this.l.a(this.f26167a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.b, this.E, this.Q);
        return this.l.a();
    }

    private boolean n() {
        return this.k == 0 || com.autonavi.aps.amapapi.utils.i.b() - this.k > 20000;
    }

    private void o() {
        i iVar = this.c;
        if (iVar == null) {
            return;
        }
        iVar.a(this.m);
    }

    private boolean p() {
        ArrayList<mhb> arrayListE = this.c.e();
        this.g = arrayListE;
        return arrayListE == null || arrayListE.size() <= 0;
    }

    private void q() {
        if (this.N != null) {
            this.N = null;
        }
        StringBuilder sb = this.w;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void r() {
        try {
            com.autonavi.aps.amapapi.storage.a aVar = this.e;
            if (aVar != null) {
                aVar.a();
            }
            d(null);
            this.O = false;
            com.autonavi.aps.amapapi.filters.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.a();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "cleanCache");
        }
    }

    public final void a(Handler handler) {
        this.P = handler;
    }

    public final void b() {
        this.n = com.autonavi.aps.amapapi.trans.c.a(this.f26167a);
        i();
        if (this.b == null) {
            this.b = (ConnectivityManager) com.autonavi.aps.amapapi.utils.i.a(this.f26167a, "connectivity");
        }
        if (this.l == null) {
            this.l = new f();
        }
    }

    public final void c() {
        if (this.A == null) {
            this.A = new com.autonavi.aps.amapapi.restruct.b(this.f26167a);
        }
        l();
        this.c.b(false);
        this.g = this.c.e();
        this.d.a(false, p());
        this.e.a(this.f26167a);
        b(this.f26167a);
        this.y = true;
    }

    public final void d() {
        if (this.o.length() > 0) {
            StringBuilder sb = this.o;
            sb.delete(0, sb.length());
        }
    }

    @SuppressLint({"NewApi"})
    public final void e() {
        a aVar;
        this.E = null;
        this.x = false;
        this.y = false;
        com.autonavi.aps.amapapi.storage.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.b(this.f26167a);
        }
        com.autonavi.aps.amapapi.filters.a aVar3 = this.D;
        if (aVar3 != null) {
            aVar3.a();
        }
        if (this.f != null) {
            this.f = null;
        }
        g gVar = this.Q;
        if (gVar != null) {
            gVar.a(this.H);
        }
        try {
            Context context = this.f26167a;
            if (context != null && (aVar = this.h) != null) {
                context.unregisterReceiver(aVar);
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "destroy");
            } catch (Throwable th2) {
                this.h = null;
                throw th2;
            }
        }
        this.h = null;
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(this.H);
        }
        i iVar = this.c;
        if (iVar != null) {
            iVar.c(this.H);
        }
        ArrayList<mhb> arrayList = this.g;
        if (arrayList != null) {
            arrayList.clear();
        }
        com.autonavi.aps.amapapi.restruct.b bVar = this.A;
        if (bVar != null) {
            bVar.f();
        }
        this.j = null;
        this.f26167a = null;
        this.w = null;
        this.J = null;
    }

    public final void f() {
        c cVar = this.T;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void g() {
        try {
            if (this.f26167a == null) {
                return;
            }
            if (this.T == null) {
                this.T = new c(this.f26167a);
            }
            this.T.a(this.d, this.c, this.P);
        } catch (Throwable th) {
            a7b.m(th, "as", "stc");
        }
    }

    public final void h() {
        c cVar = this.T;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(Context context) {
        try {
            if (this.f26167a != null) {
                return;
            }
            this.D = new com.autonavi.aps.amapapi.filters.a();
            Context applicationContext = context.getApplicationContext();
            this.f26167a = applicationContext;
            com.autonavi.aps.amapapi.utils.i.b(applicationContext);
            if (this.c == null) {
                this.c = new i(this.f26167a, (WifiManager) com.autonavi.aps.amapapi.utils.i.a(this.f26167a, "wifi"), this.P);
            }
            if (this.d == null) {
                this.d = new e(this.f26167a, this.P);
            }
            this.Q = new g(context, this.P);
            if (this.e == null) {
                this.e = new com.autonavi.aps.amapapi.storage.a();
            }
            if (this.f == null) {
                this.f = new com.autonavi.aps.amapapi.trans.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBase");
        }
    }

    private void d(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    @SuppressLint({"NewApi"})
    private com.autonavi.aps.amapapi.model.a b(boolean z, com.autonavi.aps.amapapi.a aVar) {
        String str;
        try {
            if (TextUtils.isEmpty(this.R)) {
                this.R = s4b.r(fj.t(this.f26167a) + "," + fj.N(this.f26167a));
            }
            StringBuilder sb = this.o;
            sb.append("#id:");
            sb.append(this.R);
        } catch (Throwable unused) {
        }
        com.autonavi.aps.amapapi.model.a aVar2 = new com.autonavi.aps.amapapi.model.a("");
        try {
            byte[] bArrM = m();
            long jB = com.autonavi.aps.amapapi.utils.i.b();
            this.k = jB;
            aVar.a(jB);
            try {
                com.autonavi.aps.amapapi.utils.b.c(this.f26167a);
                com.autonavi.aps.amapapi.trans.d dVarA = this.n.a(this.f26167a, bArrM, com.autonavi.aps.amapapi.utils.b.a(), com.autonavi.aps.amapapi.utils.b.b(), z);
                dVarA.getURL();
                String ipv6url = dVarA.getIPV6URL();
                fh.g(this.f26167a);
                boolean z2 = !TextUtils.isEmpty(ipv6url) && ipv6url.contains("dualstack");
                int i = com.autonavi.aps.amapapi.trans.a.f26194a;
                if (fh.v() && fh.K() && z2) {
                    i = com.autonavi.aps.amapapi.trans.a.b;
                }
                String strA = fh.G() ? null : com.autonavi.aps.amapapi.trans.a.a(this.f26167a).a(dVarA, i);
                aVar.a(i == com.autonavi.aps.amapapi.trans.a.b ? "v6" : "v4");
                i9b i9bVarA = this.n.a(dVarA);
                long jB2 = com.autonavi.aps.amapapi.utils.i.b();
                if (!TextUtils.isEmpty(strA)) {
                    if (!i9bVarA.f17172b) {
                        com.autonavi.aps.amapapi.trans.a.a(this.f26167a).a(true, i);
                    } else {
                        com.autonavi.aps.amapapi.trans.a.a(this.f26167a).a(false, i);
                        com.autonavi.aps.amapapi.trans.a.a(this.f26167a).a(i);
                    }
                }
                if (i9bVarA != null && !TextUtils.isEmpty(strA)) {
                    if (!i9bVarA.f17172b) {
                        aVar.b(strA);
                        aVar.c(com.alipay.sdk.m.k0.c.p);
                    } else {
                        aVar.b(strA);
                        aVar.c("FAIL");
                        aVar.d(com.alipay.sdk.m.k0.c.p);
                    }
                } else {
                    aVar.d(com.alipay.sdk.m.k0.c.p);
                }
                c cVar = this.T;
                if (cVar != null) {
                    cVar.d();
                }
                aVar.b(jB2);
                if (i9bVarA != null) {
                    if (!TextUtils.isEmpty(i9bVarA.f42307a)) {
                        this.o.append("#csid:" + i9bVarA.f42307a);
                    }
                    str = i9bVarA.b;
                    aVar2.h(this.w.toString());
                } else {
                    str = "";
                }
                com.autonavi.aps.amapapi.model.a aVarA = a(aVar2, i9bVarA, aVar);
                if (aVarA != null) {
                    return aVarA;
                }
                byte[] bArrB = com.autonavi.aps.amapapi.security.a.b(i9bVarA.f17171a);
                if (bArrB == null) {
                    aVar2.setErrorCode(5);
                    aVar.f("#0503");
                    this.o.append("解密数据失败#0503");
                    aVar2.setLocationDetail(this.o.toString());
                    com.autonavi.aps.amapapi.utils.g.a(str, 2053);
                    return aVar2;
                }
                com.autonavi.aps.amapapi.model.a aVarA2 = this.f.a(aVar2, bArrB, aVar);
                if (!com.autonavi.aps.amapapi.utils.i.a(aVarA2)) {
                    String strB = aVarA2.b();
                    this.L = strB;
                    if (!TextUtils.isEmpty(strB)) {
                        com.autonavi.aps.amapapi.utils.g.a(str, 2062);
                    } else {
                        com.autonavi.aps.amapapi.utils.g.a(str, 2061);
                    }
                    aVarA2.setErrorCode(6);
                    aVar.f("#0601");
                    StringBuilder sb2 = this.o;
                    StringBuilder sb3 = new StringBuilder("location faile retype:");
                    sb3.append(aVarA2.d());
                    sb3.append(" rdesc:");
                    sb3.append(TextUtils.isEmpty(this.L) ? "" : this.L);
                    sb3.append("#0601");
                    sb2.append(sb3.toString());
                    aVarA2.h(this.w.toString());
                    aVarA2.setLocationDetail(this.o.toString());
                    return aVarA2;
                }
                c(aVarA2);
                aVarA2.setOffset(this.q);
                aVarA2.a(this.p);
                aVarA2.f(String.valueOf(this.r));
                aVarA2.e("new");
                aVarA2.setLocationDetail(this.o.toString());
                this.E = aVarA2.a();
                return aVarA2;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.i.b();
                aVar.d("FAIL");
                com.autonavi.aps.amapapi.trans.a.a(this.f26167a).a(false, com.autonavi.aps.amapapi.trans.a.f26194a);
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "getApsLoc req");
                com.autonavi.aps.amapapi.utils.g.a("/mobile/binary", th);
                if (!com.autonavi.aps.amapapi.utils.i.d(this.f26167a)) {
                    aVar.f("#0401");
                    this.o.append("网络异常，未连接到网络，请连接网络#0401");
                } else if (th instanceof ff) {
                    ff ffVar = th;
                    if (ffVar.a().contains("网络异常状态码")) {
                        aVar.f("#0404");
                        StringBuilder sb4 = this.o;
                        sb4.append("网络异常，状态码错误#0404");
                        sb4.append(ffVar.f());
                    } else if (ffVar.f() != 23 && Math.abs((com.autonavi.aps.amapapi.utils.i.b() - this.k) - this.i.getHttpTimeOut()) >= 500) {
                        aVar.f("#0403," + th.getMessage());
                        this.o.append("网络异常,请求异常#0403");
                    } else {
                        aVar.f("#0402");
                        this.o.append("网络异常，连接超时#0402");
                    }
                } else {
                    aVar.f("#0403," + th.getMessage());
                    this.o.append("网络异常,请求异常#0403");
                }
                com.autonavi.aps.amapapi.model.a aVarA3 = a(4, this.o.toString());
                aVarA3.h(this.w.toString());
                return aVarA3;
            }
        } catch (Throwable th2) {
            aVar.f("#0301");
            this.o.append("get parames error:" + th2.getMessage() + "#0301");
            com.autonavi.aps.amapapi.utils.g.a((String) null, ErrorCode.CHECK_START_RUN_ERROR.h);
            com.autonavi.aps.amapapi.model.a aVarA4 = a(3, this.o.toString());
            aVarA4.h(this.w.toString());
            return aVarA4;
        }
    }

    private String c(com.autonavi.aps.amapapi.a aVar) {
        int iH = this.d.h();
        com.autonavi.aps.amapapi.restruct.d dVarE = this.d.e();
        com.autonavi.aps.amapapi.restruct.d dVarF = this.d.f();
        ArrayList<mhb> arrayList = this.g;
        boolean z = arrayList == null || arrayList.isEmpty();
        String string = "";
        if (dVarE == null && dVarF == null && z) {
            if (this.b == null) {
                this.b = (ConnectivityManager) com.autonavi.aps.amapapi.utils.i.a(this.f26167a, "connectivity");
            }
            if (com.autonavi.aps.amapapi.utils.i.c() >= 31) {
                if (com.autonavi.aps.amapapi.utils.i.a(this.f26167a) && !this.c.l()) {
                    this.z = 18;
                    this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2132);
                    aVar.f("#1802");
                    return "";
                }
            } else if (com.autonavi.aps.amapapi.utils.i.a(this.f26167a) && !this.c.k()) {
                this.z = 18;
                this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2132);
                aVar.f("#1801");
                return "";
            }
            if (com.autonavi.aps.amapapi.utils.i.c() >= 28) {
                if (this.J == null) {
                    this.J = (LocationManager) this.f26167a.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                }
                if (!((Boolean) com.autonavi.aps.amapapi.utils.e.a(this.J, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.z = 12;
                    this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    aVar.f("#1206");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                    return "";
                }
            }
            if (!com.autonavi.aps.amapapi.utils.i.e(this.f26167a)) {
                this.z = 12;
                this.o.append("定位权限被禁用,请授予应用定位权限#1201");
                aVar.f("#1201");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                return "";
            }
            if (com.autonavi.aps.amapapi.utils.i.c() >= 24 && com.autonavi.aps.amapapi.utils.i.c() < 28 && Settings.Secure.getInt(this.f26167a.getContentResolver(), "location_mode", 0) == 0) {
                this.z = 12;
                aVar.f("#1206");
                this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                return "";
            }
            String strK = this.d.k();
            String strD = this.c.d();
            if (this.c.a(this.b) && strD != null) {
                this.z = 12;
                aVar.f("#1202");
                this.o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                return "";
            }
            if (strK != null) {
                this.z = 12;
                if (!this.c.k()) {
                    aVar.f("#1204");
                    this.o.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                } else {
                    aVar.f("#1205");
                    this.o.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                }
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                return "";
            }
            if (!this.c.k() && !this.d.n()) {
                this.z = 19;
                aVar.f("#1901");
                this.o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2133);
                return "";
            }
            if (!this.c.k()) {
                aVar.f("#1301");
                this.o.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
            } else {
                aVar.f("#1302");
                if (this.c.c() != null) {
                    this.o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                    if (!com.autonavi.aps.amapapi.utils.i.f(this.f26167a)) {
                        this.o.append("或后台运行没有后台定位权限");
                    }
                    this.o.append("#1302");
                } else {
                    this.o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                    if (!com.autonavi.aps.amapapi.utils.i.f(this.f26167a)) {
                        this.o.append("或后台运行没有后台定位权限");
                    }
                    this.o.append("#1302");
                }
            }
            this.z = 13;
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2131);
            return "";
        }
        WifiInfo wifiInfoM = this.c.m();
        this.u = wifiInfoM;
        this.v = i.a(wifiInfoM);
        if (iH == 0) {
            boolean z2 = !this.g.isEmpty() || this.v;
            boolean z3 = dVarF != null;
            if (!z3) {
                if (this.v && this.g.isEmpty()) {
                    this.z = 2;
                    aVar.f("#0201");
                    this.o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2021);
                    return "";
                }
                if (this.g.size() == 1) {
                    this.z = 2;
                    if (!this.v) {
                        aVar.f("#0202");
                        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        com.autonavi.aps.amapapi.utils.g.a((String) null, 2022);
                        return "";
                    }
                    if (this.g.get(0).f18218a) {
                        aVar.f("#0202");
                        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        com.autonavi.aps.amapapi.utils.g.a((String) null, 2021);
                        return "";
                    }
                }
            }
            String str = String.format(Locale.US, "#%s#", "network");
            if (z3) {
                StringBuilder sb = new StringBuilder();
                sb.append(dVarF.b());
                String str2 = (!this.g.isEmpty() || this.v) ? "cgiwifi" : "cgi";
                sb.append("network");
                sb.append("#");
                sb.append(str2);
                string = sb.toString();
            } else if (z2) {
                string = str + "wifi";
            } else {
                this.z = 2;
                if (!this.c.k()) {
                    aVar.f("#0203");
                    this.o.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                } else {
                    aVar.f("#0204");
                    this.o.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                }
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2022);
            }
        } else if (iH != 1) {
            if (iH != 2) {
                this.z = 11;
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2111);
                aVar.f("#1101");
                this.o.append("get cgi failure#1101");
            } else if (dVarE != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(dVarE.f26182a);
                sb2.append("#");
                sb2.append(dVarE.b);
                sb2.append("#");
                sb2.append(dVarE.h);
                sb2.append("#");
                sb2.append(dVarE.i);
                sb2.append("#");
                sb2.append(dVarE.j);
                sb2.append("#");
                sb2.append("network");
                sb2.append("#");
                sb2.append((!this.g.isEmpty() || this.v) ? "cgiwifi" : "cgi");
                string = sb2.toString();
            }
        } else if (dVarE != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(dVarE.f26182a);
            sb3.append("#");
            sb3.append(dVarE.b);
            sb3.append("#");
            sb3.append(dVarE.c);
            sb3.append("#");
            sb3.append(dVarE.d);
            sb3.append("#");
            sb3.append("network");
            sb3.append("#");
            sb3.append((!this.g.isEmpty() || this.v) ? "cgiwifi" : "cgi");
            string = sb3.toString();
        }
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        if (!string.startsWith("#")) {
            string = "#" + string;
        }
        return com.autonavi.aps.amapapi.utils.i.e() + string;
    }

    public final void a() {
        e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.i = new AMapLocationClientOption();
        }
        i iVar = this.c;
        if (iVar != null) {
            this.i.isWifiActiveScan();
            iVar.a(this.i.isWifiScan(), this.i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        com.autonavi.aps.amapapi.storage.a aVar = this.e;
        if (aVar != null) {
            aVar.a(this.i);
        }
        com.autonavi.aps.amapapi.trans.e eVar = this.f;
        if (eVar != null) {
            eVar.a(this.i);
        }
        k();
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.a aVar) throws Throwable {
        com.autonavi.aps.amapapi.restruct.b bVar;
        d();
        aVar.e("conitue");
        if (this.f26167a == null) {
            aVar.f("#0101");
            this.o.append("context is null#0101");
            return a(1, this.o.toString());
        }
        int i = this.K + 1;
        this.K = i;
        if (i == 1) {
            o();
        }
        if (a(this.k) && com.autonavi.aps.amapapi.utils.i.a(this.j)) {
            if (this.s && com.autonavi.aps.amapapi.utils.a.a(this.j.getTime())) {
                this.j.setLocationType(2);
            }
            return this.j;
        }
        com.autonavi.aps.amapapi.restruct.b bVar2 = this.A;
        if (bVar2 != null) {
            if (this.B) {
                bVar2.a();
            } else {
                bVar2.b();
            }
        }
        try {
            this.c.b(this.i.isOnceLocationLatest() || !this.i.isOnceLocation());
            this.g = this.c.e();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "getLocation getScanResultsParam");
        }
        try {
            this.d.a(false, p());
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "Aps", "getLocation getCgiListParam");
        }
        String strC = c(aVar);
        this.N = strC;
        if (TextUtils.isEmpty(strC)) {
            return a(this.z, this.o.toString());
        }
        this.w = a(this.w);
        if (this.c.n()) {
            com.autonavi.aps.amapapi.model.a aVarA = a(15, "networkLocation has been mocked!#1502");
            aVar.f("#1502");
            aVarA.setMock(true);
            aVarA.setTrustedLevel(4);
            return aVarA;
        }
        com.autonavi.aps.amapapi.model.a aVarA2 = this.e.a(this.d, n(), this.j, this.c, this.w, this.N, this.f26167a, false);
        if (com.autonavi.aps.amapapi.utils.i.a(aVarA2)) {
            aVarA2.setTrustedLevel(2);
            d(aVarA2);
        } else {
            aVarA2 = b(true, aVar);
            if (com.autonavi.aps.amapapi.utils.i.a(aVarA2)) {
                aVarA2.e("new");
                this.e.a(this.w.toString());
                this.e.a(this.d.e());
                d(aVarA2);
            } else {
                com.autonavi.aps.amapapi.model.a aVarA3 = this.e.a(this.d, false, this.j, this.c, this.w, this.N, this.f26167a, true);
                if (com.autonavi.aps.amapapi.utils.i.a(aVarA3)) {
                    aVar.f("#0001");
                    aVarA3.setTrustedLevel(2);
                    d(aVarA3);
                    aVarA2 = aVarA3;
                }
            }
        }
        try {
            if (this.c != null && aVarA2 != null) {
                long jB = i.b();
                if (jB <= 15) {
                    aVarA2.setTrustedLevel(1);
                } else if (jB <= 120) {
                    aVarA2.setTrustedLevel(2);
                } else if (jB <= 600) {
                    aVarA2.setTrustedLevel(3);
                } else {
                    aVarA2.setTrustedLevel(4);
                }
            }
        } catch (Throwable unused) {
        }
        this.e.a(this.N, this.w, aVarA2, this.f26167a, true);
        com.autonavi.aps.amapapi.utils.i.a(aVarA2);
        StringBuilder sb = this.w;
        sb.delete(0, sb.length());
        if (aVarA2 != null) {
            if (this.B && (bVar = this.A) != null) {
                aVarA2.setAltitude(bVar.c());
                aVarA2.setBearing(this.A.d());
                aVarA2.setSpeed((float) this.A.e());
            } else {
                aVarA2.setAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
                aVarA2.setBearing(0.0f);
                aVarA2.setSpeed(0.0f);
            }
        }
        d(aVarA2);
        return this.j;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        this.D.a(this.s);
        return this.D.a(aVar);
    }

    private boolean a(long j) {
        if (!this.O) {
            this.O = true;
            return false;
        }
        if (com.autonavi.aps.amapapi.utils.i.b() - j < 800) {
            if ((com.autonavi.aps.amapapi.utils.i.a(this.j) ? com.autonavi.aps.amapapi.utils.i.a() - this.j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    private void b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(s4b.v("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.m = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(com.autonavi.aps.amapapi.a aVar) {
        try {
            if (this.x) {
                return;
            }
            q();
            if (this.t) {
                l();
            }
            this.c.b(this.t);
            this.g = this.c.e();
            this.d.a(true, p());
            String strC = c(aVar);
            this.N = strC;
            if (!TextUtils.isEmpty(strC)) {
                this.w = a(this.w);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initFirstLocateParam");
        }
        this.x = true;
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.m());
        sb.append(this.c.o());
        return sb;
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar, i9b i9bVar, com.autonavi.aps.amapapi.a aVar2) {
        if (i9bVar != null) {
            try {
                byte[] bArr = i9bVar.f17171a;
                if (bArr != null && bArr.length != 0) {
                    com.autonavi.aps.amapapi.trans.e eVar = new com.autonavi.aps.amapapi.trans.e();
                    String str = new String(i9bVar.f17171a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        com.autonavi.aps.amapapi.model.a aVarA = eVar.a(str, this.f26167a, i9bVar, aVar2);
                        aVarA.h(this.w.toString());
                        return aVarA;
                    }
                    if (!str.contains("</body></html>")) {
                        return null;
                    }
                    aVar.setErrorCode(5);
                    i iVar = this.c;
                    if (iVar != null && iVar.a(this.b)) {
                        aVar2.f("#0501");
                        this.o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                        com.autonavi.aps.amapapi.utils.g.a((String) null, 2051);
                    } else {
                        aVar2.f("#0502");
                        this.o.append("请求可能被劫持了#0502");
                        com.autonavi.aps.amapapi.utils.g.a((String) null, 2052);
                    }
                    aVar.setLocationDetail(this.o.toString());
                    return aVar;
                }
            } catch (Throwable th) {
                aVar.setErrorCode(4);
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "checkResponseEntity");
                aVar2.f("#0403");
                this.o.append("check response exception ex is" + th.getMessage() + "#0403");
                aVar.setLocationDetail(this.o.toString());
                return aVar;
            }
        }
        aVar.setErrorCode(4);
        this.o.append("网络异常,请求异常#0403");
        aVar2.f("#0403");
        aVar.h(this.w.toString());
        aVar.setLocationDetail(this.o.toString());
        if (i9bVar != null) {
            com.autonavi.aps.amapapi.utils.g.a(i9bVar.b, 2041);
        }
        return aVar;
    }

    public final void b(com.autonavi.aps.amapapi.model.a aVar) {
        if (com.autonavi.aps.amapapi.utils.i.a(aVar)) {
            this.e.a(this.N, this.w, aVar, this.f26167a, true);
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z) {
        if (this.c.n()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.N)) {
            return a(this.z, this.o.toString());
        }
        com.autonavi.aps.amapapi.model.a aVarA = this.e.a(this.f26167a, this.N, this.w, true, z);
        if (com.autonavi.aps.amapapi.utils.i.a(aVarA)) {
            d(aVarA);
        }
        return aVarA;
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z, com.autonavi.aps.amapapi.a aVar) {
        if (z) {
            aVar.e("statics");
        } else {
            aVar.e("first");
        }
        if (this.f26167a == null) {
            aVar.f("#0101");
            this.o.append("context is null#0101");
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2011);
            return a(1, this.o.toString());
        }
        if (this.c.n()) {
            aVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        b();
        if (TextUtils.isEmpty(this.N)) {
            return a(this.z, this.o.toString());
        }
        com.autonavi.aps.amapapi.model.a aVarB = b(z, aVar);
        if (com.autonavi.aps.amapapi.utils.i.a(aVarB) && !S) {
            this.e.a(this.w.toString());
            this.e.a(this.d.e());
            d(aVarB);
        }
        S = true;
        return aVarB;
    }

    private static void c(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar.getErrorCode() == 0 && aVar.getLocationType() == 0) {
            if (!"-5".equals(aVar.d()) && !"1".equals(aVar.d()) && !"2".equals(aVar.d()) && !"14".equals(aVar.d()) && !"24".equals(aVar.d()) && !"-1".equals(aVar.d())) {
                aVar.setLocationType(6);
            } else {
                aVar.setLocationType(5);
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(double d, double d2) {
        try {
            String strA = this.n.a(this.f26167a, d, d2);
            if (!strA.contains("\"status\":\"1\"")) {
                return null;
            }
            com.autonavi.aps.amapapi.model.a aVarA = this.f.a(strA);
            aVarA.setLatitude(d);
            aVarA.setLongitude(d2);
            return aVarA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
        fVar.f26186a = aMapLocation.getLocationType();
        fVar.d = aMapLocation.getTime();
        fVar.e = (int) aMapLocation.getAccuracy();
        fVar.b = aMapLocation.getLatitude();
        fVar.c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.Q.a(fVar);
        }
    }

    public final void a(com.autonavi.aps.amapapi.model.a aVar, int i) {
        if (aVar != null && aVar.getErrorCode() == 0) {
            com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
            fVar.d = aVar.getTime();
            fVar.e = (int) aVar.getAccuracy();
            fVar.b = aVar.getLatitude();
            fVar.c = aVar.getLongitude();
            fVar.f26186a = i;
            fVar.g = Integer.parseInt(aVar.d());
            fVar.h = aVar.l();
            this.Q.b(fVar);
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i);
        aVar.setLocationDetail(str);
        if (i == 15) {
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2151);
        }
        return aVar;
    }
}
