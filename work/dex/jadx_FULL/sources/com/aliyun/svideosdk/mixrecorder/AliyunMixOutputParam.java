package com.aliyun.svideosdk.mixrecorder;

import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixOutputParam {
    private int mBitrate;
    private int mCrf;
    private int mFps;
    private int mGopSize;
    private AliyunMixTrack mOutputAudioReferenceTrack;
    private AliyunMixTrack mOutputDurationReferenceTrack;
    private int mOutputHeight;
    private String mOutputPath;
    private int mOutputWidth;
    private VideoQuality mVideoQuality;

    @Visible
    public static final class Builder {
        private int mBitrate;
        private AliyunMixTrack mOutputAudioReferenceTrack;
        private AliyunMixTrack mOutputDurationReferenceTrack;
        private int mOutputHeight;
        private String mOutputPath;
        private int mOutputWidth;
        private int mCrf = 23;
        private VideoQuality mVideoQuality = VideoQuality.SSD;
        private int mFps = 30;
        private int mGopSize = 60;

        public Builder bitrate(int i) {
            if (i < 200) {
                Log.e("AliYunLog", "Invalid bitrate value " + i + ", bitrate value has must be between 200 and 20000");
                i = 200;
            } else if (i > 20000) {
                Log.e("AliYunLog", "Invalid bitrate value " + i + ", bitrate value has must be between 200 and 20000");
                i = 20000;
            }
            this.mBitrate = i;
            return this;
        }

        public AliyunMixOutputParam build() {
            return new AliyunMixOutputParam(this);
        }

        public Builder crf(int i) {
            if (i < com.aliyun.svideosdk.common.b.a.f25626a) {
                Log.e("AliYunLog", "Invalid crf value " + i + ", crf value has must be between " + com.aliyun.svideosdk.common.b.a.f25626a + " and " + com.aliyun.svideosdk.common.b.a.b);
                i = com.aliyun.svideosdk.common.b.a.f25626a;
            } else if (i > com.aliyun.svideosdk.common.b.a.b) {
                Log.e("AliYunLog", "Invalid crf value " + i + ", crf value has must be between " + com.aliyun.svideosdk.common.b.a.f25626a + " and " + com.aliyun.svideosdk.common.b.a.b);
                i = com.aliyun.svideosdk.common.b.a.b;
            }
            this.mCrf = i;
            return this;
        }

        public Builder fps(int i) {
            if (i < 1) {
                Log.e("AliYunLog", "Invalid fps value " + i + ", fps value has must be between 1 and 120");
                i = 1;
            } else if (i > 120) {
                Log.e("AliYunLog", "Invalid fps value " + i + ", fps value has must be between 1 and 120");
                i = 120;
            }
            this.mFps = i;
            return this;
        }

        public Builder gopSize(int i) {
            if (i < 0) {
                Log.e("AliYunLog", "Invalid gop value " + i + ", gop value has must be between 0 and 9000");
                i = 0;
            } else if (i > 9000) {
                Log.e("AliYunLog", "Invalid gop value " + i + ", gop value has must be between 0 and 9000");
                i = 9000;
            }
            this.mGopSize = i;
            return this;
        }

        public Builder outputAudioReferenceTrack(AliyunMixTrack aliyunMixTrack) {
            aliyunMixTrack.setIsOutputAudioTrack(true);
            this.mOutputAudioReferenceTrack = aliyunMixTrack;
            return this;
        }

        public Builder outputDurationReferenceTrack(AliyunMixTrack aliyunMixTrack) {
            this.mOutputDurationReferenceTrack = aliyunMixTrack;
            return this;
        }

        public Builder outputHeight(int i) {
            if (i > 0) {
                this.mOutputHeight = i;
            }
            return this;
        }

        public Builder outputPath(String str) {
            this.mOutputPath = str;
            return this;
        }

        public Builder outputWidth(int i) {
            if (i > 0) {
                this.mOutputWidth = i;
            }
            return this;
        }

        public Builder videoQuality(VideoQuality videoQuality) {
            if (videoQuality != null) {
                this.mVideoQuality = videoQuality;
            }
            return this;
        }
    }

    private AliyunMixOutputParam(Builder builder) {
        this.mOutputPath = builder.mOutputPath;
        this.mOutputDurationReferenceTrack = builder.mOutputDurationReferenceTrack;
        this.mOutputAudioReferenceTrack = builder.mOutputAudioReferenceTrack;
        this.mOutputWidth = builder.mOutputWidth;
        this.mOutputHeight = builder.mOutputHeight;
        this.mCrf = builder.mCrf;
        this.mBitrate = builder.mBitrate;
        this.mVideoQuality = builder.mVideoQuality;
        this.mFps = builder.mFps;
        this.mGopSize = builder.mGopSize;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getCrf() {
        return this.mCrf;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getGopSize() {
        return this.mGopSize;
    }

    public AliyunMixTrack getOutputAudioReferenceTrack() {
        return this.mOutputAudioReferenceTrack;
    }

    public AliyunMixTrack getOutputDurationReferenceTrack() {
        return this.mOutputDurationReferenceTrack;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public String getOutputPath() {
        return this.mOutputPath;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }
}
