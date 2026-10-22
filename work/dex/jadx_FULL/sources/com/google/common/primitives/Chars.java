package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
public final class Chars {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32232a = 2;

    @GwtCompatible
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Character) && Chars.n(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != charArrayAsList.array[charArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iL = 1;
            for (int i = this.start; i < this.end; i++) {
                iL = (iL * 31) + Chars.l(this.array[i]);
            }
            return iL;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int iN;
            if (!(obj instanceof Character) || (iN = Chars.n(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Character) || (iR = Chars.r(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iR - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i, int i2) {
            i.f0(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i3 = this.start;
            return new CharArrayAsList(cArr, i + i3, i3 + i2);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
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

        public CharArrayAsList(char[] cArr, int i, int i2) {
            this.array = cArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i) {
            i.C(i, size());
            return Character.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Character set(int i, Character ch) {
            i.C(i, size());
            char[] cArr = this.array;
            int i2 = this.start;
            char c = cArr[i2 + i];
            cArr[i2 + i] = ((Character) i.E(ch)).charValue();
            return Character.valueOf(c);
        }
    }

    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int iMin = Math.min(cArr.length, cArr2.length);
            for (int i = 0; i < iMin; i++) {
                int iE = Chars.e(cArr[i], cArr2[i]);
                if (iE != 0) {
                    return iE;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    public static char[] A(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = ((Character) i.E(array[i])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] B(char c) {
        return new byte[]{(byte) (c >> '\b'), (byte) c};
    }

    public static List<Character> c(char... cArr) {
        return cArr.length == 0 ? Collections.emptyList() : new CharArrayAsList(cArr);
    }

    public static char d(long j) {
        char c = (char) j;
        i.p(((long) c) == j, "Out of range: %s", j);
        return c;
    }

    public static int e(char c, char c2) {
        return c - c2;
    }

    public static char[] f(char[]... cArr) {
        int length = 0;
        for (char[] cArr2 : cArr) {
            length += cArr2.length;
        }
        char[] cArr3 = new char[length];
        int length2 = 0;
        for (char[] cArr4 : cArr) {
            System.arraycopy(cArr4, 0, cArr3, length2, cArr4.length);
            length2 += cArr4.length;
        }
        return cArr3;
    }

    @Beta
    public static char g(char c, char c2, char c3) {
        i.g(c2 <= c3, "min (%s) must be less than or equal to max (%s)", c2, c3);
        if (c < c2) {
            return c2;
        }
        return c < c3 ? c : c3;
    }

    public static boolean h(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static char[] i(char[] cArr, int i, int i2) {
        i.k(i >= 0, "Invalid minLength: %s", i);
        i.k(i2 >= 0, "Invalid padding: %s", i2);
        return cArr.length < i ? Arrays.copyOf(cArr, i + i2) : cArr;
    }

    @GwtIncompatible
    public static char j(byte[] bArr) {
        i.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static char k(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & 255));
    }

    public static int l(char c) {
        return c;
    }

    public static int m(char[] cArr, char c) {
        return n(cArr, c, 0, cArr.length);
    }

    public static int n(char[] cArr, char c, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int o(char[] cArr, char[] cArr2) {
        i.F(cArr, "array");
        i.F(cArr2, "target");
        if (cArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (cArr.length - cArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < cArr2.length; i2++) {
                if (cArr[i + i2] != cArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static String p(String str, char... cArr) {
        i.E(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i = 1; i < length; i++) {
            sb.append(str);
            sb.append(cArr[i]);
        }
        return sb.toString();
    }

    public static int q(char[] cArr, char c) {
        return r(cArr, c, 0, cArr.length);
    }

    public static int r(char[] cArr, char c, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (cArr[i3] == c) {
                return i3;
            }
        }
        return -1;
    }

    public static Comparator<char[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char t(char... cArr) {
        i.d(cArr.length > 0);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 > c) {
                c = c2;
            }
        }
        return c;
    }

    public static char u(char... cArr) {
        i.d(cArr.length > 0);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 < c) {
                c = c2;
            }
        }
        return c;
    }

    public static void v(char[] cArr) {
        i.E(cArr);
        w(cArr, 0, cArr.length);
    }

    public static void w(char[] cArr, int i, int i2) {
        i.E(cArr);
        i.f0(i, i2, cArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            char c = cArr[i];
            cArr[i] = cArr[i3];
            cArr[i3] = c;
            i++;
        }
    }

    public static char x(long j) {
        if (j > 65535) {
            return (char) 65535;
        }
        if (j < 0) {
            return (char) 0;
        }
        return (char) j;
    }

    public static void y(char[] cArr) {
        i.E(cArr);
        z(cArr, 0, cArr.length);
    }

    public static void z(char[] cArr, int i, int i2) {
        i.E(cArr);
        i.f0(i, i2, cArr.length);
        Arrays.sort(cArr, i, i2);
        w(cArr, i, i2);
    }
}
