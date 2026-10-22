package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.common.collect.o;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HlsPlaylistTracker.Factory f30931a = new HlsPlaylistTracker.Factory() { // from class: com.zj.adlib.mg2
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory
        public final HlsPlaylistTracker a(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            return new a(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory);
        }
    };
    public static final double b = 3.5d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final double f4240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f4242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Handler f4243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaSourceEventListener.a f4244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsDataSourceFactory f4245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public HlsMediaPlaylist f4246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsPlaylistParserFactory f4247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public HlsPlaylistTracker.PrimaryPlaylistListener f4248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c f4249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Loader f4251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<Uri, c> f4252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.PlaylistEventListener> f4253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4254a;

    public class b implements HlsPlaylistTracker.PlaylistEventListener {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
        public boolean b(Uri uri, LoadErrorHandlingPolicy.c cVar, boolean z) {
            c cVar2;
            if (a.this.f4246a == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = ((com.google.android.exoplayer2.source.hls.playlist.c) gj9.k(a.this.f4249a)).f4266c;
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    c cVar3 = (c) a.this.f4252a.get(list.get(i2).f30936a);
                    if (cVar3 != null && jElapsedRealtime < cVar3.d) {
                        i++;
                    }
                }
                LoadErrorHandlingPolicy.b bVarA = a.this.f4250a.a(new LoadErrorHandlingPolicy.a(1, 0, a.this.f4249a.f4266c.size(), i), cVar);
                if (bVarA != null && bVarA.f31114a == 2 && (cVar2 = (c) a.this.f4252a.get(uri)) != null) {
                    cVar2.h(bVarA.f5043a);
                }
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
        public void onPlaylistChanged() {
            a.this.f4253a.remove(this);
        }
    }

    public final class c implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
        public static final String f = "_HLS_msn";
        public static final String g = "_HLS_part";
        public static final String h = "_HLS_skip";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30933a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Uri f4255a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public HlsMediaPlaylist f4256a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSource f4258a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Loader f4259a = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public IOException f4260a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4261a;
        public long b;
        public long c;
        public long d;

        public c(Uri uri) {
            this.f4255a = uri;
            this.f4258a = a.this.f4245a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(Uri uri) {
            this.f4261a = false;
            n(uri);
        }

        public final boolean h(long j) {
            this.d = SystemClock.elapsedRealtime() + j;
            return this.f4255a.equals(a.this.f4242a) && !a.this.C();
        }

        public final Uri i() {
            HlsMediaPlaylist hlsMediaPlaylist = this.f4256a;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.f fVar = hlsMediaPlaylist.f4166a;
                if (fVar.f30927a != -9223372036854775807L || fVar.f4186b) {
                    Uri.Builder builderBuildUpon = this.f4255a.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.f4256a;
                    if (hlsMediaPlaylist2.f4166a.f4186b) {
                        builderBuildUpon.appendQueryParameter(f, String.valueOf(hlsMediaPlaylist2.f4171c + ((long) hlsMediaPlaylist2.f4169b.size())));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.f4256a;
                        if (hlsMediaPlaylist3.f4176e != -9223372036854775807L) {
                            List<HlsMediaPlaylist.b> list = hlsMediaPlaylist3.f4172c;
                            int size = list.size();
                            if (!list.isEmpty() && ((HlsMediaPlaylist.b) o.w(list)).c) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter(g, String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.f fVar2 = this.f4256a.f4166a;
                    if (fVar2.f30927a != -9223372036854775807L) {
                        builderBuildUpon.appendQueryParameter(h, fVar2.f4185a ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.f4255a;
        }

        @Nullable
        public HlsMediaPlaylist j() {
            return this.f4256a;
        }

        public boolean k() {
            int i;
            if (this.f4256a == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, gj9.H1(this.f4256a.f4178f));
            HlsMediaPlaylist hlsMediaPlaylist = this.f4256a;
            return hlsMediaPlaylist.f4177e || (i = hlsMediaPlaylist.f30923a) == 2 || i == 1 || this.f30933a + jMax > jElapsedRealtime;
        }

        public void m() {
            o(this.f4255a);
        }

        public final void n(Uri uri) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.f4258a, uri, 4, a.this.f4247a.b(a.this.f4249a, this.f4256a));
            a.this.f4244a.z(new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, this.f4259a.l(parsingLoadable, this, a.this.f4250a.getMinimumLoadableRetryCount(parsingLoadable.f31120a))), parsingLoadable.f31120a);
        }

        public final void o(final Uri uri) {
            this.d = 0L;
            if (this.f4261a || this.f4259a.i() || this.f4259a.h()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.c) {
                n(uri);
            } else {
                this.f4261a = true;
                a.this.f4243a.postDelayed(new Runnable() { // from class: com.zj.adlib.ng2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18409a.l(uri);
                    }
                }, this.c - jElapsedRealtime);
            }
        }

        public void p() throws IOException {
            this.f4259a.maybeThrowError();
            IOException iOException = this.f4260a;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void M(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
            az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
            a.this.f4250a.onLoadTaskConcluded(parsingLoadable.f5062a);
            a.this.f4244a.q(az4Var, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void K(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2) {
            HlsPlaylist hlsPlaylistC = parsingLoadable.c();
            az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
            if (hlsPlaylistC instanceof HlsMediaPlaylist) {
                t((HlsMediaPlaylist) hlsPlaylistC, az4Var);
                a.this.f4244a.t(az4Var, 4);
            } else {
                this.f4260a = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.f4244a.x(az4Var, 4, this.f4260a, true);
            }
            a.this.f4250a.onLoadTaskConcluded(parsingLoadable.f5062a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Loader.b A(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, IOException iOException, int i) {
            Loader.b bVarG;
            az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
            boolean z = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((parsingLoadable.d().getQueryParameter(f) != null) || z) {
                int i2 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
                if (z || i2 == 400 || i2 == 503) {
                    this.c = SystemClock.elapsedRealtime();
                    m();
                    ((MediaSourceEventListener.a) gj9.k(a.this.f4244a)).x(az4Var, parsingLoadable.f31120a, iOException, true);
                    return Loader.f5050c;
                }
            }
            LoadErrorHandlingPolicy.c cVar = new LoadErrorHandlingPolicy.c(az4Var, new oh5(parsingLoadable.f31120a), iOException, i);
            if (a.this.E(this.f4255a, cVar, false)) {
                long jB = a.this.f4250a.b(cVar);
                bVarG = jB != -9223372036854775807L ? Loader.g(false, jB) : Loader.f5051d;
            } else {
                bVarG = Loader.f5050c;
            }
            boolean zC = true ^ bVarG.c();
            a.this.f4244a.x(az4Var, parsingLoadable.f31120a, iOException, zC);
            if (zC) {
                a.this.f4250a.onLoadTaskConcluded(parsingLoadable.f5062a);
            }
            return bVarG;
        }

        public final void t(HlsMediaPlaylist hlsMediaPlaylist, az4 az4Var) {
            IOException playlistStuckException;
            boolean z;
            long j;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.f4256a;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f30933a = jElapsedRealtime;
            HlsMediaPlaylist hlsMediaPlaylistW = a.this.w(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.f4256a = hlsMediaPlaylistW;
            if (hlsMediaPlaylistW != hlsMediaPlaylist2) {
                this.f4260a = null;
                this.b = jElapsedRealtime;
                a.this.I(this.f4255a, hlsMediaPlaylistW);
            } else if (!hlsMediaPlaylistW.f4177e) {
                long size = hlsMediaPlaylist.f4171c + ((long) hlsMediaPlaylist.f4169b.size());
                HlsMediaPlaylist hlsMediaPlaylist3 = this.f4256a;
                if (size < hlsMediaPlaylist3.f4171c) {
                    playlistStuckException = new HlsPlaylistTracker.PlaylistResetException(this.f4255a);
                    z = true;
                } else {
                    playlistStuckException = ((double) (jElapsedRealtime - this.b)) > ((double) gj9.H1(hlsMediaPlaylist3.f4174d)) * a.this.f4240a ? new HlsPlaylistTracker.PlaylistStuckException(this.f4255a) : null;
                    z = false;
                }
                if (playlistStuckException != null) {
                    this.f4260a = playlistStuckException;
                    a.this.E(this.f4255a, new LoadErrorHandlingPolicy.c(az4Var, new oh5(4), playlistStuckException, 1), z);
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist4 = this.f4256a;
            if (hlsMediaPlaylist4.f4166a.f4186b) {
                j = 0;
            } else {
                j = hlsMediaPlaylist4 != hlsMediaPlaylist2 ? hlsMediaPlaylist4.f4174d : hlsMediaPlaylist4.f4174d / 2;
            }
            this.c = jElapsedRealtime + gj9.H1(j);
            if (!(this.f4256a.f4176e != -9223372036854775807L || this.f4255a.equals(a.this.f4242a)) || this.f4256a.f4177e) {
                return;
            }
            o(i());
        }

        public void u() {
            this.f4259a.j();
        }
    }

    public a(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    public static HlsMediaPlaylist.d v(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i = (int) (hlsMediaPlaylist2.f4171c - hlsMediaPlaylist.f4171c);
        List<HlsMediaPlaylist.d> list = hlsMediaPlaylist.f4169b;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    public final boolean B(Uri uri) {
        List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = this.f4249a.f4266c;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(list.get(i).f30936a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean C() {
        List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = this.f4249a.f4266c;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            c cVar = (c) sb0.g(this.f4252a.get(list.get(i).f30936a));
            if (jElapsedRealtime > cVar.d) {
                Uri uri = cVar.f4255a;
                this.f4242a = uri;
                cVar.o(z(uri));
                return true;
            }
        }
        return false;
    }

    public final void D(Uri uri) {
        if (uri.equals(this.f4242a) || !B(uri)) {
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.f4246a;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.f4177e) {
            this.f4242a = uri;
            c cVar = this.f4252a.get(uri);
            HlsMediaPlaylist hlsMediaPlaylist2 = cVar.f4256a;
            if (hlsMediaPlaylist2 == null || !hlsMediaPlaylist2.f4177e) {
                cVar.o(z(uri));
            } else {
                this.f4246a = hlsMediaPlaylist2;
                this.f4248a.z(hlsMediaPlaylist2);
            }
        }
    }

    public final boolean E(Uri uri, LoadErrorHandlingPolicy.c cVar, boolean z) {
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it = this.f4253a.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !it.next().b(uri, cVar, z);
        }
        return z2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void M(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        this.f4250a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f4244a.q(az4Var, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void K(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2) {
        HlsPlaylist hlsPlaylistC = parsingLoadable.c();
        boolean z = hlsPlaylistC instanceof HlsMediaPlaylist;
        com.google.android.exoplayer2.source.hls.playlist.c cVarD = z ? com.google.android.exoplayer2.source.hls.playlist.c.d(hlsPlaylistC.f30928a) : (com.google.android.exoplayer2.source.hls.playlist.c) hlsPlaylistC;
        this.f4249a = cVarD;
        this.f4242a = cVarD.f4266c.get(0).f30936a;
        this.f4253a.add(new b());
        u(cVarD.f4265b);
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        c cVar = this.f4252a.get(this.f4242a);
        if (z) {
            cVar.t((HlsMediaPlaylist) hlsPlaylistC, az4Var);
        } else {
            cVar.m();
        }
        this.f4250a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f4244a.t(az4Var, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public Loader.b A(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, IOException iOException, int i) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        long jB = this.f4250a.b(new LoadErrorHandlingPolicy.c(az4Var, new oh5(parsingLoadable.f31120a), iOException, i));
        boolean z = jB == -9223372036854775807L;
        this.f4244a.x(az4Var, parsingLoadable.f31120a, iOException, z);
        if (z) {
            this.f4250a.onLoadTaskConcluded(parsingLoadable.f5062a);
        }
        return z ? Loader.f5051d : Loader.g(false, jB);
    }

    public final void I(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.f4242a)) {
            if (this.f4246a == null) {
                this.f4254a = !hlsMediaPlaylist.f4177e;
                this.f4241a = hlsMediaPlaylist.f4168b;
            }
            this.f4246a = hlsMediaPlaylist;
            this.f4248a.z(hlsMediaPlaylist);
        }
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it = this.f4253a.iterator();
        while (it.hasNext()) {
            it.next().onPlaylistChanged();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.f4253a.remove(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void b(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        sb0.g(playlistEventListener);
        this.f4253a.add(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public HlsMediaPlaylist c(Uri uri, boolean z) {
        HlsMediaPlaylist hlsMediaPlaylistJ = this.f4252a.get(uri).j();
        if (hlsMediaPlaylistJ != null && z) {
            D(uri);
        }
        return hlsMediaPlaylistJ;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c d() {
        return this.f4249a;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void e(Uri uri, MediaSourceEventListener.a aVar, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.f4243a = gj9.y();
        this.f4244a = aVar;
        this.f4248a = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f4245a.a(4), uri, 4, this.f4247a.a());
        sb0.i(this.f4251a == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f4251a = loader;
        aVar.z(new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, loader.l(parsingLoadable, this, this.f4250a.getMinimumLoadableRetryCount(parsingLoadable.f31120a))), parsingLoadable.f31120a);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean excludeMediaPlaylist(Uri uri, long j) {
        c cVar = this.f4252a.get(uri);
        if (cVar != null) {
            return !cVar.h(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.f4241a;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.f4254a;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(Uri uri) {
        return this.f4252a.get(uri).k();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(Uri uri) throws IOException {
        this.f4252a.get(uri).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        Loader loader = this.f4251a;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.f4242a;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(Uri uri) {
        this.f4252a.get(uri).m();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f4242a = null;
        this.f4246a = null;
        this.f4249a = null;
        this.f4241a = -9223372036854775807L;
        this.f4251a.j();
        this.f4251a = null;
        Iterator<c> it = this.f4252a.values().iterator();
        while (it.hasNext()) {
            it.next().u();
        }
        this.f4243a.removeCallbacksAndMessages(null);
        this.f4243a = null;
        this.f4252a.clear();
    }

    public final void u(List<Uri> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.f4252a.put(uri, new c(uri));
        }
    }

    public final HlsMediaPlaylist w(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.e(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.b(y(hlsMediaPlaylist, hlsMediaPlaylist2), x(hlsMediaPlaylist, hlsMediaPlaylist2));
        }
        return hlsMediaPlaylist2.f4177e ? hlsMediaPlaylist.c() : hlsMediaPlaylist;
    }

    public final int x(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        HlsMediaPlaylist.d dVarV;
        if (hlsMediaPlaylist2.f4175d) {
            return hlsMediaPlaylist2.b;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f4246a;
        int i = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.b : 0;
        return (hlsMediaPlaylist == null || (dVarV = v(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i : (hlsMediaPlaylist.b + dVarV.K) - hlsMediaPlaylist2.f4169b.get(0).K;
    }

    public final long y(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.f4179f) {
            return hlsMediaPlaylist2.f4168b;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f4246a;
        long j = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.f4168b : 0L;
        if (hlsMediaPlaylist == null) {
            return j;
        }
        int size = hlsMediaPlaylist.f4169b.size();
        HlsMediaPlaylist.d dVarV = v(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (dVarV != null) {
            return hlsMediaPlaylist.f4168b + dVarV.b;
        }
        return ((long) size) == hlsMediaPlaylist2.f4171c - hlsMediaPlaylist.f4171c ? hlsMediaPlaylist.d() : j;
    }

    public final Uri z(Uri uri) {
        HlsMediaPlaylist.c cVar;
        HlsMediaPlaylist hlsMediaPlaylist = this.f4246a;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.f4166a.f4186b || (cVar = hlsMediaPlaylist.f4167a.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter(c.f, String.valueOf(cVar.f4180a));
        int i = cVar.f30924a;
        if (i != -1) {
            builderBuildUpon.appendQueryParameter(c.g, String.valueOf(i));
        }
        return builderBuildUpon.build();
    }

    public a(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d) {
        this.f4245a = hlsDataSourceFactory;
        this.f4247a = hlsPlaylistParserFactory;
        this.f4250a = loadErrorHandlingPolicy;
        this.f4240a = d;
        this.f4253a = new CopyOnWriteArrayList<>();
        this.f4252a = new HashMap<>();
        this.f4241a = -9223372036854775807L;
    }
}
