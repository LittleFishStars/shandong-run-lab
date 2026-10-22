package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.ki8;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaSource.a f30841a = new MediaSource.a(new Object());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource.Factory f3774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource f3775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AdPlaybackState f3776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AdsLoader f3777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f3778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AdViewProvider f3779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f3780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3781a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public Timeline f3783b;
    public final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f3773a = new Timeline.b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a[][] f3782a = new a[0][];

    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i, exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            sb0.i(this.type == 3);
            return (RuntimeException) sb0.g(getCause());
        }
    }

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f30842a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Timeline f3784a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource.a f3785a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaSource f3786a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<MaskingMediaPeriod> f3788a = new ArrayList();

        public a(MediaSource.a aVar) {
            this.f3785a = aVar;
        }

        public MediaPeriod a(MediaSource.a aVar, Allocator allocator, long j) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(aVar, allocator, j);
            this.f3788a.add(maskingMediaPeriod);
            MediaSource mediaSource = this.f3786a;
            if (mediaSource != null) {
                maskingMediaPeriod.n(mediaSource);
                maskingMediaPeriod.o(AdsMediaSource.this.new b((Uri) sb0.g(this.f30842a)));
            }
            Timeline timeline = this.f3784a;
            if (timeline != null) {
                maskingMediaPeriod.b(new MediaSource.a(timeline.s(0), ((gk5) aVar).f16804a));
            }
            return maskingMediaPeriod;
        }

        public long b() {
            Timeline timeline = this.f3784a;
            if (timeline == null) {
                return -9223372036854775807L;
            }
            return timeline.j(0, AdsMediaSource.this.f3773a).o();
        }

        public void c(Timeline timeline) {
            sb0.a(timeline.m() == 1);
            if (this.f3784a == null) {
                Object objS = timeline.s(0);
                for (int i = 0; i < this.f3788a.size(); i++) {
                    MaskingMediaPeriod maskingMediaPeriod = this.f3788a.get(i);
                    maskingMediaPeriod.b(new MediaSource.a(objS, ((gk5) maskingMediaPeriod.f3670a).f16804a));
                }
            }
            this.f3784a = timeline;
        }

        public boolean d() {
            return this.f3786a != null;
        }

        public void e(MediaSource mediaSource, Uri uri) {
            this.f3786a = mediaSource;
            this.f30842a = uri;
            for (int i = 0; i < this.f3788a.size(); i++) {
                MaskingMediaPeriod maskingMediaPeriod = this.f3788a.get(i);
                maskingMediaPeriod.n(mediaSource);
                maskingMediaPeriod.o(AdsMediaSource.this.new b(uri));
            }
            AdsMediaSource.this.prepareChildSource(this.f3785a, mediaSource);
        }

        public boolean f() {
            return this.f3788a.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.releaseChildSource(this.f3785a);
            }
        }

        public void h(MaskingMediaPeriod maskingMediaPeriod) {
            this.f3788a.remove(maskingMediaPeriod);
            maskingMediaPeriod.m();
        }
    }

    public final class b implements MaskingMediaPeriod.PrepareListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f30843a;

        public b(Uri uri) {
            this.f30843a = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(MediaSource.a aVar) {
            AdsMediaSource.this.f3777a.d(AdsMediaSource.this, ((gk5) aVar).f41928a, aVar.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(MediaSource.a aVar, IOException iOException) {
            AdsMediaSource.this.f3777a.e(AdsMediaSource.this, ((gk5) aVar).f41928a, aVar.b, iOException);
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void a(final MediaSource.a aVar) {
            AdsMediaSource.this.b.post(new Runnable() { // from class: com.zj.adlib.z10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20952a.e(aVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void b(final MediaSource.a aVar, final IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(aVar).x(new az4(az4.a(), new DataSpec(this.f30843a), SystemClock.elapsedRealtime()), 6, AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.b.post(new Runnable() { // from class: com.zj.adlib.a20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15140a.f(aVar, iOException);
                }
            });
        }
    }

    public final class c implements AdsLoader.EventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30844a = gj9.y();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile boolean f3791a;

        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(AdPlaybackState adPlaybackState) {
            if (this.f3791a) {
                return;
            }
            AdsMediaSource.this.g0(adPlaybackState);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void a(AdLoadException adLoadException, DataSpec dataSpec) {
            if (this.f3791a) {
                return;
            }
            AdsMediaSource.this.createEventDispatcher(null).x(new az4(az4.a(), dataSpec, SystemClock.elapsedRealtime()), 6, adLoadException, true);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void b(final AdPlaybackState adPlaybackState) {
            if (this.f3791a) {
                return;
            }
            this.f30844a.post(new Runnable() { // from class: com.zj.adlib.b20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15423a.d(adPlaybackState);
                }
            });
        }

        public void e() {
            this.f3791a = true;
            this.f30844a.removeCallbacksAndMessages(null);
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider) {
        this.f3775a = mediaSource;
        this.f3774a = factory;
        this.f3777a = adsLoader;
        this.f3779a = adViewProvider;
        this.f3780a = dataSpec;
        this.f3781a = obj;
        adsLoader.setSupportedContentTypes(factory.getSupportedTypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(c cVar) {
        this.f3777a.b(this, this.f3780a, this.f3781a, this.f3779a, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(c cVar) {
        this.f3777a.a(this, cVar);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        if (((AdPlaybackState) sb0.g(this.f3776a)).K <= 0 || !aVar.c()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(aVar, allocator, j);
            maskingMediaPeriod.n(this.f3775a);
            maskingMediaPeriod.b(aVar);
            return maskingMediaPeriod;
        }
        int i = ((gk5) aVar).f41928a;
        int i2 = aVar.b;
        a[][] aVarArr = this.f3782a;
        a[] aVarArr2 = aVarArr[i];
        if (aVarArr2.length <= i2) {
            aVarArr[i] = (a[]) Arrays.copyOf(aVarArr2, i2 + 1);
        }
        a aVar2 = this.f3782a[i][i2];
        if (aVar2 == null) {
            aVar2 = new a(aVar);
            this.f3782a[i][i2] = aVar2;
            e0();
        }
        return aVar2.a(aVar, allocator, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public g b() {
        return this.f3775a.b();
    }

    public final long[][] b0() {
        long[][] jArr = new long[this.f3782a.length][];
        int i = 0;
        while (true) {
            a[][] aVarArr = this.f3782a;
            if (i >= aVarArr.length) {
                return jArr;
            }
            jArr[i] = new long[aVarArr[i].length];
            int i2 = 0;
            while (true) {
                a[] aVarArr2 = this.f3782a[i];
                if (i2 < aVarArr2.length) {
                    a aVar = aVarArr2[i2];
                    jArr[i][i2] = aVar == null ? -9223372036854775807L : aVar.b();
                    i2++;
                }
            }
            i++;
        }
    }

    public final void e0() {
        Uri uri;
        AdPlaybackState adPlaybackState = this.f3776a;
        if (adPlaybackState == null) {
            return;
        }
        for (int i = 0; i < this.f3782a.length; i++) {
            int i2 = 0;
            while (true) {
                a[] aVarArr = this.f3782a[i];
                if (i2 < aVarArr.length) {
                    a aVar = aVarArr[i2];
                    AdPlaybackState.b bVarE = adPlaybackState.e(i);
                    if (aVar != null && !aVar.d()) {
                        Uri[] uriArr = bVarE.f3772a;
                        if (i2 < uriArr.length && (uri = uriArr[i2]) != null) {
                            g.c cVarL = new g.c().L(uri);
                            g.h hVar = this.f3775a.b().f3327a;
                            if (hVar != null) {
                                cVarL.m(hVar.f3368a);
                            }
                            aVar.e(this.f3774a.c(cVarL.a()), uri);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public final void f0() {
        Timeline timeline = this.f3783b;
        AdPlaybackState adPlaybackState = this.f3776a;
        if (adPlaybackState == null || timeline == null) {
            return;
        }
        if (adPlaybackState.K == 0) {
            refreshSourceInfo(timeline);
        } else {
            this.f3776a = adPlaybackState.m(b0());
            refreshSourceInfo(new ki8(timeline, this.f3776a));
        }
    }

    public final void g0(AdPlaybackState adPlaybackState) {
        AdPlaybackState adPlaybackState2 = this.f3776a;
        if (adPlaybackState2 == null) {
            a[][] aVarArr = new a[adPlaybackState.K][];
            this.f3782a = aVarArr;
            Arrays.fill(aVarArr, new a[0]);
        } else {
            sb0.i(adPlaybackState.K == adPlaybackState2.K);
        }
        this.f3776a = adPlaybackState;
        e0();
        f0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.a aVar = maskingMediaPeriod.f3670a;
        if (!aVar.c()) {
            maskingMediaPeriod.m();
            return;
        }
        a aVar2 = (a) sb0.g(this.f3782a[((gk5) aVar).f41928a][aVar.b]);
        aVar2.h(maskingMediaPeriod);
        if (aVar2.f()) {
            aVar2.g();
            this.f3782a[((gk5) aVar).f41928a][aVar.b] = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        final c cVar = new c();
        this.f3778a = cVar;
        prepareChildSource(f30841a, this.f3775a);
        this.b.post(new Runnable() { // from class: com.zj.adlib.y10
            @Override // java.lang.Runnable
            public final void run() {
                this.f20761a.c0(cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        final c cVar = (c) sb0.g(this.f3778a);
        this.f3778a = null;
        cVar.e();
        this.f3783b = null;
        this.f3776a = null;
        this.f3782a = new a[0][];
        this.b.post(new Runnable() { // from class: com.zj.adlib.x10
            @Override // java.lang.Runnable
            public final void run() {
                this.f20589a.d0(cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaSource.a getMediaPeriodIdForChildMediaPeriodId(MediaSource.a aVar, MediaSource.a aVar2) {
        return aVar.c() ? aVar : aVar2;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void Q(MediaSource.a aVar, MediaSource mediaSource, Timeline timeline) {
        if (aVar.c()) {
            ((a) sb0.g(this.f3782a[((gk5) aVar).f41928a][aVar.b])).c(timeline);
        } else {
            sb0.a(timeline.m() == 1);
            this.f3783b = timeline;
        }
        f0();
    }
}
