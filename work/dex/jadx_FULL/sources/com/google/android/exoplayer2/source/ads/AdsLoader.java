package com.google.android.exoplayer2.source.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdsLoader {

    public interface EventListener {
        default void a(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
        }

        default void b(AdPlaybackState adPlaybackState) {
        }

        default void onAdClicked() {
        }

        default void onAdTapped() {
        }
    }

    public interface Provider {
        @Nullable
        AdsLoader a(g.b bVar);
    }

    void a(AdsMediaSource adsMediaSource, EventListener eventListener);

    void b(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void c(@Nullable Player player);

    void d(AdsMediaSource adsMediaSource, int i, int i2);

    void e(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException);

    void release();

    void setSupportedContentTypes(int... iArr);
}
