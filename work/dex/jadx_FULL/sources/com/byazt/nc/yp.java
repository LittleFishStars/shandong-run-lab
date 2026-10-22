package com.byazt.nc;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 215})
public abstract class yp extends x {
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(150001, com.byazt.lq.uj.c(new Supplier<View>() { // from class: com.byazt.nc.yp.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public View get() {
                return yp.this.getExpressAdView();
            }
        }));
        cVarC.c(150002, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.yp.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(yp.this.getImageMode());
            }
        }));
        cVarC.c(150003, com.byazt.lq.uj.c(new Supplier<uj>() { // from class: com.byazt.nc.yp.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public uj get() {
                return yp.this.getDislikeInfo();
            }
        }));
        cVarC.c(150004, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.yp.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(yp.this.getInteractionType());
            }
        }));
        cVarC.c(150005, com.byazt.lq.uj.c(new Supplier<Map<String, Object>>() { // from class: com.byazt.nc.yp.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return yp.this.getMediaExtraInfo();
            }
        }));
        return cVarC.tt();
    }

    public abstract void destroy();

    public abstract sp getDislikeDialog(Activity activity);

    public abstract uj getDislikeInfo();

    public abstract View getExpressAdView();

    public abstract int getImageMode();

    public abstract int getInteractionType();

    public abstract String getLifecycleId();

    public abstract Map<String, Object> getMediaExtraInfo();

    public abstract com.byazt.sbm.n getMediationManager();

    public abstract void registerClickableRects(JSONObject jSONObject);

    public abstract void render();

    public abstract void setCanInterruptVideoPlay(boolean z);

    public abstract void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar);

    public abstract void setDislikeDialog(Dialog dialog, Integer[] numArr);

    public abstract void setDownloadListener(com.byazt.ocd.ve veVar);

    public abstract void setExpressInteractionListener(com.byazt.ft.c cVar);

    public abstract void setExpressInteractionListener(com.byazt.ft.tt ttVar);

    public abstract void setSlideIntervalTime(int i);

    public abstract void setVideoAdListener(com.byazt.ft.ve veVar);

    public abstract void showInteractionExpressAd(Activity activity);

    public abstract void unRegisterRects();

    public abstract void uploadDislikeEvent(String str);

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
        if (iIntValue == -99999986) {
            return values().sparseArray();
        }
        switch (iIntValue) {
            case 150101:
                setExpressInteractionListener(new com.byazt.ft.tt((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 150102:
                setExpressInteractionListener(new com.byazt.ft.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 150103:
                setDownloadListener(new com.byazt.ocd.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 150104:
                render();
                return null;
            case 150105:
                destroy();
                return null;
            case 150106:
                setDislikeCallback((Activity) pluginValueSetTt.objectValue(0, Activity.class), new com.byazt.dhf.c((Function) pluginValueSetTt.objectValue(1, Function.class)));
                return null;
            case 150107:
                Dialog dialog = (Dialog) pluginValueSetTt.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) pluginValueSetTt.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                setDislikeDialog(dialog, numArr);
                return null;
            case 150108:
                return getDislikeDialog((Activity) pluginValueSetTt.objectValue(0, Activity.class));
            case 150109:
                pluginValueSetTt.objectValue(0, Activity.class);
                return null;
            case 150110:
                setSlideIntervalTime(pluginValueSetTt.intValue(0));
                return null;
            case 150111:
                setVideoAdListener(new com.byazt.ft.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 150112:
                setCanInterruptVideoPlay(pluginValueSetTt.booleanValue(0));
                return null;
            case 150113:
                return getMediationManager();
            case 150114:
                uploadDislikeEvent((String) pluginValueSetTt.objectValue(0, String.class));
                return null;
            case 150115:
                registerClickableRects((JSONObject) pluginValueSetTt.objectValue(0, JSONObject.class));
                return null;
            case 150116:
                unRegisterRects();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
