package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.zj.adlib.gj9;
import com.zj.adlib.hp9;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface VideoRendererEventListener {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f31182a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final VideoRendererEventListener f5352a;

        public a(@Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener) {
            this.f31182a = videoRendererEventListener != null ? (Handler) sb0.g(handler) : null;
            this.f5352a = videoRendererEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j, long j2) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onVideoDecoderInitialized(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onVideoDecoderReleased(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(p82 p82Var) {
            p82Var.c();
            ((VideoRendererEventListener) gj9.k(this.f5352a)).h(p82Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i, long j) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onDroppedFrames(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(p82 p82Var) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).c(p82Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(d dVar, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).g(dVar);
            ((VideoRendererEventListener) gj9.k(this.f5352a)).a(dVar, decoderReuseEvaluation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onRenderedFirstFrame(obj, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j, int i) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onVideoFrameProcessingOffset(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onVideoCodecError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(hp9 hp9Var) {
            ((VideoRendererEventListener) gj9.k(this.f5352a)).onVideoSizeChanged(hp9Var);
        }

        public void A(final Object obj) {
            if (this.f31182a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f31182a.post(new Runnable() { // from class: com.zj.adlib.ap9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15329a.w(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j, final int i) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.uo9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20116a.x(j, i);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.yo9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f46085a.y(exc);
                    }
                });
            }
        }

        public void D(final hp9 hp9Var) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.so9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44737a.z(hp9Var);
                    }
                });
            }
        }

        public void k(final String str, final long j, final long j2) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.ep9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16384a.q(str, j, j2);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.qo9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44265a.r(str);
                    }
                });
            }
        }

        public void m(final p82 p82Var) {
            p82Var.c();
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.mo9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43351a.s(p82Var);
                    }
                });
            }
        }

        public void n(final int i, final long j) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.cp9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15871a.t(i, j);
                    }
                });
            }
        }

        public void o(final p82 p82Var) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.oo9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43795a.u(p82Var);
                    }
                });
            }
        }

        public void p(final d dVar, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f31182a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.wo9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20491a.v(dVar, decoderReuseEvaluation);
                    }
                });
            }
        }
    }

    default void a(d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void c(p82 p82Var) {
    }

    @Deprecated
    default void g(d dVar) {
    }

    default void h(p82 p82Var) {
    }

    default void onDroppedFrames(int i, long j) {
    }

    default void onRenderedFirstFrame(Object obj, long j) {
    }

    default void onVideoCodecError(Exception exc) {
    }

    default void onVideoDecoderInitialized(String str, long j, long j2) {
    }

    default void onVideoDecoderReleased(String str) {
    }

    default void onVideoFrameProcessingOffset(long j, int i) {
    }

    default void onVideoSizeChanged(hp9 hp9Var) {
    }
}
