package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class PasterForm {

    @SerializedName("url")
    private String mDownloadUrl;

    @SerializedName("fontId")
    private int mFontId;

    @SerializedName(RemoteMessageConst.Notification.ICON)
    private String mIcon;

    @SerializedName("id")
    private int mId;

    @SerializedName(TKDownloadReason.KSAD_TK_MD5)
    private String mMD5;

    @SerializedName("name")
    private String mName;

    @SerializedName("path")
    private String mPath;

    @SerializedName("preview")
    private String mPreviewUrl;

    @SerializedName("priority")
    private int mPriority;

    @SerializedName("sort")
    private int mSort;

    @SerializedName("type")
    private int mType;

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public int getFontId() {
        return this.mFontId;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public int getId() {
        return this.mId;
    }

    public String getMD5() {
        return this.mMD5;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getPreviewUrl() {
        return this.mPreviewUrl;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getSort() {
        return this.mSort;
    }

    public int getType() {
        return this.mType;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setFontId(int i) {
        this.mFontId = i;
    }

    public void setIcon(String str) {
        this.mIcon = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMD5(String str) {
        this.mMD5 = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setPreviewUrl(String str) {
        this.mPreviewUrl = str;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setSort(int i) {
        this.mSort = i;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
