package com.byazt.omf;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 499})
public class yv implements Function {
    public static volatile yv c;

    private yv() {
    }

    public static yv instance() {
        if (c == null) {
            synchronized (yv.class) {
                if (c == null) {
                    c = new yv();
                }
            }
        }
        return c;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (!(obj instanceof SparseArray)) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        Bundle bundle = (Bundle) sparseArray.get(0);
        com.byazt.dna.i iVar = (com.byazt.dna.i) com.byazt.ut.uj.getService("boost");
        if (iVar != null) {
            return iVar.getInitialInstance(bundle);
        }
        return null;
    }
}
