package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mx implements com.kwad.sdk.core.d<AdMatrixInfo.Styles> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.Styles) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.Styles) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styles.templateList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("templates");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdMatrixInfo.MatrixTemplate matrixTemplate = new AdMatrixInfo.MatrixTemplate();
                matrixTemplate.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                styles.templateList.add(matrixTemplate);
            }
        }
    }

    private static JSONObject b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "templates", styles.templateList);
        return jSONObject;
    }
}
