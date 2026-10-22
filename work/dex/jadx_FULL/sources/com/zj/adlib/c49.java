package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import com.blankj.utilcode.util.SpanUtils;
import com.huachenjie.base.util.spannable.DesSpanBean;
import com.huachenjie.base.util.spannable.span.CustomClickableSpan;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class c49 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40900a = "-";
    public static final String b = "字";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuffer f15733a = new StringBuffer();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<DesSpanBean> f15734a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f15735b;
    public int c;

    public c49() {
        this.f15732a = 0;
        this.f15735b = 0;
        this.c = 0;
        this.f15735b = 0;
        this.f15732a = 0;
        this.c = 0;
    }

    public static c49 f() {
        return new c49();
    }

    public synchronized c49 a(CustomClickableSpan clickableSpan) {
        if (clickableSpan != null) {
            i4a.c(this.f15735b + f40900a + this.f15732a);
            this.f15734a.add(new DesSpanBean(clickableSpan, this.f15735b, this.f15732a, 34));
        }
        return this;
    }

    public synchronized c49 b(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(b);
        }
        this.c = this.f15732a + length;
        this.f15733a.append((CharSequence) sb);
        this.f15734a.add(new DesSpanBean(new i13(), this.f15732a, this.c, 34));
        this.f15735b = this.f15732a;
        this.f15732a = this.c;
        return this;
    }

    public synchronized c49 c(TextPaint textPaint, Drawable drawable, int size) {
        float fMeasureText = textPaint.measureText(f40900a);
        int i = (int) (size / fMeasureText);
        if (i <= 0) {
            i = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(f40900a);
        }
        this.c = this.f15732a + i;
        this.f15733a.append((CharSequence) sb);
        int i3 = (int) (i * fMeasureText);
        drawable.setBounds(0, 0, i3, i3);
        this.f15734a.add(new DesSpanBean(new ef1(drawable), this.f15732a, this.c, 2));
        this.f15735b = this.f15732a;
        this.f15732a = this.c;
        return this;
    }

    public synchronized c49 d(ImageSpan imageSpan, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(f40900a);
        }
        this.c = this.f15732a + length;
        this.f15733a.append((CharSequence) sb);
        this.f15734a.add(new DesSpanBean(imageSpan, this.f15732a, this.c, 34));
        this.f15735b = this.f15732a;
        this.f15732a = this.c;
        return this;
    }

    public SpannableStringBuilder e() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f15733a.toString());
        for (DesSpanBean desSpanBean : this.f15734a) {
            spannableStringBuilder.setSpan(desSpanBean.getSpan(), desSpanBean.getStart(), desSpanBean.getEnd(), desSpanBean.getFlags());
        }
        return spannableStringBuilder;
    }

    public synchronized c49 g(b49 bean) {
        String strE = bean.e();
        this.c = this.f15732a + strE.length();
        this.f15733a.append(strE);
        if (bean.g() > 0) {
            this.f15734a.add(new DesSpanBean(new AbsoluteSizeSpan(bean.g()), this.f15732a, this.c, 34));
        }
        if (bean.f() != 0) {
            this.f15734a.add(new DesSpanBean(new ForegroundColorSpan(bean.f()), this.f15732a, this.c, 34));
        }
        if (bean.b() != 0) {
            this.f15734a.add(new DesSpanBean(new BackgroundColorSpan(bean.b()), this.f15732a, this.c, 34));
        }
        if (bean.h() == 1 || bean.h() == 2 || bean.h() == 3) {
            this.f15734a.add(new DesSpanBean(new StyleSpan(bean.h()), this.f15732a, this.c, 34));
        }
        if (bean.c() != null) {
            this.f15734a.add(new DesSpanBean(new SpanUtils.CustomTypefaceSpan(bean.c()), this.f15732a, this.c, 34));
        }
        if (bean.t()) {
            this.f15734a.add(new DesSpanBean(new UnderlineSpan(), this.f15732a, this.c, 34));
        }
        if (bean.s()) {
            this.f15734a.add(new DesSpanBean(new StrikethroughSpan(), this.f15732a, this.c, 34));
        }
        if (bean.d() != null) {
            this.f15734a.add(new DesSpanBean(bean.d(), this.f15732a, this.c, 34));
        }
        this.f15735b = this.f15732a;
        this.f15732a = this.c;
        return this;
    }

    public synchronized c49 h(String text) {
        return k(text, 0, 0, 0, 0, false, false);
    }

    public synchronized c49 i(String text, int textColor) {
        return k(text, 0, textColor, 0, 0, false, false);
    }

    public synchronized c49 j(String text, int textColor, int textSize) {
        return k(text, textSize, textColor, 0, 0, false, false);
    }

    public synchronized c49 k(String text, int textSize, @ColorInt int textColor, int typeface, @ColorInt int backgroundColor, boolean showStrikethrough, boolean showUnderline) {
        return l(text, textSize, textColor, typeface, backgroundColor, showStrikethrough, showUnderline, null);
    }

    public synchronized c49 l(String text, int textSize, int textColor, int typeface, int backgroundColor, boolean showStrikethrough, boolean showUnderline, CharacterStyle span) {
        g(new b49().o(text).q(textSize).p(textColor).r(typeface).j(backgroundColor).l(showStrikethrough).m(showUnderline).n(span));
        return this;
    }

    public synchronized c49 m(String text, int textColor) {
        return o(text, textColor, 1);
    }

    public synchronized c49 n(String text, int textColor) {
        return o(text, textColor, 2);
    }

    public synchronized c49 o(String text, int textColor, int typeface) {
        return k(text, 0, textColor, typeface, 0, false, false);
    }
}
