package com.google.common.net;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.base.i;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import com.zj.adlib.g37;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@Beta
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharMatcher f32227a = CharMatcher.d(".。．｡");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Splitter f6395a = Splitter.h('.');

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final com.google.common.base.d f6396a = com.google.common.base.d.o('.');
    public static final CharMatcher b;
    public static final int c = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final CharMatcher f6397c;
    public static final int d = 127;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final CharMatcher f6398d;
    public static final int e = 253;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final CharMatcher f6399e;
    public static final int f = 63;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f6400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<String> f6401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6402a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f6403b;

    static {
        CharMatcher charMatcherD = CharMatcher.d("-_");
        b = charMatcherD;
        CharMatcher charMatcherM = CharMatcher.m('0', '9');
        f6397c = charMatcherM;
        CharMatcher charMatcherI = CharMatcher.m('a', 'z').I(CharMatcher.m('A', 'Z'));
        f6398d = charMatcherI;
        f6399e = charMatcherM.I(charMatcherI).I(charMatcherD);
    }

    public d(String str) {
        String strG = com.google.common.base.a.g(f32227a.N(str, '.'));
        strG = strG.endsWith(Consts.DOT) ? strG.substring(0, strG.length() - 1) : strG;
        i.u(strG.length() <= 253, "Domain name too long: '%s':", strG);
        this.f6402a = strG;
        ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf(f6395a.n(strG));
        this.f6401a = immutableListCopyOf;
        i.u(immutableListCopyOf.size() <= 127, "Domain has too many parts: '%s'", strG);
        i.u(x(immutableListCopyOf), "Not a valid domain name: '%s'", strG);
        this.f6400a = c(Optional.absent());
        this.f6403b = c(Optional.of(PublicSuffixType.REGISTRY));
    }

    public static d d(String str) {
        return new d((String) i.E(str));
    }

    public static boolean n(String str) {
        try {
            d(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean o(Optional<PublicSuffixType> optional, Optional<PublicSuffixType> optional2) {
        return optional.isPresent() ? optional.equals(optional2) : optional2.isPresent();
    }

    public static boolean p(Optional<PublicSuffixType> optional, String str) {
        List<String> listO = f6395a.f(2).o(str);
        return listO.size() == 2 && o(optional, Optional.fromNullable(g37.b.get(listO.get(1))));
    }

    public static boolean w(String str, boolean z) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!f6399e.C(CharMatcher.f().P(str))) {
                return false;
            }
            CharMatcher charMatcher = b;
            if (!charMatcher.B(str.charAt(0)) && !charMatcher.B(str.charAt(str.length() - 1))) {
                return (z && f6397c.B(str.charAt(0))) ? false : true;
            }
        }
        return false;
    }

    public static boolean x(List<String> list) {
        int size = list.size() - 1;
        if (!w(list.get(size), true)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!w(list.get(i), false)) {
                return false;
            }
        }
        return true;
    }

    public final d a(int i) {
        com.google.common.base.d dVar = f6396a;
        ImmutableList<String> immutableList = this.f6401a;
        return d(dVar.k(immutableList.subList(i, immutableList.size())));
    }

    public d b(String str) {
        String str2 = (String) i.E(str);
        String str3 = this.f6402a;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str3).length());
        sb.append(str2);
        sb.append(Consts.DOT);
        sb.append(str3);
        return d(sb.toString());
    }

    public final int c(Optional<PublicSuffixType> optional) {
        int size = this.f6401a.size();
        for (int i = 0; i < size; i++) {
            String strK = f6396a.k(this.f6401a.subList(i, size));
            if (o(optional, Optional.fromNullable(g37.f41812a.get(strK)))) {
                return i;
            }
            if (g37.c.containsKey(strK)) {
                return i + 1;
            }
            if (p(optional, strK)) {
                return i;
            }
        }
        return -1;
    }

    public boolean e() {
        return this.f6401a.size() > 1;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f6402a.equals(((d) obj).f6402a);
        }
        return false;
    }

    public boolean f() {
        return this.f6400a != -1;
    }

    public boolean g() {
        return this.f6403b != -1;
    }

    public boolean h() {
        return this.f6400a == 0;
    }

    public int hashCode() {
        return this.f6402a.hashCode();
    }

    public boolean i() {
        return this.f6403b == 0;
    }

    public boolean j() {
        return this.f6403b == 1;
    }

    public boolean k() {
        return this.f6400a == 1;
    }

    public boolean l() {
        return this.f6400a > 0;
    }

    public boolean m() {
        return this.f6403b > 0;
    }

    public d q() {
        i.x0(e(), "Domain '%s' has no parent", this.f6402a);
        return a(1);
    }

    public ImmutableList<String> r() {
        return this.f6401a;
    }

    @CheckForNull
    public d s() {
        if (f()) {
            return a(this.f6400a);
        }
        return null;
    }

    @CheckForNull
    public d t() {
        if (g()) {
            return a(this.f6403b);
        }
        return null;
    }

    public String toString() {
        return this.f6402a;
    }

    public d u() {
        if (j()) {
            return this;
        }
        i.x0(m(), "Not under a registry suffix: %s", this.f6402a);
        return a(this.f6403b - 1);
    }

    public d v() {
        if (k()) {
            return this;
        }
        i.x0(l(), "Not under a public suffix: %s", this.f6402a);
        return a(this.f6400a - 1);
    }
}
