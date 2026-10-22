package com.zj.adlib;

import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e76 {
    public e76() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A(Map map) {
        return !p(map);
    }

    public static <T> T B(T t) {
        t.getClass();
        return t;
    }

    public static <T> T C(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void D(Object... objArr) {
        objArr.getClass();
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    public static String E(Object obj) {
        return String.valueOf(obj);
    }

    public static String F(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> int a(T t, T t2, @NonNull Comparator<? super T> comparator) {
        if (t == t2) {
            return 0;
        }
        return comparator.compare(t, t2);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T c(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static int d(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int e(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @RequiresApi(api = 16)
    public static boolean f(LongSparseArray longSparseArray) {
        return longSparseArray == null || longSparseArray.size() == 0;
    }

    public static boolean g(SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    public static boolean h(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray == null || sparseBooleanArray.size() == 0;
    }

    public static boolean i(SparseIntArray sparseIntArray) {
        return sparseIntArray == null || sparseIntArray.size() == 0;
    }

    @RequiresApi(api = 18)
    public static boolean j(SparseLongArray sparseLongArray) {
        return sparseLongArray == null || sparseLongArray.size() == 0;
    }

    public static boolean k(androidx.collection.LongSparseArray longSparseArray) {
        return longSparseArray == null || longSparseArray.size() == 0;
    }

    public static boolean l(SimpleArrayMap simpleArrayMap) {
        return simpleArrayMap == null || simpleArrayMap.isEmpty();
    }

    public static boolean m(CharSequence charSequence) {
        return charSequence == null || charSequence.toString().length() == 0;
    }

    public static boolean n(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if ((obj instanceof CharSequence) && obj.toString().length() == 0) {
            return true;
        }
        if ((obj instanceof Collection) && ((Collection) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof SimpleArrayMap) && ((SimpleArrayMap) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof SparseArray) && ((SparseArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof SparseBooleanArray) && ((SparseBooleanArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof SparseIntArray) && ((SparseIntArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof SparseLongArray) && ((SparseLongArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof androidx.collection.LongSparseArray) && ((androidx.collection.LongSparseArray) obj).size() == 0) {
            return true;
        }
        return (obj instanceof LongSparseArray) && ((LongSparseArray) obj).size() == 0;
    }

    public static boolean o(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean p(Map map) {
        return map == null || map.isEmpty();
    }

    @RequiresApi(api = 16)
    public static boolean q(LongSparseArray longSparseArray) {
        return !f(longSparseArray);
    }

    public static boolean r(SparseArray sparseArray) {
        return !g(sparseArray);
    }

    public static boolean s(SparseBooleanArray sparseBooleanArray) {
        return !h(sparseBooleanArray);
    }

    public static boolean t(SparseIntArray sparseIntArray) {
        return !i(sparseIntArray);
    }

    @RequiresApi(api = 18)
    public static boolean u(SparseLongArray sparseLongArray) {
        return !j(sparseLongArray);
    }

    public static boolean v(androidx.collection.LongSparseArray longSparseArray) {
        return !k(longSparseArray);
    }

    public static boolean w(SimpleArrayMap simpleArrayMap) {
        return !l(simpleArrayMap);
    }

    public static boolean x(CharSequence charSequence) {
        return !m(charSequence);
    }

    public static boolean y(Object obj) {
        return !n(obj);
    }

    public static boolean z(Collection collection) {
        return !o(collection);
    }
}
