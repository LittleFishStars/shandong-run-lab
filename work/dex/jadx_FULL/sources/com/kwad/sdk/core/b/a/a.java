package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ABParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ABParams) bVar, jSONObject);
    }

    private static void a(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (JSONObject.NULL.toString().equals(aBParams.drawActionBarTimes)) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    private static JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aBParams.videoBlackAreaClick;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoBlackAreaClick", i);
        }
        int i2 = aBParams.videoBlackAreaNewStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoBlackAreaNewStyle", i2);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i3 = aBParams.showVideoAtH5;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showVideoAtH5", i3);
        }
        int i4 = aBParams.playableStyle;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableStyle", i4);
        }
        return jSONObject;
    }
}
