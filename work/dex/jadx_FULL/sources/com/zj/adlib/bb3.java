package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bb3 implements SubtitleDecoder {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ty1 f15478a = new ty1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cv8 f15477a = new cv8();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Deque<SubtitleOutputBuffer> f15479a = new ArrayDeque();

    public class a extends SubtitleOutputBuffer {
        public a() {
        }

        @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
        public void j() {
            bb3.this.e(this);
        }
    }

    public static final class b implements Subtitle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f40713a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ImmutableList<Cue> f15481a;

        public b(long j, ImmutableList<Cue> immutableList) {
            this.f40713a = j;
            this.f15481a = immutableList;
        }

        @Override // com.google.android.exoplayer2.text.Subtitle
        public List<Cue> getCues(long j) {
            return j >= this.f40713a ? this.f15481a : ImmutableList.of();
        }

        @Override // com.google.android.exoplayer2.text.Subtitle
        public long getEventTime(int i) {
            sb0.a(i == 0);
            return this.f40713a;
        }

        @Override // com.google.android.exoplayer2.text.Subtitle
        public int getEventTimeCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.text.Subtitle
        public int getNextEventTimeIndex(long j) {
            return this.f40713a > j ? 0 : -1;
        }
    }

    public bb3() {
        for (int i = 0; i < 2; i++) {
            this.f15479a.addFirst(new a());
        }
        this.f40711a = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public cv8 dequeueInputBuffer() throws SubtitleDecoderException {
        sb0.i(!this.f15480a);
        if (this.f40711a != 0) {
            return null;
        }
        this.f40711a = 1;
        return this.f15477a;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        sb0.i(!this.f15480a);
        if (this.f40711a != 2 || this.f15479a.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer subtitleOutputBufferRemoveFirst = this.f15479a.removeFirst();
        if (this.f15477a.f()) {
            subtitleOutputBufferRemoveFirst.a(4);
        } else {
            cv8 cv8Var = this.f15477a;
            subtitleOutputBufferRemoveFirst.k(((DecoderInputBuffer) this.f15477a).f30576a, new b(((DecoderInputBuffer) cv8Var).f30576a, this.f15478a.a(((ByteBuffer) sb0.g(((DecoderInputBuffer) cv8Var).f2588a)).array())), 0L);
        }
        this.f15477a.b();
        this.f40711a = 0;
        return subtitleOutputBufferRemoveFirst;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(cv8 cv8Var) throws SubtitleDecoderException {
        sb0.i(!this.f15480a);
        sb0.i(this.f40711a == 1);
        sb0.a(this.f15477a == cv8Var);
        this.f40711a = 2;
    }

    public final void e(SubtitleOutputBuffer subtitleOutputBuffer) {
        sb0.i(this.f15479a.size() < 2);
        sb0.a(!this.f15479a.contains(subtitleOutputBuffer));
        subtitleOutputBuffer.b();
        this.f15479a.addFirst(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        sb0.i(!this.f15480a);
        this.f15477a.b();
        this.f40711a = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "ExoplayerCuesDecoder";
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        this.f15480a = true;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
    }
}
