package com.baidu.mshield.x6.e;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.sdk.m.y.l;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.f.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26763a;
    public com.baidu.mshield.x6.b.c b;
    public int c;
    public int d;

    public e(Context context, int i) {
        this(context, i, 0);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0251 A[Catch: all -> 0x0266, TryCatch #3 {all -> 0x0266, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x025e A[Catch: all -> 0x0266, TryCatch #3 {all -> 0x0266, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:45:0x011c  */
    /* JADX WARN: Code duplicated, block: B:64:0x019f A[Catch: all -> 0x0266, TRY_LEAVE, TryCatch #3 {all -> 0x0266, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d5 A[Catch: all -> 0x0266, TRY_LEAVE, TryCatch #3 {all -> 0x0266, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x020f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0246 A[Catch: all -> 0x0266, TryCatch #3 {all -> 0x0266, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    public void a() {
        JSONObject jSONObject;
        com.baidu.mshield.x6.b.b bVar;
        long jCurrentTimeMillis;
        String strH;
        Object obj;
        String strD;
        String strB;
        JSONObject jSONObjectA;
        int iA;
        int i;
        try {
            synchronized (e.class) {
                try {
                    if (!com.baidu.mshield.b.e.a.d(this.f26763a)) {
                        com.baidu.mshield.b.c.a.a("run isCanRequestNetBackground=false");
                        return;
                    }
                    com.baidu.mshield.b.c.a.a("startzidcheck===" + this.c + l.b + h.b);
                    h.b = true;
                    Object objB = com.baidu.mshield.x6.f.b.b(this.f26763a);
                    String strB2 = this.b.b();
                    String strE = this.b.e();
                    String strC = this.b.c();
                    String strF = this.b.f();
                    String strD2 = this.b.d();
                    Object obj2 = strB2 + "#" + strC;
                    if (!TextUtils.isEmpty(strF) || TextUtils.isEmpty(strD2)) {
                        if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strD2)) {
                            try {
                                if (Long.parseLong(strD2) > Long.parseLong(strF) && !TextUtils.isEmpty(strC)) {
                                    strB2 = strC;
                                }
                            } catch (Throwable th) {
                                com.baidu.mshield.x6.f.f.b(th);
                            }
                        }
                        if (TextUtils.isEmpty(strB2) || TextUtils.isEmpty(strE)) {
                            strE = strB2;
                        }
                        Object objB2 = com.baidu.mshield.utility.c.b(this.f26763a);
                        jSONObject = new JSONObject();
                        jSONObject.put("token", strE);
                        jSONObject.put("ut", com.baidu.mshield.x6.f.f.g(this.f26763a));
                        jSONObject.put("magic", objB);
                        jSONObject.put("token_rt", this.b.f());
                        bVar = new com.baidu.mshield.x6.b.b(this.f26763a);
                        bVar.k(this.c);
                        Object objB3 = com.baidu.mshield.utility.c.b(this.f26763a);
                        jSONObject.put("mz", objB2);
                        jSONObject.put("ds", com.baidu.mshield.x6.f.b.a(this.f26763a));
                        jSONObject.put("zid", objB3);
                        jSONObject.put("act_st", String.valueOf(this.d));
                        jSONObject.put("chn_st", com.baidu.mshield.x6.f.f.a(this.f26763a, "plc95", false) ? "1" : "0");
                        jSONObject.put("os_ver", EngineImpl.getInstance(this.f26763a).getPropertyByType("arl"));
                        jCurrentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("1", bVar.J());
                        jSONObject2.put("2", bVar.K());
                        jSONObject2.put("3", jCurrentTimeMillis);
                        jSONObject2.put("4", bVar.m());
                        jSONObject.put(MediationConstant.KEY_REASON, jSONObject2);
                        jSONObject.put(RVParams.TITLE_PENETRATE, String.valueOf(this.c));
                        jSONObject.put("tk", obj2);
                        jSONObject.put("pd", String.valueOf(Process.myPid()));
                        jSONObject.put("lrc", String.valueOf(bVar.F()));
                        jSONObject.put(AliyunLogKey.KEY_VIDEO_CODEC, bVar.B());
                        strH = bVar.h();
                        if (!TextUtils.isEmpty(strH)) {
                            jSONObject.put("dc", String.valueOf(com.baidu.mshield.x6.f.d.a(bVar.i(), strH)));
                        }
                        jSONObject.put("lre", bVar.j());
                        if (bVar.z()) {
                            obj = "1";
                        } else {
                            obj = "0";
                        }
                        jSONObject.put("ipo", obj);
                        strD = com.baidu.mshield.x6.f.f.d(this.f26763a);
                        if (TextUtils.isEmpty(strD)) {
                            jSONObject.put("rmf", "");
                        } else {
                            try {
                                jSONObject.put("rmf", new JSONObject(strD).optString("2", ""));
                            } catch (Throwable th2) {
                                com.baidu.mshield.x6.f.f.b(th2);
                            }
                        }
                        a(jSONObject);
                        bVar.d(0);
                        strB = "";
                        try {
                            strB = com.baidu.mshield.utility.c.b(this.f26763a);
                        } catch (Throwable th3) {
                            com.baidu.mshield.x6.f.f.b(th3);
                        }
                        if (TextUtils.isEmpty(strB)) {
                            strB = "";
                        }
                        jSONObject.put("cuid", strB);
                        jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f26763a, jSONObject, com.baidu.mshield.x6.f.g.d, false);
                        iA = com.baidu.mshield.x6.f.l.a(this.f26763a, jSONObjectA.toString(), this.d);
                        for (i = 1; iA == -100 && i < 3; i++) {
                            Thread.sleep(2000L);
                            iA = com.baidu.mshield.x6.f.l.a(this.f26763a, jSONObjectA.toString(), this.d);
                        }
                        if (iA == -100) {
                            bVar.g(false);
                            if (com.baidu.mshield.b.a.d.b(this.f26763a)) {
                                f.b(this.f26763a).a(300000L);
                            }
                        } else {
                            bVar.c(jCurrentTimeMillis);
                            bVar.d(1);
                        }
                    } else {
                        if (!TextUtils.isEmpty(strC)) {
                            strB2 = strC;
                        }
                        if (TextUtils.isEmpty(strB2)) {
                            strE = strB2;
                        } else {
                            strE = strB2;
                        }
                        Object objB4 = com.baidu.mshield.utility.c.b(this.f26763a);
                        jSONObject = new JSONObject();
                        jSONObject.put("token", strE);
                        jSONObject.put("ut", com.baidu.mshield.x6.f.f.g(this.f26763a));
                        jSONObject.put("magic", objB);
                        jSONObject.put("token_rt", this.b.f());
                        bVar = new com.baidu.mshield.x6.b.b(this.f26763a);
                        bVar.k(this.c);
                        Object objB5 = com.baidu.mshield.utility.c.b(this.f26763a);
                        jSONObject.put("mz", objB4);
                        jSONObject.put("ds", com.baidu.mshield.x6.f.b.a(this.f26763a));
                        jSONObject.put("zid", objB5);
                        jSONObject.put("act_st", String.valueOf(this.d));
                        jSONObject.put("chn_st", com.baidu.mshield.x6.f.f.a(this.f26763a, "plc95", false) ? "1" : "0");
                        jSONObject.put("os_ver", EngineImpl.getInstance(this.f26763a).getPropertyByType("arl"));
                        jCurrentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("1", bVar.J());
                        jSONObject3.put("2", bVar.K());
                        jSONObject3.put("3", jCurrentTimeMillis);
                        jSONObject3.put("4", bVar.m());
                        jSONObject.put(MediationConstant.KEY_REASON, jSONObject3);
                        jSONObject.put(RVParams.TITLE_PENETRATE, String.valueOf(this.c));
                        jSONObject.put("tk", obj2);
                        jSONObject.put("pd", String.valueOf(Process.myPid()));
                        jSONObject.put("lrc", String.valueOf(bVar.F()));
                        jSONObject.put(AliyunLogKey.KEY_VIDEO_CODEC, bVar.B());
                        strH = bVar.h();
                        if (!TextUtils.isEmpty(strH)) {
                            jSONObject.put("dc", String.valueOf(com.baidu.mshield.x6.f.d.a(bVar.i(), strH)));
                        }
                        jSONObject.put("lre", bVar.j());
                        if (bVar.z()) {
                            obj = "1";
                        } else {
                            obj = "0";
                        }
                        jSONObject.put("ipo", obj);
                        strD = com.baidu.mshield.x6.f.f.d(this.f26763a);
                        if (TextUtils.isEmpty(strD)) {
                            jSONObject.put("rmf", "");
                        } else {
                            jSONObject.put("rmf", new JSONObject(strD).optString("2", ""));
                        }
                        a(jSONObject);
                        bVar.d(0);
                        strB = "";
                        strB = com.baidu.mshield.utility.c.b(this.f26763a);
                        if (TextUtils.isEmpty(strB)) {
                            strB = "";
                        }
                        jSONObject.put("cuid", strB);
                        jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f26763a, jSONObject, com.baidu.mshield.x6.f.g.d, false);
                        iA = com.baidu.mshield.x6.f.l.a(this.f26763a, jSONObjectA.toString(), this.d);
                        while (iA == -100) {
                            Thread.sleep(2000L);
                            iA = com.baidu.mshield.x6.f.l.a(this.f26763a, jSONObjectA.toString(), this.d);
                        }
                        if (iA == -100) {
                            bVar.g(false);
                            if (com.baidu.mshield.b.a.d.b(this.f26763a)) {
                                f.b(this.f26763a).a(300000L);
                            }
                        } else {
                            bVar.c(jCurrentTimeMillis);
                            bVar.d(1);
                        }
                    }
                    h.b = false;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            com.baidu.mshield.x6.f.f.b(th5);
        }
    }

    public e(Context context, int i, int i2) {
        this.f26763a = context;
        this.c = i;
        this.d = i2;
        this.b = new com.baidu.mshield.x6.b.c(context);
    }

    public final void a(JSONObject jSONObject) {
        String str;
        Throwable th;
        String strOptString;
        String str2;
        String str3;
        String strOptString2 = "";
        try {
            String strD = com.baidu.mshield.x6.f.f.d(this.f26763a);
            if (TextUtils.isEmpty(strD)) {
                str3 = "";
                str2 = str3;
            } else {
                JSONObject jSONObject2 = new JSONObject(strD);
                String strOptString3 = jSONObject2.optString("1");
                if (TextUtils.isEmpty(strOptString3)) {
                    str = "";
                } else {
                    str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(strOptString3.getBytes(), 0)), "utf-8");
                    com.baidu.mshield.b.c.a.a("doRmfDetect ungzDrf : " + str);
                }
                try {
                    strOptString = jSONObject2.optString("3");
                    try {
                        strOptString2 = jSONObject2.optString("2");
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.baidu.mshield.x6.f.f.b(th);
                            try {
                                jSONObject.put("15094", com.baidu.mshield.x6.f.f.a(th));
                            } catch (Throwable th3) {
                                com.baidu.mshield.x6.f.f.b(th3);
                            }
                        } catch (Throwable th4) {
                            com.baidu.mshield.x6.f.f.b(th4);
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    strOptString = "";
                }
                str2 = strOptString;
                str3 = strOptString2;
                strOptString2 = str;
            }
        } catch (Throwable th6) {
            str = "";
            th = th6;
            strOptString = str;
        }
        jSONObject.put("15091", !TextUtils.isEmpty(strOptString2) ? "1" : "0");
        com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f26763a);
        String strE = bVar.E();
        if (TextUtils.isEmpty(strE)) {
            strE = "#";
        }
        boolean zA = com.baidu.mshield.x6.f.f.a(this.f26763a, false);
        jSONObject.put("15082", str3 + "#" + strE + "#" + (zA ? 1 : 0));
        jSONObject.put("15083", str2);
        String strG = bVar.G();
        if (TextUtils.isEmpty(strG)) {
            strG = "#";
        }
        jSONObject.put("15112", str3 + "#" + strG + "#" + (zA ? 1 : 0));
        boolean zF = com.baidu.xclient.gdid.a.f(this.f26763a);
        jSONObject.put("15006", zF ? "1" : "0");
        if (TextUtils.isEmpty(strOptString2)) {
            com.baidu.mshield.b.c.a.a("real machine sig is empty");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zF) {
            String strA = a(strOptString2, true);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            com.baidu.mshield.b.c.a.a("cpp param 2 result : " + strA);
            jSONObject.put("d0006", String.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
            jSONObject.put("15085", strA);
            jSONObject.put("isj", "0");
            jSONObject.put("ise", "1");
            com.baidu.mshield.b.c.a.b("native cpp=" + strA);
            return;
        }
        String strA2 = a(strOptString2, false);
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        com.baidu.mshield.b.c.a.a("java param 2 result : " + strA2);
        jSONObject.put("d0006", String.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis));
        jSONObject.put("15085", strA2);
        jSONObject.put("isj", "1");
        jSONObject.put("ise", "0");
    }

    public final String a(String str, boolean z) {
        String strValueOf;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    int iOptInt = jSONObjectOptJSONObject.optInt("eid");
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("pattern");
                    String strOptString = jSONObjectOptJSONObject.optString("item");
                    String strOptString2 = jSONObjectOptJSONObject.optString("value");
                    if (iOptInt2 != 0) {
                        str2 = "";
                        if (iOptInt2 == 2 || iOptInt2 == 3) {
                            String[] strArrSplit = strOptString.split("\\|");
                            String str3 = strArrSplit[0];
                            String str4 = strArrSplit[1];
                            str2 = strArrSplit.length == 3 ? strArrSplit[2] : "";
                            if (iOptInt2 == 2) {
                                if (z) {
                                    strValueOf = (String) com.baidu.xclient.gdid.a.a(25, strOptString, strOptString2, (Object) null);
                                } else {
                                    strValueOf = j.b(str3, str4, str2, strOptString2);
                                }
                            } else if (z) {
                                strValueOf = (String) com.baidu.xclient.gdid.a.a(26, strOptString, strOptString2, (Object) null);
                            } else {
                                strValueOf = j.a(str3, str4, str2, strOptString2);
                            }
                        }
                        jSONObject.put(String.valueOf(iOptInt), str2);
                    } else if (z) {
                        strValueOf = (String) com.baidu.xclient.gdid.a.a(24, strOptString, strOptString2, (Object) null);
                    } else {
                        strValueOf = String.valueOf(com.baidu.mshield.x6.f.f.c(strOptString));
                    }
                    str2 = strValueOf;
                    jSONObject.put(String.valueOf(iOptInt), str2);
                } catch (Throwable th) {
                    com.baidu.mshield.x6.f.f.b(th);
                }
            }
        } catch (Throwable th2) {
            com.baidu.mshield.x6.f.f.b(th2);
        }
        return jSONObject.toString();
    }
}
