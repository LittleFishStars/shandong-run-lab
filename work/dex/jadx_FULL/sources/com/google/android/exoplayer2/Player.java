package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.zj.adlib.hp9;
import com.zj.adlib.xy1;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Player {
    public static final int A = 0;
    public static final int A0 = 18;
    public static final int B = 1;
    public static final int B0 = 19;
    public static final int C = 2;
    public static final int C0 = 31;
    public static final int D = 3;
    public static final int D0 = 20;
    public static final int E = 4;
    public static final int E0 = 21;
    public static final int F = 5;
    public static final int F0 = 22;
    public static final int G = 6;
    public static final int G0 = 23;
    public static final int H = 7;
    public static final int H0 = 24;
    public static final int I = 8;
    public static final int I0 = 25;
    public static final int J = 9;
    public static final int J0 = 26;
    public static final int K = 10;
    public static final int K0 = 27;
    public static final int L = 11;
    public static final int L0 = 28;
    public static final int M = 12;
    public static final int M0 = 29;
    public static final int N = 13;
    public static final int N0 = 30;
    public static final int O = 14;
    public static final int O0 = -1;
    public static final int P = 15;
    public static final int Q = 16;
    public static final int R = 17;
    public static final int S = 18;
    public static final int T = 19;
    public static final int U = 20;
    public static final int V = 21;
    public static final int W = 22;
    public static final int X = 23;
    public static final int Y = 24;
    public static final int Z = 25;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30498a = 1;
    public static final int a0 = 26;
    public static final int b = 2;
    public static final int b0 = 27;
    public static final int c = 3;
    public static final int c0 = 28;
    public static final int d = 4;
    public static final int d0 = 29;
    public static final int e = 1;
    public static final int e0 = 30;
    public static final int f = 2;
    public static final int f0 = 1;
    public static final int g = 3;
    public static final int g0 = 2;
    public static final int h = 4;
    public static final int h0 = 3;
    public static final int i = 5;
    public static final int i0 = 4;
    public static final int j = 0;
    public static final int j0 = 5;
    public static final int k = 1;

    @Deprecated
    public static final int k0 = 5;
    public static final int l = 0;
    public static final int l0 = 6;
    public static final int m = 1;

    @Deprecated
    public static final int m0 = 6;
    public static final int n = 2;
    public static final int n0 = 7;
    public static final int o = 0;
    public static final int o0 = 8;
    public static final int p = 1;

    @Deprecated
    public static final int p0 = 8;
    public static final int q = 2;
    public static final int q0 = 9;
    public static final int r = 3;
    public static final int r0 = 10;
    public static final int s = 4;

    @Deprecated
    public static final int s0 = 10;
    public static final int t = 5;
    public static final int t0 = 11;
    public static final int u = 0;
    public static final int u0 = 12;
    public static final int v = 1;
    public static final int v0 = 13;
    public static final int w = 0;
    public static final int w0 = 14;
    public static final int x = 1;
    public static final int x0 = 15;
    public static final int y = 2;
    public static final int y0 = 16;
    public static final int z = 3;
    public static final int z0 = 17;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Command {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    public interface Listener {
        default void A(DeviceInfo deviceInfo) {
        }

        default void B(com.google.android.exoplayer2.audio.a aVar) {
        }

        default void C(d dVar, d dVar2, int i) {
        }

        default void E(b bVar) {
        }

        default void F(@Nullable g gVar, int i) {
        }

        default void G(p pVar) {
        }

        default void H(@Nullable PlaybackException playbackException) {
        }

        default void b(Metadata metadata) {
        }

        default void g(j jVar) {
        }

        default void j(xy1 xy1Var) {
        }

        default void onAudioSessionIdChanged(int i) {
        }

        @Deprecated
        default void onCues(List<Cue> list) {
        }

        default void onDeviceVolumeChanged(int i, boolean z) {
        }

        default void onIsLoadingChanged(boolean z) {
        }

        default void onIsPlayingChanged(boolean z) {
        }

        @Deprecated
        default void onLoadingChanged(boolean z) {
        }

        default void onMaxSeekToPreviousPositionChanged(long j) {
        }

        default void onPlayWhenReadyChanged(boolean z, int i) {
        }

        default void onPlaybackStateChanged(int i) {
        }

        default void onPlaybackSuppressionReasonChanged(int i) {
        }

        default void onPlayerError(PlaybackException playbackException) {
        }

        @Deprecated
        default void onPlayerStateChanged(boolean z, int i) {
        }

        @Deprecated
        default void onPositionDiscontinuity(int i) {
        }

        default void onRenderedFirstFrame() {
        }

        default void onRepeatModeChanged(int i) {
        }

        default void onSeekBackIncrementChanged(long j) {
        }

        default void onSeekForwardIncrementChanged(long j) {
        }

        @Deprecated
        default void onSeekProcessed() {
        }

        default void onShuffleModeEnabledChanged(boolean z) {
        }

        default void onSkipSilenceEnabledChanged(boolean z) {
        }

        default void onSurfaceSizeChanged(int i, int i2) {
        }

        default void onVideoSizeChanged(hp9 hp9Var) {
        }

        default void onVolumeChanged(float f) {
        }

        default void q(com.google.android.exoplayer2.trackselection.c cVar) {
        }

        default void r(Timeline timeline, int i) {
        }

        default void t(Player player, c cVar) {
        }

        default void x(MediaMetadata mediaMetadata) {
        }

        default void z(MediaMetadata mediaMetadata) {
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaItemTransitionReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    public static final class b implements Bundleable {
        public static final int K = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.util.a f2165a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final b f2164a = new a().f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<b> f30499a = new Bundleable.Creator() { // from class: com.zj.adlib.vs6
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return Player.b.f(bundle);
            }
        };

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int[] f30500a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final com.google.android.exoplayer2.util.a.b f2166a;

            public a a(int i) {
                this.f2166a.a(i);
                return this;
            }

            public a b(b bVar) {
                this.f2166a.b(bVar.f2165a);
                return this;
            }

            public a c(int... iArr) {
                this.f2166a.c(iArr);
                return this;
            }

            public a d() {
                this.f2166a.c(f30500a);
                return this;
            }

            public a e(int i, boolean z) {
                this.f2166a.d(i, z);
                return this;
            }

            public b f() {
                return new b(this.f2166a.e());
            }

            public a g(int i) {
                this.f2166a.f(i);
                return this;
            }

            public a h(int... iArr) {
                this.f2166a.g(iArr);
                return this;
            }

            public a i(int i, boolean z) {
                this.f2166a.h(i, z);
                return this;
            }

            public a() {
                this.f2166a = new com.google.android.exoplayer2.util.a.b();
            }

            public a(b bVar) {
                com.google.android.exoplayer2.util.a.b bVar2 = new com.google.android.exoplayer2.util.a.b();
                this.f2166a = bVar2;
                bVar2.b(bVar.f2165a);
            }
        }

        public static b f(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(h(0));
            if (integerArrayList == null) {
                return f2164a;
            }
            a aVar = new a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                aVar.a(integerArrayList.get(i).intValue());
            }
            return aVar.f();
        }

        public static String h(int i) {
            return Integer.toString(i, 36);
        }

        public a c() {
            return new a();
        }

        public boolean d(int i) {
            return this.f2165a.a(i);
        }

        public boolean e(int... iArr) {
            return this.f2165a.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f2165a.equals(((b) obj).f2165a);
            }
            return false;
        }

        public int g(int i) {
            return this.f2165a.c(i);
        }

        public int hashCode() {
            return this.f2165a.hashCode();
        }

        public int i() {
            return this.f2165a.d();
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < this.f2165a.d(); i++) {
                arrayList.add(Integer.valueOf(this.f2165a.c(i)));
            }
            bundle.putIntegerArrayList(h(0), arrayList);
            return bundle;
        }

        public b(com.google.android.exoplayer2.util.a aVar) {
            this.f2165a = aVar;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.a f30501a;

        public c(com.google.android.exoplayer2.util.a aVar) {
            this.f30501a = aVar;
        }

        public boolean a(int i) {
            return this.f30501a.a(i);
        }

        public boolean b(int... iArr) {
            return this.f30501a.b(iArr);
        }

        public int c(int i) {
            return this.f30501a.c(i);
        }

        public int d() {
            return this.f30501a.d();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f30501a.equals(((c) obj).f30501a);
            }
            return false;
        }

        public int hashCode() {
            return this.f30501a.hashCode();
        }
    }

    public static final class d implements Bundleable {
        public static final int P = 0;
        public static final int Q = 1;
        public static final int R = 2;
        public static final int S = 3;
        public static final int T = 4;
        public static final int U = 5;
        public static final int V = 6;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<d> f30502a = new Bundleable.Creator() { // from class: com.zj.adlib.xs6
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return Player.d.b(bundle);
            }
        };

        @Deprecated
        public final int K;
        public final int L;
        public final int M;
        public final int N;
        public final int O;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2167a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final g f2168a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Object f2169a;
        public final long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public final Object f2170b;

        @Deprecated
        public d(@Nullable Object obj, int i, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this(obj, i, g.f3322a, obj2, i2, j, j2, i3, i4);
        }

        public static d b(Bundle bundle) {
            int i = bundle.getInt(c(0), -1);
            Bundle bundle2 = bundle.getBundle(c(1));
            return new d(null, i, bundle2 == null ? null : (g) g.f30740a.a(bundle2), null, bundle.getInt(c(2), -1), bundle.getLong(c(3), -9223372036854775807L), bundle.getLong(c(4), -9223372036854775807L), bundle.getInt(c(5), -1), bundle.getInt(c(6), -1));
        }

        public static String c(int i) {
            return Integer.toString(i, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.L == dVar.L && this.M == dVar.M && this.f2167a == dVar.f2167a && this.b == dVar.b && this.N == dVar.N && this.O == dVar.O && com.google.common.base.g.a(this.f2169a, dVar.f2169a) && com.google.common.base.g.a(this.f2170b, dVar.f2170b) && com.google.common.base.g.a(this.f2168a, dVar.f2168a);
        }

        public int hashCode() {
            return com.google.common.base.g.b(this.f2169a, Integer.valueOf(this.L), this.f2168a, this.f2170b, Integer.valueOf(this.M), Long.valueOf(this.f2167a), Long.valueOf(this.b), Integer.valueOf(this.N), Integer.valueOf(this.O));
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.L);
            if (this.f2168a != null) {
                bundle.putBundle(c(1), this.f2168a.toBundle());
            }
            bundle.putInt(c(2), this.M);
            bundle.putLong(c(3), this.f2167a);
            bundle.putLong(c(4), this.b);
            bundle.putInt(c(5), this.N);
            bundle.putInt(c(6), this.O);
            return bundle;
        }

        public d(@Nullable Object obj, int i, @Nullable g gVar, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.f2169a = obj;
            this.K = i;
            this.L = i;
            this.f2168a = gVar;
            this.f2170b = obj2;
            this.M = i2;
            this.f2167a = j;
            this.b = j2;
            this.N = i3;
            this.O = i4;
        }
    }

    void E(int i2, g gVar);

    com.google.android.exoplayer2.trackselection.c K();

    void L(com.google.android.exoplayer2.trackselection.c cVar);

    b Q();

    void U(g gVar, boolean z2);

    void V(Listener listener);

    void X(MediaMetadata mediaMetadata);

    @Nullable
    g Z();

    Timeline a0();

    void addMediaItems(int i2, List<g> list);

    void addMediaItems(List<g> list);

    j b();

    void b0(g gVar);

    void c(j jVar);

    boolean canAdvertiseSession();

    void clearMediaItems();

    void clearVideoSurface();

    void clearVideoSurface(@Nullable Surface surface);

    void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

    void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void clearVideoTextureView(@Nullable TextureView textureView);

    com.google.android.exoplayer2.audio.a d();

    void decreaseDeviceVolume();

    @Nullable
    PlaybackException f();

    void f0(g gVar);

    DeviceInfo g();

    void g0(g gVar, long j2);

    Looper getApplicationLooper();

    @IntRange(from = 0, to = 100)
    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    long getCurrentLiveOffset();

    @Nullable
    Object getCurrentManifest();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    @Deprecated
    int getCurrentWindowIndex();

    @IntRange(from = 0)
    int getDeviceVolume();

    long getDuration();

    long getMaxSeekToPreviousPosition();

    int getMediaItemCount();

    int getNextMediaItemIndex();

    @Deprecated
    int getNextWindowIndex();

    boolean getPlayWhenReady();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    int getPreviousMediaItemIndex();

    @Deprecated
    int getPreviousWindowIndex();

    int getRepeatMode();

    long getSeekBackIncrement();

    long getSeekForwardIncrement();

    boolean getShuffleModeEnabled();

    long getTotalBufferedDuration();

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    float getVolume();

    MediaMetadata h0();

    @Deprecated
    boolean hasNext();

    boolean hasNextMediaItem();

    @Deprecated
    boolean hasNextWindow();

    @Deprecated
    boolean hasPrevious();

    boolean hasPreviousMediaItem();

    @Deprecated
    boolean hasPreviousWindow();

    void increaseDeviceVolume();

    boolean isCommandAvailable(int i2);

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    @Deprecated
    boolean isCurrentWindowDynamic();

    @Deprecated
    boolean isCurrentWindowLive();

    @Deprecated
    boolean isCurrentWindowSeekable();

    boolean isDeviceMuted();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    hp9 j();

    xy1 m();

    void moveMediaItem(int i2, int i3);

    void moveMediaItems(int i2, int i3, int i4);

    @Deprecated
    void next();

    void pause();

    void play();

    void prepare();

    @Deprecated
    void previous();

    void release();

    void removeMediaItem(int i2);

    void removeMediaItems(int i2, int i3);

    p s();

    void seekBack();

    void seekForward();

    void seekTo(int i2, long j2);

    void seekTo(long j2);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i2);

    void seekToNext();

    void seekToNextMediaItem();

    @Deprecated
    void seekToNextWindow();

    void seekToPrevious();

    void seekToPreviousMediaItem();

    @Deprecated
    void seekToPreviousWindow();

    void setDeviceMuted(boolean z2);

    void setDeviceVolume(@IntRange(from = 0) int i2);

    void setMediaItems(List<g> list);

    void setMediaItems(List<g> list, int i2, long j2);

    void setMediaItems(List<g> list, boolean z2);

    void setPlayWhenReady(boolean z2);

    void setPlaybackSpeed(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f2);

    void setRepeatMode(int i2);

    void setShuffleModeEnabled(boolean z2);

    void setVideoSurface(@Nullable Surface surface);

    void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

    void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void setVideoTextureView(@Nullable TextureView textureView);

    void setVolume(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f2);

    void stop();

    @Deprecated
    void stop(boolean z2);

    void u(Listener listener);

    g v(int i2);

    MediaMetadata z();
}
