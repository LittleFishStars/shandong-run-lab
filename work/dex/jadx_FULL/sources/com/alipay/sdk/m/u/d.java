package com.alipay.sdk.m.u;

import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends com.alipay.sdk.m.t.e {
    @Override // com.alipay.sdk.m.t.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.t.e.a("cashier", "main");
    }

    @Override // com.alipay.sdk.m.t.e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.t.e
    public Map<String, String> a(boolean z, String str) {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.m.t.e.i, "CBC");
        return map;
    }

    @Override // com.alipay.sdk.m.t.e
    public String a(com.alipay.sdk.m.w.a aVar) throws JSONException {
        return a(aVar, new HashMap<>(), new HashMap<>());
    }

    @Override // com.alipay.sdk.m.t.e
    public String a(com.alipay.sdk.m.w.a aVar, String str, JSONObject jSONObject) {
        String strA = super.a(aVar, str, jSONObject);
        try {
            String strF = com.alipay.sdk.m.r.b.e().f();
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "localConfigVersion", strF);
            JSONObject jSONObject2 = new JSONObject(strA);
            jSONObject2.put("h5_local", "true");
            jSONObject2.put("h5_local_version", strF);
            jSONObject2.put("route_pay_from", "h5");
            jSONObject2.put("init_from", "SDKLite");
            jSONObject2.put(AliyunLogKey.KEY_VIDEO_CODEC, "y");
            return jSONObject2.toString();
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "buildBody", th);
            com.alipay.sdk.m.y.g.a(th);
            return strA;
        }
    }
}
