package com.aliyun.player.nativeclass;

import com.aliyun.auth.common.AliyunVodHttpCommon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MediaInfo {
    private String mVideoId = "";
    private String mTitle = "";
    private int mDuration = 0;
    private String mStatus = "";
    private String mCoverUrl = "";
    private String mMediaType = "";
    private String mTransCodeMode = AliyunVodHttpCommon.COMON_FAST_TRANSCODEMODE;
    private long mTotalBitrate = 0;
    private List<TrackInfo> mTrackInfos = new ArrayList();
    private List<Thumbnail> mThumbnailList = new ArrayList();

    private Object[] getTrackInfoArray() {
        return this.mTrackInfos.toArray();
    }

    private void setThumbnailList(Thumbnail[] thumbnailArr) {
        if (thumbnailArr == null || thumbnailArr.length <= 0) {
            return;
        }
        this.mThumbnailList.addAll(Arrays.asList(thumbnailArr));
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public List<Thumbnail> getThumbnailList() {
        return this.mThumbnailList;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getTotalBitrate() {
        return this.mTotalBitrate;
    }

    public List<TrackInfo> getTrackInfos() {
        return this.mTrackInfos;
    }

    public String getTransCodeMode() {
        return this.mTransCodeMode;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setTrackInfos(TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null || trackInfoArr.length <= 0) {
            return;
        }
        this.mTrackInfos.addAll(Arrays.asList(trackInfoArr));
    }
}
