package com.alibaba.ariver.app.api;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppRestartResult {
    public boolean canRestart;
    public boolean closeAllWindow;
    public Bundle startParam;
    public String startUrl;

    public String toString() {
        return "AppRestartResult{canRestart=" + this.canRestart + ", closeAllWindow=" + this.closeAllWindow + ", startUrl=" + this.startUrl + '}';
    }
}
