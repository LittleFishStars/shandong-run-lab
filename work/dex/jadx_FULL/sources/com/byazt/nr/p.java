package com.byazt.nr;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 350})
public class p {
    public static volatile String c;

    public static String c() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String str = Build.MODEL;
        c = str;
        return str;
    }
}
