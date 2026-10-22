package com.aliyun.svideosdk.recorder.impl.h;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import com.aliyun.svideosdk.common.AliyunRecordAudioSource;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import com.google.android.exoplayer2.source.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25855a = 50;
    private boolean b = false;
    private InterfaceC0241a c;
    private OnAudioCallBack d;
    private int e;
    private AudioRecord f;
    private byte[] g;
    private byte[] h;
    private NativeRecorder i;
    private Handler j;
    private HandlerThread k;
    private b l;
    private AliyunRecordAudioSource m;
    private volatile boolean n;

    /* JADX INFO: renamed from: com.aliyun.svideosdk.recorder.impl.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0241a {
        void a(long j);
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f25856a;

        /* JADX INFO: renamed from: com.aliyun.svideosdk.recorder.impl.h.a$b$a, reason: collision with other inner class name */
        public class RunnableC0242a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f25857a;

            public RunnableC0242a(int i) {
                this.f25857a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d != null) {
                    if (a.this.b) {
                        a.this.d.onAudioDataBack(a.this.h, this.f25857a);
                    } else {
                        a.this.d.onAudioDataBackInPreview(a.this.h, this.f25857a);
                    }
                }
            }
        }

        public b(String str) {
            super(str);
        }

        public void a() {
            this.f25856a = System.nanoTime();
            if (a.this.c != null) {
                a.this.c.a(this.f25856a);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            while (!a.this.n) {
                try {
                    i = a.this.f.read(a.this.g, 0, a.this.e);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i <= 0) {
                    i = a.this.e;
                    try {
                        Thread.sleep(a.this.f25855a);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                long jNanoTime = (System.nanoTime() - this.f25856a) / 1000;
                synchronized (this) {
                    if (a.this.i != null && a.this.m != null && a.this.b) {
                        a.this.i.addAudioBuffer(a.this.m, a.this.g, i);
                    }
                    if (a.this.j != null && a.this.d != null) {
                        System.arraycopy(a.this.g, 0, a.this.h, 0, a.this.e);
                        a.this.j.post(new RunnableC0242a(i));
                    }
                }
            }
            this.f25856a = 0L;
            a.this.n = false;
        }
    }

    private void d() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
    }

    public AliyunRecordAudioSource a() {
        if (this.m == null) {
            this.m = AliyunRecordAudioSource.createAudioWithInfo(1, i.K);
        }
        return this.m;
    }

    public void a(OnAudioCallBack onAudioCallBack) {
        this.d = onAudioCallBack;
    }

    public void a(NativeRecorder nativeRecorder) {
        synchronized (this) {
            this.i = nativeRecorder;
        }
    }

    public void a(InterfaceC0241a interfaceC0241a) {
        this.c = interfaceC0241a;
        d();
        synchronized (this) {
            this.b = true;
        }
        this.n = false;
    }

    public boolean b() {
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(i.K, 16, 2) * 2;
            this.e = minBufferSize;
            if (minBufferSize < 0) {
                com.aliyun.common.c.a.a.b("AudioRecorder", "audio buffer size error");
            } else {
                this.g = new byte[minBufferSize];
                this.h = new byte[minBufferSize];
                this.f25855a = (minBufferSize * 1000) / 88200;
            }
            if (this.d != null) {
                HandlerThread handlerThread = new HandlerThread("audio data thread");
                this.k = handlerThread;
                handlerThread.start();
                this.j = new Handler(this.k.getLooper());
            }
            AudioRecord audioRecord = new AudioRecord(1, i.K, 16, 2, this.e);
            this.f = audioRecord;
            audioRecord.startRecording();
            this.n = false;
            b bVar = new b("AliyunAudioRecorder");
            this.l = bVar;
            bVar.start();
            return true;
        } catch (Exception unused) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Open audio record failed!");
            return false;
        }
    }

    public void c() {
        try {
            this.n = true;
            AudioRecord audioRecord = this.f;
            if (audioRecord != null) {
                audioRecord.stop();
                this.f.release();
            }
            this.f = null;
        } catch (Exception e) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Stop AudioRecord failed! " + e.toString());
        }
        HandlerThread handlerThread = this.k;
        if (handlerThread != null) {
            handlerThread.quit();
            this.k = null;
        }
    }

    public void e() {
        synchronized (this) {
            if (this.b) {
                this.b = false;
            }
        }
    }
}
