package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.common.math.LongMath;
import com.zj.adlib.ab3;
import com.zj.adlib.az4;
import com.zj.adlib.c62;
import com.zj.adlib.c68;
import com.zj.adlib.df2;
import com.zj.adlib.eo6;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.oh5;
import com.zj.adlib.rg3;
import com.zj.adlib.sb0;
import com.zj.adlib.vz;
import com.zj.adlib.xr0;
import com.zj.adlib.yi9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DashMediaSource extends BaseMediaSource {
    public static final long f = 30000;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f3917f = "DashMediaSource";

    @Deprecated
    public static final long g = 30000;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f3918g = "DashMediaSource";
    public static final long h = 5000;
    public static final long i = 5000000;
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Uri f3919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f3920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<DashMediaPeriod> f3921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f3922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.g.C0682g f3923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.g f3924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f3925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashChunkSource.Factory f3926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e f3927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlayerEmsgHandler.PlayerEmsgCallback f3928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f3929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSource f3930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f3931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Loader f3932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoaderErrorThrower f3933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ParsingLoadable.Parser<? extends c62> f3934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f3935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c62 f3936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xr0 f3937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IOException f3938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f3940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3941a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Uri f3942b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final MediaSourceEventListener.a f3943b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f3944b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3945b;
    public long c;
    public long d;
    public long e;

    public static final class Factory implements MediaSourceFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30876a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DrmSessionManagerProvider f3946a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CompositeSequenceableLoaderFactory f3947a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DashChunkSource.Factory f3948a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final DataSource.Factory f3949a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LoadErrorHandlingPolicy f3950a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public ParsingLoadable.Parser<? extends c62> f3951a;

        public Factory(DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.dash.a.C0688a(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DashMediaSource c(com.google.android.exoplayer2.g gVar) {
            sb0.g(gVar.f3327a);
            ParsingLoadable.Parser aVar = this.f3951a;
            if (aVar == null) {
                aVar = new com.google.android.exoplayer2.source.dash.manifest.a();
            }
            List<StreamKey> list = gVar.f3327a.f3372a;
            return new DashMediaSource(gVar, null, this.f3949a, !list.isEmpty() ? new rg3(aVar, list) : aVar, this.f3948a, this.f3947a, this.f3946a.a(gVar), this.f3950a, this.f30876a, null);
        }

        public DashMediaSource e(c62 c62Var) {
            return f(c62Var, new com.google.android.exoplayer2.g.c().L(Uri.EMPTY).D("DashMediaSource").F("application/dash+xml").a());
        }

        public DashMediaSource f(c62 c62Var, com.google.android.exoplayer2.g gVar) {
            sb0.a(!c62Var.f15743a);
            com.google.android.exoplayer2.g.c cVarF = gVar.b().F("application/dash+xml");
            if (gVar.f3327a == null) {
                cVarF.L(Uri.EMPTY);
            }
            com.google.android.exoplayer2.g gVarA = cVarF.a();
            return new DashMediaSource(gVarA, c62Var, null, null, this.f3948a, this.f3947a, this.f3946a.a(gVarA), this.f3950a, this.f30876a, null);
        }

        public Factory g(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f3947a = (CompositeSequenceableLoaderFactory) sb0.h(compositeSequenceableLoaderFactory, "DashMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{0};
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory a(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f3946a = (DrmSessionManagerProvider) sb0.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory i(long j) {
            this.f30876a = j;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f3950a = (LoadErrorHandlingPolicy) sb0.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory k(@Nullable ParsingLoadable.Parser<? extends c62> parser) {
            this.f3951a = parser;
            return this;
        }

        public Factory(DashChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.f3948a = (DashChunkSource.Factory) sb0.g(factory);
            this.f3949a = factory2;
            this.f3946a = new com.google.android.exoplayer2.drm.a();
            this.f3950a = new com.google.android.exoplayer2.upstream.f();
            this.f30876a = 30000L;
            this.f3947a = new df2();
        }
    }

    public class a implements SntpClient.InitializationCallback {
        public a() {
        }

        @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
        public void onInitializationFailed(IOException iOException) {
            DashMediaSource.this.k0(iOException);
        }

        @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
        public void onInitialized() {
            DashMediaSource.this.l0(SntpClient.h());
        }
    }

    public static final class b extends Timeline {
        public final int N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30878a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final com.google.android.exoplayer2.g.C0682g f3952a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.g f3953a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c62 f3954a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;

        public b(long j, long j2, long j3, int i, long j4, long j5, long j6, c62 c62Var, com.google.android.exoplayer2.g gVar, @Nullable com.google.android.exoplayer2.g.C0682g c0682g) {
            sb0.i(c62Var.f15743a == (c0682g != null));
            this.f30878a = j;
            this.b = j2;
            this.c = j3;
            this.N = i;
            this.d = j4;
            this.e = j5;
            this.f = j6;
            this.f3954a = c62Var;
            this.f3953a = gVar;
            this.f3952a = c0682g;
        }

        public static boolean B(c62 c62Var) {
            return c62Var.f15743a && c62Var.d != -9223372036854775807L && c62Var.b == -9223372036854775807L;
        }

        public final long A(long j) {
            DashSegmentIndex dashSegmentIndexK;
            long j2 = this.f;
            if (!B(this.f3954a)) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.e) {
                    return -9223372036854775807L;
                }
            }
            long j3 = this.d + j2;
            long jF = this.f3954a.f(0);
            int i = 0;
            while (i < this.f3954a.d() - 1 && j3 >= jF) {
                j3 -= jF;
                i++;
                jF = this.f3954a.f(i);
            }
            eo6 eo6VarC = this.f3954a.c(i);
            int iA = eo6VarC.a(2);
            return (iA == -1 || (dashSegmentIndexK = eo6VarC.f16370a.get(iA).f20347a.get(0).k()) == null || dashSegmentIndexK.g(jF) == 0) ? j2 : (j2 + dashSegmentIndexK.getTimeUs(dashSegmentIndexK.e(j3, jF))) - j3;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int f(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.N) >= 0 && iIntValue < m()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            sb0.c(i, 0, m());
            return bVar.x(z ? this.f3954a.c(i).f16369a : null, z ? Integer.valueOf(this.N + i) : null, 0, this.f3954a.f(i), gj9.Z0(this.f3954a.c(i).f41481a - this.f3954a.c(0).f41481a) - this.d);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int m() {
            return this.f3954a.d();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object s(int i) {
            sb0.c(i, 0, m());
            return Integer.valueOf(this.N + i);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            sb0.c(i, 0, 1);
            long jA = A(j);
            Object obj = Timeline.d.d;
            com.google.android.exoplayer2.g gVar = this.f3953a;
            c62 c62Var = this.f3954a;
            return dVar.m(obj, gVar, c62Var, this.f30878a, this.b, this.c, true, B(c62Var), this.f3952a, jA, this.e, 0, m() - 1, this.d);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int v() {
            return 1;
        }
    }

    public final class c implements PlayerEmsgHandler.PlayerEmsgCallback {
        public c() {
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void a() {
            DashMediaSource.this.e0();
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void b(long j) {
            DashMediaSource.this.d0(j);
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public static final class d implements ParsingLoadable.Parser<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f30880a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream, com.google.common.base.b.c)).readLine();
            try {
                Matcher matcher = f30880a.matcher(line);
                if (!matcher.matches()) {
                    throw ParserException.createForMalformedManifest("Couldn't parse timestamp: " + line, null);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j2 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= j * ((((j2 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }
    }

    public final class e implements Loader.Callback<ParsingLoadable<c62>> {
        public e() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void M(ParsingLoadable<c62> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.f0(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void K(ParsingLoadable<c62> parsingLoadable, long j, long j2) {
            DashMediaSource.this.g0(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.b A(ParsingLoadable<c62> parsingLoadable, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.h0(parsingLoadable, j, j2, iOException, i);
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public final class g implements Loader.Callback<ParsingLoadable<Long>> {
        public g() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void M(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.f0(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void K(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            DashMediaSource.this.i0(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.b A(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.j0(parsingLoadable, j, j2, iOException);
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public static final class h implements ParsingLoadable.Parser<Long> {
        public h() {
        }

        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(gj9.h1(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        ab3.a("goog.exo.dash");
    }

    public /* synthetic */ DashMediaSource(com.google.android.exoplayer2.g gVar, c62 c62Var, DataSource.Factory factory, ParsingLoadable.Parser parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, a aVar) {
        this(gVar, c62Var, factory, parser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, j);
    }

    public static long V(eo6 eo6Var, long j, long j2) {
        long jZ0 = gj9.Z0(eo6Var.f41481a);
        boolean Z = Z(eo6Var);
        long jMin = Long.MAX_VALUE;
        for (int i2 = 0; i2 < eo6Var.f16370a.size(); i2++) {
            vz vzVar = eo6Var.f16370a.get(i2);
            List<Representation> list = vzVar.f20347a;
            if ((!Z || vzVar.b != 3) && !list.isEmpty()) {
                DashSegmentIndex dashSegmentIndexK = list.get(0).k();
                if (dashSegmentIndexK == null) {
                    return jZ0 + j;
                }
                long jI = dashSegmentIndexK.i(j, j2);
                if (jI == 0) {
                    return jZ0;
                }
                long jH = (dashSegmentIndexK.h(j, j2) + jI) - 1;
                jMin = Math.min(jMin, dashSegmentIndexK.c(jH, j) + dashSegmentIndexK.getTimeUs(jH) + jZ0);
            }
        }
        return jMin;
    }

    public static long W(eo6 eo6Var, long j, long j2) {
        long jZ0 = gj9.Z0(eo6Var.f41481a);
        boolean Z = Z(eo6Var);
        long jMax = jZ0;
        for (int i2 = 0; i2 < eo6Var.f16370a.size(); i2++) {
            vz vzVar = eo6Var.f16370a.get(i2);
            List<Representation> list = vzVar.f20347a;
            if ((!Z || vzVar.b != 3) && !list.isEmpty()) {
                DashSegmentIndex dashSegmentIndexK = list.get(0).k();
                if (dashSegmentIndexK == null || dashSegmentIndexK.i(j, j2) == 0) {
                    return jZ0;
                }
                jMax = Math.max(jMax, dashSegmentIndexK.getTimeUs(dashSegmentIndexK.h(j, j2)) + jZ0);
            }
        }
        return jMax;
    }

    public static long X(c62 c62Var, long j) {
        DashSegmentIndex dashSegmentIndexK;
        int iD = c62Var.d() - 1;
        eo6 eo6VarC = c62Var.c(iD);
        long jZ0 = gj9.Z0(eo6VarC.f41481a);
        long jF = c62Var.f(iD);
        long jZ1 = gj9.Z0(j);
        long jZ2 = gj9.Z0(c62Var.f40908a);
        long jZ3 = gj9.Z0(5000L);
        for (int i2 = 0; i2 < eo6VarC.f16370a.size(); i2++) {
            List<Representation> list = eo6VarC.f16370a.get(i2).f20347a;
            if (!list.isEmpty() && (dashSegmentIndexK = list.get(0).k()) != null) {
                long jB = ((jZ2 + jZ0) + dashSegmentIndexK.b(jF, jZ1)) - jZ1;
                if (jB < jZ3 - 100000 || (jB > jZ3 && jB < jZ3 + 100000)) {
                    jZ3 = jB;
                }
            }
        }
        return LongMath.g(jZ3, 1000L, RoundingMode.CEILING);
    }

    public static boolean Z(eo6 eo6Var) {
        for (int i2 = 0; i2 < eo6Var.f16370a.size(); i2++) {
            int i3 = eo6Var.f16370a.get(i2).b;
            if (i3 == 1 || i3 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean a0(eo6 eo6Var) {
        for (int i2 = 0; i2 < eo6Var.f16370a.size(); i2++) {
            DashSegmentIndex dashSegmentIndexK = eo6Var.f16370a.get(i2).f20347a.get(0).k();
            if (dashSegmentIndexK == null || dashSegmentIndexK.a()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        m0(false);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        int iIntValue = ((Integer) ((gk5) aVar).f16805a).intValue() - this.L;
        MediaSourceEventListener.a aVarCreateEventDispatcher = createEventDispatcher(aVar, this.f3936a.c(iIntValue).f41481a);
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(iIntValue + this.L, this.f3936a, this.f3937a, iIntValue, this.f3926a, this.f3935a, this.f3922a, createDrmEventDispatcher(aVar), this.f3931a, aVarCreateEventDispatcher, this.d, this.f3933a, allocator, this.f3925a, this.f3928a, getPlayerId());
        this.f3921a.put(dashMediaPeriod.K, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public final long Y() {
        return Math.min((this.K - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f3924a;
    }

    public final void c0() {
        SntpClient.j(this.f3932a, new a());
    }

    public void d0(long j) {
        long j2 = this.e;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.e = j;
        }
    }

    public void e0() {
        this.f3920a.removeCallbacks(this.f3944b);
        t0();
    }

    public void f0(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        this.f3931a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f3943b.q(az4Var, parsingLoadable.f31120a);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
    public void g0(ParsingLoadable<c62> parsingLoadable, long j, long j2) {
        boolean z;
        int i2;
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        this.f3931a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f3943b.t(az4Var, parsingLoadable.f31120a);
        c62 c62VarC = parsingLoadable.c();
        c62 c62Var = this.f3936a;
        int iD = c62Var == null ? 0 : c62Var.d();
        long j3 = c62VarC.c(0).f41481a;
        int i3 = 0;
        while (i3 < iD && this.f3936a.c(i3).f41481a < j3) {
            i3++;
        }
        if (c62VarC.f15743a) {
            if (iD - i3 > c62VarC.d()) {
                Log.n("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j4 = this.e;
                if (j4 == -9223372036854775807L || c62VarC.g * 1000 > j4) {
                    z = false;
                } else {
                    Log.n("DashMediaSource", "Loaded stale dynamic manifest: " + c62VarC.g + ", " + this.e);
                }
                if (z) {
                    i2 = this.K;
                    this.K = i2 + 1;
                    if (i2 < this.f3931a.getMinimumLoadableRetryCount(parsingLoadable.f31120a)) {
                        r0(Y());
                        return;
                    } else {
                        this.f3938a = new DashManifestStaleException();
                        return;
                    }
                }
                this.K = 0;
            }
            z = true;
            if (z) {
                i2 = this.K;
                this.K = i2 + 1;
                if (i2 < this.f3931a.getMinimumLoadableRetryCount(parsingLoadable.f31120a)) {
                    r0(Y());
                    return;
                } else {
                    this.f3938a = new DashManifestStaleException();
                    return;
                }
            }
            this.K = 0;
        }
        this.f3936a = c62VarC;
        this.f3945b = c62VarC.f15743a & this.f3945b;
        this.b = j - j2;
        this.c = j;
        synchronized (this.f3939a) {
            if (parsingLoadable.f5063a.f5026a == this.f3919a) {
                Uri uriD = this.f3936a.f15738a;
                if (uriD == null) {
                    uriD = parsingLoadable.d();
                }
                this.f3919a = uriD;
            }
        }
        if (iD != 0) {
            this.L += i3;
            m0(true);
            return;
        }
        c62 c62Var2 = this.f3936a;
        if (!c62Var2.f15743a) {
            m0(true);
            return;
        }
        yi9 yi9Var = c62Var2.f15741a;
        if (yi9Var != null) {
            o0(yi9Var);
        } else {
            c0();
        }
    }

    public Loader.b h0(ParsingLoadable<c62> parsingLoadable, long j, long j2, IOException iOException, int i2) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        long jB = this.f3931a.b(new LoadErrorHandlingPolicy.c(az4Var, new oh5(parsingLoadable.f31120a), iOException, i2));
        Loader.b bVarG = jB == -9223372036854775807L ? Loader.f5051d : Loader.g(false, jB);
        boolean z = !bVarG.c();
        this.f3943b.x(az4Var, parsingLoadable.f31120a, iOException, z);
        if (z) {
            this.f3931a.onLoadTaskConcluded(parsingLoadable.f5062a);
        }
        return bVarG;
    }

    public void i0(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        this.f3931a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f3943b.t(az4Var, parsingLoadable.f31120a);
        l0(parsingLoadable.c().longValue() - j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.x();
        this.f3921a.remove(dashMediaPeriod.K);
    }

    public Loader.b j0(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
        this.f3943b.x(new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a()), parsingLoadable.f31120a, iOException, true);
        this.f3931a.onLoadTaskConcluded(parsingLoadable.f5062a);
        k0(iOException);
        return Loader.f5050c;
    }

    public final void k0(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        m0(true);
    }

    public final void l0(long j) {
        this.d = j;
        m0(true);
    }

    public final void m0(boolean z) {
        long j;
        long j2;
        for (int i2 = 0; i2 < this.f3921a.size(); i2++) {
            int iKeyAt = this.f3921a.keyAt(i2);
            if (iKeyAt >= this.L) {
                this.f3921a.valueAt(i2).B(this.f3936a, iKeyAt - this.L);
            }
        }
        eo6 eo6VarC = this.f3936a.c(0);
        int iD = this.f3936a.d() - 1;
        eo6 eo6VarC2 = this.f3936a.c(iD);
        long jF = this.f3936a.f(iD);
        long jZ0 = gj9.Z0(gj9.m0(this.d));
        long jW = W(eo6VarC, this.f3936a.f(0), jZ0);
        long jV = V(eo6VarC2, jF, jZ0);
        boolean z2 = this.f3936a.f15743a && !a0(eo6VarC2);
        if (z2) {
            long j3 = this.f3936a.e;
            if (j3 != -9223372036854775807L) {
                jW = Math.max(jW, jV - gj9.Z0(j3));
            }
        }
        long j4 = jV - jW;
        c62 c62Var = this.f3936a;
        if (c62Var.f15743a) {
            sb0.i(c62Var.f40908a != -9223372036854775807L);
            long jZ1 = (jZ0 - gj9.Z0(this.f3936a.f40908a)) - jW;
            u0(jZ1, j4);
            long jH1 = this.f3936a.f40908a + gj9.H1(jW);
            long jZ2 = jZ1 - gj9.Z0(this.f3923a.f3363a);
            long jMin = Math.min(5000000L, j4 / 2);
            j = jH1;
            j2 = jZ2 < jMin ? jMin : jZ2;
        } else {
            j = -9223372036854775807L;
            j2 = 0;
        }
        long jZ3 = jW - gj9.Z0(eo6VarC.f41481a);
        c62 c62Var2 = this.f3936a;
        refreshSourceInfo(new b(c62Var2.f40908a, j, this.d, this.L, jZ3, j4, j2, c62Var2, this.f3924a, c62Var2.f15743a ? this.f3923a : null));
        if (this.f3941a) {
            return;
        }
        this.f3920a.removeCallbacks(this.f3944b);
        if (z2) {
            this.f3920a.postDelayed(this.f3944b, X(this.f3936a, gj9.m0(this.d)));
        }
        if (this.f3945b) {
            t0();
            return;
        }
        if (z) {
            c62 c62Var3 = this.f3936a;
            if (c62Var3.f15743a) {
                long j5 = c62Var3.d;
                if (j5 != -9223372036854775807L) {
                    if (j5 == 0) {
                        j5 = 5000;
                    }
                    r0(Math.max(0L, (this.b + j5) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f3933a.maybeThrowError();
    }

    public void n0(Uri uri) {
        synchronized (this.f3939a) {
            this.f3919a = uri;
            this.f3942b = uri;
        }
    }

    public final void o0(yi9 yi9Var) {
        String str = yi9Var.f46037a;
        if (gj9.c(str, "urn:mpeg:dash:utc:direct:2014") || gj9.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            p0(yi9Var);
            return;
        }
        if (gj9.c(str, "urn:mpeg:dash:utc:http-iso:2014") || gj9.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            q0(yi9Var, new d());
            return;
        }
        if (gj9.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || gj9.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            q0(yi9Var, new h(null));
        } else if (gj9.c(str, "urn:mpeg:dash:utc:ntp:2014") || gj9.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            c0();
        } else {
            k0(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void p0(yi9 yi9Var) {
        try {
            l0(gj9.h1(yi9Var.b) - this.c);
        } catch (ParserException e2) {
            k0(e2);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f3935a = transferListener;
        this.f3922a.prepare();
        this.f3922a.c(Looper.myLooper(), getPlayerId());
        if (this.f3941a) {
            m0(false);
            return;
        }
        this.f3930a = this.f3929a.a();
        this.f3932a = new Loader("DashMediaSource");
        this.f3920a = gj9.y();
        t0();
    }

    public final void q0(yi9 yi9Var, ParsingLoadable.Parser<Long> parser) {
        s0(new ParsingLoadable(this.f3930a, Uri.parse(yi9Var.b), 5, parser), new g(this, null), 1);
    }

    public final void r0(long j) {
        this.f3920a.postDelayed(this.f3940a, j);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f3945b = false;
        this.f3930a = null;
        Loader loader = this.f3932a;
        if (loader != null) {
            loader.j();
            this.f3932a = null;
        }
        this.b = 0L;
        this.c = 0L;
        this.f3936a = this.f3941a ? this.f3936a : null;
        this.f3919a = this.f3942b;
        this.f3938a = null;
        Handler handler = this.f3920a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3920a = null;
        }
        this.d = -9223372036854775807L;
        this.K = 0;
        this.e = -9223372036854775807L;
        this.L = 0;
        this.f3921a.clear();
        this.f3937a.i();
        this.f3922a.release();
    }

    public final <T> void s0(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i2) {
        this.f3943b.z(new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, this.f3932a.l(parsingLoadable, callback, i2)), parsingLoadable.f31120a);
    }

    public final void t0() {
        Uri uri;
        this.f3920a.removeCallbacks(this.f3940a);
        if (this.f3932a.h()) {
            return;
        }
        if (this.f3932a.i()) {
            this.f3945b = true;
            return;
        }
        synchronized (this.f3939a) {
            uri = this.f3919a;
        }
        this.f3945b = false;
        s0(new ParsingLoadable(this.f3930a, uri, 4, this.f3934a), this.f3927a, this.f3931a.getMinimumLoadableRetryCount(4));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:23:0x005b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    /* JADX WARN: Code duplicated, block: B:27:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x00be  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dd  */
    public final void u0(long j, long j2) {
        long j3;
        long jMin;
        long jH1;
        long j4;
        long jT;
        long j5;
        c68 c68Var;
        long j6;
        long jT2;
        float f2;
        float f3;
        c68 c68Var2;
        c68 c68Var3;
        c68 c68Var4;
        c62 c62Var;
        c68 c68Var5;
        long j7;
        long jH2 = gj9.H1(j);
        long j8 = this.f3924a.f3326a.c;
        if (j8 == -9223372036854775807L) {
            c68 c68Var6 = this.f3936a.f15739a;
            if (c68Var6 != null) {
                long j9 = c68Var6.c;
                if (j9 != -9223372036854775807L) {
                    jMin = Math.min(jH2, j9);
                }
                jH1 = gj9.H1(j - j2);
                if (jH1 < 0 && j3 > 0) {
                    jH1 = 0;
                }
                j4 = this.f3936a.c;
                if (j4 != -9223372036854775807L) {
                    jH1 = Math.min(jH1 + j4, jH2);
                }
                jT = jH1;
                j5 = this.f3924a.f3326a.f3364b;
                if (j5 != -9223372036854775807L) {
                    jT = gj9.t(j5, jT, jH2);
                } else {
                    c68Var = this.f3936a.f15739a;
                    if (c68Var != null) {
                        j6 = c68Var.f15747b;
                        if (j6 != -9223372036854775807L) {
                            jT = gj9.t(j6, jT, jH2);
                        }
                    }
                }
                if (jT > j3) {
                    j3 = jT;
                }
                jT2 = this.f3923a.f3363a;
                if (jT2 == -9223372036854775807L) {
                    c62Var = this.f3936a;
                    c68Var5 = c62Var.f15739a;
                    if (c68Var5 != null) {
                        j7 = c68Var5.f15746a;
                        if (j7 != -9223372036854775807L) {
                            jT2 = j7;
                        } else {
                            jT2 = c62Var.f;
                            if (jT2 == -9223372036854775807L) {
                                jT2 = this.f30875a;
                            }
                        }
                    } else {
                        jT2 = c62Var.f;
                        if (jT2 == -9223372036854775807L) {
                            jT2 = this.f30875a;
                        }
                    }
                }
                if (jT2 < jT) {
                    jT2 = jT;
                }
                if (jT2 > j3) {
                    jT2 = gj9.t(gj9.H1(j - Math.min(5000000L, j2 / 2)), jT, j3);
                }
                com.google.android.exoplayer2.g.C0682g c0682g = this.f3924a.f3326a;
                f2 = c0682g.f3362a;
                if (f2 == -3.4028235E38f) {
                    c68Var4 = this.f3936a.f15739a;
                    if (c68Var4 != null) {
                        f2 = c68Var4.f40911a;
                    } else {
                        f2 = -3.4028235E38f;
                    }
                }
                f3 = c0682g.b;
                if (f3 == -3.4028235E38f) {
                    c68Var3 = this.f3936a.f15739a;
                    if (c68Var3 != null) {
                        f3 = c68Var3.b;
                    } else {
                        f3 = -3.4028235E38f;
                    }
                }
                if (f2 == -3.4028235E38f && f3 == -3.4028235E38f && ((c68Var2 = this.f3936a.f15739a) == null || c68Var2.f15746a == -9223372036854775807L)) {
                    f2 = 1.0f;
                    f3 = 1.0f;
                }
                this.f3923a = new com.google.android.exoplayer2.g.C0682g.a().k(jT2).i(jT).g(j3).j(f2).h(f3).f();
            }
            j3 = jH2;
            jH1 = gj9.H1(j - j2);
            if (jH1 < 0) {
                jH1 = 0;
            }
            j4 = this.f3936a.c;
            if (j4 != -9223372036854775807L) {
                jH1 = Math.min(jH1 + j4, jH2);
            }
            jT = jH1;
            j5 = this.f3924a.f3326a.f3364b;
            if (j5 != -9223372036854775807L) {
                jT = gj9.t(j5, jT, jH2);
            } else {
                c68Var = this.f3936a.f15739a;
                if (c68Var != null) {
                    j6 = c68Var.f15747b;
                    if (j6 != -9223372036854775807L) {
                        jT = gj9.t(j6, jT, jH2);
                    }
                }
            }
            if (jT > j3) {
                j3 = jT;
            }
            jT2 = this.f3923a.f3363a;
            if (jT2 == -9223372036854775807L) {
                c62Var = this.f3936a;
                c68Var5 = c62Var.f15739a;
                if (c68Var5 != null) {
                    j7 = c68Var5.f15746a;
                    if (j7 != -9223372036854775807L) {
                        jT2 = j7;
                    } else {
                        jT2 = c62Var.f;
                        if (jT2 == -9223372036854775807L) {
                            jT2 = this.f30875a;
                        }
                    }
                } else {
                    jT2 = c62Var.f;
                    if (jT2 == -9223372036854775807L) {
                        jT2 = this.f30875a;
                    }
                }
            }
            if (jT2 < jT) {
                jT2 = jT;
            }
            if (jT2 > j3) {
                jT2 = gj9.t(gj9.H1(j - Math.min(5000000L, j2 / 2)), jT, j3);
            }
            com.google.android.exoplayer2.g.C0682g c0682g2 = this.f3924a.f3326a;
            f2 = c0682g2.f3362a;
            if (f2 == -3.4028235E38f) {
                c68Var4 = this.f3936a.f15739a;
                if (c68Var4 != null) {
                    f2 = c68Var4.f40911a;
                } else {
                    f2 = -3.4028235E38f;
                }
            }
            f3 = c0682g2.b;
            if (f3 == -3.4028235E38f) {
                c68Var3 = this.f3936a.f15739a;
                if (c68Var3 != null) {
                    f3 = c68Var3.b;
                } else {
                    f3 = -3.4028235E38f;
                }
            }
            if (f2 == -3.4028235E38f) {
                f2 = 1.0f;
                f3 = 1.0f;
            }
            this.f3923a = new com.google.android.exoplayer2.g.C0682g.a().k(jT2).i(jT).g(j3).j(f2).h(f3).f();
        }
        jMin = Math.min(jH2, j8);
        j3 = jMin;
        jH1 = gj9.H1(j - j2);
        if (jH1 < 0) {
            jH1 = 0;
        }
        j4 = this.f3936a.c;
        if (j4 != -9223372036854775807L) {
            jH1 = Math.min(jH1 + j4, jH2);
        }
        jT = jH1;
        j5 = this.f3924a.f3326a.f3364b;
        if (j5 != -9223372036854775807L) {
            jT = gj9.t(j5, jT, jH2);
        } else {
            c68Var = this.f3936a.f15739a;
            if (c68Var != null) {
                j6 = c68Var.f15747b;
                if (j6 != -9223372036854775807L) {
                    jT = gj9.t(j6, jT, jH2);
                }
            }
        }
        if (jT > j3) {
            j3 = jT;
        }
        jT2 = this.f3923a.f3363a;
        if (jT2 == -9223372036854775807L) {
            c62Var = this.f3936a;
            c68Var5 = c62Var.f15739a;
            if (c68Var5 != null) {
                j7 = c68Var5.f15746a;
                if (j7 != -9223372036854775807L) {
                    jT2 = j7;
                } else {
                    jT2 = c62Var.f;
                    if (jT2 == -9223372036854775807L) {
                        jT2 = this.f30875a;
                    }
                }
            } else {
                jT2 = c62Var.f;
                if (jT2 == -9223372036854775807L) {
                    jT2 = this.f30875a;
                }
            }
        }
        if (jT2 < jT) {
            jT2 = jT;
        }
        if (jT2 > j3) {
            jT2 = gj9.t(gj9.H1(j - Math.min(5000000L, j2 / 2)), jT, j3);
        }
        com.google.android.exoplayer2.g.C0682g c0682g3 = this.f3924a.f3326a;
        f2 = c0682g3.f3362a;
        if (f2 == -3.4028235E38f) {
            c68Var4 = this.f3936a.f15739a;
            if (c68Var4 != null) {
                f2 = c68Var4.f40911a;
            } else {
                f2 = -3.4028235E38f;
            }
        }
        f3 = c0682g3.b;
        if (f3 == -3.4028235E38f) {
            c68Var3 = this.f3936a.f15739a;
            if (c68Var3 != null) {
                f3 = c68Var3.b;
            } else {
                f3 = -3.4028235E38f;
            }
        }
        if (f2 == -3.4028235E38f) {
            f2 = 1.0f;
            f3 = 1.0f;
        }
        this.f3923a = new com.google.android.exoplayer2.g.C0682g.a().k(jT2).i(jT).g(j3).j(f2).h(f3).f();
    }

    public final class f implements LoaderErrorThrower {
        public f() {
        }

        public final void a() throws IOException {
            if (DashMediaSource.this.f3938a != null) {
                throw DashMediaSource.this.f3938a;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws IOException {
            DashMediaSource.this.f3932a.maybeThrowError();
            a();
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i) throws IOException {
            DashMediaSource.this.f3932a.maybeThrowError(i);
            a();
        }
    }

    public DashMediaSource(com.google.android.exoplayer2.g gVar, @Nullable c62 c62Var, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends c62> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        this.f3924a = gVar;
        this.f3923a = gVar.f3326a;
        this.f3919a = ((com.google.android.exoplayer2.g.h) sb0.g(gVar.f3327a)).f30751a;
        this.f3942b = gVar.f3327a.f30751a;
        this.f3936a = c62Var;
        this.f3929a = factory;
        this.f3934a = parser;
        this.f3926a = factory2;
        this.f3922a = drmSessionManager;
        this.f3931a = loadErrorHandlingPolicy;
        this.f30875a = j;
        this.f3925a = compositeSequenceableLoaderFactory;
        this.f3937a = new xr0();
        boolean z = c62Var != null;
        this.f3941a = z;
        a aVar = null;
        this.f3943b = createEventDispatcher(null);
        this.f3939a = new Object();
        this.f3921a = new SparseArray<>();
        this.f3928a = new c(this, aVar);
        this.e = -9223372036854775807L;
        this.d = -9223372036854775807L;
        if (!z) {
            this.f3927a = new e(this, aVar);
            this.f3933a = new f();
            this.f3940a = new Runnable() { // from class: com.zj.adlib.d62
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41113a.t0();
                }
            };
            this.f3944b = new Runnable() { // from class: com.zj.adlib.e62
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41355a.b0();
                }
            };
            return;
        }
        sb0.i(true ^ c62Var.f15743a);
        this.f3927a = null;
        this.f3940a = null;
        this.f3944b = null;
        this.f3933a = new LoaderErrorThrower.a();
    }
}
