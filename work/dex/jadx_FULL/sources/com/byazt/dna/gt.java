package com.byazt.dna;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt implements my, Function {
    public volatile Function c;
    public volatile my tt;

    public gt(my myVar) {
        this.tt = myVar;
    }

    public gt(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    @Override // com.byazt.dna.my
    public Object getDispatchAdSdkInitializer(Bundle bundle, Object obj) {
        if (this.tt != null) {
            return this.tt.getDispatchAdSdkInitializer(bundle, obj);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bundle);
        sparseArray.put(2, obj);
        return this.c.apply(sparseArray);
    }
}
