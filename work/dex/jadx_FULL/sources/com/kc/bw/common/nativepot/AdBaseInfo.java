package com.kc.bw.common.nativepot;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdBaseInfo {
    public String adLogoUrl;
    public String crid;
    public String desc;
    public WMDownloadAppInfo downloadAppInfo;
    public String iconURL;
    public String imageUrl;
    public List<String> imageUrls;
    public InteractionType interactionType;
    public MaterialType materialType;
    public int pictureHeight;
    public int pictureWidth;
    public String title;
    public int videoHeight;
    public String videoUrl;
    public int videoWidth;

    @Keep
    public enum InteractionType {
        NORMAL,
        DOWNLOAD
    }

    @Keep
    public enum MaterialType {
        NORMAL,
        VIDEO,
        HTML
    }

    @Keep
    public static class WMDownloadAppInfo {
        public List<WMPermission> WMPermissionList;
        public String appDescContent;
        public String appDescUrl;
        public String appDeveloper;
        public String appIconUrl;
        public String appName;
        public long appSize;
        public String appVersion;
        public String permissionUrl;
        public String privacyUrl;

        public String getAppDescContent() {
            return this.appDescContent;
        }

        public String getAppDescUrl() {
            return this.appDescUrl;
        }

        public String getAppDeveloper() {
            return this.appDeveloper;
        }

        public String getAppIconUrl() {
            return this.appIconUrl;
        }

        public String getAppName() {
            return this.appName;
        }

        public long getAppSize() {
            return this.appSize;
        }

        public String getAppVersion() {
            return this.appVersion;
        }

        public List<WMPermission> getPermissionList() {
            return this.WMPermissionList;
        }

        public String getPermissionUrl() {
            return this.permissionUrl;
        }

        public String getPrivacyUrl() {
            return this.privacyUrl;
        }

        public void setAppDescContent(String str) {
            this.appDescContent = str;
        }

        public void setAppDescUrl(String str) {
            this.appDescUrl = str;
        }

        public void setAppDeveloper(String str) {
            this.appDeveloper = str;
        }

        public void setAppIconUrl(String str) {
            this.appIconUrl = str;
        }

        public void setAppName(String str) {
            this.appName = str;
        }

        public void setAppSize(long j) {
            this.appSize = j;
        }

        public void setAppVersion(String str) {
            this.appVersion = str;
        }

        public void setPermissionList(List<WMPermission> list) {
            this.WMPermissionList = list;
        }

        public void setPermissionUrl(String str) {
            this.permissionUrl = str;
        }

        public void setPrivacyUrl(String str) {
            this.privacyUrl = str;
        }

        public String toString() {
            return dexg.dexa("EpxompbeBqqJogp|bqqObnf>(") + this.appName + '\'' + dexg.dexa("-!bqqWfstjpo>(") + this.appVersion + '\'' + dexg.dexa("-!bqqEfwfmpqfs>(") + this.appDeveloper + '\'' + dexg.dexa("-!bqqEftdVsm>(") + this.appDescUrl + '\'' + dexg.dexa("-!bqqEftdDpoufou>(") + this.appDescContent + '\'' + dexg.dexa("-!qfsnjttjpoVsm>(") + this.permissionUrl + '\'' + dexg.dexa("-!qfsnjttjpoMjtu>") + this.WMPermissionList + dexg.dexa("-!qsjwbdzVsm>(") + this.privacyUrl + '\'' + dexg.dexa("-!bqqJdpoVsm>(") + this.appIconUrl + '\'' + dexg.dexa("-!bqqTj{f>") + this.appSize + '}';
        }
    }

    public String getAdLogoUrl() {
        return this.adLogoUrl;
    }

    public String getCrid() {
        return this.crid;
    }

    public String getDesc() {
        return this.desc;
    }

    public WMDownloadAppInfo getDownloadAppInfo() {
        return this.downloadAppInfo;
    }

    public String getIconURL() {
        return this.iconURL;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public InteractionType getInteractionType() {
        return this.interactionType;
    }

    public MaterialType getMaterialType() {
        return this.materialType;
    }

    public int getPictureHeight() {
        return this.pictureHeight;
    }

    public int getPictureWidth() {
        return this.pictureWidth;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setAdLogoUrl(String str) {
        this.adLogoUrl = str;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public AdBaseInfo setDesc(String str) {
        this.desc = str;
        return this;
    }

    public AdBaseInfo setDownloadAppInfo(WMDownloadAppInfo wMDownloadAppInfo) {
        this.downloadAppInfo = wMDownloadAppInfo;
        return this;
    }

    public AdBaseInfo setIconURL(String str) {
        this.iconURL = str;
        return this;
    }

    public AdBaseInfo setImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public AdBaseInfo setImageUrls(List<String> list) {
        this.imageUrls = list;
        return this;
    }

    public AdBaseInfo setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
        return this;
    }

    public AdBaseInfo setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
        return this;
    }

    public AdBaseInfo setPictureHeight(int i) {
        this.pictureHeight = i;
        return this;
    }

    public AdBaseInfo setPictureWidth(int i) {
        this.pictureWidth = i;
        return this;
    }

    public AdBaseInfo setTitle(String str) {
        this.title = str;
        return this;
    }

    public AdBaseInfo setVideoHeight(int i) {
        this.videoHeight = i;
        return this;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public AdBaseInfo setVideoWidth(int i) {
        this.videoWidth = i;
        return this;
    }

    public String toString() {
        return dexg.dexa("BeCbtfJogp|ujumf>(") + this.title + '\'' + dexg.dexa("-!jdpoVSM>(") + this.iconURL + '\'' + dexg.dexa("-!eftd>(") + this.desc + '\'' + dexg.dexa("-!jnbhfVsm>(") + this.imageUrl + '\'' + dexg.dexa("-!jnbhfVsmt>") + this.imageUrls + dexg.dexa("-!qjduvsfXjeui>") + this.pictureWidth + dexg.dexa("-!qjduvsfIfjhiu>") + this.pictureHeight + dexg.dexa("-!wjefpXjeui>") + this.videoWidth + dexg.dexa("-!wjefpIfjhiu>") + this.videoHeight + dexg.dexa("-!nbufsjbmUzqf>") + this.materialType + dexg.dexa("-!joufsbdujpoUzqf>") + this.interactionType + dexg.dexa("-!epxompbeBqqJogp>") + this.downloadAppInfo + '}';
    }
}
