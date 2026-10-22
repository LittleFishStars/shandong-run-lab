package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huachenjie.im.audio.ImAudioRecordCallback;
import com.netease.nimlib.sdk.media.record.AudioRecorder;
import com.netease.nimlib.sdk.media.record.IAudioRecordCallback;
import com.netease.nimlib.sdk.media.record.RecordType;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class g64 implements IAudioRecordCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g64 f41829a = null;
    public static int b = 10;
    public static int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f16708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImAudioRecordCallback f16709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AudioRecorder f16710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f16711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16707a = 30;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f16712a = new a();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f16713b = new b();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Runnable f16714c = new c();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g64.this.f16708a.post(g64.this.f16713b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g64.this.f16708a.postDelayed(g64.this.f16713b, 1000L);
            if (g64.this.f16709a != null) {
                ImAudioRecordCallback imAudioRecordCallback = g64.this.f16709a;
                int i = g64.b;
                g64.b = i - 1;
                imAudioRecordCallback.b(i);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g64.this.f16708a.postDelayed(g64.this.f16714c, 1000L);
            g64.c++;
            if (g64.this.f16709a != null) {
                g64.this.f16709a.c(g64.c);
            }
        }
    }

    public static g64 k() {
        g64 g64Var;
        synchronized (g64.class) {
            if (f41829a == null) {
                f41829a = new g64();
            }
            g64Var = f41829a;
        }
        return g64Var;
    }

    public void i(boolean z) {
        AudioRecorder audioRecorder = this.f16710a;
        if (audioRecorder == null) {
            return;
        }
        audioRecorder.completeRecord(z);
    }

    public void j() {
        this.f16709a = null;
        AudioRecorder audioRecorder = this.f16710a;
        if (audioRecorder != null) {
            audioRecorder.destroyAudioRecorder();
        }
        this.f16710a = null;
        Handler handler = this.f16708a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f16708a = null;
        this.f16709a = null;
    }

    public final void l(Context context) {
        if (this.f16710a == null) {
            this.f16710a = new AudioRecorder(context, RecordType.AAC, this.f16707a, this);
        }
        if (this.f16708a == null) {
            this.f16708a = new Handler(Looper.getMainLooper());
        }
    }

    public boolean m() {
        AudioRecorder audioRecorder = this.f16710a;
        if (audioRecorder == null) {
            return false;
        }
        return audioRecorder.isRecording();
    }

    public void n(File file, long j) {
        this.f16708a.removeCallbacks(this.f16714c);
        this.f16708a.removeCallbacks(this.f16712a);
        this.f16708a.removeCallbacks(this.f16713b);
        ImAudioRecordCallback imAudioRecordCallback = this.f16709a;
        if (imAudioRecordCallback != null) {
            imAudioRecordCallback.d(file, j);
        }
    }

    public void o(Context context, int i, ImAudioRecordCallback imAudioRecordCallback) {
        this.f16707a = i;
        l(context);
        if (this.f16710a.isRecording()) {
            this.f16710a.completeRecord(true);
        }
        b = 10;
        c = 0;
        this.f16709a = imAudioRecordCallback;
        this.f16710a.startRecord();
    }

    public void onRecordCancel() {
        i4a.a("onRecordCancel:");
        n(null, -2L);
    }

    public void onRecordFail() {
        i4a.a("onRecordFail:");
        n(null, -1L);
    }

    public void onRecordReachedMaxTime(int i) {
        i4a.a("onRecordReachedMaxTime:" + i);
        n(this.f16711a, (long) i);
    }

    public void onRecordReady() {
        i4a.a("onRecordReady:");
    }

    public void onRecordStart(File file, RecordType recordType) {
        i4a.a("onRecordStart:");
        this.f16711a = file;
        this.f16708a.postDelayed(this.f16714c, 1000L);
        this.f16708a.postDelayed(this.f16712a, ((long) (this.f16707a - b)) * 1000);
        ImAudioRecordCallback imAudioRecordCallback = this.f16709a;
        if (imAudioRecordCallback != null) {
            imAudioRecordCallback.a();
        }
    }

    public void onRecordSuccess(File file, long j, RecordType recordType) {
        i4a.a("onRecordSuccess:" + j);
        n(file, j);
    }

    public void p(Context context, ImAudioRecordCallback imAudioRecordCallback) {
        o(context, 30, imAudioRecordCallback);
    }
}
