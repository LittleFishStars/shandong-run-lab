package com.google.android.exoplayer2.text.cea;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.zj.adlib.cv8;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class CeaDecoder implements SubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31007a = 10;
    public static final int b = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public b f4537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<b> f4538a = new ArrayDeque<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PriorityQueue<b> f4539a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f4540b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayDeque<SubtitleOutputBuffer> f4541b;

    public static final class b extends cv8 implements Comparable<b> {
        public long c;

        public b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (f() != bVar.f()) {
                return f() ? 1 : -1;
            }
            long j = ((DecoderInputBuffer) this).f30576a - ((DecoderInputBuffer) bVar).f30576a;
            if (j == 0) {
                j = this.c - bVar.c;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    public static final class c extends SubtitleOutputBuffer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DecoderOutputBuffer.Owner<c> f31008a;

        public c(DecoderOutputBuffer.Owner<c> owner) {
            this.f31008a = owner;
        }

        @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
        public final void j() {
            this.f31008a.a(this);
        }
    }

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.f4538a.add(new b());
        }
        this.f4541b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f4541b.add(new c(new DecoderOutputBuffer.Owner() { // from class: com.google.android.exoplayer2.text.cea.c
                @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer.Owner
                public final void a(DecoderOutputBuffer decoderOutputBuffer) {
                    this.f31016a.releaseOutputBuffer((CeaDecoder.c) decoderOutputBuffer);
                }
            }));
        }
        this.f4539a = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public cv8 dequeueInputBuffer() throws SubtitleDecoderException {
        sb0.i(this.f4537a == null);
        if (this.f4538a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f4538a.pollFirst();
        this.f4537a = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.f4541b.isEmpty()) {
            return null;
        }
        while (!this.f4539a.isEmpty() && ((DecoderInputBuffer) ((b) gj9.k(this.f4539a.peek()))).f30576a <= this.f4536a) {
            b bVar = (b) gj9.k(this.f4539a.poll());
            if (bVar.f()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) gj9.k(this.f4541b.pollFirst());
                subtitleOutputBuffer.a(4);
                d(bVar);
                return subtitleOutputBuffer;
            }
            decode(bVar);
            if (isNewSubtitleDataAvailable()) {
                Subtitle subtitleCreateSubtitle = createSubtitle();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) gj9.k(this.f4541b.pollFirst());
                subtitleOutputBuffer2.k(((DecoderInputBuffer) bVar).f30576a, subtitleCreateSubtitle, Long.MAX_VALUE);
                d(bVar);
                return subtitleOutputBuffer2;
            }
            d(bVar);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(cv8 cv8Var) throws SubtitleDecoderException {
        sb0.a(cv8Var == this.f4537a);
        b bVar = (b) cv8Var;
        if (bVar.e()) {
            d(bVar);
        } else {
            long j = this.f4540b;
            this.f4540b = 1 + j;
            bVar.c = j;
            this.f4539a.add(bVar);
        }
        this.f4537a = null;
    }

    public abstract Subtitle createSubtitle();

    public final void d(b bVar) {
        bVar.b();
        this.f4538a.add(bVar);
    }

    public abstract void decode(cv8 cv8Var);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.f4540b = 0L;
        this.f4536a = 0L;
        while (!this.f4539a.isEmpty()) {
            d((b) gj9.k(this.f4539a.poll()));
        }
        b bVar = this.f4537a;
        if (bVar != null) {
            d(bVar);
            this.f4537a = null;
        }
    }

    @Nullable
    public final SubtitleOutputBuffer getAvailableOutputBuffer() {
        return this.f4541b.pollFirst();
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract String getName();

    public final long getPositionUs() {
        return this.f4536a;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.b();
        this.f4541b.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.f4536a = j;
    }
}
