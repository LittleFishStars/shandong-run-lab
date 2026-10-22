package com.byazt.jt;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME, 13})
public class tt {
    public static final SparseArray<Object> c(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        veVarC.c(262114, new Supplier<List<String>>() { // from class: com.byazt.jt.tt.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        veVarC.c(262115, new Supplier<List<String>>() { // from class: com.byazt.jt.tt.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        veVarC.c(262116, new Supplier<Boolean>() { // from class: com.byazt.jt.tt.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        veVarC.c(262117, new Supplier<Boolean>() { // from class: com.byazt.jt.tt.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        veVarC.c(262118, new Supplier<Boolean>() { // from class: com.byazt.jt.tt.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return veVarC.tt().sparseArray();
    }
}
