package com.zj.adlib;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hm8<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<V> f17027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Consumer<V> f17028a;

    public hm8() {
        this(new Consumer() { // from class: com.zj.adlib.gm8
            @Override // com.google.android.exoplayer2.util.Consumer
            public final void accept(Object obj) {
                hm8.i(obj);
            }
        });
    }

    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i, V v) {
        if (this.f42159a == -1) {
            sb0.i(this.f17027a.size() == 0);
            this.f42159a = 0;
        }
        if (this.f17027a.size() > 0) {
            SparseArray<V> sparseArray = this.f17027a;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            sb0.a(i >= iKeyAt);
            if (iKeyAt == i) {
                Consumer<V> consumer = this.f17028a;
                SparseArray<V> sparseArray2 = this.f17027a;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f17027a.append(i, v);
    }

    public void c() {
        for (int i = 0; i < this.f17027a.size(); i++) {
            this.f17028a.accept(this.f17027a.valueAt(i));
        }
        this.f42159a = -1;
        this.f17027a.clear();
    }

    public void d(int i) {
        for (int size = this.f17027a.size() - 1; size >= 0 && i < this.f17027a.keyAt(size); size--) {
            this.f17028a.accept(this.f17027a.valueAt(size));
            this.f17027a.removeAt(size);
        }
        this.f42159a = this.f17027a.size() > 0 ? Math.min(this.f42159a, this.f17027a.size() - 1) : -1;
    }

    public void e(int i) {
        int i2 = 0;
        while (i2 < this.f17027a.size() - 1) {
            int i3 = i2 + 1;
            if (i < this.f17027a.keyAt(i3)) {
                return;
            }
            this.f17028a.accept(this.f17027a.valueAt(i2));
            this.f17027a.removeAt(i2);
            int i4 = this.f42159a;
            if (i4 > 0) {
                this.f42159a = i4 - 1;
            }
            i2 = i3;
        }
    }

    public V f(int i) {
        if (this.f42159a == -1) {
            this.f42159a = 0;
        }
        while (true) {
            int i2 = this.f42159a;
            if (i2 <= 0 || i >= this.f17027a.keyAt(i2)) {
                break;
            }
            this.f42159a--;
        }
        while (this.f42159a < this.f17027a.size() - 1 && i >= this.f17027a.keyAt(this.f42159a + 1)) {
            this.f42159a++;
        }
        return this.f17027a.valueAt(this.f42159a);
    }

    public V g() {
        SparseArray<V> sparseArray = this.f17027a;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean h() {
        return this.f17027a.size() == 0;
    }

    public hm8(Consumer<V> consumer) {
        this.f17027a = new SparseArray<>();
        this.f17028a = consumer;
        this.f42159a = -1;
    }
}
