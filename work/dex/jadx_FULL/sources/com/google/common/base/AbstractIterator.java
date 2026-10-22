package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f31547a = State.NOT_READY;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public T f5923a;

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31548a;

        static {
            int[] iArr = new int[State.values().length];
            f31548a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31548a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final boolean a() {
        this.f31547a = State.FAILED;
        this.f5923a = computeNext();
        if (this.f31547a == State.DONE) {
            return false;
        }
        this.f31547a = State.READY;
        return true;
    }

    @CheckForNull
    public abstract T computeNext();

    @CanIgnoreReturnValue
    @CheckForNull
    public final T endOfData() {
        this.f31547a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        i.g0(this.f31547a != State.FAILED);
        int i = a.f31548a[this.f31547a.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return a();
        }
        return true;
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f31547a = State.NOT_READY;
        T t = (T) f.a(this.f5923a);
        this.f5923a = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
