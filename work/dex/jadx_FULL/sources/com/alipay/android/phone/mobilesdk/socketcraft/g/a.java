package com.alipay.android.phone.mobilesdk.socketcraft.g;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25307a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 16;
    public static final int h = 32;
    static final /* synthetic */ boolean i = true;
    private static final int j = 76;
    private static final byte l = 10;
    private static final String m = "US-ASCII";
    private static final byte o = -1;
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.l, 47};
    private static final byte n = -5;
    private static final byte k = 61;
    private static final byte[] q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, k, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, -9, -9, -9, -9, -9, -9, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.n, 95};
    private static final byte[] s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, k, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, -9, -9, -9, -9, 63, -9, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] t = {com.google.android.exoplayer2.text.cea.a.n, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122};
    private static final byte[] u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, -9, -9, -9, -9, com.google.android.exoplayer2.text.cea.a.g, -9, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, k, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: com.alipay.android.phone.mobilesdk.socketcraft.g.a$a, reason: collision with other inner class name */
    public static class C0181a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f25309a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public C0181a(InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i;
            if (this.b < 0) {
                if (this.f25309a) {
                    byte[] bArr = new byte[3];
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++) {
                        int i4 = ((FilterInputStream) this).in.read();
                        if (i4 < 0) {
                            break;
                        }
                        bArr[i3] = (byte) i4;
                        i2++;
                    }
                    if (i2 <= 0) {
                        return -1;
                    }
                    a.b(bArr, 0, i2, this.c, 0, this.h);
                    this.b = 0;
                    this.e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i5 = 0;
                    while (i5 < 4) {
                        do {
                            i = ((FilterInputStream) this).in.read();
                            if (i < 0) {
                                break;
                            }
                        } while (this.i[i & 127] <= -5);
                        if (i < 0) {
                            break;
                        }
                        bArr2[i5] = (byte) i;
                        i5++;
                    }
                    if (i5 != 4) {
                        if (i5 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.e = a.b(bArr2, 0, this.c, 0, this.h);
                    this.b = 0;
                }
            }
            int i6 = this.b;
            if (i6 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i6 >= this.e) {
                return -1;
            }
            if (this.f25309a && this.g && this.f >= 76) {
                this.f = 0;
                return 10;
            }
            this.f++;
            byte[] bArr3 = this.c;
            int i7 = i6 + 1;
            this.b = i7;
            byte b = bArr3[i6];
            if (i7 >= this.d) {
                this.b = -1;
            }
            return b & 255;
        }

        public C0181a(InputStream inputStream, int i) {
            super(inputStream);
            this.h = i;
            this.g = (i & 8) > 0;
            boolean z = (i & 1) > 0;
            this.f25309a = z;
            int i2 = z ? 4 : 3;
            this.d = i2;
            this.c = new byte[i2];
            this.b = -1;
            this.f = 0;
            this.i = a.c(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                int i4 = read();
                if (i4 >= 0) {
                    bArr[i + i3] = (byte) i4;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class b extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f25310a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public void a() throws IOException {
            int i = this.b;
            if (i > 0) {
                if (!this.f25310a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(a.b(this.g, this.c, i, this.i));
                this.b = 0;
            }
        }

        public void b() throws IOException {
            a();
            this.h = true;
        }

        public void c() {
            this.h = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(i);
                return;
            }
            if (!this.f25310a) {
                byte b = this.j[i & 127];
                if (b <= -5) {
                    if (b != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.c;
                int i2 = this.b;
                int i3 = i2 + 1;
                this.b = i3;
                bArr[i2] = (byte) i;
                if (i3 >= this.d) {
                    ((FilterOutputStream) this).out.write(this.g, 0, a.b(bArr, 0, this.g, 0, this.i));
                    this.b = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.c;
            int i4 = this.b;
            int i5 = i4 + 1;
            this.b = i5;
            bArr2[i4] = (byte) i;
            int i6 = this.d;
            if (i5 >= i6) {
                ((FilterOutputStream) this).out.write(a.b(this.g, bArr2, i6, this.i));
                int i7 = this.e + 4;
                this.e = i7;
                if (this.f && i7 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.e = 0;
                }
                this.b = 0;
            }
        }

        public b(OutputStream outputStream, int i) {
            super(outputStream);
            this.f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.f25310a = z;
            int i2 = z ? 3 : 4;
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = a.c(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    private a() {
    }

    private static final byte[] b(int i2) {
        if ((i2 & 16) == 16) {
            return r;
        }
        return (i2 & 32) == 32 ? t : p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i2) {
        if ((i2 & 16) == 16) {
            return s;
        }
        return (i2 & 32) == 32 ? u : q;
    }

    public static String d(String str) throws Throwable {
        C0181a c0181a = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
            C0181a c0181a2 = new C0181a(new BufferedInputStream(new FileInputStream(file)), 1);
            int i2 = 0;
            while (true) {
                try {
                    int i3 = c0181a2.read(bArr, i2, 4096);
                    if (i3 < 0) {
                        break;
                    }
                    i2 += i3;
                } catch (IOException e2) {
                    c0181a = c0181a2;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    c0181a = c0181a2;
                    try {
                        c0181a.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, "US-ASCII");
            try {
                c0181a2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        return c(bArr, 0, bArr.length, 0);
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            byteBuffer2.put(bArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] bArrB = b(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << com.google.common.base.a.B) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << com.google.common.base.a.B) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << com.google.common.base.a.B) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = bArrB[i6 >>> 18];
            bArr2[i4 + 1] = bArrB[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = k;
            bArr2[i4 + 3] = k;
            return bArr2;
        }
        if (i3 == 2) {
            bArr2[i4] = bArrB[i6 >>> 18];
            bArr2[i4 + 1] = bArrB[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = bArrB[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = k;
            return bArr2;
        }
        if (i3 != 3) {
            return bArr2;
        }
        bArr2[i4] = bArrB[i6 >>> 18];
        bArr2[i4 + 1] = bArrB[(i6 >>> 12) & 63];
        bArr2[i4 + 2] = bArrB[(i6 >>> 6) & 63];
        bArr2[i4 + 3] = bArrB[i6 & 63];
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr != null) {
            if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            if (i3 == 0) {
                return new byte[0];
            }
            if (i3 >= 4) {
                byte[] bArrC = c(i4);
                byte[] bArr2 = new byte[(i3 * 3) / 4];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int iB = 0;
                while (i2 < i5) {
                    byte b2 = bArr[i2];
                    byte b3 = bArrC[b2 & 255];
                    if (b3 < -5) {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
                    }
                    if (b3 >= -1) {
                        int i7 = i6 + 1;
                        bArr3[i6] = b2;
                        if (i7 > 3) {
                            iB += b(bArr3, 0, bArr2, iB, i4);
                            if (bArr[i2] == 61) {
                                break;
                            }
                            i6 = 0;
                        } else {
                            i6 = i7;
                        }
                    }
                    i2++;
                }
                byte[] bArr4 = new byte[iB];
                System.arraycopy(bArr2, 0, bArr4, 0, iB);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        throw new NullPointerException("Cannot decode null source array.");
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    public static String a(Serializable serializable) {
        return a(serializable, 0);
    }

    public static String a(Serializable serializable, int i2) throws Throwable {
        OutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        ObjectOutputStream objectOutputStream;
        if (serializable != null) {
            ObjectOutputStream objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bVar = new b(byteArrayOutputStream, i2 | 1);
                    try {
                        if ((i2 & 2) != 0) {
                            gZIPOutputStream = new GZIPOutputStream(bVar);
                            try {
                                objectOutputStream2 = new ObjectOutputStream(gZIPOutputStream);
                                gZIPOutputStream = gZIPOutputStream;
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                gZIPOutputStream = gZIPOutputStream;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    objectOutputStream2 = objectOutputStream3;
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        bVar.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (Exception unused4) {
                                        throw th;
                                    }
                                }
                            }
                        } else {
                            objectOutputStream2 = new ObjectOutputStream(bVar);
                            gZIPOutputStream = null;
                        }
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            bVar.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
                        } catch (UnsupportedEncodingException unused9) {
                            return new String(byteArrayOutputStream.toByteArray());
                        }
                    } catch (IOException e3) {
                        e = e3;
                        ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        objectOutputStream = objectOutputStream4;
                        gZIPOutputStream = objectOutputStream4;
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream = objectOutputStream2;
                    }
                } catch (IOException e4) {
                    e = e4;
                    gZIPOutputStream = null;
                    bVar = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    objectOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    gZIPOutputStream = null;
                    bVar = null;
                }
            } catch (IOException e5) {
                e = e5;
                gZIPOutputStream = null;
                objectOutputStream = null;
                bVar = null;
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                byteArrayOutputStream = null;
                bVar = null;
            }
        } else {
            throw new NullPointerException("Cannot serialize a null object.");
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 >= 0) {
            if (i2 + i3 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            }
            if ((i4 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                gZIPOutputStream2 = null;
                gZIPOutputStream2 = null;
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bVar = new b(byteArrayOutputStream, i4 | 1);
                        try {
                            gZIPOutputStream = new GZIPOutputStream(bVar);
                            try {
                                gZIPOutputStream.write(bArr, i2, i3);
                                gZIPOutputStream.close();
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    bVar.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused3) {
                                }
                                return byteArrayOutputStream.toByteArray();
                            } catch (IOException e2) {
                                e = e2;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    gZIPOutputStream2 = gZIPOutputStream;
                                    try {
                                        gZIPOutputStream2.close();
                                    } catch (Exception unused4) {
                                    }
                                    try {
                                        bVar.close();
                                    } catch (Exception unused5) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (Exception unused6) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                gZIPOutputStream2 = gZIPOutputStream;
                                gZIPOutputStream2.close();
                                bVar.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            gZIPOutputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bVar = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bVar = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bVar = null;
                    gZIPOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    bVar = null;
                }
            } else {
                boolean z = (i4 & 8) != 0;
                int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                if (z) {
                    i5 += i5 / 76;
                }
                int i6 = i5;
                byte[] bArr2 = new byte[i6];
                int i7 = i3 - 2;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i7) {
                    int i11 = i8;
                    b(bArr, i8 + i2, 3, bArr2, i9, i4);
                    int i12 = i10 + 4;
                    if (!z || i12 < 76) {
                        i10 = i12;
                    } else {
                        bArr2[i9 + 4] = 10;
                        i9++;
                        i10 = 0;
                    }
                    i8 = i11 + 3;
                    i9 += 4;
                }
                int i13 = i8;
                if (i13 < i3) {
                    b(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
                    i9 += 4;
                }
                int i14 = i9;
                if (i14 > i6 - 1) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i14];
                System.arraycopy(bArr2, 0, bArr3, 0, i14);
                return bArr3;
            }
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
    }

    public static byte[] c(String str) throws Throwable {
        C0181a c0181a = null;
        try {
            try {
                File file = new File(str);
                if (file.length() <= 2147483647L) {
                    byte[] bArr = new byte[(int) file.length()];
                    C0181a c0181a2 = new C0181a(new BufferedInputStream(new FileInputStream(file)), 0);
                    int i2 = 0;
                    while (true) {
                        try {
                            int i3 = c0181a2.read(bArr, i2, 4096);
                            if (i3 < 0) {
                                break;
                            }
                            i2 += i3;
                        } catch (IOException e2) {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0181a = c0181a2;
                            try {
                                c0181a.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    }
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    try {
                        c0181a2.close();
                    } catch (Exception unused2) {
                    }
                    return bArr2;
                }
                throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(byte[] bArr) throws Throwable {
        String strA;
        try {
            strA = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static void c(String str, String str2) throws Throwable {
        byte[] bArrC = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(bArrC);
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static String a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static String a(byte[] bArr, int i2, int i3) throws Throwable {
        String strA;
        try {
            strA = a(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        byte[] bArrB = b(bArr, i2, i3, i4);
        try {
            return new String(bArrB, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrB);
        }
    }

    public static byte[] a(String str) {
        return a(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:57:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static byte[] a(java.lang.String r5, int r6) throws java.lang.Throwable {
        /*
            if (r5 == 0) goto L92
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L9
            goto Ld
        L9:
            byte[] r5 = r5.getBytes()
        Ld:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = c(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L1a
            r6 = r2
            goto L1b
        L1a:
            r6 = r1
        L1b:
            if (r5 == 0) goto L91
            int r3 = r5.length
            if (r3 < r0) goto L91
            if (r6 != 0) goto L91
            r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L91
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            r2.<init>()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6f
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6f
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
        L48:
            int r0 = r4.read(r6)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            if (r0 < 0) goto L52
            r2.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L48
        L52:
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r2.close()     // Catch: java.lang.Exception -> L59
        L59:
            r4.close()     // Catch: java.lang.Exception -> L5c
        L5c:
            r3.close()     // Catch: java.lang.Exception -> L91
            goto L91
        L60:
            r5 = move-exception
            goto L6d
        L62:
            r6 = move-exception
            goto L72
        L64:
            r5 = move-exception
            r4 = r0
            goto L6d
        L67:
            r6 = move-exception
            r4 = r0
            goto L72
        L6a:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L6d:
            r0 = r2
            goto L87
        L6f:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L72:
            r0 = r2
            goto L7b
        L74:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L87
        L78:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L7b:
            java.lang.String r1 = "WS_Base64"
            java.lang.String r2 = "Base64 decode error."
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(r1, r2, r6)     // Catch: java.lang.Throwable -> L86
            r0.close()     // Catch: java.lang.Exception -> L59
            goto L59
        L86:
            r5 = move-exception
        L87:
            r0.close()     // Catch: java.lang.Exception -> L8a
        L8a:
            r4.close()     // Catch: java.lang.Exception -> L8d
        L8d:
            r3.close()     // Catch: java.lang.Exception -> L90
        L90:
            throw r5
        L91:
            return r5
        L92:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.g.a.a(java.lang.String, int):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 != null) {
            if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
                if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
                    byte[] bArrC = c(i4);
                    byte b2 = bArr[i2 + 2];
                    if (b2 == 61) {
                        bArr2[i3] = (byte) ((((bArrC[bArr[i2 + 1]] & 255) << 12) | ((bArrC[bArr[i2]] & 255) << 18)) >>> 16);
                        return 1;
                    }
                    byte b3 = bArr[i5];
                    if (b3 == 61) {
                        int i7 = ((bArrC[bArr[i2 + 1]] & 255) << 12) | ((bArrC[bArr[i2]] & 255) << 18) | ((bArrC[b2] & 255) << 6);
                        bArr2[i3] = (byte) (i7 >>> 16);
                        bArr2[i3 + 1] = (byte) (i7 >>> 8);
                        return 2;
                    }
                    int i8 = ((bArrC[bArr[i2 + 1]] & 255) << 12) | ((bArrC[bArr[i2]] & 255) << 18) | ((bArrC[b2] & 255) << 6) | (bArrC[b3] & 255);
                    bArr2[i3] = (byte) (i8 >> 16);
                    bArr2[i3 + 1] = (byte) (i8 >> 8);
                    bArr2[i6] = (byte) i8;
                    return 3;
                }
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
        }
        throw new NullPointerException("Destination array was null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static Object a(String str, int i2, final ClassLoader classLoader) throws Throwable {
        ObjectInputStream objectInputStream;
        byte[] bArrA = a(str, i2);
        ByteArrayInputStream byteArrayInputStream = null;
        objectInputStream = null;
        objectInputStream = null;
        ObjectInputStream objectInputStream2 = null;
        byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrA);
                try {
                    if (classLoader == 0) {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream2);
                    } else {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream2) { // from class: com.alipay.android.phone.mobilesdk.socketcraft.g.a.1
                            @Override // java.io.ObjectInputStream
                            public final Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
                                Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                                return cls == null ? super.resolveClass(objectStreamClass) : cls;
                            }
                        };
                    }
                    objectInputStream2 = objectInputStream;
                    Object object = objectInputStream2.readObject();
                    try {
                        byteArrayInputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        objectInputStream2.close();
                    } catch (Exception unused2) {
                    }
                    return object;
                } catch (IOException e2) {
                    throw e2;
                } catch (ClassNotFoundException e3) {
                    throw e3;
                } catch (Throwable th) {
                    th = th;
                    classLoader = objectInputStream2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        classLoader.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            throw e4;
        } catch (ClassNotFoundException e5) {
            throw e5;
        } catch (Throwable th3) {
            th = th3;
            classLoader = 0;
        }
    }

    public static Object b(String str) {
        return a(str, 0, (ClassLoader) null);
    }

    public static void b(String str, String str2) throws Throwable {
        String strD = d(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(strD.getBytes("US-ASCII"));
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void a(byte[] bArr, String str) throws Throwable {
        if (bArr != null) {
            b bVar = null;
            try {
                try {
                    b bVar2 = new b(new FileOutputStream(str), 1);
                    try {
                        bVar2.write(bArr);
                        try {
                            bVar2.close();
                        } catch (Exception unused) {
                        }
                    } catch (IOException e2) {
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        try {
                            bVar.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }

    public static void a(String str, String str2) throws Throwable {
        b bVar = null;
        try {
            try {
                b bVar2 = new b(new FileOutputStream(str2), 0);
                try {
                    bVar2.write(str.getBytes("US-ASCII"));
                    try {
                        bVar2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
