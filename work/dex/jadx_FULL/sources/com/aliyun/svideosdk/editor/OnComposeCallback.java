package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface OnComposeCallback {
    void onCancel();

    void onComplete();

    void onError(int i);

    void onProgress(int i);
}
