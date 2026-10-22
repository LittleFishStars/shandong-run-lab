package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.o;
import com.zj.adlib.al7;
import com.zj.adlib.bl7;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.sk7;
import com.zj.adlib.xk7;
import com.zj.adlib.yk7;
import com.zj.adlib.zk7;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RtspClient implements Closeable {
    public static final int L = -1;
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 2;
    public static final long b = 30000;
    public static final String h = "RtspClient";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Uri f4325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlaybackEventListener f4327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SessionInfoListener f4328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public b f4329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.source.rtsp.c f4332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public g.a f4333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SocketFactory f4335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4336a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4337b;
    public boolean c;
    public boolean d;
    public final String f;

    @Nullable
    public String g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<RtspMediaPeriod.c> f4334a = new ArrayDeque<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<RtspRequest> f4326a = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f4330a = new d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RtspMessageChannel f4331a = new RtspMessageChannel(new c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30950a = -9223372036854775807L;
    public int K = -1;

    public interface PlaybackEventListener {
        void a(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void c();

        void h(long j, ImmutableList<bl7> immutableList);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RtspState {
    }

    public interface SessionInfoListener {
        void e(String str, @Nullable Throwable th);

        void f(al7 al7Var, ImmutableList<f> immutableList);
    }

    public final class b implements Runnable, Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30951a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Handler f4338a = gj9.y();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4340a;

        public b(long j) {
            this.f30951a = j;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4340a = false;
            this.f4338a.removeCallbacks(this);
        }

        public void g() {
            if (this.f4340a) {
                return;
            }
            this.f4340a = true;
            this.f4338a.postDelayed(this, this.f30951a);
        }

        @Override // java.lang.Runnable
        public void run() {
            RtspClient.this.f4330a.e(RtspClient.this.f4325a, RtspClient.this.g);
            this.f4338a.postDelayed(this, this.f30951a);
        }
    }

    public final class c implements RtspMessageChannel.MessageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30952a = gj9.y();

        public c() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspMessageChannel.MessageListener
        public void b(final List<String> list) {
            this.f30952a.post(new Runnable() { // from class: com.zj.adlib.rk7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44475a.h(list);
                }
            });
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final void h(List<String> list) {
            RtspClient.this.r0(list);
            if (g.e(list)) {
                g(list);
            } else {
                f(list);
            }
        }

        public final void f(List<String> list) {
            RtspClient.this.f4330a.d(Integer.parseInt((String) sb0.g(g.k(list).f4390a.e(com.google.android.exoplayer2.source.rtsp.d.n))));
        }

        public final void g(List<String> list) {
            ImmutableList<bl7> immutableListOf;
            zk7 zk7VarL = g.l(list);
            int i = Integer.parseInt((String) sb0.g(zk7VarL.f21081a.e(com.google.android.exoplayer2.source.rtsp.d.n)));
            RtspRequest rtspRequest = (RtspRequest) RtspClient.this.f4326a.get(i);
            if (rtspRequest == null) {
                return;
            }
            RtspClient.this.f4326a.remove(i);
            int i2 = rtspRequest.f30967a;
            try {
                int i3 = zk7VarL.f46283a;
                if (i3 == 200) {
                    switch (i2) {
                        case 1:
                        case 3:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                            return;
                        case 2:
                            i(new sk7(i3, j.b(zk7VarL.f21082a)));
                            return;
                        case 4:
                            j(new xk7(i3, g.j(zk7VarL.f21081a.e(com.google.android.exoplayer2.source.rtsp.d.t))));
                            return;
                        case 5:
                            k();
                            return;
                        case 6:
                            String strE = zk7VarL.f21081a.e("Range");
                            al7 al7VarD = strE == null ? al7.f40549a : al7.d(strE);
                            try {
                                String strE2 = zk7VarL.f21081a.e(com.google.android.exoplayer2.source.rtsp.d.v);
                                immutableListOf = strE2 == null ? ImmutableList.of() : bl7.a(strE2, RtspClient.this.f4325a);
                            } catch (ParserException unused) {
                                immutableListOf = ImmutableList.of();
                            }
                            l(new yk7(zk7VarL.f46283a, al7VarD, immutableListOf));
                            return;
                        case 10:
                            String strE3 = zk7VarL.f21081a.e(com.google.android.exoplayer2.source.rtsp.d.y);
                            String strE4 = zk7VarL.f21081a.e(com.google.android.exoplayer2.source.rtsp.d.C);
                            if (strE3 == null || strE4 == null) {
                                throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", null);
                            }
                            m(new h(zk7VarL.f46283a, g.m(strE3), strE4));
                            return;
                        default:
                            throw new IllegalStateException();
                    }
                    RtspClient.this.m0(new RtspMediaSource.RtspPlaybackException(e));
                }
                if (i3 != 401) {
                    if (i3 == 301 || i3 == 302) {
                        if (RtspClient.this.K != -1) {
                            RtspClient.this.K = 0;
                        }
                        String strE5 = zk7VarL.f21081a.e("Location");
                        if (strE5 == null) {
                            RtspClient.this.f4328a.e("Redirection without new location.", null);
                            return;
                        }
                        Uri uri = Uri.parse(strE5);
                        RtspClient.this.f4325a = g.p(uri);
                        RtspClient.this.f4333a = g.n(uri);
                        RtspClient.this.f4330a.c(RtspClient.this.f4325a, RtspClient.this.g);
                        return;
                    }
                } else if (RtspClient.this.f4333a != null && !RtspClient.this.c) {
                    ImmutableList<String> immutableListF = zk7VarL.f21081a.f("WWW-Authenticate");
                    if (immutableListF.isEmpty()) {
                        throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", null);
                    }
                    for (int i4 = 0; i4 < immutableListF.size(); i4++) {
                        RtspClient.this.f4332a = g.o(immutableListF.get(i4));
                        if (RtspClient.this.f4332a.f30970a == 2) {
                            break;
                        }
                    }
                    RtspClient.this.f4330a.b();
                    RtspClient.this.c = true;
                    return;
                }
                RtspClient.this.m0(new RtspMediaSource.RtspPlaybackException(g.t(i2) + " " + zk7VarL.f46283a));
            } catch (ParserException e) {
                RtspClient.this.m0(new RtspMediaSource.RtspPlaybackException(e));
            }
        }

        public final void i(sk7 sk7Var) {
            al7 al7VarD = al7.f40549a;
            String str = sk7Var.f19598a.f4422a.get(i.m);
            if (str != null) {
                try {
                    al7VarD = al7.d(str);
                } catch (ParserException e) {
                    RtspClient.this.f4328a.e("SDP format error.", e);
                    return;
                }
            }
            ImmutableList<f> immutableListJ0 = RtspClient.j0(sk7Var.f19598a, RtspClient.this.f4325a);
            if (immutableListJ0.isEmpty()) {
                RtspClient.this.f4328a.e("No playable track.", null);
            } else {
                RtspClient.this.f4328a.f(al7VarD, immutableListJ0);
                RtspClient.this.f4337b = true;
            }
        }

        public final void j(xk7 xk7Var) {
            if (RtspClient.this.f4329a != null) {
                return;
            }
            if (RtspClient.z0(xk7Var.f20674a)) {
                RtspClient.this.f4330a.c(RtspClient.this.f4325a, RtspClient.this.g);
            } else {
                RtspClient.this.f4328a.e("DESCRIBE not supported.", null);
            }
        }

        public final void k() {
            sb0.i(RtspClient.this.K == 2);
            RtspClient.this.K = 1;
            RtspClient.this.d = false;
            if (RtspClient.this.f30950a != -9223372036854775807L) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.C0(gj9.H1(rtspClient.f30950a));
            }
        }

        public final void l(yk7 yk7Var) {
            sb0.i(RtspClient.this.K == 1);
            RtspClient.this.K = 2;
            if (RtspClient.this.f4329a == null) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.f4329a = rtspClient.new b(30000L);
                RtspClient.this.f4329a.g();
            }
            RtspClient.this.f30950a = -9223372036854775807L;
            RtspClient.this.f4327a.h(gj9.Z0(yk7Var.f20878a.f15288a), yk7Var.f20877a);
        }

        public final void m(h hVar) {
            sb0.i(RtspClient.this.K != -1);
            RtspClient.this.K = 1;
            RtspClient.this.g = hVar.f4418a.f4417a;
            RtspClient.this.k0();
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30953a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RtspRequest f4343a;

        public d() {
        }

        public final RtspRequest a(int i, @Nullable String str, Map<String, String> map, Uri uri) {
            String str2 = RtspClient.this.f;
            int i2 = this.f30953a;
            this.f30953a = i2 + 1;
            com.google.android.exoplayer2.source.rtsp.d.b bVar = new com.google.android.exoplayer2.source.rtsp.d.b(str2, str, i2);
            if (RtspClient.this.f4332a != null) {
                sb0.k(RtspClient.this.f4333a);
                try {
                    bVar.b("Authorization", RtspClient.this.f4332a.a(RtspClient.this.f4333a, uri, i));
                } catch (ParserException e) {
                    RtspClient.this.m0(new RtspMediaSource.RtspPlaybackException(e));
                }
            }
            bVar.d(map);
            return new RtspRequest(uri, i, bVar.e(), "");
        }

        public void b() {
            sb0.k(this.f4343a);
            ImmutableListMultimap<String, String> immutableListMultimapB = this.f4343a.f4390a.b();
            HashMap map = new HashMap();
            for (String str : immutableListMultimapB.keySet()) {
                if (!str.equals(com.google.android.exoplayer2.source.rtsp.d.n) && !str.equals("User-Agent") && !str.equals(com.google.android.exoplayer2.source.rtsp.d.y) && !str.equals("Authorization")) {
                    map.put(str, (String) o.w(immutableListMultimapB.get(str)));
                }
            }
            h(a(this.f4343a.f30967a, RtspClient.this.g, map, this.f4343a.f4389a));
        }

        public void c(Uri uri, @Nullable String str) {
            h(a(2, str, ImmutableMap.of(), uri));
        }

        public void d(int i) {
            i(new zk7(405, new com.google.android.exoplayer2.source.rtsp.d.b(RtspClient.this.f, RtspClient.this.g, i).e()));
            this.f30953a = Math.max(this.f30953a, i + 1);
        }

        public void e(Uri uri, @Nullable String str) {
            h(a(4, str, ImmutableMap.of(), uri));
        }

        public void f(Uri uri, String str) {
            sb0.i(RtspClient.this.K == 2);
            h(a(5, str, ImmutableMap.of(), uri));
            RtspClient.this.d = true;
        }

        public void g(Uri uri, long j, String str) {
            boolean z = true;
            if (RtspClient.this.K != 1 && RtspClient.this.K != 2) {
                z = false;
            }
            sb0.i(z);
            h(a(6, str, ImmutableMap.of("Range", al7.b(j)), uri));
        }

        public final void h(RtspRequest rtspRequest) {
            int i = Integer.parseInt((String) sb0.g(rtspRequest.f4390a.e(com.google.android.exoplayer2.source.rtsp.d.n)));
            sb0.i(RtspClient.this.f4326a.get(i) == null);
            RtspClient.this.f4326a.append(i, rtspRequest);
            ImmutableList<String> immutableListQ = g.q(rtspRequest);
            RtspClient.this.r0(immutableListQ);
            RtspClient.this.f4331a.g(immutableListQ);
            this.f4343a = rtspRequest;
        }

        public final void i(zk7 zk7Var) {
            ImmutableList<String> immutableListR = g.r(zk7Var);
            RtspClient.this.r0(immutableListR);
            RtspClient.this.f4331a.g(immutableListR);
        }

        public void j(Uri uri, String str, @Nullable String str2) {
            RtspClient.this.K = 0;
            h(a(10, str2, ImmutableMap.of(com.google.android.exoplayer2.source.rtsp.d.C, str), uri));
        }

        public void k(Uri uri, String str) {
            if (RtspClient.this.K == -1 || RtspClient.this.K == 0) {
                return;
            }
            RtspClient.this.K = 0;
            h(a(12, str, ImmutableMap.of(), uri));
        }
    }

    public RtspClient(SessionInfoListener sessionInfoListener, PlaybackEventListener playbackEventListener, String str, Uri uri, SocketFactory socketFactory, boolean z) {
        this.f4328a = sessionInfoListener;
        this.f4327a = playbackEventListener;
        this.f = str;
        this.f4335a = socketFactory;
        this.f4336a = z;
        this.f4325a = g.p(uri);
        this.f4333a = g.n(uri);
    }

    public static ImmutableList<f> j0(i iVar, Uri uri) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < iVar.f4421a.size(); i++) {
            MediaDescription mediaDescription = iVar.f4421a.get(i);
            if (com.google.android.exoplayer2.source.rtsp.b.c(mediaDescription)) {
                aVar.a(new f(mediaDescription, uri));
            }
        }
        return aVar.e();
    }

    public static boolean z0(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    public void A0(List<RtspMediaPeriod.c> list) {
        this.f4334a.addAll(list);
        k0();
    }

    public void B0() throws IOException {
        try {
            this.f4331a.e(o0(this.f4325a));
            this.f4330a.e(this.f4325a, this.g);
        } catch (IOException e) {
            gj9.p(this.f4331a);
            throw e;
        }
    }

    public void C0(long j) {
        this.f4330a.g(this.f4325a, j, (String) sb0.g(this.g));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b bVar = this.f4329a;
        if (bVar != null) {
            bVar.close();
            this.f4329a = null;
            this.f4330a.k(this.f4325a, (String) sb0.g(this.g));
        }
        this.f4331a.close();
    }

    public final void k0() {
        RtspMediaPeriod.c cVarPollFirst = this.f4334a.pollFirst();
        if (cVarPollFirst == null) {
            this.f4327a.c();
        } else {
            this.f4330a.j(cVarPollFirst.c(), cVarPollFirst.d(), this.g);
        }
    }

    public final void m0(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException = th instanceof RtspMediaSource.RtspPlaybackException ? (RtspMediaSource.RtspPlaybackException) th : new RtspMediaSource.RtspPlaybackException(th);
        if (this.f4337b) {
            this.f4327a.a(rtspPlaybackException);
        } else {
            this.f4328a.e(com.google.common.base.l.g(th.getMessage()), th);
        }
    }

    public final Socket o0(Uri uri) throws IOException {
        sb0.a(uri.getHost() != null);
        return this.f4335a.createSocket((String) sb0.g(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : 554);
    }

    public int q0() {
        return this.K;
    }

    public final void r0(List<String> list) {
        if (this.f4336a) {
            Log.b(h, com.google.common.base.d.p("\n").k(list));
        }
    }

    public void u0(int i, RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.f4331a.f(i, interleavedBinaryDataListener);
    }

    public void v0() {
        try {
            close();
            RtspMessageChannel rtspMessageChannel = new RtspMessageChannel(new c());
            this.f4331a = rtspMessageChannel;
            rtspMessageChannel.e(o0(this.f4325a));
            this.g = null;
            this.c = false;
            this.f4332a = null;
        } catch (IOException e) {
            this.f4327a.a(new RtspMediaSource.RtspPlaybackException(e));
        }
    }

    public void y0(long j) {
        if (this.K == 2 && !this.d) {
            this.f4330a.f(this.f4325a, (String) sb0.g(this.g));
        }
        this.f30950a = j;
    }
}
