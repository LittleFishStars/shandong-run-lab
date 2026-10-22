package com.zj.adlib;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class fm8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f41709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<b49> f16578a = new ArrayList();

    public fm8(String text) {
        this.f41709a = text;
    }

    public static fm8 f(String text) {
        return new fm8(text);
    }

    public synchronized fm8 a(String text, int textSize, int textColor, int typeface, int backgroundColor, boolean showStrikethrough, boolean showUnderline, CharacterStyle span) {
        return e(new b49().o(text).q(textSize).p(textColor).r(typeface).j(backgroundColor).l(showStrikethrough).m(showUnderline).n(span));
    }

    public SpannableStringBuilder b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f41709a);
        Iterator<b49> it = this.f16578a.iterator();
        while (it.hasNext()) {
            d(spannableStringBuilder, it.next());
        }
        return spannableStringBuilder;
    }

    public synchronized b49 c(String text) {
        b49 b49VarO;
        if (!this.f16578a.isEmpty()) {
            List<b49> list = this.f16578a;
            list.get(list.size() - 1).a(null);
        }
        b49VarO = new b49().o(text);
        b49VarO.a(this);
        return b49VarO;
    }

    public final void d(SpannableStringBuilder spannableString, b49 bean) {
        int iIndexOf;
        if (TextUtils.isEmpty(this.f41709a) || TextUtils.isEmpty(bean.e()) || (iIndexOf = this.f41709a.indexOf(bean.e())) < 0) {
            return;
        }
        int length = bean.e().length() + iIndexOf;
        if (bean.g() > 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(bean.g()), iIndexOf, length, 34);
        }
        if (bean.f() != 0) {
            spannableString.setSpan(new ForegroundColorSpan(bean.f()), iIndexOf, length, 34);
        }
        if (bean.b() != 0) {
            spannableString.setSpan(new BackgroundColorSpan(bean.b()), iIndexOf, length, 34);
        }
        if (bean.h() == 1 || bean.h() == 2 || bean.h() == 3) {
            spannableString.setSpan(new StyleSpan(bean.h()), iIndexOf, length, 34);
        }
        if (bean.t()) {
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, length, 34);
        }
        if (bean.s()) {
            spannableString.setSpan(new StrikethroughSpan(), iIndexOf, length, 34);
        }
        if (bean.d() != null) {
            spannableString.setSpan(bean.d(), iIndexOf, length, 34);
        }
    }

    public synchronized fm8 e(b49 bean) {
        this.f16578a.add(bean);
        return this;
    }
}
