package com.byazt.eu;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 15})
public class uj {
    public static String c() {
        return "TTMediationSDK_";
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        return "TTMediationSDK_" + str + LoginConstants.UNDER_LINE;
    }

    public static String tt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        if (TextUtils.isEmpty(str2)) {
            return c(str);
        }
        return "TTMediationSDK_" + str + LoginConstants.UNDER_LINE + str2 + LoginConstants.UNDER_LINE;
    }

    public static String c(com.byazt.nbs.tt ttVar) {
        if (ttVar != null && !TextUtils.isEmpty(ttVar.nb())) {
            return "TTMediationSDK_" + ttVar.nb() + LoginConstants.UNDER_LINE;
        }
        return c();
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        if (TextUtils.isEmpty(str2)) {
            return c(str);
        }
        return "TTMediationSDK_" + str + LoginConstants.UNDER_LINE + str2 + LoginConstants.UNDER_LINE;
    }
}
