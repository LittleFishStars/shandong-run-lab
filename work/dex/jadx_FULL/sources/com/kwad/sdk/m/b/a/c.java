package com.kwad.sdk.m.b.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ac;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@KsJson
public class c extends com.kwad.sdk.commercial.c.a {
    public int aYH;
    public List<b> bnB;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (b bVar : this.bnB) {
            ac.putValue(jSONObject, bVar.key, bVar.value);
        }
        ac.putValue(jSONObject, "func_ratio_count", this.aYH);
        JSONObject jSONObject2 = new JSONObject();
        ac.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
