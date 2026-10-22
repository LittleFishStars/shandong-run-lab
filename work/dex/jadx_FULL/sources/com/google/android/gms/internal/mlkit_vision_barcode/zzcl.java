package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.dgc;
import com.zj.adlib.ggc;
import com.zj.adlib.pkc;
import com.zj.adlib.wac;
import com.zj.adlib.ybc;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzcl extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();

    @CheckForNull
    transient int[] zza;

    @CheckForNull
    transient Object[] zzb;

    @CheckForNull
    transient Object[] zzc;

    @CheckForNull
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;

    @CheckForNull
    private transient Set zzh;

    @CheckForNull
    private transient Set zzi;

    @CheckForNull
    private transient Collection zzj;

    public zzcl() {
        zzm(3);
    }

    public static /* synthetic */ Object zzh(zzcl zzclVar) {
        Object obj = zzclVar.zze;
        obj.getClass();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzq(@CheckForNull Object obj) {
        if (zzo()) {
            return -1;
        }
        int iA = ggc.a(obj);
        int iZzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int iC = dgc.c(obj2, iA & iZzp);
        if (iC != 0) {
            int i = ~iZzp;
            int i2 = iA & i;
            do {
                int i3 = iC - 1;
                int[] iArr = this.zza;
                iArr.getClass();
                int i4 = iArr[i3];
                if ((i4 & i) == i2) {
                    Object[] objArr = this.zzb;
                    objArr.getClass();
                    if (wac.a(obj, objArr[i3])) {
                        return i3;
                    }
                }
                iC = i4 & iZzp;
            } while (iC != 0);
        }
        return -1;
    }

    private final int zzr(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objD = dgc.d(i2);
        if (i4 != 0) {
            dgc.e(objD, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        for (int i6 = 0; i6 <= i; i6++) {
            int iC = dgc.c(obj, i6);
            while (iC != 0) {
                int i7 = iC - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iC2 = dgc.c(objD, i10);
                dgc.e(objD, i10, iC);
                iArr[i7] = ((~i5) & i9) | (iC2 & i5);
                iC = i8 & i;
            }
        }
        this.zze = objD;
        zzt(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzs(@CheckForNull Object obj) {
        if (zzo()) {
            return zzd;
        }
        int iZzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        int iB = dgc.b(obj, null, iZzp, obj2, iArr, objArr, null);
        if (iB == -1) {
            return zzd;
        }
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Object obj3 = objArr2[iB];
        zzn(iB, iZzp);
        this.zzg--;
        zzl();
        return obj3;
    }

    private final void zzt(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzo()) {
            return;
        }
        zzl();
        Map mapZzj = zzj();
        if (mapZzj != null) {
            this.zzf = pkc.a(size(), 3, com.google.common.collect.c.d);
            mapZzj.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Object[] objArr = this.zzb;
        objArr.getClass();
        Arrays.fill(objArr, 0, this.zzg, (Object) null);
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Arrays.fill(objArr2, 0, this.zzg, (Object) null);
        Object obj = this.zze;
        obj.getClass();
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        int[] iArr = this.zza;
        iArr.getClass();
        Arrays.fill(iArr, 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.containsKey(obj);
        }
        return zzq(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            Object[] objArr = this.zzc;
            objArr.getClass();
            if (wac.a(obj, objArr[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        q qVar = new q(this);
        this.zzi = qVar;
        return qVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.get(obj);
        }
        int iZzq = zzq(obj);
        if (iZzq == -1) {
            return null;
        }
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr[iZzq];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        r rVar = new r(this);
        this.zzh = rVar;
        return rVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (zzo()) {
            ybc.e(zzo(), "Arrays already allocated");
            int i = this.zzf;
            int iMax = Math.max(i + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = dgc.d(iMax2);
            zzt(iMax2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.put(obj, obj2);
        }
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int iA = ggc.a(obj);
        int iZzp = zzp();
        int i4 = iA & iZzp;
        Object obj3 = this.zze;
        obj3.getClass();
        int iC = dgc.c(obj3, i4);
        if (iC != 0) {
            int i5 = ~iZzp;
            int i6 = iA & i5;
            int i7 = 0;
            while (true) {
                int i8 = iC - 1;
                int i9 = iArr[i8];
                int i10 = i9 & i5;
                if (i10 == i6 && wac.a(obj, objArr[i8])) {
                    Object obj4 = objArr2[i8];
                    objArr2[i8] = obj2;
                    return obj4;
                }
                int i11 = i9 & iZzp;
                i7++;
                if (i11 == 0) {
                    if (i7 < 9) {
                        if (i3 <= iZzp) {
                            iArr[i8] = (i3 & iZzp) | i10;
                            break;
                        }
                        iZzp = zzr(iZzp, dgc.a(iZzp), iA, i2);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                    int iZze = zze();
                    while (iZze >= 0) {
                        Object[] objArr3 = this.zzb;
                        objArr3.getClass();
                        Object obj5 = objArr3[iZze];
                        Object[] objArr4 = this.zzc;
                        objArr4.getClass();
                        linkedHashMap.put(obj5, objArr4[iZze]);
                        iZze = zzf(iZze);
                    }
                    this.zze = linkedHashMap;
                    this.zza = null;
                    this.zzb = null;
                    this.zzc = null;
                    zzl();
                    return linkedHashMap.put(obj, obj2);
                }
                iC = i11;
            }
        } else if (i3 > iZzp) {
            iZzp = zzr(iZzp, dgc.a(iZzp), iA, i2);
        } else {
            Object obj6 = this.zze;
            obj6.getClass();
            dgc.e(obj6, i4, i3);
        }
        int[] iArr2 = this.zza;
        iArr2.getClass();
        int length = iArr2.length;
        if (i3 > length && (iMin = Math.min(com.google.common.collect.c.d, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            int[] iArr3 = this.zza;
            iArr3.getClass();
            this.zza = Arrays.copyOf(iArr3, iMin);
            Object[] objArr5 = this.zzb;
            objArr5.getClass();
            this.zzb = Arrays.copyOf(objArr5, iMin);
            Object[] objArr6 = this.zzc;
            objArr6.getClass();
            this.zzc = Arrays.copyOf(objArr6, iMin);
        }
        int i12 = (~iZzp) & iA;
        int[] iArr4 = this.zza;
        iArr4.getClass();
        iArr4[i2] = i12;
        Object[] objArr7 = this.zzb;
        objArr7.getClass();
        objArr7[i2] = obj;
        Object[] objArr8 = this.zzc;
        objArr8.getClass();
        objArr8[i2] = obj2;
        this.zzg = i3;
        zzl();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.remove(obj);
        }
        Object objZzs = zzs(obj);
        if (objZzs == zzd) {
            return null;
        }
        return objZzs;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzj = zzj();
        return mapZzj != null ? mapZzj.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        t tVar = new t(this);
        this.zzj = tVar;
        return tVar;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    @CheckForNull
    public final Map zzj() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzl() {
        this.zzf += 32;
    }

    public final void zzm(int i) {
        this.zzf = pkc.a(12, 1, com.google.common.collect.c.d);
    }

    public final void zzn(int i, int i2) {
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int size = size() - 1;
        if (i >= size) {
            objArr[i] = null;
            objArr2[i] = null;
            iArr[i] = 0;
            return;
        }
        Object obj2 = objArr[size];
        objArr[i] = obj2;
        objArr2[i] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        iArr[i] = iArr[size];
        iArr[size] = 0;
        int iA = ggc.a(obj2) & i2;
        int iC = dgc.c(obj, iA);
        int i3 = size + 1;
        if (iC == i3) {
            dgc.e(obj, iA, i + 1);
            return;
        }
        while (true) {
            int i4 = iC - 1;
            int i5 = iArr[i4];
            int i6 = i5 & i2;
            if (i6 == i3) {
                iArr[i4] = ((i + 1) & i2) | (i5 & (~i2));
                return;
            }
            iC = i6;
        }
    }

    public final boolean zzo() {
        return this.zze == null;
    }

    public zzcl(int i) {
        zzm(12);
    }
}
