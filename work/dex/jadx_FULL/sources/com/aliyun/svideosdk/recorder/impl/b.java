package com.aliyun.svideosdk.recorder.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback;
import com.aliyun.svideosdk.common.struct.common.AliyunAudioClip;
import com.aliyun.svideosdk.recorder.AliyunIAudioRecorder;
import com.google.android.exoplayer2.source.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class b implements AliyunIAudioRecorder {
    private static int A = 0;
    private static int v = 1;
    private static int w = 44100;
    private static int x = 2;
    private static int y = 64000;
    private static final int z = AudioRecord.getMinBufferSize(i.K, 16, 2) * 2;
    private AudioRecord c;
    private MediaCodec d;
    private ByteBuffer[] f;
    private ByteBuffer[] g;
    private byte[] i;
    private String l;
    private AliyunAudioClip n;
    private AliyunAudioClip o;
    private volatile long p;
    private CountDownLatch r;
    private CountDownLatch s;
    private CountDownLatch t;
    private OnAudioRecordCallback u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ByteBuffer f25836a = ByteBuffer.allocateDirect(z);
    private String b = null;
    private MediaCodec.BufferInfo e = new MediaCodec.BufferInfo();
    private final byte[] h = new byte[7];
    private HandlerThread j = null;
    private a k = null;
    private Vector<AliyunAudioClip> m = new Vector<>();
    private FileOutputStream q = null;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f25837a;
        private long b;

        public a(Looper looper) {
            super(looper);
            this.f25837a = 0L;
            this.b = 0L;
        }

        /* JADX WARN: Code duplicated, block: B:138:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:147:0x02ef A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:148:0x02cd A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:76:0x028e  */
        /* JADX WARN: Code duplicated, block: B:78:0x0299  */
        /* JADX WARN: Code duplicated, block: B:81:0x02ae  */
        /* JADX WARN: Code duplicated, block: B:87:0x02ce A[Catch: InterruptedException -> 0x02d8, TRY_LEAVE, TryCatch #4 {InterruptedException -> 0x02d8, blocks: (B:84:0x02c5, B:87:0x02ce), top: B:138:0x02c5 }] */
        /* JADX WARN: Code duplicated, block: B:93:0x02f7  */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CountDownLatch countDownLatch;
            int i;
            b bVar;
            AliyunAudioClip aliyunAudioClip;
            super.handleMessage(message);
            int i2 = 100;
            try {
                switch (message.what) {
                    case 1:
                        try {
                            if (b.this.c != null) {
                                b.this.c.startRecording();
                            }
                            if (b.this.d == null) {
                                try {
                                    b.this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
                                } catch (IOException e) {
                                    com.aliyun.common.c.a.a.b("AliYunLog", "AudioRecord createEncoderByType Exeption" + e.toString());
                                }
                            }
                            if (b.this.d != null) {
                                MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", b.w, b.v);
                                mediaFormatCreateAudioFormat.setInteger("aac-profile", b.x);
                                mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, b.y);
                                b.this.d.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                                b.this.d.start();
                                b bVar2 = b.this;
                                bVar2.f = bVar2.d.getInputBuffers();
                                b bVar3 = b.this;
                                bVar3.g = bVar3.d.getOutputBuffers();
                            }
                            for (int i3 = 0; i3 < 2; i3++) {
                                if (b.this.c.read(b.this.f25836a, b.z) > 0) {
                                    b.this.f25836a.clear();
                                } else {
                                    com.aliyun.common.c.a.a.b("AliYunLog", "Capture invalid audio data!");
                                }
                            }
                            sendEmptyMessage(3);
                            break;
                        } catch (Exception e2) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "AudioRecord startRecording failed!" + e2.toString());
                            if (b.this.u != null) {
                                b.this.u.onError(-20001006);
                            }
                        }
                        countDownLatch = b.this.t;
                        countDownLatch.countDown();
                        return;
                    case 2:
                        if (b.this.c != null) {
                            b.this.c.stop();
                        }
                        int iDequeueInputBuffer = b.this.d.dequeueInputBuffer(1000L);
                        int i4 = 100;
                        while (iDequeueInputBuffer == -1) {
                            i4--;
                            if (i4 <= 0) {
                                if (i4 == 0) {
                                    com.aliyun.common.c.a.a.b("AliYunLog", "AudioRecord Exeption");
                                    if (b.this.u != null) {
                                        b.this.u.onError(-3);
                                    }
                                } else {
                                    b.this.d.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                                    while (true) {
                                        i = i2 - 1;
                                        if (i2 > 0) {
                                            try {
                                                if (b.this.h()) {
                                                    Thread.currentThread();
                                                    Thread.sleep(10L);
                                                    i2 = i;
                                                }
                                            } catch (InterruptedException e3) {
                                                com.aliyun.common.c.a.a.b("AliYunLog", "AudioRecord Exeption" + e3.toString());
                                            }
                                        }
                                    }
                                    if (b.this.d != null) {
                                        b.this.d.flush();
                                        b.this.d.stop();
                                        b.this.d.reset();
                                        b.this.d.release();
                                        b.this.d = null;
                                    }
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    b.this.p += jCurrentTimeMillis - this.b;
                                    b.this.a(this.f25837a, jCurrentTimeMillis);
                                    removeMessages(3);
                                    removeMessages(4);
                                }
                                countDownLatch = b.this.r;
                                countDownLatch.countDown();
                                return;
                            }
                            b.this.h();
                            iDequeueInputBuffer = b.this.d.dequeueInputBuffer(1000L);
                        }
                        if (i4 == 0) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "AudioRecord Exeption");
                            if (b.this.u != null) {
                                b.this.u.onError(-3);
                            }
                        } else {
                            b.this.d.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            while (true) {
                                i = i2 - 1;
                                if (i2 > 0) {
                                    if (b.this.h()) {
                                        Thread.currentThread();
                                        Thread.sleep(10L);
                                        i2 = i;
                                    }
                                }
                            }
                            if (b.this.d != null) {
                                b.this.d.flush();
                                b.this.d.stop();
                                b.this.d.reset();
                                b.this.d.release();
                                b.this.d = null;
                            }
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            b.this.p += jCurrentTimeMillis2 - this.b;
                            b.this.a(this.f25837a, jCurrentTimeMillis2);
                            removeMessages(3);
                            removeMessages(4);
                        }
                        countDownLatch = b.this.r;
                        countDownLatch.countDown();
                        return;
                    case 3:
                        if (b.this.n == null) {
                            String str = b.this.b + File.separator + System.nanoTime();
                            if (b.this.o == null) {
                                bVar = b.this;
                                aliyunAudioClip = new AliyunAudioClip(b.b(), 0L, str);
                            } else {
                                bVar = b.this;
                                aliyunAudioClip = new AliyunAudioClip(b.b(), b.this.o.getEndTime(), str);
                            }
                            bVar.n = aliyunAudioClip;
                            long jCurrentTimeMillis3 = System.currentTimeMillis();
                            this.f25837a = jCurrentTimeMillis3;
                            this.b = jCurrentTimeMillis3;
                            try {
                                if (b.this.q == null) {
                                    File fileD = com.aliyun.common.utils.g.d(b.this.n.getFilePath());
                                    if (fileD == null) {
                                        com.aliyun.common.c.a.a.b("AliYunLog", "Create clip file failed!");
                                        if (b.this.u != null) {
                                            b.this.u.onError(-20005004);
                                            return;
                                        }
                                        return;
                                    }
                                    b.this.q = new FileOutputStream(fileD, true);
                                }
                            } catch (IOException e4) {
                                com.aliyun.common.c.a.a.b("AliYunLog", "Create clip file failed!" + e4.toString());
                                if (b.this.u != null) {
                                    b.this.u.onError(-20005004);
                                    return;
                                }
                                return;
                            }
                        }
                        int i5 = b.this.c.read(b.this.f25836a, b.z);
                        long jCurrentTimeMillis4 = System.currentTimeMillis();
                        b.this.p += jCurrentTimeMillis4 - this.b;
                        this.b = jCurrentTimeMillis4;
                        while (i5 > 0) {
                            int iDequeueInputBuffer2 = b.this.d.dequeueInputBuffer(1000L);
                            int i6 = 100;
                            while (iDequeueInputBuffer2 == -1 && (i6 = i6 - 1) > 0) {
                                b.this.h();
                                iDequeueInputBuffer2 = b.this.d.dequeueInputBuffer(1000L);
                            }
                            if (i6 == 0) {
                                com.aliyun.common.c.a.a.b("AliYunLog", "AudioRecord Exeption");
                                if (b.this.u != null) {
                                    b.this.u.onError(-3);
                                }
                                b.this.r.countDown();
                            }
                            ByteBuffer byteBuffer = b.this.f[iDequeueInputBuffer2];
                            byteBuffer.clear();
                            int iMin = Math.min(i5, byteBuffer.capacity());
                            i5 -= iMin;
                            for (int i7 = 0; i7 < iMin; i7++) {
                                byteBuffer.put(b.this.f25836a.get());
                            }
                            b.this.d.queueInputBuffer(iDequeueInputBuffer2, 0, iMin, 0L, 0);
                        }
                        b.this.f25836a.rewind();
                        if (b.this.h()) {
                            return;
                        }
                        sendEmptyMessage(3);
                        return;
                    case 4:
                        b.this.a(this.f25837a, System.currentTimeMillis());
                        return;
                    case 5:
                        int iG = b.this.g();
                        if (iG == 0) {
                            if (b.this.u != null) {
                                b.this.u.onClipConnected(b.this.l);
                                return;
                            }
                            return;
                        }
                        com.aliyun.common.c.a.a.b("AliYunLog", "Connect clip files failed, return " + iG);
                        if (b.this.u != null) {
                            b.this.u.onError(iG);
                            return;
                        }
                        return;
                    case 6:
                        if (b.this.c != null) {
                            b.this.c.release();
                            b.this.c = null;
                        }
                        if (b.this.d != null) {
                            b.this.d.release();
                            b.this.d = null;
                        }
                        Iterator it = b.this.m.iterator();
                        while (it.hasNext()) {
                            b.this.deleteClip((AliyunAudioClip) it.next());
                        }
                        removeMessages(3);
                        removeMessages(4);
                        b.this.k.getLooper().quitSafely();
                        b.this.p = 0L;
                        b.this.k = null;
                        b.this.j = null;
                        b.this.u = null;
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                b.this.t.countDown();
                throw th;
            }
        }
    }

    private void a(int i, long j) {
        if (i >= this.m.size() || i < 0) {
            return;
        }
        int size = this.m.size();
        while (i < size) {
            AliyunAudioClip aliyunAudioClip = this.m.get(i);
            aliyunAudioClip.setStartTime(aliyunAudioClip.getStartTime() - j);
            aliyunAudioClip.setEndTime(aliyunAudioClip.getEndTime() - j);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        AliyunAudioClip aliyunAudioClip = this.n;
        if (aliyunAudioClip != null) {
            aliyunAudioClip.setEndTime(aliyunAudioClip.getStartTime() + (j2 - j));
            try {
                this.q.flush();
                this.q.close();
                this.q = null;
                this.m.add(this.n);
                this.o = this.n;
                this.n = null;
            } catch (IOException e) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Close audio data file failed!" + e.toString());
                OnAudioRecordCallback onAudioRecordCallback = this.u;
                if (onAudioRecordCallback != null) {
                    onAudioRecordCallback.onError(-20005005);
                }
            }
        }
    }

    public static /* synthetic */ int b() {
        int i = A;
        A = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        try {
            if (com.aliyun.common.utils.g.d(this.l) == null) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Create output file failed!");
                return -20003002;
            }
            int size = this.m.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                AliyunAudioClip aliyunAudioClip = this.m.get(i);
                File file = new File(aliyunAudioClip.getFilePath());
                if (!file.exists() || !file.isFile()) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "Invalid clip file[" + aliyunAudioClip.getFilePath() + "]");
                    return -20003007;
                }
                strArr[i] = aliyunAudioClip.getFilePath();
            }
            com.aliyun.common.utils.g.a(this.l, strArr);
            return 0;
        } catch (IOException e) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Create output file failed!" + e.toString());
            return -20003002;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int iDequeueOutputBuffer;
        boolean z2;
        MediaCodec mediaCodec = this.d;
        MediaCodec.BufferInfo bufferInfo = this.e;
        while (true) {
            iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
            z2 = false;
            if (iDequeueOutputBuffer < 0) {
                break;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.e;
            int i = bufferInfo2.flags;
            if (i == 0) {
                ByteBuffer byteBuffer = this.g[iDequeueOutputBuffer];
                byteBuffer.position(bufferInfo2.offset);
                int i2 = this.e.size;
                byte[] bArr = new byte[i2];
                this.i = bArr;
                int i3 = x;
                int i4 = v;
                int i5 = i2 + 7;
                byte[] bArr2 = this.h;
                bArr2[0] = -1;
                bArr2[1] = -7;
                bArr2[2] = (byte) (((i3 - 1) << 6) + 16 + (i4 >> 2));
                bArr2[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
                bArr2[4] = (byte) ((i5 & 2047) >> 3);
                bArr2[5] = (byte) (((i5 & 7) << 5) + 31);
                bArr2[6] = -4;
                byteBuffer.get(bArr);
                try {
                    this.q.write(this.h, 0, 7);
                    this.q.write(this.i, 0, this.e.size);
                } catch (IOException unused) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "Write audio data to file failed!");
                    OnAudioRecordCallback onAudioRecordCallback = this.u;
                    if (onAudioRecordCallback != null) {
                        onAudioRecordCallback.onError(-20005005);
                    }
                }
            } else if ((i & 4) != 0) {
                this.d.releaseOutputBuffer(iDequeueOutputBuffer, false);
                z2 = true;
                break;
            }
            this.d.releaseOutputBuffer(iDequeueOutputBuffer, false);
            mediaCodec = this.d;
            bufferInfo = this.e;
        }
        if (!z2) {
            if (iDequeueOutputBuffer == -2) {
                com.aliyun.common.c.a.a.c("AliYunLog", "AudioRecorder INFO_OUTPUT_FORMAT_CHANGED");
                MediaFormat outputFormat = this.d.getOutputFormat();
                w = outputFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
                v = outputFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
            } else if (iDequeueOutputBuffer == -2) {
                com.aliyun.common.c.a.a.c("AliYunLog", "AudioRecorder INFO_OUTPUT_FORMAT_CHANGED");
                this.g = this.d.getOutputBuffers();
            }
        }
        return z2;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public AliyunAudioClip[] allClips() {
        AliyunAudioClip[] aliyunAudioClipArr = new AliyunAudioClip[this.m.size()];
        this.m.copyInto(aliyunAudioClipArr);
        return aliyunAudioClipArr;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized AliyunAudioClip breakTag() {
        if (this.k == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid state!");
            return null;
        }
        this.s = new CountDownLatch(1);
        this.k.sendEmptyMessage(4);
        try {
            this.s.await();
            return this.o;
        } catch (InterruptedException unused) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Break tag failed!");
            return null;
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int connectClip() {
        a aVar = this.k;
        if (aVar == null) {
            return -4;
        }
        aVar.sendEmptyMessage(5);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int deleteClip(AliyunAudioClip aliyunAudioClip) {
        if (aliyunAudioClip == null) {
            return 0;
        }
        if (!this.m.contains(aliyunAudioClip)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Not find clip with id=" + aliyunAudioClip.getId());
            return -20003008;
        }
        int iIndexOf = this.m.indexOf(aliyunAudioClip);
        this.m.remove(aliyunAudioClip);
        long endTime = aliyunAudioClip.getEndTime() - aliyunAudioClip.getStartTime();
        this.p -= endTime;
        a(iIndexOf, endTime);
        File file = new File(aliyunAudioClip.getFilePath());
        if (file.exists() && file.isFile()) {
            file.delete();
            if (this.m.isEmpty()) {
                this.o = null;
            } else {
                this.o = this.m.lastElement();
            }
            return 0;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Clip file[" + aliyunAudioClip.getFilePath() + "] not exist!");
        return -20003008;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized long getRecordDuration() {
        return this.p;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    @TargetApi(16)
    public int init(Context context) {
        com.aliyun.common.c.a.a.c("AliYunLog", "AudioRecorder init.");
        if (this.b == null) {
            this.b = context.getExternalFilesDir(null).getAbsolutePath() + File.separator + ".aliyun_svideo_files";
        }
        this.c = new AudioRecord(1, i.K, 16, 2, z);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int release() {
        a aVar = this.k;
        if (aVar == null) {
            return -4;
        }
        aVar.sendEmptyMessage(6);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public void setOnAudioRecordCallback(OnAudioRecordCallback onAudioRecordCallback) {
        this.u = onAudioRecordCallback;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public int setOutputPath(String str) {
        com.aliyun.common.c.a.a.c("AliYunLog", "AudioRecorder setPath." + str);
        if (TextUtils.isEmpty(str)) {
            return -20003002;
        }
        this.l = str;
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int startRecord() {
        com.aliyun.common.c.a.a.c("AliYunLog", "AudioRecorder startRecord.");
        if (this.j == null) {
            HandlerThread handlerThread = new HandlerThread("AudioTagRecorder");
            this.j = handlerThread;
            handlerThread.start();
        }
        if (this.k == null) {
            this.k = new a(this.j.getLooper());
        }
        this.t = new CountDownLatch(1);
        this.k.sendEmptyMessage(1);
        try {
            this.t.await();
        } catch (InterruptedException unused) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Start audio record failed!");
            return -4;
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized AliyunAudioClip stopRecord() {
        if (this.k == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid state!");
            return null;
        }
        this.r = new CountDownLatch(1);
        this.k.sendEmptyMessage(2);
        try {
            this.r.await();
            return this.o;
        } catch (InterruptedException unused) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Stop record failed!");
            return null;
        }
    }
}
