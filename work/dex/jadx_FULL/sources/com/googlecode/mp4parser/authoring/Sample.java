package com.googlecode.mp4parser.authoring;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface Sample {
    ByteBuffer asByteBuffer();

    long getSize();

    void writeTo(WritableByteChannel writableByteChannel) throws IOException;
}
