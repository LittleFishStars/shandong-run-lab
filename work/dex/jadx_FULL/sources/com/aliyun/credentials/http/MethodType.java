package com.aliyun.credentials.http;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum MethodType {
    GET(false),
    PUT(true),
    POST(true);

    private boolean hasContent;

    MethodType(boolean z) {
        this.hasContent = z;
    }

    public boolean hasContent() {
        return this.hasContent;
    }
}
