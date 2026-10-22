package com.beizi.fusion;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eh extends AbstractMap implements Serializable {
    private static final Comparator i = new a();
    static final /* synthetic */ boolean j = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator f27234a;
    private final boolean b;
    e c;
    int d;
    int e;
    final e f;
    private b g;
    private c h;

    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            eh.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && eh.this.a((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e eVarA;
            if (!(obj instanceof Map.Entry) || (eVarA = eh.this.a((Map.Entry) obj)) == null) {
                return false;
            }
            eh.this.b(eVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return eh.this.d;
        }
    }

    public final class c extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            eh.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return eh.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return eh.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return eh.this.d;
        }
    }

    public abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f27237a;
        e b = null;
        int c;

        public d() {
            this.f27237a = eh.this.f.d;
            this.c = eh.this.e;
        }

        public final e a() {
            e eVar = this.f27237a;
            eh ehVar = eh.this;
            if (eVar == ehVar.f) {
                throw new NoSuchElementException();
            }
            if (ehVar.e != this.c) {
                throw new ConcurrentModificationException();
            }
            this.f27237a = eVar.d;
            this.b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f27237a != eh.this.f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            eh.this.b(eVar, true);
            this.b = null;
            this.c = eh.this.e;
        }
    }

    public eh(boolean z) {
        this(i, z);
    }

    public e a(Object obj, boolean z) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f27234a;
        e eVar2 = this.c;
        if (eVar2 != null) {
            Comparable comparable = comparator == i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f) : comparator.compare(obj, eVar2.f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.b : eVar2.c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        e eVar4 = this.f;
        if (eVar2 != null) {
            eVar = new e(this.b, eVar2, obj, eVar4, eVar4.e);
            if (iCompareTo < 0) {
                eVar2.b = eVar;
            } else {
                eVar2.c = eVar;
            }
            a(eVar2, true);
        } else {
            if (comparator == i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.b, eVar2, obj, eVar4, eVar4.e);
            this.c = eVar;
        }
        this.d++;
        this.e++;
        return eVar;
    }

    public void b(e eVar, boolean z) {
        int i2;
        if (z) {
            e eVar2 = eVar.e;
            eVar2.d = eVar.d;
            eVar.d.e = eVar2;
        }
        e eVar3 = eVar.b;
        e eVar4 = eVar.c;
        e eVar5 = eVar.f27238a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                a(eVar, eVar3);
                eVar.b = null;
            } else if (eVar4 != null) {
                a(eVar, eVar4);
                eVar.c = null;
            } else {
                a(eVar, (e) null);
            }
            a(eVar5, false);
            this.d--;
            this.e++;
            return;
        }
        e eVarB = eVar3.i > eVar4.i ? eVar3.b() : eVar4.a();
        b(eVarB, false);
        e eVar6 = eVar.b;
        if (eVar6 != null) {
            i2 = eVar6.i;
            eVarB.b = eVar6;
            eVar6.f27238a = eVarB;
            eVar.b = null;
        } else {
            i2 = 0;
        }
        e eVar7 = eVar.c;
        if (eVar7 != null) {
            i3 = eVar7.i;
            eVarB.c = eVar7;
            eVar7.f27238a = eVarB;
            eVar.c = null;
        }
        eVarB.i = Math.max(i2, i3) + 1;
        a(eVar, eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.c = null;
        this.d = 0;
        this.e++;
        e eVar = this.f;
        eVar.e = eVar;
        eVar.d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.g = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarA = a(obj);
        if (eVarA != null) {
            return eVarA.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.b) {
            throw new NullPointerException("value == null");
        }
        e eVarA = a(obj, true);
        Object obj3 = eVarA.h;
        eVarA.h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarB = b(obj);
        if (eVarB != null) {
            return eVarB.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }

    public eh(Comparator comparator, boolean z) {
        this.d = 0;
        this.e = 0;
        this.f27234a = comparator == null ? i : comparator;
        this.b = z;
        this.f = new e(z);
    }

    public static final class e implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f27238a;
        e b;
        e c;
        e d;
        e e;
        final Object f;
        final boolean g;
        Object h;
        int i;

        public e(boolean z) {
            this.f = null;
            this.g = z;
            this.e = this;
            this.d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.b; eVar2 != null; eVar2 = eVar2.b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.c; eVar2 != null; eVar2 = eVar2.c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.h;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.h;
            this.h = obj;
            return obj2;
        }

        public String toString() {
            return this.f + "=" + this.h;
        }

        public e(boolean z, e eVar, Object obj, e eVar2, e eVar3) {
            this.f27238a = eVar;
            this.f = obj;
            this.g = z;
            this.i = 1;
            this.d = eVar2;
            this.e = eVar3;
            eVar3.d = this;
            eVar2.e = this;
        }
    }

    public e a(Object obj) {
        if (obj != null) {
            try {
                return a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public e a(Map.Entry entry) {
        e eVarA = a(entry.getKey());
        if (eVarA == null || !a(eVarA.h, entry.getValue())) {
            return null;
        }
        return eVarA;
    }

    private static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void a(e eVar, e eVar2) {
        e eVar3 = eVar.f27238a;
        eVar.f27238a = null;
        if (eVar2 != null) {
            eVar2.f27238a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.b == eVar) {
                eVar3.b = eVar2;
                return;
            } else {
                if (!j && eVar3.c != eVar) {
                    throw new AssertionError();
                }
                eVar3.c = eVar2;
                return;
            }
        }
        this.c = eVar2;
    }

    public e b(Object obj) {
        e eVarA = a(obj);
        if (eVarA != null) {
            b(eVarA, true);
        }
        return eVarA;
    }

    private void a(e eVar, boolean z) {
        while (eVar != null) {
            e eVar2 = eVar.b;
            e eVar3 = eVar.c;
            int i2 = eVar2 != null ? eVar2.i : 0;
            int i3 = eVar3 != null ? eVar3.i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e eVar4 = eVar3.b;
                e eVar5 = eVar3.c;
                int i5 = (eVar4 != null ? eVar4.i : 0) - (eVar5 != null ? eVar5.i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!j && i5 != 1) {
                        throw new AssertionError();
                    }
                    b(eVar3);
                    a(eVar);
                } else {
                    a(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e eVar6 = eVar2.b;
                e eVar7 = eVar2.c;
                int i6 = (eVar6 != null ? eVar6.i : 0) - (eVar7 != null ? eVar7.i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!j && i6 != -1) {
                        throw new AssertionError();
                    }
                    a(eVar2);
                    b(eVar);
                } else {
                    b(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                if (!j && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                }
                eVar.i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f27238a;
        }
    }

    private void b(e eVar) {
        e eVar2 = eVar.b;
        e eVar3 = eVar.c;
        e eVar4 = eVar2.b;
        e eVar5 = eVar2.c;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.f27238a = eVar;
        }
        a(eVar, eVar2);
        eVar2.c = eVar;
        eVar.f27238a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.i : 0, eVar5 != null ? eVar5.i : 0) + 1;
        eVar.i = iMax;
        eVar2.i = Math.max(iMax, eVar4 != null ? eVar4.i : 0) + 1;
    }

    private void a(e eVar) {
        e eVar2 = eVar.b;
        e eVar3 = eVar.c;
        e eVar4 = eVar3.b;
        e eVar5 = eVar3.c;
        eVar.c = eVar4;
        if (eVar4 != null) {
            eVar4.f27238a = eVar;
        }
        a(eVar, eVar3);
        eVar3.b = eVar;
        eVar.f27238a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.i : 0, eVar4 != null ? eVar4.i : 0) + 1;
        eVar.i = iMax;
        eVar3.i = Math.max(iMax, eVar5 != null ? eVar5.i : 0) + 1;
    }
}
