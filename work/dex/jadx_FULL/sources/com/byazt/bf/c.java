package com.byazt.bf;

import android.util.SparseArray;
import com.byazt.nc.da;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2354, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(da daVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, daVar);
        sparseArray.put(-99999987, 161101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void n(da daVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, daVar);
        sparseArray.put(-99999987, 161107);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt(da daVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, daVar);
        sparseArray.put(-99999987, 161104);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void uj(da daVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, daVar);
        sparseArray.put(-99999987, 161105);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void ve(da daVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, daVar);
        sparseArray.put(-99999987, 161103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, Integer.valueOf(i2));
        sparseArray.put(-99999987, 161102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(long j, long j2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(-99999987, 161106);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
