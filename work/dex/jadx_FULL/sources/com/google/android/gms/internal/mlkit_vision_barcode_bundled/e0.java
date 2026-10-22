package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.bkc;
import com.zj.adlib.kgc;
import com.zj.adlib.llc;
import com.zj.adlib.qjc;
import com.zj.adlib.qpc;
import com.zj.adlib.ric;
import com.zj.adlib.rmc;
import com.zj.adlib.zqc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e0<T> implements zzgh<T> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f5789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzdp f5790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzfc f5791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzfo f5792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzgy f5793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qpc f5794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zqc f5795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f5797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object[] f5798a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f5799b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f5800c;
    public final int d;
    public final int e;
    public static final int[] c = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f31374a = s0.l();

    public e0(int[] iArr, Object[] objArr, int i, int i2, zzfo zzfoVar, int i3, boolean z, int[] iArr2, int i4, int i5, zqc zqcVar, zzfc zzfcVar, zzgy zzgyVar, zzdp zzdpVar, qpc qpcVar) {
        this.f5797a = iArr;
        this.f5798a = objArr;
        this.f5789a = i;
        this.b = i2;
        this.e = i3;
        boolean z2 = false;
        if (zzdpVar != null && zzdpVar.g(zzfoVar)) {
            z2 = true;
        }
        this.f5796a = z2;
        this.f5799b = iArr2;
        this.f5800c = i4;
        this.d = i5;
        this.f5795a = zqcVar;
        this.f5791a = zzfcVar;
        this.f5793a = zzgyVar;
        this.f5790a = zzdpVar;
        this.f5792a = zzfoVar;
        this.f5794a = qpcVar;
    }

    public static boolean A(Object obj, int i, zzgh zzghVar) {
        return zzghVar.h(s0.k(obj, i & 1048575));
    }

    public static boolean B(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzed) {
            return ((zzed) obj).q();
        }
        return true;
    }

    public static boolean D(Object obj, long j) {
        return ((Boolean) s0.k(obj, j)).booleanValue();
    }

    public static final void E(int i, Object obj, zzhq zzhqVar) throws IOException {
        if (obj instanceof String) {
            zzhqVar.E(i, (String) obj);
        } else {
            zzhqVar.H(i, (zzdb) obj);
        }
    }

    public static o0 G(Object obj) {
        zzed zzedVar = (zzed) obj;
        o0 o0Var = zzedVar.zzc;
        if (o0Var != o0.c()) {
            return o0Var;
        }
        o0 o0VarF = o0.f();
        zzedVar.zzc = o0VarF;
        return o0VarF;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x024f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0252  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:128:0x026d  */
    public static e0 H(Class cls, zzfl zzflVar, zqc zqcVar, zzfc zzfcVar, zzgy zzgyVar, zzdp zzdpVar, qpc qpcVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        Field fieldO;
        char cCharAt9;
        int i20;
        int i21;
        int i22;
        Object obj;
        Field fieldO2;
        int i23;
        Object obj2;
        Field fieldO3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        if (!(zzflVar instanceof i0)) {
            throw null;
        }
        i0 i0Var = (i0) zzflVar;
        String strC = i0Var.c();
        int length = strC.length();
        char c2 = 55296;
        if (strC.charAt(0) >= 55296) {
            int i28 = 1;
            while (true) {
                i = i28 + 1;
                if (strC.charAt(i28) < 55296) {
                    break;
                }
                i28 = i;
            }
        } else {
            i = 1;
        }
        int i29 = i + 1;
        int iCharAt3 = strC.charAt(i);
        if (iCharAt3 >= 55296) {
            int i30 = iCharAt3 & 8191;
            int i31 = 13;
            while (true) {
                i27 = i29 + 1;
                cCharAt13 = strC.charAt(i29);
                if (cCharAt13 < 55296) {
                    break;
                }
                i30 |= (cCharAt13 & 8191) << i31;
                i31 += 13;
                i29 = i27;
            }
            iCharAt3 = i30 | (cCharAt13 << i31);
            i29 = i27;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = c;
            i5 = 0;
        } else {
            int i32 = i29 + 1;
            int iCharAt4 = strC.charAt(i29);
            if (iCharAt4 >= 55296) {
                int i33 = iCharAt4 & 8191;
                int i34 = 13;
                while (true) {
                    i14 = i32 + 1;
                    cCharAt8 = strC.charAt(i32);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt8 & 8191) << i34;
                    i34 += 13;
                    i32 = i14;
                }
                iCharAt4 = i33 | (cCharAt8 << i34);
                i32 = i14;
            }
            int i35 = i32 + 1;
            int iCharAt5 = strC.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i13 = i35 + 1;
                    cCharAt7 = strC.charAt(i35);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt7 & 8191) << i37;
                    i37 += 13;
                    i35 = i13;
                }
                iCharAt5 = i36 | (cCharAt7 << i37);
                i35 = i13;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strC.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt6 = strC.charAt(i38);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt6 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt6 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            int iCharAt7 = strC.charAt(i38);
            if (iCharAt7 >= 55296) {
                int i42 = iCharAt7 & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt5 = strC.charAt(i41);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt5 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt7 = i42 | (cCharAt5 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            iCharAt = strC.charAt(i41);
            if (iCharAt >= 55296) {
                int i45 = iCharAt & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt4 = strC.charAt(i44);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt4 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt = i45 | (cCharAt4 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            iCharAt2 = strC.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt3 = strC.charAt(i47);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt3 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt2 = i48 | (cCharAt3 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strC.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt2 = strC.charAt(i50);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt2 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt8 = i51 | (cCharAt2 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strC.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt = strC.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt9 = i54 | (cCharAt << i55);
                i53 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i29 = i53;
        }
        Unsafe unsafe = f31374a;
        Object[] objArrD = i0Var.d();
        Class<?> cls2 = i0Var.b().getClass();
        int i56 = i4 + iCharAt2;
        int i57 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i57];
        int i58 = 0;
        int i59 = 0;
        int i60 = i4;
        int i61 = i56;
        while (i29 < length) {
            int i62 = i29 + 1;
            int iCharAt10 = strC.charAt(i29);
            if (iCharAt10 >= c2) {
                int i63 = iCharAt10 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i26 = i64 + 1;
                    cCharAt12 = strC.charAt(i64);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i63 |= (cCharAt12 & 8191) << i65;
                    i65 += 13;
                    i64 = i26;
                }
                iCharAt10 = i63 | (cCharAt12 << i65);
                i15 = i26;
            } else {
                i15 = i62;
            }
            int i66 = i15 + 1;
            int iCharAt11 = strC.charAt(i15);
            if (iCharAt11 >= c2) {
                int i67 = iCharAt11 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i25 = i68 + 1;
                    cCharAt11 = strC.charAt(i68);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i67 |= (cCharAt11 & 8191) << i69;
                    i69 += 13;
                    i68 = i25;
                }
                iCharAt11 = i67 | (cCharAt11 << i69);
                i16 = i25;
            } else {
                i16 = i66;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i58] = i59;
                i58++;
            }
            int i70 = iCharAt11 & 255;
            if (i70 >= 51) {
                int i71 = i16 + 1;
                int iCharAt12 = strC.charAt(i16);
                char c3 = 55296;
                if (iCharAt12 >= 55296) {
                    int i72 = iCharAt12 & 8191;
                    int i73 = 13;
                    while (true) {
                        i24 = i71 + 1;
                        cCharAt10 = strC.charAt(i71);
                        if (cCharAt10 < c3) {
                            break;
                        }
                        i72 |= (cCharAt10 & 8191) << i73;
                        i73 += 13;
                        i71 = i24;
                        c3 = 55296;
                    }
                    iCharAt12 = i72 | (cCharAt10 << i73);
                    i71 = i24;
                }
                int i74 = i70 - 51;
                int i75 = i71;
                if (i74 == 9 || i74 == 17) {
                    int i76 = i59 / 3;
                    i21 = i2 + 1;
                    objArr[i76 + i76 + 1] = objArrD[i2];
                } else {
                    if (i74 == 12 && (i0Var.zzc() == 1 || (iCharAt11 & 2048) != 0)) {
                        int i77 = i59 / 3;
                        i21 = i2 + 1;
                        objArr[i77 + i77 + 1] = objArrD[i2];
                    }
                    i22 = iCharAt12 + iCharAt12;
                    obj = objArrD[i22];
                    if (obj instanceof Field) {
                        fieldO2 = (Field) obj;
                    } else {
                        fieldO2 = o(cls2, (String) obj);
                        objArrD[i22] = fieldO2;
                    }
                    int i78 = i3;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO2);
                    i23 = i22 + 1;
                    obj2 = objArrD[i23];
                    if (obj2 instanceof Field) {
                        fieldO3 = (Field) obj2;
                    } else {
                        fieldO3 = o(cls2, (String) obj2);
                        objArrD[i23] = fieldO3;
                    }
                    i17 = i78;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO3);
                    i18 = i75;
                    i19 = 0;
                    strC = strC;
                }
                i2 = i21;
                i22 = iCharAt12 + iCharAt12;
                obj = objArrD[i22];
                if (obj instanceof Field) {
                    fieldO2 = (Field) obj;
                } else {
                    fieldO2 = o(cls2, (String) obj);
                    objArrD[i22] = fieldO2;
                }
                int i79 = i3;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO2);
                i23 = i22 + 1;
                obj2 = objArrD[i23];
                if (obj2 instanceof Field) {
                    fieldO3 = (Field) obj2;
                } else {
                    fieldO3 = o(cls2, (String) obj2);
                    objArrD[i23] = fieldO3;
                }
                i17 = i79;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO3);
                i18 = i75;
                i19 = 0;
                strC = strC;
            } else {
                i17 = i3;
                int i80 = i2 + 1;
                Field fieldO4 = o(cls2, (String) objArrD[i2]);
                if (i70 == 9 || i70 == 17) {
                    i17 = i17;
                    int i81 = i59 / 3;
                    objArr[i81 + i81 + 1] = fieldO4.getType();
                } else {
                    if (i70 == 27 || i70 == 49) {
                        i17 = i17;
                        int i82 = i59 / 3;
                        i20 = i80 + 1;
                        objArr[i82 + i82 + 1] = objArrD[i80];
                    } else if (i70 == 12 || i70 == 30 || i70 == 44) {
                        i17 = i17;
                        if (i0Var.zzc() == 1 || (iCharAt11 & 2048) != 0) {
                            int i83 = i59 / 3;
                            i20 = i80 + 1;
                            objArr[i83 + i83 + 1] = objArrD[i80];
                        }
                    } else if (i70 == 50) {
                        int i84 = i60 + 1;
                        iArr[i60] = i59;
                        int i85 = i59 / 3;
                        int i86 = i80 + 1;
                        int i87 = i85 + i85;
                        objArr[i87] = objArrD[i80];
                        if ((iCharAt11 & 2048) != 0) {
                            i80 = i86 + 1;
                            objArr[i87 + 1] = objArrD[i86];
                            i60 = i84;
                        } else {
                            i60 = i84;
                            i80 = i86;
                        }
                    }
                    i80 = i20;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldO4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i70 > 17) {
                    i18 = i16;
                    i19 = 0;
                } else {
                    int i88 = i16 + 1;
                    int iCharAt13 = strC.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i89 = iCharAt13 & 8191;
                        int i90 = 13;
                        while (true) {
                            i18 = i88 + 1;
                            cCharAt9 = strC.charAt(i88);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i89 |= (cCharAt9 & 8191) << i90;
                            i90 += 13;
                            i88 = i18;
                        }
                        iCharAt13 = i89 | (cCharAt9 << i90);
                    } else {
                        i18 = i88;
                    }
                    int i91 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrD[i91];
                    if (obj3 instanceof Field) {
                        fieldO = (Field) obj3;
                    } else {
                        fieldO = o(cls2, (String) obj3);
                        objArrD[i91] = fieldO;
                    }
                    i19 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO);
                }
                if (i70 >= 18 && i70 <= 49) {
                    iArr[i61] = iObjectFieldOffset3;
                    i61++;
                }
                iObjectFieldOffset2 = iObjectFieldOffset3;
                i2 = i80;
            }
            int i92 = i59 + 1;
            iArr2[i59] = iCharAt10;
            int i93 = i92 + 1;
            iArr2[i92] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i70 << 20);
            i59 = i93 + 1;
            iArr2[i93] = (i19 << 20) | iObjectFieldOffset;
            i29 = i18;
            length = length;
            i3 = i17;
            strC = strC;
            i6 = i6;
            c2 = 55296;
        }
        return new e0(iArr2, objArr, i3, i6, i0Var.b(), i0Var.zzc(), false, iArr, i4, i56, zqcVar, zzfcVar, zzgyVar, zzdpVar, qpcVar);
    }

    public static double I(Object obj, long j) {
        return ((Double) s0.k(obj, j)).doubleValue();
    }

    public static float J(Object obj, long j) {
        return ((Float) s0.k(obj, j)).floatValue();
    }

    public static int L(Object obj, long j) {
        return ((Integer) s0.k(obj, j)).intValue();
    }

    public static int T(int i) {
        return (i >>> 20) & 255;
    }

    public static long V(Object obj, long j) {
        return ((Long) s0.k(obj, j)).longValue();
    }

    public static Field o(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static void p(Object obj) {
        if (!B(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public final boolean C(Object obj, int i, int i2) {
        return s0.h(obj, (long) (R(i2) & 1048575)) == i;
    }

    public final int F(Object obj, byte[] bArr, int i, int i2, int i3, kgc kgcVar) throws IOException {
        Unsafe unsafe;
        int i4;
        Object obj2;
        e0<T> e0Var;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        kgc kgcVar2;
        int i12;
        Object obj3;
        int i13;
        int i14;
        int i15;
        boolean z2;
        int i16;
        int i17;
        int i18;
        int i19;
        int iA;
        Object obj4;
        int i20;
        e0<T> e0Var2 = this;
        Object obj5 = obj;
        byte[] bArr2 = bArr;
        i2 = i2;
        int i21 = i3;
        kgc kgcVar3 = kgcVar;
        p(obj);
        Unsafe unsafe2 = f31374a;
        int i22 = -1;
        int i23 = i;
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 1048575;
        while (true) {
            Object objValueOf = null;
            if (i23 < i2) {
                int iM = i23 + 1;
                byte b = bArr2[i23];
                if (b < 0) {
                    int iK = h.k(b, bArr2, iM, kgcVar3);
                    i6 = kgcVar3.f42815a;
                    iM = iK;
                } else {
                    i6 = b;
                }
                int i29 = i6 >>> 3;
                int iQ = i29 > i24 ? e0Var2.Q(i29, i25 / 3) : e0Var2.P(i29);
                if (iQ == i22) {
                    i7 = i29;
                    i8 = i27;
                    i28 = i28;
                    i9 = i22;
                    unsafe = unsafe2;
                    i4 = i21;
                    i10 = 0;
                    z = true;
                    i11 = i6;
                } else {
                    int i30 = i6 & 7;
                    int[] iArr = e0Var2.f5797a;
                    int i31 = iArr[iQ + 1];
                    int iT = T(i31);
                    long j = i31 & 1048575;
                    int i32 = i6;
                    if (iT <= 17) {
                        int i33 = iArr[iQ + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i28) {
                            if (i28 != 1048575) {
                                long j2 = i28;
                                obj4 = obj;
                                unsafe2.putInt(obj4, j2, i27);
                            } else {
                                obj4 = obj;
                            }
                            i28 = i35;
                            i13 = unsafe2.getInt(obj4, i35);
                            obj5 = obj4;
                        } else {
                            obj5 = obj;
                            i13 = i27;
                            i28 = i28;
                        }
                        switch (iT) {
                            case 0:
                                i14 = iQ;
                                i15 = i29;
                                z2 = true;
                                if (i30 == 1) {
                                    s0.t(obj5, j, Double.longBitsToDouble(h.q(bArr2, iM)));
                                    i23 = iM + 8;
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 1:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 5) {
                                    s0.u(obj5, j, Float.intBitsToFloat(h.b(bArr2, iM)));
                                    i23 = iM + 4;
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 2:
                            case 3:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 0) {
                                    int iM2 = h.m(bArr2, iM, kgcVar3);
                                    unsafe2.putLong(obj, j, kgcVar3.f17676a);
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i23 = iM2;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 4:
                            case 11:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 0) {
                                    i23 = h.j(bArr2, iM, kgcVar3);
                                    unsafe2.putInt(obj5, j, kgcVar3.f42815a);
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 5:
                            case 14:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 1) {
                                    unsafe2.putLong(obj, j, h.q(bArr2, iM));
                                    i23 = iM + 8;
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    z2 = true;
                                    i16 = i14;
                                    i19 = i32;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 6:
                            case 13:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 5) {
                                    unsafe2.putInt(obj5, j, h.b(bArr2, iM));
                                    i23 = iM + 4;
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 7:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 0) {
                                    i23 = h.m(bArr2, iM, kgcVar3);
                                    s0.r(obj5, j, kgcVar3.f17676a != 0);
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 8:
                                i14 = iQ;
                                i15 = i29;
                                if (i30 == 2) {
                                    i23 = (536870912 & i31) == 0 ? h.g(bArr2, iM, kgcVar3) : h.h(bArr2, iM, kgcVar3);
                                    unsafe2.putObject(obj5, j, kgcVar3.f17678a);
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 9:
                                i15 = i29;
                                if (i30 == 2) {
                                    Object objM = e0Var2.m(obj5, iQ);
                                    i32 = i32;
                                    i14 = iQ;
                                    i23 = h.o(objM, e0Var2.k(iQ), bArr, iM, i2, kgcVar);
                                    e0Var2.u(obj5, i14, objM);
                                    i27 = i13 | i34;
                                    i25 = i14;
                                    i24 = i15;
                                    i26 = i32;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i32 = i32;
                                    i16 = iQ;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 10:
                                i17 = iQ;
                                i15 = i29;
                                i18 = i32;
                                if (i30 == 2) {
                                    iA = h.a(bArr2, iM, kgcVar3);
                                    unsafe2.putObject(obj5, j, kgcVar3.f17678a);
                                    int i36 = i13 | i34;
                                    i2 = i2;
                                    i26 = i18;
                                    i24 = i15;
                                    i28 = i28;
                                    i22 = -1;
                                    i21 = i3;
                                    int i37 = i17;
                                    i27 = i36;
                                    i23 = iA;
                                    i25 = i37;
                                } else {
                                    i16 = i17;
                                    i19 = i18;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 12:
                                i17 = iQ;
                                i15 = i29;
                                i18 = i32;
                                if (i30 == 0) {
                                    iA = h.j(bArr2, iM, kgcVar3);
                                    int i38 = kgcVar3.f42815a;
                                    zzeh zzehVarJ = e0Var2.j(i17);
                                    if (zzehVarJ == null || zzehVarJ.a(i38)) {
                                        unsafe2.putInt(obj5, j, i38);
                                        int i39 = i13 | i34;
                                        i2 = i2;
                                        i26 = i18;
                                        i24 = i15;
                                        i28 = i28;
                                        i22 = -1;
                                        i21 = i3;
                                        int i310 = i17;
                                        i27 = i39;
                                        i23 = iA;
                                        i25 = i310;
                                    } else {
                                        G(obj).j(i18, Long.valueOf(i38));
                                        i23 = iA;
                                        i25 = i17;
                                        i26 = i18;
                                        i24 = i15;
                                        i27 = i13;
                                        i22 = -1;
                                        i2 = i2;
                                        i21 = i3;
                                    }
                                } else {
                                    i16 = i17;
                                    i19 = i18;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 15:
                                i17 = iQ;
                                i15 = i29;
                                i18 = i32;
                                if (i30 == 0) {
                                    i23 = h.j(bArr2, iM, kgcVar3);
                                    unsafe2.putInt(obj5, j, ric.a(kgcVar3.f42815a));
                                    int i40 = i13 | i34;
                                    i2 = i2;
                                    i25 = i17;
                                    i26 = i18;
                                    i22 = -1;
                                    i27 = i40;
                                    i24 = i15;
                                    i21 = i3;
                                } else {
                                    i16 = i17;
                                    i19 = i18;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            case 16:
                                if (i30 == 0) {
                                    int iM3 = h.m(bArr2, iM, kgcVar3);
                                    unsafe2.putLong(obj, j, ric.b(kgcVar3.f17676a));
                                    i27 = i13 | i34;
                                    i23 = iM3;
                                    i2 = i2;
                                    i26 = i32;
                                    i25 = iQ;
                                    i24 = i29;
                                    i22 = -1;
                                    i21 = i3;
                                } else {
                                    i15 = i29;
                                    i16 = iQ;
                                    i19 = i32;
                                    z2 = true;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                            default:
                                i14 = iQ;
                                i15 = i29;
                                z2 = true;
                                if (i30 == 3) {
                                    Object objM2 = e0Var2.m(obj5, i14);
                                    i23 = h.n(objM2, e0Var2.k(i14), bArr, iM, i2, (i15 << 3) | 4, kgcVar);
                                    e0Var2.u(obj5, i14, objM2);
                                    i27 = i13 | i34;
                                    i26 = i32;
                                    i2 = i2;
                                    i24 = i15;
                                    i25 = i14;
                                    i22 = -1;
                                    bArr2 = bArr;
                                    i21 = i3;
                                } else {
                                    i16 = i14;
                                    i19 = i32;
                                    i11 = i19;
                                    i4 = i3;
                                    z = z2;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i10 = i16;
                                    i8 = i13;
                                    i9 = -1;
                                }
                                break;
                        }
                    } else {
                        obj5 = obj;
                        if (iT != 27) {
                            i8 = i27;
                            i28 = i28;
                            if (iT <= 49) {
                                z = true;
                                int i41 = iM;
                                i9 = -1;
                                unsafe = unsafe2;
                                i10 = iQ;
                                i7 = i29;
                                i23 = O(obj, bArr, iM, i2, i32, i29, i30, iQ, i31, iT, j, kgcVar);
                                if (i23 != i41) {
                                    e0Var2 = this;
                                    obj5 = obj;
                                    bArr2 = bArr;
                                    i26 = i32;
                                    i2 = i2;
                                    i21 = i3;
                                    kgcVar3 = kgcVar;
                                    i27 = i8;
                                    i22 = i9;
                                    i24 = i7;
                                    i25 = i10;
                                    i28 = i28;
                                    unsafe2 = unsafe;
                                } else {
                                    i11 = i32;
                                    i4 = i3;
                                    iM = i23;
                                }
                            } else {
                                z = true;
                                i20 = iM;
                                unsafe = unsafe2;
                                i10 = iQ;
                                i7 = i29;
                                i9 = -1;
                                if (iT != 50) {
                                    i23 = N(obj, bArr, i20, i2, i32, i7, i30, i31, iT, j, i10, kgcVar);
                                    if (i23 != i20) {
                                        e0Var2 = this;
                                        obj5 = obj;
                                        bArr2 = bArr;
                                        i26 = i32;
                                        i2 = i2;
                                        i21 = i3;
                                        kgcVar3 = kgcVar;
                                        i27 = i8;
                                        i22 = i9;
                                        i24 = i7;
                                        i25 = i10;
                                        i28 = i28;
                                        unsafe2 = unsafe;
                                    } else {
                                        i11 = i32;
                                        i4 = i3;
                                        iM = i23;
                                    }
                                } else if (i30 == 2) {
                                    i23 = M(obj, bArr, i20, i2, i10, j, kgcVar);
                                    if (i23 != i20) {
                                        e0Var2 = this;
                                        obj5 = obj;
                                        bArr2 = bArr;
                                        i26 = i32;
                                        i2 = i2;
                                        i21 = i3;
                                        kgcVar3 = kgcVar;
                                        i27 = i8;
                                        i22 = i9;
                                        i24 = i7;
                                        i25 = i10;
                                        i28 = i28;
                                        unsafe2 = unsafe;
                                    } else {
                                        i11 = i32;
                                        i4 = i3;
                                        iM = i23;
                                    }
                                } else {
                                    i11 = i32;
                                    i4 = i3;
                                    iM = i20;
                                }
                            }
                        } else if (i30 == 2) {
                            zzel zzelVarW = (zzel) unsafe2.getObject(obj5, j);
                            if (!zzelVarW.r()) {
                                int size = zzelVarW.size();
                                zzelVarW = zzelVarW.W(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj5, j, zzelVarW);
                            }
                            i23 = h.e(e0Var2.k(iQ), i32, bArr, iM, i2, zzelVarW, kgcVar);
                            i26 = i32;
                            i21 = i3;
                            i25 = iQ;
                            i24 = i29;
                            i27 = i27;
                            i28 = i28;
                            i22 = -1;
                            bArr2 = bArr;
                            i2 = i2;
                        } else {
                            i8 = i27;
                            i28 = i28;
                            z = true;
                            i20 = iM;
                            unsafe = unsafe2;
                            i10 = iQ;
                            i7 = i29;
                            i9 = -1;
                            i11 = i32;
                            i4 = i3;
                            iM = i20;
                        }
                    }
                }
                if (i11 != i4 || i4 == 0) {
                    if (this.f5796a) {
                        kgcVar2 = kgcVar;
                        qjc qjcVar = kgcVar2.f17677a;
                        if (qjcVar != qjc.f19130a) {
                            i12 = i7;
                            llc llcVarB = qjcVar.b(this.f5792a, i12);
                            if (llcVarB != null) {
                                obj = obj;
                                zzdz zzdzVar = (zzdz) obj;
                                zzdzVar.t();
                                bkc bkcVar = zzdzVar.zza;
                                zzho zzhoVar = llcVarB.f17992a.f42156a;
                                if (zzhoVar == zzho.zzn) {
                                    h.j(bArr, iM, kgcVar2);
                                    throw null;
                                }
                                switch (zzhoVar.ordinal()) {
                                    case 0:
                                        bArr = bArr;
                                        objValueOf = Double.valueOf(Double.longBitsToDouble(h.q(bArr, iM)));
                                        iM += 8;
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 1:
                                        bArr = bArr;
                                        objValueOf = Float.valueOf(Float.intBitsToFloat(h.b(bArr, iM)));
                                        iM += 4;
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 2:
                                    case 3:
                                        bArr = bArr;
                                        iM = h.m(bArr, iM, kgcVar2);
                                        objValueOf = Long.valueOf(kgcVar2.f17676a);
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 4:
                                    case 12:
                                        bArr = bArr;
                                        iM = h.j(bArr, iM, kgcVar2);
                                        objValueOf = Integer.valueOf(kgcVar2.f42815a);
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 5:
                                    case 15:
                                        bArr = bArr;
                                        objValueOf = Long.valueOf(h.q(bArr, iM));
                                        iM += 8;
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 6:
                                    case 14:
                                        bArr = bArr;
                                        objValueOf = Integer.valueOf(h.b(bArr, iM));
                                        iM += 4;
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 7:
                                        bArr = bArr;
                                        iM = h.m(bArr, iM, kgcVar2);
                                        if (kgcVar2.f17676a == 0) {
                                            z = false;
                                        }
                                        objValueOf = Boolean.valueOf(z);
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 8:
                                        bArr = bArr;
                                        iM = h.g(bArr, iM, kgcVar2);
                                        obj3 = kgcVar2.f17678a;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 9:
                                        bArr = bArr;
                                        int i42 = (i12 << 3) | 4;
                                        zzgh zzghVarB = g0.a().b(llcVarB.b.getClass());
                                        Object objE = bkcVar.e(llcVarB.f17992a);
                                        if (objE == null) {
                                            objE = zzghVarB.e();
                                            bkcVar.i(llcVarB.f17992a, objE);
                                        }
                                        i23 = h.n(objE, zzghVarB, bArr, iM, i2, i42, kgcVar);
                                        break;
                                    case 10:
                                        bArr = bArr;
                                        zzgh zzghVarB2 = g0.a().b(llcVarB.b.getClass());
                                        Object objE2 = bkcVar.e(llcVarB.f17992a);
                                        if (objE2 == null) {
                                            objE2 = zzghVarB2.e();
                                            bkcVar.i(llcVarB.f17992a, objE2);
                                        }
                                        i23 = h.o(objE2, zzghVarB2, bArr, iM, i2, kgcVar);
                                        break;
                                    case 11:
                                        bArr = bArr;
                                        iM = h.a(bArr, iM, kgcVar2);
                                        obj3 = kgcVar2.f17678a;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 13:
                                        throw new IllegalStateException("Shouldn't reach here.");
                                    case 16:
                                        bArr = bArr;
                                        iM = h.j(bArr, iM, kgcVar2);
                                        objValueOf = Integer.valueOf(ric.a(kgcVar2.f42815a));
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    case 17:
                                        bArr = bArr;
                                        iM = h.m(bArr, iM, kgcVar2);
                                        objValueOf = Long.valueOf(ric.b(kgcVar2.f17676a));
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                    default:
                                        bArr = bArr;
                                        obj3 = objValueOf;
                                        bkcVar.i(llcVarB.f17992a, obj3);
                                        i23 = iM;
                                        break;
                                }
                            } else {
                                i23 = h.i(i11, bArr, iM, i2, G(obj), kgcVar);
                                obj = obj;
                                bArr = bArr;
                            }
                        }
                        i26 = i11;
                        e0Var2 = this;
                        kgcVar3 = kgcVar2;
                        i24 = i12;
                        obj5 = obj;
                        bArr2 = bArr;
                        i27 = i8;
                        i22 = i9;
                        i25 = i10;
                        i28 = i28;
                        unsafe2 = unsafe;
                        i2 = i2;
                        i21 = i4;
                    } else {
                        kgcVar2 = kgcVar;
                    }
                    i12 = i7;
                    i23 = h.i(i11, bArr, iM, i2, G(obj), kgcVar);
                    i26 = i11;
                    e0Var2 = this;
                    kgcVar3 = kgcVar2;
                    i24 = i12;
                    obj5 = obj;
                    bArr2 = bArr;
                    i27 = i8;
                    i22 = i9;
                    i25 = i10;
                    i28 = i28;
                    unsafe2 = unsafe;
                    i2 = i2;
                    i21 = i4;
                } else {
                    i5 = 1048575;
                    e0Var = this;
                    obj2 = obj;
                    i23 = iM;
                    i26 = i11;
                    i27 = i8;
                    i28 = i28;
                }
            } else {
                unsafe = unsafe2;
                i4 = i21;
                obj2 = obj5;
                e0Var = e0Var2;
                i5 = 1048575;
            }
        }
        if (i28 != i5) {
            unsafe.putInt(obj2, i28, i27);
        }
        for (int i43 = e0Var.f5800c; i43 < e0Var.d; i43++) {
            int i44 = e0Var.f5799b[i43];
            int i45 = e0Var.f5797a[i44];
            Object objK = s0.k(obj2, e0Var.U(i44) & i5);
            if (objK != null && e0Var.j(i44) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (i23 != i2) {
                throw zzeo.zze();
            }
        } else if (i23 > i2 || i26 != i4) {
            throw zzeo.zze();
        }
        return i23;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int K(Object obj) {
        int i;
        int iA;
        int iA2;
        int iB;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iQ;
        boolean z;
        int iZ;
        int iE;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        Unsafe unsafe = f31374a;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int iA14 = 0;
        int i5 = 0;
        while (i4 < this.f5797a.length) {
            int iU = U(i4);
            int[] iArr = this.f5797a;
            int i6 = iArr[i4];
            int iT = T(iU);
            if (iT <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                int i9 = i7 >>> 20;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << i9;
            } else {
                i = 0;
            }
            long j = iU & i2;
            switch (iT) {
                case 0:
                    if ((i5 & i) != 0) {
                        iA = zzdj.A(i6 << 3);
                        iA4 = iA + 8;
                        iA14 += iA4;
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        iA2 = zzdj.A(i6 << 3);
                        iA4 = iA2 + 4;
                        iA14 += iA4;
                    }
                    break;
                case 2:
                    if ((i5 & i) != 0) {
                        iB = zzdj.B(unsafe.getLong(obj, j));
                        iA3 = zzdj.A(i6 << 3);
                        iA14 += iA3 + iB;
                    }
                    break;
                case 3:
                    if ((i5 & i) != 0) {
                        iB = zzdj.B(unsafe.getLong(obj, j));
                        iA3 = zzdj.A(i6 << 3);
                        iA14 += iA3 + iB;
                    }
                    break;
                case 4:
                    if ((i5 & i) != 0) {
                        iB = zzdj.w(unsafe.getInt(obj, j));
                        iA3 = zzdj.A(i6 << 3);
                        iA14 += iA3 + iB;
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        iA = zzdj.A(i6 << 3);
                        iA4 = iA + 8;
                        iA14 += iA4;
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        iA2 = zzdj.A(i6 << 3);
                        iA4 = iA2 + 4;
                        iA14 += iA4;
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        iA4 = zzdj.A(i6 << 3) + 1;
                        iA14 += iA4;
                    }
                    break;
                case 8:
                    if ((i5 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdb) {
                            int i10 = zzdj.f31401a;
                            int iZzd = ((zzdb) object).zzd();
                            iA5 = zzdj.A(iZzd) + iZzd;
                            iA6 = zzdj.A(i6 << 3);
                            iA4 = iA6 + iA5;
                            iA14 += iA4;
                        } else {
                            iB = zzdj.z((String) object);
                            iA3 = zzdj.A(i6 << 3);
                            iA14 += iA3 + iB;
                        }
                    }
                    break;
                case 9:
                    if ((i5 & i) != 0) {
                        iA4 = m0.K(i6, unsafe.getObject(obj, j), k(i4));
                        iA14 += iA4;
                    }
                    break;
                case 10:
                    if ((i5 & i) != 0) {
                        zzdb zzdbVar = (zzdb) unsafe.getObject(obj, j);
                        int i11 = zzdj.f31401a;
                        int iZzd2 = zzdbVar.zzd();
                        iA5 = zzdj.A(iZzd2) + iZzd2;
                        iA6 = zzdj.A(i6 << 3);
                        iA4 = iA6 + iA5;
                        iA14 += iA4;
                    }
                    break;
                case 11:
                    if ((i5 & i) != 0) {
                        iB = zzdj.A(unsafe.getInt(obj, j));
                        iA3 = zzdj.A(i6 << 3);
                        iA14 += iA3 + iB;
                    }
                    break;
                case 12:
                    if ((i5 & i) != 0) {
                        iB = zzdj.w(unsafe.getInt(obj, j));
                        iA3 = zzdj.A(i6 << 3);
                        iA14 += iA3 + iB;
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        iA2 = zzdj.A(i6 << 3);
                        iA4 = iA2 + 4;
                        iA14 += iA4;
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        iA = zzdj.A(i6 << 3);
                        iA4 = iA + 8;
                        iA14 += iA4;
                    }
                    break;
                case 15:
                    if ((i5 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iA3 = zzdj.A(i6 << 3);
                        iB = zzdj.A((i12 >> 31) ^ (i12 + i12));
                        iA14 += iA3 + iB;
                    }
                    break;
                case 16:
                    if ((i & i5) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iA14 += zzdj.A(i6 << 3) + zzdj.B((j2 >> 63) ^ (j2 + j2));
                    }
                    break;
                case 17:
                    if ((i5 & i) != 0) {
                        iA4 = zzdj.v(i6, (zzfo) unsafe.getObject(obj, j), k(i4));
                        iA14 += iA4;
                    }
                    break;
                case 18:
                    iA4 = m0.D(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 19:
                    iA4 = m0.B(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 20:
                    iA4 = m0.I(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 21:
                    iA4 = m0.T(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 22:
                    iA4 = m0.G(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 23:
                    iA4 = m0.D(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 24:
                    iA4 = m0.B(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 25:
                    iA4 = m0.x(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iA4;
                    break;
                case 26:
                    iQ = m0.Q(i6, (List) unsafe.getObject(obj, j));
                    iA14 += iQ;
                    break;
                case 27:
                    iQ = m0.L(i6, (List) unsafe.getObject(obj, j), k(i4));
                    iA14 += iQ;
                    break;
                case 28:
                    iQ = m0.y(i6, (List) unsafe.getObject(obj, j));
                    iA14 += iQ;
                    break;
                case 29:
                    iQ = m0.R(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iQ;
                    break;
                case 30:
                    z = false;
                    iZ = m0.z(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iZ;
                    break;
                case 31:
                    z = false;
                    iZ = m0.B(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iZ;
                    break;
                case 32:
                    z = false;
                    iZ = m0.D(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iZ;
                    break;
                case 33:
                    z = false;
                    iZ = m0.M(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iZ;
                    break;
                case 34:
                    z = false;
                    iZ = m0.O(i6, (List) unsafe.getObject(obj, j), false);
                    iA14 += iZ;
                    break;
                case 35:
                    iE = m0.E((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 36:
                    iE = m0.C((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 37:
                    iE = m0.J((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 38:
                    iE = m0.U((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 39:
                    iE = m0.H((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 40:
                    iE = m0.E((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 41:
                    iE = m0.C((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = m0.f31387a;
                    iE = list.size();
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 43:
                    iE = m0.S((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 44:
                    iE = m0.A((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 45:
                    iE = m0.C((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 46:
                    iE = m0.E((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 47:
                    iE = m0.N((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 48:
                    iE = m0.P((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA7 = zzdj.A(iE);
                        iA8 = zzdj.A(i6 << 3);
                        iA9 = iA8 + iA7;
                        iA14 += iA9 + iE;
                    }
                    break;
                case 49:
                    iQ = m0.F(i6, (List) unsafe.getObject(obj, j), k(i4));
                    iA14 += iQ;
                    break;
                case 50:
                    qpc.a(i6, unsafe.getObject(obj, j), l(i4));
                    break;
                case 51:
                    if (C(obj, i6, i4)) {
                        iA10 = zzdj.A(i6 << 3);
                        iQ = iA10 + 8;
                        iA14 += iQ;
                    }
                    break;
                case 52:
                    if (C(obj, i6, i4)) {
                        iA11 = zzdj.A(i6 << 3);
                        iQ = iA11 + 4;
                        iA14 += iQ;
                    }
                    break;
                case 53:
                    if (C(obj, i6, i4)) {
                        iE = zzdj.B(V(obj, j));
                        iA9 = zzdj.A(i6 << 3);
                        iA14 += iA9 + iE;
                    }
                    break;
                case 54:
                    if (C(obj, i6, i4)) {
                        iE = zzdj.B(V(obj, j));
                        iA9 = zzdj.A(i6 << 3);
                        iA14 += iA9 + iE;
                    }
                    break;
                case 55:
                    if (C(obj, i6, i4)) {
                        iE = zzdj.w(L(obj, j));
                        iA9 = zzdj.A(i6 << 3);
                        iA14 += iA9 + iE;
                    }
                    break;
                case 56:
                    if (C(obj, i6, i4)) {
                        iA10 = zzdj.A(i6 << 3);
                        iQ = iA10 + 8;
                        iA14 += iQ;
                    }
                    break;
                case 57:
                    if (C(obj, i6, i4)) {
                        iA11 = zzdj.A(i6 << 3);
                        iQ = iA11 + 4;
                        iA14 += iQ;
                    }
                    break;
                case 58:
                    if (C(obj, i6, i4)) {
                        iQ = zzdj.A(i6 << 3) + 1;
                        iA14 += iQ;
                    }
                    break;
                case 59:
                    if (C(obj, i6, i4)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdb) {
                            int i14 = zzdj.f31401a;
                            int iZzd3 = ((zzdb) object2).zzd();
                            iA12 = zzdj.A(iZzd3) + iZzd3;
                            iA13 = zzdj.A(i6 << 3);
                            iQ = iA13 + iA12;
                            iA14 += iQ;
                        } else {
                            iE = zzdj.z((String) object2);
                            iA9 = zzdj.A(i6 << 3);
                            iA14 += iA9 + iE;
                        }
                    }
                    break;
                case 60:
                    if (C(obj, i6, i4)) {
                        iQ = m0.K(i6, unsafe.getObject(obj, j), k(i4));
                        iA14 += iQ;
                    }
                    break;
                case 61:
                    if (C(obj, i6, i4)) {
                        zzdb zzdbVar2 = (zzdb) unsafe.getObject(obj, j);
                        int i15 = zzdj.f31401a;
                        int iZzd4 = zzdbVar2.zzd();
                        iA12 = zzdj.A(iZzd4) + iZzd4;
                        iA13 = zzdj.A(i6 << 3);
                        iQ = iA13 + iA12;
                        iA14 += iQ;
                    }
                    break;
                case 62:
                    if (C(obj, i6, i4)) {
                        iE = zzdj.A(L(obj, j));
                        iA9 = zzdj.A(i6 << 3);
                        iA14 += iA9 + iE;
                    }
                    break;
                case 63:
                    if (C(obj, i6, i4)) {
                        iE = zzdj.w(L(obj, j));
                        iA9 = zzdj.A(i6 << 3);
                        iA14 += iA9 + iE;
                    }
                    break;
                case 64:
                    if (C(obj, i6, i4)) {
                        iA11 = zzdj.A(i6 << 3);
                        iQ = iA11 + 4;
                        iA14 += iQ;
                    }
                    break;
                case 65:
                    if (C(obj, i6, i4)) {
                        iA10 = zzdj.A(i6 << 3);
                        iQ = iA10 + 8;
                        iA14 += iQ;
                    }
                    break;
                case 66:
                    if (C(obj, i6, i4)) {
                        int iL = L(obj, j);
                        iA9 = zzdj.A(i6 << 3);
                        iE = zzdj.A((iL >> 31) ^ (iL + iL));
                        iA14 += iA9 + iE;
                    }
                    break;
                case 67:
                    if (C(obj, i6, i4)) {
                        long jV = V(obj, j);
                        iA14 += zzdj.A(i6 << 3) + zzdj.B((jV >> 63) ^ (jV + jV));
                    }
                    break;
                case 68:
                    if (C(obj, i6, i4)) {
                        iQ = zzdj.v(i6, (zzfo) unsafe.getObject(obj, j), k(i4));
                        iA14 += iQ;
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        int iA15 = 0;
        zzgy zzgyVar = this.f5793a;
        int iA16 = iA14 + zzgyVar.a(zzgyVar.d(obj));
        if (!this.f5796a) {
            return iA16;
        }
        bkc bkcVarB = this.f5790a.b(obj);
        for (int i16 = 0; i16 < bkcVarB.f15553a.c(); i16++) {
            Map.Entry entryH = bkcVarB.f15553a.h(i16);
            iA15 += bkc.a((zzds) entryH.getKey(), entryH.getValue());
        }
        for (Map.Entry entry : bkcVarB.f15553a.d()) {
            iA15 += bkc.a((zzds) entry.getKey(), entry.getValue());
        }
        return iA16 + iA15;
    }

    public final int M(Object obj, byte[] bArr, int i, int i2, int i3, long j, kgc kgcVar) throws IOException {
        Unsafe unsafe = f31374a;
        Object objL = l(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzfi) object).zze()) {
            zzfi zzfiVarZzb = zzfi.zza().zzb();
            qpc.b(zzfiVarZzb, object);
            unsafe.putObject(obj, j, zzfiVarZzb);
        }
        throw null;
    }

    public final int N(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, kgc kgcVar) throws IOException {
        Unsafe unsafe = f31374a;
        long j2 = this.f5797a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(h.q(bArr, i))));
                int i9 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(h.b(bArr, i))));
                int i10 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iM = h.m(bArr, i, kgcVar);
                unsafe.putObject(obj, j, Long.valueOf(kgcVar.f17676a));
                unsafe.putInt(obj, j2, i4);
                return iM;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iJ = h.j(bArr, i, kgcVar);
                unsafe.putObject(obj, j, Integer.valueOf(kgcVar.f42815a));
                unsafe.putInt(obj, j2, i4);
                return iJ;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(h.q(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(h.b(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iM2 = h.m(bArr, i, kgcVar);
                unsafe.putObject(obj, j, Boolean.valueOf(kgcVar.f17676a != 0));
                unsafe.putInt(obj, j2, i4);
                return iM2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iJ2 = h.j(bArr, i, kgcVar);
                int i13 = kgcVar.f42815a;
                if (i13 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !u0.h(bArr, iJ2, iJ2 + i13)) {
                        throw zzeo.zzc();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iJ2, i13, rmc.b));
                    iJ2 += i13;
                }
                unsafe.putInt(obj, j2, i4);
                return iJ2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                Object objN = n(obj, i4, i8);
                int iO = h.o(objN, k(i8), bArr, i, i2, kgcVar);
                v(obj, i4, i8, objN);
                return iO;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iA = h.a(bArr, i, kgcVar);
                unsafe.putObject(obj, j, kgcVar.f17678a);
                unsafe.putInt(obj, j2, i4);
                return iA;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iJ3 = h.j(bArr, i, kgcVar);
                int i14 = kgcVar.f42815a;
                zzeh zzehVarJ = j(i8);
                if (zzehVarJ == null || zzehVarJ.a(i14)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i14));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    G(obj).j(i3, Long.valueOf(i14));
                }
                return iJ3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iJ4 = h.j(bArr, i, kgcVar);
                unsafe.putObject(obj, j, Integer.valueOf(ric.a(kgcVar.f42815a)));
                unsafe.putInt(obj, j2, i4);
                return iJ4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iM3 = h.m(bArr, i, kgcVar);
                unsafe.putObject(obj, j, Long.valueOf(ric.b(kgcVar.f17676a)));
                unsafe.putInt(obj, j2, i4);
                return iM3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                Object objN2 = n(obj, i4, i8);
                int iN = h.n(objN2, k(i8), bArr, i, i2, (i3 & (-8)) | 4, kgcVar);
                v(obj, i4, i8, objN2);
                return iN;
            default:
                return i;
        }
    }

    public final int O(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, kgc kgcVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iL;
        int iJ = i;
        Unsafe unsafe = f31374a;
        zzel zzelVarW = (zzel) unsafe.getObject(obj, j2);
        if (!zzelVarW.r()) {
            int size = zzelVarW.size();
            zzelVarW = zzelVarW.W(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzelVarW);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    m mVar = (m) zzelVarW;
                    int iJ2 = h.j(bArr, iJ, kgcVar);
                    int i12 = kgcVar.f42815a + iJ2;
                    while (iJ2 < i12) {
                        mVar.a(Double.longBitsToDouble(h.q(bArr, iJ2)));
                        iJ2 += 8;
                    }
                    if (iJ2 == i12) {
                        return iJ2;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 1) {
                    m mVar2 = (m) zzelVarW;
                    mVar2.a(Double.longBitsToDouble(h.q(bArr, i)));
                    while (true) {
                        i8 = iJ + 8;
                        if (i8 < i2) {
                            iJ = h.j(bArr, i8, kgcVar);
                            if (i3 == kgcVar.f42815a) {
                                mVar2.a(Double.longBitsToDouble(h.q(bArr, iJ)));
                            }
                        }
                    }
                    return i8;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    p pVar = (p) zzelVarW;
                    int iJ3 = h.j(bArr, iJ, kgcVar);
                    int i13 = kgcVar.f42815a + iJ3;
                    while (iJ3 < i13) {
                        pVar.S(Float.intBitsToFloat(h.b(bArr, iJ3)));
                        iJ3 += 4;
                    }
                    if (iJ3 == i13) {
                        return iJ3;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 5) {
                    p pVar2 = (p) zzelVarW;
                    pVar2.S(Float.intBitsToFloat(h.b(bArr, i)));
                    while (true) {
                        i9 = iJ + 4;
                        if (i9 < i2) {
                            iJ = h.j(bArr, i9, kgcVar);
                            if (i3 == kgcVar.f42815a) {
                                pVar2.S(Float.intBitsToFloat(h.b(bArr, iJ)));
                            }
                        }
                    }
                    return i9;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    z zVar = (z) zzelVarW;
                    int iJ4 = h.j(bArr, iJ, kgcVar);
                    int i14 = kgcVar.f42815a + iJ4;
                    while (iJ4 < i14) {
                        iJ4 = h.m(bArr, iJ4, kgcVar);
                        zVar.b(kgcVar.f17676a);
                    }
                    if (iJ4 == i14) {
                        return iJ4;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    z zVar2 = (z) zzelVarW;
                    int iM = h.m(bArr, iJ, kgcVar);
                    zVar2.b(kgcVar.f17676a);
                    while (iM < i2) {
                        int iJ5 = h.j(bArr, iM, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iM;
                        }
                        iM = h.m(bArr, iJ5, kgcVar);
                        zVar2.b(kgcVar.f17676a);
                    }
                    return iM;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return h.f(bArr, iJ, zzelVarW, kgcVar);
                }
                if (i5 == 0) {
                    return h.l(i3, bArr, i, i2, zzelVarW, kgcVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    z zVar3 = (z) zzelVarW;
                    int iJ6 = h.j(bArr, iJ, kgcVar);
                    int i15 = kgcVar.f42815a + iJ6;
                    while (iJ6 < i15) {
                        zVar3.b(h.q(bArr, iJ6));
                        iJ6 += 8;
                    }
                    if (iJ6 == i15) {
                        return iJ6;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 1) {
                    z zVar4 = (z) zzelVarW;
                    zVar4.b(h.q(bArr, i));
                    while (true) {
                        i10 = iJ + 8;
                        if (i10 < i2) {
                            iJ = h.j(bArr, i10, kgcVar);
                            if (i3 == kgcVar.f42815a) {
                                zVar4.b(h.q(bArr, iJ));
                            }
                        }
                    }
                    return i10;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    t tVar = (t) zzelVarW;
                    int iJ7 = h.j(bArr, iJ, kgcVar);
                    int i16 = kgcVar.f42815a + iJ7;
                    while (iJ7 < i16) {
                        tVar.c(h.b(bArr, iJ7));
                        iJ7 += 4;
                    }
                    if (iJ7 == i16) {
                        return iJ7;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 5) {
                    t tVar2 = (t) zzelVarW;
                    tVar2.c(h.b(bArr, i));
                    while (true) {
                        i11 = iJ + 4;
                        if (i11 < i2) {
                            iJ = h.j(bArr, i11, kgcVar);
                            if (i3 == kgcVar.f42815a) {
                                tVar2.c(h.b(bArr, iJ));
                            }
                        }
                    }
                    return i11;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    i iVar = (i) zzelVarW;
                    int iJ8 = h.j(bArr, iJ, kgcVar);
                    int i17 = kgcVar.f42815a + iJ8;
                    while (iJ8 < i17) {
                        iJ8 = h.m(bArr, iJ8, kgcVar);
                        iVar.a(kgcVar.f17676a != 0);
                    }
                    if (iJ8 == i17) {
                        return iJ8;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    i iVar2 = (i) zzelVarW;
                    int iM2 = h.m(bArr, iJ, kgcVar);
                    iVar2.a(kgcVar.f17676a != 0);
                    while (iM2 < i2) {
                        int iJ9 = h.j(bArr, iM2, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iM2;
                        }
                        iM2 = h.m(bArr, iJ9, kgcVar);
                        iVar2.a(kgcVar.f17676a != 0);
                    }
                    return iM2;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iJ10 = h.j(bArr, iJ, kgcVar);
                        int i18 = kgcVar.f42815a;
                        if (i18 < 0) {
                            throw zzeo.zzd();
                        }
                        if (i18 == 0) {
                            zzelVarW.add("");
                        } else {
                            zzelVarW.add(new String(bArr, iJ10, i18, rmc.b));
                            iJ10 += i18;
                        }
                        while (iJ10 < i2) {
                            int iJ11 = h.j(bArr, iJ10, kgcVar);
                            if (i3 != kgcVar.f42815a) {
                                return iJ10;
                            }
                            iJ10 = h.j(bArr, iJ11, kgcVar);
                            int i19 = kgcVar.f42815a;
                            if (i19 < 0) {
                                throw zzeo.zzd();
                            }
                            if (i19 == 0) {
                                zzelVarW.add("");
                            } else {
                                zzelVarW.add(new String(bArr, iJ10, i19, rmc.b));
                                iJ10 += i19;
                            }
                        }
                        return iJ10;
                    }
                    int iJ12 = h.j(bArr, iJ, kgcVar);
                    int i20 = kgcVar.f42815a;
                    if (i20 < 0) {
                        throw zzeo.zzd();
                    }
                    if (i20 == 0) {
                        zzelVarW.add("");
                    } else {
                        int i21 = iJ12 + i20;
                        if (!u0.h(bArr, iJ12, i21)) {
                            throw zzeo.zzc();
                        }
                        zzelVarW.add(new String(bArr, iJ12, i20, rmc.b));
                        iJ12 = i21;
                    }
                    while (iJ12 < i2) {
                        int iJ13 = h.j(bArr, iJ12, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iJ12;
                        }
                        iJ12 = h.j(bArr, iJ13, kgcVar);
                        int i22 = kgcVar.f42815a;
                        if (i22 < 0) {
                            throw zzeo.zzd();
                        }
                        if (i22 == 0) {
                            zzelVarW.add("");
                        } else {
                            int i23 = iJ12 + i22;
                            if (!u0.h(bArr, iJ12, i23)) {
                                throw zzeo.zzc();
                            }
                            zzelVarW.add(new String(bArr, iJ12, i22, rmc.b));
                            iJ12 = i23;
                        }
                    }
                    return iJ12;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return h.e(k(i6), i3, bArr, i, i2, zzelVarW, kgcVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iJ14 = h.j(bArr, iJ, kgcVar);
                    int i24 = kgcVar.f42815a;
                    if (i24 < 0) {
                        throw zzeo.zzd();
                    }
                    if (i24 > bArr.length - iJ14) {
                        throw zzeo.zzg();
                    }
                    if (i24 == 0) {
                        zzelVarW.add(zzdb.zzb);
                    } else {
                        zzelVarW.add(zzdb.zzr(bArr, iJ14, i24));
                        iJ14 += i24;
                    }
                    while (iJ14 < i2) {
                        int iJ15 = h.j(bArr, iJ14, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iJ14;
                        }
                        iJ14 = h.j(bArr, iJ15, kgcVar);
                        int i25 = kgcVar.f42815a;
                        if (i25 < 0) {
                            throw zzeo.zzd();
                        }
                        if (i25 > bArr.length - iJ14) {
                            throw zzeo.zzg();
                        }
                        if (i25 == 0) {
                            zzelVarW.add(zzdb.zzb);
                        } else {
                            zzelVarW.add(zzdb.zzr(bArr, iJ14, i25));
                            iJ14 += i25;
                        }
                    }
                    return iJ14;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iL = h.f(bArr, iJ, zzelVarW, kgcVar);
                } else if (i5 == 0) {
                    iL = h.l(i3, bArr, i, i2, zzelVarW, kgcVar);
                }
                zzeh zzehVarJ = j(i6);
                zzgy zzgyVar = this.f5793a;
                int i26 = m0.f31387a;
                if (zzehVarJ != null) {
                    Object objA = null;
                    if (zzelVarW instanceof RandomAccess) {
                        int size2 = zzelVarW.size();
                        int i27 = 0;
                        for (int i28 = 0; i28 < size2; i28++) {
                            int iIntValue = ((Integer) zzelVarW.get(i28)).intValue();
                            if (zzehVarJ.a(iIntValue)) {
                                if (i28 != i27) {
                                    zzelVarW.set(i27, Integer.valueOf(iIntValue));
                                }
                                i27++;
                            } else {
                                objA = m0.a(obj, i4, iIntValue, objA, zzgyVar);
                            }
                        }
                        if (i27 != size2) {
                            zzelVarW.subList(i27, size2).clear();
                            return iL;
                        }
                    } else {
                        Iterator it = zzelVarW.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!zzehVarJ.a(iIntValue2)) {
                                objA = m0.a(obj, i4, iIntValue2, objA, zzgyVar);
                                it.remove();
                            }
                        }
                    }
                }
                return iL;
            case 33:
            case 47:
                if (i5 == 2) {
                    t tVar3 = (t) zzelVarW;
                    int iJ16 = h.j(bArr, iJ, kgcVar);
                    int i29 = kgcVar.f42815a + iJ16;
                    while (iJ16 < i29) {
                        iJ16 = h.j(bArr, iJ16, kgcVar);
                        tVar3.c(ric.a(kgcVar.f42815a));
                    }
                    if (iJ16 == i29) {
                        return iJ16;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    t tVar4 = (t) zzelVarW;
                    int iJ17 = h.j(bArr, iJ, kgcVar);
                    tVar4.c(ric.a(kgcVar.f42815a));
                    while (iJ17 < i2) {
                        int iJ18 = h.j(bArr, iJ17, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iJ17;
                        }
                        iJ17 = h.j(bArr, iJ18, kgcVar);
                        tVar4.c(ric.a(kgcVar.f42815a));
                    }
                    return iJ17;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    z zVar5 = (z) zzelVarW;
                    int iJ19 = h.j(bArr, iJ, kgcVar);
                    int i30 = kgcVar.f42815a + iJ19;
                    while (iJ19 < i30) {
                        iJ19 = h.m(bArr, iJ19, kgcVar);
                        zVar5.b(ric.b(kgcVar.f17676a));
                    }
                    if (iJ19 == i30) {
                        return iJ19;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    z zVar6 = (z) zzelVarW;
                    int iM3 = h.m(bArr, iJ, kgcVar);
                    zVar6.b(ric.b(kgcVar.f17676a));
                    while (iM3 < i2) {
                        int iJ20 = h.j(bArr, iM3, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iM3;
                        }
                        iM3 = h.m(bArr, iJ20, kgcVar);
                        zVar6.b(ric.b(kgcVar.f17676a));
                    }
                    return iM3;
                }
                break;
            default:
                if (i5 == 3) {
                    zzgh zzghVarK = k(i6);
                    int i31 = (i3 & (-8)) | 4;
                    int iC = h.c(zzghVarK, bArr, i, i2, i31, kgcVar);
                    zzelVarW.add(kgcVar.f17678a);
                    while (iC < i2) {
                        int iJ21 = h.j(bArr, iC, kgcVar);
                        if (i3 != kgcVar.f42815a) {
                            return iC;
                        }
                        iC = h.c(zzghVarK, bArr, iJ21, i2, i31, kgcVar);
                        zzelVarW.add(kgcVar.f17678a);
                    }
                    return iC;
                }
                break;
        }
        return iJ;
    }

    public final int P(int i) {
        if (i < this.f5789a || i > this.b) {
            return -1;
        }
        return S(i, 0);
    }

    public final int Q(int i, int i2) {
        if (i < this.f5789a || i > this.b) {
            return -1;
        }
        return S(i, i2);
    }

    public final int R(int i) {
        return this.f5797a[i + 2];
    }

    public final int S(int i, int i2) {
        int length = (this.f5797a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f5797a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int U(int i) {
        return this.f5797a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:177:0x054c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0030  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void a(Object obj, zzhq zzhqVar) throws IOException {
        Iterator itF;
        Map.Entry entry;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Iterator itF2;
        Map.Entry entry2;
        zzho zzhoVar = zzho.zza;
        if (this.e - 1 != 0) {
            if (this.f5796a) {
                bkc bkcVarB = this.f5790a.b(obj);
                if (bkcVarB.f15553a.isEmpty()) {
                    itF2 = null;
                    entry2 = null;
                } else {
                    itF2 = bkcVarB.f();
                    entry2 = (Map.Entry) itF2.next();
                }
            } else {
                itF2 = null;
                entry2 = null;
            }
            int length = this.f5797a.length;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int iU = U(i2);
                int i3 = this.f5797a[i2];
                while (entry2 != null && this.f5790a.a(entry2) <= i3) {
                    this.f5790a.f(zzhqVar, entry2);
                    entry2 = itF2.hasNext() ? (Map.Entry) itF2.next() : null;
                }
                switch (T(iU)) {
                    case 0:
                        if (y(obj, i2)) {
                            zzhqVar.a(i3, s0.f(obj, iU & 1048575));
                        }
                        break;
                    case 1:
                        if (y(obj, i2)) {
                            zzhqVar.i(i3, s0.g(obj, iU & 1048575));
                        }
                        break;
                    case 2:
                        if (y(obj, i2)) {
                            zzhqVar.m(i3, s0.i(obj, iU & 1048575));
                        }
                        break;
                    case 3:
                        if (y(obj, i2)) {
                            zzhqVar.F(i3, s0.i(obj, iU & 1048575));
                        }
                        break;
                    case 4:
                        if (y(obj, i2)) {
                            zzhqVar.k(i3, s0.h(obj, iU & 1048575));
                        }
                        break;
                    case 5:
                        if (y(obj, i2)) {
                            zzhqVar.e(i3, s0.i(obj, iU & 1048575));
                        }
                        break;
                    case 6:
                        if (y(obj, i2)) {
                            zzhqVar.g(i3, s0.h(obj, iU & 1048575));
                        }
                        break;
                    case 7:
                        if (y(obj, i2)) {
                            zzhqVar.n(i3, s0.B(obj, iU & 1048575));
                        }
                        break;
                    case 8:
                        if (y(obj, i2)) {
                            E(i3, s0.k(obj, iU & 1048575), zzhqVar);
                        }
                        break;
                    case 9:
                        if (y(obj, i2)) {
                            zzhqVar.z(i3, s0.k(obj, iU & 1048575), k(i2));
                        }
                        break;
                    case 10:
                        if (y(obj, i2)) {
                            zzhqVar.H(i3, (zzdb) s0.k(obj, iU & 1048575));
                        }
                        break;
                    case 11:
                        if (y(obj, i2)) {
                            zzhqVar.G(i3, s0.h(obj, iU & 1048575));
                        }
                        break;
                    case 12:
                        if (y(obj, i2)) {
                            zzhqVar.c(i3, s0.h(obj, iU & 1048575));
                        }
                        break;
                    case 13:
                        if (y(obj, i2)) {
                            zzhqVar.r(i3, s0.h(obj, iU & 1048575));
                        }
                        break;
                    case 14:
                        if (y(obj, i2)) {
                            zzhqVar.u(i3, s0.i(obj, iU & 1048575));
                        }
                        break;
                    case 15:
                        if (y(obj, i2)) {
                            zzhqVar.x(i3, s0.h(obj, iU & 1048575));
                        }
                        break;
                    case 16:
                        if (y(obj, i2)) {
                            zzhqVar.A(i3, s0.i(obj, iU & 1048575));
                        }
                        break;
                    case 17:
                        if (y(obj, i2)) {
                            zzhqVar.C(i3, s0.k(obj, iU & 1048575), k(i2));
                        }
                        break;
                    case 18:
                        m0.g(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 19:
                        m0.k(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 20:
                        m0.n(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 21:
                        m0.v(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 22:
                        m0.m(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 23:
                        m0.j(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 24:
                        m0.i(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 25:
                        m0.e(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 26:
                        m0.t(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar);
                        break;
                    case 27:
                        m0.o(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, k(i2));
                        break;
                    case 28:
                        m0.f(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar);
                        break;
                    case 29:
                        m0.u(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 30:
                        m0.h(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 31:
                        m0.p(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 32:
                        m0.q(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 33:
                        m0.r(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 34:
                        m0.s(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, false);
                        break;
                    case 35:
                        m0.g(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 36:
                        m0.k(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 37:
                        m0.n(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 38:
                        m0.v(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 39:
                        m0.m(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 40:
                        m0.j(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 41:
                        m0.i(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 42:
                        m0.e(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 43:
                        m0.u(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 44:
                        m0.h(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 45:
                        m0.p(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 46:
                        m0.q(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 47:
                        m0.r(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 48:
                        m0.s(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, true);
                        break;
                    case 49:
                        m0.l(this.f5797a[i2], (List) s0.k(obj, iU & 1048575), zzhqVar, k(i2));
                        break;
                    case 50:
                        w(zzhqVar, i3, s0.k(obj, iU & 1048575), i2);
                        break;
                    case 51:
                        if (C(obj, i3, i2)) {
                            zzhqVar.a(i3, I(obj, iU & 1048575));
                        }
                        break;
                    case 52:
                        if (C(obj, i3, i2)) {
                            zzhqVar.i(i3, J(obj, iU & 1048575));
                        }
                        break;
                    case 53:
                        if (C(obj, i3, i2)) {
                            zzhqVar.m(i3, V(obj, iU & 1048575));
                        }
                        break;
                    case 54:
                        if (C(obj, i3, i2)) {
                            zzhqVar.F(i3, V(obj, iU & 1048575));
                        }
                        break;
                    case 55:
                        if (C(obj, i3, i2)) {
                            zzhqVar.k(i3, L(obj, iU & 1048575));
                        }
                        break;
                    case 56:
                        if (C(obj, i3, i2)) {
                            zzhqVar.e(i3, V(obj, iU & 1048575));
                        }
                        break;
                    case 57:
                        if (C(obj, i3, i2)) {
                            zzhqVar.g(i3, L(obj, iU & 1048575));
                        }
                        break;
                    case 58:
                        if (C(obj, i3, i2)) {
                            zzhqVar.n(i3, D(obj, iU & 1048575));
                        }
                        break;
                    case 59:
                        if (C(obj, i3, i2)) {
                            E(i3, s0.k(obj, iU & 1048575), zzhqVar);
                        }
                        break;
                    case 60:
                        if (C(obj, i3, i2)) {
                            zzhqVar.z(i3, s0.k(obj, iU & 1048575), k(i2));
                        }
                        break;
                    case 61:
                        if (C(obj, i3, i2)) {
                            zzhqVar.H(i3, (zzdb) s0.k(obj, iU & 1048575));
                        }
                        break;
                    case 62:
                        if (C(obj, i3, i2)) {
                            zzhqVar.G(i3, L(obj, iU & 1048575));
                        }
                        break;
                    case 63:
                        if (C(obj, i3, i2)) {
                            zzhqVar.c(i3, L(obj, iU & 1048575));
                        }
                        break;
                    case 64:
                        if (C(obj, i3, i2)) {
                            zzhqVar.r(i3, L(obj, iU & 1048575));
                        }
                        break;
                    case 65:
                        if (C(obj, i3, i2)) {
                            zzhqVar.u(i3, V(obj, iU & 1048575));
                        }
                        break;
                    case 66:
                        if (C(obj, i3, i2)) {
                            zzhqVar.x(i3, L(obj, iU & 1048575));
                        }
                        break;
                    case 67:
                        if (C(obj, i3, i2)) {
                            zzhqVar.A(i3, V(obj, iU & 1048575));
                        }
                        break;
                    case 68:
                        if (C(obj, i3, i2)) {
                            zzhqVar.C(i3, s0.k(obj, iU & 1048575), k(i2));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.f5790a.f(zzhqVar, entry2);
                entry2 = itF2.hasNext() ? (Map.Entry) itF2.next() : null;
            }
            zzgy zzgyVar = this.f5793a;
            zzgyVar.j(zzgyVar.d(obj), zzhqVar);
            return;
        }
        if (this.f5796a) {
            bkc bkcVarB2 = this.f5790a.b(obj);
            if (bkcVarB2.f15553a.isEmpty()) {
                itF = null;
                entry = null;
            } else {
                itF = bkcVarB2.f();
                entry = (Map.Entry) itF.next();
            }
        } else {
            itF = null;
            entry = null;
        }
        int length2 = this.f5797a.length;
        Unsafe unsafe = f31374a;
        int i4 = 0;
        int i5 = 1048575;
        for (int i6 = 0; i6 < length2; i6 += 3) {
            int iU2 = U(i6);
            int[] iArr = this.f5797a;
            int i7 = iArr[i6];
            int iT = T(iU2);
            if (iT <= 17) {
                int i8 = iArr[i6 + 2];
                int i9 = i8 & 1048575;
                if (i9 != i5) {
                    i4 = unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = 1 << (i8 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.f5790a.a(entry) <= i7) {
                this.f5790a.f(zzhqVar, entry);
                entry = itF.hasNext() ? (Map.Entry) itF.next() : null;
            }
            long j = iU2 & 1048575;
            switch (iT) {
                case 0:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.a(i7, s0.f(obj, j));
                    }
                    break;
                case 1:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.i(i7, s0.g(obj, j));
                    }
                    break;
                case 2:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.m(i7, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.F(i7, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.k(i7, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.e(i7, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.g(i7, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.n(i7, s0.B(obj, j));
                    }
                    break;
                case 8:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        E(i7, unsafe.getObject(obj, j), zzhqVar);
                    }
                    break;
                case 9:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.z(i7, unsafe.getObject(obj, j), k(i6));
                    }
                    break;
                case 10:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.H(i7, (zzdb) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.G(i7, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.c(i7, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.r(i7, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.u(i7, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.x(i7, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.A(i7, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    z = true;
                    z2 = false;
                    if ((i & i4) != 0) {
                        zzhqVar.C(i7, unsafe.getObject(obj, j), k(i6));
                    }
                    break;
                case 18:
                    z3 = false;
                    z = true;
                    m0.g(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 19:
                    z3 = false;
                    z = true;
                    m0.k(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 20:
                    z3 = false;
                    z = true;
                    m0.n(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 21:
                    z3 = false;
                    z = true;
                    m0.v(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 22:
                    z3 = false;
                    z = true;
                    m0.m(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 23:
                    z3 = false;
                    z = true;
                    m0.j(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 24:
                    z3 = false;
                    z = true;
                    m0.i(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 25:
                    z = true;
                    int i10 = this.f5797a[i6];
                    List list = (List) unsafe.getObject(obj, j);
                    z4 = false;
                    m0.e(i10, list, zzhqVar, false);
                    z2 = z4;
                    break;
                case 26:
                    z = true;
                    m0.t(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar);
                    z2 = false;
                    break;
                case 27:
                    z = true;
                    m0.o(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, k(i6));
                    z2 = false;
                    break;
                case 28:
                    z = true;
                    m0.f(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar);
                    z2 = false;
                    break;
                case 29:
                    z3 = false;
                    z = true;
                    m0.u(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 30:
                    z3 = false;
                    z = true;
                    m0.h(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 31:
                    z3 = false;
                    z = true;
                    m0.p(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 32:
                    z3 = false;
                    z = true;
                    m0.q(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 33:
                    z3 = false;
                    z = true;
                    m0.r(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, false);
                    z2 = z3;
                    break;
                case 34:
                    z = true;
                    int i11 = this.f5797a[i6];
                    List list2 = (List) unsafe.getObject(obj, j);
                    z4 = false;
                    m0.s(i11, list2, zzhqVar, false);
                    z2 = z4;
                    break;
                case 35:
                    z = true;
                    m0.g(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 36:
                    z = true;
                    m0.k(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 37:
                    z = true;
                    m0.n(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 38:
                    z = true;
                    m0.v(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 39:
                    z = true;
                    m0.m(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 40:
                    z = true;
                    m0.j(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 41:
                    z = true;
                    m0.i(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 42:
                    z = true;
                    m0.e(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 43:
                    z = true;
                    m0.u(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 44:
                    z = true;
                    m0.h(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 45:
                    z = true;
                    m0.p(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 46:
                    z = true;
                    m0.q(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 47:
                    z = true;
                    m0.r(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 48:
                    z = true;
                    m0.s(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, true);
                    z2 = false;
                    break;
                case 49:
                    m0.l(this.f5797a[i6], (List) unsafe.getObject(obj, j), zzhqVar, k(i6));
                    z = true;
                    z2 = false;
                    break;
                case 50:
                    w(zzhqVar, i7, unsafe.getObject(obj, j), i6);
                    z = true;
                    z2 = false;
                    break;
                case 51:
                    if (C(obj, i7, i6)) {
                        zzhqVar.a(i7, I(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 52:
                    if (C(obj, i7, i6)) {
                        zzhqVar.i(i7, J(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 53:
                    if (C(obj, i7, i6)) {
                        zzhqVar.m(i7, V(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 54:
                    if (C(obj, i7, i6)) {
                        zzhqVar.F(i7, V(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 55:
                    if (C(obj, i7, i6)) {
                        zzhqVar.k(i7, L(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 56:
                    if (C(obj, i7, i6)) {
                        zzhqVar.e(i7, V(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 57:
                    if (C(obj, i7, i6)) {
                        zzhqVar.g(i7, L(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 58:
                    if (C(obj, i7, i6)) {
                        zzhqVar.n(i7, D(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 59:
                    if (C(obj, i7, i6)) {
                        E(i7, unsafe.getObject(obj, j), zzhqVar);
                    }
                    z = true;
                    z2 = false;
                    break;
                case 60:
                    if (C(obj, i7, i6)) {
                        zzhqVar.z(i7, unsafe.getObject(obj, j), k(i6));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 61:
                    if (C(obj, i7, i6)) {
                        zzhqVar.H(i7, (zzdb) unsafe.getObject(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 62:
                    if (C(obj, i7, i6)) {
                        zzhqVar.G(i7, L(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 63:
                    if (C(obj, i7, i6)) {
                        zzhqVar.c(i7, L(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 64:
                    if (C(obj, i7, i6)) {
                        zzhqVar.r(i7, L(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 65:
                    if (C(obj, i7, i6)) {
                        zzhqVar.u(i7, V(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 66:
                    if (C(obj, i7, i6)) {
                        zzhqVar.x(i7, L(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 67:
                    if (C(obj, i7, i6)) {
                        zzhqVar.A(i7, V(obj, j));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 68:
                    if (C(obj, i7, i6)) {
                        zzhqVar.C(i7, unsafe.getObject(obj, j), k(i6));
                    }
                    z = true;
                    z2 = false;
                    break;
                default:
                    z = true;
                    z2 = false;
                    break;
            }
        }
        while (entry != null) {
            this.f5790a.f(zzhqVar, entry);
            entry = itF.hasNext() ? (Map.Entry) itF.next() : null;
        }
        zzgy zzgyVar2 = this.f5793a;
        zzgyVar2.j(zzgyVar2.d(obj), zzhqVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x007f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void b(Object obj) {
        if (B(obj)) {
            if (obj instanceof zzed) {
                zzed zzedVar = (zzed) obj;
                zzedVar.p(Integer.MAX_VALUE);
                zzedVar.zzb = 0;
                zzedVar.o();
            }
            int length = this.f5797a.length;
            for (int i = 0; i < length; i += 3) {
                int iU = U(i);
                int i2 = 1048575 & iU;
                int iT = T(iU);
                long j = i2;
                if (iT != 9) {
                    if (iT != 60 && iT != 68) {
                        switch (iT) {
                            case 17:
                                if (y(obj, i)) {
                                    k(i).b(f31374a.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f5791a.a(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = f31374a;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfi) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (C(obj, this.f5797a[i], i)) {
                        k(i).b(f31374a.getObject(obj, j));
                    }
                } else if (y(obj, i)) {
                    k(i).b(f31374a.getObject(obj, j));
                }
            }
            this.f5793a.g(obj);
            if (this.f5796a) {
                this.f5790a.e(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean c(Object obj, Object obj2) {
        boolean zW;
        int length = this.f5797a.length;
        for (int i = 0; i < length; i += 3) {
            int iU = U(i);
            long j = iU & 1048575;
            switch (T(iU)) {
                case 0:
                    if (!x(obj, obj2, i) || Double.doubleToLongBits(s0.f(obj, j)) != Double.doubleToLongBits(s0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!x(obj, obj2, i) || Float.floatToIntBits(s0.g(obj, j)) != Float.floatToIntBits(s0.g(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!x(obj, obj2, i) || s0.i(obj, j) != s0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!x(obj, obj2, i) || s0.i(obj, j) != s0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!x(obj, obj2, i) || s0.h(obj, j) != s0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!x(obj, obj2, i) || s0.i(obj, j) != s0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!x(obj, obj2, i) || s0.h(obj, j) != s0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!x(obj, obj2, i) || s0.B(obj, j) != s0.B(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!x(obj, obj2, i) || !m0.w(s0.k(obj, j), s0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!x(obj, obj2, i) || !m0.w(s0.k(obj, j), s0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!x(obj, obj2, i) || !m0.w(s0.k(obj, j), s0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!x(obj, obj2, i) || s0.h(obj, j) != s0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!x(obj, obj2, i) || s0.h(obj, j) != s0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!x(obj, obj2, i) || s0.h(obj, j) != s0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!x(obj, obj2, i) || s0.i(obj, j) != s0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!x(obj, obj2, i) || s0.h(obj, j) != s0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!x(obj, obj2, i) || s0.i(obj, j) != s0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!x(obj, obj2, i) || !m0.w(s0.k(obj, j), s0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zW = m0.w(s0.k(obj, j), s0.k(obj2, j));
                    break;
                case 50:
                    zW = m0.w(s0.k(obj, j), s0.k(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jR = R(i) & 1048575;
                    if (s0.h(obj, jR) != s0.h(obj2, jR) || !m0.w(s0.k(obj, j), s0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zW) {
                return false;
            }
        }
        if (!this.f5793a.d(obj).equals(this.f5793a.d(obj2))) {
            return false;
        }
        if (this.f5796a) {
            return this.f5790a.b(obj).equals(this.f5790a.b(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void d(Object obj, Object obj2) {
        p(obj);
        obj2.getClass();
        for (int i = 0; i < this.f5797a.length; i += 3) {
            int iU = U(i);
            int i2 = this.f5797a[i];
            long j = 1048575 & iU;
            switch (T(iU)) {
                case 0:
                    if (y(obj2, i)) {
                        s0.t(obj, j, s0.f(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 1:
                    if (y(obj2, i)) {
                        s0.u(obj, j, s0.g(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 2:
                    if (y(obj2, i)) {
                        s0.w(obj, j, s0.i(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 3:
                    if (y(obj2, i)) {
                        s0.w(obj, j, s0.i(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 4:
                    if (y(obj2, i)) {
                        s0.v(obj, j, s0.h(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 5:
                    if (y(obj2, i)) {
                        s0.w(obj, j, s0.i(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 6:
                    if (y(obj2, i)) {
                        s0.v(obj, j, s0.h(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 7:
                    if (y(obj2, i)) {
                        s0.r(obj, j, s0.B(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 8:
                    if (y(obj2, i)) {
                        s0.x(obj, j, s0.k(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 9:
                    q(obj, obj2, i);
                    break;
                case 10:
                    if (y(obj2, i)) {
                        s0.x(obj, j, s0.k(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 11:
                    if (y(obj2, i)) {
                        s0.v(obj, j, s0.h(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 12:
                    if (y(obj2, i)) {
                        s0.v(obj, j, s0.h(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 13:
                    if (y(obj2, i)) {
                        s0.v(obj, j, s0.h(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 14:
                    if (y(obj2, i)) {
                        s0.w(obj, j, s0.i(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 15:
                    if (y(obj2, i)) {
                        s0.v(obj, j, s0.h(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 16:
                    if (y(obj2, i)) {
                        s0.w(obj, j, s0.i(obj2, j));
                        s(obj, i);
                    }
                    break;
                case 17:
                    q(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f5791a.b(obj, obj2, j);
                    break;
                case 50:
                    int i3 = m0.f31387a;
                    s0.x(obj, j, qpc.b(s0.k(obj, j), s0.k(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (C(obj2, i2, i)) {
                        s0.x(obj, j, s0.k(obj2, j));
                        t(obj, i2, i);
                    }
                    break;
                case 60:
                    r(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (C(obj2, i2, i)) {
                        s0.x(obj, j, s0.k(obj2, j));
                        t(obj, i2, i);
                    }
                    break;
                case 68:
                    r(obj, obj2, i);
                    break;
            }
        }
        m0.c(this.f5793a, obj, obj2);
        if (this.f5796a) {
            m0.b(this.f5790a, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final Object e() {
        return ((zzed) this.f5792a).m();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int f(Object obj) {
        int iA;
        int iA2;
        int iB;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iK;
        int iA7;
        int iB2;
        int iA8;
        int iA9;
        zzho zzhoVar = zzho.zza;
        if (this.e - 1 == 0) {
            return K(obj);
        }
        Unsafe unsafe = f31374a;
        int i = 0;
        for (int i2 = 0; i2 < this.f5797a.length; i2 += 3) {
            int iU = U(i2);
            int iT = T(iU);
            int i3 = this.f5797a[i2];
            int i4 = iU & 1048575;
            if (iT >= zzdu.zzJ.zza() && iT <= zzdu.zzW.zza()) {
                int i5 = this.f5797a[i2 + 2];
            }
            long j = i4;
            switch (iT) {
                case 0:
                    if (y(obj, i2)) {
                        iA = zzdj.A(i3 << 3);
                        iK = iA + 8;
                        i += iK;
                    }
                    break;
                case 1:
                    if (y(obj, i2)) {
                        iA2 = zzdj.A(i3 << 3);
                        iK = iA2 + 4;
                        i += iK;
                    }
                    break;
                case 2:
                    if (y(obj, i2)) {
                        iB = zzdj.B(s0.i(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 3:
                    if (y(obj, i2)) {
                        iB = zzdj.B(s0.i(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 4:
                    if (y(obj, i2)) {
                        iB = zzdj.w(s0.h(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 5:
                    if (y(obj, i2)) {
                        iA = zzdj.A(i3 << 3);
                        iK = iA + 8;
                        i += iK;
                    }
                    break;
                case 6:
                    if (y(obj, i2)) {
                        iA2 = zzdj.A(i3 << 3);
                        iK = iA2 + 4;
                        i += iK;
                    }
                    break;
                case 7:
                    if (y(obj, i2)) {
                        iA4 = zzdj.A(i3 << 3);
                        iK = iA4 + 1;
                        i += iK;
                    }
                    break;
                case 8:
                    if (y(obj, i2)) {
                        Object objK = s0.k(obj, j);
                        if (objK instanceof zzdb) {
                            int i6 = i3 << 3;
                            int i7 = zzdj.f31401a;
                            int iZzd = ((zzdb) objK).zzd();
                            iA5 = zzdj.A(iZzd) + iZzd;
                            iA6 = zzdj.A(i6);
                            iK = iA6 + iA5;
                            i += iK;
                        } else {
                            iB = zzdj.z((String) objK);
                            iA3 = zzdj.A(i3 << 3);
                            i += iA3 + iB;
                        }
                    }
                    break;
                case 9:
                    if (y(obj, i2)) {
                        iK = m0.K(i3, s0.k(obj, j), k(i2));
                        i += iK;
                    }
                    break;
                case 10:
                    if (y(obj, i2)) {
                        zzdb zzdbVar = (zzdb) s0.k(obj, j);
                        int i8 = i3 << 3;
                        int i9 = zzdj.f31401a;
                        int iZzd2 = zzdbVar.zzd();
                        iA5 = zzdj.A(iZzd2) + iZzd2;
                        iA6 = zzdj.A(i8);
                        iK = iA6 + iA5;
                        i += iK;
                    }
                    break;
                case 11:
                    if (y(obj, i2)) {
                        iB = zzdj.A(s0.h(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 12:
                    if (y(obj, i2)) {
                        iB = zzdj.w(s0.h(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 13:
                    if (y(obj, i2)) {
                        iA2 = zzdj.A(i3 << 3);
                        iK = iA2 + 4;
                        i += iK;
                    }
                    break;
                case 14:
                    if (y(obj, i2)) {
                        iA = zzdj.A(i3 << 3);
                        iK = iA + 8;
                        i += iK;
                    }
                    break;
                case 15:
                    if (y(obj, i2)) {
                        int iH = s0.h(obj, j);
                        iA3 = zzdj.A(i3 << 3);
                        iB = zzdj.A((iH >> 31) ^ (iH + iH));
                        i += iA3 + iB;
                    }
                    break;
                case 16:
                    if (y(obj, i2)) {
                        long jI = s0.i(obj, j);
                        iA7 = zzdj.A(i3 << 3);
                        iB2 = zzdj.B((jI + jI) ^ (jI >> 63));
                        iK = iA7 + iB2;
                        i += iK;
                    }
                    break;
                case 17:
                    if (y(obj, i2)) {
                        iK = zzdj.v(i3, (zzfo) s0.k(obj, j), k(i2));
                        i += iK;
                    }
                    break;
                case 18:
                    iK = m0.D(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 19:
                    iK = m0.B(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 20:
                    iK = m0.I(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 21:
                    iK = m0.T(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 22:
                    iK = m0.G(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 23:
                    iK = m0.D(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 24:
                    iK = m0.B(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 25:
                    iK = m0.x(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 26:
                    iK = m0.Q(i3, (List) s0.k(obj, j));
                    i += iK;
                    break;
                case 27:
                    iK = m0.L(i3, (List) s0.k(obj, j), k(i2));
                    i += iK;
                    break;
                case 28:
                    iK = m0.y(i3, (List) s0.k(obj, j));
                    i += iK;
                    break;
                case 29:
                    iK = m0.R(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 30:
                    iK = m0.z(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 31:
                    iK = m0.B(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 32:
                    iK = m0.D(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 33:
                    iK = m0.M(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 34:
                    iK = m0.O(i3, (List) s0.k(obj, j), false);
                    i += iK;
                    break;
                case 35:
                    iB = m0.E((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i10 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i10);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 36:
                    iB = m0.C((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i11 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i11);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 37:
                    iB = m0.J((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i12 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i12);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 38:
                    iB = m0.U((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i13 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i13);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 39:
                    iB = m0.H((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i14 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i14);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 40:
                    iB = m0.E((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i15 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i15);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 41:
                    iB = m0.C((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i16 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i16);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i17 = m0.f31387a;
                    iB = list.size();
                    if (iB > 0) {
                        int i18 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i18);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 43:
                    iB = m0.S((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i19 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i19);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 44:
                    iB = m0.A((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i20 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i20);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 45:
                    iB = m0.C((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i21 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i21);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 46:
                    iB = m0.E((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i22 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i22);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 47:
                    iB = m0.N((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i23 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i23);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 48:
                    iB = m0.P((List) unsafe.getObject(obj, j));
                    if (iB > 0) {
                        int i24 = i3 << 3;
                        iA8 = zzdj.A(iB);
                        iA9 = zzdj.A(i24);
                        iA3 = iA9 + iA8;
                        i += iA3 + iB;
                    }
                    break;
                case 49:
                    iK = m0.F(i3, (List) s0.k(obj, j), k(i2));
                    i += iK;
                    break;
                case 50:
                    qpc.a(i3, s0.k(obj, j), l(i2));
                    break;
                case 51:
                    if (C(obj, i3, i2)) {
                        iA = zzdj.A(i3 << 3);
                        iK = iA + 8;
                        i += iK;
                    }
                    break;
                case 52:
                    if (C(obj, i3, i2)) {
                        iA2 = zzdj.A(i3 << 3);
                        iK = iA2 + 4;
                        i += iK;
                    }
                    break;
                case 53:
                    if (C(obj, i3, i2)) {
                        iB = zzdj.B(V(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 54:
                    if (C(obj, i3, i2)) {
                        iB = zzdj.B(V(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 55:
                    if (C(obj, i3, i2)) {
                        iB = zzdj.w(L(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 56:
                    if (C(obj, i3, i2)) {
                        iA = zzdj.A(i3 << 3);
                        iK = iA + 8;
                        i += iK;
                    }
                    break;
                case 57:
                    if (C(obj, i3, i2)) {
                        iA2 = zzdj.A(i3 << 3);
                        iK = iA2 + 4;
                        i += iK;
                    }
                    break;
                case 58:
                    if (C(obj, i3, i2)) {
                        iA4 = zzdj.A(i3 << 3);
                        iK = iA4 + 1;
                        i += iK;
                    }
                    break;
                case 59:
                    if (C(obj, i3, i2)) {
                        Object objK2 = s0.k(obj, j);
                        if (objK2 instanceof zzdb) {
                            int i25 = i3 << 3;
                            int i26 = zzdj.f31401a;
                            int iZzd3 = ((zzdb) objK2).zzd();
                            iA5 = zzdj.A(iZzd3) + iZzd3;
                            iA6 = zzdj.A(i25);
                            iK = iA6 + iA5;
                            i += iK;
                        } else {
                            iB = zzdj.z((String) objK2);
                            iA3 = zzdj.A(i3 << 3);
                            i += iA3 + iB;
                        }
                    }
                    break;
                case 60:
                    if (C(obj, i3, i2)) {
                        iK = m0.K(i3, s0.k(obj, j), k(i2));
                        i += iK;
                    }
                    break;
                case 61:
                    if (C(obj, i3, i2)) {
                        zzdb zzdbVar2 = (zzdb) s0.k(obj, j);
                        int i27 = i3 << 3;
                        int i28 = zzdj.f31401a;
                        int iZzd4 = zzdbVar2.zzd();
                        iA5 = zzdj.A(iZzd4) + iZzd4;
                        iA6 = zzdj.A(i27);
                        iK = iA6 + iA5;
                        i += iK;
                    }
                    break;
                case 62:
                    if (C(obj, i3, i2)) {
                        iB = zzdj.A(L(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 63:
                    if (C(obj, i3, i2)) {
                        iB = zzdj.w(L(obj, j));
                        iA3 = zzdj.A(i3 << 3);
                        i += iA3 + iB;
                    }
                    break;
                case 64:
                    if (C(obj, i3, i2)) {
                        iA2 = zzdj.A(i3 << 3);
                        iK = iA2 + 4;
                        i += iK;
                    }
                    break;
                case 65:
                    if (C(obj, i3, i2)) {
                        iA = zzdj.A(i3 << 3);
                        iK = iA + 8;
                        i += iK;
                    }
                    break;
                case 66:
                    if (C(obj, i3, i2)) {
                        int iL = L(obj, j);
                        iA3 = zzdj.A(i3 << 3);
                        iB = zzdj.A((iL >> 31) ^ (iL + iL));
                        i += iA3 + iB;
                    }
                    break;
                case 67:
                    if (C(obj, i3, i2)) {
                        long jV = V(obj, j);
                        iA7 = zzdj.A(i3 << 3);
                        iB2 = zzdj.B((jV + jV) ^ (jV >> 63));
                        iK = iA7 + iB2;
                        i += iK;
                    }
                    break;
                case 68:
                    if (C(obj, i3, i2)) {
                        iK = zzdj.v(i3, (zzfo) s0.k(obj, j), k(i2));
                        i += iK;
                    }
                    break;
            }
        }
        zzgy zzgyVar = this.f5793a;
        return i + zzgyVar.a(zzgyVar.d(obj));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int g(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.f5797a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iU = U(i3);
            int i4 = this.f5797a[i3];
            long j = 1048575 & iU;
            int iHashCode = 37;
            switch (T(iU)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(s0.f(obj, j));
                    byte[] bArr = rmc.f19385a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(s0.g(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = s0.i(obj, j);
                    byte[] bArr2 = rmc.f19385a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = s0.i(obj, j);
                    byte[] bArr3 = rmc.f19385a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = s0.h(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = s0.i(obj, j);
                    byte[] bArr4 = rmc.f19385a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = s0.h(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = rmc.a(s0.B(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) s0.k(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objK = s0.k(obj, j);
                    if (objK != null) {
                        iHashCode = objK.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = s0.k(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = s0.h(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = s0.h(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = s0.h(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = s0.i(obj, j);
                    byte[] bArr5 = rmc.f19385a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = s0.h(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = s0.i(obj, j);
                    byte[] bArr6 = rmc.f19385a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objK2 = s0.k(obj, j);
                    if (objK2 != null) {
                        iHashCode = objK2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iFloatToIntBits = s0.k(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = s0.k(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(I(obj, j));
                        byte[] bArr7 = rmc.f19385a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(J(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = V(obj, j);
                        byte[] bArr8 = rmc.f19385a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = V(obj, j);
                        byte[] bArr9 = rmc.f19385a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = L(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = V(obj, j);
                        byte[] bArr10 = rmc.f19385a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = L(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = rmc.a(D(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) s0.k(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = s0.k(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = s0.k(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = L(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = L(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = L(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = V(obj, j);
                        byte[] bArr11 = rmc.f19385a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = L(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = V(obj, j);
                        byte[] bArr12 = rmc.f19385a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (C(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = s0.k(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.f5793a.d(obj).hashCode();
        return this.f5796a ? (iHashCode2 * 53) + this.f5790a.b(obj).f15553a.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean h(Object obj) {
        int i;
        int i2;
        List list;
        zzgh zzghVarK;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.f5800c) {
            int i7 = this.f5799b[i5];
            int i8 = this.f5797a[i7];
            int iU = U(i7);
            int i9 = this.f5797a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = f31374a.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iU) != 0 && !z(obj, i7, i, i2, i11)) {
                return false;
            }
            int iT = T(iU);
            if (iT == 9 || iT == 17) {
                if (z(obj, i7, i, i2, i11) && !A(obj, iU, k(i7))) {
                    return false;
                }
            } else if (iT == 27) {
                list = (List) s0.k(obj, iU & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzghVarK = k(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzghVarK.h(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iT == 60 || iT == 68) {
                if (C(obj, i8, i7) && !A(obj, iU, k(i7))) {
                    return false;
                }
            } else if (iT == 49) {
                list = (List) s0.k(obj, iU & 1048575);
                if (list.isEmpty()) {
                    zzghVarK = k(i7);
                    while (i3 < list.size()) {
                        if (!zzghVarK.h(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iT == 50 && !((zzfi) s0.k(obj, iU & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.f5796a || this.f5790a.b(obj).k();
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0296 A[PHI: r0 r18 r25 r26 r27
      0x0296: PHI (r0v61 int) = (r0v56 int), (r0v59 int), (r0v63 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x0296: PHI (r18v5 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x0296: PHI (r25v3 int) = (r25v1 int), (r25v1 int), (r25v4 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x0296: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x0296: PHI (r27v7 sun.misc.Unsafe) = (r27v5 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x02ac A[PHI: r0 r18 r25 r26 r27
      0x02ac: PHI (r0v60 int) = (r0v56 int), (r0v59 int), (r0v63 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x02ac: PHI (r18v4 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x02ac: PHI (r25v2 int) = (r25v1 int), (r25v1 int), (r25v4 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x02ac: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x02ac: PHI (r27v6 sun.misc.Unsafe) = (r27v5 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x008d. Please report as an issue. */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void i(Object obj, byte[] bArr, int i, int i2, kgc kgcVar) throws IOException {
        int i3;
        int iK;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        kgcVar = kgcVar;
        zzho zzhoVar = zzho.zza;
        int i13 = -1;
        if (this.e - 1 == 0) {
            F(obj, bArr, i, i2, 0, kgcVar);
            return;
        }
        p(obj);
        Unsafe unsafe2 = f31374a;
        int i14 = 1048575;
        int i15 = i;
        int i16 = 1048575;
        int i17 = -1;
        int i18 = 0;
        int i19 = 0;
        while (i15 < i2) {
            int i20 = i15 + 1;
            byte b = bArr[i15];
            if (b < 0) {
                iK = h.k(b, bArr, i20, kgcVar);
                i3 = kgcVar.f42815a;
            } else {
                i3 = b;
                iK = i20;
            }
            int i21 = i3 >>> 3;
            int iQ = i21 > i17 ? this.Q(i21, i18 / 3) : this.P(i21);
            if (iQ == i13) {
                i4 = iK;
                i5 = i21;
                i6 = i13;
                unsafe = unsafe2;
                i7 = 0;
            } else {
                int i22 = i3 & 7;
                int[] iArr = this.f5797a;
                int i23 = iArr[iQ + 1];
                int iT = T(i23);
                long j = i23 & i14;
                if (iT <= 17) {
                    int i24 = iArr[iQ + 2];
                    int i25 = 1 << (i24 >>> 20);
                    int i26 = 1048575;
                    int i27 = i24 & 1048575;
                    if (i27 != i16) {
                        if (i16 != 1048575) {
                            unsafe2.putInt(obj, i16, i19);
                        }
                        if (i27 != 1048575) {
                            i19 = unsafe2.getInt(obj, i27);
                        }
                        i16 = i27;
                    }
                    switch (iT) {
                        case 0:
                            i8 = iQ;
                            i5 = i21;
                            i9 = iK;
                            if (i22 != 1) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                s0.t(obj, j, Double.longBitsToDouble(h.q(bArr, i9)));
                                i15 = i9 + 8;
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 1:
                            i8 = iQ;
                            i5 = i21;
                            i9 = iK;
                            if (i22 != 5) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                s0.u(obj, j, Float.intBitsToFloat(h.b(bArr, i9)));
                                i15 = i9 + 4;
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 2:
                        case 3:
                            i26 = 1048575;
                            i8 = iQ;
                            i5 = i21;
                            i9 = iK;
                            if (i22 != 0) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                int iM = h.m(bArr, i9, kgcVar);
                                unsafe2.putLong(obj, j, kgcVar.f17676a);
                                i19 |= i25;
                                i18 = i8;
                                i15 = iM;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i8 = iQ;
                            i5 = i21;
                            i9 = iK;
                            if (i22 != 0) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                i15 = h.j(bArr, i9, kgcVar);
                                unsafe2.putInt(obj, j, kgcVar.f42815a);
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 5:
                        case 14:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 1) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                unsafe2.putLong(obj, j, h.q(bArr, iK));
                                i15 = iK + 8;
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 6:
                        case 13:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 5) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                unsafe2.putInt(obj, j, h.b(bArr, iK));
                                i15 = iK + 4;
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 7:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 0) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                i15 = h.m(bArr, iK, kgcVar);
                                s0.r(obj, j, kgcVar.f17676a != 0);
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 8:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 2) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                i15 = (i23 & 536870912) == 0 ? h.g(bArr, iK, kgcVar) : h.h(bArr, iK, kgcVar);
                                unsafe2.putObject(obj, j, kgcVar.f17678a);
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 9:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 2) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                Object objM = this.m(obj, i8);
                                i15 = h.o(objM, this.k(i8), bArr, iK, i2, kgcVar);
                                this.u(obj, i8, objM);
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 10:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 2) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                i15 = h.a(bArr, iK, kgcVar);
                                unsafe2.putObject(obj, j, kgcVar.f17678a);
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 12:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 0) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                i15 = h.j(bArr, iK, kgcVar);
                                unsafe2.putInt(obj, j, kgcVar.f42815a);
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 15:
                            i8 = iQ;
                            i5 = i21;
                            if (i22 != 0) {
                                i9 = iK;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                i15 = h.j(bArr, iK, kgcVar);
                                unsafe2.putInt(obj, j, ric.a(kgcVar.f42815a));
                                i19 |= i25;
                                i18 = i8;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 16:
                            if (i22 != 0) {
                                i5 = i21;
                                i9 = iK;
                                i8 = iQ;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                int iM2 = h.m(bArr, iK, kgcVar);
                                i5 = i21;
                                i26 = 1048575;
                                unsafe2.putLong(obj, j, ric.b(kgcVar.f17676a));
                                i19 |= i25;
                                i18 = iQ;
                                i15 = iM2;
                                i17 = i5;
                                i14 = i26;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        default:
                            i8 = iQ;
                            i5 = i21;
                            i9 = iK;
                            i4 = i9;
                            unsafe = unsafe2;
                            i7 = i8;
                            i6 = -1;
                            break;
                    }
                } else {
                    i5 = i21;
                    int i28 = iK;
                    if (iT != 27) {
                        i7 = iQ;
                        if (iT <= 49) {
                            i11 = i19;
                            i12 = i16;
                            unsafe = unsafe2;
                            i6 = -1;
                            i15 = O(obj, bArr, i28, i2, i3, i5, i22, i7, i23, iT, j, kgcVar);
                            if (i15 != i28) {
                                i13 = i6;
                                i17 = i5;
                                i18 = i7;
                                i19 = i11;
                                i16 = i12;
                            } else {
                                i4 = i15;
                                i19 = i11;
                                i16 = i12;
                            }
                        } else {
                            i10 = i28;
                            i11 = i19;
                            i12 = i16;
                            unsafe = unsafe2;
                            i6 = -1;
                            if (iT == 50) {
                                if (i22 == 2) {
                                    i15 = M(obj, bArr, i10, i2, i7, j, kgcVar);
                                    if (i15 != i10) {
                                        i13 = i6;
                                        i17 = i5;
                                        i18 = i7;
                                        i19 = i11;
                                        i16 = i12;
                                    } else {
                                        i4 = i15;
                                    }
                                }
                                i19 = i11;
                                i16 = i12;
                            } else {
                                i15 = N(obj, bArr, i10, i2, i3, i5, i22, i23, iT, j, i7, kgcVar);
                                if (i15 != i10) {
                                    i13 = i6;
                                    i17 = i5;
                                    i18 = i7;
                                    i19 = i11;
                                    i16 = i12;
                                } else {
                                    i4 = i15;
                                    i19 = i11;
                                    i16 = i12;
                                }
                            }
                        }
                        unsafe2 = unsafe;
                        i14 = 1048575;
                    } else if (i22 == 2) {
                        zzel zzelVarW = (zzel) unsafe2.getObject(obj, j);
                        if (!zzelVarW.r()) {
                            int size = zzelVarW.size();
                            zzelVarW = zzelVarW.W(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj, j, zzelVarW);
                        }
                        i15 = h.e(this.k(iQ), i3, bArr, i28, i2, zzelVarW, kgcVar);
                        i2 = i2;
                        i19 = i19;
                        i17 = i5;
                        i18 = iQ;
                        i14 = 1048575;
                        i13 = -1;
                    } else {
                        i7 = iQ;
                        i10 = i28;
                        i11 = i19;
                        i12 = i16;
                        unsafe = unsafe2;
                        i6 = -1;
                    }
                    i4 = i10;
                    i19 = i11;
                    i16 = i12;
                }
            }
            i15 = h.i(i3, bArr, i4, i2, G(obj), kgcVar);
            i13 = i6;
            i17 = i5;
            i18 = i7;
            unsafe2 = unsafe;
            i14 = 1048575;
        }
        int i29 = i19;
        Unsafe unsafe3 = unsafe2;
        if (i16 != i14) {
            unsafe3.putInt(obj, i16, i29);
        }
        if (i15 != i2) {
            throw zzeo.zze();
        }
    }

    public final zzeh j(int i) {
        int i2 = i / 3;
        return (zzeh) this.f5798a[i2 + i2 + 1];
    }

    public final zzgh k(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgh zzghVar = (zzgh) this.f5798a[i3];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzghVarB = g0.a().b((Class) this.f5798a[i3 + 1]);
        this.f5798a[i3] = zzghVarB;
        return zzghVarB;
    }

    public final Object l(int i) {
        int i2 = i / 3;
        return this.f5798a[i2 + i2];
    }

    public final Object m(Object obj, int i) {
        zzgh zzghVarK = k(i);
        int iU = U(i) & 1048575;
        if (!y(obj, i)) {
            return zzghVarK.e();
        }
        Object object = f31374a.getObject(obj, iU);
        if (B(object)) {
            return object;
        }
        Object objE = zzghVarK.e();
        if (object != null) {
            zzghVarK.d(objE, object);
        }
        return objE;
    }

    public final Object n(Object obj, int i, int i2) {
        zzgh zzghVarK = k(i2);
        if (!C(obj, i, i2)) {
            return zzghVarK.e();
        }
        Object object = f31374a.getObject(obj, U(i2) & 1048575);
        if (B(object)) {
            return object;
        }
        Object objE = zzghVarK.e();
        if (object != null) {
            zzghVarK.d(objE, object);
        }
        return objE;
    }

    public final void q(Object obj, Object obj2, int i) {
        if (y(obj2, i)) {
            int iU = U(i) & 1048575;
            Unsafe unsafe = f31374a;
            long j = iU;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f5797a[i] + " is present but null: " + obj2.toString());
            }
            zzgh zzghVarK = k(i);
            if (!y(obj, i)) {
                if (B(object)) {
                    Object objE = zzghVarK.e();
                    zzghVarK.d(objE, object);
                    unsafe.putObject(obj, j, objE);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                s(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!B(object2)) {
                Object objE2 = zzghVarK.e();
                zzghVarK.d(objE2, object2);
                unsafe.putObject(obj, j, objE2);
                object2 = objE2;
            }
            zzghVarK.d(object2, object);
        }
    }

    public final void r(Object obj, Object obj2, int i) {
        int i2 = this.f5797a[i];
        if (C(obj2, i2, i)) {
            int iU = U(i) & 1048575;
            Unsafe unsafe = f31374a;
            long j = iU;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f5797a[i] + " is present but null: " + obj2.toString());
            }
            zzgh zzghVarK = k(i);
            if (!C(obj, i2, i)) {
                if (B(object)) {
                    Object objE = zzghVarK.e();
                    zzghVarK.d(objE, object);
                    unsafe.putObject(obj, j, objE);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                t(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!B(object2)) {
                Object objE2 = zzghVarK.e();
                zzghVarK.d(objE2, object2);
                unsafe.putObject(obj, j, objE2);
                object2 = objE2;
            }
            zzghVarK.d(object2, object);
        }
    }

    public final void s(Object obj, int i) {
        int iR = R(i);
        long j = 1048575 & iR;
        if (j == 1048575) {
            return;
        }
        s0.v(obj, j, (1 << (iR >>> 20)) | s0.h(obj, j));
    }

    public final void t(Object obj, int i, int i2) {
        s0.v(obj, R(i2) & 1048575, i);
    }

    public final void u(Object obj, int i, Object obj2) {
        f31374a.putObject(obj, U(i) & 1048575, obj2);
        s(obj, i);
    }

    public final void v(Object obj, int i, int i2, Object obj2) {
        f31374a.putObject(obj, U(i2) & 1048575, obj2);
        t(obj, i, i2);
    }

    public final void w(zzhq zzhqVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    public final boolean x(Object obj, Object obj2, int i) {
        return y(obj, i) == y(obj2, i);
    }

    public final boolean y(Object obj, int i) {
        int iR = R(i);
        long j = iR & 1048575;
        if (j != 1048575) {
            return (s0.h(obj, j) & (1 << (iR >>> 20))) != 0;
        }
        int iU = U(i);
        long j2 = iU & 1048575;
        switch (T(iU)) {
            case 0:
                return Double.doubleToRawLongBits(s0.f(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(s0.g(obj, j2)) != 0;
            case 2:
                return s0.i(obj, j2) != 0;
            case 3:
                return s0.i(obj, j2) != 0;
            case 4:
                return s0.h(obj, j2) != 0;
            case 5:
                return s0.i(obj, j2) != 0;
            case 6:
                return s0.h(obj, j2) != 0;
            case 7:
                return s0.B(obj, j2);
            case 8:
                Object objK = s0.k(obj, j2);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof zzdb) {
                    return !zzdb.zzb.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return s0.k(obj, j2) != null;
            case 10:
                return !zzdb.zzb.equals(s0.k(obj, j2));
            case 11:
                return s0.h(obj, j2) != 0;
            case 12:
                return s0.h(obj, j2) != 0;
            case 13:
                return s0.h(obj, j2) != 0;
            case 14:
                return s0.i(obj, j2) != 0;
            case 15:
                return s0.h(obj, j2) != 0;
            case 16:
                return s0.i(obj, j2) != 0;
            case 17:
                return s0.k(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean z(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return y(obj, i);
        }
        return (i3 & i4) != 0;
    }
}
