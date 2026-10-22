package com.byazt.nr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 17})
public final class gu {

    @SuppressLint({"StaticFieldLeak"})
    public static Context c = null;
    public static Resources tt = null;
    public static boolean uj = false;
    public static boolean ve = false;

    public static Resources c(Context context) {
        Resources resources = tt;
        if (resources == null) {
            resources = null;
        }
        Context context2 = c;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }
}
