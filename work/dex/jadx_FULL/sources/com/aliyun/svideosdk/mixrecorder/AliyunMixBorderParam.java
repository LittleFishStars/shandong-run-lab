package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixBorderParam {
    private int mBorderColor;
    private int mBorderWidth;
    private float mCornerRadius;

    @Visible
    public static final class Builder {
        private int mBorderColor;
        private int mBorderWidth;
        private float mCornerRadius;
        private int mTrackId;

        public Builder borderColor(int i) {
            this.mBorderColor = i;
            return this;
        }

        public Builder borderWidth(int i) {
            this.mBorderWidth = i;
            return this;
        }

        public AliyunMixBorderParam build() {
            return new AliyunMixBorderParam(this);
        }

        public Builder cornerRadius(float f) {
            this.mCornerRadius = f;
            return this;
        }
    }

    public AliyunMixBorderParam(Builder builder) {
        this.mBorderWidth = builder.mBorderWidth;
        this.mBorderColor = builder.mBorderColor;
        this.mCornerRadius = builder.mCornerRadius;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }
}
