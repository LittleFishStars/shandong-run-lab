package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t0 extends zzhk {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        if (i != 0) {
            if (i2 >= i3) {
                return i;
            }
            byte b = (byte) i;
            if (b < -32) {
                if (b >= -62) {
                    i5 = i2 + 1;
                }
                return -1;
            }
            if (b < -16) {
                byte b2 = (byte) (~(i >> 8));
                if (b2 == 0) {
                    int i6 = i2 + 1;
                    byte b3 = bArr[i2];
                    if (i6 >= i3) {
                        return u0.i(b, b3);
                    }
                    i2 = i6;
                    b2 = b3;
                }
                if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                    i5 = i2 + 1;
                }
                return -1;
            }
            byte b4 = (byte) (~(i >> 8));
            if (b4 == 0) {
                int i7 = i2 + 1;
                b4 = bArr[i2];
                if (i7 >= i3) {
                    return u0.i(b, b4);
                }
                i2 = i7;
                i4 = 0;
            } else {
                i4 = i >> 16;
            }
            if (i4 == 0) {
                int i8 = i2 + 1;
                byte b5 = bArr[i2];
                if (i8 >= i3) {
                    return u0.j(b, b4, b5);
                }
                i2 = i8;
                i4 = b5;
            }
            if (b4 <= -65 && (((b << com.google.common.base.a.F) + (b4 + 112)) >> 30) == 0 && i4 <= -65) {
                i5 = i2 + 1;
            }
            return -1;
            i2 = i5;
        }
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i9 = i2 + 1;
            byte b6 = bArr[i2];
            if (b6 < 0) {
                if (b6 < -32) {
                    if (i9 >= i3) {
                        return b6;
                    }
                    if (b6 >= -62) {
                        i2 = i9 + 1;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return -1;
                }
                if (b6 >= -16) {
                    if (i9 >= i3 - 2) {
                        return u0.c(bArr, i9, i3);
                    }
                    int i10 = i9 + 1;
                    byte b7 = bArr[i9];
                    if (b7 <= -65 && (((b6 << com.google.common.base.a.F) + (b7 + 112)) >> 30) == 0) {
                        int i11 = i10 + 1;
                        if (bArr[i10] <= -65) {
                            i2 = i11 + 1;
                            if (bArr[i11] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i9 >= i3 - 1) {
                    return u0.c(bArr, i9, i3);
                }
                int i12 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 <= -65 && ((b6 != -32 || b8 >= -96) && (b6 != -19 || b8 < -96))) {
                    i2 = i12 + 1;
                    if (bArr[i12] > -65) {
                    }
                }
                return -1;
            }
            i2 = i9;
        }
        return 0;
    }
}
