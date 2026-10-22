package com.byazt.dw;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 513, 15})
public abstract class uj implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    public PluginValueSet c() {
        return com.byazt.rl.c.c().tt();
    }

    public abstract Map<String, Object> getAppInfoExtra();

    public abstract String getAppName();

    public abstract String getAuthorName();

    public abstract String getFunctionDescUrl();

    public abstract long getPackageSizeBytes();

    public abstract Map<String, String> getPermissionsMap();

    public abstract String getPermissionsUrl();

    public abstract String getPrivacyAgreement();

    public abstract String getRegUrl();

    public abstract String getVersionName();

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            PluginValueSet pluginValueSet = this.c;
            if (pluginValueSet != null) {
                return pluginValueSet.sparseArray();
            }
            PluginValueSet pluginValueSetC = c();
            this.c = pluginValueSetC;
            return pluginValueSetC.sparseArray();
        }
        if (iIntValue == 271047) {
            return getFunctionDescUrl();
        }
        if (iIntValue == 271051) {
            return getRegUrl();
        }
        switch (iIntValue) {
            case 271035:
                return getAppName();
            case 271036:
                return getAuthorName();
            case 271037:
                return Long.class.cast(Long.valueOf(getPackageSizeBytes()));
            case 271038:
                return getPermissionsUrl();
            case 271039:
                return getPermissionsMap();
            case 271040:
                return getPrivacyAgreement();
            case 271041:
                return getVersionName();
            case 271042:
                return getAppInfoExtra();
            default:
                return null;
        }
    }
}
