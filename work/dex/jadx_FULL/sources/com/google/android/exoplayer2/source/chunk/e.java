package com.google.android.exoplayer2.source.chunk;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.e;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.at6;
import com.zj.adlib.bp5;
import com.zj.adlib.ek5;
import com.zj.adlib.gj9;
import com.zj.adlib.rg6;
import com.zj.adlib.sb0;
import com.zj.adlib.ta4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(30)
public final class e implements ChunkExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChunkExtractor.Factory f30868a = new ChunkExtractor.Factory() { // from class: com.zj.adlib.pj5
        @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.Factory
        public final ChunkExtractor a(int i, d dVar, boolean z, List list, TrackOutput trackOutput, at6 at6Var) {
            return e.j(i, dVar, z, list, trackOutput, at6Var);
        }
    };
    public static final String f = "MediaPrsrChunkExtractor";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaParser f3882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.extractor.d f3883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ChunkExtractor.TrackOutputProvider f3884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f3885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rg6 f3886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ta4 f3887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d[] f3888a;

    public class b implements ExtractorOutput {
        public b() {
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public TrackOutput b(int i, int i2) {
            return e.this.f3884a != null ? e.this.f3884a.b(i, i2) : e.this.f3883a;
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void d(SeekMap seekMap) {
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void endTracks() {
            e eVar = e.this;
            eVar.f3888a = eVar.f3886a.j();
        }
    }

    @SuppressLint({"WrongConstant"})
    public e(int i, com.google.android.exoplayer2.d dVar, List<com.google.android.exoplayer2.d> list, at6 at6Var) {
        rg6 rg6Var = new rg6(dVar, i, true);
        this.f3886a = rg6Var;
        this.f3887a = new ta4();
        String str = bp5.r((String) sb0.g(dVar.j)) ? "android.media.mediaparser.MatroskaParser" : "android.media.mediaparser.FragmentedMp4Parser";
        rg6Var.r(str);
        MediaParser mediaParserCreateByName = MediaParser.createByName(str, rg6Var);
        this.f3882a = mediaParserCreateByName;
        Boolean bool = Boolean.TRUE;
        mediaParserCreateByName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.inBandCryptoInfo", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.includeSupplementalData", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.eagerlyExposeTrackType", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.exposeDummySeekMap", bool);
        mediaParserCreateByName.setParameter("android.media.mediaParser.exposeChunkIndexAsMediaFormat", bool);
        mediaParserCreateByName.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", bool);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(ek5.b(list.get(i2)));
        }
        this.f3882a.setParameter("android.media.mediaParser.exposeCaptionFormats", arrayList);
        if (gj9.f41922a >= 31) {
            ek5.a(this.f3882a, at6Var);
        }
        this.f3886a.p(list);
        this.f3885a = new b();
        this.f3883a = new com.google.android.exoplayer2.extractor.d();
        this.f3881a = -9223372036854775807L;
    }

    public static /* synthetic */ ChunkExtractor j(int i, com.google.android.exoplayer2.d dVar, boolean z, List list, TrackOutput trackOutput, at6 at6Var) {
        if (!bp5.s(dVar.j)) {
            return new e(i, dVar, list, at6Var);
        }
        Log.n(f, "Ignoring an unsupported text track.");
        return null;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean a(ExtractorInput extractorInput) throws IOException {
        k();
        this.f3887a.c(extractorInput, extractorInput.getLength());
        return this.f3882a.advance(this.f3887a);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void c(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.f3884a = trackOutputProvider;
        this.f3886a.q(j2);
        this.f3886a.o(this.f3885a);
        this.f3881a = j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public com.google.android.exoplayer2.d[] e() {
        return this.f3888a;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public com.google.android.exoplayer2.extractor.b f() {
        return this.f3886a.d();
    }

    public final void k() {
        MediaParser.SeekMap seekMapF = this.f3886a.f();
        long j = this.f3881a;
        if (j == -9223372036854775807L || seekMapF == null) {
            return;
        }
        this.f3882a.seek((MediaParser.SeekPoint) seekMapF.getSeekPoints(j).first);
        this.f3881a = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void release() {
        this.f3882a.release();
    }
}
