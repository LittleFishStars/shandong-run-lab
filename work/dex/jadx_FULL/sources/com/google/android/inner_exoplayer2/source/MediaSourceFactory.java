package com.google.android.inner_exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.MediaItem;
import com.google.android.inner_exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.inner_exoplayer2.upstream.LoadErrorHandlingPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Deprecated
public interface MediaSourceFactory extends MediaSource.Factory {
    public static final MediaSourceFactory UNSUPPORTED = new MediaSourceFactory() { // from class: com.google.android.inner_exoplayer2.source.MediaSourceFactory.1
        @Override // com.google.android.inner_exoplayer2.source.MediaSource.Factory
        public MediaSource createMediaSource(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.inner_exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.inner_exoplayer2.source.MediaSource.Factory
        public MediaSourceFactory setDrmSessionManagerProvider(@Nullable DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override // com.google.android.inner_exoplayer2.source.MediaSource.Factory
        public MediaSourceFactory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    };
}
