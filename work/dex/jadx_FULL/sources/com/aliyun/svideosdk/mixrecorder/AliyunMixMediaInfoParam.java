package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixMediaInfoParam {
    private AliyunMixRecorderDisplayParam mMixDisplayParam;
    private String mMixVideoFilePath;
    private AliyunMixRecorderDisplayParam mRecordDisplayParam;
    private long mStreamEndTimeMills;
    private long mStreamStartTimeMills;

    @Visible
    public static final class Builder {
        private AliyunMixRecorderDisplayParam mMixDisplayParam;
        private String mMixVideoFilePath;
        private AliyunMixRecorderDisplayParam mRecordDisplayParam;
        private long mStreamEndTimeMills;
        private long mStreamStartTimeMills;

        public AliyunMixMediaInfoParam build() {
            return new AliyunMixMediaInfoParam(this);
        }

        public Builder mixDisplayParam(AliyunMixRecorderDisplayParam aliyunMixRecorderDisplayParam) {
            this.mMixDisplayParam = aliyunMixRecorderDisplayParam;
            return this;
        }

        public Builder mixVideoFilePath(String str) {
            this.mMixVideoFilePath = str;
            return this;
        }

        public Builder recordDisplayParam(AliyunMixRecorderDisplayParam aliyunMixRecorderDisplayParam) {
            this.mRecordDisplayParam = aliyunMixRecorderDisplayParam;
            return this;
        }

        public Builder streamEndTimeMills(long j) {
            this.mStreamEndTimeMills = j;
            return this;
        }

        public Builder streamStartTimeMills(long j) {
            this.mStreamStartTimeMills = j;
            return this;
        }
    }

    private AliyunMixMediaInfoParam(Builder builder) {
        this.mMixVideoFilePath = builder.mMixVideoFilePath;
        this.mStreamStartTimeMills = builder.mStreamStartTimeMills;
        this.mStreamEndTimeMills = builder.mStreamEndTimeMills;
        this.mRecordDisplayParam = builder.mRecordDisplayParam;
        this.mMixDisplayParam = builder.mMixDisplayParam;
    }

    public AliyunMixRecorderDisplayParam getMixDisplayParam() {
        return this.mMixDisplayParam;
    }

    public String getMixVideoFilePath() {
        return this.mMixVideoFilePath;
    }

    public AliyunMixRecorderDisplayParam getRecordDisplayParam() {
        return this.mRecordDisplayParam;
    }

    public long getStreamEndTimeMills() {
        return this.mStreamEndTimeMills;
    }

    public long getStreamStartTimeMills() {
        return this.mStreamStartTimeMills;
    }
}
