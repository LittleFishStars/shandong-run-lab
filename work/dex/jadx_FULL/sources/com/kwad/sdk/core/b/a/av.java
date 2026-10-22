package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class av implements com.kwad.sdk.core.d<AdStyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdStyleInfo.PlayDetailInfo playDetailInfo = new AdStyleInfo.PlayDetailInfo();
        adStyleInfo.playDetailInfo = playDetailInfo;
        playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        AdStyleInfo.PlayEndInfo playEndInfo = new AdStyleInfo.PlayEndInfo();
        adStyleInfo.playEndInfo = playEndInfo;
        playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        AdStyleInfo.FeedAdInfo feedAdInfo = new AdStyleInfo.FeedAdInfo();
        adStyleInfo.feedAdInfo = feedAdInfo;
        feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
        AdStyleInfo.AdBrowseInfo adBrowseInfo = new AdStyleInfo.AdBrowseInfo();
        adStyleInfo.adBrowseInfo = adBrowseInfo;
        adBrowseInfo.parseJson(jSONObject.optJSONObject("adBrowseInfo"));
        AdStyleInfo.ExtraDisplayInfo extraDisplayInfo = new AdStyleInfo.ExtraDisplayInfo();
        adStyleInfo.extraDisplayInfo = extraDisplayInfo;
        extraDisplayInfo.parseJson(jSONObject.optJSONObject("extraDisplayInfo"));
        adStyleInfo.playableExtraData = jSONObject.optString("playableExtraData");
        if (JSONObject.NULL.toString().equals(adStyleInfo.playableExtraData)) {
            adStyleInfo.playableExtraData = "";
        }
        adStyleInfo.slideClick = jSONObject.optBoolean("slideClick");
    }

    private static JSONObject b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "playDetailInfo", adStyleInfo.playDetailInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "playEndInfo", adStyleInfo.playEndInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "feedAdInfo", adStyleInfo.feedAdInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adBrowseInfo", adStyleInfo.adBrowseInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "extraDisplayInfo", adStyleInfo.extraDisplayInfo);
        String str = adStyleInfo.playableExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableExtraData", adStyleInfo.playableExtraData);
        }
        boolean z = adStyleInfo.slideClick;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "slideClick", z);
        }
        return jSONObject;
    }
}
