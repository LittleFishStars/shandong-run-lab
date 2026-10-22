package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.zj.adlib.e86;
import com.zj.adlib.fc3;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements OggSeeker {
    public static final int b = 72000;
    public static final int c = 100000;
    public static final int d = 30000;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StreamReader f3036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e86 f3037a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f3038b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f3039c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f3040d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f3041e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f3042f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public long f3043g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public long f3044h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public long f3045i;

    public final class b implements SeekMap {
        public b() {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.a a(long j) {
            return new SeekMap.a(new x38(j, gj9.t((a.this.f3035a + ((a.this.f3036a.convertTimeToGranule(j) * (a.this.f3038b - a.this.f3035a)) / a.this.f3039c)) - 30000, a.this.f3035a, a.this.f3038b - 1)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return a.this.f3036a.convertGranuleToTime(a.this.f3039c);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public a(StreamReader streamReader, long j, long j2, long j3, long j4, boolean z) {
        sb0.a(j >= 0 && j2 > j);
        this.f3036a = streamReader;
        this.f3035a = j;
        this.f3038b = j2;
        if (j3 == j2 - j || z) {
            this.f3039c = j4;
            this.f30692a = 4;
        } else {
            this.f30692a = 0;
        }
        this.f3037a = new e86();
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long a(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f30692a;
        if (i2 == 0) {
            long position = extractorInput.getPosition();
            this.f3040d = position;
            this.f30692a = 1;
            long j = this.f3038b - 65307;
            if (j > position) {
                return j;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long jH = h(extractorInput);
                if (jH != -1) {
                    return jH;
                }
                this.f30692a = 3;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            j(extractorInput);
            this.f30692a = 4;
            return -(this.f3044h + 2);
        }
        this.f3039c = i(extractorInput);
        this.f30692a = 4;
        return this.f3040d;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    @Nullable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f3039c != 0) {
            return new b();
        }
        return null;
    }

    public final long h(ExtractorInput extractorInput) throws IOException {
        if (this.f3042f == this.f3043g) {
            return -1L;
        }
        long position = extractorInput.getPosition();
        if (!this.f3037a.d(extractorInput, this.f3043g)) {
            long j = this.f3042f;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f3037a.a(extractorInput, false);
        extractorInput.resetPeekPosition();
        long j2 = this.f3041e;
        e86 e86Var = this.f3037a;
        long j3 = e86Var.f16228a;
        long j4 = j2 - j3;
        int i2 = e86Var.d + e86Var.e;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.f3043g = position;
            this.f3045i = j3;
        } else {
            this.f3042f = extractorInput.getPosition() + ((long) i2);
            this.f3044h = this.f3037a.f16228a;
        }
        long j5 = this.f3043g;
        long j6 = this.f3042f;
        if (j5 - j6 < 100000) {
            this.f3043g = j6;
            return j6;
        }
        long position2 = extractorInput.getPosition() - (((long) i2) * (j4 <= 0 ? 2L : 1L));
        long j7 = this.f3043g;
        long j8 = this.f3042f;
        return gj9.t(position2 + ((j4 * (j7 - j8)) / (this.f3045i - this.f3044h)), j8, j7 - 1);
    }

    @VisibleForTesting
    public long i(ExtractorInput extractorInput) throws IOException {
        this.f3037a.b();
        if (!this.f3037a.c(extractorInput)) {
            throw new EOFException();
        }
        this.f3037a.a(extractorInput, false);
        e86 e86Var = this.f3037a;
        extractorInput.skipFully(e86Var.d + e86Var.e);
        long j = this.f3037a.f16228a;
        while (true) {
            e86 e86Var2 = this.f3037a;
            if ((e86Var2.b & 4) == 4 || !e86Var2.c(extractorInput) || extractorInput.getPosition() >= this.f3038b || !this.f3037a.a(extractorInput, true)) {
                break;
            }
            e86 e86Var3 = this.f3037a;
            if (!fc3.e(extractorInput, e86Var3.d + e86Var3.e)) {
                break;
            }
            j = this.f3037a.f16228a;
        }
        return j;
    }

    public final void j(ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.f3037a.c(extractorInput);
            this.f3037a.a(extractorInput, false);
            e86 e86Var = this.f3037a;
            if (e86Var.f16228a > this.f3041e) {
                extractorInput.resetPeekPosition();
                return;
            } else {
                extractorInput.skipFully(e86Var.d + e86Var.e);
                this.f3042f = extractorInput.getPosition();
                this.f3044h = this.f3037a.f16228a;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public void startSeek(long j) {
        this.f3041e = gj9.t(j, 0L, this.f3039c - 1);
        this.f30692a = 2;
        this.f3042f = this.f3035a;
        this.f3043g = this.f3038b;
        this.f3044h = 0L;
        this.f3045i = this.f3039c;
    }
}
