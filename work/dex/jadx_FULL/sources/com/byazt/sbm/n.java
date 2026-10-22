package com.byazt.sbm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1200, 46})
public abstract class n extends ve {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c(super.values());
        cVarC.c(270008, com.byazt.lq.uj.c(new Supplier<Boolean>() { // from class: com.byazt.sbm.n.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(n.this.hasDislike());
            }
        }));
        cVarC.c(270011, com.byazt.lq.uj.c(new Supplier<Boolean>() { // from class: com.byazt.sbm.n.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(n.this.isExpress());
            }
        }));
        return cVarC.tt();
    }

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.byazt.am.a aVar);

    public abstract void setUseCustomVideo(boolean z);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.sbm.ve, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                PluginValueSet pluginValueSet = this.c;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
                PluginValueSet pluginValueSetC = c();
                this.c = pluginValueSetC;
                return pluginValueSetC.sparseArray();
            case 270009:
                setUseCustomVideo(pluginValueSetTt.booleanValue(0));
                return null;
            case 270010:
                setShakeViewListener(new com.byazt.am.a((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 271048:
                onResume();
                return null;
            case 271049:
                onPause();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
