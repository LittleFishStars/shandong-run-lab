package com.baidu.mshield.x0.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.TinyApp;
import com.alipay.sdk.m.y.l;
import com.baidu.mshield.rp.Report;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x6.f.k;
import com.beizi.fusion.BeiZiBiddingConstant;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26737a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String[] b = {"L3N5c3RlbS94YmluL3N1", "L3N5c3RlbS9iaW4vc3U", "L3N5c3RlbS94YmluLy5zdQ==", "L3N5c3RlbS9iaW4vLnN1", "L3N5c3RlbS9iaW4vLnN1dg==", "L3N5c3RlbS94YmluLy5zdXY=", "L3N5c3RlbS94YmluL2Jkc3U=", "L3N5c3RlbS9iaW4vYmRzdQ==", "L3N5c3RlbS94YmluL2F1", "L3N5c3RlbS9iaW4vYXU=", "L3N5c3RlbS94YmluL2t1LnN1ZA==", "L3N5c3RlbS9iaW4va3Uuc3Vk", "L3N5c3RlbS9iaW4vLnJncw==", "L3N5c3RlbS94YmluLy5yZ3M=", "L3NiaW4vc3U="};
    public static boolean c = false;

    public static class a extends com.baidu.mshield.x0.d.h.b {
        public final /* synthetic */ Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            boolean unused = d.c = true;
            d.p(this.b);
            boolean unused2 = d.c = false;
        }
    }

    public static class b implements com.baidu.mshield.x0.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26738a;

        public b(Context context) {
            this.f26738a = context;
        }

        @Override // com.baidu.mshield.x0.e.b
        public void a(String str) {
            try {
                if (str.contains("mshield")) {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", "mshield");
                    jSONObject.put("1", str.replaceAll("\t", l.b).replaceAll("\n", l.b));
                    jSONArray.put(jSONObject);
                    d.a(this.f26738a, new c(), jSONArray, "1003138");
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // com.baidu.mshield.x0.e.b
        public boolean a() {
            return true;
        }
    }

    public static void b(Context context, JSONArray jSONArray, String str) {
        try {
            c cVar = new c();
            String str2 = EngineImpl.sAppkey;
            cVar.c = 0;
            String str3 = com.baidu.mshield.x0.a.d;
            String str4 = EngineImpl.sLoadVersion;
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("1", cVar.f26736a);
                jSONObject2.put("2", cVar.b);
                jSONObject2.put("3", String.valueOf(c(context)));
                jSONObject2.put("4", cVar.c);
                jSONObject2.put("5", cVar.d);
                jSONObject2.put("6", cVar.e);
                jSONObject2.put("7", cVar.f);
                jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, com.baidu.mshield.x0.a.d);
                jSONObject2.put("9", EngineImpl.sLoadVersion);
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                jSONObject.put("Module_section", jSONArray);
                b(context, jSONObject.toString());
            } catch (Throwable th) {
                a(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static String c(Context context) {
        try {
            String str = EngineImpl.sAppkey;
            return str != null ? str : "";
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static byte[] d() {
        char[] cArr = new char[16];
        try {
            char[] charArray = f26737a.toCharArray();
            for (int i = 0; i < 16; i++) {
                int iNextInt = new Random().nextInt(62);
                if (iNextInt >= 0 && iNextInt < charArray.length) {
                    cArr[i] = charArray[iNextInt];
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return new String(cArr).getBytes();
    }

    public static String e() {
        LineNumberReader lineNumberReader;
        String strTrim = "";
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.security_patch").getInputStream());
                try {
                    LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader2);
                    String line = "";
                    while (line != null) {
                        try {
                            line = lineNumberReader2.readLine();
                            if (line != null) {
                                strTrim = line.trim();
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStreamReader = inputStreamReader2;
                            lineNumberReader = lineNumberReader2;
                            try {
                                a(th);
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable th2) {
                                        a(th2);
                                    }
                                }
                                if (lineNumberReader != null) {
                                }
                                return strTrim;
                            } finally {
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable th3) {
                                        a(th3);
                                    }
                                }
                                if (lineNumberReader != null) {
                                    try {
                                        lineNumberReader.close();
                                    } catch (IOException e) {
                                        a(e);
                                    }
                                }
                            }
                        }
                    }
                    try {
                        inputStreamReader2.close();
                    } catch (Throwable th4) {
                        a(th4);
                    }
                    lineNumberReader2.close();
                } catch (Throwable th5) {
                    th = th5;
                    lineNumberReader = null;
                    inputStreamReader = inputStreamReader2;
                }
            } catch (Throwable th6) {
                th = th6;
                lineNumberReader = null;
            }
        } catch (IOException e2) {
        }
        return strTrim;
    }

    public static int f(Context context) {
        try {
            return com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 0;
            for (String str : b) {
                if (new File(new String(Base64.decode(str, 0))).exists()) {
                    jSONObject.put(Integer.toString(i), "1");
                } else {
                    jSONObject.put(Integer.toString(i), "0");
                }
                i++;
            }
            try {
                File file = new File(new String(Base64.decode("L3NiaW5fb3JpZw==", 0)));
                if (file.exists() && file.isDirectory()) {
                    jSONObject.put(Integer.toString(i), "0");
                    for (String str2 : file.list()) {
                        com.baidu.mshield.b.c.a.b(str2 + " exits!!");
                        if (str2.startsWith("su")) {
                            jSONObject.put(Integer.toString(i), "1");
                            break;
                        }
                    }
                } else {
                    jSONObject.put(Integer.toString(i), "0");
                }
            } catch (Throwable th) {
                a(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
        return jSONObject;
    }

    public static String h(Context context) {
        try {
            File file = new File(context.getFilesDir(), com.baidu.mshield.x0.a.f26729a);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String i(Context context) {
        try {
            return com.baidu.xclient.gdid.a.c(context);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String j(Context context) {
        try {
            return Long.toString(com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).firstInstallTime);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String k(Context context) {
        return "4.2.6";
    }

    public static String l(Context context) {
        try {
            return new String(com.baidu.mshield.b.f.d.a(Base64.decode(com.baidu.mshield.x0.a.b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void m(Context context) {
        com.baidu.mshield.x0.e.a.a().a(new b(context));
    }

    public static boolean n(Context context) {
        try {
            if (!k.a(context, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
                return true;
            }
            NetworkInfo networkInfoA = com.baidu.mshield.b.e.b.a(context);
            if (networkInfoA == null) {
                return false;
            }
            return networkInfoA.isConnected();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean o(Context context) {
        try {
            return com.baidu.mshield.b.e.a.b(context, "adb_enabled") > 0;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void p(Context context) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            List<com.baidu.mshield.x0.l.b> listE = aVar.e();
            if (listE == null) {
                return;
            }
            com.baidu.mshield.b.c.a.b("re_con==" + listE.size());
            for (com.baidu.mshield.x0.l.b bVar : listE) {
                if (a(context, aVar.a(), bVar.b)) {
                    a(context, bVar);
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void q(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String strA = "";
        com.baidu.mshield.b.c.a.b("setAliveDate begin");
        int i = 0;
        try {
            PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 16384);
            int i2 = packageInfoA.applicationInfo.flags;
            i = ((i2 & 1) == 1 || (i2 & 128) == 128) ? 1 : 0;
            try {
                strA = com.baidu.mshield.b.f.e.a(new File(packageInfoA.applicationInfo.sourceDir));
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            a(th);
        }
        try {
            jSONObject2.put("0", "0");
            jSONObject2.put("15", Integer.toString(i));
            jSONObject2.put("14", j(context));
            jSONObject2.put(TinyApp.SUB_TYPE_BRAND_ZONE, e());
            jSONObject2.put("17", strA);
            jSONObject2.put("18", e(context));
            jSONObject2.put("19", f(context));
            jSONObject2.put("990", com.baidu.xclient.gdid.a.d(context));
            jSONObject2.put("989", k(context));
            jSONObject2.put("993", e.a(context));
            jSONObject2.put("995", g.b(context));
            if (a(context, "plc31", true)) {
                jSONObject2.put("997", i(context));
            }
            jSONObject2.put("998", e.b(context));
            jSONObject2.put(BeiZiBiddingConstant.LossReason.OTHER, TextUtils.isEmpty(com.baidu.mshield.utility.c.j(context)) ? com.baidu.mshield.utility.c.i(context) : com.baidu.mshield.utility.c.j(context));
            jSONObject2.put("981", new com.baidu.mshield.x0.l.c(context).a());
            jSONObject.put("0", new JSONObject().put("1001003", jSONObject2));
            com.baidu.mshield.b.c.a.b("setAliveDate begin to report" + jSONObject.toString());
            c(context, jSONObject.toString());
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static String a(long j, String str) {
        if (j >= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new SimpleDateFormat(str).format(new Date(j));
                }
            } catch (Throwable th) {
                a(th);
            }
        }
        return "";
    }

    public static void c(Context context, String str) {
        try {
            Report.getInstance(context).w(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String f() {
        try {
            return new String(com.baidu.mshield.b.f.d.a(Base64.decode(f.b, 2), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String c() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String d(Context context) {
        try {
            String str = EngineImpl.sSecKey;
            return str != null ? str : "";
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            Report.getInstance(context).i(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String a(String str, String str2, long j) {
        try {
            return com.baidu.mshield.b.f.e.a(str + j + str2);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            String strC = new com.baidu.mshield.x0.l.a(context).c(str);
            if (!TextUtils.isEmpty(strC)) {
                return new JSONObject(strC).optInt("1") == 1;
            }
        } catch (Throwable th) {
            a(th);
        }
        return z;
    }

    public static String e(Context context) {
        return com.baidu.mshield.b.a.d.a(context);
    }

    public static boolean a(Context context, String str, boolean z, com.baidu.mshield.x0.l.a aVar) {
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.l.a(context);
            } catch (Throwable th) {
                a(th);
            }
        }
        String strC = aVar.c(str);
        if (!TextUtils.isEmpty(strC)) {
            return new JSONObject(strC).optInt("1") == 1;
        }
        return z;
    }

    public static void b(Context context, String str) {
        try {
            Report.getInstance(context).sr(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Context context, String str, c cVar, com.baidu.mshield.x0.l.a aVar) {
        if (cVar == null) {
            return;
        }
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.l.a(context);
            } catch (Throwable th) {
                a(th);
                return;
            }
        }
        String strC = aVar.c(str);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(strC);
        cVar.e = jSONObject.optInt("2");
        cVar.d = jSONObject.optInt("3");
        cVar.f = jSONObject.optInt("4");
    }

    public static void b(Context context) {
        try {
            synchronized (d.class) {
                if (c) {
                    return;
                }
                com.baidu.mshield.x0.d.h.d.b().a(new a(context));
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String b() {
        try {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void a(Context context, JSONArray jSONArray, String str) {
        try {
            c cVar = new c();
            String str2 = EngineImpl.sAppkey;
            cVar.c = 0;
            String str3 = com.baidu.mshield.x0.a.d;
            String str4 = EngineImpl.sLoadVersion;
            a(context, cVar, jSONArray, str, true);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static JSONObject b(Context context, com.baidu.mshield.x0.l.b bVar, String str) {
        Throwable th;
        String str2;
        int i;
        String str3 = "";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if ("1001003".endsWith(bVar.d)) {
                    PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0);
                    String strA = com.baidu.mshield.b.f.e.a(new File(packageInfoA.applicationInfo.sourceDir));
                    try {
                        str3 = packageInfoA.versionName;
                        int i2 = packageInfoA.versionCode;
                        str2 = str3;
                        str3 = strA;
                        i = i2;
                    } catch (Throwable th2) {
                        str2 = str3;
                        str3 = strA;
                        th = th2;
                        a(th);
                        i = 0;
                    }
                } else {
                    str2 = "";
                    i = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = "";
            }
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            jSONObject2.put("3", c(context));
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, bVar.f26754a);
            jSONObject2.put("9", bVar.c);
            jSONObject2.put("10", bVar.d);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject4 = new JSONObject(str);
                    if ("1001003".endsWith(bVar.d)) {
                        com.baidu.mshield.b.c.a.b("1001003 createInsertAlive");
                        jSONObject4.put("14", j(context));
                        jSONObject4.put(TinyApp.SUB_TYPE_BRAND_ZONE, e());
                        jSONObject4.put("17", str3);
                        jSONObject4.put("18", str2);
                        jSONObject4.put("19", i);
                    }
                    if (a(context, "plc31", false)) {
                        jSONObject4.put("997", i(context));
                    }
                    jSONObject4.put("998", e.b(context));
                    jSONObject4.put("990", com.baidu.xclient.gdid.a.d(context));
                    jSONObject4.put("989", k(context));
                    jSONObject4.put(BeiZiBiddingConstant.LossReason.OTHER, TextUtils.isEmpty(com.baidu.mshield.utility.c.j(context)) ? com.baidu.mshield.utility.c.i(context) : com.baidu.mshield.utility.c.j(context));
                    jSONObject3 = jSONObject4;
                } catch (Throwable th4) {
                    a(th4);
                }
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
            a(context, jSONObject.toString());
        } catch (Throwable th5) {
            a(th5);
        }
        return jSONObject;
    }

    public static void a(Context context, c cVar, JSONArray jSONArray, String str) {
        a(context, cVar, jSONArray, str, true);
    }

    public static void a(Context context, c cVar, JSONArray jSONArray, String str, boolean z) {
        if (jSONArray == null || jSONArray.length() == 0 || cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                jSONObject3.put("991", i(context));
                jSONObject3.put("995", g.b(context));
                jSONObject3.put("998", e.b(context));
                jSONObject3.put("989", k(context));
            }
            jSONObject2.put("0", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("1", cVar.f26736a);
            jSONObject2.put("2", cVar.b);
            jSONObject2.put("3", String.valueOf(c(context)));
            jSONObject2.put("4", cVar.c);
            jSONObject2.put("5", cVar.d);
            jSONObject2.put("6", cVar.e);
            jSONObject2.put("7", cVar.f);
            jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, com.baidu.mshield.x0.a.d);
            jSONObject2.put("9", EngineImpl.sLoadVersion);
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONArray);
            a(context, jSONObject.toString());
        } catch (Throwable th) {
            a(th);
        }
    }

    public static int a(Context context, String str) {
        try {
            Report.getInstance(context).s(str);
            return 0;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static JSONObject a(Context context, String str, JSONArray jSONArray) {
        String str2;
        String string = "";
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strC = c(context);
            String str3 = com.baidu.mshield.x0.a.d;
            String str4 = EngineImpl.sLoadVersion;
            try {
                str2 = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionName;
                try {
                    string = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
                } catch (Throwable th) {
                    th = th;
                    a(th);
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = "";
            }
            jSONObject.put("1", string);
            jSONObject.put("2", EngineImpl.getInstance(context).getPropertyByType("p"));
            jSONObject.put("3", str2);
            jSONObject.put("4", com.baidu.mshield.utility.c.b(context));
            jSONObject.put("5", str);
            jSONObject.put("6", jCurrentTimeMillis);
            jSONObject.put("7", " ");
            jSONObject.put(PrepareException.ERROR_AUTH_FAIL, strC);
            jSONObject.put("9", str3);
            jSONObject.put("10", str4);
            jSONObject.put("11", " ");
            jSONObject.put("12", " ");
            jSONObject.put("13", " ");
            jSONObject.put("14", EngineImpl.getInstance(context).getPropertyByType("ws"));
            if (a(context, "plc31", false)) {
                jSONObject.put("997", i(context));
            }
            jSONObject.put("989", k(context));
            jSONObject.put("module_section", jSONArray);
        } catch (Throwable th3) {
            a(th3);
        }
        return jSONObject;
    }

    public static String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(com.baidu.mshield.b.f.d.b(str.getBytes(), com.baidu.mshield.b.f.a.a(16)), 0);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0105 A[Catch: all -> 0x01c2, TryCatch #2 {all -> 0x01c2, blocks: (B:20:0x004f, B:22:0x0056, B:24:0x006a, B:26:0x0073, B:28:0x0086, B:30:0x008f, B:32:0x0096, B:34:0x00a2, B:36:0x00ab, B:38:0x00c7, B:40:0x00d0, B:42:0x00d9, B:44:0x00e2, B:46:0x00eb, B:48:0x00f4, B:50:0x00fd, B:52:0x0105, B:53:0x010c, B:81:0x01a4, B:84:0x01ac, B:85:0x01b5, B:80:0x01a1, B:19:0x004c, B:55:0x0117, B:57:0x0124, B:59:0x0132, B:60:0x0148, B:63:0x0152, B:65:0x015b, B:67:0x016c, B:69:0x0175, B:71:0x017c, B:73:0x0185, B:75:0x018e, B:77:0x0197, B:68:0x0171), top: B:95:0x004c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0124 A[Catch: all -> 0x01a0, TRY_LEAVE, TryCatch #0 {all -> 0x01a0, blocks: (B:55:0x0117, B:57:0x0124, B:59:0x0132, B:60:0x0148, B:63:0x0152, B:65:0x015b, B:67:0x016c, B:69:0x0175, B:71:0x017c, B:73:0x0185, B:75:0x018e, B:77:0x0197, B:68:0x0171), top: B:91:0x0117, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0150  */
    /* JADX WARN: Code duplicated, block: B:67:0x016c A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:55:0x0117, B:57:0x0124, B:59:0x0132, B:60:0x0148, B:63:0x0152, B:65:0x015b, B:67:0x016c, B:69:0x0175, B:71:0x017c, B:73:0x0185, B:75:0x018e, B:77:0x0197, B:68:0x0171), top: B:91:0x0117, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0171 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:55:0x0117, B:57:0x0124, B:59:0x0132, B:60:0x0148, B:63:0x0152, B:65:0x015b, B:67:0x016c, B:69:0x0175, B:71:0x017c, B:73:0x0185, B:75:0x018e, B:77:0x0197, B:68:0x0171), top: B:91:0x0117, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01ac A[Catch: all -> 0x01c2, TRY_ENTER, TryCatch #2 {all -> 0x01c2, blocks: (B:20:0x004f, B:22:0x0056, B:24:0x006a, B:26:0x0073, B:28:0x0086, B:30:0x008f, B:32:0x0096, B:34:0x00a2, B:36:0x00ab, B:38:0x00c7, B:40:0x00d0, B:42:0x00d9, B:44:0x00e2, B:46:0x00eb, B:48:0x00f4, B:50:0x00fd, B:52:0x0105, B:53:0x010c, B:81:0x01a4, B:84:0x01ac, B:85:0x01b5, B:80:0x01a1, B:19:0x004c, B:55:0x0117, B:57:0x0124, B:59:0x0132, B:60:0x0148, B:63:0x0152, B:65:0x015b, B:67:0x016c, B:69:0x0175, B:71:0x017c, B:73:0x0185, B:75:0x018e, B:77:0x0197, B:68:0x0171), top: B:95:0x004c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01b5 A[Catch: all -> 0x01c2, TRY_LEAVE, TryCatch #2 {all -> 0x01c2, blocks: (B:20:0x004f, B:22:0x0056, B:24:0x006a, B:26:0x0073, B:28:0x0086, B:30:0x008f, B:32:0x0096, B:34:0x00a2, B:36:0x00ab, B:38:0x00c7, B:40:0x00d0, B:42:0x00d9, B:44:0x00e2, B:46:0x00eb, B:48:0x00f4, B:50:0x00fd, B:52:0x0105, B:53:0x010c, B:81:0x01a4, B:84:0x01ac, B:85:0x01b5, B:80:0x01a1, B:19:0x004c, B:55:0x0117, B:57:0x0124, B:59:0x0132, B:60:0x0148, B:63:0x0152, B:65:0x015b, B:67:0x016c, B:69:0x0175, B:71:0x017c, B:73:0x0185, B:75:0x018e, B:77:0x0197, B:68:0x0171), top: B:95:0x004c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONArray a(Context context, com.baidu.mshield.x0.l.b bVar, String str) {
        String str2;
        String string;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String strJ;
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = "";
        try {
            PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0);
            str2 = packageInfoA.versionName;
            try {
                i = packageInfoA.versionCode;
                try {
                    string = packageInfoA.applicationInfo.loadLabel(context.getPackageManager()).toString();
                    try {
                        if ("1001003".endsWith(bVar.d)) {
                            strA = com.baidu.mshield.b.f.e.a(new File(packageInfoA.applicationInfo.sourceDir));
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            a(th);
                        } catch (Throwable th2) {
                            a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    string = "";
                }
            } catch (Throwable th4) {
                th = th4;
                string = "";
                i = 0;
                a(th);
                jSONObject3.put("1", string);
                jSONObject3.put("2", EngineImpl.getInstance(context).getPropertyByType("p"));
                jSONObject3.put("3", str2);
                jSONObject3.put("4", com.baidu.mshield.utility.c.b(context));
                jSONObject3.put("5", bVar.d);
                jSONObject3.put("6", jCurrentTimeMillis);
                jSONObject3.put("7", "0");
                jSONObject3.put(PrepareException.ERROR_AUTH_FAIL, c(context));
                jSONObject3.put("9", bVar.f26754a);
                jSONObject3.put("10", bVar.c);
                com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
                jSONObject3.put("11", aVar.c());
                jSONObject3.put("12", aVar.k());
                jSONObject3.put("13", 1);
                jSONObject3.put("14", EngineImpl.getInstance(context).getPropertyByType("ws"));
                jSONObject3.put("20", com.baidu.mshield.utility.c.j(context));
                jSONObject3.put("21", com.baidu.mshield.utility.c.i(context));
                jSONObject3.put("22", e.b(context));
                jSONObject3.put("23", i(context));
                jSONObject3.put("26", e.a(context));
                jSONObject3.put("28", g.b(context));
                if ("1003003".endsWith(bVar.d)) {
                    jSONObject3.put("29", "x0");
                }
                jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONObject2 = new JSONObject(str);
                        if ("1001003".endsWith(bVar.d)) {
                            com.baidu.mshield.b.c.a.b("1001003 createAlive");
                            jSONObject2.put("14", j(context));
                            jSONObject2.put(TinyApp.SUB_TYPE_BRAND_ZONE, e());
                            jSONObject2.put("17", strA);
                            jSONObject2.put("18", str2);
                            jSONObject2.put("19", i);
                        }
                        if (a(context, "plc31", false)) {
                            jSONObject2.put("997", i(context));
                        }
                        jSONObject2.put("998", e.b(context));
                        if (TextUtils.isEmpty(com.baidu.mshield.utility.c.j(context))) {
                            strJ = com.baidu.mshield.utility.c.i(context);
                        } else {
                            strJ = com.baidu.mshield.utility.c.j(context);
                        }
                        jSONObject2.put(BeiZiBiddingConstant.LossReason.OTHER, strJ);
                        jSONObject2.put("990", com.baidu.xclient.gdid.a.d(context));
                        jSONObject2.put("989", k(context));
                        jSONObject2.put("985", com.baidu.mshield.x6.f.e.a(context));
                        jSONObject2.put("971", com.baidu.mshield.x6.f.e.b(context));
                        jSONObject = jSONObject2;
                    } catch (Throwable th5) {
                        a(th5);
                    }
                }
                if (jSONObject.length() == 0) {
                    jSONObject3.put("module_section", new JSONArray());
                } else {
                    jSONObject3.put("module_section", new JSONArray().put(jSONObject));
                }
                return new JSONArray().put(jSONObject3);
            }
        } catch (Throwable th6) {
            th = th6;
            str2 = "";
            string = str2;
        }
        jSONObject3.put("1", string);
        jSONObject3.put("2", EngineImpl.getInstance(context).getPropertyByType("p"));
        jSONObject3.put("3", str2);
        jSONObject3.put("4", com.baidu.mshield.utility.c.b(context));
        jSONObject3.put("5", bVar.d);
        jSONObject3.put("6", jCurrentTimeMillis);
        jSONObject3.put("7", "0");
        jSONObject3.put(PrepareException.ERROR_AUTH_FAIL, c(context));
        jSONObject3.put("9", bVar.f26754a);
        jSONObject3.put("10", bVar.c);
        com.baidu.mshield.x0.l.a aVar2 = new com.baidu.mshield.x0.l.a(context);
        jSONObject3.put("11", aVar2.c());
        jSONObject3.put("12", aVar2.k());
        jSONObject3.put("13", 1);
        jSONObject3.put("14", EngineImpl.getInstance(context).getPropertyByType("ws"));
        jSONObject3.put("20", com.baidu.mshield.utility.c.j(context));
        jSONObject3.put("21", com.baidu.mshield.utility.c.i(context));
        jSONObject3.put("22", e.b(context));
        jSONObject3.put("23", i(context));
        jSONObject3.put("26", e.a(context));
        jSONObject3.put("28", g.b(context));
        if ("1003003".endsWith(bVar.d)) {
            jSONObject3.put("29", "x0");
        }
        jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject2 = new JSONObject(str);
            if ("1001003".endsWith(bVar.d)) {
                com.baidu.mshield.b.c.a.b("1001003 createAlive");
                jSONObject2.put("14", j(context));
                jSONObject2.put(TinyApp.SUB_TYPE_BRAND_ZONE, e());
                jSONObject2.put("17", strA);
                jSONObject2.put("18", str2);
                jSONObject2.put("19", i);
            }
            if (a(context, "plc31", false)) {
                jSONObject2.put("997", i(context));
            }
            jSONObject2.put("998", e.b(context));
            if (TextUtils.isEmpty(com.baidu.mshield.utility.c.j(context))) {
                strJ = com.baidu.mshield.utility.c.i(context);
            } else {
                strJ = com.baidu.mshield.utility.c.j(context);
            }
            jSONObject2.put(BeiZiBiddingConstant.LossReason.OTHER, strJ);
            jSONObject2.put("990", com.baidu.xclient.gdid.a.d(context));
            jSONObject2.put("989", k(context));
            jSONObject2.put("985", com.baidu.mshield.x6.f.e.a(context));
            jSONObject2.put("971", com.baidu.mshield.x6.f.e.b(context));
            jSONObject = jSONObject2;
        }
        if (jSONObject.length() == 0) {
            jSONObject3.put("module_section", new JSONArray());
        } else {
            jSONObject3.put("module_section", new JSONArray().put(jSONObject));
        }
        return new JSONArray().put(jSONObject3);
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.equals(context.getPackageName()) || str2.equals(com.baidu.mshield.x0.a.f26729a)) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str2.equals(jSONArray.get(i))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void a(Context context, com.baidu.mshield.x0.l.b bVar) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strD = aVar.d(bVar.d);
            String strB = b();
            if (strD.equals(strB)) {
                return;
            }
            String strA = aVar.a(bVar.d);
            if (!new com.baidu.mshield.x0.i.c(context, null).a(a(context, bVar, strA).toString())) {
                b(context, bVar, strA);
            }
            aVar.c(bVar.d, strB);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(com.baidu.mshield.b.f.d.a(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:4:0x0004, B:5:0x0009, B:7:0x0013, B:9:0x0024), top: B:14:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0024 A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:4:0x0004, B:5:0x0009, B:7:0x0013, B:9:0x0024), top: B:14:0x0004 }] */
    public static String a(Context context, com.baidu.mshield.x0.l.a aVar, String str, String str2) {
        String strC;
        JSONObject jSONObject;
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.l.a(context);
                strC = aVar.c(str);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject = new JSONObject(strC).getJSONObject("5");
                    if (jSONObject.has(str2)) {
                        return jSONObject.optString(str2, "");
                    }
                }
            } catch (Throwable th) {
                a(th);
            }
        } else {
            strC = aVar.c(str);
            if (!TextUtils.isEmpty(strC)) {
                jSONObject = new JSONObject(strC).getJSONObject("5");
                if (jSONObject.has(str2)) {
                    return jSONObject.optString(str2, "");
                }
            }
        }
        return "";
    }

    public static String a() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    public static JSONArray a(JSONArray jSONArray, int i) {
        JSONArray jSONArray2 = new JSONArray();
        try {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != i) {
                    jSONArray2.put(jSONArray.get(i2));
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return jSONArray2;
    }
}
