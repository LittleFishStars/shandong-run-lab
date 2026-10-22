package cj.mobile.wm.okserver.task;

import cj.mobile.wm.dexc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PriorityBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static final long serialVersionUID = -6903933977591709194L;
    public final int capacity;
    public final AtomicInteger count;
    public transient PriorityBlockingQueue<E>.Node<E> head;
    public transient PriorityBlockingQueue<E>.Node<E> last;
    public final Condition notEmpty;
    public final Condition notFull;
    public final ReentrantLock putLock;
    public final ReentrantLock takeLock;

    public class Itr implements Iterator<E> {
        public PriorityBlockingQueue<E>.Node<E> current;
        public E currentElement;
        public PriorityBlockingQueue<E>.Node<E> lastRet;

        public Itr() {
            PriorityBlockingQueue.this.fullyLock();
            try {
                PriorityBlockingQueue<E>.Node<E> node = PriorityBlockingQueue.this.head.next;
                this.current = node;
                if (node != null) {
                    this.currentElement = node.getValue();
                }
            } finally {
                PriorityBlockingQueue.this.fullyUnlock();
            }
        }

        private PriorityBlockingQueue<E>.Node<E> nextNode(PriorityBlockingQueue<E>.Node<E> node) {
            while (true) {
                PriorityBlockingQueue<E>.Node<E> node2 = node.next;
                if (node2 == node) {
                    return PriorityBlockingQueue.this.head.next;
                }
                if (node2 == null || node2.getValue() != null) {
                    return node2;
                }
                node = node2;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // java.util.Iterator
        public E next() {
            PriorityBlockingQueue.this.fullyLock();
            try {
                PriorityBlockingQueue<E>.Node<E> node = this.current;
                if (node == null) {
                    throw new NoSuchElementException();
                }
                E e = this.currentElement;
                this.lastRet = node;
                PriorityBlockingQueue<E>.Node<E> nodeNextNode = nextNode(node);
                this.current = nodeNextNode;
                this.currentElement = nodeNextNode == null ? null : nodeNextNode.getValue();
                PriorityBlockingQueue.this.fullyUnlock();
                return e;
            } catch (Throwable th) {
                PriorityBlockingQueue.this.fullyUnlock();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            Node node;
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            PriorityBlockingQueue.this.fullyLock();
            try {
                PriorityBlockingQueue<E>.Node<E> node2 = this.lastRet;
                this.lastRet = null;
                Node node3 = PriorityBlockingQueue.this.head;
                do {
                    node = node3;
                    node3 = node3.next;
                    if (node3 != null) {
                    }
                } while (node3 != node2);
                PriorityBlockingQueue.this.unlink(node3, node);
            } finally {
                PriorityBlockingQueue.this.fullyUnlock();
            }
        }
    }

    public class Node<T> {
        public PriorityBlockingQueue<E>.Node<T> next;
        public PriorityObject<?> value;
        public boolean valueAsT = false;

        public Node(T t) {
            setValue(t);
        }

        public int getPriority() {
            return this.value.priority;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, cj.mobile.wm.okserver.task.PriorityObject, cj.mobile.wm.okserver.task.PriorityObject<?>] */
        public T getValue() {
            ?? r0 = (T) this.value;
            if (r0 == 0) {
                return null;
            }
            return this.valueAsT ? r0 : r0.obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setValue(T t) {
            if (t == 0) {
                this.value = null;
            } else if (!(t instanceof PriorityObject)) {
                this.value = new PriorityObject<>(0, t);
            } else {
                this.value = (PriorityObject) t;
                this.valueAsT = true;
            }
        }
    }

    public PriorityBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public PriorityBlockingQueue(int i) {
        this.count = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.takeLock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.putLock = reentrantLock2;
        this.notFull = reentrantLock2.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
    }

    public PriorityBlockingQueue(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            int i = 0;
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (i == this.capacity) {
                    throw new IllegalStateException(dexc.dexa("Rvfvf!gvmm"));
                }
                opQueue(new Node<>(e));
                i++;
            }
            this.count.set(i);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private E _dequeue() {
        PriorityBlockingQueue<E>.Node<E> node = this.head;
        PriorityBlockingQueue<E>.Node<E> node2 = (PriorityBlockingQueue<E>.Node<E>) node.next;
        node.next = node;
        this.head = node2;
        E value = node2.getValue();
        node2.setValue(null);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void _enqueue(PriorityBlockingQueue<E>.Node<E> node) {
        boolean z;
        Node node2 = this.head;
        while (true) {
            PriorityBlockingQueue<E>.Node<T> node3 = node2.next;
            if (node3 == 0) {
                z = false;
                break;
            } else {
                if (node3.getPriority() < node.getPriority()) {
                    node2.next = node;
                    node.next = node3;
                    z = true;
                    break;
                }
                node2 = node2.next;
            }
        }
        if (z) {
            return;
        }
        this.last.next = node;
        this.last = node;
    }

    private synchronized E opQueue(PriorityBlockingQueue<E>.Node<E> node) {
        try {
            if (node == null) {
                return _dequeue();
            }
            _enqueue(node);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                add(object);
            }
        }
    }

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        fullyLock();
        try {
            objectOutputStream.defaultWriteObject();
            Node node = this.head;
            while (true) {
                node = node.next;
                if (node == null) {
                    objectOutputStream.writeObject(null);
                    return;
                }
                objectOutputStream.writeObject(node.getValue());
            }
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [cj.mobile.wm.okserver.task.PriorityBlockingQueue$Node, cj.mobile.wm.okserver.task.PriorityBlockingQueue<E>$Node<T>] */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        fullyLock();
        try {
            ?? r0 = this.head;
            while (true) {
                Node node = r0.next;
                if (node == null) {
                    break;
                }
                r0.next = r0;
                node.setValue(null);
                r0 = (PriorityBlockingQueue<E>.Node<E>) node;
            }
            this.head = this.last;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node node = this.head;
            do {
                node = node.next;
                if (node == null) {
                    return false;
                }
            } while (!obj.equals(node.getValue()));
            return true;
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        collection.getClass();
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        boolean z = false;
        if (i <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            int iMin = Math.min(i, this.count.get());
            PriorityBlockingQueue<E>.Node<E> node = this.head;
            int i2 = 0;
            while (i2 < iMin) {
                try {
                    Node node2 = node.next;
                    collection.add((Object) node2.getValue());
                    node2.setValue(null);
                    node.next = (PriorityBlockingQueue<E>.Node<T>) node;
                    i2++;
                    node = (PriorityBlockingQueue<E>.Node<E>) node2;
                } catch (Throwable th) {
                    if (i2 > 0) {
                        this.head = (PriorityBlockingQueue<E>.Node<E>) node;
                        if (this.count.getAndAdd(-i2) == this.capacity) {
                        }
                    }
                    throw th;
                }
            }
            if (i2 > 0) {
                this.head = (PriorityBlockingQueue<E>.Node<E>) node;
                if (this.count.getAndAdd(-i2) == this.capacity) {
                    z = true;
                }
            }
            reentrantLock.unlock();
            if (z) {
                signalNotFull();
            }
            return iMin;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            if (0 != 0) {
                signalNotFull();
            }
            throw th2;
        }
    }

    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    public void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        int andIncrement;
        e.getClass();
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() == this.capacity) {
            return false;
        }
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.capacity) {
                opQueue(node);
                andIncrement = atomicInteger.getAndIncrement();
                if (andIncrement + 1 < this.capacity) {
                    this.notFull.signal();
                }
            } else {
                andIncrement = -1;
            }
            reentrantLock.unlock();
            if (andIncrement == 0) {
                signalNotEmpty();
            }
            return andIncrement >= 0;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        e.getClass();
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        opQueue(new Node<>(e));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        reentrantLock.unlock();
        if (andIncrement != 0) {
            return true;
        }
        signalNotEmpty();
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            PriorityBlockingQueue<E>.Node<E> node = this.head.next;
            if (node == null) {
                return null;
            }
            return node.getValue();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        int andDecrement;
        AtomicInteger atomicInteger = this.count;
        E eOpQueue = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                eOpQueue = opQueue(null);
                andDecrement = atomicInteger.getAndDecrement();
                if (andDecrement > 1) {
                    this.notEmpty.signal();
                }
            } else {
                andDecrement = -1;
            }
            reentrantLock.unlock();
            if (andDecrement == this.capacity) {
                signalNotFull();
            }
            return eOpQueue;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E eOpQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return eOpQueue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        e.getClass();
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                this.notFull.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        opQueue(node);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        reentrantLock.unlock();
        if (andIncrement == 0) {
            signalNotEmpty();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        Node node;
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node node2 = this.head;
            do {
                node = node2;
                node2 = node2.next;
                if (node2 == null) {
                    return false;
                }
            } while (!obj.equals(node2.getValue()));
            unlink(node2, node);
            return true;
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.count.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E eOpQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return eOpQueue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            Node node = this.head;
            int i = 0;
            while (true) {
                node = node.next;
                if (node == null) {
                    fullyUnlock();
                    return objArr;
                }
                int i2 = i + 1;
                objArr[i] = node.getValue();
                i = i2;
            }
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i = this.count.get();
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            Node node = this.head;
            int i2 = 0;
            while (true) {
                node = node.next;
                if (node == null) {
                    break;
                }
                tArr[i2] = node.getValue();
                i2++;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        } finally {
            fullyUnlock();
        }
    }

    public void unlink(PriorityBlockingQueue<E>.Node<E> node, PriorityBlockingQueue<E>.Node<E> node2) {
        node.setValue(null);
        node2.next = node.next;
        if (this.last == node) {
            this.last = node2;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }
}
