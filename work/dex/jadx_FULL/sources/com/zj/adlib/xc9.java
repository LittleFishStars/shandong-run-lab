package com.zj.adlib;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.d;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.v;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
public final class xc9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f45794a = d.p("");

    public static int a(Deque<CharSequence> deque, CharSequence charSequence, int i, ImmutableMap.b<String, PublicSuffixType> bVar) {
        int length = charSequence.length();
        char cCharAt = 0;
        int i2 = i;
        while (i2 < length && (cCharAt = charSequence.charAt(i2)) != '&' && cCharAt != '?' && cCharAt != '!' && cCharAt != ':' && cCharAt != ',') {
            i2++;
        }
        deque.push(c(charSequence.subSequence(i, i2)));
        if (cCharAt == '!' || cCharAt == '?' || cCharAt == ':' || cCharAt == ',') {
            String strK = f45794a.k(deque);
            if (strK.length() > 0) {
                bVar.f(strK, PublicSuffixType.fromCode(cCharAt));
            }
        }
        int iA = i2 + 1;
        if (cCharAt != '?' && cCharAt != ',') {
            while (iA < length) {
                iA += a(deque, charSequence, iA, bVar);
                if (charSequence.charAt(iA) == '?' || charSequence.charAt(iA) == ',') {
                    iA++;
                    break;
                }
            }
        }
        deque.pop();
        return iA - i;
    }

    public static ImmutableMap<String, PublicSuffixType> b(CharSequence charSequence) {
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        int length = charSequence.length();
        int iA = 0;
        while (iA < length) {
            iA += a(v.d(), charSequence, iA, bVarBuilder);
        }
        return bVarBuilder.a();
    }

    public static CharSequence c(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
