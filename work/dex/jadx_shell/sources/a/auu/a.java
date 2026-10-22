package a.auu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public class a {
    private static final int[] ooo00000 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] ooo0o = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int[] oo00;
    public int oo000;
    public byte[] oo0000;
    private int oo00000;
    private int oo000000;

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrOoo0ooo0o0o000o = new a().ooo0ooo0o0o000o(str, 0);
            int length = bArrOoo0ooo0o0o000o.length;
            byte[] bArr = {78, 101, 116, 101, 97, 115, 101};
            int i = 0;
            int i2 = 0;
            while (i < length) {
                if (i2 >= 7) {
                    i2 = 0;
                }
                bArrOoo0ooo0o0o000o[i] = (byte) (bArrOoo0ooo0o0o000o[i] ^ bArr[i2]);
                i++;
                i2++;
            }
            return new String(bArrOoo0ooo0o0o000o, "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    public void ooo0oo00000oo000o(int i, byte[] bArr) {
        this.oo0000 = bArr;
        this.oo00 = (i & 8) == 0 ? ooo00000 : ooo0o;
        this.oo00000 = 0;
        this.oo000000 = 0;
    }

    public boolean ooo0ooo0o0o0(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (this.oo00000 == 6) {
            return false;
        }
        int i5 = i;
        int i6 = i2 + i;
        int i7 = this.oo00000;
        int i8 = this.oo000000;
        int i9 = 0;
        byte[] bArr2 = this.oo0000;
        int[] iArr = this.oo00;
        while (true) {
            if (i5 < i6) {
                if (i7 == 0) {
                    while (i5 + 4 <= i6 && (i8 = (iArr[bArr[i5] & 255] << 18) | (iArr[bArr[i5 + 1] & 255] << 12) | (iArr[bArr[i5 + 2] & 255] << 6) | iArr[bArr[i5 + 3] & 255]) >= 0) {
                        bArr2[i9 + 2] = (byte) i8;
                        bArr2[i9 + 1] = (byte) (i8 >> 8);
                        bArr2[i9] = (byte) (i8 >> 16);
                        i9 += 3;
                        i5 += 4;
                    }
                    if (i5 >= i6) {
                        i3 = i9;
                    }
                }
                i5++;
                int i10 = iArr[bArr[i5] & 255];
                switch (i7) {
                    case 0:
                        if (i10 >= 0) {
                            i8 = i10;
                            i7++;
                        } else if (i10 != -1) {
                            this.oo00000 = 6;
                            return false;
                        }
                        break;
                    case 1:
                        if (i10 >= 0) {
                            i8 = (i8 << 6) | i10;
                            i7++;
                        } else if (i10 != -1) {
                            this.oo00000 = 6;
                            return false;
                        }
                        break;
                    case 2:
                        if (i10 >= 0) {
                            i8 = (i8 << 6) | i10;
                            i7++;
                        } else if (i10 == -2) {
                            bArr2[i9] = (byte) (i8 >> 4);
                            i7 = 4;
                            i9++;
                        } else if (i10 != -1) {
                            this.oo00000 = 6;
                            return false;
                        }
                        break;
                    case 3:
                        if (i10 >= 0) {
                            i8 = (i8 << 6) | i10;
                            bArr2[i9 + 2] = (byte) i8;
                            bArr2[i9 + 1] = (byte) (i8 >> 8);
                            bArr2[i9] = (byte) (i8 >> 16);
                            i9 += 3;
                            i7 = 0;
                        } else if (i10 == -2) {
                            bArr2[i9 + 1] = (byte) (i8 >> 2);
                            bArr2[i9] = (byte) (i8 >> 10);
                            i9 += 2;
                            i7 = 5;
                        } else if (i10 != -1) {
                            this.oo00000 = 6;
                            return false;
                        }
                        break;
                    case 4:
                        if (i10 == -2) {
                            i7++;
                        } else if (i10 != -1) {
                            this.oo00000 = 6;
                            return false;
                        }
                        break;
                    case 5:
                        if (i10 != -1) {
                            this.oo00000 = 6;
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            } else {
                i3 = i9;
            }
        }
        if (!z) {
            this.oo00000 = i7;
            this.oo000000 = i8;
            this.oo000 = i3;
            return true;
        }
        switch (i7) {
            case 0:
                i4 = i3;
                break;
            case 1:
                this.oo00000 = 6;
                return false;
            case 2:
                i4 = i3 + 1;
                bArr2[i3] = (byte) (i8 >> 4);
                break;
            case 3:
                int i11 = i3 + 1;
                bArr2[i3] = (byte) (i8 >> 10);
                bArr2[i11] = (byte) (i8 >> 2);
                i4 = i11 + 1;
                break;
            case 4:
                this.oo00000 = 6;
                return false;
            default:
                i4 = i3;
                break;
        }
        this.oo00000 = i7;
        this.oo000 = i4;
        return true;
    }

    public byte[] ooo0ooo0o0o000o(String str, int i) {
        return ooo0ooo0o0o000o(str.getBytes(), i);
    }

    public byte[] ooo0ooo0o0o000o(byte[] bArr, int i) {
        return ooo0ooo0o0o000o(bArr, 0, bArr.length, i);
    }

    public byte[] ooo0ooo0o0o000o(byte[] bArr, int i, int i2, int i3) {
        ooo0oo00000oo000o(i3, new byte[(i2 * 3) / 4]);
        if (!ooo0ooo0o0o0(bArr, i, i2, true)) {
            throw new IllegalArgumentException("aes error");
        }
        if (this.oo000 == this.oo0000.length) {
            return this.oo0000;
        }
        byte[] bArr2 = new byte[this.oo000];
        System.arraycopy(this.oo0000, 0, bArr2, 0, this.oo000);
        return bArr2;
    }
}
