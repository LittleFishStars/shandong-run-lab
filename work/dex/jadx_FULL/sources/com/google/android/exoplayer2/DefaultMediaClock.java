package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.zj.adlib.np8;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DefaultMediaClock implements MediaClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlaybackParametersListener f30478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Renderer f2020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaClock f2021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final np8 f2022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2023a = true;
    public boolean b;

    public interface PlaybackParametersListener {
        void g(j jVar);
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, Clock clock) {
        this.f30478a = playbackParametersListener;
        this.f2022a = new np8(clock);
    }

    public void a(Renderer renderer) {
        if (renderer == this.f2020a) {
            this.f2021a = null;
            this.f2020a = null;
            this.f2023a = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public j b() {
        MediaClock mediaClock = this.f2021a;
        return mediaClock != null ? mediaClock.b() : this.f2022a.b();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void c(j jVar) {
        MediaClock mediaClock = this.f2021a;
        if (mediaClock != null) {
            mediaClock.c(jVar);
            jVar = this.f2021a.b();
        }
        this.f2022a.c(jVar);
    }

    public void d(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock mediaClockD = renderer.d();
        if (mediaClockD == null || mediaClockD == (mediaClock = this.f2021a)) {
            return;
        }
        if (mediaClock != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f2021a = mediaClockD;
        this.f2020a = renderer;
        mediaClockD.c(this.f2022a.b());
    }

    public void e(long j) {
        this.f2022a.a(j);
    }

    public final boolean f(boolean z) {
        Renderer renderer = this.f2020a;
        return renderer == null || renderer.isEnded() || (!this.f2020a.isReady() && (z || this.f2020a.hasReadStreamToEnd()));
    }

    public void g() {
        this.b = true;
        this.f2022a.d();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        return this.f2023a ? this.f2022a.getPositionUs() : ((MediaClock) sb0.g(this.f2021a)).getPositionUs();
    }

    public void h() {
        this.b = false;
        this.f2022a.e();
    }

    public long i(boolean z) {
        j(z);
        return getPositionUs();
    }

    public final void j(boolean z) {
        if (f(z)) {
            this.f2023a = true;
            if (this.b) {
                this.f2022a.d();
                return;
            }
            return;
        }
        MediaClock mediaClock = (MediaClock) sb0.g(this.f2021a);
        long positionUs = mediaClock.getPositionUs();
        if (this.f2023a) {
            if (positionUs < this.f2022a.getPositionUs()) {
                this.f2022a.e();
                return;
            } else {
                this.f2023a = false;
                if (this.b) {
                    this.f2022a.d();
                }
            }
        }
        this.f2022a.a(positionUs);
        j jVarB = mediaClock.b();
        if (jVarB.equals(this.f2022a.b())) {
            return;
        }
        this.f2022a.c(jVarB);
        this.f30478a.g(jVarB);
    }
}
