package cj.mobile.wm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s2<T> implements v2<T> {
    public final Collection<? extends v2<T>> dexa;
    public String dexb;

    @SafeVarargs
    public s2(v2<T>... v2VarArr) {
        if (v2VarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.dexa = Arrays.asList(v2VarArr);
    }

    @Override // cj.mobile.wm.v2
    public n3<T> dexa(n3<T> n3Var, int i, int i2) {
        Iterator<? extends v2<T>> it = this.dexa.iterator();
        n3<T> n3Var2 = n3Var;
        while (it.hasNext()) {
            n3<T> n3VarDexa = it.next().dexa(n3Var2, i, i2);
            if (n3Var2 != null && !n3Var2.equals(n3Var) && !n3Var2.equals(n3VarDexa)) {
                n3Var2.b();
            }
            n3Var2 = n3VarDexa;
        }
        return n3Var2;
    }

    @Override // cj.mobile.wm.v2
    public String getId() {
        if (this.dexb == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends v2<T>> it = this.dexa.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getId());
            }
            this.dexb = sb.toString();
        }
        return this.dexb;
    }
}
