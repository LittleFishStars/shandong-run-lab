package com.huachenjie.base.util.spannable.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class CustomClickableSpan extends ClickableSpan {
    public void a(@NonNull View widget) {
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View widget) {
        a(widget);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        ds.setUnderlineText(false);
        ds.clearShadowLayer();
    }
}
