package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    public static final class a extends CommonMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matcher f31576a;

        public a(Matcher matcher) {
            this.f31576a = (Matcher) i.E(matcher);
        }

        @Override // com.google.common.base.CommonMatcher
        public int a() {
            return this.f31576a.end();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean b() {
            return this.f31576a.find();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean c(int i) {
            return this.f31576a.find(i);
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean d() {
            return this.f31576a.matches();
        }

        @Override // com.google.common.base.CommonMatcher
        public String e(String str) {
            return this.f31576a.replaceAll(str);
        }

        @Override // com.google.common.base.CommonMatcher
        public int f() {
            return this.f31576a.start();
        }
    }

    public JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) i.E(pattern);
    }

    @Override // com.google.common.base.CommonPattern
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.CommonPattern
    public CommonMatcher matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.CommonPattern
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.CommonPattern
    public String toString() {
        return this.pattern.toString();
    }
}
