package com.bytedance.android.live.base.api.push;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface PushInterceptor {

    public static class InterceptResult {
        public boolean intercept;
        public String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z) {
            this(z, "");
        }

        public InterceptResult(boolean z, String str) {
            this.intercept = z;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
