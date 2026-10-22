package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a extends JsonReader {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 6;
    public static final int U = 7;
    public static final int V = 8;
    public static final int W = 9;
    public static final int X = 10;
    public static final int Y = 11;
    public static final int Z = 12;
    public static final int a0 = 13;
    public static final long b = -922337203685477580L;
    public static final int b0 = 14;
    public static final int c0 = 15;
    public static final int d0 = 16;
    public static final int e0 = 17;
    public static final int f0 = 18;
    public static final int g0 = 0;
    public static final int h0 = 1;
    public static final int i0 = 2;
    public static final int j0 = 3;
    public static final int k0 = 4;
    public static final int l0 = 5;
    public static final int m0 = 6;
    public static final int n0 = 7;
    public int L = 0;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Buffer f597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BufferedSource f598a;

    @Nullable
    public String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteString f23404a = ByteString.encodeUtf8("'\\");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final ByteString f595b = ByteString.encodeUtf8("\"\\");
    public static final ByteString c = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString d = ByteString.encodeUtf8("\n\r");
    public static final ByteString e = ByteString.encodeUtf8("*/");

    public a(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f598a = bufferedSource;
        this.f597a = bufferedSource.buffer();
        E(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int F(JsonReader.a aVar) throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS < 12 || iS > 15) {
            return -1;
        }
        if (iS == 15) {
            return W(this.f, aVar);
        }
        int iSelect = this.f598a.select(aVar.f23395a);
        if (iSelect != -1) {
            this.L = 0;
            ((JsonReader) this).f587a[this.K - 1] = aVar.f590a[iSelect];
            return iSelect;
        }
        String str = ((JsonReader) this).f587a[this.K - 1];
        String strS = s();
        int iW = W(strS, aVar);
        if (iW == -1) {
            this.L = 15;
            this.f = strS;
            ((JsonReader) this).f587a[this.K - 1] = str;
        }
        return iW;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void H() throws IOException {
        if (((JsonReader) this).f588b) {
            throw new JsonDataException("Cannot skip unexpected " + y() + " at " + getPath());
        }
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 14) {
            y0();
        } else if (iS == 13) {
            r0(f595b);
        } else if (iS == 12) {
            r0(f23404a);
        } else if (iS != 15) {
            throw new JsonDataException("Expected a name but was " + y() + " at path " + getPath());
        }
        this.L = 0;
        ((JsonReader) this).f587a[this.K - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void J() throws IOException {
        if (((JsonReader) this).f588b) {
            throw new JsonDataException("Cannot skip unexpected " + y() + " at " + getPath());
        }
        int i = 0;
        do {
            int iS = this.L;
            if (iS == 0) {
                iS = S();
            }
            if (iS == 3) {
                E(1);
            } else {
                if (iS == 1) {
                    E(3);
                } else if (iS == 4) {
                    i--;
                    if (i < 0) {
                        throw new JsonDataException("Expected a value but was " + y() + " at path " + getPath());
                    }
                    this.K--;
                } else if (iS == 2) {
                    i--;
                    if (i < 0) {
                        throw new JsonDataException("Expected a value but was " + y() + " at path " + getPath());
                    }
                    this.K--;
                } else if (iS == 14 || iS == 10) {
                    y0();
                } else if (iS == 9 || iS == 13) {
                    r0(f595b);
                } else if (iS == 8 || iS == 12) {
                    r0(f23404a);
                } else if (iS == 17) {
                    this.f597a.skip(this.M);
                } else if (iS == 18) {
                    throw new JsonDataException("Expected a value but was " + y() + " at path " + getPath());
                }
                this.L = 0;
            }
            i++;
            this.L = 0;
        } while (i != 0);
        int[] iArr = ((JsonReader) this).f589b;
        int i2 = this.K;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        ((JsonReader) this).f587a[i2 - 1] = "null";
    }

    public final void R() throws IOException {
        if (!((JsonReader) this).f23394a) {
            throw M("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int S() throws IOException {
        int[] iArr = ((JsonReader) this).f586a;
        int i = this.K;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iI0 = i0(true);
            this.f597a.readByte();
            if (iI0 != 44) {
                if (iI0 != 59) {
                    if (iI0 != 93) {
                        throw M("Unterminated array");
                    }
                    this.L = 4;
                    return 4;
                }
                R();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iI1 = i0(true);
                    this.f597a.readByte();
                    if (iI1 != 44) {
                        if (iI1 != 59) {
                            if (iI1 != 125) {
                                throw M("Unterminated object");
                            }
                            this.L = 2;
                            return 2;
                        }
                        R();
                    }
                }
                int iI2 = i0(true);
                if (iI2 == 34) {
                    this.f597a.readByte();
                    this.L = 13;
                    return 13;
                }
                if (iI2 == 39) {
                    this.f597a.readByte();
                    R();
                    this.L = 12;
                    return 12;
                }
                if (iI2 != 125) {
                    R();
                    if (!b0((char) iI2)) {
                        throw M("Expected name");
                    }
                    this.L = 14;
                    return 14;
                }
                if (i2 == 5) {
                    throw M("Expected name");
                }
                this.f597a.readByte();
                this.L = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iI3 = i0(true);
                this.f597a.readByte();
                if (iI3 != 58) {
                    if (iI3 != 61) {
                        throw M("Expected ':'");
                    }
                    R();
                    if (this.f598a.request(1L) && this.f597a.getByte(0L) == 62) {
                        this.f597a.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (i0(false) == -1) {
                    this.L = 18;
                    return 18;
                }
                R();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iI4 = i0(true);
        if (iI4 == 34) {
            this.f597a.readByte();
            this.L = 9;
            return 9;
        }
        if (iI4 == 39) {
            R();
            this.f597a.readByte();
            this.L = 8;
            return 8;
        }
        if (iI4 != 44 && iI4 != 59) {
            if (iI4 == 91) {
                this.f597a.readByte();
                this.L = 3;
                return 3;
            }
            if (iI4 != 93) {
                if (iI4 == 123) {
                    this.f597a.readByte();
                    this.L = 1;
                    return 1;
                }
                int iM0 = m0();
                if (iM0 != 0) {
                    return iM0;
                }
                int iO0 = o0();
                if (iO0 != 0) {
                    return iO0;
                }
                if (!b0(this.f597a.getByte(0L))) {
                    throw M("Expected value");
                }
                R();
                this.L = 10;
                return 10;
            }
            if (i2 == 1) {
                this.f597a.readByte();
                this.L = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw M("Unexpected value");
        }
        R();
        this.L = 7;
        return 7;
    }

    public final int W(String str, JsonReader.a aVar) {
        int length = aVar.f590a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.f590a[i])) {
                this.L = 0;
                ((JsonReader) this).f587a[this.K - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean b0(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        R();
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.L = 0;
        ((JsonReader) this).f586a[0] = 8;
        this.K = 1;
        this.f597a.clear();
        this.f598a.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void g() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 3) {
            E(1);
            ((JsonReader) this).f589b[this.K - 1] = 0;
            this.L = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + y() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void h() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 1) {
            E(3);
            this.L = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + y() + " at path " + getPath());
    }

    public final int i0(boolean z) throws IOException {
        int i;
        byte b2;
        while (true) {
            int i2 = 0;
            while (true) {
                i = i2 + 1;
                if (!this.f598a.request(i)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                b2 = this.f597a.getByte(i2);
                if (b2 == 10 || b2 == 32 || b2 == 13 || b2 == 9) {
                    i2 = i;
                }
            }
            this.f597a.skip(i - 1);
            if (b2 == 47) {
                if (!this.f598a.request(2L)) {
                    return b2;
                }
                R();
                byte b3 = this.f597a.getByte(1L);
                if (b3 == 42) {
                    this.f597a.readByte();
                    this.f597a.readByte();
                    if (!u0()) {
                        throw M("Unterminated comment");
                    }
                } else {
                    if (b3 != 47) {
                        return b2;
                    }
                    this.f597a.readByte();
                    this.f597a.readByte();
                    v0();
                }
            } else {
                if (b2 != 35) {
                    return b2;
                }
                R();
                v0();
            }
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void j() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + y() + " at path " + getPath());
        }
        int i = this.K - 1;
        this.K = i;
        int[] iArr = ((JsonReader) this).f589b;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.L = 0;
    }

    public final String j0(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.f598a.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw M("Unterminated string");
            }
            if (this.f597a.getByte(jIndexOfElement) != 92) {
                if (sb == null) {
                    String utf8 = this.f597a.readUtf8(jIndexOfElement);
                    this.f597a.readByte();
                    return utf8;
                }
                sb.append(this.f597a.readUtf8(jIndexOfElement));
                this.f597a.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f597a.readUtf8(jIndexOfElement));
            this.f597a.readByte();
            sb.append(q0());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void k() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + y() + " at path " + getPath());
        }
        int i = this.K - 1;
        this.K = i;
        ((JsonReader) this).f587a[i] = null;
        int[] iArr = ((JsonReader) this).f589b;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.L = 0;
    }

    public final String k0() throws IOException {
        long jIndexOfElement = this.f598a.indexOfElement(c);
        return jIndexOfElement != -1 ? this.f597a.readUtf8(jIndexOfElement) : this.f597a.readUtf8();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean l() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        return (iS == 2 || iS == 4 || iS == 18) ? false : true;
    }

    public final int m0() throws IOException {
        String str;
        String str2;
        int i;
        byte b2 = this.f597a.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (b2 == 102 || b2 == 70) {
            str = AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
            str2 = "FALSE";
            i = 6;
        } else {
            if (b2 != 110 && b2 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.f598a.request(i3)) {
                return 0;
            }
            char c2 = this.f597a.getByte(i2);
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.f598a.request(length + 1) && b0(this.f597a.getByte(length))) {
            return 0;
        }
        this.f597a.skip(length);
        this.L = i;
        return i;
    }

    public final int o0() throws IOException {
        char c2;
        boolean z = true;
        long j = 0;
        int i = 0;
        char c3 = 0;
        boolean z2 = false;
        boolean z3 = true;
        while (true) {
            int i2 = i + 1;
            if (!this.f598a.request(i2)) {
                break;
            }
            byte b2 = this.f597a.getByte(i);
            if (b2 != 43) {
                if (b2 == 69 || b2 == 101) {
                    if (c3 != 2 && c3 != 4) {
                        return 0;
                    }
                    c3 = 5;
                } else if (b2 == 45) {
                    c2 = 6;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (b2 != 46) {
                    if (b2 < 48 || b2 > 57) {
                        if (!b0(b2)) {
                            break;
                        }
                        return 0;
                    }
                    if (c3 == z || c3 == 0) {
                        j = -(b2 - 48);
                        c3 = 2;
                    } else if (c3 == 2) {
                        if (j == 0) {
                            return 0;
                        }
                        long j2 = (10 * j) - ((long) (b2 - 48));
                        z3 &= j > b || (j == b && j2 < j);
                        j = j2;
                    } else if (c3 == 3) {
                        c3 = 4;
                    } else if (c3 == 5 || c3 == 6) {
                        c3 = 7;
                    }
                } else {
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                }
                i = i2;
                z = true;
            } else {
                c2 = 6;
                if (c3 != 5) {
                    return 0;
                }
            }
            c3 = c2;
            i = i2;
            z = true;
        }
        if (c3 == 2 && z3 && ((j != Long.MIN_VALUE || z2) && (j != 0 || !z2))) {
            if (!z2) {
                j = -j;
            }
            this.f596a = j;
            this.f597a.skip(i);
            this.L = 16;
            return 16;
        }
        if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        }
        this.M = i;
        this.L = 17;
        return 17;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean p() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 5) {
            this.L = 0;
            int[] iArr = ((JsonReader) this).f589b;
            int i = this.K - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iS == 6) {
            this.L = 0;
            int[] iArr2 = ((JsonReader) this).f589b;
            int i2 = this.K - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + y() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double q() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 16) {
            this.L = 0;
            int[] iArr = ((JsonReader) this).f589b;
            int i = this.K - 1;
            iArr[i] = iArr[i] + 1;
            return this.f596a;
        }
        if (iS == 17) {
            this.f = this.f597a.readUtf8(this.M);
        } else if (iS == 9) {
            this.f = j0(f595b);
        } else if (iS == 8) {
            this.f = j0(f23404a);
        } else if (iS == 10) {
            this.f = k0();
        } else if (iS != 11) {
            throw new JsonDataException("Expected a double but was " + y() + " at path " + getPath());
        }
        this.L = 11;
        try {
            double d2 = Double.parseDouble(this.f);
            if (((JsonReader) this).f23394a || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
                this.f = null;
                this.L = 0;
                int[] iArr2 = ((JsonReader) this).f589b;
                int i2 = this.K - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return d2;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + d2 + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f + " at path " + getPath());
        }
    }

    public final char q0() throws IOException {
        int i;
        int i2;
        if (!this.f598a.request(1L)) {
            throw M("Unterminated escape sequence");
        }
        byte b2 = this.f597a.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b';
        }
        if (b2 == 102) {
            return '\f';
        }
        if (b2 == 110) {
            return '\n';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 != 117) {
            if (((JsonReader) this).f23394a) {
                return (char) b2;
            }
            throw M("Invalid escape sequence: \\" + ((char) b2));
        }
        if (!this.f598a.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte b3 = this.f597a.getByte(i3);
            char c3 = (char) (c2 << 4);
            if (b3 < 48 || b3 > 57) {
                if (b3 >= 97 && b3 <= 102) {
                    i = b3 - 97;
                } else {
                    if (b3 < 65 || b3 > 70) {
                        throw M("\\u" + this.f597a.readUtf8(4L));
                    }
                    i = b3 - 65;
                }
                i2 = i + 10;
            } else {
                i2 = b3 - 48;
            }
            c2 = (char) (c3 + i2);
        }
        this.f597a.skip(4L);
        return c2;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int r() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 16) {
            long j = this.f596a;
            int i = (int) j;
            if (j == i) {
                this.L = 0;
                int[] iArr = ((JsonReader) this).f589b;
                int i2 = this.K - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new JsonDataException("Expected an int but was " + this.f596a + " at path " + getPath());
        }
        if (iS == 17) {
            this.f = this.f597a.readUtf8(this.M);
        } else if (iS == 9 || iS == 8) {
            String strJ0 = iS == 9 ? j0(f595b) : j0(f23404a);
            this.f = strJ0;
            try {
                int i3 = Integer.parseInt(strJ0);
                this.L = 0;
                int[] iArr2 = ((JsonReader) this).f589b;
                int i4 = this.K - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iS != 11) {
            throw new JsonDataException("Expected an int but was " + y() + " at path " + getPath());
        }
        this.L = 11;
        try {
            double d2 = Double.parseDouble(this.f);
            int i5 = (int) d2;
            if (i5 == d2) {
                this.f = null;
                this.L = 0;
                int[] iArr3 = ((JsonReader) this).f589b;
                int i6 = this.K - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.f + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f + " at path " + getPath());
        }
    }

    public final void r0(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.f598a.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw M("Unterminated string");
            }
            if (this.f597a.getByte(jIndexOfElement) != 92) {
                this.f597a.skip(jIndexOfElement + 1);
                return;
            } else {
                this.f597a.skip(jIndexOfElement + 1);
                q0();
            }
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String s() throws IOException {
        String strJ0;
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 14) {
            strJ0 = k0();
        } else if (iS == 13) {
            strJ0 = j0(f595b);
        } else if (iS == 12) {
            strJ0 = j0(f23404a);
        } else {
            if (iS != 15) {
                throw new JsonDataException("Expected a name but was " + y() + " at path " + getPath());
            }
            strJ0 = this.f;
        }
        this.L = 0;
        ((JsonReader) this).f587a[this.K - 1] = strJ0;
        return strJ0;
    }

    public String toString() {
        return "JsonReader(" + this.f598a + ")";
    }

    public final boolean u0() throws IOException {
        BufferedSource bufferedSource = this.f598a;
        ByteString byteString = e;
        long jIndexOf = bufferedSource.indexOf(byteString);
        boolean z = jIndexOf != -1;
        Buffer buffer = this.f597a;
        buffer.skip(z ? jIndexOf + ((long) byteString.size()) : buffer.size());
        return z;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String v() throws IOException {
        String utf8;
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 10) {
            utf8 = k0();
        } else if (iS == 9) {
            utf8 = j0(f595b);
        } else if (iS == 8) {
            utf8 = j0(f23404a);
        } else if (iS == 11) {
            utf8 = this.f;
            this.f = null;
        } else if (iS == 16) {
            utf8 = Long.toString(this.f596a);
        } else {
            if (iS != 17) {
                throw new JsonDataException("Expected a string but was " + y() + " at path " + getPath());
            }
            utf8 = this.f597a.readUtf8(this.M);
        }
        this.L = 0;
        int[] iArr = ((JsonReader) this).f589b;
        int i = this.K - 1;
        iArr[i] = iArr[i] + 1;
        return utf8;
    }

    public final void v0() throws IOException {
        long jIndexOfElement = this.f598a.indexOfElement(d);
        Buffer buffer = this.f597a;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token y() throws IOException {
        int iS = this.L;
        if (iS == 0) {
            iS = S();
        }
        switch (iS) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void y0() throws IOException {
        long jIndexOfElement = this.f598a.indexOfElement(c);
        Buffer buffer = this.f597a;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }
}
