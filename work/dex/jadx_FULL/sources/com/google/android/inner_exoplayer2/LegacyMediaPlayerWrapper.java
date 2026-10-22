package com.google.android.inner_exoplayer2;

import android.media.MediaPlayer;
import android.os.Looper;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class LegacyMediaPlayerWrapper extends SimpleBasePlayer {
    private boolean playWhenReady;
    private final MediaPlayer player;

    public LegacyMediaPlayerWrapper(Looper looper) {
        super(looper);
        this.player = new MediaPlayer();
    }

    @Override // com.google.android.inner_exoplayer2.SimpleBasePlayer
    public SimpleBasePlayer.State getState() {
        return new SimpleBasePlayer.State.Builder().setAvailableCommands(new Player.Commands.Builder().addAll(1).build()).setPlayWhenReady(this.playWhenReady, 1).build();
    }

    @Override // com.google.android.inner_exoplayer2.SimpleBasePlayer
    public ListenableFuture<?> handleSetPlayWhenReady(boolean z) {
        this.playWhenReady = z;
        if (z) {
            this.player.start();
        } else {
            this.player.pause();
        }
        return com.google.common.util.concurrent.f.n();
    }
}
