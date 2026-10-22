package com.huawei.hms.api;

import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
