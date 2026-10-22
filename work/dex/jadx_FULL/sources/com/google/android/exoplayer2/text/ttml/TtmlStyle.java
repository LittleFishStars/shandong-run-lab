package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TtmlStyle {
    public static final float c = Float.MAX_VALUE;
    public static final int k = -1;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Layout.Alignment f4629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TextEmphasis f4630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f4631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4632a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4633b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public Layout.Alignment f4634b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public String f4635b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4636b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4637c = -1;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public float b = Float.MAX_VALUE;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public TtmlStyle A(int i) {
        this.g = i;
        return this;
    }

    public TtmlStyle B(@Nullable String str) {
        this.f4635b = str;
        return this;
    }

    public TtmlStyle C(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }

    public TtmlStyle D(boolean z) {
        this.f4637c = z ? 1 : 0;
        return this;
    }

    public TtmlStyle E(@Nullable Layout.Alignment alignment) {
        this.f4634b = alignment;
        return this;
    }

    public TtmlStyle F(int i) {
        this.i = i;
        return this;
    }

    public TtmlStyle G(int i) {
        this.h = i;
        return this;
    }

    public TtmlStyle H(float f) {
        this.b = f;
        return this;
    }

    public TtmlStyle I(@Nullable Layout.Alignment alignment) {
        this.f4629a = alignment;
        return this;
    }

    public TtmlStyle J(boolean z) {
        this.j = z ? 1 : 0;
        return this;
    }

    public TtmlStyle K(@Nullable TextEmphasis textEmphasis) {
        this.f4630a = textEmphasis;
        return this;
    }

    public TtmlStyle L(boolean z) {
        this.d = z ? 1 : 0;
        return this;
    }

    public TtmlStyle a(@Nullable TtmlStyle ttmlStyle) {
        return s(ttmlStyle, true);
    }

    public int b() {
        if (this.f4636b) {
            return this.f4633b;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f4632a) {
            return this.f4628a;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f4631a;
    }

    public float e() {
        return this.f31024a;
    }

    public int f() {
        return this.g;
    }

    @Nullable
    public String g() {
        return this.f4635b;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.f4634b;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.h;
    }

    public float k() {
        return this.b;
    }

    public int l() {
        int i = this.e;
        if (i == -1 && this.f == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.f == 1 ? 2 : 0);
    }

    @Nullable
    public Layout.Alignment m() {
        return this.f4629a;
    }

    public boolean n() {
        return this.j == 1;
    }

    @Nullable
    public TextEmphasis o() {
        return this.f4630a;
    }

    public boolean p() {
        return this.f4636b;
    }

    public boolean q() {
        return this.f4632a;
    }

    public TtmlStyle r(@Nullable TtmlStyle ttmlStyle) {
        return s(ttmlStyle, false);
    }

    public final TtmlStyle s(@Nullable TtmlStyle ttmlStyle, boolean z) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f4632a && ttmlStyle.f4632a) {
                x(ttmlStyle.f4628a);
            }
            if (this.e == -1) {
                this.e = ttmlStyle.e;
            }
            if (this.f == -1) {
                this.f = ttmlStyle.f;
            }
            if (this.f4631a == null && (str = ttmlStyle.f4631a) != null) {
                this.f4631a = str;
            }
            if (this.f4637c == -1) {
                this.f4637c = ttmlStyle.f4637c;
            }
            if (this.d == -1) {
                this.d = ttmlStyle.d;
            }
            if (this.i == -1) {
                this.i = ttmlStyle.i;
            }
            if (this.f4629a == null && (alignment2 = ttmlStyle.f4629a) != null) {
                this.f4629a = alignment2;
            }
            if (this.f4634b == null && (alignment = ttmlStyle.f4634b) != null) {
                this.f4634b = alignment;
            }
            if (this.j == -1) {
                this.j = ttmlStyle.j;
            }
            if (this.g == -1) {
                this.g = ttmlStyle.g;
                this.f31024a = ttmlStyle.f31024a;
            }
            if (this.f4630a == null) {
                this.f4630a = ttmlStyle.f4630a;
            }
            if (this.b == Float.MAX_VALUE) {
                this.b = ttmlStyle.b;
            }
            if (z && !this.f4636b && ttmlStyle.f4636b) {
                v(ttmlStyle.f4633b);
            }
            if (z && this.h == -1 && (i = ttmlStyle.h) != -1) {
                this.h = i;
            }
        }
        return this;
    }

    public boolean t() {
        return this.f4637c == 1;
    }

    public boolean u() {
        return this.d == 1;
    }

    public TtmlStyle v(int i) {
        this.f4633b = i;
        this.f4636b = true;
        return this;
    }

    public TtmlStyle w(boolean z) {
        this.e = z ? 1 : 0;
        return this;
    }

    public TtmlStyle x(int i) {
        this.f4628a = i;
        this.f4632a = true;
        return this;
    }

    public TtmlStyle y(@Nullable String str) {
        this.f4631a = str;
        return this;
    }

    public TtmlStyle z(float f) {
        this.f31024a = f;
        return this;
    }
}
