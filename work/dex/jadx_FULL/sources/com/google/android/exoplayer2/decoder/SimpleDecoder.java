package com.google.android.exoplayer2.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.zj.adlib.sb0;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public E f2593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public I f2594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Thread f2596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final I[] f2599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final O[] f2600a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2602b;
    public int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f2595a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<I> f2597a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayDeque<O> f2601b = new ArrayDeque<>();

    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SimpleDecoder.this.k();
        }
    }

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.f2599a = iArr;
        this.f30579a = iArr.length;
        for (int i = 0; i < this.f30579a; i++) {
            ((I[]) this.f2599a)[i] = createInputBuffer();
        }
        this.f2600a = oArr;
        this.b = oArr.length;
        for (int i2 = 0; i2 < this.b; i2++) {
            ((O[]) this.f2600a)[i2] = createOutputBuffer();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f2596a = aVar;
        aVar.start();
    }

    public final boolean b() {
        return !this.f2597a.isEmpty() && this.b > 0;
    }

    public final boolean c() throws InterruptedException {
        E e;
        synchronized (this.f2595a) {
            while (!this.f2602b && !b()) {
                this.f2595a.wait();
            }
            if (this.f2602b) {
                return false;
            }
            I iRemoveFirst = this.f2597a.removeFirst();
            O[] oArr = this.f2600a;
            int i = this.b - 1;
            this.b = i;
            O o = oArr[i];
            boolean z = this.f2598a;
            this.f2598a = false;
            if (iRemoveFirst.f()) {
                o.a(4);
            } else {
                if (iRemoveFirst.e()) {
                    o.a(Integer.MIN_VALUE);
                }
                if (iRemoveFirst.g()) {
                    o.a(134217728);
                }
                try {
                    e = (E) decode(iRemoveFirst, o, z);
                } catch (OutOfMemoryError e2) {
                    e = (E) createUnexpectedDecodeException(e2);
                } catch (RuntimeException e3) {
                    e = (E) createUnexpectedDecodeException(e3);
                }
                if (e != null) {
                    synchronized (this.f2595a) {
                        this.f2593a = e;
                    }
                    return false;
                }
            }
            synchronized (this.f2595a) {
                if (this.f2598a) {
                    o.j();
                } else if (o.e()) {
                    this.c++;
                    o.j();
                } else {
                    o.L = this.c;
                    this.c = 0;
                    this.f2601b.addLast(o);
                }
                i(iRemoveFirst);
            }
            return true;
        }
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E createUnexpectedDecodeException(Throwable th);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final I dequeueInputBuffer() throws DecoderException {
        I i;
        synchronized (this.f2595a) {
            g();
            sb0.i(this.f2594a == null);
            int i2 = this.f30579a;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.f2599a;
                int i3 = i2 - 1;
                this.f30579a = i3;
                i = iArr[i3];
            }
            this.f2594a = i;
        }
        return i;
    }

    @Nullable
    public abstract E decode(I i, O o, boolean z);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final O dequeueOutputBuffer() throws DecoderException {
        synchronized (this.f2595a) {
            g();
            if (this.f2601b.isEmpty()) {
                return null;
            }
            return this.f2601b.removeFirst();
        }
    }

    public final void f() {
        if (b()) {
            this.f2595a.notify();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.f2595a) {
            this.f2598a = true;
            this.c = 0;
            I i = this.f2594a;
            if (i != null) {
                i(i);
                this.f2594a = null;
            }
            while (!this.f2597a.isEmpty()) {
                i(this.f2597a.removeFirst());
            }
            while (!this.f2601b.isEmpty()) {
                this.f2601b.removeFirst().j();
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    public final void g() throws E, DecoderException {
        E e = this.f2593a;
        if (e != null) {
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(I i) throws DecoderException {
        synchronized (this.f2595a) {
            g();
            sb0.a(i == this.f2594a);
            this.f2597a.addLast(i);
            f();
            this.f2594a = null;
        }
    }

    public final void i(I i) {
        i.b();
        I[] iArr = this.f2599a;
        int i2 = this.f30579a;
        this.f30579a = i2 + 1;
        iArr[i2] = i;
    }

    public final void j(O o) {
        o.b();
        O[] oArr = this.f2600a;
        int i = this.b;
        this.b = i + 1;
        oArr[i] = o;
    }

    public final void k() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (c());
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @CallSuper
    public void release() {
        synchronized (this.f2595a) {
            this.f2602b = true;
            this.f2595a.notify();
        }
        try {
            this.f2596a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @CallSuper
    public void releaseOutputBuffer(O o) {
        synchronized (this.f2595a) {
            j(o);
            f();
        }
    }

    public final void setInitialInputBufferSize(int i) {
        sb0.i(this.f30579a == this.f2599a.length);
        for (I i2 : this.f2599a) {
            i2.k(i);
        }
    }
}
