package com.zj.adlib;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.igexin.push.core.b;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class wtb {
    public static boolean b = false;
    public static String i = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f20542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public aqb f20543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vob f20544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f20547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20548a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f20549b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f20550b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public HashMap f20552b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f20553c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f20555d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f20557e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f20559f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final String f20561g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f20563h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public int f20565i;
    public int j;
    public int k;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f20546a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList f20551b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final ArrayList f20554c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final ArrayList f20556d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final ArrayList f20558e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final ArrayList f20560f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final ArrayList f20562g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public final ArrayList f20564h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public final ArrayList f20566i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public final ArrayList f20567j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public final ArrayList f20568k = new ArrayList();

    public wtb(String str) {
        this.f20561g = str;
    }

    public static HashMap a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(JSONObject jSONObject, String str, ArrayList arrayList) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i2));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(JSONObject jSONObject, ArrayList arrayList) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("trackers");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    erb erbVar = new erb();
                    erbVar.f41514a = jSONObjectOptJSONObject.optInt("type");
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("urls");
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                        }
                        erbVar.f16398a = arrayList2;
                    }
                    arrayList.add(erbVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean d() {
        return this.f20548a && this.f45689a == 1 && !TextUtils.isEmpty(dqb.a(this.f20555d));
    }

    public final void e(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("channelName", "");
            String strOptString2 = jSONObject.optString(RequestParameters.SUBRESOURCE_REFERER, "");
            String strOptString3 = jSONObject.optString(b.aC, "");
            String strOptString4 = jSONObject.optString("imgUrl", "");
            String strOptString5 = jSONObject.optString("landPage", "");
            jSONObject.optString(NativeModel.JSON_KEY_SCHEME, "");
            int iOptInt = jSONObject.optInt("ctype", 0);
            String strOptString6 = jSONObject.optString("ldp", "");
            int iOptInt2 = jSONObject.optInt("impDelay", 0);
            int iOptInt3 = jSONObject.optInt("needClick", 0);
            this.f20542a = jSONObject.optLong("expire", 0L);
            this.f20545a = strOptString;
            this.f20550b = strOptString3;
            this.f20553c = strOptString4;
            this.f20555d = strOptString5;
            this.f45689a = iOptInt;
            this.f20563h = strOptString6;
            this.f20557e = strOptString2;
            this.f20549b = iOptInt2;
            boolean z = true;
            if (iOptInt3 != 1) {
                z = false;
            }
            this.f20548a = z;
            b(jSONObject, QdActivityType.IMP, this.f20546a);
            b(jSONObject, "clk", this.f20551b);
            b(jSONObject, "dpt", this.f20554c);
            b(jSONObject, "dps", this.f20556d);
            b(jSONObject, "dlf", this.f20558e);
            b(jSONObject, "download", this.f20560f);
            b(jSONObject, "downloaded", this.f20562g);
            b(jSONObject, "install", this.f20564h);
            b(jSONObject, "installed", this.f20566i);
            ArrayList arrayList = this.f20567j;
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("click_area");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        ira iraVar = new ira();
                        iraVar.f42431a = jSONObjectOptJSONObject.optString("url");
                        iraVar.b = jSONObjectOptJSONObject.optString("body");
                        arrayList.add(iraVar);
                    }
                }
            } catch (Throwable unused) {
            }
            c(jSONObject, this.f20568k);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("task");
            if (jSONObjectOptJSONObject2 != null) {
                int iOptInt4 = jSONObjectOptJSONObject2.optInt("staytime");
                int iOptInt5 = jSONObjectOptJSONObject2.optInt("clkDelay");
                int iOptInt6 = jSONObjectOptJSONObject2.optInt("downloadedDelay");
                int iOptInt7 = jSONObjectOptJSONObject2.optInt("downloadDelay");
                int iOptInt8 = jSONObjectOptJSONObject2.optInt("installDelay");
                int iOptInt9 = jSONObjectOptJSONObject2.optInt("installedDelay");
                int iOptInt10 = jSONObjectOptJSONObject2.optInt("dptDelay");
                int iOptInt11 = jSONObjectOptJSONObject2.optInt("dpsDelay");
                int iOptInt12 = jSONObjectOptJSONObject2.optInt("dpfDelay");
                this.d = iOptInt4;
                this.c = iOptInt5;
                this.e = iOptInt7;
                this.f = iOptInt6;
                this.g = iOptInt8;
                this.h = iOptInt9;
                this.f20565i = iOptInt10;
                this.j = iOptInt11;
                this.k = iOptInt12;
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("scroll");
                if (jSONObjectOptJSONObject3 != null) {
                    int iOptInt13 = jSONObjectOptJSONObject3.optInt("y");
                    int iOptInt14 = jSONObjectOptJSONObject3.optInt("time");
                    int iOptInt15 = jSONObjectOptJSONObject3.optInt("count");
                    aqb aqbVar = new aqb();
                    aqbVar.f40589a = iOptInt13;
                    aqbVar.c = iOptInt15;
                    aqbVar.b = iOptInt14;
                    this.f20543a = aqbVar;
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("clk");
                if (jSONObjectOptJSONObject4 != null) {
                    int iOptInt16 = jSONObjectOptJSONObject4.optInt("y");
                    int iOptInt17 = jSONObjectOptJSONObject4.optInt("x");
                    int iOptInt18 = jSONObjectOptJSONObject4.optInt("time");
                    vob vobVar = new vob();
                    vobVar.f45407a = iOptInt17;
                    vobVar.b = iOptInt16;
                    vobVar.c = iOptInt18;
                    this.f20544a = vobVar;
                }
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject(LoginConstants.EXT);
            if (jSONObjectOptJSONObject5 != null) {
                this.f20547a = a(jSONObjectOptJSONObject5.optJSONObject("reportHeader"));
                this.f20552b = a(jSONObjectOptJSONObject5.optJSONObject("ldpHeader"));
            }
        } catch (Throwable unused2) {
        }
    }
}
