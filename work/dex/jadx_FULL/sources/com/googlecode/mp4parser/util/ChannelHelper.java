package com.googlecode.mp4parser.util;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ChannelHelper {
    private static ByteBuffer empty = ByteBuffer.allocate(0).asReadOnlyBuffer();

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        readFully(readableByteChannel, byteBuffer, byteBuffer.remaining());
    }

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i) throws IOException {
        int i2;
        int i3 = 0;
        do {
            i2 = readableByteChannel.read(byteBuffer);
            if (-1 == i2) {
                break;
            }
            i3 += i2;
        } while (i3 != i);
        if (i2 != -1) {
            return i3;
        }
        throw new EOFException("End of file. No more boxes.");
    }
}
