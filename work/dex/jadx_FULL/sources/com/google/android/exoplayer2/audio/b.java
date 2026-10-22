package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.zj.adlib.sb0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends BaseAudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public int[] f30560a;

    @Nullable
    public int[] b;

    public void b(@Nullable int[] iArr) {
        this.f30560a = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.a onConfigure(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f30560a;
        if (iArr == null) {
            return AudioProcessor.a.f30537a;
        }
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z = aVar.b != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= aVar.b) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z |= i2 != i;
            i++;
        }
        return z ? new AudioProcessor.a(aVar.f2360a, iArr.length, 2) : AudioProcessor.a.f30537a;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        this.b = this.f30560a;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.b = null;
        this.f30560a = null;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) sb0.g(this.b);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(((iLimit - iPosition) / ((BaseAudioProcessor) this).f30541a.d) * ((BaseAudioProcessor) this).b.d);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferReplaceOutputBuffer.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += ((BaseAudioProcessor) this).f30541a.d;
        }
        byteBuffer.position(iLimit);
        byteBufferReplaceOutputBuffer.flip();
    }
}
