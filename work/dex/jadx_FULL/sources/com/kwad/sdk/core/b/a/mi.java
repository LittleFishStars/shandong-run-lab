package com.kwad.sdk.core.b.a;

import com.kc.openset.advertisers.hl.HLADNID;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mi implements com.kwad.sdk.core.d<AdMatrixInfo.SplashPlayCardTKInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashPlayCardTKInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashPlayCardTKInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashPlayCardTKInfo.tkTimeout = jSONObject.optInt("tkTimeout", new Integer(HLADNID.Reason.OTHER).intValue());
    }

    private static JSONObject b(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "tkTimeout", splashPlayCardTKInfo.tkTimeout);
        return jSONObject;
    }
}
