package com.kc.dw.core.view.gif;

import android.util.Log;
import com.kc.dw.activity.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GifHeaderParser {
    public static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    public static final int MIN_FRAME_DELAY = 2;
    public static final String TAG = "GifHeaderParser";
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    private boolean err() {
        return this.header.status != 0;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int i = read();
        boolean z = (i & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (i & 7) + 1);
        GifFrame gifFrame = this.header.currentFrame;
        gifFrame.interlace = (i & 64) != 0;
        if (z) {
            gifFrame.lct = readColorTable(iPow);
        } else {
            gifFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private int readBlock() {
        int i = read();
        this.blockSize = i;
        int i2 = 0;
        if (i > 0) {
            int i3 = 0;
            while (true) {
                try {
                    int i4 = this.blockSize;
                    if (i2 >= i4) {
                        break;
                    }
                    i3 = i4 - i2;
                    this.rawData.get(this.block, i2, i3);
                    i2 += i3;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.blockSize, e);
                    }
                    this.header.status = 1;
                }
            }
        }
        return i2;
    }

    private int[] readColorTable(int i) {
        byte[] bArr = new byte[i * 3];
        try {
            this.rawData.get(bArr);
            int[] iArr = new int[256];
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                iArr[i3] = ((bArr[i2] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i2 = i5 + 1;
            }
            return iArr;
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.header.status = 1;
            return null;
        }
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readContents(int i) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i) {
            int i2 = read();
            if (i2 == 33) {
                int i3 = read();
                if (i3 != 1) {
                    if (i3 == 249) {
                        this.header.currentFrame = new GifFrame();
                        readGraphicControlExt();
                    } else if (i3 != 254 && i3 == 255) {
                        readBlock();
                        String string = "";
                        for (int i4 = 0; i4 < 11; i4++) {
                            StringBuilder sbA = a.a(string);
                            sbA.append((char) this.block[i4]);
                            string = sbA.toString();
                        }
                        if (string.equals("NETSCAPE2.0")) {
                            readNetscapeExt();
                        }
                    }
                }
                skip();
            } else if (i2 == 44) {
                GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (i2 != 59) {
                this.header.status = 1;
            } else {
                z = true;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int i = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i2 = (i & 28) >> 2;
        gifFrame.dispose = i2;
        if (i2 == 0) {
            gifFrame.dispose = 1;
        }
        gifFrame.transparency = (i & 1) != 0;
        int i3 = readShort();
        if (i3 < 2) {
            i3 = 10;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = i3 * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        String string = "";
        for (int i = 0; i < 6; i++) {
            StringBuilder sbA = a.a(string);
            sbA.append((char) read());
            string = sbA.toString();
        }
        if (!string.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (!this.header.gctFlag || err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.gct = readColorTable(gifHeader.gctSize);
        GifHeader gifHeader2 = this.header;
        gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int i = read();
        GifHeader gifHeader = this.header;
        gifHeader.gctFlag = (i & 128) != 0;
        gifHeader.gctSize = 2 << (i & 7);
        gifHeader.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                byte b = bArr[1];
                byte b2 = bArr[2];
                GifHeader gifHeader = this.header;
                int i = ((b2 & 255) << 8) | (b & 255);
                gifHeader.loopCount = i;
                if (i == 0) {
                    gifHeader.loopCount = -1;
                }
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int i;
        do {
            try {
                i = read();
                ByteBuffer byteBuffer = this.rawData;
                byteBuffer.position(byteBuffer.position() + i);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (i > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        return this.header.frameCount > 1;
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (err()) {
            return this.header;
        }
        readHeader();
        if (!err()) {
            readContents();
            GifHeader gifHeader = this.header;
            if (gifHeader.frameCount < 0) {
                gifHeader.status = 1;
            }
        }
        return this.header;
    }

    public GifHeaderParser setData(ByteBuffer byteBuffer) {
        reset();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
