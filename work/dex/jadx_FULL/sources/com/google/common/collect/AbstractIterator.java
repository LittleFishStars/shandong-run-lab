package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f31654a = State.NOT_READY;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public T f6035a;

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31655a;

        static {
            int[] iArr = new int[State.values().length];
            f31655a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31655a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final boolean a() {
        this.f31654a = State.FAILED;
        this.f6035a = computeNext();
        if (this.f31654a == State.DONE) {
            return false;
        }
        this.f31654a = State.READY;
        return true;
    }

    @CheckForNull
    public abstract T computeNext();

    @CanIgnoreReturnValue
    @CheckForNull
    public final T endOfData() {
        this.f31654a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        com.google.common.base.i.g0(this.f31654a != State.FAILED);
        int i = a.f31655a[this.f31654a.ordinal()];
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
    @CanIgnoreReturnValue
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f31654a = State.NOT_READY;
        T t = (T) q.a(this.f6035a);
        this.f6035a = null;
        return t;
    }

    @ParametricNullness
    public final T peek() {
        if (hasNext()) {
            return (T) q.a(this.f6035a);
        }
        throw new NoSuchElementException();
    }
}
