package com.byazt.afw;

import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 133})
public class z implements uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f28287a;
    public long c;
    public int da;
    public long i;
    public String n;
    public boolean sl;
    public int sp;
    public long tt;
    public int uj;
    public int ve;
    public long x;

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.c);
            jSONObject.put("total_duration", this.tt);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.ve);
            jSONObject.put("extra_error_code", this.uj);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, this.n);
            jSONObject.put("event_list", this.f28287a);
            jSONObject.put("vbtt_skip_type", this.sp);
            jSONObject.put("video_cache_size", this.x);
            jSONObject.put("current", this.i);
            jSONObject.put("percent", this.da);
            jSONObject.put("has_endcard_skip", this.sl);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public void c(boolean z) {
        this.sl = z;
    }

    public void tt(long j) {
        this.x = j;
    }

    public void uj(long j) {
        this.tt = j;
    }

    public void ve(long j) {
        this.c = j;
    }

    public void c(long j) {
        this.i = j;
    }

    public void tt(int i) {
        this.sp = i;
    }

    public void uj(int i) {
        this.uj = i;
    }

    public void ve(int i) {
        this.ve = i;
    }

    public void c(int i) {
        this.da = i;
    }

    public void c(JSONArray jSONArray) {
        this.f28287a = jSONArray;
    }

    public void c(String str) {
        this.n = str;
    }
}
