package com.beizi.fusion;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.RequestInfo;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class u6 {
    public static String K = "SDK_UID_KEY_NEW";
    private static u6 L;
    private String A;
    private String B;
    private long C;
    private long D;
    private String E;
    private Context F;
    private String G;
    private String H;
    private RequestInfo I;
    private DevInfo J;
    private String c;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private boolean m;
    private String n;
    private String o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27824a = null;
    public boolean b = false;
    private j7 d = j7.DEVICE_OTHER;
    private String e = null;
    private String f = null;

    private u6() {
        Context contextM = q1.h().m();
        this.F = contextM;
        if (contextM == null) {
            return;
        }
        RequestInfo requestInfo = RequestInfo.getInstance(contextM);
        this.I = requestInfo;
        if (requestInfo == null) {
            return;
        }
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        this.J = this.I.getDevInfo();
    }

    private String E() {
        try {
            int i = Build.VERSION.SDK_INT;
            StructStat structStatStat = Os.stat("/data/data");
            if (structStatStat == null) {
                return "";
            }
            if (i < 27) {
                return structStatStat.st_atime + ".0";
            }
            StructTimespec structTimespec = structStatStat.st_atim;
            return structTimespec.tv_sec + Consts.DOT + structTimespec.tv_nsec;
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean G() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
    }

    private boolean H() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME");
    }

    private boolean I() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO");
    }

    private boolean K() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static synchronized u6 m() {
        if (L == null) {
            synchronized (u6.class) {
                if (L == null) {
                    L = new u6();
                }
            }
        }
        return L;
    }

    private void z() {
        try {
            WindowManager windowManager = (WindowManager) a4.j().u.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.e = displayMetrics.widthPixels + LoginConstants.UNDER_LINE + displayMetrics.heightPixels;
            float f = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
            float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
            double dSqrt = Math.sqrt((double) ((f2 * f2) + (f * f)));
            double dPow = Math.pow(10.0d, 2.0d);
            this.f = String.format("%.2f", Double.valueOf(Math.round(dSqrt * dPow) / dPow));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String A() {
        if (TextUtils.isEmpty(this.f)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.f = devInfo.getScreenSize();
            } else {
                z();
            }
        }
        return this.f;
    }

    public String B() {
        if (TextUtils.isEmpty(this.f27824a)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.f27824a = devInfo.getSdkUID();
            } else {
                this.f27824a = (String) pm.a(a4.j().u, K, "");
            }
        }
        return this.f27824a;
    }

    public String C() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.B) && (requestInfo = this.I) != null) {
            this.B = requestInfo.getSdkVersion();
        }
        return this.B;
    }

    public String D() {
        try {
            if (q1.h().s()) {
                return null;
            }
            if (TextUtils.isEmpty(this.H)) {
                if (I()) {
                    this.H = to.b(a4.j().u, "com.bbk.appstore");
                } else if (H()) {
                    this.H = to.b(a4.j().u, "com.heytap.market");
                } else if (K()) {
                    this.H = to.b(a4.j().u, "com.xiaomi.market");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.H;
    }

    public String F() {
        if (this.p) {
            return this.r;
        }
        this.p = true;
        String strC = hq.c();
        this.r = strC;
        return strC;
    }

    public synchronized boolean J() {
        if (this.m) {
            return this.l;
        }
        this.m = true;
        boolean zA = a8.a(a4.j().u, "com.tencent.mm");
        this.l = zA;
        return zA;
    }

    public String a() {
        if (q1.h().s()) {
            return null;
        }
        if (G() && TextUtils.isEmpty(this.k)) {
            this.k = to.d(a4.j().u);
        }
        return this.k;
    }

    public String b() {
        if (TextUtils.isEmpty(this.G)) {
            try {
                if (q1.h().q()) {
                    this.G = to.a(q1.h().m());
                } else {
                    this.G = q1.h().a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.G;
    }

    public long c() {
        RequestInfo requestInfo;
        if (this.C == 0 && (requestInfo = this.I) != null) {
            try {
                this.C = Long.parseLong(requestInfo.getInstallTime());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return this.C;
    }

    public String d() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.E) && (requestInfo = this.I) != null) {
            this.E = requestInfo.getPackageName();
        }
        return this.E;
    }

    public long e() {
        RequestInfo requestInfo;
        if (this.D == 0 && (requestInfo = this.I) != null) {
            try {
                this.D = Long.parseLong(requestInfo.getUpdateTime());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return this.D;
    }

    public String f() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.A) && (requestInfo = this.I) != null) {
            this.A = requestInfo.getAppVersion();
        }
        return this.A;
    }

    public String g() {
        if (TextUtils.isEmpty(this.u)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.u = devInfo.getBrand();
            } else {
                this.u = Build.BRAND;
            }
        }
        return this.u;
    }

    public String h() {
        if (TextUtils.isEmpty(this.g)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.g = devInfo.getDensity();
            } else {
                try {
                    if (TextUtils.isEmpty(this.g)) {
                        this.g = a4.j().u.getResources().getDisplayMetrics().density + "";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.g;
    }

    public j7 i() {
        j7 j7Var = this.d;
        j7 j7Var2 = j7.DEVICE_OTHER;
        if (j7Var == j7Var2) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                String devType = devInfo.getDevType();
                if ("1".equals(devType)) {
                    this.d = j7.DEVICE_PHONE;
                } else if ("2".equals(devType)) {
                    this.d = j7.DEVICE_FLAT;
                }
            } else if (j7Var == j7Var2) {
                try {
                    try {
                        if (((TelephonyManager) a4.j().u.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getPhoneType() != 0) {
                            this.d = j7.DEVICE_PHONE;
                        } else {
                            this.d = j7.DEVICE_FLAT;
                        }
                    } catch (Throwable unused) {
                        int i = a4.j().u.getResources().getConfiguration().screenLayout & 15;
                        if (i == 4 || i == 3) {
                            this.d = j7.DEVICE_FLAT;
                        } else {
                            this.d = j7.DEVICE_PHONE;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return this.d;
    }

    public String j() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = to.c();
        }
        return this.j;
    }

    public String k() {
        if (q1.h().s()) {
            return null;
        }
        if (G() && TextUtils.isEmpty(this.n)) {
            this.n = to.a(a4.j().u, "com.huawei.hwid");
        }
        return this.n;
    }

    public String l() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = fk.a(this.F);
        }
        return this.z;
    }

    public String n() {
        if (TextUtils.isEmpty(this.x)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.x = devInfo.getLanguage();
            } else {
                this.x = Locale.getDefault().getLanguage();
            }
        }
        return this.x;
    }

    public String o() {
        if (TextUtils.isEmpty(this.w)) {
            this.w = a7.c();
        }
        return this.w;
    }

    public String p() {
        if (TextUtils.isEmpty(this.h)) {
            this.h = E();
        }
        return this.h;
    }

    public String q() {
        if (TextUtils.isEmpty(this.v)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.v = devInfo.getModel();
            } else {
                this.v = Build.MODEL;
            }
        }
        return this.v;
    }

    public String r() {
        if (TextUtils.isEmpty(this.y)) {
            this.y = fk.b(this.F);
        }
        return this.y;
    }

    public String s() {
        return hq.a();
    }

    public String t() {
        if (this.q) {
            return this.s;
        }
        this.q = true;
        String strB = hq.b();
        this.s = strB;
        return strB;
    }

    public String u() {
        if (TextUtils.isEmpty(this.t)) {
            this.t = Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
        }
        return this.t;
    }

    public String v() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = to.k(a4.j().u);
        }
        return this.i;
    }

    public String w() {
        if (TextUtils.isEmpty(this.e)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.e = devInfo.getResolution();
            } else {
                z();
            }
        }
        return this.e;
    }

    public String x() {
        if (TextUtils.isEmpty(this.o)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.o = devInfo.getRomVersion();
            } else {
                try {
                    ek ekVarA = ek.a();
                    ekVarA.c();
                    this.o = ekVarA.b();
                } catch (Throwable unused) {
                }
            }
        }
        return this.o;
    }

    public String y() {
        if (TextUtils.isEmpty(this.c)) {
            DevInfo devInfo = this.J;
            if (devInfo != null) {
                this.c = devInfo.getRoot();
            } else {
                this.c = to.b();
            }
        }
        return this.c;
    }
}
