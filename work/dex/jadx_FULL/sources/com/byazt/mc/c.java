package com.byazt.mc;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1001, 20})
public final class c<T> implements BlockingQueue<T> {
    public final BlockingQueue<T> c;

    public c(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.c = new SynchronousQueue();
        } else {
            this.c = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.c.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.c.addAll(collection);
    }

    public final String c() {
        return this.c.getClass().getName();
    }

    @Override // java.util.Collection
    public void clear() {
        this.c.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.c.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.c.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.c.drainTo(collection);
    }

    @Override // java.util.Queue
    public T element() {
        return this.c.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.c.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.c.offer(t);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.c.peek();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.c.poll(j, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.c.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.c.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.c.remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.c.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.c.retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return ve();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.c.take();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public final BlockingQueue tt() {
        return this.c;
    }

    public int ve() {
        return this.c.size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.c.drainTo(collection, i);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.c.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T poll() {
        return this.c.poll();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.c.remove(obj);
    }
}
