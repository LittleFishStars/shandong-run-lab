package cj.mobile.wm;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class zb implements yb {
    public final Context dexa;
    public final qb dexb;
    public AudioManager dexc;
    public AudioAttributes dexd = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    public AudioFocusRequest dexe;
    public final AudioManager.OnAudioFocusChangeListener dexf;

    public zb(Context context, qb qbVar) {
        this.dexa = context;
        this.dexb = qbVar;
        this.dexc = (AudioManager) context.getSystemService("audio");
        this.dexf = new xb(new WeakReference(context), this, qbVar);
    }

    @Override // cj.mobile.wm.yb
    public void a() {
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(this.dexd).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.dexf).build();
        this.dexe = audioFocusRequestBuild;
        this.dexc.requestAudioFocus(audioFocusRequestBuild);
    }

    @Override // cj.mobile.wm.yb
    public void b() {
        AudioFocusRequest audioFocusRequest = this.dexe;
        if (audioFocusRequest != null) {
            this.dexc.abandonAudioFocusRequest(audioFocusRequest);
        }
    }
}
