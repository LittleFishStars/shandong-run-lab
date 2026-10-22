package com.aliyun.svideosdk.common.callback.recorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface OnRecordCallback {
    void onClipComplete(boolean z, long j);

    void onError(int i);

    void onFinish(String str);

    void onInitReady();

    void onMaxDuration();

    void onProgress(long j);
}
