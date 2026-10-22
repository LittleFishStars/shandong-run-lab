package com.byazt.nr;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 20})
public class c {

    /* JADX INFO: renamed from: com.byazt.nr.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 44})
    public static class C0481c {
        public static final Random c = c.ve();
    }

    public static JSONObject c(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : c(jSONObject.toString());
    }

    public static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strC = c();
        String strC2 = c(strC, 32);
        String strTt = tt();
        return 3 + strC + strTt + ((strC2 == null || strTt == null) ? null : com.byazt.ae.c.c(str, strTt, strC2));
    }

    public static String ve(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strC = c(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strC == null) ? str : com.byazt.ae.c.tt(str.substring(49), strSubstring, strC);
    }

    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strTt = tt(str);
                if (!TextUtils.isEmpty(strTt)) {
                    jSONObject.put("message", strTt);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable unused) {
            jSONObject.put("message", str);
            jSONObject.put("cypher", 0);
        }
        return jSONObject;
    }

    public static Random ve() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String tt() {
        String strC = c(8);
        if (strC == null || strC.length() != 16) {
            return null;
        }
        return strC;
    }

    public static String c() {
        String strC = c(16);
        if (strC == null || strC.length() != 32) {
            return null;
        }
        return strC;
    }

    public static String c(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String c(int i) {
        try {
            byte[] bArr = new byte[i];
            C0481c.c.nextBytes(bArr);
            return a.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
