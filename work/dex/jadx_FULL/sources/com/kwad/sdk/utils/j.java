package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class j {
    private AudioManager aZy;
    private AudioManager.OnAudioFocusChangeListener bov = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.j.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (j.this.kF == null) {
                return;
            }
            by.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.j.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        j.this.kF.onAudioBeOccupied();
                    } else {
                        j.this.kF.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a kF;

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public j(Context context) {
        this.aZy = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest Uu() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.bov).build();
    }

    public final boolean Ut() {
        AudioManager audioManager;
        try {
            return (this.bov == null || (audioManager = this.aZy) == null || 1 != audioManager.requestAudioFocus(Uu())) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public final void c(a aVar) {
        this.kF = aVar;
    }
}
