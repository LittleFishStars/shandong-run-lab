package com.kwad.sdk.core.response.helper;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kc.openset.advertisers.hl.HLADNID;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdCouponReceiveParam;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bz;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    public static String J(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static long L(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String M(@NonNull AdInfo adInfo) {
        return bb(adInfo).materialUrl;
    }

    public static int N(@NonNull AdInfo adInfo) {
        return bk(adInfo) == 2 ? ba(adInfo).videoDuration : bb(adInfo).videoDuration;
    }

    public static String Nx() {
        return com.ipd.dsp.internal.b1.b.a.n;
    }

    public static long O(@NonNull AdInfo adInfo) {
        return ((long) (bk(adInfo) == 2 ? ba(adInfo).videoDuration : bb(adInfo).videoDuration)) * 1000;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature P(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        return ar.Z(list) ? list.get(0) : new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    public static String Q(@NonNull AdInfo adInfo) {
        int iBk = bk(adInfo);
        if (iBk == 1) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType != 1 && !TextUtils.isEmpty(materialFeature.firstFrame)) {
                    return materialFeature.firstFrame;
                }
            }
        } else if (iBk == 2 || iBk == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature2.featureType == 2 && !TextUtils.isEmpty(materialFeature2.firstFrame)) {
                    return materialFeature2.firstFrame;
                }
            }
            while (r0.hasNext()) {
                if (materialFeature.featureType != 1) {
                }
            }
        } else if (iBk != 8) {
            return "";
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature3 : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature3.featureType == 3 && !TextUtils.isEmpty(materialFeature3.firstFrame)) {
                return materialFeature3.firstFrame;
            }
        }
        return "";
    }

    public static boolean R(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int S(@NonNull AdInfo adInfo) {
        return bb(adInfo).videoWidth;
    }

    public static int T(@NonNull AdInfo adInfo) {
        return bb(adInfo).videoHeight;
    }

    public static boolean U(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId);
    }

    public static boolean V(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean W(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    @Nullable
    public static List<Integer> X(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.dynamicAdStyleInfo.slideInfo.angle;
    }

    public static boolean Y(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static boolean Z(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = bb(adInfo);
        return materialFeatureBb.videoWidth <= materialFeatureBb.videoHeight;
    }

    public static boolean a(AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        return (smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(smallAppJumpInfo.originId) || TextUtils.isEmpty(smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static String aA(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String aB(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    private static String aC(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String aD(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String aE(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String aF(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float aG(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.appScore;
        if (i <= 0) {
            return 0.0f;
        }
        return i / 10.0f;
    }

    public static boolean aH(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aI(@NonNull AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        return f < 45.0f ? 4.5f : 5.0f;
    }

    public static String aJ(AdInfo adInfo) {
        return br.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aK(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return aL(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean aL(@NonNull AdInfo adInfo) {
        return aW(adInfo) == 1;
    }

    public static boolean aM(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int aN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aQ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aS(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aU(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static boolean aV(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && aL(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aW(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static int aX(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aY(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : al.d(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.h5Url, aH(adInfo));
    }

    public static int aZ(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    @Deprecated
    public static String aa(@NonNull AdInfo adInfo) {
        int iBk = bk(adInfo);
        if (iBk == 1) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType != 1 && !TextUtils.isEmpty(materialFeature.coverUrl)) {
                    return materialFeature.coverUrl;
                }
            }
        } else if (iBk == 2 || iBk == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature2.featureType == 2) {
                    if (!TextUtils.isEmpty(materialFeature2.materialUrl)) {
                        return materialFeature2.materialUrl;
                    }
                    if (!TextUtils.isEmpty(materialFeature2.coverUrl)) {
                        return materialFeature2.coverUrl;
                    }
                }
            }
            while (r0.hasNext()) {
                if (materialFeature.featureType != 1) {
                }
            }
        } else if (iBk != 8) {
            return "";
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature3 : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature3.featureType == 3 && !TextUtils.isEmpty(materialFeature3.coverUrl)) {
                return materialFeature3.coverUrl;
            }
        }
        return "";
    }

    public static String ab(@NonNull AdInfo adInfo) {
        int iBk = bk(adInfo);
        if (iBk != 1) {
            if (iBk != 2 && iBk != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return bd(adInfo).blurBackgroundUrl;
    }

    private static int ac(@NonNull AdInfo adInfo) {
        return bb(adInfo).width;
    }

    private static int ad(@NonNull AdInfo adInfo) {
        return bb(adInfo).height;
    }

    public static long ae(@NonNull AdInfo adInfo) {
        return bb(adInfo).photoId;
    }

    public static String af(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long ag(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static long ah(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature;
        int iMin = adInfo.adRewardInfo.rewardTime;
        if (adInfo.adMaterialInfo.materialFeatureList.size() > 0 && (materialFeature = adInfo.adMaterialInfo.materialFeatureList.get(0)) != null) {
            int i = materialFeature.videoDuration;
            long j = materialFeature.videoDurationMs;
            if (i > 0) {
                iMin = Math.min(iMin, i);
            } else if (j > 0) {
                iMin = Math.min(iMin, (int) (j / 1000));
            }
        }
        return iMin;
    }

    public static int ai(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long aj(@NonNull AdInfo adInfo) {
        return ((long) adInfo.adRewardInfo.skipShowTime) * 1000;
    }

    public static long ak(@NonNull AdInfo adInfo) {
        return ((long) adInfo.adRewardInfo.rewardTime) * 1000;
    }

    private static int al(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean am(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int an(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ao(@NonNull AdInfo adInfo) {
        return al(adInfo) != 0;
    }

    public static long ap(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return ((long) adStyleConfInfo.fullScreenSkipShowTime) * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long aq(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int ar(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adStyleConfInfo.slideConvertInfo.convertDistance;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static String as(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adStyleConfInfo.slideConvertInfo.convertSlideDirection;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return HLADNID.Reason.OTHER;
        }
    }

    public static int at(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean au(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean av(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean aw(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ax(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean ay(@NonNull AdInfo adInfo) {
        return !aL(adInfo) && az(adInfo);
    }

    public static boolean az(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aU(adInfo) && aT(adInfo) == 1) || de(adInfo)) ? false : true;
        }
        return false;
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z) {
        return ((z && aL(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || br.isNullString(aY(adInfo))) ? false : true;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b bA(@NonNull AdInfo adInfo) {
        boolean z;
        String strQ = Q(adInfo);
        int iS = S(adInfo);
        int iT = T(adInfo);
        if (br.isNullString(strQ) || br.ig(strQ) || iS == 0 || iT == 0) {
            strQ = aa(adInfo);
            iS = ac(adInfo);
            iT = ad(adInfo);
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        String str = strQ;
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z2 + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, iS, iT, true, z2);
    }

    public static String bB(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bC(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bD(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bE(AdInfo adInfo) {
        if (aL(adInfo)) {
            AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
            if (complianceInfo == null) {
                return -1;
            }
            return complianceInfo.materialJumpType;
        }
        AdInfo.UnDownloadRegionConf unDownloadRegionConf = adInfo.unDownloadConf.unDownloadRegionConf;
        if (unDownloadRegionConf == null) {
            return -1;
        }
        return unDownloadRegionConf.materialJumpType;
    }

    public static boolean bF(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bG(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i = adInfo.status;
        if (i == 0) {
            return 1;
        }
        if (1 == i || 2 == i || 3 == i || 4 == i) {
            return 2;
        }
        return 8 == i ? 3 : 0;
    }

    public static int bH(AdInfo adInfo) {
        return adInfo.status;
    }

    @Nullable
    public static String bI(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String bJ(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String bK(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bL(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    @Nullable
    public static String bM(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bN(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bO(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bP(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bQ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (bU(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static long bR(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static int bS(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bT(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    public static boolean bU(AdInfo adInfo) {
        return as.isOrientationPortrait() ? bW(adInfo) : bV(adInfo);
    }

    private static boolean bV(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    private static boolean bW(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    @Nullable
    public static String bX(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String bY(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String bZ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature ba(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature bb(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean bc(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = bi(adInfo) ? bb(adInfo) : ba(adInfo);
        return materialFeatureBb.height > materialFeatureBb.width;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature bd(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean be(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = bb(adInfo);
        return materialFeatureBb.height > materialFeatureBb.width;
    }

    public static String bf(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> bg(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iBk = bk(adInfo);
        if (iBk != 2 && iBk != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    @NonNull
    public static String bh(@NonNull AdInfo adInfo) {
        if (bi(adInfo)) {
            return M(adInfo);
        }
        List<String> listBg = bg(adInfo);
        return listBg.size() > 0 ? listBg.get(0) : "";
    }

    public static boolean bi(@NonNull AdInfo adInfo) {
        return bk(adInfo) == 1;
    }

    public static boolean bj(@NonNull AdInfo adInfo) {
        return ba(adInfo).featureType == 2;
    }

    public static int bk(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    return i != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i2;
    }

    public static int bl(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static int bm(AdInfo adInfo) {
        AdInfo.AdLiveTypeInfo adLiveTypeInfo;
        AdInfo.AdDrawInfo adDrawInfo = adInfo.adDrawInfo;
        if (adDrawInfo == null || (adLiveTypeInfo = adDrawInfo.liveTypeInfo) == null) {
            return 7;
        }
        return adLiveTypeInfo.actionbarCardType;
    }

    public static String bn(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bo(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static boolean bp(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bq(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpAppMkt;
    }

    public static int br(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpTimeOut;
    }

    public static boolean bs(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bt(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static boolean bu(AdInfo adInfo) {
        try {
            return new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() != 0;
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static List<Integer> bv(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int i = Integer.parseInt(str2);
                    if (i > 0) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    @NonNull
    private static int[] bw(@NonNull AdInfo adInfo) {
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length < 3) {
                return iArr;
            }
            iArr[0] = Integer.parseInt(strArrSplit[0]);
            iArr[1] = Integer.parseInt(strArrSplit[1]);
            iArr[2] = Integer.parseInt(strArrSplit[2]);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return iArr;
    }

    public static int bx(@NonNull AdInfo adInfo) {
        int i = bw(adInfo)[0];
        if (i > 0) {
            return i;
        }
        return 3;
    }

    public static int by(@NonNull AdInfo adInfo) {
        int i = bw(adInfo)[1];
        if (i <= 0) {
            i = 3;
        }
        return i + bx(adInfo);
    }

    public static int bz(@NonNull AdInfo adInfo) {
        int i = bw(adInfo)[2];
        if (i <= 0) {
            i = 3;
        }
        return i + by(adInfo);
    }

    public static AdInfo.CutRuleInfo cA(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cB(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean cC(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int cD(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int cE(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cF(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String cG(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static int cH(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static boolean cI(@NonNull AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        return i == 2 || i == 3;
    }

    public static boolean cJ(@Nullable AdInfo adInfo) {
        if (!cK(adInfo)) {
            return false;
        }
        int i = adInfo.adSplashInfo.skipType;
        return i == 0 || i == 2;
    }

    public static String cK(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2 && !cX(e.eO(adTemplate)) && !cY(e.eO(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return com.ipd.dsp.internal.b1.b.a.o;
        }
        AdInfo adInfoEO = e.eO(adTemplate);
        return TextUtils.isEmpty(adInfoEO.adBaseInfo.installAppLabel) ? com.ipd.dsp.internal.b1.b.a.o : adInfoEO.adBaseInfo.installAppLabel;
    }

    public static boolean cL(AdTemplate adTemplate) {
        return e.eO(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    public static String cM(AdTemplate adTemplate) {
        return e.eO(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    public static int cN(@NonNull AdInfo adInfo) {
        double d = adInfo.adSplashInfo.impressionLimitSize;
        if (d <= AudioStats.AUDIO_AMPLITUDE_NONE || d > 1.0d) {
            d = 0.699999988079071d;
        }
        return ((int) d) * 100;
    }

    public static boolean cO(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String cP(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cQ(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 3;
    }

    public static boolean cR(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cS(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 1;
    }

    @Nullable
    public static String cT(@NonNull AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i >= 200 && i < 10000) {
            return String.valueOf(i);
        }
        if (i < 10000) {
            return null;
        }
        double d = ((double) i) / 10000.0d;
        return new DecimalFormat("0.0").format(d) + "w";
    }

    public static String cU(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cV(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean cW(@NonNull AdInfo adInfo) {
        int i = adInfo.adStyleConfInfo.innerAdType;
        return i == 4 || i == 5;
    }

    @Deprecated
    public static boolean cX(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 7;
    }

    public static boolean cY(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && cw(adInfo) != 0;
    }

    public static boolean cZ(@NonNull AdInfo adInfo) {
        return cY(adInfo) || cX(adInfo);
    }

    @Nullable
    public static String ca(AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.serverExt) == null) {
            return null;
        }
        return str;
    }

    @Nullable
    public static String cb(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.adExt;
    }

    public static boolean cc(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean cd(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean ce(AdInfo adInfo) {
        AdInfo.AdBannerInfo adBannerInfo;
        return (adInfo == null || (adBannerInfo = adInfo.adBannerInfo) == null || adBannerInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean cf(AdInfo adInfo) {
        AdInfo.AdBannerInfo adBannerInfo;
        if (adInfo == null || (adBannerInfo = adInfo.adBannerInfo) == null) {
            return false;
        }
        int i = adBannerInfo.videoAutoPlayType;
        return i == 1 || i == 0;
    }

    public static boolean cg(AdInfo adInfo) {
        AdInfo.AdBannerInfo adBannerInfo;
        return (adInfo == null || (adBannerInfo = adInfo.adBannerInfo) == null || adBannerInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean ch(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean ci(AdInfo adInfo) {
        AdInfo.AdDrawInfo adDrawInfo;
        return (adInfo == null || (adDrawInfo = adInfo.adDrawInfo) == null || adDrawInfo.videoSoundType != 1) ? false : true;
    }

    public static boolean cj(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i = adFeedInfo.videoAutoPlayType;
        return i == 1 || i == 0;
    }

    public static boolean ck(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean cl(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 3) ? false : true;
    }

    public static boolean cm(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        return (hVar == null || !hVar.Gb()) && !TextUtils.isEmpty(aY(adInfo)) && adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse == 1;
    }

    @NonNull
    public static String cn(@NonNull AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        return TextUtils.isEmpty(str) ? "浏览页面" : str;
    }

    public static int co(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    public static int cp(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    public static int cq(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    public static boolean cr(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        AdInfo.H5Config h5Config;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null || (h5Config = adBaseInfo.apiExpParam) == null) {
            return false;
        }
        return h5Config.deeplinkOptimizeSwitch;
    }

    @NonNull
    public static String cs(@NonNull AdInfo adInfo) {
        String strAB = aL(adInfo) ? aB(adInfo) : aD(adInfo);
        if (TextUtils.isEmpty(strAB)) {
            strAB = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(strAB) ? "可爱的广告君" : strAB;
    }

    @NonNull
    public static String ct(@NonNull AdInfo adInfo) {
        String strAC = aC(adInfo);
        return TextUtils.isEmpty(strAC) ? "可爱的广告君" : strAC;
    }

    @NonNull
    public static String cu(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String cv(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !aL(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static long cw(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String cx(@NonNull AdInfo adInfo) {
        return br.isNullString(adInfo.adConversionInfo.liveServiceToken) ? "" : adInfo.adConversionInfo.liveServiceToken;
    }

    public static long cy(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    @NonNull
    public static String cz(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static int dA(AdInfo adInfo) {
        return adInfo.adBannerInfo.videoAutoPlayType;
    }

    public static boolean dB(AdInfo adInfo) {
        return adInfo.adBannerInfo.isSupportCarousel;
    }

    public static boolean dC(AdInfo adInfo) {
        try {
            AdMatrixInfo.StyleComponentInfo styleComponentInfo = adInfo.adMatrixInfo.adDataV2.styleComponentInfo;
            if (styleComponentInfo != null) {
                return styleComponentInfo.styleComponentFlag;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String dD(AdInfo adInfo) {
        try {
            AdMatrixInfo.StyleComponentInfo styleComponentInfo = adInfo.adMatrixInfo.adDataV2.styleComponentInfo;
            if (styleComponentInfo != null) {
                AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo = styleComponentInfo.playCardInfo;
                long j = componentTemplateInfo != null ? componentTemplateInfo.pageId : 0L;
                AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo2 = styleComponentInfo.endCardInfo;
                return AdMatrixInfo.ComponentParam.obtain().setPageId(Long.valueOf(j)).setEndCardPageId(Long.valueOf(componentTemplateInfo2 != null ? componentTemplateInfo2.pageId : 0L)).toJson().toString();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean dE(AdInfo adInfo) {
        return adInfo.ksUaPattern;
    }

    public static boolean dF(AdInfo adInfo) {
        return adInfo.unionMark;
    }

    public static boolean dG(AdInfo adInfo) {
        return adInfo.adBaseInfo.isClosure;
    }

    public static boolean dH(AdInfo adInfo) {
        AdCouponReceiveParam adCouponReceiveParam;
        return (adInfo == null || (adCouponReceiveParam = adInfo.adCouponReceiveParam) == null || adCouponReceiveParam.isEmpty()) ? false : true;
    }

    public static String da(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return al.d(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, aH(adInfo));
    }

    public static String db(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo dc(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String dd(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean de(@NonNull AdInfo adInfo) {
        if (aL(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean df(@NonNull AdInfo adInfo) {
        return de(adInfo) && ak(adInfo) < O(adInfo);
    }

    public static boolean dg(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            return true;
        }
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static boolean dh(@NonNull AdInfo adInfo) {
        boolean z;
        if (!adInfo.adStyleConfInfo.adPushSwitch) {
            return false;
        }
        long jVu = ai.Vu();
        if (jVu > 0) {
            long j = adInfo.adStyleConfInfo.adPushIntervalTime;
            if (j <= 0) {
                j = 900;
            }
            z = System.currentTimeMillis() - jVu > j * 1000;
        }
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "isPushAdEnable intervalEnable: " + z);
        return z;
    }

    public static int di(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean dj(@NonNull AdInfo adInfo) {
        return (!cY(adInfo) || TextUtils.isEmpty(b.eL(adInfo)) || dk(adInfo)) ? false : true;
    }

    private static boolean dk(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long dl(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean dm(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean dn(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean m1063do(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifySwitch;
    }

    public static boolean dp(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardRetryTaskInfo.rewardRetryTaskType == 1;
    }

    public static long dq(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifyAdvanceMs;
    }

    public static KSAdInfoData dr(AdInfo adInfo) {
        KSAdInfoData videoCoverImageUrl = KSAdInfoData.obtain().setAdDescription(aA(adInfo)).setProductName(aD(adInfo)).setAdSource(aJ(adInfo)).setVideoUrl(M(adInfo)).setMaterialType(bk(adInfo)).setAppIconUrl(cv(adInfo)).setAppName(aB(adInfo)).setImageList(ds(adInfo)).setVideoCoverImageUrl(dt(adInfo));
        try {
            videoCoverImageUrl.setCreativeId(L(adInfo));
            if (bz.aE(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), "4.9.20.1")) {
                videoCoverImageUrl.setConvertType(dx(adInfo)).setInteractionType(aW(adInfo));
            }
        } catch (Throwable unused) {
        }
        return videoCoverImageUrl;
    }

    private static List<String> ds(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iBk = bk(adInfo);
        if (iBk == 2 || iBk == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    private static String dt(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = bb(adInfo);
        if (TextUtils.isEmpty(materialFeatureBb.coverUrl)) {
            return null;
        }
        return materialFeatureBb.coverUrl;
    }

    public static String du(AdInfo adInfo) {
        return adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId;
    }

    public static boolean dv(@NonNull AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.derivativeMaterialType;
        return i == 6 || i == 2;
    }

    public static int dw(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.campaignType;
    }

    public static int dx(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.ocpcActionType;
    }

    public static int dy(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.industryFirstLevelId;
    }

    public static int dz(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adConversionInfo.webUriSourceType;
    }

    @Deprecated
    public static String eF(int i) {
        return y(i, "下载中  %s%%");
    }

    public static String eG(int i) {
        return "继续下载 " + i + "%";
    }

    public static String y(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    public static boolean cL(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean cM(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    @Deprecated
    public static boolean cN(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDU = b.dU(adTemplate);
        return (merchantLiveReservationInfoDU != null && !merchantLiveReservationInfoDU.isEmpty()) && adInfoEO.adStyleConfInfo.innerAdType == 2;
    }

    @Nullable
    public static SpannableString b(AdInfo adInfo, @ColorInt int i) {
        String str;
        int iIndexOf;
        String strCT = cT(adInfo);
        if (strCT == null || (iIndexOf = (str = String.format("已有%s粉丝关注了TA", strCT)).indexOf(strCT)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), iIndexOf, strCT.length() + iIndexOf, 18);
        return spannableString;
    }

    public static boolean cK(@Nullable AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }
}
