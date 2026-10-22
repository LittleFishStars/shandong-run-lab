package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class d implements b {
    public List<e> bil;
    public long intervalTime;

    public final long RJ() {
        long j = this.intervalTime;
        if (j > 0) {
            return j;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.bil = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("configList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                e eVar = new e();
                eVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                this.bil.add(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
