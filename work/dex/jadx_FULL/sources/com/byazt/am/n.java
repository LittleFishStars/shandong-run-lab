package com.byazt.am;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1210, 46})
public class n extends com.byazt.lsp.ve {
    public final Function<SparseArray<Object>, Object> c;

    public n(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(View view, String str, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(-99999987, 142102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 142104);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 142103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
