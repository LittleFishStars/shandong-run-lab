package com.alipay.sdk.m.u;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends com.alipay.sdk.m.t.e {
    @Override // com.alipay.sdk.m.t.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.t.e.a("sdkConfig", "obtain");
    }

    @Override // com.alipay.sdk.m.t.e
    public String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.t.e
    public boolean c() {
        return true;
    }

    @Override // com.alipay.sdk.m.t.e
    public String a(com.alipay.sdk.m.w.a aVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.putAll(com.alipay.sdk.m.y.a.a(aVar));
        com.alipay.sdk.m.y.g.d(com.alipay.sdk.m.n.a.B, "cf " + map2);
        return super.a(aVar, map, map2);
    }
}
