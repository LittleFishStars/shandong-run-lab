package com.zj.adlib;

import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import cn.hzjizhun.admin.base.ad.NativeHelper;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.base.g;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.gyf.immersionbar.b;
import com.kc.openset.constant.DeviceIdType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class m3b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m3b f43213a = null;
    public static String b = "";
    public static String c = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f18120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18122a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f18123b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f18124b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f18125c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f18126c;
    public final float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f18127d;
    public final float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final int f18128e;
    public int f;

    public m3b() {
        this.f18122a = "";
        this.f18122a = alb.b("deviceId");
        alb.b("imsi");
        alb.b(DeviceIdType.IMEI);
        alb.b("mac");
        if (this.f18126c <= 0 || this.f18124b <= 0) {
            try {
                this.f18124b = RcSdk.e().getResources().getDisplayMetrics().widthPixels;
                this.f18126c = RcSdk.e().getResources().getDisplayMetrics().heightPixels;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        if (this.f18127d <= 1) {
            Resources system = Resources.getSystem();
            this.f18127d = system.getDimensionPixelSize(system.getIdentifier(b.f6802a, "dimen", "android"));
        }
        try {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            this.d = displayMetrics.density;
            this.f18128e = displayMetrics.densityDpi;
            this.e = (float) Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public static void b(kha khaVar) {
        String str;
        try {
            m3b m3bVarC = c();
            khaVar.f17686b = m3bVarC.a();
            khaVar.f17690d = RcSdk.g();
            khaVar.f17692e = RcSdk.f();
            khaVar.f17694f = RcSdk.h();
            khaVar.e = m3bVarC.f();
            float f = m3bVarC.f18123b;
            float f2 = 0.0f;
            if (f <= 1.0f) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                        m3bVarC.f18123b = ((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1024.0f) / 1024.0f;
                    }
                    f = m3bVarC.f18123b;
                } catch (Throwable unused) {
                    f = 0.0f;
                }
            }
            khaVar.f = f;
            int length = m3bVarC.f18121a;
            int i = 1;
            if (length <= 1) {
                try {
                    length = new File("/sys/devices/system/cpu/").listFiles(new e0b()).length;
                    m3bVarC.f18121a = length;
                } catch (Throwable unused2) {
                    length = 1;
                }
            }
            khaVar.f17691e = length;
            khaVar.m = "";
            khaVar.f17696g = g();
            khaVar.f17683a = m3bVarC.f18124b;
            khaVar.f17685b = m3bVarC.f18126c;
            if (Resources.getSystem().getConfiguration().orientation != 1) {
                i = 2;
            }
            khaVar.f17689d = i;
            float f3 = m3bVarC.f18125c;
            if (f3 <= 1.0f) {
                try {
                    f3 = Integer.parseInt(new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq")).readLine()) / 1000000.0f;
                    m3bVarC.f18125c = f3;
                } catch (Throwable unused3) {
                }
            }
            f2 = f3;
            khaVar.g = f2;
            khaVar.f17698i = Build.MODEL;
            khaVar.f17699j = Build.BRAND;
            khaVar.q = RcSdk.c();
            khaVar.c = m3bVarC.d;
            khaVar.d = m3bVarC.e;
            khaVar.f17687c = m3bVarC.f18128e;
            khaVar.f17697h = oua.b();
            khaVar.i = m3bVarC.f18124b;
            khaVar.j = (m3bVarC.f18126c - m3bVarC.f18127d) - 20;
            khaVar.k = m3bVarC.d();
            try {
                if (TextUtils.isEmpty(b)) {
                    b = NativeHelper.getSysUpdateMark();
                }
                str = b;
            } catch (Throwable unused4) {
                str = b;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    khaVar.f17700k = str;
                }
            } catch (Throwable unused5) {
            }
            String strE = e();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            khaVar.l = strE;
        } catch (Throwable unused6) {
        }
    }

    public static m3b c() {
        if (f43213a == null) {
            synchronized (m3b.class) {
                if (f43213a == null) {
                    f43213a = new m3b();
                }
            }
        }
        return f43213a;
    }

    public static String e() {
        try {
            if (TextUtils.isEmpty(c) && Build.VERSION.SDK_INT > 26) {
                String lowerCase = Build.BRAND.toLowerCase();
                String lowerCase2 = Build.MANUFACTURER.toLowerCase();
                if (!(lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase2.contains("xiaomi") || lowerCase2.contains("redmi"))) {
                    String sysBootMark = NativeHelper.getSysBootMark();
                    c = sysBootMark;
                    return sysBootMark;
                }
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    public static String g() {
        try {
            String strB = alb.b("ua");
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(RcSdk.e());
            if (!TextUtils.isEmpty(defaultUserAgent)) {
                jha.a().getClass();
                String strC = jha.c();
                if (!TextUtils.isEmpty(strC) && defaultUserAgent.contains(strC)) {
                    defaultUserAgent = defaultUserAgent.replaceAll(strC, "");
                }
            }
            alb.c("ua", defaultUserAgent);
            return defaultUserAgent;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String a() {
        try {
            if (!TextUtils.isEmpty(this.f18122a)) {
                return this.f18122a;
            }
            String strB = g.b((System.currentTimeMillis() + "").getBytes());
            this.f18122a = strB;
            alb.c("deviceId", strB);
            this.f18122a.length();
            return this.f18122a;
        } catch (Throwable unused) {
            return this.f18122a;
        }
    }

    public final int d() {
        try {
            int i = this.f;
            if (i > 0) {
                return i;
            }
            TelephonyManager telephonyManager = (TelephonyManager) RcSdk.e().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            String simOperator = telephonyManager.getSimOperator();
            if (telephonyManager.getSimState() != 5) {
                return 0;
            }
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
                this.f = 1;
            } else if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                this.f = 2;
            } else if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
                this.f = 3;
            } else {
                this.f = 255;
            }
        } catch (Throwable unused) {
        }
        return this.f;
    }

    public final float f() {
        float f = this.f18120a;
        if (f > 1.0f) {
            return f;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                bufferedReader.close();
                return 0.0f;
            }
            this.f18120a = Float.parseFloat(line.split("\\s+")[1]) / 1024.0f;
            bufferedReader.close();
            return this.f18120a;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
