package com.byazt.ga;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 215})
public class yp<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28561a;
    public final LinkedHashMap<K, V> c;
    public int n;
    public int sp;
    public int tt;
    public int uj;
    public int ve;
    public int x;

    public yp(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.ve = i;
        this.c = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int ve(K k, V v) {
        int iTt = tt(k, v);
        if (iTt >= 0) {
            return iTt;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public void c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.ve = i;
        }
        tt(i);
    }

    public void c(boolean z, K k, V v, V v2) {
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.sp;
        i2 = this.x + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.ve), Integer.valueOf(this.sp), Integer.valueOf(this.x), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public int tt(K k, V v) {
        return 1;
    }

    public V tt(K k) {
        return null;
    }

    public void tt(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.tt < 0 || (this.c.isEmpty() && this.tt != 0)) {
                    break;
                }
                if (this.tt > i && !this.c.isEmpty()) {
                    Map.Entry<K, V> next = this.c.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.c.remove(key);
                    this.tt -= ve(key, value);
                    this.f28561a++;
                }
                return;
            }
            c(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final V c(K k) {
        V vPut;
        if (k != null) {
            synchronized (this) {
                V v = this.c.get(k);
                if (v != null) {
                    this.sp++;
                    return v;
                }
                this.x++;
                V vTt = tt(k);
                if (vTt == null) {
                    return null;
                }
                synchronized (this) {
                    this.n++;
                    vPut = this.c.put(k, vTt);
                    if (vPut != null) {
                        this.c.put(k, vPut);
                    } else {
                        this.tt += ve(k, vTt);
                    }
                }
                if (vPut != null) {
                    c(false, k, vTt, vPut);
                    return vPut;
                }
                tt(this.ve);
                return vTt;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V c(K k, V v) {
        V vPut;
        if (k != null && v != null) {
            synchronized (this) {
                this.uj++;
                this.tt += ve(k, v);
                vPut = this.c.put(k, v);
                if (vPut != null) {
                    this.tt -= ve(k, vPut);
                }
            }
            if (vPut != null) {
                c(false, k, vPut, v);
            }
            tt(this.ve);
            return vPut;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized Map<K, V> c() {
        return new LinkedHashMap(this.c);
    }

    public final synchronized boolean c(K k, int i) {
        if (k == null || i <= 0) {
            return false;
        }
        if (!this.c.containsKey(k)) {
            return false;
        }
        int size = this.c.size();
        if (size <= i) {
            return true;
        }
        Iterator<K> it = this.c.keySet().iterator();
        int i2 = 0;
        while (it.hasNext() && !it.next().equals(k)) {
            i2++;
        }
        return i2 >= size - i;
    }
}
