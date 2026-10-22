package com.kwad.components.offline.api.tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class StyleTemplatesConfig extends BaseOfflineCompoJsonParse<StyleTemplatesConfig> implements Serializable {
    private static final long serialVersionUID = -6279192768068169498L;
    public List<StyleTemplate> styleTemplates = new ArrayList();

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleTemplatesConfig.styleTemplates = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("styleTemplates");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                styleTemplatesConfig.styleTemplates.add(styleTemplate);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ac.putValue(jSONObject, "styleTemplates", styleTemplatesConfig.styleTemplates);
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig) {
        return toJson(styleTemplatesConfig, (JSONObject) null);
    }
}
