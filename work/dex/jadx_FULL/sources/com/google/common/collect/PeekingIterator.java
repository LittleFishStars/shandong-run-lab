package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Use Iterators.peekingIterator")
@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @ParametricNullness
    @CanIgnoreReturnValue
    E next();

    @ParametricNullness
    E peek();

    @Override // java.util.Iterator
    void remove();
}
