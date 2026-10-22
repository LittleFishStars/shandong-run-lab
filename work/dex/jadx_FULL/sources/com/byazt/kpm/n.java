package com.byazt.kpm;

import com.alipay.sdk.m.p.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 46})
public class n<K, V> {
    public static Object[] c;
    public static int tt;
    public static int uj;
    public static Object[] ve;
    public int[] n = tt.c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f28735a = tt.ve;
    public int sp = 0;

    private static int c(int[] iArr, int i, int i2) {
        try {
            return tt.c(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void uj(int i) {
        if (i == 8) {
            synchronized (c.class) {
                Object[] objArr = ve;
                if (objArr != null) {
                    this.f28735a = objArr;
                    ve = (Object[]) objArr[0];
                    this.n = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    uj--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (c.class) {
                Object[] objArr2 = c;
                if (objArr2 != null) {
                    this.f28735a = objArr2;
                    c = (Object[]) objArr2[0];
                    this.n = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    tt--;
                    return;
                }
            }
        }
        this.n = new int[i];
        this.f28735a = new Object[i << 1];
    }

    public void clear() {
        int i = this.sp;
        if (i > 0) {
            int[] iArr = this.n;
            Object[] objArr = this.f28735a;
            this.n = tt.c;
            this.f28735a = tt.ve;
            this.sp = 0;
            c(iArr, objArr, i);
        }
        if (this.sp > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return tt(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (size() != nVar.size()) {
                return false;
            }
            for (int i = 0; i < this.sp; i++) {
                try {
                    K kC = c(i);
                    V vTt = tt(i);
                    Object obj2 = nVar.get(kC);
                    if (vTt == null) {
                        if (obj2 != null || !nVar.containsKey(kC)) {
                            return false;
                        }
                    } else if (!vTt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.sp; i2++) {
            try {
                K kC2 = c(i2);
                V vTt2 = tt(i2);
                Object obj3 = map.get(kC2);
                if (vTt2 == null) {
                    if (obj3 != null || !map.containsKey(kC2)) {
                        return false;
                    }
                } else if (!vTt2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int iC = c(obj);
        if (iC >= 0) {
            return (V) this.f28735a[(iC << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.n;
        Object[] objArr = this.f28735a;
        int i = this.sp;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.sp <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iC;
        int i2 = this.sp;
        if (k == null) {
            iC = c();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iC = c(k, iHashCode);
        }
        if (iC >= 0) {
            int i3 = (iC << 1) + 1;
            Object[] objArr = this.f28735a;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iC;
        int[] iArr = this.n;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.f28735a;
            uj(i5);
            if (i2 != this.sp) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.n;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f28735a, 0, objArr2.length);
            }
            c(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.n;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f28735a;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.sp - i4) << 1);
        }
        int i7 = this.sp;
        if (i2 == i7) {
            int[] iArr4 = this.n;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f28735a;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.sp = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iC = c(obj);
        if (iC >= 0) {
            return ve(iC);
        }
        return null;
    }

    public int size() {
        return this.sp;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.sp * 28);
        sb.append('{');
        for (int i = 0; i < this.sp; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kC = c(i);
            if (kC != this) {
                sb.append(kC);
            } else {
                sb.append("(this Map)");
            }
            sb.append(a.h);
            V vTt = tt(i);
            if (vTt != this) {
                sb.append(vTt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int tt(Object obj) {
        int i = this.sp * 2;
        Object[] objArr = this.f28735a;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V ve(int i) {
        Object[] objArr = this.f28735a;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.sp;
        int i4 = 0;
        if (i3 <= 1) {
            c(this.n, objArr, i3);
            this.n = tt.c;
            this.f28735a = tt.ve;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.n;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.f28735a;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f28735a;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                uj(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.sp) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.n, 0, i);
                    System.arraycopy(objArr, 0, this.f28735a, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.n, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.f28735a, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.sp) {
            throw new ConcurrentModificationException();
        }
        this.sp = i4;
        return v;
    }

    public int c(Object obj, int i) {
        int i2 = this.sp;
        if (i2 == 0) {
            return -1;
        }
        int iC = c(this.n, i2, i);
        if (iC < 0 || obj.equals(this.f28735a[iC << 1])) {
            return iC;
        }
        int i3 = iC + 1;
        while (i3 < i2 && this.n[i3] == i) {
            if (obj.equals(this.f28735a[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iC - 1; i4 >= 0 && this.n[i4] == i; i4--) {
            if (obj.equals(this.f28735a[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public V tt(int i) {
        return (V) this.f28735a[(i << 1) + 1];
    }

    public int c() {
        int i = this.sp;
        if (i == 0) {
            return -1;
        }
        int iC = c(this.n, i, 0);
        if (iC < 0 || this.f28735a[iC << 1] == null) {
            return iC;
        }
        int i2 = iC + 1;
        while (i2 < i && this.n[i2] == 0) {
            if (this.f28735a[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iC - 1; i3 >= 0 && this.n[i3] == 0; i3--) {
            if (this.f28735a[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (uj < 10) {
                    objArr[0] = ve;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    ve = objArr;
                    uj++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                if (tt < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    c = objArr;
                    tt++;
                }
            }
        }
    }

    public int c(Object obj) {
        return obj == null ? c() : c(obj, obj.hashCode());
    }

    public K c(int i) {
        return (K) this.f28735a[i << 1];
    }
}
