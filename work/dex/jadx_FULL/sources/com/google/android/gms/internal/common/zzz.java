package com.google.android.gms.internal.common;

import com.zj.adlib.lqd;
import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NullMarked
abstract class zzz extends zzak {
    public final int K;
    public int L;

    public zzz(int i, int i2) {
        lqd.b(i2, i, "index");
        this.K = i;
        this.L = i2;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.L < this.K;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.L > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.L;
        this.L = i + 1;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.L;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.L - 1;
        this.L = i;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.L - 1;
    }

    public abstract Object zza(int i);
}
