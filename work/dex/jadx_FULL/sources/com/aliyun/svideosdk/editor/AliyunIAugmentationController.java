package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIAugmentationController {
    int apply();

    float getBrightness();

    float getContrast();

    float getSaturation();

    float getSharpness();

    float getVignette();

    void resetDefault();

    AliyunIAugmentationController setBrightness(float f);

    AliyunIAugmentationController setContrast(float f);

    AliyunIAugmentationController setSaturation(float f);

    AliyunIAugmentationController setSharpness(float f);

    AliyunIAugmentationController setVignette(float f);
}
