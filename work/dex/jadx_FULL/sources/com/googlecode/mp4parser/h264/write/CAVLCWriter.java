package com.googlecode.mp4parser.h264.write;

import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CAVLCWriter extends BitstreamWriter {
    public CAVLCWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeBool(boolean z, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        write1Bit(z ? 1 : 0);
        Debug.println("\t" + z);
    }

    public void writeNBit(long j, int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        for (int i2 = 0; i2 < i; i2++) {
            write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
        }
        Debug.println("\t" + j);
    }

    public void writeSE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeUE(((i << 1) * (i < 0 ? -1 : 1)) + (i <= 0 ? 0 : 1));
        Debug.println("\t" + i);
    }

    public void writeSliceTrailingBits() {
        throw new IllegalStateException("todo");
    }

    public void writeTrailingBits() throws IOException {
        write1Bit(1);
        writeRemainingZero();
        flush();
    }

    public void writeU(int i, int i2, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeNBit((long) i, i2);
        Debug.println("\t" + i);
    }

    public void writeUE(int i) throws IOException {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 15) {
            int i5 = (1 << i3) + i4;
            if (i < i5) {
                i2 = i3;
                break;
            } else {
                i3++;
                i4 = i5;
            }
        }
        writeNBit(0L, i2);
        write1Bit(1);
        writeNBit(i - i4, i2);
    }

    public void writeU(int i, int i2) throws IOException {
        writeNBit(i, i2);
    }

    public void writeUE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeUE(i);
        Debug.println("\t" + i);
    }
}
