package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.text.Cue;
import com.google.common.base.g;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Cue implements Bundleable {
    public static final int Q = Integer.MIN_VALUE;
    public static final int R = 0;
    public static final int S = 1;
    public static final int T = 2;
    public static final int U = 0;
    public static final int V = 1;
    public static final int W = 0;
    public static final int X = 1;
    public static final int Y = 2;
    public static final int Z = 1;
    public static final int a0 = 2;
    public static final int b0 = 0;
    public static final int c0 = 1;
    public static final int d0 = 2;
    public static final int e0 = 3;
    public static final int f0 = 4;
    public static final float g = -3.4028235E38f;
    public static final int g0 = 5;
    public static final int h0 = 6;
    public static final int i0 = 7;
    public static final int j0 = 8;
    public static final int k0 = 9;
    public static final int l0 = 10;
    public static final int m0 = 11;
    public static final int n0 = 12;
    public static final int o0 = 13;
    public static final int p0 = 14;
    public static final int q0 = 15;
    public static final int r0 = 16;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f4519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Bitmap f4520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Layout.Alignment f4521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final CharSequence f4522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4523a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final Layout.Alignment f4524b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Cue f4518a = new b().A("").a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<Cue> f31001a = new Bundleable.Creator() { // from class: com.zj.adlib.sy1
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return Cue.c(bundle);
        }
    };

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f31002a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4525a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Bitmap f4526a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Layout.Alignment f4527a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public CharSequence f4528a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4529a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f4530b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public Layout.Alignment f4531b;
        public float c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f4532c;
        public float d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public int f4533d;
        public float e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        @ColorInt
        public int f4534e;
        public float f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public int f4535f;

        public b A(CharSequence charSequence) {
            this.f4528a = charSequence;
            return this;
        }

        public b B(@Nullable Layout.Alignment alignment) {
            this.f4527a = alignment;
            return this;
        }

        public b C(float f, int i) {
            this.c = f;
            this.f4533d = i;
            return this;
        }

        public b D(int i) {
            this.f4535f = i;
            return this;
        }

        public b E(@ColorInt int i) {
            this.f4534e = i;
            this.f4529a = true;
            return this;
        }

        public Cue a() {
            return new Cue(this.f4528a, this.f4527a, this.f4531b, this.f4526a, this.f31002a, this.f4525a, this.f4530b, this.b, this.f4532c, this.f4533d, this.c, this.d, this.e, this.f4529a, this.f4534e, this.f4535f, this.f);
        }

        public b b() {
            this.f4529a = false;
            return this;
        }

        @Nullable
        @Pure
        public Bitmap c() {
            return this.f4526a;
        }

        @Pure
        public float d() {
            return this.e;
        }

        @Pure
        public float e() {
            return this.f31002a;
        }

        @Pure
        public int f() {
            return this.f4530b;
        }

        @Pure
        public int g() {
            return this.f4525a;
        }

        @Pure
        public float h() {
            return this.b;
        }

        @Pure
        public int i() {
            return this.f4532c;
        }

        @Pure
        public float j() {
            return this.d;
        }

        @Nullable
        @Pure
        public CharSequence k() {
            return this.f4528a;
        }

        @Nullable
        @Pure
        public Layout.Alignment l() {
            return this.f4527a;
        }

        @Pure
        public float m() {
            return this.c;
        }

        @Pure
        public int n() {
            return this.f4533d;
        }

        @Pure
        public int o() {
            return this.f4535f;
        }

        @ColorInt
        @Pure
        public int p() {
            return this.f4534e;
        }

        public boolean q() {
            return this.f4529a;
        }

        public b r(Bitmap bitmap) {
            this.f4526a = bitmap;
            return this;
        }

        public b s(float f) {
            this.e = f;
            return this;
        }

        public b t(float f, int i) {
            this.f31002a = f;
            this.f4525a = i;
            return this;
        }

        public b u(int i) {
            this.f4530b = i;
            return this;
        }

        public b v(@Nullable Layout.Alignment alignment) {
            this.f4531b = alignment;
            return this;
        }

        public b w(float f) {
            this.b = f;
            return this;
        }

        public b x(int i) {
            this.f4532c = i;
            return this;
        }

        public b y(float f) {
            this.f = f;
            return this;
        }

        public b z(float f) {
            this.d = f;
            return this;
        }

        public b() {
            this.f4528a = null;
            this.f4526a = null;
            this.f4527a = null;
            this.f4531b = null;
            this.f31002a = -3.4028235E38f;
            this.f4525a = Integer.MIN_VALUE;
            this.f4530b = Integer.MIN_VALUE;
            this.b = -3.4028235E38f;
            this.f4532c = Integer.MIN_VALUE;
            this.f4533d = Integer.MIN_VALUE;
            this.c = -3.4028235E38f;
            this.d = -3.4028235E38f;
            this.e = -3.4028235E38f;
            this.f4529a = false;
            this.f4534e = -16777216;
            this.f4535f = Integer.MIN_VALUE;
        }

        public b(Cue cue) {
            this.f4528a = cue.f4522a;
            this.f4526a = cue.f4520a;
            this.f4527a = cue.f4521a;
            this.f4531b = cue.f4524b;
            this.f31002a = cue.f4519a;
            this.f4525a = cue.K;
            this.f4530b = cue.L;
            this.b = cue.b;
            this.f4532c = cue.M;
            this.f4533d = cue.O;
            this.c = cue.e;
            this.d = cue.c;
            this.e = cue.d;
            this.f4529a = cue.f4523a;
            this.f4534e = cue.N;
            this.f4535f = cue.P;
            this.f = cue.f;
        }
    }

    public static final Cue c(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(d(0));
        if (charSequence != null) {
            bVar.A(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(d(1));
        if (alignment != null) {
            bVar.B(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(d(2));
        if (alignment2 != null) {
            bVar.v(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(d(3));
        if (bitmap != null) {
            bVar.r(bitmap);
        }
        if (bundle.containsKey(d(4)) && bundle.containsKey(d(5))) {
            bVar.t(bundle.getFloat(d(4)), bundle.getInt(d(5)));
        }
        if (bundle.containsKey(d(6))) {
            bVar.u(bundle.getInt(d(6)));
        }
        if (bundle.containsKey(d(7))) {
            bVar.w(bundle.getFloat(d(7)));
        }
        if (bundle.containsKey(d(8))) {
            bVar.x(bundle.getInt(d(8)));
        }
        if (bundle.containsKey(d(10)) && bundle.containsKey(d(9))) {
            bVar.C(bundle.getFloat(d(10)), bundle.getInt(d(9)));
        }
        if (bundle.containsKey(d(11))) {
            bVar.z(bundle.getFloat(d(11)));
        }
        if (bundle.containsKey(d(12))) {
            bVar.s(bundle.getFloat(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            bVar.E(bundle.getInt(d(13)));
        }
        if (!bundle.getBoolean(d(14), false)) {
            bVar.b();
        }
        if (bundle.containsKey(d(15))) {
            bVar.D(bundle.getInt(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            bVar.y(bundle.getFloat(d(16)));
        }
        return bVar.a();
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public b b() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        return TextUtils.equals(this.f4522a, cue.f4522a) && this.f4521a == cue.f4521a && this.f4524b == cue.f4524b && ((bitmap = this.f4520a) != null ? !((bitmap2 = cue.f4520a) == null || !bitmap.sameAs(bitmap2)) : cue.f4520a == null) && this.f4519a == cue.f4519a && this.K == cue.K && this.L == cue.L && this.b == cue.b && this.M == cue.M && this.c == cue.c && this.d == cue.d && this.f4523a == cue.f4523a && this.N == cue.N && this.O == cue.O && this.e == cue.e && this.P == cue.P && this.f == cue.f;
    }

    public int hashCode() {
        return g.b(this.f4522a, this.f4521a, this.f4524b, this.f4520a, Float.valueOf(this.f4519a), Integer.valueOf(this.K), Integer.valueOf(this.L), Float.valueOf(this.b), Integer.valueOf(this.M), Float.valueOf(this.c), Float.valueOf(this.d), Boolean.valueOf(this.f4523a), Integer.valueOf(this.N), Integer.valueOf(this.O), Float.valueOf(this.e), Integer.valueOf(this.P), Float.valueOf(this.f));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.f4522a);
        bundle.putSerializable(d(1), this.f4521a);
        bundle.putSerializable(d(2), this.f4524b);
        bundle.putParcelable(d(3), this.f4520a);
        bundle.putFloat(d(4), this.f4519a);
        bundle.putInt(d(5), this.K);
        bundle.putInt(d(6), this.L);
        bundle.putFloat(d(7), this.b);
        bundle.putInt(d(8), this.M);
        bundle.putInt(d(9), this.O);
        bundle.putFloat(d(10), this.e);
        bundle.putFloat(d(11), this.c);
        bundle.putFloat(d(12), this.d);
        bundle.putBoolean(d(14), this.f4523a);
        bundle.putInt(d(13), this.N);
        bundle.putInt(d(15), this.P);
        bundle.putFloat(d(16), this.f);
        return bundle;
    }

    @Deprecated
    public Cue(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, -16777216);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, null, null, f, i, i2, f2, i3, i4, f4, f3, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z, i4, Integer.MIN_VALUE, 0.0f);
    }

    public Cue(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6) {
        if (charSequence == null) {
            sb0.g(bitmap);
        } else {
            sb0.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f4522a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f4522a = charSequence.toString();
        } else {
            this.f4522a = null;
        }
        this.f4521a = alignment;
        this.f4524b = alignment2;
        this.f4520a = bitmap;
        this.f4519a = f;
        this.K = i;
        this.L = i2;
        this.b = f2;
        this.M = i3;
        this.c = f4;
        this.d = f5;
        this.f4523a = z;
        this.N = i5;
        this.O = i4;
        this.e = f3;
        this.P = i6;
        this.f = f6;
    }
}
