package com.byazt.qx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN})
public class hd extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;

    public hd(com.byazt.omf.d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    public static void c(com.byazt.pct.nu nuVar, final com.byazt.omf.d dVar) {
        nuVar.c("showAppDetailOrPrivacyDialog", new com.byazt.pct.uj.tt() { // from class: com.byazt.qx.hd.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new hd(dVar);
            }
        });
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.omf.x.m().hd();
        WeakReference<com.byazt.omf.d> weakReference = this.c;
        if (weakReference == null) {
            return;
        }
        com.byazt.omf.d dVar = weakReference.get();
        if (dVar == null) {
            ve();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("show_dialog_style");
        if (iOptInt == 1) {
            dVar.yv();
        } else if (iOptInt == 2) {
            dVar.zm();
        }
    }
}
