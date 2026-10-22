package com.kwad.sdk.commercial;

import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends com.kwad.sdk.core.response.a.a {
    public double aJs;
    public List<f> aJt;
    public String minVersion;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aJs = jSONObject.optDouble("default_ratio", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.minVersion = jSONObject.optString("min_version", "");
        List<JSONObject> listH = ac.h(jSONObject.optJSONArray("rule_set"));
        if (listH != null) {
            this.aJt = new ArrayList();
            for (JSONObject jSONObject2 : listH) {
                f fVar = new f();
                fVar.parseJson(jSONObject2);
                this.aJt.add(fVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "default_ratio", this.aJs);
        ac.putValue(jSONObject, "min_version", this.minVersion);
        ac.putValue(jSONObject, "rule_set", this.aJt);
        afterToJson(jSONObject);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public final String toString() {
        return "RefineConfRatio{defaultRatio=" + this.aJs + ", minVersion='" + this.minVersion + "', ruleSet=" + this.aJt + '}';
    }
}
