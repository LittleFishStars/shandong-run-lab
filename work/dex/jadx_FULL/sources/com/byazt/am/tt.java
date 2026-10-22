package com.byazt.am;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1210, 13})
public class tt {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public View c(com.byazt.dw.c cVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, cVar);
        sparseArray.put(-99999987, 266013);
        sparseArray.put(-99999985, View.class);
        return (View) this.c.apply(sparseArray);
    }
}
