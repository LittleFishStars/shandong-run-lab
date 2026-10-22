package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.at6;
import com.zj.adlib.d72;
import com.zj.adlib.g89;
import com.zj.adlib.h89;
import com.zj.adlib.n20;
import com.zj.adlib.om6;
import com.zj.adlib.rh9;
import com.zj.adlib.sb0;
import com.zj.adlib.zf2;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends MediaChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30921a = "com.apple.streaming.transportStreamTimestamp";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicInteger f4125a = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f4126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DrmInitData f4127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Id3Decoder f4128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsExtractorFactory f4129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final HlsMediaChunkExtractor f4130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HlsSampleStreamWrapper f4131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DataSource f4132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImmutableList<Integer> f4133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f4134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g89 f4135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f4136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final List<d> f4137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4138a;
    public HlsMediaChunkExtractor b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final DataSpec f4139b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f4140b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f4141c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final boolean f4142d;
    public final int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final boolean f4143e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4144f;
    public volatile boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public b(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, d dVar, boolean z, @Nullable DataSource dataSource2, @Nullable DataSpec dataSpec2, boolean z2, Uri uri, @Nullable List<d> list, int i, @Nullable Object obj, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, g89 g89Var, @Nullable DrmInitData drmInitData, @Nullable HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, om6 om6Var, boolean z6, at6 at6Var) {
        super(dataSource, dataSpec, dVar, i, obj, j, j2, j3);
        this.f4142d = z;
        this.e = i2;
        this.j = z3;
        this.d = i3;
        this.f4139b = dataSpec2;
        this.f4132a = dataSource2;
        this.f4144f = dataSpec2 != null;
        this.f4143e = z2;
        this.f4126a = uri;
        this.f4140b = z5;
        this.f4135a = g89Var;
        this.f4141c = z4;
        this.f4129a = hlsExtractorFactory;
        this.f4137a = list;
        this.f4127a = drmInitData;
        this.f4130a = hlsMediaChunkExtractor;
        this.f4128a = id3Decoder;
        this.f4136a = om6Var;
        this.f4138a = z6;
        this.f4134a = at6Var;
        this.f4133a = ImmutableList.of();
        this.c = f4125a.getAndIncrement();
    }

    public static DataSource g(DataSource dataSource, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        sb0.g(bArr2);
        return new n20(dataSource, bArr, bArr2);
    }

    public static b h(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, d dVar, long j, HlsMediaPlaylist hlsMediaPlaylist, a.e eVar, Uri uri, @Nullable List<d> list, int i, @Nullable Object obj, boolean z, h89 h89Var, @Nullable b bVar, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z2, at6 at6Var) {
        DataSource dataSourceG;
        DataSpec dataSpec;
        boolean z3;
        Id3Decoder id3Decoder;
        om6 om6Var;
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        HlsMediaPlaylist.e eVar2 = eVar.f4123a;
        DataSpec dataSpecA = new DataSpec.b().j(rh9.f(((HlsPlaylist) hlsMediaPlaylist).f30928a, eVar2.f)).i(eVar2.c).h(eVar2.d).c(eVar.f4124a ? 8 : 0).a();
        boolean z4 = bArr != null;
        DataSource dataSourceG2 = g(dataSource, bArr, z4 ? j((String) sb0.g(eVar2.h)) : null);
        HlsMediaPlaylist.d dVar2 = eVar2.f4183a;
        if (dVar2 != null) {
            boolean z5 = bArr2 != null;
            byte[] bArrJ = z5 ? j((String) sb0.g(dVar2.h)) : null;
            dataSpec = new DataSpec(rh9.f(((HlsPlaylist) hlsMediaPlaylist).f30928a, dVar2.f), dVar2.c, dVar2.d);
            dataSourceG = g(dataSource, bArr2, bArrJ);
            z3 = z5;
        } else {
            dataSourceG = null;
            dataSpec = null;
            z3 = false;
        }
        long j2 = j + eVar2.b;
        long j3 = j2 + eVar2.f30926a;
        int i2 = hlsMediaPlaylist.b + eVar2.K;
        if (bVar != null) {
            DataSpec dataSpec2 = bVar.f4139b;
            boolean z6 = dataSpec == dataSpec2 || (dataSpec != null && dataSpec2 != null && dataSpec.f5026a.equals(dataSpec2.f5026a) && dataSpec.f5032c == bVar.f4139b.f5032c);
            boolean z7 = uri.equals(bVar.f4126a) && bVar.h;
            id3Decoder = bVar.f4128a;
            om6Var = bVar.f4136a;
            hlsMediaChunkExtractor = (z6 && z7 && !bVar.i && bVar.d == i2) ? bVar.b : null;
        } else {
            id3Decoder = new Id3Decoder();
            om6Var = new om6(10);
            hlsMediaChunkExtractor = null;
        }
        return new b(hlsExtractorFactory, dataSourceG2, dataSpecA, dVar, z4, dataSourceG, dataSpec, z3, uri, list, i, obj, j2, j3, eVar.f4122a, eVar.f30920a, !eVar.f4124a, i2, eVar2.f4184a, z, h89Var.a(i2), eVar2.f4182a, hlsMediaChunkExtractor, id3Decoder, om6Var, z2, at6Var);
    }

    public static byte[] j(String str) {
        if (com.google.common.base.a.g(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean n(a.e eVar, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsMediaPlaylist.e eVar2 = eVar.f4123a;
        if (eVar2 instanceof HlsMediaPlaylist.b) {
            return ((HlsMediaPlaylist.b) eVar2).b || (eVar.f30920a == 0 && ((HlsPlaylist) hlsMediaPlaylist).f4188a);
        }
        return ((HlsPlaylist) hlsMediaPlaylist).f4188a;
    }

    public static boolean u(@Nullable b bVar, Uri uri, HlsMediaPlaylist hlsMediaPlaylist, a.e eVar, long j) {
        if (bVar == null) {
            return false;
        }
        if (uri.equals(bVar.f4126a) && bVar.h) {
            return false;
        }
        return !n(eVar, hlsMediaPlaylist) || j + eVar.f4123a.b < ((Chunk) bVar).c;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.g = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean f() {
        return this.h;
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void i(DataSource dataSource, DataSpec dataSpec, boolean z, boolean z2) throws IOException {
        DataSpec dataSpecE;
        long position;
        long j;
        boolean z3 = false;
        if (z) {
            z3 = this.f != 0;
            dataSpecE = dataSpec;
        } else {
            dataSpecE = dataSpec.e(this.f);
        }
        try {
            zf2 zf2VarS = s(dataSource, dataSpecE, z2);
            if (z3) {
                zf2VarS.skipFully(this.f);
            }
            while (!this.g && this.b.a(zf2VarS)) {
                try {
                    try {
                    } catch (EOFException e) {
                        if ((((Chunk) this).f3837a.L & 16384) == 0) {
                            throw e;
                        }
                        this.b.onTruncatedSegmentParsed();
                        position = zf2VarS.getPosition();
                        j = dataSpec.f5032c;
                    }
                } catch (Throwable th) {
                    this.f = (int) (zf2VarS.getPosition() - dataSpec.f5032c);
                    throw th;
                }
            }
            position = zf2VarS.getPosition();
            j = dataSpec.f5032c;
            this.f = (int) (position - j);
            d72.a(dataSource);
        } catch (Throwable th2) {
            d72.a(dataSource);
            throw th2;
        }
    }

    public int k(int i) {
        sb0.i(!this.f4138a);
        if (i >= this.f4133a.size()) {
            return 0;
        }
        return this.f4133a.get(i).intValue();
    }

    public void l(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList<Integer> immutableList) {
        this.f4131a = hlsSampleStreamWrapper;
        this.f4133a = immutableList;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        sb0.g(this.f4131a);
        if (this.b == null && (hlsMediaChunkExtractor = this.f4130a) != null && hlsMediaChunkExtractor.isReusable()) {
            this.b = this.f4130a;
            this.f4144f = false;
        }
        q();
        if (this.g) {
            return;
        }
        if (!this.f4141c) {
            p();
        }
        this.h = !this.g;
    }

    public void m() {
        this.i = true;
    }

    public boolean o() {
        return this.j;
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void p() throws IOException {
        i(((Chunk) this).f3839a, ((Chunk) this).f3838a, this.f4142d, true);
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void q() throws IOException {
        if (this.f4144f) {
            sb0.g(this.f4132a);
            sb0.g(this.f4139b);
            i(this.f4132a, this.f4139b, this.f4143e, false);
            this.f = 0;
            this.f4144f = false;
        }
    }

    public final long r(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        try {
            this.f4136a.O(10);
            extractorInput.peekFully(this.f4136a.d(), 0, 10);
            if (this.f4136a.J() != 4801587) {
                return -9223372036854775807L;
            }
            this.f4136a.T(3);
            int iF = this.f4136a.F();
            int i = iF + 10;
            if (i > this.f4136a.b()) {
                byte[] bArrD = this.f4136a.d();
                this.f4136a.O(i);
                System.arraycopy(bArrD, 0, this.f4136a.d(), 0, 10);
            }
            extractorInput.peekFully(this.f4136a.d(), 10, iF);
            Metadata metadataD = this.f4128a.d(this.f4136a.d(), iF);
            if (metadataD == null) {
                return -9223372036854775807L;
            }
            int length = metadataD.length();
            for (int i2 = 0; i2 < length; i2++) {
                Metadata.Entry entry = metadataD.get(i2);
                if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                        System.arraycopy(privFrame.privateData, 0, this.f4136a.d(), 0, 8);
                        this.f4136a.S(0);
                        this.f4136a.R(8);
                        return this.f4136a.z() & 8589934591L;
                    }
                }
            }
            return -9223372036854775807L;
        } catch (EOFException unused) {
        }
    }

    @EnsuresNonNull({"extractor"})
    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final zf2 s(DataSource dataSource, DataSpec dataSpec, boolean z) throws IOException {
        long jA = dataSource.a(dataSpec);
        if (z) {
            try {
                this.f4135a.h(this.f4140b, ((Chunk) this).f3841b);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        zf2 zf2Var = new zf2(dataSource, dataSpec.f5032c, jA);
        if (this.b == null) {
            long jR = r(zf2Var);
            zf2Var.resetPeekPosition();
            HlsMediaChunkExtractor hlsMediaChunkExtractor = this.f4130a;
            HlsMediaChunkExtractor hlsMediaChunkExtractorC = hlsMediaChunkExtractor != null ? hlsMediaChunkExtractor.c() : this.f4129a.a(dataSpec.f5026a, ((Chunk) this).f3837a, this.f4137a, this.f4135a, dataSource.getResponseHeaders(), zf2Var, this.f4134a);
            this.b = hlsMediaChunkExtractorC;
            if (hlsMediaChunkExtractorC.isPackedAudioExtractor()) {
                this.f4131a.d0(jR != -9223372036854775807L ? this.f4135a.b(jR) : ((Chunk) this).f3841b);
            } else {
                this.f4131a.d0(0L);
            }
            this.f4131a.P();
            this.b.b(this.f4131a);
        }
        this.f4131a.a0(this.f4127a);
        return zf2Var;
    }

    public void t() {
        this.j = true;
    }
}
