package com.byazt.fb;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1053, 15})
public abstract class uj implements Function<SparseArray<Object>, Object> {
    public abstract <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        return applyFunction(pluginValueSetTt.intValue(-99999987, 0), pluginValueSetTt, (Class) pluginValueSetTt.objectValue(-99999985, Class.class));
    }
}
