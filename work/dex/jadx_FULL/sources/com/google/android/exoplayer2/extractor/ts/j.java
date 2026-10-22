package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.en1;
import com.zj.adlib.gj9;
import com.zj.adlib.jw5;
import com.zj.adlib.kw5;
import com.zj.adlib.om6;
import com.zj.adlib.pm6;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f3191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final s f3192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3196a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3199b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3200c;
    public boolean d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f3197a = new boolean[3];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jw5 f3193a = new jw5(7, 128);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final jw5 f3198b = new jw5(8, 128);
    public final jw5 c = new jw5(6, 128);
    public long b = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3194a = new om6();

    public static final class b {
        public static final int c = 128;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30722a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3201a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f3203a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public a f3204a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final pm6 f3205a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3206a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f3207a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f3208b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public a f3210b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f3211b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public long f3212c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f3213c;
        public long d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f3214d;
        public boolean e;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<kw5.c> f3202a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final SparseArray<kw5.b> f3209b = new SparseArray<>();

        public static final class a {
            public static final int j = 2;
            public static final int k = 7;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f30723a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public kw5.c f3215a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f3216a;
            public int b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            public boolean f3217b;
            public int c;

            /* JADX INFO: renamed from: c, reason: collision with other field name */
            public boolean f3218c;
            public int d;

            /* JADX INFO: renamed from: d, reason: collision with other field name */
            public boolean f3219d;
            public int e;

            /* JADX INFO: renamed from: e, reason: collision with other field name */
            public boolean f3220e;
            public int f;

            /* JADX INFO: renamed from: f, reason: collision with other field name */
            public boolean f3221f;
            public int g;
            public int h;
            public int i;

            public a() {
            }

            public void b() {
                this.f3217b = false;
                this.f3216a = false;
            }

            public final boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.f3216a) {
                    return false;
                }
                if (!aVar.f3216a) {
                    return true;
                }
                kw5.c cVar = (kw5.c) sb0.k(this.f3215a);
                kw5.c cVar2 = (kw5.c) sb0.k(aVar.f3215a);
                return (this.c == aVar.c && this.d == aVar.d && this.f3218c == aVar.f3218c && (!this.f3219d || !aVar.f3219d || this.f3220e == aVar.f3220e) && (((i = this.f30723a) == (i2 = aVar.f30723a) || (i != 0 && i2 != 0)) && (((i3 = cVar.i) != 0 || cVar2.i != 0 || (this.f == aVar.f && this.g == aVar.g)) && ((i3 != 1 || cVar2.i != 1 || (this.h == aVar.h && this.i == aVar.i)) && (z = this.f3221f) == aVar.f3221f && (!z || this.e == aVar.e))))) ? false : true;
            }

            public boolean d() {
                int i;
                return this.f3217b && ((i = this.b) == 7 || i == 2);
            }

            public void e(kw5.c cVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f3215a = cVar;
                this.f30723a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
                this.f3218c = z;
                this.f3219d = z2;
                this.f3220e = z3;
                this.f3221f = z4;
                this.e = i5;
                this.f = i6;
                this.g = i7;
                this.h = i8;
                this.i = i9;
                this.f3216a = true;
                this.f3217b = true;
            }

            public void f(int i) {
                this.b = i;
                this.f3217b = true;
            }
        }

        public b(TrackOutput trackOutput, boolean z, boolean z2) {
            this.f3203a = trackOutput;
            this.f3206a = z;
            this.f3211b = z2;
            this.f3204a = new a();
            this.f3210b = new a();
            byte[] bArr = new byte[128];
            this.f3207a = bArr;
            this.f3205a = new pm6(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:54:0x0102  */
        /* JADX WARN: Code duplicated, block: B:56:0x0106  */
        /* JADX WARN: Code duplicated, block: B:58:0x010e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x010f  */
        /* JADX WARN: Code duplicated, block: B:60:0x0118  */
        /* JADX WARN: Code duplicated, block: B:63:0x011e  */
        /* JADX WARN: Code duplicated, block: B:65:0x0128 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x0129  */
        /* JADX WARN: Code duplicated, block: B:74:0x0152  */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean zD;
            boolean z3;
            int iH;
            int i3;
            int i4;
            int iG;
            int i5;
            int iG2;
            int iE;
            if (this.f3213c) {
                int i6 = i2 - i;
                byte[] bArr2 = this.f3207a;
                int length = bArr2.length;
                int i7 = this.f30722a;
                if (length < i7 + i6) {
                    this.f3207a = Arrays.copyOf(bArr2, (i7 + i6) * 2);
                }
                System.arraycopy(bArr, i, this.f3207a, this.f30722a, i6);
                int i8 = this.f30722a + i6;
                this.f30722a = i8;
                this.f3205a.i(this.f3207a, 0, i8);
                if (this.f3205a.b(8)) {
                    this.f3205a.k();
                    int iE2 = this.f3205a.e(2);
                    this.f3205a.l(5);
                    if (this.f3205a.c()) {
                        this.f3205a.h();
                        if (this.f3205a.c()) {
                            int iH2 = this.f3205a.h();
                            if (!this.f3211b) {
                                this.f3213c = false;
                                this.f3210b.f(iH2);
                                return;
                            }
                            if (this.f3205a.c()) {
                                int iH3 = this.f3205a.h();
                                if (this.f3209b.indexOfKey(iH3) < 0) {
                                    this.f3213c = false;
                                    return;
                                }
                                kw5.b bVar = this.f3209b.get(iH3);
                                kw5.c cVar = this.f3202a.get(bVar.b);
                                if (cVar.f17809a) {
                                    if (!this.f3205a.b(2)) {
                                        return;
                                    } else {
                                        this.f3205a.l(2);
                                    }
                                }
                                if (this.f3205a.b(cVar.h)) {
                                    int iE3 = this.f3205a.e(cVar.h);
                                    if (!cVar.f17810b) {
                                        if (this.f3205a.b(1)) {
                                            boolean zD2 = this.f3205a.d();
                                            if (!zD2) {
                                                z = zD2;
                                                z2 = false;
                                            } else {
                                                if (!this.f3205a.b(1)) {
                                                    return;
                                                }
                                                z = zD2;
                                                z2 = true;
                                                zD = this.f3205a.d();
                                            }
                                            if (this.b == 5) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                iH = 0;
                                            } else if (!this.f3205a.c()) {
                                                return;
                                            } else {
                                                iH = this.f3205a.h();
                                            }
                                            i3 = cVar.i;
                                            if (i3 != 0) {
                                                if (this.f3205a.b(cVar.j)) {
                                                    iE = this.f3205a.e(cVar.j);
                                                    if (bVar.f17807a || z) {
                                                        i4 = iE;
                                                        iG = 0;
                                                    } else {
                                                        if (!this.f3205a.c()) {
                                                            return;
                                                        }
                                                        iG = this.f3205a.g();
                                                        i4 = iE;
                                                        i5 = 0;
                                                    }
                                                    iG2 = i5;
                                                    this.f3210b.e(cVar, iE2, iH2, iE3, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                                    this.f3213c = false;
                                                }
                                                return;
                                            }
                                            if (i3 == 1 || cVar.f17811c) {
                                                i4 = 0;
                                                iG = 0;
                                            } else {
                                                if (!this.f3205a.c()) {
                                                    return;
                                                }
                                                int iG3 = this.f3205a.g();
                                                if (!bVar.f17807a || z) {
                                                    i5 = iG3;
                                                    i4 = 0;
                                                    iG = 0;
                                                    iG2 = 0;
                                                } else {
                                                    if (!this.f3205a.c()) {
                                                        return;
                                                    }
                                                    iG2 = this.f3205a.g();
                                                    i5 = iG3;
                                                    i4 = 0;
                                                    iG = 0;
                                                }
                                            }
                                            this.f3210b.e(cVar, iE2, iH2, iE3, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                            this.f3213c = false;
                                            i5 = iG;
                                            iG2 = i5;
                                            this.f3210b.e(cVar, iE2, iH2, iE3, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                            this.f3213c = false;
                                        }
                                        return;
                                    }
                                    z = false;
                                    z2 = false;
                                    zD = z2;
                                    if (this.b == 5) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        iH = 0;
                                    } else if (!this.f3205a.c()) {
                                        return;
                                    } else {
                                        iH = this.f3205a.h();
                                    }
                                    i3 = cVar.i;
                                    if (i3 != 0) {
                                        if (i3 == 1) {
                                        }
                                        i4 = 0;
                                        iG = 0;
                                    } else {
                                        if (this.f3205a.b(cVar.j)) {
                                            return;
                                        }
                                        iE = this.f3205a.e(cVar.j);
                                        if (bVar.f17807a) {
                                        }
                                        i4 = iE;
                                        iG = 0;
                                    }
                                    i5 = iG;
                                    iG2 = i5;
                                    this.f3210b.e(cVar, iE2, iH2, iE3, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                    this.f3213c = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.b == 9 || (this.f3211b && this.f3210b.c(this.f3204a))) {
                if (z && this.f3214d) {
                    d(i + ((int) (j - this.f3201a)));
                }
                this.f3212c = this.f3201a;
                this.d = this.f3208b;
                this.e = false;
                this.f3214d = true;
            }
            if (this.f3206a) {
                z2 = this.f3210b.d();
            }
            boolean z4 = this.e;
            int i2 = this.b;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.e = z5;
            return z5;
        }

        public boolean c() {
            return this.f3211b;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void d(int i) {
            long j = this.d;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.e;
            this.f3203a.e(j, z ? 1 : 0, (int) (this.f3201a - this.f3212c), i, null);
        }

        public void e(kw5.b bVar) {
            this.f3209b.append(bVar.f42929a, bVar);
        }

        public void f(kw5.c cVar) {
            this.f3202a.append(cVar.d, cVar);
        }

        public void g() {
            this.f3213c = false;
            this.f3214d = false;
            this.f3210b.b();
        }

        public void h(long j, int i, long j2) {
            this.b = i;
            this.f3208b = j2;
            this.f3201a = j;
            if (!this.f3206a || i != 1) {
                if (!this.f3211b) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.f3204a;
            this.f3204a = this.f3210b;
            this.f3210b = aVar;
            aVar.b();
            this.f30722a = 0;
            this.f3213c = true;
        }
    }

    public j(s sVar, boolean z, boolean z2) {
        this.f3192a = sVar;
        this.f3196a = z;
        this.f3199b = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        c();
        int iE = om6Var.e();
        int iF = om6Var.f();
        byte[] bArrD = om6Var.d();
        this.f30721a += (long) om6Var.a();
        this.f3190a.c(om6Var, om6Var.a());
        while (true) {
            int iC = kw5.c(bArrD, iE, iF, this.f3197a);
            if (iC == iF) {
                e(bArrD, iE, iF);
                return;
            }
            int iF2 = kw5.f(bArrD, iC);
            int i = iC - iE;
            if (i > 0) {
                e(bArrD, iE, iC);
            }
            int i2 = iF - iC;
            long j = this.f30721a - ((long) i2);
            d(j, i2, i < 0 ? -i : 0, this.b);
            f(j, iF2, this.b);
            iE = iC + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3195a = cVar.b();
        TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 2);
        this.f3190a = trackOutputB;
        this.f3191a = new b(trackOutputB, this.f3196a, this.f3199b);
        this.f3192a.b(extractorOutput, cVar);
    }

    @EnsuresNonNull({com.alibaba.ariver.remotedebug.b.c.g, "sampleReader"})
    public final void c() {
        sb0.k(this.f3190a);
        gj9.k(this.f3191a);
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g, "sampleReader"})
    public final void d(long j, int i, int i2, long j2) {
        if (!this.f3200c || this.f3191a.c()) {
            this.f3193a.b(i2);
            this.f3198b.b(i2);
            if (this.f3200c) {
                if (this.f3193a.c()) {
                    jw5 jw5Var = this.f3193a;
                    this.f3191a.f(kw5.l(jw5Var.f17516a, 3, jw5Var.b));
                    this.f3193a.d();
                } else if (this.f3198b.c()) {
                    jw5 jw5Var2 = this.f3198b;
                    this.f3191a.e(kw5.j(jw5Var2.f17516a, 3, jw5Var2.b));
                    this.f3198b.d();
                }
            } else if (this.f3193a.c() && this.f3198b.c()) {
                ArrayList arrayList = new ArrayList();
                jw5 jw5Var3 = this.f3193a;
                arrayList.add(Arrays.copyOf(jw5Var3.f17516a, jw5Var3.b));
                jw5 jw5Var4 = this.f3198b;
                arrayList.add(Arrays.copyOf(jw5Var4.f17516a, jw5Var4.b));
                jw5 jw5Var5 = this.f3193a;
                kw5.c cVarL = kw5.l(jw5Var5.f17516a, 3, jw5Var5.b);
                jw5 jw5Var6 = this.f3198b;
                kw5.b bVarJ = kw5.j(jw5Var6.f17516a, 3, jw5Var6.b);
                this.f3190a.f(new com.google.android.exoplayer2.d.b().S(this.f3195a).e0("video/avc").I(en1.a(cVarL.f17808a, cVarL.b, cVarL.c)).j0(cVarL.f).Q(cVarL.g).a0(cVarL.f42930a).T(arrayList).E());
                this.f3200c = true;
                this.f3191a.f(cVarL);
                this.f3191a.e(bVarJ);
                this.f3193a.d();
                this.f3198b.d();
            }
        }
        if (this.c.b(i2)) {
            jw5 jw5Var7 = this.c;
            this.f3194a.Q(this.c.f17516a, kw5.q(jw5Var7.f17516a, jw5Var7.b));
            this.f3194a.S(4);
            this.f3192a.a(j2, this.f3194a);
        }
        if (this.f3191a.b(j, i, this.f3200c, this.d)) {
            this.d = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    public final void e(byte[] bArr, int i, int i2) {
        if (!this.f3200c || this.f3191a.c()) {
            this.f3193a.a(bArr, i, i2);
            this.f3198b.a(bArr, i, i2);
        }
        this.c.a(bArr, i, i2);
        this.f3191a.a(bArr, i, i2);
    }

    @RequiresNonNull({"sampleReader"})
    public final void f(long j, int i, long j2) {
        if (!this.f3200c || this.f3191a.c()) {
            this.f3193a.e(i);
            this.f3198b.e(i);
        }
        this.c.e(i);
        this.f3191a.h(j, i, j2);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.b = j;
        }
        this.d |= (i & 2) != 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f30721a = 0L;
        this.d = false;
        this.b = -9223372036854775807L;
        kw5.a(this.f3197a);
        this.f3193a.d();
        this.f3198b.d();
        this.c.d();
        b bVar = this.f3191a;
        if (bVar != null) {
            bVar.g();
        }
    }
}
