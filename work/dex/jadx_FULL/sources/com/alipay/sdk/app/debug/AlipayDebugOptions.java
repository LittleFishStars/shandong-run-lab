package com.alipay.sdk.app.debug;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlipayDebugOptions {
    private AlipayPayLifeCycle mAlipayPayLifeCycle;

    public interface AlipayPayLifeCycle {
        void onPayEnd(JSONObject jSONObject);
    }

    public static class Builder {
        private AlipayDebugOptions alipayDebugOptions;

        public Builder() {
            this.alipayDebugOptions = null;
            this.alipayDebugOptions = new AlipayDebugOptions();
        }

        public AlipayDebugOptions build() {
            return this.alipayDebugOptions;
        }

        public Builder setAlipayPayLifeCycle(AlipayPayLifeCycle alipayPayLifeCycle) {
            this.alipayDebugOptions.mAlipayPayLifeCycle = alipayPayLifeCycle;
            return this;
        }
    }

    public AlipayPayLifeCycle getAlipayPayLifeCycle() {
        return this.mAlipayPayLifeCycle;
    }

    private AlipayDebugOptions() {
        this.mAlipayPayLifeCycle = null;
    }
}
