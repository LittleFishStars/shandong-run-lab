package com.alibaba.triver.audio;

import android.media.MediaPlayer;
import android.util.Log;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24670a = "GlobalAudioPlayer";
    private static final String b = "onBackgroundAudioCanPlay";
    private static final String c = "onBackgroundAudioPlay";
    private static final String d = "onBackgroundAudioPause";
    private static final String e = "onBackgroundAudioStop";
    private static final String f = "onBackgroundAudioEnded";
    private static final String g = "onBackgroundAudioTimeUpdate";
    private static final String h = "onBackgroundAudioError";
    private static final String i = "onBackgroundAudioWaiting";
    private static final String j = "onBackgroundAudioSeeking";
    private static final String k = "onBackgroundAudioSeeked";
    private static b l;
    private MediaPlayer m;
    private int n;
    private a p;
    private ApiContext r;
    private int o = 0;
    private boolean q = false;
    private Timer s = null;

    private b() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.m = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.m.setOnPreparedListener(this);
        this.m.setOnErrorListener(this);
        this.m.setOnBufferingUpdateListener(this);
        this.m.setOnCompletionListener(this);
        this.m.setOnSeekCompleteListener(this);
    }

    public static synchronized b g() {
        if (l == null) {
            l = new b();
        }
        return l;
    }

    @Override // com.alibaba.triver.audio.c
    public boolean b() {
        try {
            MediaPlayer mediaPlayer = this.m;
            return mediaPlayer != null && mediaPlayer.isPlaying();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return false;
        }
    }

    @Override // com.alibaba.triver.audio.c
    public void c() {
        try {
            this.m.pause();
            this.q = true;
            a(d, new JSONObject());
            i();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.triver.audio.c
    public void d() {
        try {
            this.m.stop();
            a(e, new JSONObject());
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
        this.q = false;
        e();
    }

    @Override // com.alibaba.triver.audio.c
    public void e() {
        try {
            i();
            this.m.reset();
            this.n = 0;
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.triver.audio.c
    public void f() {
    }

    public void h() {
        Timer timer = this.s;
        if (timer != null) {
            timer.cancel();
        } else {
            this.s = new Timer();
        }
        try {
            this.s.schedule(new TimerTask() { // from class: com.alibaba.triver.audio.b.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (b.this.m == null) {
                        return;
                    }
                    try {
                        int currentPosition = b.this.m.getCurrentPosition();
                        int duration = b.this.m.getDuration();
                        JSONObject jSONObject = new JSONObject();
                        int i2 = 0;
                        jSONObject.put("currentTime", (Object) Integer.valueOf(currentPosition == 0 ? 0 : currentPosition / 1000));
                        if (duration != 0) {
                            i2 = duration / 1000;
                        }
                        jSONObject.put("duration", (Object) Integer.valueOf(i2));
                        b.this.a(b.g, jSONObject);
                    } catch (Exception e2) {
                        RVLogger.w(Log.getStackTraceString(e2));
                    }
                }
            }, 0L, 1000L);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f24670a, "start timer error : " + e2.getMessage());
        }
    }

    public void i() {
        Timer timer = this.s;
        if (timer != null) {
            timer.cancel();
            this.s = null;
        }
    }

    public int j() {
        return this.n;
    }

    public int k() {
        try {
            return this.m.getDuration();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return 0;
        }
    }

    public int l() {
        try {
            return this.m.getCurrentPosition();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return 0;
        }
    }

    public a m() {
        if (this.p == null) {
            this.p = new a();
        }
        return this.p;
    }

    public void n() {
        this.p = null;
    }

    public void o() {
        try {
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.n = i2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        a(f, new JSONObject());
        i();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        String str;
        String str2 = i2 == 1 ? "UNKNOWN_ERROR" : "SERVER_DIED";
        if (i3 == -1010) {
            str = "ERROR_UNSUPPORTED";
        } else if (i3 == -1007) {
            str = "ERROR_MALFORMED";
        } else if (i3 == -1004) {
            str = "IO_ERROR";
        } else if (i3 != -110) {
            str = "error code , what is : " + i2 + "   extra is :" + i3;
        } else {
            str = "TIMED_OUT_ERROR";
        }
        a(str2 + "\t" + str);
        i();
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            if (b()) {
                return;
            }
            a(b, new JSONObject());
            mediaPlayer.start();
            a(c, new JSONObject());
            h();
            mediaPlayer.seekTo(this.o);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f24670a, "onPrepared Error : " + e2.getMessage());
            i();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        a(k, new JSONObject());
    }

    public int p() {
        return this.o;
    }

    public boolean q() {
        return this.q;
    }

    public ApiContext r() {
        return this.r;
    }

    public void a(ApiContext apiContext) {
        this.r = apiContext;
    }

    @Override // com.alibaba.triver.audio.c
    public void a(a aVar) {
        try {
            if ((q() || b()) && !this.p.equals(aVar)) {
                d();
            }
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f24670a, "play new audio , stop error : " + e2.getMessage());
        }
        this.p = aVar;
        a();
    }

    public void b(int i2) {
        this.o = i2;
    }

    @Override // com.alibaba.triver.audio.c
    public void a() {
        String str;
        try {
            if (this.m == null) {
                return;
            }
            if (b()) {
                c();
                return;
            }
            if (this.q) {
                this.m.start();
                this.q = false;
                a(c, new JSONObject());
                h();
                return;
            }
            a aVar = this.p;
            if (aVar == null || (str = aVar.c) == null) {
                return;
            }
            this.m.setDataSource(str);
            this.m.prepareAsync();
            this.n = 0;
            a(i, new JSONObject());
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.triver.audio.c
    public void a(int i2) {
        try {
            this.m.seekTo(i2 * 1000);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (this.r == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        this.r.sendEvent(str, jSONObject2, null);
    }

    public void a(String str) {
        if (this.r == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        this.r.sendEvent(h, jSONObject2, null);
    }
}
