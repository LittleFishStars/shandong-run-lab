package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class le implements com.kwad.sdk.core.d<AdMatrixInfo.RotateDegreeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RotateDegreeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RotateDegreeInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateDegreeInfo.rotateDegree = jSONObject.optInt("rotateDegree");
        rotateDegreeInfo.direction = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    private static JSONObject b(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = rotateDegreeInfo.rotateDegree;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rotateDegree", i);
        }
        int i2 = rotateDegreeInfo.direction;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, i2);
        }
        return jSONObject;
    }
}
