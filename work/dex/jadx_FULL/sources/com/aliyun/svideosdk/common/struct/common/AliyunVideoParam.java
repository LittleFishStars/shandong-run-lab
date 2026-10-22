package com.aliyun.svideosdk.common.struct.common;

import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.video.spherical.a;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunVideoParam implements Serializable {
    private static final long serialVersionUID = 5802703421083731345L;
    private int mBitrate;
    private int mFrameRate;
    private int mGop;
    private int mOutputHeight;
    private int mOutputWidth;
    private int mCrf = 23;
    private float mScaleRate = 1.0f;
    private AudioSampleRate mAudioSampleRate = AudioSampleRate.AUDIO_PCM_44_1K;
    private AudioChannel mAudioChannel = AudioChannel.CHANNEL_STEREO;
    private VideoQuality mVideoQuality = VideoQuality.HD;
    private VideoDisplayMode mScaleMode = VideoDisplayMode.FILL;
    private VideoCodecs mVideoCodec = VideoCodecs.H264_HARDWARE;

    @Visible
    public enum AudioChannel {
        CHANNEL_MONO(1),
        CHANNEL_STEREO(2);

        private int value;

        AudioChannel(int i) {
            this.value = i;
        }

        public static AudioChannel getTypeByValue(int i) {
            if (i != 1) {
                return i != 2 ? CHANNEL_STEREO : CHANNEL_STEREO;
            }
            return CHANNEL_MONO;
        }

        public int getValue() {
            return this.value;
        }
    }

    @Visible
    public enum AudioSampleRate {
        AUDIO_PCM_8K(8000),
        AUDIO_PCM_12K(WifiManagerBridgeExtension.ERROR_12000),
        AUDIO_PCM_16K(16000),
        AUDIO_PCM_24K(24000),
        AUDIO_PCM_32K(a.h),
        AUDIO_PCM_44_1K(i.K),
        AUDIO_PCM_48K(48000),
        AUDIO_PCM_64K(64000),
        AUDIO_PCM_88_2K(88200),
        AUDIO_PCM_96K(96000);

        private int value;

        AudioSampleRate(int i) {
            this.value = i;
        }

        public static AudioSampleRate getTypeByValue(int i) {
            switch (i) {
                case 8000:
                    return AUDIO_PCM_8K;
                case WifiManagerBridgeExtension.ERROR_12000 /* 12000 */:
                    return AUDIO_PCM_12K;
                case 16000:
                    return AUDIO_PCM_16K;
                case 24000:
                    return AUDIO_PCM_24K;
                case a.h /* 32000 */:
                    return AUDIO_PCM_32K;
                case i.K /* 44100 */:
                    return AUDIO_PCM_44_1K;
                case 48000:
                    return AUDIO_PCM_48K;
                case 64000:
                    return AUDIO_PCM_64K;
                case 88200:
                    return AUDIO_PCM_88_2K;
                case 96000:
                    return AUDIO_PCM_96K;
                default:
                    return AUDIO_PCM_44_1K;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    @Visible
    public static class Builder {
        private AliyunVideoParam mVideoParam = new AliyunVideoParam();

        public Builder audioChannel(AudioChannel audioChannel) {
            this.mVideoParam.mAudioChannel = audioChannel;
            return this;
        }

        public Builder audioSampleRate(AudioSampleRate audioSampleRate) {
            this.mVideoParam.mAudioSampleRate = audioSampleRate;
            return this;
        }

        public Builder bitrate(int i) {
            this.mVideoParam.setBitrate(i);
            return this;
        }

        public AliyunVideoParam build() {
            return this.mVideoParam;
        }

        public Builder crf(int i) {
            this.mVideoParam.setCrf(i);
            return this;
        }

        public Builder frameRate(int i) {
            this.mVideoParam.setFrameRate(i);
            return this;
        }

        public Builder gop(int i) {
            this.mVideoParam.setGop(i);
            return this;
        }

        public Builder outputHeight(int i) {
            this.mVideoParam.setOutputHeight(i);
            return this;
        }

        public Builder outputWidth(int i) {
            this.mVideoParam.setOutputWidth(i);
            return this;
        }

        public Builder scaleMode(VideoDisplayMode videoDisplayMode) {
            this.mVideoParam.setScaleMode(videoDisplayMode);
            return this;
        }

        public Builder scaleRate(float f) {
            this.mVideoParam.setScaleRate(f);
            return this;
        }

        public Builder videoCodec(VideoCodecs videoCodecs) {
            this.mVideoParam.setVideoCodec(videoCodecs);
            return this;
        }

        public Builder videoQuality(VideoQuality videoQuality) {
            this.mVideoParam.setVideoQuality(videoQuality);
            return this;
        }
    }

    public AudioChannel getAudioChannel() {
        return this.mAudioChannel;
    }

    public AudioSampleRate getAudioSampleRate() {
        return this.mAudioSampleRate;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getCrf() {
        return this.mCrf;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public VideoDisplayMode getScaleMode() {
        VideoDisplayMode videoDisplayMode = this.mScaleMode;
        return videoDisplayMode == null ? VideoDisplayMode.FILL : videoDisplayMode;
    }

    public float getScaleRate() {
        return this.mScaleRate;
    }

    public VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public VideoQuality getVideoQuality() {
        VideoQuality videoQuality = this.mVideoQuality;
        return videoQuality == null ? VideoQuality.HD : videoQuality;
    }

    public void setAudioChannel(AudioChannel audioChannel) {
        this.mAudioChannel = audioChannel;
    }

    public void setAudioSampleRate(AudioSampleRate audioSampleRate) {
        this.mAudioSampleRate = audioSampleRate;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setFrameRate(int i) {
        if (i > 120) {
            i = 120;
        } else if (i <= 0) {
            i = 1;
        }
        this.mFrameRate = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setScaleMode(VideoDisplayMode videoDisplayMode) {
        this.mScaleMode = videoDisplayMode;
    }

    public void setScaleRate(float f) {
        this.mScaleRate = f;
    }

    public void setVideoCodec(VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public void setVideoQuality(VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }
}
