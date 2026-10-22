package com.googlecode.mp4parser;

import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MemoryDataSourceImpl implements DataSource {
    ByteBuffer data;

    public MemoryDataSourceImpl(byte[] bArr) {
        this.data = ByteBuffer.wrap(bArr);
    }

    @Override // com.googlecode.mp4parser.DataSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.googlecode.mp4parser.DataSource
    public ByteBuffer map(long j, long j2) throws IOException {
        int iPosition = this.data.position();
        this.data.position(CastUtils.l2i(j));
        ByteBuffer byteBufferSlice = this.data.slice();
        byteBufferSlice.limit(CastUtils.l2i(j2));
        this.data.position(iPosition);
        return byteBufferSlice;
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long position() throws IOException {
        return this.data.position();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.data.remaining() == 0 && byteBuffer.remaining() != 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), this.data.remaining());
        if (byteBuffer.hasArray()) {
            byteBuffer.put(this.data.array(), this.data.position(), iMin);
            ByteBuffer byteBuffer2 = this.data;
            byteBuffer2.position(byteBuffer2.position() + iMin);
        } else {
            byte[] bArr = new byte[iMin];
            this.data.get(bArr);
            byteBuffer.put(bArr);
        }
        return iMin;
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long size() throws IOException {
        return this.data.capacity();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return writableByteChannel.write((ByteBuffer) ((ByteBuffer) this.data.position(CastUtils.l2i(j))).slice().limit(CastUtils.l2i(j2)));
    }

    @Override // com.googlecode.mp4parser.DataSource
    public void position(long j) throws IOException {
        this.data.position(CastUtils.l2i(j));
    }

    public MemoryDataSourceImpl(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }
}
