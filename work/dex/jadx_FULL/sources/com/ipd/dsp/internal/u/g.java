package com.ipd.dsp.internal.u;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.f.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.e.a f38548a;
    public final Handler b;
    public final List<b> c;
    public final com.ipd.dsp.internal.b.h d;
    public final com.ipd.dsp.internal.j.e e;
    public boolean f;
    public boolean g;
    public boolean h;
    public com.ipd.dsp.internal.b.g<Bitmap> i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public m<Bitmap> n;
    public a o;

    @Nullable
    public d p;
    public int q;
    public int r;
    public int s;

    @VisibleForTesting
    public static class a extends com.ipd.dsp.internal.a0.e<Bitmap> {
        public final Handler i;
        public final int j;
        public final long k;
        public Bitmap l;

        public a(Handler handler, int i, long j) {
            this.i = handler;
            this.j = i;
            this.k = j;
        }

        public Bitmap a() {
            return this.l;
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onLoadCleared(@Nullable Drawable drawable) {
            this.l = null;
        }

        @Override // com.ipd.dsp.internal.a0.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable com.ipd.dsp.internal.b0.f<? super Bitmap> fVar) {
            this.l = bitmap;
            this.i.sendMessageAtTime(this.i.obtainMessage(1, this), this.k);
        }
    }

    public interface b {
        void a();
    }

    public class c implements Handler.Callback {
        public static final int b = 1;
        public static final int c = 2;

        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            g.this.d.a((p<?>) message.obj);
            return false;
        }
    }

    @VisibleForTesting
    public interface d {
        void a();
    }

    public g(com.ipd.dsp.internal.components.glide.a aVar, com.ipd.dsp.internal.e.a aVar2, int i, int i2, m<Bitmap> mVar, Bitmap bitmap) {
        this(aVar.e(), com.ipd.dsp.internal.components.glide.a.e(aVar.g()), aVar2, null, a(com.ipd.dsp.internal.components.glide.a.e(aVar.g()), i, i2), mVar, bitmap);
    }

    public static com.ipd.dsp.internal.f.f g() {
        return new com.ipd.dsp.internal.c0.e(Double.valueOf(Math.random()));
    }

    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.n = (m) com.ipd.dsp.internal.d0.m.a(mVar);
        this.m = (Bitmap) com.ipd.dsp.internal.d0.m.a(bitmap);
        this.i = this.i.c((com.ipd.dsp.internal.z.a<?>) new com.ipd.dsp.internal.z.i().b(mVar));
        this.q = o.a(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    public void b(b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    public Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.a() : this.m;
    }

    public int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.j;
        }
        return -1;
    }

    public Bitmap e() {
        return this.m;
    }

    public int f() {
        return this.f38548a.e();
    }

    public m<Bitmap> h() {
        return this.n;
    }

    public int i() {
        return this.s;
    }

    public int j() {
        return this.f38548a.k();
    }

    public int k() {
        return this.f38548a.i() + this.q;
    }

    public int l() {
        return this.r;
    }

    public final void m() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            com.ipd.dsp.internal.d0.m.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f38548a.n();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f38548a.f());
        this.f38548a.c();
        this.l = new a(this.b, this.f38548a.a(), jUptimeMillis);
        this.i.c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.b(g())).a(this.f38548a).b(this.l);
    }

    public final void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.a(bitmap);
            this.m = null;
        }
    }

    public void o() {
        com.ipd.dsp.internal.d0.m.a(!this.f, "Can't restart a running animation");
        this.h = true;
        a aVar = this.o;
        if (aVar != null) {
            this.d.a((p<?>) aVar);
            this.o = null;
        }
    }

    public final void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        m();
    }

    public final void q() {
        this.f = false;
    }

    public ByteBuffer b() {
        return this.f38548a.m().asReadOnlyBuffer();
    }

    public g(com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.b.h hVar, com.ipd.dsp.internal.e.a aVar, Handler handler, com.ipd.dsp.internal.b.g<Bitmap> gVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = hVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = eVar;
        this.b = handler;
        this.i = gVar;
        this.f38548a = aVar;
        a(mVar, bitmap);
    }

    public void a(b bVar) {
        if (!this.k) {
            if (!this.c.contains(bVar)) {
                boolean zIsEmpty = this.c.isEmpty();
                this.c.add(bVar);
                if (zIsEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    public void a() {
        this.c.clear();
        n();
        q();
        a aVar = this.j;
        if (aVar != null) {
            this.d.a((p<?>) aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.a((p<?>) aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.a((p<?>) aVar3);
            this.o = null;
        }
        this.f38548a.clear();
        this.k = true;
    }

    @VisibleForTesting
    public void a(@Nullable d dVar) {
        this.p = dVar;
    }

    @VisibleForTesting
    public void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.o = aVar;
                return;
            }
        }
        if (aVar.a() != null) {
            n();
            a aVar2 = this.j;
            this.j = aVar;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                this.c.get(size).a();
            }
            if (aVar2 != null) {
                this.b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m();
    }

    public static com.ipd.dsp.internal.b.g<Bitmap> a(com.ipd.dsp.internal.b.h hVar, int i, int i2) {
        return hVar.a().c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.b(com.ipd.dsp.internal.i.j.b).c(true).b(true).b(i, i2));
    }
}
