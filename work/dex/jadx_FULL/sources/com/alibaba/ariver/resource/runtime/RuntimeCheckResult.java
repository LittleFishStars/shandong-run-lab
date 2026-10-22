package com.alibaba.ariver.resource.runtime;

import android.text.TextUtils;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RuntimeCheckResult {
    public static final String DEGRADE_BY_APPINFO_MISS = "7";
    public static final String DEGRADE_BY_CONFIG = "0";
    public static final String DEGRADE_BY_ENGINE_FAIL = "4";
    public static final String DEGRADE_BY_EXTENSION = "3";
    public static final String DEGRADE_BY_FATAL = "2";
    public static final String DEGRADE_BY_INVALID_PARAMS = "6";
    public static final String DEGRADE_BY_MINSDK_FAIL = "5";
    public static final String DEGRADE_BY_RESOURCE = "1";
    private String degradeReason;
    private boolean degraded;
    private boolean enabled;
    public String extendInfo;

    public RuntimeCheckResult(boolean z) {
        this.enabled = z;
        this.degraded = false;
        this.degradeReason = null;
    }

    public String getDegradeReason() {
        return TextUtils.isEmpty(this.degradeReason) ? "" : this.degradeReason;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public boolean isDegrade() {
        return this.degraded;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String toString() {
        return "RuntimeCheckResult{enabled=" + this.enabled + ", hasDegrade=" + this.degraded + ", degradeReason=" + this.degradeReason + ", extendInfo=" + this.extendInfo + '}';
    }

    public RuntimeCheckResult(boolean z, boolean z2, String str) {
        this.enabled = z;
        this.degraded = z2;
        this.degradeReason = str;
    }

    public RuntimeCheckResult(boolean z, boolean z2, String str, String str2) {
        this(z, z2, str);
        this.extendInfo = str2;
    }
}
