package com.coremedia.iso;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class IsoTypeReaderVariable {
    public static long read(ByteBuffer byteBuffer, int i) {
        int uInt8;
        if (i == 1) {
            uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        } else if (i == 2) {
            uInt8 = IsoTypeReader.readUInt16(byteBuffer);
        } else {
            if (i != 3) {
                if (i == 4) {
                    return IsoTypeReader.readUInt32(byteBuffer);
                }
                if (i == 8) {
                    return IsoTypeReader.readUInt64(byteBuffer);
                }
                throw new RuntimeException("I don't know how to read " + i + " bytes");
            }
            uInt8 = IsoTypeReader.readUInt24(byteBuffer);
        }
        return uInt8;
    }
}
