package com.aliyun.svideosdk.common.struct.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunBorderParam {
    private int mBorderColor;
    private int mBorderWidth;
    private float mCorner;
    private float mCornerRadius;

    @Visible
    public static final class Builder {
        private int mBorderColor;
        private int mBorderWidth;
        private float mCorner;
        private float mCornerRadius = -1.0f;

        public Builder borderColor(int i) {
            this.mBorderColor = i;
            return this;
        }

        public Builder borderWidth(int i) {
            this.mBorderWidth = i;
            return this;
        }

        public AliyunBorderParam build() {
            return new AliyunBorderParam(this);
        }

        public Builder corner(float f) {
            this.mCorner = f;
            return this;
        }

        @Deprecated
        public Builder cornerRadius(float f) {
            this.mCornerRadius = f;
            return this;
        }
    }

    public AliyunBorderParam(Builder builder) {
        this.mBorderWidth = builder.mBorderWidth;
        this.mBorderColor = builder.mBorderColor;
        this.mCornerRadius = builder.mCornerRadius;
        this.mCorner = builder.mCorner;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCorner() {
        return this.mCorner;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }
}
