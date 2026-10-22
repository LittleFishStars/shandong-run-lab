package com.kwad.sdk.core.b.a;

import com.huachenjie.works.page.campus_wall.post.list.PostListActivity;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.zj.adlib.xh9;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ab implements com.kwad.sdk.core.d<AdLabelImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdLabelImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdLabelImpl) bVar, jSONObject);
    }

    private static void a(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLabelImpl.thirdAge = jSONObject.optInt("thirdAge");
        adLabelImpl.thirdGender = jSONObject.optInt("thirdGender");
        adLabelImpl.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(adLabelImpl.thirdInterest)) {
            adLabelImpl.thirdInterest = "";
        }
        adLabelImpl.prevTitle = jSONObject.optString("prevTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.prevTitle)) {
            adLabelImpl.prevTitle = "";
        }
        adLabelImpl.postTitle = jSONObject.optString(PostListActivity.z);
        if (JSONObject.NULL.toString().equals(adLabelImpl.postTitle)) {
            adLabelImpl.postTitle = "";
        }
        adLabelImpl.historyTitle = jSONObject.optString("historyTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.historyTitle)) {
            adLabelImpl.historyTitle = "";
        }
        adLabelImpl.channel = jSONObject.optString(xh9.WEBSITE_PARAMS_CHANNEL);
        if (JSONObject.NULL.toString().equals(adLabelImpl.channel)) {
            adLabelImpl.channel = "";
        }
        adLabelImpl.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
    }

    private static JSONObject b(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adLabelImpl.thirdAge;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = adLabelImpl.thirdGender;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdGender", i2);
        }
        String str = adLabelImpl.thirdInterest;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdInterest", adLabelImpl.thirdInterest);
        }
        String str2 = adLabelImpl.prevTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "prevTitle", adLabelImpl.prevTitle);
        }
        String str3 = adLabelImpl.postTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, PostListActivity.z, adLabelImpl.postTitle);
        }
        String str4 = adLabelImpl.historyTitle;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "historyTitle", adLabelImpl.historyTitle);
        }
        String str5 = adLabelImpl.channel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, xh9.WEBSITE_PARAMS_CHANNEL, adLabelImpl.channel);
        }
        long j = adLabelImpl.cpmBidFloor;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cpmBidFloor", j);
        }
        return jSONObject;
    }
}
