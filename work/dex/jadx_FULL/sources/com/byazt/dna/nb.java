package com.byazt.dna;

import android.os.Message;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class nb implements qp.c, Function {
    public volatile Function c;
    public volatile qp.c tt;

    public nb(qp.c cVar) {
        this.tt = cVar;
    }

    public nb(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.tt.handleMsg((Message) sparseArray.get(1));
        return null;
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, message);
        this.c.apply(sparseArray);
    }
}
