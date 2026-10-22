package com.fl.saas.api.mixNative;

import com.fl.saas.common.pojo.YdNativePojo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeCustomizeVideo extends YdNativePojo.CustomizeVideo {
    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    String getVideoUrl();

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoAutoStart();

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoBreak(long j);

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoContinue(long j);

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoError(long j, int i, int i2);

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoFinish();

    void reportVideoFirst();

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoPause(long j);

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoStart();

    void reportVideoStart(long j);

    @Override // com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
    void reportVideoStartError(int i, int i2);

    void reportVideoThird();

    void reportVideomMidpoint();
}
