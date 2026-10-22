package com.fl.saas.adx.api.mixNative;

import com.fl.saas.adx.base.interfaces.CustomizeVideo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeCustomizeVideo extends CustomizeVideo {
    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    String getVideoUrl();

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoAutoStart();

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoBreak(long j);

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoContinue(long j);

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoError(long j, int i, int i2);

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoFinish();

    void reportVideoFirst();

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoPause(long j);

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoStart();

    void reportVideoStart(long j);

    @Override // com.fl.saas.adx.base.interfaces.CustomizeVideo
    void reportVideoStartError(int i, int i2);

    void reportVideoThird();

    void reportVideomMidpoint();
}
