package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.zj.adlib.cv8;
import com.zj.adlib.sb0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SimpleSubtitleDecoder extends SimpleDecoder<cv8, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f31003a;

    public class a extends SubtitleOutputBuffer {
        public a() {
        }

        @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
        public void j() {
            SimpleSubtitleDecoder.this.releaseOutputBuffer(this);
        }
    }

    public SimpleSubtitleDecoder(String str) {
        super(new cv8[2], new SubtitleOutputBuffer[2]);
        this.f31003a = str;
        setInitialInputBufferSize(1024);
    }

    public abstract Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final String getName() {
        return this.f31003a;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final cv8 createInputBuffer() {
        return new cv8();
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final SubtitleOutputBuffer createOutputBuffer() {
        return new a();
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final SubtitleDecoderException createUnexpectedDecodeException(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    @Nullable
    public final SubtitleDecoderException decode(cv8 cv8Var, SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) sb0.g(((DecoderInputBuffer) cv8Var).f2588a);
            subtitleOutputBuffer.k(((DecoderInputBuffer) cv8Var).f30576a, decode(byteBuffer.array(), byteBuffer.limit(), z), cv8Var.b);
            subtitleOutputBuffer.c(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }
}
