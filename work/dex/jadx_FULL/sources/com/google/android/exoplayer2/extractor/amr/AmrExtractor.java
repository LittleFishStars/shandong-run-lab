package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.c;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.sb0;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AmrExtractor implements Extractor {

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f2709b;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k;
    public static final int l = 20;
    public static final int m = 16000;
    public static final int n = 8000;
    public static final int o = 20000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SeekMap f2712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f2713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f2715a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2716b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2717b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f2718c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2719c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30628a = new ExtractorsFactory() { // from class: com.zj.adlib.k50
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return AmrExtractor.p();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f2708a = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final byte[] b = gj9.z0("#!AMR\n");
    public static final byte[] c = gj9.z0("#!AMR-WB\n");

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f2709b = iArr;
        k = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    public static byte[] e() {
        byte[] bArr = b;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public static byte[] f() {
        byte[] bArr = c;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public static int h(int i2) {
        return f2708a[i2];
    }

    public static int i(int i2) {
        return f2709b[i2];
    }

    public static int j(int i2, long j2) {
        return (int) (((((long) i2) * 8) * 1000000) / j2);
    }

    public static /* synthetic */ Extractor[] p() {
        return new Extractor[]{new AmrExtractor()};
    }

    public static boolean s(ExtractorInput extractorInput, byte[] bArr) throws IOException {
        extractorInput.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f2711a = extractorOutput;
        this.f2713a = extractorOutput.b(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        g();
        if (extractorInput.getPosition() == 0 && !u(extractorInput)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        q();
        int iV = v(extractorInput);
        r(extractorInput.getLength(), iV);
        return iV;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        return u(extractorInput);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    public final void g() {
        sb0.k(this.f2713a);
        gj9.k(this.f2711a);
    }

    public final SeekMap k(long j2, boolean z) {
        return new c(j2, this.f2716b, j(this.g, 20000L), this.g, z);
    }

    public final int l(int i2) throws ParserException {
        if (n(i2)) {
            return this.f2714a ? f2709b[i2] : f2708a[i2];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f2714a ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i2);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }

    public final boolean m(int i2) {
        return !this.f2714a && (i2 < 12 || i2 > 14);
    }

    public final boolean n(int i2) {
        return i2 >= 0 && i2 <= 15 && (o(i2) || m(i2));
    }

    public final boolean o(int i2) {
        return this.f2714a && (i2 < 10 || i2 > 13);
    }

    @RequiresNonNull({"trackOutput"})
    public final void q() {
        if (this.f2719c) {
            return;
        }
        this.f2719c = true;
        boolean z = this.f2714a;
        this.f2713a.f(new d.b().e0(z ? "audio/amr-wb" : "audio/3gpp").W(k).H(1).f0(z ? 16000 : 8000).E());
    }

    @RequiresNonNull({"extractorOutput"})
    public final void r(long j2, int i2) {
        int i3;
        if (this.f2717b) {
            return;
        }
        int i4 = this.d;
        if ((i4 & 1) == 0 || j2 == -1 || !((i3 = this.g) == -1 || i3 == this.e)) {
            SeekMap.b bVar = new SeekMap.b(-9223372036854775807L);
            this.f2712a = bVar;
            this.f2711a.d(bVar);
            this.f2717b = true;
            return;
        }
        if (this.h >= 20 || i2 == -1) {
            SeekMap seekMapK = k(j2, (i4 & 2) != 0);
            this.f2712a = seekMapK;
            this.f2711a.d(seekMapK);
            this.f2717b = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.f2710a = 0L;
        this.e = 0;
        this.f = 0;
        if (j2 != 0) {
            SeekMap seekMap = this.f2712a;
            if (seekMap instanceof c) {
                this.f2718c = ((c) seekMap).c(j2);
                return;
            }
        }
        this.f2718c = 0L;
    }

    public final int t(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.f2715a, 0, 1);
        byte b2 = this.f2715a[0];
        if ((b2 & 131) <= 0) {
            return l((b2 >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b2), null);
    }

    public final boolean u(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = b;
        if (s(extractorInput, bArr)) {
            this.f2714a = false;
            extractorInput.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = c;
        if (!s(extractorInput, bArr2)) {
            return false;
        }
        this.f2714a = true;
        extractorInput.skipFully(bArr2.length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    public final int v(ExtractorInput extractorInput) throws IOException {
        if (this.f == 0) {
            try {
                int iT = t(extractorInput);
                this.e = iT;
                this.f = iT;
                if (this.g == -1) {
                    this.f2716b = extractorInput.getPosition();
                    this.g = this.e;
                }
                if (this.g == this.e) {
                    this.h++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iB = this.f2713a.b(extractorInput, this.f, true);
        if (iB == -1) {
            return -1;
        }
        int i2 = this.f - iB;
        this.f = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f2713a.e(this.f2718c + this.f2710a, 1, this.e, 0, null);
        this.f2710a += 20000;
        return 0;
    }

    public AmrExtractor(int i2) {
        this.d = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f2715a = new byte[1];
        this.g = -1;
    }
}
