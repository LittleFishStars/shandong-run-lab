package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.svideosdk.conan.DoNotProguard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@DoNotProguard
public interface AliyunMixCallback {
    @DoNotProguard
    void onComplete();

    @DoNotProguard
    void onError(int i);

    @DoNotProguard
    void onProgress(long j);
}
