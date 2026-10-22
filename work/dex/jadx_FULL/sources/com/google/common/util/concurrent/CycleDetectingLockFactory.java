package com.google.common.util.concurrent;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@CanIgnoreReturnValue
public class CycleDetectingLockFactory {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Policy f6530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, b>> f6528a = new MapMaker().l().i();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f6529a = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<b>> f32364a = new a();

    public interface CycleDetectingLock {
        b getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final b lockGraphNode;

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, b bVar, boolean z, a aVar) {
            this(bVar, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public b getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        private CycleDetectingReentrantLock(b bVar, boolean z) {
            super(z);
            this.lockGraphNode = (b) com.google.common.base.i.E(bVar);
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }
    }

    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final b lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, b bVar, boolean z, a aVar) {
            this(cycleDetectingLockFactory, bVar, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public b getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, b bVar, boolean z) {
            super(z);
            this.readLock = cycleDetectingLockFactory.new CycleDetectingReentrantReadLock(this);
            this.writeLock = cycleDetectingLockFactory.new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = (b) com.google.common.base.i.E(bVar);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    public static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), b.class.getName());

        public ExampleStackTrace(b bVar, b bVar2) {
            String strD = bVar.d();
            String strD2 = bVar2.d();
            StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 4 + String.valueOf(strD2).length());
            sb.append(strD);
            sb.append(" -> ");
            sb.append(strD2);
            super(sb.toString());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (c.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else {
                    if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                        return;
                    }
                }
            }
        }
    }

    @Beta
    public enum Policies implements Policy {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f6529a.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        /* synthetic */ Policies(a aVar) {
            this();
        }
    }

    @Beta
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    @Beta
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        public /* synthetic */ PotentialDeadlockException(b bVar, b bVar2, ExampleStackTrace exampleStackTrace, a aVar) {
            this(bVar, bVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable cause = this.conflictingStackTrace; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }

        private PotentialDeadlockException(b bVar, b bVar2, ExampleStackTrace exampleStackTrace) {
            super(bVar, bVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    public class a extends ThreadLocal<ArrayList<b>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<b> initialValue() {
            return Lists.u(3);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f32365a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<b, ExampleStackTrace> f6531a = new MapMaker().l().i();
        public final Map<b, PotentialDeadlockException> b = new MapMaker().l().i();

        public b(String str) {
            this.f32365a = (String) com.google.common.base.i.E(str);
        }

        public void a(Policy policy, b bVar) {
            com.google.common.base.i.x0(this != bVar, "Attempted to acquire multiple locks with the same rank %s", bVar.d());
            if (this.f6531a.containsKey(bVar)) {
                return;
            }
            PotentialDeadlockException potentialDeadlockException = this.b.get(bVar);
            a aVar = null;
            if (potentialDeadlockException != null) {
                policy.handlePotentialDeadlock(new PotentialDeadlockException(bVar, this, potentialDeadlockException.getConflictingStackTrace(), aVar));
                return;
            }
            ExampleStackTrace exampleStackTraceC = bVar.c(this, Sets.z());
            if (exampleStackTraceC == null) {
                this.f6531a.put(bVar, new ExampleStackTrace(bVar, this));
                return;
            }
            PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(bVar, this, exampleStackTraceC, aVar);
            this.b.put(bVar, potentialDeadlockException2);
            policy.handlePotentialDeadlock(potentialDeadlockException2);
        }

        public void b(Policy policy, List<b> list) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                a(policy, it.next());
            }
        }

        @CheckForNull
        public final ExampleStackTrace c(b bVar, Set<b> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.f6531a.get(bVar);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry<b, ExampleStackTrace> entry : this.f6531a.entrySet()) {
                b key = entry.getKey();
                ExampleStackTrace exampleStackTraceC = key.c(bVar, set);
                if (exampleStackTraceC != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(key, this);
                    exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                    exampleStackTrace2.initCause(exampleStackTraceC);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        public String d() {
            return this.f32365a;
        }
    }

    @Beta
    public static final class c<E extends Enum<E>> extends CycleDetectingLockFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<E, b> f32366a;

        @VisibleForTesting
        public c(Policy policy, Map<E, b> map) {
            super(policy, null);
            this.f32366a = map;
        }

        public ReentrantLock o(E e) {
            return p(e, false);
        }

        public ReentrantLock p(E e, boolean z) {
            if (super.f6530a == Policies.DISABLED) {
                return new ReentrantLock(z);
            }
            b bVar = this.f32366a.get(e);
            Objects.requireNonNull(bVar);
            return new CycleDetectingReentrantLock(this, bVar, z, null);
        }

        public ReentrantReadWriteLock q(E e) {
            return r(e, false);
        }

        public ReentrantReadWriteLock r(E e, boolean z) {
            if (super.f6530a == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z);
            }
            b bVar = this.f32366a.get(e);
            Objects.requireNonNull(bVar);
            return new CycleDetectingReentrantReadWriteLock(this, bVar, z, null);
        }
    }

    public /* synthetic */ CycleDetectingLockFactory(Policy policy, a aVar) {
        this(policy);
    }

    @VisibleForTesting
    public static <E extends Enum<E>> Map<E, b> e(Class<E> cls) {
        EnumMap enumMapW = Maps.W(cls);
        E[] enumConstants = cls.getEnumConstants();
        int length = enumConstants.length;
        ArrayList arrayListU = Lists.u(length);
        int i = 0;
        for (E e : enumConstants) {
            b bVar = new b(f(e));
            arrayListU.add(bVar);
            enumMapW.put(e, bVar);
        }
        for (int i2 = 1; i2 < length; i2++) {
            ((b) arrayListU.get(i2)).b(Policies.THROW, arrayListU.subList(0, i2));
        }
        while (i < length - 1) {
            i++;
            ((b) arrayListU.get(i)).b(Policies.DISABLED, arrayListU.subList(i, length));
        }
        return Collections.unmodifiableMap(enumMapW);
    }

    public static String f(Enum<?> r3) {
        String simpleName = r3.getDeclaringClass().getSimpleName();
        String strName = r3.name();
        StringBuilder sb = new StringBuilder(simpleName.length() + 1 + String.valueOf(strName).length());
        sb.append(simpleName);
        sb.append(Consts.DOT);
        sb.append(strName);
        return sb.toString();
    }

    public static <E extends Enum<E>> Map<? extends E, b> g(Class<E> cls) {
        ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, b>> concurrentMap = f6528a;
        Map<? extends E, b> map = (Map) concurrentMap.get(cls);
        if (map != null) {
            return map;
        }
        Map<? extends Enum<?>, b> mapE = e(cls);
        return (Map) com.google.common.base.e.a(concurrentMap.putIfAbsent(cls, mapE), mapE);
    }

    public static void h(CycleDetectingLock cycleDetectingLock) {
        if (cycleDetectingLock.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<b> arrayList = f32364a.get();
        b lockGraphNode = cycleDetectingLock.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public static CycleDetectingLockFactory i(Policy policy) {
        return new CycleDetectingLockFactory(policy);
    }

    public static <E extends Enum<E>> c<E> j(Class<E> cls, Policy policy) {
        com.google.common.base.i.E(cls);
        com.google.common.base.i.E(policy);
        return new c<>(policy, g(cls));
    }

    public final void a(CycleDetectingLock cycleDetectingLock) {
        if (cycleDetectingLock.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<b> arrayList = f32364a.get();
        b lockGraphNode = cycleDetectingLock.getLockGraphNode();
        lockGraphNode.b(this.f6530a, arrayList);
        arrayList.add(lockGraphNode);
    }

    public ReentrantLock k(String str) {
        return l(str, false);
    }

    public ReentrantLock l(String str, boolean z) {
        return this.f6530a == Policies.DISABLED ? new ReentrantLock(z) : new CycleDetectingReentrantLock(this, new b(str), z, null);
    }

    public ReentrantReadWriteLock m(String str) {
        return n(str, false);
    }

    public ReentrantReadWriteLock n(String str, boolean z) {
        return this.f6530a == Policies.DISABLED ? new ReentrantReadWriteLock(z) : new CycleDetectingReentrantReadWriteLock(this, new b(str), z, null);
    }

    public CycleDetectingLockFactory(Policy policy) {
        this.f6530a = (Policy) com.google.common.base.i.E(policy);
    }

    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {

        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }
    }

    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {

        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }
    }
}
