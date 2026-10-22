package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gm implements com.kwad.sdk.core.d<ImpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ImpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ImpInfo) bVar, jSONObject);
    }

    private static void a(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        impInfo.pageScene = jSONObject.optLong("pageScene");
        impInfo.subPageScene = jSONObject.optLong("subPageScene");
        impInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(impInfo.sdkExtraData)) {
            impInfo.sdkExtraData = "";
        }
        impInfo.posId = jSONObject.optLong("posId");
        impInfo.entryScene = jSONObject.optLong("entryScene");
        impInfo.adNum = jSONObject.optInt("adNum");
        impInfo.action = jSONObject.optInt("action");
        impInfo.width = jSONObject.optInt("width");
        impInfo.height = jSONObject.optInt("height");
        impInfo.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
        impInfo.adStyle = jSONObject.optInt("adStyle");
        URLPackage uRLPackage = new URLPackage();
        impInfo.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        impInfo.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(impInfo.promoteId)) {
            impInfo.promoteId = "";
        }
        impInfo.comment = jSONObject.optString("comment");
        if (JSONObject.NULL.toString().equals(impInfo.comment)) {
            impInfo.comment = "";
        }
        impInfo.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(impInfo.backUrl)) {
            impInfo.backUrl = "";
        }
        impInfo.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        impInfo.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        impInfo.screenOrientation = jSONObject.optInt("screenOrientation");
        impInfo.extraData = jSONObject.optString("extraData");
        if (JSONObject.NULL.toString().equals(impInfo.extraData)) {
            impInfo.extraData = "";
        }
        impInfo.query = jSONObject.optString("query");
        if (JSONObject.NULL.toString().equals(impInfo.query)) {
            impInfo.query = "";
        }
    }

    private static JSONObject b(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = impInfo.pageScene;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageScene", j);
        }
        long j2 = impInfo.subPageScene;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "subPageScene", j2);
        }
        String str = impInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        long j3 = impInfo.posId;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "posId", j3);
        }
        long j4 = impInfo.entryScene;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "entryScene", j4);
        }
        int i = impInfo.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adNum", i);
        }
        int i2 = impInfo.action;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "action", i2);
        }
        int i3 = impInfo.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", i3);
        }
        int i4 = impInfo.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", i4);
        }
        long j5 = impInfo.cpmBidFloor;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cpmBidFloor", j5);
        }
        int i5 = impInfo.adStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adStyle", i5);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "urlPackage", impInfo.urlPackage);
        String str2 = impInfo.promoteId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        String str3 = impInfo.comment;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "comment", impInfo.comment);
        }
        String str4 = impInfo.backUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        long j6 = impInfo.userCommRateBuying;
        if (j6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userCommRateBuying", j6);
        }
        long j7 = impInfo.userCommRateSharing;
        if (j7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userCommRateSharing", j7);
        }
        int i6 = impInfo.screenOrientation;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenOrientation", i6);
        }
        String str5 = impInfo.extraData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extraData", impInfo.extraData);
        }
        String str6 = impInfo.query;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "query", impInfo.query);
        }
        return jSONObject;
    }
}
