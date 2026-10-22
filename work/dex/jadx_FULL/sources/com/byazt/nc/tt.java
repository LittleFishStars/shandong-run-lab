package com.byazt.nc;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 13})
public abstract class tt extends x {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(110001, com.byazt.lq.uj.c(new Supplier<View>() { // from class: com.byazt.nc.tt.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public View get() {
                return tt.this.getSplashView();
            }
        }));
        cVarC.c(110003, com.byazt.lq.uj.c(new Supplier<View>() { // from class: com.byazt.nc.tt.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public View get() {
                return tt.this.getSplashCardView();
            }
        }));
        cVarC.c(110004, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.tt.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(tt.this.getInteractionType());
            }
        }));
        cVarC.c(110005, com.byazt.lq.uj.c(new Supplier<Map<String, Object>>() { // from class: com.byazt.nc.tt.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return tt.this.getMediaExtraInfo();
            }
        }));
        return cVarC.tt();
    }

    public abstract int getInteractionType();

    public abstract String getLifecycleId();

    public abstract Map<String, Object> getMediaExtraInfo();

    public abstract com.byazt.sbm.sp getMediationManager();

    public abstract View getSplashCardView();

    public abstract View getSplashView();

    public abstract void hideSkipButton();

    public abstract void setDownloadListener(com.byazt.ocd.ve veVar);

    public abstract void setSplashAdListener(com.byazt.vw.c cVar);

    public abstract void setSplashCardListener(com.byazt.vw.tt ttVar);

    public abstract void showSplashCardView(ViewGroup viewGroup, Activity activity);

    public abstract void showSplashView(ViewGroup viewGroup);

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
    @Override // com.byazt.nc.x, java.util.function.Function
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
            case UIMsg.f_FUN.FUN_ID_SCH_POI_OPTION /* 110101 */:
                hideSkipButton();
                return null;
            case UIMsg.f_FUN.FUN_ID_SCH_POI_ACTION /* 110102 */:
                setDownloadListener(new com.byazt.ocd.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 110103:
                setSplashAdListener(new com.byazt.vw.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 110106:
                setSplashCardListener(new com.byazt.vw.tt((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 110108:
                showSplashView((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                showSplashCardView((ViewGroup) pluginValueSetTt.objectValue(0, ViewGroup.class), (Activity) pluginValueSetTt.objectValue(1, Activity.class));
                return null;
            case 110110:
                return getMediationManager();
            default:
                return super.apply(sparseArray);
        }
    }
}
