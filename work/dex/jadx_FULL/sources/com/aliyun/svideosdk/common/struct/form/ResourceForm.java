package com.aliyun.svideosdk.common.struct.form;

import com.alibaba.ariver.permission.b;
import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class ResourceForm {
    private transient boolean isMore;

    @SerializedName("description")
    private String mDescription;

    @SerializedName(RemoteMessageConst.Notification.ICON)
    private String mIcon;

    @SerializedName("id")
    private int mId;

    @SerializedName("isNew")
    private int mIsNew;

    @SerializedName(b.b)
    private int mLevel;

    @SerializedName("name")
    private String mName;

    @SerializedName("pasterList")
    private List<PasterForm> mPasterList;

    @SerializedName("preview")
    private String mPreviewUrl;

    @SerializedName("sort")
    private int mSort;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mId == ((ResourceForm) obj).mId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public int getId() {
        return this.mId;
    }

    public int getIsNew() {
        return this.mIsNew;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getName() {
        return this.mName;
    }

    public List<PasterForm> getPasterList() {
        return this.mPasterList;
    }

    public String getPreviewUrl() {
        return this.mPreviewUrl;
    }

    public int getSort() {
        return this.mSort;
    }

    public int hashCode() {
        return this.mId;
    }

    public boolean isMore() {
        return this.isMore;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setIcon(String str) {
        this.mIcon = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setIsNew(int i) {
        this.mIsNew = i;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public void setMore(boolean z) {
        this.isMore = z;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPasterList(List<PasterForm> list) {
        this.mPasterList = list;
    }

    public void setPreviewUrl(String str) {
        this.mPreviewUrl = str;
    }

    public void setSort(int i) {
        this.mSort = i;
    }
}
