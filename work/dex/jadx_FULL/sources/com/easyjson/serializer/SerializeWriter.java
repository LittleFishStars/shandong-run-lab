package com.easyjson.serializer;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.common.utils.IOUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.easyjson.JSON;
import com.easyjson.JSONException;
import com.easyjson.parser.JSONLexer;
import com.google.common.net.c;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS;
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    static final int[] sizeTable = {9, 99, 999, AVMDLDataLoader.KeyIsEnableEventInfo, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 <= 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = IOUtils.DIR_SEPARATOR_WINDOWS;
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(int i) {
        this(null, i);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public SerializeWriter(Writer writer, int i) {
        this.writer = writer;
        if (i > 0) {
            this.buf = new char[i];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.mask;
        }
        this.features = i;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            j = -j;
            c = '-';
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i - 1;
            cArr[i3] = DigitOnes[i2];
            i = i3 - 1;
            cArr[i] = DigitTens[i2];
            j = j2;
        }
        int i4 = (int) j;
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i - 1;
            cArr[i7] = DigitOnes[i6];
            i = i7 - 1;
            cArr[i] = DigitTens[i6];
            i4 = i5;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            i--;
            cArr[i] = digits[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            } else {
                i4 = i8;
            }
        }
        if (c != 0) {
            cArr[i - 1] = c;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char cCharAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    write(34);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (cCharAt2 < bArr2.length && bArr2[cCharAt2] != 0) {
                        write(92);
                        cCharAt2 = replaceChars[cCharAt2];
                    }
                    write(cCharAt2);
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count + 3;
            if (i4 > this.buf.length) {
                expandCapacity(i4);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            cArr[i5] = '\"';
            int i7 = i6 + 1;
            cArr[i6] = '\"';
            this.count = i7 + 1;
            cArr[i7] = c.b;
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 2, i9 - i10);
                    char[] cArr4 = this.buf;
                    cArr4[i10] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i11] = replaceChars[c];
                    i9++;
                    i10 = i11;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr5 = this.buf;
                    int i12 = i10 + 1;
                    System.arraycopy(cArr5, i12, cArr5, i10 + 3, (i9 - i10) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i10);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = '\"';
                    cArr7[i12] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i13 = i12 + 1;
                    cArr7[i13] = replaceChars[c];
                    i9 += 2;
                    cArr7[this.count - 2] = '\"';
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
        }
        this.buf[this.count - 1] = c.b;
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char cCharAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    write(39);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (cCharAt2 < bArr2.length && bArr2[cCharAt2] != 0) {
                        write(92);
                        cCharAt2 = replaceChars[cCharAt2];
                    }
                    write(cCharAt2);
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count + 3;
            if (i4 > this.buf.length) {
                expandCapacity(i4);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            cArr[i6] = '\'';
            this.count = i7 + 1;
            cArr[i7] = c.b;
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 2, i9 - i10);
                    char[] cArr4 = this.buf;
                    cArr4[i10] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i11] = replaceChars[c];
                    i9++;
                    i10 = i11;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr5 = this.buf;
                    int i12 = i10 + 1;
                    System.arraycopy(cArr5, i12, cArr5, i10 + 3, (i9 - i10) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i10);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = '\'';
                    cArr7[i12] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i13 = i12 + 1;
                    cArr7[i13] = replaceChars[c];
                    i9 += 2;
                    cArr7[this.count - 2] = '\'';
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
        }
        this.buf[i - 1] = c.b;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i, i2).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        int i;
        if (z) {
            i = serializerFeature.mask | this.features;
        } else {
            i = (~serializerFeature.mask) & this.features;
        }
        this.features = i;
    }

    public void expandCapacity(int i) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (str == null) {
            str = "UTF-8";
        }
        try {
            return new String(this.buf, 0, this.count).getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new JSONException("toBytes error", e);
        }
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 <= this.buf.length) {
            i2 = i3;
        } else if (this.writer == null) {
            expandCapacity(i3);
            i2 = i3;
        } else {
            flush();
        }
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    } else {
                        i = i3;
                    }
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void write(boolean z) {
        write(z ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    System.arraycopy(cArr, i, cArr2, i5, i6);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    i += i6;
                } while (i2 > this.buf.length);
                i4 = i2;
            }
        }
        System.arraycopy(cArr, i, this.buf, this.count, i2);
        this.count = i4;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean z = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                int i5 = 0;
                while (i5 < i) {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                    write(cArr[(i8 >>> 18) & 63]);
                    write(cArr[(i8 >>> 12) & 63]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(cArr[i8 & 63]);
                    i5 = i7 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = ((bArr[i] & 255) << 10) | (i9 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i10 >> 12]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(i9 == 2 ? cArr[i10 & 63] : '=');
                    write(61);
                }
                write(c);
                return;
            }
            expandCapacity(i4);
        }
        this.count = i4;
        int i11 = i3 + 1;
        this.buf[i3] = c;
        int i12 = 0;
        while (i12 < i) {
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
            int i16 = i14 + 1;
            int i17 = i15 | (bArr[i14] & 255);
            char[] cArr2 = this.buf;
            int i18 = i11 + 1;
            cArr2[i11] = cArr[(i17 >>> 18) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(i17 >>> 12) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(i17 >>> 6) & 63];
            i11 = i20 + 1;
            cArr2[i20] = cArr[i17 & 63];
            i12 = i16;
        }
        int i21 = length - i;
        if (i21 > 0) {
            int i22 = ((bArr[i] & 255) << 10) | (i21 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i21 == 2 ? cArr[i22 & 63] : '=';
            cArr3[i4 - 2] = com.alipay.sdk.m.p.a.h;
        }
        this.buf[i4 - 1] = c;
    }

    public void writeFieldName(String str, boolean z) {
        int i = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i) == 0) {
            if ((i & SerializerFeature.QuoteFieldNames.mask) != 0) {
                writeStringWithDoubleQuote(str, c.b, z);
                return;
            } else {
                writeKeyWithDoubleQuoteIfHasSpecial(str);
                return;
            }
        }
        if ((SerializerFeature.QuoteFieldNames.mask & i) == 0) {
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else {
            writeStringWithSingleQuote(str);
            write(58);
        }
    }

    public void writeInt(int i) {
        int i2;
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i3 = i < 0 ? -i : i;
        int i4 = 0;
        do {
            i2 = sizeTable[i4];
            i4++;
        } while (i3 > i2);
        if (i < 0) {
            i4++;
        }
        int i5 = this.count + i4;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i4];
                getChars(i, i4, cArr);
                write(cArr, 0, i4);
                return;
            }
            expandCapacity(i5);
        }
        getChars(i, i5, this.buf);
        this.count = i5;
    }

    public void writeLong(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j2 = j < 0 ? -j : j;
        int i = 1;
        long j3 = 10;
        while (true) {
            if (i >= 19) {
                i = 0;
                break;
            } else {
                if (j2 < j3) {
                    break;
                }
                j3 *= 10;
                i++;
            }
        }
        int i2 = i != 0 ? i : 19;
        if (j < 0) {
            i2++;
        }
        int i3 = this.count + i2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i2];
                getChars(j, i2, cArr);
                write(cArr, 0, i2);
                return;
            }
            expandCapacity(i3);
        }
        getChars(j, i3, this.buf);
        this.count = i3;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x027c A[PHI: r4 r7
      0x027c: PHI (r4v29 int) = (r4v26 int), (r4v33 int) binds: [B:150:0x027a, B:114:0x022d] A[DONT_GENERATE, DONT_INLINE]
      0x027c: PHI (r7v9 int) = (r7v7 int), (r7v13 int) binds: [B:150:0x027a, B:114:0x022d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:153:0x0280 A[PHI: r4 r7 r8
      0x0280: PHI (r4v32 int) = (r4v26 int), (r4v28 int), (r4v33 int) binds: [B:150:0x027a, B:124:0x023f, B:114:0x022d] A[DONT_GENERATE, DONT_INLINE]
      0x0280: PHI (r7v12 int) = (r7v7 int), (r7v8 int), (r7v13 int) binds: [B:150:0x027a, B:124:0x023f, B:114:0x022d] A[DONT_GENERATE, DONT_INLINE]
      0x0280: PHI (r8v19 int) = (r8v2 int), (r8v14 int), (r8v2 int) binds: [B:150:0x027a, B:124:0x023f, B:114:0x022d] A[DONT_GENERATE, DONT_INLINE]] */
    public void writeStringWithDoubleQuote(String str, char c, boolean z) {
        int i;
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i2 = this.count + length + 2;
        if (c != 0) {
            i2++;
        }
        char c2 = '\r';
        char c3 = ' ';
        char c4 = '/';
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                int i3 = 0;
                while (i3 < str.length()) {
                    char cCharAt = str.charAt(i3);
                    int i4 = this.features;
                    if ((SerializerFeature.BrowserCompatible.mask & i4) == 0) {
                        byte[] bArr = specicalFlags_doubleQuotes;
                        if ((cCharAt < bArr.length && bArr[cCharAt] != 0) || (cCharAt == '/' && (i4 & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                            write(92);
                            cCharAt = replaceChars[cCharAt];
                        }
                    } else if (cCharAt == '\b' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                        write(92);
                        cCharAt = replaceChars[cCharAt];
                    } else if (cCharAt < c3) {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr = ascii_chars;
                        int i5 = cCharAt * 2;
                        write(cArr[i5]);
                        cCharAt = cArr[i5 + 1];
                    } else if (cCharAt >= 127) {
                        write(92);
                        write(117);
                        char[] cArr2 = DIGITS;
                        write(cArr2[(cCharAt >>> '\f') & 15]);
                        write(cArr2[(cCharAt >>> '\b') & 15]);
                        write(cArr2[(cCharAt >>> 4) & 15]);
                        cCharAt = cArr2[cCharAt & 15];
                    }
                    write(cCharAt);
                    i3++;
                    c3 = ' ';
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i2);
        }
        int i6 = this.count;
        int i7 = i6 + 1;
        int i8 = i7 + length;
        char[] cArr3 = this.buf;
        cArr3[i6] = '\"';
        str.getChars(0, length, cArr3, i7);
        this.count = i2;
        int i9 = -1;
        if ((this.features & SerializerFeature.BrowserCompatible.mask) != 0) {
            for (int i10 = i7; i10 < i8; i10++) {
                char c5 = this.buf[i10];
                if (c5 == '\"' || c5 == '/' || c5 == '\\' || c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                    i2++;
                } else {
                    if (c5 < ' ' || c5 >= 127) {
                        i2 += 5;
                    }
                }
                i9 = i10;
            }
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            this.count = i2;
            while (i9 >= i7) {
                char[] cArr4 = this.buf;
                char c6 = cArr4[i9];
                if (c6 == '\b' || c6 == '\f' || c6 == '\n' || c6 == c2 || c6 == '\t') {
                    int i11 = i9 + 1;
                    System.arraycopy(cArr4, i11, cArr4, i9 + 2, (i8 - i9) - 1);
                    char[] cArr5 = this.buf;
                    cArr5[i9] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr5[i11] = replaceChars[c6];
                } else {
                    if (c6 == '\"' || c6 == '/' || c6 == '\\') {
                        int i12 = i9 + 1;
                        System.arraycopy(cArr4, i12, cArr4, i9 + 2, (i8 - i9) - 1);
                        char[] cArr6 = this.buf;
                        cArr6[i9] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr6[i12] = c6;
                    } else {
                        if (c6 < ' ') {
                            int i13 = i9 + 1;
                            System.arraycopy(cArr4, i13, cArr4, i9 + 6, (i8 - i9) - 1);
                            char[] cArr7 = this.buf;
                            cArr7[i9] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr7[i13] = 'u';
                            cArr7[i9 + 2] = '0';
                            cArr7[i9 + 3] = '0';
                            char[] cArr8 = ascii_chars;
                            int i14 = c6 * 2;
                            cArr7[i9 + 4] = cArr8[i14];
                            cArr7[i9 + 5] = cArr8[i14 + 1];
                        } else if (c6 >= 127) {
                            int i15 = i9 + 1;
                            System.arraycopy(cArr4, i15, cArr4, i9 + 6, (i8 - i9) - 1);
                            char[] cArr9 = this.buf;
                            cArr9[i9] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr9[i15] = 'u';
                            char[] cArr10 = DIGITS;
                            cArr9[i9 + 2] = cArr10[(c6 >>> '\f') & 15];
                            cArr9[i9 + 3] = cArr10[(c6 >>> '\b') & 15];
                            cArr9[i9 + 4] = cArr10[(c6 >>> 4) & 15];
                            cArr9[i9 + 5] = cArr10[c6 & 15];
                        }
                        i8 += 5;
                    }
                    i9--;
                    c2 = '\r';
                }
                i8++;
                i9--;
                c2 = '\r';
            }
            if (c == 0) {
                this.buf[this.count - 1] = '\"';
                return;
            }
            char[] cArr11 = this.buf;
            int i16 = this.count;
            cArr11[i16 - 2] = '\"';
            cArr11[i16 - 1] = c;
            return;
        }
        if (z) {
            int i17 = 0;
            char c7 = 0;
            int i18 = -1;
            int i19 = -1;
            int i20 = i7;
            while (i20 < i8) {
                char c8 = this.buf[i20];
                if (c8 == 8232) {
                    i17++;
                    i2 += 4;
                    if (i18 == -1) {
                        i18 = i20;
                        i19 = i18;
                    } else {
                        i19 = i20;
                    }
                    c7 = c8;
                } else if (c8 < ']') {
                    if (c8 != ' ' && ((c8 == c4 && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0) || ((c8 <= '#' || c8 == '\\') && (c8 <= 31 || c8 == '\\' || c8 == '\"')))) {
                        i17++;
                        byte[] bArr2 = specicalFlags_doubleQuotes;
                        if (c8 < bArr2.length && bArr2[c8] == 4) {
                            i2 += 4;
                        }
                        if (i18 == -1) {
                            i18 = i20;
                            i19 = i18;
                        } else {
                            i19 = i20;
                        }
                        c7 = c8;
                    }
                } else if (c8 >= 127 && c8 <= 160) {
                    if (i18 == -1) {
                        i18 = i20;
                    }
                    i17++;
                    i2 += 4;
                    i19 = i20;
                    c7 = c8;
                }
                i20++;
                c4 = '/';
            }
            if (i17 > 0) {
                int i21 = i2 + i17;
                if (i21 > this.buf.length) {
                    expandCapacity(i21);
                }
                this.count = i21;
                if (i17 == 1) {
                    if (c7 == 8232) {
                        int i22 = i19 + 1;
                        char[] cArr12 = this.buf;
                        System.arraycopy(cArr12, i22, cArr12, i19 + 6, (i8 - i19) - 1);
                        char[] cArr13 = this.buf;
                        cArr13[i19] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr13[i22] = 'u';
                        int i23 = i22 + 1;
                        cArr13[i23] = '2';
                        int i24 = i23 + 1;
                        cArr13[i24] = '0';
                        int i25 = i24 + 1;
                        cArr13[i25] = '2';
                        cArr13[i25 + 1] = '8';
                    } else {
                        byte[] bArr3 = specicalFlags_doubleQuotes;
                        if (c7 >= bArr3.length || bArr3[c7] != 4) {
                            int i26 = i19 + 1;
                            char[] cArr14 = this.buf;
                            System.arraycopy(cArr14, i26, cArr14, i19 + 2, (i8 - i19) - 1);
                            char[] cArr15 = this.buf;
                            cArr15[i19] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr15[i26] = replaceChars[c7];
                        } else {
                            int i27 = i19 + 1;
                            char[] cArr16 = this.buf;
                            System.arraycopy(cArr16, i27, cArr16, i19 + 6, (i8 - i19) - 1);
                            char[] cArr17 = this.buf;
                            cArr17[i19] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            int i28 = i27 + 1;
                            cArr17[i27] = 'u';
                            int i29 = i28 + 1;
                            char[] cArr18 = DIGITS;
                            cArr17[i28] = cArr18[(c7 >>> '\f') & 15];
                            int i30 = i29 + 1;
                            cArr17[i29] = cArr18[(c7 >>> '\b') & 15];
                            cArr17[i30] = cArr18[(c7 >>> 4) & 15];
                            cArr17[i30 + 1] = cArr18[c7 & 15];
                        }
                    }
                } else if (i17 > 1) {
                    for (int i31 = i18 - i7; i31 < str.length(); i31++) {
                        char cCharAt2 = str.charAt(i31);
                        byte[] bArr4 = specicalFlags_doubleQuotes;
                        if ((cCharAt2 < bArr4.length && bArr4[cCharAt2] != 0) || (cCharAt2 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                            char[] cArr19 = this.buf;
                            int i32 = i18 + 1;
                            cArr19[i18] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            if (bArr4[cCharAt2] == 4) {
                                int i33 = i32 + 1;
                                cArr19[i32] = 'u';
                                int i34 = i33 + 1;
                                char[] cArr20 = DIGITS;
                                cArr19[i33] = cArr20[(cCharAt2 >>> '\f') & 15];
                                int i35 = i34 + 1;
                                cArr19[i34] = cArr20[(cCharAt2 >>> '\b') & 15];
                                int i36 = i35 + 1;
                                cArr19[i35] = cArr20[(cCharAt2 >>> 4) & 15];
                                i = i36 + 1;
                                cArr19[i36] = cArr20[cCharAt2 & 15];
                            } else {
                                i = i32 + 1;
                                cArr19[i32] = replaceChars[cCharAt2];
                            }
                            i18 = i;
                        } else if (cCharAt2 == 8232) {
                            char[] cArr21 = this.buf;
                            int i37 = i18 + 1;
                            cArr21[i18] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            int i38 = i37 + 1;
                            cArr21[i37] = 'u';
                            int i39 = i38 + 1;
                            char[] cArr22 = DIGITS;
                            cArr21[i38] = cArr22[(cCharAt2 >>> '\f') & 15];
                            int i40 = i39 + 1;
                            cArr21[i39] = cArr22[(cCharAt2 >>> '\b') & 15];
                            int i41 = i40 + 1;
                            cArr21[i40] = cArr22[(cCharAt2 >>> 4) & 15];
                            i18 = i41 + 1;
                            cArr21[i41] = cArr22[cCharAt2 & 15];
                        } else {
                            this.buf[i18] = cCharAt2;
                            i18++;
                        }
                    }
                }
            }
        }
        if (c == 0) {
            this.buf[this.count - 1] = '\"';
            return;
        }
        char[] cArr23 = this.buf;
        int i42 = this.count;
        cArr23[i42 - 2] = '\"';
        cArr23[i42 - 1] = c;
    }

    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        cCharAt = replaceChars[cCharAt];
                    }
                    write(cCharAt);
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.buf[i8];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i10] = replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i11] = replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char[] cArr6 = this.buf;
                char c3 = cArr6[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i14] = replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }
}
