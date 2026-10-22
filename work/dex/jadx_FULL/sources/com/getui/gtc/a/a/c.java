package com.getui.gtc.a.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f30244a = true;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f30245a;
        public int b;
    }

    public static class b extends a {
        private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e;
        private int f;
        private final int[] g;

        public b(byte[] bArr) {
            this.f30245a = bArr;
            this.g = c;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARN: Code duplicated, block: B:48:0x00cc  */
        public final boolean a(byte[] bArr, int i) {
            int i2 = this.e;
            if (i2 == 6) {
                return false;
            }
            int i3 = i + 0;
            int i4 = this.f;
            byte[] bArr2 = this.f30245a;
            int[] iArr = this.g;
            int i5 = 0;
            int i6 = 0;
            while (i5 < i3) {
                if (i2 == 0) {
                    while (true) {
                        int i7 = i5 + 4;
                        if (i7 > i3 || (i4 = (iArr[bArr[i5] & 255] << 18) | (iArr[bArr[i5 + 1] & 255] << 12) | (iArr[bArr[i5 + 2] & 255] << 6) | iArr[bArr[i5 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i4;
                        bArr2[i6 + 1] = (byte) (i4 >> 8);
                        bArr2[i6] = (byte) (i4 >> 16);
                        i6 += 3;
                        i5 = i7;
                    }
                    if (i5 >= i3) {
                        break;
                    }
                }
                int i8 = i5 + 1;
                int i9 = iArr[bArr[i5] & 255];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 == 5 && i9 != -1) {
                                        this.e = 6;
                                        return false;
                                    }
                                } else if (i9 == -2) {
                                    i2++;
                                } else if (i9 != -1) {
                                    this.e = 6;
                                    return false;
                                }
                            } else if (i9 >= 0) {
                                i4 = (i4 << 6) | i9;
                                bArr2[i6 + 2] = (byte) i4;
                                bArr2[i6 + 1] = (byte) (i4 >> 8);
                                bArr2[i6] = (byte) (i4 >> 16);
                                i6 += 3;
                                i2 = 0;
                            } else if (i9 == -2) {
                                bArr2[i6 + 1] = (byte) (i4 >> 2);
                                bArr2[i6] = (byte) (i4 >> 10);
                                i6 += 2;
                                i2 = 5;
                            } else if (i9 != -1) {
                                this.e = 6;
                                return false;
                            }
                        } else if (i9 >= 0) {
                            i4 = (i4 << 6) | i9;
                            i2++;
                        } else if (i9 == -2) {
                            bArr2[i6] = (byte) (i4 >> 4);
                            i6++;
                            i2 = 4;
                        } else if (i9 != -1) {
                            this.e = 6;
                            return false;
                        }
                    } else if (i9 >= 0) {
                        i4 = (i4 << 6) | i9;
                        i2++;
                    } else if (i9 != -1) {
                        this.e = 6;
                        return false;
                    }
                } else if (i9 >= 0) {
                    i2++;
                    i4 = i9;
                } else if (i9 != -1) {
                    this.e = 6;
                    return false;
                }
                i5 = i8;
            }
            if (i2 == 1) {
                this.e = 6;
                return false;
            }
            if (i2 == 2) {
                bArr2[i6] = (byte) (i4 >> 4);
                i6++;
            } else if (i2 == 3) {
                int i10 = i6 + 1;
                bArr2[i6] = (byte) (i4 >> 10);
                i6 = i10 + 1;
                bArr2[i10] = (byte) (i4 >> 2);
            } else if (i2 == 4) {
                this.e = 6;
                return false;
            }
            this.e = i2;
            this.b = i6;
            return true;
        }
    }

    private c() {
    }

    public static String a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < 3 && i < bArr.length) {
                i4 |= (bArr[i] & 255) << (16 - (i3 << 3));
                i3++;
                i++;
            }
            if (i2 == 102400) {
                sb.append("\r\n");
                i2 = 0;
            }
            char cCharAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i4 << 8) >>> 26);
            char cCharAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i4 << 14) >>> 26);
            char cCharAt3 = com.alipay.sdk.m.p.a.h;
            char cCharAt4 = i3 < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i4 << 20) >>> 26);
            if (i3 >= 3) {
                cCharAt3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i4 << 26) >>> 26);
            }
            sb.append(cCharAt);
            sb.append(cCharAt2);
            sb.append(cCharAt4);
            sb.append(cCharAt3);
            i2 += 4;
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        return b(bytes, bytes.length);
    }

    public static byte[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    private static byte[] b(byte[] bArr, int i) {
        b bVar = new b(new byte[(i * 3) / 4]);
        if (!bVar.a(bArr, i)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i2 = bVar.b;
        byte[] bArr2 = bVar.f30245a;
        if (i2 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }
}
