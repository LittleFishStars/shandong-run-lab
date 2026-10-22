package com.byazt.tn;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1385, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121108);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void uj() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121105);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void ve() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121104);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 121102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(boolean z, int i, String str, int i2, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(7);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, str2);
        sparseArray.put(-99999987, 121106);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(boolean z, int i, Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, bundle);
        sparseArray.put(-99999987, 121107);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
