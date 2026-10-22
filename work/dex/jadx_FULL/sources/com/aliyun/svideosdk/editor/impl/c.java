package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.common.AliyunPip;
import com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip;
import com.aliyun.svideosdk.editor.AliyunIAugmentationController;
import com.aliyun.svideosdk.editor.NativeEditor;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c implements AliyunIAugmentationController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25736a;
    private AliyunPip b;
    private PipVideoTrackClip c;
    private WeakReference<f> d;

    public c(NativeEditor nativeEditor, AliyunPip aliyunPip, PipVideoTrackClip pipVideoTrackClip, f fVar) {
        this.f25736a = nativeEditor;
        this.b = aliyunPip;
        this.c = pipVideoTrackClip;
        this.d = new WeakReference<>(fVar);
    }

    private void b() {
        this.c.setBrightness(this.b.getBrightness());
        this.c.setContrast(this.b.getContrast());
        this.c.setSaturation(this.b.getSaturation());
        this.c.setSharpness(this.b.getSharpness());
        this.c.setVignette(this.b.getVignette());
    }

    public void a() {
        if (this.f25736a != null) {
            this.f25736a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public int apply() {
        this.f25736a.updatePicInPic(this.b.getNativeHandle());
        b();
        if (this.d.get() == null) {
            return 0;
        }
        this.d.get().saveEffectToLocal();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getBrightness() {
        return this.b.getBrightness();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getContrast() {
        return this.b.getContrast();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getSaturation() {
        return this.b.getSaturation();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getSharpness() {
        return this.b.getSharpness();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getVignette() {
        return this.b.getVignette();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public void resetDefault() {
        this.b.setBrightness(0.5f);
        this.b.setContrast(0.25f);
        this.b.setSaturation(0.5f);
        this.b.setSharpness(0.0f);
        this.b.setVignette(0.0f);
        apply();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public AliyunIAugmentationController setBrightness(float f) {
        this.b.setBrightness(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public AliyunIAugmentationController setContrast(float f) {
        this.b.setContrast(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public AliyunIAugmentationController setSaturation(float f) {
        this.b.setSaturation(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public AliyunIAugmentationController setSharpness(float f) {
        this.b.setSharpness(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public AliyunIAugmentationController setVignette(float f) {
        this.b.setVignette(f);
        return this;
    }
}
