package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixTrackLayoutParam {
    private float mCenterX;
    private float mCenterY;
    private float mHeightRatio;
    private AliyunMixBorderParam mMixBorderParam;
    private float mWidthRatio;

    @Visible
    public static final class Builder {
        private AliyunMixBorderParam mMixBorderParam;
        private float mCenterX = 0.5f;
        private float mCenterY = 0.5f;
        private float mWidthRatio = 1.0f;
        private float mHeightRatio = 1.0f;

        public Builder borderParam(AliyunMixBorderParam aliyunMixBorderParam) {
            this.mMixBorderParam = aliyunMixBorderParam;
            return this;
        }

        public AliyunMixTrackLayoutParam build() {
            return new AliyunMixTrackLayoutParam(this);
        }

        public Builder centerX(float f) {
            StringBuilder sb;
            float f2 = 0.0f;
            if (f >= 0.0f) {
                f2 = 1.0f;
                if (f > 1.0f) {
                    sb = new StringBuilder();
                }
                this.mCenterX = f;
                return this;
            }
            sb = new StringBuilder();
            sb.append("Invalid centerX value ");
            sb.append(f);
            sb.append(", centerX value has must be between 0 and 1!");
            com.aliyun.common.c.a.a.b("AliYunLog", sb.toString());
            f = f2;
            this.mCenterX = f;
            return this;
        }

        public Builder centerY(float f) {
            StringBuilder sb;
            float f2 = 0.0f;
            if (f >= 0.0f) {
                f2 = 1.0f;
                if (f > 1.0f) {
                    sb = new StringBuilder();
                }
                this.mCenterY = f;
                return this;
            }
            sb = new StringBuilder();
            sb.append("Invalid centerY value ");
            sb.append(f);
            sb.append(", centerY value has must be between 0 and 1!");
            com.aliyun.common.c.a.a.b("AliYunLog", sb.toString());
            f = f2;
            this.mCenterY = f;
            return this;
        }

        public Builder heightRatio(float f) {
            if (f > 1.0f) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Height ratio must be larger than 0 and less than 1!");
                this.mHeightRatio = 1.0f;
            } else if (f > 0.0f) {
                this.mHeightRatio = f;
            } else {
                com.aliyun.common.c.a.a.b("AliYunLog", "Height ratio must be larger than 0 and less than 1!");
            }
            return this;
        }

        public Builder widthRatio(float f) {
            if (f > 1.0f) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Width ratio must be larger than 0 and less than 1!");
                this.mWidthRatio = 1.0f;
            } else if (f > 0.0f) {
                this.mWidthRatio = f;
            } else {
                com.aliyun.common.c.a.a.b("AliYunLog", "Width ratio must be larger than 0 and less than 1!");
            }
            return this;
        }
    }

    private AliyunMixTrackLayoutParam(Builder builder) {
        this.mCenterX = builder.mCenterX;
        this.mCenterY = builder.mCenterY;
        this.mWidthRatio = builder.mWidthRatio;
        this.mHeightRatio = builder.mHeightRatio;
        this.mMixBorderParam = builder.mMixBorderParam;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public float getHeightRatio() {
        return this.mHeightRatio;
    }

    public AliyunMixBorderParam getMixBorderParam() {
        return this.mMixBorderParam;
    }

    public float getWidthRatio() {
        return this.mWidthRatio;
    }
}
