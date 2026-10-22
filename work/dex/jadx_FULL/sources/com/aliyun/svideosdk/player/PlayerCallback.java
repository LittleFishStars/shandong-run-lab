package com.aliyun.svideosdk.player;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface PlayerCallback {
    void onDataSize(int i, int i2);

    void onError(int i);

    void onPlayComplete();
}
