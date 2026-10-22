package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface HlsPlaylistTracker {

    public interface Factory {
        HlsPlaylistTracker a(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory);
    }

    public interface PlaylistEventListener {
        boolean b(Uri uri, LoadErrorHandlingPolicy.c cVar, boolean z);

        void onPlaylistChanged();
    }

    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri) {
            this.url = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri) {
            this.url = uri;
        }
    }

    public interface PrimaryPlaylistListener {
        void z(HlsMediaPlaylist hlsMediaPlaylist);
    }

    void a(PlaylistEventListener playlistEventListener);

    void b(PlaylistEventListener playlistEventListener);

    @Nullable
    HlsMediaPlaylist c(Uri uri, boolean z);

    @Nullable
    c d();

    void e(Uri uri, MediaSourceEventListener.a aVar, PrimaryPlaylistListener primaryPlaylistListener);

    boolean excludeMediaPlaylist(Uri uri, long j);

    long getInitialStartTimeUs();

    boolean isLive();

    boolean isSnapshotValid(Uri uri);

    void maybeThrowPlaylistRefreshError(Uri uri) throws IOException;

    void maybeThrowPrimaryPlaylistRefreshError() throws IOException;

    void refreshPlaylist(Uri uri);

    void stop();
}
