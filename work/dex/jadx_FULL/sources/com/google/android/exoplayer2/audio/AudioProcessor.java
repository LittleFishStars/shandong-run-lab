package com.google.android.exoplayer2.audio;

import com.zj.adlib.gj9;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f30536a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f30537a = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f2360a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3) {
            this.f2360a = i;
            this.b = i2;
            this.c = i3;
            this.d = gj9.J0(i3) ? gj9.p0(i3, i2) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f2360a + ", channelCount=" + this.b + ", encoding=" + this.c + ']';
        }
    }

    a a(a aVar) throws UnhandledAudioFormatException;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
