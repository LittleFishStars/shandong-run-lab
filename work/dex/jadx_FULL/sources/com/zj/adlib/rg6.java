package com.zj.adlib;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(30)
@SuppressLint({"Override"})
public final class rg6 implements MediaParser.OutputConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> f44448a = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f19287a = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    public static final String b = "OConsumerAdapterV30";
    public static final String c = "track-type-string";
    public static final String d = "chunk-index-int-sizes";
    public static final String e = "chunk-index-long-offsets";
    public static final String f = "chunk-index-long-us-durations";
    public static final String g = "chunk-index-long-us-times";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f19288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f19289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaParser.SeekMap f19290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final d f19291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f19292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.extractor.b f19293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public g89 f19294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f19295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f19296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<TrackOutput> f19297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<d> f19298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19299a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f19300b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public MediaParser.SeekMap f19301b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<d> f19302b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19303b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final ArrayList<MediaCodec.CryptoInfo> f19304c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f19305c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final ArrayList<TrackOutput.a> f19306d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f19307d;

    public static final class b implements DataReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public MediaParser.InputReader f44449a;

        public b() {
        }

        @Override // com.google.android.exoplayer2.upstream.DataReader
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return ((MediaParser.InputReader) gj9.k(this.f44449a)).read(bArr, i, i2);
        }
    }

    public static final class c implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaParser.SeekMap f44450a;

        public c(MediaParser.SeekMap seekMap) {
            this.f44450a = seekMap;
        }

        public static x38 b(MediaParser.SeekPoint seekPoint) {
            return new x38(seekPoint.timeMicros, seekPoint.position);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.a a(long j) {
            Pair seekPoints = this.f44450a.getSeekPoints(j);
            Object obj = seekPoints.first;
            return obj == seekPoints.second ? new SeekMap.a(b((MediaParser.SeekPoint) obj)) : new SeekMap.a(b((MediaParser.SeekPoint) obj), b((MediaParser.SeekPoint) seekPoints.second));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            long durationMicros = this.f44450a.getDurationMicros();
            if (durationMicros != -2147483648L) {
                return durationMicros;
            }
            return -9223372036854775807L;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return this.f44450a.isSeekable();
        }
    }

    public rg6() {
        this(null, -2, false);
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    @Nullable
    public static tn1 e(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] bArrC = byteBuffer != null ? c(byteBuffer) : null;
        int integer = mediaFormat.getInteger("color-transfer", -1);
        int integer2 = mediaFormat.getInteger("color-range", -1);
        int integer3 = mediaFormat.getInteger("color-standard", -1);
        if (bArrC == null && integer == -1 && integer2 == -1 && integer3 == -1) {
            return null;
        }
        return new tn1(integer3, integer2, integer, bArrC);
    }

    public static int g(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i;
        }
        return 0;
    }

    public static List<byte[]> h(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            int i2 = i + 1;
            sb.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(c(byteBuffer));
            i = i2;
        }
    }

    public static String i(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.mediaparser.Mp4Parser":
            case "android.media.mediaparser.FragmentedMp4Parser":
                return "video/mp4";
            case "android.media.mediaparser.OggParser":
                return "audio/ogg";
            case "android.media.mediaparser.TsParser":
                return "video/mp2t";
            case "android.media.mediaparser.AdtsParser":
                return "audio/mp4a-latm";
            case "android.media.mediaparser.WavParser":
                return "audio/raw";
            case "android.media.mediaparser.PsParser":
                return "video/mp2p";
            case "android.media.mediaparser.Ac3Parser":
                return "audio/ac3";
            case "android.media.mediaparser.AmrParser":
                return "audio/amr";
            case "android.media.mediaparser.FlacParser":
                return "audio/flac";
            case "android.media.mediaparser.MatroskaParser":
                return "video/webm";
            case "android.media.mediaparser.Ac4Parser":
                return "audio/ac4";
            case "android.media.mediaparser.Mp3Parser":
                return "audio/mpeg";
            case "android.media.mediaparser.FlvParser":
                return "video/x-flv";
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    public static int l(MediaFormat mediaFormat) {
        return g(mediaFormat, "is-forced-subtitle", 2) | g(mediaFormat, "is-autoselect", 4) | 0 | g(mediaFormat, "is-default", 1);
    }

    @Nullable
    public static DrmInitData u(@Nullable String str, @Nullable android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
        for (int i = 0; i < schemeInitDataCount; i++) {
            android.media.DrmInitData.SchemeInitData schemeInitDataAt = drmInitData.getSchemeInitDataAt(i);
            schemeDataArr[i] = new DrmInitData.SchemeData(schemeInitDataAt.uuid, schemeInitDataAt.mimeType, schemeInitDataAt.data);
        }
        return new DrmInitData(str, schemeDataArr);
    }

    public static int w(@Nullable String str) {
        if (str == null) {
            return -1;
        }
        switch (str) {
            case "metadata":
                return 5;
            case "unknown":
                return -1;
            case "text":
                return 3;
            case "audio":
                return 1;
            case "video":
                return 2;
            default:
                return bp5.l(str);
        }
    }

    public void a() {
        this.f19307d = true;
    }

    public final void b(int i) {
        for (int size = this.f19297a.size(); size <= i; size++) {
            this.f19297a.add(null);
            this.f19302b.add(null);
            this.f19304c.add(null);
            this.f19306d.add(null);
        }
    }

    @Nullable
    public com.google.android.exoplayer2.extractor.b d() {
        return this.f19293a;
    }

    @Nullable
    public MediaParser.SeekMap f() {
        return this.f19290a;
    }

    @Nullable
    public d[] j() {
        if (!this.f19303b) {
            return null;
        }
        d[] dVarArr = new d[this.f19302b.size()];
        for (int i = 0; i < this.f19302b.size(); i++) {
            dVarArr[i] = (d) sb0.g(this.f19302b.get(i));
        }
        return dVarArr;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> k(long j) {
        MediaParser.SeekMap seekMap = this.f19301b;
        return seekMap != null ? seekMap.getSeekPoints(j) : f44448a;
    }

    public final void m() {
        if (!this.f19303b || this.f19305c) {
            return;
        }
        int size = this.f19297a.size();
        for (int i = 0; i < size; i++) {
            if (this.f19297a.get(i) == null) {
                return;
            }
        }
        this.f19292a.endTracks();
        this.f19305c = true;
    }

    public final boolean n(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(d);
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer intBufferAsIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer longBufferAsLongBuffer = ((ByteBuffer) sb0.g(mediaFormat.getByteBuffer(e))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer2 = ((ByteBuffer) sb0.g(mediaFormat.getByteBuffer(f))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer3 = ((ByteBuffer) sb0.g(mediaFormat.getByteBuffer(g))).asLongBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        long[] jArr = new long[longBufferAsLongBuffer.remaining()];
        long[] jArr2 = new long[longBufferAsLongBuffer2.remaining()];
        long[] jArr3 = new long[longBufferAsLongBuffer3.remaining()];
        intBufferAsIntBuffer.get(iArr);
        longBufferAsLongBuffer.get(jArr);
        longBufferAsLongBuffer2.get(jArr2);
        longBufferAsLongBuffer3.get(jArr3);
        com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(iArr, jArr, jArr2, jArr3);
        this.f19293a = bVar;
        this.f19292a.d(bVar);
        return true;
    }

    public void o(ExtractorOutput extractorOutput) {
        this.f19292a = extractorOutput;
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSampleCompleted(int i, long j, int i2, int i3, int i4, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        long j2 = this.f19289a;
        if (j2 == -9223372036854775807L || j < j2) {
            g89 g89Var = this.f19294a;
            if (g89Var != null) {
                j = g89Var.a(j);
            }
            ((TrackOutput) sb0.g(this.f19297a.get(i))).e(j, i2, i3, i4, t(i, cryptoInfo));
        }
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSampleDataFound(int i, MediaParser.InputReader inputReader) throws IOException {
        b(i);
        this.f19295a.f44449a = inputReader;
        TrackOutput trackOutputB = this.f19297a.get(i);
        if (trackOutputB == null) {
            trackOutputB = this.f19292a.b(i, -1);
            this.f19297a.set(i, trackOutputB);
        }
        trackOutputB.b(this.f19295a, (int) inputReader.getLength(), true);
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap cVar;
        if (this.f19299a && this.f19290a == null) {
            this.f19290a = seekMap;
            return;
        }
        this.f19301b = seekMap;
        long durationMicros = seekMap.getDurationMicros();
        ExtractorOutput extractorOutput = this.f19292a;
        if (this.f19307d) {
            if (durationMicros == -2147483648L) {
                durationMicros = -9223372036854775807L;
            }
            cVar = new SeekMap.b(durationMicros);
        } else {
            cVar = new c(seekMap);
        }
        extractorOutput.d(cVar);
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onTrackCountFound(int i) {
        this.f19303b = true;
        m();
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onTrackDataFound(int i, MediaParser.TrackData trackData) {
        if (n(trackData.mediaFormat)) {
            return;
        }
        b(i);
        TrackOutput trackOutput = this.f19297a.get(i);
        if (trackOutput == null) {
            String string = trackData.mediaFormat.getString(c);
            int iW = w(string != null ? string : trackData.mediaFormat.getString("mime"));
            if (iW == this.f19288a) {
                this.f19300b = i;
            }
            TrackOutput trackOutputB = this.f19292a.b(i, iW);
            this.f19297a.set(i, trackOutputB);
            if (string != null) {
                return;
            } else {
                trackOutput = trackOutputB;
            }
        }
        d dVarV = v(trackData);
        d dVar = this.f19291a;
        trackOutput.f((dVar == null || i != this.f19300b) ? dVarV : dVarV.A(dVar));
        this.f19302b.set(i, dVarV);
        m();
    }

    public void p(List<d> list) {
        this.f19298a = list;
    }

    public void q(long j) {
        this.f19289a = j;
    }

    public void r(String str) {
        this.f19296a = i(str);
    }

    public void s(g89 g89Var) {
        this.f19294a = g89Var;
    }

    @Nullable
    public final TrackOutput.a t(int i, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        int i2;
        int i3;
        if (cryptoInfo == null) {
            return null;
        }
        if (this.f19304c.get(i) == cryptoInfo) {
            return (TrackOutput.a) sb0.g(this.f19306d.get(i));
        }
        try {
            Matcher matcher = f19287a.matcher(cryptoInfo.toString());
            matcher.find();
            i2 = Integer.parseInt((String) gj9.k(matcher.group(1)));
            i3 = Integer.parseInt((String) gj9.k(matcher.group(2)));
        } catch (RuntimeException e2) {
            Log.e(b, "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e2);
            i2 = 0;
            i3 = 0;
        }
        TrackOutput.a aVar = new TrackOutput.a(cryptoInfo.mode, cryptoInfo.key, i2, i3);
        this.f19304c.set(i, cryptoInfo);
        this.f19306d.set(i, aVar);
        return aVar;
    }

    public final d v(MediaParser.TrackData trackData) {
        MediaFormat mediaFormat = trackData.mediaFormat;
        String string = mediaFormat.getString("mime");
        int integer = mediaFormat.getInteger("caption-service-number", -1);
        d.b bVarF = new d.b().M(u(mediaFormat.getString("crypto-mode-fourcc"), trackData.drmInitData)).K(this.f19296a).Z(mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, -1)).H(mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, -1)).J(e(mediaFormat)).e0(string).I(mediaFormat.getString("codecs-string")).P(mediaFormat.getFloat("frame-rate", -1.0f)).j0(mediaFormat.getInteger("width", -1)).Q(mediaFormat.getInteger("height", -1)).T(h(mediaFormat)).V(mediaFormat.getString(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_LANGUAGE)).W(mediaFormat.getInteger("max-input-size", -1)).Y(mediaFormat.getInteger("exo-pcm-encoding", -1)).d0(mediaFormat.getInteger("rotation-degrees", 0)).f0(mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, -1)).g0(l(mediaFormat)).N(mediaFormat.getInteger("encoder-delay", 0)).O(mediaFormat.getInteger("encoder-padding", 0)).a0(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).i0(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).F(integer);
        for (int i = 0; i < this.f19298a.size(); i++) {
            d dVar = this.f19298a.get(i);
            if (gj9.c(dVar.k, string) && dVar.Z == integer) {
                bVarF.V(dVar.h).c0(dVar.L).g0(dVar.K).U(dVar.g).X(dVar.f2567a);
                break;
            }
        }
        return bVarF.E();
    }

    public rg6(@Nullable d dVar, int i, boolean z) {
        this.f19299a = z;
        this.f19291a = dVar;
        this.f19288a = i;
        this.f19297a = new ArrayList<>();
        this.f19302b = new ArrayList<>();
        this.f19304c = new ArrayList<>();
        this.f19306d = new ArrayList<>();
        this.f19295a = new b();
        this.f19292a = new os2();
        this.f19289a = -9223372036854775807L;
        this.f19298a = ImmutableList.of();
    }
}
