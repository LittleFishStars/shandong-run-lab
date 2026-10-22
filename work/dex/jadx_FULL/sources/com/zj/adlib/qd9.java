package com.zj.adlib;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.text.ttml.TextEmphasis;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qd9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44183a = "TtmlRenderUtil";

    public static void a(Spannable spannable, int i, int i2, TtmlStyle ttmlStyle, @Nullable od9 od9Var, Map<String, TtmlStyle> map, int i3) {
        od9 od9VarE;
        TtmlStyle ttmlStyleF;
        int i4;
        if (ttmlStyle.l() != -1) {
            spannable.setSpan(new StyleSpan(ttmlStyle.l()), i, i2, 33);
        }
        if (ttmlStyle.t()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (ttmlStyle.u()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (ttmlStyle.q()) {
            wl8.a(spannable, new ForegroundColorSpan(ttmlStyle.c()), i, i2, 33);
        }
        if (ttmlStyle.p()) {
            wl8.a(spannable, new BackgroundColorSpan(ttmlStyle.b()), i, i2, 33);
        }
        if (ttmlStyle.d() != null) {
            wl8.a(spannable, new TypefaceSpan(ttmlStyle.d()), i, i2, 33);
        }
        if (ttmlStyle.o() != null) {
            TextEmphasis textEmphasis = (TextEmphasis) sb0.g(ttmlStyle.o());
            int i5 = textEmphasis.f4625a;
            if (i5 == -1) {
                i5 = (i3 == 2 || i3 == 1) ? 3 : 1;
                i4 = 1;
            } else {
                i4 = textEmphasis.f4626b;
            }
            int i6 = textEmphasis.f4627c;
            if (i6 == -2) {
                i6 = 1;
            }
            wl8.a(spannable, new TextEmphasisSpan(i5, i4, i6), i, i2, 33);
        }
        int iJ = ttmlStyle.j();
        if (iJ == 2) {
            od9 od9VarD = d(od9Var, map);
            if (od9VarD != null && (od9VarE = e(od9VarD, map)) != null) {
                if (od9VarE.g() != 1 || od9VarE.f(0).f18620b == null) {
                    Log.h(f44183a, "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) gj9.k(od9VarE.f(0).f18620b);
                    TtmlStyle ttmlStyleF2 = f(od9VarE.f18613a, od9VarE.l(), map);
                    int i7 = ttmlStyleF2 != null ? ttmlStyleF2.i() : -1;
                    if (i7 == -1 && (ttmlStyleF = f(od9VarD.f18613a, od9VarD.l(), map)) != null) {
                        i7 = ttmlStyleF.i();
                    }
                    spannable.setSpan(new cl7(str, i7), i, i2, 33);
                }
            }
        } else if (iJ == 3 || iJ == 4) {
            spannable.setSpan(new mk2(), i, i2, 33);
        }
        if (ttmlStyle.n()) {
            wl8.a(spannable, new y14(), i, i2, 33);
        }
        int iF = ttmlStyle.f();
        if (iF == 1) {
            wl8.a(spannable, new AbsoluteSizeSpan((int) ttmlStyle.e(), true), i, i2, 33);
        } else if (iF == 2) {
            wl8.a(spannable, new RelativeSizeSpan(ttmlStyle.e()), i, i2, 33);
        } else {
            if (iF != 3) {
                return;
            }
            wl8.a(spannable, new RelativeSizeSpan(ttmlStyle.e() / 100.0f), i, i2, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    @Nullable
    public static od9 d(@Nullable od9 od9Var, Map<String, TtmlStyle> map) {
        while (od9Var != null) {
            TtmlStyle ttmlStyleF = f(od9Var.f18613a, od9Var.l(), map);
            if (ttmlStyleF != null && ttmlStyleF.j() == 1) {
                return od9Var;
            }
            od9Var = od9Var.f18614a;
        }
        return null;
    }

    @Nullable
    public static od9 e(od9 od9Var, Map<String, TtmlStyle> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(od9Var);
        while (!arrayDeque.isEmpty()) {
            od9 od9Var2 = (od9) arrayDeque.pop();
            TtmlStyle ttmlStyleF = f(od9Var2.f18613a, od9Var2.l(), map);
            if (ttmlStyleF != null && ttmlStyleF.j() == 3) {
                return od9Var2;
            }
            for (int iG = od9Var2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(od9Var2.f(iG));
            }
        }
        return null;
    }

    @Nullable
    public static TtmlStyle f(@Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, Map<String, TtmlStyle> map) {
        int i = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i < length) {
                    ttmlStyle2.a(map.get(strArr[i]));
                    i++;
                }
                return ttmlStyle2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return ttmlStyle.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    ttmlStyle.a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return ttmlStyle;
    }
}
