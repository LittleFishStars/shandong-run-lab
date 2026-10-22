package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.zj.adlib.ab3;
import com.zj.adlib.jy1;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DecoderInputBuffer extends Buffer {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public final int L;
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d f2586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jy1 f2587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ByteBuffer f2588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2589a;

    @Nullable
    public ByteBuffer b;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i, int i2) {
            super("Buffer too small (" + i + " < " + i2 + ")");
            this.currentCapacity = i;
            this.requiredCapacity = i2;
        }
    }

    static {
        ab3.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i) {
        this(i, 0);
    }

    public static DecoderInputBuffer n() {
        return new DecoderInputBuffer(0);
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.f2588a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.b;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f2589a = false;
    }

    public final ByteBuffer j(int i) {
        int i2 = this.L;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.f2588a;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    @EnsuresNonNull({"data"})
    public void k(int i) {
        int i2 = i + this.M;
        ByteBuffer byteBuffer = this.f2588a;
        if (byteBuffer == null) {
            this.f2588a = j(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.f2588a = byteBuffer;
            return;
        }
        ByteBuffer byteBufferJ = j(i3);
        byteBufferJ.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferJ.put(byteBuffer);
        }
        this.f2588a = byteBufferJ;
    }

    public final void l() {
        ByteBuffer byteBuffer = this.f2588a;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.b;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean m() {
        return getFlag(1073741824);
    }

    @EnsuresNonNull({"supplementalData"})
    public void o(int i) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.b = ByteBuffer.allocate(i);
        } else {
            this.b.clear();
        }
    }

    public DecoderInputBuffer(int i, int i2) {
        this.f2587a = new jy1();
        this.L = i;
        this.M = i2;
    }
}
