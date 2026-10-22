package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.amap.api.col.p0003l.ff;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g7b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r4b f41839a;

    public g7b(String str) {
        this.f41839a = null;
        try {
            this.f41839a = new r4b.a(str, "1.0", "1.0.0").b(new String[]{AliyunLogCommon.LogLevel.INFO}).c();
        } catch (ff unused) {
        }
    }

    public static r4b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString("a");
            String strOptString2 = jSONObject.optString("b");
            String strOptString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("d");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i));
            }
            return new r4b.a(strOptString, strOptString2, strOptString).a(strOptString3).b((String[]) arrayList.toArray(new String[0])).c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final List<r4b> b(Context context) {
        r4b r4bVarA;
        try {
            JSONArray jSONArray = new JSONArray(f7b.a(context, this.f41839a, "rbck"));
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    r4bVarA = a(jSONArray.getJSONObject(i));
                } catch (JSONException unused) {
                    r4bVarA = null;
                }
                if (r4bVarA != null) {
                    arrayList.add(r4bVarA);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    public final void c(Context context, r4b r4bVar) {
        JSONArray jSONArray;
        if (r4bVar == null) {
            return;
        }
        ArrayList<r4b> arrayList = new ArrayList();
        arrayList.add(r4bVar);
        if (arrayList.size() == 0) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray();
            for (r4b r4bVar2 : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a", r4bVar2.a());
                    jSONObject.put("b", r4bVar2.e());
                    jSONObject.put("c", r4bVar2.f());
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; r4bVar2.i() != null && i < r4bVar2.i().length; i++) {
                        jSONArray2.put(r4bVar2.i()[i]);
                    }
                    jSONObject.put("d", jSONArray2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        String string = jSONArray.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        f7b.b(context, this.f41839a, "rbck", string);
    }
}
