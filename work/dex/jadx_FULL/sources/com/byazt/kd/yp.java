package com.byazt.kd;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1714, 215})
public abstract class yp<V, O> implements u<V, O> {
    public final List<com.byazt.vc.c<V>> c;

    public yp(List<com.byazt.vc.c<V>> list) {
        this.c = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.c.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.c.toArray()));
        }
        return sb.toString();
    }

    @Override // com.byazt.kd.u
    public boolean tt() {
        return this.c.isEmpty() || (this.c.size() == 1 && this.c.get(0).n());
    }

    @Override // com.byazt.kd.u
    public List<com.byazt.vc.c<V>> ve() {
        return this.c;
    }
}
