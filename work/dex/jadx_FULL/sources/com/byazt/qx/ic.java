package com.byazt.qx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME})
public class ic extends com.byazt.pct.n<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;

    public ic(com.byazt.omf.d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("sendPlayableReward", (com.byazt.pct.n<?, ?>) new ic(dVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.omf.d dVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.omf.d> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null && (dVar = this.c.get()) != null) {
            dVar.zb();
        }
        return jSONObject2;
    }
}
