package com.byazt.ouz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 117})
public class rl {
    public Map<String, c> c;
    public String tt;

    public rl(String str) {
        this.tt = str;
    }

    public void c(Map<String, c> map) {
        this.c = map;
    }

    @NonNull
    public String toString() {
        if (this.c == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, c> entry : this.c.entrySet()) {
            c value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.c());
                jSONArray.put(value.tt());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        }
        return jSONObject.toString();
    }

    public int tt(String str) {
        int iC = c(false);
        Map<String, c> map = this.c;
        if (map != null && map.containsKey(str)) {
            c cVar = this.c.get(str);
            iC = cVar != null ? iC + cVar.tt() : iC + 5000;
        }
        return iC + 5000;
    }

    public int c(String str) {
        int iC = c(true);
        Map<String, c> map = this.c;
        if (map != null && map.containsKey(str)) {
            c cVar = this.c.get(str);
            iC = cVar != null ? iC + cVar.c() : iC + 5000;
        }
        return iC + 5000;
    }

    @com.byazt.zqa.c(c = {0, 1, 27, 782})
    public static class c {
        public int c;
        public int tt;

        public c(int i, int i2) {
            this.c = i;
            this.tt = i2;
        }

        public int c() {
            return this.c;
        }

        public int tt() {
            return this.tt;
        }

        public c() {
        }
    }

    private int c(boolean z) {
        float fHs;
        int iNe = 0;
        if (!com.byazt.omf.gt.tt().ix()) {
            return 0;
        }
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        try {
            String strC = com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", this.tt);
            if (!TextUtils.isEmpty(strC)) {
                double d2 = Double.parseDouble(strC);
                if (d2 >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                    try {
                        if (d2 < com.byazt.omf.gt.tt().te()) {
                            iNe = 0 + com.byazt.omf.gt.tt().ne();
                        }
                    } catch (NumberFormatException e) {
                        e = e;
                        d = d2;
                        com.byazt.nr.m.c(e);
                    }
                }
                d = d2;
            }
        } catch (NumberFormatException e2) {
            e = e2;
        }
        try {
            int i = Integer.parseInt(com.byazt.whk.c.c().c("ugen_render", z ? "h5_render_success" : "native_render_success", this.tt));
            int i2 = Integer.parseInt(com.byazt.whk.c.c().c("ugen_render", z ? "h5_render_fail" : "native_render_fail", this.tt));
            int i3 = i + i2;
            float f = i3 > 0 ? (i2 / i3) * 100.0f : 0.0f;
            com.byazt.nr.m.c("RenderTimeoutControl", "successCount: " + i + "failCount: " + i2 + " errorRate: " + f);
            if (z) {
                fHs = com.byazt.omf.gt.tt().lz();
            } else {
                fHs = com.byazt.omf.gt.tt().hs();
            }
            if (f >= fHs) {
                iNe += com.byazt.omf.gt.tt().ne();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isH5", z);
            jSONObject.put("bytebenchScore", d);
            jSONObject.put("successCount", i);
            jSONObject.put("failCount", i2);
            jSONObject.put("errorRate", f);
            jSONObject.put("result", iNe);
            com.byazt.ukr.yp.c().x(jSONObject);
        } catch (NumberFormatException | JSONException e3) {
            com.byazt.nr.m.c(e3);
        }
        return iNe;
    }

    public static rl c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        rl rlVar = new rl(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    map.put(next, new c(jSONArrayOptJSONArray.optInt(0), jSONArrayOptJSONArray.optInt(1)));
                }
            }
            rlVar.c(map);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return rlVar;
    }
}
