package com.kwad.sdk.core.b.a;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.core.response.model.LiveInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ax implements com.kwad.sdk.core.d<AdTemplate> {
    private static void l(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(adTemplate.mOriginJString)) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.subType = jSONObject.optInt("subType");
        adTemplate.defaultType = jSONObject.optInt("defaultType");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        LiveInfo liveInfo = new LiveInfo();
        adTemplate.liveInfo = liveInfo;
        liveInfo.parseJson(jSONObject.optJSONObject("liveInfo"));
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (JSONObject.NULL.toString().equals(adTemplate.impAdExtra)) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (JSONObject.NULL.toString().equals(adTemplate.extra)) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (JSONObject.NULL.toString().equals(adTemplate.mUniqueId)) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        LiveDetailReward liveDetailReward = new LiveDetailReward();
        adTemplate.mLiveDetailRewardFromAdLive = liveDetailReward;
        liveDetailReward.parseJson(jSONObject.optJSONObject("mLiveDetailRewardFromAdLive"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.swipeAngle = jSONObject.optInt("swipeAngle");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        adTemplate.requestStartTime = jSONObject.optLong("requestStartTime");
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.addStartTime = jSONObject.optLong("addStartTime");
        adTemplate.showTime = jSONObject.optLong("showTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        AdStatusInfo adStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo = adStatusInfo;
        adStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adTemplate.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        adTemplate.isNativeRewardPreview = jSONObject.optBoolean("isNativeRewardPreview");
        adTemplate.mInstallApkFromSDK = jSONObject.optBoolean("mInstallApkFromSDK");
        adTemplate.mInstallApkFormUser = jSONObject.optBoolean("mInstallApkFormUser");
        adTemplate.mClickOpenAppStore = jSONObject.optBoolean("mClickOpenAppStore");
        adTemplate.mDataLoadTraceElement = jSONObject.optString("mDataLoadTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataLoadTraceElement)) {
            adTemplate.mDataLoadTraceElement = "";
        }
        adTemplate.mDataCacheTraceElement = jSONObject.optString("mDataCacheTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataCacheTraceElement)) {
            adTemplate.mDataCacheTraceElement = "";
        }
        adTemplate.downLoadType = jSONObject.optInt("downLoadType", new Integer("3").intValue());
        adTemplate.hasInnerEcFailed = jSONObject.optBoolean("hasInnerEcFailed");
        adTemplate.isDoAuth = jSONObject.optBoolean("isDoAuth");
    }

    private static JSONObject m(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j = adTemplate.posId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "posId", j);
        }
        int i = adTemplate.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adStyle", i);
        }
        int i2 = adTemplate.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i2);
        }
        int i3 = adTemplate.subType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "subType", i3);
        }
        int i4 = adTemplate.defaultType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "defaultType", i4);
        }
        int i5 = adTemplate.contentType;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "contentType", i5);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        com.kwad.sdk.utils.ac.a(jSONObject, "liveInfo", adTemplate.liveInfo);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j2 = adTemplate.llsid;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "llsid", j2);
        }
        boolean z = adTemplate.mIsFromContent;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsFromContent", z);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j3 = adTemplate.mBidEcpm;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mBidEcpm", j3);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i6 = adTemplate.realShowType;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realShowType", i6);
        }
        int i7 = adTemplate.mInitVoiceStatus;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mInitVoiceStatus", i7);
        }
        int i8 = adTemplate.mMediaPlayerType;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mMediaPlayerType", i8);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.ac.a(jSONObject, "mLiveDetailRewardFromAdLive", adTemplate.mLiveDetailRewardFromAdLive);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i9 = adTemplate.mIsLeftSlipStatus;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsLeftSlipStatus", i9);
        }
        int i10 = adTemplate.mPhotoResponseType;
        if (i10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mPhotoResponseType", i10);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z2 = adTemplate.mIsAudioEnable;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mIsAudioEnable", z2);
        }
        boolean z3 = adTemplate.mRewardVerifyCalled;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mRewardVerifyCalled", z3);
        }
        boolean z4 = adTemplate.isWebViewDownload;
        if (z4) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isWebViewDownload", z4);
        }
        boolean z5 = adTemplate.watched;
        if (z5) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "watched", z5);
        }
        int i11 = adTemplate.swipeAngle;
        if (i11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "swipeAngle", i11);
        }
        boolean z6 = adTemplate.converted;
        if (z6) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "converted", z6);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j4 = adTemplate.requestStartTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestStartTime", j4);
        }
        long j5 = adTemplate.loadDataTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "loadDataTime", j5);
        }
        long j6 = adTemplate.showStartTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showStartTime", j6);
        }
        long j7 = adTemplate.addStartTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "addStartTime", j7);
        }
        long j8 = adTemplate.showTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showTime", j8);
        }
        boolean z7 = adTemplate.notNetworkRequest;
        if (z7) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "notNetworkRequest", z7);
        }
        long j9 = adTemplate.downloadDuration;
        if (j9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadDuration", j9);
        }
        long j10 = adTemplate.adLoadTotalTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adLoadTotalTime", j10);
        }
        long j11 = adTemplate.adShowStartTimeStamp;
        if (j11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adShowStartTimeStamp", j11);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adVideoPreCacheConfig", adTemplate.adVideoPreCacheConfig);
        boolean z8 = adTemplate.isNativeRewardPreview;
        if (z8) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isNativeRewardPreview", z8);
        }
        boolean z9 = adTemplate.mInstallApkFromSDK;
        if (z9) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mInstallApkFromSDK", z9);
        }
        boolean z10 = adTemplate.mInstallApkFormUser;
        if (z10) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mInstallApkFormUser", z10);
        }
        boolean z11 = adTemplate.mClickOpenAppStore;
        if (z11) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mClickOpenAppStore", z11);
        }
        String str5 = adTemplate.mDataLoadTraceElement;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mDataLoadTraceElement", adTemplate.mDataLoadTraceElement);
        }
        String str6 = adTemplate.mDataCacheTraceElement;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mDataCacheTraceElement", adTemplate.mDataCacheTraceElement);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "downLoadType", adTemplate.downLoadType);
        boolean z12 = adTemplate.hasInnerEcFailed;
        if (z12) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hasInnerEcFailed", z12);
        }
        boolean z13 = adTemplate.isDoAuth;
        if (z13) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isDoAuth", z13);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        l((AdTemplate) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return m((AdTemplate) bVar, jSONObject);
    }
}
