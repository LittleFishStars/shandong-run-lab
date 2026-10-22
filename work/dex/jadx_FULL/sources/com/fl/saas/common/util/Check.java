package com.fl.saas.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.zj.adlib.rj1;
import com.zj.adlib.sj1;
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

    public static <T> void checkNull(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }

    public static <T> void clearNullList(List<? extends T> list) {
        if (isValidAdList(list)) {
            list.clear();
        }
    }

    public static <T, S> Optional<S> filterNullFindFirst(List<? extends T> list, Function<? super T, ? extends S> function) {
        return Optional.ofNullable(list).map(new rj1()).map(function);
    }

    public static <T> void filterNullFindFirst(List<T> list, Consumer<? super T> consumer) {
        Optional.ofNullable(list).map(new rj1()).ifPresent(consumer);
    }

    public static <T> void filterNullList(List<? extends T> list, Consumer<T> consumer) {
        if (!isValidAdList(list) || consumer == null) {
            return;
        }
        for (T t : list) {
            if (t != null) {
                consumer.accept(t);
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

    public static <T> Optional<T> getRefValue(WeakReference<T> weakReference) {
        return Optional.ofNullable(weakReference).map(new sj1());
    }

    public static <T> void ifPresentOrElse(T t, Consumer<? super T> consumer, Runnable runnable) {
        if (t != null) {
            consumer.accept(t);
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

    public static <T> T obtainNotNull(T t, Supplier<T> supplier) {
        return t != null ? t : supplier.get();
    }
}
