package com.kwad.components.offline.api.tk.model;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TemplateConfig extends BaseOfflineCompoJsonParse<TemplateConfig> {
    public String bundleFile;
    public String bundleId;
    public String md5;
    public String sha256;
    public String version;
    public String versionCode;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.bundleId = jSONObject.optString("bundleId");
        templateConfig.bundleFile = jSONObject.optString("bundleFile");
        templateConfig.version = jSONObject.optString("version");
        templateConfig.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        templateConfig.sha256 = jSONObject.optString("sha256");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(templateConfig.bundleId)) {
            ac.putValue(jSONObject, "bundleId", templateConfig.bundleId);
        }
        if (!TextUtils.isEmpty(templateConfig.bundleFile)) {
            ac.putValue(jSONObject, "bundleFile", templateConfig.bundleFile);
        }
        if (!TextUtils.isEmpty(templateConfig.version)) {
            ac.putValue(jSONObject, "version", templateConfig.version);
        }
        if (!TextUtils.isEmpty(templateConfig.md5)) {
            ac.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, templateConfig.md5);
        }
        if (!TextUtils.isEmpty(templateConfig.sha256)) {
            ac.putValue(jSONObject, "sha256", templateConfig.sha256);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig) {
        return toJson(templateConfig, (JSONObject) null);
    }
}
