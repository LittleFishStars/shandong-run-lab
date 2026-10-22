package com.beizi.fusion.bzunified;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiUnifiedAdRequestParameters {
    private String extraData;
    private String spaceId;
    private int timeout;

    public static class Builder {
        private String extraData;
        private String spaceId;
        private int timeout;

        public BeiZiUnifiedAdRequestParameters build() {
            BeiZiUnifiedAdRequestParameters beiZiUnifiedAdRequestParameters = new BeiZiUnifiedAdRequestParameters();
            beiZiUnifiedAdRequestParameters.setSpaceId(this.spaceId);
            beiZiUnifiedAdRequestParameters.setTimeout(this.timeout);
            beiZiUnifiedAdRequestParameters.setExtraData(this.extraData);
            return beiZiUnifiedAdRequestParameters;
        }

        public Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public Builder setSpaceId(String str) {
            this.spaceId = str;
            return this;
        }

        public Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }
    }

    public String getExtraData() {
        return this.extraData;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }
}
