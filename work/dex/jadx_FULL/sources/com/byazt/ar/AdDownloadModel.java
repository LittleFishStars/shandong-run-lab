package com.byazt.ar;

import android.text.TextUtils;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.e.DeepLink;
import com.byazt.e.uj;
import com.byazt.gq.t;
import com.byazt.ki.tt;
import com.byazt.su.DownloadModel;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zqa.c;
import com.google.android.exoplayer2.offline.a;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@c(c = {0, 1, 119, 1245})
public class AdDownloadModel implements DownloadModel {
    public String mAppIcon;
    public String mAppName;
    public boolean mAutoInstallWithoutNotification;
    public List<String> mBackupUrls;
    public List<String> mClickTrackUrl;
    public DeepLink mDeepLink;
    public boolean mDistinctDir;
    public JSONObject mDownloadSettings;
    public String mDownloadUrl;
    public long mExpectFileLength;
    public JSONObject mExtra;
    public long mExtraValue;
    public String mFileName;
    public String mFilePath;
    public IDownloadFileUriProvider mFileUriProvider;
    public Map<String, String> mHeaders;
    public long mId;
    public boolean mIndependentProcess;

    @Deprecated
    public boolean mIsInExternalPublicDir;
    public String mLogExtra;
    public String mMd5;
    public String mMimeType;
    public int mModelType;
    public String mNotificationJumpUrl;
    public String mPackageName;
    public uj mQuickAppModel;
    public String mSdkMonitorScene;
    public String mStartToast;
    public String mTaskKey;
    public int mVersionCode;
    public String mVersionName;
    public boolean mIsAd = true;
    public boolean mIsShowToast = true;
    public boolean mIsShowNotification = true;
    public boolean mAutoInstall = true;
    public boolean mNeedWifi = false;
    public int mExecutorGroup = 2;
    public boolean mEnablePause = true;
    public int mFunnelType = 1;

    @c(c = {0, 1, 119, 2061})
    public static final class Builder {
        public AdDownloadModel model = new AdDownloadModel();

        public AdDownloadModel build() {
            return this.model;
        }

        @Deprecated
        public Builder setAdId(long j) {
            return setId(j);
        }

        public Builder setAppIcon(String str) {
            this.model.mAppIcon = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.model.mAppName = str;
            return this;
        }

        public Builder setAutoInstall(boolean z) {
            this.model.mAutoInstall = z;
            return this;
        }

        public Builder setAutoInstallWithoutNotification(boolean z) {
            this.model.mAutoInstallWithoutNotification = z;
            return this;
        }

        public Builder setBackupUrls(List<String> list) {
            this.model.mBackupUrls = list;
            return this;
        }

        public Builder setClickTrackUrl(List<String> list) {
            this.model.mClickTrackUrl = list;
            return this;
        }

        public Builder setDeepLink(DeepLink deepLink) {
            this.model.mDeepLink = deepLink;
            return this;
        }

        public Builder setDistinctDir(boolean z) {
            this.model.mDistinctDir = z;
            return this;
        }

        public Builder setDownloadSettings(JSONObject jSONObject) {
            this.model.mDownloadSettings = jSONObject;
            return this;
        }

        public Builder setDownloadUrl(String str) {
            this.model.mDownloadUrl = str;
            return this;
        }

        public Builder setEnablePause(boolean z) {
            this.model.mEnablePause = z;
            return this;
        }

        public Builder setExecutorGroup(int i) {
            this.model.mExecutorGroup = i;
            return this;
        }

        public Builder setExpectFileLength(long j) {
            this.model.mExpectFileLength = j;
            return this;
        }

        public Builder setExtra(JSONObject jSONObject) {
            this.model.mExtra = jSONObject;
            return this;
        }

        public Builder setExtraValue(long j) {
            this.model.mExtraValue = j;
            return this;
        }

        public Builder setFileName(String str) {
            this.model.mFileName = str;
            return this;
        }

        public Builder setFilePath(String str) {
            this.model.mFilePath = str;
            return this;
        }

        public Builder setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
            this.model.mFileUriProvider = iDownloadFileUriProvider;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.model.mHeaders = map;
            return this;
        }

        public Builder setId(long j) {
            this.model.mId = j;
            return this;
        }

        public Builder setIsAd(boolean z) {
            this.model.mIsAd = z;
            return this;
        }

        @Deprecated
        public Builder setIsInExternalPublicDir(boolean z) {
            this.model.mIsInExternalPublicDir = z;
            return this;
        }

        public Builder setIsShowNotification(boolean z) {
            this.model.mIsShowNotification = z;
            return this;
        }

        public Builder setIsShowToast(boolean z) {
            this.model.mIsShowToast = z;
            return this;
        }

        public Builder setLogExtra(String str) {
            this.model.mLogExtra = str;
            return this;
        }

        public Builder setMd5(String str) {
            this.model.mMd5 = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.model.mMimeType = str;
            return this;
        }

        public Builder setModelType(int i) {
            this.model.mModelType = i;
            return this;
        }

        public Builder setNeedIndependentProcess(boolean z) {
            this.model.mIndependentProcess = z;
            return this;
        }

        public Builder setNeedWifi(boolean z) {
            this.model.mNeedWifi = z;
            return this;
        }

        public Builder setNotificationJumpUrl(String str) {
            this.model.mNotificationJumpUrl = str;
            return this;
        }

        public Builder setPackageName(String str) {
            this.model.mPackageName = str;
            return this;
        }

        public Builder setQuickAppModel(uj ujVar) {
            this.model.mQuickAppModel = ujVar;
            return this;
        }

        public Builder setSdkMonitorScene(String str) {
            this.model.mSdkMonitorScene = str;
            return this;
        }

        public Builder setStartToast(String str) {
            this.model.mStartToast = str;
            return this;
        }

        public Builder setTaskKey(String str) {
            this.model.mTaskKey = str;
            return this;
        }

        public Builder setVersionCode(int i) {
            this.model.mVersionCode = i;
            return this;
        }

        public Builder setVersionName(String str) {
            this.model.mVersionName = str;
            return this;
        }
    }

    private static void appendBackupUrlsFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("backup_urls");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.optString(i));
        }
        builder.setBackupUrls(arrayList);
    }

    private static void appendDeepLinkFromJson(JSONObject jSONObject, Builder builder) {
        builder.setDeepLink(new DeepLink(jSONObject.optString(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL), jSONObject.optString("web_url"), null));
    }

    private static void appendHeaderMapFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("header_keys");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("header_values");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray2 == null) {
            return;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            map.put(jSONArrayOptJSONArray.optString(i), jSONArrayOptJSONArray2.optString(i));
        }
        builder.setHeaders(map);
    }

    private static void appendQuickAppUrlFromJson(JSONObject jSONObject, Builder builder) {
        String strOptString = jSONObject.optString("quick_app_url");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        builder.setQuickAppModel(new uj.c().c(strOptString).c());
    }

    private static void appendTrackUrlFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("click_track_urls");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i));
            }
            builder.setClickTrackUrl(arrayList);
        }
    }

    public static AdDownloadModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            boolean z = true;
            Builder distinctDir = builder.setAdId(tt.c(jSONObject, "id")).setIsAd(jSONObject.optInt("is_ad", 1) == 1).setModelType(jSONObject.optInt("model_type")).setMimeType(jSONObject.optString(a.f3586e)).setExtraValue(tt.c(jSONObject, "ext_value")).setLogExtra(jSONObject.optString("log_extra")).setPackageName(jSONObject.optString("package_name")).setDownloadUrl(jSONObject.optString("download_url")).setAppName(jSONObject.optString("app_name")).setAppIcon(jSONObject.optString("app_icon")).setIsShowToast(jSONObject.optInt("is_show_toast", 1) == 1).setIsShowNotification(jSONObject.optInt("show_notification", 1) == 1).setNeedWifi(jSONObject.optInt("need_wifi") == 1).setMd5(jSONObject.optString(TKDownloadReason.KSAD_TK_MD5)).setExpectFileLength(jSONObject.optLong("expect_file_length")).setNeedIndependentProcess(jSONObject.optInt("independent_process") == 1).setVersionCode(jSONObject.optInt("version_code")).setVersionName(jSONObject.optString("version_name")).setFilePath(jSONObject.optString(CropKey.RESULT_KEY_FILE_PATH)).setFileName(jSONObject.optString("file_name")).setNotificationJumpUrl(jSONObject.optString("notification_jump_url")).setAutoInstallWithoutNotification(jSONObject.optInt("auto_install_without_notify") == 1).setExecutorGroup(jSONObject.optInt("executor_group")).setDownloadSettings(jSONObject.optJSONObject("download_settings")).setExtra(jSONObject.optJSONObject("extra")).setStartToast(jSONObject.optString("start_toast")).setSdkMonitorScene(jSONObject.optString("sdk_monitor_scene")).setAutoInstall(jSONObject.optInt("auto_install", 1) == 1).setDistinctDir(jSONObject.optInt("distinct_dir") == 1);
            if (jSONObject.optInt("enable_pause", 1) != 1) {
                z = false;
            }
            distinctDir.setEnablePause(z).setTaskKey(jSONObject.optString("task_key"));
            appendDeepLinkFromJson(jSONObject, builder);
            appendQuickAppUrlFromJson(jSONObject, builder);
            appendTrackUrlFromJson(jSONObject, builder);
            appendHeaderMapFromJson(jSONObject, builder);
            appendBackupUrlsFromJson(jSONObject, builder);
        } catch (Exception e) {
            t.gt().c(e, "AdDownloadModel fromJson");
        }
        return builder.build();
    }

    @Override // com.byazt.su.DownloadModel
    public boolean autoInstallWithoutNotification() {
        return this.mAutoInstallWithoutNotification;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean distinctDir() {
        return this.mDistinctDir;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean enablePause() {
        return this.mEnablePause;
    }

    @Override // com.byazt.su.DownloadModel
    public void forceHideNotification() {
        this.mIsShowNotification = false;
    }

    @Override // com.byazt.su.DownloadModel
    public void forceHideToast() {
        this.mIsShowToast = false;
    }

    @Override // com.byazt.su.DownloadModel
    public void forceWifi() {
        this.mNeedWifi = true;
    }

    @Override // com.byazt.su.DownloadModel
    public String getAppIcon() {
        return this.mAppIcon;
    }

    @Override // com.byazt.su.DownloadModel
    public List<String> getBackupUrls() {
        return this.mBackupUrls;
    }

    @Override // com.byazt.su.DownloadModel
    public List<String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    @Override // com.byazt.su.DownloadModel
    public DeepLink getDeepLink() {
        return this.mDeepLink;
    }

    @Override // com.byazt.su.DownloadModel
    public IDownloadFileUriProvider getDownloadFileUriProvider() {
        return this.mFileUriProvider;
    }

    @Override // com.byazt.su.DownloadModel
    public JSONObject getDownloadSettings() {
        return this.mDownloadSettings;
    }

    @Override // com.byazt.su.DownloadModel
    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.byazt.su.DownloadModel
    public int getExecutorGroup() {
        return this.mExecutorGroup;
    }

    @Override // com.byazt.su.DownloadModel
    public long getExpectFileLength() {
        return this.mExpectFileLength;
    }

    @Override // com.byazt.su.DownloadModel
    public JSONObject getExtra() {
        return this.mExtra;
    }

    @Override // com.byazt.su.DownloadModel
    public long getExtraValue() {
        return this.mExtraValue;
    }

    @Override // com.byazt.su.DownloadModel
    public String getFileName() {
        return this.mFileName;
    }

    @Override // com.byazt.su.DownloadModel
    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.byazt.su.DownloadModel
    public int getFunnelType() {
        return this.mFunnelType;
    }

    @Override // com.byazt.su.DownloadModel
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.byazt.su.DownloadModel
    public long getId() {
        return this.mId;
    }

    @Override // com.byazt.su.DownloadModel
    public String getLogExtra() {
        return this.mLogExtra;
    }

    @Override // com.byazt.su.DownloadModel
    public String getMd5() {
        return this.mMd5;
    }

    @Override // com.byazt.su.DownloadModel
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.byazt.su.DownloadModel
    public int getModelType() {
        return this.mModelType;
    }

    @Override // com.byazt.su.DownloadModel
    public String getName() {
        return this.mAppName;
    }

    @Override // com.byazt.su.DownloadModel
    public String getNotificationJumpUrl() {
        return this.mNotificationJumpUrl;
    }

    @Override // com.byazt.su.DownloadModel
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.byazt.su.DownloadModel
    public uj getQuickAppModel() {
        return this.mQuickAppModel;
    }

    @Override // com.byazt.su.DownloadModel
    public String getSdkMonitorScene() {
        return this.mSdkMonitorScene;
    }

    @Override // com.byazt.su.DownloadModel
    public String getStartToast() {
        return this.mStartToast;
    }

    public String getTaskKey() {
        return this.mTaskKey;
    }

    @Override // com.byazt.su.DownloadModel
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.byazt.su.DownloadModel
    public String getVersionName() {
        return this.mVersionName;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isAd() {
        return this.mIsAd;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isAutoInstall() {
        return this.mAutoInstall;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isInExternalPublicDir() {
        return this.mIsInExternalPublicDir;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isNeedWifi() {
        return this.mNeedWifi;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isShowToast() {
        return this.mIsShowToast;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        return true;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean needIndependentProcess() {
        return this.mIndependentProcess;
    }

    @Deprecated
    public AdDownloadModel setAdId(long j) {
        return setId(j);
    }

    public AdDownloadModel setAppIcon(String str) {
        this.mAppIcon = str;
        return this;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public AdDownloadModel setAutoInstallWithoutNotification(boolean z) {
        this.mAutoInstallWithoutNotification = z;
        return this;
    }

    public AdDownloadModel setBackupUrls(List<String> list) {
        this.mBackupUrls = list;
        return this;
    }

    public AdDownloadModel setClickTrackUrl(List<String> list) {
        this.mClickTrackUrl = list;
        return this;
    }

    public AdDownloadModel setDeepLink(DeepLink deepLink) {
        this.mDeepLink = deepLink;
        return this;
    }

    public AdDownloadModel setDownloadUrl(String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public void setExpectFileLength(long j) {
        this.mExpectFileLength = j;
    }

    public void setExtra(JSONObject jSONObject) {
        this.mExtra = jSONObject;
    }

    public void setExtraValue(long j) {
        this.mExtraValue = j;
    }

    public AdDownloadModel setFileName(String str) {
        this.mFileName = str;
        return this;
    }

    public AdDownloadModel setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.mFileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public AdDownloadModel setFunnelType(int i) {
        this.mFunnelType = i;
        return this;
    }

    public AdDownloadModel setHeaders(Map<String, String> map) {
        this.mHeaders = map;
        return this;
    }

    public AdDownloadModel setId(long j) {
        this.mId = j;
        return this;
    }

    public AdDownloadModel setIsAd(boolean z) {
        this.mIsAd = z;
        return this;
    }

    public AdDownloadModel setIsShowNotification(boolean z) {
        this.mIsShowNotification = z;
        return this;
    }

    public void setIsShowToast(boolean z) {
        this.mIsShowToast = z;
    }

    public AdDownloadModel setLogExtra(String str) {
        this.mLogExtra = str;
        return this;
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public AdDownloadModel setMimeType(String str) {
        this.mMimeType = str;
        return this;
    }

    public AdDownloadModel setModelType(int i) {
        this.mModelType = i;
        return this;
    }

    public AdDownloadModel setNeedIndependentProcess(boolean z) {
        this.mIndependentProcess = z;
        return this;
    }

    public void setNeedWifi(boolean z) {
        this.mNeedWifi = z;
    }

    public AdDownloadModel setNotificationJumpUrl(String str) {
        this.mNotificationJumpUrl = str;
        return this;
    }

    public AdDownloadModel setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public AdDownloadModel setQuickAppModel(uj ujVar) {
        this.mQuickAppModel = ujVar;
        return this;
    }

    public void setSdkMonitorScene(String str) {
        this.mSdkMonitorScene = str;
    }

    public void setStartToast(String str) {
        this.mStartToast = str;
    }

    public void setTaskKey(String str) {
        this.mTaskKey = str;
    }

    public AdDownloadModel setVersionCode(int i) {
        this.mVersionCode = i;
        return this;
    }

    public AdDownloadModel setVersionName(String str) {
        this.mVersionName = str;
        return this;
    }

    @Override // com.byazt.su.DownloadModel
    public boolean shouldDownloadWithPatchApply() {
        return tt.c(com.byazt.k.c.c(getDownloadSettings()), getMimeType());
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.mId);
            int i = 1;
            jSONObject.put("is_ad", this.mIsAd ? 1 : 0);
            jSONObject.putOpt("model_type", Integer.valueOf(this.mModelType));
            jSONObject.putOpt(a.f3586e, this.mMimeType);
            jSONObject.putOpt("ext_value", Long.valueOf(this.mExtraValue));
            jSONObject.putOpt("log_extra", this.mLogExtra);
            jSONObject.putOpt("package_name", this.mPackageName);
            jSONObject.putOpt("download_url", this.mDownloadUrl);
            jSONObject.putOpt("app_name", this.mAppName);
            jSONObject.putOpt("app_icon", this.mAppIcon);
            jSONObject.putOpt("is_show_toast", Integer.valueOf(this.mIsShowToast ? 1 : 0));
            jSONObject.putOpt("show_notification", Integer.valueOf(this.mIsShowNotification ? 1 : 0));
            jSONObject.put("need_wifi", this.mNeedWifi ? 1 : 0);
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.mMd5);
            jSONObject.put("expect_file_length", this.mExpectFileLength);
            jSONObject.put("independent_process", this.mIndependentProcess ? 1 : 0);
            jSONObject.put("version_code", this.mVersionCode);
            jSONObject.putOpt("version_name", this.mVersionName);
            jSONObject.putOpt(CropKey.RESULT_KEY_FILE_PATH, this.mFilePath);
            jSONObject.putOpt("file_name", this.mFileName);
            jSONObject.putOpt("notification_jump_url", this.mNotificationJumpUrl);
            jSONObject.putOpt("auto_install_without_notify", Integer.valueOf(this.mAutoInstallWithoutNotification ? 1 : 0));
            jSONObject.putOpt("executor_group", Integer.valueOf(this.mExecutorGroup));
            jSONObject.putOpt("start_toast", this.mStartToast);
            jSONObject.putOpt("sdk_monitor_scene", this.mSdkMonitorScene);
            jSONObject.putOpt("auto_install", Integer.valueOf(this.mAutoInstall ? 1 : 0));
            jSONObject.putOpt("distinct_dir", Integer.valueOf(this.mDistinctDir ? 1 : 0));
            if (!this.mEnablePause) {
                i = 0;
            }
            jSONObject.putOpt("enable_pause", Integer.valueOf(i));
            jSONObject.putOpt("task_key", this.mTaskKey);
            Object obj = this.mDownloadSettings;
            if (obj != null) {
                jSONObject.put("download_settings", obj);
            }
            List<String> list = this.mBackupUrls;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.mBackupUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("backup_urls", jSONArray);
            }
            DeepLink deepLink = this.mDeepLink;
            if (deepLink != null) {
                if (!TextUtils.isEmpty(deepLink.getOpenUrl())) {
                    jSONObject.put(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, this.mDeepLink.getOpenUrl());
                }
                if (!TextUtils.isEmpty(this.mDeepLink.getWebUrl())) {
                    jSONObject.put("web_url", this.mDeepLink.getWebUrl());
                }
            }
            uj ujVar = this.mQuickAppModel;
            if (ujVar != null) {
                jSONObject.putOpt("quick_app_url", ujVar.c());
            }
            List<String> list2 = this.mClickTrackUrl;
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = this.mClickTrackUrl.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("click_track_urls", jSONArray2);
            }
            Object obj2 = this.mExtra;
            if (obj2 != null) {
                jSONObject.put("extra", obj2);
            }
            Map<String, String> map = this.mHeaders;
            if (map != null && !map.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                    jSONArray3.put(entry.getKey());
                    jSONArray4.put(entry.getKey());
                }
                jSONObject.put("header_keys", jSONArray3);
                jSONObject.put("header_values", jSONArray4);
            }
        } catch (Exception e) {
            t.gt().c(e, "AdDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.byazt.su.DownloadModel
    public AdDownloadModel setFilePath(String str) {
        this.mFilePath = str;
        return this;
    }
}
