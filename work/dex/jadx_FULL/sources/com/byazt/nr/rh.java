package com.byazt.nr;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 115})
public class rh {
    public static final Map<com.byazt.fn.ve, Object> c = new ConcurrentHashMap();
    public static AtomicBoolean tt = new AtomicBoolean(false);
    public static final Object ve = new Object();

    public static boolean a(Context context) {
        return ve(context) == 6;
    }

    public static boolean c(Context context) {
        return ve(context) != 0;
    }

    public static boolean n(Context context) {
        return ve(context) == 5;
    }

    public static String sp(Context context) {
        int iVe = ve(context);
        if (iVe == 2) {
            return "2g";
        }
        if (iVe == 3) {
            return "3g";
        }
        if (iVe == 4) {
            return "wifi";
        }
        if (iVe != 5) {
            return iVe != 6 ? "mobile" : NetworkUtil.NETWORK_CLASS_5G;
        }
        return "4g";
    }

    public static int tt(Context context) {
        int iVe = ve(context);
        if (iVe == 1) {
            return 0;
        }
        if (iVe == 4) {
            return 1;
        }
        if (iVe == 5) {
            return 4;
        }
        if (iVe != 6) {
            return iVe;
        }
        return 6;
    }

    public static boolean uj(Context context) {
        return ve(context) == 4;
    }

    public static int ve(Context context) {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getRealNetworkType(60000L);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
