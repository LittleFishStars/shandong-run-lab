package com.getui.gtc.base.http;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class BufferedSink {
    public final OutputStream sink;
    private long size;

    public BufferedSink(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = outputStream;
        this.size = 0L;
    }

    public final void close() throws IOException {
        this.sink.close();
    }

    public final long size() {
        return this.size;
    }

    public final BufferedSink write(String str) throws IOException {
        byte[] bytes = str.getBytes();
        this.sink.write(bytes);
        this.size += (long) bytes.length;
        return this;
    }

    public final BufferedSink write(ByteBuffer byteBuffer) throws IOException {
        byte[] bArrArray = byteBuffer.array();
        this.sink.write(bArrArray);
        this.size += (long) bArrArray.length;
        return this;
    }

    public final BufferedSink write(byte[] bArr) throws IOException {
        this.sink.write(bArr);
        this.size += (long) bArr.length;
        return this;
    }

    public final BufferedSink writeLong(long j) throws IOException {
        byte[] bytes = String.valueOf(j).getBytes();
        this.sink.write(bytes);
        this.size += (long) bytes.length;
        return this;
    }

    public final BufferedSink writeUtf8(String str) throws IOException {
        byte[] bytes = str.getBytes();
        this.sink.write(bytes);
        this.size += (long) bytes.length;
        return this;
    }
}
