package com.autonavi.amap.mapcore.animation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f, float f2, float f3, float f4) {
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromX;
        float f3 = (f2 == 1.0f && this.mToX == 1.0f) ? 1.0f : f2 + ((this.mToX - f2) * f);
        float f4 = this.mFromY;
        float f5 = (f4 == 1.0f && this.mToY == 1.0f) ? 1.0f : ((this.mToY - f4) * f) + f4;
        gLTransformation.scaleX = f3;
        gLTransformation.scaleY = f5;
    }
}
