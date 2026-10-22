package com.igexin.push.core.i.a;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n implements d {
    private static final String f = "n";
    private static final int g = 4096;
    private static final int h = -1;
    private static final int i = -1;
    private static final int j = 4;
    private static final int k = 255;
    private static final int l = 0;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private int E;
    private Boolean F;
    private Bitmap.Config G;
    private int[] m;
    private final int[] n;
    private final d.a o;
    private ByteBuffer p;
    private byte[] q;
    private j r;
    private short[] s;
    private byte[] t;
    private byte[] u;
    private byte[] v;
    private int[] w;
    private int x;
    private i y;
    private Bitmap z;

    private n(d.a aVar) {
        this.n = new int[256];
        this.G = Bitmap.Config.ARGB_8888;
        this.o = aVar;
        this.y = new i();
    }

    private n(d.a aVar, i iVar, ByteBuffer byteBuffer) {
        this(aVar, iVar, byteBuffer, 1);
    }

    public n(d.a aVar, i iVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(iVar, byteBuffer, i2);
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.C + i2; i10++) {
            byte[] bArr = this.v;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.m[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.C + i12; i13++) {
            byte[] bArr2 = this.v;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.m[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x0264  */
    /* JADX WARN: Code duplicated, block: B:26:0x0043  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v32, types: [short] */
    /* JADX WARN: Type inference failed for: r5v34 */
    private Bitmap a(g gVar, g gVar2) {
        int i2;
        byte b;
        Boolean bool;
        boolean zBooleanValue;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        short s;
        int i11;
        Bitmap bitmap;
        int i12;
        int[] iArr = this.w;
        byte b2 = 0;
        if (gVar2 == null) {
            Bitmap bitmap2 = this.z;
            if (bitmap2 != null) {
                this.o.a(bitmap2);
            }
            this.z = null;
            Arrays.fill(iArr, 0);
        }
        if (gVar2 != null && gVar2.k == 3 && this.z == null) {
            Arrays.fill(iArr, 0);
        }
        if (gVar2 != null && (i11 = gVar2.k) > 0) {
            if (i11 == 2) {
                if (gVar.j) {
                    i12 = 0;
                } else {
                    i iVar = this.y;
                    i12 = iVar.n;
                    if (gVar.o != null && iVar.l == gVar.l) {
                        i12 = 0;
                    }
                }
                int i13 = gVar2.h;
                int i14 = this.C;
                int i15 = i13 / i14;
                int i16 = gVar2.f / i14;
                int i17 = gVar2.g / i14;
                int i18 = gVar2.e / i14;
                int i19 = this.E;
                int i20 = (i16 * i19) + i18;
                int i21 = (i15 * i19) + i20;
                while (i20 < i21) {
                    int i22 = i20 + i17;
                    for (int i23 = i20; i23 < i22; i23++) {
                        iArr[i23] = i12;
                    }
                    i20 += this.E;
                }
            } else if (i11 == 3 && (bitmap = this.z) != null) {
                int i24 = this.E;
                bitmap.getPixels(iArr, 0, i24, 0, 0, i24, this.D);
            }
        }
        if (gVar != null) {
            this.p.position(gVar.n);
        }
        if (gVar == null) {
            i iVar2 = this.y;
            i2 = iVar2.h * iVar2.i;
        } else {
            i2 = gVar.h * gVar.g;
        }
        byte[] bArr = this.v;
        if (bArr == null || bArr.length < i2) {
            this.v = this.o.a(i2);
        }
        byte[] bArr2 = this.v;
        if (this.s == null) {
            this.s = new short[4096];
        }
        short[] sArr = this.s;
        if (this.t == null) {
            this.t = new byte[4096];
        }
        byte[] bArr3 = this.t;
        if (this.u == null) {
            this.u = new byte[4097];
        }
        byte[] bArr4 = this.u;
        int iQ = q();
        int i25 = 1 << iQ;
        int i26 = i25 + 1;
        int i27 = i25 + 2;
        int i28 = iQ + 1;
        int i29 = (1 << i28) - 1;
        for (int i30 = 0; i30 < i25; i30++) {
            sArr[i30] = 0;
            bArr3[i30] = (byte) i30;
        }
        byte[] bArr5 = this.q;
        int i31 = i28;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = i27;
        int i41 = i29;
        int i42 = -1;
        while (true) {
            if (i32 >= i2) {
                b = b2;
                break;
            }
            if (i33 == 0) {
                int iQ2 = q();
                if (iQ2 > 0) {
                    ByteBuffer byteBuffer = this.p;
                    byteBuffer.get(this.q, 0, Math.min(iQ2, byteBuffer.remaining()));
                }
                if (iQ2 <= 0) {
                    this.B = 3;
                    b = 0;
                    break;
                }
                i33 = iQ2;
                i35 = 0;
            } else {
                i28 = i28;
                i32 = i32;
            }
            i34 += (bArr5[i35] & 255) << i36;
            i35++;
            i33--;
            i42 = i42;
            int i43 = i36 + 8;
            i40 = i40;
            i31 = i31;
            i32 = i32;
            bArr5 = bArr5;
            i38 = i38;
            while (true) {
                if (i43 < i31) {
                    i36 = i43;
                    b2 = 0;
                    break;
                }
                iArr = iArr;
                int i44 = i34 & i41;
                i34 >>= i31;
                i43 -= i31;
                if (i44 != i25) {
                    if (i44 == i26) {
                        iArr = iArr;
                        i36 = i43;
                        b2 = 0;
                        break;
                    }
                    if (i42 == -1) {
                        bArr2[i37] = bArr3[i44];
                        i37++;
                        i32++;
                        i38 = i44;
                        i42 = i38;
                        i43 = i43;
                    } else {
                        if (i44 >= i40) {
                            bArr4[i39] = (byte) i38;
                            i39++;
                            s = i42;
                        } else {
                            s = i44;
                        }
                        while (s >= i25) {
                            bArr4[i39] = bArr3[s];
                            i39++;
                            s = sArr[s];
                        }
                        int i45 = bArr3[s] & 255;
                        byte b3 = (byte) i45;
                        bArr2[i37] = b3;
                        while (true) {
                            i37++;
                            i32++;
                            if (i39 <= 0) {
                                break;
                            }
                            i39--;
                            bArr2[i37] = bArr4[i39];
                        }
                        if (i40 < 4096) {
                            sArr[i40] = (short) i42;
                            bArr3[i40] = b3;
                            i40++;
                            if ((i40 & i41) == 0 && i40 < 4096) {
                                i31++;
                                i41 += i40;
                            }
                        }
                        i42 = i44;
                        i43 = i43;
                        i38 = i45;
                    }
                } else {
                    i40 = i27;
                    i41 = i29;
                    i31 = i28;
                    i42 = -1;
                }
            }
        }
        Arrays.fill(bArr2, i37, i2, b);
        if (gVar.i || this.C != 1) {
            int[] iArr2 = this.w;
            int i46 = gVar.h;
            int i47 = this.C;
            int i48 = i46 / i47;
            int i49 = gVar.f / i47;
            int i50 = gVar.g / i47;
            int i51 = gVar.e / i47;
            boolean z = this.x == 0;
            int i52 = this.E;
            int i53 = this.D;
            byte[] bArr6 = this.v;
            int[] iArr3 = this.m;
            Boolean bool2 = this.F;
            int i54 = 8;
            int i55 = 0;
            int i56 = 0;
            int i57 = 1;
            while (true) {
                bool = bool2;
                if (i55 >= i48) {
                    break;
                }
                if (gVar.i) {
                    if (i56 >= i48) {
                        int i58 = i57 + 1;
                        i3 = i48;
                        if (i58 == 2) {
                            i56 = 4;
                            i57 = i58;
                        } else if (i58 != 3) {
                            i57 = i58;
                            if (i58 == 4) {
                                i56 = 1;
                                i54 = 2;
                            }
                        } else {
                            i54 = 4;
                            i57 = i58;
                            i56 = 2;
                        }
                    } else {
                        i3 = i48;
                    }
                    i4 = i56 + i54;
                } else {
                    i3 = i48;
                    i4 = i56;
                    i56 = i55;
                }
                int i59 = i56 + i49;
                boolean z2 = i47 == 1;
                if (i59 < i53) {
                    int i60 = i59 * i52;
                    int i61 = i60 + i51;
                    int i62 = i61 + i50;
                    int i63 = i60 + i52;
                    if (i63 < i62) {
                        i62 = i63;
                    }
                    int i64 = i55 * i47 * gVar.g;
                    if (z2) {
                        bool2 = bool;
                        int i65 = i61;
                        while (true) {
                            i5 = i50;
                            if (i65 >= i62) {
                                break;
                            }
                            int i66 = iArr3[bArr6[i64] & 255];
                            if (i66 != 0) {
                                iArr2[i65] = i66;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i64 += i47;
                            i65++;
                            i50 = i5;
                        }
                    } else {
                        i5 = i50;
                        int i67 = ((i62 - i61) * i47) + i64;
                        bool2 = bool;
                        int i68 = i61;
                        while (i68 < i62) {
                            int i69 = i62;
                            int i70 = gVar.g;
                            int i71 = i51;
                            int i72 = i52;
                            int i73 = i64;
                            int i74 = 0;
                            int i75 = 0;
                            int i76 = 0;
                            int i77 = 0;
                            int i78 = 0;
                            while (true) {
                                if (i73 >= this.C + i64) {
                                    i9 = i53;
                                    break;
                                }
                                byte[] bArr7 = this.v;
                                i9 = i53;
                                if (i73 >= bArr7.length || i73 >= i67) {
                                    break;
                                }
                                int i79 = this.m[bArr7[i73] & 255];
                                if (i79 != 0) {
                                    i74 += (i79 >> 24) & 255;
                                    i75 += (i79 >> 16) & 255;
                                    i76 += (i79 >> 8) & 255;
                                    i77 += i79 & 255;
                                    i78++;
                                }
                                i73++;
                                i53 = i9;
                            }
                            int i80 = i70 + i64;
                            for (int i81 = i80; i81 < this.C + i80; i81++) {
                                byte[] bArr8 = this.v;
                                if (i81 >= bArr8.length || i81 >= i67) {
                                    break;
                                }
                                int i82 = this.m[bArr8[i81] & 255];
                                if (i82 != 0) {
                                    i74 += (i82 >> 24) & 255;
                                    i75 += (i82 >> 16) & 255;
                                    i76 += (i82 >> 8) & 255;
                                    i77 += i82 & 255;
                                    i78++;
                                }
                            }
                            int i83 = i78 == 0 ? 0 : ((i74 / i78) << 24) | ((i75 / i78) << 16) | ((i76 / i78) << 8) | (i77 / i78);
                            if (i83 != 0) {
                                iArr2[i68] = i83;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i64 += i47;
                            i68++;
                            i62 = i69;
                            i51 = i71;
                            i52 = i72;
                            i53 = i9;
                        }
                    }
                    i6 = i51;
                    i7 = i52;
                    i8 = i53;
                } else {
                    i5 = i50;
                    i6 = i51;
                    i7 = i52;
                    i8 = i53;
                    bool2 = bool;
                }
                i55++;
                i48 = i3;
                i56 = i4;
                i49 = i49;
                i50 = i5;
                i51 = i6;
                i52 = i7;
                i53 = i8;
            }
            if (this.F == null) {
                if (bool == null) {
                    zBooleanValue = false;
                } else {
                    zBooleanValue = bool.booleanValue();
                }
                this.F = Boolean.valueOf(zBooleanValue);
            }
        } else {
            int[] iArr4 = this.w;
            int i84 = gVar.h;
            int i85 = gVar.f;
            int i86 = gVar.g;
            int i87 = gVar.e;
            byte b4 = this.x == 0 ? (byte) 1 : b;
            int i88 = this.E;
            byte[] bArr9 = this.v;
            int[] iArr5 = this.m;
            byte b5 = -1;
            for (int i89 = b; i89 < i84; i89++) {
                int i90 = (i89 + i85) * i88;
                int i91 = i90 + i87;
                int i92 = i91 + i86;
                int i93 = i90 + i88;
                if (i93 < i92) {
                    i92 = i93;
                }
                int i94 = gVar.g * i89;
                while (true) {
                    int i95 = i84;
                    if (i91 < i92) {
                        byte b6 = bArr9[i94];
                        int i96 = i85;
                        int i97 = b6 & 255;
                        if (i97 != b5) {
                            int i98 = iArr5[i97];
                            if (i98 != 0) {
                                iArr4[i91] = i98;
                            } else {
                                b5 = b6;
                            }
                        }
                        i94++;
                        i91++;
                        i84 = i95;
                        i85 = i96;
                    }
                }
            }
            Boolean bool3 = this.F;
            if ((bool3 == null || !bool3.booleanValue()) && (this.F != null || b4 == 0 || b5 == -1)) {
                zBooleanValue = false;
            } else {
                zBooleanValue = true;
            }
            this.F = Boolean.valueOf(zBooleanValue);
        }
        if (this.A && ((i10 = gVar.k) == 0 || i10 == 1)) {
            if (this.z == null) {
                this.z = s();
            }
            Bitmap bitmap3 = this.z;
            int i99 = this.E;
            bitmap3.setPixels(iArr, 0, i99, 0, 0, i99, this.D);
        }
        Bitmap bitmapS = s();
        int i100 = this.E;
        bitmapS.setPixels(iArr, 0, i100, 0, 0, i100, this.D);
        return bitmapS;
    }

    private void a(g gVar) {
        g gVar2 = gVar;
        int[] iArr = this.w;
        int i2 = gVar2.h;
        int i3 = gVar2.f;
        int i4 = gVar2.g;
        int i5 = gVar2.e;
        boolean z = this.x == 0;
        int i6 = this.E;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gVar2.g * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b2 = bArr[i12];
                int i14 = i2;
                int i15 = b2 & 255;
                if (i15 != b) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b = b2;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            gVar2 = gVar;
        }
        Boolean bool = this.F;
        this.F = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.F == null && z && b != -1));
    }

    private void b(g gVar) {
        Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        g gVar2 = gVar;
        int[] iArr = this.w;
        int i8 = gVar2.h;
        int i9 = this.C;
        int i10 = i8 / i9;
        int i11 = gVar2.f / i9;
        int i12 = gVar2.g / i9;
        int i13 = gVar2.e / i9;
        boolean z = this.x == 0;
        int i14 = this.E;
        int i15 = this.D;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        Boolean bool2 = this.F;
        int i16 = 8;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        while (true) {
            bool = bool2;
            if (i18 >= i10) {
                break;
            }
            if (gVar2.i) {
                if (i17 >= i10) {
                    int i20 = i19 + 1;
                    i2 = i10;
                    if (i20 == 2) {
                        i17 = 4;
                        i19 = i20;
                    } else if (i20 != 3) {
                        i19 = i20;
                        if (i20 == 4) {
                            i17 = 1;
                            i16 = 2;
                        }
                    } else {
                        i16 = 4;
                        i19 = i20;
                        i17 = 2;
                    }
                } else {
                    i2 = i10;
                }
                i3 = i17 + i16;
            } else {
                i2 = i10;
                i3 = i17;
                i17 = i18;
            }
            int i21 = i17 + i11;
            boolean z2 = i9 == 1;
            if (i21 < i15) {
                int i22 = i21 * i14;
                int i23 = i22 + i13;
                int i24 = i23 + i12;
                int i25 = i22 + i14;
                if (i25 < i24) {
                    i24 = i25;
                }
                i4 = i3;
                int i26 = i18 * i9 * gVar2.g;
                if (z2) {
                    int i27 = i23;
                    while (true) {
                        i5 = i11;
                        if (i27 >= i24) {
                            break;
                        }
                        int i28 = iArr2[bArr[i26] & 255];
                        if (i28 != 0) {
                            iArr[i27] = i28;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i26 += i9;
                        i27++;
                        i11 = i5;
                    }
                } else {
                    i5 = i11;
                    int i29 = ((i24 - i23) * i9) + i26;
                    int i30 = i23;
                    while (true) {
                        i6 = i12;
                        if (i30 < i24) {
                            int i31 = gVar2.g;
                            int i32 = i13;
                            int i33 = i26;
                            int i34 = 0;
                            int i35 = 0;
                            int i36 = 0;
                            int i37 = 0;
                            int i38 = 0;
                            while (true) {
                                if (i33 >= this.C + i26) {
                                    i7 = i14;
                                    break;
                                }
                                byte[] bArr2 = this.v;
                                i7 = i14;
                                if (i33 >= bArr2.length || i33 >= i29) {
                                    break;
                                }
                                int i39 = this.m[bArr2[i33] & 255];
                                if (i39 != 0) {
                                    i34 += (i39 >> 24) & 255;
                                    i35 += (i39 >> 16) & 255;
                                    i36 += (i39 >> 8) & 255;
                                    i37 += i39 & 255;
                                    i38++;
                                }
                                i33++;
                                i14 = i7;
                            }
                            int i40 = i31 + i26;
                            for (int i41 = i40; i41 < this.C + i40; i41++) {
                                byte[] bArr3 = this.v;
                                if (i41 >= bArr3.length || i41 >= i29) {
                                    break;
                                }
                                int i42 = this.m[bArr3[i41] & 255];
                                if (i42 != 0) {
                                    i34 += (i42 >> 24) & 255;
                                    i35 += (i42 >> 16) & 255;
                                    i36 += (i42 >> 8) & 255;
                                    i37 += i42 & 255;
                                    i38++;
                                }
                            }
                            int i43 = i38 == 0 ? 0 : ((i34 / i38) << 24) | ((i35 / i38) << 16) | ((i36 / i38) << 8) | (i37 / i38);
                            if (i43 != 0) {
                                iArr[i30] = i43;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i26 += i9;
                            i30++;
                            gVar2 = gVar;
                            i12 = i6;
                            i13 = i32;
                            i14 = i7;
                        }
                    }
                }
                bool2 = bool;
                i18++;
                gVar2 = gVar;
                i11 = i5;
                i10 = i2;
                i12 = i6;
                i17 = i4;
                i13 = i13;
                i14 = i14;
            } else {
                i4 = i3;
                i5 = i11;
            }
            i6 = i12;
            bool2 = bool;
            i18++;
            gVar2 = gVar;
            i11 = i5;
            i10 = i2;
            i12 = i6;
            i17 = i4;
            i13 = i13;
            i14 = i14;
        }
        if (this.F == null) {
            this.F = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [short] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private void c(g gVar) {
        int i2;
        int i3;
        byte b;
        short s;
        n nVar = this;
        if (gVar != null) {
            nVar.p.position(gVar.n);
        }
        if (gVar == null) {
            i iVar = nVar.y;
            i2 = iVar.h;
            i3 = iVar.i;
        } else {
            i2 = gVar.g;
            i3 = gVar.h;
        }
        int i4 = i2 * i3;
        byte[] bArr = nVar.v;
        if (bArr == null || bArr.length < i4) {
            nVar.v = nVar.o.a(i4);
        }
        byte[] bArr2 = nVar.v;
        if (nVar.s == null) {
            nVar.s = new short[4096];
        }
        short[] sArr = nVar.s;
        if (nVar.t == null) {
            nVar.t = new byte[4096];
        }
        byte[] bArr3 = nVar.t;
        if (nVar.u == null) {
            nVar.u = new byte[4097];
        }
        byte[] bArr4 = nVar.u;
        int iQ = q();
        int i5 = 1 << iQ;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iQ + 1;
        int i9 = (1 << i8) - 1;
        byte b2 = 0;
        for (int i10 = 0; i10 < i5; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = nVar.q;
        int i11 = i8;
        int i12 = i7;
        int i13 = i9;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (i14 < i4) {
            if (i15 == 0) {
                int iQ2 = q();
                if (iQ2 > 0) {
                    ByteBuffer byteBuffer = nVar.p;
                    byteBuffer.get(nVar.q, 0, Math.min(iQ2, byteBuffer.remaining()));
                }
                if (iQ2 <= 0) {
                    nVar.B = 3;
                    b = 0;
                    Arrays.fill(bArr2, i19, i4, b);
                }
                i15 = iQ2;
                i16 = 0;
            } else {
                i14 = i14;
                i8 = i8;
            }
            i18 += (bArr5[i16] & 255) << i17;
            i16++;
            i15--;
            int i23 = i17 + 8;
            int i24 = i12;
            int i25 = i11;
            int i26 = i22;
            int i27 = i20;
            while (i23 >= i25) {
                int i28 = i18 & i13;
                i18 >>= i25;
                i23 -= i25;
                if (i28 != i5) {
                    if (i28 == i6) {
                        break;
                    }
                    if (i26 == -1) {
                        bArr2[i19] = bArr3[i28];
                        i19++;
                        i14++;
                        i26 = i28;
                        i27 = i26;
                    } else {
                        if (i28 >= i24) {
                            bArr4[i21] = (byte) i27;
                            i21++;
                            s = i26;
                        } else {
                            s = i28;
                        }
                        while (s >= i5) {
                            bArr4[i21] = bArr3[s];
                            i21++;
                            s = sArr[s];
                        }
                        int i29 = bArr3[s] & 255;
                        byte b3 = (byte) i29;
                        bArr2[i19] = b3;
                        while (true) {
                            i19++;
                            i14++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr2[i19] = bArr4[i21];
                        }
                        if (i24 < 4096) {
                            sArr[i24] = (short) i26;
                            bArr3[i24] = b3;
                            i24++;
                            if ((i24 & i13) == 0 && i24 < 4096) {
                                i25++;
                                i13 += i24;
                            }
                        }
                        i26 = i28;
                        i27 = i29;
                    }
                } else {
                    i24 = i7;
                    i13 = i9;
                    i25 = i8;
                    i26 = -1;
                }
            }
            nVar = this;
            i22 = i26;
            i17 = i23;
            i12 = i24;
            i11 = i25;
            i14 = i14;
            i8 = i8;
            i20 = i27;
            b2 = 0;
        }
        b = b2;
        Arrays.fill(bArr2, i19, i4, b);
    }

    private j p() {
        if (this.r == null) {
            this.r = new j();
        }
        return this.r;
    }

    private int q() {
        return this.p.get() & 255;
    }

    private int r() {
        int iQ = q();
        if (iQ <= 0) {
            return iQ;
        }
        ByteBuffer byteBuffer = this.p;
        byteBuffer.get(this.q, 0, Math.min(iQ, byteBuffer.remaining()));
        return iQ;
    }

    private Bitmap s() {
        Boolean bool = this.F;
        Bitmap bitmapA = this.o.a(this.E, this.D, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.G, this.x);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a() {
        return this.y.h;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a(int i2) {
        if (i2 >= 0) {
            i iVar = this.y;
            if (i2 < iVar.e) {
                return iVar.g.get(i2).m;
            }
        }
        return -1;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a(InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i3 = inputStream.read(bArr, 0, 16384);
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(f, "Error reading data from stream", e);
            }
        } else {
            this.B = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(f, "Error closing stream", e2);
            }
        }
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized int a(byte[] bArr) {
        if (this.r == null) {
            this.r = new j();
        }
        j jVar = this.r;
        if (bArr != null) {
            jVar.a(ByteBuffer.wrap(bArr));
        } else {
            jVar.c = null;
            jVar.d.d = 2;
        }
        i iVarB = jVar.b();
        this.y = iVarB;
        if (bArr != null) {
            a(iVarB, bArr);
        }
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.G = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(i iVar, ByteBuffer byteBuffer) {
        a(iVar, byteBuffer, 1);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(i iVar, ByteBuffer byteBuffer, int i2) {
        try {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: ".concat(String.valueOf(i2)));
            }
            int iHighestOneBit = Integer.highestOneBit(i2);
            this.B = 0;
            this.y = iVar;
            this.x = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.p = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.p.order(ByteOrder.LITTLE_ENDIAN);
            this.A = false;
            Iterator<g> it = iVar.g.iterator();
            while (it.hasNext()) {
                if (it.next().k == 3) {
                    this.A = true;
                    break;
                }
            }
            this.C = iHighestOneBit;
            int i3 = iVar.h;
            this.E = i3 / iHighestOneBit;
            int i4 = iVar.i;
            this.D = i4 / iHighestOneBit;
            this.v = this.o.a(i3 * i4);
            this.w = this.o.b(this.E * this.D);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(i iVar, byte[] bArr) {
        a(iVar, ByteBuffer.wrap(bArr));
    }

    @Override // com.igexin.push.core.i.a.d
    public final int b() {
        return this.y.i;
    }

    @Override // com.igexin.push.core.i.a.d
    public final ByteBuffer c() {
        return this.p;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int d() {
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void e() {
        this.x = (this.x + 1) % this.y.e;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int f() {
        int i2;
        i iVar = this.y;
        int i3 = iVar.e;
        if (i3 <= 0 || (i2 = this.x) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= i3) {
            return -1;
        }
        return iVar.g.get(i2).m;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int g() {
        return this.y.e;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int h() {
        return this.x;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void i() {
        this.x = -1;
    }

    @Override // com.igexin.push.core.i.a.d
    @Deprecated
    public final int j() {
        int i2 = this.y.o;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int k() {
        return this.y.o;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int l() {
        int i2 = this.y.o;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int m() {
        return this.p.limit() + this.v.length + (this.w.length * 4);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized Bitmap n() {
        if (this.y.e <= 0 || this.x < 0) {
            com.igexin.c.a.c.a.b(f, "Unable to decode frame, frameCount=" + this.y.e + ", framePointer=" + this.x);
            this.B = 1;
        }
        int i2 = this.B;
        if (i2 != 1 && i2 != 2) {
            this.B = 0;
            if (this.q == null) {
                this.q = this.o.a(255);
            }
            g gVar = this.y.g.get(this.x);
            int i3 = this.x - 1;
            g gVar2 = i3 >= 0 ? this.y.g.get(i3) : null;
            int[] iArr = gVar.o;
            if (iArr == null) {
                iArr = this.y.c;
            }
            this.m = iArr;
            if (iArr == null) {
                com.igexin.c.a.c.a.b(f, "No valid color table found for frame #" + this.x);
                this.B = 1;
                return null;
            }
            if (gVar.j) {
                System.arraycopy(iArr, 0, this.n, 0, iArr.length);
                int[] iArr2 = this.n;
                this.m = iArr2;
                iArr2[gVar.l] = 0;
                if (gVar.k == 2 && this.x == 0) {
                    this.F = Boolean.TRUE;
                }
            }
            return a(gVar, gVar2);
        }
        com.igexin.c.a.c.a.b(f, "Unable to decode frame, status=" + this.B);
        return null;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void o() {
        this.y = null;
        Bitmap bitmap = this.z;
        if (bitmap != null) {
            this.o.a(bitmap);
        }
        this.z = null;
        this.p = null;
        this.F = null;
        this.o.a();
    }
}
