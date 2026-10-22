package com.zj.adlib;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(23)
public final class ec0 extends MediaCodec.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("lock")
    public long f41399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("lock")
    public MediaCodec.CodecException f16284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("lock")
    public MediaFormat f16285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f16286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerThread f16287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("lock")
    public IllegalStateException f16289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public boolean f16292a;

    @Nullable
    @GuardedBy("lock")
    public MediaFormat b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f16290a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public final qb4 f16288a = new qb4();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @GuardedBy("lock")
    public final qb4 f16293b = new qb4();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public final ArrayDeque<MediaCodec.BufferInfo> f16291a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @GuardedBy("lock")
    public final ArrayDeque<MediaFormat> f16294b = new ArrayDeque<>();

    public ec0(HandlerThread handlerThread) {
        this.f16287a = handlerThread;
    }

    @GuardedBy("lock")
    public final void b(MediaFormat mediaFormat) {
        this.f16293b.a(-2);
        this.f16294b.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f16290a) {
            int iF = -1;
            if (i()) {
                return -1;
            }
            j();
            if (!this.f16288a.e()) {
                iF = this.f16288a.f();
            }
            return iF;
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f16290a) {
            if (i()) {
                return -1;
            }
            j();
            if (this.f16293b.e()) {
                return -1;
            }
            int iF = this.f16293b.f();
            if (iF >= 0) {
                sb0.k(this.f16285a);
                MediaCodec.BufferInfo bufferInfoRemove = this.f16291a.remove();
                bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
            } else if (iF == -2) {
                this.f16285a = this.f16294b.remove();
            }
            return iF;
        }
    }

    public void e() {
        synchronized (this.f16290a) {
            this.f41399a++;
            ((Handler) gj9.k(this.f16286a)).post(new Runnable() { // from class: com.zj.adlib.dc0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41150a.m();
                }
            });
        }
    }

    @GuardedBy("lock")
    public final void f() {
        if (!this.f16294b.isEmpty()) {
            this.b = this.f16294b.getLast();
        }
        this.f16288a.c();
        this.f16293b.c();
        this.f16291a.clear();
        this.f16294b.clear();
        this.f16284a = null;
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f16290a) {
            mediaFormat = this.f16285a;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        sb0.i(this.f16286a == null);
        this.f16287a.start();
        Handler handler = new Handler(this.f16287a.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f16286a = handler;
    }

    @GuardedBy("lock")
    public final boolean i() {
        return this.f41399a > 0 || this.f16292a;
    }

    @GuardedBy("lock")
    public final void j() {
        k();
        l();
    }

    @GuardedBy("lock")
    public final void k() {
        IllegalStateException illegalStateException = this.f16289a;
        if (illegalStateException == null) {
            return;
        }
        this.f16289a = null;
        throw illegalStateException;
    }

    @GuardedBy("lock")
    public final void l() {
        MediaCodec.CodecException codecException = this.f16284a;
        if (codecException == null) {
            return;
        }
        this.f16284a = null;
        throw codecException;
    }

    public final void m() {
        synchronized (this.f16290a) {
            if (this.f16292a) {
                return;
            }
            long j = this.f41399a - 1;
            this.f41399a = j;
            if (j > 0) {
                return;
            }
            if (j < 0) {
                n(new IllegalStateException());
            } else {
                f();
            }
        }
    }

    public final void n(IllegalStateException illegalStateException) {
        synchronized (this.f16290a) {
            this.f16289a = illegalStateException;
        }
    }

    public void o() {
        synchronized (this.f16290a) {
            this.f16292a = true;
            this.f16287a.quit();
            f();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f16290a) {
            this.f16284a = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.f16290a) {
            this.f16288a.a(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f16290a) {
            MediaFormat mediaFormat = this.b;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.b = null;
            }
            this.f16293b.a(i);
            this.f16291a.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f16290a) {
            b(mediaFormat);
            this.b = null;
        }
    }
}
