package com.alibaba.ariver.kernel.common.immutable;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class ImmutableCollection<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Iterator f24237a = new Iterator() { // from class: com.alibaba.ariver.kernel.common.immutable.ImmutableCollection.1
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("removing is unsupported");
        }
    };
    protected Collection<E> immutableCollection;

    public static class ImmutableIterator implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator f24238a;

        public ImmutableIterator(Iterator it) {
            this.f24238a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator it = this.f24238a;
            return it != null && it.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Iterator it = this.f24238a;
            if (it != null) {
                return it.next();
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("removing is unsupported");
        }
    }

    public ImmutableCollection(Collection<E> collection) {
        this.immutableCollection = collection;
    }

    public boolean contains(Object obj) {
        Collection<E> collection = this.immutableCollection;
        return collection != null && collection.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        Collection<E> collection2 = this.immutableCollection;
        return collection2 != null && collection2.containsAll(collection);
    }

    public boolean isEmpty() {
        Collection<E> collection = this.immutableCollection;
        return collection == null || collection.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Collection<E> collection = this.immutableCollection;
        return collection == null ? f24237a : new ImmutableIterator(collection.iterator());
    }

    public int size() {
        Collection<E> collection = this.immutableCollection;
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public Object[] toArray() {
        Collection<E> collection = this.immutableCollection;
        if (collection != null) {
            return collection.toArray();
        }
        return null;
    }

    public ImmutableCollection() {
    }
}
