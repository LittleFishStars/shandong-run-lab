package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class AdTemplate extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static boolean isInnerEcCancelDowngrade = false;
    private static final long serialVersionUID = -5413539480595883024L;
    public long adLoadTotalTime;
    public long adShowStartTimeStamp;
    public int adStyle;
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public long addStartTime;
    public int contentType;
    public int defaultType;
    public long downloadDuration;
    public String extra;
    public String impAdExtra;
    public long llsid;
    public long loadDataTime;
    public int loadType;
    public SceneImpl mAdScene;
    public long mBidEcpm;
    public boolean mClickOpenAppStore;
    public long mCurPlayTime;
    public String mDataCacheTraceElement;
    public String mDataLoadTraceElement;
    public volatile transient boolean mHasAdShow;
    public int mInitVoiceStatus;
    public boolean mInstallApkFormUser;
    public boolean mInstallApkFromSDK;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public int mPhotoResponseType;
    public volatile transient boolean mPvReported;
    public transient boolean mTrackUrlReported;
    public boolean notNetworkRequest;
    public long posId;
    public int realShowType;
    public long requestStartTime;
    public long showStartTime;
    public long showTime;
    public int splashAdLoadType;
    public int subType;

    @Nullable
    public TKAdLiveShopItemInfo tkLiveShopItemInfo;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = createPhotoInfo();
    public LiveInfo liveInfo = new LiveInfo();
    public int positionShow = -1;
    public transient int adxResult = -1;
    private int serverPosition = -1;
    public boolean mIsFromContent = false;
    public boolean hasEnterAdWebViewLandPageActivity = false;
    public boolean mHasReportVideoLoad = false;
    public String mUniqueId = "";
    public boolean mHasSelected = false;
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public int mMediaPlayerType = 0;
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public LiveDetailReward mLiveDetailRewardFromAdLive = new LiveDetailReward();
    public long mOutClickTimeParam = -1;
    public volatile long mVisibleTimeParam = -1;
    public int mIsLeftSlipStatus = 0;
    public boolean interactLandingPageShowing = false;
    public boolean mIsForceJumpLandingPage = false;
    public boolean mAdWebVideoPageShowing = false;
    public boolean isEndCardPage = false;
    public boolean mIsAudioEnable = false;
    public boolean mRewardVerifyCalled = false;
    public boolean mCheatingFlow = false;
    public boolean mXiaomiAppStoreDetailViewOpen = false;
    public boolean isWebViewDownload = false;
    public boolean watched = false;
    public int swipeAngle = 0;
    public boolean converted = false;
    public boolean fromCache = false;
    protected transient Map<String, Object> mLocalParams = new HashMap();

    @NonNull
    public AdStatusInfo mAdStatusInfo = new AdStatusInfo();
    public boolean isNativeRewardPreview = false;
    public int downLoadType = 3;
    public boolean hasInnerEcFailed = false;
    public boolean isDoAuth = false;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            if (TextUtils.isEmpty(this.mOriginJString)) {
                this.mOriginJString = jSONObject.toString();
            }
            PhotoInfo photoInfoCreatePhotoInfo = createPhotoInfo();
            photoInfoCreatePhotoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
            setPhotoInfo(photoInfoCreatePhotoInfo);
        }
        this.realShowType = this.contentType;
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        ac.a(jSONObject, "photoInfo", this.photoInfo);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        try {
            ad.merge(jSONObject, new JSONObject(this.mOriginJString));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
    }

    public AdResultData createAdResultData() {
        AdResultData adResultData = new AdResultData();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        adResultData.setAdTemplateList(arrayList);
        return adResultData;
    }

    public PhotoInfo createPhotoInfo() {
        return new PhotoInfo();
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj);
    }

    public long getDownloadFinishTime() {
        return this.mAdStatusInfo.getDownloadFinishTime();
    }

    public long getDownloadSize() {
        return this.mAdStatusInfo.getDownloadSize();
    }

    public int getDownloadStatus() {
        return this.mAdStatusInfo.getDownloadStatus();
    }

    public int getDownloadType() {
        return this.mAdStatusInfo.getDownloadType();
    }

    public long getLoadDataTime() {
        return this.mAdStatusInfo.getLoadDataTime();
    }

    @Nullable
    public <T> T getLocalParams(String str) {
        T t;
        if (TextUtils.isEmpty(str) || (t = (T) this.mLocalParams.get(str)) == null) {
            return null;
        }
        return t;
    }

    public int getServerPosition() {
        int i = this.serverPosition;
        return i != -1 ? i : getShowPosition();
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public long getmCurPlayTime() {
        return this.mCurPlayTime;
    }

    public boolean hasInnerEcFailed() {
        return this.hasInnerEcFailed;
    }

    public int hashCode() {
        String str = this.mUniqueId;
        return str != null ? str.hashCode() : super.hashCode();
    }

    public boolean isCheatingFlow() {
        return this.mCheatingFlow;
    }

    public boolean isLoadFromCache() {
        return this.mAdStatusInfo.isLoadFromCache();
    }

    @Nullable
    public Object putLocalParams(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mLocalParams.put(str, obj);
    }

    public void setCheatingFlow(boolean z) {
        if (this.mCheatingFlow) {
            return;
        }
        this.mCheatingFlow = z;
    }

    public void setDownloadFinishTime(long j) {
        this.mAdStatusInfo.setDownloadFinishTime(j);
    }

    public void setDownloadSize(long j) {
        this.mAdStatusInfo.setDownloadSize(j);
    }

    public void setDownloadStatus(int i) {
        this.mAdStatusInfo.setDownloadStatus(i);
    }

    public void setDownloadType(int i) {
        this.mAdStatusInfo.setDownloadType(i);
    }

    public void setHasInnerEcFailed(boolean z) {
        this.hasInnerEcFailed = z;
    }

    public void setLoadDataTime(long j) {
        this.mAdStatusInfo.setLoadDataTime(j);
    }

    public void setLoadFromCache(boolean z) {
        this.mAdStatusInfo.setLoadFromCache(z);
    }

    public void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    public void setServerPosition(int i) {
        if (this.serverPosition == -1) {
            this.serverPosition = i;
        }
    }

    public void setShowPosition(int i) {
        this.positionShow = i;
    }

    public void setmCurPlayTime(long j) {
        this.mCurPlayTime = j;
    }

    public void updateLiveDetailRewardFromAdLive(LiveDetailReward liveDetailReward) {
        if (liveDetailReward != null) {
            LiveDetailReward liveDetailReward2 = this.mLiveDetailRewardFromAdLive;
            liveDetailReward2.hasRewardTime = liveDetailReward.hasRewardTime;
            liveDetailReward2.countDownSecond = liveDetailReward.countDownSecond;
            liveDetailReward2.success = liveDetailReward.success;
            liveDetailReward2.pageDataKey = liveDetailReward.pageDataKey;
        }
    }

    public Map<String, Object> getLocalParams() {
        return this.mLocalParams;
    }
}
