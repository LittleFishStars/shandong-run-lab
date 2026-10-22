package com.byazt.px;

import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 34})
public class a extends com.byazt.fb.uj implements Supplier<SparseArray<Object>> {
    public com.byazt.dj.ve c;

    public a(com.byazt.dj.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values().sparseArray();
        }
        return null;
    }

    public PluginValueSet values() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        com.byazt.dj.ve veVar = this.c;
        double dTt = AudioStats.AUDIO_AMPLITUDE_NONE;
        cVarC.c(8481, veVar != null ? veVar.c() : 0.0d);
        com.byazt.dj.ve veVar2 = this.c;
        if (veVar2 != null) {
            dTt = veVar2.tt();
        }
        cVarC.c(8482, dTt);
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
