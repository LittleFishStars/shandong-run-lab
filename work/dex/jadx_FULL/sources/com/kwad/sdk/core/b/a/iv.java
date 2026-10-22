package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class iv implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.title)) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.userHeadUrl)) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.liveStartTime)) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard = liveReservationPlayEndInfo;
        liveReservationPlayEndInfo.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    private static JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = merchantLiveReservationInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        String str2 = merchantLiveReservationInfo.userHeadUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        int i = merchantLiveReservationInfo.bookUserCount;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bookUserCount", i);
        }
        String str3 = merchantLiveReservationInfo.liveStartTime;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        boolean z = merchantLiveReservationInfo.displayWeakCard;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayWeakCard", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        boolean z2 = merchantLiveReservationInfo.displayBookCount;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayBookCount", z2);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }
}
