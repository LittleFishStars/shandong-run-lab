package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d51 implements ProgressiveMediaExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Extractor f41108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ExtractorInput f15926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExtractorsFactory f15927a;

    public d51(ExtractorsFactory extractorsFactory) {
        this.f15927a = extractorsFactory;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void a(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) throws IOException {
        zf2 zf2Var = new zf2(dataReader, j, j2);
        this.f15926a = zf2Var;
        if (this.f41108a != null) {
            return;
        }
        Extractor[] extractorArrA = this.f15927a.a(uri, map);
        if (extractorArrA.length == 1) {
            this.f41108a = extractorArrA[0];
        } else {
            for (Extractor extractor : extractorArrA) {
                try {
                    if (extractor.d(zf2Var)) {
                        this.f41108a = extractor;
                        sb0.i(true);
                        zf2Var.resetPeekPosition();
                        break;
                    } else {
                        boolean z = this.f41108a != null || zf2Var.getPosition() == j;
                        sb0.i(z);
                        zf2Var.resetPeekPosition();
                    }
                } catch (EOFException unused) {
                    if (this.f41108a != null || zf2Var.getPosition() == j) {
                    }
                } catch (Throwable th) {
                    sb0.i(this.f41108a != null || zf2Var.getPosition() == j);
                    zf2Var.resetPeekPosition();
                    throw th;
                }
                sb0.i(z);
                zf2Var.resetPeekPosition();
            }
            if (this.f41108a == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + gj9.U(extractorArrA) + ") could read the stream.", (Uri) sb0.g(uri));
            }
        }
        this.f41108a.b(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int b(iv6 iv6Var) throws IOException {
        return ((Extractor) sb0.g(this.f41108a)).c((ExtractorInput) sb0.g(this.f15926a), iv6Var);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void disableSeekingOnMp3Streams() {
        Extractor extractor = this.f41108a;
        if (extractor instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor).i();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long getCurrentInputPosition() {
        ExtractorInput extractorInput = this.f15926a;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        Extractor extractor = this.f41108a;
        if (extractor != null) {
            extractor.release();
            this.f41108a = null;
        }
        this.f15926a = null;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long j, long j2) {
        ((Extractor) sb0.g(this.f41108a)).seek(j, j2);
    }
}
