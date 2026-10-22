package cj.mobile.wm;

import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c7 implements t2<InputStream, y6> {
    public final t2<q4, y6> dexa;

    public c7(t2<q4, y6> t2Var) {
        this.dexa = t2Var;
    }

    @Override // cj.mobile.wm.t2
    public n3<y6> dexa(InputStream inputStream, int i, int i2) {
        return this.dexa.dexa(new q4(inputStream, null), i, i2);
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        return this.dexa.getId();
    }
}
