package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.cu9;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TeeAudioProcessor extends BaseAudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioBufferSink f30555a;

    public interface AudioBufferSink {
        void flush(int i, int i2, int i3);

        void handleBuffer(ByteBuffer byteBuffer);
    }

    public static final class a implements AudioBufferSink {
        public static final String b = "WaveFileAudioBufferSink";
        public static final int f = 4;
        public static final int g = 40;
        public static final int h = 44;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30556a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public RandomAccessFile f2465a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2466a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ByteBuffer f2467a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2468a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f2469b;
        public int c;
        public int d;
        public int e;

        public a(String str) {
            this.f2466a = str;
            byte[] bArr = new byte[1024];
            this.f2468a = bArr;
            this.f2467a = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        }

        public final String a() {
            int i = this.d;
            this.d = i + 1;
            return gj9.H("%s-%04d.wav", this.f2466a, Integer.valueOf(i));
        }

        public final void b() throws IOException {
            if (this.f2465a != null) {
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(a(), "rw");
            e(randomAccessFile);
            this.f2465a = randomAccessFile;
            this.e = 44;
        }

        public final void c() throws IOException {
            RandomAccessFile randomAccessFile = this.f2465a;
            if (randomAccessFile == null) {
                return;
            }
            try {
                this.f2467a.clear();
                this.f2467a.putInt(this.e - 8);
                randomAccessFile.seek(4L);
                randomAccessFile.write(this.f2468a, 0, 4);
                this.f2467a.clear();
                this.f2467a.putInt(this.e - 44);
                randomAccessFile.seek(40L);
                randomAccessFile.write(this.f2468a, 0, 4);
            } catch (IOException e) {
                Log.o(b, "Error updating file size", e);
            }
            try {
                randomAccessFile.close();
            } finally {
                this.f2465a = null;
            }
        }

        public final void d(ByteBuffer byteBuffer) throws IOException {
            RandomAccessFile randomAccessFile = (RandomAccessFile) sb0.g(this.f2465a);
            while (byteBuffer.hasRemaining()) {
                int iMin = Math.min(byteBuffer.remaining(), this.f2468a.length);
                byteBuffer.get(this.f2468a, 0, iMin);
                randomAccessFile.write(this.f2468a, 0, iMin);
                this.e += iMin;
            }
        }

        public final void e(RandomAccessFile randomAccessFile) throws IOException {
            randomAccessFile.writeInt(1380533830);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(1463899717);
            randomAccessFile.writeInt(1718449184);
            this.f2467a.clear();
            this.f2467a.putInt(16);
            this.f2467a.putShort((short) cu9.b(this.c));
            this.f2467a.putShort((short) this.f2469b);
            this.f2467a.putInt(this.f30556a);
            int iP0 = gj9.p0(this.c, this.f2469b);
            this.f2467a.putInt(this.f30556a * iP0);
            this.f2467a.putShort((short) iP0);
            this.f2467a.putShort((short) ((iP0 * 8) / this.f2469b));
            randomAccessFile.write(this.f2468a, 0, this.f2467a.position());
            randomAccessFile.writeInt(1684108385);
            randomAccessFile.writeInt(-1);
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int i, int i2, int i3) {
            try {
                c();
            } catch (IOException e) {
                Log.e(b, "Error resetting", e);
            }
            this.f30556a = i;
            this.f2469b = i2;
            this.c = i3;
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(ByteBuffer byteBuffer) {
            try {
                b();
                d(byteBuffer);
            } catch (IOException e) {
                Log.e(b, "Error writing data", e);
            }
        }
    }

    public TeeAudioProcessor(AudioBufferSink audioBufferSink) {
        this.f30555a = (AudioBufferSink) sb0.g(audioBufferSink);
    }

    public final void b() {
        if (isActive()) {
            AudioBufferSink audioBufferSink = this.f30555a;
            AudioProcessor.a aVar = ((BaseAudioProcessor) this).f30541a;
            audioBufferSink.flush(aVar.f2360a, aVar.b, aVar.c);
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.a onConfigure(AudioProcessor.a aVar) {
        return aVar;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        b();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        b();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        b();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        this.f30555a.handleBuffer(byteBuffer.asReadOnlyBuffer());
        replaceOutputBuffer(iRemaining).put(byteBuffer).flip();
    }
}
