package com.byazt.ep;

import com.byazt.nr.m;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1555, 54})
public class ve<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28477a;
    public final LinkedHashMap<K, SoftReference<V>> c;
    public int n;
    public int sp;
    public int tt;
    public int uj;
    public int ve;
    public int x;

    public ve(int i) {
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

    public final V c(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.c.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.sp++;
                    return v;
                }
                this.c.remove(k);
            } else {
                v = null;
            }
            this.x++;
            V vTt = tt(k);
            if (vTt == null) {
                return null;
            }
            synchronized (this) {
                this.n++;
                SoftReference<V> softReferencePut = this.c.put(k, new SoftReference<>(vTt));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.c.put(k, softReferencePut);
                } else {
                    this.tt += ve(k, vTt);
                }
            }
            if (v != null) {
                return v;
            }
            c(this.ve);
            return vTt;
        }
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.sp;
        i2 = this.x + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.ve), Integer.valueOf(this.sp), Integer.valueOf(this.x), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public int tt(K k, V v) {
        return 1;
    }

    public V tt(K k) {
        return null;
    }

    public final V c(K k, V v) {
        V v2;
        if (k != null && v != null) {
            synchronized (this) {
                this.uj++;
                this.tt += ve(k, v);
                SoftReference<V> softReferencePut = this.c.put(k, new SoftReference<>(v));
                if (softReferencePut != null) {
                    v2 = softReferencePut.get();
                    if (v2 != null) {
                        this.tt -= ve(k, v2);
                    }
                } else {
                    v2 = null;
                }
            }
            c(this.ve);
            return v2;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public void c(int i) {
        while (true) {
            synchronized (this) {
                if (this.tt < 0 || (this.c.isEmpty() && this.tt != 0)) {
                    break;
                    break;
                }
                if (this.tt <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.c.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.c.remove(key);
                if (value != null) {
                    this.tt -= ve(key, value.get());
                }
                this.f28477a++;
            }
        }
        m.uj("LruCache", "oom maybe occured, clear cache. size= " + this.tt + ", maxSize: " + i);
        this.tt = 0;
        this.c.clear();
    }

    public final void c() {
        c(-1);
    }
}
