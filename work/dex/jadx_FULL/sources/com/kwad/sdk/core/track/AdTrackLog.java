package com.kwad.sdk.core.track;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.helper.b;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.as;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class AdTrackLog extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int NEGATIVE_RESULT = 2;
    public static final int POSITIVE_RESULT = 1;
    private static int sLiveSupportMode = 2;
    private static final long serialVersionUID = 6629369763953107007L;
    public int adLiveComponentReady;
    public int adLiveSwitch;
    public int adTkLiveSwitch;
    public String apiSdkVersion;
    public int isPlugin;
    public int ksUaPattern;
    public int preLandingPageShowType;
    public int preLandingPageSwitch;
    public int rewardAdvanceSwitch;
    public int rewardDetailCallPositionY;
    public int rewardDetailStatusBarHeight;
    public int rewardSkipShowTime;
    public String sceneId;
    public int screenOrientation;
    public int serverCheckSwitch;
    public String templateId;
    public int unionMark;

    private AdTrackLog() {
    }

    @Nullable
    public static AdTrackLog createFromJson(String str) {
        try {
            AdTrackLog adTrackLog = new AdTrackLog();
            adTrackLog.parseJson(new JSONObject(str));
            return adTrackLog;
        } catch (Exception unused) {
            return null;
        }
    }

    private int toReportInt(boolean z) {
        return z ? 1 : 2;
    }

    public void bindABParams(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        AdInfo adInfoEO = e.eO(adTemplate);
        this.adLiveComponentReady = toReportInt(((f) ServiceProvider.get(f.class)).tu());
        this.adLiveSwitch = toReportInt(com.kwad.sdk.core.response.helper.a.cY(adInfoEO));
        this.adTkLiveSwitch = toReportInt(TextUtils.isEmpty(b.eL(adInfoEO)));
        if (sLiveSupportMode == 2 && ((f) ServiceProvider.get(f.class)).tu()) {
            sLiveSupportMode = 1;
        }
        this.adLiveComponentReady = sLiveSupportMode;
        this.serverCheckSwitch = toReportInt(com.kwad.sdk.core.response.helper.a.dm(adInfoEO));
        this.rewardAdvanceSwitch = toReportInt(com.kwad.sdk.core.response.helper.a.dn(adInfoEO));
        this.rewardSkipShowTime = com.kwad.sdk.core.response.helper.a.ai(adInfoEO);
        this.preLandingPageSwitch = toReportInt(b.eJ(adInfoEO));
        this.preLandingPageShowType = b.eK(adInfoEO);
        this.apiSdkVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
        this.isPlugin = toReportInt(((f) ServiceProvider.get(f.class)).Fu());
        this.screenOrientation = toReportInt(as.isOrientationPortrait());
    }

    public void setKsUaPattern(boolean z) {
        this.ksUaPattern = toReportInt(z);
    }

    public void setUnionMark(boolean z) {
        this.unionMark = toReportInt(z);
    }

    public AdTrackLog(String str, String str2) {
        this.templateId = str;
        this.sceneId = str2;
    }
}
