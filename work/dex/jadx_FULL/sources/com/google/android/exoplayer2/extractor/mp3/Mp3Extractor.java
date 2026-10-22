package com.google.android.exoplayer2.extractor.mp3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.zj.adlib.cs3;
import com.zj.adlib.gj9;
import com.zj.adlib.hs5;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.u54;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Mp3Extractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30664a = new ExtractorsFactory() { // from class: com.zj.adlib.yr5
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return Mp3Extractor.n();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Id3Decoder.FramePredicate f2914a = new Id3Decoder.FramePredicate() { // from class: com.zj.adlib.as5
        @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i2, int i3, int i4, int i5, int i6) {
            return Mp3Extractor.o(i2, i3, i4, i5, i6);
        }
    };
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 4;
    public static final int j = 8;
    public static final int k = 131072;
    public static final int l = 32768;
    public static final int m = 10;
    public static final int n = -128000;
    public static final int o = 1483304551;
    public static final int p = 1231971951;
    public static final int q = 1447187017;
    public static final int r = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackOutput f2917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Seeker f2918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Metadata f2919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cs3 f2920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hs5.a f2921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u54 f2923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2924a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TrackOutput f2925b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2926b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TrackOutput f2927c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2928d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f2929e;
    public int f;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    public static long k(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.length();
        for (int i2 = 0; i2 < length; i2++) {
            Metadata.Entry entry = metadata.get(i2);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.id.equals("TLEN")) {
                    return gj9.Z0(Long.parseLong(textInformationFrame.value));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static int l(om6 om6Var, int i2) {
        if (om6Var.f() >= i2 + 4) {
            om6Var.S(i2);
            int iO = om6Var.o();
            if (iO == 1483304551 || iO == 1231971951) {
                return iO;
            }
        }
        if (om6Var.f() < 40) {
            return 0;
        }
        om6Var.S(36);
        if (om6Var.o() == 1447187017) {
            return q;
        }
        return 0;
    }

    public static boolean m(int i2, long j2) {
        return ((long) (i2 & n)) == (j2 & (-128000));
    }

    public static /* synthetic */ Extractor[] n() {
        return new Extractor[]{new Mp3Extractor()};
    }

    public static /* synthetic */ boolean o(int i2, int i3, int i4, int i5, int i6) {
        return (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) || (i3 == 77 && i4 == 76 && i5 == 76 && (i6 == 84 || i2 == 2));
    }

    @Nullable
    public static c p(@Nullable Metadata metadata, long j2) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i2 = 0; i2 < length; i2++) {
            Metadata.Entry entry = metadata.get(i2);
            if (entry instanceof MlltFrame) {
                return c.b(j2, (MlltFrame) entry, k(metadata));
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f2916a = extractorOutput;
        TrackOutput trackOutputB = extractorOutput.b(0, 1);
        this.f2925b = trackOutputB;
        this.f2927c = trackOutputB;
        this.f2916a.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        f();
        int iS = s(extractorInput);
        if (iS == -1 && (this.f2918a instanceof b)) {
            long jH = h(this.c);
            if (this.f2918a.getDurationUs() != jH) {
                ((b) this.f2918a).d(jH);
                this.f2916a.d(this.f2918a);
            }
        }
        return iS;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        return u(extractorInput, true);
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    public final void f() {
        sb0.k(this.f2925b);
        gj9.k(this.f2916a);
    }

    public final Seeker g(ExtractorInput extractorInput) throws IOException {
        long jK;
        long dataEndPosition;
        Seeker seekerQ = q(extractorInput);
        c cVarP = p(this.f2919a, extractorInput.getPosition());
        if (this.f2924a) {
            return new Seeker.a();
        }
        if ((this.d & 4) != 0) {
            if (cVarP != null) {
                jK = cVarP.getDurationUs();
                dataEndPosition = cVarP.getDataEndPosition();
            } else if (seekerQ != null) {
                jK = seekerQ.getDurationUs();
                dataEndPosition = seekerQ.getDataEndPosition();
            } else {
                jK = k(this.f2919a);
                dataEndPosition = -1;
            }
            seekerQ = new b(jK, extractorInput.getPosition(), dataEndPosition);
        } else if (cVarP != null) {
            seekerQ = cVarP;
        } else if (seekerQ == null) {
            seekerQ = null;
        }
        if (seekerQ == null || !(seekerQ.isSeekable() || (this.d & 1) == 0)) {
            return j(extractorInput, (this.d & 2) != 0);
        }
        return seekerQ;
    }

    public final long h(long j2) {
        return this.b + ((j2 * 1000000) / ((long) this.f2921a.c));
    }

    public void i() {
        this.f2924a = true;
    }

    public final Seeker j(ExtractorInput extractorInput, boolean z) throws IOException {
        extractorInput.peekFully(this.f2922a.d(), 0, 4);
        this.f2922a.S(0);
        this.f2921a.a(this.f2922a.o());
        return new a(extractorInput.getLength(), extractorInput.getPosition(), this.f2921a, z);
    }

    @Nullable
    public final Seeker q(ExtractorInput extractorInput) throws IOException {
        om6 om6Var = new om6(this.f2921a.b);
        extractorInput.peekFully(om6Var.d(), 0, this.f2921a.b);
        hs5.a aVar = this.f2921a;
        int i2 = 21;
        if ((aVar.f42194a & 1) != 0) {
            if (aVar.d != 1) {
                i2 = 36;
            }
        } else if (aVar.d == 1) {
            i2 = 13;
        }
        int i3 = i2;
        int iL = l(om6Var, i3);
        if (iL != 1483304551 && iL != 1231971951) {
            if (iL != 1447187017) {
                extractorInput.resetPeekPosition();
                return null;
            }
            d dVarB = d.b(extractorInput.getLength(), extractorInput.getPosition(), this.f2921a, om6Var);
            extractorInput.skipFully(this.f2921a.b);
            return dVarB;
        }
        e eVarB = e.b(extractorInput.getLength(), extractorInput.getPosition(), this.f2921a, om6Var);
        if (eVarB != null && !this.f2920a.a()) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(i3 + 141);
            extractorInput.peekFully(this.f2922a.d(), 0, 3);
            this.f2922a.S(0);
            this.f2920a.d(this.f2922a.J());
        }
        extractorInput.skipFully(this.f2921a.b);
        return (eVarB == null || eVarB.isSeekable() || iL != 1231971951) ? eVarB : j(extractorInput, false);
    }

    public final boolean r(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.f2918a;
        if (seeker != null) {
            long dataEndPosition = seeker.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.f2922a.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    public final int s(ExtractorInput extractorInput) throws IOException {
        if (this.e == 0) {
            try {
                u(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f2918a == null) {
            Seeker seekerG = g(extractorInput);
            this.f2918a = seekerG;
            this.f2916a.d(seekerG);
            this.f2927c.f(new com.google.android.exoplayer2.d.b().e0(this.f2921a.f17069a).W(4096).H(this.f2921a.d).f0(this.f2921a.c).N(this.f2920a.f15885a).O(this.f2920a.f15886b).X((this.d & 8) != 0 ? null : this.f2919a).E());
            this.f2928d = extractorInput.getPosition();
        } else if (this.f2928d != 0) {
            long position = extractorInput.getPosition();
            long j2 = this.f2928d;
            if (position < j2) {
                extractorInput.skipFully((int) (j2 - position));
            }
        }
        return t(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.e = 0;
        this.b = -9223372036854775807L;
        this.c = 0L;
        this.f = 0;
        this.f2929e = j3;
        Seeker seeker = this.f2918a;
        if (!(seeker instanceof b) || ((b) seeker).b(j3)) {
            return;
        }
        this.f2926b = true;
        this.f2927c = this.f2917a;
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    public final int t(ExtractorInput extractorInput) throws IOException {
        if (this.f == 0) {
            extractorInput.resetPeekPosition();
            if (r(extractorInput)) {
                return -1;
            }
            this.f2922a.S(0);
            int iO = this.f2922a.o();
            if (!m(iO, this.e) || hs5.j(iO) == -1) {
                extractorInput.skipFully(1);
                this.e = 0;
                return 0;
            }
            this.f2921a.a(iO);
            if (this.b == -9223372036854775807L) {
                this.b = this.f2918a.getTimeUs(extractorInput.getPosition());
                if (this.f2915a != -9223372036854775807L) {
                    this.b += this.f2915a - this.f2918a.getTimeUs(0L);
                }
            }
            hs5.a aVar = this.f2921a;
            this.f = aVar.b;
            Seeker seeker = this.f2918a;
            if (seeker instanceof b) {
                b bVar = (b) seeker;
                bVar.c(h(this.c + ((long) aVar.f)), extractorInput.getPosition() + ((long) this.f2921a.b));
                if (this.f2926b && bVar.b(this.f2929e)) {
                    this.f2926b = false;
                    this.f2927c = this.f2925b;
                }
            }
        }
        int iB = this.f2927c.b(extractorInput, this.f, true);
        if (iB == -1) {
            return -1;
        }
        int i2 = this.f - iB;
        this.f = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f2927c.e(h(this.c), 1, this.f2921a.b, 0, null);
        this.c += (long) this.f2921a.f;
        this.f = 0;
        return 0;
    }

    public final boolean u(ExtractorInput extractorInput, boolean z) throws IOException {
        int peekPosition;
        int i2;
        int iJ;
        int i3 = z ? 32768 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataA = this.f2923a.a(extractorInput, (this.d & 8) == 0 ? null : f2914a);
            this.f2919a = metadataA;
            if (metadataA != null) {
                this.f2920a.c(metadataA);
            }
            peekPosition = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(peekPosition);
            }
            i2 = 0;
        } else {
            peekPosition = 0;
            i2 = 0;
        }
        int i4 = i2;
        int i5 = i4;
        while (true) {
            if (r(extractorInput)) {
                if (i4 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.f2922a.S(0);
            int iO = this.f2922a.o();
            if ((i2 == 0 || m(iO, i2)) && (iJ = hs5.j(iO)) != -1) {
                i4++;
                if (i4 != 1) {
                    if (i4 == 4) {
                        break;
                    }
                } else {
                    this.f2921a.a(iO);
                    i2 = iO;
                }
                extractorInput.advancePeekPosition(iJ - 4);
            } else {
                int i6 = i5 + 1;
                if (i5 == i3) {
                    if (z) {
                        return false;
                    }
                    throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                }
                if (z) {
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(peekPosition + i6);
                } else {
                    extractorInput.skipFully(1);
                }
                i4 = 0;
                i5 = i6;
                i2 = 0;
            }
        }
        if (z) {
            extractorInput.skipFully(peekPosition + i5);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.e = i2;
        return true;
    }

    public Mp3Extractor(int i2) {
        this(i2, -9223372036854775807L);
    }

    public Mp3Extractor(int i2, long j2) {
        this.d = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f2915a = j2;
        this.f2922a = new om6(10);
        this.f2921a = new hs5.a();
        this.f2920a = new cs3();
        this.b = -9223372036854775807L;
        this.f2923a = new u54();
        com.google.android.exoplayer2.extractor.d dVar = new com.google.android.exoplayer2.extractor.d();
        this.f2917a = dVar;
        this.f2927c = dVar;
    }
}
