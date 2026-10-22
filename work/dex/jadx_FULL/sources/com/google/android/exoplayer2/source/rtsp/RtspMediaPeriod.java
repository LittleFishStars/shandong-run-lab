package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.al7;
import com.zj.adlib.bl7;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RtspMediaPeriod implements MediaPeriod {
    public static final int L = 3;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f4344a = gj9.y();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPeriod.Callback f4345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RtpDataChannel.Factory f4346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RtspClient f4347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f4348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public RtspMediaSource.RtspPlaybackException f4350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f4351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImmutableList<da9> f4352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IOException f4353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<d> f4354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4355a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4356b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<c> f4357c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4358c;
    public boolean d;
    public boolean e;
    public boolean f;

    public interface Listener {
        default void a() {
        }

        void b(al7 al7Var);
    }

    public final class b implements ExtractorOutput, Loader.Callback<RtpDataLoadable>, SampleQueue.UpstreamFormatChangedListener, RtspClient.SessionInfoListener, RtspClient.PlaybackEventListener {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.PlaybackEventListener
        public void a(RtspMediaSource.RtspPlaybackException rtspPlaybackException) {
            RtspMediaPeriod.this.f4350a = rtspPlaybackException;
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public TrackOutput b(int i, int i2) {
            return ((d) sb0.g((d) RtspMediaPeriod.this.f4354a.get(i))).f30957a;
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.PlaybackEventListener
        public void c() {
            RtspMediaPeriod.this.f4347a.C0(0L);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void d(SeekMap seekMap) {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.SessionInfoListener
        public void e(String str, @Nullable Throwable th) {
            RtspMediaPeriod.this.f4353a = th == null ? new IOException(str) : new IOException(str, th);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void endTracks() {
            Handler handler = RtspMediaPeriod.this.f4344a;
            final RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
            handler.post(new Runnable() { // from class: com.zj.adlib.uk7
                @Override // java.lang.Runnable
                public final void run() {
                    RtspMediaPeriod.u(rtspMediaPeriod);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.SessionInfoListener
        public void f(al7 al7Var, ImmutableList<f> immutableList) {
            for (int i = 0; i < immutableList.size(); i++) {
                f fVar = immutableList.get(i);
                RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
                d dVar = rtspMediaPeriod.new d(fVar, i, rtspMediaPeriod.f4346a);
                RtspMediaPeriod.this.f4354a.add(dVar);
                dVar.j();
            }
            RtspMediaPeriod.this.f4348a.b(al7Var);
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
        public void g(com.google.android.exoplayer2.d dVar) {
            Handler handler = RtspMediaPeriod.this.f4344a;
            final RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
            handler.post(new Runnable() { // from class: com.zj.adlib.tk7
                @Override // java.lang.Runnable
                public final void run() {
                    RtspMediaPeriod.u(rtspMediaPeriod);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.PlaybackEventListener
        public void h(long j, ImmutableList<bl7> immutableList) {
            ArrayList arrayList = new ArrayList(immutableList.size());
            for (int i = 0; i < immutableList.size(); i++) {
                arrayList.add((String) sb0.g(immutableList.get(i).f15566a.getPath()));
            }
            for (int i2 = 0; i2 < RtspMediaPeriod.this.f4357c.size(); i2++) {
                if (!arrayList.contains(((c) RtspMediaPeriod.this.f4357c.get(i2)).c().getPath())) {
                    RtspMediaPeriod.this.f4348a.a();
                    if (RtspMediaPeriod.this.K()) {
                        RtspMediaPeriod.this.f4356b = true;
                        RtspMediaPeriod.this.b = -9223372036854775807L;
                        RtspMediaPeriod.this.f30954a = -9223372036854775807L;
                        RtspMediaPeriod.this.c = -9223372036854775807L;
                    }
                }
            }
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                bl7 bl7Var = immutableList.get(i3);
                RtpDataLoadable rtpDataLoadableH = RtspMediaPeriod.this.H(bl7Var.f15566a);
                if (rtpDataLoadableH != null) {
                    rtpDataLoadableH.f(bl7Var.f15565a);
                    rtpDataLoadableH.e(bl7Var.f40775a);
                    if (RtspMediaPeriod.this.K() && RtspMediaPeriod.this.b == RtspMediaPeriod.this.f30954a) {
                        rtpDataLoadableH.d(j, bl7Var.f15565a);
                    }
                }
            }
            if (!RtspMediaPeriod.this.K()) {
                if (RtspMediaPeriod.this.c != -9223372036854775807L) {
                    RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
                    rtspMediaPeriod.seekToUs(rtspMediaPeriod.c);
                    RtspMediaPeriod.this.c = -9223372036854775807L;
                    return;
                }
                return;
            }
            if (RtspMediaPeriod.this.b == RtspMediaPeriod.this.f30954a) {
                RtspMediaPeriod.this.b = -9223372036854775807L;
                RtspMediaPeriod.this.f30954a = -9223372036854775807L;
            } else {
                RtspMediaPeriod.this.b = -9223372036854775807L;
                RtspMediaPeriod rtspMediaPeriod2 = RtspMediaPeriod.this;
                rtspMediaPeriod2.seekToUs(rtspMediaPeriod2.f30954a);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void M(RtpDataLoadable rtpDataLoadable, long j, long j2, boolean z) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void K(RtpDataLoadable rtpDataLoadable, long j, long j2) {
            if (RtspMediaPeriod.this.getBufferedPositionUs() == 0) {
                if (RtspMediaPeriod.this.f) {
                    return;
                }
                RtspMediaPeriod.this.P();
                RtspMediaPeriod.this.f = true;
                return;
            }
            for (int i = 0; i < RtspMediaPeriod.this.f4354a.size(); i++) {
                d dVar = (d) RtspMediaPeriod.this.f4354a.get(i);
                if (dVar.f4362a.f30956a == rtpDataLoadable) {
                    dVar.c();
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Loader.b A(RtpDataLoadable rtpDataLoadable, long j, long j2, IOException iOException, int i) {
            if (!RtspMediaPeriod.this.d) {
                RtspMediaPeriod.this.f4353a = iOException;
            } else if (!(iOException.getCause() instanceof BindException)) {
                RtspMediaPeriod.this.f4350a = new RtspMediaSource.RtspPlaybackException(rtpDataLoadable.f4322a.f4411a.toString(), iOException);
            } else if (RtspMediaPeriod.b(RtspMediaPeriod.this) < 3) {
                return Loader.f5047a;
            }
            return Loader.f5050c;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RtpDataLoadable f30956a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final f f4360a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f4361a;

        public c(f fVar, int i, RtpDataChannel.Factory factory) {
            this.f4360a = fVar;
            this.f30956a = new RtpDataLoadable(i, fVar, new RtpDataLoadable.EventListener() { // from class: com.google.android.exoplayer2.source.rtsp.e
                @Override // com.google.android.exoplayer2.source.rtsp.RtpDataLoadable.EventListener
                public final void a(String str, RtpDataChannel rtpDataChannel) {
                    this.f30973a.f(str, rtpDataChannel);
                }
            }, RtspMediaPeriod.this.f4349a, factory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, RtpDataChannel rtpDataChannel) {
            this.f4361a = str;
            RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListenerF = rtpDataChannel.f();
            if (interleavedBinaryDataListenerF != null) {
                RtspMediaPeriod.this.f4347a.u0(rtpDataChannel.getLocalPort(), interleavedBinaryDataListenerF);
                RtspMediaPeriod.this.f = true;
            }
            RtspMediaPeriod.this.M();
        }

        public Uri c() {
            return this.f30956a.f4322a.f4411a;
        }

        public String d() {
            sb0.k(this.f4361a);
            return this.f4361a;
        }

        public boolean e() {
            return this.f4361a != null;
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SampleQueue f30957a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f4362a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Loader f4364a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4365a;
        public boolean b;

        public d(f fVar, int i, RtpDataChannel.Factory factory) {
            this.f4362a = RtspMediaPeriod.this.new c(fVar, i, factory);
            this.f4364a = new Loader("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i);
            SampleQueue sampleQueueM = SampleQueue.m(RtspMediaPeriod.this.f4351a);
            this.f30957a = sampleQueueM;
            sampleQueueM.d0(RtspMediaPeriod.this.f4349a);
        }

        public void c() {
            if (this.f4365a) {
                return;
            }
            this.f4362a.f30956a.cancelLoad();
            this.f4365a = true;
            RtspMediaPeriod.this.T();
        }

        public long d() {
            return this.f30957a.A();
        }

        public boolean e() {
            return this.f30957a.K(this.f4365a);
        }

        public int f(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return this.f30957a.S(yk3Var, decoderInputBuffer, i, this.f4365a);
        }

        public void g() {
            if (this.b) {
                return;
            }
            this.f4364a.j();
            this.f30957a.T();
            this.b = true;
        }

        public void h(long j) {
            if (this.f4365a) {
                return;
            }
            this.f4362a.f30956a.c();
            this.f30957a.V();
            this.f30957a.b0(j);
        }

        public int i(long j) {
            int iF = this.f30957a.F(j, this.f4365a);
            this.f30957a.e0(iF);
            return iF;
        }

        public void j() {
            this.f4364a.l(this.f4362a.f30956a, RtspMediaPeriod.this.f4349a, 0);
        }
    }

    public final class e implements SampleStream {
        public final int K;

        public e(int i) {
            this.K = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return RtspMediaPeriod.this.N(this.K, yk3Var, decoderInputBuffer, i);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return RtspMediaPeriod.this.J(this.K);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws RtspMediaSource.RtspPlaybackException {
            if (RtspMediaPeriod.this.f4350a != null) {
                throw RtspMediaPeriod.this.f4350a;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return RtspMediaPeriod.this.R(this.K, j);
        }
    }

    public RtspMediaPeriod(Allocator allocator, RtpDataChannel.Factory factory, Uri uri, Listener listener, String str, SocketFactory socketFactory, boolean z) {
        this.f4351a = allocator;
        this.f4346a = factory;
        this.f4348a = listener;
        b bVar = new b();
        this.f4349a = bVar;
        this.f4347a = new RtspClient(bVar, bVar, str, uri, socketFactory, z);
        this.f4354a = new ArrayList();
        this.f4357c = new ArrayList();
        this.b = -9223372036854775807L;
        this.f30954a = -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    public static ImmutableList<da9> G(ImmutableList<d> immutableList) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < immutableList.size(); i++) {
            aVar.a(new da9(Integer.toString(i), (com.google.android.exoplayer2.d) sb0.g(immutableList.get(i).f30957a.G())));
        }
        return aVar.e();
    }

    public static /* synthetic */ int b(RtspMediaPeriod rtspMediaPeriod) {
        int i = rtspMediaPeriod.K;
        rtspMediaPeriod.K = i + 1;
        return i;
    }

    public static /* synthetic */ void u(RtspMediaPeriod rtspMediaPeriod) {
        rtspMediaPeriod.L();
    }

    @Nullable
    public final RtpDataLoadable H(Uri uri) {
        for (int i = 0; i < this.f4354a.size(); i++) {
            if (!this.f4354a.get(i).f4365a) {
                c cVar = this.f4354a.get(i).f4362a;
                if (cVar.c().equals(uri)) {
                    return cVar.f30956a;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public ImmutableList<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return ImmutableList.of();
    }

    public boolean J(int i) {
        return !S() && this.f4354a.get(i).e();
    }

    public final boolean K() {
        return this.b != -9223372036854775807L;
    }

    public final void L() {
        if (this.f4358c || this.d) {
            return;
        }
        for (int i = 0; i < this.f4354a.size(); i++) {
            if (this.f4354a.get(i).f30957a.G() == null) {
                return;
            }
        }
        this.d = true;
        this.f4352a = G(ImmutableList.copyOf((Collection) this.f4354a));
        ((MediaPeriod.Callback) sb0.g(this.f4345a)).h(this);
    }

    public final void M() {
        boolean zE = true;
        for (int i = 0; i < this.f4357c.size(); i++) {
            zE &= this.f4357c.get(i).e();
        }
        if (zE && this.e) {
            this.f4347a.A0(this.f4357c);
        }
    }

    public int N(int i, yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (S()) {
            return -3;
        }
        return this.f4354a.get(i).f(yk3Var, decoderInputBuffer, i2);
    }

    public void O() {
        for (int i = 0; i < this.f4354a.size(); i++) {
            this.f4354a.get(i).g();
        }
        gj9.p(this.f4347a);
        this.f4358c = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P() {
        this.f4347a.v0();
        RtpDataChannel.Factory factoryB = this.f4346a.b();
        if (factoryB == null) {
            this.f4350a = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f4354a.size());
        ArrayList arrayList2 = new ArrayList(this.f4357c.size());
        for (int i = 0; i < this.f4354a.size(); i++) {
            d dVar = this.f4354a.get(i);
            if (dVar.f4365a) {
                arrayList.add(dVar);
            } else {
                d dVar2 = new d(dVar.f4362a.f4360a, i, factoryB);
                arrayList.add(dVar2);
                dVar2.j();
                if (this.f4357c.contains(dVar.f4362a)) {
                    arrayList2.add(dVar2.f4362a);
                }
            }
        }
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f4354a);
        this.f4354a.clear();
        this.f4354a.addAll(arrayList);
        this.f4357c.clear();
        this.f4357c.addAll(arrayList2);
        for (int i2 = 0; i2 < immutableListCopyOf.size(); i2++) {
            ((d) immutableListCopyOf.get(i2)).c();
        }
    }

    public final boolean Q(long j) {
        for (int i = 0; i < this.f4354a.size(); i++) {
            if (!this.f4354a.get(i).f30957a.Z(j, false)) {
                return false;
            }
        }
        return true;
    }

    public int R(int i, long j) {
        if (S()) {
            return -3;
        }
        return this.f4354a.get(i).i(j);
    }

    public final boolean S() {
        return this.f4356b;
    }

    public final void T() {
        this.f4355a = true;
        for (int i = 0; i < this.f4354a.size(); i++) {
            this.f4355a &= this.f4354a.get(i).f4365a;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f4345a = callback;
        try {
            this.f4347a.B0();
        } catch (IOException e2) {
            this.f4353a = e2;
            gj9.p(this.f4347a);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        if (K()) {
            return;
        }
        for (int i = 0; i < this.f4354a.size(); i++) {
            d dVar = this.f4354a.get(i);
            if (!dVar.f4365a) {
                dVar.f30957a.r(j, z, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        sb0.i(this.d);
        return new ga9((da9[]) ((ImmutableList) sb0.g(this.f4352a)).toArray(new da9[0]));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                sampleStreamArr[i] = null;
            }
        }
        this.f4357c.clear();
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                da9 da9VarD = exoTrackSelection.d();
                int iIndexOf = ((ImmutableList) sb0.g(this.f4352a)).indexOf(da9VarD);
                this.f4357c.add(((d) sb0.g(this.f4354a.get(iIndexOf))).f4362a);
                if (this.f4352a.contains(da9VarD) && sampleStreamArr[i2] == null) {
                    sampleStreamArr[i2] = new e(iIndexOf);
                    zArr2[i2] = true;
                }
            }
        }
        for (int i3 = 0; i3 < this.f4354a.size(); i3++) {
            d dVar = this.f4354a.get(i3);
            if (!this.f4357c.contains(dVar.f4362a)) {
                dVar.c();
            }
        }
        this.e = true;
        M();
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.f4355a || this.f4354a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j = this.f30954a;
        if (j != -9223372036854775807L) {
            return j;
        }
        boolean z = true;
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < this.f4354a.size(); i++) {
            d dVar = this.f4354a.get(i);
            if (!dVar.f4365a) {
                jMin = Math.min(jMin, dVar.d());
                z = false;
            }
        }
        if (z || jMin == Long.MIN_VALUE) {
            return 0L;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return !this.f4355a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        IOException iOException = this.f4353a;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (!this.f4356b) {
            return -9223372036854775807L;
        }
        this.f4356b = false;
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        if (getBufferedPositionUs() == 0 && !this.f) {
            this.c = j;
            return j;
        }
        discardBuffer(j, false);
        this.f30954a = j;
        if (K()) {
            int iQ0 = this.f4347a.q0();
            if (iQ0 == 1) {
                return j;
            }
            if (iQ0 != 2) {
                throw new IllegalStateException();
            }
            this.b = j;
            this.f4347a.y0(j);
            return j;
        }
        if (Q(j)) {
            return j;
        }
        this.b = j;
        this.f4347a.y0(j);
        for (int i = 0; i < this.f4354a.size(); i++) {
            this.f4354a.get(i).h(j);
        }
        return j;
    }
}
