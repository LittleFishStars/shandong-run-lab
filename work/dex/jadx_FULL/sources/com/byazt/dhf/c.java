package com.byazt.dhf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 244101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 244103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(int i, String str, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(-99999987, 244102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
