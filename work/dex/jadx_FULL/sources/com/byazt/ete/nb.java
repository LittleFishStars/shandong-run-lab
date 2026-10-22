package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class nb {
    public JSONObject c;

    public String c() {
        JSONObject jSONObject = this.c;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("url") : "";
    }

    public String toString() {
        JSONObject jSONObject = this.c;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static nb c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static nb c(JSONObject jSONObject) {
        nb nbVar = new nb();
        nbVar.c = jSONObject;
        return nbVar;
    }
}
