package com.baidu.mshield.x0.g;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.h.b;
import com.baidu.mshield.x6.EngineImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26747a = -1;
    public static int b = -1;
    public static String c = "";
    public static long d = -1;
    public static long e;
    public static Map<Integer, Boolean> f = new HashMap(100);

    public static String a(Context context, String str, int i, String str2) {
        synchronized (a.class) {
            try {
                com.baidu.mshield.b.c.a.b("accountId: " + str + " eventId: " + i);
                com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
                ArrayList arrayList = new ArrayList();
                try {
                    String strA = d.a(context, aVar, "plc104", "7");
                    if (!TextUtils.isEmpty(strA)) {
                        JSONArray jSONArray = new JSONArray(strA);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.getString(i2));
                        }
                    }
                } catch (Throwable th) {
                    d.a(th);
                }
                if (d == -1) {
                    d = aVar.f();
                }
                if (e == 0) {
                    e = aVar.i();
                }
                if (!arrayList.contains(String.valueOf(i))) {
                    return "";
                }
                if (f.get(Integer.valueOf(i)) == null && f.size() <= 100) {
                    f.put(Integer.valueOf(i), Boolean.TRUE);
                } else if (System.currentTimeMillis() - e < d * 1000) {
                    return "";
                }
                new com.baidu.mshield.x0.h.a().a(context, 2, 0, 0L);
                EngineImpl.getInstance(context).bdsd(4, false);
                aVar.b(System.currentTimeMillis());
                e = System.currentTimeMillis();
            } catch (Throwable th2) {
                d.a(th2);
            }
            return "";
        }
    }

    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            boolean zA = d.a(context, "plc16", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_APP_DEBUG  status : " + zA);
            if (!zA) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = (String) com.baidu.xclient.gdid.a.a(18, d.h(context), (Object) null, (Object) null);
            com.baidu.mshield.b.c.a.b("jni debug result=" + str + ", time cost=" + (System.currentTimeMillis() - jCurrentTimeMillis));
            StringBuilder sb = new StringBuilder();
            sb.append("Debug.isDebuggerConnected()=");
            sb.append(Debug.isDebuggerConnected());
            com.baidu.mshield.b.c.a.b(sb.toString());
            if (!TextUtils.isEmpty(str)) {
                str.startsWith("1");
            }
            String strA = TextUtils.isEmpty(str) ? " " : e.a(str);
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strB = aVar.b("n_l_c_n_k_i_d");
            aVar.a("n_l_c_n_k_i_d", strA);
            com.baidu.mshield.b.c.a.b("report debug : 2 compare: " + strB + " : " + strA + ":-" + str);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("2", str);
            return (strA == null || strA.equalsIgnoreCase(strB)) ? false : true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static boolean c(Context context, JSONObject jSONObject) {
        try {
            boolean zA = d.a(context, "plc20", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_USB_DEBUG  status : " + zA);
            if (zA) {
                b = d.o(context) ? 1 : 0;
                com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
                String strB = aVar.b("n_l_c_n_k_d_m");
                String strValueOf = String.valueOf(b);
                aVar.a("n_l_c_n_k_d_m", strValueOf);
                com.baidu.mshield.b.c.a.b("report debug : 7 compare: " + strB + " : " + strValueOf);
                jSONObject.put("7", strValueOf);
                StringBuilder sb = new StringBuilder();
                sb.append("getSafetyFactor isDebugMode finish Time:");
                sb.append(b);
                com.baidu.mshield.b.c.a.b(sb.toString());
                if (!strValueOf.equalsIgnoreCase(strB)) {
                    return true;
                }
            } else {
                b = -1;
            }
            return false;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static void d(Context context, JSONObject jSONObject) {
        try {
            if (d.a(context, "plc36", true)) {
                jSONObject.put("30", String.valueOf(b.e(context)));
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void e(Context context, JSONObject jSONObject) {
        try {
            int i = 1;
            if (!d.a(context, "plc03", true)) {
                f26747a = -1;
                return;
            }
            com.baidu.mshield.b.c.a.b("injectStatus is true");
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = (String) com.baidu.xclient.gdid.a.a(19, context.getPackageName(), d.h(context), Integer.valueOf(aVar.g()));
            com.baidu.mshield.b.c.a.b("jni inject result=" + str + " , time cost=" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("1")) {
                    i = str.startsWith("-1") ? -1 : 0;
                }
                f26747a = i;
                com.baidu.mshield.b.c.a.b("injectRet is not empty, isjnject: " + f26747a);
            }
            jSONObject.put("1", TextUtils.isEmpty(str) ? "" : str);
            com.baidu.mshield.b.c.a.b("getSafetyFactor isInject finish Time: " + str);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.b("load jni lib fail: " + th);
            d.a(th);
        }
    }

    public static void f(Context context, JSONObject jSONObject) {
        String strB;
        try {
            if (d.a(context, "plc84", true)) {
                try {
                    strB = b.b(context);
                } catch (Throwable th) {
                    d.a(th);
                    strB = "";
                }
                jSONObject.put("71", strB);
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    public static void g(Context context, JSONObject jSONObject) {
        try {
            if (d.a(context, "plc71", false)) {
                jSONObject.put("59", a(b.d(context)));
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static boolean h(Context context, JSONObject jSONObject) {
        try {
            boolean zA = d.a(context, "plc18", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_PROXY  status : " + zA);
            if (zA) {
                c = d.a();
                com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
                String strB = aVar.b("n_l_c_n_k_p_p");
                String strA = TextUtils.isEmpty(c) ? " " : e.a(c);
                aVar.a("n_l_c_n_k_p_p", strA);
                com.baidu.mshield.b.c.a.b("report debug : 10 compare: " + strB + " : " + strA);
                jSONObject.put("10", c);
                if (strA != null && !strA.equalsIgnoreCase(strB)) {
                    return true;
                }
            } else {
                c = "";
            }
            com.baidu.mshield.b.c.a.b("getSafetyFactor proxyIp finish Time:" + c);
            return false;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static boolean i(Context context, JSONObject jSONObject) {
        String[] strArr;
        try {
            boolean zA = d.a(context, "plc15", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_SAFE_SCAN_COMMON status : " + zA);
            if (zA) {
                JSONObject jSONObjectG = d.g(context);
                com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
                String strB = aVar.b("n_l_c_n_k_i_r");
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    strArr = d.b;
                    if (i >= strArr.length) {
                        break;
                    }
                    sb.append(jSONObjectG.opt(Integer.toString(i)));
                    i++;
                }
                sb.append(jSONObjectG.opt(Integer.toString(strArr.length)));
                sb.toString().contains("1");
                String strA = e.a(sb.toString());
                aVar.a("n_l_c_n_k_i_r", strA);
                com.baidu.mshield.b.c.a.b("report debug : 12 compare: " + strB + " : " + strA);
                jSONObject.put("12", jSONObjectG);
                if (strA != null && !strA.equalsIgnoreCase(strB)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return false;
    }

    public static void j(Context context, JSONObject jSONObject) {
        try {
            boolean zA = d.a(context, "plc83", true);
            com.baidu.mshield.b.c.a.b("new roo=" + zA);
            if (zA) {
                jSONObject.put("69", "");
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str = (String) com.baidu.xclient.gdid.a.a(20, (Object) null, (Object) null, (Object) null);
                com.baidu.mshield.b.c.a.b("jni root result=" + str + " , time cost=" + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                jSONObject.put("69", str);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        e(context, jSONObject);
        b(context, jSONObject);
        c(context, jSONObject);
        i(context, jSONObject);
        d(context, jSONObject);
        f(context, jSONObject);
        g(context, jSONObject);
        h(context, jSONObject);
        j(context, jSONObject);
    }

    public static String a(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(l.b);
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
