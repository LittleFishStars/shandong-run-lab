package com.aliyun.svideosdk.common.struct.common;

import android.util.Log;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunLayoutParam {
    private final float centerX;
    private final float centerY;
    private final VideoDisplayMode displayMode;
    private final float heightRatio;
    private final int layoutLevel;
    private final float widthRatio;

    @Visible
    public static final class Builder {
        private float centerX;
        private float centerY;
        private VideoDisplayMode displayMode;
        private float heightRatio;
        private int layoutLevel;
        private float widthRatio;

        private Builder() {
            this.centerX = 0.5f;
            this.centerY = 0.5f;
            this.widthRatio = 1.0f;
            this.heightRatio = 1.0f;
            this.layoutLevel = 1;
            this.displayMode = VideoDisplayMode.FILL;
        }

        public AliyunLayoutParam build() {
            return new AliyunLayoutParam(this);
        }

        public Builder centerX(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.centerX = f;
                return this;
            }
            Log.e("AliYunLog", "centerX " + f + " is invalid");
            return this;
        }

        public Builder centerY(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.centerY = f;
                return this;
            }
            Log.e("AliYunLog", "centerY " + f + " is invalid");
            return this;
        }

        public Builder displayMode(VideoDisplayMode videoDisplayMode) {
            if (videoDisplayMode == null) {
                Log.e("AliYunLog", "VideoDisplayMode is invalid");
                return this;
            }
            this.displayMode = videoDisplayMode;
            return this;
        }

        public Builder heightRatio(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.heightRatio = f;
                return this;
            }
            Log.e("AliYunLog", "heightRatio " + f + " is invalid");
            return this;
        }

        public Builder layoutLevel(int i) {
            this.layoutLevel = i;
            return this;
        }

        public Builder widthRatio(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.widthRatio = f;
                return this;
            }
            Log.e("AliYunLog", "widthRatio " + f + " is invalid");
            return this;
        }
    }

    private AliyunLayoutParam(Builder builder) {
        this.centerX = builder.centerX;
        this.centerY = builder.centerY;
        this.widthRatio = builder.widthRatio;
        this.heightRatio = builder.heightRatio;
        this.layoutLevel = builder.layoutLevel;
        this.displayMode = builder.displayMode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public VideoDisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public float getHeightRatio() {
        return this.heightRatio;
    }

    public int getLayoutLevel() {
        return this.layoutLevel;
    }

    public float getWidthRatio() {
        return this.widthRatio;
    }
}
