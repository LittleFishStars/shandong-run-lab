package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.o;
import com.zj.adlib.az4;
import com.zj.adlib.bp5;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.m53;
import com.zj.adlib.oh5;
import com.zj.adlib.om6;
import com.zj.adlib.s04;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    public static final int Q = -1;
    public static final int R = -2;
    public static final int S = -3;
    public static final Set<Integer> c = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public static final String g = "HlsSampleStreamWrapper";
    public final int K;
    public final int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f4057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseIntArray f4058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final d f4059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DrmInitData f4060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionEventListener.a f4061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f4062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f4063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f4064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Chunk f4065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Callback f4066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.source.hls.a f4068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.source.hls.b f4069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f4070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ga9 f4073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<com.google.android.exoplayer2.source.hls.b> f4075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<com.google.android.exoplayer2.source.hls.b> f4076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, DrmInitData> f4077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Set<Integer> f4078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c[] f4081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f4082a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public d f4083b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f4084b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<s04> f4085b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Set<da9> f4086b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4087b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f4088b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean[] f4089b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f4090c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public d f4091c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4092c;
    public boolean d;
    public boolean e;
    public final String f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4093f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4094g;
    public boolean h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Loader f4072a = new Loader("Loader:HlsSampleStreamWrapper");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.source.hls.a.b f4067a = new com.google.android.exoplayer2.source.hls.a.b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f4080a = new int[0];

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(Uri uri);

        void onPrepared();
    }

    public static class b implements TrackOutput {
        public static final d c = new d.b().e0("application/id3").E();
        public static final d d = new d.b().e0("application/x-emsg").E();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f30915a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f4095a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final m53 f4096a = new m53();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f4097a;
        public d b;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public int f4098d;

        public b(TrackOutput trackOutput, int i) {
            this.f4095a = trackOutput;
            if (i == 1) {
                this.f30915a = c;
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i);
                }
                this.f30915a = d;
            }
            this.f4097a = new byte[0];
            this.f4098d = 0;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void a(om6 om6Var, int i, int i2) {
            h(this.f4098d + i);
            om6Var.k(this.f4097a, this.f4098d, i);
            this.f4098d += i;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int d(DataReader dataReader, int i, boolean z, int i2) throws IOException {
            h(this.f4098d + i);
            int i3 = dataReader.read(this.f4097a, this.f4098d, i);
            if (i3 != -1) {
                this.f4098d += i3;
                return i3;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void e(long j, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
            sb0.g(this.b);
            om6 om6VarI = i(i2, i3);
            if (!gj9.c(this.b.k, this.f30915a.k)) {
                if (!"application/x-emsg".equals(this.b.k)) {
                    Log.n(HlsSampleStreamWrapper.g, "Ignoring sample for unsupported format: " + this.b.k);
                    return;
                }
                EventMessage eventMessageB = this.f4096a.b(om6VarI);
                if (!g(eventMessageB)) {
                    Log.n(HlsSampleStreamWrapper.g, String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f30915a.k, eventMessageB.getWrappedMetadataFormat()));
                    return;
                }
                om6VarI = new om6((byte[]) sb0.g(eventMessageB.getWrappedMetadataBytes()));
            }
            int iA = om6VarI.a();
            this.f4095a.c(om6VarI, iA);
            this.f4095a.e(j, i, iA, i3, aVar);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void f(d dVar) {
            this.b = dVar;
            this.f4095a.f(this.f30915a);
        }

        public final boolean g(EventMessage eventMessage) {
            d wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && gj9.c(this.f30915a.k, wrappedMetadataFormat.k);
        }

        public final void h(int i) {
            byte[] bArr = this.f4097a;
            if (bArr.length < i) {
                this.f4097a = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        public final om6 i(int i, int i2) {
            int i3 = this.f4098d - i2;
            om6 om6Var = new om6(Arrays.copyOfRange(this.f4097a, i3 - i, i3));
            byte[] bArr = this.f4097a;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.f4098d = i2;
            return om6Var;
        }
    }

    public static final class c extends SampleQueue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public DrmInitData f30916a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<String, DrmInitData> f4099a;

        @Override // com.google.android.exoplayer2.source.SampleQueue, com.google.android.exoplayer2.extractor.TrackOutput
        public void e(long j, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
            super.e(j, i, i2, i3, aVar);
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue
        public d getAdjustedUpstreamFormat(d dVar) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.f30916a;
            if (drmInitData2 == null) {
                drmInitData2 = dVar.f2566a;
            }
            if (drmInitData2 != null && (drmInitData = this.f4099a.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadataH0 = h0(dVar.f2567a);
            if (drmInitData2 != dVar.f2566a || metadataH0 != dVar.f2567a) {
                dVar = dVar.b().M(drmInitData2).X(metadataH0).E();
            }
            return super.getAdjustedUpstreamFormat(dVar);
        }

        @Nullable
        public final Metadata h0(@Nullable Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[length - 1];
            while (i < length) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                }
                i++;
            }
            return new Metadata(entryArr);
        }

        public void i0(@Nullable DrmInitData drmInitData) {
            this.f30916a = drmInitData;
            invalidateUpstreamFormatAdjustment();
        }

        public void j0(com.google.android.exoplayer2.source.hls.b bVar) {
            f0(bVar.c);
        }

        public c(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar, Map<String, DrmInitData> map) {
            super(allocator, drmSessionManager, aVar);
            this.f4099a = map;
        }
    }

    public HlsSampleStreamWrapper(String str, int i, Callback callback, com.google.android.exoplayer2.source.hls.a aVar, Map<String, DrmInitData> map, Allocator allocator, long j, @Nullable d dVar, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar3, int i2) {
        this.f = str;
        this.K = i;
        this.f4066a = callback;
        this.f4068a = aVar;
        this.f4077a = map;
        this.f4070a = allocator;
        this.f4059a = dVar;
        this.f4062a = drmSessionManager;
        this.f4061a = aVar2;
        this.f4071a = loadErrorHandlingPolicy;
        this.f4064a = aVar3;
        this.L = i2;
        Set<Integer> set = c;
        this.f4078a = new HashSet(set.size());
        this.f4058a = new SparseIntArray(set.size());
        this.f4081a = new c[0];
        this.f4089b = new boolean[0];
        this.f4082a = new boolean[0];
        ArrayList<com.google.android.exoplayer2.source.hls.b> arrayList = new ArrayList<>();
        this.f4075a = arrayList;
        this.f4076a = Collections.unmodifiableList(arrayList);
        this.f4085b = new ArrayList<>();
        this.f4074a = new Runnable() { // from class: com.zj.adlib.v04
            @Override // java.lang.Runnable
            public final void run() {
                this.f45264a.H();
            }
        };
        this.f4084b = new Runnable() { // from class: com.zj.adlib.w04
            @Override // java.lang.Runnable
            public final void run() {
                this.f45500a.S();
            }
        };
        this.f4057a = gj9.y();
        this.f30914a = j;
        this.b = j;
    }

    public static boolean C(Chunk chunk) {
        return chunk instanceof com.google.android.exoplayer2.source.hls.b;
    }

    public static com.google.android.exoplayer2.extractor.d o(int i, int i2) {
        Log.n(g, "Unmapped track with id " + i + " of type " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public static d r(@Nullable d dVar, d dVar2, boolean z) {
        String strD;
        String strG;
        if (dVar == null) {
            return dVar2;
        }
        int iL = bp5.l(dVar2.k);
        if (gj9.S(dVar.i, iL) == 1) {
            strD = gj9.T(dVar.i, iL);
            strG = bp5.g(strD);
        } else {
            strD = bp5.d(dVar.i, dVar2.k);
            strG = dVar2.k;
        }
        d.b bVarI = dVar2.b().S(dVar.f).U(dVar.g).V(dVar.h).g0(dVar.K).c0(dVar.L).G(z ? dVar.M : -1).Z(z ? dVar.N : -1).I(strD);
        if (iL == 2) {
            bVarI.j0(dVar.Q).Q(dVar.R).P(dVar.f2564a);
        }
        if (strG != null) {
            bVarI.e0(strG);
        }
        int i = dVar.U;
        if (i != -1 && iL == 1) {
            bVarI.H(i);
        }
        Metadata metadataCopyWithAppendedEntriesFrom = dVar.f2567a;
        if (metadataCopyWithAppendedEntriesFrom != null) {
            Metadata metadata = dVar2.f2567a;
            if (metadata != null) {
                metadataCopyWithAppendedEntriesFrom = metadata.copyWithAppendedEntriesFrom(metadataCopyWithAppendedEntriesFrom);
            }
            bVarI.X(metadataCopyWithAppendedEntriesFrom);
        }
        return bVarI.E();
    }

    public static boolean v(d dVar, d dVar2) {
        String str = dVar.k;
        String str2 = dVar2.k;
        int iL = bp5.l(str);
        if (iL != 3) {
            return iL == bp5.l(str2);
        }
        if (gj9.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || dVar.Z == dVar2.Z;
        }
        return false;
    }

    public static int z(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public final void B(com.google.android.exoplayer2.source.hls.b bVar) {
        this.f4069a = bVar;
        this.f4083b = ((Chunk) bVar).f3837a;
        this.b = -9223372036854775807L;
        this.f4075a.add(bVar);
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (c cVar : this.f4081a) {
            aVarBuilder.a(Integer.valueOf(cVar.H()));
        }
        bVar.l(this, aVarBuilder.e());
        for (c cVar2 : this.f4081a) {
            cVar2.j0(bVar);
            if (bVar.f4138a) {
                cVar2.g0();
            }
        }
    }

    public final boolean D() {
        return this.b != -9223372036854775807L;
    }

    public boolean E(int i) {
        return !D() && this.f4081a[i].K(this.f4094g);
    }

    public boolean F() {
        return this.M == 2;
    }

    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    @RequiresNonNull({"trackGroups"})
    public final void G() {
        int i = this.f4073a.K;
        int[] iArr = new int[i];
        this.f4088b = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                c[] cVarArr = this.f4081a;
                if (i3 >= cVarArr.length) {
                    break;
                }
                if (v((d) sb0.k(cVarArr[i3].G()), this.f4073a.b(i2).c(0))) {
                    this.f4088b[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        Iterator<s04> it = this.f4085b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void H() {
        if (!this.f4092c && this.f4088b == null && this.f4079a) {
            for (c cVar : this.f4081a) {
                if (cVar.G() == null) {
                    return;
                }
            }
            if (this.f4073a != null) {
                G();
                return;
            }
            l();
            b0();
            this.f4066a.onPrepared();
        }
    }

    public void I() throws IOException {
        this.f4072a.maybeThrowError();
        this.f4068a.n();
    }

    public void J(int i) throws IOException {
        I();
        this.f4081a[i].N();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void M(Chunk chunk, long j, long j2, boolean z) {
        this.f4065a = null;
        az4 az4Var = new az4(chunk.f3836a, chunk.f3838a, chunk.d(), chunk.c(), j, j2, chunk.a());
        this.f4071a.onLoadTaskConcluded(chunk.f3836a);
        this.f4064a.r(az4Var, chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c);
        if (z) {
            return;
        }
        if (D() || this.O == 0) {
            W();
        }
        if (this.O > 0) {
            this.f4066a.d(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void K(Chunk chunk, long j, long j2) {
        this.f4065a = null;
        this.f4068a.p(chunk);
        az4 az4Var = new az4(chunk.f3836a, chunk.f3838a, chunk.d(), chunk.c(), j, j2, chunk.a());
        this.f4071a.onLoadTaskConcluded(chunk.f3836a);
        this.f4064a.u(az4Var, chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c);
        if (this.f4087b) {
            this.f4066a.d(this);
        } else {
            continueLoading(this.f30914a);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public Loader.b A(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.b bVarG;
        int i2;
        boolean zC = C(chunk);
        if (zC && !((com.google.android.exoplayer2.source.hls.b) chunk).o() && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode) == 410 || i2 == 404)) {
            return Loader.f5047a;
        }
        long jA = chunk.a();
        az4 az4Var = new az4(chunk.f3836a, chunk.f3838a, chunk.d(), chunk.c(), j, j2, jA);
        LoadErrorHandlingPolicy.c cVar = new LoadErrorHandlingPolicy.c(az4Var, new oh5(chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, gj9.H1(chunk.f3841b), gj9.H1(chunk.c)), iOException, i);
        LoadErrorHandlingPolicy.b bVarA = this.f4071a.a(TrackSelectionUtil.c(this.f4068a.k()), cVar);
        boolean zM = (bVarA == null || bVarA.f31114a != 2) ? false : this.f4068a.m(chunk, bVarA.f5043a);
        if (zM) {
            if (zC && jA == 0) {
                ArrayList<com.google.android.exoplayer2.source.hls.b> arrayList = this.f4075a;
                sb0.i(arrayList.remove(arrayList.size() - 1) == chunk);
                if (this.f4075a.isEmpty()) {
                    this.b = this.f30914a;
                } else {
                    ((com.google.android.exoplayer2.source.hls.b) o.w(this.f4075a)).m();
                }
            }
            bVarG = Loader.f5050c;
        } else {
            long jB = this.f4071a.b(cVar);
            bVarG = jB != -9223372036854775807L ? Loader.g(false, jB) : Loader.f5051d;
        }
        Loader.b bVar = bVarG;
        boolean z = !bVar.c();
        this.f4064a.w(az4Var, chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c, iOException, z);
        if (z) {
            this.f4065a = null;
            this.f4071a.onLoadTaskConcluded(chunk.f3836a);
        }
        if (zM) {
            if (this.f4087b) {
                this.f4066a.d(this);
            } else {
                continueLoading(this.f30914a);
            }
        }
        return bVar;
    }

    public void P() {
        this.f4078a.clear();
    }

    public boolean Q(Uri uri, LoadErrorHandlingPolicy.c cVar, boolean z) {
        LoadErrorHandlingPolicy.b bVarA;
        if (!this.f4068a.o(uri)) {
            return true;
        }
        long j = (z || (bVarA = this.f4071a.a(TrackSelectionUtil.c(this.f4068a.k()), cVar)) == null || bVarA.f31114a != 2) ? -9223372036854775807L : bVarA.f5043a;
        return this.f4068a.q(uri, j) && j != -9223372036854775807L;
    }

    public void R() {
        if (this.f4075a.isEmpty()) {
            return;
        }
        com.google.android.exoplayer2.source.hls.b bVar = (com.google.android.exoplayer2.source.hls.b) o.w(this.f4075a);
        int iC = this.f4068a.c(bVar);
        if (iC == 1) {
            bVar.t();
        } else if (iC == 2 && !this.f4094g && this.f4072a.i()) {
            this.f4072a.e();
        }
    }

    public final void S() {
        this.f4079a = true;
        H();
    }

    public void T(da9[] da9VarArr, int i, int... iArr) {
        this.f4073a = q(da9VarArr);
        this.f4086b = new HashSet();
        for (int i2 : iArr) {
            this.f4086b.add(this.f4073a.b(i2));
        }
        this.P = i;
        Handler handler = this.f4057a;
        final Callback callback = this.f4066a;
        Objects.requireNonNull(callback);
        handler.post(new Runnable() { // from class: com.zj.adlib.u04
            @Override // java.lang.Runnable
            public final void run() {
                callback.onPrepared();
            }
        });
        b0();
    }

    public int U(int i, yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (D()) {
            return -3;
        }
        int i3 = 0;
        if (!this.f4075a.isEmpty()) {
            int i4 = 0;
            while (i4 < this.f4075a.size() - 1 && u(this.f4075a.get(i4))) {
                i4++;
            }
            gj9.m1(this.f4075a, 0, i4);
            com.google.android.exoplayer2.source.hls.b bVar = this.f4075a.get(0);
            d dVar = ((Chunk) bVar).f3837a;
            if (!dVar.equals(this.f4091c)) {
                this.f4064a.i(this.K, dVar, ((Chunk) bVar).b, ((Chunk) bVar).f3840a, ((Chunk) bVar).f3841b);
            }
            this.f4091c = dVar;
        }
        if (!this.f4075a.isEmpty() && !this.f4075a.get(0).o()) {
            return -3;
        }
        int iS = this.f4081a[i].S(yk3Var, decoderInputBuffer, i2, this.f4094g);
        if (iS == -5) {
            d dVarA = (d) sb0.g(yk3Var.f46052a);
            if (i == this.N) {
                int iQ = this.f4081a[i].Q();
                while (i3 < this.f4075a.size() && this.f4075a.get(i3).c != iQ) {
                    i3++;
                }
                dVarA = dVarA.A(i3 < this.f4075a.size() ? ((Chunk) this.f4075a.get(i3)).f3837a : (d) sb0.g(this.f4083b));
            }
            yk3Var.f46052a = dVarA;
        }
        return iS;
    }

    public void V() {
        if (this.f4087b) {
            for (c cVar : this.f4081a) {
                cVar.R();
            }
        }
        this.f4072a.k(this);
        this.f4057a.removeCallbacksAndMessages(null);
        this.f4092c = true;
        this.f4085b.clear();
    }

    public final void W() {
        for (c cVar : this.f4081a) {
            cVar.W(this.e);
        }
        this.e = false;
    }

    public final boolean X(long j) {
        int length = this.f4081a.length;
        for (int i = 0; i < length; i++) {
            if (!this.f4081a[i].Z(j, false) && (this.f4089b[i] || !this.d)) {
                return false;
            }
        }
        return true;
    }

    public boolean Y(long j, boolean z) {
        this.f30914a = j;
        if (D()) {
            this.b = j;
            return true;
        }
        if (this.f4079a && !z && X(j)) {
            return false;
        }
        this.b = j;
        this.f4094g = false;
        this.f4075a.clear();
        if (this.f4072a.i()) {
            if (this.f4079a) {
                for (c cVar : this.f4081a) {
                    cVar.s();
                }
            }
            this.f4072a.e();
        } else {
            this.f4072a.f();
            W();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0120  */
    /* JADX WARN: Code duplicated, block: B:73:0x0129  */
    public boolean Z(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        j();
        int i = this.O;
        int i2 = 0;
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            s04 s04Var = (s04) sampleStreamArr[i3];
            if (s04Var != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                this.O--;
                s04Var.d();
                sampleStreamArr[i3] = null;
            }
        }
        boolean z4 = z || (!this.f4093f ? j == this.f30914a : i != 0);
        ExoTrackSelection exoTrackSelectionK = this.f4068a.k();
        boolean z5 = z4;
        ExoTrackSelection exoTrackSelection = exoTrackSelectionK;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr[i4];
            if (exoTrackSelection2 != null) {
                int iC = this.f4073a.c(exoTrackSelection2.d());
                if (iC == this.P) {
                    this.f4068a.u(exoTrackSelection2);
                    exoTrackSelection = exoTrackSelection2;
                }
                if (sampleStreamArr[i4] == null) {
                    this.O++;
                    s04 s04Var2 = new s04(this, iC);
                    sampleStreamArr[i4] = s04Var2;
                    zArr2[i4] = true;
                    if (this.f4088b != null) {
                        s04Var2.a();
                        if (!z5) {
                            c cVar = this.f4081a[this.f4088b[iC]];
                            z5 = (cVar.Z(j, true) || cVar.D() == 0) ? false : true;
                        }
                    }
                }
            }
        }
        if (this.O == 0) {
            this.f4068a.r();
            this.f4091c = null;
            this.e = true;
            this.f4075a.clear();
            if (this.f4072a.i()) {
                if (this.f4079a) {
                    c[] cVarArr = this.f4081a;
                    int length = cVarArr.length;
                    while (i2 < length) {
                        cVarArr[i2].s();
                        i2++;
                    }
                }
                this.f4072a.e();
            } else {
                W();
            }
        } else {
            if (this.f4075a.isEmpty() || gj9.c(exoTrackSelection, exoTrackSelectionK)) {
                z2 = z;
            } else {
                if (this.f4093f) {
                    z3 = true;
                } else {
                    long j2 = j < 0 ? -j : 0L;
                    com.google.android.exoplayer2.source.hls.b bVarW = w();
                    exoTrackSelection.c(j, j2, -9223372036854775807L, this.f4076a, this.f4068a.a(bVarW, j));
                    if (exoTrackSelection.getSelectedIndexInTrackGroup() != this.f4068a.j().d(((Chunk) bVarW).f3837a)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    this.e = true;
                    z2 = true;
                    z5 = true;
                } else {
                    z2 = z;
                }
            }
            if (z5) {
                Y(j, z2);
                while (i2 < sampleStreamArr.length) {
                    if (sampleStreamArr[i2] != null) {
                        zArr2[i2] = true;
                    }
                    i2++;
                }
            }
        }
        g0(sampleStreamArr);
        this.f4093f = true;
        return z5;
    }

    public long a(long j, w38 w38Var) {
        return this.f4068a.b(j, w38Var);
    }

    public void a0(@Nullable DrmInitData drmInitData) {
        if (gj9.c(this.f4060a, drmInitData)) {
            return;
        }
        this.f4060a = drmInitData;
        int i = 0;
        while (true) {
            c[] cVarArr = this.f4081a;
            if (i >= cVarArr.length) {
                return;
            }
            if (this.f4089b[i]) {
                cVarArr[i].i0(drmInitData);
            }
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput b(int i, int i2) {
        TrackOutput trackOutputP;
        if (!c.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.f4081a;
                if (i3 >= trackOutputArr.length) {
                    trackOutputP = null;
                    break;
                }
                if (this.f4080a[i3] == i) {
                    trackOutputP = trackOutputArr[i3];
                    break;
                }
                i3++;
            }
        } else {
            trackOutputP = x(i, i2);
        }
        if (trackOutputP == null) {
            if (this.h) {
                return o(i, i2);
            }
            trackOutputP = p(i, i2);
        }
        if (i2 != 5) {
            return trackOutputP;
        }
        if (this.f4063a == null) {
            this.f4063a = new b(trackOutputP, this.L);
        }
        return this.f4063a;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void b0() {
        this.f4087b = true;
    }

    public void c0(boolean z) {
        this.f4068a.t(z);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        List<com.google.android.exoplayer2.source.hls.b> listEmptyList;
        long jMax;
        if (this.f4094g || this.f4072a.i() || this.f4072a.h()) {
            return false;
        }
        if (D()) {
            listEmptyList = Collections.emptyList();
            jMax = this.b;
            for (c cVar : this.f4081a) {
                cVar.b0(this.b);
            }
        } else {
            listEmptyList = this.f4076a;
            com.google.android.exoplayer2.source.hls.b bVarW = w();
            jMax = bVarW.f() ? ((Chunk) bVarW).c : Math.max(this.f30914a, ((Chunk) bVarW).f3841b);
        }
        List<com.google.android.exoplayer2.source.hls.b> list = listEmptyList;
        long j2 = jMax;
        this.f4067a.a();
        this.f4068a.e(j, j2, list, this.f4087b || !list.isEmpty(), this.f4067a);
        com.google.android.exoplayer2.source.hls.a.b bVar = this.f4067a;
        boolean z = bVar.f4120a;
        Chunk chunk = bVar.f4119a;
        Uri uri = bVar.f30918a;
        if (z) {
            this.b = -9223372036854775807L;
            this.f4094g = true;
            return true;
        }
        if (chunk == null) {
            if (uri != null) {
                this.f4066a.onPlaylistRefreshRequired(uri);
            }
            return false;
        }
        if (C(chunk)) {
            B((com.google.android.exoplayer2.source.hls.b) chunk);
        }
        this.f4065a = chunk;
        this.f4064a.A(new az4(chunk.f3836a, chunk.f3838a, this.f4072a.l(chunk, this, this.f4071a.getMinimumLoadableRetryCount(chunk.f30858a))), chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void d(SeekMap seekMap) {
    }

    public void d0(long j) {
        if (this.f4090c != j) {
            this.f4090c = j;
            for (c cVar : this.f4081a) {
                cVar.a0(j);
            }
        }
    }

    public void discardBuffer(long j, boolean z) {
        if (!this.f4079a || D()) {
            return;
        }
        int length = this.f4081a.length;
        for (int i = 0; i < length; i++) {
            this.f4081a[i].r(j, z, this.f4082a[i]);
        }
    }

    public ga9 e() {
        j();
        return this.f4073a;
    }

    public int e0(int i, long j) {
        if (D()) {
            return 0;
        }
        c cVar = this.f4081a[i];
        int iF = cVar.F(j, this.f4094g);
        com.google.android.exoplayer2.source.hls.b bVar = (com.google.android.exoplayer2.source.hls.b) o.x(this.f4075a, null);
        if (bVar != null && !bVar.o()) {
            iF = Math.min(iF, bVar.k(i) - cVar.D());
        }
        cVar.e0(iF);
        return iF;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.h = true;
        this.f4057a.post(this.f4084b);
    }

    public void f0(int i) {
        j();
        sb0.g(this.f4088b);
        int i2 = this.f4088b[i];
        sb0.i(this.f4082a[i2]);
        this.f4082a[i2] = false;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void g(d dVar) {
        this.f4057a.post(this.f4074a);
    }

    public final void g0(SampleStream[] sampleStreamArr) {
        this.f4085b.clear();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream != null) {
                this.f4085b.add((s04) sampleStream);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.f4094g) {
            return Long.MIN_VALUE;
        }
        if (D()) {
            return this.b;
        }
        long jMax = this.f30914a;
        com.google.android.exoplayer2.source.hls.b bVarW = w();
        if (!bVarW.f()) {
            if (this.f4075a.size() > 1) {
                ArrayList<com.google.android.exoplayer2.source.hls.b> arrayList = this.f4075a;
                bVarW = arrayList.get(arrayList.size() - 2);
            } else {
                bVarW = null;
            }
        }
        if (bVarW != null) {
            jMax = Math.max(jMax, ((Chunk) bVarW).c);
        }
        if (this.f4079a) {
            for (c cVar : this.f4081a) {
                jMax = Math.max(jMax, cVar.A());
            }
        }
        return jMax;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (D()) {
            return this.b;
        }
        if (this.f4094g) {
            return Long.MIN_VALUE;
        }
        return ((Chunk) w()).c;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f4072a.i();
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void j() {
        sb0.i(this.f4087b);
        sb0.g(this.f4073a);
        sb0.g(this.f4086b);
    }

    public int k(int i) {
        j();
        sb0.g(this.f4088b);
        int i2 = this.f4088b[i];
        if (i2 == -1) {
            return this.f4086b.contains(this.f4073a.b(i)) ? -3 : -2;
        }
        boolean[] zArr = this.f4082a;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    public final void l() {
        d dVar;
        int length = this.f4081a.length;
        int i = -2;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = 2;
            if (i3 >= length) {
                break;
            }
            String str = ((d) sb0.k(this.f4081a[i3].G())).k;
            if (!bp5.t(str)) {
                i4 = bp5.p(str) ? 1 : bp5.s(str) ? 3 : -2;
            }
            if (z(i4) > z(i)) {
                i2 = i3;
                i = i4;
            } else if (i4 == i && i2 != -1) {
                i2 = -1;
            }
            i3++;
        }
        da9 da9VarJ = this.f4068a.j();
        int i5 = da9VarJ.K;
        this.P = -1;
        this.f4088b = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.f4088b[i6] = i6;
        }
        da9[] da9VarArr = new da9[length];
        int i7 = 0;
        while (i7 < length) {
            d dVar2 = (d) sb0.k(this.f4081a[i7].G());
            if (i7 == i2) {
                d[] dVarArr = new d[i5];
                for (int i8 = 0; i8 < i5; i8++) {
                    d dVarC = da9VarJ.c(i8);
                    if (i == 1 && (dVar = this.f4059a) != null) {
                        dVarC = dVarC.A(dVar);
                    }
                    dVarArr[i8] = i5 == 1 ? dVar2.A(dVarC) : r(dVarC, dVar2, true);
                }
                da9VarArr[i7] = new da9(this.f, dVarArr);
                this.P = i7;
            } else {
                d dVar3 = (i == 2 && bp5.p(dVar2.k)) ? this.f4059a : null;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f);
                sb.append(":muxed:");
                sb.append(i7 < i2 ? i7 : i7 - 1);
                da9VarArr[i7] = new da9(sb.toString(), r(dVar3, dVar2, false));
            }
            i7++;
        }
        this.f4073a = q(da9VarArr);
        sb0.i(this.f4086b == null);
        this.f4086b = Collections.emptySet();
    }

    public final boolean m(int i) {
        for (int i2 = i; i2 < this.f4075a.size(); i2++) {
            if (this.f4075a.get(i2).f4138a) {
                return false;
            }
        }
        com.google.android.exoplayer2.source.hls.b bVar = this.f4075a.get(i);
        for (int i3 = 0; i3 < this.f4081a.length; i3++) {
            if (this.f4081a[i3].D() > bVar.k(i3)) {
                return false;
            }
        }
        return true;
    }

    public void maybeThrowPrepareError() throws IOException {
        I();
        if (this.f4094g && !this.f4087b) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    public void n() {
        if (this.f4087b) {
            return;
        }
        continueLoading(this.f30914a);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (c cVar : this.f4081a) {
            cVar.T();
        }
    }

    public final SampleQueue p(int i, int i2) {
        int length = this.f4081a.length;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        c cVar = new c(this.f4070a, this.f4062a, this.f4061a, this.f4077a);
        cVar.b0(this.f30914a);
        if (z) {
            cVar.i0(this.f4060a);
        }
        cVar.a0(this.f4090c);
        com.google.android.exoplayer2.source.hls.b bVar = this.f4069a;
        if (bVar != null) {
            cVar.j0(bVar);
        }
        cVar.d0(this);
        int i3 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.f4080a, i3);
        this.f4080a = iArrCopyOf;
        iArrCopyOf[length] = i;
        this.f4081a = (c[]) gj9.c1(this.f4081a, cVar);
        boolean[] zArrCopyOf = Arrays.copyOf(this.f4089b, i3);
        this.f4089b = zArrCopyOf;
        zArrCopyOf[length] = z;
        this.d |= z;
        this.f4078a.add(Integer.valueOf(i2));
        this.f4058a.append(i2, length);
        if (z(i2) > z(this.M)) {
            this.N = length;
            this.M = i2;
        }
        this.f4082a = Arrays.copyOf(this.f4082a, i3);
        return cVar;
    }

    public final ga9 q(da9[] da9VarArr) {
        for (int i = 0; i < da9VarArr.length; i++) {
            da9 da9Var = da9VarArr[i];
            d[] dVarArr = new d[da9Var.K];
            for (int i2 = 0; i2 < da9Var.K; i2++) {
                d dVarC = da9Var.c(i2);
                dVarArr[i2] = dVarC.d(this.f4062a.a(dVarC));
            }
            da9VarArr[i] = new da9(da9Var.f, dVarArr);
        }
        return new ga9(da9VarArr);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        if (this.f4072a.h() || D()) {
            return;
        }
        if (this.f4072a.i()) {
            sb0.g(this.f4065a);
            if (this.f4068a.v(j, this.f4065a, this.f4076a)) {
                this.f4072a.e();
                return;
            }
            return;
        }
        int size = this.f4076a.size();
        while (size > 0 && this.f4068a.c(this.f4076a.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f4076a.size()) {
            s(size);
        }
        int iH = this.f4068a.h(j, this.f4076a);
        if (iH < this.f4075a.size()) {
            s(iH);
        }
    }

    public final void s(int i) {
        sb0.i(!this.f4072a.i());
        while (true) {
            if (i >= this.f4075a.size()) {
                i = -1;
                break;
            } else if (m(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = ((Chunk) w()).c;
        com.google.android.exoplayer2.source.hls.b bVarT = t(i);
        if (this.f4075a.isEmpty()) {
            this.b = this.f30914a;
        } else {
            ((com.google.android.exoplayer2.source.hls.b) o.w(this.f4075a)).m();
        }
        this.f4094g = false;
        this.f4064a.D(this.M, ((Chunk) bVarT).f3841b, j);
    }

    public final com.google.android.exoplayer2.source.hls.b t(int i) {
        com.google.android.exoplayer2.source.hls.b bVar = this.f4075a.get(i);
        ArrayList<com.google.android.exoplayer2.source.hls.b> arrayList = this.f4075a;
        gj9.m1(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.f4081a.length; i2++) {
            this.f4081a[i2].w(bVar.k(i2));
        }
        return bVar;
    }

    public final boolean u(com.google.android.exoplayer2.source.hls.b bVar) {
        int i = bVar.c;
        int length = this.f4081a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f4082a[i2] && this.f4081a[i2].Q() == i) {
                return false;
            }
        }
        return true;
    }

    public final com.google.android.exoplayer2.source.hls.b w() {
        ArrayList<com.google.android.exoplayer2.source.hls.b> arrayList = this.f4075a;
        return arrayList.get(arrayList.size() - 1);
    }

    @Nullable
    public final TrackOutput x(int i, int i2) {
        sb0.a(c.contains(Integer.valueOf(i2)));
        int i3 = this.f4058a.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.f4078a.add(Integer.valueOf(i2))) {
            this.f4080a[i3] = i;
        }
        return this.f4080a[i3] == i ? this.f4081a[i3] : o(i, i2);
    }

    public int y() {
        return this.P;
    }
}
