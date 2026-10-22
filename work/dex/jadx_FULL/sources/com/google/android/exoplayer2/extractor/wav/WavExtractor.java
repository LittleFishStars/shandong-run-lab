package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.Log;
import com.huachenjie.common.constants.UserConstants;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.zj.adlib.au9;
import com.zj.adlib.bu9;
import com.zj.adlib.cu9;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.zt9;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class WavExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30736a = new ExtractorsFactory() { // from class: com.zj.adlib.yt9
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return WavExtractor.f();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f3300a = "WavExtractor";
    public static final int f = 10;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f3302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OutputWriter f3304a;
    public int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3301a = -1;
    public int e = -1;
    public long b = -1;

    public interface OutputWriter {
        boolean a(ExtractorInput extractorInput, long j) throws IOException;

        void init(int i, long j) throws ParserException;

        void reset(long j);
    }

    public static final class a implements OutputWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f30737a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 209, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 253, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 307, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 408, 449, 494, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 598, MediaPlayer.MEDIA_PLAYER_OPTION_BACKGROUND_STATUS, 724, 796, 876, 963, 1060, 1166, 1282, SecExceptionCode.SEC_ERROR_SECURITYBODY_DATA_FILE_MISMATCH, UserConstants.MODIFY_PHONE_ERROR_CODE.f33733a, 1707, 1878, 2066, 2272, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_UNKONWN_ERROR, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f3305a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3306a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d f3307a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ExtractorOutput f3308a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f3309a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f3310a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final zt9 f3311a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f3312a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int f3313b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f3314b;
        public int c;
        public int d;

        public a(ExtractorOutput extractorOutput, TrackOutput trackOutput, zt9 zt9Var) throws ParserException {
            this.f3308a = extractorOutput;
            this.f3309a = trackOutput;
            this.f3311a = zt9Var;
            int iMax = Math.max(1, zt9Var.c / 10);
            this.f3313b = iMax;
            om6 om6Var = new om6(zt9Var.f21108a);
            om6Var.y();
            int iY = om6Var.y();
            this.f3305a = iY;
            int i = zt9Var.b;
            int i2 = (((zt9Var.e - (i * 4)) * 8) / (zt9Var.f * i)) + 1;
            if (iY == i2) {
                int iM = gj9.m(iMax, iY);
                this.f3312a = new byte[zt9Var.e * iM];
                this.f3310a = new om6(iM * f(iY, i));
                int i3 = ((zt9Var.c * zt9Var.e) * 8) / iY;
                this.f3307a = new d.b().e0("audio/raw").G(i3).Z(i3).W(f(iMax, i)).H(zt9Var.b).f0(zt9Var.c).Y(2).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i2 + "; got: " + iY, null);
        }

        public static int f(int i, int i2) {
            return i * 2 * i2;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0038 A[LOOP:0: B:6:0x001e->B:12:0x0038, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x003e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x001b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0020  */
        /* JADX WARN: Code duplicated, block: B:9:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:4:0x001b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public boolean a(com.google.android.exoplayer2.extractor.ExtractorInput r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f3313b
                int r1 = r6.d
                int r1 = r6.d(r1)
                int r0 = r0 - r1
                int r1 = r6.f3305a
                int r0 = com.zj.adlib.gj9.m(r0, r1)
                com.zj.adlib.zt9 r1 = r6.f3311a
                int r1 = r1.e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.c
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.f3312a
                int r5 = r6.c
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.c
                int r4 = r4 + r3
                r6.c = r4
                goto L1e
            L3e:
                int r7 = r6.c
                com.zj.adlib.zt9 r8 = r6.f3311a
                int r8 = r8.e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.f3312a
                com.zj.adlib.om6 r9 = r6.f3310a
                r6.b(r8, r7, r9)
                int r8 = r6.c
                com.zj.adlib.zt9 r9 = r6.f3311a
                int r9 = r9.e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.c = r8
                com.zj.adlib.om6 r7 = r6.f3310a
                int r7 = r7.f()
                com.google.android.exoplayer2.extractor.TrackOutput r8 = r6.f3309a
                com.zj.adlib.om6 r9 = r6.f3310a
                r8.c(r9, r7)
                int r8 = r6.d
                int r8 = r8 + r7
                r6.d = r8
                int r7 = r6.d(r8)
                int r8 = r6.f3313b
                if (r7 < r8) goto L75
                r6.g(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.d
                int r7 = r6.d(r7)
                if (r7 <= 0) goto L82
                r6.g(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.wav.WavExtractor.a.a(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
        }

        public final void b(byte[] bArr, int i, om6 om6Var) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.f3311a.b; i3++) {
                    c(bArr, i2, i3, om6Var.d());
                }
            }
            int iE = e(this.f3305a * i);
            om6Var.S(0);
            om6Var.R(iE);
        }

        public final void c(byte[] bArr, int i, int i2, byte[] bArr2) {
            zt9 zt9Var = this.f3311a;
            int i3 = zt9Var.e;
            int i4 = zt9Var.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int iS = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int iMin = Math.min(bArr[i5 + 2] & 255, 88);
            int i8 = b[iMin];
            int i9 = ((i * this.f3305a * i4) + i2) * 2;
            bArr2[i9] = (byte) (iS & 255);
            bArr2[i9 + 1] = (byte) (iS >> 8);
            for (int i10 = 0; i10 < i7 * 2; i10++) {
                int i11 = bArr[((i10 / 8) * i4 * 4) + i6 + ((i10 / 2) % 4)] & 255;
                int i12 = i10 % 2 == 0 ? i11 & 15 : i11 >> 4;
                int i13 = ((((i12 & 7) * 2) + 1) * i8) >> 3;
                if ((i12 & 8) != 0) {
                    i13 = -i13;
                }
                iS = gj9.s(iS + i13, -32768, 32767);
                i9 += i4 * 2;
                bArr2[i9] = (byte) (iS & 255);
                bArr2[i9 + 1] = (byte) (iS >> 8);
                int i14 = iMin + f30737a[i12];
                int[] iArr = b;
                iMin = gj9.s(i14, 0, iArr.length - 1);
                i8 = iArr[iMin];
            }
        }

        public final int d(int i) {
            return i / (this.f3311a.b * 2);
        }

        public final int e(int i) {
            return f(i, this.f3311a.b);
        }

        public final void g(int i) {
            long jO1 = this.f3306a + gj9.o1(this.f3314b, 1000000L, this.f3311a.c);
            int iE = e(i);
            this.f3309a.e(jO1, 1, iE, this.d - iE, null);
            this.f3314b += (long) i;
            this.d -= iE;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void init(int i, long j) {
            this.f3308a.d(new bu9(this.f3311a, this.f3305a, i, j));
            this.f3309a.f(this.f3307a);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void reset(long j) {
            this.c = 0;
            this.f3306a = j;
            this.d = 0;
            this.f3314b = 0L;
        }
    }

    public static final class b implements OutputWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30738a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3315a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d f3316a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ExtractorOutput f3317a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f3318a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final zt9 f3319a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f3320b;

        public b(ExtractorOutput extractorOutput, TrackOutput trackOutput, zt9 zt9Var, String str, int i) throws ParserException {
            this.f3317a = extractorOutput;
            this.f3318a = trackOutput;
            this.f3319a = zt9Var;
            int i2 = (zt9Var.b * zt9Var.f) / 8;
            if (zt9Var.e == i2) {
                int i3 = zt9Var.c;
                int i4 = i3 * i2 * 8;
                int iMax = Math.max(i2, (i3 * i2) / 10);
                this.f30738a = iMax;
                this.f3316a = new d.b().e0(str).G(i4).Z(i4).W(iMax).H(zt9Var.b).f0(zt9Var.c).Y(i).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i2 + "; got: " + zt9Var.e, null);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public boolean a(ExtractorInput extractorInput, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.b) < (i2 = this.f30738a)) {
                int iB = this.f3318a.b(extractorInput, (int) Math.min(i2 - i, j2), true);
                if (iB == -1) {
                    j2 = 0;
                } else {
                    this.b += iB;
                    j2 -= (long) iB;
                }
            }
            zt9 zt9Var = this.f3319a;
            int i3 = zt9Var.e;
            int i4 = this.b / i3;
            if (i4 > 0) {
                long jO1 = this.f3315a + gj9.o1(this.f3320b, 1000000L, zt9Var.c);
                int i5 = i4 * i3;
                int i6 = this.b - i5;
                this.f3318a.e(jO1, 1, i5, i6, null);
                this.f3320b += (long) i4;
                this.b = i6;
            }
            return j2 <= 0;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void init(int i, long j) {
            this.f3317a.d(new bu9(this.f3319a, 1, i, j));
            this.f3318a.f(this.f3316a);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void reset(long j) {
            this.f3315a = j;
            this.b = 0;
            this.f3320b = 0L;
        }
    }

    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new WavExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3302a = extractorOutput;
        this.f3303a = extractorOutput.b(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        e();
        int i2 = this.d;
        if (i2 == 0) {
            g(extractorInput);
            return 0;
        }
        if (i2 == 1) {
            i(extractorInput);
            return 0;
        }
        if (i2 == 2) {
            h(extractorInput);
            return 0;
        }
        if (i2 == 3) {
            k(extractorInput);
            return 0;
        }
        if (i2 == 4) {
            return j(extractorInput);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        return au9.a(extractorInput);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    public final void e() {
        sb0.k(this.f3303a);
        gj9.k(this.f3302a);
    }

    public final void g(ExtractorInput extractorInput) throws IOException {
        sb0.i(extractorInput.getPosition() == 0);
        int i2 = this.e;
        if (i2 != -1) {
            extractorInput.skipFully(i2);
            this.d = 4;
        } else {
            if (!au9.a(extractorInput)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
            }
            extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
            this.d = 1;
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    public final void h(ExtractorInput extractorInput) throws IOException {
        zt9 zt9VarB = au9.b(extractorInput);
        int i2 = zt9VarB.f46338a;
        if (i2 == 17) {
            this.f3304a = new a(this.f3302a, this.f3303a, zt9VarB);
        } else if (i2 == 6) {
            this.f3304a = new b(this.f3302a, this.f3303a, zt9VarB, "audio/g711-alaw", -1);
        } else if (i2 == 7) {
            this.f3304a = new b(this.f3302a, this.f3303a, zt9VarB, "audio/g711-mlaw", -1);
        } else {
            int iA = cu9.a(i2, zt9VarB.f);
            if (iA == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + zt9VarB.f46338a);
            }
            this.f3304a = new b(this.f3302a, this.f3303a, zt9VarB, "audio/raw", iA);
        }
        this.d = 3;
    }

    public final void i(ExtractorInput extractorInput) throws IOException {
        this.f3301a = au9.c(extractorInput);
        this.d = 2;
    }

    public final int j(ExtractorInput extractorInput) throws IOException {
        sb0.i(this.b != -1);
        return ((OutputWriter) sb0.g(this.f3304a)).a(extractorInput, this.b - extractorInput.getPosition()) ? -1 : 0;
    }

    public final void k(ExtractorInput extractorInput) throws IOException {
        Pair<Long, Long> pairE = au9.e(extractorInput);
        this.e = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j2 = this.f3301a;
        if (j2 != -1 && jLongValue == 4294967295L) {
            jLongValue = j2;
        }
        this.b = ((long) this.e) + jLongValue;
        long length = extractorInput.getLength();
        if (length != -1 && this.b > length) {
            Log.n(f3300a, "Data exceeds input length: " + this.b + ", " + length);
            this.b = length;
        }
        ((OutputWriter) sb0.g(this.f3304a)).init(this.e, this.b);
        this.d = 4;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.d = j2 == 0 ? 0 : 4;
        OutputWriter outputWriter = this.f3304a;
        if (outputWriter != null) {
            outputWriter.reset(j3);
        }
    }
}
