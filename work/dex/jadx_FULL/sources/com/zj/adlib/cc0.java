package com.zj.adlib;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(23)
public class cc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40943a = 0;
    public static final int b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaCodec f15788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f15789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerThread f15790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ps1 f15791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReference<RuntimeException> f15792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<b> f15787a = new ArrayDeque<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f15786a = new Object();

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            cc0.this.f(message);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40945a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f15794a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaCodec.CryptoInfo f15795a = new MediaCodec.CryptoInfo();
        public int b;
        public int c;
        public int d;

        public void a(int i, int i2, int i3, long j, int i4) {
            this.f40945a = i;
            this.b = i2;
            this.c = i3;
            this.f15794a = j;
            this.d = i4;
        }
    }

    public cc0(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ps1());
    }

    public static void c(jy1 jy1Var, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = jy1Var.b;
        cryptoInfo.numBytesOfClearData = e(jy1Var.f17526a, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(jy1Var.f17528b, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) sb0.g(d(jy1Var.f17527b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) sb0.g(d(jy1Var.f17525a, cryptoInfo.iv));
        cryptoInfo.mode = jy1Var.f42700a;
        if (gj9.f41922a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(jy1Var.c, jy1Var.d));
        }
    }

    @Nullable
    public static byte[] d(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    public static int[] e(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b k() {
        ArrayDeque<b> arrayDeque = f15787a;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    public static void o(b bVar) {
        ArrayDeque<b> arrayDeque = f15787a;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public final void b() throws InterruptedException {
        this.f15791a.d();
        ((Handler) sb0.g(this.f15789a)).obtainMessage(2).sendToTarget();
        this.f15791a.a();
    }

    public final void f(Message message) {
        b bVar;
        int i = message.what;
        if (i == 0) {
            bVar = (b) message.obj;
            g(bVar.f40945a, bVar.b, bVar.c, bVar.f15794a, bVar.d);
        } else if (i != 1) {
            bVar = null;
            if (i != 2) {
                ay6.a(this.f15792a, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f15791a.f();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.f40945a, bVar.b, bVar.f15795a, bVar.f15794a, bVar.d);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    public final void g(int i, int i2, int i3, long j, int i4) {
        try {
            this.f15788a.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            ay6.a(this.f15792a, null, e);
        }
    }

    public final void h(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            synchronized (f15786a) {
                this.f15788a.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e) {
            ay6.a(this.f15792a, null, e);
        }
    }

    public void i() {
        if (this.f15793a) {
            try {
                j();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void j() throws InterruptedException {
        ((Handler) sb0.g(this.f15789a)).removeCallbacksAndMessages(null);
        b();
    }

    public final void l() {
        RuntimeException andSet = this.f15792a.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void m(int i, int i2, int i3, long j, int i4) {
        l();
        b bVarK = k();
        bVarK.a(i, i2, i3, j, i4);
        ((Handler) gj9.k(this.f15789a)).obtainMessage(0, bVarK).sendToTarget();
    }

    public void n(int i, int i2, jy1 jy1Var, long j, int i3) {
        l();
        b bVarK = k();
        bVarK.a(i, i2, 0, j, i3);
        c(jy1Var, bVarK.f15795a);
        ((Handler) gj9.k(this.f15789a)).obtainMessage(1, bVarK).sendToTarget();
    }

    @VisibleForTesting(otherwise = 5)
    public void p(RuntimeException runtimeException) {
        this.f15792a.set(runtimeException);
    }

    public void q() {
        if (this.f15793a) {
            i();
            this.f15790a.quit();
        }
        this.f15793a = false;
    }

    public void r() {
        if (this.f15793a) {
            return;
        }
        this.f15790a.start();
        this.f15789a = new a(this.f15790a.getLooper());
        this.f15793a = true;
    }

    public void s() throws InterruptedException {
        b();
    }

    @VisibleForTesting
    public cc0(MediaCodec mediaCodec, HandlerThread handlerThread, ps1 ps1Var) {
        this.f15788a = mediaCodec;
        this.f15790a = handlerThread;
        this.f15791a = ps1Var;
        this.f15792a = new AtomicReference<>();
    }
}
