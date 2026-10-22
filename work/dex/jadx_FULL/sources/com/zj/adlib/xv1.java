package com.zj.adlib;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xv1<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f45903a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public final Map<E, Integer> f20740a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public Set<E> f20741a = Collections.emptySet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public List<E> f20739a = Collections.emptyList();

    public void a(E e) {
        synchronized (this.f45903a) {
            ArrayList arrayList = new ArrayList(this.f20739a);
            arrayList.add(e);
            this.f20739a = Collections.unmodifiableList(arrayList);
            Integer num = this.f20740a.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f20741a);
                hashSet.add(e);
                this.f20741a = Collections.unmodifiableSet(hashSet);
            }
            this.f20740a.put(e, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public void b(E e) {
        synchronized (this.f45903a) {
            Integer num = this.f20740a.get(e);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f20739a);
            arrayList.remove(e);
            this.f20739a = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f20740a.remove(e);
                HashSet hashSet = new HashSet(this.f20741a);
                hashSet.remove(e);
                this.f20741a = Collections.unmodifiableSet(hashSet);
            } else {
                this.f20740a.put(e, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public int count(E e) {
        int iIntValue;
        synchronized (this.f45903a) {
            iIntValue = this.f20740a.containsKey(e) ? this.f20740a.get(e).intValue() : 0;
        }
        return iIntValue;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f45903a) {
            set = this.f20741a;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f45903a) {
            it = this.f20739a.iterator();
        }
        return it;
    }
}
