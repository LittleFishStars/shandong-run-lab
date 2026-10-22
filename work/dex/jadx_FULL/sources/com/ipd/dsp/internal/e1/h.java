package com.ipd.dsp.internal.e1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h implements Serializable {
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;

    public h(@Nullable JSONObject jSONObject) {
        this.f = 0;
        this.j = "";
        if (jSONObject != null) {
            this.f = jSONObject.optInt("style", 0);
            this.g = jSONObject.optString("bg_color", "");
            this.h = jSONObject.optString("title", "");
            this.j = jSONObject.optString("logo", "");
            this.i = jSONObject.optString("text_color", "");
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = "广告";
        }
    }
}
