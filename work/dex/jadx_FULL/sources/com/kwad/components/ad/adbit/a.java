package com.kwad.components.ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ac;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {

    @NonNull
    public JSONObject bD;

    @NonNull
    public Map<String, String> bE;

    public a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.bD = jSONObject;
        this.bE = map;
    }

    public final String Q() {
        for (String str : this.bE.keySet()) {
            ac.putValue(this.bD, str, this.bE.get(str));
        }
        return this.bD.toString();
    }
}
