package com.byazt.wee;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1009, 20})
public class c {
    public final AudioManager tt;
    public int c = -1;
    public int ve = -1;
    public int uj = -1;
    public final int n = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29158a = 0;

    public c(Context context) {
        this.tt = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    private boolean a() {
        return this.tt.isWiredHeadsetOn() && this.tt.isBluetoothA2dpOn();
    }

    private boolean n() {
        for (AudioDeviceInfo audioDeviceInfo : this.tt.getDevices(3)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 8 || type == 7) {
                return true;
            }
        }
        return false;
    }

    public int c() {
        try {
            int i = this.uj;
            if (i != -1) {
                return i;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                AudioManager audioManager = this.tt;
                this.uj = audioManager != null ? audioManager.getStreamMinVolume(3) : 0;
            } else {
                this.uj = 0;
            }
            return this.uj;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int tt() {
        try {
            int i = this.ve;
            if (i != -1) {
                return i;
            }
            AudioManager audioManager = this.tt;
            int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : 15;
            this.ve = streamMaxVolume;
            return streamMaxVolume;
        } catch (Throwable unused) {
            return 15;
        }
    }

    public boolean uj() {
        return Build.VERSION.SDK_INT < 31 ? a() : n();
    }

    public int ve() {
        try {
            AudioManager audioManager = this.tt;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public int c(int i) {
        AudioManager audioManager = this.tt;
        if (audioManager == null) {
            return -1;
        }
        audioManager.setStreamVolume(3, i, 0);
        ve();
        return i;
    }
}
