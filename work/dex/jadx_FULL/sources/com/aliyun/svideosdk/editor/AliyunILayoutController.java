package com.aliyun.svideosdk.editor;

import android.graphics.PointF;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunILayoutController {
    int apply();

    float getAlpha();

    PointF getPosition();

    float getRotationRadian();

    float getScale();

    AliyunILayoutController setAlpha(float f);

    AliyunILayoutController setPosition(float f, float f2);

    AliyunILayoutController setRotation(float f);

    AliyunILayoutController setScale(float f);
}
