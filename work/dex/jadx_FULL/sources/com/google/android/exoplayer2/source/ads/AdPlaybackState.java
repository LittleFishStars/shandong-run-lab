package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AdPlaybackState implements Bundleable {
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 2;
    public static final int P = 3;
    public static final int Q = 4;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final int U = 4;
    public final int K;
    public final int L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Object f3766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b[] f3767a;
    public final long b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AdPlaybackState f3764a = new AdPlaybackState(null, new b[0], 0, -9223372036854775807L, 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final b f3763a = new b(0).j(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<AdPlaybackState> f30839a = new Bundleable.Creator() { // from class: com.zj.adlib.wv
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return AdPlaybackState.d(bundle);
        }
    };

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public static final class b implements Bundleable {
        public static final int L = 0;
        public static final int M = 1;
        public static final int N = 2;
        public static final int O = 3;
        public static final int P = 4;
        public static final int Q = 5;
        public static final int R = 6;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<b> f30840a = new Bundleable.Creator() { // from class: com.zj.adlib.yv
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return AdPlaybackState.b.d(bundle);
            }
        };
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3768a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3769a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f3770a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f3771a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Uri[] f3772a;
        public final long b;

        @CheckResult
        public static long[] b(long[] jArr, int i) {
            int length = jArr.length;
            int iMax = Math.max(i, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        @CheckResult
        public static int[] c(int[] iArr, int i) {
            int length = iArr.length;
            int iMax = Math.max(i, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public static b d(Bundle bundle) {
            long j = bundle.getLong(h(0));
            int i = bundle.getInt(h(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(h(2));
            int[] intArray = bundle.getIntArray(h(3));
            long[] longArray = bundle.getLongArray(h(4));
            long j2 = bundle.getLong(h(5));
            boolean z = bundle.getBoolean(h(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            return new b(j, i, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j2, z);
        }

        public static String h(int i) {
            return Integer.toString(i, 36);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3768a == bVar.f3768a && this.K == bVar.K && Arrays.equals(this.f3772a, bVar.f3772a) && Arrays.equals(this.f3770a, bVar.f3770a) && Arrays.equals(this.f3771a, bVar.f3771a) && this.b == bVar.b && this.f3769a == bVar.f3769a;
        }

        public int f(@IntRange(from = -1) int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.f3770a;
                if (i3 >= iArr.length || this.f3769a || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public boolean g() {
            if (this.K == -1) {
                return true;
            }
            for (int i = 0; i < this.K; i++) {
                int i2 = this.f3770a[i];
                if (i2 == 0 || i2 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.K * 31;
            long j = this.f3768a;
            int iHashCode = (((((((i + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.f3772a)) * 31) + Arrays.hashCode(this.f3770a)) * 31) + Arrays.hashCode(this.f3771a)) * 31;
            long j2 = this.b;
            return ((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f3769a ? 1 : 0);
        }

        public boolean i() {
            return this.K == -1 || e() < this.K;
        }

        @CheckResult
        public b j(int i) {
            int[] iArrC = c(this.f3770a, i);
            long[] jArrB = b(this.f3771a, i);
            return new b(this.f3768a, i, iArrC, (Uri[]) Arrays.copyOf(this.f3772a, i), jArrB, this.b, this.f3769a);
        }

        @CheckResult
        public b k(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.f3772a;
            if (length < uriArr.length) {
                jArr = b(jArr, uriArr.length);
            } else if (this.K != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new b(this.f3768a, this.K, this.f3770a, this.f3772a, jArr, this.b, this.f3769a);
        }

        @CheckResult
        public b l(int i, @IntRange(from = 0) int i2) {
            int i3 = this.K;
            sb0.a(i3 == -1 || i2 < i3);
            int[] iArrC = c(this.f3770a, i2 + 1);
            int i4 = iArrC[i2];
            sb0.a(i4 == 0 || i4 == 1 || i4 == i);
            long[] jArrB = this.f3771a;
            if (jArrB.length != iArrC.length) {
                jArrB = b(jArrB, iArrC.length);
            }
            long[] jArr = jArrB;
            Uri[] uriArr = this.f3772a;
            if (uriArr.length != iArrC.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, iArrC.length);
            }
            iArrC[i2] = i;
            return new b(this.f3768a, this.K, iArrC, uriArr, jArr, this.b, this.f3769a);
        }

        @CheckResult
        public b m(Uri uri, @IntRange(from = 0) int i) {
            int[] iArrC = c(this.f3770a, i + 1);
            long[] jArrB = this.f3771a;
            if (jArrB.length != iArrC.length) {
                jArrB = b(jArrB, iArrC.length);
            }
            long[] jArr = jArrB;
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.f3772a, iArrC.length);
            uriArr[i] = uri;
            iArrC[i] = 1;
            return new b(this.f3768a, this.K, iArrC, uriArr, jArr, this.b, this.f3769a);
        }

        @CheckResult
        public b n() {
            if (this.K == -1) {
                return this;
            }
            int[] iArr = this.f3770a;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                int i2 = iArrCopyOf[i];
                if (i2 == 3 || i2 == 2 || i2 == 4) {
                    iArrCopyOf[i] = this.f3772a[i] == null ? 0 : 1;
                }
            }
            return new b(this.f3768a, length, iArrCopyOf, this.f3772a, this.f3771a, this.b, this.f3769a);
        }

        @CheckResult
        public b o() {
            if (this.K == -1) {
                return new b(this.f3768a, 0, new int[0], new Uri[0], new long[0], this.b, this.f3769a);
            }
            int[] iArr = this.f3770a;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                int i2 = iArrCopyOf[i];
                if (i2 == 1 || i2 == 0) {
                    iArrCopyOf[i] = 2;
                }
            }
            return new b(this.f3768a, length, iArrCopyOf, this.f3772a, this.f3771a, this.b, this.f3769a);
        }

        @CheckResult
        public b p(long j) {
            return new b(this.f3768a, this.K, this.f3770a, this.f3772a, this.f3771a, j, this.f3769a);
        }

        @CheckResult
        public b q(boolean z) {
            return new b(this.f3768a, this.K, this.f3770a, this.f3772a, this.f3771a, this.b, z);
        }

        @CheckResult
        public b r(long j) {
            return new b(j, this.K, this.f3770a, this.f3772a, this.f3771a, this.b, this.f3769a);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(h(0), this.f3768a);
            bundle.putInt(h(1), this.K);
            bundle.putParcelableArrayList(h(2), new ArrayList<>(Arrays.asList(this.f3772a)));
            bundle.putIntArray(h(3), this.f3770a);
            bundle.putLongArray(h(4), this.f3771a);
            bundle.putLong(h(5), this.b);
            bundle.putBoolean(h(6), this.f3769a);
            return bundle;
        }

        public b(long j) {
            this(j, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        public b(long j, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
            sb0.a(iArr.length == uriArr.length);
            this.f3768a = j;
            this.K = i;
            this.f3770a = iArr;
            this.f3772a = uriArr;
            this.f3771a = jArr;
            this.b = j2;
            this.f3769a = z;
        }
    }

    public AdPlaybackState(Object obj, long... jArr) {
        this(obj, b(jArr), 0L, -9223372036854775807L, 0);
    }

    public static b[] b(long[] jArr) {
        int length = jArr.length;
        b[] bVarArr = new b[length];
        for (int i = 0; i < length; i++) {
            bVarArr[i] = new b(jArr[i]);
        }
        return bVarArr;
    }

    public static AdPlaybackState c(Object obj, AdPlaybackState adPlaybackState) {
        int i = adPlaybackState.K - adPlaybackState.L;
        b[] bVarArr = new b[i];
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = adPlaybackState.f3767a[i2];
            long j = bVar.f3768a;
            int i3 = bVar.K;
            int[] iArr = bVar.f3770a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            Uri[] uriArr = bVar.f3772a;
            Uri[] uriArr2 = (Uri[]) Arrays.copyOf(uriArr, uriArr.length);
            long[] jArr = bVar.f3771a;
            bVarArr[i2] = new b(j, i3, iArrCopyOf, uriArr2, Arrays.copyOf(jArr, jArr.length), bVar.b, bVar.f3769a);
        }
        return new AdPlaybackState(obj, bVarArr, adPlaybackState.f3765a, adPlaybackState.b, adPlaybackState.L);
    }

    public static AdPlaybackState d(Bundle bundle) {
        b[] bVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(j(1));
        if (parcelableArrayList == null) {
            bVarArr = new b[0];
        } else {
            b[] bVarArr2 = new b[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                bVarArr2[i] = (b) b.f30840a.a((Bundle) parcelableArrayList.get(i));
            }
            bVarArr = bVarArr2;
        }
        return new AdPlaybackState(null, bVarArr, bundle.getLong(j(2), 0L), bundle.getLong(j(3), -9223372036854775807L), bundle.getInt(j(4)));
    }

    public static String j(int i) {
        return Integer.toString(i, 36);
    }

    public b e(@IntRange(from = 0) int i) {
        int i2 = this.L;
        return i < i2 ? f3763a : this.f3767a[i - i2];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        return gj9.c(this.f3766a, adPlaybackState.f3766a) && this.K == adPlaybackState.K && this.f3765a == adPlaybackState.f3765a && this.b == adPlaybackState.b && this.L == adPlaybackState.L && Arrays.equals(this.f3767a, adPlaybackState.f3767a);
    }

    public int f(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        int i = this.L;
        while (i < this.K && ((e(i).f3768a != Long.MIN_VALUE && e(i).f3768a <= j) || !e(i).i())) {
            i++;
        }
        if (i < this.K) {
            return i;
        }
        return -1;
    }

    public int g(long j, long j2) {
        int i = this.K - 1;
        while (i >= 0 && i(j, j2, i)) {
            i--;
        }
        if (i < 0 || !e(i).g()) {
            return -1;
        }
        return i;
    }

    public boolean h(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        b bVarE;
        int i3;
        return i < this.K && (i3 = (bVarE = e(i)).K) != -1 && i2 < i3 && bVarE.f3770a[i2] == 4;
    }

    public int hashCode() {
        int i = this.K * 31;
        Object obj = this.f3766a;
        return ((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f3765a)) * 31) + ((int) this.b)) * 31) + this.L) * 31) + Arrays.hashCode(this.f3767a);
    }

    public final boolean i(long j, long j2, int i) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j3 = e(i).f3768a;
        if (j3 == Long.MIN_VALUE) {
            return j2 == -9223372036854775807L || j < j2;
        }
        return j < j3;
    }

    @CheckResult
    public AdPlaybackState k(@IntRange(from = 0) int i, @IntRange(from = 1) int i2) {
        sb0.a(i2 > 0);
        int i3 = i - this.L;
        b[] bVarArr = this.f3767a;
        if (bVarArr[i3].K == i2) {
            return this;
        }
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i3] = this.f3767a[i3].j(i2);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState l(@IntRange(from = 0) int i, long... jArr) {
        int i2 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i2] = bVarArr2[i2].k(jArr);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState m(long[][] jArr) {
        sb0.i(this.L == 0);
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        for (int i = 0; i < this.K; i++) {
            bVarArr2[i] = bVarArr2[i].k(jArr[i]);
        }
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState n(@IntRange(from = 0) int i, long j) {
        int i2 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i2] = this.f3767a[i2].r(j);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState o(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i3] = bVarArr2[i3].l(4, i2);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState p(long j) {
        return this.f3765a == j ? this : new AdPlaybackState(this.f3766a, this.f3767a, j, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState q(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, Uri uri) {
        int i3 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i3] = bVarArr2[i3].m(uri, i2);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState r(long j) {
        return this.b == j ? this : new AdPlaybackState(this.f3766a, this.f3767a, this.f3765a, j, this.L);
    }

    @CheckResult
    public AdPlaybackState s(@IntRange(from = 0) int i, long j) {
        int i2 = i - this.L;
        b[] bVarArr = this.f3767a;
        if (bVarArr[i2].b == j) {
            return this;
        }
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i2] = bVarArr2[i2].p(j);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState t(@IntRange(from = 0) int i, boolean z) {
        int i2 = i - this.L;
        b[] bVarArr = this.f3767a;
        if (bVarArr[i2].f3769a == z) {
            return this;
        }
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i2] = bVarArr2[i2].q(z);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (b bVar : this.f3767a) {
            arrayList.add(bVar.toBundle());
        }
        bundle.putParcelableArrayList(j(1), arrayList);
        bundle.putLong(j(2), this.f3765a);
        bundle.putLong(j(3), this.b);
        bundle.putInt(j(4), this.L);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f3766a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f3765a);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.f3767a.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f3767a[i].f3768a);
            sb.append(", ads=[");
            for (int i2 = 0; i2 < this.f3767a[i].f3770a.length; i2++) {
                sb.append("ad(state=");
                int i3 = this.f3767a[i].f3770a[i2];
                if (i3 == 0) {
                    sb.append('_');
                } else if (i3 == 1) {
                    sb.append('R');
                } else if (i3 == 2) {
                    sb.append('S');
                } else if (i3 == 3) {
                    sb.append('P');
                } else if (i3 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f3767a[i].f3771a[i2]);
                sb.append(')');
                if (i2 < this.f3767a[i].f3770a.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < this.f3767a.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    @CheckResult
    public AdPlaybackState u(@IntRange(from = 0) int i, long j) {
        int i2 = i - this.L;
        b bVar = new b(j);
        b[] bVarArr = (b[]) gj9.c1(this.f3767a, bVar);
        System.arraycopy(bVarArr, i2, bVarArr, i2 + 1, this.f3767a.length - i2);
        bVarArr[i2] = bVar;
        return new AdPlaybackState(this.f3766a, bVarArr, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState v(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i3] = bVarArr2[i3].l(3, i2);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState w(@IntRange(from = 0) int i) {
        int i2 = this.L;
        if (i2 == i) {
            return this;
        }
        sb0.a(i > i2);
        int i3 = this.K - i;
        b[] bVarArr = new b[i3];
        System.arraycopy(this.f3767a, i - this.L, bVarArr, 0, i3);
        return new AdPlaybackState(this.f3766a, bVarArr, this.f3765a, this.b, i);
    }

    @CheckResult
    public AdPlaybackState x(@IntRange(from = 0) int i) {
        int i2 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i2] = bVarArr2[i2].n();
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState y(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i3] = bVarArr2[i3].l(2, i2);
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    @CheckResult
    public AdPlaybackState z(@IntRange(from = 0) int i) {
        int i2 = i - this.L;
        b[] bVarArr = this.f3767a;
        b[] bVarArr2 = (b[]) gj9.e1(bVarArr, bVarArr.length);
        bVarArr2[i2] = bVarArr2[i2].o();
        return new AdPlaybackState(this.f3766a, bVarArr2, this.f3765a, this.b, this.L);
    }

    public AdPlaybackState(@Nullable Object obj, b[] bVarArr, long j, long j2, int i) {
        this.f3766a = obj;
        this.f3765a = j;
        this.b = j2;
        this.K = bVarArr.length + i;
        this.f3767a = bVarArr;
        this.L = i;
    }
}
