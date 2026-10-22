package com.ipd.dsp;

import androidx.annotation.Keep;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DspConfig {

    @Keep
    public String appId;

    @Keep
    public DspCustomController customController;

    @Keep
    public LinkedList<String> hosts;

    @Keep
    public boolean httpsOnly;

    @Keep
    public DspInitCallback initCallback;

    @Keep
    public boolean isDebug;

    @Keep
    public String oaid;

    @Keep
    public boolean personalRecommend;

    @Keep
    public boolean programmaticRecommend;

    @Keep
    public String wxOpenId;

    @Keep
    public static class Builder {
        private String appId;
        private DspCustomController customController;
        private LinkedList<String> hosts;
        private DspInitCallback initCallback;
        private boolean isDebug;
        private String oaid;
        private String wxOpenId;
        private boolean personalRecommend = true;
        private boolean programmaticRecommend = true;
        private boolean httpsOnly = false;

        @Keep
        public Builder() {
        }

        @Keep
        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        @Keep
        public DspConfig build() {
            return new DspConfig(this);
        }

        @Keep
        public Builder customController(DspCustomController dspCustomController) {
            this.customController = dspCustomController;
            return this;
        }

        @Keep
        public Builder debug(boolean z) {
            this.isDebug = z;
            return this;
        }

        @Keep
        public Builder hosts(LinkedList<String> linkedList) {
            if (linkedList != null && !linkedList.isEmpty()) {
                this.hosts = linkedList;
            }
            return this;
        }

        @Keep
        public Builder httpsOnly(boolean z) {
            this.httpsOnly = z;
            return this;
        }

        @Keep
        public Builder initCallback(DspInitCallback dspInitCallback) {
            this.initCallback = dspInitCallback;
            return this;
        }

        @Keep
        public Builder oaid(String str) {
            this.oaid = str;
            return this;
        }

        @Keep
        public Builder personalRecommend(boolean z) {
            this.personalRecommend = z;
            return this;
        }

        @Keep
        public Builder programmaticRecommend(boolean z) {
            this.programmaticRecommend = z;
            return this;
        }

        @Keep
        public Builder wxOpenId(String str) {
            this.wxOpenId = str;
            return this;
        }
    }

    @Keep
    public interface DspInitCallback {
        @Keep
        void onFail(int i, String str);

        @Keep
        void onSuccess();
    }

    private DspConfig(Builder builder) {
        this.isDebug = builder.isDebug;
        this.appId = builder.appId;
        this.customController = builder.customController;
        this.initCallback = builder.initCallback;
        this.personalRecommend = builder.personalRecommend;
        this.programmaticRecommend = builder.programmaticRecommend;
        this.httpsOnly = builder.httpsOnly;
        this.wxOpenId = builder.wxOpenId;
        this.oaid = builder.oaid;
        this.hosts = builder.hosts;
    }
}
