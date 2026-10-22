package com.byazt.jt;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME, 20})
public class c {
    public static final SparseArray<Object> c(final IMediationConfig iMediationConfig) {
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        if (iMediationConfig == null) {
            return null;
        }
        veVarC.c(264101, new Supplier<String>() { // from class: com.byazt.jt.c.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getPublisherDid();
            }
        });
        veVarC.c(264102, new Supplier<Boolean>() { // from class: com.byazt.jt.c.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isOpenAdnTest());
            }
        });
        veVarC.c(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? ve.c(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        veVarC.c(264104, new Supplier<Map<String, Object>>() { // from class: com.byazt.jt.c.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return iMediationConfig.getLocalExtra();
            }
        });
        veVarC.c(264105, new Supplier<Boolean>() { // from class: com.byazt.jt.c.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.getHttps());
            }
        });
        veVarC.c(264106, new Supplier<JSONObject>() { // from class: com.byazt.jt.c.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return iMediationConfig.getCustomLocalConfig();
            }
        });
        veVarC.c(264107, new Supplier<String>() { // from class: com.byazt.jt.c.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getOpensdkVer();
            }
        });
        veVarC.c(264108, new Supplier<Boolean>() { // from class: com.byazt.jt.c.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isWxInstalled());
            }
        });
        veVarC.c(264109, new Supplier<Boolean>() { // from class: com.byazt.jt.c.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportH265());
            }
        });
        veVarC.c(264110, new Supplier<Boolean>() { // from class: com.byazt.jt.c.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportSplashZoomout());
            }
        });
        veVarC.c(264111, new Supplier<String>() { // from class: com.byazt.jt.c.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.wxAppId();
            }
        });
        return veVarC.tt().sparseArray();
    }
}
