package com.byazt.am;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1210, 54})
public class ve {
    public final Function<SparseArray<Object>, Object> c;

    public ve(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public String c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267001);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public String tt() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267002);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public String uj() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267004);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public String ve() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 267003);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }
}
