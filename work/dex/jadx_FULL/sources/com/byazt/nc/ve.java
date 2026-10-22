package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 54})
public abstract class ve implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(250001, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getAppName();
            }
        }));
        cVarC.c(250002, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getAppVersion();
            }
        }));
        cVarC.c(250003, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getDeveloperName();
            }
        }));
        cVarC.c(250004, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getPrivacyUrl();
            }
        }));
        cVarC.c(250006, com.byazt.lq.uj.c(new Supplier<Map<String, String>>() { // from class: com.byazt.nc.ve.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return ve.this.getPermissionsMap();
            }
        }));
        cVarC.c(250005, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getPermissionUrl();
            }
        }));
        cVarC.c(250007, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getFunctionDescUrl();
            }
        }));
        cVarC.c(250008, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getRegNumber();
            }
        }));
        cVarC.c(250009, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.ve.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ve.this.getRegUrl();
            }
        }));
        return cVarC.tt();
    }

    public abstract String getAppName();

    public abstract String getAppVersion();

    public abstract String getDeveloperName();

    public abstract String getFunctionDescUrl();

    public abstract String getPermissionUrl();

    public abstract Map<String, String> getPermissionsMap();

    public abstract String getPrivacyUrl();

    public abstract String getRegNumber();

    public abstract String getRegUrl();

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
