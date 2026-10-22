package com.ipd.dsp.internal.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38272a = 16384;
    public static final AtomicReference<byte[]> b = new AtomicReference<>();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38273a;
        public final int b;
        public final byte[] c;

        public b(@NonNull byte[] bArr, int i, int i2) {
            this.c = bArr;
            this.f38273a = i;
            this.b = i2;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    fileChannel = channel;
                    th = th3;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                channel = null;
            }
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    @NonNull
    public static byte[] c(@NonNull ByteBuffer byteBuffer) {
        b bVarA = a(byteBuffer);
        if (bVarA != null && bVarA.f38273a == 0 && bVarA.b == bVarA.c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        b(byteBufferAsReadOnlyBuffer);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    public static InputStream d(@NonNull ByteBuffer byteBuffer) {
        return new C0875a(byteBuffer);
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.d0.a$a, reason: collision with other inner class name */
    public static class C0875a extends InputStream {
        public static final int h = -1;

        @NonNull
        public final ByteBuffer f;
        public int g = -1;

        public C0875a(@NonNull ByteBuffer byteBuffer) {
            this.f = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.g = this.f.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f.hasRemaining()) {
                return this.f.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i = this.g;
            if (i == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.f.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j, available());
            ByteBuffer byteBuffer = this.f;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) {
            if (!this.f.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i2, available());
            this.f.get(bArr, i, iMin);
            return iMin;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        b(byteBuffer);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
            } catch (Throwable th) {
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                randomAccessFile.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        b bVarA = a(byteBuffer);
        if (bVarA != null) {
            byte[] bArr = bVarA.c;
            int i = bVarA.f38273a;
            outputStream.write(bArr, i, bVarA.b + i);
            return;
        }
        byte[] andSet = b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int iMin = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, iMin);
            outputStream.write(andSet, 0, iMin);
        }
        b.set(andSet);
    }

    @NonNull
    public static ByteBuffer a(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i = inputStream.read(andSet);
            if (i >= 0) {
                byteArrayOutputStream.write(andSet, 0, i);
            } else {
                b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return b(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    @Nullable
    public static b a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
