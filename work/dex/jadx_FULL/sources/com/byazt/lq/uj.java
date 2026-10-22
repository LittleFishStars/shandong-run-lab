package com.byazt.lq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 51, 15})
public class uj {
    public static <T> Object c(final Supplier<T> supplier) {
        return c(com.byazt.mta.c.c().tt()) ? new ValueSet.ValueGetter<Object>() { // from class: com.byazt.lq.uj.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            public T get() {
                return supplier.get();
            }
        } : supplier;
    }

    public static boolean c(int i) {
        return i >= 6803 && i < 7000;
    }

    public static Object c(SparseArray<Object> sparseArray) {
        return c(com.byazt.mta.c.c().tt()) ? com.byazt.rl.ve.c(sparseArray).tt() : sparseArray;
    }

    public static PluginValueSet c(int i, PluginValueSet pluginValueSet) {
        if (c(com.byazt.mta.c.c().tt())) {
            return com.byazt.rl.c.c(((ValueSet) pluginValueSet.objectValue(i, ValueSet.class)).sparseArray()).tt();
        }
        return com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(i, SparseArray.class)).tt();
    }
}
