package com.zj.adlib;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.span.LanguageFeatureSpan;
import com.google.common.base.Predicate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gv8 {
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof LanguageFeatureSpan);
    }

    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(Cue.b bVar) {
        bVar.b();
        if (bVar.k() instanceof Spanned) {
            if (!(bVar.k() instanceof Spannable)) {
                bVar.A(SpannableString.valueOf(bVar.k()));
            }
            g((Spannable) sb0.g(bVar.k()), new Predicate() { // from class: com.zj.adlib.fv8
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return gv8.c(obj);
                }
            });
        }
        f(bVar);
    }

    public static void f(Cue.b bVar) {
        bVar.C(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.k() instanceof Spanned) {
            if (!(bVar.k() instanceof Spannable)) {
                bVar.A(SpannableString.valueOf(bVar.k()));
            }
            g((Spannable) sb0.g(bVar.k()), new Predicate() { // from class: com.zj.adlib.ev8
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return gv8.d(obj);
                }
            });
        }
    }

    public static void g(Spannable spannable, Predicate<Object> predicate) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }
}
