package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.i;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class Shorts extends ShortsMethodsForWeb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32241a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final short f6434a = 16384;

    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int iMin = Math.min(sArr.length, sArr2.length);
            for (int i = 0; i < iMin; i++) {
                int iE = Shorts.e(sArr[i], sArr2[i]);
                if (iE != 0) {
                    return iE;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Short) && Shorts.n(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != shortArrayAsList.array[shortArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iL = 1;
            for (int i = this.start; i < this.end; i++) {
                iL = (iL * 31) + Shorts.l(this.array[i]);
            }
            return iL;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int iN;
            if (!(obj instanceof Short) || (iN = Shorts.n(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iN - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int iR;
            if (!(obj instanceof Short) || (iR = Shorts.r(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iR - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i, int i2) {
            i.f0(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i3 = this.start;
            return new ShortArrayAsList(sArr, i + i3, i3 + i2);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.array[i]);
            }
        }

        public ShortArrayAsList(short[] sArr, int i, int i2) {
            this.array = sArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int i) {
            i.C(i, size());
            return Short.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int i, Short sh) {
            i.C(i, size());
            short[] sArr = this.array;
            int i2 = this.start;
            short s = sArr[i2 + i];
            sArr[i2 + i] = ((Short) i.E(sh)).shortValue();
            return Short.valueOf(s);
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Short sh) {
            return sh.toString();
        }

        @Override // com.google.common.base.Converter
        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    @Beta
    public static Converter<String, Short> A() {
        return ShortConverter.INSTANCE;
    }

    public static short[] B(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = ((Number) i.E(array[i])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] C(short s) {
        return new byte[]{(byte) (s >> 8), (byte) s};
    }

    public static List<Short> c(short... sArr) {
        return sArr.length == 0 ? Collections.emptyList() : new ShortArrayAsList(sArr);
    }

    public static short d(long j) {
        short s = (short) j;
        i.p(((long) s) == j, "Out of range: %s", j);
        return s;
    }

    public static int e(short s, short s2) {
        return s - s2;
    }

    public static short[] f(short[]... sArr) {
        int length = 0;
        for (short[] sArr2 : sArr) {
            length += sArr2.length;
        }
        short[] sArr3 = new short[length];
        int length2 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, length2, sArr4.length);
            length2 += sArr4.length;
        }
        return sArr3;
    }

    @Beta
    public static short g(short s, short s2, short s3) {
        i.m(s2 <= s3, "min (%s) must be less than or equal to max (%s)", s2, s3);
        if (s < s2) {
            return s2;
        }
        return s < s3 ? s : s3;
    }

    public static boolean h(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static short[] i(short[] sArr, int i, int i2) {
        i.k(i >= 0, "Invalid minLength: %s", i);
        i.k(i2 >= 0, "Invalid padding: %s", i2);
        return sArr.length < i ? Arrays.copyOf(sArr, i + i2) : sArr;
    }

    @GwtIncompatible
    public static short j(byte[] bArr) {
        i.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short k(byte b, byte b2) {
        return (short) ((b << 8) | (b2 & 255));
    }

    public static int l(short s) {
        return s;
    }

    public static int m(short[] sArr, short s) {
        return n(sArr, s, 0, sArr.length);
    }

    public static int n(short[] sArr, short s, int i, int i2) {
        while (i < i2) {
            if (sArr[i] == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int o(short[] sArr, short[] sArr2) {
        i.F(sArr, "array");
        i.F(sArr2, "target");
        if (sArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (sArr.length - sArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < sArr2.length; i2++) {
                if (sArr[i + i2] != sArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static String p(String str, short... sArr) {
        i.E(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i = 1; i < sArr.length; i++) {
            sb.append(str);
            sb.append((int) sArr[i]);
        }
        return sb.toString();
    }

    public static int q(short[] sArr, short s) {
        return r(sArr, s, 0, sArr.length);
    }

    public static int r(short[] sArr, short s, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (sArr[i3] == s) {
                return i3;
            }
        }
        return -1;
    }

    public static Comparator<short[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short t(short... sArr) {
        i.d(sArr.length > 0);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short u(short... sArr) {
        i.d(sArr.length > 0);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }

    public static void v(short[] sArr) {
        i.E(sArr);
        w(sArr, 0, sArr.length);
    }

    public static void w(short[] sArr, int i, int i2) {
        i.E(sArr);
        i.f0(i, i2, sArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            short s = sArr[i];
            sArr[i] = sArr[i3];
            sArr[i3] = s;
            i++;
        }
    }

    public static short x(long j) {
        if (j > 32767) {
            return Short.MAX_VALUE;
        }
        if (j < -32768) {
            return Short.MIN_VALUE;
        }
        return (short) j;
    }

    public static void y(short[] sArr) {
        i.E(sArr);
        z(sArr, 0, sArr.length);
    }

    public static void z(short[] sArr, int i, int i2) {
        i.E(sArr);
        i.f0(i, i2, sArr.length);
        Arrays.sort(sArr, i, i2);
        w(sArr, i, i2);
    }
}
