package com.coremedia.iso;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class IsoTypeWriterVariable {
    public static void write(long j, ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (int) (j & 255));
            return;
        }
        if (i == 2) {
            IsoTypeWriter.writeUInt16(byteBuffer, (int) (j & 65535));
            return;
        }
        if (i == 3) {
            IsoTypeWriter.writeUInt24(byteBuffer, (int) (j & 16777215));
            return;
        }
        if (i == 4) {
            IsoTypeWriter.writeUInt32(byteBuffer, j);
        } else {
            if (i == 8) {
                IsoTypeWriter.writeUInt64(byteBuffer, j);
                return;
            }
            throw new RuntimeException("I don't know how to read " + i + " bytes");
        }
    }
}
