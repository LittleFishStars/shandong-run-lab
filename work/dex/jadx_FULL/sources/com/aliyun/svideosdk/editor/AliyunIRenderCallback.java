package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIRenderCallback {
    int needRenderCallback();

    int onCustomRender(int i, int i2, int i3, long j);

    void onRenderDestroy();

    void onRenderSetup();

    int onTextureRender(int i, int i2, int i3, long j);
}
