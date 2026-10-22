package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.zj.adlib.a7b;
import com.zj.adlib.boa;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d extends bw<String, List<OfflineMapProvince>> {
    public Context b;

    public d(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.col.p0003l.bw
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", ((bw) this).f752a);
        return hashtable;
    }

    public final void e(Context context) {
        this.b = context;
    }

    @Override // com.amap.api.col.p0003l.bw
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.b != null) {
                boa.p(jSONObject.toString(), this.b);
            }
        } catch (Throwable th) {
            a7b.m(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.b;
            if (context != null) {
                return boa.g(jSONObject, context);
            }
            return null;
        } catch (JSONException e) {
            a7b.m(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.bw
    public final JSONObject a(fh.c cVar) {
        JSONObject jSONObject;
        if (cVar == null || (jSONObject = cVar.c) == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("015");
        if (!jSONObjectOptJSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObjectOptJSONObject));
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObjectOptJSONObject;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final String a() {
        return "015";
    }
}
