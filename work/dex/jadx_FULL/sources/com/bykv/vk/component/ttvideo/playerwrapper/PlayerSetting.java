package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.media.AudioManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class PlayerSetting {
    private final Context mContext;
    private float mCurrentPlayerVolume = 1.0f;
    private float mLastVolume;
    private MediaPlayer mPlayer;

    public PlayerSetting(Context context, MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
        this.mContext = context;
    }

    public float getMaxVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : 0;
        return streamMaxVolume >= 0 ? streamMaxVolume : 0;
    }

    public float getPlayerVolume() {
        return this.mCurrentPlayerVolume;
    }

    public float getVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamVolume = audioManager != null ? audioManager.getStreamVolume(3) : 0;
        return streamVolume >= 0 ? streamVolume : 0;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        if (mediaPlayer.isOSPlayer()) {
            return getVolume() < 0.001f;
        }
        return this.mPlayer.isMute();
    }

    public void setMute(boolean z) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (!mediaPlayer.isOSPlayer()) {
            this.mPlayer.setIsMute(z);
            return;
        }
        float maxVolume = getMaxVolume();
        if (maxVolume > 0.0f) {
            this.mLastVolume = getVolume() / maxVolume;
        }
        if (z) {
            this.mPlayer.setVolume(0.0f, 0.0f);
            return;
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        float f = this.mLastVolume;
        mediaPlayer2.setVolume(f, f);
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000a A[PHI: r1
      0x000a: PHI (r1v2 float) = (r1v0 float), (r1v1 float) binds: [B:6:0x0008, B:9:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    public void setPlayerVolume(float f) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        float f2 = 0.0f;
        if (f < 0.0f) {
            f = f2;
        } else {
            f2 = 1.0f;
            if (f > 1.0f) {
                f = f2;
            }
        }
        this.mCurrentPlayerVolume = f;
        mediaPlayer.setVolume(f, f);
    }

    public void setVolume(float f) {
        AudioManager audioManager;
        if (this.mPlayer == null || (audioManager = (AudioManager) this.mContext.getSystemService("audio")) == null) {
            return;
        }
        audioManager.setStreamVolume(3, (int) f, 0);
    }
}
