package com.byazt.kh;

import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_LIKE, 13})
public abstract class tt implements Runnable {
    public final String tt;

    public tt(String str, Object... objArr) {
        this.tt = ve.c(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.tt);
        try {
            ve();
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    public abstract void ve();
}
