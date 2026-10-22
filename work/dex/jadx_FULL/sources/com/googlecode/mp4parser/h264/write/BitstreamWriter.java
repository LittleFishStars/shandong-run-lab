package com.googlecode.mp4parser.h264.write;

import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BitstreamWriter {
    private int curBit;
    private int[] curByte = new int[8];
    private final OutputStream os;

    public BitstreamWriter(OutputStream outputStream) {
        this.os = outputStream;
    }

    private void writeCurByte() throws IOException {
        int[] iArr = this.curByte;
        this.os.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    public void flush() throws IOException {
        for (int i = this.curBit; i < 8; i++) {
            this.curByte[i] = 0;
        }
        this.curBit = 0;
        writeCurByte();
    }

    public void write1Bit(int i) throws IOException {
        Debug.print(i);
        if (this.curBit == 8) {
            this.curBit = 0;
            writeCurByte();
        }
        int[] iArr = this.curByte;
        int i2 = this.curBit;
        this.curBit = i2 + 1;
        iArr[i2] = i;
    }

    public void writeByte(int i) throws IOException {
        this.os.write(i);
    }

    public void writeNBit(long j, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
        }
    }

    public void writeRemainingZero() throws IOException {
        writeNBit(0L, 8 - this.curBit);
    }
}
