package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.zj.adlib.gj9;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AudioRendererEventListener {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f30538a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final AudioRendererEventListener f2361a;

        public a(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
            this.f30538a = audioRendererEventListener != null ? (Handler) sb0.g(handler) : null;
            this.f2361a = audioRendererEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i, long j, long j2) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onAudioUnderrun(i, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onAudioCodecError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onAudioSinkError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j, long j2) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onAudioDecoderInitialized(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onAudioDecoderReleased(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(p82 p82Var) {
            p82Var.c();
            ((AudioRendererEventListener) gj9.k(this.f2361a)).f(p82Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(p82 p82Var) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).i(p82Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(com.google.android.exoplayer2.d dVar, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).e(dVar);
            ((AudioRendererEventListener) gj9.k(this.f2361a)).d(dVar, decoderReuseEvaluation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(long j) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onAudioPositionAdvancing(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(boolean z) {
            ((AudioRendererEventListener) gj9.k(this.f2361a)).onSkipSilenceEnabledChanged(z);
        }

        public void B(final long j) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.ff0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16515a.y(j);
                    }
                });
            }
        }

        public void C(final boolean z) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.df0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41168a.z(z);
                    }
                });
            }
        }

        public void D(final int i, final long j, final long j2) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.lf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17929a.A(i, j, j2);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.pf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43969a.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.nf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43512a.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j, final long j2) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.rf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19282a.t(str, j, j2);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.ze0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f46243a.u(str);
                    }
                });
            }
        }

        public void o(final p82 p82Var) {
            p82Var.c();
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.hf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42113a.v(p82Var);
                    }
                });
            }
        }

        public void p(final p82 p82Var) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.jf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42572a.w(p82Var);
                    }
                });
            }
        }

        public void q(final com.google.android.exoplayer2.d dVar, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f30538a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.zj.adlib.bf0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f40735a.x(dVar, decoderReuseEvaluation);
                    }
                });
            }
        }
    }

    default void d(com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    @Deprecated
    default void e(com.google.android.exoplayer2.d dVar) {
    }

    default void f(p82 p82Var) {
    }

    default void i(p82 p82Var) {
    }

    default void onAudioCodecError(Exception exc) {
    }

    default void onAudioDecoderInitialized(String str, long j, long j2) {
    }

    default void onAudioDecoderReleased(String str) {
    }

    default void onAudioPositionAdvancing(long j) {
    }

    default void onAudioSinkError(Exception exc) {
    }

    default void onAudioUnderrun(int i, long j, long j2) {
    }

    default void onSkipSilenceEnabledChanged(boolean z) {
    }
}
