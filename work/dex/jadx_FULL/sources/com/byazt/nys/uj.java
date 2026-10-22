package com.byazt.nys;

import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 15})
public class uj extends Exception {
    public final int c;

    public uj(int i, String str) {
        super(str);
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    public uj(int i, String str, Throwable th) {
        super(str, th);
        this.c = i;
    }
}
