package com.kwad.components.core.innerEc.live.widget;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends CharacterStyle {
    private int Fx;
    private boolean aaD;
    private float mRadius = 3.0f;
    private float aaB = 0.0f;
    private float aaC = 3.0f;

    public o(float f, float f2, float f3, int i) {
        this.Fx = i;
    }

    public final void aO(boolean z) {
        this.aaD = true;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        if (this.aaD) {
            textPaint.setShadowLayer(this.mRadius, this.aaB, this.aaC, this.Fx);
        }
    }
}
