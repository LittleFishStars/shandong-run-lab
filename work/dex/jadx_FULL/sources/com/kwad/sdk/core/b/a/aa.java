package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class aa implements com.kwad.sdk.core.d<AdMatrixInfo.AdInteractionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.AdInteractionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.AdInteractionInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        adInteractionInfo.interactivityDefaultStyle = jSONObject.optInt("interactivityDefaultStyle", new Integer("4").intValue());
        adInteractionInfo.isMediaDisable = jSONObject.optBoolean("isMediaDisable");
        adInteractionInfo.switchDefaultTime = jSONObject.optLong("switchDefaultTime", new Long("1500").longValue());
        AdMatrixInfo.ShakeInfo shakeInfo = new AdMatrixInfo.ShakeInfo();
        adInteractionInfo.shakeInfo = shakeInfo;
        shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
        AdMatrixInfo.RotateInfo rotateInfo = new AdMatrixInfo.RotateInfo();
        adInteractionInfo.rotateInfo = rotateInfo;
        rotateInfo.parseJson(jSONObject.optJSONObject("rotateInfo"));
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = new AdMatrixInfo.SplashSlideInfo();
        adInteractionInfo.slideInfo = splashSlideInfo;
        splashSlideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
        AdMatrixInfo.SplashActionBarInfo splashActionBarInfo = new AdMatrixInfo.SplashActionBarInfo();
        adInteractionInfo.splashActionBarInfo = splashActionBarInfo;
        splashActionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adInteractionInfo.tkDefaultTimeout = jSONObject.optLong("tkDefaultTimeout", new Long("1500").longValue());
    }

    private static JSONObject b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adInteractionInfo.interactiveStyle;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interactiveStyle", i);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "interactivityDefaultStyle", adInteractionInfo.interactivityDefaultStyle);
        boolean z = adInteractionInfo.isMediaDisable;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isMediaDisable", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "switchDefaultTime", adInteractionInfo.switchDefaultTime);
        com.kwad.sdk.utils.ac.a(jSONObject, "shakeInfo", adInteractionInfo.shakeInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "rotateInfo", adInteractionInfo.rotateInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "slideInfo", adInteractionInfo.slideInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "actionBarInfo", adInteractionInfo.splashActionBarInfo);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "tkDefaultTimeout", adInteractionInfo.tkDefaultTimeout);
        return jSONObject;
    }
}
