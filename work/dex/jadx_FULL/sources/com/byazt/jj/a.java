package com.byazt.jj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 34})
public class a {
    public static void c(com.byazt.lkb.c cVar) {
        if (cVar == null) {
            return;
        }
        Function<SparseArray<Object>, Object> functionZm = cVar.zm();
        if (functionZm != null) {
            Object objApply = functionZm.apply(com.byazt.yxi.uj.c().c(10001).c(Boolean.class).tt());
            if (objApply instanceof Boolean) {
                tt.c(((Boolean) objApply).booleanValue());
            }
        }
        if (cVar.p() != null) {
            Object objApply2 = functionZm.apply(com.byazt.yxi.uj.c().c(10003).c(Map.class).tt());
            if (objApply2 instanceof Map) {
                System.out.println("onetap " + objApply2.toString());
                uj.c((Map) objApply2);
            }
        }
        ve.c(cVar.yv());
        n.c(cVar.md());
        c.c(cVar.h());
    }
}
