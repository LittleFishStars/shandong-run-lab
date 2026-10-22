package com.byazt.yxi;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1133, 13})
public class tt {
    public boolean c;
    public int tt;
    public PluginValueSet uj;
    public String ve;

    public tt(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
            this.c = pluginValueSetTt.booleanValue(-999903);
            this.tt = pluginValueSetTt.intValue(-999900);
            this.ve = pluginValueSetTt.stringValue(-999901);
            this.uj = com.byazt.rl.c.c((SparseArray<Object>) pluginValueSetTt.objectValue(-999902, SparseArray.class)).tt();
        }
    }

    public boolean c() {
        return this.c;
    }

    public int tt() {
        return this.tt;
    }

    public PluginValueSet uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }
}
