package com.byazt.rb;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 23, 34})
public class a {
    public List<ve> c;
    public List<c> tt;
    public com.byazt.xj.ve uj;
    public Context ve;

    public a(Context context, com.byazt.xj.ve veVar, List<ve> list) {
        this.uj = veVar;
        this.ve = context;
        this.c = list;
        uj();
    }

    private void uj() {
        this.tt = new ArrayList();
        List<ve> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            ve veVar = this.c.get(i);
            if (veVar != null) {
                this.tt.add(new c(this.ve, this.uj, veVar));
            }
        }
    }

    public void c() {
        List<c> list = this.tt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c cVar : this.tt) {
            if (cVar != null) {
                cVar.uj();
            }
        }
    }

    public void tt() {
        List<c> list = this.tt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c cVar : this.tt) {
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void ve() {
        List<c> list = this.tt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c cVar : this.tt) {
            if (cVar != null) {
                cVar.ve();
            }
        }
    }

    public void c(Canvas canvas) {
        List<c> list = this.tt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c cVar : this.tt) {
            if (cVar != null) {
                cVar.c(canvas);
            }
        }
    }

    public void tt(Canvas canvas) {
        List<c> list = this.tt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c cVar : this.tt) {
            if (cVar != null) {
                cVar.tt(canvas);
            }
        }
    }

    public void c(int i, int i2) {
        List<c> list = this.tt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c cVar : this.tt) {
            if (cVar != null) {
                cVar.c(i, i2);
            }
        }
    }

    public c c(String str) {
        List<c> list = this.tt;
        if (list != null && !list.isEmpty()) {
            for (c cVar : this.tt) {
                if (cVar != null && TextUtils.equals(cVar.n(), str)) {
                    return cVar;
                }
            }
        }
        return null;
    }
}
