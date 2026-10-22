package com.byazt.eu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 54})
public final class ve {
    public static void c(Object obj) {
        c(obj, true, "Object can not be null.", "");
    }

    private static boolean c(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String strC = c(str, objArr);
        if (z) {
            throw new NullPointerException(strC);
        }
        tt.uj("TTMediationSDK_ADAPTER", strC);
        return false;
    }

    private static String c(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e) {
            tt.uj("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e.getMessage());
            return strValueOf;
        }
    }
}
