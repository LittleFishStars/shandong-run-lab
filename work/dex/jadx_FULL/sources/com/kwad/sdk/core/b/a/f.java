package com.kwad.sdk.core.b.a;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f implements com.kwad.sdk.core.d<ActivityInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ActivityInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ActivityInfo) bVar, jSONObject);
    }

    private static void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    private static JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = activityInfo.actTypeId;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actTypeId", i);
        }
        int i2 = activityInfo.sceneTypeId;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sceneTypeId", i2);
        }
        return jSONObject;
    }
}
