package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41699a = "RtpH263Reader";
    public static final long c = 90000;
    public static final int e = 0;
    public static final int f = 128;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f16554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f16555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16556a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16557b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f16558b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f16559c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16553a = -9223372036854775807L;
    public int b = -1;

    public fk7(b bVar) {
        this.f16555a = bVar;
    }

    public static long e(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, 90000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        sb0.k(this.f16554a);
        int iE = om6Var.e();
        int iM = om6Var.M();
        Object[] objArr = (iM & 1024) > 0;
        if ((iM & 512) != 0 || (iM & 504) != 0 || (iM & 7) != 0) {
            Log.n(f41699a, "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
            return;
        }
        if (objArr != true) {
            int iB = kk7.b(this.b);
            if (i != iB) {
                Log.n(f41699a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return;
            }
        } else if ((om6Var.h() & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) < 128) {
            Log.n(f41699a, "Picture start Code (PSC) missing, dropping packet.");
            return;
        } else {
            om6Var.d()[iE] = 0;
            om6Var.d()[iE + 1] = 0;
            om6Var.S(iE);
        }
        if (this.f16552a == 0) {
            d(om6Var, this.f16558b);
            if (!this.f16558b && this.f16556a) {
                int i2 = this.f16559c;
                d dVar = this.f16555a.f4394a;
                if (i2 != dVar.Q || this.d != dVar.R) {
                    this.f16554a.f(dVar.b().j0(this.f16559c).Q(this.d).E());
                }
                this.f16558b = true;
            }
        }
        int iA = om6Var.a();
        this.f16554a.c(om6Var, iA);
        this.f16552a += iA;
        if (z) {
            if (this.f16553a == -9223372036854775807L) {
                this.f16553a = j;
            }
            this.f16554a.e(e(this.f16557b, j, this.f16553a), this.f16556a ? 1 : 0, this.f16552a, 0, null);
            this.f16552a = 0;
            this.f16556a = false;
        }
        this.b = i;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 2);
        this.f16554a = trackOutputB;
        trackOutputB.f(this.f16555a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
    }

    public final void d(om6 om6Var, boolean z) {
        int iE = om6Var.e();
        if (((om6Var.I() >> 10) & 63) != 32) {
            om6Var.S(iE);
            this.f16556a = false;
            return;
        }
        int iH = om6Var.h();
        int i = (iH >> 1) & 1;
        if (!z && i == 0) {
            int i2 = (iH >> 2) & 7;
            if (i2 == 1) {
                this.f16559c = 128;
                this.d = 96;
            } else {
                int i3 = i2 - 2;
                this.f16559c = 176 << i3;
                this.d = 144 << i3;
            }
        }
        om6Var.S(iE);
        this.f16556a = i == 0;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f16553a = j;
        this.f16552a = 0;
        this.f16557b = j2;
    }
}
