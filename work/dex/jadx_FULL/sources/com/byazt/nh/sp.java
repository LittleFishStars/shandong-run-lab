package com.byazt.nh;

import android.util.SparseArray;
import com.byazt.nc.z;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2116, 91})
public class sp {
    public final Function<SparseArray<Object>, Object> c;

    public sp(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 124101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt(z zVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, zVar);
        sparseArray.put(-99999987, 124103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(z zVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, zVar);
        sparseArray.put(-99999987, 124102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 124104);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
