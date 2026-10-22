package com.byazt.ga;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 20})
public final class c<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28556a;
    public static Object[] n;
    public static Object[] sp;
    public static int x;
    public Object[] c;
    public z<E, E> da;
    public int[] i;
    public int tt;
    public static final int[] ve = new int[0];
    public static final Object[] uj = new Object[0];

    public c() {
        this(0);
    }

    private int c(Object obj, int i) {
        int i2 = this.tt;
        if (i2 == 0) {
            return -1;
        }
        int iC = tt.c(this.i, i2, i);
        if (iC < 0 || obj.equals(this.c[iC])) {
            return iC;
        }
        int i3 = iC + 1;
        while (i3 < i2 && this.i[i3] == i) {
            if (obj.equals(this.c[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iC - 1; i4 >= 0 && this.i[i4] == i; i4--) {
            if (obj.equals(this.c[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private void uj(int i) {
        if (i == 8) {
            synchronized (c.class) {
                Object[] objArr = sp;
                if (objArr != null) {
                    this.c = objArr;
                    sp = (Object[]) objArr[0];
                    this.i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    x--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (c.class) {
                Object[] objArr2 = n;
                if (objArr2 != null) {
                    this.c = objArr2;
                    n = (Object[]) objArr2[0];
                    this.i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f28556a--;
                    return;
                }
            }
        }
        this.i = new int[i];
        this.c = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iC;
        if (e == null) {
            iC = c();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iC = c(e, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i2 = ~iC;
        int i3 = this.tt;
        int[] iArr = this.i;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.c;
            uj(i4);
            int[] iArr2 = this.i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            c(iArr, objArr, this.tt);
        }
        int i5 = this.tt;
        if (i2 < i5) {
            int[] iArr3 = this.i;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i2, objArr2, i6, this.tt - i2);
        }
        this.i[i2] = i;
        this.c[i2] = e;
        this.tt++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        c(this.tt + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.tt;
        if (i != 0) {
            c(this.i, this.c, i);
            this.i = ve;
            this.c = uj;
            this.tt = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return c(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.tt; i++) {
                try {
                    if (!set.contains(tt(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.i;
        int i = this.tt;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.tt <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return tt().uj().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iC = c(obj);
        if (iC < 0) {
            return false;
        }
        ve(iC);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.tt - 1; i >= 0; i--) {
            if (!collection.contains(this.c[i])) {
                ve(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.tt;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.tt;
        Object[] objArr = new Object[i];
        System.arraycopy(this.c, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.tt * 14);
        sb.append('{');
        for (int i = 0; i < this.tt; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eTt = tt(i);
            if (eTt != this) {
                sb.append(eTt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E tt(int i) {
        return (E) this.c[i];
    }

    public E ve(int i) {
        Object[] objArr = this.c;
        E e = (E) objArr[i];
        int i2 = this.tt;
        if (i2 <= 1) {
            c(this.i, objArr, i2);
            this.i = ve;
            this.c = uj;
            this.tt = 0;
        } else {
            int[] iArr = this.i;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.tt = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i4, objArr2, i, this.tt - i);
                }
                this.c[this.tt] = null;
            } else {
                uj(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.tt--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.i, 0, i);
                    System.arraycopy(objArr, 0, this.c, 0, i);
                }
                int i5 = this.tt;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, this.i, i, i5 - i);
                    System.arraycopy(objArr, i6, this.c, i, this.tt - i);
                }
            }
        }
        return e;
    }

    public c(int i) {
        if (i == 0) {
            this.i = ve;
            this.c = uj;
        } else {
            uj(i);
        }
        this.tt = 0;
    }

    private z<E, E> tt() {
        if (this.da == null) {
            this.da = new z<E, E>() { // from class: com.byazt.ga.c.1
                @Override // com.byazt.ga.z
                public int c() {
                    return c.this.tt;
                }

                @Override // com.byazt.ga.z
                public Map<E, E> tt() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.byazt.ga.z
                public void ve() {
                    c.this.clear();
                }

                @Override // com.byazt.ga.z
                public Object c(int i, int i2) {
                    return c.this.c[i];
                }

                @Override // com.byazt.ga.z
                public int c(Object obj) {
                    return c.this.c(obj);
                }

                @Override // com.byazt.ga.z
                public void c(int i) {
                    c.this.ve(i);
                }
            };
        }
        return this.da;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.tt) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.tt));
        }
        System.arraycopy(this.c, 0, tArr, 0, this.tt);
        int length = tArr.length;
        int i = this.tt;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    private int c() {
        int i = this.tt;
        if (i == 0) {
            return -1;
        }
        int iC = tt.c(this.i, i, 0);
        if (iC < 0 || this.c[iC] == null) {
            return iC;
        }
        int i2 = iC + 1;
        while (i2 < i && this.i[i2] == 0) {
            if (this.c[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iC - 1; i3 >= 0 && this.i[i3] == 0; i3--) {
            if (this.c[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (x < 10) {
                    objArr[0] = sp;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    sp = objArr;
                    x++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                if (f28556a < 10) {
                    objArr[0] = n;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    n = objArr;
                    f28556a++;
                }
            }
        }
    }

    public void c(int i) {
        int[] iArr = this.i;
        if (iArr.length < i) {
            Object[] objArr = this.c;
            uj(i);
            int i2 = this.tt;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.i, 0, i2);
                System.arraycopy(objArr, 0, this.c, 0, this.tt);
            }
            c(iArr, objArr, this.tt);
        }
    }

    public int c(Object obj) {
        return obj == null ? c() : c(obj, obj.hashCode());
    }
}
