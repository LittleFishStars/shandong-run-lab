package com.aliyun.player.source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UrlSource extends SourceBase {
    private long mOriginSize;
    private String mUri = null;
    private String mCacheFilePath = null;

    public UrlSource() {
        this.mQuality = "AUTO";
        this.mForceQuality = true;
        this.mOriginSize = 0L;
    }

    public String getCacheFilePath() {
        return this.mCacheFilePath;
    }

    public long getOriginSize() {
        return this.mOriginSize;
    }

    public String getUri() {
        return this.mUri;
    }

    public void setCacheFilePath(String str) {
        this.mCacheFilePath = str;
    }

    public void setOriginSize(long j) {
        this.mOriginSize = j;
    }

    public void setUri(String str) {
        this.mUri = str;
    }
}
