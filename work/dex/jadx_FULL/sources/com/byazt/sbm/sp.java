package com.byazt.sbm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1200, 91})
public abstract class sp extends ve {
    public PluginValueSet c;

    private PluginValueSet c() {
        return com.byazt.rl.c.c(super.values()).tt();
    }

    public abstract void destroy();

    @Override // com.byazt.sbm.ve
    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.sbm.ve, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return values().sparseArray();
        }
        if (iIntValue != 270007) {
            return super.apply(sparseArray);
        }
        destroy();
        return null;
    }
}
