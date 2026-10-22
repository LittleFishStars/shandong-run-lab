package com.kwad.sdk.core.b.a;

import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kwad.components.core.innerEc.logger.BaseInnerEcMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cb implements com.kwad.sdk.core.d<BaseInnerEcMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BaseInnerEcMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BaseInnerEcMsg) bVar, jSONObject);
    }

    private static void a(BaseInnerEcMsg baseInnerEcMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInnerEcMsg.adStyle = jSONObject.optInt("ad_style");
        baseInnerEcMsg.materialType = jSONObject.optInt("material_type");
        baseInnerEcMsg.userId = jSONObject.optString(PtgRewardConstant.REWARD_PARAMS.USER_ID);
        if (JSONObject.NULL.toString().equals(baseInnerEcMsg.userId)) {
            baseInnerEcMsg.userId = "";
        }
        baseInnerEcMsg.status = jSONObject.optInt("status");
    }

    private static JSONObject b(BaseInnerEcMsg baseInnerEcMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = baseInnerEcMsg.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", i);
        }
        int i2 = baseInnerEcMsg.materialType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", i2);
        }
        String str = baseInnerEcMsg.userId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, PtgRewardConstant.REWARD_PARAMS.USER_ID, baseInnerEcMsg.userId);
        }
        int i3 = baseInnerEcMsg.status;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i3);
        }
        return jSONObject;
    }
}
