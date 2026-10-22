package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.zj.adlib.ar8;
import com.zj.adlib.az4;
import com.zj.adlib.bp5;
import com.zj.adlib.d72;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.oh5;
import com.zj.adlib.om6;
import com.zj.adlib.ps1;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<a>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    public static final long e = 10000;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f3689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionEventListener.a f3691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f3692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SeekMap f3693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IcyHeaders f3694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f3695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f3696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProgressiveMediaExtractor f3697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f3698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f3699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f3700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f3701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f3702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3706a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3710b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3711c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3712d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f3713e;

    @Nullable
    public final String f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f3714f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, String> f3687a = x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.exoplayer2.d f30827a = new com.google.android.exoplayer2.d.b().S("icy").e0("application/x-icy").E();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Loader f3703a = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ps1 f3704a = new ps1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f3705a = new Runnable() { // from class: com.zj.adlib.m17
        @Override // java.lang.Runnable
        public final void run() {
            this.f43199a.H();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f3709b = new Runnable() { // from class: com.zj.adlib.n17
        @Override // java.lang.Runnable
        public final void run() {
            this.f43426a.E();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3690a = gj9.y();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c[] f3707a = new c[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SampleQueue[] f3708a = new SampleQueue[0];
    public long d = -9223372036854775807L;
    public long b = -9223372036854775807L;
    public int K = 1;

    public interface Listener {
        void onSourceInfoRefreshed(long j, boolean z, boolean z2);
    }

    public final class a implements Loader.Loadable, IcyDataSource.Listener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Uri f3715a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ExtractorOutput f3716a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public TrackOutput f3717a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProgressiveMediaExtractor f3718a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ar8 f3721a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ps1 f3723a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile boolean f3724a;
        public long b;
        public boolean c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final iv6 f3722a = new iv6();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f3725b = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30828a = az4.a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DataSpec f3720a = g(0);

        public a(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ps1 ps1Var) {
            this.f3715a = uri;
            this.f3721a = new ar8(dataSource);
            this.f3718a = progressiveMediaExtractor;
            this.f3716a = extractorOutput;
            this.f3723a = ps1Var;
        }

        @Override // com.google.android.exoplayer2.source.IcyDataSource.Listener
        public void a(om6 om6Var) {
            long jMax = !this.c ? this.b : Math.max(ProgressiveMediaPeriod.this.z(true), this.b);
            int iA = om6Var.a();
            TrackOutput trackOutput = (TrackOutput) sb0.g(this.f3717a);
            trackOutput.c(om6Var, iA);
            trackOutput.e(jMax, 1, iA, 0, null);
            this.c = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.f3724a = true;
        }

        public final DataSpec g(long j) {
            return new DataSpec.b().j(this.f3715a).i(j).g(ProgressiveMediaPeriod.this.f).c(6).f(ProgressiveMediaPeriod.f3687a).a();
        }

        public final void h(long j, long j2) {
            this.f3722a.f42452a = j;
            this.b = j2;
            this.f3725b = true;
            this.c = false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x00f9 */
        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void load() throws IOException {
            int iB = 0;
            while (iB == 0 && !this.f3724a) {
                long j = this.f3722a.f42452a;
                DataSpec dataSpecG = g(j);
                this.f3720a = dataSpecG;
                long jA = this.f3721a.a(dataSpecG);
                if (jA != -1) {
                    jA += j;
                    ProgressiveMediaPeriod.this.O();
                }
                long j2 = jA;
                ProgressiveMediaPeriod.this.f3694a = IcyHeaders.parse(this.f3721a.getResponseHeaders());
                DataReader icyDataSource = this.f3721a;
                if (ProgressiveMediaPeriod.this.f3694a != null && ProgressiveMediaPeriod.this.f3694a.metadataInterval != -1) {
                    icyDataSource = new IcyDataSource(this.f3721a, ProgressiveMediaPeriod.this.f3694a.metadataInterval, this);
                    TrackOutput trackOutputB = ProgressiveMediaPeriod.this.B();
                    this.f3717a = trackOutputB;
                    trackOutputB.f(ProgressiveMediaPeriod.f30827a);
                }
                long currentInputPosition = j;
                this.f3718a.a(icyDataSource, this.f3715a, this.f3721a.getResponseHeaders(), j, j2, this.f3716a);
                if (ProgressiveMediaPeriod.this.f3694a != null) {
                    this.f3718a.disableSeekingOnMp3Streams();
                }
                if (this.f3725b) {
                    this.f3718a.seek(currentInputPosition, this.b);
                    this.f3725b = false;
                }
                while (true) {
                    long j3 = currentInputPosition;
                    while (true) {
                        if (iB != 0 || this.f3724a) {
                            break;
                        }
                        try {
                            this.f3723a.a();
                            iB = this.f3718a.b(this.f3722a);
                            currentInputPosition = this.f3718a.getCurrentInputPosition();
                            if (currentInputPosition > ProgressiveMediaPeriod.this.f3688a + j3) {
                                this.f3723a.d();
                                ProgressiveMediaPeriod.this.f3690a.post(ProgressiveMediaPeriod.this.f3709b);
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (iB == 1) {
                    iB = 0;
                } else if (this.f3718a.getCurrentInputPosition() != -1) {
                    this.f3722a.f42452a = this.f3718a.getCurrentInputPosition();
                }
                d72.a(this.f3721a);
            }
        }
    }

    public final class b implements SampleStream {
        public final int K;

        public b(int i) {
            this.K = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return ProgressiveMediaPeriod.this.T(this.K, yk3Var, decoderInputBuffer, i);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ProgressiveMediaPeriod.this.D(this.K);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            ProgressiveMediaPeriod.this.N(this.K);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return ProgressiveMediaPeriod.this.X(this.K, j);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30830a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3726a;

        public c(int i, boolean z) {
            this.f30830a = i;
            this.f3726a = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f30830a == cVar.f30830a && this.f3726a == cVar.f3726a;
        }

        public int hashCode() {
            return (this.f30830a * 31) + (this.f3726a ? 1 : 0);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ga9 f30831a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean[] f3727a;
        public final boolean[] b;
        public final boolean[] c;

        public d(ga9 ga9Var, boolean[] zArr) {
            this.f30831a = ga9Var;
            this.f3727a = zArr;
            int i = ga9Var.K;
            this.b = new boolean[i];
            this.c = new boolean[i];
        }
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar2, Listener listener, Allocator allocator, @Nullable String str, int i) {
        this.f3689a = uri;
        this.f3701a = dataSource;
        this.f3692a = drmSessionManager;
        this.f3691a = aVar;
        this.f3702a = loadErrorHandlingPolicy;
        this.f3696a = aVar2;
        this.f3698a = listener;
        this.f3700a = allocator;
        this.f = str;
        this.f3688a = i;
        this.f3697a = progressiveMediaExtractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (this.j) {
            return;
        }
        ((MediaPeriod.Callback) sb0.g(this.f3695a)).d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.g = true;
    }

    public static Map<String, String> x() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    public TrackOutput B() {
        return S(new c(0, true));
    }

    public final boolean C() {
        return this.d != -9223372036854775807L;
    }

    public boolean D(int i) {
        return !Z() && this.f3708a[i].K(this.i);
    }

    public final void H() {
        if (this.j || this.f3710b || !this.f3706a || this.f3693a == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.f3708a) {
            if (sampleQueue.G() == null) {
                return;
            }
        }
        this.f3704a.d();
        int length = this.f3708a.length;
        da9[] da9VarArr = new da9[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            com.google.android.exoplayer2.d dVarE = (com.google.android.exoplayer2.d) sb0.g(this.f3708a[i].G());
            String str = dVarE.k;
            boolean zP = bp5.p(str);
            boolean z = zP || bp5.t(str);
            zArr[i] = z;
            this.f3711c = z | this.f3711c;
            IcyHeaders icyHeaders = this.f3694a;
            if (icyHeaders != null) {
                if (zP || this.f3707a[i].f3726a) {
                    Metadata metadata = dVarE.f2567a;
                    dVarE = dVarE.b().X(metadata == null ? new Metadata(icyHeaders) : metadata.copyWithAppendedEntries(icyHeaders)).E();
                }
                if (zP && dVarE.M == -1 && dVarE.N == -1 && icyHeaders.bitrate != -1) {
                    dVarE = dVarE.b().G(icyHeaders.bitrate).E();
                }
            }
            da9VarArr[i] = new da9(Integer.toString(i), dVarE.d(this.f3692a.a(dVarE)));
        }
        this.f3699a = new d(new ga9(da9VarArr), zArr);
        this.f3710b = true;
        ((MediaPeriod.Callback) sb0.g(this.f3695a)).h(this);
    }

    public final void I(int i) {
        v();
        d dVar = this.f3699a;
        boolean[] zArr = dVar.c;
        if (zArr[i]) {
            return;
        }
        com.google.android.exoplayer2.d dVarC = dVar.f30831a.b(i).c(0);
        this.f3696a.i(bp5.l(dVarC.k), dVarC, 0, null, this.c);
        zArr[i] = true;
    }

    public final void J(int i) {
        v();
        boolean[] zArr = this.f3699a.f3727a;
        if (this.h && zArr[i]) {
            if (this.f3708a[i].K(false)) {
                return;
            }
            this.d = 0L;
            this.h = false;
            this.f3714f = true;
            this.c = 0L;
            this.M = 0;
            for (SampleQueue sampleQueue : this.f3708a) {
                sampleQueue.V();
            }
            ((MediaPeriod.Callback) sb0.g(this.f3695a)).d(this);
        }
    }

    public void L() throws IOException {
        this.f3703a.maybeThrowError(this.f3702a.getMinimumLoadableRetryCount(this.K));
    }

    public void N(int i) throws IOException {
        this.f3708a[i].N();
        L();
    }

    public final void O() {
        this.f3690a.post(new Runnable() { // from class: com.zj.adlib.o17
            @Override // java.lang.Runnable
            public final void run() {
                this.f43648a.F();
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void M(a aVar, long j, long j2, boolean z) {
        ar8 ar8Var = aVar.f3721a;
        az4 az4Var = new az4(aVar.f30828a, aVar.f3720a, ar8Var.g(), ar8Var.h(), j, j2, ar8Var.d());
        this.f3702a.onLoadTaskConcluded(aVar.f30828a);
        this.f3696a.r(az4Var, 1, -1, null, 0, null, aVar.b, this.b);
        if (z) {
            return;
        }
        for (SampleQueue sampleQueue : this.f3708a) {
            sampleQueue.V();
        }
        if (this.L > 0) {
            ((MediaPeriod.Callback) sb0.g(this.f3695a)).d(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void K(a aVar, long j, long j2) {
        SeekMap seekMap;
        if (this.b == -9223372036854775807L && (seekMap = this.f3693a) != null) {
            boolean zIsSeekable = seekMap.isSeekable();
            long jZ = z(true);
            long j3 = jZ == Long.MIN_VALUE ? 0L : jZ + 10000;
            this.b = j3;
            this.f3698a.onSourceInfoRefreshed(j3, zIsSeekable, this.f3712d);
        }
        ar8 ar8Var = aVar.f3721a;
        az4 az4Var = new az4(aVar.f30828a, aVar.f3720a, ar8Var.g(), ar8Var.h(), j, j2, ar8Var.d());
        this.f3702a.onLoadTaskConcluded(aVar.f30828a);
        this.f3696a.u(az4Var, 1, -1, null, 0, null, aVar.b, this.b);
        this.i = true;
        ((MediaPeriod.Callback) sb0.g(this.f3695a)).d(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public Loader.b A(a aVar, long j, long j2, IOException iOException, int i) {
        Loader.b bVarG;
        ar8 ar8Var = aVar.f3721a;
        az4 az4Var = new az4(aVar.f30828a, aVar.f3720a, ar8Var.g(), ar8Var.h(), j, j2, ar8Var.d());
        long jB = this.f3702a.b(new LoadErrorHandlingPolicy.c(az4Var, new oh5(1, -1, null, 0, null, gj9.H1(aVar.b), gj9.H1(this.b)), iOException, i));
        if (jB == -9223372036854775807L) {
            bVarG = Loader.f5051d;
        } else {
            int iY = y();
            bVarG = w(aVar, iY) ? Loader.g(iY > this.M, jB) : Loader.f5050c;
        }
        boolean z = !bVarG.c();
        this.f3696a.w(az4Var, 1, -1, null, 0, null, aVar.b, this.b, iOException, z);
        if (z) {
            this.f3702a.onLoadTaskConcluded(aVar.f30828a);
        }
        return bVarG;
    }

    public final TrackOutput S(c cVar) {
        int length = this.f3708a.length;
        for (int i = 0; i < length; i++) {
            if (cVar.equals(this.f3707a[i])) {
                return this.f3708a[i];
            }
        }
        SampleQueue sampleQueueL = SampleQueue.l(this.f3700a, this.f3692a, this.f3691a);
        sampleQueueL.d0(this);
        int i2 = length + 1;
        c[] cVarArr = (c[]) Arrays.copyOf(this.f3707a, i2);
        cVarArr[length] = cVar;
        this.f3707a = (c[]) gj9.l(cVarArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.f3708a, i2);
        sampleQueueArr[length] = sampleQueueL;
        this.f3708a = (SampleQueue[]) gj9.l(sampleQueueArr);
        return sampleQueueL;
    }

    public int T(int i, yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (Z()) {
            return -3;
        }
        I(i);
        int iS = this.f3708a[i].S(yk3Var, decoderInputBuffer, i2, this.i);
        if (iS == -3) {
            J(i);
        }
        return iS;
    }

    public void U() {
        if (this.f3710b) {
            for (SampleQueue sampleQueue : this.f3708a) {
                sampleQueue.R();
            }
        }
        this.f3703a.k(this);
        this.f3690a.removeCallbacksAndMessages(null);
        this.f3695a = null;
        this.j = true;
    }

    public final boolean V(boolean[] zArr, long j) {
        int length = this.f3708a.length;
        for (int i = 0; i < length; i++) {
            if (!this.f3708a[i].Z(j, false) && (zArr[i] || !this.f3711c)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void G(SeekMap seekMap) {
        this.f3693a = this.f3694a == null ? seekMap : new SeekMap.b(-9223372036854775807L);
        this.b = seekMap.getDurationUs();
        boolean z = !this.g && seekMap.getDurationUs() == -9223372036854775807L;
        this.f3712d = z;
        this.K = z ? 7 : 1;
        this.f3698a.onSourceInfoRefreshed(this.b, seekMap.isSeekable(), this.f3712d);
        if (this.f3710b) {
            return;
        }
        H();
    }

    public int X(int i, long j) {
        if (Z()) {
            return 0;
        }
        I(i);
        SampleQueue sampleQueue = this.f3708a[i];
        int iF = sampleQueue.F(j, this.i);
        sampleQueue.e0(iF);
        if (iF == 0) {
            J(i);
        }
        return iF;
    }

    public final void Y() {
        a aVar = new a(this.f3689a, this.f3701a, this.f3697a, this, this.f3704a);
        if (this.f3710b) {
            sb0.i(C());
            long j = this.b;
            if (j != -9223372036854775807L && this.d > j) {
                this.i = true;
                this.d = -9223372036854775807L;
                return;
            }
            aVar.h(((SeekMap) sb0.g(this.f3693a)).a(this.d).f30623a.b, this.d);
            for (SampleQueue sampleQueue : this.f3708a) {
                sampleQueue.b0(this.d);
            }
            this.d = -9223372036854775807L;
        }
        this.M = y();
        this.f3696a.A(new az4(aVar.f30828a, aVar.f3720a, this.f3703a.l(aVar, this, this.f3702a.getMinimumLoadableRetryCount(this.K))), 1, -1, null, 0, null, aVar.b, this.b);
    }

    public final boolean Z() {
        return this.f3714f || C();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        v();
        if (!this.f3693a.isSeekable()) {
            return 0L;
        }
        SeekMap.a aVarA = this.f3693a.a(j);
        return w38Var.a(j, aVarA.f30623a.f20602a, aVarA.b.f20602a);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput b(int i, int i2) {
        return S(new c(i, false));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f3695a = callback;
        this.f3704a.f();
        Y();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.i || this.f3703a.h() || this.h) {
            return false;
        }
        if (this.f3710b && this.L == 0) {
            return false;
        }
        boolean zF = this.f3704a.f();
        if (this.f3703a.i()) {
            return zF;
        }
        Y();
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void d(final SeekMap seekMap) {
        this.f3690a.post(new Runnable() { // from class: com.zj.adlib.p17
            @Override // java.lang.Runnable
            public final void run() {
                this.f18753a.G(seekMap);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        v();
        if (C()) {
            return;
        }
        boolean[] zArr = this.f3699a.b;
        int length = this.f3708a.length;
        for (int i = 0; i < length; i++) {
            this.f3708a[i].r(j, z, zArr[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        v();
        return this.f3699a.f30831a;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.f3706a = true;
        this.f3690a.post(this.f3705a);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        ExoTrackSelection exoTrackSelection;
        v();
        d dVar = this.f3699a;
        ga9 ga9Var = dVar.f30831a;
        boolean[] zArr3 = dVar.b;
        int i = this.L;
        int i2 = 0;
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            SampleStream sampleStream = sampleStreamArr[i3];
            if (sampleStream != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                int i4 = ((b) sampleStream).K;
                sb0.i(zArr3[i4]);
                this.L--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z = !this.f3713e ? j == 0 : i != 0;
        for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && (exoTrackSelection = exoTrackSelectionArr[i5]) != null) {
                sb0.i(exoTrackSelection.length() == 1);
                sb0.i(exoTrackSelection.getIndexInTrackGroup(0) == 0);
                int iC = ga9Var.c(exoTrackSelection.d());
                sb0.i(!zArr3[iC]);
                this.L++;
                zArr3[iC] = true;
                sampleStreamArr[i5] = new b(iC);
                zArr2[i5] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.f3708a[iC];
                    z = (sampleQueue.Z(j, true) || sampleQueue.D() == 0) ? false : true;
                }
            }
        }
        if (this.L == 0) {
            this.h = false;
            this.f3714f = false;
            if (this.f3703a.i()) {
                SampleQueue[] sampleQueueArr = this.f3708a;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].s();
                    i2++;
                }
                this.f3703a.e();
            } else {
                SampleQueue[] sampleQueueArr2 = this.f3708a;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].V();
                    i2++;
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.f3713e = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void g(com.google.android.exoplayer2.d dVar) {
        this.f3690a.post(this.f3705a);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long jZ;
        v();
        if (this.i || this.L == 0) {
            return Long.MIN_VALUE;
        }
        if (C()) {
            return this.d;
        }
        if (this.f3711c) {
            int length = this.f3708a.length;
            jZ = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                d dVar = this.f3699a;
                if (dVar.f3727a[i] && dVar.b[i] && !this.f3708a[i].J()) {
                    jZ = Math.min(jZ, this.f3708a[i].A());
                }
            }
        } else {
            jZ = Long.MAX_VALUE;
        }
        if (jZ == Long.MAX_VALUE) {
            jZ = z(false);
        }
        return jZ == Long.MIN_VALUE ? this.c : jZ;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f3703a.i() && this.f3704a.e();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        L();
        if (this.i && !this.f3710b) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (SampleQueue sampleQueue : this.f3708a) {
            sampleQueue.T();
        }
        this.f3697a.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (!this.f3714f) {
            return -9223372036854775807L;
        }
        if (!this.i && y() <= this.M) {
            return -9223372036854775807L;
        }
        this.f3714f = false;
        return this.c;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        v();
        boolean[] zArr = this.f3699a.f3727a;
        if (!this.f3693a.isSeekable()) {
            j = 0;
        }
        int i = 0;
        this.f3714f = false;
        this.c = j;
        if (C()) {
            this.d = j;
            return j;
        }
        if (this.K != 7 && V(zArr, j)) {
            return j;
        }
        this.h = false;
        this.d = j;
        this.i = false;
        if (this.f3703a.i()) {
            SampleQueue[] sampleQueueArr = this.f3708a;
            int length = sampleQueueArr.length;
            while (i < length) {
                sampleQueueArr[i].s();
                i++;
            }
            this.f3703a.e();
        } else {
            this.f3703a.f();
            SampleQueue[] sampleQueueArr2 = this.f3708a;
            int length2 = sampleQueueArr2.length;
            while (i < length2) {
                sampleQueueArr2[i].V();
                i++;
            }
        }
        return j;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void v() {
        sb0.i(this.f3710b);
        sb0.g(this.f3699a);
        sb0.g(this.f3693a);
    }

    public final boolean w(a aVar, int i) {
        SeekMap seekMap;
        if (this.g || !((seekMap = this.f3693a) == null || seekMap.getDurationUs() == -9223372036854775807L)) {
            this.M = i;
            return true;
        }
        if (this.f3710b && !Z()) {
            this.h = true;
            return false;
        }
        this.f3714f = this.f3710b;
        this.c = 0L;
        this.M = 0;
        for (SampleQueue sampleQueue : this.f3708a) {
            sampleQueue.V();
        }
        aVar.h(0L, 0L);
        return true;
    }

    public final int y() {
        int iH = 0;
        for (SampleQueue sampleQueue : this.f3708a) {
            iH += sampleQueue.H();
        }
        return iH;
    }

    public final long z(boolean z) {
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.f3708a.length; i++) {
            if (z || ((d) sb0.g(this.f3699a)).b[i]) {
                jMax = Math.max(jMax, this.f3708a[i].A());
            }
        }
        return jMax;
    }
}
