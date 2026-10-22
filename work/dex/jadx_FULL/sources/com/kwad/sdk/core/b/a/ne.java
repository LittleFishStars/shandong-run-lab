package com.kwad.sdk.core.b.a;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ne implements com.kwad.sdk.core.d<TemplateConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TemplateConfig) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TemplateConfig) bVar, jSONObject);
    }

    private static void a(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.h5Url = jSONObject.optString(ALPParamConstant.H5URL);
        if (JSONObject.NULL.toString().equals(templateConfig.h5Url)) {
            templateConfig.h5Url = "";
        }
        templateConfig.h5Version = jSONObject.optString("h5Version");
        if (JSONObject.NULL.toString().equals(templateConfig.h5Version)) {
            templateConfig.h5Version = "";
        }
        templateConfig.h5Checksum = jSONObject.optString("h5Checksum");
        if (JSONObject.NULL.toString().equals(templateConfig.h5Checksum)) {
            templateConfig.h5Checksum = "";
        }
    }

    private static JSONObject b(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = templateConfig.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ALPParamConstant.H5URL, templateConfig.h5Url);
        }
        String str2 = templateConfig.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "h5Version", templateConfig.h5Version);
        }
        String str3 = templateConfig.h5Checksum;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "h5Checksum", templateConfig.h5Checksum);
        }
        return jSONObject;
    }
}
