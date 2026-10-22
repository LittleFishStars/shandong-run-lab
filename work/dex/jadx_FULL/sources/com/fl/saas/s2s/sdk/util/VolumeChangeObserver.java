package com.fl.saas.s2s.sdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.google.android.exoplayer2.StreamVolumeManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class VolumeChangeObserver {
    private AudioManager audioManager;
    private Context context;
    private int lastVolume;
    private VolumeChangeListener listener;
    private BroadcastReceiver volumeReceiver = new BroadcastReceiver() { // from class: com.fl.saas.s2s.sdk.util.VolumeChangeObserver.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(StreamVolumeManager.b)) {
                int streamVolume = VolumeChangeObserver.this.audioManager.getStreamVolume(3);
                VolumeChangeObserver.this.audioManager.getStreamMaxVolume(3);
                if (streamVolume != VolumeChangeObserver.this.lastVolume) {
                    VolumeChangeObserver.this.lastVolume = streamVolume;
                    boolean z = streamVolume == 0;
                    if (VolumeChangeObserver.this.listener != null) {
                        VolumeChangeObserver.this.listener.onVolumeChanged(streamVolume, z);
                    }
                }
            }
        }
    };

    public interface VolumeChangeListener {
        void onVolumeChanged(int i, boolean z);
    }

    public VolumeChangeObserver(Context context) {
        this.context = context;
        this.audioManager = (AudioManager) context.getSystemService("audio");
    }

    public void start(VolumeChangeListener volumeChangeListener) {
        this.listener = volumeChangeListener;
        this.lastVolume = this.audioManager.getStreamVolume(3);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(StreamVolumeManager.b);
        this.context.registerReceiver(this.volumeReceiver, intentFilter);
    }

    public void stop() {
        try {
            this.context.unregisterReceiver(this.volumeReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
