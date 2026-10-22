package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.remotedebug.b.c;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gv9 implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f41995a = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern b = Pattern.compile("MPEGTS:(-?\\d+)");
    public static final int e = 6;
    public static final int f = 9;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f16883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g89 f16884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f16886a;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16885a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f16887a = new byte[1024];

    public gv9(@Nullable String str, g89 g89Var) {
        this.f16886a = str;
        this.f16884a = g89Var;
    }

    @RequiresNonNull({c.g})
    public final TrackOutput a(long j) {
        TrackOutput trackOutputB = this.f16883a.b(0, 3);
        trackOutputB.f(new d.b().e0("text/vtt").V(this.f16886a).i0(j).E());
        this.f16883a.endTracks();
        return trackOutputB;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f16883a = extractorOutput;
        extractorOutput.d(new SeekMap.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        sb0.g(this.f16883a);
        int length = (int) extractorInput.getLength();
        int i = this.d;
        byte[] bArr = this.f16887a;
        if (i == bArr.length) {
            this.f16887a = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f16887a;
        int i2 = this.d;
        int i3 = extractorInput.read(bArr2, i2, bArr2.length - i2);
        if (i3 != -1) {
            int i4 = this.d + i3;
            this.d = i4;
            if (length == -1 || i4 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.f16887a, 0, 6, false);
        this.f16885a.Q(this.f16887a, 6);
        if (hv9.b(this.f16885a)) {
            return true;
        }
        extractorInput.peekFully(this.f16887a, 6, 3, false);
        this.f16885a.Q(this.f16887a, 9);
        return hv9.b(this.f16885a);
    }

    @RequiresNonNull({c.g})
    public final void e() throws ParserException {
        om6 om6Var = new om6(this.f16887a);
        hv9.e(om6Var);
        long jF = 0;
        long jD = 0;
        for (String strQ = om6Var.q(); !TextUtils.isEmpty(strQ); strQ = om6Var.q()) {
            if (strQ.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f41995a.matcher(strQ);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain local timestamp: " + strQ, null);
                }
                Matcher matcher2 = b.matcher(strQ);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain media timestamp: " + strQ, null);
                }
                jD = hv9.d((String) sb0.g(matcher.group(1)));
                jF = g89.f(Long.parseLong((String) sb0.g(matcher2.group(1))));
            }
        }
        Matcher matcherA = hv9.a(om6Var);
        if (matcherA == null) {
            a(0L);
            return;
        }
        long jD2 = hv9.d((String) sb0.g(matcherA.group(1)));
        long jB = this.f16884a.b(g89.j((jF + jD2) - jD));
        TrackOutput trackOutputA = a(jB - jD2);
        this.f16885a.Q(this.f16887a, this.d);
        trackOutputA.c(this.f16885a, this.d);
        trackOutputA.e(jB, 1, this.d, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        throw new IllegalStateException();
    }
}
