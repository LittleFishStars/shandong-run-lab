package com.byazt.oj;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 54})
public class ve {
    public static volatile ve c;

    private ve() {
    }

    public static ve c() {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve();
                }
            }
        }
        return c;
    }

    public uj c(View view, com.byazt.aq.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(cVar.i())) {
            return new sl(view, cVar);
        }
        if ("translate".equals(cVar.i())) {
            return new z(view, cVar);
        }
        if ("ripple".equals(cVar.i())) {
            return new x(view, cVar);
        }
        if ("marquee".equals(cVar.i())) {
            return new sp(view, cVar);
        }
        if ("waggle".equals(cVar.i())) {
            return new m(view, cVar);
        }
        if ("shine".equals(cVar.i())) {
            return new t(view, cVar);
        }
        if ("swing".equals(cVar.i())) {
            return new yp(view, cVar);
        }
        if ("fade".equals(cVar.i())) {
            return new c(view, cVar);
        }
        if ("rubIn".equals(cVar.i())) {
            return new da(view, cVar);
        }
        if ("rotate".equals(cVar.i())) {
            return new i(view, cVar);
        }
        if ("cutIn".equals(cVar.i())) {
            return new a(view, cVar);
        }
        if ("stretch".equals(cVar.i())) {
            return new u(view, cVar);
        }
        if ("bounce".equals(cVar.i())) {
            return new n(view, cVar);
        }
        return null;
    }
}
