package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Log;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z39 extends BaseRenderer implements Handler.Callback {
    public static final int P = 0;
    public static final int Q = 1;
    public static final int R = 2;
    public static final int S = 0;
    public static final String f = "TextRenderer";
    public int N;
    public int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Handler f46181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d f20968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SubtitleDecoder f20969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SubtitleDecoderFactory f20970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SubtitleOutputBuffer f20971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextOutput f20972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public cv8 f20973a;

    @Nullable
    public SubtitleOutputBuffer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final yk3 f20974b;
    public boolean c;
    public long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f20975d;
    public boolean e;

    public z39(TextOutput textOutput, @Nullable Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.f31005a);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int e(d dVar) {
        if (this.f20970a.a(dVar)) {
            return RendererCapabilities.create(dVar.a0 == 0 ? 4 : 2);
        }
        return bp5.s(dVar.k) ? RendererCapabilities.create(1) : RendererCapabilities.create(0);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        o((List) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f20975d;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    public final void k() {
        s(Collections.emptyList());
    }

    public final long l() {
        if (this.O == -1) {
            return Long.MAX_VALUE;
        }
        sb0.g(this.f20971a);
        if (this.O >= this.f20971a.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.f20971a.getEventTime(this.O);
    }

    public final void m(SubtitleDecoderException subtitleDecoderException) {
        Log.e(f, "Subtitle decoding failed. streamFormat=" + this.f20968a, subtitleDecoderException);
        k();
        q();
    }

    public final void n() {
        this.e = true;
        this.f20969a = this.f20970a.b((d) sb0.g(this.f20968a));
    }

    public final void o(List<Cue> list) {
        this.f20972a.onCues(list);
        this.f20972a.j(new xy1(list));
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f20968a = null;
        this.d = -9223372036854775807L;
        k();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        k();
        this.c = false;
        this.f20975d = false;
        this.d = -9223372036854775807L;
        if (this.N != 0) {
            q();
        } else {
            p();
            ((SubtitleDecoder) sb0.g(this.f20969a)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(d[] dVarArr, long j, long j2) {
        this.f20968a = dVarArr[0];
        if (this.f20969a != null) {
            this.N = 1;
        } else {
            n();
        }
    }

    public final void p() {
        this.f20973a = null;
        this.O = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.f20971a;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.j();
            this.f20971a = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.b;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.j();
            this.b = null;
        }
    }

    public final void q() {
        releaseDecoder();
        n();
    }

    public void r(long j) {
        sb0.i(isCurrentStreamFinal());
        this.d = j;
    }

    public final void releaseDecoder() {
        p();
        ((SubtitleDecoder) sb0.g(this.f20969a)).release();
        this.f20969a = null;
        this.N = 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws DecoderException {
        boolean z;
        if (isCurrentStreamFinal()) {
            long j3 = this.d;
            if (j3 != -9223372036854775807L && j >= j3) {
                p();
                this.f20975d = true;
            }
        }
        if (this.f20975d) {
            return;
        }
        if (this.b == null) {
            ((SubtitleDecoder) sb0.g(this.f20969a)).setPositionUs(j);
            try {
                this.b = ((SubtitleDecoder) sb0.g(this.f20969a)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                m(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f20971a != null) {
            long jL = l();
            z = false;
            while (jL <= j) {
                this.O++;
                jL = l();
                z = true;
            }
        } else {
            z = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.b;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.f()) {
                if (!z && l() == Long.MAX_VALUE) {
                    if (this.N == 2) {
                        q();
                    } else {
                        p();
                        this.f20975d = true;
                    }
                }
            } else if (((DecoderOutputBuffer) subtitleOutputBuffer).f30577a <= j) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.f20971a;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.j();
                }
                this.O = subtitleOutputBuffer.getNextEventTimeIndex(j);
                this.f20971a = subtitleOutputBuffer;
                this.b = null;
                z = true;
            }
        }
        if (z) {
            sb0.g(this.f20971a);
            s(this.f20971a.getCues(j));
        }
        if (this.N == 2) {
            return;
        }
        while (!this.c) {
            try {
                cv8 cv8VarDequeueInputBuffer = this.f20973a;
                if (cv8VarDequeueInputBuffer == null) {
                    cv8VarDequeueInputBuffer = ((SubtitleDecoder) sb0.g(this.f20969a)).dequeueInputBuffer();
                    if (cv8VarDequeueInputBuffer == null) {
                        return;
                    } else {
                        this.f20973a = cv8VarDequeueInputBuffer;
                    }
                }
                if (this.N == 1) {
                    cv8VarDequeueInputBuffer.i(4);
                    ((SubtitleDecoder) sb0.g(this.f20969a)).queueInputBuffer(cv8VarDequeueInputBuffer);
                    this.f20973a = null;
                    this.N = 2;
                    return;
                }
                int source = readSource(this.f20974b, cv8VarDequeueInputBuffer, 0);
                if (source == -4) {
                    if (cv8VarDequeueInputBuffer.f()) {
                        this.c = true;
                        this.e = false;
                    } else {
                        d dVar = this.f20974b.f46052a;
                        if (dVar == null) {
                            return;
                        }
                        cv8VarDequeueInputBuffer.b = dVar.f2565a;
                        cv8VarDequeueInputBuffer.l();
                        this.e &= !cv8VarDequeueInputBuffer.h();
                    }
                    if (!this.e) {
                        ((SubtitleDecoder) sb0.g(this.f20969a)).queueInputBuffer(cv8VarDequeueInputBuffer);
                        this.f20973a = null;
                    }
                } else if (source == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                m(e2);
                return;
            }
        }
    }

    public final void s(List<Cue> list) {
        Handler handler = this.f46181a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            o(list);
        }
    }

    public z39(TextOutput textOutput, @Nullable Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.f20972a = (TextOutput) sb0.g(textOutput);
        this.f46181a = looper == null ? null : gj9.x(looper, this);
        this.f20970a = subtitleDecoderFactory;
        this.f20974b = new yk3();
        this.d = -9223372036854775807L;
    }
}
