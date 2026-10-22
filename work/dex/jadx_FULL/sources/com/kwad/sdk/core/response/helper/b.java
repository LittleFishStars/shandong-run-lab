package com.kwad.sdk.core.response.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.br;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private static Random aXC = new Random();

    public static int a(boolean z, @NonNull AdInfo adInfo) {
        return z ? adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType : adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    @NonNull
    public static AdMatrixInfo cO(@NonNull AdTemplate adTemplate) {
        return e.eG(adTemplate) ? e.eO(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cP(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).styles.templateList;
    }

    @NonNull
    public static AdMatrixInfo.AdDataV2 cQ(@NonNull AdTemplate adTemplate) {
        return e.eO(adTemplate).adMatrixInfo.adDataV2;
    }

    public static FeedSlideConf cR(@NonNull AdTemplate adTemplate) {
        JSONArray jSONArrayOptJSONArray;
        AdMatrixInfo.TemplateData templateDataU = u(adTemplate, m1064do(adTemplate).templateId);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(templateDataU != null ? templateDataU.data : "").optJSONObject("slideInfo");
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("angle")) != null && jSONArrayOptJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) jSONArrayOptJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) jSONArrayOptJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo cS(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String cT(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, cO(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew cU(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String cV(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        boolean z = e.fi(adTemplate) || e.eI(adTemplate) == 2;
        if (a.cY(adInfoEO)) {
            return "";
        }
        if (z && a.cN(adTemplate)) {
            AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dU(adTemplate).templateId);
            return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateT2 = t(adTemplate, cU(adTemplate).templateId);
        return matrixTemplateT2 != null ? matrixTemplateT2.templateUrl : "";
    }

    public static long cW(@NonNull AdTemplate adTemplate) {
        return cU(adTemplate).maxTimeOut;
    }

    public static boolean cX(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cV(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo cY(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String cZ(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, cY(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    @Nullable
    public static int dA(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dp(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static double dB(@NonNull AdTemplate adTemplate) {
        return e.eO(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean dC(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ds(adTemplate));
    }

    public static boolean dD(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dt(adTemplate).templateId);
    }

    public static boolean dE(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.NativeTKInfo nativeTKInfoDu = du(adTemplate);
        return (nativeTKInfoDu == null || TextUtils.isEmpty(nativeTKInfoDu.templateId) || nativeTKInfoDu.renderType != 1) ? false : true;
    }

    public static boolean dF(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ex(adTemplate));
    }

    public static String dG(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo feedTKInfoDt = dt(adTemplate);
        return TextUtils.isEmpty(feedTKInfoDt.templateId) ? "ksad-feed-card" : feedTKInfoDt.templateId;
    }

    public static boolean dH(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dv(adTemplate));
    }

    public static boolean dI(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.feedInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dJ(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.feedInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dK(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.nativeAdInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            try {
                return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.bidirectionalSwitch;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                return false;
            }
        }
    }

    public static boolean dL(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dN(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dO(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dP(@NonNull AdInfo adInfo) {
        if (dQ(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dQ(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String dS(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.subtitle;
        } catch (Exception unused) {
            return "摇一摇";
        }
    }

    public static long dT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dV(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dW(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean dX(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dY(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dZ(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static long da(@NonNull AdTemplate adTemplate) {
        return v(adTemplate, cY(adTemplate).templateId);
    }

    public static long db(@NonNull AdTemplate adTemplate) {
        return ((long) cY(adTemplate).changeTime) * 1000;
    }

    public static int dc(@NonNull AdTemplate adTemplate) {
        return cY(adTemplate).maxTimesPerDay;
    }

    public static long dd(@NonNull AdTemplate adTemplate) {
        return cY(adTemplate).intervalTime;
    }

    public static boolean de(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        return !a.aL(adInfoEO) && a.az(adInfoEO);
    }

    public static boolean df(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cZ(adTemplate)) && da(adTemplate) > 0) {
            return as.isOrientationPortrait();
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate dg(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String dh(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dg(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo di(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String dj(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, di(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static boolean dk(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dj(adTemplate));
    }

    @Nullable
    private static String dl(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, e.eO(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static String dm(@NonNull AdTemplate adTemplate) {
        return dn(adTemplate) ? dl(adTemplate) : a.aY(e.eO(adTemplate));
    }

    private static boolean dn(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.cL(adTemplate) || !dQ(e.eO(adTemplate))) ? false : true;
    }

    @NonNull
    /* JADX INFO: renamed from: do, reason: not valid java name */
    private static AdMatrixInfo.FeedInfo m1064do(@NonNull AdTemplate adTemplate) {
        return dq(adTemplate) ? cO(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo : cO(adTemplate).adDataV2.feedInfo;
    }

    @NonNull
    private static AdMatrixInfo.NativeMatrixAdInfo dp(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.nativeAdInfo;
    }

    private static boolean dq(@NonNull AdTemplate adTemplate) {
        return a.cY(e.eO(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo dr(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String ds(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, m1064do(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo dt(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.feedTKCardInfo;
    }

    public static AdMatrixInfo.NativeTKInfo du(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.nativeTKCardInfo;
    }

    @Nullable
    public static String dv(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dr(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    @Nullable
    public static boolean dw(@NonNull AdTemplate adTemplate) {
        return m1064do(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    @Nullable
    public static boolean dx(@NonNull AdTemplate adTemplate) {
        return m1064do(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int dy(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = m1064do(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    @Nullable
    public static boolean dz(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dp(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return false;
        }
        return shakeInfo.enable;
    }

    public static boolean eA(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static String eB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String eC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String eD(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String eE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts eF(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts eG(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean eH(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean eI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static boolean eJ(@NonNull AdInfo adInfo) {
        return (a.bQ(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int eK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String eL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean eM(@NonNull AdInfo adInfo) {
        return a.bj(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static boolean ea(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static int eb(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean ec(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean ed(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int ee(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int ef(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean eg(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean eh(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean ei(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean ej(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean ek(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean el(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean em(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 10;
        } catch (Exception unused) {
        }
    }

    public static boolean en(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 9;
        } catch (Exception unused) {
        }
    }

    public static boolean eo(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 12;
        } catch (Exception unused) {
        }
    }

    public static boolean ep(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 14;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean eq(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i == 4 || i == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean er(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
        } catch (Exception unused) {
        }
    }

    public static boolean es(@NonNull AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception unused) {
        }
    }

    public static long et(@NonNull AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            return j <= 0 ? com.igexin.push.config.c.j : j;
        } catch (Exception unused) {
            return com.igexin.push.config.c.j;
        }
    }

    public static boolean eu(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ev(@NonNull AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception unused) {
        }
    }

    public static float ew(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static boolean ex(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean ey(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float ez(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static boolean fm(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).cP(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.de(adInfo) || a.bQ(adInfo)) ? false : true;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate t(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cO(adTemplate).styles.templateList) {
            if (br.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    private static AdMatrixInfo.TemplateData u(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cO(adTemplate).adDataV2.templateDataList) {
            if (br.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long v(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData templateDataU = u(adTemplate, str);
        if (templateDataU != null) {
            return templateDataU.templateDelayTime;
        }
        return 0L;
    }

    public static AdMatrixInfo.RotateInfo dL(@NonNull AdTemplate adTemplate) {
        try {
            return e.eO(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dM(@NonNull AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = m1064do(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dN(@NonNull AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = dp(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate dO(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.complianceCardInfo;
    }

    public static boolean dQ(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dP(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate dR(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String dS(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dR(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static boolean dT(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dS(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dU(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo dV(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dW(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo ec(@NonNull AdTemplate adTemplate) {
        return e.eO(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static boolean ed(@NonNull AdTemplate adTemplate) {
        return cQ(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long ee(@NonNull AdTemplate adTemplate) {
        long j = cQ(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    public static String ef(AdTemplate adTemplate) {
        return cQ(adTemplate).topFloorTKInfo.templateId;
    }

    public static String eg(AdTemplate adTemplate) {
        return cQ(adTemplate).neoTKInfo.templateId;
    }

    public static String eh(AdTemplate adTemplate) {
        return cQ(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String ei(AdTemplate adTemplate) {
        return cQ(adTemplate).innerEcLiveTKInfo.templateId;
    }

    public static String ej(AdTemplate adTemplate) {
        return cQ(adTemplate).videoImageTKInfo.templateId;
    }

    public static String ek(AdTemplate adTemplate) {
        return cQ(adTemplate).fullScreenInfo.templateId;
    }

    public static String el(AdTemplate adTemplate) {
        return cQ(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String em(AdTemplate adTemplate) {
        return cQ(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String en(AdTemplate adTemplate) {
        return cQ(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String eo(AdTemplate adTemplate) {
        return cQ(adTemplate).bannerTKInfo.templateId;
    }

    public static String eq(AdTemplate adTemplate) {
        return cQ(adTemplate).confirmTKInfo.templateId;
    }

    public static String er(AdTemplate adTemplate) {
        return cQ(adTemplate).activityTKInfo.templateId;
    }

    public static String es(AdTemplate adTemplate) {
        return cQ(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String et(AdTemplate adTemplate) {
        return cQ(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String eu(AdTemplate adTemplate) {
        return cQ(adTemplate).pushTKInfo.templateId;
    }

    public static String ev(AdTemplate adTemplate) {
        return cQ(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static float dI(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = e.eO(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean dJ(@NonNull AdTemplate adTemplate) {
        try {
            return e.eO(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    @Nullable
    public static String dP(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dO(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static long dX(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dY(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static AdMatrixInfo.AdBannerTKInfo dZ(@NonNull AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean ea(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        if (g(adInfoEO) || e.fa(adTemplate)) {
            return false;
        }
        return !(cU(adTemplate).cardType == 4) && e.eO(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && adInfoEO.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean eb(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        if (g(adInfoEO) || e.fa(adTemplate)) {
            return false;
        }
        return ((cU(adTemplate).cardType == 4) || e.eO(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || adInfoEO.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static String ep(AdTemplate adTemplate) {
        return cQ(adTemplate).interstitialCardInfo.templateId;
    }

    public static String ew(AdTemplate adTemplate) {
        return cQ(adTemplate).feedTKCardInfo.templateId;
    }

    public static String ex(AdTemplate adTemplate) {
        return cQ(adTemplate).drawTKCardInfo.templateId;
    }

    public static int ey(AdTemplate adTemplate) {
        return cQ(adTemplate).innerEcAuthInfo.cancelClosureAuthTime;
    }

    public static float dK(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = e.eO(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }
}
