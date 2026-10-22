package cj.mobile.wm;

import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b5<T> implements v4<URL, T> {
    public final v4<n4, T> dexa;

    public b5(v4<n4, T> v4Var) {
        this.dexa = v4Var;
    }

    @Override // cj.mobile.wm.v4
    public y2<T> dexa(URL url, int i, int i2) {
        return this.dexa.dexa(new n4(url), i, i2);
    }
}
