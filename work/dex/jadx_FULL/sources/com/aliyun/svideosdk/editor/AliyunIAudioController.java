package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIAudioController {
    int apply();

    AliyunIAudioController denoise(int i);

    int getVolume();

    AliyunIAudioController removeAudioFadeIn();

    AliyunIAudioController removeAudioFadeOut();

    AliyunIAudioController setAudioEffect(AudioEffectType audioEffectType, float f);

    AliyunIAudioController setAudioFadeIn(ShapeType shapeType, long j);

    AliyunIAudioController setAudioFadeOut(ShapeType shapeType, long j);

    AliyunIAudioController setVolume(int i);
}
