package com.ipd.dsp.internal.e1;

import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j implements Serializable {
    public String f;
    public int g;
    public int h;
    public int i;

    public j(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f = "";
            return;
        }
        this.f = jSONObject.optString("url");
        this.g = jSONObject.optInt("valid_duration");
        this.h = jSONObject.optInt("skip_duration");
        this.i = jSONObject.optInt("type", 0);
    }
}
