package com.byazt.afw;

import com.byazt.afw.uj;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 13})
public class tt<T extends uj> {
    public ic c;
    public boolean n = false;
    public String tt;
    public T uj;
    public JSONObject ve;

    public tt(ic icVar, String str, JSONObject jSONObject, T t) {
        this.c = icVar;
        this.tt = str;
        this.ve = jSONObject;
        this.uj = t;
    }

    public ic c() {
        return this.c;
    }

    public boolean n() {
        return this.n;
    }

    public String tt() {
        return this.tt;
    }

    public T uj() {
        return this.uj;
    }

    public JSONObject ve() {
        if (this.ve == null) {
            this.ve = new JSONObject();
        }
        return this.ve;
    }

    public void c(boolean z) {
        this.n = z;
    }
}
