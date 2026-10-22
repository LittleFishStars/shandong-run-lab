package com.baidu.mshield.x0.i;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.RVParams;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.f.f;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.mshield.b.d.a {
    public b c;

    public a(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public HashMap<String, String> b() {
        HashMap<String, String> map;
        String strA;
        String str;
        HashMap<String, String> map2 = new HashMap<>();
        String strOptString = "";
        try {
            byte[] bArrD = d.d();
            try {
                strA = this.c.a(URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.d(bArrD, e.a(com.baidu.mshield.utility.c.b(this.b)).getBytes()), 0)));
            } catch (Throwable th) {
                d.a(th);
                strA = "";
            }
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(this.b);
                    jSONObject2.put(RVParams.SHOW_OPTION_MENU, aVar.p());
                    jSONObject.put("jwl", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    String strC = aVar.c("plc114");
                    String str2 = strA;
                    if (TextUtils.isEmpty(strC)) {
                        jSONObject4.put("4", "0");
                        jSONObject4.put("5", "0");
                        jSONObject4.put("6", "0");
                    } else {
                        JSONObject jSONObject5 = new JSONObject(strC);
                        if (jSONObject5.has("5") && jSONObject5.optJSONObject("5").has("uv6")) {
                            String strOptString2 = jSONObject5.optJSONObject("5").optJSONObject("uv6").optString("4", "");
                            String strOptString3 = jSONObject5.optJSONObject("5").optJSONObject("uv6").optString("5", "");
                            String strOptString4 = jSONObject5.optJSONObject("5").optJSONObject("uv6").optString("6", "");
                            jSONObject4.put("4", strOptString2);
                            jSONObject4.put("5", strOptString3);
                            jSONObject4.put("6", strOptString4);
                        }
                    }
                    jSONObject3.put("uv6", jSONObject4);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("4", "");
                    String strC2 = aVar.c("plc115");
                    if (!TextUtils.isEmpty(strC2)) {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(strC2).optJSONObject("5");
                        if (jSONObjectOptJSONObject.has("uv4") && jSONObjectOptJSONObject.optJSONObject("uv4").has("4")) {
                            jSONObject6.put("4", jSONObjectOptJSONObject.optJSONObject("uv4").optString("4"));
                        }
                    }
                    jSONObject3.put("uv4", jSONObject6);
                    jSONObject.put("sec", jSONObject3);
                    try {
                        String strY = new com.baidu.mshield.x6.b.b(this.b).y();
                        if (!TextUtils.isEmpty(strY)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("ver", strY);
                            jSONObject.put("sig", jSONObject7);
                        }
                    } catch (Throwable th2) {
                        d.a(th2);
                    }
                    try {
                        com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.b);
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("1", bVar.x());
                        String strL = bVar.L();
                        if (TextUtils.isEmpty(strL)) {
                            String strA2 = g.a(this.b);
                            com.baidu.mshield.b.c.a.b(" manufacturer: " + strA2.toLowerCase());
                            if (!TextUtils.isEmpty(strA2)) {
                                strL = e.a(strA2.toLowerCase());
                                bVar.l(strL);
                            }
                        }
                        jSONObject8.put("2", strL);
                        String strM = bVar.M();
                        if (TextUtils.isEmpty(strM)) {
                            String propertyByType = EngineImpl.getInstance(this.b).getPropertyByType("mod");
                            com.baidu.mshield.b.c.a.b(" model: " + propertyByType.toLowerCase());
                            if (!TextUtils.isEmpty(propertyByType)) {
                                strM = e.a(propertyByType.toLowerCase());
                                bVar.m(strM);
                            }
                        }
                        jSONObject8.put("3", strM);
                        String strS = bVar.s();
                        if (TextUtils.isEmpty(strS)) {
                            String lowerCase = Build.ID.toLowerCase();
                            com.baidu.mshield.b.c.a.b(" buildId: " + lowerCase);
                            strS = e.a(lowerCase);
                            bVar.d(strS);
                        }
                        jSONObject8.put("4", strS);
                        String strD = bVar.d();
                        if (TextUtils.isEmpty(strD)) {
                            String strB = g.b(this.b);
                            com.baidu.mshield.b.c.a.b(" romName: " + strB.toLowerCase());
                            if (!TextUtils.isEmpty(strB)) {
                                strD = e.a(strB.toLowerCase());
                                bVar.t(strD);
                            }
                        }
                        jSONObject8.put("5", strD);
                        String strE = bVar.e();
                        if (TextUtils.isEmpty(strE)) {
                            String strC3 = g.c(this.b);
                            com.baidu.mshield.b.c.a.b(" romVersion: " + strC3.toLowerCase());
                            if (!TextUtils.isEmpty(strC3)) {
                                strE = e.a(strC3.toLowerCase());
                                bVar.u(strE);
                            }
                        }
                        jSONObject8.put("6", strE);
                        String strT = bVar.t();
                        if (TextUtils.isEmpty(strT)) {
                            String propertyByType2 = EngineImpl.getInstance(this.b).getPropertyByType("arv");
                            com.baidu.mshield.b.c.a.b(" romVersion: " + propertyByType2.toLowerCase());
                            if (!TextUtils.isEmpty(propertyByType2)) {
                                strT = e.a(propertyByType2.toLowerCase());
                                bVar.e(strT);
                            }
                        }
                        jSONObject8.put("7", strT);
                        String strD2 = f.d(this.b);
                        if (TextUtils.isEmpty(strD2)) {
                            jSONObject8.put("9", "");
                        } else {
                            try {
                                jSONObject8.put("9", new JSONObject(strD2).optString("2", ""));
                            } catch (Throwable th3) {
                                d.a(th3);
                            }
                        }
                        jSONObject.put("f", jSONObject8);
                    } catch (Throwable th4) {
                        d.a(th4);
                    }
                    try {
                        jSONObject.put("prv", "1");
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put("cu", d.i(this.b));
                        jSONObject9.put("zi", com.baidu.mshield.utility.c.b(this.b));
                        jSONObject9.put("cuw", new com.baidu.mshield.x6.b.c(this.b).a());
                        jSONObject.put("ids", jSONObject9);
                    } catch (Throwable th5) {
                        d.a(th5);
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    String string = d.a(this.b, "1044103", jSONArray).toString();
                    byte[] bArrA = this.c.a(bArrD, string);
                    com.baidu.mshield.b.c.a.b("getPolicy: " + string);
                    String strA3 = a(str2, bArrA);
                    new com.baidu.mshield.x6.b.b(this.b).a(System.currentTimeMillis(), !TextUtils.isEmpty(strA3));
                    com.baidu.mshield.b.c.a.b("get policy r: " + strA3);
                    if (TextUtils.isEmpty(strA3)) {
                        return null;
                    }
                    try {
                        JSONObject jSONObject10 = new JSONObject(strA3);
                        String strOptString5 = jSONObject10.optString("skey");
                        strOptString = jSONObject10.optString("data");
                        str = new String(com.baidu.mshield.b.a.c.b(com.baidu.mshield.b.f.d.a(Base64.decode(strOptString.getBytes(), 0), com.baidu.mshield.b.f.d.c(Base64.decode(strOptString5.getBytes(), 0), a().getBytes()))));
                    } catch (Throwable th6) {
                        d.a(th6);
                        str = strOptString;
                    }
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    com.baidu.mshield.b.c.a.b("policy d: " + str);
                    map2.put("url", str2);
                    map2.put("source", strA3);
                    map2.put("decrpt", str);
                    return map2;
                } catch (Throwable th7) {
                    th = th7;
                    map = null;
                    d.a(th);
                    return map;
                }
            } catch (Throwable th8) {
                d.a(th8);
                return null;
            }
        } catch (Throwable th9) {
            th = th9;
            map = null;
            d.a(th);
            return map;
        }
    }
}
