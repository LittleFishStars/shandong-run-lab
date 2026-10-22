package com.ipd.dsp.internal.e1;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.r;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {
    public static Pair<List<d>, List<m>> a(String str, String str2, String str3, String str4, String str5) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("trade_id");
            String strOptString2 = jSONObject.optString(UserTrackConstant.SIGN);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adverts");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("source", ""))) {
                            try {
                                d dVar = new d();
                                dVar.f = TextUtils.isEmpty(str2) ? Dsp.getAppId() : str2;
                                dVar.i = strOptString;
                                dVar.g = str3;
                                dVar.h = str4;
                                dVar.x = strOptString2;
                                dVar.a(jSONObjectOptJSONObject);
                                dVar.D.f = str5;
                                linkedList.add(dVar);
                            } catch (Throwable unused) {
                            }
                        } else {
                            try {
                                m mVar = new m(jSONObjectOptJSONObject);
                                mVar.f = TextUtils.isEmpty(str2) ? Dsp.getAppId() : str2;
                                mVar.i = strOptString;
                                mVar.g = str3;
                                mVar.h = str4;
                                mVar.D.f = str5;
                                linkedList2.add(mVar);
                            } catch (IllegalStateException e) {
                                com.ipd.dsp.internal.c2.k.f("AIF", e.getMessage());
                            }
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            r.a(e2);
        }
        return new Pair<>(linkedList, linkedList2);
    }
}
