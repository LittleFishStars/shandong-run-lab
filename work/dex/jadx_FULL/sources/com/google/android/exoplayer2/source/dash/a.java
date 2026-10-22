package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.at6;
import com.zj.adlib.c62;
import com.zj.adlib.f62;
import com.zj.adlib.g62;
import com.zj.adlib.gj9;
import com.zj.adlib.ka7;
import com.zj.adlib.qi8;
import com.zj.adlib.uk1;
import com.zj.adlib.vr0;
import com.zj.adlib.vz;
import com.zj.adlib.w38;
import com.zj.adlib.xr0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements DashChunkSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final PlayerEmsgHandler.b f3967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExoTrackSelection f3968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f3969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoaderErrorThrower f3970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c62 f3971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xr0 f3972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IOException f3973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b[] f3976a;
    public final int b;
    public int c;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.a$a, reason: collision with other inner class name */
    public static final class C0688a implements DashChunkSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30889a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ChunkExtractor.Factory f3977a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSource.Factory f3978a;

        public C0688a(DataSource.Factory factory) {
            this(factory, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource a(LoaderErrorThrower loaderErrorThrower, c62 c62Var, xr0 xr0Var, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, long j, boolean z, List<d> list, @Nullable PlayerEmsgHandler.b bVar, @Nullable TransferListener transferListener, at6 at6Var) {
            DataSource dataSourceA = this.f3978a.a();
            if (transferListener != null) {
                dataSourceA.b(transferListener);
            }
            return new a(this.f3977a, loaderErrorThrower, c62Var, xr0Var, i, iArr, exoTrackSelection, i2, dataSourceA, j, this.f30889a, z, list, bVar, at6Var);
        }

        public C0688a(DataSource.Factory factory, int i) {
            this(com.google.android.exoplayer2.source.chunk.b.f30864a, factory, i);
        }

        public C0688a(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i) {
            this.f3977a = factory;
            this.f3978a = factory2;
            this.f30889a = i;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30890a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final ChunkExtractor f3979a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final DashSegmentIndex f3980a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Representation f3981a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final vr0 f3982a;
        public final long b;

        public b(long j, Representation representation, vr0 vr0Var, @Nullable ChunkExtractor chunkExtractor, long j2, @Nullable DashSegmentIndex dashSegmentIndex) {
            this.f30890a = j;
            this.f3981a = representation;
            this.f3982a = vr0Var;
            this.b = j2;
            this.f3979a = chunkExtractor;
            this.f3980a = dashSegmentIndex;
        }

        @CheckResult
        public b b(long j, Representation representation) throws BehindLiveWindowException {
            long jE;
            long jE2;
            DashSegmentIndex dashSegmentIndexK = this.f3981a.k();
            DashSegmentIndex dashSegmentIndexK2 = representation.k();
            if (dashSegmentIndexK == null) {
                return new b(j, representation, this.f3982a, this.f3979a, this.b, dashSegmentIndexK);
            }
            if (!dashSegmentIndexK.a()) {
                return new b(j, representation, this.f3982a, this.f3979a, this.b, dashSegmentIndexK2);
            }
            long jG = dashSegmentIndexK.g(j);
            if (jG == 0) {
                return new b(j, representation, this.f3982a, this.f3979a, this.b, dashSegmentIndexK2);
            }
            long jF = dashSegmentIndexK.f();
            long timeUs = dashSegmentIndexK.getTimeUs(jF);
            long j2 = (jG + jF) - 1;
            long timeUs2 = dashSegmentIndexK.getTimeUs(j2) + dashSegmentIndexK.c(j2, j);
            long jF2 = dashSegmentIndexK2.f();
            long timeUs3 = dashSegmentIndexK2.getTimeUs(jF2);
            long j3 = this.b;
            if (timeUs2 != timeUs3) {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    jE2 = j3 - (dashSegmentIndexK2.e(timeUs, j) - jF);
                } else {
                    jE = dashSegmentIndexK.e(timeUs3, j);
                }
                return new b(j, representation, this.f3982a, this.f3979a, jE2, dashSegmentIndexK2);
            }
            jE = j2 + 1;
            jE2 = j3 + (jE - jF2);
            return new b(j, representation, this.f3982a, this.f3979a, jE2, dashSegmentIndexK2);
        }

        @CheckResult
        public b c(DashSegmentIndex dashSegmentIndex) {
            return new b(this.f30890a, this.f3981a, this.f3982a, this.f3979a, this.b, dashSegmentIndex);
        }

        @CheckResult
        public b d(vr0 vr0Var) {
            return new b(this.f30890a, this.f3981a, vr0Var, this.f3979a, this.b, this.f3980a);
        }

        public long e(long j) {
            return this.f3980a.h(this.f30890a, j) + this.b;
        }

        public long f() {
            return this.f3980a.f() + this.b;
        }

        public long g(long j) {
            return (e(j) + this.f3980a.i(this.f30890a, j)) - 1;
        }

        public long h() {
            return this.f3980a.g(this.f30890a);
        }

        public long i(long j) {
            return k(j) + this.f3980a.c(j - this.b, this.f30890a);
        }

        public long j(long j) {
            return this.f3980a.e(j, this.f30890a) + this.b;
        }

        public long k(long j) {
            return this.f3980a.getTimeUs(j - this.b);
        }

        public ka7 l(long j) {
            return this.f3980a.d(j - this.b);
        }

        public boolean m(long j, long j2) {
            return this.f3980a.a() || j2 == -9223372036854775807L || i(j) <= j2;
        }
    }

    public static final class c extends BaseMediaChunkIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f30891a;
        public final long d;

        public c(b bVar, long j, long j2, long j3) {
            super(j, j2);
            this.f30891a = bVar;
            this.d = j3;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec a() {
            checkInBounds();
            long currentIndex = getCurrentIndex();
            ka7 ka7VarL = this.f30891a.l(currentIndex);
            int i = this.f30891a.m(currentIndex, this.d) ? 0 : 8;
            b bVar = this.f30891a;
            return f62.b(bVar.f3981a, bVar.f3982a.f20281a, ka7VarL, i);
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.f30891a.i(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.f30891a.k(getCurrentIndex());
        }
    }

    public a(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, c62 c62Var, xr0 xr0Var, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, DataSource dataSource, long j, int i3, boolean z, List<d> list, @Nullable PlayerEmsgHandler.b bVar, at6 at6Var) {
        this.f3970a = loaderErrorThrower;
        this.f3971a = c62Var;
        this.f3972a = xr0Var;
        this.f3975a = iArr;
        this.f3968a = exoTrackSelection;
        this.f30888a = i2;
        this.f3969a = dataSource;
        this.c = i;
        this.f3966a = j;
        this.b = i3;
        this.f3967a = bVar;
        long jF = c62Var.f(i);
        ArrayList<Representation> arrayListL = l();
        this.f3976a = new b[exoTrackSelection.length()];
        int i4 = 0;
        while (i4 < this.f3976a.length) {
            Representation representation = arrayListL.get(exoTrackSelection.getIndexInTrackGroup(i4));
            vr0 vr0VarJ = xr0Var.j(representation.f3984a);
            b[] bVarArr = this.f3976a;
            if (vr0VarJ == null) {
                vr0VarJ = representation.f3984a.get(0);
            }
            int i5 = i4;
            bVarArr[i5] = new b(jF, representation, vr0VarJ, factory.a(i2, representation.f3983a, z, list, bVar, at6Var), 0L, representation.k());
            i4 = i5 + 1;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long a(long j, w38 w38Var) {
        for (b bVar : this.f3976a) {
            if (bVar.f3980a != null) {
                long j2 = bVar.j(j);
                long jK = bVar.k(j2);
                long jH = bVar.h();
                return w38Var.a(j, jK, (jK >= j || (jH != -1 && j2 >= (bVar.f() + jH) - 1)) ? jK : bVar.k(j2 + 1));
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void b(ExoTrackSelection exoTrackSelection) {
        this.f3968a = exoTrackSelection;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void c(c62 c62Var, int i) {
        try {
            this.f3971a = c62Var;
            this.c = i;
            long jF = c62Var.f(i);
            ArrayList<Representation> arrayListL = l();
            for (int i2 = 0; i2 < this.f3976a.length; i2++) {
                Representation representation = arrayListL.get(this.f3968a.getIndexInTrackGroup(i2));
                b[] bVarArr = this.f3976a;
                bVarArr[i2] = bVarArr[i2].b(jF, representation);
            }
        } catch (BehindLiveWindowException e) {
            this.f3973a = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean d(Chunk chunk, boolean z, LoadErrorHandlingPolicy.c cVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.b bVarA;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.b bVar = this.f3967a;
        if (bVar != null && bVar.j(chunk)) {
            return true;
        }
        if (!this.f3971a.f15743a && (chunk instanceof MediaChunk)) {
            IOException iOException = cVar.f5046a;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar2 = this.f3976a[this.f3968a.b(chunk.f3837a)];
                long jH = bVar2.h();
                if (jH != -1 && jH != 0) {
                    if (((MediaChunk) chunk).e() > (bVar2.f() + jH) - 1) {
                        this.f3974a = true;
                        return true;
                    }
                }
            }
        }
        b bVar3 = this.f3976a[this.f3968a.b(chunk.f3837a)];
        vr0 vr0VarJ = this.f3972a.j(bVar3.f3981a.f3984a);
        if (vr0VarJ != null && !bVar3.f3982a.equals(vr0VarJ)) {
            return true;
        }
        LoadErrorHandlingPolicy.a aVarI = i(this.f3968a, bVar3.f3981a.f3984a);
        if ((!aVarI.a(2) && !aVarI.a(1)) || (bVarA = loadErrorHandlingPolicy.a(aVarI, cVar)) == null || !aVarI.a(bVarA.f31114a)) {
            return false;
        }
        int i = bVarA.f31114a;
        if (i == 2) {
            ExoTrackSelection exoTrackSelection = this.f3968a;
            return exoTrackSelection.blacklist(exoTrackSelection.b(chunk.f3837a), bVarA.f5043a);
        }
        if (i != 1) {
            return false;
        }
        this.f3972a.e(bVar3.f3982a, bVarA.f5043a);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean e(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f3973a != null) {
            return false;
        }
        return this.f3968a.f(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void f(Chunk chunk) {
        com.google.android.exoplayer2.extractor.b bVarF;
        if (chunk instanceof com.google.android.exoplayer2.source.chunk.d) {
            int iB = this.f3968a.b(((Chunk) ((com.google.android.exoplayer2.source.chunk.d) chunk)).f3837a);
            b bVar = this.f3976a[iB];
            if (bVar.f3980a == null && (bVarF = bVar.f3979a.f()) != null) {
                this.f3976a[iB] = bVar.c(new g62(bVarF, bVar.f3981a.b));
            }
        }
        PlayerEmsgHandler.b bVar2 = this.f3967a;
        if (bVar2 != null) {
            bVar2.i(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        return (this.f3973a != null || this.f3968a.length() < 2) ? list.size() : this.f3968a.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void h(long j, long j2, List<? extends MediaChunk> list, uk1 uk1Var) {
        int i;
        int i2;
        MediaChunkIterator[] mediaChunkIteratorArr;
        long j3;
        long j4;
        if (this.f3973a != null) {
            return;
        }
        long j5 = j2 - j;
        long jZ0 = gj9.Z0(this.f3971a.f40908a) + gj9.Z0(this.f3971a.c(this.c).f41481a) + j2;
        PlayerEmsgHandler.b bVar = this.f3967a;
        if (bVar == null || !bVar.h(jZ0)) {
            long jZ1 = gj9.Z0(gj9.m0(this.f3966a));
            long jK = k(jZ1);
            MediaChunk mediaChunk = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.f3968a.length();
            MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
            int i3 = 0;
            while (i3 < length) {
                b bVar2 = this.f3976a[i3];
                if (bVar2.f3980a == null) {
                    mediaChunkIteratorArr2[i3] = MediaChunkIterator.f30862a;
                    i = i3;
                    i2 = length;
                    mediaChunkIteratorArr = mediaChunkIteratorArr2;
                    j3 = j5;
                    j4 = jZ1;
                } else {
                    long jE = bVar2.e(jZ1);
                    long jG = bVar2.g(jZ1);
                    i = i3;
                    i2 = length;
                    mediaChunkIteratorArr = mediaChunkIteratorArr2;
                    j3 = j5;
                    j4 = jZ1;
                    long jM = m(bVar2, mediaChunk, j2, jE, jG);
                    if (jM < jE) {
                        mediaChunkIteratorArr[i] = MediaChunkIterator.f30862a;
                    } else {
                        mediaChunkIteratorArr[i] = new c(n(i), jM, jG, jK);
                    }
                }
                i3 = i + 1;
                jZ1 = j4;
                mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                length = i2;
                j5 = j3;
            }
            long j6 = j5;
            long j7 = jZ1;
            this.f3968a.c(j, j6, j(j7, j), list, mediaChunkIteratorArr2);
            b bVarN = n(this.f3968a.getSelectedIndex());
            ChunkExtractor chunkExtractor = bVarN.f3979a;
            if (chunkExtractor != null) {
                Representation representation = bVarN.f3981a;
                ka7 ka7VarM = chunkExtractor.e() == null ? representation.m() : null;
                ka7 ka7VarL = bVarN.f3980a == null ? representation.l() : null;
                if (ka7VarM != null || ka7VarL != null) {
                    uk1Var.f45163a = newInitializationChunk(bVarN, this.f3969a, this.f3968a.a(), this.f3968a.getSelectionReason(), this.f3968a.getSelectionData(), ka7VarM, ka7VarL);
                    return;
                }
            }
            long j8 = bVarN.f30890a;
            boolean z = j8 != -9223372036854775807L;
            if (bVarN.h() == 0) {
                uk1Var.f20085a = z;
                return;
            }
            long jE2 = bVarN.e(j7);
            long jG2 = bVarN.g(j7);
            long jM2 = m(bVarN, mediaChunk, j2, jE2, jG2);
            if (jM2 < jE2) {
                this.f3973a = new BehindLiveWindowException();
                return;
            }
            if (jM2 > jG2 || (this.f3974a && jM2 >= jG2)) {
                uk1Var.f20085a = z;
                return;
            }
            if (z && bVarN.k(jM2) >= j8) {
                uk1Var.f20085a = true;
                return;
            }
            int iMin = (int) Math.min(this.b, (jG2 - jM2) + 1);
            if (j8 != -9223372036854775807L) {
                while (iMin > 1 && bVarN.k((((long) iMin) + jM2) - 1) >= j8) {
                    iMin--;
                }
            }
            uk1Var.f45163a = newMediaChunk(bVarN, this.f3969a, this.f30888a, this.f3968a.a(), this.f3968a.getSelectionReason(), this.f3968a.getSelectionData(), jM2, iMin, list.isEmpty() ? j2 : -9223372036854775807L, jK);
        }
    }

    public final LoadErrorHandlingPolicy.a i(ExoTrackSelection exoTrackSelection, List<vr0> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (exoTrackSelection.isBlacklisted(i2, jElapsedRealtime)) {
                i++;
            }
        }
        int iF = xr0.f(list);
        return new LoadErrorHandlingPolicy.a(iF, iF - this.f3972a.g(list), length, i);
    }

    public final long j(long j, long j2) {
        if (!this.f3971a.f15743a) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(k(j), this.f3976a[0].i(this.f3976a[0].g(j))) - j2);
    }

    public final long k(long j) {
        c62 c62Var = this.f3971a;
        long j2 = c62Var.f40908a;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - gj9.Z0(j2 + c62Var.c(this.c).f41481a);
    }

    public final ArrayList<Representation> l() {
        List<vz> list = this.f3971a.c(this.c).f16370a;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.f3975a) {
            arrayList.addAll(list.get(i).f20347a);
        }
        return arrayList;
    }

    public final long m(b bVar, @Nullable MediaChunk mediaChunk, long j, long j2, long j3) {
        return mediaChunk != null ? mediaChunk.e() : gj9.t(bVar.j(j), j2, j3);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.f3973a;
        if (iOException != null) {
            throw iOException;
        }
        this.f3970a.maybeThrowError();
    }

    public final b n(int i) {
        b bVar = this.f3976a[i];
        vr0 vr0VarJ = this.f3972a.j(bVar.f3981a.f3984a);
        if (vr0VarJ == null || vr0VarJ.equals(bVar.f3982a)) {
            return bVar;
        }
        b bVarD = bVar.d(vr0VarJ);
        this.f3976a[i] = bVarD;
        return bVarD;
    }

    public Chunk newInitializationChunk(b bVar, DataSource dataSource, d dVar, int i, @Nullable Object obj, @Nullable ka7 ka7Var, @Nullable ka7 ka7Var2) {
        ka7 ka7Var3 = ka7Var;
        Representation representation = bVar.f3981a;
        if (ka7Var3 != null) {
            ka7 ka7VarA = ka7Var3.a(ka7Var2, bVar.f3982a.f20281a);
            if (ka7VarA != null) {
                ka7Var3 = ka7VarA;
            }
        } else {
            ka7Var3 = ka7Var2;
        }
        return new com.google.android.exoplayer2.source.chunk.d(dataSource, f62.b(representation, bVar.f3982a.f20281a, ka7Var3, 0), dVar, i, obj, bVar.f3979a);
    }

    public Chunk newMediaChunk(b bVar, DataSource dataSource, int i, d dVar, int i2, Object obj, long j, int i3, long j2, long j3) {
        Representation representation = bVar.f3981a;
        long jK = bVar.k(j);
        ka7 ka7VarL = bVar.l(j);
        if (bVar.f3979a == null) {
            return new qi8(dataSource, f62.b(representation, bVar.f3982a.f20281a, ka7VarL, bVar.m(j, j3) ? 0 : 8), dVar, i2, obj, jK, bVar.i(j), j, i, dVar);
        }
        int i4 = 1;
        int i5 = 1;
        while (i4 < i3) {
            ka7 ka7VarA = ka7VarL.a(bVar.l(((long) i4) + j), bVar.f3982a.f20281a);
            if (ka7VarA == null) {
                break;
            }
            i5++;
            i4++;
            ka7VarL = ka7VarA;
        }
        long j4 = (((long) i5) + j) - 1;
        long jI = bVar.i(j4);
        long j5 = bVar.f30890a;
        return new com.google.android.exoplayer2.source.chunk.c(dataSource, f62.b(representation, bVar.f3982a.f20281a, ka7VarL, bVar.m(j4, j3) ? 0 : 8), dVar, i2, obj, jK, jI, j2, (j5 == -9223372036854775807L || j5 > jI) ? -9223372036854775807L : j5, j, i5, -representation.b, bVar.f3979a);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void release() {
        for (b bVar : this.f3976a) {
            ChunkExtractor chunkExtractor = bVar.f3979a;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }
}
