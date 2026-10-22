package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 66})
public abstract class t implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(230002, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.t.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(t.this.getHeight());
            }
        }));
        cVarC.c(230001, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.t.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(t.this.getWidth());
            }
        }));
        cVarC.c(230003, com.byazt.lq.uj.c(new Supplier<String>() { // from class: com.byazt.nc.t.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return t.this.getImageUrl();
            }
        }));
        cVarC.c(230004, com.byazt.lq.uj.c(new Supplier<Double>() { // from class: com.byazt.nc.t.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(t.this.getDuration());
            }
        }));
        cVarC.c(230005, com.byazt.lq.uj.c(new Supplier<Boolean>() { // from class: com.byazt.nc.t.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(t.this.isValid());
            }
        }));
        return cVarC.tt();
    }

    public abstract double getDuration();

    public abstract int getHeight();

    public abstract String getImageUrl();

    public abstract int getWidth();

    public abstract boolean isValid();

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
        if (sparseArray != null && com.byazt.rl.c.c(sparseArray).tt().intValue(-99999987) == -99999986) {
            return values().sparseArray();
        }
        return null;
    }
}
