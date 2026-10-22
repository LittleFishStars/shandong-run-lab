package com.baidu.mshield.x0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26732a;
    public static String b;

    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f26733a;
        public final /* synthetic */ Context b;

        public a(JSONObject jSONObject, Context context) {
            this.f26733a = jSONObject;
            this.b = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            String str2;
            JSONObject jSONObject;
            String str3;
            boolean z;
            String str4 = "4";
            String str5 = "1";
            try {
                int iOptInt = this.f26733a.optInt("1", 0);
                String strOptString = this.f26733a.optString("4", "");
                int iOptInt2 = this.f26733a.has("7") ? this.f26733a.optJSONObject("7").optInt("1", 1) : 0;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.b("detect app encryptStr====" + c.b);
                String strB = com.baidu.xclient.gdid.a.b(c.b);
                com.baidu.mshield.b.c.a.b("detect app decryptStr====" + strB);
                JSONObject jSONObject2 = !TextUtils.isEmpty(strB) ? new JSONObject(strB) : new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                int length = jSONObject2.length();
                String str6 = PrepareException.ERROR_AUTH_FAIL;
                String str7 = "0";
                if (length > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        Iterator<String> it = itKeys;
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                        JSONObject jSONObject4 = jSONObject2;
                        String strOptString2 = jSONObjectOptJSONObject.optString("p");
                        String str8 = strOptString;
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("f");
                        JSONObject jSONObject5 = new JSONObject();
                        String str9 = strValueOf;
                        PackageInfo packageInfoB = b.b(this.b, strOptString2);
                        if (packageInfoB != null) {
                            str2 = next;
                            if (iOptInt == 1) {
                                jSONObject5.put(str7, e.a(new File(packageInfoB.applicationInfo.sourceDir)));
                            }
                            jSONObject5.put(str5, str5);
                            if (b.c(this.b, strOptString2)) {
                                jSONObject5.put(str4, str5);
                            } else {
                                jSONObject5.put(str4, str7);
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject6 = new JSONObject();
                            str = str4;
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    jSONObject3 = jSONObject3;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    iOptInt2 = iOptInt2;
                                    String next2 = itKeys2.next();
                                    str7 = str7;
                                    String strOptString3 = jSONObjectOptJSONObject2.optString(next2);
                                    if (!TextUtils.isEmpty(strOptString3)) {
                                        String str10 = str5;
                                        if (new File(strOptString3).exists()) {
                                            String[] strArrA = com.baidu.mshield.b.a.b.a(strOptString3);
                                            stringBuffer.append(strArrA[0]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[1]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[2]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[3]);
                                        }
                                        arrayList.add(strOptString3);
                                        jSONObject6.put(next2, stringBuffer.toString());
                                        str5 = str10;
                                        str6 = str6;
                                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject2;
                                    }
                                }
                            }
                            String str11 = str5;
                            String str12 = str7;
                            JSONObject jSONObject7 = jSONObjectOptJSONObject2;
                            int i = iOptInt2;
                            jSONObject = jSONObject3;
                            String str13 = str6;
                            jSONObject5.put("3", String.valueOf(b.a(this.b, strOptString2, arrayList)));
                            jSONObject5.put("5", jSONObject6.toString());
                            jSONObject5.put("6", packageInfoB.firstInstallTime);
                            jSONObject5.put("7", packageInfoB.lastUpdateTime);
                            if (jSONObject7 == null || jSONObject7.length() <= 0) {
                                str5 = str11;
                                str3 = str13;
                                str7 = str12;
                                jSONObject5.put(str3, str7);
                            } else {
                                str5 = str11;
                                str3 = str13;
                                jSONObject5.put(str3, str5);
                                str7 = str12;
                            }
                            jSONObject5.put("9", packageInfoB.versionName);
                            iOptInt2 = i;
                            if (iOptInt2 == 1) {
                                String[] strArrA2 = b.a(this.b, strOptString2);
                                for (int i2 = 0; i2 < strArrA2.length; i2++) {
                                    String str14 = strArrA2[i2];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    if (!TextUtils.isEmpty(str14)) {
                                        String[] strArrA3 = com.baidu.mshield.b.a.b.a(str14);
                                        stringBuffer2.append(strArrA3[0]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[1]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[2]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[3]);
                                    }
                                    jSONObject5.put(String.valueOf(i2 + 10), stringBuffer2.toString());
                                }
                                z = true;
                            } else {
                                z = true;
                            }
                        } else {
                            str = str4;
                            iOptInt = iOptInt;
                            str2 = next;
                            jSONObject = jSONObject3;
                            str3 = str6;
                            z = true;
                            jSONObject5.put(str5, str7);
                        }
                        JSONObject jSONObject8 = jSONObject;
                        jSONObject8.put(str2, jSONObject5);
                        jSONObject3 = jSONObject8;
                        itKeys = it;
                        jSONObject2 = jSONObject4;
                        strOptString = str8;
                        strValueOf = str9;
                        str4 = str;
                        str6 = str3;
                        iOptInt = iOptInt;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("3", jSONObject3);
                jSONObject9.put(str7, strValueOf);
                jSONObject9.put("5", strOptString);
                jSONObject9.put(str6, EngineImpl.getInstance(this.b).getPropertyByType("mod"));
                jSONArray.put(jSONObject9);
                com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
                d.b(this.b, jSONArray, "1001159");
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strC = aVar.c("plc115");
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: policy=" + strC);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            boolean z = true;
            if (jSONObject.optInt("1", 0) != 1) {
                z = false;
            }
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: sw=" + z);
            if (z) {
                if (System.currentTimeMillis() - aVar.h() < ((long) jSONObject.optInt("3", 24)) * 3600000) {
                    com.baidu.mshield.b.c.a.b("handleCollectRoutine not time");
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv4");
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("3", 10);
                    if ((jSONObjectOptJSONObject.has("7") ? jSONObjectOptJSONObject.optJSONObject("7").optInt("2", 0) : 0) == 0) {
                        b = f26732a;
                    } else {
                        b = jSONObjectOptJSONObject.optString("2");
                    }
                    if (TextUtils.isEmpty(b)) {
                        return;
                    }
                    new Timer().schedule(new a(jSONObjectOptJSONObject, context), iOptInt * 1000);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
