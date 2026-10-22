package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.igexin.assist.sdk.AssistPushConsts;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.br;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int aLd;

    @NonNull
    private final com.kwad.sdk.core.adlog.c.a aLe;
    private final AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    @KsJson
    public static class C1273a extends com.kwad.sdk.core.response.a.a {
        public String aLA;
        public int aLB;
        public int aLC;
        public int aLD;
        public int aLE;

        @Nullable
        public AdTrackLog aLF;
        public int aLG;
        public int aLf;
        public String aLg;
        public String aLh;
        public String aLi;
        public String aLj;
        public String aLl;
        public int aLm;
        public int aLn;
        public int aLo;
        public int aLp;
        public int aLq;
        public boolean aLr;
        public String aLs;
        public JSONObject aLt;
        public int aLv;
        public int aLw;
        public int aLx;
        public int aLy;
        public String aLz;
        public String templateId;
        public int tkPublishType;
        public int aLk = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int aLu = 0;
        public int showLiveStyle = -1;

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.FZ()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.aLF = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.aLF);
            }
            return this.aLF;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.aLk;
            if (i != -1) {
                ac.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                ac.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                ac.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                ac.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.aLF;
            if (adTrackLog != null) {
                ac.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.aLt;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.aLt.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        this.aLe = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.aLd = aVar.aKI;
    }

    private void IR() {
        JSONObject jSONObject = this.aLe.aMe;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ac.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.aML;
        if (i >= 0) {
            putBody("adOrder", i);
        }
        int i2 = aVar.QX;
        if (i2 >= 0) {
            putBody("adInterstitialSource", i2);
        }
        if (!TextUtils.isEmpty(aVar.aMj)) {
            putBody("adRenderArea", aVar.aMj);
        }
        putBody("adxResult", aVar.adxResult);
        int i3 = aVar.aMP;
        if (i3 != 0) {
            putBody("fingerSwipeType", i3);
        }
        int i4 = aVar.aMQ;
        if (i4 != 0) {
            putBody("fingerSwipeDistance", i4);
        }
        int i5 = aVar.aMI;
        if (i5 != -1) {
            putBody("installStatus", i5);
        }
        C1273a c1273a = aVar.QZ;
        if (c1273a != null) {
            putBody("clientExtData", c1273a.toJson().toString());
        }
        String str2 = aVar.aMT;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i6 = aVar.Rb;
        if (i6 != -1) {
            putBody("triggerType", i6);
        }
        int i7 = aVar.Ra;
        if (i7 != 0) {
            putBody("photoSizeStyle", i7);
        }
    }

    private void b(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.nm;
        if (i != 0) {
            putBody("itemClickType", i);
        }
        if (!TextUtils.isEmpty(aVar.QY)) {
            putBody(AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.QY);
        }
        int i2 = aVar.aMA;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        int i3 = aVar.aML;
        if (i3 >= 0) {
            putBody("adOrder", i3);
        }
        int i4 = aVar.QX;
        if (i4 >= 0) {
            putBody("adInterstitialSource", i4);
        }
        int i5 = aVar.Rb;
        if (i5 != -1) {
            putBody("triggerType", i5);
        }
        int i6 = aVar.aMS;
        if (i6 != 0) {
            putBody("cardCloseType", i6);
        }
        putBody("adxResult", aVar.adxResult);
        double d = aVar.np;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            putBody("splashShakeAcceleration", d);
        }
        if (!TextUtils.isEmpty(aVar.aMM)) {
            putBody("splashInteractionRotateAngle", aVar.aMM);
        }
        int i7 = aVar.aMP;
        if (i7 != 0) {
            putBody("fingerSwipeType", i7);
        }
        int i8 = aVar.aMQ;
        if (i8 != 0) {
            putBody("fingerSwipeDistance", i8);
        }
        long j = aVar.zV;
        if (j > 0) {
            putBody("playedDuration", j);
        }
        int i9 = aVar.aMK;
        if (i9 > 0) {
            putBody("playedRate", i9);
        }
        String str2 = aVar.aMT;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i10 = aVar.aMs;
        if (i10 != -1) {
            putBody("retainCodeType", i10);
        }
        C1273a c1273a = aVar.QZ;
        if (c1273a != null) {
            putBody("clientExtData", c1273a.toJson().toString());
        }
        int i11 = aVar.aMR;
        if (i11 != 0) {
            putBody("finger_swiper_angle", i11);
        }
        int i12 = aVar.Ra;
        if (i12 != 0) {
            putBody("photoSizeStyle", i12);
        }
    }

    private void c(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.aMh;
        if (i != 0) {
            putBody("itemCloseType", i);
        }
        int i2 = aVar.aMf;
        if (i2 > 0) {
            putBody("photoPlaySecond", i2);
        }
        int i3 = aVar.aMg;
        if (i3 != 0) {
            putBody("awardReceiveStage", i3);
        }
        int i4 = aVar.aMi;
        if (i4 != 0) {
            putBody("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.QY)) {
            putBody(AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.QY);
        }
        C1273a c1273a = aVar.QZ;
        if (c1273a != null) {
            putBody("clientExtData", c1273a.toJson().toString());
        }
        int i5 = aVar.aMt;
        if (i5 > 0) {
            putBody("deeplinkType", i5);
        }
        if (!TextUtils.isEmpty(aVar.aMu)) {
            putBody("deeplinkAppName", aVar.aMu);
        }
        int i6 = aVar.aMv;
        if (i6 != 0) {
            putBody("deeplinkFailedReason", i6);
        }
        int i7 = aVar.downloadSource;
        if (i7 > 0) {
            putBody("downloadSource", i7);
        }
        int i8 = aVar.aMS;
        if (i8 != 0) {
            putBody("cardCloseType", i8);
        }
        int i9 = aVar.aMw;
        if (i9 > 0) {
            putBody("isPackageChanged", i9);
        }
        putBody("installedFrom", aVar.aMx);
        putBody("isChangedEndcard", aVar.aMz);
        int i10 = aVar.aMA;
        if (i10 != 0) {
            putBody("adAggPageSource", i10);
        }
        String str2 = aVar.aMy;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!br.isNullString(aVar.aMC)) {
            putBody("installedPackageName", aVar.aMC);
        }
        if (!br.isNullString(aVar.aMB)) {
            putBody("serverPackageName", aVar.aMB);
        }
        int i11 = aVar.aME;
        if (i11 > 0) {
            putBody("closeButtonClickTime", i11);
        }
        int i12 = aVar.aMD;
        if (i12 > 0) {
            putBody("closeButtonImpressionTime", i12);
        }
        int i13 = aVar.downloadStatus;
        if (i13 >= 0) {
            putBody("downloadStatus", i13);
        }
        long j = aVar.aMF;
        if (j > 0) {
            putBody("landingPageLoadedDuration", j);
        }
        long j2 = aVar.RD;
        if (j2 > 0) {
            putBody("leaveTime", j2);
        }
        long j3 = aVar.aMG;
        if (j3 > 0) {
            putBody("adItemClickBackDuration", j3);
        }
        int i14 = aVar.aMs;
        if (i14 != -1) {
            putBody("retainCodeType", i14);
        }
        long j4 = aVar.aMk;
        if (j4 > -1) {
            putBody("highestLossPrice", j4);
        }
        int i15 = aVar.aMl;
        if (i15 >= 0 || i15 == -9999) {
            putBody("impFailReason", i15);
        }
        long j5 = aVar.aMm;
        if (j5 > -1 || j5 == -9999) {
            putBody("winEcpm", j5);
        }
        int i16 = aVar.adnType;
        if (i16 > 0 || i16 == -9999) {
            putBody("adnType", i16);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.aMn)) {
            putBody("adnAdvertiser", aVar.aMn);
        }
        if (!TextUtils.isEmpty(aVar.aMo)) {
            putBody("adnTitle", aVar.aMo);
        }
        if (!TextUtils.isEmpty(aVar.aMp)) {
            putBody("adnRequestId", aVar.aMp);
        }
        putBody("adnShowType", aVar.aMq);
        putBody("adnClickType", aVar.aMr);
        putBody("adnMaterialType", aVar.adnMaterialType);
        if (!TextUtils.isEmpty(aVar.adnMaterialUrl)) {
            putBody("adnMaterialUrl", aVar.adnMaterialUrl);
        }
        putBody("downloadCardType", aVar.aMJ);
        putBody("landingPageType", aVar.ads);
        int i17 = aVar.QX;
        if (i17 >= 0) {
            putBody("adInterstitialSource", i17);
        }
        int i18 = aVar.aMN;
        if (i18 > 0) {
            putBody("downloadInstallType", i18);
        }
        int i19 = aVar.aMP;
        if (i19 != 0) {
            putBody("fingerSwipeType", i19);
        }
        int i20 = aVar.aMQ;
        if (i20 != 0) {
            putBody("fingerSwipeDistance", i20);
        }
        int i21 = aVar.aMO;
        if (i21 > 0) {
            putBody("businessSceneType", i21);
        }
        long j6 = aVar.zV;
        if (j6 > 0) {
            putBody("playedDuration", j6);
        }
        int i22 = aVar.aMK;
        if (i22 > 0) {
            putBody("playedRate", i22);
        }
        int i23 = aVar.aMH;
        if (i23 != -1) {
            putBody("appStorePageType", i23);
        }
        int i24 = aVar.Rb;
        if (i24 != -1) {
            putBody("triggerType", i24);
        }
        int i25 = aVar.Ra;
        if (i25 != 0) {
            putBody("photoSizeStyle", i25);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String strReplaceFirst;
        Context context = ServiceProvider.getContext();
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        int i = this.aLd;
        if (i == 1) {
            String str = adInfoEO.adBaseInfo.showUrl;
            strReplaceFirst = ((this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).FO()) ? str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.helper.a.aX(e.eO(this.mAdTemplate)))) : str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm))).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(strReplaceFirst, this.aLe);
            a(strReplaceFirst, this.mAdTemplate, this.aLe);
        } else if (i == 2) {
            strReplaceFirst = al.av(context, al.a(adInfoEO.adBaseInfo.clickUrl, this.aLe.no)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(strReplaceFirst, this.aLe);
            a(strReplaceFirst, this.mAdTemplate, this.aLe);
        } else {
            strReplaceFirst = adInfoEO.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(strReplaceFirst, this.aLe);
        }
        IR();
        return strReplaceFirst;
    }

    private void a(String str, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            putBody("initVoiceStatus", i);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i2 = aVar.aMA;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(aVar.QY)) {
            return;
        }
        putBody(AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.QY);
    }
}
