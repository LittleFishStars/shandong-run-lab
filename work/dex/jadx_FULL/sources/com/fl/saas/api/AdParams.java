package com.fl.saas.api;

import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdParams {
    private final boolean expressAutoHeight;
    private final boolean expressFullWidth;
    private final float expressHeight;
    private final float expressWidth;
    private final int imageAcceptedHeight;
    private final int imageAcceptedWidth;
    private final String key;
    private final boolean useSurfaceView;

    public static class Builder {
        private boolean expressAutoHeight;
        private boolean expressFullWidth;
        private float expressHeight;
        private float expressWidth;
        private int imageAcceptedHeight;
        private int imageAcceptedWidth;
        private final String key;
        private boolean useSurfaceView;

        public Builder(String str) {
            this.key = str;
        }

        public AdParams build() {
            return new AdParams(this);
        }

        public Builder setExpressAutoHeight() {
            this.expressAutoHeight = true;
            return this;
        }

        public Builder setExpressAutoHeight(boolean z) {
            this.expressAutoHeight = z;
            return this;
        }

        public Builder setExpressFullWidth() {
            this.expressFullWidth = true;
            return this;
        }

        public Builder setExpressFullWidth(boolean z) {
            this.expressFullWidth = z;
            return this;
        }

        public Builder setExpressHeight(float f) {
            this.expressHeight = f;
            return this;
        }

        public Builder setExpressWidth(float f) {
            this.expressWidth = f;
            return this;
        }

        public Builder setImageAcceptedHeight(int i) {
            this.imageAcceptedHeight = i;
            return this;
        }

        public Builder setImageAcceptedWidth(int i) {
            this.imageAcceptedWidth = i;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.useSurfaceView = z;
            return this;
        }
    }

    private AdParams(Builder builder) {
        this.key = builder.key;
        this.expressWidth = builder.expressWidth <= 0.0f ? DeviceUtil.px2dip(DeviceUtil.getMobileWidth()) : builder.expressWidth;
        this.expressHeight = builder.expressHeight;
        this.imageAcceptedWidth = builder.imageAcceptedWidth;
        this.imageAcceptedHeight = builder.imageAcceptedHeight;
        this.expressAutoHeight = builder.expressAutoHeight;
        this.expressFullWidth = builder.expressFullWidth;
        this.useSurfaceView = builder.useSurfaceView;
    }

    public float getExpressHeight() {
        float f = this.expressHeight;
        return f <= 0.0f ? this.expressWidth / 2.0f : f;
    }

    public float getExpressWidth() {
        return this.expressWidth;
    }

    public int getImageAcceptedHeight() {
        return this.imageAcceptedHeight;
    }

    public int getImageAcceptedWidth() {
        return this.imageAcceptedWidth;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isExpressAutoHeight() {
        return this.expressAutoHeight;
    }

    public boolean isExpressFullWidth() {
        return this.expressFullWidth;
    }

    public boolean isUseSurfaceView() {
        return this.useSurfaceView;
    }
}
