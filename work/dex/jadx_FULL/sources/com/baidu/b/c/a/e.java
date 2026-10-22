package com.baidu.b.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f26281a;
    private int b;
    private int c;
    private int f;
    private i g;
    private f h;
    private int d = 0;
    private int e = 0;
    private int i = 1;
    private boolean j = false;

    public e(b bVar, int i) {
        this.f26281a = null;
        this.g = null;
        this.h = null;
        this.b = i;
        this.c = i;
        this.f = i;
        this.f26281a = new byte[i * 2];
        this.h = new d(bVar);
        this.g = new h(this.b);
    }

    private int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IllegalBlockSizeException {
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i4 = this.i;
        if (i4 == 2 || i4 == 3 || i3 % this.c == 0 || i4 == 6) {
            if (this.j) {
                this.h.d(bArr, i, i3, bArr2, i2);
            } else {
                this.h.c(bArr, i, i3, bArr2, i2);
            }
            return i3;
        }
        if (this.g != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.c + " bytes");
        }
        throw new IllegalBlockSizeException("Input length not multiple of " + this.c + " bytes");
    }

    public int a(int i) {
        int i2 = this.d + i;
        i iVar = this.g;
        if (iVar == null || this.j) {
            return i2;
        }
        int i3 = this.c;
        int i4 = this.b;
        if (i3 == i4) {
            return i2 + iVar.a(i2);
        }
        int i5 = this.f;
        return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
    }

    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int iA;
        byte[] bArr3;
        int i4;
        i iVar;
        int iA2;
        int i5 = this.d + i2;
        int i6 = this.c;
        int i7 = this.b;
        if (i6 != i7) {
            int i8 = this.f;
            iA = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
        } else {
            i iVar2 = this.g;
            iA = iVar2 != null ? iVar2.a(i5) : 0;
        }
        if (iA > 0 && iA != this.b && this.g != null && this.j) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.b + " when decrypting with padded cipher");
        }
        boolean z = this.j;
        int i9 = (z || this.g == null) ? i5 : i5 + iA;
        if (bArr2 == null) {
            throw new ShortBufferException("Output buffer is null");
        }
        int length = bArr2.length - i3;
        if (((!z || this.g == null) && length < i9) || (z && length < i9 - this.b)) {
            throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
        }
        int i10 = this.d;
        if (i10 == 0 && (z || this.g == null)) {
            bArr3 = bArr;
            i4 = i;
        } else {
            byte[] bArr4 = new byte[i9];
            if (i10 != 0) {
                System.arraycopy(this.f26281a, 0, bArr4, 0, i10);
            }
            if (i2 != 0) {
                System.arraycopy(bArr, i, bArr4, this.d, i2);
            }
            if (!this.j && (iVar = this.g) != null) {
                iVar.a(bArr4, i5, iA);
            }
            bArr3 = bArr4;
            i4 = 0;
        }
        if (this.j) {
            if (length < i9) {
                this.h.b();
            }
            byte[] bArr5 = new byte[i5];
            iA2 = a(bArr3, i4, bArr5, 0, i5);
            i iVar3 = this.g;
            if (iVar3 != null && (iA2 = iVar3.b(bArr5, 0, iA2)) < 0) {
                throw new BadPaddingException("Given final block not properly padded");
            }
            if (bArr2.length - i3 < iA2) {
                this.h.c();
                throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + iA2 + " bytes needed");
            }
            for (int i11 = 0; i11 < iA2; i11++) {
                bArr2[i3 + i11] = bArr5[i11];
            }
        } else {
            iA2 = a(bArr3, i4, bArr2, i3, i9);
        }
        this.d = 0;
        this.f = this.b;
        if (this.i != 0) {
            this.h.a();
        }
        return iA2;
    }

    public void a(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z = i == 2 || i == 4;
        this.j = z;
        if (this.i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f26279a;
            }
            bArr2 = new byte[this.b];
            secureRandom.nextBytes(bArr2);
        }
        this.d = 0;
        this.f = this.b;
        this.h.a(this.j, "", bArr, bArr2);
    }

    public byte[] a(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        try {
            int iA = a(i2);
            byte[] bArr2 = new byte[iA];
            int iA2 = a(bArr, i, i2, bArr2, 0);
            if (iA2 >= iA) {
                return bArr2;
            }
            byte[] bArr3 = new byte[iA2];
            if (iA2 != 0) {
                try {
                    System.arraycopy(bArr2, 0, bArr3, 0, iA2);
                } catch (ShortBufferException unused) {
                }
            }
            return bArr3;
        } catch (ShortBufferException unused2) {
            return null;
        }
    }
}
