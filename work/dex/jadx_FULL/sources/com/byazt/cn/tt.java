package com.byazt.cn;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1569, 13})
public abstract class tt implements Function<SparseArray<Object>, Object> {
    public abstract void c(Object obj);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || ((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        c(sparseArray.get(0, Object.class));
        return null;
    }
}
