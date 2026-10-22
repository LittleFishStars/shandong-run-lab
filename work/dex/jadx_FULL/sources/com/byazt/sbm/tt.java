package com.byazt.sbm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1200, 13})
public abstract class tt implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(271001, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.tt.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tt.this.getMediationRit();
            }
        }));
        cVarC.c(271002, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.tt.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tt.this.getAdnName();
            }
        }));
        cVarC.c(271003, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.tt.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tt.this.getAdType();
            }
        }));
        cVarC.c(271004, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.sbm.tt.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(tt.this.getErrCode());
            }
        }));
        cVarC.c(271005, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.tt.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tt.this.getErrMsg();
            }
        }));
        return cVarC.tt();
    }

    public abstract String getAdType();

    public abstract String getAdnName();

    public abstract int getErrCode();

    public abstract String getErrMsg();

    public abstract String getMediationRit();

    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return com.byazt.rl.c.c(pluginValueSet).tt();
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return com.byazt.rl.c.c(pluginValueSetC).tt();
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return values().sparseArray();
    }
}
