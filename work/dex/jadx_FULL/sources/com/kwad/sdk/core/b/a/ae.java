package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ae implements com.kwad.sdk.core.d<WebCardRegisterLiveMessageListener.AdLiveMessageInfoList> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardRegisterLiveMessageListener.AdLiveMessageInfoList) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardRegisterLiveMessageListener.AdLiveMessageInfoList) bVar, jSONObject);
    }

    private static void a(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adLiveMessageInfos");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                WebCardRegisterLiveMessageListener.AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new WebCardRegisterLiveMessageListener.AdLiveMessageInfoList.AdLiveMessageItemInfo();
                adLiveMessageItemInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
            }
        }
    }

    private static JSONObject b(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adLiveMessageInfos", adLiveMessageInfoList.adLiveMessageInfos);
        return jSONObject;
    }
}
