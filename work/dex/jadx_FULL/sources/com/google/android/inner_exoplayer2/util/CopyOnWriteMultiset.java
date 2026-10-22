package com.google.android.inner_exoplayer2.util;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class CopyOnWriteMultiset<E> implements Iterable<E> {
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Map<E, Integer> elementCounts = new HashMap();

    @GuardedBy("lock")
    private Set<E> elementSet = Collections.emptySet();

    @GuardedBy("lock")
    private List<E> elements = Collections.emptyList();

    public void add(E e) {
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList(this.elements);
            arrayList.add(e);
            this.elements = Collections.unmodifiableList(arrayList);
            Integer num = this.elementCounts.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.elementSet);
                hashSet.add(e);
                this.elementSet = Collections.unmodifiableSet(hashSet);
            }
            this.elementCounts.put(e, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public int count(E e) {
        int iIntValue;
        synchronized (this.lock) {
            iIntValue = this.elementCounts.containsKey(e) ? this.elementCounts.get(e).intValue() : 0;
        }
        return iIntValue;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.lock) {
            set = this.elementSet;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.lock) {
            it = this.elements.iterator();
        }
        return it;
    }

    public void remove(E e) {
        synchronized (this.lock) {
            Integer num = this.elementCounts.get(e);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.elements);
            arrayList.remove(e);
            this.elements = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.elementCounts.remove(e);
                HashSet hashSet = new HashSet(this.elementSet);
                hashSet.remove(e);
                this.elementSet = Collections.unmodifiableSet(hashSet);
            } else {
                this.elementCounts.put(e, Integer.valueOf(num.intValue() - 1));
            }
        }
    }
}
