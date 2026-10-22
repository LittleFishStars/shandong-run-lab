package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class am implements com.kwad.sdk.core.d<AdMatrixInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.Styles styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles = styles;
        styles.parseJson(jSONObject.optJSONObject("styles"));
        AdMatrixInfo.AdDataV2 adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2 = adDataV2;
        adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
        adMatrixInfo.tag = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tag");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdMatrixInfo.MatrixTag matrixTag = new AdMatrixInfo.MatrixTag();
                matrixTag.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adMatrixInfo.tag.add(matrixTag);
            }
        }
    }

    private static JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.ac.a(jSONObject, "adDataV2", adMatrixInfo.adDataV2);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "tag", adMatrixInfo.tag);
        return jSONObject;
    }
}
