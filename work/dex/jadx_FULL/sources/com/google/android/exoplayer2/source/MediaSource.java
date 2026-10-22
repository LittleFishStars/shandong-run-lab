package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.at6;
import com.zj.adlib.gk5;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaSource {

    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Factory f30821a = MediaSourceFactory.f30824a;

        Factory a(DrmSessionManagerProvider drmSessionManagerProvider);

        Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

        MediaSource c(com.google.android.exoplayer2.g gVar);

        int[] getSupportedTypes();
    }

    public interface MediaSourceCaller {
        void r(MediaSource mediaSource, Timeline timeline);
    }

    public static final class a extends gk5 {
        public a(Object obj) {
            super(obj);
        }

        @Override // com.zj.adlib.gk5
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            return new a(super.a(obj));
        }

        @Override // com.zj.adlib.gk5
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(long j) {
            return new a(super.b(j));
        }

        public a(Object obj, long j) {
            super(obj, j);
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(gk5 gk5Var) {
            super(gk5Var);
        }
    }

    void B(MediaSourceCaller mediaSourceCaller);

    void C(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    @Deprecated
    default void E(MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        x(mediaSourceCaller, transferListener, at6.f40608a);
    }

    MediaPeriod F(a aVar, Allocator allocator, long j);

    void G(MediaSourceEventListener mediaSourceEventListener);

    void H(MediaSourceCaller mediaSourceCaller);

    void L(MediaSourceCaller mediaSourceCaller);

    com.google.android.exoplayer2.g b();

    void g(DrmSessionEventListener drmSessionEventListener);

    default boolean isSingleWindow() {
        return true;
    }

    void j(MediaPeriod mediaPeriod);

    void maybeThrowSourceInfoRefreshError() throws IOException;

    @Nullable
    default Timeline q() {
        return null;
    }

    void t(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void x(MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener, at6 at6Var);
}
