package com.byazt.ga;

import com.hzchengdun.securityguard.SecExceptionCode;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 133})
public abstract class z<K, V> {
    public z<K, V>.tt tt;

    @com.byazt.zqa.c(c = {0, 1, 256, SecExceptionCode.SEC_ERROE_NOCAPTCHA_INVALID_THREAD})
    public final class c<T> implements Iterator<T> {
        public final int c;
        public int tt;
        public boolean uj = false;
        public int ve;

        public c(int i) {
            this.c = i;
            this.tt = z.this.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.ve < this.tt;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) z.this.c(this.ve, this.c);
            this.ve++;
            this.uj = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.uj) {
                throw new IllegalStateException();
            }
            int i = this.ve - 1;
            this.ve = i;
            this.tt--;
            this.uj = false;
            z.this.c(i);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 1876})
    public final class tt implements Set<K> {
        public tt() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            z.this.ve();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return z.this.c(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return z.c(z.this.tt(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return z.c(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iC = z.this.c() - 1; iC >= 0; iC--) {
                Object objC = z.this.c(iC, 0);
                iHashCode += objC == null ? 0 : objC.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return z.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new c(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iC = z.this.c(obj);
            if (iC < 0) {
                return false;
            }
            z.this.c(iC);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return z.tt(z.this.tt(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return z.ve(z.this.tt(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return z.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return z.this.tt(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) z.this.c(tArr, 0);
        }
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean tt(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean ve(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract int c();

    public abstract int c(Object obj);

    public abstract Object c(int i, int i2);

    public abstract void c(int i);

    public abstract Map<K, V> tt();

    public Set<K> uj() {
        if (this.tt == null) {
            this.tt = new tt();
        }
        return this.tt;
    }

    public abstract void ve();

    public <T> T[] c(T[] tArr, int i) {
        int iC = c();
        if (tArr.length < iC) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iC));
        }
        for (int i2 = 0; i2 < iC; i2++) {
            tArr[i2] = c(i2, i);
        }
        if (tArr.length > iC) {
            tArr[iC] = null;
        }
        return tArr;
    }

    public Object[] tt(int i) {
        int iC = c();
        Object[] objArr = new Object[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            objArr[i2] = c(i2, i);
        }
        return objArr;
    }

    public static <T> boolean c(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
