package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    private static final HashMap<String, f> vo = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.j.d sm;
    private KsRewardVideoAd.RewardAdInteractionListener vp;

    @Nullable
    private static f N(String str) {
        return vo.get(str);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener O(String str) {
        f fVarN = N(str);
        if (fVarN != null) {
            return fVarN.vp;
        }
        return null;
    }

    public static void P(String str) {
        f fVarN = N(str);
        if (fVarN != null) {
            fVarN.vp = fVarN.mInteractionListener;
        }
    }

    public static com.kwad.components.core.j.d Q(String str) {
        f fVarN = N(str);
        if (fVarN != null) {
            return fVarN.sm;
        }
        return null;
    }

    public static void R(String str) {
        f fVarN = N(str);
        if (fVarN != null) {
            fVarN.destroy();
            vo.put(str, null);
        }
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.sm = dVar;
        fVar.vp = rewardAdInteractionListener;
        vo.put(str, fVar);
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.vp = null;
        com.kwad.components.core.j.d dVar = this.sm;
        if (dVar != null) {
            dVar.destroy();
            this.sm = null;
        }
    }
}
