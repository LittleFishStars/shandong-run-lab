package cj.mobile.wm.common.bean;

import android.text.TextUtils;
import cj.mobile.wm.common.utils.GsonUtils;
import cj.mobile.wm.dexc;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdSlot {
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public int adHeight;
    public int adWidth;
    public int countDownDuration;
    public Map<String, Object> ext;
    public boolean isMutedSet;
    public boolean muted;
    public int orientation;
    public String rewardExt;
    public String serverBidToken;
    public String slotId;
    public String userId;
    public static final String EXT_SPLASH_KEY = dexc.dexa("fyu`tqmbti`cfbo");
    public static final String EXT_patch_KEY = dexc.dexa("fyu`qbudi`cfbo");
    public static final String RewardCodeKey = dexc.dexa("SfxbseDpefLfz");
    public static final String RewardMsgKey = dexc.dexa("SfxbseNthLfz");
    public static final String RewardUserIdKey = dexc.dexa("SfxbseVtfsJeLfz");
    public static final String RewardExtKey = dexc.dexa("SfxbseFyuLfz");
    public static final String RewardNameKey = dexc.dexa("SfxbseObnfLfz");
    public static final String RewardAmountKey = dexc.dexa("SfxbseBnpvouLfz");

    public WMAdSlot(Builder builder) {
        this.isMutedSet = false;
        this.slotId = builder.slotId;
        this.adWidth = builder.adWidth;
        this.adHeight = builder.adHeight;
        this.orientation = builder.orientation;
        this.muted = builder.muted;
        this.isMutedSet = builder.isMutedSet;
        this.ext = builder.ext;
        this.countDownDuration = builder.countDownDuration;
        this.serverBidToken = builder.serverBidToken;
        this.userId = builder.userId;
        this.rewardExt = builder.rewardExt;
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

    public String getRewardExt() {
        return this.rewardExt;
    }

    public String getServerBidToken() {
        return this.serverBidToken;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isMuted() {
        return this.muted;
    }

    public boolean isMutedSet() {
        return this.isMutedSet;
    }

    public static class Builder {
        public int adHeight;
        public int adWidth;
        public int countDownDuration;
        public Map<String, Object> ext;
        public int orientation;
        public String rewardExt;
        public String serverBidToken;
        public String slotId;
        public String userId;
        public boolean muted = true;
        public boolean isMutedSet = false;

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
            this.isMutedSet = true;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setRewardExt(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                this.rewardExt = GsonUtils.getInstance().toJson(map);
            }
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

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setRewardExt(String str) {
            if (TextUtils.isEmpty(str)) {
                this.rewardExt = str;
            }
            return this;
        }
    }
}
