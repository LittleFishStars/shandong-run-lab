package com.byazt.px;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 91})
public class sp extends com.byazt.fb.uj implements Supplier<SparseArray<Object>> {
    public com.byazt.je.tt c;

    public sp(com.byazt.je.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values().sparseArray();
        }
        return null;
    }

    public List<String> getCustomAppList() {
        com.byazt.je.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.c();
        }
        return null;
    }

    public List<String> getCustomDevImeis() {
        com.byazt.je.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.tt();
        }
        return null;
    }

    public boolean isCanUseOaid() {
        com.byazt.je.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.ve();
        }
        return true;
    }

    public boolean isLimitPersonalAds() {
        com.byazt.je.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.uj();
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        com.byazt.je.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.n();
        }
        return true;
    }

    public PluginValueSet values() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(8476, getCustomAppList());
        cVarC.c(8477, getCustomDevImeis());
        cVarC.c(8478, isCanUseOaid());
        cVarC.c(8027, isLimitPersonalAds());
        cVarC.c(8028, isProgrammaticRecommend());
        return cVarC.tt();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public SparseArray<Object> get() {
        PluginValueSet pluginValueSetValues = values();
        if (pluginValueSetValues != null) {
            return pluginValueSetValues.sparseArray();
        }
        return null;
    }
}
