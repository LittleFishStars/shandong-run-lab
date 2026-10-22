package com.zj.adlib;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44003a = "RtpVP8Reader";
    public static final long c = 90000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f18875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f18876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18874a = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18873a = -1;
    public int b = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f18878b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18877a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18879b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f18880c = false;

    public pk7(b bVar) {
        this.f18876a = bVar;
    }

    public static long d(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, 90000L);
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
    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        sb0.k(this.f18875a);
        if (e(om6Var, i)) {
            if (this.b == -1 && this.f18877a) {
                this.f18879b = (om6Var.h() & 1) == 0;
            }
            if (!this.f18880c) {
                int iE = om6Var.e();
                om6Var.S(iE + 6);
                int iY = om6Var.y() & 16383;
                int iY2 = om6Var.y() & 16383;
                om6Var.S(iE);
                d dVar = this.f18876a.f4394a;
                if (iY != dVar.Q || iY2 != dVar.R) {
                    this.f18875a.f(dVar.b().j0(iY).Q(iY2).E());
                }
                this.f18880c = true;
            }
            int iA = om6Var.a();
            this.f18875a.c(om6Var, iA);
            this.b += iA;
            if (z) {
                if (this.f18874a == -9223372036854775807L) {
                    this.f18874a = j;
                }
                this.f18875a.e(d(this.f18878b, j, this.f18874a), this.f18879b ? 1 : 0, this.b, 0, null);
                this.b = -1;
                this.f18877a = false;
            }
            this.f18873a = i;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 2);
        this.f18875a = trackOutputB;
        trackOutputB.f(this.f18876a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
    }

    public final boolean e(om6 om6Var, int i) {
        int iG = om6Var.G();
        if (this.f18877a) {
            int iB = kk7.b(this.f18873a);
            if (i != iB) {
                Log.n(f44003a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return false;
            }
        } else {
            if ((iG & 16) != 1 || (iG & 7) != 0) {
                Log.n(f44003a, "RTP packet is not the start of a new VP8 partition, skipping.");
                return false;
            }
            this.f18877a = true;
        }
        if ((iG & 128) != 0) {
            int iG2 = om6Var.G();
            if ((iG2 & 128) != 0 && (om6Var.G() & 128) != 0) {
                om6Var.T(1);
            }
            if ((iG2 & 64) != 0) {
                om6Var.T(1);
            }
            if ((iG2 & 32) != 0 || (iG2 & 16) != 0) {
                om6Var.T(1);
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f18874a = j;
        this.b = -1;
        this.f18878b = j2;
    }
}
