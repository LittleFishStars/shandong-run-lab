package com.blankj.utilcode.util;

import android.util.Pair;
import com.alibaba.android.arouter.routes.ARouter$$Group$$compat;
import com.efs.sdk.memleaksdk.monitor.shark.cn;
import com.ipd.dsp.internal.j.n;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.logging.impl.WeakHashtable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MapUtils {

    public interface Closure<K, V> {
        void a(K k, V v);
    }

    public interface Transformer<K1, V1, K2, V2> {
        Pair<K2, V2> a(K1 k1, V1 v1);
    }

    /* JADX INFO: Add missing generic type declarations: [K1, V1] */
    public class a<K1, V1> implements Closure<K1, V1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Transformer f28148a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f1308a;

        public a(Transformer transformer, Map map) {
            this.f28148a = transformer;
            this.f1308a = map;
        }

        @Override // com.blankj.utilcode.util.MapUtils.Closure
        public void a(K1 k1, V1 v1) {
            Pair pairA = this.f28148a.a(k1, v1);
            this.f1308a.put(pairA.first, pairA.second);
        }
    }

    public MapUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <K, V> void a(Map<K, V> map, Closure<K, V> closure) {
        if (map == null || closure == null) {
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            closure.a(entry.getKey(), entry.getValue());
        }
    }

    public static boolean b(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean c(Map map) {
        return !b(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> d(Pair<K, V>... pairArr) {
        ARouter$$Group$$compat.AnonymousClass3 anonymousClass3 = (HashMap<K, V>) new HashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    anonymousClass3.put(pair.first, pair.second);
                }
            }
        }
        return anonymousClass3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> Hashtable<K, V> e(Pair<K, V>... pairArr) {
        WeakHashtable weakHashtable = (Hashtable<K, V>) new Hashtable();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    weakHashtable.put(pair.first, pair.second);
                }
            }
        }
        return weakHashtable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> LinkedHashMap<K, V> f(Pair<K, V>... pairArr) {
        cn.AnonymousClass1 anonymousClass1 = (LinkedHashMap<K, V>) new LinkedHashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    anonymousClass1.put(pair.first, pair.second);
                }
            }
        }
        return anonymousClass1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> TreeMap<K, V> g(Comparator<K> comparator, Pair<K, V>... pairArr) {
        if (comparator == null) {
            throw new IllegalArgumentException("comparator must not be null");
        }
        n nVar = (TreeMap<K, V>) new TreeMap(comparator);
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    nVar.put(pair.first, pair.second);
                }
            }
        }
        return nVar;
    }

    @SafeVarargs
    public static <K, V> Map<K, V> h(Pair<K, V>... pairArr) {
        return Collections.unmodifiableMap(d(pairArr));
    }

    public static int i(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static String j(Map map) {
        return map == null ? "null" : map.toString();
    }

    public static <K1, V1, K2, V2> Map<K2, V2> k(Map<K1, V1> map, Transformer<K1, V1, K2, V2> transformer) {
        if (map != null && transformer != null) {
            try {
                Map<K2, V2> map2 = (Map) map.getClass().newInstance();
                a(map, new a(transformer, map2));
                return map2;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
