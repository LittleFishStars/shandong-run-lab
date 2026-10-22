package com.byazt.qv;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.omf.x;
import com.byazt.vx.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 15})
public class uj {
    public static Map<String, List<com.byazt.nbs.n>> c = new ConcurrentHashMap();
    public static Map<String, String> tt = new ConcurrentHashMap();

    public static PluginValueSet c(String str, com.byazt.dj.tt.c cVar, int i) {
        long jCurrentTimeMillis;
        String strVe;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return com.byazt.ch.c.c(cVar.c());
        }
        if (com.byazt.vq.c.c().c(str)) {
            return com.byazt.ch.c.c(cVar.c());
        }
        String strTt = tt(str);
        if (TextUtils.isEmpty(strTt)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            strVe = ve(str);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            i2 = !TextUtils.isEmpty(strVe) ? 2 : 3;
        } else {
            jCurrentTimeMillis = 0;
            strVe = strTt;
            i2 = 1;
        }
        com.byazt.ng.a.c(i, i2, jCurrentTimeMillis, str, strVe);
        if (TextUtils.isEmpty(strVe)) {
            return com.byazt.ch.c.c(cVar.c());
        }
        cVar.uj(strVe);
        return com.byazt.ch.c.c(cVar.c(), str, i2 == 2);
    }

    private static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (c.size() == 0) {
            tt();
        }
        for (String str2 : c.keySet()) {
            List<com.byazt.nbs.n> list = c.get(str2);
            if (list != null) {
                Iterator<com.byazt.nbs.n> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().c())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    private static String ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (tt.size() == 0) {
            ve();
        }
        return tt.get(str);
    }

    private static void ve() {
        String string = com.byazt.rq.c.ve().getString("mediation_adn_map", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string2 = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                        tt.put(next, string2);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void tt() {
        String string = com.byazt.rq.c.ve().getString("mediation_csj_map", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            String strOptString = jSONObjectOptJSONObject.optString("csj_code_id");
                            if (TextUtils.isEmpty(strOptString)) {
                                strOptString = jSONObjectOptJSONObject.optString("csj_rit_id");
                            }
                            double dOptDouble = jSONObjectOptJSONObject.optDouble("price");
                            if (dOptDouble <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                dOptDouble = jSONObjectOptJSONObject.optDouble("ecpm");
                            }
                            copyOnWriteArrayList.add(new com.byazt.nbs.n(strOptString, dOptDouble, jSONObjectOptJSONObject.optInt("load_sort"), jSONObjectOptJSONObject.optInt("show_sort")));
                        }
                        c.put(next, copyOnWriteArrayList);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean c(String str) {
        return x.m().zb() && !TextUtils.isEmpty(tt(str));
    }

    public static void c(final JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        double dDoubleValue;
        if (jSONObject == null) {
            return;
        }
        c.clear();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(next)) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("price");
                        long jOptLong = jSONObject2.optLong("csj_code_id");
                        try {
                            dDoubleValue = Double.valueOf(strOptString).doubleValue();
                        } catch (Throwable unused) {
                            dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                        copyOnWriteArrayList.add(new com.byazt.nbs.n(String.valueOf(jOptLong), dDoubleValue, 0, 0));
                    }
                    c.put(next, copyOnWriteArrayList);
                }
            }
        } catch (Throwable unused2) {
        }
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.qv.uj.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rq.c.ve().put("mediation_csj_map", jSONObject.toString());
            }
        });
    }

    public static void c() {
        if (tt.size() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : tt.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.qv.uj.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rq.c.ve().put("mediation_adn_map", jSONObject.toString());
            }
        });
    }

    public static boolean c(String str, String str2) {
        List<com.byazt.nbs.n> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = c.get(str)) == null || list.size() == 0) {
            return true;
        }
        h.c(list);
        return str2.equals(list.get(0).c());
    }
}
