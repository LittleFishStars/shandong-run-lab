package com.kwad.sdk.core.b.a;

import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.credentials.utils.AuthConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lf implements com.kwad.sdk.core.d<AdMatrixInfo.RotateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RotateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RotateInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(rotateInfo.title)) {
            rotateInfo.title = "";
        }
        rotateInfo.subTitle = jSONObject.optString(RVParams.LONG_SUB_TITLE);
        if (JSONObject.NULL.toString().equals(rotateInfo.subTitle)) {
            rotateInfo.subTitle = "";
        }
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        rotateInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.x = rotateDegreeInfo;
        rotateDegreeInfo.parseJson(jSONObject.optJSONObject("x"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.y = rotateDegreeInfo2;
        rotateDegreeInfo2.parseJson(jSONObject.optJSONObject("y"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.z = rotateDegreeInfo3;
        rotateDegreeInfo3.parseJson(jSONObject.optJSONObject(com.google.android.exoplayer2.source.rtsp.j.o));
        rotateInfo.enable = jSONObject.optBoolean(AuthConstant.INI_ENABLE);
        rotateInfo.bidirectionalSwitch = jSONObject.optBoolean("bidirectionalSwitch");
    }

    private static JSONObject b(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rotateInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", rotateInfo.title);
        }
        String str2 = rotateInfo.subTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, RVParams.LONG_SUB_TITLE, rotateInfo.subTitle);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "downloadTexts", rotateInfo.downloadTexts);
        com.kwad.sdk.utils.ac.a(jSONObject, "x", rotateInfo.x);
        com.kwad.sdk.utils.ac.a(jSONObject, "y", rotateInfo.y);
        com.kwad.sdk.utils.ac.a(jSONObject, com.google.android.exoplayer2.source.rtsp.j.o, rotateInfo.z);
        boolean z = rotateInfo.enable;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, AuthConstant.INI_ENABLE, z);
        }
        boolean z2 = rotateInfo.bidirectionalSwitch;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bidirectionalSwitch", z2);
        }
        return jSONObject;
    }
}
