package com.byazt.bnf;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nr.gt;
import com.byazt.omf.p;
import com.byazt.vif.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 20})
public final class c {
    public static String c(com.byazt.dna.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_layer_default";
        }
        if (tt()) {
            str = uj(cVar, str);
        }
        return c(str, cVar != null && cVar.isSupportMultiProcess(), cVar.getAppId());
    }

    public static String tt(com.byazt.dna.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_global_default";
        }
        if (tt()) {
            str = uj(cVar, str) + "_global";
        }
        return c(str, cVar != null && cVar.isSupportMultiProcess(), cVar.getAppId());
    }

    private static String uj(com.byazt.dna.c cVar, String str) {
        if (cVar == null || TextUtils.isEmpty(cVar.getAppId())) {
            return str;
        }
        return cVar.getAppId() + LoginConstants.UNDER_LINE + str;
    }

    public static String ve(com.byazt.dna.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_version_default";
        }
        if (tt()) {
            str = uj(cVar, str);
        }
        return c(str, cVar != null && cVar.isSupportMultiProcess(), cVar.getAppId());
    }

    private static String c(String str, boolean z, String str2) {
        if (z || gt.c(com.byazt.omf.gt.getContext()) || !uj.tt()) {
            return str;
        }
        return str + gt.tt(com.byazt.omf.gt.getContext());
    }

    private static boolean tt() {
        if (c()) {
            return false;
        }
        return uj.c();
    }

    public static boolean c() {
        return p.uj < 7500;
    }
}
