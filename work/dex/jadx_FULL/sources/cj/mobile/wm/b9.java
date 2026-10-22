package cj.mobile.wm;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b9<T, Y> {
    public int dexb;
    public final int dexc;
    public final LinkedHashMap<T, Y> dexa = new LinkedHashMap<>(100, 0.75f, true);
    public int dexd = 0;

    public b9(int i) {
        this.dexc = i;
        this.dexb = i;
    }

    private void dexb() {
        dexa(this.dexb);
    }

    public void a() {
        dexa(0);
    }

    public int dexa() {
        return this.dexd;
    }

    public Y dexa(T t) {
        return this.dexa.get(t);
    }

    public void dexa(int i) {
        while (this.dexd > i) {
            Map.Entry<T, Y> next = this.dexa.entrySet().iterator().next();
            Y value = next.getValue();
            this.dexd -= dexb(value);
            T key = next.getKey();
            this.dexa.remove(key);
            dexa(key, value);
        }
    }

    public void dexa(T t, Y y) {
    }

    public int dexb(Y y) {
        return 1;
    }

    public Y dexb(T t, Y y) {
        if (dexb(y) >= this.dexb) {
            dexa(t, y);
            return null;
        }
        Y yPut = this.dexa.put(t, y);
        if (y != null) {
            this.dexd += dexb(y);
        }
        if (yPut != null) {
            this.dexd -= dexb(yPut);
        }
        dexb();
        return yPut;
    }

    public Y dexc(T t) {
        Y yRemove = this.dexa.remove(t);
        if (yRemove != null) {
            this.dexd -= dexb(yRemove);
        }
        return yRemove;
    }
}
