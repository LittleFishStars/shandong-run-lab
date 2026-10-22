package com.kwad.components.core.innerEc.live.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n extends ClickableSpan {

    @Nullable
    private final View.OnClickListener gh;

    public n(@Nullable View.OnClickListener onClickListener) {
        this.gh = onClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(@NonNull View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(0);
        }
        View.OnClickListener onClickListener = this.gh;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(@NonNull TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
