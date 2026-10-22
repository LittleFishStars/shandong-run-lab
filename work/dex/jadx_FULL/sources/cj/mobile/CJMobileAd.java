package cj.mobile;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import android.widget.Toast;
import cj.mobile.a.h;
import cj.mobile.a.l;
import cj.mobile.a.m;
import cj.mobile.a.o;
import cj.mobile.a.p;
import cj.mobile.a.q;
import cj.mobile.a.r;
import cj.mobile.a.s;
import cj.mobile.ad.HicSDK;
import cj.mobile.ad.ZFSDK;
import cj.mobile.listener.CJAppAdListener;
import cj.mobile.listener.CJInitListener;
import cj.mobile.p.f;
import cj.mobile.p.g;
import cj.mobile.p.i;
import cj.mobile.p.j;
import cj.mobile.p.k;
import com.alibaba.ariver.kernel.RVStartParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.c49;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJMobileAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21643a = null;
    public static String b = null;
    public static CJInitListener c = null;
    public static Context context = null;
    public static String d = null;
    public static List<PackageInfo> e = null;
    public static int f = 10;
    public static int g = 240;
    public static Runnable h = new c();
    public static Runnable i = new d();
    public static Runnable j = new e();

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21645a;

        public b(Context context) {
            this.f21645a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            cj.mobile.p.b.d();
            i.d(this.f21645a);
            i.a(this.f21645a);
            DisplayMetrics displayMetrics = this.f21645a.getResources().getDisplayMetrics();
            cj.mobile.p.b.L = displayMetrics.widthPixels;
            cj.mobile.p.b.M = displayMetrics.heightPixels;
        }
    }

    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (CJMobileAd.c != null) {
                CJMobileAd.c.initFailed(CJMobileAd.b);
            }
        }
    }

    public class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            cj.mobile.p.b.o0 = 2;
            if (CJMobileAd.c != null) {
                CJMobileAd.c.initSuccess();
            }
        }
    }

    public class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CJMobileAd.b(CJMobileAd.context, CJMobileAd.d, CJMobileAd.f21643a);
        }
    }

    public static List<PackageInfo> getAppList() {
        List<PackageInfo> list = e;
        if (list != null) {
            return list;
        }
        if (!cj.mobile.p.b.l0) {
            return null;
        }
        try {
            if (e == null) {
                e = context.getPackageManager().getInstalledPackages(0);
            }
        } catch (Exception unused) {
        }
        return e;
    }

    public static String getCJDeviceId(Context context2) {
        return i.d(context2);
    }

    public static int getSdkCode() {
        return 30506;
    }

    public static String getSdkVersion() {
        return "a.3.5.6";
    }

    public static void init(Context context2, String str, CJInitListener cJInitListener) {
        if (cj.mobile.p.b.o0 == 0) {
            cj.mobile.p.b.o0 = 1;
        }
        cj.mobile.p.b.a();
        Context applicationContext = context2.getApplicationContext();
        context = applicationContext;
        a(applicationContext);
        d = str;
        c = cJInitListener;
        k.a(context2);
        k.b(context2);
        if (cj.mobile.p.b.d0) {
            cj.mobile.p.b.e0 = 35;
            cj.mobile.p.b.f0 = 15;
            cj.mobile.p.b.g0 = 3000;
        } else {
            cj.mobile.p.b.e0 = -1;
            cj.mobile.p.b.f0 = -1;
            cj.mobile.p.b.g0 = -1;
        }
        g.b("id", getCJDeviceId(context));
        if (str != null && !str.equals("")) {
            cj.mobile.p.b.N = str;
        }
        cj.mobile.p.b.O = true;
        if (str.trim().equals("345a20d3863f8911")) {
            Toast.makeText(context2, "请注意正在使用测试的id进行广告调用，请在发版时换成正式id", 0).show();
        }
        String str2 = f21643a;
        if (str2 != null && !str2.equals("")) {
            f21643a = j.b(context2, "init" + str);
            cj.mobile.p.b.p0.post(j);
            return;
        }
        g.a("sdk", getSdkVersion());
        g.a("init", str);
        if (!j.b(context2, "init" + str).equals("")) {
            f21643a = j.b(context2, "init" + str);
            cj.mobile.p.b.p0.post(j);
        }
        HashMap map = new HashMap();
        map.put("appKey", str);
        f.a(context2);
        f.a(context2, cj.mobile.p.e.d, map, new a(context2, str));
    }

    public static void isCanGetOaid(boolean z) {
        cj.mobile.p.b.k0 = z;
    }

    public static void isCanUseAppList(boolean z) {
        cj.mobile.p.b.l0 = z;
        k.b(z);
    }

    public static void offPersonal(boolean z) {
        k.a(z);
    }

    public static void privacyCompliance(Application application, boolean z) {
        k.a(application, z);
    }

    public static void setAndroidId(Context context2, String str) {
        i.a(context2, str);
    }

    public static void setAppAdListener(CJAppAdListener cJAppAdListener) {
        cj.mobile.p.b.n0 = cJAppAdListener;
    }

    public static void setAppList(List<PackageInfo> list) {
        e = list;
    }

    public static void setAppUserId(String str) {
        cj.mobile.p.b.U = str;
    }

    public static void setImei(Context context2, String str) {
        if (str == null || str.equals("")) {
            return;
        }
        cj.mobile.p.b.S = str;
        i.b(context2, str);
    }

    public static void setIsOpenShake(boolean z) {
        g.a("setIsOpenShake", "" + z);
        cj.mobile.p.b.d0 = z;
    }

    public static void setOAIDCode(int i2) {
    }

    public static void setOaid(Context context2, String str) {
        if (str == null || str.equals("")) {
            return;
        }
        cj.mobile.p.b.R = str;
        i.c(context2, str);
    }

    public static void b(Context context2, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.optInt("code") == 1) {
                f21643a = str2;
                if (jSONObject.optInt(RVStartParams.KEY_LANDSCAPE_SHORT) != 0) {
                    cj.mobile.p.b.W = false;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    a(context2, jSONArrayOptJSONArray.optJSONObject(i2));
                }
                cj.mobile.p.b.p0.post(i);
                return;
            }
            b = jSONObject.optString("message");
            cj.mobile.p.b.p0.post(h);
        } catch (Exception unused) {
            b = "数据解析失败：" + str2;
            cj.mobile.p.b.p0.post(h);
        }
    }

    public static void a(Context context2) {
        cj.mobile.p.b.f22637a.execute(new b(context2));
    }

    /* JADX WARN: Code duplicated, block: B:129:0x0209 A[Catch: Exception -> 0x0227, TryCatch #14 {Exception -> 0x0227, blocks: (B:126:0x01fe, B:128:0x0204, B:130:0x020d, B:129:0x0209), top: B:256:0x01fe }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void a(Context context2, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("plat");
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.optString("value");
        if (strOptString2 == null || strOptString2.equals("")) {
            return;
        }
        if (strOptString.indexOf(c49.f40900a) > 0) {
            strOptString = strOptString.substring(0, strOptString.indexOf(c49.f40900a));
        }
        strOptString.hashCode();
        byte b2 = -1;
        switch (strOptString.hashCode()) {
            case 3122:
                if (strOptString.equals("as")) {
                    b2 = 0;
                }
                break;
            case 3138:
                if (strOptString.equals("bd")) {
                    b2 = 1;
                }
                break;
            case 3281:
                if (strOptString.equals(AliyunLogKey.KEY_FILE_WIDTH)) {
                    b2 = 2;
                }
                break;
            case 3302:
                if (strOptString.equals("gm")) {
                    b2 = 3;
                }
                break;
            case 3343:
                if (strOptString.equals("hw")) {
                    b2 = 4;
                }
                break;
            case 3344:
                if (strOptString.equals("hx")) {
                    b2 = 5;
                }
                break;
            case 3386:
                if (strOptString.equals("jd")) {
                    b2 = 6;
                }
                break;
            case 3402:
                if (strOptString.equals("jt")) {
                    b2 = 7;
                }
                break;
            case 3407:
                if (strOptString.equals("jy")) {
                    b2 = 8;
                }
                break;
            case 3432:
                if (strOptString.equals(MediationConstant.ADN_KS)) {
                    b2 = 9;
                }
                break;
            case 3612:
                if (strOptString.equals("qm")) {
                    b2 = 10;
                }
                break;
            case 3623:
                if (strOptString.equals("qx")) {
                    b2 = 11;
                }
                break;
            case 3694:
                if (strOptString.equals("tb")) {
                    b2 = 12;
                }
                break;
            case 3703:
                if (strOptString.equals("tk")) {
                    b2 = 13;
                }
                break;
            case 3798:
                if (strOptString.equals("wm")) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 3884:
                if (strOptString.equals("zf")) {
                    b2 = com.google.common.base.a.q;
                }
                break;
            case 3903:
                if (strOptString.equals("zy")) {
                    b2 = com.google.common.base.a.r;
                }
                break;
            case 98810:
                if (strOptString.equals("csj")) {
                    b2 = 17;
                }
                break;
            case 102199:
                if (strOptString.equals("gdt")) {
                    b2 = com.google.common.base.a.u;
                }
                break;
            case 103298:
                if (strOptString.equals("hic")) {
                    b2 = 19;
                }
                break;
            case 105603:
                if (strOptString.equals("jun")) {
                    b2 = com.google.common.base.a.x;
                }
                break;
            case 113873:
                if (strOptString.equals("sig")) {
                    b2 = com.google.common.base.a.y;
                }
                break;
        }
        try {
            switch (b2) {
                case 0:
                    Class.forName("com.beizi.fusion.BeiZis");
                    new cj.mobile.a.b().a(context2, strOptString2);
                    cj.mobile.p.b.j = true;
                    j.a(context2, "init-beizi-" + cj.mobile.p.b.N, strOptString2);
                    break;
                case 1:
                    try {
                        Class.forName("com.baidu.mobads.sdk.api.BDAdConfig");
                        new cj.mobile.a.a().b(context2, strOptString2);
                        cj.mobile.p.b.h = true;
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                case 2:
                    if (strOptString3 == null || strOptString3.equals("")) {
                        return;
                    }
                    try {
                        Class.forName("com.ptg.adsdk.lib.PtgAdSdk");
                        new cj.mobile.a.c().a(context2, strOptString2, strOptString3);
                        cj.mobile.p.b.r = true;
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                case 3:
                    try {
                        cj.mobile.p.b.P = true;
                        new p().a(context2, strOptString2);
                        cj.mobile.p.b.l = true;
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                case 4:
                    try {
                        Class.forName("com.huawei.hms.ads.HwAds");
                        new cj.mobile.a.d().b(context2);
                        cj.mobile.p.b.o = true;
                        return;
                    } catch (Exception unused4) {
                        return;
                    }
                case 5:
                    try {
                        Class.forName("com.hxad.sdk.HXSDK");
                        new cj.mobile.a.e().a(context2, strOptString2);
                        cj.mobile.p.b.q = true;
                        return;
                    } catch (Exception unused5) {
                        return;
                    }
                case 6:
                    try {
                        Class.forName("com.jd.ad.sdk.bl.initsdk.JADYunSdk");
                        new cj.mobile.a.f().b(context2, strOptString2);
                        cj.mobile.p.b.s = true;
                        return;
                    } catch (Exception unused6) {
                        return;
                    }
                case 7:
                    if (strOptString3 == null || strOptString3.equals("")) {
                        return;
                    }
                    try {
                        new cj.mobile.a.g().a(context2, strOptString2, strOptString3);
                        cj.mobile.p.b.t = true;
                        return;
                    } catch (Exception unused7) {
                        return;
                    }
                case 8:
                    try {
                        new h().a(context2, strOptString2);
                        cj.mobile.p.b.n = true;
                        return;
                    } catch (Exception unused8) {
                        return;
                    }
                case 9:
                    try {
                        Class.forName("com.kwad.sdk.api.KsAdSDK");
                        new cj.mobile.a.i().a(context2, strOptString2);
                        cj.mobile.p.b.g = true;
                        return;
                    } catch (Exception unused9) {
                        return;
                    }
                case 10:
                    try {
                        Class.forName("com.qumeng.advlib.core.QMConfig");
                        new l().a(context2);
                        cj.mobile.p.b.k = true;
                        return;
                    } catch (Exception unused10) {
                        return;
                    }
                case 11:
                    if (strOptString3 == null || strOptString3.equals("")) {
                        return;
                    }
                    String[] strArrSplit = strOptString3.split(",");
                    if (strArrSplit.length != 2) {
                        return;
                    }
                    try {
                        Class.forName("com.qlick.adx.sdk.api.QlickSdk");
                        new cj.mobile.a.k().a(context2, strOptString2, strArrSplit[0], strArrSplit[1]);
                        cj.mobile.p.b.w = true;
                        return;
                    } catch (Exception unused11) {
                        return;
                    }
                case 12:
                    try {
                        Class.forName("com.windmill.sdk.WindMillAd");
                        new o().a(context2, strOptString2);
                        cj.mobile.p.b.u = true;
                        return;
                    } catch (Exception unused12) {
                        return;
                    }
                case 13:
                    if (strOptString3 == null || strOptString3.equals("")) {
                        return;
                    }
                    try {
                        Class.forName("com.anythink.core.api.ATSDK");
                        new q().a(context2, strOptString2, strOptString3);
                        cj.mobile.p.b.m = true;
                        return;
                    } catch (Exception unused13) {
                        return;
                    }
                case 14:
                    if (strOptString3 == null || strOptString3.equals("")) {
                        return;
                    }
                    try {
                        Class.forName("cj.mobile.wm.appsdkdex.WMAdSdk");
                        new s().a(context2, strOptString2, strOptString3);
                        cj.mobile.p.b.p = true;
                        return;
                    } catch (Exception unused14) {
                        return;
                    }
                case 15:
                    try {
                        Class.forName("cj.mobile.zf.ZFCJAdSdk");
                        new ZFSDK().a(context2, strOptString2);
                        cj.mobile.p.b.v = true;
                        return;
                    } catch (Exception unused15) {
                        return;
                    }
                case 16:
                    try {
                        Class.forName("cj.mobile.zy.ad.LYAd");
                        new cj.mobile.a.j().a(context2, strOptString2);
                        cj.mobile.p.b.i = true;
                        return;
                    } catch (Exception unused16) {
                        return;
                    }
                case 17:
                    if (strOptString3 != null) {
                        try {
                            if (strOptString3.equals("gm")) {
                                cj.mobile.p.b.P = true;
                                cj.mobile.p.b.l = true;
                            } else {
                                cj.mobile.p.b.P = false;
                                cj.mobile.p.b.e = true;
                            }
                        } catch (Exception unused17) {
                            return;
                        }
                    } else {
                        cj.mobile.p.b.P = false;
                        cj.mobile.p.b.e = true;
                    }
                    new p().a(context2, strOptString2);
                    j.a(context, "ttAppKey", strOptString2);
                    j.a(context, "ttToken", strOptString3);
                    return;
                case 18:
                    new r().a(context2, strOptString2);
                    cj.mobile.p.b.d = true;
                    String strTrim = strOptString3.trim();
                    if (!strTrim.equals("")) {
                        cj.mobile.p.b.i0 = Integer.parseInt(strTrim);
                    }
                    break;
                case 19:
                    try {
                        Class.forName("com.hxad.sdk.ling.ic.bh.BHAdSdk");
                        new HicSDK().a(context2, strOptString2, strOptString3);
                        cj.mobile.p.b.x = true;
                        return;
                    } catch (Exception unused18) {
                        return;
                    }
                case 20:
                    g = Integer.parseInt(strOptString2);
                    f = Integer.parseInt(strOptString3);
                    j.b(context, "cctalk_time", g);
                    j.b(context, "cctalk_percent", f);
                    break;
                case 21:
                    if (strOptString3 == null || strOptString3.equals("")) {
                        return;
                    }
                    try {
                        Class.forName("com.sigmob.windad.WindAds");
                        j.a(context2, "init-sig-" + cj.mobile.p.b.N, strOptString2);
                        j.a(context2, "init-sig-token-" + cj.mobile.p.b.N, strOptString3);
                        new m().a(context2, strOptString2, strOptString3);
                        cj.mobile.p.b.a0 = strOptString2;
                        cj.mobile.p.b.b0 = strOptString3;
                        return;
                    } catch (Exception unused19) {
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception unused20) {
        }
    }

    public class a implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21644a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f21644a = context;
            this.b = str;
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
            g.a("init-error", "code:" + iOException.hashCode() + "-msg:" + iOException.getMessage());
            if (CJMobileAd.f21643a == null || CJMobileAd.f21643a.equals("")) {
                if (!j.b(this.f21644a, "init" + this.b).equals("")) {
                    String unused = CJMobileAd.f21643a = j.b(this.f21644a, "init" + this.b);
                    cj.mobile.p.b.p0.post(CJMobileAd.j);
                    return;
                }
                String unused2 = CJMobileAd.b = "初始化失败：code：" + iOException.hashCode() + "--message:" + iOException.getMessage();
                cj.mobile.p.b.p0.post(CJMobileAd.h);
            }
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
            j.a(this.f21644a, "init" + this.b, str);
            if (CJMobileAd.f21643a == null || CJMobileAd.f21643a.equals("")) {
                String unused = CJMobileAd.f21643a = str;
                cj.mobile.p.b.p0.post(CJMobileAd.j);
            }
        }
    }
}
