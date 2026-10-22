package cj.mobile.p;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import cj.mobile.b.l;
import cj.mobile.b.m;
import cj.mobile.b.n;
import cj.mobile.b.o;
import cj.mobile.b.p;
import cj.mobile.b.q;
import cj.mobile.b.r;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class k {
    public static int a(Context context, float f) {
        return Math.round(f * context.getResources().getDisplayMetrics().density);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void b(boolean z) {
    }

    public static String c() {
        try {
            Class.forName("com.ptg.adsdk.lib.PtgAdSdk");
            return new cj.mobile.b.b().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String d() {
        try {
            return new p().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String e() {
        try {
            Class.forName("com.hxad.sdk.HXSDK");
            return new cj.mobile.b.d().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String f() {
        try {
            Class.forName("com.jd.ad.sdk.bl.initsdk.JADYunSdk");
            return new cj.mobile.b.e().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String g() {
        try {
            return new cj.mobile.b.f().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String h() {
        try {
            return new cj.mobile.b.g().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String i() {
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
            return new cj.mobile.b.h().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String j() {
        try {
            Class.forName("com.qumeng.advlib.core.QMConfig");
            return new cj.mobile.b.k().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String k() {
        try {
            Class.forName("com.qlick.adx.sdk.api.QlickSdk");
            return new cj.mobile.b.j().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String l() {
        try {
            Class.forName("com.sigmob.windad.WindAds");
            return new l().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String m() {
        try {
            Class.forName("com.windmill.sdk.WindMillAd");
            return new m().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String n() {
        try {
            Class.forName("com.anythink.core.api.ATSDK");
            return new o().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String o() {
        try {
            Class.forName("cj.mobile.wm.appsdkdex.WMAdSdk");
            return new q().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String p() {
        try {
            Class.forName("cj.mobile.zf.ZFCJAdSdk");
            return new r().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static String q() {
        try {
            Class.forName("cj.mobile.zy.ad.LYAd");
            return new cj.mobile.b.i().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static void b(Context context) {
        try {
            new n().b();
        } catch (Exception unused) {
        }
        try {
            new p().b();
        } catch (Exception unused2) {
        }
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
            new cj.mobile.b.h().b();
        } catch (Exception unused3) {
        }
        try {
            Class.forName("com.sigmob.windad.WindAds");
            new l().b();
        } catch (Exception unused4) {
        }
        try {
            Class.forName("com.baidu.mobads.sdk.api.BDAdConfig");
            new cj.mobile.b.a().b();
        } catch (Exception unused5) {
        }
        try {
            Class.forName("com.qumeng.advlib.core.QMConfig");
            new cj.mobile.b.k().b();
        } catch (Exception unused6) {
        }
        try {
            Class.forName("com.anythink.core.api.ATSDK");
            new o().b();
        } catch (Exception unused7) {
        }
        try {
            Class.forName("cj.mobile.zy.ad.LYAd");
            new cj.mobile.b.i().b();
        } catch (Exception unused8) {
        }
        try {
            new cj.mobile.b.g().b();
        } catch (Exception unused9) {
        }
        try {
            Class.forName("cj.mobile.wm.appsdkdex.WMAdSdk");
            new q().b();
        } catch (Exception unused10) {
        }
        try {
            Class.forName("com.hxad.sdk.HXSDK");
            new cj.mobile.b.d().b();
        } catch (Exception unused11) {
        }
        try {
            Class.forName("com.ptg.adsdk.lib.PtgAdSdk");
            new cj.mobile.b.b().b();
        } catch (Exception unused12) {
        }
        try {
            Class.forName("com.jd.ad.sdk.bl.initsdk.JADYunSdk");
            new cj.mobile.b.e().b();
        } catch (Exception unused13) {
        }
        try {
            new cj.mobile.b.f().b();
        } catch (Exception unused14) {
        }
        try {
            Class.forName("cj.mobile.zf.ZFCJAdSdk");
            new r().b();
        } catch (Exception unused15) {
        }
        try {
            Class.forName("com.windmill.sdk.WindMillAd");
            new m().b();
        } catch (Exception unused16) {
        }
        try {
            Class.forName("com.qlick.adx.sdk.api.QlickSdk");
            new cj.mobile.b.j().b();
        } catch (Exception unused17) {
        }
        try {
            Class.forName("com.hxad.sdk.ling.ic.bh.BHAdSdk");
            new cj.mobile.b.c().a();
        } catch (Exception unused18) {
        }
    }

    public static String a(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null || telephonyManager.getSimState() != 5) {
                b.Q = 0;
            }
        } catch (Exception unused) {
        }
    }

    public static String a() {
        try {
            Class.forName("com.baidu.mobads.sdk.api.BDAdConfig");
            return new cj.mobile.b.a().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }

    public static void a(boolean z) {
        b.m0 = z;
    }

    public static void a(Application application, boolean z) {
        b.j0 = z;
    }

    public static String b() {
        try {
            return new n().a();
        } catch (Exception unused) {
            return "no_ad";
        }
    }
}
