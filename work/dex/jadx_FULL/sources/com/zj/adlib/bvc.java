package com.zj.adlib;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class bvc extends AbstractMap {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile tuc f40849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f15648a = Collections.emptyList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f15649a = Collections.emptyMap();
    public Map b = Collections.emptyMap();

    public void b() {
        if (this.f15650a) {
            return;
        }
        this.f15649a = this.f15649a.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f15649a);
        this.b = this.b.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.b);
        this.f15650a = true;
    }

    public final int c() {
        return this.f15648a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        o();
        if (!this.f15648a.isEmpty()) {
            this.f15648a.clear();
        }
        if (this.f15649a.isEmpty()) {
            return;
        }
        this.f15649a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return l(comparable) >= 0 || this.f15649a.containsKey(comparable);
    }

    public final Iterable d() {
        return this.f15649a.isEmpty() ? ztc.a() : this.f15649a.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f40849a == null) {
            this.f40849a = new tuc(this, null);
        }
        return this.f40849a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bvc)) {
            return super.equals(obj);
        }
        bvc bvcVar = (bvc) obj;
        int size = size();
        if (size != bvcVar.size()) {
            return false;
        }
        int iC = c();
        if (iC != bvcVar.c()) {
            return entrySet().equals(bvcVar.entrySet());
        }
        for (int i = 0; i < iC; i++) {
            if (!h(i).equals(bvcVar.h(i))) {
                return false;
            }
        }
        if (iC != size) {
            return this.f15649a.equals(bvcVar.f15649a);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        o();
        int iL = l(comparable);
        if (iL >= 0) {
            return ((duc) this.f15648a.get(iL)).setValue(obj);
        }
        o();
        if (this.f15648a.isEmpty() && !(this.f15648a instanceof ArrayList)) {
            this.f15648a = new ArrayList(this.K);
        }
        int i = -(iL + 1);
        if (i >= this.K) {
            return n().put(comparable, obj);
        }
        int size = this.f15648a.size();
        int i2 = this.K;
        if (size == i2) {
            duc ducVar = (duc) this.f15648a.remove(i2 - 1);
            n().put(ducVar.a(), ducVar.getValue());
        }
        this.f15648a.add(i, new duc(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iL = l(comparable);
        return iL >= 0 ? ((duc) this.f15648a.get(iL)).getValue() : this.f15649a.get(comparable);
    }

    public final Map.Entry h(int i) {
        return (Map.Entry) this.f15648a.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iC = c();
        int iHashCode = 0;
        for (int i = 0; i < iC; i++) {
            iHashCode += ((duc) this.f15648a.get(i)).hashCode();
        }
        return this.f15649a.size() > 0 ? iHashCode + this.f15649a.hashCode() : iHashCode;
    }

    public final boolean k() {
        return this.f15650a;
    }

    public final int l(Comparable comparable) {
        int size = this.f15648a.size() - 1;
        int i = 0;
        if (size >= 0) {
            int iCompareTo = comparable.compareTo(((duc) this.f15648a.get(size)).a());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int iCompareTo2 = comparable.compareTo(((duc) this.f15648a.get(i2)).a());
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final Object m(int i) {
        o();
        Object value = ((duc) this.f15648a.remove(i)).getValue();
        if (!this.f15649a.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            List list = this.f15648a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new duc(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    public final SortedMap n() {
        o();
        if (this.f15649a.isEmpty() && !(this.f15649a instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f15649a = treeMap;
            this.b = treeMap.descendingMap();
        }
        return (SortedMap) this.f15649a;
    }

    public final void o() {
        if (this.f15650a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        o();
        Comparable comparable = (Comparable) obj;
        int iL = l(comparable);
        if (iL >= 0) {
            return m(iL);
        }
        if (this.f15649a.isEmpty()) {
            return null;
        }
        return this.f15649a.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f15648a.size() + this.f15649a.size();
    }
}
