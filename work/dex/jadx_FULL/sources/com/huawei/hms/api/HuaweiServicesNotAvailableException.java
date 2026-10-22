package com.huawei.hms.api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class HuaweiServicesNotAvailableException extends Exception {
    public final int errorCode;

    public HuaweiServicesNotAvailableException(int i) {
        this.errorCode = i;
    }
}
