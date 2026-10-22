package com.zj.adlib;

import com.huachenjie.base.view.danmuku.model.painter.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class b77 extends a {
    @Override // com.huachenjie.base.view.danmuku.model.painter.a
    public void layout(y52 danMuView, t52 danMuChannel) {
        float fB = danMuView.b();
        if (danMuView.m() - fB <= (-danMuView.l())) {
            danMuView.t(false);
        } else {
            danMuView.A(danMuView.m() - fB);
        }
    }
}
