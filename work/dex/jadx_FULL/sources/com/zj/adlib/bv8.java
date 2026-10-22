package com.zj.adlib;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class bv8 implements Extractor {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;
    public static final int k = 5;
    public static final int l = 1024;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f15637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f15638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f15639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SubtitleDecoder f15640a;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final uy1 f15642a = new uy1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f15641a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Long> f15643a = new ArrayList();
    public final List<om6> b = new ArrayList();
    public int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f40846a = -9223372036854775807L;

    public bv8(SubtitleDecoder subtitleDecoder, d dVar) {
        this.f15640a = subtitleDecoder;
        this.f15637a = dVar.b().e0("text/x-exoplayer-cues").I(dVar.k).E();
    }

    public final void a() throws IOException, DecoderException {
        try {
            cv8 cv8VarDequeueInputBuffer = this.f15640a.dequeueInputBuffer();
            while (cv8VarDequeueInputBuffer == null) {
                Thread.sleep(5L);
                cv8VarDequeueInputBuffer = this.f15640a.dequeueInputBuffer();
            }
            cv8VarDequeueInputBuffer.k(this.d);
            ((DecoderInputBuffer) cv8VarDequeueInputBuffer).f2588a.put(this.f15641a.d(), 0, this.d);
            ((DecoderInputBuffer) cv8VarDequeueInputBuffer).f2588a.limit(this.d);
            this.f15640a.queueInputBuffer(cv8VarDequeueInputBuffer);
            SubtitleOutputBuffer subtitleOutputBufferDequeueOutputBuffer = this.f15640a.dequeueOutputBuffer();
            while (subtitleOutputBufferDequeueOutputBuffer == null) {
                Thread.sleep(5L);
                subtitleOutputBufferDequeueOutputBuffer = this.f15640a.dequeueOutputBuffer();
            }
            for (int i2 = 0; i2 < subtitleOutputBufferDequeueOutputBuffer.getEventTimeCount(); i2++) {
                byte[] bArrA = this.f15642a.a(subtitleOutputBufferDequeueOutputBuffer.getCues(subtitleOutputBufferDequeueOutputBuffer.getEventTime(i2)));
                this.f15643a.add(Long.valueOf(subtitleOutputBufferDequeueOutputBuffer.getEventTime(i2)));
                this.b.add(new om6(bArrA));
            }
            subtitleOutputBufferDequeueOutputBuffer.j();
        } catch (SubtitleDecoderException e) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        sb0.i(this.e == 0);
        this.f15638a = extractorOutput;
        this.f15639a = extractorOutput.b(0, 3);
        this.f15638a.endTracks();
        this.f15638a.d(new h(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.f15639a.f(this.f15637a);
        this.e = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException, DecoderException {
        int i2 = this.e;
        sb0.i((i2 == 0 || i2 == 5) ? false : true);
        if (this.e == 1) {
            this.f15641a.O(extractorInput.getLength() != -1 ? Ints.d(extractorInput.getLength()) : 1024);
            this.d = 0;
            this.e = 2;
        }
        if (this.e == 2 && e(extractorInput)) {
            a();
            g();
            this.e = 4;
        }
        if (this.e == 3 && f(extractorInput)) {
            g();
            this.e = 4;
        }
        return this.e == 4 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        return true;
    }

    public final boolean e(ExtractorInput extractorInput) throws IOException {
        int iB = this.f15641a.b();
        int i2 = this.d;
        if (iB == i2) {
            this.f15641a.c(i2 + 1024);
        }
        int i3 = extractorInput.read(this.f15641a.d(), this.d, this.f15641a.b() - this.d);
        if (i3 != -1) {
            this.d += i3;
        }
        long length = extractorInput.getLength();
        return (length != -1 && ((long) this.d) == length) || i3 == -1;
    }

    public final boolean f(ExtractorInput extractorInput) throws IOException {
        return extractorInput.skip((extractorInput.getLength() > (-1L) ? 1 : (extractorInput.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(extractorInput.getLength()) : 1024) == -1;
    }

    public final void g() {
        sb0.k(this.f15639a);
        sb0.i(this.f15643a.size() == this.b.size());
        long j2 = this.f40846a;
        for (int iH = j2 == -9223372036854775807L ? 0 : gj9.h(this.f15643a, Long.valueOf(j2), true, true); iH < this.b.size(); iH++) {
            om6 om6Var = this.b.get(iH);
            om6Var.S(0);
            int length = om6Var.d().length;
            this.f15639a.c(om6Var, length);
            this.f15639a.e(this.f15643a.get(iH).longValue(), 1, length, 0, null);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        if (this.e == 5) {
            return;
        }
        this.f15640a.release();
        this.e = 5;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        int i2 = this.e;
        sb0.i((i2 == 0 || i2 == 5) ? false : true);
        this.f40846a = j3;
        if (this.e == 2) {
            this.e = 1;
        }
        if (this.e == 4) {
            this.e = 3;
        }
    }
}
