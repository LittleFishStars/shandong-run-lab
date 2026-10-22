package com.airbnb.lottie.parser.moshi;

import com.zj.adlib.yo4;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class JsonReader implements Closeable {
    public static final String[] b = new String[128];
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23394a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f588b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f586a = new int[32];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f587a = new String[32];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f589b = new int[32];

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Options f23395a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String[] f590a;

        public a(String[] strArr, Options options) {
            this.f590a = strArr;
            this.f23395a = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.L(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            b[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = b;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    public static void L(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = b;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        bufferedSink.writeUtf8(str, i, i2);
                    }
                    bufferedSink.writeUtf8(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    bufferedSink.writeUtf8(str, i, i2);
                }
                bufferedSink.writeUtf8(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            bufferedSink.writeUtf8(str, i, length);
        }
        bufferedSink.writeByte(34);
    }

    public static JsonReader w(BufferedSource bufferedSource) {
        return new com.airbnb.lottie.parser.moshi.a(bufferedSource);
    }

    public final void E(int i) {
        int i2 = this.K;
        int[] iArr = this.f586a;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.f586a = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f587a;
            this.f587a = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f589b;
            this.f589b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f586a;
        int i3 = this.K;
        this.K = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int F(a aVar) throws IOException;

    public abstract void H() throws IOException;

    public abstract void J() throws IOException;

    public final JsonEncodingException M(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void g() throws IOException;

    public final String getPath() {
        return yo4.a(this.K, this.f586a, this.f587a, this.f589b);
    }

    public abstract void h() throws IOException;

    public abstract void j() throws IOException;

    public abstract void k() throws IOException;

    public abstract boolean l() throws IOException;

    public abstract boolean p() throws IOException;

    public abstract double q() throws IOException;

    public abstract int r() throws IOException;

    public abstract String s() throws IOException;

    public abstract String v() throws IOException;

    public abstract Token y() throws IOException;
}
