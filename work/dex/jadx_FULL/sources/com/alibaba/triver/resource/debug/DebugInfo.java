package com.alibaba.triver.resource.debug;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DebugInfo implements Serializable {
    private String mDownloadUrl;

    public DebugInfo(String str) {
        this.mDownloadUrl = str;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }
}
