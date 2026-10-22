package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import com.alipay.sdk.m.p.a;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.google.common.net.c;
import com.zj.adlib.dv9;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class SerializeWriter extends Writer {
    private static int BUFFER_THRESHOLD;
    static final int nonDirectFeatures;
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    private static final char[] VALUE_TRUE = ":true".toCharArray();
    private static final char[] VALUE_FALSE = ":false".toCharArray();

    static {
        int i;
        BUFFER_THRESHOLD = 131072;
        try {
            String stringProperty = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");
            if (stringProperty != null && stringProperty.length() > 0 && (i = Integer.parseInt(stringProperty)) >= 64 && i <= 65536) {
                BUFFER_THRESHOLD = i * 1024;
            }
        } catch (Throwable unused) {
        }
        nonDirectFeatures = SerializerFeature.UseSingleQuotes.mask | 0 | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i ? new byte[i] : bArr;
        int iEncodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr2);
        outputStream.write(bArr2, 0, iEncodeUTF8);
        if (bArr2 != bArr && bArr2.length <= BUFFER_THRESHOLD) {
            threadLocal.set(bArr2);
        }
        return iEncodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i ? new byte[i] : bArr;
        int iEncodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr2);
        byte[] bArr3 = new byte[iEncodeUTF8];
        System.arraycopy(bArr2, 0, bArr3, 0, iEncodeUTF8);
        if (bArr2 != bArr && bArr2.length <= BUFFER_THRESHOLD) {
            threadLocal.set(bArr2);
        }
        return bArr3;
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char cCharAt = str.charAt(i3);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt2]);
                    }
                    i2++;
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
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
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
            if (c < bArr.length && bArr[c] != 0) {
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
                    cArr4[i10] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i11] = IOUtils.replaceChars[c];
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
                    System.arraycopy(cArr6, i2, cArr6, 1, i10);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = '\'';
                    cArr7[i12] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i13 = i12 + 1;
                    cArr7[i13] = IOUtils.replaceChars[c];
                    i9 += 2;
                    cArr7[this.count - 2] = '\'';
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
            i2 = 0;
        }
        this.buf[i - 1] = c.b;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= BUFFER_THRESHOLD) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void computeFeatures() {
        long j;
        int i = this.features;
        boolean z = (SerializerFeature.QuoteFieldNames.mask & i) != 0;
        this.quoteFieldNames = z;
        boolean z2 = (SerializerFeature.UseSingleQuotes.mask & i) != 0;
        this.useSingleQuotes = z2;
        this.sortField = (SerializerFeature.SortField.mask & i) != 0;
        this.disableCircularReferenceDetect = (SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0;
        boolean z3 = (SerializerFeature.BeanToArray.mask & i) != 0;
        this.beanToArray = z3;
        this.writeNonStringValueAsString = (SerializerFeature.WriteNonStringValueAsString.mask & i) != 0;
        this.notWriteDefaultValue = (SerializerFeature.NotWriteDefaultValue.mask & i) != 0;
        boolean z4 = (SerializerFeature.WriteEnumUsingName.mask & i) != 0;
        this.writeEnumUsingName = z4;
        this.writeEnumUsingToString = (SerializerFeature.WriteEnumUsingToString.mask & i) != 0;
        this.writeDirect = z && (nonDirectFeatures & i) == 0 && (z3 || z4);
        this.keySeperator = z2 ? '\'' : '\"';
        boolean z5 = (SerializerFeature.BrowserSecure.mask & i) != 0;
        this.browserSecure = z5;
        if (z5) {
            j = 5764610843043954687L;
        } else {
            j = (i & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        }
        this.sepcialBits = j;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i) {
        ThreadLocal<char[]> threadLocal;
        char[] cArr;
        int i2 = this.maxBufSize;
        if (i2 != -1 && i >= i2) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i);
        }
        char[] cArr2 = this.buf;
        int length = cArr2.length + (cArr2.length >> 1) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr3 = new char[i];
        System.arraycopy(cArr2, 0, cArr3, 0, this.count);
        if (this.buf.length < BUFFER_THRESHOLD && ((cArr = (threadLocal = bufLocal).get()) == null || cArr.length < this.buf.length)) {
            threadLocal.set(this.buf);
        }
        this.buf = cArr3;
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

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void reset() {
        this.count = 0;
    }

    public void setMaxBufSize(int i) {
        if (i >= this.buf.length) {
            this.maxBufSize = i;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        return toBytes((str == null || "UTF-8".equals(str)) ? IOUtils.UTF8 : Charset.forName(str));
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i = this.count;
        char[] cArr = new char[i];
        System.arraycopy(this.buf, 0, cArr, 0, i);
        return cArr;
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i = this.count;
        char[] cArr = new char[i - 2];
        System.arraycopy(this.buf, 1, cArr, 0, i - 2);
        return cArr;
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

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        boolean z = this.useSingleQuotes;
        char c = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
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
            cArr3[i4 - 2] = a.h;
        }
        this.buf[i4 - 1] = c;
    }

    public void writeDouble(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            writeNull();
            return;
        }
        int i = this.count + 24;
        if (i > this.buf.length) {
            if (this.writer != null) {
                String string = RyuDouble.toString(d);
                write(string, 0, string.length());
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            expandCapacity(i);
        }
        this.count += RyuDouble.toString(d, this.buf, this.count);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> r2) {
        String string;
        if (r2 == null) {
            writeNull();
            return;
        }
        if (!this.writeEnumUsingName || this.writeEnumUsingToString) {
            string = this.writeEnumUsingToString ? r2.toString() : null;
        } else {
            string = r2.name();
        }
        if (string == null) {
            writeInt(r2.ordinal());
            return;
        }
        int i = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i);
        write(string);
        write(i);
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i = this.count + length + 3;
        if (i > this.buf.length) {
            expandCapacity(i);
        }
        int i2 = this.count;
        char[] cArr = this.buf;
        cArr[i2] = '\"';
        str.getChars(0, length, cArr, i2 + 1);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i - 2] = '\"';
        cArr2[i - 1] = c.b;
    }

    public void writeFieldValue(char c, String str, char c2) {
        write(c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c, String str, String str2) {
        int length = str.length();
        int i = this.count;
        int length2 = str2.length();
        int i2 = i + length + length2 + 6;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, c.b);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i2);
        }
        char[] cArr = this.buf;
        int i3 = this.count;
        cArr[i3] = c;
        int i4 = i3 + 2;
        int i5 = i4 + length;
        cArr[i3 + 1] = '\"';
        str.getChars(0, length, cArr, i4);
        this.count = i2;
        char[] cArr2 = this.buf;
        cArr2[i5] = '\"';
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        cArr2[i6] = c.b;
        cArr2[i7] = '\"';
        str2.getChars(0, length2, cArr2, i7 + 1);
        this.buf[this.count - 1] = '\"';
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00d4  */
    public void writeFieldValueStringWithDoubleQuoteCheck(char c, String str, String str2) {
        int length;
        int i;
        int i2;
        int length2 = str.length();
        int i3 = this.count;
        if (str2 == null) {
            i = i3 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i = i3 + length2 + length + 6;
        }
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, c.b);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i);
        }
        char[] cArr = this.buf;
        int i4 = this.count;
        cArr[i4] = c;
        int i5 = i4 + 2;
        int i6 = i5 + length2;
        cArr[i4 + 1] = '\"';
        str.getChars(0, length2, cArr, i5);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i6] = '\"';
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        cArr2[i7] = c.b;
        if (str2 == null) {
            int i9 = i8 + 1;
            cArr2[i8] = 'n';
            int i10 = i9 + 1;
            cArr2[i9] = 'u';
            cArr2[i10] = 'l';
            cArr2[i10 + 1] = 'l';
            return;
        }
        int i11 = i8 + 1;
        cArr2[i8] = '\"';
        int i12 = i11 + length;
        str2.getChars(0, length, cArr2, i11);
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = 0;
        char c2 = 0;
        for (int i17 = i11; i17 < i12; i17++) {
            char c3 = this.buf[i17];
            if (c3 < ']') {
                if ((c3 < '@' && (this.sepcialBits & (1 << c3)) != 0) || c3 == '\\') {
                    i16++;
                    if (c3 == '(' || c3 == ')' || c3 == '<' || c3 == '>') {
                        i += 4;
                    } else {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if (c3 < bArr.length && bArr[c3] == 4) {
                            i += 4;
                        }
                    }
                    i13 = -1;
                    if (i14 == -1) {
                        i14 = i17;
                        i15 = i14;
                    } else {
                        i15 = i17;
                    }
                    c2 = c3;
                } else {
                    i13 = -1;
                }
            } else if (c3 >= 127 && (c3 == 8232 || c3 == 8233 || c3 < 160)) {
                if (i14 == i13) {
                    i14 = i17;
                }
                i16++;
                i += 4;
                i15 = i17;
                c2 = c3;
            }
        }
        if (i16 > 0) {
            int i18 = i + i16;
            if (i18 > this.buf.length) {
                expandCapacity(i18);
            }
            this.count = i18;
            if (i16 == 1) {
                if (c2 == 8232) {
                    int i19 = i15 + 1;
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i19, cArr3, i15 + 6, (i12 - i15) - 1);
                    char[] cArr4 = this.buf;
                    cArr4[i15] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i19] = 'u';
                    int i20 = i19 + 1;
                    cArr4[i20] = '2';
                    int i21 = i20 + 1;
                    cArr4[i21] = '0';
                    int i22 = i21 + 1;
                    cArr4[i22] = '2';
                    cArr4[i22 + 1] = '8';
                } else if (c2 == 8233) {
                    int i23 = i15 + 1;
                    char[] cArr5 = this.buf;
                    System.arraycopy(cArr5, i23, cArr5, i15 + 6, (i12 - i15) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i15] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr6[i23] = 'u';
                    int i24 = i23 + 1;
                    cArr6[i24] = '2';
                    int i25 = i24 + 1;
                    cArr6[i25] = '0';
                    int i26 = i25 + 1;
                    cArr6[i26] = '2';
                    cArr6[i26 + 1] = '9';
                } else if (c2 == '(' || c2 == ')' || c2 == '<' || c2 == '>') {
                    int i27 = i15 + 1;
                    char[] cArr7 = this.buf;
                    System.arraycopy(cArr7, i27, cArr7, i15 + 6, (i12 - i15) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i15] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i28 = i27 + 1;
                    cArr8[i27] = 'u';
                    int i29 = i28 + 1;
                    char[] cArr9 = IOUtils.DIGITS;
                    cArr8[i28] = cArr9[(c2 >>> '\f') & 15];
                    int i30 = i29 + 1;
                    cArr8[i29] = cArr9[(c2 >>> '\b') & 15];
                    cArr8[i30] = cArr9[(c2 >>> 4) & 15];
                    cArr8[i30 + 1] = cArr9[c2 & 15];
                } else {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c2 >= bArr2.length || bArr2[c2] != 4) {
                        int i31 = i15 + 1;
                        char[] cArr10 = this.buf;
                        System.arraycopy(cArr10, i31, cArr10, i15 + 2, (i12 - i15) - 1);
                        char[] cArr11 = this.buf;
                        cArr11[i15] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr11[i31] = IOUtils.replaceChars[c2];
                    } else {
                        int i32 = i15 + 1;
                        char[] cArr12 = this.buf;
                        System.arraycopy(cArr12, i32, cArr12, i15 + 6, (i12 - i15) - 1);
                        char[] cArr13 = this.buf;
                        cArr13[i15] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        int i33 = i32 + 1;
                        cArr13[i32] = 'u';
                        int i34 = i33 + 1;
                        char[] cArr14 = IOUtils.DIGITS;
                        cArr13[i33] = cArr14[(c2 >>> '\f') & 15];
                        int i35 = i34 + 1;
                        cArr13[i34] = cArr14[(c2 >>> '\b') & 15];
                        cArr13[i35] = cArr14[(c2 >>> 4) & 15];
                        cArr13[i35 + 1] = cArr14[c2 & 15];
                    }
                }
            } else if (i16 > 1) {
                for (int i36 = i14 - i11; i36 < str2.length(); i36++) {
                    char cCharAt = str2.charAt(i36);
                    if (this.browserSecure) {
                        if (cCharAt != '(' && cCharAt != ')') {
                            if (cCharAt == '<' || cCharAt == '>') {
                            }
                        }
                        char[] cArr15 = this.buf;
                        int i37 = i14 + 1;
                        cArr15[i14] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        int i38 = i37 + 1;
                        cArr15[i37] = 'u';
                        int i39 = i38 + 1;
                        char[] cArr16 = IOUtils.DIGITS;
                        cArr15[i38] = cArr16[(cCharAt >>> '\f') & 15];
                        int i40 = i39 + 1;
                        cArr15[i39] = cArr16[(cCharAt >>> '\b') & 15];
                        int i41 = i40 + 1;
                        cArr15[i40] = cArr16[(cCharAt >>> 4) & 15];
                        i14 = i41 + 1;
                        cArr15[i41] = cArr16[cCharAt & 15];
                    }
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if ((cCharAt >= bArr3.length || bArr3[cCharAt] == 0) && !(cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        if (cCharAt == 8232 || cCharAt == 8233) {
                            char[] cArr17 = this.buf;
                            int i42 = i14 + 1;
                            cArr17[i14] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            int i43 = i42 + 1;
                            cArr17[i42] = 'u';
                            int i44 = i43 + 1;
                            char[] cArr18 = IOUtils.DIGITS;
                            cArr17[i43] = cArr18[(cCharAt >>> '\f') & 15];
                            int i45 = i44 + 1;
                            cArr17[i44] = cArr18[(cCharAt >>> '\b') & 15];
                            int i46 = i45 + 1;
                            cArr17[i45] = cArr18[(cCharAt >>> 4) & 15];
                            i14 = i46 + 1;
                            cArr17[i46] = cArr18[cCharAt & 15];
                        } else {
                            this.buf[i14] = cCharAt;
                            i14++;
                        }
                    } else {
                        char[] cArr19 = this.buf;
                        int i47 = i14 + 1;
                        cArr19[i14] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        if (bArr3[cCharAt] == 4) {
                            int i48 = i47 + 1;
                            cArr19[i47] = 'u';
                            int i49 = i48 + 1;
                            char[] cArr20 = IOUtils.DIGITS;
                            cArr19[i48] = cArr20[(cCharAt >>> '\f') & 15];
                            int i50 = i49 + 1;
                            cArr19[i49] = cArr20[(cCharAt >>> '\b') & 15];
                            int i51 = i50 + 1;
                            cArr19[i50] = cArr20[(cCharAt >>> 4) & 15];
                            i2 = i51 + 1;
                            cArr19[i51] = cArr20[cCharAt & 15];
                        } else {
                            i2 = i47 + 1;
                            cArr19[i47] = IOUtils.replaceChars[cCharAt];
                        }
                        i14 = i2;
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeFloat(float f, boolean z) {
        if (f != f || f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) {
            writeNull();
            return;
        }
        int i = this.count + 15;
        if (i > this.buf.length) {
            if (this.writer != null) {
                String string = RyuFloat.toString(f);
                write(string, 0, string.length());
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            expandCapacity(i);
        }
        this.count += RyuFloat.toString(f, this.buf, this.count);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeHex(byte[] bArr) {
        int length = this.count + (bArr.length * 2) + 3;
        if (length > this.buf.length) {
            expandCapacity(length);
        }
        char[] cArr = this.buf;
        int i = this.count;
        int i2 = i + 1;
        cArr[i] = 'x';
        this.count = i2 + 1;
        cArr[i2] = '\'';
        for (byte b : bArr) {
            int i3 = b & 255;
            int i4 = i3 >> 4;
            int i5 = i3 & 15;
            char[] cArr2 = this.buf;
            int i6 = this.count;
            int i7 = i6 + 1;
            this.count = i7;
            int i8 = 48;
            cArr2[i6] = (char) (i4 + (i4 < 10 ? 48 : 55));
            this.count = i7 + 1;
            if (i5 >= 10) {
                i8 = 55;
            }
            cArr2[i7] = (char) (i5 + i8);
        }
        char[] cArr3 = this.buf;
        int i9 = this.count;
        this.count = i9 + 1;
        cArr3[i9] = '\'';
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iStringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int i2 = this.count + iStringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(i, iStringSize, cArr);
                write(cArr, 0, iStringSize);
                return;
            }
            expandCapacity(i2);
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeLong(long j) {
        boolean z = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iStringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int i = this.count + iStringSize;
        if (z) {
            i += 2;
        }
        if (i > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(j, iStringSize, cArr);
                if (!z) {
                    write(cArr, 0, iStringSize);
                    return;
                }
                write(34);
                write(cArr, 0, iStringSize);
                write(34);
                return;
            }
            expandCapacity(i);
        }
        if (z) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i2 = i - 1;
            IOUtils.getChars(j, i2, cArr2);
            this.buf[i2] = '\"';
        } else {
            IOUtils.getChars(j, i, this.buf);
        }
        this.count = i;
    }

    public void writeLongAndChar(long j, char c) throws IOException {
        writeLong(j);
        write(c);
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c) {
        if (!this.useSingleQuotes) {
            writeStringWithDoubleQuote(str, c);
        } else {
            writeStringWithSingleQuote(str);
            write(c);
        }
    }

    /* JADX WARN: Code duplicated, block: B:166:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f  */
    public void writeStringWithDoubleQuote(String str, char c) {
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i = this.count + length + 2;
        if (c != 0) {
            i++;
        }
        int length2 = this.buf.length;
        char c2 = dv9.b;
        if (i > length2) {
            if (this.writer != null) {
                write(34);
                int i2 = 0;
                while (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    if (isEnabled(SerializerFeature.BrowserSecure) && (cCharAt == '(' || cCharAt == ')' || cCharAt == '<' || cCharAt == c2)) {
                        write(92);
                        write(117);
                        char[] cArr = IOUtils.DIGITS;
                        write(cArr[(cCharAt >>> '\f') & 15]);
                        write(cArr[(cCharAt >>> '\b') & 15]);
                        write(cArr[(cCharAt >>> 4) & 15]);
                        write(cArr[cCharAt & 15]);
                    } else if (!isEnabled(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if ((cCharAt >= bArr.length || bArr[cCharAt] == 0) && !(cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(cCharAt);
                        } else {
                            write(92);
                            if (bArr[cCharAt] == 4) {
                                write(117);
                                char[] cArr2 = IOUtils.DIGITS;
                                write(cArr2[(cCharAt >>> '\f') & 15]);
                                write(cArr2[(cCharAt >>> '\b') & 15]);
                                write(cArr2[(cCharAt >>> 4) & 15]);
                                write(cArr2[cCharAt & 15]);
                            } else {
                                write(IOUtils.replaceChars[cCharAt]);
                            }
                        }
                    } else if (cCharAt == '\b' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt]);
                    } else if (cCharAt < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr3 = IOUtils.ASCII_CHARS;
                        int i3 = cCharAt * 2;
                        write(cArr3[i3]);
                        write(cArr3[i3 + 1]);
                    } else if (cCharAt >= 127) {
                        write(92);
                        write(117);
                        char[] cArr4 = IOUtils.DIGITS;
                        write(cArr4[(cCharAt >>> '\f') & 15]);
                        write(cArr4[(cCharAt >>> '\b') & 15]);
                        write(cArr4[(cCharAt >>> 4) & 15]);
                        write(cArr4[cCharAt & 15]);
                    } else {
                        write(cCharAt);
                    }
                    i2++;
                    c2 = dv9.b;
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr5 = this.buf;
        cArr5[i4] = '\"';
        str.getChars(0, length, cArr5, i5);
        this.count = i;
        int i7 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i8 = i5; i8 < i6; i8++) {
                char c3 = this.buf[i8];
                if (c3 == '\"' || c3 == '/' || c3 == '\\' || c3 == '\b' || c3 == '\f' || c3 == '\n' || c3 == '\r' || c3 == '\t') {
                    i++;
                } else {
                    if (c3 < ' ' || c3 >= 127) {
                        i += 5;
                    }
                }
                i7 = i8;
            }
            if (i > this.buf.length) {
                expandCapacity(i);
            }
            this.count = i;
            while (i7 >= i5) {
                char[] cArr6 = this.buf;
                char c4 = cArr6[i7];
                if (c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                    int i9 = i7 + 1;
                    System.arraycopy(cArr6, i9, cArr6, i7 + 2, (i6 - i7) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i9] = IOUtils.replaceChars[c4];
                } else {
                    if (c4 == '\"' || c4 == '/' || c4 == '\\') {
                        int i10 = i7 + 1;
                        System.arraycopy(cArr6, i10, cArr6, i7 + 2, (i6 - i7) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr8[i10] = c4;
                    } else {
                        if (c4 < ' ') {
                            int i11 = i7 + 1;
                            System.arraycopy(cArr6, i11, cArr6, i7 + 6, (i6 - i7) - 1);
                            char[] cArr9 = this.buf;
                            cArr9[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr9[i11] = 'u';
                            cArr9[i7 + 2] = '0';
                            cArr9[i7 + 3] = '0';
                            char[] cArr10 = IOUtils.ASCII_CHARS;
                            int i12 = c4 * 2;
                            cArr9[i7 + 4] = cArr10[i12];
                            cArr9[i7 + 5] = cArr10[i12 + 1];
                        } else if (c4 >= 127) {
                            int i13 = i7 + 1;
                            System.arraycopy(cArr6, i13, cArr6, i7 + 6, (i6 - i7) - 1);
                            char[] cArr11 = this.buf;
                            cArr11[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr11[i13] = 'u';
                            char[] cArr12 = IOUtils.DIGITS;
                            cArr11[i7 + 2] = cArr12[(c4 >>> '\f') & 15];
                            cArr11[i7 + 3] = cArr12[(c4 >>> '\b') & 15];
                            cArr11[i7 + 4] = cArr12[(c4 >>> 4) & 15];
                            cArr11[i7 + 5] = cArr12[c4 & 15];
                        }
                        i6 += 5;
                    }
                    i7--;
                }
                i6++;
                i7--;
            }
            if (c == 0) {
                this.buf[this.count - 1] = '\"';
                return;
            }
            char[] cArr13 = this.buf;
            int i14 = this.count;
            cArr13[i14 - 2] = '\"';
            cArr13[i14 - 1] = c;
            return;
        }
        int i15 = 0;
        char c5 = 0;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = i5; i18 < i6; i18++) {
            char c6 = this.buf[i18];
            if (c6 < ']') {
                if ((c6 < '@' && (this.sepcialBits & (1 << c6)) != 0) || c6 == '\\') {
                    i15++;
                    if (c6 == '(' || c6 == ')' || c6 == '<' || c6 == '>') {
                        i += 4;
                    } else {
                        byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                        if (c6 < bArr2.length && bArr2[c6] == 4) {
                            i += 4;
                        }
                    }
                    i7 = -1;
                    if (i16 == -1) {
                        i16 = i18;
                        i17 = i16;
                    } else {
                        i17 = i18;
                    }
                    c5 = c6;
                } else {
                    i7 = -1;
                }
            } else if (c6 >= 127 && (c6 == 8232 || c6 == 8233 || c6 < 160)) {
                if (i16 == i7) {
                    i16 = i18;
                }
                i15++;
                i += 4;
                i17 = i18;
                c5 = c6;
            }
        }
        if (i15 > 0) {
            int i19 = i + i15;
            if (i19 > this.buf.length) {
                expandCapacity(i19);
            }
            this.count = i19;
            if (i15 == 1) {
                if (c5 == 8232) {
                    int i20 = i17 + 1;
                    char[] cArr14 = this.buf;
                    System.arraycopy(cArr14, i20, cArr14, i17 + 6, (i6 - i17) - 1);
                    char[] cArr15 = this.buf;
                    cArr15[i17] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr15[i20] = 'u';
                    int i21 = i20 + 1;
                    cArr15[i21] = '2';
                    int i22 = i21 + 1;
                    cArr15[i22] = '0';
                    int i23 = i22 + 1;
                    cArr15[i23] = '2';
                    cArr15[i23 + 1] = '8';
                } else if (c5 == 8233) {
                    int i24 = i17 + 1;
                    char[] cArr16 = this.buf;
                    System.arraycopy(cArr16, i24, cArr16, i17 + 6, (i6 - i17) - 1);
                    char[] cArr17 = this.buf;
                    cArr17[i17] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr17[i24] = 'u';
                    int i25 = i24 + 1;
                    cArr17[i25] = '2';
                    int i26 = i25 + 1;
                    cArr17[i26] = '0';
                    int i27 = i26 + 1;
                    cArr17[i27] = '2';
                    cArr17[i27 + 1] = '9';
                } else if (c5 == '(' || c5 == ')' || c5 == '<' || c5 == '>') {
                    int i28 = i17 + 1;
                    char[] cArr18 = this.buf;
                    System.arraycopy(cArr18, i28, cArr18, i17 + 6, (i6 - i17) - 1);
                    char[] cArr19 = this.buf;
                    cArr19[i17] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr19[i28] = 'u';
                    int i29 = i28 + 1;
                    char[] cArr20 = IOUtils.DIGITS;
                    cArr19[i29] = cArr20[(c5 >>> '\f') & 15];
                    int i30 = i29 + 1;
                    cArr19[i30] = cArr20[(c5 >>> '\b') & 15];
                    int i31 = i30 + 1;
                    cArr19[i31] = cArr20[(c5 >>> 4) & 15];
                    cArr19[i31 + 1] = cArr20[c5 & 15];
                } else {
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if (c5 >= bArr3.length || bArr3[c5] != 4) {
                        int i32 = i17 + 1;
                        char[] cArr21 = this.buf;
                        System.arraycopy(cArr21, i32, cArr21, i17 + 2, (i6 - i17) - 1);
                        char[] cArr22 = this.buf;
                        cArr22[i17] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr22[i32] = IOUtils.replaceChars[c5];
                    } else {
                        int i33 = i17 + 1;
                        char[] cArr23 = this.buf;
                        System.arraycopy(cArr23, i33, cArr23, i17 + 6, (i6 - i17) - 1);
                        char[] cArr24 = this.buf;
                        cArr24[i17] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        int i34 = i33 + 1;
                        cArr24[i33] = 'u';
                        int i35 = i34 + 1;
                        char[] cArr25 = IOUtils.DIGITS;
                        cArr24[i34] = cArr25[(c5 >>> '\f') & 15];
                        int i36 = i35 + 1;
                        cArr24[i35] = cArr25[(c5 >>> '\b') & 15];
                        cArr24[i36] = cArr25[(c5 >>> 4) & 15];
                        cArr24[i36 + 1] = cArr25[c5 & 15];
                    }
                }
            } else if (i15 > 1) {
                for (int i37 = i16 - i5; i37 < str.length(); i37++) {
                    char cCharAt2 = str.charAt(i37);
                    if (this.browserSecure) {
                        if (cCharAt2 != '(' && cCharAt2 != ')') {
                            if (cCharAt2 == '<' || cCharAt2 == '>') {
                            }
                        }
                        char[] cArr26 = this.buf;
                        int i38 = i16 + 1;
                        cArr26[i16] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        int i39 = i38 + 1;
                        cArr26[i38] = 'u';
                        int i40 = i39 + 1;
                        char[] cArr27 = IOUtils.DIGITS;
                        cArr26[i39] = cArr27[(cCharAt2 >>> '\f') & 15];
                        int i41 = i40 + 1;
                        cArr26[i40] = cArr27[(cCharAt2 >>> '\b') & 15];
                        int i42 = i41 + 1;
                        cArr26[i41] = cArr27[(cCharAt2 >>> 4) & 15];
                        i16 = i42 + 1;
                        cArr26[i42] = cArr27[cCharAt2 & 15];
                    }
                    byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                    if ((cCharAt2 >= bArr4.length || bArr4[cCharAt2] == 0) && !(cCharAt2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        if (cCharAt2 == 8232 || cCharAt2 == 8233) {
                            char[] cArr28 = this.buf;
                            int i43 = i16 + 1;
                            cArr28[i16] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            int i44 = i43 + 1;
                            cArr28[i43] = 'u';
                            int i45 = i44 + 1;
                            char[] cArr29 = IOUtils.DIGITS;
                            cArr28[i44] = cArr29[(cCharAt2 >>> '\f') & 15];
                            int i46 = i45 + 1;
                            cArr28[i45] = cArr29[(cCharAt2 >>> '\b') & 15];
                            int i47 = i46 + 1;
                            cArr28[i46] = cArr29[(cCharAt2 >>> 4) & 15];
                            i16 = i47 + 1;
                            cArr28[i47] = cArr29[cCharAt2 & 15];
                        } else {
                            this.buf[i16] = cCharAt2;
                            i16++;
                        }
                    } else {
                        char[] cArr30 = this.buf;
                        int i48 = i16 + 1;
                        cArr30[i16] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        if (bArr4[cCharAt2] == 4) {
                            int i49 = i48 + 1;
                            cArr30[i48] = 'u';
                            int i50 = i49 + 1;
                            char[] cArr31 = IOUtils.DIGITS;
                            cArr30[i49] = cArr31[(cCharAt2 >>> '\f') & 15];
                            int i51 = i50 + 1;
                            cArr30[i50] = cArr31[(cCharAt2 >>> '\b') & 15];
                            int i52 = i51 + 1;
                            cArr30[i51] = cArr31[(cCharAt2 >>> 4) & 15];
                            i16 = i52 + 1;
                            cArr30[i52] = cArr31[cCharAt2 & 15];
                        } else {
                            i16 = i48 + 1;
                            cArr30[i48] = IOUtils.replaceChars[cCharAt2];
                        }
                    }
                }
            }
        }
        if (c == 0) {
            this.buf[this.count - 1] = '\"';
            return;
        }
        char[] cArr32 = this.buf;
        int i53 = this.count;
        cArr32[i53 - 2] = '\"';
        cArr32[i53 - 1] = c;
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
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
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
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
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
            cArr3[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i10] = IOUtils.replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i11] = IOUtils.replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c3 = this.buf[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i14] = IOUtils.replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        }
        byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public void writeFieldName(String str, boolean z) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.useSingleQuotes) {
            if (!this.quoteFieldNames) {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            } else {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
        }
        if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, c.b);
            return;
        }
        boolean z2 = true;
        boolean z3 = str.length() == 0;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z2 = z3;
                break;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < '@' && (this.sepcialBits & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            writeStringWithDoubleQuote(str, c.b);
        } else {
            write(str);
            write(58);
        }
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeNull(int i, int i2) {
        if ((i & i2) == 0 && (this.features & i2) == 0) {
            writeNull();
            return;
        }
        int i3 = SerializerFeature.WriteMapNullValue.mask;
        if ((i & i3) != 0 && (i & (~i3) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
            writeNull();
            return;
        }
        if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
            return;
        }
        if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
            return;
        }
        if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.getMask();
        }
        this.features = i;
        computeFeatures();
    }

    public void writeFieldValue(char c, String str, boolean z) {
        if (!this.quoteFieldNames) {
            write(c);
            writeFieldName(str);
            write(z);
            return;
        }
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.buf;
        cArr2[i4 + 1] = this.keySeperator;
        if (z) {
            System.arraycopy(VALUE_TRUE, 0, cArr2, i4 + 2, 5);
        } else {
            System.arraycopy(VALUE_FALSE, 0, cArr2, i4 + 2, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
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

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), (char) 0);
        }
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

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer, int i) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i > 0) {
            this.buf = new char[i];
            computeFeatures();
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i);
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

    public void writeFieldValue(char c, String str, int i) {
        if (i != Integer.MIN_VALUE && this.quoteFieldNames) {
            int iStringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
            int length = str.length();
            int i2 = this.count + length + 4 + iStringSize;
            if (i2 > this.buf.length) {
                if (this.writer != null) {
                    write(c);
                    writeFieldName(str);
                    writeInt(i);
                    return;
                }
                expandCapacity(i2);
            }
            int i3 = this.count;
            this.count = i2;
            char[] cArr = this.buf;
            cArr[i3] = c;
            int i4 = i3 + length + 1;
            cArr[i3 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i3 + 2);
            char[] cArr2 = this.buf;
            cArr2[i4 + 1] = this.keySeperator;
            cArr2[i4 + 2] = c.b;
            IOUtils.getChars(i, this.count, cArr2);
            return;
        }
        write(c);
        writeFieldName(str);
        writeInt(i);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        boolean z;
        int i;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i2 = this.count;
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        while (i4 < size) {
            String str = list.get(i4);
            if (str == null) {
                z = true;
            } else {
                int length = str.length();
                z = false;
                for (int i5 = 0; i5 < length; i5++) {
                    char cCharAt = str.charAt(i5);
                    z = cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\\';
                    if (z) {
                        break;
                    }
                }
            }
            if (z) {
                this.count = i2;
                write(91);
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String str2 = list.get(i6);
                    if (i6 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i3 + 3;
            if (i4 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i3;
                expandCapacity(length2);
            }
            if (i4 == 0) {
                i = i3 + 1;
                this.buf[i3] = '[';
            } else {
                i = i3 + 1;
                this.buf[i3] = ',';
            }
            int i7 = i + 1;
            this.buf[i] = '\"';
            str.getChars(0, str.length(), this.buf, i7);
            int length3 = i7 + str.length();
            this.buf[length3] = '\"';
            i4++;
            i3 = length3 + 1;
        }
        this.buf[i3] = ']';
        this.count = i3 + 1;
    }

    public void writeStringWithSingleQuote(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = cArr.length;
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < cArr.length) {
                    char c = cArr[i];
                    if (c > '\r' && c != '\\' && c != '\'' && (c != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(c);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[c]);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = length + i5;
        char[] cArr2 = this.buf;
        cArr2[i4] = '\'';
        System.arraycopy(cArr, 0, cArr2, i5, cArr.length);
        this.count = i3;
        int i7 = -1;
        char c2 = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c3 = this.buf[i8];
            if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c2 = c3;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr3 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr3, i10, cArr3, i7 + 2, (i6 - i7) - 1);
            char[] cArr4 = this.buf;
            cArr4[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr4[i10] = IOUtils.replaceChars[c2];
        } else if (i > 1) {
            char[] cArr5 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr5, i11, cArr5, i7 + 2, (i6 - i7) - 1);
            char[] cArr6 = this.buf;
            cArr6[i7] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr6[i11] = IOUtils.replaceChars[c2];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c4 = this.buf[i13];
                if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr7, i14, cArr7, i13 + 2, (i12 - i13) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i13] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr8[i14] = IOUtils.replaceChars[c4];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j != Long.MIN_VALUE && this.quoteFieldNames && !isEnabled(SerializerFeature.BrowserCompatible.mask)) {
            int iStringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
            int length = str.length();
            int i = this.count + length + 4 + iStringSize;
            if (i > this.buf.length) {
                if (this.writer != null) {
                    write(c);
                    writeFieldName(str);
                    writeLong(j);
                    return;
                }
                expandCapacity(i);
            }
            int i2 = this.count;
            this.count = i;
            char[] cArr = this.buf;
            cArr[i2] = c;
            int i3 = i2 + length + 1;
            cArr[i2 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i2 + 2);
            char[] cArr2 = this.buf;
            cArr2[i3 + 1] = this.keySeperator;
            cArr2[i3 + 2] = c.b;
            IOUtils.getChars(j, this.count, cArr2);
            return;
        }
        write(c);
        writeFieldName(str);
        writeLong(j);
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
    }

    public void writeFieldValue(char c, String str, float f) {
        write(c);
        writeFieldName(str);
        writeFloat(f, false);
    }

    public void writeFieldValue(char c, String str, double d) {
        write(c);
        writeFieldName(str);
        writeDouble(d, false);
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c);
                writeStringWithDoubleQuote(str, c.b);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            writeFieldValueStringWithDoubleQuoteCheck(c, str, str2);
            return;
        }
        write(c);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c, String str, Enum<?> r4) {
        if (r4 == null) {
            write(c);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, r4.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, r4.toString());
        } else {
            writeFieldValue(c, str, r4.ordinal());
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        String string;
        write(c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        int iScale = bigDecimal.scale();
        if (isEnabled(SerializerFeature.WriteBigDecimalAsPlain) && iScale >= -100 && iScale < 100) {
            string = bigDecimal.toPlainString();
        } else {
            string = bigDecimal.toString();
        }
        write(string);
    }

    /* JADX WARN: Code duplicated, block: B:165:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:59:0x0147  */
    public void writeStringWithDoubleQuote(char[] cArr, char c) {
        int i;
        int i2;
        if (cArr == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = cArr.length;
        int i3 = this.count + length + 2;
        if (c != 0) {
            i3++;
        }
        int length2 = this.buf.length;
        char c2 = dv9.b;
        if (i3 > length2) {
            if (this.writer != null) {
                write(34);
                int i4 = 0;
                while (i4 < cArr.length) {
                    char c3 = cArr[i4];
                    if (isEnabled(SerializerFeature.BrowserSecure) && (c3 == '(' || c3 == ')' || c3 == '<' || c3 == c2)) {
                        write(92);
                        write(117);
                        char[] cArr2 = IOUtils.DIGITS;
                        write(cArr2[(c3 >>> '\f') & 15]);
                        write(cArr2[(c3 >>> '\b') & 15]);
                        write(cArr2[(c3 >>> 4) & 15]);
                        write(cArr2[c3 & 15]);
                    } else if (!isEnabled(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if ((c3 < bArr.length && bArr[c3] != 0) || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (bArr[c3] == 4) {
                                write(117);
                                char[] cArr3 = IOUtils.DIGITS;
                                write(cArr3[(c3 >>> '\f') & 15]);
                                write(cArr3[(c3 >>> '\b') & 15]);
                                write(cArr3[(c3 >>> 4) & 15]);
                                write(cArr3[c3 & 15]);
                            } else {
                                write(IOUtils.replaceChars[c3]);
                            }
                        } else {
                            write(c3);
                        }
                    } else if (c3 == '\b' || c3 == '\f' || c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == '\"' || c3 == '/' || c3 == '\\') {
                        write(92);
                        write(IOUtils.replaceChars[c3]);
                    } else if (c3 < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr4 = IOUtils.ASCII_CHARS;
                        int i5 = c3 * 2;
                        write(cArr4[i5]);
                        write(cArr4[i5 + 1]);
                    } else if (c3 >= 127) {
                        write(92);
                        write(117);
                        char[] cArr5 = IOUtils.DIGITS;
                        write(cArr5[(c3 >>> '\f') & 15]);
                        write(cArr5[(c3 >>> '\b') & 15]);
                        write(cArr5[(c3 >>> 4) & 15]);
                        write(cArr5[c3 & 15]);
                    } else {
                        write(c3);
                    }
                    i4++;
                    c2 = dv9.b;
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i3);
        }
        int i6 = this.count;
        int i7 = i6 + 1;
        int i8 = length + i7;
        char[] cArr6 = this.buf;
        cArr6[i6] = '\"';
        System.arraycopy(cArr, 0, cArr6, i7, cArr.length);
        this.count = i3;
        int i9 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i10 = i7; i10 < i8; i10++) {
                char c4 = this.buf[i10];
                if (c4 == '\"' || c4 == '/' || c4 == '\\' || c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                    i3++;
                } else {
                    if (c4 < ' ' || c4 >= 127) {
                        i3 += 5;
                    }
                }
                i9 = i10;
            }
            if (i3 > this.buf.length) {
                expandCapacity(i3);
            }
            this.count = i3;
            while (i9 >= i7) {
                char[] cArr7 = this.buf;
                char c5 = cArr7[i9];
                if (c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                    int i11 = i9 + 1;
                    System.arraycopy(cArr7, i11, cArr7, i9 + 2, (i8 - i9) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i9] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr8[i11] = IOUtils.replaceChars[c5];
                } else {
                    if (c5 == '\"' || c5 == '/' || c5 == '\\') {
                        int i12 = i9 + 1;
                        System.arraycopy(cArr7, i12, cArr7, i9 + 2, (i8 - i9) - 1);
                        char[] cArr9 = this.buf;
                        cArr9[i9] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr9[i12] = c5;
                    } else {
                        if (c5 < ' ') {
                            int i13 = i9 + 1;
                            System.arraycopy(cArr7, i13, cArr7, i9 + 6, (i8 - i9) - 1);
                            char[] cArr10 = this.buf;
                            cArr10[i9] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr10[i13] = 'u';
                            cArr10[i9 + 2] = '0';
                            cArr10[i9 + 3] = '0';
                            char[] cArr11 = IOUtils.ASCII_CHARS;
                            int i14 = c5 * 2;
                            cArr10[i9 + 4] = cArr11[i14];
                            cArr10[i9 + 5] = cArr11[i14 + 1];
                        } else if (c5 >= 127) {
                            int i15 = i9 + 1;
                            System.arraycopy(cArr7, i15, cArr7, i9 + 6, (i8 - i9) - 1);
                            char[] cArr12 = this.buf;
                            cArr12[i9] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr12[i15] = 'u';
                            char[] cArr13 = IOUtils.DIGITS;
                            cArr12[i9 + 2] = cArr13[(c5 >>> '\f') & 15];
                            cArr12[i9 + 3] = cArr13[(c5 >>> '\b') & 15];
                            cArr12[i9 + 4] = cArr13[(c5 >>> 4) & 15];
                            cArr12[i9 + 5] = cArr13[c5 & 15];
                        }
                        i8 += 5;
                    }
                    i9--;
                }
                i8++;
                i9--;
            }
            if (c != 0) {
                char[] cArr14 = this.buf;
                int i16 = this.count;
                cArr14[i16 - 2] = '\"';
                cArr14[i16 - 1] = c;
                return;
            }
            this.buf[this.count - 1] = '\"';
            return;
        }
        int i17 = i7;
        int i18 = -1;
        int i19 = 0;
        char c6 = 0;
        int i20 = -1;
        while (i17 < i8) {
            char c7 = this.buf[i17];
            if (c7 >= ']') {
                if (c7 >= 127 && (c7 == 8232 || c7 == 8233 || c7 < 160)) {
                    if (i20 == i9) {
                        i20 = i17;
                    }
                    i19++;
                    i3 += 4;
                    i18 = i17;
                    c6 = c7;
                }
                int i21 = i20;
                i2 = i9;
                i = i21;
            } else {
                int i22 = i20;
                if ((c7 < '@' && (this.sepcialBits & (1 << c7)) != 0) || c7 == '\\') {
                    i19++;
                    if (c7 == '(' || c7 == ')' || c7 == '<' || c7 == '>') {
                        i3 += 4;
                    } else {
                        byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                        if (c7 < bArr2.length && bArr2[c7] == 4) {
                            i3 += 4;
                        }
                    }
                    i = i22;
                    i2 = -1;
                    if (i == -1) {
                        i = i17;
                        i18 = i;
                    } else {
                        i18 = i17;
                    }
                    c6 = c7;
                } else {
                    i = i22;
                    i2 = -1;
                }
            }
            i17++;
            int i23 = i2;
            i20 = i;
            i9 = i23;
        }
        int i24 = i20;
        if (i19 > 0) {
            int i25 = i3 + i19;
            if (i25 > this.buf.length) {
                expandCapacity(i25);
            }
            this.count = i25;
            if (i19 == 1) {
                if (c6 == 8232) {
                    int i26 = i18 + 1;
                    char[] cArr15 = this.buf;
                    System.arraycopy(cArr15, i26, cArr15, i18 + 6, (i8 - i18) - 1);
                    char[] cArr16 = this.buf;
                    cArr16[i18] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr16[i26] = 'u';
                    int i27 = i26 + 1;
                    cArr16[i27] = '2';
                    int i28 = i27 + 1;
                    cArr16[i28] = '0';
                    int i29 = i28 + 1;
                    cArr16[i29] = '2';
                    cArr16[i29 + 1] = '8';
                } else if (c6 == 8233) {
                    int i30 = i18 + 1;
                    char[] cArr17 = this.buf;
                    System.arraycopy(cArr17, i30, cArr17, i18 + 6, (i8 - i18) - 1);
                    char[] cArr18 = this.buf;
                    cArr18[i18] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr18[i30] = 'u';
                    int i31 = i30 + 1;
                    cArr18[i31] = '2';
                    int i32 = i31 + 1;
                    cArr18[i32] = '0';
                    int i33 = i32 + 1;
                    cArr18[i33] = '2';
                    cArr18[i33 + 1] = '9';
                } else if (c6 != '(' && c6 != ')' && c6 != '<' && c6 != '>') {
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if (c6 < bArr3.length && bArr3[c6] == 4) {
                        int i34 = i18 + 1;
                        char[] cArr19 = this.buf;
                        System.arraycopy(cArr19, i34, cArr19, i18 + 6, (i8 - i18) - 1);
                        char[] cArr20 = this.buf;
                        cArr20[i18] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        int i35 = i34 + 1;
                        cArr20[i34] = 'u';
                        int i36 = i35 + 1;
                        char[] cArr21 = IOUtils.DIGITS;
                        cArr20[i35] = cArr21[(c6 >>> '\f') & 15];
                        int i37 = i36 + 1;
                        cArr20[i36] = cArr21[(c6 >>> '\b') & 15];
                        cArr20[i37] = cArr21[(c6 >>> 4) & 15];
                        cArr20[i37 + 1] = cArr21[c6 & 15];
                    } else {
                        int i38 = i18 + 1;
                        char[] cArr22 = this.buf;
                        System.arraycopy(cArr22, i38, cArr22, i18 + 2, (i8 - i18) - 1);
                        char[] cArr23 = this.buf;
                        cArr23[i18] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr23[i38] = IOUtils.replaceChars[c6];
                    }
                } else {
                    int i39 = i18 + 1;
                    char[] cArr24 = this.buf;
                    System.arraycopy(cArr24, i39, cArr24, i18 + 6, (i8 - i18) - 1);
                    char[] cArr25 = this.buf;
                    cArr25[i18] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr25[i39] = 'u';
                    int i40 = i39 + 1;
                    char[] cArr26 = IOUtils.DIGITS;
                    cArr25[i40] = cArr26[(c6 >>> '\f') & 15];
                    int i41 = i40 + 1;
                    cArr25[i41] = cArr26[(c6 >>> '\b') & 15];
                    int i42 = i41 + 1;
                    cArr25[i42] = cArr26[(c6 >>> 4) & 15];
                    cArr25[i42 + 1] = cArr26[c6 & 15];
                }
            } else if (i19 > 1) {
                for (int i43 = i24 - i7; i43 < cArr.length; i43++) {
                    char c8 = cArr[i43];
                    if (this.browserSecure) {
                        if (c8 != '(' && c8 != ')') {
                            if (c8 == '<' || c8 == '>') {
                            }
                        }
                        char[] cArr27 = this.buf;
                        int i44 = i24 + 1;
                        cArr27[i24] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        int i45 = i44 + 1;
                        cArr27[i44] = 'u';
                        int i46 = i45 + 1;
                        char[] cArr28 = IOUtils.DIGITS;
                        cArr27[i45] = cArr28[(c8 >>> '\f') & 15];
                        int i47 = i46 + 1;
                        cArr27[i46] = cArr28[(c8 >>> '\b') & 15];
                        int i48 = i47 + 1;
                        cArr27[i47] = cArr28[(c8 >>> 4) & 15];
                        i24 = i48 + 1;
                        cArr27[i48] = cArr28[c8 & 15];
                    }
                    byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                    if ((c8 >= bArr4.length || bArr4[c8] == 0) && !(c8 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        if (c8 != 8232 && c8 != 8233) {
                            this.buf[i24] = c8;
                            i24++;
                        } else {
                            char[] cArr29 = this.buf;
                            int i49 = i24 + 1;
                            cArr29[i24] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                            int i50 = i49 + 1;
                            cArr29[i49] = 'u';
                            int i51 = i50 + 1;
                            char[] cArr30 = IOUtils.DIGITS;
                            cArr29[i50] = cArr30[(c8 >>> '\f') & 15];
                            int i52 = i51 + 1;
                            cArr29[i51] = cArr30[(c8 >>> '\b') & 15];
                            int i53 = i52 + 1;
                            cArr29[i52] = cArr30[(c8 >>> 4) & 15];
                            i24 = i53 + 1;
                            cArr29[i53] = cArr30[c8 & 15];
                        }
                    } else {
                        char[] cArr31 = this.buf;
                        int i54 = i24 + 1;
                        cArr31[i24] = com.aliyun.vod.common.utils.IOUtils.DIR_SEPARATOR_WINDOWS;
                        if (bArr4[c8] == 4) {
                            int i55 = i54 + 1;
                            cArr31[i54] = 'u';
                            int i56 = i55 + 1;
                            char[] cArr32 = IOUtils.DIGITS;
                            cArr31[i55] = cArr32[(c8 >>> '\f') & 15];
                            int i57 = i56 + 1;
                            cArr31[i56] = cArr32[(c8 >>> '\b') & 15];
                            int i58 = i57 + 1;
                            cArr31[i57] = cArr32[(c8 >>> 4) & 15];
                            i24 = i58 + 1;
                            cArr31[i58] = cArr32[c8 & 15];
                        } else {
                            i24 = i54 + 1;
                            cArr31[i54] = IOUtils.replaceChars[c8];
                        }
                    }
                }
            }
        }
        if (c != 0) {
            char[] cArr33 = this.buf;
            int i59 = this.count;
            cArr33[i59 - 2] = '\"';
            cArr33[i59 - 1] = c;
            return;
        }
        this.buf[this.count - 1] = '\"';
    }
}
