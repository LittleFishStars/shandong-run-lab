package com.byazt.fb;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1053, 20})
public abstract class c extends uj implements LongSupplier {
    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 0) {
            onAppBackground();
            return null;
        }
        if (i != 1) {
            return null;
        }
        onAppForeground();
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onAppBackground();

    public abstract void onAppForeground();
}
