package com.baidu.mshield.x0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
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
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26730a = "";

    /* JADX INFO: renamed from: com.baidu.mshield.x0.c.a$a, reason: collision with other inner class name */
    public static class C0281a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f26731a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ com.baidu.mshield.x0.l.a c;

        public C0281a(JSONObject jSONObject, Context context, com.baidu.mshield.x0.l.a aVar) {
            this.f26731a = jSONObject;
            this.b = context;
            this.c = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            String str2;
            String str3;
            int i;
            String str4;
            String str5 = "4";
            String str6 = "7";
            String str7 = "1";
            try {
                int iOptInt = this.f26731a.optInt("1", 0);
                String strOptString = this.f26731a.optString("4", "");
                String strOptString2 = this.f26731a.optString("5", "");
                String strOptString3 = this.f26731a.optString("6", "");
                int iOptInt2 = this.f26731a.has("7") ? this.f26731a.optJSONObject("7").optInt("1", 1) : 0;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.b("detect app encryptStr====" + a.f26730a);
                String strB = com.baidu.xclient.gdid.a.b(a.f26730a);
                com.baidu.mshield.b.c.a.b("detect app decryptStr====" + strB);
                JSONObject jSONObject = !TextUtils.isEmpty(strB) ? new JSONObject(strB) : new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                int length = jSONObject.length();
                String str8 = PrepareException.ERROR_AUTH_FAIL;
                String str9 = "0";
                if (length > 0) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        Iterator<String> it = itKeys;
                        String next = itKeys.next();
                        String str10 = strOptString;
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                        JSONObject jSONObject3 = jSONObject;
                        String strOptString4 = jSONObjectOptJSONObject.optString("p");
                        String str11 = strValueOf;
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("f");
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = jSONObject2;
                        PackageInfo packageInfoB = b.b(this.b, strOptString4);
                        if (packageInfoB != null) {
                            str4 = next;
                            if (iOptInt == 1) {
                                jSONObject4.put(str9, e.a(new File(packageInfoB.applicationInfo.sourceDir)));
                            }
                            jSONObject4.put(str7, str7);
                            if (b.c(this.b, strOptString4)) {
                                jSONObject4.put(str5, str7);
                            } else {
                                jSONObject4.put(str5, str9);
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject6 = new JSONObject();
                            str = str5;
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    iOptInt2 = iOptInt2;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    str9 = str9;
                                    String next2 = itKeys2.next();
                                    str7 = str7;
                                    String strOptString5 = jSONObjectOptJSONObject2.optString(next2);
                                    if (!TextUtils.isEmpty(strOptString5)) {
                                        String str12 = str8;
                                        if (new File(strOptString5).exists()) {
                                            String[] strArrA = com.baidu.mshield.b.a.b.a(strOptString5);
                                            stringBuffer.append(strArrA[0]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[1]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[2]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[3]);
                                        }
                                        arrayList.add(strOptString5);
                                        jSONObject6.put(next2, stringBuffer.toString());
                                        str8 = str12;
                                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject2;
                                        str6 = str6;
                                    }
                                }
                            }
                            String str13 = str7;
                            JSONObject jSONObject7 = jSONObjectOptJSONObject2;
                            String str14 = str9;
                            String str15 = str8;
                            int i2 = iOptInt2;
                            jSONObject4.put("3", String.valueOf(b.a(this.b, strOptString4, arrayList)));
                            jSONObject4.put("5", jSONObject6.toString());
                            jSONObject4.put("6", packageInfoB.firstInstallTime);
                            str6 = str6;
                            jSONObject4.put(str6, packageInfoB.lastUpdateTime);
                            if (jSONObject7 == null || jSONObject7.length() <= 0) {
                                str7 = str13;
                                str3 = str15;
                                str2 = str14;
                                jSONObject4.put(str3, str2);
                            } else {
                                str7 = str13;
                                str3 = str15;
                                jSONObject4.put(str3, str7);
                                str2 = str14;
                            }
                            jSONObject4.put("9", packageInfoB.versionName);
                            i = i2;
                            if (i == 1) {
                                int i3 = 0;
                                for (String[] strArrA2 = b.a(this.b, strOptString4); i3 < strArrA2.length; strArrA2 = strArrA2) {
                                    String str16 = strArrA2[i3];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    if (!TextUtils.isEmpty(str16)) {
                                        String[] strArrA3 = com.baidu.mshield.b.a.b.a(str16);
                                        stringBuffer2.append(strArrA3[0]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[1]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[2]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[3]);
                                    }
                                    jSONObject4.put(String.valueOf(i3 + 10), stringBuffer2.toString());
                                    i3++;
                                }
                            }
                        } else {
                            str = str5;
                            iOptInt = iOptInt;
                            str2 = str9;
                            str3 = str8;
                            i = iOptInt2;
                            str4 = next;
                            jSONObject4.put(str7, str2);
                        }
                        jSONObject5.put(str4, jSONObject4);
                        str8 = str3;
                        iOptInt2 = i;
                        str9 = str2;
                        strOptString = str10;
                        itKeys = it;
                        jSONObject = jSONObject3;
                        strValueOf = str11;
                        iOptInt = iOptInt;
                        jSONObject2 = jSONObject5;
                        str5 = str;
                    }
                }
                String str17 = strOptString;
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("3", jSONObject2);
                jSONObject8.put(str9, strValueOf);
                jSONObject8.put("5", str17);
                jSONObject8.put("6", strOptString2);
                jSONObject8.put(str6, strOptString3);
                jSONObject8.put(str8, EngineImpl.getInstance(this.b).getPropertyByType("mod"));
                jSONArray.put(jSONObject8);
                com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
                d.b(this.b, jSONArray, "1001159");
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(str17);
                stringBuffer3.append(LoginConstants.UNDER_LINE);
                stringBuffer3.append(strOptString2);
                stringBuffer3.append(LoginConstants.UNDER_LINE);
                stringBuffer3.append(strOptString3);
                this.c.f(stringBuffer3.toString());
                a.f26730a = "";
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void a(Context context) {
        JSONObject jSONObjectOptJSONObject;
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strC = aVar.c("plc114");
            com.baidu.mshield.b.c.a.b("handleNativeCollect: policy=" + strC);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            boolean z = jSONObject.optInt("1", 0) == 1;
            com.baidu.mshield.b.c.a.b("handleNativeCollect: sw=" + z);
            if (z && (jSONObjectOptJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv6")) != null) {
                com.baidu.mshield.b.c.a.b("detect app encrypt===" + f26730a);
                int iOptInt = jSONObjectOptJSONObject.optInt("3", 10);
                if (TextUtils.isEmpty(f26730a)) {
                    return;
                }
                new Timer().schedule(new C0281a(jSONObjectOptJSONObject, context, aVar), iOptInt * 1000);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
