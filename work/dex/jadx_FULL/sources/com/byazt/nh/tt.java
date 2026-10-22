package com.byazt.nh;

import android.util.SparseArray;
import com.byazt.nc.i;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2116, 13})
public class tt {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 172101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(List<i> list) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, list);
        sparseArray.put(-99999987, 172102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
