package com.alibaba.alibcprotocol.route.proxy.impl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcSDKInitResult {
    public static final int SDK_INIT_AD = 2;
    public static final int SDK_INIT_FAIL = 1;
    public static final int SDK_INIT_SUCCESS = 0;
    public int errorCode;
    public String errorMsg;
    public int result;

    public AlibcSDKInitResult(int i) {
        this.result = i;
    }

    public AlibcSDKInitResult(int i, String str) {
        this.result = 1;
        this.errorCode = i;
        this.errorMsg = str;
    }
}
