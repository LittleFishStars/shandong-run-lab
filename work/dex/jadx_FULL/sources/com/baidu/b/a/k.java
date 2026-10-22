package com.baidu.b.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f26259a;
    private final int[] b;
    private final byte[] c;
    private final int d;
    private int e;
    private int f;

    public k() {
        this(0);
    }

    public k(int i) {
        this.f26259a = new byte[1];
        this.b = new int[4];
        this.c = new byte[16];
        this.d = i;
        b();
    }

    private static int a(byte[] bArr, int i) {
        return (int) (b(bArr, i, 4) & 4294967295L);
    }

    private static long b(byte[] bArr, int i, int i2) {
        if (i2 > 8) {
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }

    private void b() {
        int[] iArr = this.b;
        int i = this.d;
        iArr[0] = (i - 1640531535) - 2048144777;
        iArr[1] = (-2048144777) + i;
        iArr[2] = i;
        iArr[3] = i - (-1640531535);
    }

    private void b(byte[] bArr, int i) {
        int[] iArr = this.b;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int iRotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * (-2048144777)), 13) * (-1640531535);
        int[] iArr2 = this.b;
        iArr2[0] = iRotateLeft;
        iArr2[1] = iRotateLeft2;
        iArr2[2] = iRotateLeft3;
        iArr2[3] = iRotateLeft4;
        this.f = 0;
    }

    public long a() {
        int i = 0;
        int iRotateLeft = (this.e > 16 ? Integer.rotateLeft(this.b[0], 1) + Integer.rotateLeft(this.b[1], 7) + Integer.rotateLeft(this.b[2], 12) + Integer.rotateLeft(this.b[3], 18) : this.b[2] + 374761393) + this.e;
        int i2 = this.f - 4;
        while (i <= i2) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + (a(this.c, i) * (-1028477379)), 17) * 668265263;
            i += 4;
        }
        while (i < this.f) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + ((this.c[i] & 255) * 374761393), 11) * (-1640531535);
            i++;
        }
        int i3 = (iRotateLeft ^ (iRotateLeft >>> 15)) * (-2048144777);
        int i4 = (i3 ^ (i3 >>> 13)) * (-1028477379);
        return ((long) (i4 ^ (i4 >>> 16))) & 4294967295L;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this.e += i2;
        int i3 = i + i2;
        int i4 = this.f;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.c, i4, i2);
            this.f += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.c, i4, i5);
            b(this.c, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            b(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.f = i7;
            System.arraycopy(bArr, i, this.c, 0, i7);
        }
    }
}
