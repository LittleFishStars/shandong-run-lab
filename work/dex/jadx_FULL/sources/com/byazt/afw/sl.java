package com.byazt.afw;

import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 158})
public class sl extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28285a;
    public String c;
    public String n;
    public long tt;
    public int uj;
    public long ve;

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.c);
            jSONObject.put("preload_size", this.tt);
            jSONObject.put("load_time", this.ve);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.uj);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, this.n);
            jSONObject.put("error_message_server", this.f28285a);
            c(jSONObject);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(long j) {
        this.ve = j;
    }

    public void ve(String str) {
        this.f28285a = str;
    }

    public void c(long j) {
        this.tt = j;
    }

    public void tt(String str) {
        this.n = str;
    }

    public void c(int i) {
        this.uj = i;
    }
}
