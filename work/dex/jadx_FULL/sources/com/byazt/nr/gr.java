package com.byazt.nr;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.source.rtsp.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr {
    public static volatile gr tt;
    public c c;
    public Map<Integer, Map<String, Object>> n;
    public Map<Integer, JSONObject> ve = new ConcurrentHashMap(1);
    public boolean uj = false;

    public interface c {
        void c(int i, Map<String, Object> map);
    }

    public static gr c() {
        if (tt == null) {
            synchronized (gr.class) {
                if (tt == null) {
                    tt = new gr();
                }
            }
        }
        return tt;
    }

    public void tt(int i) {
        if (i == 0) {
            return;
        }
        try {
            Map<Integer, JSONObject> map = this.ve;
            if (map != null) {
                if (map.size() > 20) {
                    this.ve.clear();
                } else {
                    this.ve.remove(Integer.valueOf(i));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void ve(int i) {
        if (this.uj && i != 0) {
            try {
                this.n.remove(Integer.valueOf(i));
            } catch (Throwable unused) {
            }
        }
    }

    public void c(int i, int i2) {
        if (i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = this.ve.get(Integer.valueOf(i));
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.ve.put(Integer.valueOf(i), jSONObject);
            }
            jSONObject.put("click_calculation_type", i2);
            jSONObject.put("click_calculation_time", System.currentTimeMillis());
        } catch (Exception unused) {
        }
    }

    public JSONObject c(int i) {
        Map<Integer, JSONObject> map;
        if (i == 0 || (map = this.ve) == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public void c(boolean z) {
        this.uj = z;
        if (z && this.n == null) {
            this.n = new ConcurrentHashMap();
        }
    }

    public void c(int i, int i2, float[] fArr) {
        if (!this.uj || i == 0 || this.c == null) {
            return;
        }
        try {
            Map<String, Object> map = this.n.get(Integer.valueOf(i));
            if (map == null) {
                return;
            }
            HashMap map2 = new HashMap(map);
            map2.put("hashcode", Integer.valueOf(i));
            map2.put("type", Integer.valueOf(i2));
            if (i2 == 1) {
                map2.put("x", Float.valueOf(fArr[0]));
                map2.put("y", Float.valueOf(fArr[1]));
                map2.put(j.o, Float.valueOf(fArr[2]));
            } else {
                map2.put("x", Double.valueOf(Math.toDegrees(fArr[0])));
                map2.put("y", Double.valueOf(Math.toDegrees(fArr[1])));
                map2.put(j.o, Double.valueOf(Math.toDegrees(fArr[2])));
            }
            this.c.c(i, map2);
        } catch (Exception unused) {
        }
    }

    public void c(int i, String str, Object obj) {
        if (!this.uj || i == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Map<String, Object> concurrentHashMap = this.n.get(Integer.valueOf(i));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.n.put(Integer.valueOf(i), concurrentHashMap);
            }
            concurrentHashMap.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public void c(c cVar) {
        this.c = cVar;
    }
}
