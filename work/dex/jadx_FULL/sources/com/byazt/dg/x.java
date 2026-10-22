package com.byazt.dg;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 71})
public class x {
    public final List<c<com.byazt.jx.yp, Path>> c;
    public final List<c<Integer, Integer>> tt;
    public final List<com.byazt.jx.x> ve;

    public x(List<com.byazt.jx.x> list) {
        this.ve = list;
        this.c = new ArrayList(list.size());
        this.tt = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.c.add(list.get(i).tt().c());
            this.tt.add(list.get(i).ve().c());
        }
    }

    public List<com.byazt.jx.x> c() {
        return this.ve;
    }

    public List<c<com.byazt.jx.yp, Path>> tt() {
        return this.c;
    }

    public List<c<Integer, Integer>> ve() {
        return this.tt;
    }
}
