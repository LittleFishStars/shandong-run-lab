package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.ISource;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class Source implements ISource {

    @SerializedName("SourceId")
    private String mId;

    @SerializedName("Path")
    private String mPath;

    @SerializedName("URL")
    private String mURL;

    public Source() {
    }

    public Source(String str) {
        this.mPath = str;
    }

    public Source(String str, String str2) {
        this.mId = str;
        this.mPath = str2;
    }

    public Source(String str, String str2, String str3) {
        this.mId = str;
        this.mPath = str2;
        this.mURL = str3;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Source)) {
            return false;
        }
        Source source = (Source) obj;
        if (equals(this.mPath, source.mPath)) {
            return true;
        }
        return equals(this.mId, source.mId) && equals(this.mURL, source.mURL);
    }

    @Override // com.aliyun.svideosdk.common.ISource
    public String getId() {
        return this.mId;
    }

    public int getIntId() {
        try {
            return Integer.parseInt(getId());
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.aliyun.svideosdk.common.ISource
    public String getPath() {
        return this.mPath;
    }

    @Override // com.aliyun.svideosdk.common.ISource
    public String getURL() {
        return this.mURL;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setURL(String str) {
        this.mURL = str;
    }
}
