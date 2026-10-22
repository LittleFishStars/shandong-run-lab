package com.googlecode.mp4parser.authoring.tracks.h265;

import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SEIMessage {
    public SEIMessage(BitReaderBuffer bitReaderBuffer) throws IOException {
        int i = 0;
        while (bitReaderBuffer.readBits(8) == 255) {
            i += 255;
        }
        int bits = bitReaderBuffer.readBits(8) + i;
        while (bitReaderBuffer.readBits(8) == 255) {
        }
        bitReaderBuffer.readBits(8);
        System.err.println("payloadType " + bits);
    }
}
