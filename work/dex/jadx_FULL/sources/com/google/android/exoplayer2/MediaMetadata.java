package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.zj.adlib.gj9;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MediaMetadata implements Bundleable {
    public static final int A0 = 13;
    public static final int B0 = 14;
    public static final int C0 = 15;
    public static final int D0 = 16;
    public static final int E0 = 17;
    public static final int F0 = 18;
    public static final int G0 = 19;
    public static final int H0 = 20;
    public static final int I0 = 21;
    public static final int J0 = 22;
    public static final int K = -1;
    public static final int K0 = 23;
    public static final int L = 0;
    public static final int L0 = 24;
    public static final int M = 1;
    public static final int M0 = 25;
    public static final int N = 2;
    public static final int N0 = 26;
    public static final int O = 3;
    public static final int O0 = 27;
    public static final int P = 4;
    public static final int P0 = 28;
    public static final int Q = 5;
    public static final int Q0 = 29;
    public static final int R = 6;
    public static final int R0 = 30;
    public static final int S = 0;
    public static final int S0 = 1000;
    public static final int T = 1;
    public static final int U = 2;
    public static final int V = 3;
    public static final int W = 4;
    public static final int X = 5;
    public static final int Y = 6;
    public static final int Z = 7;
    public static final int a0 = 8;
    public static final int b0 = 9;
    public static final int c0 = 10;
    public static final int d0 = 11;
    public static final int e0 = 12;
    public static final int f0 = 13;
    public static final int g0 = 14;
    public static final int h0 = 15;
    public static final int i0 = 16;
    public static final int j0 = 17;
    public static final int k0 = 18;
    public static final int l0 = 19;
    public static final int m0 = 20;
    public static final int n0 = 0;
    public static final int o0 = 1;
    public static final int p0 = 2;
    public static final int q0 = 3;
    public static final int r0 = 4;
    public static final int s0 = 5;
    public static final int t0 = 6;
    public static final int u0 = 7;
    public static final int v0 = 8;
    public static final int w0 = 9;
    public static final int x0 = 10;
    public static final int y0 = 11;
    public static final int z0 = 12;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Uri f2103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Bundle f2104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Rating f2105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Boolean f2106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final CharSequence f2107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Integer f2108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final byte[] f2109a;

    @Nullable
    public final Rating b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final CharSequence f2110b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final Integer f2111b;

    @Nullable
    public final CharSequence c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final Integer f2112c;

    @Nullable
    public final CharSequence d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public final Integer f2113d;

    @Nullable
    public final CharSequence e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    @Deprecated
    public final Integer f2114e;

    @Nullable
    public final CharSequence f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public final Integer f2115f;

    @Nullable
    public final CharSequence g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @Nullable
    public final Integer f2116g;

    @Nullable
    public final CharSequence h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @Nullable
    public final Integer f2117h;

    @Nullable
    public final CharSequence i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @Nullable
    public final Integer f2118i;

    @Nullable
    public final CharSequence j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    @Nullable
    public final Integer f2119j;

    @Nullable
    public final CharSequence k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    @Nullable
    public final Integer f2120k;

    @Nullable
    public final CharSequence l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    @Nullable
    public final Integer f2121l;

    @Nullable
    public final CharSequence m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    @Nullable
    public final Integer f2122m;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final MediaMetadata f2102a = new b().F();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<MediaMetadata> f30491a = new Bundleable.Creator() { // from class: com.zj.adlib.qh5
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return MediaMetadata.c(bundle);
        }
    };

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FolderType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PictureType {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f30492a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Bundle f2123a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Rating f2124a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Boolean f2125a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public CharSequence f2126a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Integer f2127a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public byte[] f2128a;

        @Nullable
        public Rating b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public CharSequence f2129b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public Integer f2130b;

        @Nullable
        public CharSequence c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Nullable
        public Integer f2131c;

        @Nullable
        public CharSequence d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        @Nullable
        public Integer f2132d;

        @Nullable
        public CharSequence e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        @Nullable
        public Integer f2133e;

        @Nullable
        public CharSequence f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        @Nullable
        public Integer f2134f;

        @Nullable
        public CharSequence g;

        /* JADX INFO: renamed from: g, reason: collision with other field name */
        @Nullable
        public Integer f2135g;

        @Nullable
        public CharSequence h;

        /* JADX INFO: renamed from: h, reason: collision with other field name */
        @Nullable
        public Integer f2136h;

        @Nullable
        public CharSequence i;

        /* JADX INFO: renamed from: i, reason: collision with other field name */
        @Nullable
        public Integer f2137i;

        @Nullable
        public CharSequence j;

        /* JADX INFO: renamed from: j, reason: collision with other field name */
        @Nullable
        public Integer f2138j;

        @Nullable
        public CharSequence k;

        /* JADX INFO: renamed from: k, reason: collision with other field name */
        @Nullable
        public Integer f2139k;

        @Nullable
        public CharSequence l;

        /* JADX INFO: renamed from: l, reason: collision with other field name */
        @Nullable
        public Integer f2140l;

        @Nullable
        public CharSequence m;

        public MediaMetadata F() {
            return new MediaMetadata(this);
        }

        public b G(byte[] bArr, int i) {
            if (this.f2128a == null || gj9.c(Integer.valueOf(i), 3) || !gj9.c(this.f2127a, 3)) {
                this.f2128a = (byte[]) bArr.clone();
                this.f2127a = Integer.valueOf(i);
            }
            return this;
        }

        public b H(@Nullable MediaMetadata mediaMetadata) {
            if (mediaMetadata == null) {
                return this;
            }
            CharSequence charSequence = mediaMetadata.f2107a;
            if (charSequence != null) {
                j0(charSequence);
            }
            CharSequence charSequence2 = mediaMetadata.f2110b;
            if (charSequence2 != null) {
                M(charSequence2);
            }
            CharSequence charSequence3 = mediaMetadata.c;
            if (charSequence3 != null) {
                L(charSequence3);
            }
            CharSequence charSequence4 = mediaMetadata.d;
            if (charSequence4 != null) {
                K(charSequence4);
            }
            CharSequence charSequence5 = mediaMetadata.e;
            if (charSequence5 != null) {
                V(charSequence5);
            }
            CharSequence charSequence6 = mediaMetadata.f;
            if (charSequence6 != null) {
                i0(charSequence6);
            }
            CharSequence charSequence7 = mediaMetadata.g;
            if (charSequence7 != null) {
                T(charSequence7);
            }
            Rating rating = mediaMetadata.f2105a;
            if (rating != null) {
                n0(rating);
            }
            Rating rating2 = mediaMetadata.b;
            if (rating2 != null) {
                a0(rating2);
            }
            byte[] bArr = mediaMetadata.f2109a;
            if (bArr != null) {
                O(bArr, mediaMetadata.f2108a);
            }
            Uri uri = mediaMetadata.f2103a;
            if (uri != null) {
                P(uri);
            }
            Integer num = mediaMetadata.f2111b;
            if (num != null) {
                m0(num);
            }
            Integer num2 = mediaMetadata.f2112c;
            if (num2 != null) {
                l0(num2);
            }
            Integer num3 = mediaMetadata.f2113d;
            if (num3 != null) {
                X(num3);
            }
            Boolean bool = mediaMetadata.f2106a;
            if (bool != null) {
                Z(bool);
            }
            Integer num4 = mediaMetadata.f2114e;
            if (num4 != null) {
                d0(num4);
            }
            Integer num5 = mediaMetadata.f2115f;
            if (num5 != null) {
                d0(num5);
            }
            Integer num6 = mediaMetadata.f2116g;
            if (num6 != null) {
                c0(num6);
            }
            Integer num7 = mediaMetadata.f2117h;
            if (num7 != null) {
                b0(num7);
            }
            Integer num8 = mediaMetadata.f2118i;
            if (num8 != null) {
                g0(num8);
            }
            Integer num9 = mediaMetadata.f2119j;
            if (num9 != null) {
                f0(num9);
            }
            Integer num10 = mediaMetadata.f2120k;
            if (num10 != null) {
                e0(num10);
            }
            CharSequence charSequence8 = mediaMetadata.h;
            if (charSequence8 != null) {
                o0(charSequence8);
            }
            CharSequence charSequence9 = mediaMetadata.i;
            if (charSequence9 != null) {
                R(charSequence9);
            }
            CharSequence charSequence10 = mediaMetadata.j;
            if (charSequence10 != null) {
                S(charSequence10);
            }
            Integer num11 = mediaMetadata.f2121l;
            if (num11 != null) {
                U(num11);
            }
            Integer num12 = mediaMetadata.f2122m;
            if (num12 != null) {
                k0(num12);
            }
            CharSequence charSequence11 = mediaMetadata.k;
            if (charSequence11 != null) {
                Y(charSequence11);
            }
            CharSequence charSequence12 = mediaMetadata.l;
            if (charSequence12 != null) {
                Q(charSequence12);
            }
            CharSequence charSequence13 = mediaMetadata.m;
            if (charSequence13 != null) {
                h0(charSequence13);
            }
            Bundle bundle = mediaMetadata.f2104a;
            if (bundle != null) {
                W(bundle);
            }
            return this;
        }

        public b I(Metadata metadata) {
            for (int i = 0; i < metadata.length(); i++) {
                metadata.get(i).populateMediaMetadata(this);
            }
            return this;
        }

        public b J(List<Metadata> list) {
            for (int i = 0; i < list.size(); i++) {
                Metadata metadata = list.get(i);
                for (int i2 = 0; i2 < metadata.length(); i2++) {
                    metadata.get(i2).populateMediaMetadata(this);
                }
            }
            return this;
        }

        public b K(@Nullable CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public b L(@Nullable CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public b M(@Nullable CharSequence charSequence) {
            this.f2129b = charSequence;
            return this;
        }

        @Deprecated
        public b N(@Nullable byte[] bArr) {
            return O(bArr, null);
        }

        public b O(@Nullable byte[] bArr, @Nullable Integer num) {
            this.f2128a = bArr == null ? null : (byte[]) bArr.clone();
            this.f2127a = num;
            return this;
        }

        public b P(@Nullable Uri uri) {
            this.f30492a = uri;
            return this;
        }

        public b Q(@Nullable CharSequence charSequence) {
            this.l = charSequence;
            return this;
        }

        public b R(@Nullable CharSequence charSequence) {
            this.i = charSequence;
            return this;
        }

        public b S(@Nullable CharSequence charSequence) {
            this.j = charSequence;
            return this;
        }

        public b T(@Nullable CharSequence charSequence) {
            this.g = charSequence;
            return this;
        }

        public b U(@Nullable Integer num) {
            this.f2139k = num;
            return this;
        }

        public b V(@Nullable CharSequence charSequence) {
            this.e = charSequence;
            return this;
        }

        public b W(@Nullable Bundle bundle) {
            this.f2123a = bundle;
            return this;
        }

        public b X(@Nullable Integer num) {
            this.f2132d = num;
            return this;
        }

        public b Y(@Nullable CharSequence charSequence) {
            this.k = charSequence;
            return this;
        }

        public b Z(@Nullable Boolean bool) {
            this.f2125a = bool;
            return this;
        }

        public b a0(@Nullable Rating rating) {
            this.b = rating;
            return this;
        }

        public b b0(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.f2135g = num;
            return this;
        }

        public b c0(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.f2134f = num;
            return this;
        }

        public b d0(@Nullable Integer num) {
            this.f2133e = num;
            return this;
        }

        public b e0(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.f2138j = num;
            return this;
        }

        public b f0(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.f2137i = num;
            return this;
        }

        public b g0(@Nullable Integer num) {
            this.f2136h = num;
            return this;
        }

        public b h0(@Nullable CharSequence charSequence) {
            this.m = charSequence;
            return this;
        }

        public b i0(@Nullable CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        public b j0(@Nullable CharSequence charSequence) {
            this.f2126a = charSequence;
            return this;
        }

        public b k0(@Nullable Integer num) {
            this.f2140l = num;
            return this;
        }

        public b l0(@Nullable Integer num) {
            this.f2131c = num;
            return this;
        }

        public b m0(@Nullable Integer num) {
            this.f2130b = num;
            return this;
        }

        public b n0(@Nullable Rating rating) {
            this.f2124a = rating;
            return this;
        }

        public b o0(@Nullable CharSequence charSequence) {
            this.h = charSequence;
            return this;
        }

        @Deprecated
        public b p0(@Nullable Integer num) {
            return d0(num);
        }

        public b() {
        }

        public b(MediaMetadata mediaMetadata) {
            this.f2126a = mediaMetadata.f2107a;
            this.f2129b = mediaMetadata.f2110b;
            this.c = mediaMetadata.c;
            this.d = mediaMetadata.d;
            this.e = mediaMetadata.e;
            this.f = mediaMetadata.f;
            this.g = mediaMetadata.g;
            this.f2124a = mediaMetadata.f2105a;
            this.b = mediaMetadata.b;
            this.f2128a = mediaMetadata.f2109a;
            this.f2127a = mediaMetadata.f2108a;
            this.f30492a = mediaMetadata.f2103a;
            this.f2130b = mediaMetadata.f2111b;
            this.f2131c = mediaMetadata.f2112c;
            this.f2132d = mediaMetadata.f2113d;
            this.f2125a = mediaMetadata.f2106a;
            this.f2133e = mediaMetadata.f2115f;
            this.f2134f = mediaMetadata.f2116g;
            this.f2135g = mediaMetadata.f2117h;
            this.f2136h = mediaMetadata.f2118i;
            this.f2137i = mediaMetadata.f2119j;
            this.f2138j = mediaMetadata.f2120k;
            this.h = mediaMetadata.h;
            this.i = mediaMetadata.i;
            this.j = mediaMetadata.j;
            this.f2139k = mediaMetadata.f2121l;
            this.f2140l = mediaMetadata.f2122m;
            this.k = mediaMetadata.k;
            this.l = mediaMetadata.l;
            this.m = mediaMetadata.m;
            this.f2123a = mediaMetadata.f2104a;
        }
    }

    public static MediaMetadata c(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        b bVar = new b();
        bVar.j0(bundle.getCharSequence(d(0))).M(bundle.getCharSequence(d(1))).L(bundle.getCharSequence(d(2))).K(bundle.getCharSequence(d(3))).V(bundle.getCharSequence(d(4))).i0(bundle.getCharSequence(d(5))).T(bundle.getCharSequence(d(6))).O(bundle.getByteArray(d(10)), bundle.containsKey(d(29)) ? Integer.valueOf(bundle.getInt(d(29))) : null).P((Uri) bundle.getParcelable(d(11))).o0(bundle.getCharSequence(d(22))).R(bundle.getCharSequence(d(23))).S(bundle.getCharSequence(d(24))).Y(bundle.getCharSequence(d(27))).Q(bundle.getCharSequence(d(28))).h0(bundle.getCharSequence(d(30))).W(bundle.getBundle(d(1000)));
        if (bundle.containsKey(d(8)) && (bundle3 = bundle.getBundle(d(8))) != null) {
            bVar.n0((Rating) Rating.f2180a.a(bundle3));
        }
        if (bundle.containsKey(d(9)) && (bundle2 = bundle.getBundle(d(9))) != null) {
            bVar.a0((Rating) Rating.f2180a.a(bundle2));
        }
        if (bundle.containsKey(d(12))) {
            bVar.m0(Integer.valueOf(bundle.getInt(d(12))));
        }
        if (bundle.containsKey(d(13))) {
            bVar.l0(Integer.valueOf(bundle.getInt(d(13))));
        }
        if (bundle.containsKey(d(14))) {
            bVar.X(Integer.valueOf(bundle.getInt(d(14))));
        }
        if (bundle.containsKey(d(15))) {
            bVar.Z(Boolean.valueOf(bundle.getBoolean(d(15))));
        }
        if (bundle.containsKey(d(16))) {
            bVar.d0(Integer.valueOf(bundle.getInt(d(16))));
        }
        if (bundle.containsKey(d(17))) {
            bVar.c0(Integer.valueOf(bundle.getInt(d(17))));
        }
        if (bundle.containsKey(d(18))) {
            bVar.b0(Integer.valueOf(bundle.getInt(d(18))));
        }
        if (bundle.containsKey(d(19))) {
            bVar.g0(Integer.valueOf(bundle.getInt(d(19))));
        }
        if (bundle.containsKey(d(20))) {
            bVar.f0(Integer.valueOf(bundle.getInt(d(20))));
        }
        if (bundle.containsKey(d(21))) {
            bVar.e0(Integer.valueOf(bundle.getInt(d(21))));
        }
        if (bundle.containsKey(d(25))) {
            bVar.U(Integer.valueOf(bundle.getInt(d(25))));
        }
        if (bundle.containsKey(d(26))) {
            bVar.k0(Integer.valueOf(bundle.getInt(d(26))));
        }
        return bVar.F();
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public b b() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return gj9.c(this.f2107a, mediaMetadata.f2107a) && gj9.c(this.f2110b, mediaMetadata.f2110b) && gj9.c(this.c, mediaMetadata.c) && gj9.c(this.d, mediaMetadata.d) && gj9.c(this.e, mediaMetadata.e) && gj9.c(this.f, mediaMetadata.f) && gj9.c(this.g, mediaMetadata.g) && gj9.c(this.f2105a, mediaMetadata.f2105a) && gj9.c(this.b, mediaMetadata.b) && Arrays.equals(this.f2109a, mediaMetadata.f2109a) && gj9.c(this.f2108a, mediaMetadata.f2108a) && gj9.c(this.f2103a, mediaMetadata.f2103a) && gj9.c(this.f2111b, mediaMetadata.f2111b) && gj9.c(this.f2112c, mediaMetadata.f2112c) && gj9.c(this.f2113d, mediaMetadata.f2113d) && gj9.c(this.f2106a, mediaMetadata.f2106a) && gj9.c(this.f2115f, mediaMetadata.f2115f) && gj9.c(this.f2116g, mediaMetadata.f2116g) && gj9.c(this.f2117h, mediaMetadata.f2117h) && gj9.c(this.f2118i, mediaMetadata.f2118i) && gj9.c(this.f2119j, mediaMetadata.f2119j) && gj9.c(this.f2120k, mediaMetadata.f2120k) && gj9.c(this.h, mediaMetadata.h) && gj9.c(this.i, mediaMetadata.i) && gj9.c(this.j, mediaMetadata.j) && gj9.c(this.f2121l, mediaMetadata.f2121l) && gj9.c(this.f2122m, mediaMetadata.f2122m) && gj9.c(this.k, mediaMetadata.k) && gj9.c(this.l, mediaMetadata.l) && gj9.c(this.m, mediaMetadata.m);
    }

    public int hashCode() {
        return com.google.common.base.g.b(this.f2107a, this.f2110b, this.c, this.d, this.e, this.f, this.g, this.f2105a, this.b, Integer.valueOf(Arrays.hashCode(this.f2109a)), this.f2108a, this.f2103a, this.f2111b, this.f2112c, this.f2113d, this.f2106a, this.f2115f, this.f2116g, this.f2117h, this.f2118i, this.f2119j, this.f2120k, this.h, this.i, this.j, this.f2121l, this.f2122m, this.k, this.l, this.m);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.f2107a);
        bundle.putCharSequence(d(1), this.f2110b);
        bundle.putCharSequence(d(2), this.c);
        bundle.putCharSequence(d(3), this.d);
        bundle.putCharSequence(d(4), this.e);
        bundle.putCharSequence(d(5), this.f);
        bundle.putCharSequence(d(6), this.g);
        bundle.putByteArray(d(10), this.f2109a);
        bundle.putParcelable(d(11), this.f2103a);
        bundle.putCharSequence(d(22), this.h);
        bundle.putCharSequence(d(23), this.i);
        bundle.putCharSequence(d(24), this.j);
        bundle.putCharSequence(d(27), this.k);
        bundle.putCharSequence(d(28), this.l);
        bundle.putCharSequence(d(30), this.m);
        if (this.f2105a != null) {
            bundle.putBundle(d(8), this.f2105a.toBundle());
        }
        if (this.b != null) {
            bundle.putBundle(d(9), this.b.toBundle());
        }
        if (this.f2111b != null) {
            bundle.putInt(d(12), this.f2111b.intValue());
        }
        if (this.f2112c != null) {
            bundle.putInt(d(13), this.f2112c.intValue());
        }
        if (this.f2113d != null) {
            bundle.putInt(d(14), this.f2113d.intValue());
        }
        if (this.f2106a != null) {
            bundle.putBoolean(d(15), this.f2106a.booleanValue());
        }
        if (this.f2115f != null) {
            bundle.putInt(d(16), this.f2115f.intValue());
        }
        if (this.f2116g != null) {
            bundle.putInt(d(17), this.f2116g.intValue());
        }
        if (this.f2117h != null) {
            bundle.putInt(d(18), this.f2117h.intValue());
        }
        if (this.f2118i != null) {
            bundle.putInt(d(19), this.f2118i.intValue());
        }
        if (this.f2119j != null) {
            bundle.putInt(d(20), this.f2119j.intValue());
        }
        if (this.f2120k != null) {
            bundle.putInt(d(21), this.f2120k.intValue());
        }
        if (this.f2121l != null) {
            bundle.putInt(d(25), this.f2121l.intValue());
        }
        if (this.f2122m != null) {
            bundle.putInt(d(26), this.f2122m.intValue());
        }
        if (this.f2108a != null) {
            bundle.putInt(d(29), this.f2108a.intValue());
        }
        if (this.f2104a != null) {
            bundle.putBundle(d(1000), this.f2104a);
        }
        return bundle;
    }

    public MediaMetadata(b bVar) {
        this.f2107a = bVar.f2126a;
        this.f2110b = bVar.f2129b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.f2105a = bVar.f2124a;
        this.b = bVar.b;
        this.f2109a = bVar.f2128a;
        this.f2108a = bVar.f2127a;
        this.f2103a = bVar.f30492a;
        this.f2111b = bVar.f2130b;
        this.f2112c = bVar.f2131c;
        this.f2113d = bVar.f2132d;
        this.f2106a = bVar.f2125a;
        this.f2114e = bVar.f2133e;
        this.f2115f = bVar.f2133e;
        this.f2116g = bVar.f2134f;
        this.f2117h = bVar.f2135g;
        this.f2118i = bVar.f2136h;
        this.f2119j = bVar.f2137i;
        this.f2120k = bVar.f2138j;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.f2121l = bVar.f2139k;
        this.f2122m = bVar.f2140l;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.f2104a = bVar.f2123a;
    }
}
