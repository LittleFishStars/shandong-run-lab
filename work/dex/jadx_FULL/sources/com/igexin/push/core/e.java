package com.igexin.push.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.push.g.o;
import com.igexin.sdk.GService;
import com.igexin.sdk.PushService;
import com.igexin.sdk.main.SdkInitSwitch;
import com.igexin.sdk.main.SdkPushSwitch;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {
    public static String A = null;
    public static String B = null;
    public static String C = null;
    public static String D = null;
    public static String E = null;
    public static String F = null;
    public static String G = null;
    public static String H = null;
    public static String I = null;
    public static String K = null;
    public static String L = null;
    public static String M = null;
    public static String Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38001a = "";
    public static int aA = 0;
    public static byte[] aB = null;
    public static long aH = 0;
    private static final String aN = "CoreRuntimeInfo";
    private static Map<String, Integer> aO = null;
    public static String ac = null;
    public static byte[] ad = null;
    public static boolean ae = false;
    public static boolean af = false;
    public static boolean ag = false;
    public static Map<String, PushTaskBean> ah = null;
    public static Map<String, Integer> ai = null;
    public static Map<String, HashSet<String>> aj = null;
    public static Map<String, Integer> ak = null;
    public static HashMap<String, Long> al = null;
    public static String an = null;
    public static long ao = 0;
    public static String ap = null;
    public static String aq = null;
    public static String ar = null;
    public static String as = null;
    public static String at = null;
    public static String au = null;
    public static long av = 0;
    public static long aw = 0;
    public static volatile long ax = 0;
    public static long ay = 0;
    public static boolean az = false;
    public static String b = "";
    public static long c = 0;
    public static String d = null;
    public static String e = null;
    public static String f = "";
    public static String g = "";
    public static String h = null;
    public static String i = "";
    public static int j;
    public static int k;
    public static Context l;
    public static volatile boolean s;
    public static volatile boolean u;
    public static volatile boolean v;
    public static AtomicBoolean m = new AtomicBoolean(false);
    public static boolean n = true;
    public static HashMap<String, ClassLoader> o = new HashMap<>();
    public static volatile boolean p = true;
    public static volatile boolean q = false;
    public static int r = 0;
    public static boolean t = true;
    public static AtomicBoolean w = new AtomicBoolean(true);
    public static int x = 0;
    public static int y = 0;
    public static long z = 0;
    public static int J = -1;
    public static String N = "";
    public static long O = -1;
    public static long P = -1;
    public static long Q = 0;
    public static long R = 0;
    public static long S = 0;
    public static long T = 0;
    public static long U = 0;
    public static String V = null;
    public static boolean W = false;
    public static long X = 0;
    public static long Y = 0;
    public static long aa = 0;
    public static int ab = 0;
    public static int am = 0;
    public static String aC = null;
    public static int aD = 3600;
    public static boolean aE = false;
    public static long aF = com.heytap.mcssdk.constant.a.n;
    public static long aG = com.heytap.mcssdk.constant.a.n;
    public static String aI = "oppo r9";
    public static int aJ = 200;
    public static String aK = "";
    public static String aL = "";
    private static String aP = "";
    public static boolean aM = false;

    public static int a(String str) {
        int iIntValue;
        synchronized (e.class) {
            if (aO.get(str) == null) {
                aO.put(str, 0);
            }
            iIntValue = aO.get(str).intValue() - 1;
            aO.put(str, Integer.valueOf(iIntValue));
            if (iIntValue == 0) {
                aO.remove(str);
            }
        }
        return iIntValue;
    }

    public static void a() {
        ServiceManager.getInstance();
        String strD = ServiceManager.d(l);
        ServiceManager.getInstance();
        String strE = ServiceManager.e(l);
        try {
            if (!TextUtils.isEmpty(strE)) {
                Class<?> cls = Class.forName(strE);
                if (cls == PushService.class || PushService.class.isAssignableFrom(cls)) {
                    strE = null;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        String[] strArr = {strD, strE, GService.class.getName()};
        int iB = com.igexin.push.config.e.b();
        for (int i2 = 0; i2 < 3; i2++) {
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str)) {
                try {
                    l.getPackageManager().setComponentEnabledSetting(new ComponentName(l, str), (iB == -1 || iB == 1) ? 1 : 2, 1);
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
            }
        }
    }

    public static void a(long j2) {
        z = j2;
        A = com.igexin.c.b.a.b(String.valueOf(j2));
    }

    public static boolean a(Context context) {
        l = context;
        g = context.getPackageName();
        i = o.b(context, "sc", "").toString();
        ac = "getui.permission.GetuiService." + g;
        if (!e()) {
            com.igexin.c.a.c.a.a(aN, "parseManifests failed");
            com.igexin.c.a.c.a.a("CoreRuntimeInfo|parseManifests failed", new Object[0]);
            throw new IllegalArgumentException("parseManifests failed");
        }
        ad = com.igexin.c.b.a.b(f38001a + context.getPackageName()).getBytes();
        com.igexin.push.g.j.a();
        com.igexin.push.config.e.a();
        a();
        if (Build.VERSION.SDK_INT < 29) {
            System.currentTimeMillis();
            D = com.igexin.push.g.n.g();
            System.currentTimeMillis();
            E = com.igexin.push.g.n.f();
            System.currentTimeMillis();
        }
        F = com.igexin.push.g.n.e();
        G = com.igexin.push.g.n.d();
        n = com.igexin.push.g.c.e();
        ah = new ConcurrentHashMap();
        ai = new ConcurrentHashMap();
        aj = new HashMap();
        ak = new HashMap();
        al = new HashMap<>();
        s = com.igexin.push.core.d.d.a().b("p");
        aO = new HashMap();
        az = true;
        com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init success ##########", new Object[0]);
        if (new SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a("i", Boolean.TRUE);
            new SdkInitSwitch(l).delete();
        }
        if (new SdkPushSwitch(l).isSwitchOn()) {
            s = true;
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            new SdkPushSwitch(l).delete();
        }
        return true;
    }

    public static boolean a(String str, Integer num) {
        synchronized (e.class) {
            int iIntValue = num.intValue();
            if (aO.get(str) == null || (iIntValue = aO.get(str).intValue() + num.intValue()) != 0) {
                aO.put(str, Integer.valueOf(iIntValue));
                return true;
            }
            aO.remove(str);
            return false;
        }
    }

    public static Boolean b() {
        return Boolean.valueOf(aP.equals("*"));
    }

    public static ClassLoader b(String str) {
        String str2 = str.split(LoginConstants.UNDER_LINE)[0];
        if (o.containsKey(str2)) {
            return o.get(str2);
        }
        return null;
    }

    public static void b(long j2) {
        O = j2;
    }

    private static void c() {
        if (new SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a("i", Boolean.TRUE);
            new SdkInitSwitch(l).delete();
        }
        if (new SdkPushSwitch(l).isSwitchOn()) {
            s = true;
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            new SdkPushSwitch(l).delete();
        }
    }

    private static String d() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    private static boolean e() {
        try {
            ApplicationInfo applicationInfoB = com.igexin.push.g.n.b(l);
            if (applicationInfoB == null || applicationInfoB.metaData == null) {
                return false;
            }
            String strA = com.igexin.push.g.d.a(applicationInfoB);
            if (TextUtils.isEmpty(strA)) {
                strA = applicationInfoB.metaData.getString(b.b);
            }
            if (TextUtils.isEmpty(strA)) {
                strA = applicationInfoB.metaData.getString("GETUI_APPID");
            }
            if (strA != null) {
                strA = strA.trim();
            }
            b = applicationInfoB.metaData.getString(b.d);
            String string = applicationInfoB.metaData.getString(b.e);
            if (string != null) {
                aP = string;
            }
            if (TextUtils.isEmpty(strA)) {
                com.igexin.c.a.c.a.a(aN, "getui sdk init error, missing parm ######");
                com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init error, missing parm #####", new Object[0]);
                return false;
            }
            f38001a = strA;
            f = SDKUrlConfig.getLocation();
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static void f() {
        if (Build.VERSION.SDK_INT < 29) {
            System.currentTimeMillis();
            D = com.igexin.push.g.n.g();
            System.currentTimeMillis();
            E = com.igexin.push.g.n.f();
            System.currentTimeMillis();
        }
        F = com.igexin.push.g.n.e();
        G = com.igexin.push.g.n.d();
    }
}
