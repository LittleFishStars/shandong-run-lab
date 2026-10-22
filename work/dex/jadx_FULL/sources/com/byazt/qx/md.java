package com.byazt.qx;

import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md extends com.byazt.pct.n<JSONObject, JSONObject> {
    public final com.byazt.omf.d c;

    public md(com.byazt.omf.d dVar) {
        this.c = dVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("pageFinished", (com.byazt.pct.n<?, ?>) new md(dVar));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.omf.d dVar = this.c;
        if (dVar != null) {
            dVar.yp();
        }
        return jSONObject2;
    }
}
