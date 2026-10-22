package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class e<T> extends AbstractIterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<T> f31971a;

    public e(Queue<T> queue) {
        this.f31971a = (Queue) com.google.common.base.i.E(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    @CheckForNull
    public T computeNext() {
        return this.f31971a.isEmpty() ? endOfData() : this.f31971a.remove();
    }
}
