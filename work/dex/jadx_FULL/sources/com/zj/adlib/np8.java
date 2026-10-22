package com.zj.adlib;

import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class np8 implements MediaClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f43584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f18480a = j.f3398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f18481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18482a;
    public long b;

    public np8(Clock clock) {
        this.f18481a = clock;
    }

    public void a(long j) {
        this.f43584a = j;
        if (this.f18482a) {
            this.b = this.f18481a.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public j b() {
        return this.f18480a;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void c(j jVar) {
        if (this.f18482a) {
            a(getPositionUs());
        }
        this.f18480a = jVar;
    }

    public void d() {
        if (this.f18482a) {
            return;
        }
        this.b = this.f18481a.elapsedRealtime();
        this.f18482a = true;
    }

    public void e() {
        if (this.f18482a) {
            a(getPositionUs());
            this.f18482a = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long j = this.f43584a;
        if (!this.f18482a) {
            return j;
        }
        long jElapsedRealtime = this.f18481a.elapsedRealtime() - this.b;
        j jVar = this.f18480a;
        return j + (jVar.f3399a == 1.0f ? gj9.Z0(jElapsedRealtime) : jVar.b(jElapsedRealtime));
    }
}
