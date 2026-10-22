package com.googlecode.mp4parser;

import com.googlecode.mp4parser.util.CastUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DirectFileReadDataSource implements DataSource {
    private static final int TRANSFER_SIZE = 8192;
    private String filename;
    private RandomAccessFile raf;

    public DirectFileReadDataSource(File file) throws IOException {
        this.raf = new RandomAccessFile(file, "r");
        this.filename = file.getName();
    }

    @Override // com.googlecode.mp4parser.DataSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public ByteBuffer map(long j, long j2) throws IOException {
        this.raf.seek(j);
        byte[] bArr = new byte[CastUtils.l2i(j2)];
        this.raf.readFully(bArr);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long position() throws IOException {
        return this.raf.getFilePointer();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public int read(ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[8192];
        int i = 0;
        int i2 = 0;
        while (i < iRemaining) {
            i2 = this.raf.read(bArr, 0, Math.min(iRemaining - i, 8192));
            if (i2 < 0) {
                break;
            }
            i += i2;
            byteBuffer.put(bArr, 0, i2);
        }
        if (i2 >= 0 || i != 0) {
            return i;
        }
        return -1;
    }

    public int readAllInOnce(ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[byteBuffer.remaining()];
        int i = this.raf.read(bArr);
        byteBuffer.put(bArr, 0, i);
        return i;
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long size() throws IOException {
        return this.raf.length();
    }

    public String toString() {
        return this.filename;
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return writableByteChannel.write(map(j, j2));
    }

    @Override // com.googlecode.mp4parser.DataSource
    public void position(long j) throws IOException {
        this.raf.seek(j);
    }
}
