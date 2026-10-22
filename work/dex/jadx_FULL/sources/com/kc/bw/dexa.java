package com.kc.bw;

import com.alibaba.ariver.resource.parser.a.e;
import com.google.android.exoplayer2.text.cea.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class dexa {
    public static final int dexa = 0;
    public static final int dexb = 1;
    public static final int dexc = 2;
    public static final int dexd = 4;
    public static final int dexe = 8;

    @Keep
    public static abstract class dexb {
        public byte[] dexa;
        public int dexb;

        public abstract int dexa(int i);

        public abstract boolean dexa(byte[] bArr, int i, int i2, boolean z);
    }

    @Keep
    public static class dexc extends dexb {
        public static final int[] dexf = $d2j$hex$5964a9ab$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffffffffffff3f0000003400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffffffffffffffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        public static final int[] dexg = $d2j$hex$5964a9ab$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffff3400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffff3f000000ffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        public static final int dexh = -1;
        public static final int dexi = -2;
        public int dexc;
        public int dexd;
        public final int[] dexe;

        private static byte[] $d2j$hex$5964a9ab$decode_B(String str) {
            int i;
            int i2;
            int i3;
            int i4;
            char[] charArray = str.toCharArray();
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                char c = charArray[i6];
                char c2 = charArray[i6 + 1];
                if (c < '0' || c > '9') {
                    if (c >= 'a' && c <= 'f') {
                        i = c - 'a';
                    } else {
                        if (c < 'A' || c > 'F') {
                            throw new RuntimeException();
                        }
                        i = c - 'A';
                    }
                    i2 = i + 10;
                } else {
                    i2 = c - '0';
                }
                if (c2 < '0' || c2 > '9') {
                    if (c2 >= 'a' && c2 <= 'f') {
                        i3 = c2 - 'a';
                    } else {
                        if (c2 < 'A' || c2 > 'F') {
                            throw new RuntimeException();
                        }
                        i3 = c2 - 'A';
                    }
                    i4 = i3 + 10;
                } else {
                    i4 = c2 - '0';
                }
                bArr[i5] = (byte) (i4 | (i2 << 4));
            }
            return bArr;
        }

        private static int[] $d2j$hex$5964a9ab$decode_I(String str) {
            byte[] bArr$d2j$hex$5964a9ab$decode_B = $d2j$hex$5964a9ab$decode_B(str);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr$d2j$hex$5964a9ab$decode_B);
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            IntBuffer intBufferAsIntBuffer = byteBufferWrap.asIntBuffer();
            int[] iArr = new int[bArr$d2j$hex$5964a9ab$decode_B.length / 4];
            intBufferAsIntBuffer.get(iArr);
            return iArr;
        }

        private static long[] $d2j$hex$5964a9ab$decode_J(String str) {
            byte[] bArr$d2j$hex$5964a9ab$decode_B = $d2j$hex$5964a9ab$decode_B(str);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr$d2j$hex$5964a9ab$decode_B);
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            LongBuffer longBufferAsLongBuffer = byteBufferWrap.asLongBuffer();
            long[] jArr = new long[bArr$d2j$hex$5964a9ab$decode_B.length / 8];
            longBufferAsLongBuffer.get(jArr);
            return jArr;
        }

        private static short[] $d2j$hex$5964a9ab$decode_S(String str) {
            byte[] bArr$d2j$hex$5964a9ab$decode_B = $d2j$hex$5964a9ab$decode_B(str);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr$d2j$hex$5964a9ab$decode_B);
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            ShortBuffer shortBufferAsShortBuffer = byteBufferWrap.asShortBuffer();
            short[] sArr = new short[bArr$d2j$hex$5964a9ab$decode_B.length / 2];
            shortBufferAsShortBuffer.get(sArr);
            return sArr;
        }

        public dexc(int i, byte[] bArr) {
            this.dexa = bArr;
            this.dexe = (i & 8) == 0 ? dexf : dexg;
            this.dexc = 0;
            this.dexd = 0;
        }

        @Override // com.kc.bw.dexa.dexb
        public int dexa(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00d1  */
        @Override // com.kc.bw.dexa.dexb
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
                int i11 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 != 2) {
                            if (i8 != 3) {
                                if (i8 != 4) {
                                    if (i8 == 5 && i11 != -1) {
                                        this.dexc = 6;
                                        return false;
                                    }
                                } else if (i11 == -2) {
                                    i8++;
                                } else if (i11 != -1) {
                                    this.dexc = 6;
                                    return false;
                                }
                            } else if (i11 >= 0) {
                                int i12 = (i7 << 6) | i11;
                                bArr2[i6 + 2] = (byte) i12;
                                bArr2[i6 + 1] = (byte) (i12 >> 8);
                                bArr2[i6] = (byte) (i12 >> 16);
                                i6 += 3;
                                i7 = i12;
                                i8 = 0;
                            } else if (i11 == -2) {
                                bArr2[i6 + 1] = (byte) (i7 >> 2);
                                bArr2[i6] = (byte) (i7 >> 10);
                                i6 += 2;
                                i8 = 5;
                            } else if (i11 != -1) {
                                this.dexc = 6;
                                return false;
                            }
                        } else if (i11 >= 0) {
                            i8++;
                            i7 = (i7 << 6) | i11;
                        } else if (i11 == -2) {
                            bArr2[i6] = (byte) (i7 >> 4);
                            i6++;
                            i8 = 4;
                        } else if (i11 != -1) {
                            this.dexc = 6;
                            return false;
                        }
                    } else if (i11 >= 0) {
                        i8++;
                        i7 = (i7 << 6) | i11;
                    } else if (i11 != -1) {
                        this.dexc = 6;
                        return false;
                    }
                } else if (i11 >= 0) {
                    i8++;
                    i7 = i11;
                } else if (i11 != -1) {
                    this.dexc = 6;
                    return false;
                }
                i9++;
            }
            if (!z) {
                this.dexc = i8;
                this.dexd = i7;
            } else {
                if (i8 == 1) {
                    this.dexc = 6;
                    return false;
                }
                if (i8 == 2) {
                    bArr2[i6] = (byte) (i7 >> 4);
                    i6++;
                } else if (i8 == 3) {
                    int i13 = i6 + 1;
                    bArr2[i6] = (byte) (i7 >> 10);
                    i6 = i13 + 1;
                    bArr2[i13] = (byte) (i7 >> 2);
                } else if (i8 == 4) {
                    this.dexc = 6;
                    return false;
                }
                this.dexc = i8;
            }
            this.dexb = i6;
            return true;
        }
    }

    @Keep
    public static class dexd extends dexb {
        public static final int dexj = 19;
        public static final byte[] dexk = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, a.l, 47};
        public static final byte[] dexl = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, a.n, 95};
        public final byte[] dexc;
        public int dexd;
        public int dexe;
        public final boolean dexf;
        public final boolean dexg;
        public final boolean dexh;
        public final byte[] dexi;

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

        @Override // com.kc.bw.dexa.dexb
        public int dexa(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0052  */
        /* JADX WARN: Code duplicated, block: B:28:0x0096  */
        /* JADX WARN: Code duplicated, block: B:32:0x00da  */
        /* JADX WARN: Code duplicated, block: B:33:0x00de A[EDGE_INSN: B:33:0x00de->B:23:0x008c BREAK  A[LOOP:0: B:26:0x0092->B:34:0x00e3]] */
        /* JADX WARN: Code duplicated, block: B:34:0x00e3 A[LOOP:0: B:26:0x0092->B:34:0x00e3, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:87:0x00d6 A[SYNTHETIC] */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // com.kc.bw.dexa.dexb
        public boolean dexa(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kc.bw.dexa.dexd.dexa(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] dexa(String str, int i) {
        return dexa(str.getBytes(), i);
    }

    public static byte[] dexa(byte[] bArr, int i) {
        return dexa(bArr, 0, bArr.length, i);
    }

    public static byte[] dexa(byte[] bArr, int i, int i2, int i3) {
        dexc dexcVar = new dexc(i3, new byte[(i2 * 3) / 4]);
        if (!dexcVar.dexa(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i4 = dexcVar.dexb;
        byte[] bArr2 = dexcVar.dexa;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    public static byte[] dexb(String str, int i) {
        return dexb(str.getBytes(), i);
    }

    public static byte[] dexb(byte[] bArr, int i) {
        return dexb(bArr, 0, bArr.length, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] dexb(byte[] bArr, int i, int i2, int i3) {
        dexd dexdVar = new dexd(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!dexdVar.dexf) {
            int i5 = i2 % 3;
            if (i5 != 0) {
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (dexdVar.dexg && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (dexdVar.dexh ? 2 : 1);
        }
        dexdVar.dexa = new byte[i4];
        dexdVar.dexa(bArr, i, i2, true);
        return dexdVar.dexa;
    }
}
