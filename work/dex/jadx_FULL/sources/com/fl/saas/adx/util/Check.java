package com.fl.saas.adx.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.B;
import com.fl.saas.C1428p0;
import com.fl.saas.b1;
import com.zj.adlib.sj1;
import com.zj.adlib.tj1;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Check {
    @NonNull
    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T, U> T checkNull(U u, Function<U, T> function) {
        if (u != null) {
            return function.apply(u);
        }
        return null;
    }

    public static <T> void clearNullList(List<? extends T> list) {
        if (isValidAdList(list)) {
            list.clear();
        }
    }

    public static <T, S> C1428p0 filterNullFindFirst(List<? extends T> list, Function<? super T, ? extends S> function) {
        return C1428p0.b(list).a((Function) new tj1()).a((Function) function);
    }

    public static <T> void filterNullList(List<? extends T> list, B b) {
        if (!isValidAdList(list) || b == null) {
            return;
        }
        for (T t : list) {
            if (t != null) {
                b.a(t);
            }
        }
    }

    @Nullable
    public static <T> T findFirstNonNull(@Nullable List<T> list) {
        if (list == null) {
            return null;
        }
        for (T t : list) {
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public static <T> C1428p0 getRefValue(WeakReference<T> weakReference) {
        return C1428p0.b(weakReference).a((Function) new sj1());
    }

    public static <T> void ifPresentOrElse(T t, B b, Runnable runnable) {
        if (t != null) {
            b.a(t);
        } else {
            runnable.run();
        }
    }

    public static boolean isValidAdList(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static <T> T[] listToArray(List<T> list) {
        if (list == null || list.isEmpty()) {
            return (T[]) new Object[0];
        }
        T[] tArr = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tArr[i] = list.get(i);
        }
        return tArr;
    }

    public static <T> T obtainNotNull(T t, b1 b1Var) {
        return t != null ? t : (T) b1Var.a();
    }

    public static <T> void checkNull(T t, B b) {
        if (t != null) {
            b.a(t);
        }
    }

    public static <T> void filterNullFindFirst(List<T> list, B b) {
        C1428p0.b(list).a((Function) new tj1()).a(b);
    }
}
