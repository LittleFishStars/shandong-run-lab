package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AudioFocusManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30473a = "AudioFocusManager";
    public static final float b = 0.2f;
    public static final float c = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f1975c = -1;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f1976a = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1977a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AudioFocusRequest f1978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioManager f1979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PlayerControl f1980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f1981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.audio.a f1982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1983a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1984b;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void executePlayerCommand(int i);

        void setVolumeMultiplier(float f);
    }

    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30474a;

        public a(Handler handler) {
            this.f30474a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i) {
            AudioFocusManager.this.i(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.f30474a.post(new Runnable() { // from class: com.zj.adlib.ue0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45125a.b(i);
                }
            });
        }
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl) {
        this.f1979a = (AudioManager) sb0.g((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f1980a = playerControl;
        this.f1981a = new a(handler);
    }

    public static int e(@Nullable com.google.android.exoplayer2.audio.a aVar) {
        if (aVar == null) {
            return 0;
        }
        switch (aVar.M) {
            case 0:
                Log.n(f30473a, "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (aVar.K == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                Log.n(f30473a, "Unidentified audio usage: " + aVar.M);
                return 0;
            case 16:
                return gj9.f41922a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        this.f1979a.abandonAudioFocus(this.f1981a);
    }

    public final void b() {
        if (this.f1977a == 0) {
            return;
        }
        if (gj9.f41922a >= 26) {
            c();
        } else {
            a();
        }
        o(0);
    }

    @RequiresApi(26)
    public final void c() {
        AudioFocusRequest audioFocusRequest = this.f1978a;
        if (audioFocusRequest != null) {
            this.f1979a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i2) {
        PlayerControl playerControl = this.f1980a;
        if (playerControl != null) {
            playerControl.executePlayerCommand(i2);
        }
    }

    @VisibleForTesting
    public AudioManager.OnAudioFocusChangeListener g() {
        return this.f1981a;
    }

    public float h() {
        return this.f1976a;
    }

    public final void i(int i2) {
        if (i2 == -3 || i2 == -2) {
            if (i2 != -2 && !r()) {
                o(3);
                return;
            } else {
                f(0);
                o(2);
                return;
            }
        }
        if (i2 == -1) {
            f(-1);
            b();
        } else if (i2 == 1) {
            o(1);
            f(1);
        } else {
            Log.n(f30473a, "Unknown focus change type: " + i2);
        }
    }

    public void j() {
        this.f1980a = null;
        b();
    }

    public final int k() {
        if (this.f1977a == 1) {
            return 1;
        }
        if ((gj9.f41922a >= 26 ? m() : l()) == 1) {
            o(1);
            return 1;
        }
        o(0);
        return -1;
    }

    public final int l() {
        return this.f1979a.requestAudioFocus(this.f1981a, gj9.r0(((com.google.android.exoplayer2.audio.a) sb0.g(this.f1982a)).M), this.f1984b);
    }

    @RequiresApi(26)
    public final int m() {
        AudioFocusRequest audioFocusRequest = this.f1978a;
        if (audioFocusRequest == null || this.f1983a) {
            this.f1978a = (audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f1984b) : new AudioFocusRequest.Builder(this.f1978a)).setAudioAttributes(((com.google.android.exoplayer2.audio.a) sb0.g(this.f1982a)).b().f30558a).setWillPauseWhenDucked(r()).setOnAudioFocusChangeListener(this.f1981a).build();
            this.f1983a = false;
        }
        return this.f1979a.requestAudioFocus(this.f1978a);
    }

    public void n(@Nullable com.google.android.exoplayer2.audio.a aVar) {
        if (gj9.c(this.f1982a, aVar)) {
            return;
        }
        this.f1982a = aVar;
        int iE = e(aVar);
        this.f1984b = iE;
        boolean z = true;
        if (iE != 1 && iE != 0) {
            z = false;
        }
        sb0.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void o(int i2) {
        if (this.f1977a == i2) {
            return;
        }
        this.f1977a = i2;
        float f2 = i2 == 3 ? 0.2f : 1.0f;
        if (this.f1976a == f2) {
            return;
        }
        this.f1976a = f2;
        PlayerControl playerControl = this.f1980a;
        if (playerControl != null) {
            playerControl.setVolumeMultiplier(f2);
        }
    }

    public final boolean p(int i2) {
        return i2 == 1 || this.f1984b != 1;
    }

    public int q(boolean z, int i2) {
        if (p(i2)) {
            b();
            return z ? 1 : -1;
        }
        if (z) {
            return k();
        }
        return -1;
    }

    public final boolean r() {
        com.google.android.exoplayer2.audio.a aVar = this.f1982a;
        return aVar != null && aVar.K == 1;
    }
}
