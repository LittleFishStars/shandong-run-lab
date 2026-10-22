package com.google.android.exoplayer2.audio;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioProcessor.a f30541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2385a;
    public AudioProcessor.a b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ByteBuffer f2386b;
    public AudioProcessor.a c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ByteBuffer f2387c;
    public AudioProcessor.a d;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.f30536a;
        this.f2386b = byteBuffer;
        this.f2387c = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f30537a;
        this.c = aVar;
        this.d = aVar;
        this.f30541a = aVar;
        this.b = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.c = aVar;
        this.d = onConfigure(aVar);
        return isActive() ? this.d : AudioProcessor.a.f30537a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f2387c = AudioProcessor.f30536a;
        this.f2385a = false;
        this.f30541a = this.c;
        this.b = this.d;
        onFlush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f2387c;
        this.f2387c = AudioProcessor.f30536a;
        return byteBuffer;
    }

    public final boolean hasPendingOutput() {
        return this.f2387c.hasRemaining();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.d != AudioProcessor.a.f30537a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public boolean isEnded() {
        return this.f2385a && this.f2387c == AudioProcessor.f30536a;
    }

    public AudioProcessor.a onConfigure(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.a.f30537a;
    }

    public void onFlush() {
    }

    public void onQueueEndOfStream() {
    }

    public void onReset() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f2385a = true;
        onQueueEndOfStream();
    }

    public final ByteBuffer replaceOutputBuffer(int i) {
        if (this.f2386b.capacity() < i) {
            this.f2386b = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f2386b.clear();
        }
        ByteBuffer byteBuffer = this.f2386b;
        this.f2387c = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f2386b = AudioProcessor.f30536a;
        AudioProcessor.a aVar = AudioProcessor.a.f30537a;
        this.c = aVar;
        this.d = aVar;
        this.f30541a = aVar;
        this.b = aVar;
        onReset();
    }
}
