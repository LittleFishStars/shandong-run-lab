package cj.mobile.wm;

import android.content.Context;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class xb implements AudioManager.OnAudioFocusChangeListener {
    public final WeakReference<Context> dexa;
    public final yb dexb;
    public final qb dexc;
    public boolean dexd = true;

    public xb(WeakReference<Context> weakReference, yb ybVar, qb qbVar) {
        this.dexa = weakReference;
        this.dexb = ybVar;
        this.dexc = qbVar;
    }

    public int dexa(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (int) ((audioManager.getStreamVolume(3) * 1.0f) / audioManager.getStreamMaxVolume(3));
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        Context context;
        if (this.dexc == null || (context = this.dexa.get()) == null) {
            return;
        }
        if (1 == i) {
            if (this.dexd && !this.dexc.e()) {
                this.dexc.start();
            } else if (this.dexc.e()) {
                this.dexc.dexa(dexa(context));
            }
            this.dexd = false;
            return;
        }
        if (-3 == i) {
            this.dexc.dexa(dexa(context) * 0.8f);
            return;
        }
        if (-2 == i) {
            if (this.dexc.e()) {
                this.dexd = true;
                this.dexc.a();
                return;
            }
            return;
        }
        if (-1 == i) {
            this.dexb.b();
            this.dexd = false;
            this.dexc.stop();
        }
    }
}
