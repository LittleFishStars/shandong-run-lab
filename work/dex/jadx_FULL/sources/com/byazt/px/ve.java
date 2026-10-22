package com.byazt.px;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 54})
public class ve {
    public final PluginValueSet c;

    private ve(PluginValueSet pluginValueSet) {
        this.c = pluginValueSet;
    }

    public static ve c(PluginValueSet pluginValueSet) {
        return new ve(pluginValueSet);
    }

    private boolean tt() {
        PluginValueSet pluginValueSet = this.c;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    public Function<SparseArray<Object>, Object> c() {
        if (tt()) {
            return (Function) this.c.objectValue(8301, Function.class);
        }
        return null;
    }
}
