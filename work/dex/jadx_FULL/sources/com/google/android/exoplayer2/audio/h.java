package com.google.android.exoplayer2.audio;

import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h extends BaseAudioProcessor {
    public static final short b = 1024;
    public static final long d = 150000;
    public static final int e = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final long f2476e = 20000;
    public static final int f = 1;
    public static final int g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final short f2478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f2479a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2480b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f2481b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2482b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f2483b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f2484c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2485c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f2486d;

    public h() {
        this(150000L, 20000L, (short) 1024);
    }

    public final int b(long j) {
        return (int) ((j * ((long) ((BaseAudioProcessor) this).f30541a.f2360a)) / 1000000);
    }

    public final int c(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.f2478a);
        int i = this.f30567a;
        return ((iLimit / i) * i) + i;
    }

    public final int d(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f2478a) {
                int i = this.f30567a;
                return i * (iPosition / i);
            }
        }
        return byteBuffer.limit();
    }

    public long e() {
        return this.f2484c;
    }

    public final void f(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        replaceOutputBuffer(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.f2485c = true;
        }
    }

    public final void g(byte[] bArr, int i) {
        replaceOutputBuffer(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.f2485c = true;
        }
    }

    public final void h(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iD = d(byteBuffer);
        int iPosition = iD - byteBuffer.position();
        byte[] bArr = this.f2479a;
        int length = bArr.length;
        int i = this.c;
        int i2 = length - i;
        if (iD < iLimit && iPosition < i2) {
            g(bArr, i);
            this.c = 0;
            this.f2480b = 0;
            return;
        }
        int iMin = Math.min(iPosition, i2);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f2479a, this.c, iMin);
        int i3 = this.c + iMin;
        this.c = i3;
        byte[] bArr2 = this.f2479a;
        if (i3 == bArr2.length) {
            if (this.f2485c) {
                g(bArr2, this.f2486d);
                this.f2484c += (long) ((this.c - (this.f2486d * 2)) / this.f30567a);
            } else {
                this.f2484c += (long) ((i3 - this.f2486d) / this.f30567a);
            }
            l(byteBuffer, this.f2479a, this.c);
            this.c = 0;
            this.f2480b = 2;
        }
        byteBuffer.limit(iLimit);
    }

    public final void i(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f2479a.length));
        int iC = c(byteBuffer);
        if (iC == byteBuffer.position()) {
            this.f2480b = 1;
        } else {
            byteBuffer.limit(iC);
            f(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f2482b;
    }

    public final void j(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iD = d(byteBuffer);
        byteBuffer.limit(iD);
        this.f2484c += (long) (byteBuffer.remaining() / this.f30567a);
        l(byteBuffer, this.f2483b, this.f2486d);
        if (iD < iLimit) {
            g(this.f2483b, this.f2486d);
            this.f2480b = 0;
            byteBuffer.limit(iLimit);
        }
    }

    public void k(boolean z) {
        this.f2482b = z;
    }

    public final void l(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.f2486d);
        int i2 = this.f2486d - iMin;
        System.arraycopy(bArr, i - i2, this.f2483b, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f2483b, i2, iMin);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.a onConfigure(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c == 2) {
            return this.f2482b ? aVar : AudioProcessor.a.f30537a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.f2482b) {
            this.f30567a = ((BaseAudioProcessor) this).f30541a.d;
            int iB = b(this.f2477a) * this.f30567a;
            if (this.f2479a.length != iB) {
                this.f2479a = new byte[iB];
            }
            int iB2 = b(this.f2481b) * this.f30567a;
            this.f2486d = iB2;
            if (this.f2483b.length != iB2) {
                this.f2483b = new byte[iB2];
            }
        }
        this.f2480b = 0;
        this.f2484c = 0L;
        this.c = 0;
        this.f2485c = false;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        int i = this.c;
        if (i > 0) {
            g(this.f2479a, i);
        }
        if (this.f2485c) {
            return;
        }
        this.f2484c += (long) (this.f2486d / this.f30567a);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.f2482b = false;
        this.f2486d = 0;
        byte[] bArr = gj9.f16790a;
        this.f2479a = bArr;
        this.f2483b = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !hasPendingOutput()) {
            int i = this.f2480b;
            if (i == 0) {
                i(byteBuffer);
            } else if (i == 1) {
                h(byteBuffer);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                j(byteBuffer);
            }
        }
    }

    public h(long j, long j2, short s) {
        sb0.a(j2 <= j);
        this.f2477a = j;
        this.f2481b = j2;
        this.f2478a = s;
        byte[] bArr = gj9.f16790a;
        this.f2479a = bArr;
        this.f2483b = bArr;
    }
}
