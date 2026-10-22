package com.byazt.lw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt implements com.byazt.dr.c {
    public final String c;

    public gt(String str) {
        this.c = str;
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return this.c;
    }

    public String toString() {
        return tt();
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return "'" + this.c + "'";
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.STRING;
    }
}
