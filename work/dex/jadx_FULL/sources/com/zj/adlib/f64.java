package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.netease.nimlib.sdk.media.player.AudioPlayer;
import com.netease.nimlib.sdk.media.player.OnPlayListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class f64 implements OnPlayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f64 f41606a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f16475a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImAudioPlayCallback f16476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AudioPlayer f16477a;

    public static f64 b() {
        f64 f64Var;
        synchronized (f64.class) {
            if (f41606a == null) {
                f41606a = new f64();
            }
            f64Var = f41606a;
        }
        return f64Var;
    }

    public void a() {
        g();
        this.f16476a = null;
        AudioPlayer audioPlayer = this.f16477a;
        if (audioPlayer != null) {
            if (audioPlayer.isPlaying()) {
                this.f16477a.stop();
            }
            this.f16477a = null;
        }
    }

    public String c() {
        String str = f16475a;
        return str == null ? "" : str;
    }

    public final void d(Context context) {
        if (this.f16477a == null) {
            AudioPlayer audioPlayer = new AudioPlayer(context);
            this.f16477a = audioPlayer;
            audioPlayer.setOnPlayListener(this);
        }
    }

    public boolean e() {
        AudioPlayer audioPlayer = this.f16477a;
        if (audioPlayer != null) {
            return audioPlayer.isPlaying();
        }
        return false;
    }

    public boolean f(String str) {
        if (this.f16477a == null || TextUtils.isEmpty(str) || !str.equals(f16475a)) {
            return false;
        }
        return this.f16477a.isPlaying();
    }

    public final void g() {
        h(c());
        f16475a = "";
    }

    public final void h(String str) {
        ImAudioPlayCallback imAudioPlayCallback = this.f16476a;
        if (imAudioPlayCallback == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        imAudioPlayCallback.a(str);
    }

    public void i(Context context, String str, String str2, ImAudioPlayCallback imAudioPlayCallback) {
        d(context);
        if (f16475a.equals(str2) && this.f16477a.isPlaying()) {
            this.f16477a.stop();
            return;
        }
        if (this.f16477a.isPlaying()) {
            h(f16475a);
        }
        f16475a = str2;
        this.f16476a = imAudioPlayCallback;
        this.f16477a.setDataSource(str);
        this.f16477a.start(3);
    }

    public void j() {
        AudioPlayer audioPlayer = this.f16477a;
        if (audioPlayer == null || !audioPlayer.isPlaying()) {
            return;
        }
        this.f16477a.stop();
    }

    public void k(String str) {
        AudioPlayer audioPlayer = this.f16477a;
        if (audioPlayer != null && audioPlayer.isPlaying() && !TextUtils.isEmpty(str) && str.equals(f16475a)) {
            this.f16477a.stop();
        }
    }

    public void onCompletion() {
        g();
    }

    public void onError(String str) {
        g();
    }

    public void onInterrupt() {
        g();
    }

    public void onPlaying(long j) {
    }

    public void onPrepared() {
        ImAudioPlayCallback imAudioPlayCallback = this.f16476a;
        if (imAudioPlayCallback == null) {
            return;
        }
        imAudioPlayCallback.b(c());
    }
}
