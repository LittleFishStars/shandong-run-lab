package com.byazt.qx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class nb extends com.byazt.pct.n<JSONObject, JSONObject> {
    public final String c;

    public nb(String str) {
        this.c = str;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar) {
        nuVar.c("sendAction", (com.byazt.pct.n<?, ?>) new nb(icVar.zm()));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        Object objUj = com.byazt.rgb.tt.uj(this.c, 1);
        if (objUj instanceof JSONArray) {
            ((JSONArray) objUj).put(jSONObject);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            com.byazt.rgb.tt.c(this.c, 1, jSONArray);
        }
        jSONObject2.put("code", 0);
        return jSONObject2;
    }
}
