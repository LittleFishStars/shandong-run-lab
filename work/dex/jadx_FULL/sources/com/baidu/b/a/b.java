package com.baidu.b.a;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b implements Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f26255a = true;
    private static final ObjectStreamField[] b = {new ObjectStreamField("bits", long[].class)};
    private long[] c;
    private transient int d;
    private transient boolean e;

    public b() {
        this.d = 0;
        this.e = false;
        g(64);
        this.e = false;
    }

    public b(int i) {
        this.d = 0;
        this.e = false;
        if (i >= 0) {
            g(i);
            this.e = true;
        } else {
            throw new NegativeArraySizeException("nbits < 0: " + i);
        }
    }

    private b(long[] jArr) {
        this.d = 0;
        this.e = false;
        this.c = jArr;
        this.d = jArr.length;
        d();
    }

    public static b a(long[] jArr) {
        int length = jArr.length;
        while (length > 0 && jArr[length - 1] == 0) {
            length--;
        }
        return new b(Arrays.copyOf(jArr, length));
    }

    private void d() {
        int i;
        int i2;
        boolean z = f26255a;
        if (!z && (i2 = this.d) != 0 && this.c[i2 - 1] == 0) {
            throw new AssertionError();
        }
        if (!z && ((i = this.d) < 0 || i > this.c.length)) {
            throw new AssertionError();
        }
        if (z) {
            return;
        }
        int i3 = this.d;
        long[] jArr = this.c;
        if (i3 != jArr.length && jArr[i3] != 0) {
            throw new AssertionError();
        }
    }

    private static void d(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i2);
        }
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + " > toIndex: " + i2);
    }

    private void e() {
        int i = this.d - 1;
        while (i >= 0 && this.c[i] == 0) {
            i--;
        }
        this.d = i + 1;
    }

    private static int f(int i) {
        return i >> 6;
    }

    private void f() {
        int i = this.d;
        long[] jArr = this.c;
        if (i != jArr.length) {
            this.c = Arrays.copyOf(jArr, i);
            d();
        }
    }

    private void g(int i) {
        this.c = new long[f(i - 1) + 1];
    }

    private void h(int i) {
        long[] jArr = this.c;
        if (jArr.length < i) {
            this.c = Arrays.copyOf(this.c, Math.max(jArr.length * 2, i));
            this.e = false;
        }
    }

    private void i(int i) {
        int i2 = i + 1;
        if (this.d < i2) {
            h(i2);
            this.d = i2;
        }
    }

    public void a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int iF = f(i);
        i(iF);
        long[] jArr = this.c;
        jArr[iF] = jArr[iF] | (1 << i);
        d();
    }

    public void a(int i, int i2) {
        d(i, i2);
        if (i == i2) {
            return;
        }
        int iF = f(i);
        int iF2 = f(i2 - 1);
        i(iF2);
        long j = (-1) << i;
        long j2 = (-1) >>> (-i2);
        if (iF == iF2) {
            long[] jArr = this.c;
            jArr[iF] = (j2 & j) | jArr[iF];
        } else {
            long[] jArr2 = this.c;
            jArr2[iF] = j | jArr2[iF];
            while (true) {
                iF++;
                if (iF >= iF2) {
                    break;
                } else {
                    this.c[iF] = -1;
                }
            }
            long[] jArr3 = this.c;
            jArr3[iF2] = j2 | jArr3[iF2];
        }
        d();
    }

    public void a(int i, int i2, boolean z) {
        if (z) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    public void a(int i, boolean z) {
        if (z) {
            a(i);
        } else {
            b(i);
        }
    }

    public void a(b bVar) {
        if (this == bVar) {
            return;
        }
        while (true) {
            int i = this.d;
            if (i <= bVar.d) {
                break;
            }
            long[] jArr = this.c;
            int i2 = i - 1;
            this.d = i2;
            jArr[i2] = 0;
        }
        for (int i3 = 0; i3 < this.d; i3++) {
            long[] jArr2 = this.c;
            jArr2[i3] = jArr2[i3] & bVar.c[i3];
        }
        e();
        d();
    }

    public byte[] a() {
        int i = this.d;
        if (i == 0) {
            return new byte[0];
        }
        int i2 = i - 1;
        int i3 = i2 * 8;
        for (long j = this.c[i2]; j != 0; j >>>= 8) {
            i3++;
        }
        byte[] bArr = new byte[i3];
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i4 = 0; i4 < i2; i4++) {
            byteBufferOrder.putLong(this.c[i4]);
        }
        for (long j2 = this.c[i2]; j2 != 0; j2 >>>= 8) {
            byteBufferOrder.put((byte) (255 & j2));
        }
        return bArr;
    }

    public int b() {
        int i = this.d;
        if (i == 0) {
            return 0;
        }
        int i2 = i - 1;
        return (i2 * 64) + (64 - Long.numberOfLeadingZeros(this.c[i2]));
    }

    public void b(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int iF = f(i);
        if (iF >= this.d) {
            return;
        }
        long[] jArr = this.c;
        jArr[iF] = jArr[iF] & (~(1 << i));
        e();
        d();
    }

    public void b(int i, int i2) {
        int iF;
        d(i, i2);
        if (i != i2 && (iF = f(i)) < this.d) {
            int iF2 = f(i2 - 1);
            if (iF2 >= this.d) {
                i2 = b();
                iF2 = this.d - 1;
            }
            long j = (-1) << i;
            long j2 = (-1) >>> (-i2);
            if (iF == iF2) {
                long[] jArr = this.c;
                jArr[iF] = (~(j2 & j)) & jArr[iF];
            } else {
                long[] jArr2 = this.c;
                jArr2[iF] = (~j) & jArr2[iF];
                while (true) {
                    iF++;
                    if (iF >= iF2) {
                        break;
                    } else {
                        this.c[iF] = 0;
                    }
                }
                long[] jArr3 = this.c;
                jArr3[iF2] = (~j2) & jArr3[iF2];
            }
            e();
            d();
        }
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        int iMin = Math.min(this.d, bVar.d);
        int i = this.d;
        int i2 = bVar.d;
        if (i < i2) {
            h(i2);
            this.d = bVar.d;
        }
        for (int i3 = 0; i3 < iMin; i3++) {
            long[] jArr = this.c;
            jArr[i3] = jArr[i3] | bVar.c[i3];
        }
        if (iMin < bVar.d) {
            System.arraycopy(bVar.c, iMin, this.c, iMin, this.d - iMin);
        }
        d();
    }

    public int c() {
        int iBitCount = 0;
        for (int i = 0; i < this.d; i++) {
            iBitCount += Long.bitCount(this.c[i]);
        }
        return iBitCount;
    }

    public b c(int i, int i2) {
        int i3;
        long j;
        d(i, i2);
        d();
        int iB = b();
        int i4 = 0;
        if (iB <= i || i == i2) {
            return new b(0);
        }
        if (i2 > iB) {
            i2 = iB;
        }
        int i5 = i2 - i;
        b bVar = new b(i5);
        int iF = f(i5 - 1) + 1;
        int iF2 = f(i);
        int i6 = i & 63;
        boolean z = i6 == 0;
        while (true) {
            i3 = iF - 1;
            if (i4 >= i3) {
                break;
            }
            long[] jArr = bVar.c;
            long[] jArr2 = this.c;
            jArr[i4] = z ? jArr2[iF2] : (jArr2[iF2] >>> i) | (jArr2[iF2 + 1] << (-i));
            i4++;
            iF2++;
        }
        long j2 = (-1) >>> (-i2);
        long[] jArr3 = bVar.c;
        if (((i2 - 1) & 63) < i6) {
            long[] jArr4 = this.c;
            j = ((jArr4[iF2 + 1] & j2) << (-i)) | (jArr4[iF2] >>> i);
        } else {
            j = (this.c[iF2] & j2) >>> i;
        }
        jArr3[i3] = j;
        bVar.d = iF;
        bVar.e();
        bVar.d();
        return bVar;
    }

    public void c(b bVar) {
        int iMin = Math.min(this.d, bVar.d);
        int i = this.d;
        int i2 = bVar.d;
        if (i < i2) {
            h(i2);
            this.d = bVar.d;
        }
        for (int i3 = 0; i3 < iMin; i3++) {
            long[] jArr = this.c;
            jArr[i3] = jArr[i3] ^ bVar.c[i3];
        }
        int i4 = bVar.d;
        if (iMin < i4) {
            System.arraycopy(bVar.c, iMin, this.c, iMin, i4 - iMin);
        }
        e();
        d();
    }

    public boolean c(int i) {
        if (i >= 0) {
            d();
            int iF = f(i);
            return iF < this.d && (this.c[iF] & (1 << i)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
    }

    public Object clone() {
        if (!this.e) {
            f();
        }
        try {
            b bVar = (b) super.clone();
            bVar.c = (long[]) this.c.clone();
            bVar.d();
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        d();
        int iF = f(i);
        if (iF >= this.d) {
            return -1;
        }
        long j = this.c[iF] & ((-1) << i);
        while (j == 0) {
            iF++;
            if (iF == this.d) {
                return -1;
            }
            j = this.c[iF];
        }
        return (iF * 64) + Long.numberOfTrailingZeros(j);
    }

    public void d(b bVar) {
        for (int iMin = Math.min(this.d, bVar.d) - 1; iMin >= 0; iMin--) {
            long[] jArr = this.c;
            jArr[iMin] = jArr[iMin] & (~bVar.c[iMin]);
        }
        e();
        d();
    }

    public int e(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        d();
        int iF = f(i);
        if (iF >= this.d) {
            return i;
        }
        long j = (~this.c[iF]) & ((-1) << i);
        while (j == 0) {
            iF++;
            int i2 = this.d;
            if (iF == i2) {
                return i2 * 64;
            }
            j = ~this.c[iF];
        }
        return (iF * 64) + Long.numberOfTrailingZeros(j);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        b bVar = (b) obj;
        d();
        bVar.d();
        if (this.d != bVar.d) {
            return false;
        }
        for (int i = 0; i < this.d; i++) {
            if (this.c[i] != bVar.c[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.d;
        long j = 1234;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((j >> 32) ^ j);
            }
            j ^= this.c[i] * ((long) (i + 1));
        }
    }

    public String toString() {
        d();
        int i = this.d;
        StringBuilder sb = new StringBuilder(((i > 128 ? c() : i * 64) * 6) + 2);
        sb.append('{');
        int iD = d(0);
        if (iD != -1) {
            sb.append(iD);
            while (true) {
                iD = d(iD + 1);
                if (iD < 0) {
                    break;
                }
                int iE = e(iD);
                do {
                    sb.append(", ");
                    sb.append(iD);
                    iD++;
                } while (iD < iE);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
