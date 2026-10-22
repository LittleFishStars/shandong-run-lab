package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Function;
import com.zj.adlib.aa9;
import com.zj.adlib.bl8;
import com.zj.adlib.cs3;
import com.zj.adlib.g89;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.kw5;
import com.zj.adlib.ma9;
import com.zj.adlib.mr;
import com.zj.adlib.n53;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.vh2;
import com.zj.adlib.z99;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FragmentedMp4Extractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2954a = "FragmentedMp4Extractor";
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 4;
    public static final int o = 16;
    public static final int p = 1936025959;
    public static final int q = 100;
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<b> f2956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TrackOutput f2958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public b f2959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Track f2960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final g89 f2961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final n53 f2962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<Atom.a> f2964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<d> f2965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f2967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput[] f2968a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2969b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f2970b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayDeque<a> f2971b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2972b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TrackOutput[] f2973b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final om6 f2974c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2975d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final om6 f2976d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f2977e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final om6 f2978e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public om6 f2979f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ExtractorsFactory f2953a = new ExtractorsFactory() { // from class: com.zj.adlib.bm3
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return FragmentedMp4Extractor.k();
        }
    };
    public static final byte[] b = {-94, 57, 79, 82, 90, -101, 79, com.google.common.base.a.x, -94, 68, 108, 66, 124, 100, -115, -12};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f30679a = new d.b().e0("application/x-emsg").E();

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30680a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2980a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2981a;

        public a(long j, boolean z, int i) {
            this.f2980a = j;
            this.f2981a = z;
            this.f30680a = i;
        }
    }

    public static final class b {
        public static final int e = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30681a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f2982a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ma9 f2984a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public vh2 f2986a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2987a;
        public int b;
        public int c;
        public int d;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final aa9 f2983a = new aa9();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f2985a = new om6();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final om6 f2988b = new om6(1);

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final om6 f2989c = new om6();

        public b(TrackOutput trackOutput, ma9 ma9Var, vh2 vh2Var) {
            this.f2982a = trackOutput;
            this.f2984a = ma9Var;
            this.f2986a = vh2Var;
            j(ma9Var, vh2Var);
        }

        public int c() {
            int i;
            if (this.f2987a) {
                i = this.f2983a.f15228a[this.f30681a] ? 1 : 0;
            } else {
                i = this.f2984a.f18162b[this.f30681a];
            }
            return g() != null ? i | 1073741824 : i;
        }

        public long d() {
            return !this.f2987a ? this.f2984a.f18161a[this.f30681a] : this.f2983a.f15227a[this.c];
        }

        public long e() {
            return !this.f2987a ? this.f2984a.f18163b[this.f30681a] : this.f2983a.c(this.f30681a);
        }

        public int f() {
            return !this.f2987a ? this.f2984a.f18160a[this.f30681a] : this.f2983a.f15231b[this.f30681a];
        }

        @Nullable
        public z99 g() {
            if (!this.f2987a) {
                return null;
            }
            int i = ((vh2) gj9.k(this.f2983a.f15223a)).f45351a;
            z99 z99VarB = this.f2983a.f15224a;
            if (z99VarB == null) {
                z99VarB = this.f2984a.f18159a.b(i);
            }
            if (z99VarB == null || !z99VarB.f21011a) {
                return null;
            }
            return z99VarB;
        }

        public boolean h() {
            this.f30681a++;
            if (!this.f2987a) {
                return false;
            }
            int i = this.b + 1;
            this.b = i;
            int[] iArr = this.f2983a.f15226a;
            int i2 = this.c;
            if (i != iArr[i2]) {
                return true;
            }
            this.c = i2 + 1;
            this.b = 0;
            return false;
        }

        public int i(int i, int i2) {
            om6 om6Var;
            z99 z99VarG = g();
            if (z99VarG == null) {
                return 0;
            }
            int length = z99VarG.f46220a;
            if (length != 0) {
                om6Var = this.f2983a.f15222a;
            } else {
                byte[] bArr = (byte[]) gj9.k(z99VarG.f21012a);
                this.f2989c.Q(bArr, bArr.length);
                om6 om6Var2 = this.f2989c;
                length = bArr.length;
                om6Var = om6Var2;
            }
            boolean zG = this.f2983a.g(this.f30681a);
            boolean z = zG || i2 != 0;
            this.f2988b.d()[0] = (byte) ((z ? 128 : 0) | length);
            this.f2988b.S(0);
            this.f2982a.a(this.f2988b, 1, 1);
            this.f2982a.a(om6Var, length, 1);
            if (!z) {
                return length + 1;
            }
            if (!zG) {
                this.f2985a.O(8);
                byte[] bArrD = this.f2985a.d();
                bArrD[0] = 0;
                bArrD[1] = 1;
                bArrD[2] = (byte) ((i2 >> 8) & 255);
                bArrD[3] = (byte) (i2 & 255);
                bArrD[4] = (byte) ((i >> 24) & 255);
                bArrD[5] = (byte) ((i >> 16) & 255);
                bArrD[6] = (byte) ((i >> 8) & 255);
                bArrD[7] = (byte) (i & 255);
                this.f2982a.a(this.f2985a, 8, 1);
                return length + 1 + 8;
            }
            om6 om6Var3 = this.f2983a.f15222a;
            int iM = om6Var3.M();
            om6Var3.T(-2);
            int i3 = (iM * 6) + 2;
            if (i2 != 0) {
                this.f2985a.O(i3);
                byte[] bArrD2 = this.f2985a.d();
                om6Var3.k(bArrD2, 0, i3);
                int i4 = (((bArrD2[2] & 255) << 8) | (bArrD2[3] & 255)) + i2;
                bArrD2[2] = (byte) ((i4 >> 8) & 255);
                bArrD2[3] = (byte) (i4 & 255);
                om6Var3 = this.f2985a;
            }
            this.f2982a.a(om6Var3, i3, 1);
            return length + 1 + i3;
        }

        public void j(ma9 ma9Var, vh2 vh2Var) {
            this.f2984a = ma9Var;
            this.f2986a = vh2Var;
            this.f2982a.f(ma9Var.f18159a.f3009a);
            k();
        }

        public void k() {
            this.f2983a.f();
            this.f30681a = 0;
            this.c = 0;
            this.b = 0;
            this.d = 0;
            this.f2987a = false;
        }

        public void l(long j) {
            int i = this.f30681a;
            while (true) {
                aa9 aa9Var = this.f2983a;
                if (i >= aa9Var.b || aa9Var.c(i) >= j) {
                    return;
                }
                if (this.f2983a.f15228a[i]) {
                    this.d = i;
                }
                i++;
            }
        }

        public void m() {
            z99 z99VarG = g();
            if (z99VarG == null) {
                return;
            }
            om6 om6Var = this.f2983a.f15222a;
            int i = z99VarG.f46220a;
            if (i != 0) {
                om6Var.T(i);
            }
            if (this.f2983a.g(this.f30681a)) {
                om6Var.T(om6Var.M() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            z99 z99VarB = this.f2984a.f18159a.b(((vh2) gj9.k(this.f2983a.f15223a)).f45351a);
            this.f2982a.f(this.f2984a.f18159a.f3009a.b().M(drmInitData.copyWithSchemeType(z99VarB != null ? z99VarB.f21010a : null)).E());
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    @Nullable
    public static b A(om6 om6Var, SparseArray<b> sparseArray, boolean z) {
        om6Var.S(8);
        int iB = Atom.b(om6Var.o());
        b bVarValueAt = z ? sparseArray.valueAt(0) : sparseArray.get(om6Var.o());
        if (bVarValueAt == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jL = om6Var.L();
            aa9 aa9Var = bVarValueAt.f2983a;
            aa9Var.f15229b = jL;
            aa9Var.c = jL;
        }
        vh2 vh2Var = bVarValueAt.f2986a;
        bVarValueAt.f2983a.f15223a = new vh2((iB & 2) != 0 ? om6Var.o() - 1 : vh2Var.f45351a, (iB & 8) != 0 ? om6Var.o() : vh2Var.b, (iB & 16) != 0 ? om6Var.o() : vh2Var.c, (iB & 32) != 0 ? om6Var.o() : vh2Var.d);
        return bVarValueAt;
    }

    public static void B(Atom.a aVar, SparseArray<b> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        b bVarA = A(((Atom.b) sb0.g(aVar.h(1952868452))).f30671a, sparseArray, z);
        if (bVarA == null) {
            return;
        }
        aa9 aa9Var = bVarA.f2983a;
        long j = aa9Var.d;
        boolean z2 = aa9Var.f15234c;
        bVarA.k();
        bVarA.f2987a = true;
        Atom.b bVarH = aVar.h(1952867444);
        if (bVarH == null || (i & 2) != 0) {
            aa9Var.d = j;
            aa9Var.f15234c = z2;
        } else {
            aa9Var.d = z(bVarH.f30671a);
            aa9Var.f15234c = true;
        }
        E(aVar, bVarA, i);
        z99 z99VarB = bVarA.f2984a.f18159a.b(((vh2) sb0.g(aa9Var.f15223a)).f45351a);
        Atom.b bVarH2 = aVar.h(1935763834);
        if (bVarH2 != null) {
            u((z99) sb0.g(z99VarB), bVarH2.f30671a, aa9Var);
        }
        Atom.b bVarH3 = aVar.h(1935763823);
        if (bVarH3 != null) {
            t(bVarH3.f30671a, aa9Var);
        }
        Atom.b bVarH4 = aVar.h(1936027235);
        if (bVarH4 != null) {
            x(bVarH4.f30671a, aa9Var);
        }
        v(aVar, z99VarB != null ? z99VarB.f21010a : null, aa9Var);
        int size = aVar.f2939a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom.b bVar = aVar.f2939a.get(i2);
            if (((Atom) bVar).f30669a == 1970628964) {
                F(bVar.f30671a, aa9Var, bArr);
            }
        }
    }

    public static Pair<Integer, vh2> C(om6 om6Var) {
        om6Var.S(12);
        return Pair.create(Integer.valueOf(om6Var.o()), new vh2(om6Var.o() - 1, om6Var.o(), om6Var.o(), om6Var.o()));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0098  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:64:0x0111  */
    /* JADX WARN: Code duplicated, block: B:70:0x0126  */
    public static int D(b bVar, int i, int i2, om6 om6Var, int i3) throws ParserException {
        long j;
        long j2;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        boolean z;
        int i4;
        long j3;
        long j4;
        int i5;
        int iO;
        int iO2;
        int iO3;
        int iO4;
        long jO1;
        boolean z2;
        b bVar2 = bVar;
        om6Var.S(8);
        int iB = Atom.b(om6Var.o());
        Track track = bVar2.f2984a.f18159a;
        aa9 aa9Var = bVar2.f2983a;
        vh2 vh2Var = (vh2) gj9.k(aa9Var.f15223a);
        aa9Var.f15226a[i] = om6Var.K();
        long[] jArr2 = aa9Var.f15227a;
        long j5 = aa9Var.f15229b;
        jArr2[i] = j5;
        if ((iB & 1) != 0) {
            jArr2[i] = j5 + ((long) om6Var.o());
        }
        boolean z3 = (iB & 4) != 0;
        int iO5 = vh2Var.d;
        if (z3) {
            iO5 = om6Var.o();
        }
        boolean z4 = (iB & 256) != 0;
        boolean z5 = (iB & 512) != 0;
        boolean z6 = (iB & 1024) != 0;
        boolean z7 = (iB & 2048) != 0;
        long[] jArr3 = track.f3010a;
        if (jArr3 != null && jArr3.length == 1) {
            j = 0;
            if (jArr3[0] == 0) {
                j2 = ((long[]) gj9.k(track.f3013b))[0];
            }
            iArr = aa9Var.f15231b;
            jArr = aa9Var.f15232b;
            zArr = aa9Var.f15228a;
            int i6 = iO5;
            if (track.b == 2 || (i2 & 1) == 0) {
                z = false;
            } else {
                z = true;
            }
            i4 = i3 + aa9Var.f15226a[i];
            boolean z8 = z;
            j3 = track.f3008a;
            j4 = aa9Var.d;
            i5 = i3;
            while (i5 < i4) {
                if (z4) {
                    iO = om6Var.o();
                } else {
                    iO = vh2Var.b;
                }
                int iE = e(iO);
                if (z5) {
                    iO2 = om6Var.o();
                } else {
                    iO2 = vh2Var.c;
                }
                int iE2 = e(iO2);
                if (z6) {
                    iO3 = om6Var.o();
                } else if (i5 == 0 || !z3) {
                    iO3 = vh2Var.d;
                } else {
                    iO3 = i6;
                }
                if (z7) {
                    iO4 = om6Var.o();
                } else {
                    iO4 = 0;
                }
                jO1 = gj9.o1((((long) iO4) + j4) - j2, 1000000L, j3);
                jArr[i5] = jO1;
                if (!aa9Var.f15234c) {
                    jArr[i5] = jO1 + bVar2.f2984a.f18158a;
                }
                iArr[i5] = iE2;
                if (((iO3 >> 16) & 1) == 0 || (z8 && i5 != 0)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                zArr[i5] = z2;
                j4 += (long) iE;
                i5++;
                bVar2 = bVar;
                z4 = z4;
                z3 = z3;
                z7 = z7;
                z5 = z5;
                z6 = z6;
            }
            aa9Var.d = j4;
            return i4;
        }
        j = 0;
        j2 = j;
        iArr = aa9Var.f15231b;
        jArr = aa9Var.f15232b;
        zArr = aa9Var.f15228a;
        int i7 = iO5;
        if (track.b == 2) {
            z = false;
        } else {
            z = false;
        }
        i4 = i3 + aa9Var.f15226a[i];
        boolean z9 = z;
        j3 = track.f3008a;
        j4 = aa9Var.d;
        i5 = i3;
        while (i5 < i4) {
            if (z4) {
                iO = om6Var.o();
            } else {
                iO = vh2Var.b;
            }
            int iE3 = e(iO);
            if (z5) {
                iO2 = om6Var.o();
            } else {
                iO2 = vh2Var.c;
            }
            int iE4 = e(iO2);
            if (z6) {
                iO3 = om6Var.o();
            } else if (i5 == 0) {
                iO3 = vh2Var.d;
            } else {
                iO3 = vh2Var.d;
            }
            if (z7) {
                iO4 = om6Var.o();
            } else {
                iO4 = 0;
            }
            jO1 = gj9.o1((((long) iO4) + j4) - j2, 1000000L, j3);
            jArr[i5] = jO1;
            if (!aa9Var.f15234c) {
                jArr[i5] = jO1 + bVar2.f2984a.f18158a;
            }
            iArr[i5] = iE4;
            if (((iO3 >> 16) & 1) == 0) {
                z2 = false;
            } else {
                z2 = false;
            }
            zArr[i5] = z2;
            j4 += (long) iE3;
            i5++;
            bVar2 = bVar;
            z4 = z4;
            z3 = z3;
            z7 = z7;
            z5 = z5;
            z6 = z6;
        }
        aa9Var.d = j4;
        return i4;
    }

    public static void E(Atom.a aVar, b bVar, int i) throws ParserException {
        List<Atom.b> list = aVar.f2939a;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Atom.b bVar2 = list.get(i4);
            if (((Atom) bVar2).f30669a == 1953658222) {
                om6 om6Var = bVar2.f30671a;
                om6Var.S(12);
                int iK = om6Var.K();
                if (iK > 0) {
                    i3 += iK;
                    i2++;
                }
            }
        }
        bVar.c = 0;
        bVar.b = 0;
        bVar.f30681a = 0;
        bVar.f2983a.e(i2, i3);
        int i5 = 0;
        int iD = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Atom.b bVar3 = list.get(i6);
            if (((Atom) bVar3).f30669a == 1953658222) {
                iD = D(bVar, i5, i, bVar3.f30671a, iD);
                i5++;
            }
        }
    }

    public static void F(om6 om6Var, aa9 aa9Var, byte[] bArr) throws ParserException {
        om6Var.S(8);
        om6Var.k(bArr, 0, 16);
        if (Arrays.equals(bArr, b)) {
            w(om6Var, 16, aa9Var);
        }
    }

    public static boolean L(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    public static boolean M(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    public static int e(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i, null);
    }

    @Nullable
    public static DrmInitData h(List<Atom.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.b bVar = list.get(i);
            if (((Atom) bVar).f30669a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrD = bVar.f30671a.d();
                UUID uuidF = c.f(bArrD);
                if (uuidF == null) {
                    Log.n(f2954a, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, "video/mp4", bArrD));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    @Nullable
    public static b i(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b bVarValueAt = sparseArray.valueAt(i);
            if ((bVarValueAt.f2987a || bVarValueAt.f30681a != bVarValueAt.f2984a.f43259a) && (!bVarValueAt.f2987a || bVarValueAt.c != bVarValueAt.f2983a.f40497a)) {
                long jD = bVarValueAt.d();
                if (jD < j) {
                    bVar = bVarValueAt;
                    j = jD;
                }
            }
        }
        return bVar;
    }

    public static /* synthetic */ Extractor[] k() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    public static long r(om6 om6Var) {
        om6Var.S(8);
        return Atom.c(om6Var.o()) == 0 ? om6Var.I() : om6Var.L();
    }

    public static void s(Atom.a aVar, SparseArray<b> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        int size = aVar.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom.a aVar2 = aVar.b.get(i2);
            if (((Atom) aVar2).f30669a == 1953653094) {
                B(aVar2, sparseArray, z, i, bArr);
            }
        }
    }

    public static void t(om6 om6Var, aa9 aa9Var) throws ParserException {
        om6Var.S(8);
        int iO = om6Var.o();
        if ((Atom.b(iO) & 1) == 1) {
            om6Var.T(8);
        }
        int iK = om6Var.K();
        if (iK == 1) {
            aa9Var.c += Atom.c(iO) == 0 ? om6Var.I() : om6Var.L();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + iK, null);
        }
    }

    public static void u(z99 z99Var, om6 om6Var, aa9 aa9Var) throws ParserException {
        int i;
        int i2 = z99Var.f46220a;
        om6Var.S(8);
        if ((Atom.b(om6Var.o()) & 1) == 1) {
            om6Var.T(8);
        }
        int iG = om6Var.G();
        int iK = om6Var.K();
        if (iK > aa9Var.b) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + iK + " is greater than fragment sample count" + aa9Var.b, null);
        }
        if (iG == 0) {
            boolean[] zArr = aa9Var.f15233b;
            i = 0;
            for (int i3 = 0; i3 < iK; i3++) {
                int iG2 = om6Var.G();
                i += iG2;
                zArr[i3] = iG2 > i2;
            }
        } else {
            i = (iG * iK) + 0;
            Arrays.fill(aa9Var.f15233b, 0, iK, iG > i2);
        }
        Arrays.fill(aa9Var.f15233b, iK, aa9Var.b, false);
        if (i > 0) {
            aa9Var.d(i);
        }
    }

    public static void v(Atom.a aVar, @Nullable String str, aa9 aa9Var) throws ParserException {
        byte[] bArr = null;
        om6 om6Var = null;
        om6 om6Var2 = null;
        for (int i = 0; i < aVar.f2939a.size(); i++) {
            Atom.b bVar = aVar.f2939a.get(i);
            om6 om6Var3 = bVar.f30671a;
            int i2 = ((Atom) bVar).f30669a;
            if (i2 == 1935828848) {
                om6Var3.S(12);
                if (om6Var3.o() == 1936025959) {
                    om6Var = om6Var3;
                }
            } else if (i2 == 1936158820) {
                om6Var3.S(12);
                if (om6Var3.o() == 1936025959) {
                    om6Var2 = om6Var3;
                }
            }
        }
        if (om6Var == null || om6Var2 == null) {
            return;
        }
        om6Var.S(8);
        int iC = Atom.c(om6Var.o());
        om6Var.T(4);
        if (iC == 1) {
            om6Var.T(4);
        }
        if (om6Var.o() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        om6Var2.S(8);
        int iC2 = Atom.c(om6Var2.o());
        om6Var2.T(4);
        if (iC2 == 1) {
            if (om6Var2.I() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            om6Var2.T(4);
        }
        if (om6Var2.I() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        om6Var2.T(1);
        int iG = om6Var2.G();
        int i3 = (iG & 240) >> 4;
        int i4 = iG & 15;
        boolean z = om6Var2.G() == 1;
        if (z) {
            int iG2 = om6Var2.G();
            byte[] bArr2 = new byte[16];
            om6Var2.k(bArr2, 0, 16);
            if (iG2 == 0) {
                int iG3 = om6Var2.G();
                bArr = new byte[iG3];
                om6Var2.k(bArr, 0, iG3);
            }
            aa9Var.f15225a = true;
            aa9Var.f15224a = new z99(z, str, iG2, bArr2, i3, i4, bArr);
        }
    }

    public static void w(om6 om6Var, int i, aa9 aa9Var) throws ParserException {
        om6Var.S(i + 8);
        int iB = Atom.b(om6Var.o());
        if ((iB & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iK = om6Var.K();
        if (iK == 0) {
            Arrays.fill(aa9Var.f15233b, 0, aa9Var.b, false);
            return;
        }
        if (iK == aa9Var.b) {
            Arrays.fill(aa9Var.f15233b, 0, iK, z);
            aa9Var.d(om6Var.a());
            aa9Var.b(om6Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + iK + " is different from fragment sample count" + aa9Var.b, null);
        }
    }

    public static void x(om6 om6Var, aa9 aa9Var) throws ParserException {
        w(om6Var, 0, aa9Var);
    }

    public static Pair<Long, com.google.android.exoplayer2.extractor.b> y(om6 om6Var, long j) throws ParserException {
        long jL;
        long jL2;
        om6Var.S(8);
        int iC = Atom.c(om6Var.o());
        om6Var.T(4);
        long jI = om6Var.I();
        if (iC == 0) {
            jL = om6Var.I();
            jL2 = om6Var.I();
        } else {
            jL = om6Var.L();
            jL2 = om6Var.L();
        }
        long j2 = jL;
        long j3 = j + jL2;
        long jO1 = gj9.o1(j2, 1000000L, jI);
        om6Var.T(2);
        int iM = om6Var.M();
        int[] iArr = new int[iM];
        long[] jArr = new long[iM];
        long[] jArr2 = new long[iM];
        long[] jArr3 = new long[iM];
        long j4 = jO1;
        int i = 0;
        long j5 = j2;
        while (i < iM) {
            int iO = om6Var.o();
            if ((iO & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long jI2 = om6Var.I();
            iArr[i] = iO & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + jI2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = iM;
            int[] iArr2 = iArr;
            long jO2 = gj9.o1(j6, 1000000L, jI);
            jArr4[i] = jO2 - jArr5[i];
            om6Var.T(4);
            j3 += (long) iArr2[i];
            i++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iM = i2;
            j5 = j6;
            j4 = jO2;
        }
        return Pair.create(Long.valueOf(jO1), new com.google.android.exoplayer2.extractor.b(iArr, jArr, jArr2, jArr3));
    }

    public static long z(om6 om6Var) {
        om6Var.S(8);
        return Atom.c(om6Var.o()) == 1 ? om6Var.L() : om6Var.I();
    }

    public final void G(long j) throws ParserException {
        while (!this.f2964a.isEmpty() && this.f2964a.peek().f30670a == j) {
            l(this.f2964a.pop());
        }
        f();
    }

    public final boolean H(ExtractorInput extractorInput) throws IOException {
        if (this.g == 0) {
            if (!extractorInput.readFully(this.f2978e.d(), 0, 8, true)) {
                return false;
            }
            this.g = 8;
            this.f2978e.S(0);
            this.f2955a = this.f2978e.I();
            this.f = this.f2978e.o();
        }
        long j = this.f2955a;
        if (j == 1) {
            extractorInput.readFully(this.f2978e.d(), 8, 8);
            this.g += 8;
            this.f2955a = this.f2978e.L();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.f2964a.isEmpty()) {
                length = this.f2964a.peek().f30670a;
            }
            if (length != -1) {
                this.f2955a = (length - extractorInput.getPosition()) + ((long) this.g);
            }
        }
        if (this.f2955a < this.g) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = extractorInput.getPosition() - ((long) this.g);
        int i = this.f;
        if ((i == 1836019558 || i == 1835295092) && !this.f2972b) {
            this.f2957a.d(new SeekMap.b(this.f2975d, position));
            this.f2972b = true;
        }
        if (this.f == 1836019558) {
            int size = this.f2956a.size();
            for (int i2 = 0; i2 < size; i2++) {
                aa9 aa9Var = this.f2956a.valueAt(i2).f2983a;
                aa9Var.f15221a = position;
                aa9Var.c = position;
                aa9Var.f15229b = position;
            }
        }
        int i3 = this.f;
        if (i3 == 1835295092) {
            this.f2959a = null;
            this.f2969b = position + this.f2955a;
            this.e = 2;
            return true;
        }
        if (L(i3)) {
            long position2 = (extractorInput.getPosition() + this.f2955a) - 8;
            this.f2964a.push(new Atom.a(this.f, position2));
            if (this.f2955a == this.g) {
                G(position2);
            } else {
                f();
            }
        } else if (M(this.f)) {
            if (this.g != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            long j2 = this.f2955a;
            if (j2 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            om6 om6Var = new om6((int) j2);
            System.arraycopy(this.f2978e.d(), 0, om6Var.d(), 0, 8);
            this.f2979f = om6Var;
            this.e = 1;
        } else {
            if (this.f2955a > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f2979f = null;
            this.e = 1;
        }
        return true;
    }

    public final void I(ExtractorInput extractorInput) throws IOException {
        int i = ((int) this.f2955a) - this.g;
        om6 om6Var = this.f2979f;
        if (om6Var != null) {
            extractorInput.readFully(om6Var.d(), 8, i);
            n(new Atom.b(this.f, om6Var), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i);
        }
        G(extractorInput.getPosition());
    }

    public final void J(ExtractorInput extractorInput) throws IOException {
        int size = this.f2956a.size();
        long j = Long.MAX_VALUE;
        b bVarValueAt = null;
        for (int i = 0; i < size; i++) {
            aa9 aa9Var = this.f2956a.valueAt(i).f2983a;
            if (aa9Var.f15230b) {
                long j2 = aa9Var.c;
                if (j2 < j) {
                    bVarValueAt = this.f2956a.valueAt(i);
                    j = j2;
                }
            }
        }
        if (bVarValueAt == null) {
            this.e = 3;
            return;
        }
        int position = (int) (j - extractorInput.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        extractorInput.skipFully(position);
        bVarValueAt.f2983a.a(extractorInput);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean K(ExtractorInput extractorInput) throws IOException {
        int iB;
        b bVarI = this.f2959a;
        Throwable th = null;
        if (bVarI == null) {
            bVarI = i(this.f2956a);
            if (bVarI == null) {
                int position = (int) (this.f2969b - extractorInput.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                }
                extractorInput.skipFully(position);
                f();
                return false;
            }
            int iD = (int) (bVarI.d() - extractorInput.getPosition());
            if (iD < 0) {
                Log.n(f2954a, "Ignoring negative offset to sample data.");
                iD = 0;
            }
            extractorInput.skipFully(iD);
            this.f2959a = bVarI;
        }
        int i = 4;
        int i2 = 1;
        if (this.e == 3) {
            int iF = bVarI.f();
            this.i = iF;
            if (bVarI.f30681a < bVarI.d) {
                extractorInput.skipFully(iF);
                bVarI.m();
                if (!bVarI.h()) {
                    this.f2959a = null;
                }
                this.e = 3;
                return true;
            }
            if (bVarI.f2984a.f18159a.c == 1) {
                this.i = iF - 8;
                extractorInput.skipFully(8);
            }
            if ("audio/ac4".equals(bVarI.f2984a.f18159a.f3009a.k)) {
                this.j = bVarI.i(this.i, 7);
                mr.a(this.i, this.f2976d);
                bVarI.f2982a.c(this.f2976d, 7);
                this.j += 7;
            } else {
                this.j = bVarI.i(this.i, 0);
            }
            this.i += this.j;
            this.e = 4;
            this.k = 0;
        }
        Track track = bVarI.f2984a.f18159a;
        TrackOutput trackOutput = bVarI.f2982a;
        long jE = bVarI.e();
        g89 g89Var = this.f2961a;
        if (g89Var != null) {
            jE = g89Var.a(jE);
        }
        long j = jE;
        if (track.d == 0) {
            while (true) {
                int i3 = this.j;
                int i4 = this.i;
                if (i3 >= i4) {
                    break;
                }
                this.j += trackOutput.b(extractorInput, i4 - i3, false);
            }
        } else {
            byte[] bArrD = this.f2970b.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i5 = track.d;
            int i6 = i5 + 1;
            int i7 = 4 - i5;
            while (this.j < this.i) {
                int i8 = this.k;
                if (i8 == 0) {
                    extractorInput.readFully(bArrD, i7, i6);
                    this.f2970b.S(0);
                    int iO = this.f2970b.o();
                    if (iO < i2) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th);
                    }
                    this.k = iO - 1;
                    this.f2963a.S(0);
                    trackOutput.c(this.f2963a, i);
                    trackOutput.c(this.f2970b, i2);
                    this.f2966a = (this.f2973b.length <= 0 || !kw5.g(track.f3009a.k, bArrD[i])) ? 0 : i2;
                    this.j += 5;
                    this.i += i7;
                } else {
                    if (this.f2966a) {
                        this.f2974c.O(i8);
                        extractorInput.readFully(this.f2974c.d(), 0, this.k);
                        trackOutput.c(this.f2974c, this.k);
                        iB = this.k;
                        int iQ = kw5.q(this.f2974c.d(), this.f2974c.f());
                        this.f2974c.S("video/hevc".equals(track.f3009a.k) ? 1 : 0);
                        this.f2974c.R(iQ);
                        com.google.android.exoplayer2.extractor.a.a(j, this.f2974c, this.f2973b);
                    } else {
                        iB = trackOutput.b(extractorInput, i8, false);
                    }
                    this.j += iB;
                    this.k -= iB;
                    th = null;
                    i = 4;
                    i2 = 1;
                }
            }
        }
        int iC = bVarI.c();
        z99 z99VarG = bVarI.g();
        trackOutput.e(j, iC, this.i, 0, z99VarG != null ? z99VarG.f21009a : null);
        q(j);
        if (!bVarI.h()) {
            this.f2959a = null;
        }
        this.e = 3;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f2957a = extractorOutput;
        f();
        j();
        Track track = this.f2960a;
        if (track != null) {
            this.f2956a.put(0, new b(extractorOutput.b(0, track.b), new ma9(this.f2960a, new long[0], new int[0], 0, new long[0], new int[0], 0L), new vh2(0, 0, 0, 0)));
            this.f2957a.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        while (true) {
            int i = this.e;
            if (i != 0) {
                if (i == 1) {
                    I(extractorInput);
                } else if (i == 2) {
                    J(extractorInput);
                } else if (K(extractorInput)) {
                    return 0;
                }
            } else if (!H(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        return bl8.b(extractorInput);
    }

    public final void f() {
        this.e = 0;
        this.g = 0;
    }

    public final vh2 g(SparseArray<vh2> sparseArray, int i) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (vh2) sb0.g(sparseArray.get(i));
    }

    public final void j() {
        int i;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.f2968a = trackOutputArr;
        TrackOutput trackOutput = this.f2958a;
        int i2 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.d & 4) != 0) {
            trackOutputArr[i] = this.f2957a.b(100, 5);
            i3 = 101;
            i++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) gj9.e1(this.f2968a, i);
        this.f2968a = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.f(f30679a);
        }
        this.f2973b = new TrackOutput[this.f2965a.size()];
        while (i2 < this.f2973b.length) {
            TrackOutput trackOutputB = this.f2957a.b(i3, 3);
            trackOutputB.f(this.f2965a.get(i2));
            this.f2973b[i2] = trackOutputB;
            i2++;
            i3++;
        }
    }

    public final void l(Atom.a aVar) throws ParserException {
        int i = ((Atom) aVar).f30669a;
        if (i == 1836019574) {
            p(aVar);
        } else if (i == 1836019558) {
            o(aVar);
        } else {
            if (this.f2964a.isEmpty()) {
                return;
            }
            this.f2964a.peek().d(aVar);
        }
    }

    public final void m(om6 om6Var) {
        long jO1;
        String str;
        long jO2;
        String str2;
        long jI;
        long jA;
        if (this.f2968a.length == 0) {
            return;
        }
        om6Var.S(8);
        int iC = Atom.c(om6Var.o());
        if (iC == 0) {
            String str3 = (String) sb0.g(om6Var.A());
            String str4 = (String) sb0.g(om6Var.A());
            long jI2 = om6Var.I();
            jO1 = gj9.o1(om6Var.I(), 1000000L, jI2);
            long j = this.f2977e;
            long j2 = j != -9223372036854775807L ? j + jO1 : -9223372036854775807L;
            str = str3;
            jO2 = gj9.o1(om6Var.I(), 1000L, jI2);
            str2 = str4;
            jI = om6Var.I();
            jA = j2;
        } else {
            if (iC != 1) {
                Log.n(f2954a, "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jI3 = om6Var.I();
            jA = gj9.o1(om6Var.L(), 1000000L, jI3);
            long jO3 = gj9.o1(om6Var.I(), 1000L, jI3);
            long jI4 = om6Var.I();
            str = (String) sb0.g(om6Var.A());
            jO2 = jO3;
            jI = jI4;
            str2 = (String) sb0.g(om6Var.A());
            jO1 = -9223372036854775807L;
        }
        byte[] bArr = new byte[om6Var.a()];
        om6Var.k(bArr, 0, om6Var.a());
        om6 om6Var2 = new om6(this.f2962a.a(new EventMessage(str, str2, jO2, jI, bArr)));
        int iA = om6Var2.a();
        for (TrackOutput trackOutput : this.f2968a) {
            om6Var2.S(0);
            trackOutput.c(om6Var2, iA);
        }
        if (jA == -9223372036854775807L) {
            this.f2971b.addLast(new a(jO1, true, iA));
            this.h += iA;
            return;
        }
        if (!this.f2971b.isEmpty()) {
            this.f2971b.addLast(new a(jA, false, iA));
            this.h += iA;
            return;
        }
        g89 g89Var = this.f2961a;
        if (g89Var != null) {
            jA = g89Var.a(jA);
        }
        for (TrackOutput trackOutput2 : this.f2968a) {
            trackOutput2.e(jA, 1, iA, 0, null);
        }
    }

    @Nullable
    public Track modifyTrack(@Nullable Track track) {
        return track;
    }

    public final void n(Atom.b bVar, long j) throws ParserException {
        if (!this.f2964a.isEmpty()) {
            this.f2964a.peek().e(bVar);
            return;
        }
        int i = ((Atom) bVar).f30669a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                m(bVar.f30671a);
            }
        } else {
            Pair<Long, com.google.android.exoplayer2.extractor.b> pairY = y(bVar.f30671a, j);
            this.f2977e = ((Long) pairY.first).longValue();
            this.f2957a.d((SeekMap) pairY.second);
            this.f2972b = true;
        }
    }

    public final void o(Atom.a aVar) throws ParserException {
        s(aVar, this.f2956a, this.f2960a != null, this.d, this.f2967a);
        DrmInitData drmInitDataH = h(aVar.f2939a);
        if (drmInitDataH != null) {
            int size = this.f2956a.size();
            for (int i = 0; i < size; i++) {
                this.f2956a.valueAt(i).n(drmInitDataH);
            }
        }
        if (this.c != -9223372036854775807L) {
            int size2 = this.f2956a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f2956a.valueAt(i2).l(this.c);
            }
            this.c = -9223372036854775807L;
        }
    }

    public final void p(Atom.a aVar) throws ParserException {
        int i = 0;
        sb0.j(this.f2960a == null, "Unexpected moov box.");
        DrmInitData drmInitDataH = h(aVar.f2939a);
        Atom.a aVar2 = (Atom.a) sb0.g(aVar.g(1836475768));
        SparseArray<vh2> sparseArray = new SparseArray<>();
        int size = aVar2.f2939a.size();
        long jR = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.b bVar = aVar2.f2939a.get(i2);
            int i3 = ((Atom) bVar).f30669a;
            if (i3 == 1953654136) {
                Pair<Integer, vh2> pairC = C(bVar.f30671a);
                sparseArray.put(((Integer) pairC.first).intValue(), (vh2) pairC.second);
            } else if (i3 == 1835362404) {
                jR = r(bVar.f30671a);
            }
        }
        List<ma9> listA = AtomParsers.A(aVar, new cs3(), jR, drmInitDataH, (this.d & 16) != 0, false, new Function() { // from class: com.zj.adlib.zl3
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.f46287a.modifyTrack((Track) obj);
            }
        });
        int size2 = listA.size();
        if (this.f2956a.size() != 0) {
            sb0.i(this.f2956a.size() == size2);
            while (i < size2) {
                ma9 ma9Var = listA.get(i);
                Track track = ma9Var.f18159a;
                this.f2956a.get(track.f30684a).j(ma9Var, g(sparseArray, track.f30684a));
                i++;
            }
            return;
        }
        while (i < size2) {
            ma9 ma9Var2 = listA.get(i);
            Track track2 = ma9Var2.f18159a;
            this.f2956a.put(track2.f30684a, new b(this.f2957a.b(i, track2.b), ma9Var2, g(sparseArray, track2.f30684a)));
            this.f2975d = Math.max(this.f2975d, track2.f3014c);
            i++;
        }
        this.f2957a.endTracks();
    }

    public final void q(long j) {
        while (!this.f2971b.isEmpty()) {
            a aVarRemoveFirst = this.f2971b.removeFirst();
            this.h -= aVarRemoveFirst.f30680a;
            long jA = aVarRemoveFirst.f2980a;
            if (aVarRemoveFirst.f2981a) {
                jA += j;
            }
            g89 g89Var = this.f2961a;
            if (g89Var != null) {
                jA = g89Var.a(jA);
            }
            for (TrackOutput trackOutput : this.f2968a) {
                trackOutput.e(jA, 1, aVarRemoveFirst.f30680a, this.h, null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        int size = this.f2956a.size();
        for (int i = 0; i < size; i++) {
            this.f2956a.valueAt(i).k();
        }
        this.f2971b.clear();
        this.h = 0;
        this.c = j2;
        this.f2964a.clear();
        f();
    }

    public FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    public FragmentedMp4Extractor(int i, @Nullable g89 g89Var) {
        this(i, g89Var, null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, @Nullable g89 g89Var, @Nullable Track track) {
        this(i, g89Var, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, @Nullable g89 g89Var, @Nullable Track track, List<d> list) {
        this(i, g89Var, track, list, null);
    }

    public FragmentedMp4Extractor(int i, @Nullable g89 g89Var, @Nullable Track track, List<d> list, @Nullable TrackOutput trackOutput) {
        this.d = i;
        this.f2961a = g89Var;
        this.f2960a = track;
        this.f2965a = Collections.unmodifiableList(list);
        this.f2958a = trackOutput;
        this.f2962a = new n53();
        this.f2978e = new om6(16);
        this.f2963a = new om6(kw5.f17801a);
        this.f2970b = new om6(5);
        this.f2974c = new om6();
        byte[] bArr = new byte[16];
        this.f2967a = bArr;
        this.f2976d = new om6(bArr);
        this.f2964a = new ArrayDeque<>();
        this.f2971b = new ArrayDeque<>();
        this.f2956a = new SparseArray<>();
        this.f2975d = -9223372036854775807L;
        this.c = -9223372036854775807L;
        this.f2977e = -9223372036854775807L;
        this.f2957a = ExtractorOutput.f30621a;
        this.f2968a = new TrackOutput[0];
        this.f2973b = new TrackOutput[0];
    }
}
