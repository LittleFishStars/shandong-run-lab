package com.fl.saas.adx.base.inner;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.fl.saas.b1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ClickSpannable {
    private b1 nextCondition;
    private final SpannableStringBuilder spannable = new SpannableStringBuilder();
    private String separator = " ";
    private int genericColor = -1;

    private void addSeparator() {
        if (this.spannable.length() <= 0 || this.spannable.toString().endsWith(this.separator)) {
            return;
        }
        this.spannable.append((CharSequence) this.separator);
    }

    public SpannableStringBuilder build() {
        return this.spannable;
    }

    public ClickSpannable nextCondition(b1 b1Var) {
        this.nextCondition = b1Var;
        return this;
    }

    public ClickSpannable setGenericColor(@ColorInt int i) {
        this.genericColor = i;
        return this;
    }

    public ClickSpannable setSeparator(String str) {
        this.separator = str;
        return this;
    }

    public ClickSpannable setText(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
        }
        addSeparator();
        for (String str2 : strArr) {
            this.spannable.append((CharSequence) str2);
        }
        return this;
    }

    public ClickSpannable setTextClick(String str, Runnable runnable) {
        return setTextClick(str, false, runnable);
    }

    public ClickSpannable setTextClick(String str, final boolean z, final Runnable runnable) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        b1 b1Var = this.nextCondition;
        this.nextCondition = null;
        if (b1Var != null && b1Var.a() != Boolean.TRUE) {
            return this;
        }
        addSeparator();
        int length = this.spannable.length();
        this.spannable.append((CharSequence) str);
        int length2 = this.spannable.length();
        if (runnable != null) {
            this.spannable.setSpan(new ClickableSpan() { // from class: com.fl.saas.adx.base.inner.ClickSpannable.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    runnable.run();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (z) {
                        return;
                    }
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(ClickSpannable.this.genericColor);
                }
            }, length, length2, 33);
        }
        return this;
    }
}
