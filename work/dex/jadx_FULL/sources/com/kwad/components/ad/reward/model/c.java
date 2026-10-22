package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;
    public final boolean jM = com.kwad.components.ad.reward.a.b.hZ();

    @Nullable
    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfigB;
        if (e.KC()) {
            ksVideoPlayConfigB = com.kwad.components.core.internal.api.e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfigB = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData adResultDataD = f.oU().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (adResultDataD == null) {
                return null;
            }
            return a(adResultDataD, intExtra, ksVideoPlayConfigB);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!e.KC() && com.kwad.sdk.core.response.helper.e.fe(adTemplate) < 0) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(com.kwad.sdk.core.response.helper.a.M(adInfo));
            if (fileCO == null || !fileCO.exists()) {
                return false;
            }
        }
        return true;
    }

    public final AdInfo da() {
        return this.mAdInfo;
    }

    public final boolean db() {
        return com.kwad.sdk.core.response.helper.e.fa(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final boolean iF() {
        return com.kwad.sdk.core.response.helper.e.n(getAdTemplate(), com.kwad.components.ad.reward.a.b.l(da()));
    }

    public final boolean iG() {
        return com.kwad.sdk.core.response.helper.e.S(getAdTemplate());
    }

    public final AdResultData iH() {
        return this.mAdResultData;
    }

    public final KsVideoPlayConfig iI() {
        return this.mVideoPlayConfig;
    }

    public final int iJ() {
        return this.rewardType;
    }

    public final JSONObject iK() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo iL() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    @Nullable
    private static c a(AdResultData adResultData, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        c cVar = new c();
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        if (adTemplateR == null) {
            com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplateR);
        if (!c(adTemplateR, adInfoEO)) {
            return null;
        }
        boolean zIsShowLandscape = ksVideoPlayConfig.isShowLandscape();
        adTemplateR.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = adTemplateR;
        cVar.mAdInfo = adInfoEO;
        cVar.mScreenOrientation = zIsShowLandscape ? 1 : 0;
        cVar.rewardType = i;
        return cVar;
    }
}
