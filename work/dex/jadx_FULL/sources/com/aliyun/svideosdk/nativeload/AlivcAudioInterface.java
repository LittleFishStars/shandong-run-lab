package com.aliyun.svideosdk.nativeload;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AlivcAudioInterface {
    void flush();

    int getPlayState();

    int getPlaybackHeadPosition();

    void pause();

    void play();

    void release();

    int setStereoVolume(float f, float f2);

    void stop();

    int write(byte[] bArr, int i, int i2);
}
