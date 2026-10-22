package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixRecorderDisplayParam {
    private VideoDisplayMode mDisplayMode;
    private int mLayoutLevel;
    private AliyunMixTrackLayoutParam mLayoutParam;

    @Visible
    public static final class Builder {
        private int mLayoutLevel;
        private VideoDisplayMode mDisplayMode = VideoDisplayMode.FILL;
        private AliyunMixTrackLayoutParam mLayoutParam = new AliyunMixTrackLayoutParam.Builder().build();

        public AliyunMixRecorderDisplayParam build() {
            return new AliyunMixRecorderDisplayParam(this);
        }

        public Builder displayMode(VideoDisplayMode videoDisplayMode) {
            this.mDisplayMode = videoDisplayMode;
            return this;
        }

        public Builder layoutLevel(int i) {
            this.mLayoutLevel = i;
            return this;
        }

        public Builder layoutParam(AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam) {
            this.mLayoutParam = aliyunMixTrackLayoutParam;
            return this;
        }
    }

    private AliyunMixRecorderDisplayParam(Builder builder) {
        this.mDisplayMode = builder.mDisplayMode;
        this.mLayoutLevel = builder.mLayoutLevel;
        this.mLayoutParam = builder.mLayoutParam;
    }

    public VideoDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getLayoutLevel() {
        return this.mLayoutLevel;
    }

    public AliyunMixTrackLayoutParam getLayoutParam() {
        return this.mLayoutParam;
    }
}
