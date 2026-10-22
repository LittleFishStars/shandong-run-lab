package com.kc.dw.core.view.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.kc.dw.activity.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    public static final int LOOP_FOREVER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    private static final int WORK_BUFFER_SIZE = 16384;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private boolean isFirstFrameTransparent;
    private int loopIndex;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private byte[] workBuffer;
    private int workBufferPosition;
    private int workBufferSize;

    @Keep
    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Bitmap.Config config);

        byte[] obtainByteArray(int i);

        int[] obtainIntArray(int i);

        void release(Bitmap bitmap);

        void release(byte[] bArr);

        void release(int[] iArr);
    }

    public GifDecoder() {
        this(new SimpleBitmapProvider());
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.workBufferSize = 0;
        this.workBufferPosition = 0;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    public GifDecoder(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public GifDecoder(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i; i9++) {
            byte[] bArr = this.mainPixels;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.act[bArr[i9] & 255];
            if (i10 != 0) {
                i7 += (i10 >> 24) & 255;
                i6 += (i10 >> 16) & 255;
                i5 += (i10 >> 8) & 255;
                i4 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
            byte[] bArr2 = this.mainPixels;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr2[i12] & 255];
            if (i13 != 0) {
                i7 += (i13 >> 24) & 255;
                i6 += (i13 >> 16) & 255;
                i5 += (i13 >> 8) & 255;
                i4 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i7 / i8) << 24) | ((i6 / i8) << 16) | ((i5 / i8) << 8) | (i4 / i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v24, types: [short] */
    /* JADX WARN: Type inference failed for: r1v27 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        short s;
        this.workBufferSize = 0;
        this.workBufferPosition = 0;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i2 = gifFrame.ih;
        }
        int i3 = i * i2;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i3) {
            this.mainPixels = this.bitmapProvider.obtainByteArray(i3);
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int i4 = readByte();
        int i5 = 1;
        int i6 = 1 << i4;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = i4 + 1;
        int i10 = (1 << i9) - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            this.prefix[i11] = 0;
            this.suffix[i11] = (byte) i11;
        }
        int i12 = i9;
        int i13 = 0;
        int block = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = i8;
        int i21 = i10;
        int i22 = -1;
        while (i13 < i3) {
            int i23 = 3;
            if (block == 0) {
                block = readBlock();
                if (block <= 0) {
                    this.status = 3;
                    break;
                }
                i18 = 0;
            }
            i16 += (this.block[i18] & 255) << i15;
            i18++;
            block -= i5;
            int i24 = i15 + 8;
            i20 = i20;
            int i25 = i19;
            while (true) {
                if (i24 < i12) {
                    i19 = i25;
                    i15 = i24;
                    i9 = i9;
                    break;
                }
                int i26 = i16 & i21;
                i16 >>= i12;
                i24 -= i12;
                if (i26 != i6) {
                    if (i26 > i20) {
                        this.status = i23;
                    } else if (i26 != i7) {
                        if (i22 == -1) {
                            this.pixelStack[i17] = this.suffix[i26];
                            i17++;
                            i22 = i26;
                            i25 = i22;
                            i23 = 3;
                        } else {
                            if (i26 >= i20) {
                                this.pixelStack[i17] = (byte) i25;
                                i17++;
                                s = i22;
                            } else {
                                s = i26;
                            }
                            while (s >= i6) {
                                this.pixelStack[i17] = this.suffix[s];
                                s = this.prefix[s];
                                i17++;
                                i24 = i24;
                            }
                            int i27 = i24;
                            byte[] bArr2 = this.suffix;
                            int i28 = bArr2[s] & 255;
                            int i29 = i17 + 1;
                            int i30 = i6;
                            byte b = (byte) i28;
                            this.pixelStack[i17] = b;
                            if (i20 < 4096) {
                                this.prefix[i20] = (short) i22;
                                bArr2[i20] = b;
                                i20++;
                                if ((i20 & i21) == 0 && i20 < 4096) {
                                    i12++;
                                    i21 += i20;
                                }
                            }
                            i17 = i29;
                            while (i17 > 0) {
                                i17--;
                                this.mainPixels[i14] = this.pixelStack[i17];
                                i13++;
                                i14++;
                            }
                            i22 = i26;
                            i24 = i27;
                            i6 = i30;
                            i23 = 3;
                            i25 = i28;
                            i9 = i9;
                        }
                    }
                    i15 = i24;
                    i19 = i25;
                    break;
                }
                i12 = i9;
                i20 = i8;
                i21 = i10;
                i22 = -1;
            }
            i5 = 1;
        }
        while (i14 < i3) {
            this.mainPixels[i14] = 0;
            i14++;
        }
    }

    private void fillRect(int[] iArr, GifFrame gifFrame, int i) {
        int i2 = gifFrame.ih;
        int i3 = this.sampleSize;
        int i4 = i2 / i3;
        int i5 = gifFrame.iy / i3;
        int i6 = gifFrame.iw / i3;
        int i7 = gifFrame.ix / i3;
        int i8 = this.downsampledWidth;
        int i9 = (i5 * i8) + i7;
        int i10 = i9;
        while (i10 < (i4 * i8) + i9) {
            for (int i11 = i10; i11 < i10 + i6; i11++) {
                iArr[i11] = i;
            }
            i10 += this.downsampledWidth;
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Bitmap bitmapObtain = null;
        try {
            bitmapObtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, Bitmap.Config.ARGB_8888);
            if (bitmapObtain != null) {
                setAlpha(bitmapObtain);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bitmapObtain;
    }

    private int readBlock() {
        int i = readByte();
        if (i > 0) {
            try {
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                int i2 = this.workBufferSize;
                int i3 = this.workBufferPosition;
                int i4 = i2 - i3;
                if (i4 >= i) {
                    System.arraycopy(this.workBuffer, i3, this.block, 0, i);
                    this.workBufferPosition += i;
                } else if (this.rawData.remaining() + i4 >= i) {
                    System.arraycopy(this.workBuffer, this.workBufferPosition, this.block, 0, i4);
                    this.workBufferPosition = this.workBufferSize;
                    readChunkIfNeeded();
                    int i5 = i - i4;
                    System.arraycopy(this.workBuffer, 0, this.block, i4, i5);
                    this.workBufferPosition += i5;
                } else {
                    this.status = 1;
                }
            } catch (Exception e) {
                Log.w(TAG, "Error Reading Block", e);
                this.status = 1;
            }
        }
        return i;
    }

    private int readByte() {
        try {
            readChunkIfNeeded();
            byte[] bArr = this.workBuffer;
            int i = this.workBufferPosition;
            this.workBufferPosition = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }

    private void readChunkIfNeeded() {
        if (this.workBufferSize > this.workBufferPosition) {
            return;
        }
        if (this.workBuffer == null) {
            this.workBuffer = this.bitmapProvider.obtainByteArray(16384);
        }
        this.workBufferPosition = 0;
        int iMin = Math.min(this.rawData.remaining(), 16384);
        this.workBufferSize = iMin;
        this.rawData.get(this.workBuffer, 0, iMin);
    }

    private static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.mainScratch;
        int i6 = 0;
        if (gifFrame2 == null) {
            Arrays.fill(iArr, 0);
        }
        int i7 = 3;
        int i8 = 2;
        int i9 = 1;
        if (gifFrame2 != null && (i4 = gifFrame2.dispose) > 0) {
            if (i4 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    i5 = gifHeader.bgColor;
                    if (gifFrame.lct != null && gifHeader.bgIndex == gifFrame.transIndex) {
                    }
                    fillRect(iArr, gifFrame2, i5);
                } else if (this.framePointer == 0) {
                    this.isFirstFrameTransparent = true;
                }
                i5 = 0;
                fillRect(iArr, gifFrame2, i5);
            } else if (i4 == 3) {
                Bitmap bitmap = this.previousImage;
                if (bitmap == null) {
                    fillRect(iArr, gifFrame2, 0);
                } else {
                    int i10 = gifFrame2.ih;
                    int i11 = this.sampleSize;
                    int i12 = i10 / i11;
                    int i13 = gifFrame2.iy / i11;
                    int i14 = gifFrame2.iw / i11;
                    int i15 = gifFrame2.ix / i11;
                    int i16 = this.downsampledWidth;
                    bitmap.getPixels(iArr, (i13 * i16) + i15, i16, i15, i13, i14, i12);
                }
            }
        }
        decodeBitmapData(gifFrame);
        int i17 = gifFrame.ih;
        int i18 = this.sampleSize;
        int i19 = i17 / i18;
        int i20 = gifFrame.iy / i18;
        int i21 = gifFrame.iw / i18;
        int i22 = gifFrame.ix / i18;
        boolean z = this.framePointer == 0;
        int i23 = 8;
        int i24 = 0;
        int i25 = 1;
        while (i6 < i19) {
            if (gifFrame.interlace) {
                if (i24 >= i19) {
                    i25++;
                    if (i25 == i8) {
                        i24 = 4;
                    } else if (i25 == i7) {
                        i24 = i8;
                        i23 = 4;
                    } else if (i25 == 4) {
                        i23 = i8;
                        i24 = i9;
                    }
                }
                i2 = i24 + i23;
            } else {
                i2 = i24;
                i24 = i6;
            }
            int i26 = i24 + i20;
            if (i26 < this.downsampledHeight) {
                int i27 = this.downsampledWidth;
                int i28 = i26 * i27;
                int i29 = i28 + i22;
                int i30 = i29 + i21;
                int i31 = i28 + i27;
                if (i31 < i30) {
                    i30 = i31;
                }
                int i32 = this.sampleSize;
                int i33 = i6 * i32 * gifFrame.iw;
                int i34 = i33;
                int i35 = i29;
                while (true) {
                    i3 = i20;
                    if (i35 < i30) {
                        int i36 = i21;
                        int iAverageColorsNear = this.sampleSize == 1 ? this.act[this.mainPixels[i34] & 255] : averageColorsNear(i34, ((i30 - i29) * i32) + i33, gifFrame.iw);
                        if (iAverageColorsNear != 0) {
                            iArr[i35] = iAverageColorsNear;
                        } else if (!this.isFirstFrameTransparent && z) {
                            this.isFirstFrameTransparent = true;
                        }
                        i34 += this.sampleSize;
                        i35++;
                        i20 = i3;
                        i21 = i36;
                    }
                }
            } else {
                i3 = i20;
            }
            i6++;
            i19 = i19;
            i24 = i2;
            i20 = i3;
            i21 = i21;
            i7 = 3;
            i8 = 2;
            i9 = 1;
        }
        if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                int i37 = this.downsampledWidth;
                bitmap2.setPixels(iArr, 0, i37, 0, 0, i37, this.downsampledHeight);
            }
        }
        Bitmap nextBitmap = getNextBitmap();
        if (nextBitmap != null) {
            int i38 = this.downsampledWidth;
            nextBitmap.setPixels(iArr, 0, i38, 0, 0, i38, this.downsampledHeight);
        }
        return nextBitmap;
    }

    public boolean advance() {
        if (this.header.frameCount <= 0) {
            return false;
        }
        if (this.framePointer == getFrameCount() - 1) {
            this.loopIndex++;
        }
        GifHeader gifHeader = this.header;
        int i = gifHeader.loopCount;
        if (i != -1 && this.loopIndex > i) {
            return false;
        }
        this.framePointer = (this.framePointer + 1) % gifHeader.frameCount;
        return true;
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = false;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
        byte[] bArr3 = this.workBuffer;
        if (bArr3 != null) {
            this.bitmapProvider.release(bArr3);
        }
    }

    public int getByteSize() {
        return (this.mainScratch.length * 4) + this.rawData.limit() + this.mainPixels.length;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return gifHeader.frames.get(i).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    public int getLoopCount() {
        return this.header.loopCount;
    }

    public int getLoopIndex() {
        return this.loopIndex;
    }

    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    public Bitmap getNextFrame() {
        synchronized (this) {
            if (this.header.frameCount <= 0 || this.framePointer < 0) {
                String str = TAG;
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sbA = a.a("unable to decode frame, frameCount=");
                    sbA.append(this.header.frameCount);
                    sbA.append(" framePointer=");
                    sbA.append(this.framePointer);
                    Log.d(str, sbA.toString());
                }
                this.status = 1;
            }
            int i = this.status;
            if (i != 1 && i != 2) {
                this.status = 0;
                GifFrame gifFrame = this.header.frames.get(this.framePointer);
                int i2 = this.framePointer - 1;
                GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
                int[] iArr = gifFrame.lct;
                if (iArr == null) {
                    iArr = this.header.gct;
                }
                this.act = iArr;
                if (iArr != null) {
                    if (gifFrame.transparency) {
                        System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                        int[] iArr2 = this.pct;
                        this.act = iArr2;
                        iArr2[gifFrame.transIndex] = 0;
                    }
                    return setPixels(gifFrame, gifFrame2);
                }
                String str2 = TAG;
                if (Log.isLoggable(str2, 3)) {
                    StringBuilder sbA2 = a.a("No Valid Color Table for frame #");
                    sbA2.append(this.framePointer);
                    Log.d(str2, sbA2.toString());
                }
                this.status = 1;
                return null;
            }
            String str3 = TAG;
            if (Log.isLoggable(str3, 3)) {
                StringBuilder sbA3 = a.a("Unable to decode frame, status=");
                sbA3.append(this.status);
                Log.d(str3, sbA3.toString());
            }
            return null;
        }
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(int i, byte[] bArr) {
        int i2;
        synchronized (this) {
            GifHeader header = getHeaderParser().setData(bArr).parseHeader();
            this.header = header;
            if (bArr != null) {
                setData(header, ByteBuffer.wrap(bArr), i);
            }
            i2 = this.status;
        }
        return i2;
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 16384);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                byteArrayOutputStream.flush();
                read(2, byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void resetLoopIndex() {
        this.loopIndex = 0;
    }

    public void setData(GifHeader gifHeader, ByteBuffer byteBuffer) {
        synchronized (this) {
            setData(gifHeader, byteBuffer, 2);
        }
    }

    public void setData(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int iHighestOneBit = Integer.highestOneBit(i);
                this.status = 0;
                this.header = gifHeader;
                this.isFirstFrameTransparent = false;
                this.framePointer = -1;
                resetLoopIndex();
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (it.hasNext()) {
                    if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                }
                this.sampleSize = iHighestOneBit;
                int i2 = gifHeader.width;
                this.downsampledWidth = i2 / iHighestOneBit;
                int i3 = gifHeader.height;
                this.downsampledHeight = i3 / iHighestOneBit;
                this.mainPixels = this.bitmapProvider.obtainByteArray(i2 * i3);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        synchronized (this) {
            setData(gifHeader, ByteBuffer.wrap(bArr));
        }
    }

    public boolean setFrameIndex(int i) {
        if (i < -1 || i >= getFrameCount()) {
            return false;
        }
        this.framePointer = i;
        return true;
    }
}
