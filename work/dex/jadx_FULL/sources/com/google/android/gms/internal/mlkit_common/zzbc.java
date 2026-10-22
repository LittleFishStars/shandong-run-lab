package com.google.android.gms.internal.mlkit_common;

import com.zj.adlib.b9c;
import com.zj.adlib.i9c;
import com.zj.adlib.jac;
import com.zj.adlib.r8c;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzbc extends zzau {
    static final zzau zza = new zzbc(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzbc(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Code duplicated, block: B:75:0x01a6 A[PHI: r5
      0x01a6: PHI (r5v5 ??) = (r5v2 ??), (r5v6 short[]) binds: [B:74:0x01a4, B:57:0x0138] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static zzbc zzg(int i, Object[] objArr, b bVar) {
        int iHighestOneBit;
        short[] sArr;
        char c;
        char c2;
        ?? r3;
        ?? r4;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzbc) zza;
        }
        jac jacVar = null;
        ?? r5 = 0;
        jac jacVar2 = null;
        jac jacVar3 = null;
        int i3 = 1;
        if (i2 == 1) {
            Object obj = objArrCopyOf[0];
            obj.getClass();
            Object obj2 = objArrCopyOf[1];
            obj2.getClass();
            b9c.a(obj, obj2);
            return new zzbc(null, objArrCopyOf, 1);
        }
        r8c.b(i2, objArrCopyOf.length >> 1, "index");
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            Object obj3 = objArrCopyOf[0];
            obj3.getClass();
            Object obj4 = objArrCopyOf[1];
            obj4.getClass();
            b9c.a(obj3, obj4);
            c = 1;
            c2 = 2;
        } else {
            int i4 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int i7 = i6 + i6;
                    int i8 = i5 + i5;
                    Object obj5 = objArrCopyOf[i8];
                    obj5.getClass();
                    Object obj6 = objArrCopyOf[i8 ^ i3];
                    obj6.getClass();
                    b9c.a(obj5, obj6);
                    int iA = i9c.a(obj5.hashCode());
                    while (true) {
                        int i9 = iA & i4;
                        int i10 = bArr[i9] & 255;
                        if (i10 == 255) {
                            bArr[i9] = (byte) i7;
                            if (i6 < i5) {
                                objArrCopyOf[i7] = obj5;
                                objArrCopyOf[i7 ^ 1] = obj6;
                            }
                            i6++;
                            break;
                        }
                        if (obj5.equals(objArrCopyOf[i10 == true ? 1 : 0])) {
                            int i11 = ~i10;
                            Object obj7 = objArrCopyOf[i11 == true ? 1 : 0];
                            obj7.getClass();
                            jac jacVar4 = new jac(obj5, obj6, obj7);
                            objArrCopyOf[i11 == true ? 1 : 0] = obj6;
                            jacVar2 = jacVar4;
                            break;
                        }
                        iA = i9 + 1;
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 == i2) {
                    r3 = bArr;
                } else {
                    r4 = new Object[]{bArr, Integer.valueOf(i6), jacVar2};
                    c2 = 2;
                }
                c = 1;
                r5 = r4;
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i12 = 0;
                for (int i13 = 0; i13 < i2; i13++) {
                    int i14 = i12 + i12;
                    int i15 = i13 + i13;
                    Object obj8 = objArrCopyOf[i15];
                    obj8.getClass();
                    Object obj9 = objArrCopyOf[i15 ^ 1];
                    obj9.getClass();
                    b9c.a(obj8, obj9);
                    int iA2 = i9c.a(obj8.hashCode());
                    while (true) {
                        int i16 = iA2 & i4;
                        char c3 = (char) sArr[i16];
                        if (c3 == 65535) {
                            sArr[i16] = (short) i14;
                            if (i12 < i13) {
                                objArrCopyOf[i14] = obj8;
                                objArrCopyOf[i14 ^ 1] = obj9;
                            }
                            i12++;
                            break;
                        }
                        if (obj8.equals(objArrCopyOf[c3])) {
                            int i17 = c3 ^ 1;
                            Object obj10 = objArrCopyOf[i17 == true ? 1 : 0];
                            obj10.getClass();
                            jac jacVar5 = new jac(obj8, obj9, obj10);
                            objArrCopyOf[i17 == true ? 1 : 0] = obj9;
                            jacVar3 = jacVar5;
                            break;
                        }
                        iA2 = i16 + 1;
                    }
                }
                if (i12 == i2) {
                    r3 = sArr;
                } else {
                    c2 = 2;
                    r5 = new Object[]{sArr, Integer.valueOf(i12), jacVar3};
                    c = 1;
                }
            } else {
                int i18 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i19 = 0;
                int i20 = 0;
                while (i19 < i2) {
                    int i21 = i20 + i20;
                    int i22 = i19 + i19;
                    Object obj11 = objArrCopyOf[i22];
                    obj11.getClass();
                    Object obj12 = objArrCopyOf[i22 ^ i18];
                    obj12.getClass();
                    b9c.a(obj11, obj12);
                    int iA3 = i9c.a(obj11.hashCode());
                    while (true) {
                        int i23 = iA3 & i4;
                        ?? r15 = sArr[i23];
                        if (r15 == b) {
                            sArr[i23] = i21;
                            if (i20 < i19) {
                                objArrCopyOf[i21] = obj11;
                                objArrCopyOf[i21 ^ 1] = obj12;
                            }
                            i20++;
                            break;
                        }
                        if (obj11.equals(objArrCopyOf[r15])) {
                            int i24 = r15 ^ 1;
                            Object obj13 = objArrCopyOf[i24 == true ? 1 : 0];
                            obj13.getClass();
                            jac jacVar6 = new jac(obj11, obj12, obj13);
                            objArrCopyOf[i24 == true ? 1 : 0] = obj12;
                            jacVar = jacVar6;
                            break;
                        }
                        iA3 = i23 + 1;
                        b = -1;
                    }
                    i19++;
                    i18 = 1;
                    b = -1;
                }
                if (i20 == i2) {
                    r3 = sArr;
                } else {
                    c = 1;
                    c2 = 2;
                    r5 = new Object[]{sArr, Integer.valueOf(i20), jacVar};
                }
            }
            c2 = 2;
            r4 = r3;
            c = 1;
            r5 = r4;
        }
        boolean z = r5 instanceof Object[];
        ?? r6 = r5;
        if (z) {
            Object[] objArr2 = (Object[]) r5;
            jac jacVar7 = (jac) objArr2[c2];
            if (bVar == null) {
                throw jacVar7.a();
            }
            bVar.f5738a = jacVar7;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r6 = obj14;
            i2 = iIntValue;
        }
        return new zzbc(r6, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0009 A[EDGE_INSN: B:43:0x0009->B:4:0x0009 BREAK  A[LOOP:0: B:15:0x0038->B:21:0x004e], EDGE_INSN: B:45:0x0009->B:4:0x0009 BREAK  A[LOOP:1: B:25:0x0063->B:31:0x007a], EDGE_INSN: B:47:0x0009->B:4:0x0009 BREAK  A[LOOP:2: B:33:0x0089->B:42:0x00a0]] */
    @Override // com.google.android.gms.internal.mlkit_common.zzau, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        Object obj3 = this.zzc;
        Object[] objArr = this.zzb;
        int i = this.zzd;
        if (obj == null) {
            obj2 = null;
        } else if (i == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            if (obj4.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else if (obj3 == null) {
            obj2 = null;
        } else if (obj3 instanceof byte[]) {
            byte[] bArr = (byte[]) obj3;
            int length = bArr.length - 1;
            int iA = i9c.a(obj.hashCode());
            while (true) {
                int i2 = iA & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    break;
                }
                if (obj.equals(objArr[i3])) {
                    obj2 = objArr[i3 ^ 1];
                } else {
                    iA = i2 + 1;
                }
            }
            obj2 = null;
        } else if (obj3 instanceof short[]) {
            short[] sArr = (short[]) obj3;
            int length2 = sArr.length - 1;
            int iA2 = i9c.a(obj.hashCode());
            while (true) {
                int i4 = iA2 & length2;
                char c = (char) sArr[i4];
                if (c == 65535) {
                    break;
                }
                if (obj.equals(objArr[c])) {
                    obj2 = objArr[c ^ 1];
                } else {
                    iA2 = i4 + 1;
                }
            }
            obj2 = null;
        } else {
            int[] iArr = (int[]) obj3;
            int length3 = iArr.length - 1;
            int iA3 = i9c.a(obj.hashCode());
            while (true) {
                int i5 = iA3 & length3;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    break;
                }
                if (obj.equals(objArr[i6])) {
                    obj2 = objArr[i6 ^ 1];
                } else {
                    iA3 = i5 + 1;
                }
            }
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    public final zzan zza() {
        return new zzbb(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    public final zzav zzd() {
        return new zzaz(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    public final zzav zze() {
        return new zzba(this, new zzbb(this.zzb, 0, this.zzd));
    }
}
