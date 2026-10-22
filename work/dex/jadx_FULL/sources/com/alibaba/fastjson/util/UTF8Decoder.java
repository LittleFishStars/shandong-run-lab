package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] cArrArray = charBuffer.array();
        int iArrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int iArrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int iMin = Math.min(iArrayOffset2 - iArrayOffset, iArrayOffset4 - iArrayOffset3) + iArrayOffset3;
        while (iArrayOffset3 < iMin) {
            byte b = bArrArray[iArrayOffset];
            if (b < 0) {
                break;
            }
            iArrayOffset++;
            cArrArray[iArrayOffset3] = (char) b;
            iArrayOffset3++;
        }
        int i2 = iArrayOffset;
        while (true) {
            int i3 = iArrayOffset3;
            while (i2 < iArrayOffset2) {
                byte b2 = bArrArray[i2];
                if (b2 < 0) {
                    if ((b2 >> 5) == -2) {
                        if (iArrayOffset2 - i2 < 2 || i3 >= iArrayOffset4) {
                            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 2);
                        }
                        byte b3 = bArrArray[i2 + 1];
                        if (isMalformed2(b2, b3)) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 2);
                        }
                        i = i3 + 1;
                        cArrArray[i3] = (char) (((b2 << 6) ^ b3) ^ 3968);
                        i2 += 2;
                    } else if ((b2 >> 4) == -2) {
                        if (iArrayOffset2 - i2 < 3 || i3 >= iArrayOffset4) {
                            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 3);
                        }
                        byte b4 = bArrArray[i2 + 1];
                        byte b5 = bArrArray[i2 + 2];
                        if (isMalformed3(b2, b4, b5)) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 3);
                        }
                        i = i3 + 1;
                        cArrArray[i3] = (char) ((((b2 << 12) ^ (b4 << 6)) ^ b5) ^ 8064);
                        i2 += 3;
                    } else {
                        if ((b2 >> 3) != -2) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 1);
                        }
                        if (iArrayOffset2 - i2 < 4 || iArrayOffset4 - i3 < 2) {
                            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 4);
                        }
                        byte b6 = bArrArray[i2 + 1];
                        byte b7 = bArrArray[i2 + 2];
                        byte b8 = bArrArray[i2 + 3];
                        int i4 = ((b2 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                        if (isMalformed4(b6, b7, b8) || i4 < 65536 || i4 > 1114111) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 4);
                        }
                        int i5 = i3 + 1;
                        int i6 = i4 - 65536;
                        cArrArray[i3] = (char) (((i6 >> 10) & 1023) | 55296);
                        iArrayOffset3 = i5 + 1;
                        cArrArray[i5] = (char) ((i6 & 1023) | 56320);
                        i2 += 4;
                    }
                    i3 = i;
                } else {
                    if (i3 >= iArrayOffset4) {
                        return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 1);
                    }
                    iArrayOffset3 = i3 + 1;
                    cArrArray[i3] = (char) b2;
                    i2++;
                }
            }
            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 0);
        }
    }

    private static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult coderResultMalformedN = malformedN(byteBuffer, i3);
        byteBuffer.position(i);
        charBuffer.position(i2);
        return coderResultMalformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
            byte b = byteBuffer.get();
            if ((b >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            }
            if ((b >> 1) == -2) {
                return byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 6);
            }
            return CoderResult.malformedForLength(1);
        }
        if (i == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i == 3) {
            byte b2 = byteBuffer.get();
            byte b3 = byteBuffer.get();
            if ((b2 != -32 || (b3 & 224) != 128) && !isNotContinuation(b3)) {
                i2 = 2;
            }
            return CoderResult.malformedForLength(i2);
        }
        if (i != 4) {
            throw new IllegalStateException();
        }
        int i3 = byteBuffer.get() & 255;
        int i4 = byteBuffer.get() & 255;
        if (i3 > 244 || ((i3 == 240 && (i4 < 144 || i4 > 191)) || ((i3 == 244 && (i4 & 240) != 128) || isNotContinuation(i4)))) {
            return CoderResult.malformedForLength(1);
        }
        return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        return (i4 == 0 || i2 - i < i4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
