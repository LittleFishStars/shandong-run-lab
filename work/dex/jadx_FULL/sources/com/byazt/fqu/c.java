package com.byazt.fqu;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1010, 20})
public class c {
    public static SparseArray<Object> c(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        veVarC.c(261001, adConfig.getAppId());
        veVarC.c(261002, adConfig.getAppName());
        veVarC.c(261003, adConfig.isPaid());
        veVarC.c(261004, adConfig.getKeywords());
        veVarC.c(261005, adConfig.getData());
        veVarC.c(261006, adConfig.getTitleBarTheme());
        veVarC.c(261007, adConfig.isAllowShowNotify());
        veVarC.c(261008, adConfig.isDebug());
        veVarC.c(261009, adConfig.getDirectDownloadNetworkType());
        veVarC.c(261011, adConfig.isSupportMultiProcess());
        veVarC.c(261012, uj.c(adConfig.getCustomController()));
        veVarC.c(261013, new Supplier<Integer>() { // from class: com.byazt.fqu.c.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        veVarC.c(261014, new Supplier<Integer>() { // from class: com.byazt.fqu.c.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        veVarC.c(261015, new Supplier<Integer>() { // from class: com.byazt.fqu.c.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        veVarC.c(261016, adConfig.getMediationConfig() != null ? com.byazt.jt.c.c(adConfig.getMediationConfig()) : null);
        veVarC.c(261017, adConfig.isUseMediation());
        veVarC.c(261018, new Supplier<Map<String, Object>>() { // from class: com.byazt.fqu.c.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return adConfig.getInitExtra();
            }
        });
        return veVarC.tt().sparseArray();
    }
}
