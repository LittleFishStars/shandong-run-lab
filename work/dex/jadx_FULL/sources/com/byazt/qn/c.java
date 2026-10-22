package com.byazt.qn;

import android.content.Context;
import android.widget.ScrollView;
import com.huachenjie.common.constants.ErrorCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, ErrorCode.CHECK_START_RUN_ERROR.c, 20})
public class c extends com.byazt.xj.c<ScrollView> {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView c() {
        UGScrollView uGScrollView = new UGScrollView(this.tt);
        uGScrollView.c(this);
        return uGScrollView;
    }

    @Override // com.byazt.xj.c
    public com.byazt.xj.c.C0576c x() {
        return new com.byazt.dy.c.C0391c(this);
    }
}
