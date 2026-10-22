package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.gj9;
import com.zj.adlib.jw5;
import com.zj.adlib.kw5;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30718a = 176;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final float[] f3168a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    public static final int b = 178;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f3169b = "H263Reader";
    public static final int c = 179;
    public static final int d = 181;
    public static final int e = 182;
    public static final int f = 31;
    public static final int g = -1;
    public static final int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f3172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f3173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final t f3174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final jw5 f3175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final om6 f3176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f3179a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3180b;

    public static final class a {
        public static final byte[] b = {0, 0, 1};
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public static final int h = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30719a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3181a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f3182a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f3183b;
        public int c;

        public a(int i) {
            this.f3182a = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f3181a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f3182a;
                int length = bArr2.length;
                int i4 = this.f3183b;
                if (length < i4 + i3) {
                    this.f3182a = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f3182a, this.f3183b, i3);
                this.f3183b += i3;
            }
        }

        public boolean b(int i, int i2) {
            int i3 = this.f30719a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i == 179 || i == 181) {
                                this.f3183b -= i2;
                                this.f3181a = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            Log.n(i.f3169b, "Unexpected start code value");
                            c();
                        } else {
                            this.c = this.f3183b;
                            this.f30719a = 4;
                        }
                    } else if (i > 31) {
                        Log.n(i.f3169b, "Unexpected start code value");
                        c();
                    } else {
                        this.f30719a = 3;
                    }
                } else if (i != 181) {
                    Log.n(i.f3169b, "Unexpected start code value");
                    c();
                } else {
                    this.f30719a = 2;
                }
            } else if (i == 176) {
                this.f30719a = 1;
                this.f3181a = true;
            }
            byte[] bArr = b;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f3181a = false;
            this.f3183b = 0;
            this.f30719a = 0;
        }
    }

    public static final class b {
        public static final int c = 1;
        public static final int d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30720a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3184a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f3185a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3186a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f3187b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f3188b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f3189c;

        public b(TrackOutput trackOutput) {
            this.f3185a = trackOutput;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f3188b) {
                int i3 = this.b;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.b = i3 + (i2 - i);
                } else {
                    this.f3189c = ((bArr[i4] & u.n7) >> 6) == 0;
                    this.f3188b = false;
                }
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
        public void b(long j, int i, boolean z) {
            if (this.f30720a == 182 && z && this.f3186a) {
                long j2 = this.f3187b;
                if (j2 != -9223372036854775807L) {
                    this.f3185a.e(j2, this.f3189c ? 1 : 0, (int) (j - this.f3184a), i, null);
                }
            }
            if (this.f30720a != 179) {
                this.f3184a = j;
            }
        }

        public void c(int i, long j) {
            this.f30720a = i;
            this.f3189c = false;
            this.f3186a = i == 182 || i == 179;
            this.f3188b = i == 182;
            this.b = 0;
            this.f3187b = j;
        }

        public void d() {
            this.f3186a = false;
            this.f3188b = false;
            this.f3189c = false;
            this.f30720a = -1;
        }
    }

    public i() {
        this(null);
    }

    public static com.google.android.exoplayer2.d c(a aVar, int i, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f3182a, aVar.f3183b);
        nm6 nm6Var = new nm6(bArrCopyOf);
        nm6Var.t(i);
        nm6Var.t(4);
        nm6Var.r();
        nm6Var.s(8);
        if (nm6Var.g()) {
            nm6Var.s(4);
            nm6Var.s(3);
        }
        int iH = nm6Var.h(4);
        float f2 = 1.0f;
        if (iH == 15) {
            int iH2 = nm6Var.h(8);
            int iH3 = nm6Var.h(8);
            if (iH3 == 0) {
                Log.n(f3169b, "Invalid aspect ratio");
            } else {
                f2 = iH2 / iH3;
            }
        } else {
            float[] fArr = f3168a;
            if (iH < fArr.length) {
                f2 = fArr[iH];
            } else {
                Log.n(f3169b, "Invalid aspect ratio");
            }
        }
        if (nm6Var.g()) {
            nm6Var.s(2);
            nm6Var.s(1);
            if (nm6Var.g()) {
                nm6Var.s(15);
                nm6Var.r();
                nm6Var.s(15);
                nm6Var.r();
                nm6Var.s(15);
                nm6Var.r();
                nm6Var.s(3);
                nm6Var.s(11);
                nm6Var.r();
                nm6Var.s(15);
                nm6Var.r();
            }
        }
        if (nm6Var.h(2) != 0) {
            Log.n(f3169b, "Unhandled video object layer shape");
        }
        nm6Var.r();
        int iH4 = nm6Var.h(16);
        nm6Var.r();
        if (nm6Var.g()) {
            if (iH4 == 0) {
                Log.n(f3169b, "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = iH4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                nm6Var.s(i2);
            }
        }
        nm6Var.r();
        int iH5 = nm6Var.h(13);
        nm6Var.r();
        int iH6 = nm6Var.h(13);
        nm6Var.r();
        nm6Var.r();
        return new com.google.android.exoplayer2.d.b().S(str).e0("video/mp4v-es").j0(iH5).Q(iH6).a0(f2).T(Collections.singletonList(bArrCopyOf)).E();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        sb0.k(this.f3173a);
        sb0.k(this.f3171a);
        int iE = om6Var.e();
        int iF = om6Var.f();
        byte[] bArrD = om6Var.d();
        this.f3170a += (long) om6Var.a();
        this.f3171a.c(om6Var, om6Var.a());
        while (true) {
            int iC = kw5.c(bArrD, iE, iF, this.f3179a);
            if (iC == iF) {
                break;
            }
            int i = iC + 3;
            int i2 = om6Var.d()[i] & 255;
            int i3 = iC - iE;
            int i4 = 0;
            if (!this.f3178a) {
                if (i3 > 0) {
                    this.f3172a.a(bArrD, iE, iC);
                }
                if (this.f3172a.b(i2, i3 < 0 ? -i3 : 0)) {
                    TrackOutput trackOutput = this.f3171a;
                    a aVar = this.f3172a;
                    trackOutput.f(c(aVar, aVar.c, (String) sb0.g(this.f3177a)));
                    this.f3178a = true;
                }
            }
            this.f3173a.a(bArrD, iE, iC);
            jw5 jw5Var = this.f3175a;
            if (jw5Var != null) {
                if (i3 > 0) {
                    jw5Var.a(bArrD, iE, iC);
                } else {
                    i4 = -i3;
                }
                if (this.f3175a.b(i4)) {
                    jw5 jw5Var2 = this.f3175a;
                    ((om6) gj9.k(this.f3176a)).Q(this.f3175a.f17516a, kw5.q(jw5Var2.f17516a, jw5Var2.b));
                    ((t) gj9.k(this.f3174a)).a(this.f3180b, this.f3176a);
                }
                if (i2 == 178 && om6Var.d()[iC + 2] == 1) {
                    this.f3175a.e(i2);
                }
            }
            int i5 = iF - iC;
            this.f3173a.b(this.f3170a - ((long) i5), i5, this.f3178a);
            this.f3173a.c(i2, this.f3180b);
            iE = i;
        }
        if (!this.f3178a) {
            this.f3172a.a(bArrD, iE, iF);
        }
        this.f3173a.a(bArrD, iE, iF);
        jw5 jw5Var3 = this.f3175a;
        if (jw5Var3 != null) {
            jw5Var3.a(bArrD, iE, iF);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3177a = cVar.b();
        TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 2);
        this.f3171a = trackOutputB;
        this.f3173a = new b(trackOutputB);
        t tVar = this.f3174a;
        if (tVar != null) {
            tVar.b(extractorOutput, cVar);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f3180b = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        kw5.a(this.f3179a);
        this.f3172a.c();
        b bVar = this.f3173a;
        if (bVar != null) {
            bVar.d();
        }
        jw5 jw5Var = this.f3175a;
        if (jw5Var != null) {
            jw5Var.d();
        }
        this.f3170a = 0L;
        this.f3180b = -9223372036854775807L;
    }

    public i(@Nullable t tVar) {
        this.f3174a = tVar;
        this.f3179a = new boolean[4];
        this.f3172a = new a(128);
        this.f3180b = -9223372036854775807L;
        if (tVar != null) {
            this.f3175a = new jw5(178, 128);
            this.f3176a = new om6();
        } else {
            this.f3175a = null;
            this.f3176a = null;
        }
    }
}
