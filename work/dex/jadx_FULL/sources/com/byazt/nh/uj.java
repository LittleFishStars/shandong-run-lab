package com.byazt.nh;

import android.util.SparseArray;
import com.byazt.nc.sl;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2116, 15})
public class uj {
    public final Function<SparseArray<Object>, Object> c;

    public uj(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 132101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt(sl slVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, slVar);
        sparseArray.put(-99999987, 132103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(sl slVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, slVar);
        sparseArray.put(-99999987, 132102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 132104);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
