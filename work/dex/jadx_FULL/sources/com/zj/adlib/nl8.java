package com.zj.adlib;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class nl8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile nl8 f43551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f18445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SoundPool f18446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Integer> f18449a;
    public List<b> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18451b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f18447a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18450a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f18448a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f18443a = 1.0f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Handler f18452a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Vibrator f18453a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public b f18454a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f18456a = {100, 2000, 1000, 1000, 3000};

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f18455a = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43552a = 0;

        public a(int soundId, long repeatTime, boolean needVibrate) {
            b bVar = new b(soundId, repeatTime);
            this.f18454a = bVar;
            bVar.b = needVibrate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(SoundPool soundPool) {
            h(soundPool);
            nl8.f43551a.f18448a = null;
        }

        public final Vibrator c() {
            if (this.f18453a == null) {
                this.f18453a = (Vibrator) Utils.a().getSystemService("vibrator");
            }
            return this.f18453a;
        }

        public boolean e(SoundPool soundPool, int sampleId, int status) {
            b bVar = this.f18454a;
            if (bVar == null || sampleId != bVar.f43553a) {
                return false;
            }
            if (status == 0) {
                this.f18455a = true;
            }
            return true;
        }

        public void f(SoundPool soundPool) {
            c().cancel();
            int i = this.f43552a;
            if (i == 0) {
                return;
            }
            soundPool.pause(i);
        }

        public void g(final SoundPool soundPool) {
            b bVar = this.f18454a;
            if (bVar == null) {
                return;
            }
            if (bVar.b) {
                try {
                    if (c().hasVibrator()) {
                        c().vibrate(VibrationEffect.createWaveform(this.f18456a, 0), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                    }
                } catch (Exception e) {
                    i4a.c("播放异常:" + e.getMessage());
                }
            }
            if (soundPool == null || !this.f18455a) {
                return;
            }
            int i = this.f43552a;
            if (i == 0) {
                this.f43552a = soundPool.play(this.f18454a.f43553a, 1.0f, 1.0f, 0, -1, 1.0f);
            } else {
                soundPool.resume(i);
            }
            if (this.f43552a == 0 || this.f18454a.f18457a <= 0) {
                return;
            }
            this.f18452a.postDelayed(new Runnable() { // from class: com.zj.adlib.ml8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18254a.d(soundPool);
                }
            }, this.f18454a.f18457a);
        }

        public void h(SoundPool soundPool) {
            c().cancel();
            int i = this.f43552a;
            if (i == 0) {
                return;
            }
            soundPool.stop(i);
            this.f43552a = 0;
            this.f18454a = null;
        }
    }

    public nl8(Context context) {
        g(context.getApplicationContext());
    }

    public static nl8 e(Context context) {
        if (f43551a == null) {
            synchronized (nl8.class) {
                if (f43551a == null) {
                    f43551a = new nl8(context);
                }
            }
        }
        return f43551a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(SoundPool soundPool, int i, int i2) {
        b next;
        a aVar = this.f18448a;
        if (aVar != null && aVar.e(soundPool, i, i2)) {
            l();
            return;
        }
        if (CollectionUtils.r(this.b)) {
            return;
        }
        Iterator<b> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && i == next.f43553a) {
                break;
            }
        }
        if (next == null) {
            return;
        }
        j();
        if (next.f18458a) {
            p(next);
        } else {
            k(next);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        if (!this.b.isEmpty()) {
            k(this.b.get(0));
        } else {
            this.f18450a = true;
            l();
        }
    }

    public final long f(int rawId) {
        int duration = 1000;
        try {
            MediaPlayer mediaPlayerCreate = MediaPlayer.create(this.f18445a, rawId);
            if (mediaPlayerCreate != null) {
                duration = mediaPlayerCreate.getDuration();
                mediaPlayerCreate.stop();
                mediaPlayerCreate.reset();
                mediaPlayerCreate.release();
            }
        } catch (Exception unused) {
        }
        return duration;
    }

    public void g(Context context) {
        this.f18445a = context;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(10);
        builder.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).build());
        SoundPool soundPoolBuild = builder.build();
        this.f18446a = soundPoolBuild;
        soundPoolBuild.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.zj.adlib.ll8
            @Override // android.media.SoundPool.OnLoadCompleteListener
            public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                this.f43097a.h(soundPool, i, i2);
            }
        });
    }

    public final void j() {
        a aVar = this.f18448a;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f18446a);
    }

    public final void k(b sound) {
        this.b.remove(sound);
        SoundPool soundPool = this.f18446a;
        if (soundPool == null) {
            return;
        }
        int iPlay = soundPool.play(sound.f43553a, 1.0f, 1.0f, 1, 0, 1.0f);
        this.f18444a = iPlay;
        if (iPlay != 0) {
            if (sound.f18458a) {
                return;
            }
            n(sound);
        } else if (this.b.isEmpty()) {
            this.f18450a = true;
            l();
        }
    }

    public final void l() {
        if (this.f18451b || this.f18448a == null) {
            return;
        }
        List<Integer> list = this.f18449a;
        if ((list == null || list.isEmpty()) && this.f18450a) {
            this.f18448a.g(this.f18446a);
        }
    }

    public void m(int rawId, long repeatTime, boolean needVibrate) {
        a aVar = new a(this.f18446a.load(this.f18445a, rawId, 1), repeatTime, needVibrate);
        this.f18448a = aVar;
        aVar.f18452a = this.f18447a;
    }

    public final void n(b sound) {
        this.f18447a.postDelayed(new Runnable() { // from class: com.zj.adlib.kl8
            @Override // java.lang.Runnable
            public final void run() {
                this.f42852a.i();
            }
        }, sound.f18457a);
    }

    public void o(int rawId) {
        if (this.f18451b) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(new b(this.f18446a.load(this.f18445a, rawId, 0), true));
    }

    public final void p(b sound) {
        this.b.remove(sound);
        if (this.f18446a == null) {
            return;
        }
        if (this.f18449a == null) {
            this.f18449a = new ArrayList();
        }
        int iPlay = this.f18446a.play(sound.f43553a, 1.0f, 1.0f, 0, -1, 1.0f);
        if (iPlay != 0) {
            this.f18449a.add(Integer.valueOf(iPlay));
        }
    }

    public void q(int... rawIds) {
        if (this.f18451b) {
            return;
        }
        v(false);
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        for (int i : rawIds) {
            this.b.add(new b(this.f18446a.load(this.f18445a, i, 1), f(i)));
        }
        this.f18450a = false;
    }

    public void r() {
        this.f18447a.removeCallbacksAndMessages(null);
        this.f18446a.release();
        this.f18446a = null;
        f43551a = null;
    }

    public void s(boolean isSilent, boolean needStop) {
        this.f18451b = isSilent;
        if (needStop) {
            u();
        }
    }

    public void t() {
        a aVar = this.f18448a;
        if (aVar == null) {
            return;
        }
        aVar.h(this.f18446a);
        this.f18448a = null;
    }

    public void u() {
        v(true);
        t();
    }

    public void v(boolean stopRepeat) {
        try {
            this.f18446a.stop(this.f18444a);
            this.f18447a.removeCallbacksAndMessages(null);
            if (stopRepeat) {
                if (CollectionUtils.t(this.f18449a)) {
                    Iterator<Integer> it = this.f18449a.iterator();
                    while (it.hasNext()) {
                        this.f18446a.stop(it.next().intValue());
                    }
                    this.f18449a.clear();
                }
                this.f18446a.autoPause();
            }
            this.f18450a = true;
            l();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43553a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f18457a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f18458a;
        public boolean b;

        public b(int id, long time) {
            this.f18458a = false;
            this.b = false;
            this.f43553a = id;
            this.f18457a = time;
        }

        public b(int id, boolean repeat) {
            this.b = false;
            this.f43553a = id;
            this.f18458a = repeat;
        }
    }
}
