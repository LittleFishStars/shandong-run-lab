package com.beizi.fusion;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface gf extends ya {

    public enum a implements xa {
        VIDEO_CACHE_FAILED(32, "cache_failed"),
        VIDEO_START(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, "play_start"),
        VIDEO_PROCESS(33, "play_process"),
        VIDEO_FINISHED(MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION, "play_end"),
        VIDEO_PLAY_VALID(MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, "video play valid"),
        VIDEO_ERROR(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, "video play error"),
        VIDEO_PREPARED(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, "video prepared");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27348a;
        private final String b;

        a(int i, String str) {
            this.f27348a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.xa
        public int getEventCode() {
            return this.f27348a;
        }
    }

    void a(xa xaVar, int i);

    void b(xa xaVar, int i);

    void c(xa xaVar);

    void e(xa xaVar);

    void i(xa xaVar);

    void j(xa xaVar);
}
