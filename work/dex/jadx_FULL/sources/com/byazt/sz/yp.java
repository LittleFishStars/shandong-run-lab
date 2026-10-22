package com.byazt.sz;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 215})
public class yp {
    public Context c;
    public JSONObject tt;
    public Map<String, Object> uj;
    public JSONObject ve;

    public void c(Context context) {
        this.c = context;
    }

    public Context getContext() {
        return this.c;
    }

    public void tt(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public void c(JSONObject jSONObject) {
        this.tt = jSONObject;
    }

    public Map<String, Object> tt() {
        return this.uj;
    }

    public JSONObject c() {
        return this.ve;
    }

    public void c(Map<String, Object> map) {
        this.uj = map;
    }
}
