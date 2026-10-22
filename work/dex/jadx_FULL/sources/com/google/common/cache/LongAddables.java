package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Supplier<LongAddable> f31644a;

    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    public class a implements Supplier<LongAddable> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LongAddable get() {
            return new LongAdder();
        }
    }

    public class b implements Supplier<LongAddable> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LongAddable get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        Supplier<LongAddable> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f31644a = bVar;
    }

    public static LongAddable a() {
        return f31644a.get();
    }
}
