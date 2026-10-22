package com.aliyun.svideosdk.common.callback.recorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface OnTextureIdCallback {
    int onScaledIdBack(int i, int i2, int i3, float[] fArr);

    void onTextureDestroyed();

    int onTextureIdBack(int i, int i2, int i3, float[] fArr);
}
