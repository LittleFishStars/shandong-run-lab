package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BitReaderBuffer {
    private ByteBuffer buffer;
    int initialPos;
    int position;

    public BitReaderBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public int byteSync() {
        int i = 8 - (this.position % 8);
        if (i == 8) {
            i = 0;
        }
        readBits(i);
        return i;
    }

    public int getPosition() {
        return this.position;
    }

    public int readBits(int i) {
        int bits;
        int i2 = this.buffer.get(this.initialPos + (this.position / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.position;
        int i4 = 8 - (i3 % 8);
        if (i <= i4) {
            bits = ((i2 << (i3 % 8)) & 255) >> ((i3 % 8) + (i4 - i));
            this.position = i3 + i;
        } else {
            int i5 = i - i4;
            bits = (readBits(i4) << i5) + readBits(i5);
        }
        this.buffer.position(this.initialPos + ((int) Math.ceil(((double) this.position) / 8.0d)));
        return bits;
    }

    public boolean readBool() {
        return readBits(1) == 1;
    }

    public int remainingBits() {
        return (this.buffer.limit() * 8) - this.position;
    }
}
