package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.hl8;
import com.zj.adlib.sb0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i implements AudioProcessor {
    public static final int b = -1;
    public static final float c = 1.0E-4f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f2487c = 1024;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AudioProcessor.a f2490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public hl8 f2491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShortBuffer f2492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2493a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2495b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public AudioProcessor.a f2496b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ByteBuffer f2497b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2498b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public AudioProcessor.a f2499c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ByteBuffer f2500c;
    public AudioProcessor.a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30568a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f2494b = 1.0f;

    public i() {
        AudioProcessor.a aVar = AudioProcessor.a.f30537a;
        this.f2490a = aVar;
        this.f2496b = aVar;
        this.f2499c = aVar;
        this.d = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f30536a;
        this.f2497b = byteBuffer;
        this.f2492a = byteBuffer.asShortBuffer();
        this.f2500c = byteBuffer;
        this.f2488a = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i = this.f2488a;
        if (i == -1) {
            i = aVar.f2360a;
        }
        this.f2490a = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i, aVar.b, 2);
        this.f2496b = aVar2;
        this.f2493a = true;
        return aVar2;
    }

    public long b(long j) {
        if (this.f2495b < 1024) {
            return (long) (((double) this.f30568a) * j);
        }
        long jL = this.f2489a - ((long) ((hl8) sb0.g(this.f2491a)).l());
        int i = this.d.f2360a;
        int i2 = this.f2499c.f2360a;
        return i == i2 ? gj9.o1(j, jL, this.f2495b) : gj9.o1(j, jL * ((long) i), this.f2495b * ((long) i2));
    }

    public void c(int i) {
        this.f2488a = i;
    }

    public void d(float f) {
        if (this.f2494b != f) {
            this.f2494b = f;
            this.f2493a = true;
        }
    }

    public void e(float f) {
        if (this.f30568a != f) {
            this.f30568a = f;
            this.f2493a = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f2490a;
            this.f2499c = aVar;
            AudioProcessor.a aVar2 = this.f2496b;
            this.d = aVar2;
            if (this.f2493a) {
                this.f2491a = new hl8(aVar.f2360a, aVar.b, this.f30568a, this.f2494b, aVar2.f2360a);
            } else {
                hl8 hl8Var = this.f2491a;
                if (hl8Var != null) {
                    hl8Var.i();
                }
            }
        }
        this.f2500c = AudioProcessor.f30536a;
        this.f2489a = 0L;
        this.f2495b = 0L;
        this.f2498b = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int iK;
        hl8 hl8Var = this.f2491a;
        if (hl8Var != null && (iK = hl8Var.k()) > 0) {
            if (this.f2497b.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.f2497b = byteBufferOrder;
                this.f2492a = byteBufferOrder.asShortBuffer();
            } else {
                this.f2497b.clear();
                this.f2492a.clear();
            }
            hl8Var.j(this.f2492a);
            this.f2495b += (long) iK;
            this.f2497b.limit(iK);
            this.f2500c = this.f2497b;
        }
        ByteBuffer byteBuffer = this.f2500c;
        this.f2500c = AudioProcessor.f30536a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f2496b.f2360a != -1 && (Math.abs(this.f30568a - 1.0f) >= 1.0E-4f || Math.abs(this.f2494b - 1.0f) >= 1.0E-4f || this.f2496b.f2360a != this.f2490a.f2360a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        hl8 hl8Var;
        return this.f2498b && ((hl8Var = this.f2491a) == null || hl8Var.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        hl8 hl8Var = this.f2491a;
        if (hl8Var != null) {
            hl8Var.s();
        }
        this.f2498b = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            hl8 hl8Var = (hl8) sb0.g(this.f2491a);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f2489a += (long) iRemaining;
            hl8Var.t(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f30568a = 1.0f;
        this.f2494b = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f30537a;
        this.f2490a = aVar;
        this.f2496b = aVar;
        this.f2499c = aVar;
        this.d = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f30536a;
        this.f2497b = byteBuffer;
        this.f2492a = byteBuffer.asShortBuffer();
        this.f2500c = byteBuffer;
        this.f2488a = -1;
        this.f2493a = false;
        this.f2491a = null;
        this.f2489a = 0L;
        this.f2495b = 0L;
        this.f2498b = false;
    }
}
