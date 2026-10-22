package com.autonavi.amap.mapcore.animation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float f, float f2) {
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromAlpha;
        float f3 = f2 + ((this.mToAlpha - f2) * f);
        this.mCurAlpha = f3;
        gLTransformation.alpha = f3;
    }
}
