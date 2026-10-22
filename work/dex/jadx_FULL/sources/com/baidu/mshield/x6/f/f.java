package com.baidu.mshield.x6.f;

import android.content.Context;
import android.nfc.NfcManager;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {
    public static String a() {
        String str = EngineImpl.sAppkey;
        return str != null ? str : "";
    }

    public static String b() {
        String str = EngineImpl.sSecKey;
        return str != null ? str : "";
    }

    public static String c() {
        try {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return a(context, false) ? new com.baidu.mshield.x6.b.b(context).g() : l.e;
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String e(Context context) {
        try {
            return MH.getVersion(context);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String f(Context context) {
        try {
            return new String(h.a(Base64.decode(g.b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String g(Context context) {
        String strB = "";
        try {
            com.baidu.mshield.x6.b.c cVar = new com.baidu.mshield.x6.b.c(context);
            strB = cVar.b();
            if (TextUtils.isEmpty(strB)) {
                com.baidu.mshield.b.c.a.a("cloud token is empty");
                strB = cVar.e();
            }
            com.baidu.mshield.b.c.a.a("getUserHoldToken : " + strB);
        } catch (Throwable th) {
            b(th);
        }
        return strB;
    }

    public static void h(Context context) {
        try {
            b.c(context);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jO = ((long) bVar.o()) * 60000;
            long jK = bVar.K();
            if (!bVar.n() || jCurrentTimeMillis - jK > jO) {
                com.baidu.mshield.x6.e.h.a(context).a(3);
            }
            if (!bVar.f()) {
                j(context);
                bVar.d(true);
            }
            com.baidu.mshield.x6.e.h.a(context).a(1, false);
            if (bVar.a()) {
                return;
            }
            com.baidu.mshield.x6.e.h.a(context).a();
        } catch (Throwable th) {
            b(th);
        }
    }

    public static void i(Context context) {
        try {
            String strA = l.a(context);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            if (TextUtils.isEmpty(strA)) {
                bVar.a(System.currentTimeMillis(), false);
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            try {
                String strOptString = jSONObject.optString("sig");
                if (TextUtils.isEmpty(strOptString)) {
                    com.baidu.mshield.b.c.a.a("sig sdata is empty ");
                } else {
                    String strA2 = com.baidu.mshield.b.f.e.a(strOptString);
                    l.c = strA2;
                    bVar.h(strA2);
                    String str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(strOptString.getBytes(), 0)), "utf-8");
                    com.baidu.mshield.b.c.a.a("requestSigPolicy ungzSig : " + str);
                    l.f26771a = str;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sgs");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("3", "");
                    l.b = strOptString2;
                    com.baidu.mshield.b.c.a.a("requestSgsPolicy : " + strOptString2);
                }
            } catch (Throwable th) {
                b(th);
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("drf");
                if (jSONObjectOptJSONObject2 != null) {
                    l.d = jSONObjectOptJSONObject2.toString();
                    com.baidu.mshield.b.c.a.a("requestSigPolicy ungzDrf : " + new String(com.baidu.mshield.b.a.c.b(Base64.decode(jSONObjectOptJSONObject2.optString("1").getBytes(), 0)), "utf-8"));
                    bVar.g(jSONObjectOptJSONObject2.optString("2"));
                } else {
                    l.d = "";
                }
            } catch (Throwable th2) {
                b(th2);
            }
            bVar.a(System.currentTimeMillis(), true);
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("rmf");
                if (jSONObjectOptJSONObject3 == null) {
                    l.e = "";
                    return;
                }
                if (a(context, false)) {
                    bVar.v(jSONObjectOptJSONObject3.toString());
                    l.e = "";
                } else {
                    l.e = jSONObjectOptJSONObject3.toString();
                    bVar.p();
                }
                com.baidu.mshield.b.c.a.a("requestSigPolicy ungzRmf : " + new String(com.baidu.mshield.b.a.c.b(Base64.decode(jSONObjectOptJSONObject3.optString("1").getBytes(), 0)), "utf-8"));
            } catch (Throwable th3) {
                b(th3);
            }
        } catch (Throwable th4) {
            b(th4);
        }
    }

    public static void j(Context context) {
        try {
            String strA = com.baidu.mshield.x6.c.a.a(context);
            String strB = com.baidu.mshield.x6.c.a.b(context);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            if (!TextUtils.isEmpty(strA)) {
                bVar.o(com.baidu.mshield.b.f.e.a(strA));
            }
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            bVar.n(com.baidu.mshield.b.f.e.a(strB));
        } catch (Throwable th) {
            b(th);
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str, String str2, boolean z) {
        String str3;
        String string;
        JSONObject jSONObject2 = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            str3 = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionName;
            try {
                string = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            } catch (Throwable th) {
                th = th;
                try {
                    b(th);
                    string = "";
                } catch (Throwable th2) {
                    b(th2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = "";
        }
        jSONObject2.put("1", string);
        jSONObject2.put("2", EngineImpl.getInstance(context).getPropertyByType("p"));
        jSONObject2.put("3", str3);
        jSONObject2.put("4", com.baidu.mshield.utility.c.b(context));
        jSONObject2.put("5", str);
        jSONObject2.put("6", jCurrentTimeMillis);
        jSONObject2.put("7", "");
        jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, a());
        String str4 = EngineImpl.sLoadVersion;
        if (TextUtils.isEmpty(str4)) {
            jSONObject2.put("9", str2);
            jSONObject2.put("10", "0");
        } else {
            String[] strArrSplit = str4.split(WVNativeCallbackUtil.SEPERATER);
            if (strArrSplit.length == 2) {
                jSONObject2.put("9", strArrSplit[0]);
                jSONObject2.put("10", strArrSplit[1]);
            } else if (strArrSplit.length == 1) {
                jSONObject2.put("9", str2);
                jSONObject2.put("10", strArrSplit[0]);
            } else {
                jSONObject2.put("9", str2);
                jSONObject2.put("10", "0");
            }
        }
        jSONObject2.put("11", "");
        jSONObject2.put("12", "");
        jSONObject2.put("13", 1);
        jSONObject2.put("14", EngineImpl.getInstance(context).getPropertyByType("ws"));
        if (jSONObject != null) {
            jSONObject.put("989", e(context));
            jSONObject2.put("module_section", new JSONArray().put(jSONObject));
        }
        return jSONObject2;
    }

    public static void b(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(l.d)) {
            return l.d;
        }
        i(context);
        return l.d;
    }

    public static String e() {
        return l.b;
    }

    public static String d() {
        return l.c;
    }

    public static String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(com.baidu.mshield.b.f.a.b(str.getBytes(), com.baidu.mshield.b.f.a.a()), 0);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x005a A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:7:0x0009, B:8:0x0012, B:11:0x0019, B:39:0x005f, B:12:0x0020, B:31:0x0050, B:32:0x0052, B:33:0x0054, B:34:0x0056, B:35:0x0058, B:36:0x005a, B:37:0x005c, B:38:0x005e, B:40:0x0062), top: B:47:0x0009 }] */
    public static int c(String str) {
        int numericValue = -1;
        if (str != null && str != "") {
            try {
                char[] charArray = str.trim().toCharArray();
                int i = 0;
                while (i < charArray.length - 1) {
                    if (i == 0) {
                        numericValue = Character.getNumericValue(charArray[i]);
                    } else {
                        char c = charArray[i];
                        i++;
                        int numericValue2 = Character.getNumericValue(charArray[i]);
                        if (c == '%') {
                            numericValue %= numericValue2;
                        } else if (c == '&') {
                            numericValue &= numericValue2;
                        } else if (c == '*') {
                            numericValue *= numericValue2;
                        } else if (c == '+') {
                            numericValue += numericValue2;
                        } else if (c == '-') {
                            numericValue -= numericValue2;
                        } else if (c == '/') {
                            numericValue /= numericValue2;
                        } else if (c == '^') {
                            numericValue ^= numericValue2;
                        } else if (c != 'x') {
                            numericValue = c != '|' ? numericValue2 : numericValue | numericValue2;
                        } else {
                            numericValue *= numericValue2;
                        }
                    }
                    i++;
                }
                com.baidu.mshield.b.c.a.a("illegalArithmetic expr：" + str + "，res：" + numericValue);
            } catch (Throwable th) {
                b(th);
            }
            return numericValue;
        }
        com.baidu.mshield.b.c.a.a("illegalArithmetic expr is empty : " + str);
        return -1;
    }

    public static String c(Context context) {
        try {
            if (!TextUtils.isEmpty(l.f26771a)) {
                return l.f26771a;
            }
            i(context);
            return l.f26771a;
        } catch (Throwable th) {
            b(th);
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str, boolean z) {
        return a(context, jSONObject, str, "mshield_x6", z);
    }

    public static String a(String str, String str2, long j) throws UnsupportedEncodingException {
        return com.baidu.mshield.b.f.e.a(str + j + str2);
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            String strA = new com.baidu.mshield.x6.b.a(context).a(str);
            if (!TextUtils.isEmpty(strA)) {
                return new JSONObject(strA).optInt("1") == 1;
            }
        } catch (Throwable th) {
            b(th);
        }
        return z;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            try {
                if (cause instanceof UnknownHostException) {
                    return "";
                }
            } catch (Throwable th2) {
                b(th2);
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        printWriter.close();
        return string.replaceAll("\t", com.alipay.sdk.m.y.l.b).replaceAll("\n", com.alipay.sdk.m.y.l.b);
    }

    public static boolean a(Context context) {
        try {
            return ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter() != null;
        } catch (Throwable th) {
            b(th);
            return false;
        }
    }

    public static boolean a(Context context, boolean z) {
        try {
            String strA = a(context, "plc104");
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject = new JSONObject(strA).getJSONObject("5");
                if (jSONObject.has("34")) {
                    return jSONObject.optInt("34") == 1;
                }
            }
        } catch (Throwable th) {
            b(th);
        }
        return z;
    }

    public static String a(Context context, String str) {
        try {
            return new com.baidu.mshield.x6.b.a(context).a(str);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(com.baidu.mshield.b.f.a.a(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a()));
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }
}
