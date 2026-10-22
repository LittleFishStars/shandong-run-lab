package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((Integer) obj2).intValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i) {
            return Integer.valueOf(this.parent.get(i));
        }
    }

    @CanIgnoreReturnValue
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32236a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f6431a;

        public b(int i) {
            this.f6431a = new int[i];
        }

        public static int h(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public b a(int i) {
            g(1);
            int[] iArr = this.f6431a;
            int i2 = this.f32236a;
            iArr[i2] = i;
            this.f32236a = i2 + 1;
            return this;
        }

        public b b(ImmutableIntArray immutableIntArray) {
            g(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.f6431a, this.f32236a, immutableIntArray.length());
            this.f32236a += immutableIntArray.length();
            return this;
        }

        public b c(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().intValue());
            }
            return this;
        }

        public b d(Collection<Integer> collection) {
            g(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f6431a;
                int i = this.f32236a;
                this.f32236a = i + 1;
                iArr[i] = num.intValue();
            }
            return this;
        }

        public b e(int[] iArr) {
            g(iArr.length);
            System.arraycopy(iArr, 0, this.f6431a, this.f32236a, iArr.length);
            this.f32236a += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray f() {
            if (this.f32236a == 0) {
                return ImmutableIntArray.EMPTY;
            }
            return new ImmutableIntArray(this.f6431a, 0, this.f32236a);
        }

        public final void g(int i) {
            int i2 = this.f32236a + i;
            int[] iArr = this.f6431a;
            if (i2 > iArr.length) {
                this.f6431a = Arrays.copyOf(iArr, h(iArr.length, i2));
            }
        }
    }

    public static b builder(int i) {
        i.k(i >= 0, "Invalid initialCapacity: %s", i);
        return new b(i);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        i.C(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int iL = 1;
        for (int i = this.start; i < this.end; i++) {
            iL = (iL * 31) + Ints.l(this.array[i]);
        }
        return iL;
    }

    public int indexOf(int i) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (this.array[i2] == i) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i) {
        int i2;
        int i3 = this.end;
        do {
            i3--;
            i2 = this.start;
            if (i3 < i2) {
                return -1;
            }
        } while (this.array[i3] != i);
        return i3 - i2;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i, int i2) {
        i.f0(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new ImmutableIntArray(iArr, i + i3, i3 + i2);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.array[i]);
        }
    }

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.B(collection));
    }

    public static ImmutableIntArray of(int i) {
        return new ImmutableIntArray(new int[]{i});
    }

    private ImmutableIntArray(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().c(iterable).f();
    }

    public static ImmutableIntArray of(int i, int i2) {
        return new ImmutableIntArray(new int[]{i, i2});
    }

    public static ImmutableIntArray of(int i, int i2, int i3) {
        return new ImmutableIntArray(new int[]{i, i2, i3});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray of(int i, int... iArr) {
        i.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
