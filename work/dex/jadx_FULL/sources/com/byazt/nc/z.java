package com.byazt.nc;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 133})
public abstract class z extends x {
    public static final String REWARD_EXTRA_KEY_ERROR_CODE = "reward_extra_key_error_code";
    public static final String REWARD_EXTRA_KEY_ERROR_MSG = "reward_extra_key_error_msg";
    public static final String REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD = "reward_extra_key_has_video_complete_reward";
    public static final String REWARD_EXTRA_KEY_IS_SERVER_VERIFY = "reward_extra_key_is_server_verify";
    public static final String REWARD_EXTRA_KEY_REWARD_AMOUNT = "reward_extra_key_reward_amount";
    public static final String REWARD_EXTRA_KEY_REWARD_NAME = "reward_extra_key_reward_name";
    public static final String REWARD_EXTRA_KEY_REWARD_PROPOSE = "reward_extra_key_reward_propose";
    public static final int REWARD_TYPE_CLICK_LANDING = 4;
    public static final int REWARD_TYPE_DEFAULT = 0;
    public static final int REWARD_TYPE_INTERACT = 1;
    public static final int REWARD_TYPE_PLAYABLE = 3;
    public static final int REWARD_TYPE_VIDEO_COMPLETE = 2;
    public PluginValueSet c;

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(120001, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.z.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(z.this.getInteractionType());
            }
        }));
        cVarC.c(120002, com.byazt.lq.uj.c(new Supplier<Map<String, Object>>() { // from class: com.byazt.nc.z.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return z.this.getMediaExtraInfo();
            }
        }));
        cVarC.c(120003, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.z.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(z.this.getRewardVideoAdType());
            }
        }));
        cVarC.c(120004, com.byazt.lq.uj.c(new Supplier<Long>() { // from class: com.byazt.nc.z.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(z.this.getExpirationTimestamp());
            }
        }));
        return cVarC.tt();
    }

    public abstract long getExpirationTimestamp();

    public abstract int getInteractionType();

    public abstract Map<String, Object> getMediaExtraInfo();

    public abstract com.byazt.sbm.a getMediationManager();

    public abstract int getRewardVideoAdType();

    public abstract void setDownloadListener(com.byazt.ocd.ve veVar);

    public abstract void setRewardAdInteractionListener(com.byazt.tn.c cVar);

    public abstract void setRewardPlayAgainController(com.byazt.tn.tt ttVar);

    public abstract void setRewardPlayAgainInteractionListener(com.byazt.tn.c cVar);

    public abstract void showRewardVideoAd(Activity activity);

    public abstract void showRewardVideoAd(Activity activity, Object obj, String str);

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
        if (iIntValue == 121109) {
            return getMediationManager();
        }
        switch (iIntValue) {
            case 120101:
                setRewardAdInteractionListener(new com.byazt.tn.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 120102:
                setRewardPlayAgainInteractionListener(new com.byazt.tn.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 120103:
                setRewardPlayAgainController(new com.byazt.tn.tt((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 120104:
                setDownloadListener(new com.byazt.ocd.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 120105:
                showRewardVideoAd((Activity) pluginValueSetTt.objectValue(0, Activity.class));
                return null;
            case 120106:
                showRewardVideoAd((Activity) pluginValueSetTt.objectValue(0, Activity.class), pluginValueSetTt.objectValue(1, Object.class), (String) pluginValueSetTt.objectValue(2, String.class));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
