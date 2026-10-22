package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixStream {
    private VideoDisplayMode mDisplayMode;
    private String mFilePath;
    private long mStreamEndTime;
    private int mStreamId;
    private long mStreamStartTime;
    private AliyunMixTrack mTrack;

    @Visible
    public static final class Builder {
        private VideoDisplayMode mDisplayMode = VideoDisplayMode.FILL;
        private String mFilePath;
        private long mStreamEndTime;
        private long mStreamStartTime;

        public AliyunMixStream build() {
            return new AliyunMixStream(this);
        }

        public Builder displayMode(VideoDisplayMode videoDisplayMode) {
            this.mDisplayMode = videoDisplayMode;
            return this;
        }

        public Builder filePath(String str) {
            this.mFilePath = str;
            return this;
        }

        public Builder streamEndTime(long j, TimeUnit timeUnit) {
            this.mStreamEndTime = timeUnit.toMillis(j);
            return this;
        }

        public Builder streamEndTimeMills(long j) {
            this.mStreamEndTime = j;
            return this;
        }

        public Builder streamStartTime(long j, TimeUnit timeUnit) {
            this.mStreamStartTime = timeUnit.toMillis(j);
            return this;
        }

        public Builder streamStartTimeMills(long j) {
            this.mStreamStartTime = j;
            return this;
        }
    }

    private AliyunMixStream(Builder builder) {
        this.mFilePath = builder.mFilePath;
        this.mStreamStartTime = builder.mStreamStartTime;
        this.mStreamEndTime = builder.mStreamEndTime;
        this.mDisplayMode = builder.mDisplayMode;
    }

    public VideoDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public long getStreamEndTimeMills() {
        return this.mStreamEndTime;
    }

    public int getStreamId() {
        return this.mStreamId;
    }

    public long getStreamStartTimeMills() {
        return this.mStreamStartTime;
    }

    public AliyunMixTrack getTrack() {
        return this.mTrack;
    }

    public void setStreamId(int i) {
        this.mStreamId = i;
    }

    public void setTrack(AliyunMixTrack aliyunMixTrack) {
        this.mTrack = aliyunMixTrack;
    }
}
