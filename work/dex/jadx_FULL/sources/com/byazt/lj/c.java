package com.byazt.lj;

import android.util.SparseArray;
import com.byazt.yxi.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, 20})
public class c {
    public static Function<SparseArray<Object>, Object> c;

    public static void c(Function<SparseArray<Object>, Object> function) {
        c = function;
    }

    public static void c(boolean z) {
        if (c != null) {
            uj ujVarC = uj.c();
            ujVarC.c(10000).c(Void.class);
            ujVarC.c(20000, Boolean.valueOf(z));
            c.apply(ujVarC.tt());
        }
    }
}
