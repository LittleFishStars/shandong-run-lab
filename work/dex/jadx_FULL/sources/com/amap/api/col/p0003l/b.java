package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.zj.adlib.a7b;
import com.zj.adlib.sja;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b extends bw<String, sja> {
    public b(Context context, String str) {
        super(context, str);
    }

    public static sja e(JSONObject jSONObject) throws AMapException {
        sja sjaVar = new sja();
        try {
            String strOptString = jSONObject.optString("update", "");
            if (strOptString.equals("0")) {
                sjaVar.b(false);
            } else if (strOptString.equals("1")) {
                sjaVar.b(true);
            }
            sjaVar.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            a7b.m(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return sjaVar;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final /* synthetic */ sja a(JSONObject jSONObject) throws AMapException {
        return e(jSONObject);
    }

    @Override // com.amap.api.col.p0003l.bw
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", ((bw) this).f752a);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final JSONObject a(fh.c cVar) {
        JSONObject jSONObject;
        if (cVar == null || (jSONObject = cVar.c) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    @Override // com.amap.api.col.p0003l.bw
    public final String a() {
        return "016";
    }
}
