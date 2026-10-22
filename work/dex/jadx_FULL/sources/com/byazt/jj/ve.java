package com.byazt.jj;

import android.util.SparseArray;
import com.byazt.omf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 54})
public class ve {
    public static Function<SparseArray<Object>, Object> c;

    public static void c(Function<SparseArray<Object>, Object> function) {
        c = function;
    }

    private static void tt(com.byazt.ng.c cVar, boolean z) {
        if (c != null) {
            com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
            if (z) {
                ujVarC.c(10002).c(Void.class);
                ujVarC.c(20003, cVar.ve());
                c.apply(ujVarC.tt());
            } else {
                ujVarC.c(10002).c(Void.class);
                ujVarC.c(20002, cVar.ve());
                c.apply(ujVarC.tt());
            }
        }
    }

    public static void c(com.byazt.ng.c cVar, boolean z) {
        if (cVar != null && x.m().lr()) {
            tt(cVar, z);
        }
    }
}
