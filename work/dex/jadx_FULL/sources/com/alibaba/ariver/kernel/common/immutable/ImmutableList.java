package com.alibaba.ariver.kernel.common.immutable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ImmutableList<E> extends ImmutableCollection<E> implements Immutable<List<E>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<E> f24239a;

    public ImmutableList(List<E> list) {
        super(list);
        this.f24239a = list;
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
        return super.containsAll(collection);
    }

    public E get(int i) {
        List<E> list = this.f24239a;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public int indexOf(E e) {
        List<E> list = this.f24239a;
        if (list != null) {
            return list.indexOf(e);
        }
        return -1;
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public int lastIndexOf(Object obj) {
        List<E> list = this.f24239a;
        if (list != null) {
            return list.lastIndexOf(obj);
        }
        return -1;
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ Object[] toArray() {
        return super.toArray();
    }

    public String toString() {
        return this.f24239a.toString();
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.Immutable
    public List<E> mutable() {
        return new ArrayList(this.f24239a);
    }

    public ImmutableList(E e) {
        ArrayList arrayList = new ArrayList();
        this.f24239a = arrayList;
        arrayList.add(e);
        this.immutableCollection = this.f24239a;
    }
}
