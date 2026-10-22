package com.byazt.vw;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 682, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(com.byazt.nc.tt ttVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, ttVar);
        sparseArray.put(-99999987, 111101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt(com.byazt.nc.tt ttVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, ttVar);
        sparseArray.put(-99999987, 111102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(com.byazt.nc.tt ttVar, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, ttVar);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 111103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
