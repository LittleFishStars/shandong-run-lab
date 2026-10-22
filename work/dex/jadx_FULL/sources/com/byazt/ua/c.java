package com.byazt.ua;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29083a;
    public boolean c;
    public long n;
    public long sp;
    public boolean tt;
    public boolean uj;
    public boolean ve;
    public boolean x;

    /* JADX INFO: renamed from: com.byazt.ua.c$c, reason: collision with other inner class name */
    public interface InterfaceC0539c {
        boolean getHasUseCustomizeVideo();

        c getVideoModel();
    }

    public void c(boolean z) {
        this.x = z;
    }

    public c n(boolean z) {
        this.ve = z;
        return this;
    }

    public c tt(boolean z) {
        this.uj = z;
        return this;
    }

    public c uj(boolean z) {
        this.tt = z;
        return this;
    }

    public c ve(boolean z) {
        this.c = z;
        return this;
    }

    public c c(long j) {
        this.n = j;
        return this;
    }

    public c tt(long j) {
        this.f29083a = j;
        return this;
    }

    public c ve(long j) {
        this.sp = j;
        return this;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.c);
            jSONObject.put("isFromVideoDetailPage", this.tt);
            jSONObject.put("isFromDetailPage", this.ve);
            jSONObject.put("duration", this.n);
            jSONObject.put("totalPlayDuration", this.f29083a);
            jSONObject.put("currentPlayPosition", this.sp);
            jSONObject.put("isAutoPlay", this.uj);
            jSONObject.put("isMute", this.x);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.ve(jSONObject.optBoolean("isCompleted"));
        cVar.uj(jSONObject.optBoolean("isFromVideoDetailPage"));
        cVar.n(jSONObject.optBoolean("isFromDetailPage"));
        cVar.c(jSONObject.optLong("duration"));
        cVar.tt(jSONObject.optLong("totalPlayDuration"));
        cVar.ve(jSONObject.optLong("currentPlayPosition"));
        cVar.tt(jSONObject.optBoolean("isAutoPlay"));
        cVar.c(jSONObject.optBoolean("isMute"));
        return cVar;
    }
}
