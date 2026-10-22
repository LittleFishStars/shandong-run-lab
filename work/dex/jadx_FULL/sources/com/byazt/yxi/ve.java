package com.byazt.yxi;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1133, 54})
public class ve {
    public static SparseArray<Object> c(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        Object objApply = function.apply(uj.c().c(-99999986).c(SparseArray.class).tt());
        return objApply instanceof SparseArray ? (SparseArray) objApply : new SparseArray<>();
    }

    public static boolean c(int i) {
        return i >= 6803 && i < 7000;
    }

    public static PluginValueSet tt(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return com.byazt.rl.c.c().tt();
        }
        Object objApply = ((function instanceof Supplier) && c(com.byazt.mta.c.c().tt())) ? ((Supplier) function).get() : function.apply(uj.c().c(-99999986).c(SparseArray.class).tt());
        return objApply instanceof SparseArray ? com.byazt.rl.c.c((SparseArray<Object>) objApply).tt() : com.byazt.rl.c.c().tt();
    }
}
