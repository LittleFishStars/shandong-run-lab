package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.zj.adlib.c62;
import com.zj.adlib.gj9;
import com.zj.adlib.m53;
import com.zj.adlib.om6;
import com.zj.adlib.xn5;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class PlayerEmsgHandler implements Handler.Callback {
    public static final int K = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlayerEmsgCallback f3956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f3957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c62 f3958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3961a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TreeMap<Long, Long> f3960a = new TreeMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3955a = gj9.z(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m53 f3959a = new m53();

    public interface PlayerEmsgCallback {
        void a();

        void b(long j);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30886a;
        public final long b;

        public a(long j, long j2) {
            this.f30886a = j;
            this.b = j2;
        }
    }

    public final class b implements TrackOutput {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SampleQueue f3962a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final yk3 f3965a = new yk3();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final xn5 f3964a = new xn5();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30887a = -9223372036854775807L;

        public b(Allocator allocator) {
            this.f3962a = SampleQueue.m(allocator);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void a(om6 om6Var, int i, int i2) {
            this.f3962a.c(om6Var, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int d(DataReader dataReader, int i, boolean z, int i2) throws IOException {
            return this.f3962a.b(dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void e(long j, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
            this.f3962a.e(j, i, i2, i3, aVar);
            l();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void f(d dVar) {
            this.f3962a.f(dVar);
        }

        @Nullable
        public final xn5 g() {
            this.f3964a.b();
            if (this.f3962a.S(this.f3965a, this.f3964a, 0, false) != -4) {
                return null;
            }
            this.f3964a.l();
            return this.f3964a;
        }

        public boolean h(long j) {
            return PlayerEmsgHandler.this.j(j);
        }

        public void i(Chunk chunk) {
            long j = this.f30887a;
            if (j == -9223372036854775807L || chunk.c > j) {
                this.f30887a = chunk.c;
            }
            PlayerEmsgHandler.this.m(chunk);
        }

        public boolean j(Chunk chunk) {
            long j = this.f30887a;
            return PlayerEmsgHandler.this.n(j != -9223372036854775807L && j < chunk.f3841b);
        }

        public final void k(long j, long j2) {
            PlayerEmsgHandler.this.f3955a.sendMessage(PlayerEmsgHandler.this.f3955a.obtainMessage(1, new a(j, j2)));
        }

        public final void l() {
            while (this.f3962a.K(false)) {
                xn5 xn5VarG = g();
                if (xn5VarG != null) {
                    long j = ((DecoderInputBuffer) xn5VarG).f30576a;
                    Metadata metadataA = PlayerEmsgHandler.this.f3959a.a(xn5VarG);
                    if (metadataA != null) {
                        EventMessage eventMessage = (EventMessage) metadataA.get(0);
                        if (PlayerEmsgHandler.h(eventMessage.schemeIdUri, eventMessage.value)) {
                            m(j, eventMessage);
                        }
                    }
                }
            }
            this.f3962a.t();
        }

        public final void m(long j, EventMessage eventMessage) {
            long jF = PlayerEmsgHandler.f(eventMessage);
            if (jF == -9223372036854775807L) {
                return;
            }
            k(j, jF);
        }

        public void n() {
            this.f3962a.T();
        }
    }

    public PlayerEmsgHandler(c62 c62Var, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.f3958a = c62Var;
        this.f3956a = playerEmsgCallback;
        this.f3957a = allocator;
    }

    public static long f(EventMessage eventMessage) {
        try {
            return gj9.h1(gj9.I(eventMessage.messageData));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @Nullable
    public final Map.Entry<Long, Long> e(long j) {
        return this.f3960a.ceilingEntry(Long.valueOf(j));
    }

    public final void g(long j, long j2) {
        Long l = this.f3960a.get(Long.valueOf(j2));
        if (l == null) {
            this.f3960a.put(Long.valueOf(j2), Long.valueOf(j));
        } else if (l.longValue() > j) {
            this.f3960a.put(Long.valueOf(j2), Long.valueOf(j));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.c) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f30886a, aVar.b);
        return true;
    }

    public final void i() {
        if (this.f3961a) {
            this.b = true;
            this.f3961a = false;
            this.f3956a.a();
        }
    }

    public boolean j(long j) {
        c62 c62Var = this.f3958a;
        boolean z = false;
        if (!c62Var.f15743a) {
            return false;
        }
        if (this.b) {
            return true;
        }
        Map.Entry<Long, Long> entryE = e(c62Var.g);
        if (entryE != null && entryE.getValue().longValue() < j) {
            this.f30885a = entryE.getKey().longValue();
            l();
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    public b k() {
        return new b(this.f3957a);
    }

    public final void l() {
        this.f3956a.b(this.f30885a);
    }

    public void m(Chunk chunk) {
        this.f3961a = true;
    }

    public boolean n(boolean z) {
        if (!this.f3958a.f15743a) {
            return false;
        }
        if (this.b) {
            return true;
        }
        if (!z) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.c = true;
        this.f3955a.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator<Map.Entry<Long, Long>> it = this.f3960a.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f3958a.g) {
                it.remove();
            }
        }
    }

    public void q(c62 c62Var) {
        this.b = false;
        this.f30885a = -9223372036854775807L;
        this.f3958a = c62Var;
        p();
    }
}
