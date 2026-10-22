package com.aliyun.sls.android.producer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface LogProducerCallback {
    void onCall(int resultCode, String reqId, String errorMessage, int logBytes, int compressedBytes);
}
