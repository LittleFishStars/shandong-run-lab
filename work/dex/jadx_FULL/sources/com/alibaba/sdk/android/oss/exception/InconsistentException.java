package com.alibaba.sdk.android.oss.exception;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InconsistentException extends IOException {
    private Long clientChecksum;
    private String requestId;
    private Long serverChecksum;

    public InconsistentException(Long l, Long l2, String str) {
        this.clientChecksum = l;
        this.serverChecksum = l2;
        this.requestId = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "InconsistentException: inconsistent object\n[RequestId]: " + this.requestId + "\n[ClientChecksum]: " + this.clientChecksum + "\n[ServerChecksum]: " + this.serverChecksum;
    }
}
