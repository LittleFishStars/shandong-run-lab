package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMAdSlot {
    public static final String EXT_SPLASH_KEY = dexg.dexa("fyu`tqmbti`cfbo");
    public static final String EXT_patch_KEY = dexg.dexa("fyu`qbudi`cfbo");
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public int adHeight;
    public int adWidth;
    public int countDownDuration;
    public Map<String, Object> ext;
    public boolean muted;
    public int orientation;
    public String serverBidToken;
    public String slotId;

    @Keep
    public static class Builder {
        public int adHeight;
        public int adWidth;
        public int countDownDuration;
        public Map<String, Object> ext;
        public boolean muted;
        public int orientation;
        public String serverBidToken;
        public String slotId;

        public WMAdSlot builder() {
            return new WMAdSlot(this);
        }

        public Builder setAdSize(int i, int i2) {
            this.adWidth = i;
            this.adHeight = i2;
            return this;
        }

        public Builder setCountDownDuration(int i) {
            this.countDownDuration = i;
            return this;
        }

        public Builder setExt(Map<String, Object> map) {
            this.ext = map;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.muted = z;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setServerBidToken(String str) {
            this.serverBidToken = str;
            return this;
        }

        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }
    }

    public WMAdSlot(Builder builder) {
        this.slotId = builder.slotId;
        this.adWidth = builder.adWidth;
        this.adHeight = builder.adHeight;
        this.orientation = builder.orientation;
        this.muted = builder.muted;
        this.ext = builder.ext;
        this.countDownDuration = builder.countDownDuration;
        this.serverBidToken = builder.serverBidToken;
    }

    public int getAdHeight() {
        return this.adHeight;
    }

    public int getAdWidth() {
        return this.adWidth;
    }

    public int getCountDownDuration() {
        return this.countDownDuration;
    }

    public Map<String, Object> getExt() {
        return this.ext;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getServerBidToken() {
        return this.serverBidToken;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public boolean isMuted() {
        return this.muted;
    }
}
