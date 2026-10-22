package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32179a = 8192;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final OutputStream f6346a = new a();
    public static final int b = 524288;
    public static final int c = 2147483639;
    public static final int d = 20;

    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            com.google.common.base.i.E(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            com.google.common.base.i.E(bArr);
        }
    }

    public static byte[] a(Queue<byte[]> queue, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] bArrRemove = queue.remove();
            int iMin = Math.min(i2, bArrRemove.length);
            System.arraycopy(bArrRemove, 0, bArr, i - i2, iMin);
            i2 -= iMin;
        }
        return bArr;
    }

    @CanIgnoreReturnValue
    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        com.google.common.base.i.E(inputStream);
        com.google.common.base.i.E(outputStream);
        byte[] bArrD = d();
        long j = 0;
        while (true) {
            int i = inputStream.read(bArrD);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArrD, 0, i);
            j += (long) i;
        }
    }

    @CanIgnoreReturnValue
    public static long c(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        com.google.common.base.i.E(readableByteChannel);
        com.google.common.base.i.E(writableByteChannel);
        long jWrite = 0;
        if (!(readableByteChannel instanceof FileChannel)) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(d());
            while (readableByteChannel.read(byteBufferWrap) != -1) {
                j.b(byteBufferWrap);
                while (byteBufferWrap.hasRemaining()) {
                    jWrite += (long) writableByteChannel.write(byteBufferWrap);
                }
                j.a(byteBufferWrap);
            }
            return jWrite;
        }
        FileChannel fileChannel = (FileChannel) readableByteChannel;
        long jPosition = fileChannel.position();
        long j = jPosition;
        while (true) {
            long jTransferTo = fileChannel.transferTo(j, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
            j += jTransferTo;
            fileChannel.position(j);
            if (jTransferTo <= 0 && j >= fileChannel.size()) {
                return j - jPosition;
            }
        }
    }

    public static byte[] d() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @Beta
    public static long e(InputStream inputStream) throws IOException {
        byte[] bArrD = d();
        long j = 0;
        while (true) {
            long j2 = inputStream.read(bArrD);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Beta
    public static InputStream f(InputStream inputStream, long j) {
        return new d(inputStream, j);
    }

    @Beta
    public static ByteArrayDataInput g(ByteArrayInputStream byteArrayInputStream) {
        return new C0751b((ByteArrayInputStream) com.google.common.base.i.E(byteArrayInputStream));
    }

    @Beta
    public static ByteArrayDataInput h(byte[] bArr) {
        return g(new ByteArrayInputStream(bArr));
    }

    @Beta
    public static ByteArrayDataInput i(byte[] bArr, int i) {
        com.google.common.base.i.d0(i, bArr.length);
        return g(new ByteArrayInputStream(bArr, i, bArr.length - i));
    }

    @Beta
    public static ByteArrayDataOutput j() {
        return l(new ByteArrayOutputStream());
    }

    @Beta
    public static ByteArrayDataOutput k(int i) {
        if (i >= 0) {
            return l(new ByteArrayOutputStream(i));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i)));
    }

    @Beta
    public static ByteArrayDataOutput l(ByteArrayOutputStream byteArrayOutputStream) {
        return new c((ByteArrayOutputStream) com.google.common.base.i.E(byteArrayOutputStream));
    }

    @Beta
    public static OutputStream m() {
        return f6346a;
    }

    @CanIgnoreReturnValue
    @Beta
    public static int n(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        com.google.common.base.i.E(inputStream);
        com.google.common.base.i.E(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        com.google.common.base.i.f0(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    @Beta
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T o(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int i;
        com.google.common.base.i.E(inputStream);
        com.google.common.base.i.E(byteProcessor);
        byte[] bArrD = d();
        do {
            i = inputStream.read(bArrD);
            if (i == -1) {
                break;
            }
        } while (byteProcessor.a(bArrD, 0, i));
        return byteProcessor.getResult();
    }

    @Beta
    public static void p(InputStream inputStream, byte[] bArr) throws IOException {
        q(inputStream, bArr, 0, bArr.length);
    }

    @Beta
    public static void q(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iN = n(inputStream, bArr, i, i2);
        if (iN == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(81);
        sb.append("reached end of stream after reading ");
        sb.append(iN);
        sb.append(" bytes; ");
        sb.append(i2);
        sb.append(" bytes expected");
        throw new EOFException(sb.toString());
    }

    @Beta
    public static void r(InputStream inputStream, long j) throws IOException {
        long jT = t(inputStream, j);
        if (jT >= j) {
            return;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append("reached end of stream after skipping ");
        sb.append(jT);
        sb.append(" bytes; ");
        sb.append(j);
        sb.append(" bytes expected");
        throw new EOFException(sb.toString());
    }

    public static long s(InputStream inputStream, long j) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(iAvailable, j));
    }

    public static long t(InputStream inputStream, long j) throws IOException {
        byte[] bArr = null;
        long j2 = 0;
        while (j2 < j) {
            long j3 = j - j2;
            long jS = s(inputStream, j3);
            if (jS == 0) {
                int iMin = (int) Math.min(j3, 8192L);
                if (bArr == null) {
                    bArr = new byte[iMin];
                }
                jS = inputStream.read(bArr, 0, iMin);
                if (jS == -1) {
                    break;
                }
            }
            j2 += jS;
        }
        return j2;
    }

    public static byte[] u(InputStream inputStream) throws IOException {
        com.google.common.base.i.E(inputStream);
        return w(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] v(InputStream inputStream, long j) throws IOException {
        com.google.common.base.i.p(j >= 0, "expectedSize (%s) must be non-negative", j);
        if (j > 2147483639) {
            StringBuilder sb = new StringBuilder(62);
            sb.append(j);
            sb.append(" bytes is too large to fit in a byte array");
            throw new OutOfMemoryError(sb.toString());
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int i4 = inputStream.read(bArr, i3, i2);
            if (i4 == -1) {
                return Arrays.copyOf(bArr, i3);
            }
            i2 -= i4;
        }
        int i5 = inputStream.read();
        if (i5 == -1) {
            return bArr;
        }
        ArrayDeque arrayDeque = new ArrayDeque(22);
        arrayDeque.add(bArr);
        arrayDeque.add(new byte[]{(byte) i5});
        return w(inputStream, arrayDeque, i + 1);
    }

    public static byte[] w(InputStream inputStream, Queue<byte[]> queue, int i) throws IOException {
        int iU = 8192;
        while (i < 2147483639) {
            int iMin = Math.min(iU, c - i);
            byte[] bArr = new byte[iMin];
            queue.add(bArr);
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = inputStream.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    return a(queue, i);
                }
                i2 += i3;
                i += i3;
            }
            iU = com.google.common.math.e.u(iU, 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, c);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* JADX INFO: renamed from: com.google.common.io.b$b, reason: collision with other inner class name */
    public static class C0751b implements ByteArrayDataInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInput f32180a;

        public C0751b(ByteArrayInputStream byteArrayInputStream) {
            this.f32180a = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.f32180a.readBoolean();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.f32180a.readByte();
            } catch (EOFException e) {
                throw new IllegalStateException(e);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.f32180a.readChar();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.f32180a.readDouble();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.f32180a.readFloat();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.f32180a.readFully(bArr);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.f32180a.readInt();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        @CheckForNull
        public String readLine() {
            try {
                return this.f32180a.readLine();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.f32180a.readLong();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.f32180a.readShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            try {
                return this.f32180a.readUTF();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.f32180a.readUnsignedByte();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.f32180a.readUnsignedShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int i) {
            try {
                return this.f32180a.skipBytes(i);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            try {
                this.f32180a.readFully(bArr, i, i2);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static class c implements ByteArrayDataOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteArrayOutputStream f32181a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataOutput f6347a;

        public c(ByteArrayOutputStream byteArrayOutputStream) {
            this.f32181a = byteArrayOutputStream;
            this.f6347a = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.f32181a.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int i) {
            try {
                this.f6347a.write(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean z) {
            try {
                this.f6347a.writeBoolean(z);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int i) {
            try {
                this.f6347a.writeByte(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.f6347a.writeBytes(str);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int i) {
            try {
                this.f6347a.writeChar(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.f6347a.writeChars(str);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double d) {
            try {
                this.f6347a.writeDouble(d);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float f) {
            try {
                this.f6347a.writeFloat(f);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int i) {
            try {
                this.f6347a.writeInt(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long j) {
            try {
                this.f6347a.writeLong(j);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int i) {
            try {
                this.f6347a.writeShort(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.f6347a.writeUTF(str);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.f6347a.write(bArr);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr, int i, int i2) {
            try {
                this.f6347a.write(bArr, i, i2);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32182a;
        public long b;

        public d(InputStream inputStream, long j) {
            super(inputStream);
            this.b = -1L;
            com.google.common.base.i.E(inputStream);
            com.google.common.base.i.e(j >= 0, "limit must be non-negative");
            this.f32182a = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f32182a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            ((FilterInputStream) this).in.mark(i);
            this.b = this.f32182a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f32182a == 0) {
                return -1;
            }
            int i = ((FilterInputStream) this).in.read();
            if (i != -1) {
                this.f32182a--;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f32182a = this.b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j, this.f32182a));
            this.f32182a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.f32182a;
            if (j == 0) {
                return -1;
            }
            int i3 = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i2, j));
            if (i3 != -1) {
                this.f32182a -= (long) i3;
            }
            return i3;
        }
    }
}
