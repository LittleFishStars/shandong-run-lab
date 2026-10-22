package com.alibaba.baichuan.log;

import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ConcurrentLRUCache<T> implements Iterable<T> {
    private final Object[] elements;
    private final int maxSize;
    private volatile int next = 0;
    private volatile int count = 0;

    public static class PageIterator<T> implements Iterator<T> {
        private int left;
        private final Object[] mCopyElements;
        private final int mCopyMaxSize;
        private final int next;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.left > 0;
        }

        @Override // java.util.Iterator
        public T next() {
            Object[] objArr = this.mCopyElements;
            int i = this.next;
            int i2 = this.left;
            int i3 = this.mCopyMaxSize;
            T t = (T) objArr[((i - i2) + i3) % i3];
            this.left = i2 - 1;
            return t;
        }

        private PageIterator(Object[] objArr, int i, int i2, int i3) {
            Object[] objArr2 = new Object[i2];
            this.mCopyElements = objArr2;
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            this.mCopyMaxSize = i;
            this.left = i2;
            this.next = i3;
        }
    }

    public ConcurrentLRUCache(int i) {
        this.elements = new Object[i];
        this.maxSize = i;
    }

    public T add(T t) {
        T t2;
        synchronized (this) {
            t2 = (T) this.elements[this.next];
            this.elements[this.next] = t;
            int i = this.next + 1;
            this.next = i;
            this.next = i % this.maxSize;
            if (this.count < this.maxSize) {
                this.count++;
            }
        }
        return t2;
    }

    public void clear() {
        synchronized (this) {
            for (int i = 0; i < this.count; i++) {
                this.elements[i] = null;
            }
            this.count = 0;
            this.next = 0;
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.maxSize;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        PageIterator pageIterator;
        synchronized (this) {
            pageIterator = new PageIterator(this.elements, this.maxSize, this.count, this.next);
        }
        return pageIterator;
    }

    public int size() {
        return this.count;
    }
}
