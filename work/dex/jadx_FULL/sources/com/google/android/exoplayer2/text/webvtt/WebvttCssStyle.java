package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.common.base.a;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class WebvttCssStyle {
    public static final int i = -1;
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static final int q = 0;
    public static final int r = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @ColorInt
    public int f4638a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f4639a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f4642b = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Set<String> f4640a = Collections.emptySet();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f4644c = "";

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public String f4646d = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4641a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4643b = false;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4645c = false;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public static int C(int i2, String str, @Nullable String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public void A(String str) {
        this.f4644c = str;
    }

    public WebvttCssStyle B(boolean z) {
        this.d = z ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f4643b) {
            return this.b;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f4645c;
    }

    public int c() {
        if (this.f4641a) {
            return this.f4638a;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f4646d;
    }

    public float e() {
        return this.f31025a;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f4639a.isEmpty() && this.f4642b.isEmpty() && this.f4640a.isEmpty() && this.f4644c.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iC = C(C(C(0, this.f4639a, str, 1073741824), this.f4642b, str2, 2), this.f4644c, str3, 4);
        if (iC == -1 || !set.containsAll(this.f4640a)) {
            return 0;
        }
        return iC + (this.f4640a.size() * 4);
    }

    public int i() {
        int i2 = this.e;
        if (i2 == -1 && this.f == -1) {
            return -1;
        }
        return (i2 == 1 ? 1 : 0) | (this.f == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f4643b;
    }

    public boolean k() {
        return this.f4641a;
    }

    public boolean l() {
        return this.c == 1;
    }

    public boolean m() {
        return this.d == 1;
    }

    public WebvttCssStyle n(int i2) {
        this.b = i2;
        this.f4643b = true;
        return this;
    }

    public WebvttCssStyle o(boolean z) {
        this.e = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle p(boolean z) {
        this.f4645c = z;
        return this;
    }

    public WebvttCssStyle q(int i2) {
        this.f4638a = i2;
        this.f4641a = true;
        return this;
    }

    public WebvttCssStyle r(@Nullable String str) {
        this.f4646d = str == null ? null : a.g(str);
        return this;
    }

    public WebvttCssStyle s(float f) {
        this.f31025a = f;
        return this;
    }

    public WebvttCssStyle t(int i2) {
        this.g = i2;
        return this;
    }

    public WebvttCssStyle u(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle v(boolean z) {
        this.c = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle w(int i2) {
        this.h = i2;
        return this;
    }

    public void x(String[] strArr) {
        this.f4640a = new HashSet(Arrays.asList(strArr));
    }

    public void y(String str) {
        this.f4639a = str;
    }

    public void z(String str) {
        this.f4642b = str;
    }
}
