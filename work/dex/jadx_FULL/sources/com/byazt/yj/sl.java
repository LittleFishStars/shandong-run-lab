package com.byazt.yj;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 158})
public class sl implements da, Function {
    public volatile Function c;
    public volatile da tt;

    public sl(da daVar) {
        this.tt = daVar;
    }

    public sl(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return this.tt.coverterTo((Bitmap) sparseArray.get(1));
    }

    @Override // com.byazt.yj.da
    public Bitmap coverterTo(Bitmap bitmap) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bitmap);
        return (Bitmap) this.c.apply(sparseArray);
    }
}
