package com.igexin.push.core.a.b;

import com.igexin.push.d.c.n;
import com.igexin.sdk.main.FeedbackImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d extends com.igexin.push.core.a.a {
    private static final String b = "FormatMsgAction";
    private static Map<String, a> c;

    public d() {
        HashMap map = new HashMap();
        c = map;
        map.put(com.igexin.push.core.b.G, new h());
        c.put("response_deviceid", new i());
        c.put(com.igexin.push.core.b.E, new e());
        c.put(com.igexin.push.core.b.F, new g());
        c.put("sendmessage_feedback", new j());
        c.put("block_client", new c());
        c.put("settag_result", new k());
        c.put("query_tag_result", new f());
        c.put("response_bind", new b());
        c.put("response_unbind", new l());
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!nVar.d() || nVar.f == null) {
            return false;
        }
        try {
            final JSONObject jSONObject = new JSONObject((String) nVar.f);
            if (jSONObject.has("action") && !jSONObject.getString("action").equals(com.igexin.push.core.b.F) && !jSONObject.getString("action").equals(com.igexin.push.core.b.G) && jSONObject.has("id")) {
                FeedbackImpl.getInstance().asyncFeedback(new Runnable() { // from class: com.igexin.push.core.a.b.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String strOptString = jSONObject.optString("id");
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.a(strOptString);
                    }
                });
            }
            if (!jSONObject.has("action")) {
                return false;
            }
            a aVar = c.get(jSONObject.getString("action"));
            if (aVar != null) {
                return aVar.a(obj, jSONObject);
            }
            return false;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
