package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.gj9;
import com.zj.adlib.jw5;
import com.zj.adlib.kw5;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30716a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final double[] f3148a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public static final int b = 179;
    public static final int c = 181;
    public static final int d = 184;
    public static final int e = 178;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f3151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final t f3152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final jw5 f3153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final om6 f3154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f3157a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3158b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3159b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f3160c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3161c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f3162d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3163d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f3164e;

    public static final class a {
        public static final byte[] b = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30717a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3165a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f3166a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f3167b;

        public a(int i) {
            this.f3166a = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f3165a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f3166a;
                int length = bArr2.length;
                int i4 = this.f30717a;
                if (length < i4 + i3) {
                    this.f3166a = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f3166a, this.f30717a, i3);
                this.f30717a += i3;
            }
        }

        public boolean b(int i, int i2) {
            if (this.f3165a) {
                int i3 = this.f30717a - i2;
                this.f30717a = i3;
                if (this.f3167b != 0 || i != 181) {
                    this.f3165a = false;
                    return true;
                }
                this.f3167b = i3;
            } else if (i == 179) {
                this.f3165a = true;
            }
            byte[] bArr = b;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f3165a = false;
            this.f30717a = 0;
            this.f3167b = 0;
        }
    }

    public h() {
        this(null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    /* JADX WARN: Code duplicated, block: B:16:0x0078  */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:20:0x0098  */
    public static Pair<com.google.android.exoplayer2.d, Long> c(a aVar, String str) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        double[] dArr;
        double d2;
        int i3;
        int i4;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f3166a, aVar.f30717a);
        int i5 = bArrCopyOf[4] & 255;
        int i6 = bArrCopyOf[5] & 255;
        int i7 = (i5 << 4) | (i6 >> 4);
        int i8 = ((i6 & 15) << 8) | (bArrCopyOf[6] & 255);
        int i9 = (bArrCopyOf[7] & 240) >> 4;
        if (i9 == 2) {
            f = i8 * 4;
            i = i7 * 3;
        } else {
            if (i9 != 3) {
                if (i9 != 4) {
                    f2 = 1.0f;
                } else {
                    f = i8 * 121;
                    i = i7 * 100;
                }
                com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().S(str).e0("video/mpeg2").j0(i7).Q(i8).a0(f2).T(Collections.singletonList(bArrCopyOf)).E();
                i2 = (bArrCopyOf[7] & com.google.common.base.a.q) - 1;
                if (i2 >= 0) {
                    dArr = f3148a;
                    if (i2 < dArr.length) {
                        d2 = dArr[i2];
                        byte b2 = bArrCopyOf[aVar.f3167b + 9];
                        i3 = (b2 & 96) >> 5;
                        i4 = b2 & 31;
                        if (i3 != i4) {
                            d2 *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                        }
                        j = (long) (1000000.0d / d2);
                    } else {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                return Pair.create(dVarE, Long.valueOf(j));
            }
            f = i8 * 16;
            i = i7 * 9;
        }
        f2 = f / i;
        com.google.android.exoplayer2.d dVarE2 = new com.google.android.exoplayer2.d.b().S(str).e0("video/mpeg2").j0(i7).Q(i8).a0(f2).T(Collections.singletonList(bArrCopyOf)).E();
        i2 = (bArrCopyOf[7] & com.google.common.base.a.q) - 1;
        if (i2 >= 0) {
            dArr = f3148a;
            if (i2 < dArr.length) {
                d2 = dArr[i2];
                byte b3 = bArrCopyOf[aVar.f3167b + 9];
                i3 = (b3 & 96) >> 5;
                i4 = b3 & 31;
                if (i3 != i4) {
                    d2 *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                }
                j = (long) (1000000.0d / d2);
            } else {
                j = 0;
            }
        } else {
            j = 0;
        }
        return Pair.create(dVarE2, Long.valueOf(j));
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0112  */
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
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        boolean z;
        int i;
        sb0.k(this.f3150a);
        int iE = om6Var.e();
        int iF = om6Var.f();
        byte[] bArrD = om6Var.d();
        this.f3149a += (long) om6Var.a();
        this.f3150a.c(om6Var, om6Var.a());
        while (true) {
            int iC = kw5.c(bArrD, iE, iF, this.f3157a);
            if (iC == iF) {
                break;
            }
            int i2 = iC + 3;
            int i3 = om6Var.d()[i2] & 255;
            int i4 = iC - iE;
            if (!this.f3159b) {
                if (i4 > 0) {
                    this.f3151a.a(bArrD, iE, iC);
                }
                if (this.f3151a.b(i3, i4 < 0 ? -i4 : 0)) {
                    Pair<com.google.android.exoplayer2.d, Long> pairC = c(this.f3151a, (String) sb0.g(this.f3155a));
                    this.f3150a.f((com.google.android.exoplayer2.d) pairC.first);
                    this.f3158b = ((Long) pairC.second).longValue();
                    this.f3159b = true;
                }
            }
            jw5 jw5Var = this.f3153a;
            if (jw5Var != null) {
                if (i4 > 0) {
                    jw5Var.a(bArrD, iE, iC);
                    i = 0;
                } else {
                    i = -i4;
                }
                if (this.f3153a.b(i)) {
                    jw5 jw5Var2 = this.f3153a;
                    ((om6) gj9.k(this.f3154a)).Q(this.f3153a.f17516a, kw5.q(jw5Var2.f17516a, jw5Var2.b));
                    ((t) gj9.k(this.f3152a)).a(this.f3164e, this.f3154a);
                }
                if (i3 == 178 && om6Var.d()[iC + 2] == 1) {
                    this.f3153a.e(i3);
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i5 = iF - iC;
                if (this.f3163d && this.f3159b) {
                    long j = this.f3164e;
                    if (j != -9223372036854775807L) {
                        this.f3150a.e(j, this.f3161c ? 1 : 0, ((int) (this.f3149a - this.f3162d)) - i5, i5, null);
                    }
                }
                if (!this.f3156a || this.f3163d) {
                    this.f3162d = this.f3149a - ((long) i5);
                    long j2 = this.f3160c;
                    if (j2 == -9223372036854775807L) {
                        long j3 = this.f3164e;
                        j2 = j3 != -9223372036854775807L ? j3 + this.f3158b : -9223372036854775807L;
                    }
                    this.f3164e = j2;
                    this.f3161c = false;
                    this.f3160c = -9223372036854775807L;
                    z = true;
                    this.f3156a = true;
                } else {
                    z = true;
                }
                this.f3163d = i3 == 0 ? z : false;
            } else if (i3 == 184) {
                this.f3161c = true;
            }
            iE = i2;
        }
        if (!this.f3159b) {
            this.f3151a.a(bArrD, iE, iF);
        }
        jw5 jw5Var3 = this.f3153a;
        if (jw5Var3 != null) {
            jw5Var3.a(bArrD, iE, iF);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3155a = cVar.b();
        this.f3150a = extractorOutput.b(cVar.c(), 2);
        t tVar = this.f3152a;
        if (tVar != null) {
            tVar.b(extractorOutput, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.f3160c = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        kw5.a(this.f3157a);
        this.f3151a.c();
        jw5 jw5Var = this.f3153a;
        if (jw5Var != null) {
            jw5Var.d();
        }
        this.f3149a = 0L;
        this.f3156a = false;
        this.f3160c = -9223372036854775807L;
        this.f3164e = -9223372036854775807L;
    }

    public h(@Nullable t tVar) {
        this.f3152a = tVar;
        this.f3157a = new boolean[4];
        this.f3151a = new a(128);
        if (tVar != null) {
            this.f3153a = new jw5(178, 128);
            this.f3154a = new om6();
        } else {
            this.f3153a = null;
            this.f3154a = null;
        }
        this.f3160c = -9223372036854775807L;
        this.f3164e = -9223372036854775807L;
    }
}
