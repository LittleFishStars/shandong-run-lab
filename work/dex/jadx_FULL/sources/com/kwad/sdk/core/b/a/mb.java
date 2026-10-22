package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mb implements com.kwad.sdk.core.d<AdMatrixInfo.SplashActionBarInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashActionBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashActionBarInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashActionBarInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(splashActionBarInfo.title)) {
            splashActionBarInfo.title = "";
        }
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashActionBarInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    private static JSONObject b(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashActionBarInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", splashActionBarInfo.title);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "downloadTexts", splashActionBarInfo.downloadTexts);
        return jSONObject;
    }
}
