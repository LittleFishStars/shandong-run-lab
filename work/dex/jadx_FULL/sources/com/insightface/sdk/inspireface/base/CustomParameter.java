package com.insightface.sdk.inspireface.base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class CustomParameter {
    public int enableRecognition = 0;
    public int enableLiveness = 0;
    public int enableIrLiveness = 0;
    public int enableMaskDetect = 0;
    public int enableFaceQuality = 0;
    public int enableFaceAttribute = 0;
    public int enableInteractionLiveness = 0;
    public int enableFacePose = 0;
    public int enableFaceEmotion = 0;

    public CustomParameter enableFaceAttribute(boolean z) {
        this.enableFaceAttribute = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableFaceEmotion(boolean z) {
        this.enableFaceEmotion = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableFacePose(boolean z) {
        this.enableFacePose = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableFaceQuality(boolean z) {
        this.enableFaceQuality = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableInteractionLiveness(boolean z) {
        this.enableInteractionLiveness = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableIrLiveness(boolean z) {
        this.enableIrLiveness = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableLiveness(boolean z) {
        this.enableLiveness = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableMaskDetect(boolean z) {
        this.enableMaskDetect = z ? 1 : 0;
        return this;
    }

    public CustomParameter enableRecognition(boolean z) {
        this.enableRecognition = z ? 1 : 0;
        return this;
    }
}
