package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.security.a;
import com.autonavi.aps.amapapi.storage.b;
import com.autonavi.aps.amapapi.storage.c;
import com.autonavi.aps.amapapi.utils.i;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class deb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i7b f41165a;
    public static long b;
    public static b c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f15977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15979a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f15978a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public b f15981b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15976a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15980a = false;

    public deb(Context context) {
        this.f15977a = context.getApplicationContext();
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        boolean zA;
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            g();
            b bVar = c;
            if (bVar != null && bVar.a() != null) {
                if (TextUtils.isEmpty(str)) {
                    long jB = i.b() - c.d();
                    zA = jB >= 0 && jB <= j;
                    aMapLocation.setTrustedLevel(3);
                } else {
                    zA = i.a(c.b(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (!zA) {
                    return aMapLocation;
                }
                AMapLocation aMapLocationA = c.a();
                try {
                    aMapLocationA.setLocationType(9);
                    aMapLocationA.setFixLastLocation(true);
                    aMapLocationA.setLocationDetail(aMapLocation.getLocationDetail());
                    return aMapLocationA;
                } catch (Throwable th) {
                    th = th;
                    aMapLocation = aMapLocationA;
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "fixLastLocation");
                return aMapLocation;
            }
            return aMapLocation;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void b() {
        if (this.f15980a) {
            return;
        }
        try {
            if (this.f15979a == null) {
                this.f15979a = a.a("MD5", fj.L());
            }
            if (f41165a == null) {
                f41165a = new i7b(this.f15977a, i7b.c(c.class));
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.f15980a = true;
    }

    public final boolean c(AMapLocation aMapLocation, String str) {
        if (this.f15977a != null && aMapLocation != null && i.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            b bVar = new b();
            bVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                bVar.a((String) null);
            } else {
                bVar.a(str);
            }
            try {
                c = bVar;
                b = i.b();
                this.f15978a = bVar;
                b bVar2 = this.f15981b;
                if ((bVar2 == null || i.a(bVar2.a(), bVar.a()) > 500.0f) && i.b() - this.f15976a > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation d() {
        g();
        b bVar = c;
        if (bVar != null && i.a(bVar.a())) {
            return c.a();
        }
        return null;
    }

    public final void e() {
        try {
            f();
            this.f15976a = 0L;
            this.f15980a = false;
            this.f15978a = null;
            this.f15981b = null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void f() {
        b bVar;
        String strF;
        try {
            b();
            b bVar2 = this.f15978a;
            if (bVar2 != null && i.a(bVar2.a()) && f41165a != null && (bVar = this.f15978a) != this.f15981b && bVar.d() == 0) {
                String str = this.f15978a.a().toStr();
                String strB = this.f15978a.b();
                this.f15981b = this.f15978a;
                String str2 = null;
                if (TextUtils.isEmpty(str)) {
                    strF = null;
                } else {
                    String strF2 = m4b.f(a.a(str.getBytes("UTF-8"), this.f15979a));
                    strF = TextUtils.isEmpty(strB) ? null : m4b.f(a.a(strB.getBytes("UTF-8"), this.f15979a));
                    str2 = strF2;
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                b bVar3 = new b();
                bVar3.b(str2);
                bVar3.a(i.b());
                bVar3.a(strF);
                f41165a.h(bVar3, "_id=1");
                this.f15976a = i.b();
                b bVar4 = c;
                if (bVar4 != null) {
                    bVar4.a(i.b());
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "saveLastFix");
        }
    }

    public final void g() {
        if (c == null || i.b() - b > 180000) {
            b bVarH = h();
            b = i.b();
            if (bVarH == null || !i.a(bVarH.a())) {
                return;
            }
            c = bVarH;
        }
    }

    public final b h() {
        Throwable th;
        b bVar;
        byte[] bArrB;
        byte[] bArrB2;
        String str = null;
        if (this.f15977a == null) {
            return null;
        }
        b();
        try {
            i7b i7bVar = f41165a;
            if (i7bVar == null) {
                return null;
            }
            List listP = i7bVar.p("_id=1", b.class);
            if (listP == null || listP.size() <= 0) {
                bVar = null;
            } else {
                bVar = (b) listP.get(0);
                try {
                    byte[] bArrG = m4b.g(bVar.c());
                    String str2 = (bArrG == null || bArrG.length <= 0 || (bArrB2 = a.b(bArrG, this.f15979a)) == null || bArrB2.length <= 0) ? null : new String(bArrB2, "UTF-8");
                    byte[] bArrG2 = m4b.g(bVar.b());
                    if (bArrG2 != null && bArrG2.length > 0 && (bArrB = a.b(bArrG2, this.f15979a)) != null && bArrB.length > 0) {
                        str = new String(bArrB, "UTF-8");
                    }
                    bVar.a(str);
                    str = str2;
                } catch (Throwable th2) {
                    th = th2;
                    com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "readLastFix");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                AMapLocation aMapLocation = new AMapLocation("");
                com.autonavi.aps.amapapi.utils.b.a(aMapLocation, new JSONObject(str));
                if (i.b(aMapLocation)) {
                    bVar.a(aMapLocation);
                }
            }
            return bVar;
        } catch (Throwable th3) {
            th = th3;
            bVar = null;
        }
        com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "readLastFix");
        return bVar;
    }
}
