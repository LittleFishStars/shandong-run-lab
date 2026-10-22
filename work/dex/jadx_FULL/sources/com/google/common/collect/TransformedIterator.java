package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class TransformedIterator<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f31927a;

    public TransformedIterator(Iterator<? extends F> it) {
        this.f31927a = (Iterator) com.google.common.base.i.E(it);
    }

    @ParametricNullness
    abstract T a(@ParametricNullness F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f31927a.hasNext();
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        return a(this.f31927a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f31927a.remove();
    }
}
