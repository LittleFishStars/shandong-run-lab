package com.zj.adlib;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(30)
public final class ck5 implements HlsMediaChunkExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HlsExtractorFactory f40983a = new HlsExtractorFactory() { // from class: com.zj.adlib.bk5
        @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
        public final HlsMediaChunkExtractor a(Uri uri, d dVar, List list, g89 g89Var, Map map, ExtractorInput extractorInput, at6 at6Var) {
            return ck5.f(uri, dVar, list, g89Var, map, extractorInput, at6Var);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaParser f15830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f15831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<MediaFormat> f15832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f15833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rg6 f15834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ta4 f15835a = new ta4();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15836a;

    public static final class b implements MediaParser.SeekableInputReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40984a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ExtractorInput f15837a;

        @Override // android.media.MediaParser.InputReader
        public long getLength() {
            return this.f15837a.getLength();
        }

        @Override // android.media.MediaParser.InputReader
        public long getPosition() {
            return this.f15837a.getPeekPosition();
        }

        @Override // android.media.MediaParser.InputReader
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int iPeek = this.f15837a.peek(bArr, i, i2);
            this.f40984a += iPeek;
            return iPeek;
        }

        @Override // android.media.MediaParser.SeekableInputReader
        public void seekToPosition(long j) {
            throw new UnsupportedOperationException();
        }

        public b(ExtractorInput extractorInput) {
            this.f15837a = extractorInput;
        }
    }

    public ck5(MediaParser mediaParser, rg6 rg6Var, d dVar, boolean z, ImmutableList<MediaFormat> immutableList, int i, at6 at6Var) {
        this.f15830a = mediaParser;
        this.f15834a = rg6Var;
        this.f15836a = z;
        this.f15832a = immutableList;
        this.f15831a = dVar;
        this.f15833a = at6Var;
        this.f15829a = i;
    }

    @SuppressLint({"WrongConstant"})
    public static MediaParser e(MediaParser.OutputConsumer outputConsumer, d dVar, boolean z, ImmutableList<MediaFormat> immutableList, at6 at6Var, String... strArr) {
        MediaParser mediaParserCreateByName = strArr.length == 1 ? MediaParser.createByName(strArr[0], outputConsumer) : MediaParser.create(outputConsumer, strArr);
        mediaParserCreateByName.setParameter("android.media.mediaParser.exposeCaptionFormats", immutableList);
        mediaParserCreateByName.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", Boolean.valueOf(z));
        Boolean bool = Boolean.TRUE;
        mediaParserCreateByName.setParameter("android.media.mediaparser.inBandCryptoInfo", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.eagerlyExposeTrackType", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ignoreTimestampOffset", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.mode", LiveConfigKey.HLS);
        String str = dVar.i;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(bp5.c(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAacStream", bool);
            }
            if (!"video/avc".equals(bp5.o(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAvcStream", bool);
            }
        }
        if (gj9.f41922a >= 31) {
            ek5.a(mediaParserCreateByName, at6Var);
        }
        return mediaParserCreateByName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HlsMediaChunkExtractor f(Uri uri, d dVar, List list, g89 g89Var, Map map, ExtractorInput extractorInput, at6 at6Var) throws IOException {
        if (FileTypes.a(dVar.k) == 13) {
            return new e51(new gv9(dVar.h, g89Var), dVar, g89Var);
        }
        boolean z = list != null;
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                aVarBuilder.a(ek5.b((d) list.get(i)));
            }
        } else {
            aVarBuilder.a(ek5.b(new d.b().e0("application/cea-608").E()));
        }
        ImmutableList immutableListE = aVarBuilder.e();
        rg6 rg6Var = new rg6();
        if (list == null) {
            list = ImmutableList.of();
        }
        rg6Var.p(list);
        rg6Var.s(g89Var);
        MediaParser mediaParserE = e(rg6Var, dVar, z, immutableListE, at6Var, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        b bVar = new b(extractorInput);
        mediaParserE.advance(bVar);
        rg6Var.r(mediaParserE.getParserName());
        return new ck5(mediaParserE, rg6Var, dVar, z, immutableListE, bVar.f40984a, at6Var);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean a(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.f15829a);
        this.f15829a = 0;
        this.f15835a.c(extractorInput, extractorInput.getLength());
        return this.f15830a.advance(this.f15835a);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void b(ExtractorOutput extractorOutput) {
        this.f15834a.o(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor c() {
        sb0.i(!isReusable());
        return new ck5(e(this.f15834a, this.f15831a, this.f15836a, this.f15832a, this.f15833a, this.f15830a.getParserName()), this.f15834a, this.f15831a, this.f15836a, this.f15832a, 0, this.f15833a);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isPackedAudioExtractor() {
        String parserName = this.f15830a.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(parserName) || "android.media.mediaparser.Ac4Parser".equals(parserName) || "android.media.mediaparser.AdtsParser".equals(parserName) || "android.media.mediaparser.Mp3Parser".equals(parserName);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isReusable() {
        String parserName = this.f15830a.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(parserName) || "android.media.mediaparser.TsParser".equals(parserName);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void onTruncatedSegmentParsed() {
        this.f15830a.seek(MediaParser.SeekPoint.START);
    }
}
