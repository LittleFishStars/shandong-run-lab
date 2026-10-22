package com.fl.saas.base.inner.interstitial.coustomView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface VideoSoundControlListener {

    public interface SoundControlViewStateChangeListener {
        void changeViewVisible(boolean z);
    }

    void changeSoundEnable(boolean z);

    boolean getSoundEnable();

    void setSoundControlViewStateChangeListener(SoundControlViewStateChangeListener soundControlViewStateChangeListener);
}
