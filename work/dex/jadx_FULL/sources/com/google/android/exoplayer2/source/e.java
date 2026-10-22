package com.google.android.exoplayer2.source;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.upstream.DataReader;
import com.zj.adlib.at6;
import com.zj.adlib.ek5;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.rg6;
import com.zj.adlib.ta4;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(30)
public final class e implements ProgressiveMediaExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProgressiveMediaExtractor.Factory f30901a = new ProgressiveMediaExtractor.Factory() { // from class: com.zj.adlib.yj5
        @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
        public final ProgressiveMediaExtractor a(at6 at6Var) {
            return new e(at6Var);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaParser f4001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rg6 f4002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ta4 f4003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f4004a;

    @SuppressLint({"WrongConstant"})
    public e(at6 at6Var) {
        rg6 rg6Var = new rg6();
        this.f4002a = rg6Var;
        this.f4003a = new ta4();
        MediaParser mediaParserCreate = MediaParser.create(rg6Var, new String[0]);
        this.f4001a = mediaParserCreate;
        Boolean bool = Boolean.TRUE;
        mediaParserCreate.setParameter("android.media.mediaparser.eagerlyExposeTrackType", bool);
        mediaParserCreate.setParameter("android.media.mediaparser.inBandCryptoInfo", bool);
        mediaParserCreate.setParameter("android.media.mediaparser.includeSupplementalData", bool);
        this.f4004a = "android.media.mediaparser.UNKNOWN";
        if (gj9.f41922a >= 31) {
            ek5.a(mediaParserCreate, at6Var);
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void a(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) throws IOException {
        this.f4002a.o(extractorOutput);
        this.f4003a.c(dataReader, j2);
        this.f4003a.b(j);
        String parserName = this.f4001a.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(parserName)) {
            this.f4001a.advance(this.f4003a);
            String parserName2 = this.f4001a.getParserName();
            this.f4004a = parserName2;
            this.f4002a.r(parserName2);
            return;
        }
        if (parserName.equals(this.f4004a)) {
            return;
        }
        String parserName3 = this.f4001a.getParserName();
        this.f4004a = parserName3;
        this.f4002a.r(parserName3);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int b(iv6 iv6Var) throws IOException {
        boolean zAdvance = this.f4001a.advance(this.f4003a);
        long jA = this.f4003a.a();
        iv6Var.f42452a = jA;
        if (zAdvance) {
            return jA != -1 ? 1 : 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void disableSeekingOnMp3Streams() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.f4004a)) {
            this.f4002a.a();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long getCurrentInputPosition() {
        return this.f4003a.getPosition();
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        this.f4001a.release();
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long j, long j2) {
        this.f4003a.b(j);
        Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> pairK = this.f4002a.k(j2);
        this.f4001a.seek((MediaParser.SeekPoint) (((MediaParser.SeekPoint) pairK.second).position == j ? pairK.second : pairK.first));
    }
}
