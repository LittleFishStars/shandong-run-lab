package com.byazt.ydv;

import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 842, 20})
public abstract class c {
    public List<com.byazt.utw.a.tt> c;
    public n tt;

    public abstract int c();

    public com.byazt.utw.a.tt c(String str) {
        List<com.byazt.utw.a.tt> list;
        if (str != null && (list = this.c) != null && list.size() > 0) {
            for (com.byazt.utw.a.tt ttVar : this.c) {
                if (str.equals(ttVar.c)) {
                    return ttVar;
                }
            }
        }
        return null;
    }

    public abstract String c(String str, String str2);

    public n n() {
        return this.tt;
    }

    public abstract boolean tt();

    public abstract InputStream uj();

    public abstract List<com.byazt.utw.a.tt> ve();
}
