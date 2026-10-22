package com.kc.dw.platform.ad_adapter;

import com.kc.dw.core.loader.AdPlatformError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends AdPlatformError {
    public f(String str, Integer num) {
        this.platform = "SSD";
        this.message = str;
        this.code = num;
    }
}
