package com.byazt.gqp;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 323, 46})
public final class n extends z {
    public List<String> c;
    public List<String> tt;

    public n(List<String> list, List<String> list2) {
        this.c = list;
        this.tt = list2;
    }

    @com.byazt.zqa.c(c = {0, 1, 323, 151})
    public static final class c {
        public final List<String> c = new ArrayList();
        public final List<String> tt = new ArrayList();

        public c c(String str, String str2) {
            this.c.add(str);
            this.tt.add(str2);
            return this;
        }

        public n c() {
            return new n(this.c, this.tt);
        }
    }
}
