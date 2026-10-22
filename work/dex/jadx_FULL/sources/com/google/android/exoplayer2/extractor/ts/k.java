package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.zj.adlib.en1;
import com.zj.adlib.gj9;
import com.zj.adlib.jw5;
import com.zj.adlib.kw5;
import com.zj.adlib.om6;
import com.zj.adlib.pm6;
import com.zj.adlib.sb0;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30724a = 9;
    public static final int b = 16;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f3222b = "H265Reader";
    public static final int c = 21;
    public static final int d = 32;
    public static final int e = 33;
    public static final int f = 34;
    public static final int g = 35;
    public static final int h = 39;
    public static final int i = 40;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f3225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final s f3226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f3231a = new boolean[3];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jw5 f3227a = new jw5(32, 128);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final jw5 f3233b = new jw5(33, 128);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final jw5 f3234c = new jw5(34, 128);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final jw5 f3235d = new jw5(39, 128);

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final jw5 f3236e = new jw5(40, 128);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3232b = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3228a = new om6();

    public static final class a {
        public static final int b = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30725a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3237a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f3238a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3239a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f3240b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f3241b;
        public long c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f3242c;
        public long d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f3243d;
        public boolean e;
        public boolean f;
        public boolean g;

        public a(TrackOutput trackOutput) {
            this.f3238a = trackOutput;
        }

        public static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        public static boolean c(int i) {
            return i < 32 || i == 40;
        }

        public void a(long j, int i, boolean z) {
            if (this.f && this.f3242c) {
                this.g = this.f3239a;
                this.f = false;
            } else if (this.f3243d || this.f3242c) {
                if (z && this.e) {
                    d(i + ((int) (j - this.f3237a)));
                }
                this.c = this.f3237a;
                this.d = this.f3240b;
                this.g = this.f3239a;
                this.e = true;
            }
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
            boolean z = this.g;
            this.f3238a.e(j, z ? 1 : 0, (int) (this.f3237a - this.c), i, null);
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f3241b) {
                int i3 = this.f30725a;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.f30725a = i3 + (i2 - i);
                } else {
                    this.f3242c = (bArr[i4] & UnsignedBytes.f32243a) != 0;
                    this.f3241b = false;
                }
            }
        }

        public void f() {
            this.f3241b = false;
            this.f3242c = false;
            this.f3243d = false;
            this.e = false;
            this.f = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.f3242c = false;
            this.f3243d = false;
            this.f3240b = j2;
            this.f30725a = 0;
            this.f3237a = j;
            if (!c(i2)) {
                if (this.e && !this.f) {
                    if (z) {
                        d(i);
                    }
                    this.e = false;
                }
                if (b(i2)) {
                    this.f3243d = !this.f;
                    this.f = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.f3239a = z2;
            this.f3241b = z2 || i2 <= 9;
        }
    }

    public k(s sVar) {
        this.f3226a = sVar;
    }

    public static com.google.android.exoplayer2.d f(@Nullable String str, jw5 jw5Var, jw5 jw5Var2, jw5 jw5Var3) {
        int i2 = jw5Var.b;
        byte[] bArr = new byte[jw5Var2.b + i2 + jw5Var3.b];
        System.arraycopy(jw5Var.f17516a, 0, bArr, 0, i2);
        System.arraycopy(jw5Var2.f17516a, 0, bArr, jw5Var.b, jw5Var2.b);
        System.arraycopy(jw5Var3.f17516a, 0, bArr, jw5Var.b + jw5Var2.b, jw5Var3.b);
        pm6 pm6Var = new pm6(jw5Var2.f17516a, 0, jw5Var2.b);
        pm6Var.l(44);
        int iE = pm6Var.e(3);
        pm6Var.k();
        int iE2 = pm6Var.e(2);
        boolean zD = pm6Var.d();
        int iE3 = pm6Var.e(5);
        int i3 = 0;
        for (int i4 = 0; i4 < 32; i4++) {
            if (pm6Var.d()) {
                i3 |= 1 << i4;
            }
        }
        int[] iArr = new int[6];
        for (int i5 = 0; i5 < 6; i5++) {
            iArr[i5] = pm6Var.e(8);
        }
        int iE4 = pm6Var.e(8);
        int i6 = 0;
        for (int i7 = 0; i7 < iE; i7++) {
            if (pm6Var.d()) {
                i6 += 89;
            }
            if (pm6Var.d()) {
                i6 += 8;
            }
        }
        pm6Var.l(i6);
        if (iE > 0) {
            pm6Var.l((8 - iE) * 2);
        }
        pm6Var.h();
        int iH = pm6Var.h();
        if (iH == 3) {
            pm6Var.k();
        }
        int iH2 = pm6Var.h();
        int iH3 = pm6Var.h();
        if (pm6Var.d()) {
            int iH4 = pm6Var.h();
            int iH5 = pm6Var.h();
            int iH6 = pm6Var.h();
            int iH7 = pm6Var.h();
            iH2 -= ((iH == 1 || iH == 2) ? 2 : 1) * (iH4 + iH5);
            iH3 -= (iH == 1 ? 2 : 1) * (iH6 + iH7);
        }
        pm6Var.h();
        pm6Var.h();
        int iH8 = pm6Var.h();
        for (int i8 = pm6Var.d() ? 0 : iE; i8 <= iE; i8++) {
            pm6Var.h();
            pm6Var.h();
            pm6Var.h();
        }
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        if (pm6Var.d() && pm6Var.d()) {
            g(pm6Var);
        }
        pm6Var.l(2);
        if (pm6Var.d()) {
            pm6Var.l(8);
            pm6Var.h();
            pm6Var.h();
            pm6Var.k();
        }
        h(pm6Var);
        if (pm6Var.d()) {
            for (int i9 = 0; i9 < pm6Var.h(); i9++) {
                pm6Var.l(iH8 + 4 + 1);
            }
        }
        pm6Var.l(2);
        float f2 = 1.0f;
        if (pm6Var.d()) {
            if (pm6Var.d()) {
                int iE5 = pm6Var.e(8);
                if (iE5 == 255) {
                    int iE6 = pm6Var.e(16);
                    int iE7 = pm6Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f2 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = kw5.f17802a;
                    if (iE5 < fArr.length) {
                        f2 = fArr[iE5];
                    } else {
                        Log.n(f3222b, "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (pm6Var.d()) {
                pm6Var.k();
            }
            if (pm6Var.d()) {
                pm6Var.l(4);
                if (pm6Var.d()) {
                    pm6Var.l(24);
                }
            }
            if (pm6Var.d()) {
                pm6Var.h();
                pm6Var.h();
            }
            pm6Var.k();
            if (pm6Var.d()) {
                iH3 *= 2;
            }
        }
        return new com.google.android.exoplayer2.d.b().S(str).e0("video/hevc").I(en1.c(iE2, zD, iE3, i3, iArr, iE4)).j0(iH2).Q(iH3).a0(f2).T(Collections.singletonList(bArr)).E();
    }

    public static void g(pm6 pm6Var) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (pm6Var.d()) {
                    int iMin = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        pm6Var.g();
                    }
                    for (int i5 = 0; i5 < iMin; i5++) {
                        pm6Var.g();
                    }
                } else {
                    pm6Var.h();
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    public static void h(pm6 pm6Var) {
        int iH = pm6Var.h();
        boolean zD = false;
        int i2 = 0;
        for (int i3 = 0; i3 < iH; i3++) {
            if (i3 != 0) {
                zD = pm6Var.d();
            }
            if (zD) {
                pm6Var.k();
                pm6Var.h();
                for (int i4 = 0; i4 <= i2; i4++) {
                    if (pm6Var.d()) {
                        pm6Var.k();
                    }
                }
            } else {
                int iH2 = pm6Var.h();
                int iH3 = pm6Var.h();
                int i5 = iH2 + iH3;
                for (int i6 = 0; i6 < iH2; i6++) {
                    pm6Var.h();
                    pm6Var.k();
                }
                for (int i7 = 0; i7 < iH3; i7++) {
                    pm6Var.h();
                    pm6Var.k();
                }
                i2 = i5;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        c();
        while (om6Var.a() > 0) {
            int iE = om6Var.e();
            int iF = om6Var.f();
            byte[] bArrD = om6Var.d();
            this.f3223a += (long) om6Var.a();
            this.f3224a.c(om6Var, om6Var.a());
            while (iE < iF) {
                int iC = kw5.c(bArrD, iE, iF, this.f3231a);
                if (iC == iF) {
                    e(bArrD, iE, iF);
                    return;
                }
                int iE2 = kw5.e(bArrD, iC);
                int i2 = iC - iE;
                if (i2 > 0) {
                    e(bArrD, iE, iC);
                }
                int i3 = iF - iC;
                long j = this.f3223a - ((long) i3);
                d(j, i3, i2 < 0 ? -i2 : 0, this.f3232b);
                i(j, i3, iE2, this.f3232b);
                iE = iC + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3229a = cVar.b();
        TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 2);
        this.f3224a = trackOutputB;
        this.f3225a = new a(trackOutputB);
        this.f3226a.b(extractorOutput, cVar);
    }

    @EnsuresNonNull({com.alibaba.ariver.remotedebug.b.c.g, "sampleReader"})
    public final void c() {
        sb0.k(this.f3224a);
        gj9.k(this.f3225a);
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g, "sampleReader"})
    public final void d(long j, int i2, int i3, long j2) {
        this.f3225a.a(j, i2, this.f3230a);
        if (!this.f3230a) {
            this.f3227a.b(i3);
            this.f3233b.b(i3);
            this.f3234c.b(i3);
            if (this.f3227a.c() && this.f3233b.c() && this.f3234c.c()) {
                this.f3224a.f(f(this.f3229a, this.f3227a, this.f3233b, this.f3234c));
                this.f3230a = true;
            }
        }
        if (this.f3235d.b(i3)) {
            jw5 jw5Var = this.f3235d;
            this.f3228a.Q(this.f3235d.f17516a, kw5.q(jw5Var.f17516a, jw5Var.b));
            this.f3228a.T(5);
            this.f3226a.a(j2, this.f3228a);
        }
        if (this.f3236e.b(i3)) {
            jw5 jw5Var2 = this.f3236e;
            this.f3228a.Q(this.f3236e.f17516a, kw5.q(jw5Var2.f17516a, jw5Var2.b));
            this.f3228a.T(5);
            this.f3226a.a(j2, this.f3228a);
        }
    }

    @RequiresNonNull({"sampleReader"})
    public final void e(byte[] bArr, int i2, int i3) {
        this.f3225a.e(bArr, i2, i3);
        if (!this.f3230a) {
            this.f3227a.a(bArr, i2, i3);
            this.f3233b.a(bArr, i2, i3);
            this.f3234c.a(bArr, i2, i3);
        }
        this.f3235d.a(bArr, i2, i3);
        this.f3236e.a(bArr, i2, i3);
    }

    @RequiresNonNull({"sampleReader"})
    public final void i(long j, int i2, int i3, long j2) {
        this.f3225a.g(j, i2, i3, j2, this.f3230a);
        if (!this.f3230a) {
            this.f3227a.e(i3);
            this.f3233b.e(i3);
            this.f3234c.e(i3);
        }
        this.f3235d.e(i3);
        this.f3236e.e(i3);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i2) {
        if (j != -9223372036854775807L) {
            this.f3232b = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f3223a = 0L;
        this.f3232b = -9223372036854775807L;
        kw5.a(this.f3231a);
        this.f3227a.d();
        this.f3233b.d();
        this.f3234c.d();
        this.f3235d.d();
        this.f3236e.d();
        a aVar = this.f3225a;
        if (aVar != null) {
            aVar.f();
        }
    }
}
