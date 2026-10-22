package com.fl.saas.adx.api;

import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdParams {
    private final float expressHeight;
    private final float expressWidth;
    private final boolean isMixNative;
    private final String key;
    private final String linkId;

    public static class Builder {
        private float expressHeight;
        private float expressWidth;
        private final String key;
        private String linkId = "";
        private boolean isMixNative = true;

        public Builder(String str) {
            this.key = str;
        }

        public AdParams build() {
            return new AdParams(this);
        }

        public Builder setExpressHeight(float f) {
            this.expressHeight = f;
            return this;
        }

        public Builder setExpressWidth(float f) {
            this.expressWidth = f;
            return this;
        }

        public Builder setIsMixNative(boolean z) {
            this.isMixNative = z;
            return this;
        }

        public Builder setLinkId(String str) {
            this.linkId = str;
            return this;
        }
    }

    private AdParams(Builder builder) {
        this.key = builder.key;
        this.linkId = builder.linkId;
        this.expressWidth = builder.expressWidth <= 0.0f ? DeviceUtil.px2dip(DeviceUtil.getMobileWidth()) : builder.expressWidth;
        this.expressHeight = builder.expressHeight;
        this.isMixNative = builder.isMixNative;
    }

    public float getExpressHeight() {
        float f = this.expressHeight;
        return f <= 0.0f ? this.expressWidth / 2.0f : f;
    }

    public float getExpressWidth() {
        return this.expressWidth;
    }

    public String getKey() {
        return this.key;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public boolean isMixNative() {
        return this.isMixNative;
    }
}
