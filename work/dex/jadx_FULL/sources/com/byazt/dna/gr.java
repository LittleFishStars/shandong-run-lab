package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr implements gu, Function {
    public volatile Function c;
    public volatile gu tt;

    public gr(gu guVar) {
        this.tt = guVar;
    }

    public gr(Function function) {
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

    @Override // com.byazt.dna.gu
    public Object getData(int i) {
        if (this.tt != null) {
            return this.tt.getData(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.gu
    public Object getData(int i, com.byazt.iy.c cVar) {
        if (this.tt != null) {
            return this.tt.getData(i, cVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        if (cVar != null) {
            cVar = new com.byazt.iy.tt(cVar);
        }
        sparseArray.put(2, cVar);
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.gu
    public void setData(int i, Object obj) {
        if (this.tt != null) {
            this.tt.setData(i, obj);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.gu
    public void setData(int i, Object obj, com.byazt.iy.c cVar) {
        if (this.tt != null) {
            this.tt.setData(i, obj, cVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        if (cVar != null) {
            cVar = new com.byazt.iy.tt(cVar);
        }
        sparseArray.put(3, cVar);
        this.c.apply(sparseArray);
    }
}
