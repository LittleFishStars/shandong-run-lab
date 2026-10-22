package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class in1 {
    @KeepForSdk
    public static boolean a(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> b() {
        return Collections.emptyList();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> c(@NonNull T t) {
        return Collections.singletonList(t);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> d(@NonNull T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : c(tArr[0]);
        }
        return b();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> e(@NonNull K k, @NonNull V v, @NonNull K k2, @NonNull V v2, @NonNull K k3, @NonNull V v3) {
        Map mapK = k(3, false);
        mapK.put(k, v);
        mapK.put(k2, v2);
        mapK.put(k3, v3);
        return Collections.unmodifiableMap(mapK);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> f(@NonNull K k, @NonNull V v, @NonNull K k2, @NonNull V v2, @NonNull K k3, @NonNull V v3, @NonNull K k4, @NonNull V v4, @NonNull K k5, @NonNull V v5, @NonNull K k6, @NonNull V v6) {
        Map mapK = k(6, false);
        mapK.put(k, v);
        mapK.put(k2, v2);
        mapK.put(k3, v3);
        mapK.put(k4, v4);
        mapK.put(k5, v5);
        mapK.put(k6, v6);
        return Collections.unmodifiableMap(mapK);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> g(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map mapK = k(length, false);
        for (int i = 0; i < kArr.length; i++) {
            mapK.put(kArr[i], vArr[i]);
        }
        return Collections.unmodifiableMap(mapK);
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> h(int i) {
        return i == 0 ? new ArraySet() : l(i, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> i(@NonNull T t, @NonNull T t2, @NonNull T t3) {
        Set setL = l(3, false);
        setL.add(t);
        setL.add(t2);
        setL.add(t3);
        return Collections.unmodifiableSet(setL);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> j(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set setL = l(2, false);
            setL.add(t);
            setL.add(t2);
            return Collections.unmodifiableSet(setL);
        }
        if (length == 3) {
            return i(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set setL2 = l(length, false);
            Collections.addAll(setL2, tArr);
            return Collections.unmodifiableSet(setL2);
        }
        T t3 = tArr[0];
        T t4 = tArr[1];
        T t5 = tArr[2];
        T t6 = tArr[3];
        Set setL3 = l(4, false);
        setL3.add(t3);
        setL3.add(t4);
        setL3.add(t5);
        setL3.add(t6);
        return Collections.unmodifiableSet(setL3);
    }

    public static Map k(int i, boolean z) {
        return i <= 256 ? new ArrayMap(i) : new HashMap(i, 1.0f);
    }

    public static Set l(int i, boolean z) {
        return i <= (true != z ? 256 : 128) ? new ArraySet(i) : new HashSet(i, true != z ? 1.0f : 0.75f);
    }
}
