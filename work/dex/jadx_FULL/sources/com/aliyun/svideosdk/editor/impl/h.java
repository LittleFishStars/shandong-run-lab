package com.aliyun.svideosdk.editor.impl;

import android.graphics.PointF;
import com.aliyun.svideosdk.common.AliyunLayoutParams;
import com.aliyun.svideosdk.editor.AliyunILayoutController;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class h implements AliyunILayoutController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AliyunLayoutParams f25748a;
    private AliyunIControllerCallback b;

    public h(AliyunLayoutParams aliyunLayoutParams, AliyunIControllerCallback aliyunIControllerCallback) {
        this.f25748a = aliyunLayoutParams;
        this.b = aliyunIControllerCallback;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public int apply() {
        AliyunIControllerCallback aliyunIControllerCallback = this.b;
        if (aliyunIControllerCallback != null) {
            return aliyunIControllerCallback.onApply();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public float getAlpha() {
        return this.f25748a.getAlpha();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public PointF getPosition() {
        return this.f25748a.getPosition();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public float getRotationRadian() {
        return this.f25748a.getRotationRadian();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public float getScale() {
        return this.f25748a.getScale();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public AliyunILayoutController setAlpha(float f) {
        this.f25748a.setAlpha(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public AliyunILayoutController setPosition(float f, float f2) {
        this.f25748a.setPosition(new PointF(f, f2));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public AliyunILayoutController setRotation(float f) {
        this.f25748a.setRotationRadian(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public AliyunILayoutController setScale(float f) {
        this.f25748a.setScale(f);
        return this;
    }
}
