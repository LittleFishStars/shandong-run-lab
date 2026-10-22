package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 72})
public abstract class da extends u {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c(super.values());
        cVarC.c(160001, com.byazt.lq.uj.c(new Supplier<Double>() { // from class: com.byazt.nc.da.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(da.this.getVideoDuration());
            }
        }));
        cVarC.c(160002, com.byazt.lq.uj.c(new Supplier<com.byazt.yh.c>() { // from class: com.byazt.nc.da.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.yh.c get() {
                return da.this.getCustomVideo();
            }
        }));
        cVarC.c(160003, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.da.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(da.this.getAdViewWidth());
            }
        }));
        cVarC.c(160004, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.da.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(da.this.getAdViewHeight());
            }
        }));
        return cVarC.tt();
    }

    public abstract int getAdViewHeight();

    public abstract int getAdViewWidth();

    public abstract com.byazt.yh.c getCustomVideo();

    public abstract double getVideoDuration();

    public abstract void setVideoAdListener(com.byazt.bf.c cVar);

    public abstract void setVideoRewardListener(com.byazt.bf.tt ttVar);

    @Override // com.byazt.nc.u
    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.nc.u, com.byazt.nc.x, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return values().sparseArray();
            case 140111:
                Function function = (Function) pluginValueSetTt.objectValue(0, Function.class);
                setExpressRenderListener(pluginValueSetTt.intValue(1) == 1 ? new com.byazt.am.n(function) : new com.byazt.lsp.ve(function));
                return null;
            case 160101:
                setVideoAdListener(new com.byazt.bf.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 160102:
                setVideoRewardListener(new com.byazt.bf.tt((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
