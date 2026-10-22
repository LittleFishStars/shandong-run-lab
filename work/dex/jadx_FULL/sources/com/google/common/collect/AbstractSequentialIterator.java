package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public T f31672a;

    public AbstractSequentialIterator(@CheckForNull T t) {
        this.f31672a = t;
    }

    @CheckForNull
    public abstract T computeNext(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f31672a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t = this.f31672a;
        if (t == null) {
            throw new NoSuchElementException();
        }
        this.f31672a = computeNext(t);
        return t;
    }
}
