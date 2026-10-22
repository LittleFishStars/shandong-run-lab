package com.alibaba.ariver.app.api;

import androidx.annotation.Nullable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppLoadResult {
    public String appType;
    public String appVersion;
    public String mainHtmlUrl;
    public String mainJsUrl;

    @Nullable
    public Callable<Boolean> waitLoadFuture;

    public String toString() {
        return "AppLoadResult{mainJsUrl='" + this.mainJsUrl + "', mainHtmlUrl='" + this.mainHtmlUrl + "', appType=" + this.appType + ", appVersion='" + this.appVersion + "'}";
    }
}
