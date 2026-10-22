package com.alibaba.ariver.kernel.common.io;

import androidx.collection.LruCache;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ByteArrayPool {
    private final int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BytePool f24242a = new BytePool(12);
    private final Object c = new Object();
    private final AtomicBoolean d = new AtomicBoolean(false);
    private int e = 0;

    public class BytePool extends LruCache<Integer, LinkedList<byte[]>> {
        private BytePool(int i) {
            super(i);
        }

        @Override // androidx.collection.LruCache
        public void entryRemoved(boolean z, Integer num, LinkedList<byte[]> linkedList, LinkedList<byte[]> linkedList2) {
            synchronized (ByteArrayPool.this.c) {
                if (z || linkedList2 != null) {
                    ByteArrayPool.this.e -= num.intValue() * linkedList.size();
                }
            }
        }
    }

    public class ConcurrentLinkedList<T> extends LinkedList<T> {
        private ConcurrentLinkedList() {
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public boolean offer(T t) {
            boolean zOffer;
            synchronized (this) {
                zOffer = super.offer(t);
            }
            return zOffer;
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public T poll() {
            T t;
            synchronized (this) {
                t = (T) super.poll();
            }
            return t;
        }
    }

    public ByteArrayPool(int i) {
        this.b = i;
    }

    private void a() {
        if (!this.d.get() && this.e > this.b) {
            this.d.set(true);
            BytePool bytePool = this.f24242a;
            bytePool.trimToSize(bytePool.size() / 2);
            this.d.set(false);
        }
    }

    public byte[] getBuf(int i) {
        byte[] bArrPoll;
        LinkedList<byte[]> linkedList = this.f24242a.get(Integer.valueOf(i));
        if (linkedList == null || (bArrPoll = linkedList.poll()) == null) {
            return new byte[i];
        }
        synchronized (this.c) {
            this.e -= bArrPoll.length;
        }
        return bArrPoll;
    }

    public void returnBuf(byte[] bArr) {
        if (bArr == null || bArr.length > this.b) {
            return;
        }
        synchronized (this.c) {
            this.e += bArr.length;
        }
        LinkedList<byte[]> linkedList = this.f24242a.get(Integer.valueOf(bArr.length));
        if (linkedList == null) {
            ConcurrentLinkedList concurrentLinkedList = new ConcurrentLinkedList();
            concurrentLinkedList.offer(bArr);
            this.f24242a.put(Integer.valueOf(bArr.length), concurrentLinkedList);
        } else {
            linkedList.offer(bArr);
        }
        a();
    }
}
