package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.li8;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k extends BaseMediaSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d f4293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.g f4294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f4295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f4296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f4298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4299a;
    public final Timeline b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataSource.Factory f30945a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f4301a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f4302a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LoadErrorHandlingPolicy f4300a = new com.google.android.exoplayer2.upstream.f();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4303a = true;

        public b(DataSource.Factory factory) {
            this.f30945a = (DataSource.Factory) sb0.g(factory);
        }

        public k a(com.google.android.exoplayer2.g.l lVar, long j) {
            return new k(this.f4302a, lVar, this.f30945a, j, this.f4300a, this.f4303a, this.f4301a);
        }

        public b b(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.f();
            }
            this.f4300a = loadErrorHandlingPolicy;
            return this;
        }

        public b c(@Nullable Object obj) {
            this.f4301a = obj;
            return this;
        }

        @Deprecated
        public b d(@Nullable String str) {
            this.f4302a = str;
            return this;
        }

        public b e(boolean z) {
            this.f4303a = z;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        return new j(this.f4296a, this.f4295a, this.f4298a, this.f4293a, this.f30944a, this.f4297a, createEventDispatcher(aVar), this.f4299a);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f4294a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        ((j) mediaPeriod).i();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f4298a = transferListener;
        refreshSourceInfo(this.b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public k(@Nullable String str, com.google.android.exoplayer2.g.l lVar, DataSource.Factory factory, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, @Nullable Object obj) {
        this.f4295a = factory;
        this.f30944a = j;
        this.f4297a = loadErrorHandlingPolicy;
        this.f4299a = z;
        com.google.android.exoplayer2.g gVarA = new com.google.android.exoplayer2.g.c().L(Uri.EMPTY).D(lVar.f3379a.toString()).I(ImmutableList.of(lVar)).K(obj).a();
        this.f4294a = gVarA;
        com.google.android.exoplayer2.d.b bVarU = new com.google.android.exoplayer2.d.b().e0((String) com.google.common.base.e.a(lVar.f3380a, "text/x-unknown")).V(lVar.f3381b).g0(lVar.f30754a).c0(lVar.b).U(lVar.c);
        String str2 = lVar.d;
        this.f4293a = bVarU.S(str2 == null ? str : str2).E();
        this.f4296a = new DataSpec.b().j(lVar.f3379a).c(1).a();
        this.b = new li8(j, true, false, false, (Object) null, gVarA);
    }
}
