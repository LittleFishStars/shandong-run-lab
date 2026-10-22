package com.google.android.exoplayer2.analytics;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface PlaybackSessionManager {

    public interface Listener {
        void B(AnalyticsListener.a aVar, String str);

        void b(AnalyticsListener.a aVar, String str);

        void k0(AnalyticsListener.a aVar, String str, boolean z);

        void w0(AnalyticsListener.a aVar, String str, String str2);
    }

    void a(AnalyticsListener.a aVar);

    void b(Listener listener);

    void c(AnalyticsListener.a aVar);

    void d(AnalyticsListener.a aVar, int i);

    String e(Timeline timeline, MediaSource.a aVar);

    void f(AnalyticsListener.a aVar);

    boolean g(AnalyticsListener.a aVar, String str);

    @Nullable
    String getActiveSessionId();
}
