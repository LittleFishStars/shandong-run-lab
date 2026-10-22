package com.igexin.sdk.router.site;

import com.igexin.c.a.c.a;
import com.igexin.push.core.e;
import com.igexin.push.g.o;
import com.igexin.sdk.router.boatman.receive.IBoatResult;
import com.igexin.sdk.router.boatman.receive.Site;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class InitSite extends Site<JSONObject, JSONObject> {
    @Override // com.igexin.sdk.router.boatman.receive.Site
    public String getTag() {
        return "tag_extension_init";
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public JSONObject onArrived(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put("cid", e.A);
            jSONObject.put("deviceId", e.H);
            jSONObject.put("userPushService", o.b(e.l, o.c, ""));
        } catch (JSONException e) {
            a.a(e);
        }
        return jSONObject;
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public void onArrived(JSONObject jSONObject, IBoatResult<JSONObject> iBoatResult) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("cid", e.A);
            jSONObject.put("deviceId", e.H);
            jSONObject.put("userPushService", o.b(e.l, "ups", ""));
            iBoatResult.onResult(jSONObject);
        } catch (JSONException e) {
            a.a(e);
        }
    }
}
