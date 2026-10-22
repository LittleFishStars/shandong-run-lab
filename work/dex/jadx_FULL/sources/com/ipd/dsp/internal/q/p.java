package com.ipd.dsp.internal.q;

import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p implements ImageHeaderParser {
    public static final int A = 1635150182;
    public static final int B = 1635150195;
    public static final String b = "DfltImageHeaderParser";
    public static final int c = 4671814;
    public static final int d = -1991225785;
    public static final int e = 65496;
    public static final int f = 19789;
    public static final int g = 18761;
    public static final int j = 218;
    public static final int k = 217;
    public static final int l = 255;
    public static final int m = 225;
    public static final int n = 274;
    public static final int p = 1380533830;
    public static final int q = 1464156752;
    public static final int r = 1448097792;
    public static final int s = -256;
    public static final int t = 255;
    public static final int u = 88;
    public static final int v = 76;
    public static final int w = 2;
    public static final int x = 16;
    public static final int y = 8;
    public static final int z = 1718909296;
    public static final String h = "Exif\u0000\u0000";
    public static final byte[] i = h.getBytes(StandardCharsets.UTF_8);
    public static final int[] o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f38510a;

        public b(byte[] bArr, int i) {
            this.f38510a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public void a(ByteOrder byteOrder) {
            this.f38510a.order(byteOrder);
        }

        public int b(int i) {
            if (a(i, 4)) {
                return this.f38510a.getInt(i);
            }
            return -1;
        }

        public int a() {
            return this.f38510a.remaining();
        }

        public short a(int i) {
            if (a(i, 2)) {
                return this.f38510a.getShort(i);
            }
            return (short) -1;
        }

        public final boolean a(int i, int i2) {
            return this.f38510a.remaining() - i >= i2;
        }
    }

    public interface c {

        public static final class a extends IOException {
            public static final long f = 1;

            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] bArr, int i) throws IOException;

        short a() throws IOException;

        int b() throws IOException;

        long skip(long j) throws IOException;
    }

    public static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    public static boolean a(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) throws IOException {
        return a(new d((InputStream) com.ipd.dsp.internal.d0.m.a(inputStream)));
    }

    public final int b(c cVar) throws IOException {
        short sA;
        int iB;
        long j2;
        long jSkip;
        do {
            short sA2 = cVar.a();
            if (sA2 != 255) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(b, "Unknown segmentId=" + ((int) sA2));
                }
                return -1;
            }
            sA = cVar.a();
            if (sA == 218) {
                return -1;
            }
            if (sA == 217) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(b, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iB = cVar.b() - 2;
            if (sA == 225) {
                return iB;
            }
            j2 = iB;
            jSkip = cVar.skip(j2);
        } while (jSkip == j2);
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(b, "Unable to skip enough data, type: " + ((int) sA) + ", wanted to skip: " + iB + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f38511a;

        public d(InputStream inputStream) {
            this.f38511a = inputStream;
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public short a() throws IOException {
            int i = this.f38511a.read();
            if (i != -1) {
                return (short) i;
            }
            throw new c.a();
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public int b() throws IOException {
            return (a() << 8) | a();
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.f38511a.skip(j2);
                if (jSkip <= 0) {
                    if (this.f38511a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public int a(byte[] bArr, int i) throws IOException {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.f38511a.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new c.a();
            }
            return i2;
        }
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return a(new a((ByteBuffer) com.ipd.dsp.internal.d0.m.a(byteBuffer)));
    }

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f38509a;

        public a(ByteBuffer byteBuffer) {
            this.f38509a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public short a() throws c.a {
            if (this.f38509a.remaining() >= 1) {
                return (short) (this.f38509a.get() & 255);
            }
            throw new c.a();
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public int b() throws c.a {
            return (a() << 8) | a();
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public long skip(long j) {
            int iMin = (int) Math.min(this.f38509a.remaining(), j);
            ByteBuffer byteBuffer = this.f38509a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // com.ipd.dsp.internal.q.p.c
        public int a(byte[] bArr, int i) {
            int iMin = Math.min(i, this.f38509a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f38509a.get(bArr, 0, iMin);
            return iMin;
        }
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        return a(new d((InputStream) com.ipd.dsp.internal.d0.m.a(inputStream)), (com.ipd.dsp.internal.j.b) com.ipd.dsp.internal.d0.m.a(bVar));
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        return a(new a((ByteBuffer) com.ipd.dsp.internal.d0.m.a(byteBuffer)), (com.ipd.dsp.internal.j.b) com.ipd.dsp.internal.d0.m.a(bVar));
    }

    @NonNull
    public final ImageHeaderParser.ImageType a(c cVar) throws IOException {
        try {
            int iB = cVar.b();
            if (iB == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iA = (iB << 8) | cVar.a();
            if (iA == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iA2 = (iA << 8) | cVar.a();
            if (iA2 == -1991225785) {
                cVar.skip(21L);
                try {
                    return cVar.a() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iA2 != 1380533830) {
                return a(cVar, iA2);
            }
            cVar.skip(4L);
            if (((cVar.b() << 16) | cVar.b()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iB2 = (cVar.b() << 16) | cVar.b();
            if ((iB2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = iB2 & 255;
            if (i2 != 88) {
                if (i2 == 76) {
                    cVar.skip(4L);
                    return (cVar.a() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            cVar.skip(4L);
            short sA = cVar.a();
            if ((sA & 2) != 0) {
                return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            }
            if ((sA & 16) != 0) {
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    public final ImageHeaderParser.ImageType a(c cVar, int i2) throws IOException {
        if (((cVar.b() << 16) | cVar.b()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iB = (cVar.b() << 16) | cVar.b();
        if (iB == 1635150195) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i3 = 0;
        boolean z2 = iB == 1635150182;
        cVar.skip(4L);
        int i4 = i2 - 16;
        if (i4 % 4 == 0) {
            while (i3 < 5 && i4 > 0) {
                int iB2 = (cVar.b() << 16) | cVar.b();
                if (iB2 == 1635150195) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (iB2 == 1635150182) {
                    z2 = true;
                }
                i3++;
                i4 -= 4;
            }
        }
        return z2 ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }

    public final int a(c cVar, com.ipd.dsp.internal.j.b bVar) throws IOException {
        try {
            int iB = cVar.b();
            if (!a(iB)) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(b, "Parser doesn't handle magic number: " + iB);
                }
                return -1;
            }
            int iB2 = b(cVar);
            if (iB2 == -1) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(b, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.b(iB2, byte[].class);
            try {
                return a(cVar, bArr, iB2);
            } finally {
                bVar.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    public final int a(c cVar, byte[] bArr, int i2) throws IOException {
        int iA = cVar.a(bArr, i2);
        if (iA != i2) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(b, "Unable to read exif segment data, length: " + i2 + ", actually read: " + iA);
            }
            return -1;
        }
        if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(b, "Missing jpeg exif preamble");
        }
        return -1;
    }

    public final boolean a(byte[] bArr, int i2) {
        boolean z2 = bArr != null && i2 > i.length;
        if (z2) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = i;
                if (i3 >= bArr2.length) {
                    break;
                }
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            }
        }
        return z2;
    }

    public static int a(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(b, "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i2 = 0; i2 < sA2; i2++) {
            int iA = a(iB, i2);
            short sA3 = bVar.a(iA);
            if (sA3 == 274) {
                short sA4 = bVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iA + 4);
                    if (iB2 < 0) {
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(b, "Negative tiff component count");
                        }
                    } else {
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(b, "Got tagIndex=" + i2 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i3 = iB2 + o[sA4];
                        if (i3 > 4) {
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(b, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                            }
                        } else {
                            int i4 = iA + 8;
                            if (i4 >= 0 && i4 <= bVar.a()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                    return bVar.a(i4);
                                }
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.a(b, "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(b, "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) sA3));
                            }
                        }
                    }
                } else if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(b, "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }
}
