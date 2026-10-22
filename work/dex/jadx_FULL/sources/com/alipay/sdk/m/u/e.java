package com.alipay.sdk.m.u;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends com.alipay.sdk.m.t.e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.m.t.e
    public String a(com.alipay.sdk.m.w.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.t.e
    public Map<String, String> a(boolean z, String str) {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.m.t.e.c, String.valueOf(z));
        map.put(com.alipay.sdk.m.t.e.f, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        map.put(com.alipay.sdk.m.t.e.i, "CBC");
        return map;
    }

    @Override // com.alipay.sdk.m.t.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.m.t.e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.t.e
    public String a(com.alipay.sdk.m.w.a aVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("api_name", "/sdk/log");
        map.put(com.alipay.sdk.m.t.e.l, "1.0.0");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(t, "1.0");
        return a(aVar, map, map2);
    }

    @Override // com.alipay.sdk.m.t.e
    public com.alipay.sdk.m.t.b a(com.alipay.sdk.m.w.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, com.alipay.sdk.m.n.a.e, true);
    }
}
