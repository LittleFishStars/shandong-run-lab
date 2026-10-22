package com.byazt.yx;

import com.baidu.mapapi.http.wrapper.HttpManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 34})
public final class a {
    public static boolean c(String str) {
        return "POST".equals(str) || "PATCH".equals(str) || HttpManager.HTTP_PUT.equals(str) || HttpManager.HTTP_DELETE.equals(str) || "MOVE".equals(str);
    }

    public static boolean n(String str) {
        return !"PROPFIND".equals(str);
    }

    public static boolean tt(String str) {
        return "POST".equals(str) || HttpManager.HTTP_PUT.equals(str) || "PATCH".equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean uj(String str) {
        return "PROPFIND".equals(str);
    }

    public static boolean ve(String str) {
        return tt(str) || "OPTIONS".equals(str) || HttpManager.HTTP_DELETE.equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }
}
