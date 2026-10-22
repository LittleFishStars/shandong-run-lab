package com.byazt.ppf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 20})
public class c {
    public static Object c(JSONObject jSONObject, String str) {
        return c(jSONObject, str, null);
    }

    public static Object c(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (jSONObject != null && str != null && !str.isEmpty()) {
            String[] strArrSplit = str.split("\\.");
            try {
                int length = strArrSplit.length;
                int i = 0;
                Object obj2 = jSONObject;
                while (i < length) {
                    String str2 = strArrSplit[i];
                    if (!(obj2 instanceof JSONObject)) {
                        return obj;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    if (!jSONObject2.has(str2)) {
                        return obj;
                    }
                    i++;
                    obj2 = jSONObject2.get(str2);
                }
                return obj2;
            } catch (Exception unused) {
            }
        }
        return obj;
    }
}
