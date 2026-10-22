package com.baidu.mshield.utility;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.baidu.mshield.MyProvider;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.rp.Report;
import com.baidu.mshield.x0.EngineImpl;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26722a = null;
    public static String b = null;
    public static String c = "";
    public static String d = "";
    public static int e = -1;

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strA = com.baidu.xclient.gdid.a.a(context);
            if (strA == null) {
                strA = "";
            }
            jSONObject.put("0", strA);
            String strB = com.baidu.xclient.gdid.a.b(context);
            if (strB == null) {
                strB = "";
            }
            jSONObject.put("1", strB);
            String strE = com.baidu.xclient.gdid.a.e(context);
            if (strE == null) {
                strE = "";
            }
            jSONObject.put("2", strE);
            String str = Build.HOST;
            if (str == null) {
                str = "";
            }
            jSONObject.put("3", str);
            String strA2 = c.a();
            if (strA2 == null) {
                strA2 = "";
            }
            jSONObject.put("4", strA2);
            String strH = com.baidu.xclient.gdid.a.h(context);
            if (strH == null) {
                strH = "";
            }
            jSONObject.put("5", strH);
            String str2 = Build.VERSION.CODENAME;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("6", str2);
            String str3 = Build.VERSION.INCREMENTAL;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("7", str3);
            jSONObject.put(PrepareException.ERROR_AUTH_FAIL, c.b(context));
            String strG = com.baidu.xclient.gdid.a.g(context);
            if (strG == null) {
                strG = "";
            }
            jSONObject.put("9", strG);
            String strA3 = com.baidu.mshield.core.a.a("mod");
            if (strA3 == null) {
                strA3 = "";
            }
            jSONObject.put("10", strA3);
            jSONObject.put("11", c.g(context));
            String strA4 = com.baidu.mshield.core.a.a("arv");
            jSONObject.put("12", strA4 != null ? strA4 : "");
            jSONObject.put("13", c.h(context));
            jSONObject.put("20", com.baidu.mshield.core.a.a("arl"));
        } catch (Throwable th) {
            a(th);
        }
        return jSONObject;
    }

    public static String[] c(Context context) {
        if (!TextUtils.isEmpty(f26722a) && !TextUtils.isEmpty(b)) {
            return new String[]{f26722a, b};
        }
        String strK = com.baidu.mshield.sharedpreferences.a.a(context).K();
        if (TextUtils.isEmpty(strK)) {
            return new String[0];
        }
        String[] strArrSplit = strK.split(c49.f40900a);
        if (strArrSplit == null || strArrSplit.length != 2) {
            return new String[2];
        }
        f26722a = strArrSplit[0];
        b = strArrSplit[1];
        return strArrSplit;
    }

    @SuppressLint({"MissingPermission"})
    public static int d(Context context) {
        NetworkInfo networkInfoA;
        try {
            networkInfoA = com.baidu.mshield.b.e.b.a(context);
        } catch (Throwable th) {
            a(th);
            networkInfoA = null;
        }
        if (networkInfoA == null) {
            return 0;
        }
        if (1 == networkInfoA.getType()) {
            return 2;
        }
        networkInfoA.getType();
        return 1;
    }

    public static String e(Context context) {
        try {
            if (TextUtils.isEmpty(d) && e != 1) {
                try {
                    ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + Consts.DOT + "mshield.ac.provider", 0);
                    if (providerInfoResolveContentProvider != null && !providerInfoResolveContentProvider.multiprocess) {
                        d = providerInfoResolveContentProvider.processName;
                    }
                } catch (Throwable th) {
                    a(th);
                }
                e = 1;
                return d;
            }
            return d;
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static String f(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("host=");
            String str = f.f26726a;
            sb.append(str);
            com.baidu.mshield.b.c.a.b(sb.toString());
            return new String(F.getInstance().ad(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void g(Context context) {
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        if (System.currentTimeMillis() - aVarA.b() <= 86400000) {
            aVarA.a(aVarA.l() + 1);
            return;
        }
        HashMap map = new HashMap();
        map.put("0", Integer.valueOf(aVarA.l() + 1));
        aVarA.a(0);
        aVarA.k();
        a(context, "1067119", map);
    }

    public static int h(Context context) {
        int iA;
        try {
            if (MyProvider.a() || TextUtils.isEmpty(e(context)) || (iA = a(context)) == 1) {
                return 1;
            }
            if (iA == 2) {
                return 0;
            }
            return MyProvider.a() ? 1 : 0;
        } catch (Throwable th) {
            a(th);
            return -1;
        }
    }

    public static String[] i(Context context) {
        String str = f26722a;
        String str2 = b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.mshield.b.c.a.b("get key key select by in memory!");
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String strK = com.baidu.mshield.sharedpreferences.a.a(context).K();
            if (!TextUtils.isEmpty(strK)) {
                String[] strArrSplit = strK.split(c49.f40900a);
                if (strArrSplit.length == 2) {
                    com.baidu.mshield.b.c.a.b("get key key select by  from Info");
                    return strArrSplit;
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String strA = com.baidu.mshield.sharedpreferences.a.a(context).a();
            if (!TextUtils.isEmpty(strA)) {
                String[] strArrSplit2 = strA.split(c49.f40900a);
                if (strArrSplit2.length == 2) {
                    com.baidu.mshield.b.c.a.b("get key key select by  in mark");
                    return strArrSplit2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.mshield.b.c.a.b("get key key select by by default");
            str = "985050001";
            str2 = "83162820e470e3b72501f0683504560e";
        }
        return new String[]{str, str2};
    }

    public static void a(String str, String str2) {
        f26722a = str;
        b = str2;
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] strArrI = i(context);
            jSONObject2.put("3", (strArrI == null || strArrI.length != 2 || TextUtils.isEmpty(strArrI[0]) || TextUtils.isEmpty(strArrI[1])) ? "985050001" : strArrI[0]);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, "mshield");
            jSONObject2.put("9", "4.2.6");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map != null && map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report report = Report.getInstance(context);
            String string = jSONObject.toString();
            com.baidu.mshield.b.c.a.b("sendEventUDC:" + string);
            report.s(string);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void b(Context context, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("Common_section");
            long jOptLong = jSONObjectOptJSONObject.optLong("0");
            String strOptString = jSONObjectOptJSONObject.optString("10");
            int iOptInt = jSONObjectOptJSONObject.optInt("5");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("6");
            int iOptInt3 = jSONObjectOptJSONObject.optInt("7");
            int iOptInt4 = jSONObjectOptJSONObject.optInt("11");
            String strOptString2 = jSONObjectOptJSONObject.optString("12", "");
            if (iOptInt2 == 0) {
                iOptInt2 = 1;
            }
            com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
            aVar.d = str;
            aVar.b = strOptString;
            aVar.g = iOptInt;
            aVar.c = 3;
            aVar.e = jOptLong;
            aVar.f = iOptInt2;
            aVar.h = iOptInt3;
            aVar.i = iOptInt4;
            aVar.j = strOptString2;
            b.a(context).a(aVar);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] strArrI = i(context);
            if (strArrI.length == 2) {
                if (TextUtils.isEmpty(strArrI[0]) || TextUtils.isEmpty(strArrI[1]) || !"200080".equals(strArrI[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                    return;
                }
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 246);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context, com.baidu.mshield.rp.b.a aVar, String str, boolean z) {
        return a(context, aVar.f26712a, aVar.c, z ? aVar.d : aVar.e, str);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        b.a(context).a(false);
        b.a(context).e();
        com.baidu.mshield.rp.b.a aVar = new com.baidu.mshield.rp.b.a();
        aVar.f26712a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.d = str4;
        aVar.e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        List<com.baidu.mshield.rp.b.a> listP = aVarA.p();
        if (listP == null || !listP.contains(aVar)) {
            aVarA.a(aVar);
            if (!aVarA.e(aVar.e)) {
                b.a(context).a(aVar);
            }
            b.a(context).b();
            b.a(context).d();
            return;
        }
        aVarA.a(listP, aVar);
        b.a(context).b();
    }

    public static void a(Context context, String str) {
        String strValueOf = "";
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("0");
                if (jSONObjectOptJSONObject != null) {
                    String strValueOf2 = "";
                    while (jSONObjectOptJSONObject.keys().hasNext()) {
                        strValueOf2 = String.valueOf(jSONObjectOptJSONObject.keys().next());
                        if (!TextUtils.isEmpty(strValueOf2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        aVarA.a(strValueOf2, jSONObjectOptJSONObject.optString(strValueOf2));
                    }
                }
            } catch (Throwable th) {
                a(th);
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("1");
                if (jSONObjectOptJSONObject2 != null) {
                    while (jSONObjectOptJSONObject2.keys().hasNext()) {
                        strValueOf = String.valueOf(jSONObjectOptJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(strValueOf)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(strValueOf)) {
                        aVarA.b(strValueOf, jSONObjectOptJSONObject2.optString(strValueOf));
                    }
                }
            } catch (Throwable th2) {
                a(th2);
            }
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("2");
                if (jSONArrayOptJSONArray != null) {
                    com.baidu.mshield.b.c.a.b("setAliveData rp= " + jSONArrayOptJSONArray.toString());
                    aVarA.f(jSONArrayOptJSONArray.toString());
                }
            } catch (Throwable th3) {
                a(th3);
            }
        } catch (Throwable th4) {
            a(th4);
        }
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] strArrI = i(context);
            if (strArrI.length == 2) {
                jSONObject2.put("3", strArrI[0]);
            } else {
                jSONObject2.put("3", "985050001");
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, str);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject3 = new JSONObject(str4);
                } catch (Throwable th) {
                    a(th);
                }
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable th2) {
            a(th2);
        }
        return jSONObject;
    }

    public static void a(Context context, long j) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            new Intent("com.b.r.p").setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 201326592);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                a(th);
            }
            try {
                alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
            } catch (Throwable th2) {
                a(th2);
            }
        } catch (Throwable th3) {
            a(th3);
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        long jOptLong;
        String strOptString;
        String str;
        String str2;
        String str3;
        String strOptString2;
        String str4;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2 = jSONObject.getJSONObject("Common_section");
        } catch (Throwable th) {
            a(th);
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            String strOptString3 = jSONObject2.optString("10");
            jOptLong = jSONObject2.optLong("0");
            String strOptString4 = jSONObject2.optString("1");
            String strOptString5 = jSONObject2.optString("3");
            strOptString2 = jSONObject2.optString(PrepareException.ERROR_AUTH_FAIL);
            str3 = strOptString5;
            str2 = strOptString4;
            str = strOptString3;
            strOptString = jSONObject2.optString("9");
        } else {
            jOptLong = jCurrentTimeMillis;
            strOptString = "";
            str = strOptString;
            str2 = str;
            str3 = str2;
            strOptString2 = str3;
        }
        try {
            String string = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            try {
                str5 = string;
                str4 = "";
                try {
                    str7 = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionName;
                    str6 = str5;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        a(th);
                        str6 = str5;
                        str7 = str4;
                    } catch (Throwable th3) {
                        a(th3);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                str5 = string;
                str4 = "";
            }
        } catch (Throwable th5) {
            th = th5;
            str4 = "";
            str5 = str4;
        }
        jSONObject3.put("1", str6);
        jSONObject3.put("2", com.baidu.mshield.core.a.a("p"));
        jSONObject3.put("3", str7);
        jSONObject3.put("4", c.b(context));
        jSONObject3.put("5", str);
        jSONObject3.put("6", jOptLong);
        jSONObject3.put("7", str2);
        jSONObject3.put(PrepareException.ERROR_AUTH_FAIL, str3);
        jSONObject3.put("9", strOptString2);
        jSONObject3.put("10", strOptString);
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        jSONObject3.put("11", aVarA.o());
        jSONObject3.put("12", aVarA.t());
        jSONObject3.put("13", 0);
        jSONObject3.put("14", com.baidu.mshield.core.a.a("ws"));
        jSONObject3.put("20", c.j(context));
        jSONObject3.put("21", c.d(context));
        jSONObject3.put("22", c.h(context));
        String strR = aVarA.r();
        if (TextUtils.isEmpty(strR)) {
            try {
                strR = com.baidu.xclient.gdid.a.c(context);
                if (TextUtils.isEmpty(strR)) {
                    strR = str4;
                }
                aVarA.j(strR);
            } catch (Throwable unused) {
            }
        }
        jSONObject3.put("23", strR);
        jSONObject3.put("25", com.baidu.mshield.rp.a.b(context));
        jSONObject3.put("26", com.baidu.mshield.rp.a.a(context));
        jSONObject3.put("27", com.baidu.mshield.rp.a.c(context));
        jSONObject3.put("28", EngineImpl.getInstance(context).getNui());
        jSONObject3.put("30", str4);
        Object obj = jSONObject.get("Module_section");
        if (obj instanceof JSONArray) {
            jSONObject3.put("module_section", obj);
        } else {
            jSONObject3.put("module_section", new JSONArray().put(obj));
        }
        return jSONObject3;
    }

    public static int a(Context context) {
        try {
            String strE = e(context);
            if (TextUtils.isEmpty(c)) {
                c = a(Process.myPid());
            }
            if (TextUtils.isEmpty(c)) {
                return 0;
            }
            if (TextUtils.isEmpty(strE)) {
                return context.getPackageName().equals(c) ? 3 : 4;
            }
            return strE.equals(c) ? 1 : 2;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static String a(int i) {
        String processName;
        String strA = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                try {
                    if (!TextUtils.isEmpty(processName)) {
                        com.baidu.mshield.b.c.a.b("getProcessName return by P+:" + processName);
                        return processName.trim();
                    }
                } catch (Throwable th) {
                    th = th;
                    strA = processName;
                    a(th);
                }
            } else {
                processName = null;
            }
            try {
                Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD, false, Application.class.getClassLoader()).getDeclaredMethod(TRiverConstants.KEY_CURRENT_PROCESS_NAME, new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                if (objInvoke instanceof String) {
                    processName = (String) objInvoke;
                }
                if (!TextUtils.isEmpty(processName)) {
                    com.baidu.mshield.b.c.a.b("getProcessName return by reflect:" + processName);
                    return processName.trim();
                }
            } catch (Throwable th2) {
                a(th2);
            }
            strA = a(String.format("/proc/%d/cmdline", Integer.valueOf(i)));
            if (!TextUtils.isEmpty(strA)) {
                com.baidu.mshield.b.c.a.b("getProcessName return by cmdline:" + strA);
                return strA.trim();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return strA;
    }

    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String strA = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                    a(th);
                }
                return strA;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            a(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append('\n');
                }
                sb.append(line);
            } else {
                return sb.toString();
            }
        }
    }
}
