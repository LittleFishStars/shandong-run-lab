package com.aliyun.svideosdk.common.callback.recorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface OnAudioCallBack {
    void onAudioDataBack(byte[] bArr, int i);

    void onAudioDataBackInPreview(byte[] bArr, int i);
}
