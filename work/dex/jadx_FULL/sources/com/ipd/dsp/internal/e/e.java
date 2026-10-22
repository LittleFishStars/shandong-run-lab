package com.ipd.dsp.internal.e;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements a {
    public static final String A = "e";
    public static final int B = 4096;
    public static final int C = -1;
    public static final int D = -1;
    public static final int E = 4;
    public static final int F = 255;

    @ColorInt
    public static final int G = 0;

    @ColorInt
    public int[] f;

    @ColorInt
    public final int[] g;
    public final a.InterfaceC0876a h;
    public ByteBuffer i;
    public byte[] j;
    public d k;
    public short[] l;
    public byte[] m;
    public byte[] n;
    public byte[] o;

    @ColorInt
    public int[] p;
    public int q;
    public c r;
    public Bitmap s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;

    @Nullable
    public Boolean y;

    @NonNull
    public Bitmap.Config z;

    public e(@NonNull a.InterfaceC0876a interfaceC0876a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0876a, cVar, byteBuffer, 1);
    }

    @Override // com.ipd.dsp.internal.e.a
    public int a(int i) {
        if (i < 0) {
            return -1;
        }
        c cVar = this.r;
        if (i < cVar.c) {
            return cVar.e.get(i).i;
        }
        return -1;
    }

    @Override // com.ipd.dsp.internal.e.a
    @Nullable
    public synchronized Bitmap b() {
        if (this.r.c <= 0 || this.q < 0) {
            if (Dsp.isDebugLogEnable()) {
                k.a(A, "Unable to decode frame, frameCount=" + this.r.c + ", framePointer=" + this.q);
            }
            this.u = 1;
        }
        int i = this.u;
        if (i != 1 && i != 2) {
            this.u = 0;
            if (this.j == null) {
                this.j = this.h.a(255);
            }
            b bVar = this.r.e.get(this.q);
            int i2 = this.q - 1;
            b bVar2 = i2 >= 0 ? this.r.e.get(i2) : null;
            int[] iArr = bVar.k;
            if (iArr == null) {
                iArr = this.r.f38286a;
            }
            this.f = iArr;
            if (iArr == null) {
                if (Dsp.isDebugLogEnable()) {
                    k.a(A, "No valid color table found for frame #" + this.q);
                }
                this.u = 1;
                return null;
            }
            if (bVar.f) {
                System.arraycopy(iArr, 0, this.g, 0, iArr.length);
                int[] iArr2 = this.g;
                this.f = iArr2;
                iArr2[bVar.h] = 0;
                if (bVar.g == 2 && this.q == 0) {
                    this.y = Boolean.TRUE;
                }
            }
            return a(bVar, bVar2);
        }
        if (Dsp.isDebugLogEnable()) {
            k.a(A, "Unable to decode frame, status=" + this.u);
        }
        return null;
    }

    @Override // com.ipd.dsp.internal.e.a
    public void c() {
        this.q = (this.q + 1) % this.r.c;
    }

    @Override // com.ipd.dsp.internal.e.a
    public void clear() {
        this.r = null;
        byte[] bArr = this.o;
        if (bArr != null) {
            this.h.a(bArr);
        }
        int[] iArr = this.p;
        if (iArr != null) {
            this.h.a(iArr);
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            this.h.a(bitmap);
        }
        this.s = null;
        this.i = null;
        this.y = null;
        byte[] bArr2 = this.j;
        if (bArr2 != null) {
            this.h.a(bArr2);
        }
    }

    @Override // com.ipd.dsp.internal.e.a
    public int d() {
        return this.r.g;
    }

    @Override // com.ipd.dsp.internal.e.a
    public int e() {
        return this.r.c;
    }

    @Override // com.ipd.dsp.internal.e.a
    public int f() {
        int i;
        if (this.r.c <= 0 || (i = this.q) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.ipd.dsp.internal.e.a
    public int g() {
        return this.r.m;
    }

    @Override // com.ipd.dsp.internal.e.a
    public int h() {
        return this.u;
    }

    @Override // com.ipd.dsp.internal.e.a
    public int i() {
        return this.i.limit() + this.o.length + (this.p.length * 4);
    }

    @Override // com.ipd.dsp.internal.e.a
    public int j() {
        return this.r.f;
    }

    @Override // com.ipd.dsp.internal.e.a
    public int k() {
        int i = this.r.m;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.ipd.dsp.internal.e.a
    @Deprecated
    public int l() {
        int i = this.r.m;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.ipd.dsp.internal.e.a
    @NonNull
    public ByteBuffer m() {
        return this.i;
    }

    @Override // com.ipd.dsp.internal.e.a
    public void n() {
        this.q = -1;
    }

    @NonNull
    public final d o() {
        if (this.k == null) {
            this.k = new d();
        }
        return this.k;
    }

    public final Bitmap p() {
        Boolean bool = this.y;
        Bitmap bitmapA = this.h.a(this.x, this.w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.z);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    public final int q() {
        int iR = r();
        if (iR <= 0) {
            return iR;
        }
        ByteBuffer byteBuffer = this.i;
        byteBuffer.get(this.j, 0, Math.min(iR, byteBuffer.remaining()));
        return iR;
    }

    public final int r() {
        return this.i.get() & 255;
    }

    @Override // com.ipd.dsp.internal.e.a
    public synchronized int read(@Nullable byte[] bArr) {
        c cVarD = o().a(bArr).d();
        this.r = cVarD;
        if (bArr != null) {
            a(cVarD, bArr);
        }
        return this.u;
    }

    public e(@NonNull a.InterfaceC0876a interfaceC0876a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0876a);
        a(cVar, byteBuffer, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [short] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void c(b bVar) {
        int i;
        int i2;
        short s;
        int i3;
        this = this;
        if (bVar != null) {
            this.i.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = this.r;
            i = cVar.f;
            i2 = cVar.g;
        } else {
            i = bVar.c;
            i2 = bVar.d;
        }
        int i4 = i * i2;
        byte[] bArr = this.o;
        if (bArr == null || bArr.length < i4) {
            this.o = this.h.a(i4);
        }
        byte[] bArr2 = this.o;
        if (this.l == null) {
            this.l = new short[4096];
        }
        short[] sArr = this.l;
        if (this.m == null) {
            this.m = new byte[4096];
        }
        byte[] bArr3 = this.m;
        if (this.n == null) {
            this.n = new byte[4097];
        }
        byte[] bArr4 = this.n;
        int iR = r();
        int i5 = 1 << iR;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iR + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = this.j;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int iQ = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = -1;
        while (i10 < i4) {
            if (iQ == 0) {
                iQ = q();
                if (iQ <= 0) {
                    this.u = 3;
                    break;
                }
                i20 = 0;
            }
            i16 += (bArr5[i20] & 255) << i15;
            i20++;
            iQ--;
            int i22 = i15 + 8;
            i18 = i18;
            i21 = i21;
            int i23 = i13;
            i12 = i12;
            while (true) {
                if (i22 < i12) {
                    i15 = i22;
                    i13 = i23;
                    break;
                }
                int i24 = i8;
                int i25 = i16 & i14;
                i16 >>= i12;
                i22 -= i12;
                if (i25 == i5) {
                    i23 = i7;
                    i14 = i9;
                    i8 = i24;
                    i12 = i8;
                    i21 = -1;
                } else {
                    if (i25 == i6) {
                        i15 = i22;
                        i8 = i24;
                        i13 = i23;
                        break;
                    }
                    if (i21 == -1) {
                        bArr2[i17] = bArr3[i25];
                        i17++;
                        i10++;
                        i21 = i25;
                        i18 = i21;
                        i8 = i24;
                        i22 = i22;
                    } else {
                        int i26 = i23;
                        if (i25 >= i26) {
                            bArr4[i19] = (byte) i18;
                            i19++;
                            s = i21;
                        } else {
                            s = i25;
                        }
                        while (s >= i5) {
                            bArr4[i19] = bArr3[s];
                            i19++;
                            s = sArr[s];
                        }
                        i18 = bArr3[s] & 255;
                        byte b = (byte) i18;
                        bArr2[i17] = b;
                        while (true) {
                            i17++;
                            i10++;
                            if (i19 <= 0) {
                                break;
                            }
                            i19--;
                            bArr2[i17] = bArr4[i19];
                        }
                        byte[] bArr6 = bArr4;
                        if (i26 < 4096) {
                            sArr[i26] = (short) i21;
                            bArr3[i26] = b;
                            i3 = i26 + 1;
                            if ((i3 & i14) == 0 && i3 < 4096) {
                                i12++;
                                i14 += i3;
                            }
                        } else {
                            i3 = i26;
                        }
                        i8 = i24;
                        i22 = i22;
                        bArr4 = bArr6;
                        i23 = i3;
                        i21 = i25;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i17, i4, (byte) 0);
    }

    @Override // com.ipd.dsp.internal.e.a
    public int a() {
        return this.q;
    }

    public e(@NonNull a.InterfaceC0876a interfaceC0876a) {
        this.g = new int[256];
        this.z = Bitmap.Config.ARGB_8888;
        this.h = interfaceC0876a;
        this.r = new c();
    }

    @Override // com.ipd.dsp.internal.e.a
    public int a(@Nullable InputStream inputStream, int i) {
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
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                k.e(A, "Error reading data from stream", e);
            }
        } else {
            this.u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                k.e(A, "Error closing stream", e2);
            }
        }
        return this.u;
    }

    @Override // com.ipd.dsp.internal.e.a
    public synchronized void a(@NonNull c cVar, @NonNull byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    @Override // com.ipd.dsp.internal.e.a
    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    @Override // com.ipd.dsp.internal.e.a
    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i) {
        try {
            if (i > 0) {
                int iHighestOneBit = Integer.highestOneBit(i);
                this.u = 0;
                this.r = cVar;
                this.q = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.i = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.i.order(ByteOrder.LITTLE_ENDIAN);
                this.t = false;
                Iterator<b> it = cVar.e.iterator();
                while (it.hasNext()) {
                    if (it.next().g == 3) {
                        this.t = true;
                        break;
                    }
                }
                this.v = iHighestOneBit;
                int i2 = cVar.f;
                this.x = i2 / iHighestOneBit;
                int i3 = cVar.g;
                this.w = i3 / iHighestOneBit;
                this.o = this.h.a(i2 * i3);
                this.p = this.h.b(this.x * this.w);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.p;
        int i = bVar2.d;
        int i2 = bVar2.b;
        int i3 = bVar2.c;
        int i4 = bVar2.f38285a;
        boolean z = this.q == 0;
        int i5 = this.x;
        byte[] bArr = this.o;
        int[] iArr2 = this.f;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            bVar2 = bVar;
        }
        Boolean bool = this.y;
        this.y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.y == null && z && b != -1));
    }

    @Override // com.ipd.dsp.internal.e.a
    public void a(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config != config3 && config != (config2 = Bitmap.Config.RGB_565)) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
        }
        this.z = config;
    }

    public final Bitmap a(b bVar, b bVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.p;
        int i3 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.s;
            if (bitmap2 != null) {
                this.h.a(bitmap2);
            }
            this.s = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.s == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i2 = bVar2.g) > 0) {
            if (i2 == 2) {
                if (!bVar.f) {
                    c cVar = this.r;
                    int i4 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.h) {
                        i3 = i4;
                    }
                }
                int i5 = bVar2.d;
                int i6 = this.v;
                int i7 = i5 / i6;
                int i8 = bVar2.b / i6;
                int i9 = bVar2.c / i6;
                int i10 = bVar2.f38285a / i6;
                int i11 = this.x;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.x;
                }
            } else if (i2 == 3 && (bitmap = this.s) != null) {
                int i16 = this.x;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.w);
            }
        }
        c(bVar);
        if (!bVar.e && this.v == 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.t && ((i = bVar.g) == 0 || i == 1)) {
            if (this.s == null) {
                this.s = p();
            }
            Bitmap bitmap3 = this.s;
            int i17 = this.x;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.w);
        }
        Bitmap bitmapP = p();
        int i18 = this.x;
        bitmapP.setPixels(iArr, 0, i18, 0, 0, i18, this.w);
        return bitmapP;
    }

    public final void a(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.p;
        int i6 = bVar.d;
        int i7 = this.v;
        int i8 = i6 / i7;
        int i9 = bVar.b / i7;
        int i10 = bVar.c / i7;
        int i11 = bVar.f38285a / i7;
        boolean z = this.q == 0;
        int i12 = this.x;
        int i13 = this.w;
        byte[] bArr = this.o;
        int[] iArr2 = this.f;
        Boolean bool = this.y;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i8) {
            Boolean bool2 = bool;
            if (bVar.e) {
                if (i15 >= i8) {
                    int i18 = i17 + 1;
                    i = i8;
                    if (i18 == 2) {
                        i15 = 4;
                        i17 = i18;
                    } else if (i18 != 3) {
                        i17 = i18;
                        if (i18 == 4) {
                            i15 = 1;
                            i14 = 2;
                        }
                    } else {
                        i14 = 4;
                        i17 = i18;
                        i15 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i15 + i14;
            } else {
                i = i8;
                i2 = i15;
                i15 = i16;
            }
            int i19 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i16 * i7 * bVar.c;
                if (z2) {
                    int i25 = i21;
                    while (true) {
                        i4 = i9;
                        if (i25 >= i22) {
                            break;
                        }
                        int i26 = iArr2[bArr[i24] & 255];
                        if (i26 != 0) {
                            iArr[i25] = i26;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i4;
                    }
                } else {
                    i4 = i9;
                    int i27 = ((i22 - i21) * i7) + i24;
                    int i28 = i21;
                    while (true) {
                        i5 = i10;
                        if (i28 < i22) {
                            int iA = a(i24, i27, bVar.c);
                            if (iA != 0) {
                                iArr[i28] = iA;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i24 += i7;
                            i28++;
                            i10 = i5;
                        }
                    }
                }
                bool = bool2;
                i16++;
                i9 = i4;
                i8 = i;
                i10 = i5;
                i15 = i3;
            } else {
                i3 = i2;
                i4 = i9;
            }
            i5 = i10;
            bool = bool2;
            i16++;
            i9 = i4;
            i8 = i;
            i10 = i5;
            i15 = i3;
        }
        Boolean bool3 = bool;
        if (this.y == null) {
            this.y = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    @ColorInt
    public final int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.v + i; i9++) {
            byte[] bArr = this.o;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f[bArr[i9] & 255];
            if (i10 != 0) {
                i7 += (i10 >> 24) & 255;
                i6 += (i10 >> 16) & 255;
                i5 += (i10 >> 8) & 255;
                i4 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.v + i11; i12++) {
            byte[] bArr2 = this.o;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f[bArr2[i12] & 255];
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
}
