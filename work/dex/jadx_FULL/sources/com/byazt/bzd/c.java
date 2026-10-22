package com.byazt.bzd;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 20})
public class c {
    public AudioAttributes c;
    public boolean n;
    public AudioFocusRequest tt;
    public AudioManager.OnAudioFocusChangeListener uj;
    public AudioManager ve;

    public c() {
        this.n = false;
        boolean zHd = gt.tt().hd();
        this.n = zHd;
        if (zHd) {
            this.uj = new AudioManager.OnAudioFocusChangeListener() { // from class: com.byazt.bzd.c.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.ve = (AudioManager) gt.getContext().getSystemService("audio");
        }
    }

    public int c() {
        if (!this.n) {
            return -1;
        }
        this.c = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.uj).setAudioAttributes(this.c).build();
        this.tt = audioFocusRequestBuild;
        AudioManager audioManager = this.ve;
        if (audioManager != null) {
            return audioManager.requestAudioFocus(audioFocusRequestBuild);
        }
        return -1;
    }

    public void tt() {
        AudioManager audioManager;
        if (this.n && (audioManager = this.ve) != null) {
            audioManager.abandonAudioFocusRequest(this.tt);
        }
    }
}
