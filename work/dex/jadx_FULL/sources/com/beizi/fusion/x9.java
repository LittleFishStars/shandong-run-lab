package com.beizi.fusion;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface x9 extends ya {

    public enum a implements xa {
        AD_CLICK(502, "ad_click"),
        DOWNLOAD_START(510, "download_start"),
        DOWNLOAD_PAUSE(511, "download_pause"),
        DOWNLOAD_CONTINUE(512, "download_continue"),
        DOWNLOAD_COMPLETE(513, "download_complete"),
        DOWNLOAD_FAILED(518, "download_failed"),
        INSTALL_START(514, "install_start"),
        INSTALL_COMPLETE(515, "install_complete"),
        APP_LAUNCHED(516, "app_launched"),
        INVOKE_DEEPLINK(520, "start_deeplink"),
        DEEPLINK_INVOKE_SUCCESS(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, "deeplink_success"),
        DEEPLINK_INVOKE_ASSUME_SUCCESS(525, "deeplink_assume_success"),
        DEEPLINK_INVOKE_FAILED(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE, "deeplink_failed"),
        DEEPLINK_INVOKE_ASSUME_REFUSE(526, "deeplink_refuse"),
        APP_NOT_INSTALLED(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, "app_not_installed"),
        APP_INSTALLED(524, "app_installed"),
        AD_CLOSE(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, "ad_closed"),
        REWARD_PRIMARY_CLOSE(84, "reward_close"),
        REWARD_TO_PRIVILEGE(85, "reward_to_privilege"),
        REWARD_TO_RETAIN(86, "reward_to_retain"),
        REWARD_TO_END_CARD(87, "reward_to_end_card"),
        COMPLAIN_CONFIRM(900, "complain_confirm");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28028a;
        private final String b;

        a(int i, String str) {
            this.f28028a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.xa
        public int getEventCode() {
            return this.f28028a;
        }
    }

    void a(a aVar);

    void a(xa xaVar, View view);

    void d(xa xaVar);

    void f(xa xaVar);
}
