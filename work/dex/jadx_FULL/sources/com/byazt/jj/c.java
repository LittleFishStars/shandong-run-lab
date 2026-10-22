package com.byazt.jj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 20})
public class c {
    public static Function<SparseArray<Object>, Object> c;

    public static void c(Function<SparseArray<Object>, Object> function) {
        c = function;
    }

    public static void c(boolean z) {
        if (c != null) {
            com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
            ujVarC.c(10000).c(Boolean.class);
            ujVarC.c(20000, Boolean.valueOf(z));
            c.apply(ujVarC.tt());
        }
    }
}
