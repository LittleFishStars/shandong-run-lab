package cj.mobile.wm;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class dexm {
    public static final int dexa = 0;
    public static final int dexb = 1;
    public static final int dexc = 2;
    public static final int dexd = 4;
    public static final int dexe = 8;

    public static abstract class dexb {
        public byte[] dexa;
        public int dexb;

        public abstract int dexa(int i);

        public abstract boolean dexa(byte[] bArr, int i, int i2, boolean z);
    }

    public static class dexc extends dexb {
        public static final int[] dexf = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] dexg = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int dexh = -1;
        public static final int dexi = -2;
        public int dexc;
        public int dexd;
        public final int[] dexe;

        @Override // cj.mobile.wm.dexm.dexb
        public int dexa(int i) {
            return ((i * 3) / 4) + 10;
        }

        public dexc(int i, byte[] bArr) {
            this.dexa = bArr;
            this.dexe = (i & 8) == 0 ? dexf : dexg;
            this.dexc = 0;
            this.dexd = 0;
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00d4  */
        @Override // cj.mobile.wm.dexm.dexb
        public boolean dexa(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.dexc;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.dexd;
            byte[] bArr2 = this.dexa;
            int[] iArr = this.dexe;
            int i6 = 0;
            int i7 = i5;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i7 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i7;
                        bArr2[i6 + 1] = (byte) (i7 >> 8);
                        bArr2[i6] = (byte) (i7 >> 16);
                        i6 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 != 2) {
                            if (i8 != 3) {
                                if (i8 != 4) {
                                    if (i8 == 5 && i12 != -1) {
                                        this.dexc = 6;
                                        return false;
                                    }
                                } else if (i12 == -2) {
                                    i8++;
                                } else if (i12 != -1) {
                                    this.dexc = 6;
                                    return false;
                                }
                            } else if (i12 >= 0) {
                                int i13 = i12 | (i7 << 6);
                                bArr2[i6 + 2] = (byte) i13;
                                bArr2[i6 + 1] = (byte) (i13 >> 8);
                                bArr2[i6] = (byte) (i13 >> 16);
                                i6 += 3;
                                i7 = i13;
                                i8 = 0;
                            } else if (i12 == -2) {
                                bArr2[i6 + 1] = (byte) (i7 >> 2);
                                bArr2[i6] = (byte) (i7 >> 10);
                                i6 += 2;
                                i8 = 5;
                            } else if (i12 != -1) {
                                this.dexc = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            i12 |= i7 << 6;
                            i8++;
                            i7 = i12;
                        } else if (i12 == -2) {
                            bArr2[i6] = (byte) (i7 >> 4);
                            i6++;
                            i8 = 4;
                        } else if (i12 != -1) {
                            this.dexc = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i12 |= i7 << 6;
                        i8++;
                        i7 = i12;
                    } else if (i12 != -1) {
                        this.dexc = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i8++;
                    i7 = i12;
                } else if (i12 != -1) {
                    this.dexc = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.dexc = i8;
                this.dexd = i7;
                this.dexb = i6;
                return true;
            }
            if (i8 == 1) {
                this.dexc = 6;
                return false;
            }
            if (i8 == 2) {
                bArr2[i6] = (byte) (i7 >> 4);
                i6++;
            } else if (i8 == 3) {
                int i14 = i6 + 1;
                bArr2[i6] = (byte) (i7 >> 10);
                i6 = i14 + 1;
                bArr2[i14] = (byte) (i7 >> 2);
            } else if (i8 == 4) {
                this.dexc = 6;
                return false;
            }
            this.dexc = i8;
            this.dexb = i6;
            return true;
        }
    }

    public static class dexd extends dexb {
        public static final int dexj = 19;
        public static final byte[] dexk = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.l, 47};
        public static final byte[] dexl = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.n, 95};
        public final byte[] dexc;
        public int dexd;
        public int dexe;
        public final boolean dexf;
        public final boolean dexg;
        public final boolean dexh;
        public final byte[] dexi;

        @Override // cj.mobile.wm.dexm.dexb
        public int dexa(int i) {
            return ((i * 8) / 5) + 10;
        }

        public dexd(int i, byte[] bArr) {
            this.dexa = bArr;
            this.dexf = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.dexg = z;
            this.dexh = (i & 4) != 0;
            this.dexi = (i & 8) == 0 ? dexk : dexl;
            this.dexc = new byte[2];
            this.dexd = 0;
            this.dexe = z ? 19 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0052  */
        /* JADX WARN: Code duplicated, block: B:28:0x0096  */
        /* JADX WARN: Code duplicated, block: B:32:0x00da  */
        /* JADX WARN: Code duplicated, block: B:33:0x00df A[EDGE_INSN: B:33:0x00df->B:23:0x008c BREAK  A[LOOP:0: B:26:0x0092->B:34:0x00e6]] */
        /* JADX WARN: Code duplicated, block: B:34:0x00e6 A[LOOP:0: B:26:0x0092->B:34:0x00e6, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:90:0x00d6 A[SYNTHETIC] */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // cj.mobile.wm.dexm.dexb
        public boolean dexa(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 479
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dexm.dexd.dexa(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] dexa(String str, int i) {
        return dexa(str.getBytes(), i);
    }

    public static byte[] dexb(String str, int i) {
        return dexb(str.getBytes(), i);
    }

    public static byte[] dexa(byte[] bArr, int i) {
        return dexa(bArr, 0, bArr.length, i);
    }

    public static byte[] dexb(byte[] bArr, int i) {
        return dexb(bArr, 0, bArr.length, i);
    }

    public static byte[] dexa(byte[] bArr, int i, int i2, int i3) {
        dexc dexcVar = new dexc(i3, new byte[(i2 * 3) / 4]);
        if (dexcVar.dexa(bArr, i, i2, true)) {
            int i4 = dexcVar.dexb;
            byte[] bArr2 = dexcVar.dexa;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] dexb(byte[] bArr, int i, int i2, int i3) {
        dexd dexdVar = new dexd(i3, null);
        int i4 = (i2 / 3) * 4;
        if (dexdVar.dexf) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            int i5 = i2 % 3;
            if (i5 != 0) {
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            }
        }
        if (dexdVar.dexg && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (dexdVar.dexh ? 2 : 1);
        }
        dexdVar.dexa = new byte[i4];
        dexdVar.dexa(bArr, i, i2, true);
        return dexdVar.dexa;
    }
}
