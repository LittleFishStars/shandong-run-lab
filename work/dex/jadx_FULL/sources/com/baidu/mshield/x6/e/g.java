package com.baidu.mshield.x6.e;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.x6.EngineImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26766a;

    public g(Context context, int i) {
        this.f26766a = context;
    }

    public JSONObject a() {
        try {
            return b();
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public final JSONObject b() {
        String strOptString;
        String str;
        String str2;
        String strOptString2 = "";
        try {
            JSONObject jSONObjectA = com.baidu.xclient.gdid.a.a();
            com.baidu.mshield.b.c.a.a("praseJsonData jsonObject=" + jSONObjectA);
            if (jSONObjectA != null) {
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f26766a);
                jSONObjectA.put("15004", com.baidu.mshield.x6.f.f.a());
                jSONObjectA.put("15101", EngineImpl.getInstance(this.f26766a).getPropertyByType("cuid"));
                jSONObjectA.put("15110", EngineImpl.getInstance(this.f26766a).getPropertyByType("aid"));
                jSONObjectA.put("15018", EngineImpl.getInstance(this.f26766a).getPropertyByType(EngineImpl.KEY_OAID));
                String propertyByType = EngineImpl.getInstance(this.f26766a).getPropertyByType("sl");
                jSONObjectA.put("07001", propertyByType);
                jSONObjectA.put("02037", com.baidu.mshield.x6.f.f.a(this.f26766a) ? "1" : "0");
                jSONObjectA.put("17001", com.baidu.mshield.x6.c.b.a());
                jSONObjectA.put("06005", a(this.f26766a));
                com.baidu.mshield.b.c.a.b("07001 sensor list=" + propertyByType);
                try {
                    jSONObjectA.put("15100", com.baidu.mshield.x6.f.f.g(this.f26766a));
                    boolean zA = a.a(this.f26766a, com.baidu.mshield.x6.b.b.n);
                    jSONObjectA.put("15090", zA && a.a(this.f26766a, com.baidu.mshield.x6.b.b.n, "2", true) ? "1" : "0");
                    jSONObjectA.put("15093", zA ? "1" : "0");
                    jSONObjectA.put("15099", bVar.C() ? "0" : "1");
                } catch (Throwable th) {
                    com.baidu.mshield.x6.f.f.b(th);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("3", EngineImpl.getInstance(this.f26766a).getPropertyByType("p"));
                jSONObject.put("4", EngineImpl.getInstance(this.f26766a).getPropertyByType("s"));
                EngineImpl.getInstance(this.f26766a).getSecApi().a(this.f26766a, jSONObject);
                jSONObjectA.put("1011105", jSONObject);
                try {
                    String strB = com.baidu.mshield.x6.f.f.b(this.f26766a);
                    if (TextUtils.isEmpty(strB)) {
                        str2 = "";
                        strOptString = str2;
                    } else {
                        JSONObject jSONObject2 = new JSONObject(strB);
                        String strOptString3 = jSONObject2.optString("1");
                        if (TextUtils.isEmpty(strOptString3)) {
                            str = "";
                        } else {
                            str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(strOptString3.getBytes(), 0)), "utf-8");
                            com.baidu.mshield.b.c.a.a("getJsonDataPart18 ungzDrf : " + str);
                        }
                        try {
                            strOptString = jSONObject2.optString("3");
                            try {
                                strOptString2 = jSONObject2.optString("2");
                            } catch (Throwable th2) {
                                th = th2;
                                com.baidu.mshield.x6.f.f.b(th);
                                try {
                                    jSONObjectA.put("15094", com.baidu.mshield.x6.f.f.a(th));
                                } catch (Throwable th3) {
                                    com.baidu.mshield.x6.f.f.b(th3);
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            strOptString = "";
                        }
                        str2 = strOptString2;
                        strOptString2 = str;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    strOptString = "";
                    str = strOptString;
                }
                jSONObjectA.put("15091", TextUtils.isEmpty(strOptString2) ? "0" : "1");
                jSONObjectA.put("15082", str2 + "#" + bVar.E());
                jSONObjectA.put("15083", strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                    com.baidu.mshield.b.c.a.a("real machine sig is not empty");
                    com.baidu.mshield.b.c.a.a("getEmulatorResultPolicy datas===" + strOptString2);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> listA = com.baidu.mshield.x6.c.a.a(strOptString2);
                    jSONObjectA.put("d0005", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    JSONArray jSONArray = new JSONArray();
                    if (listA != null && listA.size() > 0) {
                        Iterator<String> it = listA.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next());
                        }
                        com.baidu.mshield.b.c.a.a("getEmulatorResult 15084===" + jSONArray);
                    }
                    jSONObjectA.put("15084", jSONArray);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObjectB = com.baidu.mshield.x6.c.a.b(strOptString2);
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    com.baidu.mshield.b.c.a.a("cpp param 2 result : " + jSONObjectB);
                    jSONObjectA.put("d0006", String.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2));
                    jSONObjectA.put("15085", jSONObjectB.toString());
                }
                if (a.a(this.f26766a, com.baidu.mshield.x6.b.b.o)) {
                    String strC = com.baidu.mshield.x6.f.f.c(this.f26766a);
                    if (!TextUtils.isEmpty(strC)) {
                        com.baidu.mshield.b.c.a.a("getEmulatorResultPolicy===" + strC);
                        List<String> listA2 = com.baidu.mshield.x6.c.a.a(strC);
                        JSONArray jSONArray2 = new JSONArray();
                        if (listA2 != null && listA2.size() > 0) {
                            Iterator<String> it2 = listA2.iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put(it2.next());
                            }
                            com.baidu.mshield.b.c.a.a("getEmulatorResult 14001===" + jSONArray2);
                        }
                        jSONObjectA.put("14001", jSONArray2);
                    }
                }
                jSONObjectA.put("15086", com.baidu.mshield.x6.f.f.e() + "#" + com.baidu.mshield.x6.f.f.d());
            }
            return jSONObjectA;
        } catch (Throwable th6) {
            a(th6);
            return null;
        }
    }

    public final void a(Throwable th) {
        com.baidu.mshield.x6.f.f.b(th);
    }

    public static String a(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return null;
            }
            String stringExtra = intentRegisterReceiver.getStringExtra("technology");
            return TextUtils.isEmpty(stringExtra) ? "unknown" : stringExtra;
        } catch (Exception e) {
            com.baidu.mshield.x6.f.f.b(e);
            return null;
        }
    }
}
