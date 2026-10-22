package com.google.android.exoplayer2.audio;

import com.zj.adlib.gj9;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j extends BaseAudioProcessor {
    public static final int e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f2502a = gj9.f16790a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2503b;
    public int c;
    public int d;

    public long b() {
        return this.f2501a;
    }

    public void c() {
        this.f2501a = 0L;
    }

    public void d(int i, int i2) {
        this.f30569a = i;
        this.b = i2;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        if (super.isEnded() && (i = this.d) > 0) {
            replaceOutputBuffer(i).put(this.f2502a, 0, this.d).flip();
            this.d = 0;
        }
        return super.getOutput();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.d == 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.a onConfigure(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f2503b = true;
        return (this.f30569a == 0 && this.b == 0) ? AudioProcessor.a.f30537a : aVar;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.f2503b) {
            this.f2503b = false;
            int i = this.b;
            int i2 = ((BaseAudioProcessor) this).f30541a.d;
            this.f2502a = new byte[i * i2];
            this.c = this.f30569a * i2;
        }
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        if (this.f2503b) {
            int i = this.d;
            if (i > 0) {
                this.f2501a += (long) (i / ((BaseAudioProcessor) this).f30541a.d);
            }
            this.d = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.f2502a = gj9.f16790a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.c);
        this.f2501a += (long) (iMin / ((BaseAudioProcessor) this).f30541a.d);
        this.c -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.c > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.d + i2) - this.f2502a.length;
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(length);
        int iS = gj9.s(length, 0, this.d);
        byteBufferReplaceOutputBuffer.put(this.f2502a, 0, iS);
        int iS2 = gj9.s(length - iS, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iS2);
        byteBufferReplaceOutputBuffer.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iS2;
        int i4 = this.d - iS;
        this.d = i4;
        byte[] bArr = this.f2502a;
        System.arraycopy(bArr, iS, bArr, 0, i4);
        byteBuffer.get(this.f2502a, this.d, i3);
        this.d += i3;
        byteBufferReplaceOutputBuffer.flip();
    }
}
