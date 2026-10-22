package com.kc.openset.video;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class VideoTuBeConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39994a;
    private final int b;
    private final VideoTubeDramaMode c;
    private final String d;
    private final String e;

    @Keep
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f39995a;
        private int b;
        private VideoTubeDramaMode c;
        private String d;
        private String e;

        public VideoTuBeConfig build() {
            return new VideoTuBeConfig(this);
        }

        public Builder setDramaMode(VideoTubeDramaMode videoTubeDramaMode) {
            this.c = videoTubeDramaMode;
            return this;
        }

        public Builder setFreeEpisodeCount(int i) {
            this.f39995a = i;
            return this;
        }

        public Builder setRewardId(String str) {
            this.d = str;
            return this;
        }

        public Builder setUnlockEpisodesCount(int i) {
            this.b = i;
            return this;
        }

        public Builder setUserId(String str) {
            this.e = str;
            return this;
        }
    }

    private VideoTuBeConfig(Builder builder) {
        this.f39994a = builder.f39995a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    public VideoTubeDramaMode getDramaMode() {
        return this.c;
    }

    public int getFreeEpisodeCount() {
        return this.f39994a;
    }

    public String getRewardId() {
        return this.d;
    }

    public int getUnlockEpisodesCount() {
        return this.b;
    }

    public String getUserId() {
        return this.e;
    }
}
