package com.aliyun.svideosdk.multirecorder.config;

import android.text.TextUtils;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunVideoRecorderConfig {
    private final int crf;
    private final int encoderFps;
    private final int fps;
    private final int gop;
    private final String outputPath;
    private final int videoBitrate;
    private final VideoCodecs videoCodecs;
    private final int videoHeight;
    private final VideoQuality videoQuality;
    private final int videoWidth;

    @Visible
    public static class Builder {
        private int crf;
        private int encoderFps;
        private int fps;
        private int gop;
        private String outputPath;
        private int videoBitrate;
        private VideoCodecs videoCodecs;
        private int videoHeight;
        private VideoQuality videoQuality;
        private int videoWidth;

        private Builder() {
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.outputPath = null;
            this.fps = 30;
            this.videoCodecs = VideoCodecs.H264_HARDWARE;
            this.crf = com.aliyun.svideosdk.common.b.a.c;
            this.encoderFps = 30;
            this.videoQuality = VideoQuality.HD;
            this.gop = 125;
            this.videoBitrate = 0;
        }

        private void check() {
            if (this.videoWidth == 0 || this.videoHeight == 0) {
                throw new IllegalArgumentException("Should set videoWidth and videoHeight");
            }
            if (this.outputPath == null) {
                throw new IllegalArgumentException("Should set outputPath");
            }
        }

        public AliyunVideoRecorderConfig build() {
            check();
            return new AliyunVideoRecorderConfig(this);
        }

        public Builder crf(int i) {
            if (i >= com.aliyun.svideosdk.common.b.a.f25626a && i <= com.aliyun.svideosdk.common.b.a.b) {
                this.crf = i;
                return this;
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid crf value " + i + ", crf must be between " + com.aliyun.svideosdk.common.b.a.f25626a + " and " + com.aliyun.svideosdk.common.b.a.b);
            return this;
        }

        public Builder encoderFps(int i) {
            if (i >= 1 && i <= 120) {
                this.encoderFps = i;
                return this;
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid encoderFps value " + i + ", encoderFps must be between 1 and 120");
            return this;
        }

        public Builder fps(int i) {
            int i2 = this.crf;
            if (i2 >= 1 && i2 <= 120) {
                this.fps = i;
                return this;
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid fps value " + i + ", fps must be between 1 and 120");
            return this;
        }

        public Builder gop(int i) {
            if (i >= 0 && i <= 9000) {
                this.gop = i;
                return this;
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid gop value " + i + ", gop value must be between 0 and 9000");
            return this;
        }

        public Builder outputPath(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("outputPath should not be empty!");
            }
            this.outputPath = str;
            return this;
        }

        public Builder videoBitrate(int i) {
            if (i >= 200 && i <= 20000) {
                this.videoBitrate = i;
                return this;
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid video bitrate value " + i + ", video bitrate must be between 200 and 20000");
            return this;
        }

        public Builder videoCodecs(VideoCodecs videoCodecs) {
            if (videoCodecs == null) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Invalid VideoCodecs");
                return this;
            }
            this.videoCodecs = videoCodecs;
            return this;
        }

        public Builder videoHeight(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("videoHeight must be greater than 0!");
            }
            this.videoHeight = i;
            return this;
        }

        public Builder videoQuality(VideoQuality videoQuality) {
            if (videoQuality == null) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Invalid VideoQuality");
                return this;
            }
            this.videoQuality = videoQuality;
            return this;
        }

        public Builder videoWidth(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("videoWidth must be grate than 0!");
            }
            this.videoWidth = i;
            return this;
        }
    }

    private AliyunVideoRecorderConfig(Builder builder) {
        this.videoWidth = builder.videoWidth;
        this.videoHeight = builder.videoHeight;
        this.outputPath = builder.outputPath;
        this.fps = builder.fps;
        this.videoCodecs = builder.videoCodecs;
        this.crf = builder.crf;
        this.encoderFps = builder.encoderFps;
        this.videoQuality = builder.videoQuality;
        this.gop = builder.gop;
        this.videoBitrate = builder.videoBitrate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getCrf() {
        return this.crf;
    }

    public int getEncoderFps() {
        return this.encoderFps;
    }

    public int getFps() {
        return this.fps;
    }

    public int getGop() {
        return this.gop;
    }

    public String getOutputPath() {
        return this.outputPath;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public VideoCodecs getVideoCodecs() {
        return this.videoCodecs;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }
}
