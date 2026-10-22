package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o {
    public String _a;
    public int _b;
    public String _c;
    public String _d;
    public List<String> _e;
    public String _f;
    public String _g;
    public String _h;
    public String _i;
    public String _j;
    public String _k;
    public String _l;
    public String _m;
    public String _n;
    public String _o;
    public String _p;
    public String _q;
    public String _r;
    public String _s;

    public _o() {
        this._b = -1;
    }

    public _o(String str, String str2, String str3, int i, String str4, ArrayList arrayList, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this._a = str3;
        this._b = i;
        this._c = str4;
        this._d = PtgApiProvider.providerName;
        _a(100, "");
        this._e = arrayList;
        this._f = _a(150, str5);
        this._g = _a(200, str6);
        this._h = _a(100, "");
        this._i = str7;
        this._j = str8;
        this._k = _a(100, str9);
        this._l = str10;
        this._m = _a(100, str11);
        this._n = "";
        this._p = str;
        this._o = str2;
    }

    public static String _a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    public final JSONObject _a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj = this._p;
            Object obj2 = "";
            if (obj == null) {
                obj = "";
            }
            jSONObject.put("adId", obj);
            Object obj3 = this._o;
            if (obj3 == null) {
                obj3 = "";
            }
            jSONObject.put("consumerAdId", obj3);
            Object obj4 = this._a;
            if (obj4 == null) {
                obj4 = "";
            }
            jSONObject.put("slotId", obj4);
            jSONObject.put("slotType", this._b);
            Object obj5 = this._c;
            if (obj5 == null) {
                obj5 = "";
            }
            jSONObject.put("consumerSlotId", obj5);
            Object obj6 = this._d;
            if (obj6 == null) {
                obj6 = "";
            }
            jSONObject.put("consumerType", obj6);
            Object obj7 = this._f;
            if (obj7 == null) {
                obj7 = "";
            }
            jSONObject.put("title", obj7);
            Object obj8 = this._g;
            if (obj8 == null) {
                obj8 = "";
            }
            jSONObject.put("desc", obj8);
            JSONArray jSONArray = new JSONArray();
            List<String> list = this._e;
            if (list != null && !list.isEmpty()) {
                for (String str : this._e) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
            }
            jSONObject.put("imgList", jSONArray);
            Object obj9 = this._n;
            if (obj9 == null) {
                obj9 = "";
            }
            jSONObject.put("industryId", obj9);
            Object obj10 = this._i;
            if (obj10 == null) {
                obj10 = "";
            }
            jSONObject.put("landingPageUrl", obj10);
            Object obj11 = this._j;
            if (obj11 == null) {
                obj11 = "";
            }
            jSONObject.put("deeplink", obj11);
            Object obj12 = this._h;
            if (obj12 == null) {
                obj12 = "";
            }
            jSONObject.put("source", obj12);
            Object obj13 = this._k;
            if (obj13 == null) {
                obj13 = "";
            }
            jSONObject.put("appName", obj13);
            Object obj14 = this._m;
            if (obj14 == null) {
                obj14 = "";
            }
            jSONObject.put("appPackageName", obj14);
            Object obj15 = this._l;
            if (obj15 == null) {
                obj15 = "";
            }
            jSONObject.put("appDownloadUrl", obj15);
            jSONObject.put("mediaId", PtgAdSdk.getConfig()._a);
            Object obj16 = this._q;
            if (obj16 == null) {
                obj16 = "";
            }
            jSONObject.put("blockTarget", obj16);
            Object obj17 = this._r;
            if (obj17 == null) {
                obj17 = "";
            }
            jSONObject.put("blockKeyword", obj17);
            Object obj18 = this._s;
            if (obj18 != null) {
                obj2 = obj18;
            }
            jSONObject.put("whiteKeyword", obj2);
            jSONObject.put("policyVersion", PtgAdSdk.getConfig()._g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
