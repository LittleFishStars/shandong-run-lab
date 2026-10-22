package com.bykv.vk.component.ttvideo.log;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.dv9;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29291a = -2147483648L;
    public long b = -2147483648L;
    public long c = -2147483648L;
    public long d = -2147483648L;
    public long e = -2147483648L;
    public long f = -2147483648L;
    public int g = Integer.MIN_VALUE;
    public int h = Integer.MIN_VALUE;
    public int i = Integer.MIN_VALUE;
    public int j = Integer.MIN_VALUE;
    public String k = "";
    public String l = "";
    public int m = Integer.MIN_VALUE;
    public String n = "";
    public String o = "";
    public String p = "";

    public static void a(Map map, String str, int i) {
        if (i != Integer.MIN_VALUE) {
            map.put(str, Integer.valueOf(i));
        }
    }

    public static void a(Map map, String str, long j) {
        if (j != -2147483648L) {
            map.put(str, Long.valueOf(j));
        }
    }

    public static void a(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public JSONObject a(c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        a(map, "player_sessionid", this.n);
        a(map, "log_type", "video_playq");
        a(map, "sdk_version", cVar.e);
        a(map, com.alipay.sdk.m.w.a.v, cVar.d);
        a(map, t.x, cVar.c);
        a(map, "pt", this.c);
        a(map, "vt", this.d);
        a(map, "et", this.e);
        a(map, dv9.f16123a, this.f);
        a((Map) map, RVParams.BACKGROUND_COLOR, this.g);
        a((Map) map, "br", this.h);
        a((Map) map, "vd", cVar.h);
        a(map, "initial_url", this.k);
        a(map, "init_audio_url", this.l);
        a((Map) map, "watch_dur", this.m);
        a((Map) map, "errt", this.i);
        a((Map) map, "errc", this.j);
        a(map, "ps_t", this.f29291a);
        a(map, "pt_new", this.b);
        a(map, "play_log_id", this.o);
        a(map, "last_sessionid", this.p);
        return new JSONObject(map);
    }
}
