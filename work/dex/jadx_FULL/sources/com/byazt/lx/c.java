package com.byazt.lx;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1021, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public static volatile c c;
    public static Function<SparseArray<Object>, Object> tt;

    private c() {
    }

    public static c getInstance() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public static void init(Function<SparseArray<Object>, Object> function) {
        tt = function;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        return null;
    }

    public void startRequestRit(String str, String str2) {
        if (tt != null) {
            com.byazt.rl.c cVarC = com.byazt.rl.c.c();
            cVarC.c(20000, str);
            cVarC.c(20001, str2);
            cVarC.c(-99999987, 10000);
            cVarC.c(-99999985, Void.class);
            tt.apply(cVarC.tt().sparseArray());
        }
    }
}
