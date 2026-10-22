package com.byazt.sbm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1200, 20})
public abstract class c implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(271006, com.byazt.lq.uj.c(new Supplier<Map<String, String>>() { // from class: com.byazt.sbm.c.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return c.this.getCustomData();
            }
        }));
        cVarC.c(271007, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getSdkName();
            }
        }));
        cVarC.c(271008, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getCustomSdkName();
            }
        }));
        cVarC.c(271009, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getSlotId();
            }
        }));
        cVarC.c(271010, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getLevelTag();
            }
        }));
        cVarC.c(271011, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getEcpm();
            }
        }));
        cVarC.c(271012, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.sbm.c.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(c.this.getReqBiddingType());
            }
        }));
        cVarC.c(271013, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getErrorMsg();
            }
        }));
        cVarC.c(271014, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getRequestId();
            }
        }));
        cVarC.c(271015, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getRitType();
            }
        }));
        cVarC.c(271016, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getSegmentId();
            }
        }));
        cVarC.c(271017, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getChannel();
            }
        }));
        cVarC.c(271018, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getSubChannel();
            }
        }));
        cVarC.c(271019, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getAbTestId();
            }
        }));
        cVarC.c(271020, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getScenarioId();
            }
        }));
        cVarC.c(271051, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getSubRitType();
            }
        }));
        cVarC.c(271052, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.sbm.c.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return c.this.getDiscount();
            }
        }));
        return cVarC.tt();
    }

    public abstract String getAbTestId();

    public abstract String getChannel();

    public abstract Map<String, String> getCustomData();

    public abstract String getCustomSdkName();

    public abstract String getDiscount();

    public abstract String getEcpm();

    public abstract String getErrorMsg();

    public abstract String getLevelTag();

    public abstract int getReqBiddingType();

    public abstract String getRequestId();

    public abstract String getRitType();

    public abstract String getScenarioId();

    public abstract String getSdkName();

    public abstract String getSegmentId();

    public abstract String getSlotId();

    public abstract String getSubChannel();

    public abstract String getSubRitType();

    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
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
