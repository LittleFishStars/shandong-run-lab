package com.aliyun.vod.common.global;

import android.content.Context;
import com.aliyun.vod.common.utils.SignatureUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AppInfo {
    private static final String TAG = "com.aliyun.vod.common.global.AppInfo";
    private String mSignature;

    public static class AppInfoHolder {
        private static AppInfo sAppInfoInstance = new AppInfo();

        private AppInfoHolder() {
        }
    }

    public static AppInfo getInstance() {
        return AppInfoHolder.sAppInfoInstance;
    }

    public String obtainAppSignature(Context context) {
        String str = this.mSignature;
        if (str == null || "".equals(str)) {
            this.mSignature = SignatureUtils.getSingInfo(context);
        }
        return this.mSignature;
    }

    private AppInfo() {
    }
}
