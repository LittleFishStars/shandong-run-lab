package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class StreamVolumeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30505a = "StreamVolumeManager";
    public static final String b = "android.media.VOLUME_CHANGED_ACTION";
    public static final int c = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioManager f2183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f2184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f2185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public VolumeChangeReceiver f2186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2187a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2188b;

    public interface Listener {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    public final class VolumeChangeReceiver extends BroadcastReceiver {
        public VolumeChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = StreamVolumeManager.this.f2184a;
            final StreamVolumeManager streamVolumeManager = StreamVolumeManager.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.n
                @Override // java.lang.Runnable
                public final void run() {
                    StreamVolumeManager.b(streamVolumeManager);
                }
            });
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.f2182a = applicationContext;
        this.f2184a = handler;
        this.f2185a = listener;
        AudioManager audioManager = (AudioManager) sb0.k((AudioManager) applicationContext.getSystemService("audio"));
        this.f2183a = audioManager;
        this.f2181a = 3;
        this.f2188b = h(audioManager, 3);
        this.f2187a = f(audioManager, this.f2181a);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter(b));
            this.f2186a = volumeChangeReceiver;
        } catch (RuntimeException e) {
            Log.o(f30505a, "Error registering stream volume receiver", e);
        }
    }

    public static /* synthetic */ void b(StreamVolumeManager streamVolumeManager) {
        streamVolumeManager.o();
    }

    public static boolean f(AudioManager audioManager, int i) {
        if (gj9.f41922a >= 23) {
            return audioManager.isStreamMute(i);
        }
        return h(audioManager, i) == 0;
    }

    public static int h(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            Log.o(f30505a, "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public void c() {
        if (this.f2188b <= e()) {
            return;
        }
        this.f2183a.adjustStreamVolume(this.f2181a, -1, 1);
        o();
    }

    public int d() {
        return this.f2183a.getStreamMaxVolume(this.f2181a);
    }

    public int e() {
        if (gj9.f41922a >= 28) {
            return this.f2183a.getStreamMinVolume(this.f2181a);
        }
        return 0;
    }

    public int g() {
        return this.f2188b;
    }

    public void i() {
        if (this.f2188b >= d()) {
            return;
        }
        this.f2183a.adjustStreamVolume(this.f2181a, 1, 1);
        o();
    }

    public boolean j() {
        return this.f2187a;
    }

    public void k() {
        VolumeChangeReceiver volumeChangeReceiver = this.f2186a;
        if (volumeChangeReceiver != null) {
            try {
                this.f2182a.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e) {
                Log.o(f30505a, "Error unregistering stream volume receiver", e);
            }
            this.f2186a = null;
        }
    }

    public void l(boolean z) {
        if (gj9.f41922a >= 23) {
            this.f2183a.adjustStreamVolume(this.f2181a, z ? -100 : 100, 1);
        } else {
            this.f2183a.setStreamMute(this.f2181a, z);
        }
        o();
    }

    public void m(int i) {
        if (this.f2181a == i) {
            return;
        }
        this.f2181a = i;
        o();
        this.f2185a.onStreamTypeChanged(i);
    }

    public void n(int i) {
        if (i < e() || i > d()) {
            return;
        }
        this.f2183a.setStreamVolume(this.f2181a, i, 1);
        o();
    }

    public final void o() {
        int iH = h(this.f2183a, this.f2181a);
        boolean zF = f(this.f2183a, this.f2181a);
        if (this.f2188b == iH && this.f2187a == zF) {
            return;
        }
        this.f2188b = iH;
        this.f2187a = zF;
        this.f2185a.onStreamVolumeChanged(iH, zF);
    }
}
